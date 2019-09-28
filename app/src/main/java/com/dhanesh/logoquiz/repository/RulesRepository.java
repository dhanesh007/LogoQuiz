package com.dhanesh.logoquiz.repository;

import com.dhanesh.logoquiz.domain.IRule;
import com.dhanesh.logoquiz.domain.StringMatchRule;

import java.util.ArrayList;
import java.util.List;

public class RulesRepository implements IRulesRespository {
    private List<IRule> mRules;

    public RulesRepository() {

    }

    public List<IRule> getRules() {
        if (mRules == null) {
            mRules = new ArrayList<>();
            mRules.add(StringMatchRule.getInstance());
        }
        return mRules;
    }

}
