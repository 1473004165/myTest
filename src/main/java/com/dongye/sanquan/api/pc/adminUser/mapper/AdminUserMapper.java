package com.dongye.sanquan.api.pc.adminUser.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dongye.sanquan.pojo.orm.SysAdminEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 章卜
 * @since 2021-04-05
 */
@Mapper
@Repository
public interface AdminUserMapper extends BaseMapper<SysAdminEntity> {


}
