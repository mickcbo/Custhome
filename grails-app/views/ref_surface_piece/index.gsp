
<%@ page import="custhome.Ref_surface_piece" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main_user">
		<g:set var="entityName" value="${message(code: 'ref_surface_piece.label', default: 'Creation surface')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-ref_surface_piece" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-striped">
			<thead>
					<tr>
					
						<th><g:message code="ref_surface_piece.couleur.label" default="Couleur" /></th>
					
						<th><g:message code="ref_surface_piece.materiaux.label" default="Materiaux" /></th>
					
						<th><g:message code="ref_surface_piece.piece.label" default="Piece" /></th>
					
						<th><g:message code="ref_surface_piece.surface.label" default="Surface" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ref_surface_pieceInstanceList}" status="i" var="ref_surface_pieceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${ref_surface_pieceInstance.id}">${fieldValue(bean: ref_surface_pieceInstance, field: "couleur")}</g:link></td>
					
						<td>${fieldValue(bean: ref_surface_pieceInstance, field: "materiaux")}</td>
					
						<td>${fieldValue(bean: ref_surface_pieceInstance, field: "piece")}</td>
					
						<td>${fieldValue(bean: ref_surface_pieceInstance, field: "surface")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ref_surface_pieceInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
