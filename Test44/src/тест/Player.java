package тест;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Player implements Comparable<Player> {

	private String name;
	private String type;
	private int age;
	
	public static ArrayList<Player> players = new ArrayList<Player>();
	public static LinkedList<Player> lPlayers = new LinkedList<Player>();
	public static HashMap<String, TreeSet<Player>> byTypes = new HashMap<String, TreeSet<Player>>();
	
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
					add(new Player(words[1], words[2], parseInt(words[3])), parseInt(words[4]));
					break;
				case "find":
					find(words[1]);
					break;
				case "ranklist":
					rankList(parseInt(words[1]), parseInt(words[2]));
			}
		}
		
	}
	
	public static void add(Player pl, int pos) {
		if(pos > players.size()) {
			players.add(pl);
		}else {
			players.add(pos-1, pl);
		}
		if(!byTypes.containsKey(pl.type)) {
			byTypes.put(pl.type, new TreeSet<Player>());
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
			System.out.println();
			return;
		}
		TreeSet<Player> types = byTypes.get(type);
		int end = 5;
		if(types.size() < 5) end = types.size();
		int i = 0;
		Iterator<Player> it = types.iterator();
		
		while(i < end) {
			Player p = it.next();
			System.out.print(p.toString());
			if(i < end-1) {
				System.out.print("; ");
			}
			i++;
		}
		
//		for(int i = 0; i < end; i++) {
//			System.out.print(types.get(i).toString());
//			if(i < end-1) {
//				System.out.print("; ");
//			}
//		}
		System.out.println();
	}
	
	public static int parseInt( final String s )
	{
	    int num  = 0;
	    int sign = -1;
	    final int len  = s.length( );
	    final char ch  = s.charAt( 0 );
	    if ( ch == '-' )
	        sign = 1;
	    else
	        num = '0' - ch;

	    // Build the number.
	    int i = 1;
	    while ( i < len )
	        num = num*10 + '0' - s.charAt( i++ );

	    return sign * num;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Player o2) {
		if(name.equals(o2.name)) {
			return age > o2.age ? -1 :(age < o2.age ? 1 : 0);
		}
		return name.compareTo(o2.name);
	} 
}