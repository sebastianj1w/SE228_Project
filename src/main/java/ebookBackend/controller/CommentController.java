package ebookBackend.controller;

import ebookBackend.entity.Comment;
import ebookBackend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @RequestMapping(path = "/getByBook", method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> getCommentByBookId(@RequestParam String Bid) {
        return commentRepository.findByToID(Bid);
    }

    @RequestMapping(path = "/setToBook", method = RequestMethod.POST)
    @ResponseBody
    public String setCommentToBookId(@RequestParam String Bid, @RequestBody Comment comment) {
        comment.setCreatedTime(new Date());
        comment.setContentType(0);
        comment.setSize(comment.getContent().length());
        commentRepository.save(comment);
        return "";
    }
}
