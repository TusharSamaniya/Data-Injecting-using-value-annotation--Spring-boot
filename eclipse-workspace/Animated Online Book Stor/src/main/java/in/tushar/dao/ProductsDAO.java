package in.tushar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.tushar.dto.Products;
import in.tushar.dto.ShopingCart;

public class ProductsDAO {
	
	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String query;
	
	public ProductsDAO(Connection con) {
		super();
		this.con = con;
	}
	
	public List<Products> getRomanticPtoducts(){
		List<Products> item = new ArrayList<>();
		query = "select * from products where category = ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, "Romantic");
			rs =psmt.executeQuery();
			
			while(rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCategory(rs.getString("category"));
				p.setPrice(rs.getInt("price"));
				p.setFakePrice(rs.getInt("fakeprice"));
				
				item.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public List<Products> getAdventureProducts(){
		List<Products> item = new ArrayList<>();
		query = "select * from products where category = ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, "Adventure");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCategory(rs.getString("category"));
				p.setPrice(rs.getInt("price"));
				p.setFakePrice(rs.getInt("fakeprice"));
				
				item.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public List<Products> getSelfHelpProducts(){
		List<Products> item = new ArrayList<>();
		query = "select * from products where category = ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, "Self-help");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCategory(rs.getString("category"));
				p.setPrice(rs.getInt("price"));
				p.setFakePrice(rs.getInt("fakeprice"));
				
				item.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public List<Products> getPoetryProducts(){
		List<Products> item = new ArrayList<>();
		query = "select * from products where category = ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, "Poetry");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Products p = new Products();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCategory(rs.getString("category"));
				p.setPrice(rs.getInt("price"));
				p.setFakePrice(rs.getInt("fakeprice"));
				
				item.add(p);
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return item;
	}
	
	
	public Products getSingleProduct(int id) {
		 Products row = null;
	        try {
	            query = "select * from products where id=? ";

	            psmt = this.con.prepareStatement(query);
	            psmt.setInt(1, id);
	            ResultSet rs = psmt.executeQuery();

	            while (rs.next()) {
	            	row = new Products();
	                row.setId(rs.getInt("id"));
	                row.setName(rs.getString("name"));
	                row.setCategory(rs.getString("category"));
	                row.setPrice(rs.getInt("price"));
	                row.setImage(rs.getBytes("image"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
	
	
	public double getTotalCartPrice(ArrayList<ShopingCart> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (ShopingCart item : cartList) {
                    query = "select price from products where id=?";
                    psmt = this.con.prepareStatement(query);
                    psmt.setInt(1, item.getId());
                    rs = psmt.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getDouble("price")*item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }
	
	
	
	
	public List<ShopingCart> getCartProducts(ArrayList<ShopingCart> cartList){
		List<ShopingCart> products = new ArrayList<>();
		
		try {
			
			if(cartList.size() > 0) {
				for(ShopingCart item : cartList) {
					query = "select * from products where id = ?";
					psmt = con.prepareStatement(query);
					psmt.setInt(1, item.getId());
					rs = psmt.executeQuery();
					
					while(rs.next()) {
						ShopingCart row = new ShopingCart();
						row.setId(rs.getInt("id"));
						row.setName(rs.getString("name"));
						row.setCategory(rs.getString("category"));
						row.setPrice(rs.getInt("price"));
						row.setFakePrice(rs.getInt("fakeprice"));
						
						products.add(row);
					}
					rs.close();
					psmt.close();
				}
				
			}
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return products;
	}
	
}
