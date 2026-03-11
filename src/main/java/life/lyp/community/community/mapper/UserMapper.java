package life.lyp.community.community.mapper;

import life.lyp.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
    @Insert("INSERT INTO user_table(account_id, name, token, gmt_create, gmt_modified) VALUES ( #{account_id} ,#{name},#{token},#{gmtCreate},#{gmtModified}) ")
    void insert(User user);
}
