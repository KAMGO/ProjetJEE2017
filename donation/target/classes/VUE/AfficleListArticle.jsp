<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>liste articles et ajout article</title>
</head>
<body>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<%@ include file="menu.jsp" %>
	<div class="jumbotron" id="subject">
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="wrapper">
						<div class="ibox">
							<div class="p-xs">
								<h2 id="nom-sous-categorie"></h2>
								<span>Choisissez l'article que vous souhaitez consulter.</span>
							</div>
						</div>

						<div class="ibox">
							<div class="article-title" id="total-sub-categorie">
								<div class="pull-right article-desc">
									<!--  count du nombre de d'article dans cette sous cat -->
									<small>Total posts: ${listeArticles.size()}</small>
								</div>
							</div>

							<c:forEach items="${listeArticles}" var="article">
								<div class="don-item active" id="elem-article">
									<div class="row">
										<div class="col-md-9">
											<div class="don-icon">
												<input type="hidden" id="sous-categorie-hidden"
													value="${article.getSousCategorie().getTitre()}"> 
											</div>
											<!-- titre de article avec un href -->
											<a
												href="${context}/afficheCommentaire?nomArticle=${article.getTitre()}&nomSousCategorie=${article.getSousCategorie().getTitre()}&pseudoDonateur=${article.getUtilisateur().getPseudo()}&dateArticle=${article.getDateArticle()}"
												id="titre-article" class="don-item-title"
												title="${article.getTitre()}">${article.getTitre()}</a>

											<div id="description-article" class="don-sub-title">Si
												cet Article t'intéresse, cliquez dessus!.</div>
										</div>
										<div id="description-donateur-article">
											<div class="col-md-1 don-info">
												<span class="views-number">${article.getDateArticle()}</span>
											</div>
											<div class="col-md-1 don-info">
												<span class="views-number">${article.getUtilisateur().getPseudo()}</span>
												<div>
													<small>donateur</small>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<!-- row -->
		</div>
	</div>
	<fieldset>
	<legend>Ajouter un article</legend>
			<div class="modal fade" id="modal-article" >
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<p>Veuillez entrer le titre de l'article à ajouter:</p>
					</div>
	
					<div class="modal-body">
						<form method="POST" action="${context}/ajouterArticle">
							<div class="form-group">
								<input type="hidden" name="form-hidden-souscat"
									id="form-hidden-souscat" value="${maSousCategorie}">
									 <label class="sr-only"
									for="form-comment" id="form-souscat"></label>
								<textarea name="form-Article-title" placeholder="Votre titre..."
									class="form-Article form-control" id="form-subject-title"
									rows="1"></textarea>
								<textarea name="form-Article-comment"
									placeholder="Votre commentaire..." id="form-Article-comment"></textarea>
							</div>
							<button type="submit" class="btn1">Confirmer</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</fieldset>
<%@ include file="Footer.jsp" %>
</body>
</html>