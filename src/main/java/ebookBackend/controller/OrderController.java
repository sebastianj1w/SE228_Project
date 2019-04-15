package ebookBackend.controller;

//import ebookBackend.entity.User;

import ebookBackend.entity.Order;
import ebookBackend.entity.User;
import ebookBackend.service.OrderService;
import ebookBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {


//    @ResponseBody
//    @RequestMapping("/detail")
//    public User detail(String id) {
//        User user = new User();
//        user.setId(id);
//        user.setIden("user");
//        user.setMail("china");
//        return user;
//    }

    @Autowired
    OrderService orderService;

//    @ResponseBody
//    @RequestMapping("/list")
//    public List<User> list() {
////        List<User> list = userService.listAllUser();
////        System.out.println("size:" + list.size());
////        return list;
//        return null;
//    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Order insertOrder(@RequestBody Order order) {

        return  orderService.makeOrder(userID);
    }


}