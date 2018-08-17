<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content=" projet JEE 2018 ">
<meta name="author" content="KAMGO Martin, DIALLO">
<link rel="icon" href="">

<title>ProjetJEE 2018 donation</title>

<!-- core CSS -->
<link href="/ProjetJEE2017_2bis-donation/VUE/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<!-- ICONE -->
<link rel="stylesheet"
	href="/ProjetJEE2017_2bis-donation/VUE/assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/ProjetJEE2017_2bis-donation/VUE/assets/css/form-elements.css">
<!--  CSS PROJECT -->
<link rel="stylesheet" href="/ProjetJEE2017_2bis-donation/VUE/assets/css/style.css">
<!-- THEME LUMEN -->
<link rel="stylesheet"
	href="/ProjetJEE2017_2bis-donation/VUE/bootstrap/css/lumen.css">
<!-- TEMPLATE COMMENTS -->
<link href="/ProjetJEE2017_2bis-donation/VUE/css/comment.css" rel="stylesheet">
</head>

<body>
	<c:set var="context" value="${pageContext.request.contextPath}" /> 
	<c:import url="include/navbar1.jsp" />

	<!-- MODAL LOGIN -->
	<div class="modal fade" id="modal-login" tabindex="-1" role="dialog"
		aria-labelledby="modal-login-label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Quitter</span>
					</button>
					<h3 class="modal-title" id="modal-login-label">Connexion au
						site</h3>
					<p>Entrez votre pseudo et votre mot de passe pour vous
						connecter:</p>
				</div>

				<div class="modal-body">
					<form role="form" action="${context}/login" method="POST"
						class="login-form">
						<div class="form-group">
							<label class="sr-only" for="pseudo">Pseudo</label> <input
								type="text" name="pseudo" placeholder="Pseudo..."
								class="form-username form-control" id="pseudo">
						</div>
						<div class="form-group">
							<label class="sr-only" for="motdepasse">Mot de passe</label> <input
								type="password" name="motdepasse" placeholder="Mot de passe..."
								class="form-password form-control" id="motdepasse">
						</div>
						<button type="submit" class="btn1">Se connecter</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- MODAL REGISTER-->
	<div class="modal fade" id="modal-register" tabindex="-1" role="dialog"
		aria-labelledby="modal-register-label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Quitter</span>
					</button>
					<h3 class="modal-title" id="modal-register-label">Enregistrez-vous
						maintenant</h3>
					<p>Remplissez les champs suivants:</p>
				</div>
				<div class="modal-body">
					<form role="form" action="${context}/register" method="post"
						class="registration-form">
						<div class="form-group">
							<label class="sr-only" for="form-username">Pseudo</label> <input
								type="text" name="form-username" placeholder="Pseudo..."
								class="form-username form-control" id="form-username">
						</div>
						<div class="form-group">
							<label class="sr-only" for="form-password-register">Mot
								de passe</label> <input type="password" name="form-password-register"
								placeholder="Mot de passe..."
								class="form-password-register form-control"
								id="form-password-register">
						</div>
						<div class="form-group">
							<label class="sr-only" for="form-last-name">Nom</label> <input
								type="text" name="form-last-name" placeholder="Nom..."
								class="form-last-name form-control" id="form-last-name">
						</div>
						<div class="form-group">
							<label class="sr-only" for="form-first-name">Pr�nom</label> <input
								type="text" name="form-first-name" placeholder="Pr�nom..."
								class="form-first-name form-control" id="form-first-name">
						</div>
						<div class="form-group">
							<label class="sr-only" for="form-email">Email</label> <input
								type="text" name="form-email" placeholder="Email..."
								class="form-email form-control" id="form-email">
						</div>
						<button type="submit" class="btn1">S'enregistrer</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- row -->
	<div class="jumbotron" id="body-text">
		<div class="container">
			<div id="welcome">
				<h1>Bienvenu(e) sur notre site de donation !</h1>
				<img class="img-responsive img-rounded"
					src="https://images.wallpaperscraft.com/image/woman_child_sleep_peace_background_54090_1680x1050.jpg"
					alt="img welcome">
			</div>
		</div>
	</div>

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
								<h2>Bienvenu(e) sur notre site de donation</h2>
								<span>Choisissez la sous-cat�gorie que vous souhaitez.</span>
							</div>
						</div>

						<div class="ibox-content forum-container">
							<div class="forum-title" id="total-sub-categorie">
								<div class="pull-right forum-desc">
									<small>Total de sous-cat�gorie:
										${listSousCategorie.size()}</small>
								</div>
								<h3>Article</h3>
							</div>
							<c:forEach items="${listSousCategorie}" var="sousCategorie">
								<div class="forum-item active" id="elem-sub-categorie">
									<div class="row">
										<div class="col-md-9">
											<div class="forum-icon">
												<i class="${sousCategorie.getID()}"></i>
											</div>
											<a
												href="${context}/displaysubjects?nomSousCategorie=${sousCategorie.getTitre()}"
												class="forum-item-title" id="btn-sub-categories"
												onclick="$('#total-sub-categorie').hide()">${sousCategorie.getTitre()}</a>
											<div class="forum-sub-title">Parlez de ${sousCategorie.getTitre()} avec les personnes int�ress�es !</div>
										</div>
										<div class="col-md-1 forum-info">
											<span class="views-number"> 1216 </span>
											<div>
												<small>Vues</small>
											</div>
										</div>
										<div class="col-md-1 forum-info">
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

	<!-- AFFICHAGE DES Articles -->
	<div class="jumbotron" id="subject">
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
								<h2 id="nom-sous-categorie"></h2>
								<span>Choisissez l'article que vous souhaitez consulter.</span>
							</div>
						</div>

						<div class="ibox-content forum-container">
							<div class="forum-title" id="total-sub-categorie">
								<div class="pull-right forum-desc">
									<!--  count du nombre de sujet dans cette sous cat -->
									<small>Total posts: ${listeSujets.size()}</small>

									<!-- Seul une personne connect�e peut ajouter un sujet -->
									<c:if test="${not empty utilisateur}">
										<a id="add-subject" class=" launch-modal" href="#"
											data-modal-id="modal-subject">Nouveau <i
											class="fa fa-plus-square-o fa-2x"></i>
										</a>
									</c:if>
								</div>
							</div>

							<c:forEach items="${listeSujets}" var="sujet" varStatus="loop">
								<div class="forum-item active" id="elem-sujet">
									<div class="row">
										<div class="col-md-9">
											<div class="forum-icon">
												<input type="hidden" id="sous-categorie-hidden"
													value="${sujet.getSousCategorie().getTitre()}"> 
												<i
													class=" ${sujet.getSousCategorie().getIcone()}"></i>
											</div>
											<!-- titre de article avec un href -->
											<a
												href="${context}/displaycomments?nomSujet=${sujet.getTitre()}&nomSousCategorie=${sujet.getSousCategorie().getTitre()}&pseudoAuteur=${sujet.getUtilisateur().getPseudo()}&dateSujet=${sujet.getDateSujet()}"
												id="titre-sujet" class="forum-item-title"
												title="${sujet.getTitre()}">${sujet.getTitre()}</a>

											<div id="description-sujet" class="forum-sub-title">Si
												ce sujet vous int�resse, cliquez dessus!.</div>
										</div>
										<div id="description-auteur-sujet">
											<div class="col-md-1 forum-info">
												<span class="views-number">    .    </span>
												<div>
													<small>   .   </small>
												</div>
											</div>
											<div class="col-md-1 forum-info">
												<span class="views-number">${sujet.getDateSujet()}</span>
												<div>
													<small>Date</small>
												</div>
											</div>
											<div class="col-md-1 forum-info">
												<span class="views-number">${sujet.getUtilisateur().getPseudo()}</span>
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
					<!-- wrapper wrapper-content animated fadeInRight -->
				</div>
				<!-- col-lg-12 -->
			</div>
			<!-- row -->
		</div>
	</div>

	<!-- Affichage des commentaires -->
	<div class="jumbotron" id="comments">
		<div class="container">
			<c:forEach items="${listeCommentaire}" var="commentaire">
				<section class="container" id="elem-comment">
					<section class="row clearfix">
						<section class="col-md-12 column">
							<div class="row clearfix">
								<div class="col-md-12 column">
									<div class="panel panel-default">
										<div class="panel-heading">
											<section class="panel-title">
												<time class="pull-right">
													<i class="fa fa-calendar"></i>
													<div id="date-creation-sujet">
														${commentaire.getSujet().getDateSujet()}</div>
												</time>
												<section class="pull-left" id="id">
													<abbr title="id of the comment">${commentaire.getID()}</abbr>
												</section>
											</section>
										</div>
										<section class="row panel-body">
											<section class="col-md-9">
												<h2 id="nom-sujet">${commentaire.getSujet().getTitre()}</h2>
												<hr>
												${commentaire.getTexte()}
											</section>
											<section id="user-description" class="col-md-3 ">
												<section class="well">
													<div class="dropdown">
														<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
															class="fa fa-circle"></i>${commentaire.getUtilisateur().getPseudo()}<span
															class="caret"></span></a>
													</div>
													<figure>
														<img class="img-rounded img-responsive"
															src="http://mirya.clanweb.eu/infusions/last_seen_users_panel/images/noAvatar.png"
															alt="${commentaire.getUtilisateur().getPseudo()}'s avatar">
														<figcaption class="text-center">
															<br> <i class="fa fa-star"></i> <i
																class="fa fa-star"></i> <i class="fa fa-star"></i> <i
																class="fa fa-star"></i> <i class="fa fa-star-half"></i>
														</figcaption>
													</figure>
													<dl class="dl-horizontal">
														<dt>Type:</dt>
														<dd>${commentaire.getUtilisateur().getType()}</dd>
													</dl>
												</section>
											</section>
										</section>
										<div class="panel-footer" id="panelfooter">
											<div class="row">
												<section class="col-md-2 "></section>
												<section class="col-md-6">
													<small><a href="#" data-toggle="tooltip" title="">
													</a> </small> <br>
												</section>

												<!-- La personne connect�e ne pourra modifier que ses posts -->
												<!-- Si c'est un admin il peut tout modifier et supprimer -->
												<c:choose>
													<c:when
														test="${commentaire.getUtilisateur().getPseudo() == utilisateur.getPseudo() || utilisateur.getType() == 'Admin'}">
														<section>
															<a href="#" class="btn btn-primary launch-modal"
																id="edit" href="#"
																data-modal-id="modal-modify-${commentaire.getID()}">
																Modifier <i class="fa fa-edit"></i>
															</a> <a href="#" class="btn btn-primary launch-modal"
																id="delete" href="#"
																data-modal-id="modal-delete-${commentaire.getID()}">
																Supprimer <i class="fa fa-trash-o"></i>
															</a>
														</section>
													</c:when>
												</c:choose>
											</div>
										</div>
									</div>
								</div>
							</div>
						</section>
					</section>
				</section>

				<!-- MODAL MODIFY COMMENTAIRE -->
				<div class="modal fade" id="modal-modify-${commentaire.getID()}"
					tabindex="-1" role="dialog" aria-labelledby="modal-modify-label"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Quitter</span>
								</button>
								<h3 class="modal-title" id="modal-modify-label">Modifier un
									commentaire</h3>
								<p>Veuillez entrer le commentaire que vous voulez modifier:</p>
							</div>

							<div class="modal-body">
								<form role="form" action="${context}/modifycomment"
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
				<div class="modal fade" id="modal-delete-${commentaire.getID()}"
					tabindex="-1" role="dialog" aria-labelledby="modal-modify-label"
					aria-hidden="true">
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

			</c:forEach>
			<a class="btn btn-primary launch-modal" href="#"
				data-modal-id="modal-comment" id="reply">R�pondre <i
				class="fa fa-mail-reply "></i></a>
		</div>
	</div>

	<!-- MODAL ADD COMMENT -->
	<div class="modal fade" id="modal-comment" tabindex="-1" role="dialog"
		aria-labelledby="modal-comment-label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Quitter</span>
					</button>
					<h3 class="modal-title" id="modal-comment-label">Ajouter un
						commentaire</h3>
					<p>Veuillez entrer le commentaire que vous voulez ajouter:</p>
				</div>

				<div class="modal-body">
					<form role="form" action="${context}/addComment" method="POST"
						class="comment-form">
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
			</div>
		</div>
	</div>

	<!-- MODAL PROFILE-->
	<div class="modal fade" id="modal-profile" tabindex="-1" role="dialog"
		aria-labelledby="modal-profile-label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Quitter</span>
					</button>
					<h3 class="modal-title" id="modal-profile-label">Votre profil</h3>
				</div>
				<div class="modal-body">
					<div class="div-pseudo">
						<strong>Pseudo</strong>
						<p id="pseudo">${sessionScope.utilisateur.getPseudo()}</p>
					</div>
					<div class="div-nom">
						<strong>Nom</strong>
						<p id="nom">${sessionScope.utilisateur.getNom()}</p>
					</div>
					<div class="div-prenom">
						<strong>Pr�nom</strong>
						<p id="prenom">${sessionScope.utilisateur.getPrenom()}</p>
					</div>
					<div class="div-email">
						<strong>Email</strong>
						<p id="email">${sessionScope.utilisateur.getMail()}</p>
					</div>
					<div class="div-type">
						<strong>Type</strong>
						<p id="type">${sessionScope.utilisateur.getType()}</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- MODAL ADD ARTICLE -->
	<div class="modal fade" id="modal-subject" tabindex="-1" role="dialog"
		aria-labelledby="modal-subject-label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Quitter</span>
					</button>
					<h3 class="modal-title" id="modal-subject-label">Ajouter un
						Article</h3>
					<p>Veuillez entrer le titre de l'article � ajouter:</p>
				</div>

				<div class="modal-body">
					<form role="form" action="${context}/addsubject" method="POST"
						class="subject-form">
						<div class="form-group">
							<input type="hidden" name="form-hidden-souscat"
								id="form-hidden-souscat"></input> <label class="sr-only"
								for="form-comment" id="form-souscat"></label>
							<textarea name="form-subject-title" placeholder="Votre titre..."
								class="form-subject form-control" id="form-subject-title"
								rows="1"></textarea>
							<textarea name="form-subject-comment"
								placeholder="Votre commentaire..."
								class="form-subject form-control" id="form-subject-comment"></textarea>
						</div>
						<button type="submit" class="btn1">Confirmer</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Fin affichage des commentaires -->

	<hr>

	<c:import url="include/footer.jsp" />
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="/ProjetJEE2017_2bis-donation/VUE/bootstrap/js/bootstrap.min.js"></script>
	<script src="/ProjetJEE2017_2bis-donation/VUE/assets/js/jquery.backstretch.min.js"></script>
	<script src="/ProjetJEE2017_2bis-donation/VUE/js/scripts.js"></script>
</body>
</html>