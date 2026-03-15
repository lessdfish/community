package life.lyp.community.community.advice;

import com.alibaba.fastjson.JSON;
import life.lyp.community.community.dto.ResultDTO;
import life.lyp.community.community.exception.CustomizeErrorCode;
import life.lyp.community.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * ClassName:CustomizeExceptionHandler
 * Package:life.lyp.community.community.advice
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/14 - 23:27
 * @Version: v1.0
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ModelAndView handle(HttpServletRequest request, Throwable ex, Model model, HttpServletResponse response) {

        String contentType = request.getContentType();

        if ("application/json".equals(contentType)) {

            ResultDTO resultDTO = null;
            //返回JSON
            if(ex instanceof CustomizeException){
                resultDTO = ResultDTO.errorOf((CustomizeException) ex);
            }else {
                resultDTO = ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;


        } else {
            //错误页面跳转
            if (ex instanceof CustomizeException) {
                model.addAttribute("message", ex.getMessage());

            } else {
                model.addAttribute("message", ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR));
            }
            return new ModelAndView("error");
        }
    }


        private HttpStatus getStatus (HttpServletRequest request){
            Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
            if (statusCode == null) {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }
            return HttpStatus.valueOf(statusCode);
        }
    }

