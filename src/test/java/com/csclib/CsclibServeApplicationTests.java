package com.csclib;

import com.csclib.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class CsclibServeApplicationTests {

  @Autowired DataSource ds;

  @Test
  void checkMD5Util() {
    System.out.println(MD5Util.getMD5("xylewis"));
  }

  @Test
  void checkDataSource() {
    try {
      System.out.println(ds.getConnection());
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
