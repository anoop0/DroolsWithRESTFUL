package com.droolsRestful.controller;

import com.droolsRestful.droolsUtilities.DroolsRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anoop on 07-03-2017.
 */
@RestController
public class DroolsRestController {

    @Autowired
    DroolsRules droolsRules;

    DecimalFormat format = new DecimalFormat("0.#");

    @RequestMapping(value="doMaths/{operation}/{num1}/{num2}", method = RequestMethod.GET,
        produces = "application/json")
    public Map basicOperation(@PathVariable("operation") String operation, @PathVariable("num1") String num1, @PathVariable("num2") String num2) {

        Map<String, String> input  = new HashMap<String, String>();
        input.put("operator",  operation);
        input.put("num1", num1);
        input.put("num2", num2);
        Double result  = droolsRules.executeOperation(input);

        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("result", format.format(result));
        return resultMap;
    }



}
