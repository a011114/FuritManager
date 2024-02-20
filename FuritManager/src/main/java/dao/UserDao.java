package dao;

import bean.User;

public interface UserDao {

	
	public User getUser(User user);
	
	
	public boolean getByUname(String uname);

	
	public String add(User user);

	
	public String updatePwd(User user);
}
