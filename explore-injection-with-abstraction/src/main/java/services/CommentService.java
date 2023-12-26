package services;

import models.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

@Service
@Lazy
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRepository commentRepository,
                          @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        System.out.println("Comment Service initialized");
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
