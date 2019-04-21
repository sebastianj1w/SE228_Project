package ebookBackend.service;

import ebookBackend.dao.BooksMapper;
import ebookBackend.dao.ItemsMapper;
import ebookBackend.dao.OrderMapper;
import ebookBackend.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ItemsMapper itemsMapper;
    @Autowired
    BooksMapper bookMapper;

    public List<Order> getAll() {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        List<Order> odl = orderMapper.selectByExample(orderExample);
        if (odl.size()>0)
            return odl;
        return new ArrayList<Order>();
    }

    public Order getByOrderId(String orderId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderidEqualTo(orderId);
        List<Order> odl = orderMapper.selectByExample(orderExample);
        if (odl.size()>0)
            return odl.get(0);
        return new Order();
    }

    public Order makeOrder(OrderWithItems orderWithItems) {
        orderWithItems.generateItemList();

        Order order = new Order();
        order.setUserid(orderWithItems.getUserid());
        order.setOrderid(orderWithItems.getOrderid());

        List<Items> items = orderWithItems.getItems();
        for (Items item: items){
            BooksExample bookBasicExample = new BooksExample();
            BooksExample.Criteria criteria = bookBasicExample.createCriteria();
            criteria.andIdEqualTo(item.getBookid());
            Books book = bookMapper.selectByExample(bookBasicExample).get(0);
            item.setValue(book.getPrice());
            order.setTitle(order.getTitle()+"、"+book.getTitle());
        }

        BigDecimal total = new BigDecimal("0");
        for (Items item: items){
            total = total.add(item.getValue().multiply(new BigDecimal(item.getAmount())));
        }

        order.setTotal(total);
        order.setState(0);
        order.setDate(new BigDecimal(new Date().getTime()));

        orderMapper.insert(order);

        for (Items item: items){
            itemsMapper.insert(item);

            BooksExample booksExample = new BooksExample();
            BooksExample.Criteria criteria = booksExample.createCriteria();
            criteria.andIdEqualTo(item.getBookid());
            Books book = bookMapper.selectByExample(booksExample).get(0);
            book.setStock(book.getStock()-item.getAmount());
            bookMapper.updateByExampleSelective(book, booksExample);
        }

        return order;
    }

    public List<Order> getByUserId(String userId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUseridEqualTo(userId);
        return orderMapper.selectByExample(orderExample);
    }

    public List<Order> getByUserAndDate(String userId, String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date d2  = null;
        Date d1 = null;
        try {
            d1  = sdf.parse(date1);
            d2  = sdf.parse(date2);
        }catch (Exception e){
            e.printStackTrace();
        }
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUseridEqualTo(userId).andDateBetween(new BigDecimal(d1.getTime()),new BigDecimal(d2.getTime()));
        return orderMapper.selectByExample(orderExample);
    }

    public List<Items> getItems(String orderId) {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andOrderidEqualTo(orderId);
        return itemsMapper.selectByExample(itemsExample);
    }
}
