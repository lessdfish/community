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
    public CustomizeException(ICustomizeErrorCode errorCode){
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
