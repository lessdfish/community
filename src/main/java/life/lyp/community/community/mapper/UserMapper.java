package life.lyp.community.community.mapper;

import life.lyp.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * ClassName:UserMapper
 * Package:life.lyp.community.community.mapper
 * Description:
 *
 * @Author:lyp
 * @Create:2026/3/11 - 19:24
 * @Version: v1.0
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user_table(account_id, name, token, gmt_create, gmt_modified, avatar_url) VALUES ( #{accountId} ,#{name},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl}) ")
    void insert(User user);

    @Select("SELECT * FROM user_table where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user_table where id = #{id}")
    User findById(Integer creator);
}
