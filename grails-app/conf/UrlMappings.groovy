class UrlMappings {

    static mappings = {
	"/$controller/$action?/$id?"{
            constraints {
		// apply constraints here
            }
	}
        "500"(view:'/error')
               "/"(controller: "selectLocation")
        //"/"(view:"/SelectLocation/index")
"/locationDetails" {
controller = "locationDetails"
action = "index"
}
    }
}
