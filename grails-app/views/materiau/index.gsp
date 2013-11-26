
<%@ page import="custhome.Materiau" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main_admin">
		<g:set var="entityName" value="${message(code: 'materiau.label', default: 'Materiau')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-materiau" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-striped">
			<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'materiau.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="nom" title="${message(code: 'materiau.nom.label', default: 'Nom')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${materiauInstanceList}" status="i" var="materiauInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${materiauInstance.id}">${fieldValue(bean: materiauInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: materiauInstance, field: "nom")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${materiauInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
