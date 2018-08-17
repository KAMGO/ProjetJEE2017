<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
	<div class="jumbotron" id="sub-categorie">
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- col-lg-12 -->
				<div class="col-lg-12">
					<!-- wrapper wrapper-content animated fadeInRight -->
					<div class="wrapper wrapper-content animated fadeInRight">
						<!-- ibox-content m-b-sm border-bottom -->
						<div class="ibox-content m-b-sm border-bottom">
							<div class="p-xs">
								<div class="pull-left m-r-md">
									<i class="fa fa-globe text-navy mid-icon"></i>
								</div>
								<h2>liste sous categorie</h2>
								<span>Choisissez la sous-catégorie que vous souhaitez.</span>
							</div>
						</div>

						<div class="ibox-content don-container">
							<div class="don-title" id="total-sub-categorie">
								<div class="pull-right don-desc">
									<small>Total de sous-catégorie:
										${listSousCategorie.size()}</small>
								</div>
								<h3>Sous Categories</h3>
							</div>
							<c:forEach items="${listSousCategorie}" var="sousCategorie">
								<div class="don-item active" id="elem-sub-categorie">
									<div class="row">
										<div class="col-md-9">
											<div class="don-icon">
												<i class="${sousCategorie.getID()}"></i>
											</div>
											<a
												href="${context}/affichearticles?maSousCategorie=${sousCategorie.getTitre()}"
												class="don-item-title" id="btn-sub-categories"
												onclick="$('#total-sub-categorie').hide()">${sousCategorie.getTitre()}</a>
											<div class="don-sub-title"> ${sousCategorie.getTitre()} vous  intéresse ?</div>
										</div>
										<div class="col-md-1 don-info">
											<span class="views-number"> 1216 </span>
											<div>
												<small>Vues</small>
											</div>
										</div>
										<div class="col-md-1 don-info">
											<span class="views-number"> 140 </span>
											<div>
												<small>Commentaires</small>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<!-- wrapper wrapper-content animated fadeInRight -->
				</div>
				<!-- col-lg-12 -->
			</div>
		</div>
	</div>
<%@ include file="Footer.jsp" %>
</body>
</html>