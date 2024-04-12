package spring.data.jdbc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import spring.data.jdbc.entity.Author;

@Mapper
public interface AuthorMapper {
    @Select("SELECT id, first_name as firstName, last_name as lastName FROM AUTHOR WHERE id = #{id}")
    Author getAuthor(@Param("id") Long id);

    @Insert("INSERT INTO AUTHOR (first_name, last_name) VALUES (#{firstName}, #{lastName})")
    Long saveAuthor(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
