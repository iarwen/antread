package com.antread.tools;

import static org.springframework.data.domain.ExampleMatcher.matching;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.antread.tools.ApplicationMain;
import com.antread.tools.system.dao.BooksRepository;
import com.antread.tools.system.domain.BookImage;
import com.antread.tools.system.domain.BookRating;
import com.antread.tools.system.domain.BooksInfo;
import com.antread.tools.system.service.IBooksService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationMain.class)
public class ApplicationTests {

	@Autowired
	private BooksRepository booksRepository;

	@Before
	public void setUp() {
		//booksRepository.deleteAll();
	}

	@Test
	public void test() throws Exception {
		BooksInfo info = new BooksInfo();
		info.setId(1066462L);
		info.setAuthor(new String[] { "幾米" });
		info.setBinding("平装");
		BookImage bi = new BookImage();
		bi.setLarge("https://img3.doubanio.com/lpic/s1557610.jpg");
		bi.setMedium("https://img3.doubanio.com/mpic/s1557610.jpg");
		bi.setSmall("https://img3.doubanio.com/spic/s1557610.jpg");
		info.setImages(bi);
		info.setIsbn10("710801744X");
		info.setIsbn13("9787108017444");
		info.setPages(132);
		info.setPrice("16.00元");
		info.setPubdate("2010-09");
		info.setPublisher("生活·读书·新知三联书店");
		BookRating br = new BookRating();
		br.setMax(10);
		br.setMin(0);
		br.setNumRaters(67328);
		br.setAverage("6.8");
		info.setRating(br);
		info.setSubtitle("");
		info.setTitle("向左走·向右走");
		info.setTranslator(new String[] {});
		booksRepository.save(info);


		BooksInfo u = booksRepository.findOne(1066462L);
		
		Assert.assertNotNull(u);
		//模糊查询
		BooksInfo bookinfo = new BooksInfo();
		bookinfo.setTitle("17444");
		bookinfo.setIsbn13("17444");
		Example<BooksInfo> example = Example.of(bookinfo,
				matching().withStringMatcher(StringMatcher.CONTAINING).//
						withIgnorePaths("id", "pages").// base type
						withIgnoreNullValues()); //default

		List<BooksInfo> list = booksRepository.findAll(example);
		System.out.println(list.size());
		 
		for(int i=0;i<100;i++){
			BooksInfo temp =new BooksInfo();
			BeanUtils.copyProperties(info, temp);
			temp.setTitle(temp.getTitle()+i);
			temp.setId(temp.getId()+i);
			booksRepository.save(temp);
		}
		
	}
	
	@Autowired
	private IBooksService booksService;
	
	@Test
	public void testService() throws Exception {
		Page<BooksInfo> page = booksService.findByTitleOrISBN("向左走", 1, 20);
		System.out.println(page.getNumberOfElements());
		page.getContent().forEach(new Consumer<BooksInfo>() {
			@Override
			public void accept(BooksInfo info) {
				System.out.println(info.getTitle());
			}
		});
	}
}