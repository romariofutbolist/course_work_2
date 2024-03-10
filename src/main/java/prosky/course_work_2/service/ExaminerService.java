package prosky.course_work_2.service;

import prosky.course_work_2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
