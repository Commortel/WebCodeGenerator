package fr.ensisa.code_generator;

import fr.ensisa.code_generator.Factory;

public class Context {
	private Factory factory;
	
	public Factory getFactory() {
		if (factory == null) factory = new Factory();
		return factory;
	}

}
