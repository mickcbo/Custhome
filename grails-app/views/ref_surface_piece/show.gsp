
<%@ page import="custhome.Ref_surface_piece" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main_user">
		<g:set var="entityName" value="${message(code: 'ref_surface_piece.label', default: 'Creation surface')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul class="nav nav-pills">
				
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-ref_surface_piece" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list ref_surface_piece">
			
				<g:if test="${ref_surface_pieceInstance?.couleur}">
				<li class="fieldcontain">
					<span id="couleur-label" class="property-label"><g:message code="ref_surface_piece.couleur.label" default="Couleur" /></span>
					
						<span class="property-value" aria-labelledby="couleur-label"><g:link controller="couleur" action="show" id="${ref_surface_pieceInstance?.couleur?.id}">${ref_surface_pieceInstance?.couleur?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ref_surface_pieceInstance?.materiaux}">
				<li class="fieldcontain">
					<span id="materiaux-label" class="property-label"><g:message code="ref_surface_piece.materiaux.label" default="Materiaux" /></span>
					
						<span class="property-value" aria-labelledby="materiaux-label"><g:link controller="materiau" action="show" id="${ref_surface_pieceInstance?.materiaux?.id}">${ref_surface_pieceInstance?.materiaux?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ref_surface_pieceInstance?.piece}">
				<li class="fieldcontain">
					<span id="piece-label" class="property-label"><g:message code="ref_surface_piece.piece.label" default="Piece" /></span>
					
						<span class="property-value" aria-labelledby="piece-label"><g:link controller="piece" action="show" id="${ref_surface_pieceInstance?.piece?.id}">${ref_surface_pieceInstance?.piece?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ref_surface_pieceInstance?.surface}">
				<li class="fieldcontain">
					<span id="surface-label" class="property-label"><g:message code="ref_surface_piece.surface.label" default="Surface" /></span>
					
						<span class="property-value" aria-labelledby="surface-label"><g:link controller="surface" action="show" id="${ref_surface_pieceInstance?.surface?.id}">${ref_surface_pieceInstance?.surface?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:ref_surface_pieceInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${ref_surface_pieceInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
