package service;

import java.util.List;

import dao.FuritDao;
import dao.FuritDaoImpl;
import bean.Furit;

public class FuritServiceImpl implements FuritService {

	@Override
	public List<Furit> showAll() {
		FuritDao furitDao = new FuritDaoImpl();
		return furitDao.getAll();
	}

	@Override
	public Furit showDetail(long gid) {
		FuritDao furitDao = new FuritDaoImpl();
		return furitDao.getById(gid);
	}

	@Override
	public String add(Furit goods) {
		goods.setStatus("1");
		
		FuritDao furitDao = new FuritDaoImpl();
		return furitDao.add(goods);
	}

	@Override
	public String update(Furit goods) {
		
		goods.setStatus("1");
		
		FuritDao furitDao = new FuritDaoImpl();
		return furitDao.update(goods);
	}

	@Override
	public String delete(long gid) {
		FuritDao furitDao = new FuritDaoImpl();
		return furitDao.delete(gid);
	}
}
