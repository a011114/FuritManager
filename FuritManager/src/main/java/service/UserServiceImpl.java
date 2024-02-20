package service;

import dao.UserDaoImpl;
import bean.User;

public class UserServiceImpl implements UserService{
	
	public String reg(User user) {

		user.setStatus('1');
		
		UserDaoImpl userDao = new UserDaoImpl();
		String info = userDao.add(user);
		
		return info;
	}
	
	public User login(User user) {
		if(user==null || user.getUname()==null || user.getPwd()==null
				|| "".equals(user.getUname()) || "".equals(user.getPwd())) {
			return null;
		}
		UserDaoImpl userDao = new UserDaoImpl();
		User u = userDao.getUser(user);
		return u;
	}

	public String resetPwd(User user) {

		if (user == null || user.getTel() == null || user.getPwd() == null
				|| "".equals(user.getTel()) || "".equals(user.getPwd())) {
			return null;
		}
		UserDaoImpl userDao = new UserDaoImpl();
		String info = userDao.updatePwd(user);
		return info;
	}

	public boolean isUnameExists(String uname) {

		if (uname == null || "".equals(uname)) {
			return true;
		}
		UserDaoImpl userDao = new UserDaoImpl();
		boolean result = userDao.getByUname(uname);
		return result;
	}
}
