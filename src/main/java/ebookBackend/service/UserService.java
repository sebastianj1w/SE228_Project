package ebookBackend.service;

import ebookBackend.dao.UserMapper;
import ebookBackend.entity.User;
import ebookBackend.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

//    public List<User> listAllUser() {
//        return userInfoMapper.listAllUser();
//    }
//
    public User get(String id) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<User> bdl = userMapper.selectByExample(userExample);
        if (bdl.size()>0)
            return bdl.get(0);
        return new User();
    }
//
//    public int insertUser(User user) {
//        return userDao.insertUser(user);
//    }
//
//    public int updateUser(User user) {
//        return userDao.updateUser(user);
//    }
//
//    public int deleteUser(int id) {
//        return userDao.deleteUser(id);
//    }

}