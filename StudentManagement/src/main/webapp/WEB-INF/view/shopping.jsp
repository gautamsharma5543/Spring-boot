<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
/* Basic table styling */
table {
    width: 100%;
    border-collapse: collapse; /* Removes double border spacing */
    margin: 20px 0;
    font-size: 16px;
    text-align: left;
    background-color: #f8f9fa; /* Light background for the table */
}

/* Table header styling */
table th {
    background-color: #343a40; /* Dark header */
    color: #ffffff;           /* White text */
    padding: 12px 15px;
    font-weight: bold;
}

/* Table row styling */
table td, table th {
    border: 1px solid #dddddd; /* Light border */
    padding: 10px 15px;
}

/* Alternating row colors */
table tr:nth-child(even) {
    background-color: #f2f2f2; /* Light gray for even rows */
}

table tr:nth-child(odd) {
    background-color: #ffffff; /* White for odd rows */
}

/* Hover effect for rows */
table tr:hover {
    background-color: #e0f7fa; /* Light blue hover */
    cursor: pointer;
}

/* Add some responsiveness */
@media (max-width: 768px) {
    table {
        font-size: 14px;
    }

    table th, table td {
        padding: 8px 10px;
    }
}

img {
	height: 100px;
	width: 100px;
}
h1{text-align:center;color:blue;font-family: brush script mt,cursive;letter-spacing: 10px;}
</style>
<body>


<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>


<script>
$(document).ready(function(){
	$getJSON("https://fakestoreapi.com/products",function(productresult){
		var productdata='';
		$.each(productresult,function(key,value))
		{
			productdata+='<tr>';
			productdata+='<td>' +value.id+'</td>';
			productdata+='<td>' +value.title+'</td>';
			productdata+='<td>' +value.price+'</td>';
			productdata+='<td>' +value.description+'</td>';
			productdata+='<td>' +value.category+'</td>';
			productdata+='<td>' +<img src="'+value.image+'"</td>';
			productdata+='<td>' <button>Buy</button>'</td>';
			productdata+='</tr>';
			
		});
	$('#table').append(productdata);
	})
});

</script>


<div>
<h1> e-SHOPPING</h1>

<table id='table'>

<tr>
				<th>Product Id</th>
				<th>Title</th>
				<th>Price</th>
				<th>Description</th>
				<th>Category</th>
				<th>Image</th>
</tr>
</table>
<div style="text-align: center">
<a href="https://fakestoreapi.com/products">click here to so product</a>

</div>

</div>
</body>
</html>