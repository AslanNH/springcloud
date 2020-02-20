package com.nh;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.protocol.ResponseDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ErrorHandlerController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("error")
    public Object error(HttpServletRequest request){
        Map<String,Object> errorAttributes = getErrorAttributes(request);
        String message = (String) errorAttributes.get("message");
        String trace = (String) errorAttributes.get("trace");
        if(StringUtils.isNotBlank(trace)){
            message += String.format(" and trace %s",trace);
        }
        return JSONObject.parseObject(message).toJSONString();
    }

    private Map<String,Object> getErrorAttributes(HttpServletRequest request) {
        return errorAttributes.getErrorAttributes(new ServletWebRequest(request),true);
    }
}
