
public class Power {

	private String name;
	private Type type;
	
	public Power(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object o) {
		Power p = null;
		if(o.getClass() == this.getClass()) {
			p = (Power) o;
		}else {
			return false;
		}
		
		return name.equals(p.getName());
	}
	
	public String toString() {
		return "Name: " + name + " Type: " + type; 
	}
}
