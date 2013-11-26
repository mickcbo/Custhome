<%@ page import="custhome.Ref_surface_piece" %>



<div class="fieldcontain ${hasErrors(bean: ref_surface_pieceInstance, field: 'couleur', 'error')} required">
	<label for="couleur">
		<g:message code="ref_surface_piece.couleur.label" default="Couleur" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="couleur" name="couleur.id" from="${custhome.Couleur.list()}" optionKey="id" required="" value="${ref_surface_pieceInstance?.couleur?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ref_surface_pieceInstance, field: 'materiaux', 'error')} required">
	<label for="materiaux">
		<g:message code="ref_surface_piece.materiaux.label" default="Materiaux" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="materiaux" name="materiaux.id" from="${custhome.Materiau.list()}" optionKey="id" required="" value="${ref_surface_pieceInstance?.materiaux?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ref_surface_pieceInstance, field: 'piece', 'error')} required">
	<label for="piece">
		<g:message code="ref_surface_piece.piece.label" default="Piece" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="piece" name="piece.id" from="${custhome.Piece.list()}" optionKey="id" required="" value="${ref_surface_pieceInstance?.piece?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ref_surface_pieceInstance, field: 'surface', 'error')} required">
	<label for="surface">
		<g:message code="ref_surface_piece.surface.label" default="Surface" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="surface" name="surface.id" from="${custhome.Surface.list()}" optionKey="id" required="" value="${ref_surface_pieceInstance?.surface?.id}" class="many-to-one"/>
</div>

