package com.video.mapper;

        import com.video.pojo.User;
        import org.apache.ibatis.annotations.Param;
        import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User loginUser(@Param( "email") String email, @Param("pwd") String pwd);
}
