package ebookBackend.RESTfulService.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/getBook")
public class BookListController {
    private List<Book> bookList = loadList("static/booklist.json");
    private List<BookBasic> basicList = loadBasic(bookList);
    private HashMap<String, Integer> index = loadIndex(bookList);

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<BookBasic> getList() {
        return basicList;
    }

    @RequestMapping(path = "/information", method = RequestMethod.GET)
    @ResponseBody
    public Book information(@RequestParam String ID) {
//        int i;
        if (index.get(ID) == null) {
            return new Book();
        }
        else {
            return bookList.get(index.get(ID));
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Book> loadList(String path) {
        List<Book> list = new ArrayList<>();
        try {
            System.out.println("loading");
            Resource resource = new ClassPathResource(path);
            File listFile = resource.getFile();
            JSONArray bookArray = null;

            String input = FileUtils.readFileToString(listFile);

            JSONObject jsonObject = JSONObject.fromObject(input);

            if (jsonObject != null) {
                bookArray = jsonObject.getJSONArray("bookList");
                list = JSONArray.toList(bookArray, new Book(), new JsonConfig());
            }

        } catch (IOException E) {
            System.out.println("ERROR");
        }
        return list;
    }

    private static HashMap<String, Integer> loadIndex(List<Book> list) {
        int size = list.size();
        HashMap<String, Integer> indexMap = new HashMap<>();
        for (int i=0;i<size;i++) {
            indexMap.put(list.get(i).getID(),i);
        }
        return indexMap;
    }

    private static List<BookBasic> loadBasic(List<Book> l) {
        List<BookBasic> basicList = new ArrayList<>();
        for (int i=0;i<l.size();i++) {
            basicList.add(new BookBasic(l.get(i)));
        }
        return basicList;
    }
}
