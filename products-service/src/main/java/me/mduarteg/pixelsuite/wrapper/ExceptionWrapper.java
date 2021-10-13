package me.mduarteg.pixelsuite.wrapper;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ExceptionWrapper {
    private String code;
    private String message;
    private Object errorObject;

    public ExceptionWrapper(String code, String message, Object errorObject) {
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

    public Object getErrorObject() {
        return errorObject;
    }

    public void setErrorObject(Object errorObject) {
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