package ebookBackend.serviceImp;

import ebookBackend.dao.CartItemsMapper;
import ebookBackend.entity.CartItems;
import ebookBackend.entity.CartItemsExample;
import ebookBackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImp implements CartService {
    @Autowired
    CartItemsMapper cartItemsMapper;

    public List<CartItems> getCartItemsByUid(String uid) {
        CartItemsExample cartItemsExample = new CartItemsExample();
        CartItemsExample.Criteria criteria = cartItemsExample.createCriteria();
        criteria.andUidEqualTo(uid);
//        System.out.println(id);
        List<CartItems> bdl = cartItemsMapper.selectByExample(cartItemsExample);
        return bdl;
    }

    public CartItems getCartItemsByUidAndBid(String uid, String bid) {
        CartItemsExample cartItemsExample = new CartItemsExample();
        CartItemsExample.Criteria criteria = cartItemsExample.createCriteria();
        criteria.andUidEqualTo(uid).andBidEqualTo(bid);
//        System.out.println(id);
        List<CartItems> bdl = cartItemsMapper.selectByExample(cartItemsExample);
        if (bdl.size() > 0)
            return bdl.get(0);
        else return null;
    }

    public void updateCartItemsByUid(String uid, String bid, int amount) {
        CartItemsExample cartItemsExample = new CartItemsExample();
        CartItemsExample.Criteria criteria = cartItemsExample.createCriteria();
        criteria.andUidEqualTo(uid).andBidEqualTo(bid);
        CartItems cartItem = new CartItems();
        cartItem.setAmount(amount);
        cartItemsMapper.updateByExampleSelective(cartItem, cartItemsExample);
    }

    public void updateCartItemsByCartItems(CartItems cartItem) {
        CartItemsExample cartItemsExample = new CartItemsExample();
        CartItemsExample.Criteria criteria = cartItemsExample.createCriteria();
        criteria.andUidEqualTo(cartItem.getUid()).andBidEqualTo(cartItem.getBid());
        cartItemsMapper.updateByExampleSelective(cartItem, cartItemsExample);
    }

    public void insertCartItems(CartItems cartItem) {
        cartItemsMapper.insert(cartItem);
    }

    public void cleanCartItemsByUid(String uid) {
        CartItemsExample cartItemsExample = new CartItemsExample();
        CartItemsExample.Criteria criteria = cartItemsExample.createCriteria();
        criteria.andUidEqualTo(uid);
        cartItemsMapper.deleteByExample(cartItemsExample);
    }

    public void deleteCartItemsByUidAndBid(String uid, String bid) {
        CartItemsExample cartItemsExample = new CartItemsExample();
        CartItemsExample.Criteria criteria = cartItemsExample.createCriteria();
        criteria.andUidEqualTo(uid).andBidEqualTo(bid);
        cartItemsMapper.deleteByExample(cartItemsExample);
    }
}
