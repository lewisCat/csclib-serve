package com.csclib.service.impl;

import com.csclib.entity.Projects;
import com.csclib.mapper.ProjectsMapper;
import com.csclib.service.IProjectsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lewis
 * @since 2021-07-21
 */
@Service
public class ProjectsServiceImpl extends ServiceImpl<ProjectsMapper, Projects> implements IProjectsService {

}
