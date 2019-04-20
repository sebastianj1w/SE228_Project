package ebookBackend.service;

import ebookBackend.dao.BooksMapper;
import ebookBackend.dao.ItemsMapper;
import ebookBackend.dao.OrderMapper;
import ebookBackend.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ItemsMapper itemsMapper;
    @Autowired
    BooksMapper bookMapper;

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

            item.setValue(bookMapper.selectByExample(bookBasicExample).get(0).getPrice());
        }

        BigDecimal total = new BigDecimal("0");
        for (Items item: items){
            total = total.add(item.getValue().multiply(new BigDecimal(item.getAmount())));
        }

        order.setTotal(total);
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
//
//    @Autowired
//    ItemsMapper itemsMapper;

    public List<Items> getItems(String orderId) {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andOrderidEqualTo(orderId);
        return itemsMapper.selectByExample(itemsExample);
    }
}
