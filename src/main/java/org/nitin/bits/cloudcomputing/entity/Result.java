package org.nitin.bits.cloudcomputing.entity;

import org.springframework.http.HttpStatus;

public class Result {

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private HttpStatus status;
    private String result;

    public Result(HttpStatus status, String result) {
        this.status = status;
        this.result = result;
    }
}
