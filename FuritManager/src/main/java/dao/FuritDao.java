package dao;

import java.util.List;

import bean.Furit;

public interface FuritDao {
		
		public List<Furit> getAll();

		
		public Furit getById(long gid);

		
		public String add(Furit goods);

		
		public String update(Furit goods);
		
		public String delete(long gid);
}
