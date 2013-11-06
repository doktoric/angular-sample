package com.acme.doktoric.web;

import org.codehaus.jackson.map.ObjectMapper;
import com.acme.doktoric.dto.ResponseMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JsonExceptionHandler implements HandlerExceptionResolver {
    private ObjectMapper mapper = new ObjectMapper();

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            mapper.writeValue(response.getWriter(), new ResponseMessage(ResponseMessage.Type.error, ex.getMessage()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
