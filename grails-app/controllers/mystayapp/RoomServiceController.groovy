package mystayapp

class RoomServiceController {

    def index() {
        println("params: "+params)
        render(view: 'index',model: [ params: params])
    }
}
