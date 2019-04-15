package ebookBackend.dao;

import ebookBackend.entity.TUserinfo;
import ebookBackend.entity.TUserinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userinfo
     *
     * @mbggenerated
     */
    int countByExample(TUserinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userinfo
     *
     * @mbggenerated
     */
    int deleteByExample(TUserinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userinfo
     *
     * @mbggenerated
     */
    int insert(TUserinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userinfo
     *
     * @mbggenerated
     */
    int insertSelective(TUserinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userinfo
     *
     * @mbggenerated
     */
    List<TUserinfo> selectByExample(TUserinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userinfo
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TUserinfo record, @Param("example") TUserinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userinfo
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TUserinfo record, @Param("example") TUserinfoExample example);
}