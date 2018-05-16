package vora.priya.factoryPattern.factories;

import vora.priya.factoryPattern.component.Component;

abstract public class ComponentFactory {
	abstract public Component createComp(String type);
}
