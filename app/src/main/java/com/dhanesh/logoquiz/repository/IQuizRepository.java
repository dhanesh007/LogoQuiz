package com.dhanesh.logoquiz.repository;

import com.dhanesh.logoquiz.data.QuizItem;

import java.util.List;

public interface IQuizRepository {

    public List<QuizItem> getQizItems();
}
