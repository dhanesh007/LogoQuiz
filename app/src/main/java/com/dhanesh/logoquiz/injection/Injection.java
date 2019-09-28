package com.dhanesh.logoquiz.injection;

import android.content.Context;

import com.dhanesh.logoquiz.repository.IQuizRepository;
import com.dhanesh.logoquiz.repository.IRulesRespository;
import com.dhanesh.logoquiz.repository.InMemoryQuizRepository;
import com.dhanesh.logoquiz.repository.RulesRepository;
import com.dhanesh.logoquiz.ui.ViewModelFactory;

public class Injection {
    public static IRulesRespository provideRulesRepository() {
        return new RulesRepository();
    }

    public static IQuizRepository provideQuizRepository() {
        return new InMemoryQuizRepository();
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        IRulesRespository rulesRespository = provideRulesRepository();
        IQuizRepository quizRepository = provideQuizRepository();
        return new ViewModelFactory(rulesRespository, quizRepository);
    }
}
