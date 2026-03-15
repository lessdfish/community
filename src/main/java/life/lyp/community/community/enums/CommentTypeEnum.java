package life.lyp.community.community.enums;

/**
 * ClassName:CommentTypeEnum
 * Package:life.lyp.community.community.enums
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/15 - 16:50
 * @Version: v1.0
 */
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);
    private Integer type;

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType()==type) {
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type){
        this.type = type;
    }
}
