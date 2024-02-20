package bean;

/**
 * ��Ʒ��
 * @author liz@pdsu
 *
 */
public class Furit {
	private long gid;        
	private String gname;     
	private String unit;     
	private double price;    
	private float remain;    
	private String status;   
	
	public Furit() {
	}
	public Furit(long gid, String gname, String unit, double price, float remain, String status) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.unit = unit;
		this.price = price;
		this.remain = remain;
		this.status = status;
	}


	public long getGid() {
		return gid;
	}
	public void setGid(long gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public float getRemain() {
		return remain;
	}
	public void setRemain(float remain) {
		this.remain = remain;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", unit=" + unit + ", price=" + price
				+ ", remain=" + remain + ", status=" + status + "]";
	}
}
