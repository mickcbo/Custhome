<%@ page import="custhome.Piece" %>



<div class="fieldcontain ${hasErrors(bean: pieceInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="piece.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${pieceInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pieceInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="piece.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${pieceInstance?.nom}"/>
</div>

