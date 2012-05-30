package groovyx.gaelyk.plugin.twitter.bootstrap;

import groovyx.gaelyk.GaelykBindingEnhancer;

import com.google.appengine.api.utils.SystemProperty;


public class TwitterBootstrap {
	
	private static class TwitterBootstrapConfig {
		String css
		String js
		String responsive
		String logo
		String brand
		int	gap
		
		TwitterBootstrapConfig(){
			boolean prod = SystemProperty.environment.value() == SystemProperty.Environment.Value.Production
			
			css			= "/gpr/css/bootstrap${ prod ? '.min' : ''}.css"
			js			= "/gpr/js/bootstrap${ prod ? '.min' : ''}.js"
			responsive	= "/gpr/css/bootstrap-responsive${ prod ? '.min' : ''}.css"
			logo		= null
			brand		= "Gaelyk"
			gap			= 60
		}
	}
	
	private static TwitterBootstrap instance = null
	
	final String css
	final String js
	final String responsive
	final String logo
	final String brand
	final int gap
	
	private TwitterBootstrap(TwitterBootstrapConfig cfg){
		css			= cfg.css
		js			= cfg.js
		responsive	= cfg.responsive
		logo		= cfg.logo
		brand		= cfg.brand
		gap			= cfg.gap
	}


	static reset(){
		instance = new TwitterBootstrap(new TwitterBootstrapConfig())
	}
	
	static TwitterBootstrap getInstance(){
		if(instance == null){
			reset()
		}
		instance
	}
	
	static void setInstance(TwitterBootstrap instance){
		throw new UnsupportedOperationException("You cannot set the instance manually!")
	}
	
	static void configure(Closure c){
		TwitterBootstrapConfig cfg = []
		c.delegate = cfg
		c.resolveStrategy = Closure.DELEGATE_FIRST
		c()
		
		instance = new TwitterBootstrap(cfg)
	}
}
