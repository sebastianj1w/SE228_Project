package ebookBackend.service;

import ebookBackend.entity.User;

import java.util.List;

public interface UserService {
    User get(String id);
    List<User> getall();
    int banUser(String id, int op);
    int insertUser(User user);
    int update(User user);

}
