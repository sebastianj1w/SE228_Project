package ebookBackend.controller;

//import ebookBackend.entity.Book;
import ebookBackend.entity.Books;
import ebookBackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Books> getList() {
        List<Books> list = bookService.listAll();
        return list;
    }

    @RequestMapping(path = "/information", method = RequestMethod.GET)
    @ResponseBody
    public Books information(@RequestParam String ID) {
        return bookService.get(ID);
    }

    @RequestMapping(path = "/title", method = RequestMethod.GET)
    @ResponseBody
    public String title(@RequestParam String ID) {
        return bookService.get(ID).getTitle();
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    @ResponseBody
    public int update(@RequestBody Books book) {
        System.out.println("1");
        System.out.println(book.getPicid());
        return bookService.update(book);
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    @ResponseBody
    public int newBook(@RequestBody Books book) {
        return bookService.insert(book);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public int deleteBook(@RequestParam String id) {
        return bookService.delete(id);
    }

    @RequestMapping(path = "/getprice", method = RequestMethod.GET)
    @ResponseBody
    public double price(@RequestParam String id) {
        return bookService.get(id).getPrice().doubleValue();
    }
}
