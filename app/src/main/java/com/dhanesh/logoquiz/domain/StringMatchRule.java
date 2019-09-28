package com.dhanesh.logoquiz.domain;

import com.dhanesh.logoquiz.utils.StringUtils;

public class StringMatchRule implements IRule<String> {

    private static StringMatchRule mInstance;
    private static final Object lock = new Object();

    private StringMatchRule() {
        // Making it singleton
    }

    public static StringMatchRule getInstance() {
        if (mInstance == null) {
            synchronized (lock) {
                if (mInstance == null) {
                    mInstance = new StringMatchRule();
                }
            }
        }
        return mInstance;
    }

    @Override
    public ValidationResult validate(String originalString, String strToBeMatched) {
        if (!StringUtils.isEmptyOrNull(strToBeMatched)) {
            if (originalString.equalsIgnoreCase(strToBeMatched)) {
                return ValidationResult.getDefaultSuccessResult();
            } else {
                return new ValidationResult(ValidationResult.ResultCodes.FAILED, "Invalid String!");
            }
        }
        return ValidationResult.getDefaultFailedResult();
    }
}
