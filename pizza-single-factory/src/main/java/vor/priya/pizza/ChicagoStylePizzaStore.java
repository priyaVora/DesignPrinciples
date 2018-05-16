package vor.priya.pizza;

public class ChicagoStylePizzaStore extends PizzaStore {

	@Override
	PizzaFactory createFactory() {
		// TODO Auto-generated method stub
		return new ChicagoStylePIzzaFactory();
	}

	
}
