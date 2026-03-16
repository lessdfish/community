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

    QUESTION_NOT_FOUND(2001,"你找到的问题不在了，要不然换一个试试？Ciallo～(∠・ω< )⌒★"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(20721,"当前操作需要登录，请登录后重试！ciallo~"),
    SYS_ERROR(2004,"服务器冒烟了，要不然等会再试？Ciallo～(∠・ω< )⌒★"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在！"),
    COMMENT_NOT_FOUND(2006,"你找的评论不见了，要不然换一个试试？"),
    CONTENT_IS_EMPTY(2007,"输入内容不能为空！ciallo~");


    @Override
    public String getMessage(){
        return message;
    }
    private Integer code;

    @Override
    public Integer getCode() {
        return code;
    }

    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
