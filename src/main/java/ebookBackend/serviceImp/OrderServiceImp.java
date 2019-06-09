package ebookBackend.serviceImp;

import ebookBackend.dao.BooksMapper;
import ebookBackend.dao.ItemsMapper;
import ebookBackend.dao.OrderMapper;
import ebookBackend.entity.*;
import ebookBackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

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
        if (odl.size() > 0)
            return odl;
        return new ArrayList<Order>();
    }

    public Order getByOrderId(String orderId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderidEqualTo(orderId);
        List<Order> odl = orderMapper.selectByExample(orderExample);
        if (odl.size() > 0)
            return odl.get(0);
        return new Order();
    }

    @Transactional(rollbackOn=Exception.class)
    public Order makeOrder(OrderWithItems orderWithItems) throws Exception {
        orderWithItems.generateItemList();

        Order order = new Order();
        order.setUserid(orderWithItems.getUserid());
        order.setOrderid(orderWithItems.getOrderid());

        List<Items> items = orderWithItems.getItems();
        for (Items item : items) {
            BooksExample bookBasicExample = new BooksExample();
            BooksExample.Criteria criteria = bookBasicExample.createCriteria();
            criteria.andIdEqualTo(item.getBookid());
            Books book = bookMapper.selectByExample(bookBasicExample).get(0);
            item.setValue(book.getPrice());
            if (order.getTitle() != null)
                order.setTitle(order.getTitle() + "、" + book.getTitle());
            else
                order.setTitle(book.getTitle());
        }

        BigDecimal total = new BigDecimal("0");
        for (Items item : items) {
            total = total.add(item.getValue().multiply(new BigDecimal(item.getAmount())));
        }

        order.setTotal(total);
        order.setState(0);
        order.setDate(new BigDecimal(new Date().getTime()));
        order.setShow(1);

        orderMapper.insert(order);

        for (Items item : items) {
            itemsMapper.insert(item);

            BooksExample booksExample = new BooksExample();
            BooksExample.Criteria criteria = booksExample.createCriteria();
            criteria.andIdEqualTo(item.getBookid());

            Books book = bookMapper.selectByExample(booksExample).get(0);

            if (book.getStock() - item.getAmount() > 0) {
                System.out.println("sss1");
                book.setStock(book.getStock() - item.getAmount());
                bookMapper.updateByExampleSelective(book, booksExample);
            } else {
                System.out.println("sss");
                throw new Exception("no stock");
            }
        }

        return order;
    }

    public List<Order> getByUserId(String userId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUseridEqualTo(userId).andShowEqualTo(1);
        return orderMapper.selectByExample(orderExample);
    }

    public List<Order> getByUserAndDate(String userId, String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date d2 = null;
        Date d1 = null;
        try {
            d1 = sdf.parse(date1);
            d2 = sdf.parse(date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUseridEqualTo(userId).andDateBetween(new BigDecimal(d1.getTime()), new BigDecimal(d2.getTime())).andShowEqualTo(1);
        return orderMapper.selectByExample(orderExample);
    }

    public List<Order> getByDate(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date d2 = null;
        Date d1 = null;
        try {
            d1 = sdf.parse(date1);
            d2 = sdf.parse(date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andDateBetween(new BigDecimal(d1.getTime()), new BigDecimal(d2.getTime()));
        return orderMapper.selectByExample(orderExample);
    }

    public List<Items> getItems(String orderId) {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andOrderidEqualTo(orderId);
        return itemsMapper.selectByExample(itemsExample);
    }

    public void deleteOrder(String orderId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderidEqualTo(orderId);

        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria1 = itemsExample.createCriteria();
        criteria1.andOrderidEqualTo(orderId);

        itemsMapper.deleteByExample(itemsExample);
        orderMapper.deleteByExample(orderExample);
    }

    public void unShowOrder(String orderId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderidEqualTo(orderId);
        Order order = new Order();
        order.setShow(0);
        orderMapper.updateByExampleSelective(order, orderExample);
    }

    public void payOrder(String orderId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderidEqualTo(orderId);
        Order order = new Order();
        order.setState(1);
        orderMapper.updateByExampleSelective(order, orderExample);
    }

    public void commentedOrder(String orderId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderidEqualTo(orderId);
        Order order = new Order();
        order.setState(2);
        orderMapper.updateByExampleSelective(order, orderExample);
    }
}
