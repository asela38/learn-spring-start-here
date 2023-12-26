package services;

import annotations.ToLog;
import lombok.extern.java.Log;
import models.Comment;
import org.springframework.stereotype.Service;

@Service
@Log
public class CommentService {

    public String publishComment(Comment comment) {
        log.info("Publish Comment : " + comment.getText());
        return "SUCCESS";
    }

    @ToLog
    public String deleteComment(Comment comment) {
        log.info("Delete Comment : " + comment.getText());
        return "SUCCESS";
    }

    public String editComment(Comment comment) {
        log.info("Edit Comment : " + comment.getText());
        return "SUCCESS";
    }
}
