package ebookBackend.service;

import ebookBackend.dao.BooksMapper;
import ebookBackend.entity.Books;
import ebookBackend.entity.BooksExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    BooksMapper booksMapper;

    public Books get(String id) {
        BooksExample bookBasicExample = new BooksExample();
        BooksExample.Criteria criteria = bookBasicExample.createCriteria();
        criteria.andIdEqualTo(id);
//        System.out.println(id);
        List<Books> bdl = booksMapper.selectByExample(bookBasicExample);
        if (bdl.size()>0)
            return bdl.get(0);
        return new Books();
    }

    public List<Books> listAll() {
        BooksExample bookBasicExample = new BooksExample();
        BooksExample.Criteria criteria = bookBasicExample.createCriteria();
        List<Books> bdl = booksMapper.selectByExample(bookBasicExample);
        if (bdl.size()>0)
            return bdl;
        else
            return null;
//        return bookBasicMapper.listAll();
    }
//
    public int insert(Books book) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        book.setId(uuid);
        return booksMapper.insert(book);
    }
//
    public int update(Books book) {
        if (book.getId() == null) return -1;
        BooksExample bookBasicExample = new BooksExample();
        BooksExample.Criteria criteria = bookBasicExample.createCriteria();
        criteria.andIdEqualTo(book.getId());
        return booksMapper.updateByExampleSelective(book, bookBasicExample);
    }
//
    public int delete(String id) {
        return booksMapper.deleteByPrimaryKey(id);
    }

}