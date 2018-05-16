package vor.priya.pizza;

public class NYStylePizzaFactory   extends PizzaFactory{

	@Override
	public Pizza createPizza(String type) {
		Pizza p;
		if (type.equals("pepporoni")) {
			p = new PepperoniPizza();
		} else if (type.equals("cheese")) {
			p = new CheesePizza();
		} else {
			throw new IllegalArgumentException("unsupported pizza type " + type);
		}
		p.setCrustType("Thin");
		return p;
	}
}
