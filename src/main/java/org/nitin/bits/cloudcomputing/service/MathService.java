package org.nitin.bits.cloudcomputing.service;

import org.nitin.bits.cloudcomputing.entity.MathRequest;
import org.nitin.bits.cloudcomputing.entity.Result;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MathService {

    public Result computeValue(MathRequest mathRequest) {
        Long result = 0L;
        String expression = mathRequest.getExpression();
        List<String> validExpressions = Arrays.asList("+", "-", "*", "/");
        Long num1 = mathRequest.getNum1();
        Long num2 = mathRequest.getNum2();
        switch (expression) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new RuntimeException("Cannot divide by zero");
                }
                result = num1 / num2;
                break;
            default:
                throw new RuntimeException("Invalid operation requested. Supported expressions are: " + validExpressions.toString());
        }
        return new Result(HttpStatus.OK, result.toString());
    }
}
