package custhome



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CouleurController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Couleur.list(params), model:[couleurInstanceCount: Couleur.count()]
    }

    def show(Couleur couleurInstance) {
        respond couleurInstance
    }

    def create() {
        respond new Couleur(params)
    }

    @Transactional
    def save(Couleur couleurInstance) {
        if (couleurInstance == null) {
            notFound()
            return
        }

        if (couleurInstance.hasErrors()) {
            respond couleurInstance.errors, view:'create'
            return
        }

        couleurInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'couleurInstance.label', default: 'Couleur'), couleurInstance.id])
                redirect couleurInstance
            }
            '*' { respond couleurInstance, [status: CREATED] }
        }
    }

    def edit(Couleur couleurInstance) {
        respond couleurInstance
    }

    @Transactional
    def update(Couleur couleurInstance) {
        if (couleurInstance == null) {
            notFound()
            return
        }

        if (couleurInstance.hasErrors()) {
            respond couleurInstance.errors, view:'edit'
            return
        }

        couleurInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Couleur.label', default: 'Couleur'), couleurInstance.id])
                redirect couleurInstance
            }
            '*'{ respond couleurInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Couleur couleurInstance) {

        if (couleurInstance == null) {
            notFound()
            return
        }

        couleurInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Couleur.label', default: 'Couleur'), couleurInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'couleurInstance.label', default: 'Couleur'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
