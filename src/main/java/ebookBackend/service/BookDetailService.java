package ebookBackend.service;

import ebookBackend.dao.BookDetailMapper;
import ebookBackend.entity.BookDetail;
import ebookBackend.entity.BookDetailExample;
//import ebookBackend.entity.BookDetailWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookDetailService {

    @Autowired
    BookDetailMapper bookDetailMapper;

    public BookDetail get(String id) {
        BookDetailExample bookDetailExample = new BookDetailExample();
        BookDetailExample.Criteria criteria = bookDetailExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<BookDetail> bdl = bookDetailMapper.selectByExample(bookDetailExample);
        if (bdl.size()>0)
            return bdl.get(0);
        return new BookDetail();
    }

//    public int insert(BookDetail book) {
//        return bookDetailMapper.insert(book);
//    }
//
//    public int update(BookDetail book) {
//        return bookDetailMapper.update(book);
//    }
//
//    public int delete(String id) {
//        return bookDetailMapper.delete(id);
//    }

}
