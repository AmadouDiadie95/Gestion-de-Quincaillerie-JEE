package models;

public class Vente {
	public static int nbreTotal ;
	private int id ;
	private String date ;
	private String client_name ;
	private String article_name ;
	private int quantity_choiced ;
	private double total_price ;
	public Vente() {
		super();
		Vente.nbreTotal ++ ; 
		id = nbreTotal ;
		// TODO Auto-generated constructor stub
	}
	public Vente(int id, String date, String client_name, String article_name, int quantity_choiced,
			double total_price) {
		super();
		this.id = id;
		this.date = date;
		this.client_name = client_name;
		this.article_name = article_name;
		this.quantity_choiced = quantity_choiced;
		this.total_price = total_price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getArticle_name() {
		return article_name;
	}
	public void setArticle_name(String article_name) {
		this.article_name = article_name;
	}
	public int getQuantity_choiced() {
		return quantity_choiced;
	}
	public void setQuantity_choiced(int quantity_choiced) {
		this.quantity_choiced = quantity_choiced;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	@Override
	public String toString() {
		return "Vente [id=" + id + ", date=" + date + ", client_name=" + client_name + ", article_name=" + article_name
				+ ", quantity_choiced=" + quantity_choiced + ", total_price=" + total_price + "]";
	}
	
	

}
