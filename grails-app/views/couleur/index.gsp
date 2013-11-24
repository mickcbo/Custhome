
<%@ page import="custhome.Couleur" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main_admin">
		<g:set var="entityName" value="${message(code: 'couleur.label', default: 'Couleur')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
	
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-couleur" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-striped">
			<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'couleur.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="nom" title="${message(code: 'couleur.nom.label', default: 'Nom')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${couleurInstanceList}" status="i" var="couleurInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${couleurInstance.id}">${fieldValue(bean: couleurInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: couleurInstance, field: "nom")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${couleurInstanceCount ?: 0}" />
			</div>
		</div>
		
	</body>
</html>
