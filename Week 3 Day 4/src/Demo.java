import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		Superhero mememan = null;
		Superhero kekman = null;
		try {
			mememan = new Superhero("Memelord Memerov", "Meemo");
			kekman = new Superhero("Keker Keks", "Kekman");
		} catch (InvalidCredentialsException e) {
			e.printStackTrace();
		}
		
		try {
			mememan.addImmunity(Type.CHEMICAL);
			mememan.addImmunity(Type.INTELLECT);
			
			kekman.addImmunity(Type.INTELLECT);
			kekman.addImmunity(Type.TECH);
		} catch (AlreadyImmuneException e) {
			e.printStackTrace();
		}
		
		Power memes = new Power("Free Memes", Type.INTELLECT);
		Power depression = new Power("Depression", Type.OTHER);
		Power fortyKeks = new Power("3edgy5me", Type.CHEMICAL);
		Power run = new Power("Run away", Type.MAGIC);

		try {
			mememan.addPower(depression);
			mememan.addPower(memes);
			mememan.addPower(depression);
			kekman.addPower(fortyKeks);
			kekman.addPower(run);
		}catch(PowerAlreadyExistsException e) {
			e.printStackTrace();
		}		
		
		mememan.attack(kekman, depression);
		mememan.attack(kekman, memes);		
		
		ArrayList<Superhero> list = new ArrayList<>();
		
		list.add(kekman);
		list.add(mememan);
		
		System.out.println(list);
	}
}
