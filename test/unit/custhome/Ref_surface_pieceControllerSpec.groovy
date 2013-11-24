package custhome



import grails.test.mixin.*
import spock.lang.*

@TestFor(Ref_surface_pieceController)
@Mock(Ref_surface_piece)
class Ref_surface_pieceControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.ref_surface_pieceInstanceList
            model.ref_surface_pieceInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.ref_surface_pieceInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def ref_surface_piece = new Ref_surface_piece()
            ref_surface_piece.validate()
            controller.save(ref_surface_piece)

        then:"The create view is rendered again with the correct model"
            model.ref_surface_pieceInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            ref_surface_piece = new Ref_surface_piece(params)

            controller.save(ref_surface_piece)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/ref_surface_piece/show/1'
            controller.flash.message != null
            Ref_surface_piece.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def ref_surface_piece = new Ref_surface_piece(params)
            controller.show(ref_surface_piece)

        then:"A model is populated containing the domain instance"
            model.ref_surface_pieceInstance == ref_surface_piece
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def ref_surface_piece = new Ref_surface_piece(params)
            controller.edit(ref_surface_piece)

        then:"A model is populated containing the domain instance"
            model.ref_surface_pieceInstance == ref_surface_piece
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/ref_surface_piece/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def ref_surface_piece = new Ref_surface_piece()
            ref_surface_piece.validate()
            controller.update(ref_surface_piece)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.ref_surface_pieceInstance == ref_surface_piece

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            ref_surface_piece = new Ref_surface_piece(params).save(flush: true)
            controller.update(ref_surface_piece)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/ref_surface_piece/show/$ref_surface_piece.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/ref_surface_piece/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def ref_surface_piece = new Ref_surface_piece(params).save(flush: true)

        then:"It exists"
            Ref_surface_piece.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(ref_surface_piece)

        then:"The instance is deleted"
            Ref_surface_piece.count() == 0
            response.redirectedUrl == '/ref_surface_piece/index'
            flash.message != null
    }
}
