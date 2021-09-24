package me.mduarteg.pixelsuite.wrapper;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ExceptionWrapper<T> {
    private String code;
    private String message;
    private T errorObject;

    public ExceptionWrapper(String code, String message, T errorObject) {
        this.code = code;
        this.message = message;
        this.errorObject = errorObject;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getErrorObject() {
        return errorObject;
    }

    public void setErrorObject(T errorObject) {
        this.errorObject = errorObject;
    }

    @Override
    public String toString() {
        return "ExceptionWrapper{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", errorObject=" + errorObject +
                '}';
    }
}