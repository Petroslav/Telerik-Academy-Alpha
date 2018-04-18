import java.util.Random;

public class Supervillain extends Hero {

	public Supervillain(String name, double weight, Gender gender, String secretIdentity, String backstory, boolean isGood) {
		super(name, weight, gender, secretIdentity, backstory, isGood);
	}
	
	public boolean saveWorld() {
		return new Random().nextInt(101) > 60;
	}
	
	@Override
	public void canFly() {
		System.out.println("I can't fly bruh");
	}
	
	@Override
	public void addSuperPower(Power p) {
		System.out.println("I CAN NOW LIE BETTER");
		super.addSuperPower(p);
	}
}
