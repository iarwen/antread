package org.antread.tools;

import java.util.List;

import org.antread.tools.system.dao.BooksRepository;
import org.antread.tools.system.domain.BookImage;
import org.antread.tools.system.domain.BookRating;
import org.antread.tools.system.domain.BooksInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest( classes = ApplicationMain.class)
public class ApplicationTests {

    @Autowired
    private BooksRepository booksRepository;

    @Before
    public void setUp() {
    	booksRepository.deleteAll();
    }

    @Test
    public   void test() throws Exception {
    	BooksInfo info  = new BooksInfo();
    	info.setId(1066462L);
    	info.setAuthor(new String[]{"幾米"});
    	info.setBinding("平装");
    	BookImage bi =new BookImage();
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
    	info.setTranslator(new String[]{});
    	booksRepository.save(info);
        Assert.assertEquals(1, booksRepository.findAll().size());

        BooksInfo u = booksRepository.findOne(1066462L);

        // 获取一个Book，再验证Book总数
        List<BooksInfo> books = booksRepository.findByTitle(u.getTitle());
        
        Assert.assertEquals(1, books.size());
      
        ExampleMatcher matcher = ExampleMatcher.matching().
                withMatcher("title", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING).ignoreCase());
        BooksInfo bookinfo = new BooksInfo();
        bookinfo.setTitle("左");
        Example<BooksInfo> exam =  Example.of( bookinfo,  matcher );
        List<BooksInfo> list = booksRepository.findAll(exam);
        System.out.println(list.size());
        //booksRepository.delete(u);
        //Assert.assertEquals(0, booksRepository.findAll().size());

    }

}