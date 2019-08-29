package com.yye.springbootthymeleaf.service.impl;

import com.yye.springbootthymeleaf.model.Book;
import com.yye.springbootthymeleaf.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Book 业务层实现
 *
 */
@Service
public class BookServiceImpl implements BookService {

    private static Map<Long, Book> BOOK_DB = new HashMap<>();

    @Override
    public List<Book> findAll()
    {
        List<Book> list = new ArrayList<>();
        Book book = new Book();
        book.setId(1L);
        book.setIntroduction("好看");
        book.setWriter("安托万·德·圣·埃克苏佩");
        book.setName("小王子");
        list.add(book);
        return list;
    }

    @Override
    public Book insertByBook(Book book) {
        book.setId(BOOK_DB.size() + 1L);
        BOOK_DB.put(book.getId(), book);
        return book;
    }

    @Override
    public Book update(Book book) {
        BOOK_DB.put(book.getId(), book);
        return book;
    }

    @Override
    public Book delete(Long id) {
        return BOOK_DB.remove(id);
    }

    @Override
    public Book findById(Long id) {
        return BOOK_DB.get(id);
    }
}
