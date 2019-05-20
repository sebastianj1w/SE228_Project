package ebookBackend.service;

import ebookBackend.entity.Items;
import ebookBackend.entity.Order;
import ebookBackend.entity.OrderWithItems;

import java.util.List;

public interface OrderService  {
    List<Order> getAll();
    Order getByOrderId(String orderId);
    Order makeOrder(OrderWithItems orderWithItems) throws Exception ;
    List<Order> getByUserId(String userId);
    List<Order> getByUserAndDate(String userId, String date1, String date2);
    List<Order> getByDate(String date1, String date2);
    List<Items> getItems(String orderId);
    void deleteOrder(String orderId);
}
