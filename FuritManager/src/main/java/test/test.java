package test;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import bean.User;
import dao.UserDao;
import util.DBUtil;

public class test {
	@Test
	public void test1() {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
	}
}
