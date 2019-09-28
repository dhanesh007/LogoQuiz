/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dhanesh.logoquiz.ui;

import com.dhanesh.logoquiz.repository.IQuizRepository;
import com.dhanesh.logoquiz.repository.IRulesRespository;
import com.dhanesh.logoquiz.ui.home.HomeViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Factory for ViewModels
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

    private final IRulesRespository mRulesRespository;
    private final IQuizRepository mQuizRepository;

    public ViewModelFactory(IRulesRespository rulesRespository, IQuizRepository quizRepository) {
        this.mRulesRespository = rulesRespository;
        this.mQuizRepository = quizRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(mRulesRespository, mQuizRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
