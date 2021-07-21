/*
package com.csclib;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;

public class CreateCode {
  public static void main(String[] args) {
    //
    AutoGenerator mpg = new AutoGenerator();
    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    gc.setOutputDir(System.getProperty("user.dir") + "/src/main/java"); // 输出目录
    gc.setAuthor("Lewis"); // 设置作者
    gc.setOpen(false); // 生成后不自动打开资源管理器
    gc.setFileOverride(true); // 是否覆盖文件
    gc.setIdType(IdType.ASSIGN_ID); // 设置主键策略
    gc.setDateType(DateType.ONLY_DATE); // 设置时间类型
    gc.setSwagger2(true); // 设置是否支持Swagger2
    mpg.setGlobalConfig(gc); // 填充全局配置
    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setEntity("entity");
    pc.setMapper("mapper");
    pc.setService("service");
    pc.setController("controller");
    pc.setParent("com.csclib");
    // pc.setModuleName("eim");
    mpg.setPackageInfo(pc); // 填充包信息

    // 数据库配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl("jdbc:mariadb://101.34.69.141:3306/csclib_dev");
    dsc.setDriverName("org.mariadb.jdbc.Driver");
    dsc.setUsername("root");
    dsc.setPassword("I8soRm4H1L5q");
    dsc.setDbType(DbType.MARIADB);
    mpg.setDataSource(dsc); // 填充数据库配置

    // 策略配置
    StrategyConfig sc = new StrategyConfig();
    sc.setInclude(
        "certificates", "employees", "projects", "prousecert", "sysuser"); // 设置映射的数据表,对应生成相应代码
    sc.setEntityLombokModel(true);
    sc.setNaming(NamingStrategy.underline_to_camel); // 下划线转驼峰命名
    sc.setColumnNaming(NamingStrategy.underline_to_camel); // 下划线转驼峰命名
    sc.setLogicDeleteFieldName("deleted"); // 设置逻辑删除列
    // 自动填充配置
    TableFill gmtCreate = new TableFill("gtm_create", FieldFill.INSERT);
    TableFill gmtModify = new TableFill("gtm_modify", FieldFill.INSERT_UPDATE);
    ArrayList<TableFill> tableFiles = new ArrayList<TableFill>();
    tableFiles.add(gmtCreate);
    tableFiles.add(gmtModify);
    // 加入自动生成策略
    sc.setTableFillList(tableFiles);
    sc.setVersionFieldName("version"); // 乐观锁
    sc.setRestControllerStyle(true); // RestController风格
    sc.setControllerMappingHyphenStyle(true); // 支持下划线路径
    mpg.setStrategy(sc); // 填充策略配置
    // 配置模板引擎
    mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    // 执行代码生成
    mpg.execute();
  }
}
*/
