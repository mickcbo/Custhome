package custhome



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Ref_surface_pieceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Ref_surface_piece.list(params), model:[ref_surface_pieceInstanceCount: Ref_surface_piece.count()]
    }

    def show(Ref_surface_piece ref_surface_pieceInstance) {
        respond ref_surface_pieceInstance
    }

    def create() {
        respond new Ref_surface_piece(params)
    }

    @Transactional
    def save(Ref_surface_piece ref_surface_pieceInstance) {
        if (ref_surface_pieceInstance == null) {
            notFound()
            return
        }

        if (ref_surface_pieceInstance.hasErrors()) {
            respond ref_surface_pieceInstance.errors, view:'create'
            return
        }

        ref_surface_pieceInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ref_surface_pieceInstance.label', default: 'Ref_surface_piece'), ref_surface_pieceInstance.id])
                redirect ref_surface_pieceInstance
            }
            '*' { respond ref_surface_pieceInstance, [status: CREATED] }
        }
    }

    def edit(Ref_surface_piece ref_surface_pieceInstance) {
        respond ref_surface_pieceInstance
    }

    @Transactional
    def update(Ref_surface_piece ref_surface_pieceInstance) {
        if (ref_surface_pieceInstance == null) {
            notFound()
            return
        }

        if (ref_surface_pieceInstance.hasErrors()) {
            respond ref_surface_pieceInstance.errors, view:'edit'
            return
        }

        ref_surface_pieceInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Ref_surface_piece.label', default: 'Ref_surface_piece'), ref_surface_pieceInstance.id])
                redirect ref_surface_pieceInstance
            }
            '*'{ respond ref_surface_pieceInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Ref_surface_piece ref_surface_pieceInstance) {

        if (ref_surface_pieceInstance == null) {
            notFound()
            return
        }

        ref_surface_pieceInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Ref_surface_piece.label', default: 'Ref_surface_piece'), ref_surface_pieceInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ref_surface_pieceInstance.label', default: 'Ref_surface_piece'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
