package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.BookMapper;
import com.zking.ssm.mapper.MyFileMapper;
import com.zking.ssm.model.Book;
import com.zking.ssm.model.MyFile;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class IBookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private MyFileMapper myFileMapper;

    @Override
    public int deleteByPrimaryKey(Integer bookId) {
        return 0;
    }

    @Override
    public int insert(Book record) {
        return bookMapper.insert(record);
    }

    @Override
    public int insertSelective(Book record) {
        return 0;
    }

    @Override
    public Book selectByPrimaryKey(Integer bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return 0;
    }

    @Override
    public List<Book> listBookByPager(PageBean pageBean) {
        return bookMapper.listBookByPager();
    }

    @Transactional
    @Override
    public int updImg(Book book, MyFile myFile) {
        //新增文件长传记录
        myFileMapper.insert(myFile);
        //修改书本表img
        bookMapper.updImg(book);

        return 1;
    }

    @Override
    public List<Map> listListMap() {
        return bookMapper.listListMap();
    }

    @Override
    public Map listMap(Integer bookId) {
        return bookMapper.listMap(bookId);
    }

    @Override
    public Book listSingerBook(Integer bookId) {
        return bookMapper.listSingerBook(bookId);
    }
}
