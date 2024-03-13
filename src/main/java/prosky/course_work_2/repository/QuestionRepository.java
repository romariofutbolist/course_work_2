package prosky.course_work_2.repository;

import prosky.course_work_2.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();


}
