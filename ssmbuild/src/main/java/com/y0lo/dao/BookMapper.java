package com.y0lo.dao;

import com.y0lo.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;

public interface BookMapper {

    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookID") int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("bookID") int id);

    //查询全部的书
    List<Books> queryAllBook();

    //按name查询书籍
    List<Books> queryBookName(@Param("bookName") String name);
}
