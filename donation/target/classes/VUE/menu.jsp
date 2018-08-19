<div class="navbar ">
    <div class="container">
    	<c:set var="context" value="${pageContext.request.contextPath}"/>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
            	<li><a href="${context}/accueil">Accueil</a></li> 
            	<c:if test="${!empty sessionScope.utilisateur}">
            		<!-- grâce à cet import, je récupère les listes pour afficher la navbar -->
				<c:import url="/affichercategories" />
			
				<ul class="nav navbar-nav">
				<c:forEach items="${listCategorie}" var="categorie">
					<li><a
						href="${context}/affichersouscategories?nomCategorie=${categorie.getTitre()}">${categorie.getTitre()}</a></li>
				</c:forEach>
				</ul>
                </c:if>
            </ul>
			<!-- si l'utilisateur est deja connecte cette partie est cachee--> 
            <ul class="nav navbar-nav navbar-right">
            	<c:if test="${empty sessionScope.utilisateur}">
            	<li><a href="/donation/VUE/Connexion.jsp"><span class="glyphicon glyphicon-log-in"></span>Connexion</a></li>
               	<li><a href="/donation/VUE/inscription.jsp"><span class="glyphicon glyphicon-user"></span>Inscription</a></li>
    	        </c:if>
    	        <c:if test="${!empty sessionScope.utilisateur}">
	           	<li><a href="${context}/deconnexion"><span class="glyphicon glyphicon-log-out"></span>Deconnexion</a></li>
	           	</c:if>
            </ul>
            
        </div>
    </div>
</div>