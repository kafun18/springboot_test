package org.javaboy.vhr.exception;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.javaboy.vhr.model.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

//拦截异常并统一处理
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e,HttpServletResponse resp){
        if (e instanceof MySQLIntegrityConstraintViolationException){
            resp.setStatus(500);
            return RespBean.error("该数据有关联数据，操作失败！");
        }
        resp.setStatus(500);
        return RespBean.error("数据库异常，操作失败！");
    }
}
