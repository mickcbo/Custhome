<%@ page import="custhome.Couleur" %>



<div class="fieldcontain ${hasErrors(bean: couleurInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="couleur.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${couleurInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: couleurInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="couleur.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${couleurInstance?.nom}"/>
</div>

