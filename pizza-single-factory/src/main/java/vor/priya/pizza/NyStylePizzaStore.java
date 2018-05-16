package vor.priya.pizza;

public class NyStylePizzaStore extends PizzaStore {

	@Override
	PizzaFactory createFactory() {
		// TODO Auto-generated method stub
		return new NYStylePizzaFactory();
	}

}
