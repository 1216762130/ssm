package com.zking.ssm.service;

import com.zking.ssm.model.Book;
import com.zking.ssm.model.MyFile;
import com.zking.ssm.util.PageBean;

import java.util.List;
import java.util.Map;


public interface IBookService {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> listBookByPager(PageBean pageBean);

    int updImg(Book book, MyFile myFile);

    List<Map> listListMap();

    Map listMap(Integer bookId);

    Book listSingerBook(Integer bookId);
}