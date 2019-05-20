package ebookBackend.service;

import ebookBackend.entity.Books;

import java.util.List;

public interface BookService {
    Books get(String id);
    List<Books> listAll();
    int insert(Books book);
    int update(Books book);
    int delete(String id);
}
