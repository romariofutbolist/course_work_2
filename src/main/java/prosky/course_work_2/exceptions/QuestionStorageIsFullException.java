package prosky.course_work_2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionStorageIsFullException extends RuntimeException {
    public QuestionStorageIsFullException(String message) {
        super(message);
    }
}
