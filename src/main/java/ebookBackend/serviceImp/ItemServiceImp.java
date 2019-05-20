package ebookBackend.serviceImp;

import ebookBackend.dao.ItemsMapper;
import ebookBackend.entity.Items;
import ebookBackend.entity.ItemsExample;
import ebookBackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class ItemServiceImp implements ItemService {
    @Autowired
    ItemsMapper itemsMapper;

    public List<Items> getByOrderId(String id) {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andOrderidEqualTo(id);
        List<Items> bdl = itemsMapper.selectByExample(itemsExample);
        if (bdl.size()>0)
            return bdl;
        return null;
    }

    public void insert(Items item){
        itemsMapper.insert(item);
    }

//    public List<Items> listAll() {
//        ItemsExample itemsExample = new ItemsExample();
//        ItemsExample.Criteria criteria = itemsExample.createCriteria();
//        List<Items> bdl = itemsMapper.selectByExample(itemsExample);
//        if (bdl.size()>0)
//            return bdl;
//        else
//            return null;
////        return bookBasicMapper.listAll();
//    }
}
