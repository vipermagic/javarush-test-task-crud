package net.vipermagi.javarushcrud.controller;

import net.vipermagi.javarushcrud.model.Book;
import net.vipermagi.javarushcrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private BookService bookService;
    private static int id = 0;
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired(required = true)
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        if(book.getId() == 0) {
            this.bookService.addBook(book);
        } else {
            this.bookService.updateBook(book);
        }

        return "redirect:/";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id) {
        this.bookService.removeBook(id);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        logger.debug("BookController", "editBook");
        BookController.id = this.bookService.getBookById(id).getId();
//        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "redirect:/";
    }

    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));

        return "redirect:/";
    }

    @RequestMapping(value = "/")
    public ModelAndView listOfBooks(@RequestParam(required = false) Integer page, @RequestParam(required = false) String bookTitle) {
        ModelAndView modelAndView = new ModelAndView("index");

        if(id != 0) {
            modelAndView.addObject("book", this.bookService.getBookById(id));
            id = 0;
        } else {
            modelAndView.addObject("book", new Book());
        }

        List<Book> books = null;
        if(bookTitle == null) {
            books = this.bookService.listBooks();
        } else {
            List<Book> tempBooks = this.bookService.listBooks();
            books = new ArrayList<Book>();
            for(Book tempBook : tempBooks) {
                if(tempBook.getTitle().toLowerCase().contains(bookTitle.toLowerCase())) {
                    System.out.println("filter: " + tempBook);
                    books.add(tempBook);
                }
            }
        }

        PagedListHolder<Book> pagedListHolder = new PagedListHolder<Book>(books);
        pagedListHolder.setPageSize(10);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if(page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            page = 1;
        }

        modelAndView.addObject("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(0);
            modelAndView.addObject("listBooks", pagedListHolder.getPageList());
        } else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page - 1);
            modelAndView.addObject("listBooks", pagedListHolder.getPageList());
        }

        return modelAndView;
    }
}
