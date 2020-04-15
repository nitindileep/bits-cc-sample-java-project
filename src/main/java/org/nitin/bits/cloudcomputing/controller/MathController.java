package org.nitin.bits.cloudcomputing.controller;

import org.nitin.bits.cloudcomputing.entity.MathRequest;
import org.nitin.bits.cloudcomputing.entity.Result;
import org.nitin.bits.cloudcomputing.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/compute")
public class MathController {

    @Autowired
    MathService mathService;

    @PostMapping
    public ResponseEntity evaluateSimpleMathExpression(@RequestBody MathRequest mathRequest) {
        Result result;
        try {
            result = mathService.computeValue(mathRequest);
        } catch (Exception e) {
            result = new Result(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return new ResponseEntity(result, result.getStatus());
    }

    @GetMapping
    public ResponseEntity healthCheck() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
