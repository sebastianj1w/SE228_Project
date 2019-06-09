package ebookBackend.controller;

import ebookBackend.repository.ImageRepository;
import ebookBackend.entity.Image;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;


@RestController
@CrossOrigin
@RequestMapping(value = "/image")
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private MongoTemplate mongoTemplate;


    @PostMapping("/uploadImage")
    @ResponseBody
    public String uploadImage(MultipartFile file){
        if(file.isEmpty())
            return "请选择一张图片";

        // 返回的 JSON 对象，这种类可自己封装
        String jsonResult;
        String fileName = file.getOriginalFilename();
        try {
            Image uploadFile = new Image();
            uploadFile.setName(fileName);
            uploadFile.setCreatedTime(new Date());
            uploadFile.setContent(new Binary(file.getBytes()));
            uploadFile.setContentType(file.getContentType());
            uploadFile.setSize(file.getSize());

            Image savedFile = imageRepository.save(uploadFile);
            String id = savedFile.getId();

            jsonResult =  id;
        } catch (IOException e) {
            e.printStackTrace();
            jsonResult =  "failed";
        }
        return jsonResult;

    }

    @GetMapping(value = "/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] image(@PathVariable String id){
        byte[] data = null;
        Image file = mongoTemplate.findById(id, Image.class);
        if(file != null){
            data = file.getContent().getData();
        }
        return data;
    }

}
