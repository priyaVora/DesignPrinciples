package vor.priya.pizza;

abstract public class PizzaStore {
	// open for extension, close for modification
	private PizzaFactory pizzaFactory;

	abstract PizzaFactory createFactory();

	public PizzaStore() {
		this.pizzaFactory = this.createFactory();
	}

	public Pizza makePizza(String type) {
		//return null;
		return pizzaFactory.createPizza(type);
	}

	public void bakePizza(Pizza pizza) {
		System.out.println("Bakiing Pizza" + pizza);
	}

	public void box(Pizza p) {
		System.out.println("Boxing Pizza: " + p);
	}

	public void cut(Pizza p) {
		System.out.println("Cutting Pizza: " + p);
	}
}
