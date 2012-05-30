package groovyx.gaelyk.plugin.twitter.bootstrap

import com.google.appengine.api.utils.SystemProperty;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import spock.lang.Specification

class TwitterBootstrapSpec extends Specification {

	LocalServiceTestHelper helper = new LocalServiceTestHelper()
	
	def setup() {
		helper.setUp()
	}
	def cleanup() {
		helper.tearDown()
		TwitterBootstrap.reset()
	}
	
	def "Get prod resources"(){
		SystemProperty.environment.set(SystemProperty.Environment.Value.Production)
		TwitterBootstrap.reset()
		
		expect:
		TwitterBootstrap.instance.css 				== "/gpr/bootstrap/css/bootstrap.min.css"
		TwitterBootstrap.instance.responsive 		== "/gpr/bootstrap/css/bootstrap-responsive.min.css"
		TwitterBootstrap.instance.js				== "/gpr/bootstrap/js/bootstrap.min.js"
		TwitterBootstrap.instance.logo				== null
		TwitterBootstrap.instance.brand				== "Gaelyk"
	}
	
	def "Get dev resources"(){
		SystemProperty.environment.set(SystemProperty.Environment.Value.Development)
		TwitterBootstrap.reset()
		
		expect:
		TwitterBootstrap.instance.css 				== "/gpr/bootstrap/css/bootstrap.css"
		TwitterBootstrap.instance.responsive 		== "/gpr/bootstrap/css/bootstrap-responsive.css"
		TwitterBootstrap.instance.js				== "/gpr/bootstrap/js/bootstrap.js"
		TwitterBootstrap.instance.logo				== null
		TwitterBootstrap.instance.brand				== "Gaelyk"
	}
	
	def "Get custom resources"(){
		TwitterBootstrap.configure {
			css 			= "/css/bootstrap.css"
			responsive 		= "/css/bootstrap-responsive.css"
			js				= "/js/bootstrap.js"
			logo			= "/img/myCoolLogo.png"
			brand			= "My Brand"
		}
		
		expect:
		TwitterBootstrap.instance.css 				== "/css/bootstrap.css"
		TwitterBootstrap.instance.responsive 		== "/css/bootstrap-responsive.css"
		TwitterBootstrap.instance.js				== "/js/bootstrap.js"
		TwitterBootstrap.instance.logo				== "/img/myCoolLogo.png"
		TwitterBootstrap.instance.brand				== "My Brand"
	}
	
	
	
}
