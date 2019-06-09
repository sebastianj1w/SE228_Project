package ebookBackend.repository;

import ebookBackend.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CommentRepository  extends MongoRepository<Comment, String> {
    @Query("{ 'id' : ?0 }")
    public Comment findByid(String id);

    @Query("{ 'toid' : ?0 }")
    public List<Comment> findByToID(String toid);

}
