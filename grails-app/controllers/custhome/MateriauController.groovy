package custhome



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MateriauController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Materiau.list(params), model:[materiauInstanceCount: Materiau.count()]
    }

    def show(Materiau materiauInstance) {
        respond materiauInstance
    }

    def create() {
        respond new Materiau(params)
    }

    @Transactional
    def save(Materiau materiauInstance) {
        if (materiauInstance == null) {
            notFound()
            return
        }

        if (materiauInstance.hasErrors()) {
            respond materiauInstance.errors, view:'create'
            return
        }

        materiauInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'materiauInstance.label', default: 'Materiau'), materiauInstance.id])
                redirect materiauInstance
            }
            '*' { respond materiauInstance, [status: CREATED] }
        }
    }

    def edit(Materiau materiauInstance) {
        respond materiauInstance
    }

    @Transactional
    def update(Materiau materiauInstance) {
        if (materiauInstance == null) {
            notFound()
            return
        }

        if (materiauInstance.hasErrors()) {
            respond materiauInstance.errors, view:'edit'
            return
        }

        materiauInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Materiau.label', default: 'Materiau'), materiauInstance.id])
                redirect materiauInstance
            }
            '*'{ respond materiauInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Materiau materiauInstance) {

        if (materiauInstance == null) {
            notFound()
            return
        }

        materiauInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Materiau.label', default: 'Materiau'), materiauInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'materiauInstance.label', default: 'Materiau'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
