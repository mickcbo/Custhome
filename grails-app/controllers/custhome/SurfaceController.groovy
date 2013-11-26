package custhome



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SurfaceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Surface.list(params), model:[surfaceInstanceCount: Surface.count()]
    }

    def show(Surface surfaceInstance) {
        respond surfaceInstance
    }

    def create() {
        respond new Surface(params)
    }

    @Transactional
    def save(Surface surfaceInstance) {
        if (surfaceInstance == null) {
            notFound()
            return
        }

        if (surfaceInstance.hasErrors()) {
            respond surfaceInstance.errors, view:'create'
            return
        }

        surfaceInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'surfaceInstance.label', default: 'Surface'), surfaceInstance.id])
                redirect surfaceInstance
            }
            '*' { respond surfaceInstance, [status: CREATED] }
        }
    }

    def edit(Surface surfaceInstance) {
        respond surfaceInstance
    }

    @Transactional
    def update(Surface surfaceInstance) {
        if (surfaceInstance == null) {
            notFound()
            return
        }

        if (surfaceInstance.hasErrors()) {
            respond surfaceInstance.errors, view:'edit'
            return
        }

        surfaceInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Surface.label', default: 'Surface'), surfaceInstance.id])
                redirect surfaceInstance
            }
            '*'{ respond surfaceInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Surface surfaceInstance) {

        if (surfaceInstance == null) {
            notFound()
            return
        }

        surfaceInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Surface.label', default: 'Surface'), surfaceInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'surfaceInstance.label', default: 'Surface'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
