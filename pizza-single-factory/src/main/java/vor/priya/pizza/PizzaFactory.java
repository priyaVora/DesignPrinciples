package vor.priya.pizza;

public class PizzaFactory {
	public Pizza createPizza(String type) {
		if (type.equals("pepporoni")) {
			return new PepperoniPizza();
		} else if (type.equals("pineapple")) {
			return new PineapplePizza();
		} else if (type.equals("cheese")) {
			return new CheesePizza();
		} else {
			throw new IllegalArgumentException("unsupported pizza type " + type);
		}
	}
}
