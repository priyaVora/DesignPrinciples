package vor.priya.pizza;

public class CalifornaStylePizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String type) {
		Pizza p;
		if (type.equals("cheese")) {
			p = new CheesePizza();
		} else if(type.equals("clam")) { 
			p = new ClamPizza();
		} else {
			throw new IllegalArgumentException("unsupported pizza type " + type);
		}
		p.setCrustType("Stuffed");
		return p;
	}

}
