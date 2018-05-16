
public class UFOEnemyShipFactory implements EnemyShipFactory {

	public EsWeapon addESGUn() {
		return new ESUFOGun();
	}

	public EsEngine addESEngine() {
		return new ESUFOEngine();
	}

}
