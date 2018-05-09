package vor.priya.pizza;

public class PizzaStore {
	// open for extension, close for modification
	private PizzaFactory pizzaFactory = new PizzaFactory();

	public Pizza makePizza(String type) {
		return pizzaFactory.createPizza(type);
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
