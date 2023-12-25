package main;

import config.ProjectConfiguration;
import models.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import proxies.EmailCommentNotificationProxy;
import repositories.DBCommentRepository;
import services.CommentService;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(getComment());
    }

    private static void extracted() {
        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();
        var commentService = new CommentService(commentRepository, commentNotificationProxy);
        Comment comment = getComment();
        commentService.publishComment(comment);
    }

    private static Comment getComment() {
        var comment = new Comment();
        comment.setAuthor("Laurentiu");
        comment.setText("Demo Comment");
        return comment;
    }
}
