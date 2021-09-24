package me.mduarteg.pixelsuite.wrapper;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ResponseWrapper<T> {
    private String code;
    private T result;

    public ResponseWrapper(String code, T result) {
        this.code = code;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "code='" + code + '\'' +
                ", result=" + result +
                '}';
    }
}
