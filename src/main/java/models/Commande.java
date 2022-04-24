package models;

public class Commande {
	public static int nbreTotal ;
	private int id ;
	private String date ;
	private String supplier ;
	private String article_name ;
	private String article_price ;
	private int quantity_choiced ;
	private double total_price ;
	public Commande() {
		super();
		Commande.nbreTotal ++ ; 
		id = nbreTotal ;
		// TODO Auto-generated constructor stub
	}
	public Commande(int id, String date, String supplier, String article_name, String article_price,
			int quantity_choiced, double total_price) {
		super();
		this.id = id;
		this.date = date;
		this.supplier = supplier;
		this.article_name = article_name;
		this.article_price = article_price;
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
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getArticle_name() {
		return article_name;
	}
	public void setArticle_name(String article_name) {
		this.article_name = article_name;
	}
	public String getArticle_price() {
		return article_price;
	}
	public void setArticle_price(String article_price) {
		this.article_price = article_price;
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
		return "Commande [id=" + id + ", date=" + date + ", supplier=" + supplier + ", article_name=" + article_name
				+ ", article_price=" + article_price + ", quantity_choiced=" + quantity_choiced + ", total_price="
				+ total_price + "]";
	}
	
	
}
