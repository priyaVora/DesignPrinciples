package vor.priya.pizza;

public class CalifornaStylePizzaStore extends PizzaStore {

	@Override
	PizzaFactory createFactory() {
		// TODO Auto-generated method stub
		return new CaliforniaStylePIzzaFactory();
	}

	

}
