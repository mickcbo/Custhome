<%@ page import="custhome.Surface" %>



<div class="fieldcontain ${hasErrors(bean: surfaceInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="surface.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${surfaceInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: surfaceInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="surface.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${surfaceInstance?.nom}"/>
</div>

