package ebookBackend.RESTfulService.controller;

import ebookBackend.RESTfulService.entity.User;
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

@RestController
@RequestMapping("/api")
public class LoginController {
    private List<User> userList = loadList("static/user.json");
    private HashMap<String, String> keyMap = loadMap(userList);

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody User user) {
        System.out.println(user);
//        if (password.equals(keyMap.get(username))) {
//            return "successful";
//        } else {
            return "failed";
//        }
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
            keyMap.put(list.get(i).getId(), list.get(i).getPassword());
        }
        return keyMap;
    }


}