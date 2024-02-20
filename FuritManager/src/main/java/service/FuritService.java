package service;

import java.util.List;

import bean.Furit;

public interface FuritService {
	List<Furit> showAll();
	
	Furit showDetail(long gid);
	
	String add(Furit goods);
	
	String update(Furit goods);
	
	String delete(long gid);
}
