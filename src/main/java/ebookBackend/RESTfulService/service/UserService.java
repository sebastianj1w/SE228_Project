package ebookBackend.RESTfulService.service;

import ebookBackend.RESTfulService.dao.UserDao;
import ebookBackend.RESTfulService.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> listAllUser() {
        return userDao.listAllUser();
    }

    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

}