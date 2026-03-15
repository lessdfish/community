package life.lyp.community.community.dto;

import life.lyp.community.community.exception.CustomizeErrorCode;
import life.lyp.community.community.exception.CustomizeException;
import lombok.Data;

/**
 * ClassName:ResultDTO
 * Package:life.lyp.community.community.dto
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/15 - 16:44
 * @Version: v1.0
 */
@Data
public class ResultDTO {
    private Integer code;
    private String message;

    public static ResultDTO errorOf(Integer code,String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeErrorCode errorCode) {
        return errorOf(errorCode.getCode(),errorCode.getMessage());
    }
    public static ResultDTO okOf(){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("成功Ciallo～(∠・ω< )⌒★！");
        return resultDTO;
    }
    public static ResultDTO errorOf(CustomizeException e){
        return errorOf(e.getCode(),e.getMessage());
    }
}
