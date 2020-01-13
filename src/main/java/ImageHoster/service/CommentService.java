package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentService {
    @Autowired
    private CommentsRepository commentsRepository;
    public void saveComment(String text, User user,  Image image){
        Comment comments = new Comment();
        comments.setText(text);
        comments.setCreatedDate(new Date());
        comments.setImage(image);
        comments.setUser(user);
        commentsRepository.saveComments(comments);
    }
}
