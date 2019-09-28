package com.dhanesh.logoquiz.domain;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ValidationResult {
    public enum ResultCodes {
        SUCCESSFUL,
        FAILED
    }

    public final ResultCodes validationStatus;
    public final String message;

    public ValidationResult(@NonNull ResultCodes resultCode, @Nullable String message) {
        this.validationStatus = resultCode;
        this.message = message;
    }

    public static ValidationResult getDefaultFailedResult() {
        return new ValidationResult(ResultCodes.FAILED, null);
    }

    public static ValidationResult getDefaultSuccessResult() {
        return new ValidationResult(ResultCodes.SUCCESSFUL, null);
    }
}


