package custhome



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PieceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Piece.list(params), model:[pieceInstanceCount: Piece.count()]
    }

    def show(Piece pieceInstance) {
        respond pieceInstance
    }

    def create() {
        respond new Piece(params)
    }

    @Transactional
    def save(Piece pieceInstance) {
        if (pieceInstance == null) {
            notFound()
            return
        }

        if (pieceInstance.hasErrors()) {
            respond pieceInstance.errors, view:'create'
            return
        }

        pieceInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pieceInstance.label', default: 'Piece'), pieceInstance.id])
                redirect pieceInstance
            }
            '*' { respond pieceInstance, [status: CREATED] }
        }
    }

    def edit(Piece pieceInstance) {
        respond pieceInstance
    }

    @Transactional
    def update(Piece pieceInstance) {
        if (pieceInstance == null) {
            notFound()
            return
        }

        if (pieceInstance.hasErrors()) {
            respond pieceInstance.errors, view:'edit'
            return
        }

        pieceInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Piece.label', default: 'Piece'), pieceInstance.id])
                redirect pieceInstance
            }
            '*'{ respond pieceInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Piece pieceInstance) {

        if (pieceInstance == null) {
            notFound()
            return
        }

        pieceInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Piece.label', default: 'Piece'), pieceInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pieceInstance.label', default: 'Piece'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
