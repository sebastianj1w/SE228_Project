package ebookBackend.controller;

//import ebookBackend.entity.User;
import ebookBackend.entity.User;
import ebookBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @ResponseBody
    @RequestMapping("/detail")
    public User detail(String  id) {
        User user = new User();
        user.setId(id);
        user.setIden("user");
        user.setMail("china");
        return user;
    }

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/list")
    public List<User> list() {
//        List<User> list = userService.listAllUser();
//        System.out.println("size:" + list.size());
//        return list;
        return null;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertUser(String identity, String mail) {
//        User user = new User();
//        user.setIdentity(identity);
//        user.setMail(mail);

//        int result = userService.insertUser(user);
//        if (result > 0) {
//            return "{\"returncode\":0,\"message\":\"success\"}";
//        } else {
//            return "{\"returncode\":0,\"message\":\"error\"}";
//        }
        return "";
    }


}