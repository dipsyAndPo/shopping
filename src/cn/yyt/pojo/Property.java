package cn.yyt.pojo;

public class Property {
	private int id;
	private String name;
	private Category category;
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Property(int id, String name, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Property [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	
	
	
}
