import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Superhero {

	private static Random RNG = new Random();
	
	private String name;
	private String secretIdentity;
	private Alignment alignment;
	private int hp;
	private ArrayList<Power> powers;
	private HashSet<Type> immunities;
	
	
	public Superhero(String name, String secretIdentity) throws InvalidCredentialsException {
		setName(name);
		setSecretIdentity(secretIdentity);
		this.hp = 100;
		powers = new ArrayList<Power>();
		immunities = new HashSet<Type>();
		int align = RNG.nextInt(3);
		switch(align) {
			case 0:
				alignment = Alignment.GOOD;
				break;
			case 1:
				alignment = Alignment.NEUTRAL;
				break;
			case 2:
				alignment = Alignment.EVIL;
				break;
		}
		
	}
	
	public Superhero(String name, String secretIdentity, Alignment alignment) throws InvalidCredentialsException {
		setName(name);
		setSecretIdentity(secretIdentity);
		this.hp = 100;
		powers = new ArrayList<Power>();
		immunities = new HashSet<Type>();
		this.alignment = alignment;		
	}
	
	public void setName(String name) throws InvalidCredentialsException {
		if(name.length() < 3 || name.length() > 60) {
			throw new InvalidCredentialsException("Invalid name");
		}
		this.name = name;
	}
	
	public void setSecretIdentity(String secretIdentity) throws InvalidCredentialsException {
		if(secretIdentity.length() < 3 || secretIdentity.length() > 60) {
			throw new InvalidCredentialsException("Invalid secret identity");
		}
		
		this.secretIdentity = secretIdentity;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSecretIdentity() {
		return secretIdentity;
	}
	
	public Alignment getAlignment() {
		return alignment;
	}
	
	public void addImmunity(Type immunity) throws AlreadyImmuneException {
		if(!immunities.contains(immunity)) {
			immunities.add(immunity);
			System.out.printf("%s is now immune to %s attacks\n", name, printType(immunity));
		}else {
			System.out.printf("%s is already immune to this type of attack\n", name);
		}
	}
	
	
	public void addPower(Power p) throws PowerAlreadyExistsException {
		if(powerExists(p)) {
			throw new PowerAlreadyExistsException("Power already exists, cannot be learned twice");
		}else {
			powers.add(p);
			System.out.printf("%s has learned %s!\n", name, p.getName());
		}
	}
	
	public Power getRandomPower(){
		int power = RNG.nextInt(powers.size());
		return powers.get(power);
	}
	
	public void attack(Superhero target, Power p) {
		if(!powerExists(p)) {
			System.out.println("Cannot initiate attack, I cannot perform this power!");
		}else {
			target.takeHit(p);
		}
	}
	
	private void takeHit(Power p) {
		if(hp <= 0) {
			System.out.printf("%s is unable to fight. No damage inflicted.\n", name);
		}
		if(immunities.contains(p.getType())) {
			System.out.printf("%s is immune to %s attacks. No damage sustained.\n", name, printType(p.getType()));
		}else {
			hp -= 10;
			System.out.printf("%s took 10 damage from the attack!\n", name);
			if(hp <= 0) {
				System.out.printf("%s has fainted.", name);
			}
		}
		
	}

	private String printType(Type type) {
		String stringType = "";
		
		switch(type) {
			case MAGIC: 
				stringType = "Magic";
				break;
			case CHEMICAL:
				stringType = "Chemical";
				break;
			case INTELLECT:
				stringType = "Intellect";
				break;
			case TECH:
				stringType = "Tech";
				break;
			case OTHER:
				stringType = "such";
				break;
			default:
				stringType = "";
				break;
		}
		
		return stringType;
	}

	private boolean powerExists(Power p){
		if(powers.contains(p)) {
			return true;
		}
		for(Power pwr : powers) {
			if(pwr.equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String toString = "";
		
		toString += "Name : " + name + "\n";
		toString += "Secret identity: " + secretIdentity + "\n";
		toString += "Current HP: " + hp + "\n";
		toString += "Knows: ";
		
		for(Power p : powers) {
			toString += p.toString() + "; ";
		}
		
		toString += "\n";
		
		return toString;
	}
	
	
}
