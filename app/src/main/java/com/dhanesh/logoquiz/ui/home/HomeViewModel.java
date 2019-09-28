package com.dhanesh.logoquiz.ui.home;

import com.dhanesh.logoquiz.data.QuizItem;
import com.dhanesh.logoquiz.domain.IRule;
import com.dhanesh.logoquiz.domain.ValidationResult;
import com.dhanesh.logoquiz.repository.IQuizRepository;
import com.dhanesh.logoquiz.repository.IRulesRespository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private IRulesRespository mRulesRespository;
    private IQuizRepository mQuizRepository;

    public HomeViewModel(@NonNull IRulesRespository rulesRepository, @NonNull IQuizRepository quizRepository) {
        this.mRulesRespository = rulesRepository;
        this.mQuizRepository = quizRepository;
    }

    public List<QuizItem> getQuizItems() {
        return this.mQuizRepository.getQizItems();
    }

    public ValidationResult validate(QuizItem quizItem, String strToBeValidated) {
        for (IRule rule : mRulesRespository.getRules()) {
            ValidationResult validationResult = rule.validate(quizItem.name, strToBeValidated);
            if (validationResult.validationStatus == ValidationResult.ResultCodes.FAILED) {
                return validationResult;
            }
        }
        return ValidationResult.getDefaultSuccessResult();
    }
}
