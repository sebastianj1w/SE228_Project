package ebookBackend.service;

import ebookBackend.dao.ItemsMapper;
import ebookBackend.dao.OrderMapper;
import ebookBackend.entity.Items;
import ebookBackend.entity.ItemsExample;
import ebookBackend.entity.Order;
import ebookBackend.entity.OrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public Order getByOrderId(int orderId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderidEqualTo(orderId);
        List<Order> odl = orderMapper.selectByExample(orderExample);
        if (odl.size()>0)
            return odl.get(0);
        return new Order();
    }

    public Order makeOrder(String userId) {
        Order order = new Order();
        order.setUserid(userId);
//        order.setOrderid("111");
        order.setTotal(new BigDecimal("90.00"));
        orderMapper.insert(order);
        return order;
    }

    public List<Order> getByUserId(String userId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUseridEqualTo(userId);
        return orderMapper.selectByExample(orderExample);
    }

    @Autowired
    ItemsMapper itemsMapper;

    public List<Items> getItems(int orderId) {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andOrderidEqualTo(orderId);
        return itemsMapper.selectByExample(itemsExample);
    }
}
