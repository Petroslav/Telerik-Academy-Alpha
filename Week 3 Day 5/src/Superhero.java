import java.util.Random;

public class Superhero extends Hero {

	public Superhero(String name, double weight, Gender gender, String secretIdentity, String backstory, boolean isGood) {
		super(name, weight, gender, secretIdentity, backstory, isGood);
	}
	
	public boolean saveWorld() {
		return new Random().nextInt(101) > 75;
	}
	
	@Override
	public void canFly() {
		System.out.println("I BELIEVE I CAN FLYYYYYYYYYYYYYYYYYYYYYYYYYYY");
	}
	
	@Override
	public void addSuperPower(Power p) {
		if(this.getListOfPowers().contains(p)) {
			System.out.println("ME VERY STRONG NOW, DOUBLE OF POWER EQUAL MANY WIN!!!");
		}
		super.addSuperPower(p);
	}
}
