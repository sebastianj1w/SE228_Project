package ebookBackend.entity;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Comment {

    @Id
    private String id;
    private String userid; // 评论者用户名
    private String toid; // 对书id或comment id的评论
    private String content; // 评论内容
    private Date createdTime; // 上传时间
    private int contentType; // 评论类型（0对书/1跟帖）
    private long size; // 评论字数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
