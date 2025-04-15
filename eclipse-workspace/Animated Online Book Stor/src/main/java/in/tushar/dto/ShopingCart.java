package in.tushar.dto;

public class ShopingCart extends Products{
	
	private int quantity;

	public ShopingCart() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
