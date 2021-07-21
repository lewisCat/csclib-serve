package com.csclib.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * druid数据源配置类
 *
 * @author lewis
 */
@Configuration
public class DruidConfig {
  /*数据源*/
  @Bean
  @ConfigurationProperties(prefix = "spring.datasource") // 引入yml的配置
  public DataSource druidDataSource() {
    return new DruidDataSource();
  }

  /*后台监控功能*/
  @Bean
  public ServletRegistrationBean statViewServlet() {
    ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    HashMap<String, String> map = new HashMap<>();
    map.put("loginUsername", "admin");
    map.put("loginPassword", "xylewis");
    map.put("allow", "");
    bean.setInitParameters(map);

    return bean;
  }
}
