package ImageHoster.controller;

import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class CommentController {
    @Autowired
    private CommentService commentsService;
    @Autowired
    private ImageService imageService;


    //This method is used to add comments /persist comment to database and redirected to /images/id/imageTitle;
    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments")
    public String comments(@PathVariable("imageId") String id, @PathVariable ("imageTitle") String imageTitle, @RequestParam ("comment") String text, HttpSession session) {
        User loggedUser=(User)session.getAttribute("loggeduser");
       Image image=imageService.getImageByTitle(Integer.valueOf(id),imageTitle);
       commentsService.saveComment(text,loggedUser,image);
       return "redirect:/images/"+id+"/"+imageTitle;
    }
}
