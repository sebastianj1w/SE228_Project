package ebookBackend.RESTfulService.dao;

import ebookBackend.RESTfulService.entity.Book;
import ebookBackend.RESTfulService.entity.BookBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
//    public List<BookBasic> listAll() {
//        List<BookBasic> list = jdbcTemplate.query("select * from t_booklist", new RowMapper() {
//            public Object mapRow(ResultSet rs, int no) throws SQLException {
//                BookBasic book = new BookBasic();
//                book.setTitle(rs.getString(1));
//                book.setAuthor(rs.getString(2));
//                book.setPublisher(rs.getString(3));
//                book.setPrice(rs.getFloat(4));
//                book.setID(rs.getString(5));
//                book.setStock(rs.getInt(6));
//                book.setISBN(rs.getString(7));
//                return book;
//            }
//        });
//        return list;
//    }

    public int insert(final Book book) {
        int result = jdbcTemplate.update("insert into t_booklist (title, author, publisher, price, ID, stock, ISBN) VALUES (?,?,?,?,?,?,?)", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, book.getID());
                ps.setFloat(2, book.getRate());
                ps.setString(3, book.getPublishDate());
                ps.setFloat(4, book.getWords());
                ps.setString(5, book.getAbstraction());
                ps.setString(6, book.getCatalogue());
            }
        });

        return result;
    }

    public int update(final Book book) {
        int result = jdbcTemplate.update("UPDATE t_item set rate=?,publishDate=?,words=?,abstraction=?,catalogue=? where id=?", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, book.getID());
                ps.setFloat(2, book.getRate());
                ps.setString(3, book.getPublishDate());
                ps.setFloat(4, book.getWords());
                ps.setString(5, book.getAbstraction());
                ps.setString(6, book.getCatalogue());
            }
        });

        return result;
    }

    public int delete(int id) {
        int result = jdbcTemplate.update("delete from t_booklist where id=?", new Object[]{id}, new int[]{Types.INTEGER});
        return result;
    }
}
