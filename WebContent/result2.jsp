<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>States</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty state}">

			<div id="nav">
				<ul>
					<li><a href="index.html">Home</a></li>
					<li><a href="#">Search</a>
						<ul>
							<li><a href="/States/nameForm.html">By Name</a></li>
							<li><a href="/States/abbrevForm.html">By Abbreviation</a></li>
							<li><a href="/States/newState.html">Add your own state</a></li>
						</ul>
					</li>
					<li ><a id="hp" href="http://www.ARMoreira.com">Back to Main</a></li>
				</ul>
			</div>

			<form action="navigate.do" method="GET">
			<div class="button big-btn prev"><button name="previous">Previous</button></div>
			<div class="button big-btn next"><button name="next">Next</button></div>
			</form>
			<ul id="results">
					${state.number}
					<li><h1>State: ${state.name}</h1></li>
					<li><h3>Abbr: ${state.abbreviation}</h3></li>
					<li><img id="flag" src="${state.flag}" alt="State Flag"></li>
					<li><h3>Capital: ${state.capital}</h3></li>
					<li><h3>Population of: ${state.population}</h3></li>
					
			</ul>
			<div id="map">
				<script type="text/javascript"
					src="http://maps.google.com/maps/api/js?sensor=false"></script>
				<div style="overflow: auto; height: 400px; width: 500px;">
					<div id="gmap_canvas" style="height: 400px; width: 500px;">
						<style>
						#gmap_canvas img {
							max-width: none !important;
							background: none !important
						}
						</style>
					</div>
				</div>
				<script type="text/javascript">
				function init_map()
				{var myOptions = {zoom:7,center:new google.maps.LatLng(${state.latitude},${state.longitude}),mapTypeId: google.maps.MapTypeId.ROADMAP};
				map = new google.maps.Map(document.getElementById("gmap_canvas"), myOptions);
				marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(${state.latitude},${state.longitude})});
				infowindow.open(map,marker);}google.maps.event.addDomListener(window, 'load', init_map);
				</script>
			</div>
			
		</c:when>
		<c:otherwise>
		No state found
	</c:otherwise>
	</c:choose>

	<br />
</body>
</html>