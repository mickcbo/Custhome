
<%@ page import="custhome.Surface" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main_admin">
		<g:set var="entityName" value="${message(code: 'surface.label', default: 'Surface')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-surface" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-striped">
			<thead>
					<tr>
					
						<g:sortableColumn property="nom" title="${message(code: 'surface.nom.label', default: 'Nom')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'surface.description.label', default: 'Description')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${surfaceInstanceList}" status="i" var="surfaceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="edit" id="${surfaceInstance.id}">${fieldValue(bean: surfaceInstance, field: "nom")}</g:link></td>
					
						<td>${fieldValue(bean: surfaceInstance, field: "description")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${surfaceInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
