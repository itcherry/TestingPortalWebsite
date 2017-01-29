package com.javaweb.model.dao;

import com.javaweb.model.entity.Answer;
import com.javaweb.model.entity.task.Task;

import java.util.List;

public interface AnswerDao extends GenericDao<Answer> {
	List<Answer> getListOfAnswersForTask(Task task);
	void insertAnswerForPersonHistory(int answerId, int personId);
}
