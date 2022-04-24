/**
 * 
 */
package models;

/**
 * @author Papes
 *
 */
public class Category {
	public static int nbreTotal ;
	private int id ;
	private String name ;
	private String description ;
	private int number_of_article ;
	
	public Category() {
		super();
		Category.nbreTotal ++ ; 
		id = nbreTotal ;
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name, String description, int number_of_article) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.number_of_article = number_of_article;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumber_of_article() {
		return number_of_article;
	}

	public void setNumber_of_article(int number_of_article) {
		this.number_of_article = number_of_article;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", number_of_article="
				+ number_of_article + "]";
	}
	
	
}
