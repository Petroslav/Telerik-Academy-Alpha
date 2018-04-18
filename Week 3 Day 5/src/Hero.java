import java.util.ArrayList;

public class Hero extends Person {
	
	private String secretIdentity;
	private String backstory;
	private boolean isGood;
	private ArrayList<Power> listOfPowers;
	
	public Hero(String name, double weight, Gender gender, String secretIdentity, String backstory, boolean isGood) {
		super(name, weight, gender);
		this.secretIdentity = secretIdentity;
		this.backstory = backstory;
		this.isGood = isGood;
		listOfPowers = new ArrayList<Power>();
	}
	
	public void canFly() {
		System.out.println("Maybe I can, maybe I can't");
	}
	
	public String getSecretIdentity() {
		return secretIdentity;
	}



	public String getBackstory() {
		return backstory;
	}



	public boolean isGood() {
		return isGood;
	}



	public ArrayList<Power> getListOfPowers() {
		return listOfPowers;
	}



	public void addSuperPower(Power p) {
		listOfPowers.add(p);
	}
}
