package ebookBackend.RESTfulService.controller;

import ebookBackend.RESTfulService.entity.BookDetail;
import ebookBackend.RESTfulService.entity.BookBasic;
import ebookBackend.RESTfulService.service.BookBasicService;
import ebookBackend.RESTfulService.service.BookDetailService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
//    private List<BookDetail> bookDetailList = loadList("static/booklist.json");
//    private List<BookBasic> basicList = loadBasic(bookDetailList);
//    private HashMap<String, Integer> index = loadIndex(bookDetailList);

    @Autowired
    BookBasicService bookBasicService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<BookBasic> getList() {
        List<BookBasic> list = bookBasicService.listAll();
        return list;
    }

    @Autowired
    BookDetailService bookDetailService;

    @RequestMapping(path = "/information", method = RequestMethod.GET)
    @ResponseBody
    public BookDetail information(@RequestParam String ID) {
//        int i;
        return bookDetailService.get(ID);
//        if (index.get(ID) == null) {
//            return new BookDetail();
//        }
//        else {
//            return bookDetailList.get(index.get(ID));
//        }
    }

    @SuppressWarnings("unchecked")
    private static List<BookDetail> loadList(String path) {
        List<BookDetail> list = new ArrayList<>();
        try {
            System.out.println("loading");
            Resource resource = new ClassPathResource(path);
            File listFile = resource.getFile();
            JSONArray bookArray = null;

            String input = FileUtils.readFileToString(listFile);

            JSONObject jsonObject = JSONObject.fromObject(input);

            if (jsonObject != null) {
                bookArray = jsonObject.getJSONArray("bookDetailList");
                list = JSONArray.toList(bookArray, new BookDetail(), new JsonConfig());
            }

        } catch (IOException E) {
            System.out.println("ERROR");
        }
        return list;
    }

    private static HashMap<String, Integer> loadIndex(List<BookDetail> list) {
        int size = list.size();
        HashMap<String, Integer> indexMap = new HashMap<>();
        for (int i=0;i<size;i++) {
            indexMap.put(list.get(i).getID(),i);
        }
        return indexMap;
    }

//    private static List<BookBasic> loadBasic(List<BookDetail> l) {
//        List<BookBasic> basicList = new ArrayList<>();
//        for (int i=0;i<l.size();i++) {
//            basicList.add(new BookBasic(l.get(i)));
//        }
//        return basicList;
//    }
}
