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

    @ResponseBody
    @RequestMapping("/getByDate")
    public List<Order> listByMonthD(@RequestParam String date1, @RequestParam String date2) {
        return orderService.getByDate(date1, date2);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertOrder(@RequestBody OrderWithItems order) {
        try {
            orderService.makeOrder(order);
            return "success";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "no stock!";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteOrder(@RequestParam String Oid) {
        Order order = orderService.getByOrderId(Oid);
        if (order == null) return "no such order";
        orderService.deleteOrder(Oid);
        return "success";
    }

    @RequestMapping(value = "/un_show", method = RequestMethod.GET)
    public String unShowOrder(@RequestParam String Oid) {
        Order order = orderService.getByOrderId(Oid);
        if (order == null) return "no such order";
        orderService.unShowOrder(Oid);
        return "success";
    }

    @RequestMapping(value = "/pay_success", method = RequestMethod.GET)
    public String orderPaid(@RequestParam String Oid) {
        Order order = orderService.getByOrderId(Oid);
        if (order == null) return "no such order";
        orderService.payOrder(Oid);
        return "success";
    }

    @RequestMapping(value = "/comment_success", method = RequestMethod.GET)
    public String orderCommented(@RequestParam String Oid) {
        Order order = orderService.getByOrderId(Oid);
        if (order == null) return "no such order";
        orderService.commentedOrder(Oid);
        return "success";
    }

    @RequestMapping(value = "/getItems", method = RequestMethod.GET)
    public List<Items> insertOrder(@RequestParam String Oid) {
        return orderService.getItems(Oid);
    }

}