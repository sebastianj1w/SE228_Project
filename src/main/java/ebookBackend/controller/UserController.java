package ebookBackend.controller;

//import ebookBackend.entity.User;
import ebookBackend.entity.User;
import ebookBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/detail")
    public User detail(@RequestParam String id) {
        User user = new User();
        user.setId(id);
        user.setIden("user");
        user.setMail("china");
        return user;
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<User> list() {
//        List<User> list = userService.listAllUser();
//        System.out.println("size:" + list.size());
//        return list;
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public int insertUser(@RequestBody User user) {
        user.setIden("user");
        return userService.insertUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/ban", method = RequestMethod.GET)
    public String banUser(@RequestParam String id, @RequestParam int op) {
        userService.banUser(id, op);
        return "success";
    }


}