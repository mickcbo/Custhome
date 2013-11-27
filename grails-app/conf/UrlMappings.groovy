class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
		"/about"(view:"/apropos/index")
        "500"(view:'/error')
		"/create"(view:"/userAccount/index")
		"/save" (controller:'UserAccount', action:'save')
	}
}
