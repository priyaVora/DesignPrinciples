package vora.priya.factoryPattern.store;

import vora.priya.factoryPattern.component.Component;
import vora.priya.factoryPattern.factories.ComponentFactory;

abstract public class LanguageStore {
	// open for extension, close for modification
	private ComponentFactory componentFactory;

	abstract ComponentFactory createFactory();

	public LanguageStore() {
		this.componentFactory = this.createFactory();
	}
	public Component makeComponent(String type) {
		return componentFactory.createComp(type);
	}
}
