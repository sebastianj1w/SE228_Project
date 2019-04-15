package ebookBackend.service;

import ebookBackend.dao.TBookBasicMapper;
import ebookBackend.entity.BookBasic;
import ebookBackend.entity.BookBasicExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookBasicService {

    @Autowired
    TBookBasicMapper bookBasicMapper;

    public BookBasic get(String id) {
        BookBasicExample bookBasicExample = new BookBasicExample();
        BookBasicExample.Criteria criteria = bookBasicExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<BookBasic> bdl = bookBasicMapper.selectByExample(bookBasicExample);
        if (bdl.size()>0)
            return bdl.get(0);
        return new BookBasic();
    }

    public List<BookBasic> listAll() {
        BookBasicExample bookBasicExample = new BookBasicExample();
        BookBasicExample.Criteria criteria = bookBasicExample.createCriteria();
        List<BookBasic> bdl = bookBasicMapper.selectByExample(bookBasicExample);
        if (bdl.size()>0)
            return bdl;
        else
            return null;
//        return bookBasicMapper.listAll();
    }
//
//    public int insert(BookBasic book) {
//        return bookBasicMapper.insert(book);
//    }
//
//    public int update(BookBasic book) {
//        return bookBasicMapper.update(book);
//    }
//
//    public int delete(int id) {
//        return bookBasicMapper.delete(id);
//    }

}