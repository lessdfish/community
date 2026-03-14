package life.lyp.community.community.exception;

/**
 * ClassName:CustomizeErrorCode
 * Package:life.lyp.community.community.exception
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/14 - 23:48
 * @Version: v1.0
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND("你找到的问题不在了，要不然换一个试试？Ciallo～(∠・ω< )⌒★");

    @Override
    public String getMessage(){
        return message;
    }
    private String message;
    CustomizeErrorCode(String message){
        this.message = message;
    }
}
