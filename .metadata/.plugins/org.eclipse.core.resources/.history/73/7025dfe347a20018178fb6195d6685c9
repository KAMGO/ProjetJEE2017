<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Liste commentaires</title>
<script type="text/javascript" src="/VUE/js/common.js"></script>
<script type="text/javascript" src="/VUE/js/script.js"></script>
</head>
<body>

<div class="jumbotron" id="commentaire">
			<c:forEach items="${listeCommentaire}" var="commentaire">
				<div class="container" id="elem-commentaire">
					<div class="row clearfix">
						<div class="col-md-12 column">
							<div class="row clearfix">
								<div class="col-md-12 column">
									<div class="panel panel-default">
										<div class="panel-heading">
											<div class="panel-title">
												<time class="pull-right">
													<i class="fa fa-calendar"></i>
													<div id="date-creati">
														${commentaire.getArticle().getDateArticle()}
													</div>
												</time>
												<div class="pull-left" id="id">
													<abbr title="id of the commentaire">${commentaire.getID()}</abbr>
												</div>
											</div>
										</div>
										<div class="row panel-body">
											<div class="col-md-9">
												<h2 id="nom-Article">${commentaire.getArticle().getTitre()}</h2>
												<hr>
												${commentaire.getTexte()}
											</div>
											<div id="user-description" class="col-md-3 ">
												<div class="well">
													<div class="dropdown">
														<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
															class="fa fa-circle"></i>${commentaire.getUtilisateur().getPseudo()}<span
															class="caret"></span></a>
													</div>
													<p>
														<dt>Statut :</dt>
														<dd>${commentaire.getUtilisateur().getStatut()}</dd>
													</p>
												</div>
											</div>
										</div>
										<div class="panel-footer" id="panelfooter">
											<div class="row">

												<!-- La personne connectée ne pourra modifier que ses publications -->
												<!-- Si c'est un admin il peut tout modifier et supprimer -->
												<c:choose>
													<c:when
														test="${commentaire.getUtilisateur().getPseudo() == utilisateur.getPseudo() || utilisateur.getStatut() == 'Admin'}">
														<div>
															<button type="button" id="afficheModif" valeur="Modifier">Modifier</button>  
										                  
															<button type="button" id="afficheSuppr" valeur="supprimer">supprimer</button>
														</div>
													</c:when>
												</c:choose>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
	<!-- MODAL MODIFY COMMENTAIRE -->
													<!-- celui qui a publier peut modifier ou suprimer son commentaire -->
												<!-- l'administrateur peut tout modifier et supprimer -->
		<c:if test="${commentaire.getUtilisateur().getPseudo() == utilisateur.getPseudo() || utilisateur.getStatut() == 'Admin' }">
				<div class="modal fade" id="modifierComm">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" >
									<span aria-hidden="true">&times;</span><span class="sr-only">Quitter</span>
								</button>
								<h3 class="modal-title" id="modif_commentaite">Modifier un
									commentaire</h3>
								<p>Veuillez entrer le commentaire que vous voulez modifier:</p>
							</div>

							<div class="modal-body">
								<form action="${context}/modifycomment"
									method="POST" class="modify-form">
									<input type="hidden" name="id-commentaire-hidden"
										id="id-commentaire-hidden" value="${commentaire.getID()}"></input>
									<div class="form-group">
										<label class="sr-only" for="form-modify">Commentaire</label>
										<textarea name="form-modify"
											placeholder="Votre commentaire..."
											class="form-modify form-control" id="form-modify">${commentaire.getTexte()}</textarea>
									</div>
									<button type="submit" class="btn1">Confirmer</button>
								</form>
							</div>
						</div>
					</div>
				</div>

				<!-- MODAL DELETE COMMENTAIRE -->
				<div class="modal fade" id="supprimerComm">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Quitter</span>
								</button>
								<h3 class="modal-title" id="modal-modify-label">Voulez-vous
									supprimer ce commentaire?</h3>
							</div>

							<div class="modal-body">
								<form role="form" action="${context}/deletecomment"
									method="POST" class="modify-form">
									<input type="hidden" name="id-commentaire-hidden"
										id="id-commentaire-hidden" value="${commentaire.getID()}"></input>
									<div class="form-group">
										<label class="sr-only" for="form-modify">Commentaire</label>
										<textarea name="form-modify" class="form-modify form-control"
											id="form-modify" readonly>${commentaire.getTexte()}</textarea>
									</div>
									<button type="submit" class="btn1">Supprimer</button>
								</form>
							</div>
						</div>
					</div>
				</div>
		</c:if>
	</c:forEach>
</div>
<fieldset>
<legend><h2>ajouter un commentaire </h2></legend>
			<div class="modal-content">
				<div class="modal-header">
					<p>Veuillez entrer le commentaire que vous voulez ajouter:</p>
				</div>
					<form role="form" action="${context}/ajouterCommentaire" method="POST">
						<div class="form-group">
							<label class="sr-only" for="form-comment">Commentaire</label> <label
								class="form-comment form-control" id="nom-sujet-label">nom</label>
							<label class="form-comment form-control" id="date-sujet-label">date</label>

							<input type="hidden" name="nom-sujet-hidden"
								id="nom-sujet-hidden" value="xxx"></input> <input type="hidden"
								name="date-sujet-hidden" id="date-sujet-hidden" value="xxx"></input>
							<textarea name="form-comment" placeholder="Votre commentaire..."
								class="form-comment form-control" id="form-comment"></textarea>
						</div>
						<button type="submit" class="btn1">Confirmer</button>
					</form>
				</div>
</fieldset>
</body>
</html>