package com.bt.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
Testing comment
**/

@RestController
@RequestMapping("/")
public class SampleController {
    @RequestMapping(value = "/getResponse", method = RequestMethod.GET)
    @ResponseBody
    public String printAddress(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession)
            throws JSONException {
        int a = 20;
System.out.println("Inside printAddress method");
        JSONObject js = new JSONObject();
        js.put("Name", "KC Technologies, DevOps training Institute");
        js.put("Address", " Marathahalli ");

        return js.toString();

    }
}
