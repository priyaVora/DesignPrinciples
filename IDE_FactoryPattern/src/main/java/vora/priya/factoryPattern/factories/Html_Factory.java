package vora.priya.factoryPattern.factories;


import vora.priya.factoryPattern.component.Component;
import vora.priya.factoryPattern.component.Html_Button;
import vora.priya.factoryPattern.component.Html_Checkbox;
import vora.priya.factoryPattern.component.Html_Component;
import vora.priya.factoryPattern.component.Html_Label;
import vora.priya.factoryPattern.component.Html_RadioButton;
import vora.priya.factoryPattern.component.Java_Component;

public class Html_Factory  extends ComponentFactory{
	@Override
	public Component createComp(String type) {		
		Component c;
		if(type.equals("Button")) { 
			c = new Html_Button();		
		} else if(type.equals("CheckBox")) { 
			c = new Html_Checkbox();
		} else if(type.equals("Label")) { 
			c = new Html_Label();
		} else if(type.equals("RadioButton")) { 
			c = new Html_RadioButton();
		} else { 
			throw new IllegalArgumentException("unsupported component type" + type);
		}
		return c;
	}
}
