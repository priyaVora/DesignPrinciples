package vor.priya.pizza;

abstract public class PizzaStore {
	// open for extension, close for modification
	// private PizzaFactory pizzaFactory = new PizzaFactory();

	abstract Pizza createPizza(String type);

	public Pizza makePizza(String type) {
		return createPizza(type);
	}

	public void bakePizza(Pizza pizza) {
		System.out.println("Bakiing Pizza" + pizza);
	}

	public void box(Pizza p) {
		System.out.println("Boxing piza: " + p);
	}

	public void cut(Pizza p) {
		System.out.println("Cutting Pizza: " + p);
	}
}
