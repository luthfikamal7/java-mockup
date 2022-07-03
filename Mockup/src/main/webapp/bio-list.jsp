<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Mockup</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> Biodata Karyawan</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Biodata</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List Biodata</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Biodata</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>User ID</th>
						<th>Nama</th>
						<th>Posisi</th>
						<th>No KTP</th>
						<th>Tempat/Tanggal Lahir</th>
						<th>Jenis Kelamin</th>
						<th>Agama</th>
						<th>Golongan Darah</th>
						<th>Status</th>
						<th>Alamat KTP</th>
						<th>Alamat Tinggal</th>
						<th>Email</th>
						<th>No HP</th>
						<th>Orang Terdekat</th>
						<th>Actions</th>
						
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="bio" items="${listBio}">

						<tr>
							<td>${bio.id}</td>
							<td>${bio.userId}</td>
							<td>${bio.nama}</td>
							<td><c:out value="${bio.posisi}" /></td>
							<td><c:out value="${bio.noktp}" /></td>
							<td><c:out value="${bio.ttl}" /></td>
							<td><c:out value="${bio.gender}" /></td>
							<td><c:out value="${bio.agama}" /></td>
							<td><c:out value="${bio.golDarah}" /></td>
							<td><c:out value="${bio.status}" /></td>
							<td><c:out value="${bio.alamatKtp}" /></td>
							<td><c:out value="${bio.alamatTinggal}" /></td>
							<td><c:out value="${bio.email}" /></td>
							<td><c:out value="${bio.nohp}" /></td>
							<td><c:out value="${bio.orgTerdekat}" /></td>
							
							<td><a href="edit?id="${bio.id}>Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${bio.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>