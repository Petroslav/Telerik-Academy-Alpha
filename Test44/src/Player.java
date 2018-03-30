import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Player {

	private String name;
	private String type;
	private int age;
	
	public static ArrayList<Player> players = new ArrayList<Player>();
	public static HashMap<String, ArrayList<Player>> byTypes = new HashMap<String, ArrayList<Player>>();
	
	public Player(String name, String type, int age) {
		this.name = name;
		this.type = type;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}
	
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
//		Scanner sc = new Scanner(System.in);

		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> commands = new ArrayList<>();
		
		while(true) {
			String command = sc.readLine();
			if(command.equals("end")) {
				break;
			}
			commands.add(command);
		}
		
		sc.close();
		
		for(String command : commands) {
			String[] words = command.split(" ");
			switch(words[0]){
				case "add":
					add(new Player(words[1], words[2], Integer.parseInt(words[3])), Integer.parseInt(words[4]));
					break;
				case "find":
					find(words[1]);
					break;
				case "ranklist":
					rankList(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
			}
		}
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static void add(Player pl, int pos) {
		if(!players.isEmpty() || pos < players.size()) {
			players.add(pos-1, pl);			
		}else {
			players.add(pl);
		}
		if(!byTypes.containsKey(pl.type)) {
			byTypes.put(pl.type, new ArrayList<Player>());
		}
		byTypes.get(pl.type).add(pl);	
		System.out.println("Added player " + pl.name + " to position " + pos );
	}
	
	public static void rankList(int start, int end) {
		for(int i = start; i < end; i++) {
			System.out.print(i + ". " + players.get(i-1).toString() + ";");
		}
		System.out.println(end + ". " + players.get(end-1).toString());
	}
	
	public static void find(String type) {
		System.out.print("Type " + type + ": ");
		if(!byTypes.containsKey(type)) {
			return;
		}
		ArrayList<Player> types = byTypes.get(type);
		Collections.sort(types, new Comparator<Player>() {

			@Override
			public int compare(Player o1, Player o2) {
				if(o1.name.equals(o2.name)) {
					return o1.age > o2.age ? -1 :(o1.age < o2.age ? 1 : 0);
				}
				return o1.name.compareTo(o2.name);
			}
			
		});
		int end = 5;
		if(types.size() < 5) end = types.size();
		for(int i = 0; i < end; i++) {
			System.out.print(types.get(i).toString());
			if(i < end-1) {
				System.out.print("; ");
			}
		}
		System.out.println();
	}
}