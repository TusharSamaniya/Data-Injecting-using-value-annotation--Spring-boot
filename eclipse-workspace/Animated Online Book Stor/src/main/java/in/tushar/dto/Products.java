package in.tushar.dto;

public class Products {
	
	private int id;
	private String name;
	private String category;
	private int price;
	private int fakePrice;
	private byte[] image;
	
	public Products() {
    }
	
	public Products(int id, String name, String category, int price, int fakePrice, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.fakePrice = fakePrice;
		this.image = image;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getFakePrice() {
		return fakePrice;
	}
	public void setFakePrice(int fakePrice) {
		this.fakePrice = fakePrice;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
	

}
