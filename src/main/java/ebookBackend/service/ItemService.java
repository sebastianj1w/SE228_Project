package ebookBackend.service;

import ebookBackend.entity.Items;

import java.util.List;

public interface ItemService {
    List<Items> getByOrderId(String id);
    void insert(Items item);
}
