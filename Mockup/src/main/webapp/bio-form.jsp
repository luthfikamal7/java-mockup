
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
				<a href="https://www.xadmin.net" class="navbar-brand"> Biodata Karyawan </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Biodata</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${bio != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${bio == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${bio != null}">
            			Edit User
            		</c:if>
						<c:if test="${bio == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${bio != null}">
					<input type="hidden" name="id" value="<c:out value='${bio.id}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>User ID</label> <input type="text"
						value="<c:out value='${bio.userId}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Nama</label> <input type="text"
						value="<c:out value='${bio.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Posisi</label> <input type="text"
						value="<c:out value='${bio.posisi}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>No Ktp</label> <input type="text"
						value="<c:out value='${bio.noktp}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Tempat/Tanggal Lahir</label> <input type="text"
						value="<c:out value='${bio.ttl}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Jenis Kelamin</label> <input type="text"
						value="<c:out value='${bio.gender}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Agama</label> <input type="text"
						value="<c:out value='${bio.agama}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Golongan Darah</label> <input type="text"
						value="<c:out value='${bio.golDarah}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Status</label> <input type="text"
						value="<c:out value='${bio.status}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Alamat Ktp</label> <input type="text"
						value="<c:out value='${bio.alamatKtp}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Alamat Tinggal</label> <input type="text"
						value="<c:out value='${bio.alamatTinggal}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${bio.email}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>No HP</label> <input type="text"
						value="<c:out value='${bio.nohp}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Orang Terdekat</label> <input type="text"
						value="<c:out value='${bio.orgTerdekat}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>