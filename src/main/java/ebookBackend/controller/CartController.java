package ebookBackend.controller;

import ebookBackend.entity.CartItems;
import ebookBackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCart(@RequestParam String Uid, @RequestParam String Bid) {
        CartItems cartItem = cartService.getCartItemsByUidAndBid(Uid, Bid);
        if (cartItem != null) {
            cartItem.setAmount(cartItem.getAmount()+1);
            cartService.updateCartItemsByCartItems(cartItem);
        }
        else {
            cartItem = new CartItems();
            cartItem.setAmount(1);
            cartItem.setBid(Bid);
            cartItem.setUid(Uid);
            cartService.insertCartItems(cartItem);
        }
        return "no imp";
    }

    @ResponseBody
    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public String setCart(@RequestParam String Uid, @RequestParam String Bid, @RequestParam int amount) {
//        System.out.println(Uid);
//        System.out.println(Bid);
//        System.out.println(amount);
        CartItems cartItem = cartService.getCartItemsByUidAndBid(Uid, Bid);
        if (cartItem != null) {
            cartItem.setAmount(amount);
            cartService.updateCartItemsByCartItems(cartItem);
        }
        else {
            cartItem = new CartItems();
            cartItem.setAmount(amount);
            cartItem.setBid(Bid);
            cartItem.setUid(Uid);
            cartService.insertCartItems(cartItem);
        }
        return "set";
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<CartItems> getCart(@RequestParam String Uid) {
        return cartService.getCartItemsByUid(Uid);
    }

    @ResponseBody
    @RequestMapping(value = "/clean", method = RequestMethod.GET)
    public String cleanCart(@RequestParam String Uid) {
        cartService.cleanCartItemsByUid(Uid);
        return "";
    }
}
