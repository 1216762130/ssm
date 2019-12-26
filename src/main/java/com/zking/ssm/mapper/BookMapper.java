package com.zking.ssm.mapper;

import com.zking.ssm.model.Book;
import com.zking.ssm.model.MyFile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> listBookByPager();

    int updImg(Book book);

    List<Map> listListMap();

    Map listMap(Integer bookId);

    Book listSingerBook(Integer bookId);
}