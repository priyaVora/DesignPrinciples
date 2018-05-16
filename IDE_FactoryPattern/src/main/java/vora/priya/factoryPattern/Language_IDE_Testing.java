package vora.priya.factoryPattern;

import vora.priya.factoryPattern.component.Component;
import vora.priya.factoryPattern.store.Java_Store;
import vora.priya.factoryPattern.store.LanguageStore;

public class Language_IDE_Testing {
	public static void main(String[] args) {
		LanguageStore componentStore =  new Java_Store();
		
		Component currentComponent = componentStore.makeComponent("Button");
		System.out.println(currentComponent.toString() + "\n");
		
		Component secondComponent = componentStore.makeComponent("Label");
		System.out.println(secondComponent.toString() + "\n");
	

}

}

