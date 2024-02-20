package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import util.DBUtil;

public class UserDaoImpl implements UserDao{
	//注册
	public String add(User user) {
		//返回执行结果给调用者
		String info = "failure";
		//数据库访问的准备工作
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into users(uname,pwd,tel,status) "
				    +"values(?,?,?,?)";
		try {
			//打开预编译语句
			ps = conn.prepareStatement(sql);
			//准备数据
			ps.setString(1, user.getUname());
			ps.setString(2,user.getPwd());
			ps.setString(3, user.getTel());
			ps.setString(4, String.valueOf(user.getStatus()));
			//执行更新语句
			int i = ps.executeUpdate();
			//处理结果
			if(i==1) {
				info = "success";
			}
		} catch (SQLException e) {
			info = "failure";
			e.printStackTrace();
		}finally {
			//关闭资源
			DBUtil.close(null, ps, conn);
		}
		return info;
	}

	@Override
	public User getUser(User user) {
		User u = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from users where uname=? and pwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getUname());
			ps.setString(2,user.getPwd());
			rs = ps.executeQuery();
			
			//计数变量，记录循环次数。超出1次循环认为登录无效
			int flag = 0;
			while(rs.next()) {
				flag++;
				if(flag>1) {
					u = null;
					break;
				}
				u = new User();
				u.setUid(rs.getLong("uid"));
				u.setUname(rs.getString("uname"));
				u.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public boolean getByUname(String uname) {
		//返回执行结果给调用者
		boolean exists = true;
		//数据库访问的准备工作
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//打开预编译语句
			String sql = "select * from users where uname=?";
			ps = conn.prepareStatement(sql);
			//准备数据
			ps.setString(1,uname);
			//执行更新语句
			rs = ps.executeQuery();
			//计数变量，记录循环次数。超出1次循环认为登录无效
			int flag = 0;
			while(rs.next()) {
				flag++;
				if(flag>1) break;
			}
			exists = flag==0?false:true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭资源
			DBUtil.close(null, ps, conn);
		}
		return exists;
	}

	@Override
	public String updatePwd(User user) {
		//返回执行结果给调用者
		String info = "failure";
		///数据库访问的准备工作
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update users set pwd=? where tel=?";
		try {
			//打开预编译语句
			ps = conn.prepareStatement(sql);
			//准备数据
			ps.setString(1,user.getPwd());
			ps.setString(2, user.getTel());
			//执行更新语句
			ps.executeUpdate();
			info = "success";
		} catch (SQLException e) {
			info = "failure";
			e.printStackTrace();
		}finally {
			//关闭资源
			DBUtil.close(null, ps, conn);
		}
		return info;
	}
}
