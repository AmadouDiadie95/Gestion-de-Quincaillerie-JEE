package models;

public class Supplier {
	public static int nbreTotal ;
	private int id ;
	private String name ;
	private String tel ;
	private String address ;
	private String email ;
	public Supplier() {
		super();
		Supplier.nbreTotal ++ ; 
		id = nbreTotal ;
		// TODO Auto-generated constructor stub
	}
	public Supplier(int id, String name, String tel, String address, String email) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", tel=" + tel + ", address=" + address + ", email=" + email
				+ "]";
	}
	
	
}
