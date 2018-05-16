package vora.priya.factoryPattern.store;

import vora.priya.factoryPattern.factories.ComponentFactory;
import vora.priya.factoryPattern.factories.Java_Factory;

public class Java_Store extends LanguageStore {
	@Override
	ComponentFactory createFactory() {
		// TODO Auto-generated method stub
		return new Java_Factory();
	}
}
