package ebookBackend.service;

import ebookBackend.entity.CartItems;

import java.util.List;

public interface CartService {
    List<CartItems> getCartItemsByUid(String uid);
    CartItems getCartItemsByUidAndBid(String uid, String bid);
    void updateCartItemsByUid(String uid, String bid, int amount);
    void updateCartItemsByCartItems(CartItems cartItem);
    void insertCartItems(CartItems cartItem);
    void cleanCartItemsByUid(String uid);
    void deleteCartItemsByUidAndBid(String uid, String bid);
}
