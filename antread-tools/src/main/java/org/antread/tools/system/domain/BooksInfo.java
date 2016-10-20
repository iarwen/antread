package org.antread.tools.system.domain;

import javax.persistence.Id;

public class BooksInfo   {
   
    @Id
    //豆瓣的ID
	private Long id;
	//标题
	private String title;
	//副标题
	private String subtitle;
	//图片
	private BookImage images;
	//作者
	private String[] author;
	//译者
	private String[] translator;
	//出版社
	private String publisher;
	//评分
	private BookRating rating;
	//出版日期
	private String pubdate;
	//装帧
	private String binding;
	//价格
	private String price;
	//页数
	private int pages;
	//书号
	private String isbn13;
	//书号2
	private String isbn10;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
 
	public String[] getAuthor() {
		return author;
	}
	public void setAuthor(String[] author) {
		this.author = author;
	}
	public String[] getTranslator() {
		return translator;
	}
	public void setTranslator(String[] translator) {
		this.translator = translator;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public BookRating getRating() {
		return rating;
	}
	
	public void setRating(BookRating rating) {
		this.rating = rating;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getBinding() {
		return binding;
	}
	public void setBinding(String binding) {
		this.binding = binding;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
 
	public BookImage getImages() {
		return images;
	}
	public void setImages(BookImage images) {
		this.images = images;
	}
	public String getIsbn10() {
		return isbn10;
	}
	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

}

