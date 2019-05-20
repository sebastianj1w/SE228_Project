package ebookBackend.serviceImp;

import ebookBackend.dao.UserMapper;
import ebookBackend.entity.User;
import ebookBackend.entity.UserExample;
import ebookBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImp implements UserService {

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
        if (bdl.size() > 0)
            return bdl.get(0);
        return new User();
    }

    public List<User> getall() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        List<User> bdl = userMapper.selectByExample(userExample);
        for (User user:bdl) {
            user.setPassword("");
        }
        if (bdl.size() > 0)
            return bdl;
        return new ArrayList<>();
    }

    public int banUser(String id, int op) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);
        User user = new User();
        user.setBan(op == 1);
        userMapper.updateByExampleSelective(user, userExample);
        return 0;
    }

    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    public int update(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(user.getId());
        return userMapper.updateByExampleSelective(user, userExample);
    }

//    public int deleteUser(int id) {
////        return userMapper.deleteUser(id);
//    }

}