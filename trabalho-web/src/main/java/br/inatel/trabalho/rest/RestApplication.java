package br.inatel.trabalho.rest;

import java.util.HashSet;
import java.util.Set;

import br.inatel.trabalho.impl.ProductResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class RestApplication extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		
		classes.add(ProductResource.class);
		return classes;
	}

}
