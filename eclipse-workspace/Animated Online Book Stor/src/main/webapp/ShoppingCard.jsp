<%@ page import = "in.tushar.dao.ProductsDAO"%>
<%@ page import = "in.tushar.util.ConnectionFactory"%>
<%@ page import="in.tushar.dto.Products"%>
<%@ page import="java.util.*"%>
<%@ page import="in.tushar.dto.ShopingCart"%>
<%@page import="java.text.DecimalFormat"%>



<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
	return; // Ensure the rest of the page doesn't execute after redirection
}
ArrayList<ShopingCart> cart_list = (ArrayList<ShopingCart>) session.getAttribute("cart-list");
List<ShopingCart> cartProduct = null;
if (cart_list != null) {
	ProductsDAO pDao = new ProductsDAO(ConnectionFactory.getConnection());
	cartProduct = pDao.getCartProducts(cart_list);
	double total = pDao.getTotalCartPrice(cart_list);
	request.setAttribute("total", total);
	request.setAttribute("cart_list", cart_list);
}
%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Shopping Card</title>
  </head>
  <body>
    
    <!-- Navabar -->
    <%@include file = "includes/navbar.jsp" %>
   
    <div class = "container my-3">
    	<div class="d-flex py-3">
    		<h3>Total Price: $ ${(total>0)?dcf.format(total):0} </h3>
    		<a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a>
    	</div>
    	
    		<table border = "1" class = "table table-light">
    		<thead>
    			<tr>
    				<th scope = "col">Name</th>
    				<th scope = "col">Category</th>
    				<th scope = "col">Price</th>
    				<th scope = "col">Buy Now</th>
    				<th scope = "col">Cancel</th>
    			</tr>
    		</thead>
    		
    		<tbody>
    			<%
				if (cart_list != null) {
					for (ShopingCart item : cartProduct) {
				%>
    			<tr>
                    <td><%= item.getName() %></td>
                    <td><%= item.getCategory() %></td>
                    <td><%= item.getPrice() %></td>
                    <td>
						<form action="order-now" method="post" class="form-inline">
						<input type="hidden" name="id" value="<%= item.getId()%>" class="form-input"/>
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%=item.getId()%>"><i class="fas fa-plus-square"></i></a> 
								<input type="text" name="quantity" class="form-control"  value="<%=item.getQuantity()%>" readonly> 
								<a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=item.getId()%>"><i class="fas fa-minus-square"></i></a>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">Buy</button>
						</form>
					</td>
					<td><a href="remove-from-cart?id=<%=item.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
                    
                </tr>
                
               <%
				}}%>
    		</tbody>
    	
    	</table>
    	
    	</div>
    
    </div>
    
    
    
    <!-- Footer -->
    <%@include file = "includes/footer.jsp" %>
    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>