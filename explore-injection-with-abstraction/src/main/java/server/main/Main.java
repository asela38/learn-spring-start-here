package server.main;

import config.ProjectConfiguration;
import models.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import proxies.EmailCommentNotificationProxy;
import repositories.DBCommentRepository;
import services.CommentService;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        System.out.println("Main.server.main context created.");
        var commentService = context.getBean(CommentService.class);
        System.out.println("Main.server.main comment service created");
        commentService.publishComment(getComment());

        Object o = context.getBean("singletonObject", Object.class);
        Object o1 = context.getBean("singletonObject", Object.class);
        Object o2 = context.getBean("prototypeObject", Object.class);
        Object o3 = context.getBean("prototypeObject", Object.class);

        System.out.println("singletons o == o1 = " + (o == o1));
        System.out.println("prototypes o2 == o3 = " + (o2 == o3));


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
