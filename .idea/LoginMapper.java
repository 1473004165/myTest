package com.dongye.sanquan.api.mb.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dongye.sanquan.pojo.orm.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("mbLoginMapper")
@Mapper
public interface LoginMapper extends BaseMapper<SysUserEntity> {

}
