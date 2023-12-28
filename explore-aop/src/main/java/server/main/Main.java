package server.main;

import config.ProjectConfiguration;
import lombok.extern.java.Log;
import models.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

@Log
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        var service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Demo Comment");
        comment.setAuthor("Asela");

        String value = service.publishComment(comment);
        log.info("Publish Value " + value);

         value = service.editComment(comment);
        log.info("Edit Value " + value);

         value = service.deleteComment(comment);
        log.info("Delete Value " + value);
    }
}
