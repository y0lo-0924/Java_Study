package com.y0lo.controller;

import com.y0lo.pojo.Books;
import com.y0lo.service.BookService;
import com.y0lo.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    //controller 调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService = new BookServiceImpl();

    //查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    //跳转到添加书籍页面
    @RequestMapping("toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.addBook(books);
        //重定向可以防止用户重复提交表单 https://blog.csdn.net/qq_41649001/article/details/107491939
        return "redirect:/book/allBook";    //重定向到我们的     @RequestMapping("allBook")
    }

    //跳转到修改页面
    @RequestMapping("toUpdate")
    public String toUpdatePaper(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBook",books);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){
        System.out.println("deleteBook=>"+id);
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        List<Books> list = bookService.queryBookName(queryBookName);
        model.addAttribute("list",list);
        return "allBook";
    }
}
