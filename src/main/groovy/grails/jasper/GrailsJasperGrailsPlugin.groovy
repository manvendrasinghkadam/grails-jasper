package grails.jasper

import grails.plugins.*

class GrailsJasperGrailsPlugin extends Plugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.0.2 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp",
        'docs/**',
        'src/docs/**'
    ]

    // TODO Fill in these fields
    def title = "Jasper Plugin" // Headline display name of the plugin
    def author = "Craig Andrews"
    def authorEmail = "candrews@integralblue.com"
    def description = '''
    Adds easy support for launching jasper reports from GSP pages.
    After installing, run your application and request (app-url)/jasper/demo for a demonstration and instructions.
    '''
    def profiles = ['web']

    // URL to the plugin's documentation
    def documentation = "http://www.grails.org/plugin/jasper"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "Apache License 2.0"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [system: "JIRA", url: "http://jira.grails.org/browse/GPJASPER"]

    // Online location of the plugin's browseable source code.
    def scm = [url: "https://github.com/candrews/grails-jasper"]

    def doWithWebDescriptor = { xml ->
        def servlets = xml.servlet
        def lastServlet = servlets[servlets.size() - 1]
        lastServlet + {
            servlet {
                'servlet-name'('image')
                'servlet-class'('net.sf.jasperreports.j2ee.servlets.ImageServlet')
            }
        }

        def mappings = xml.'servlet-mapping'
        def lastMapping = mappings[mappings.size() - 1]
        lastMapping + {
            'servlet-mapping' {
                'servlet-name'('image')
                'url-pattern'('/reports/image')
            }
        }
    }

    Closure doWithSpring() { {->
            // TODO Implement runtime spring config (optional)
        } 
    }

    void doWithDynamicMethods() {
        // TODO Implement registering dynamic methods to classes (optional)
    }

    void doWithApplicationContext() {
        // TODO Implement post initialization spring config (optional)
    }

    void onChange(Map<String, Object> event) {
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    void onConfigChange(Map<String, Object> event) {
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    void onShutdown(Map<String, Object> event) {
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
