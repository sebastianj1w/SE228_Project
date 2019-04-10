package ebookBackend.RESTfulService.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {
    private List<User> userList = loadList("static/user.json");
    private HashMap<String, String> keyMap = loadMap(userList);

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        if (password.equals(keyMap.get(username))) {

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

    @SuppressWarnings("unchecked")
    private static List<User> loadList(String path) {
        List<User> list = new ArrayList<>();
        try {
            JSONArray userArray = null;
            Resource resource = new ClassPathResource(path);
            File listFile = resource.getFile();

            String input = FileUtils.readFileToString(listFile);
            JSONObject jsonObject = JSONObject.fromObject(input);

            if (jsonObject != null) {
                userArray = jsonObject.getJSONArray("userList");
                list = JSONArray.toList(userArray, new User(), new JsonConfig());
            }

        } catch (IOException E) {
            System.out.println("ERROR");
        }
        return list;
    }

    private HashMap<String, String> loadMap(List<User> list) {
        HashMap<String, String> keyMap = new HashMap<>();
        int size = list.size();
        for (int i=0;i<size;i++) {
            keyMap.put(list.get(i).getID(), list.get(i).getPassword());
        }
        return keyMap;
    }


}

class User {
    private String ID;
    private String password;
    private String identity;
    private boolean ban;
    private String mail;

    public User() {
        this.mail = "123@gmail.com";
        this.ID = "123";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String email) {
        this.mail = email;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getIdentity() { return identity; }

    public void setIdentity(String identity) { this.identity = identity; }

    public boolean getBan() { return ban; }

    public void setBan(boolean ban) { this.ban = ban; }
}