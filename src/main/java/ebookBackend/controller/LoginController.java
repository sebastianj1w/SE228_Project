package ebookBackend.controller;

import ebookBackend.entity.User;
import ebookBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody User user) {
        String password = user.getPassword();
        String id = user.getId();
        User userE = userService.get(id);
        if (password.equals(userE.getPassword())) {
            if (userE.getBan()) return "banned";
            return "successful";
        } else {
            return "failed";
        }
    }

    @RequestMapping(path = "/information", method = RequestMethod.GET)
    @ResponseBody
    public User information() {
        return new User();
    }

}