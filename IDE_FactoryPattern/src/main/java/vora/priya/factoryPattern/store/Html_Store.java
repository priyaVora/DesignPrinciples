package vora.priya.factoryPattern.store;

import vora.priya.factoryPattern.factories.ComponentFactory;
import vora.priya.factoryPattern.factories.Html_Factory;

public class Html_Store extends LanguageStore {
	@Override
	ComponentFactory createFactory() {
		// TODO Auto-generated method stub
		return new Html_Factory();
	}
}
