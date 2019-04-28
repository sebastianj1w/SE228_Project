package ebookBackend.controller;

//import ebookBackend.entity.User;

import ebookBackend.entity.Items;
import ebookBackend.entity.Order;
import ebookBackend.entity.OrderWithItems;
import ebookBackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
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

    @ResponseBody
    @RequestMapping("/getAll")
    public List<Order> listAll() {
        return orderService.getAll();
    }

    @ResponseBody
    @RequestMapping("/getByUser")
    public List<Order> list(@RequestParam String Uid) {
        return orderService.getByUserId(Uid);
    }

    @ResponseBody
    @RequestMapping("/getByUserAndDate")
    public List<Order> listByMonth(
            @RequestParam String Uid, @RequestParam String date1, @RequestParam String date2) {
        return orderService.getByUserAndDate(Uid, date1, date2);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Order insertOrder(@RequestBody OrderWithItems order) {
//        order.generateItemList();
        return orderService.makeOrder(order);
    }

    @RequestMapping(value = "/getItems", method = RequestMethod.GET)
    public List<Items> insertOrder(@RequestParam String Oid) {
//        order.generateItemList();
        return orderService.getItems(Oid);
    }

}