package bean;

/**
 * �û���
 * @author liz@pdsu
 *
 */
public class User {
	private long uid;            
	private String uname;        
	private String pwd;         
	private String tel;        
	private char status;        
	
	
	public User() {
	}
	
	public User(long uid, String uname, String pwd, String tel, char status) {
		this.uid = uid;
		this.uname = uname;
		this.pwd = pwd;
		this.tel = tel;
		this.status = status;
	}
		
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", pwd=" + pwd + ", tel=" + tel + ", status=" + status + "]";
	}
	
}
