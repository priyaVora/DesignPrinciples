package vora.priya.factoryPattern.factories;

import vora.priya.factoryPattern.component.Component;
import vora.priya.factoryPattern.component.Html_Component;
import vora.priya.factoryPattern.component.Java_Button;
import vora.priya.factoryPattern.component.Java_Component;
import vora.priya.factoryPattern.component.Java_Label;

public class Java_Factory extends ComponentFactory {

	@Override
	public Component createComp(String type) {
		Component c;
		if (type.equals("Button")) {
			c = new Java_Button();
		} else if (type.equals("Label")) {
			c = new Java_Label();
		} else {
			throw new IllegalArgumentException("unsupported component type" + type);
		}
		return c;
	}

}
