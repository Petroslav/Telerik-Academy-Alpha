
public class Person {

	private String name;
	private double weight;
	private Gender gender;
	
	public Person(String name, double weight, Gender gender) {
		this.name = name;
		this.weight = weight;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public Gender getGender() {
		return gender;
	}
	
	@Override
	public String toString() {		
		return name + " weights " + weight + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (gender != other.gender)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	
	
	
}
