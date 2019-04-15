package ebookBackend.controller;

import ebookBackend.entity.Book;
import ebookBackend.entity.BookBasic;
import ebookBackend.service.BookBasicService;
import ebookBackend.service.BookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/getBook")
public class BookController {

    @Autowired
    BookBasicService bookBasicService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<BookBasic> getList() {
        List<BookBasic> list = bookBasicService.listAll();
        return list;
    }

    @Autowired
    BookDetailService bookDetailService;

    @RequestMapping(path = "/information", method = RequestMethod.GET)
    @ResponseBody
    public Book information(@RequestParam String ID) {
        Book book = new Book(bookBasicService.get(ID),bookDetailService.get(ID));
        return book;
    }
}
