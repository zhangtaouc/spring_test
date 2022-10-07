package utils;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public interface MyBatisutils {
    SqlSession getMyBatis() throws IOException;
}
