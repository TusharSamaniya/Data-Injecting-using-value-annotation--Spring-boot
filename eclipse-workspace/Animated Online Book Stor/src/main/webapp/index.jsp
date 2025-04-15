<%@ page import="in.tushar.util.ConnectionFactory"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="in.tushar.dto.Products"%>
<%@ page import="in.tushar.dao.ProductsDAO"%>

<%
if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
	return; // Ensure the rest of the page doesn't execute after redirection
}
%>

<%
ProductsDAO dao = new ProductsDAO(ConnectionFactory.getConnection());
List<Products> RomanticBooks = dao.getRomanticPtoducts();
List<Products> AdvantureBooks = dao.getAdventureProducts();
List<Products> SelfHelpBooks = dao.getSelfHelpProducts();
List<Products> PoetryBooks = dao.getPoetryProducts();
%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet" href="IndexDesign.css">
<title>Home Page</title>

</head>
<body>

	<!-- Navabar -->
	<%@include file="includes/navbar.jsp"%>



	<!-- Carousel -->
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100"
					src="https://plus.unsplash.com/premium_photo-1676930551268-54f8608306e0?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
					alt="First slide">
				<div class="carousel-caption d-none d-md-block">
					<h5>Discover Your Next Great Read!</h5>
					<p>Thousands of books across all genres at unbeatable prices</p>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src="https://media.istockphoto.com/id/2154284120/photo/divine-light-on-an-open-prayer-book.jpg?s=612x612&w=0&k=20&c=oidz6H3fQjR2FlQ1ahCX2lUlNBIjfb23jFBcDHLE95Q="
					alt="Second slide">
				<div class="carousel-caption d-none d-md-block">
					<h5>Books That Inspire, Entertain & Educate!</h5>
					<p>Explore bestsellers, classics, and new releases</p>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src="https://media.istockphoto.com/id/1266961396/photo/rigved.jpg?s=612x612&w=0&k=20&c=_iMKbSvoCnYT22jrkjw2OWh1UL4TOXEpgaAM8Ctn8tI="
					alt="Third slide">
				<div class="carousel-caption d-none d-md-block">
					<h5>Your One-Stop Online Bookstore!</h5>
					<p>Find fiction, non-fiction, academic books, and more</p>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>


	<!-- Heading of romantic books -->
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Romantic</h1>
			<p class="lead">You must allow me to tell you how ardently I
				admire and love you..</p>
		</div>
	</div>

	<!--This is my card-->
	<div class="container">
		<div class="row">
			<%
			if (!RomanticBooks.isEmpty()) {
				for (Products p : RomanticBooks) {
			%>

			<div class="col-md-3 my-3">
				<div class="card w-100" style="width: 18rem;">
					<img class="card-img-top" src="ImageServlet?id=<%=p.getId()%>"
						alt="Product Image">

					<div class="card-body">
						<h5 class="card-title">
							<%=p.getName()%>
						</h5>

						<p>
							<del style="color: red;"><%=p.getFakePrice()%></del>
							<span style="font-weight: bold; color: green;"><%=p.getPrice()%></span>
						</p>
						<div class="mt-3 d-flex justify-content-between">
							<a href="add-to-Cart?id=<%=p.getId()%>"
								class="btn btn-outline-primary">Add to Card</a> <a href="#"
								class="btn btn-outline-primary">Buy Now</a>
						</div>
					</div>
				</div>
			</div>

			<%
			}
			}
			%>
		</div>
	</div>

	<div class="d-flex justify-content-center">
		<button type="button btn-default" class="btn btn-success btn-lg">View
			All</button>
	</div>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Fiction</h1>
			<p class="lead">Where reality bends and stories unfold" or "Step
				into a world where imagination reigns</p>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<%
			if (!AdvantureBooks.isEmpty()) {
				for (Products p : AdvantureBooks) {
			%>

			<div class="col-md-3 my-3">
				<div class="card w-100" style="width: 18rem;">
						<img class="card-img-top" src="ImageServlet?id=<%=p.getId()%>"
							alt="Adventure Books">
						<div class="card-body">
							<h5 class="card-title"><%=p.getName()%></h5>


							<p>
								<del style="color: red;"><%=p.getFakePrice()%></del>
								<span style="font-weight: bold; color: green;"><%=p.getPrice()%></span>
							</p>

							<div class="mt-3 d-flex justify-content-between">
							<a href="add-to-Cart?id=<%=p.getId()%>"
								class="btn btn-outline-primary">Add to Card</a> <a href="#"
								class="btn btn-outline-primary">Buy Now</a>
							</div>
						</div>
					
				</div>
			</div>
			<%
			}
			}
			%>
		</div>
	</div>

	<div class="d-flex justify-content-center">
		<button type="button btn-default" class="btn btn-success btn-lg">View
			All</button>
	</div>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Self-Help Books</h1>
			<p class="lead">Unlock your potential — because the only limits
				that exist are the ones you set for yourself</p>
		</div>
	</div>

	<!-- This is my Self Help books -->
	<div class="container">
		<div class="row">
			<%
			if (!SelfHelpBooks.isEmpty()) {
				for (Products p : SelfHelpBooks) {
			%>

			<div class="col-md-3 my-3">
				<div class="card w-100" style="width: 18rem;">
						<img class="card-img-top" src="ImageServlet?id=<%=p.getId()%>"
							alt="Self Help Books">
						<div class="card-body">
							<h5 class="card-title"><%=p.getName()%></h5>
							<p class="card-text">
								<del style="color: red"><%=p.getFakePrice()%></del>
								<span style="font-weight: bold; color: green;"><%=p.getPrice()%></span>
							</p>

							<div class="mt-3 d-flex justify-content-between">
							<a href="add-to-Cart?id=<%=p.getId()%>"
								class="btn btn-outline-primary">Add to Card</a> <a href="#"
								class="btn btn-outline-primary">Buy Now</a>
							</div>
						</div>

				</div>
			</div>

			<%
			}
			}
			%>
		</div>
	</div>

	<div class="d-flex justify-content-center">
		<button type="button btn-default" class="btn btn-success btn-lg">View
			All</button>
	</div>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">Poerty</h1>
			<p class="lead">Uncover the beauty of life, love, and emotion in
				every page of our poetry books</p>
		</div>
	</div>

	<!-- This is poetry books -->
	<div class="container">
		<div class="row">
			<%
			if (!PoetryBooks.isEmpty()) {
				for (Products p : PoetryBooks) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100" style="width: 18rem;">
						<img class="card-img-top" src="ImageServlet?id=<%=p.getId()%>"
							alt="Poetry Books">
						<h5 class="card-title"><%=p.getName()%></h5>
						<p class="card-text">
							<del style="color: red"><%=p.getFakePrice()%></del>
							<span style="font-weight: bold; color: green;"><%=p.getPrice()%></span>
						</p>

						<div class="mt-3 d-flex justify-content-between">
							<a href="add-to-Cart?id=<%=p.getId()%>"
								class="btn btn-outline-primary">Add to Card</a> <a href="#"
								class="btn btn-outline-primary">Buy Now</a>
						</div>
					
				</div>
			</div>
			<%
			}
			}
			%>

		</div>
	</div>



<%@ include file = "includes/footer.jsp" %>







	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>