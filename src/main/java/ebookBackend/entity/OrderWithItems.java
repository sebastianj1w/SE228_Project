package ebookBackend.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderWithItems {
    private BigDecimal total;
    private String userid;
    private String orderid;
    private String itemStr;
    private List<Items> items;

    public OrderWithItems() {
        this.orderid = UUID.randomUUID().toString().replaceAll("-","");
        this.total = new BigDecimal("0");
        this.items = new ArrayList<>();
    }

    public void generateItemList() {


        String[] itemStrs = itemStr.split(";");
//        String exampleStr = "book_id:amount;book_id:amount";
        int size = itemStrs.length;
        String[] tmp;
        for (int i=0;i<size;i++){
            tmp = itemStrs[i].split(":");

            Items tmpItem = new Items();

            tmpItem.setAmount(Integer.parseInt(tmp[1]));
            tmpItem.setBookid(tmp[0]);
            tmpItem.setOrderid(this.orderid);
//            System.out.println(tmpItem.getBookid());
//            System.out.println(tmpItem.getOrderid());
//            System.out.println(bookBasicService.get(tmp[0]).getPrice());
//
//            tmpItem.setValue(bookBasicService.get(tmp[0]).getPrice());

            items.add(tmpItem);

//            itemService.insert(tmpItem);

//            this.total = this.total.add(tmpItem.getValue().multiply(tmpItem.getValue()));
        }
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getItemStr() {
        return itemStr;
    }

    public void setItemStr(String itemStr) {
        this.itemStr = itemStr;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
