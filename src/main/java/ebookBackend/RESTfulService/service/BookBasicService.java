package ebookBackend.RESTfulService.service;

import ebookBackend.RESTfulService.dao.BookBasicDao;
import ebookBackend.RESTfulService.entity.BookBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    @Autowired
    BookBasicDao bookBasicDao;

    public List<BookBasic> listAll() {
        return bookBasicDao.listAll();
    }

    public int insert(BookBasic book) {
        return bookBasicDao.insert(book);
    }

    public int update(BookBasic book) {
        return bookBasicDao.update(book);
    }

    public int delete(int id) {
        return bookBasicDao.delete(id);
    }

}