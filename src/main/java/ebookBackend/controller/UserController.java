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
        User user = userService.get(id);
        user.setPassword(null);
        return user;
    }

    @ResponseBody
    @RequestMapping("/conflict")
    public String conflict(@RequestParam String id) {
        User user = userService.get(id);
        if (user.getId()!=null)
            if (user.getId().equals(id))
                return "conflict";
        return "no-conflict";
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<User> list() {
        return userService.getall();
    }

    @ResponseBody
    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public int insertUser(@RequestBody User user) {
        user.setIden("user");
        user.setCart("");
        return userService.insertUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/ban", method = RequestMethod.GET)
    public String banUser(@RequestParam String id, @RequestParam int op) {
        userService.banUser(id, op);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/addcart", method = RequestMethod.GET)
    public String addCart(@RequestParam String Uid, @RequestParam String Bid) {
        User user =  userService.get(Uid);
        user.setCart(user.getCart()+Bid+";");
        userService.update(user);
        return user.getCart();
    }

    @ResponseBody
    @RequestMapping(value = "/getcart", method = RequestMethod.GET)
    public String getCart(@RequestParam String Uid) {
        User user =  userService.get(Uid);
        return user.getCart();
    }

    @ResponseBody
    @RequestMapping(value = "/cleancart", method = RequestMethod.GET)
    public String cleanCart(@RequestParam String Uid) {
        User user =  userService.get(Uid);
        user.setCart("");
        userService.update(user);
        return user.getCart();
    }


}