package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Furit;
import util.DBUtil;


/**
 * ��Ʒ���ݷ��ʶ������ڲ�ѯ����ӻ�������ݿ��е���Ʒ��Ϣ
 * 
 * @author liz@pdsu
 *
 */
public class FuritDaoImpl implements FuritDao {
	// ��ѯȫ����Ʒ��Ϣ�������뼯����
	
	
	public List<Furit> getAll() {
		// ��������Ʒ���б�
		List<Furit> list = new ArrayList<Furit>();

		String sql = "select * from goods";
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			// ִ��SQL���
			rs = ps.executeQuery();

			//����ѯ����������Ʒ��Ϣ�����б�
			while (rs.next()) {
				//��һ�����ݴ�����Ʒ����
				Furit g = new Furit();
				g.setGid(rs.getLong("gid"));
				g.setGname(rs.getString("gname"));
				g.setUnit(rs.getString("unit"));
				g.setPrice(rs.getDouble("price"));
				g.setRemain(rs.getFloat("remain"));
				g.setStatus(rs.getString("status"));

				//����Ʒ��������б�
				list.add(g);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}

		return list;
	}

	// ������Ʒ��Ų�ѯ��Ʒ��Ϣ
	public Furit getById(long gid) {
		Furit goods = null;
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from goods where gid=?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, gid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				goods = new Furit();
				goods.setGid(rs.getLong("gid"));
				goods.setGname(rs.getString("gname"));
				goods.setUnit(rs.getString("unit"));
				goods.setPrice(rs.getDouble("price"));
				goods.setRemain(rs.getFloat("remain"));
				goods.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goods;
	}

	// ��goods��ָ������Ʒ��Ϣ�������ݿ�
	public String add(Furit goods) {
		// ����ִ�н����������
		String info = "failure";
		// ���ݿ���ʵ�׼������
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into goods(gid,gname,unit,price,remain,status) "
					+ "values(?,?,?,?,?,?)";
		try {
			// ��Ԥ�������
			ps = conn.prepareStatement(sql);
			// ׼������
			ps.setLong(1, goods.getGid());
			ps.setString(2, goods.getGname());
			ps.setString(3, goods.getUnit());
			ps.setDouble(4, goods.getPrice());
			ps.setFloat(5, goods.getRemain());
			ps.setString(6, goods.getStatus());
			// ִ�и������
			int i = ps.executeUpdate();
			// ������
			if (i == 1) {
				info = "success";
			}
		} catch (SQLException e) {
			info = "failure";
			e.printStackTrace();
		} finally {
			// �ر���Դ
			DBUtil.close(null, ps, conn);
		}
		return info;
	}

	// ��goods��ָ������Ʒ����Ϣ���µ����ݿ�
	public String update(Furit goods) {
		// ����ִ�н����������
		String info = "failure";
		// ���ݿ���ʵ�׼������
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "update goods set gname=?,unit=?,price=?,remain=?,status=? "
					+ "where gid=?";
		try {
			// ��Ԥ�������
			ps = conn.prepareStatement(sql);
			// ׼������
			ps.setString(1, goods.getGname());
			ps.setString(2, goods.getUnit());
			ps.setDouble(3, goods.getPrice());
			ps.setFloat(4, goods.getRemain());
			ps.setString(5, goods.getStatus());
			ps.setLong(6, goods.getGid());
			// ִ�и������
			ps.executeUpdate();
			// �������������ޱ仯ʱ����ֵΪ0�����δ�׳��쳣����Ϊִ�гɹ�����
			info = "success";
		} catch (SQLException e) {
			info = "failure";
			e.printStackTrace();
		} finally {
			// �ر���Դ
			DBUtil.close(null, ps, conn);
		}
		return info;
	}
	
	// ������Ʒ���ɾ����Ӧ����Ʒ
	@Override
	public String delete(long gid) {
		String info = "failure";
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from goods where gid=?";
		try {
			// ��Ԥ�������
			ps = conn.prepareStatement(sql);
			// ׼������
			ps.setLong(1, gid);
			// ִ�и������
			int i = ps.executeUpdate();
			if (i == 1) {
				info = "删除成功";
			}
		} catch (SQLException e) {
			info = "删除失败";
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ps, conn);
		}
		return info;
	}
}
