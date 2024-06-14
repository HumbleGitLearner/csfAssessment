package ibf2023.csf.backend.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class PhotoDetails {
      @Id
    @Field("_id")

    private int photoId;
    private  String title;
    private String image;
    private String url;
    private  List<Comment> comments;
    
    public PhotoDetails() {
    }
    public PhotoDetails(int photoId, String title, String image, String url, List<Comment> comments) {
        this.photoId = photoId;
        this.title = title;
        this.image = image;
        this.url = url;
        this.comments = comments;
    }
    public int getPhotoId() {
        return photoId;
    }
    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
