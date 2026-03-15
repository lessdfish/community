package life.lyp.community.community.exception;

/**
 * ClassName:CustomizeException
 * Package:life.lyp.community.community.exception
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/14 - 23:39
 * @Version: v1.0
 */
public class CustomizeException extends RuntimeException{
    private String message;
    private Integer code;
    public CustomizeException(ICustomizeErrorCode errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage(){
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
