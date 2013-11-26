<%@ page import="custhome.Materiau" %>



<div class="fieldcontain ${hasErrors(bean: materiauInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="materiau.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${materiauInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: materiauInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="materiau.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${materiauInstance?.nom}"/>
</div>

