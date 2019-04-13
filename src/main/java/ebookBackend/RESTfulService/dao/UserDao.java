package ebookBackend.RESTfulService.dao;

import ebookBackend.RESTfulService.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;


@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
    public List<User> listAllUser() {
        List<User> list = jdbcTemplate.query("select * from t_userinfo", new RowMapper() {
            public Object mapRow(ResultSet rs, int no) throws SQLException {
                User user = new User();
                user.setId(rs.getString(1));
                user.setIdentity(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setBan(rs.getBoolean(4));
                user.setMail(rs.getString(5));
                return user;
            }
        });
        return list;
    }

    public int insertUser(final User user) {
        int result = jdbcTemplate.update("insert into t_userinfo (id, iden, password, ban, mail) VALUES (?,?,?,?,?)", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, user.getId());
                ps.setString(2, user.getIdentity());
                ps.setString(3, user.getPassword());
                ps.setBoolean(4, user.getBan());
                ps.setString(5, user.getMail());
            }
        });

        return result;
    }

    public int updateUser(final User user) {
        int result = jdbcTemplate.update("UPDATE t_userinfo set iden=?,password=?,ban=?,mail=? where id=?", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(2, user.getIdentity());
                ps.setString(3, user.getPassword());

                ps.setString(1, user.getId());
                ps.setBoolean(4, user.getBan());
                ps.setString(5, user.getMail());
            }
        });

        return result;
    }

    public int deleteUser(int id) {
        int result = jdbcTemplate.update("delete from t_userinfo where id=?", new Object[]{id}, new int[]{Types.INTEGER});
        return result;
    }
}