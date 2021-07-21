package com.csclib.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csclib.entity.Projects;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper 接口
 *
 * @author Lewis
 * @since 2021-07-21
 */
@Mapper
public interface ProjectsMapper extends BaseMapper<Projects> {}
