package com.calcfab.controller;

import com.calcfab.controller.utils.Result;
import com.calcfab.domain.Book;
import com.calcfab.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author XuBowen
 * @date 2023/2/11 19:05
 */

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public Result getAll(){
        return new Result(true, bookService.list());
    }

    @PostMapping
    public Result save(@RequestBody Book book) throws IOException {
        if (book.getName().equals("123") ) throw new IOException();
        boolean flag = bookService.save(book);
        return new Result(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }
    @PutMapping
    public Result update(@RequestBody Book book) throws IOException {
        if (book.getName().equals("123") ) throw new IOException();
        boolean flag = bookService.updateById(book);
        return new Result(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }
    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        return new Result(bookService.removeById(id));
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id){
        return new Result(true, bookService.getById(id));
    }
}
