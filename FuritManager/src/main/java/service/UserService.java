package service;

import bean.User;

public interface UserService {
	public String reg(User user);
	public User login(User user);
	public String resetPwd(User user);
	public boolean isUnameExists(String uname);
}
