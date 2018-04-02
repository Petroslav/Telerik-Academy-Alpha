import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class Player2 {

	private String name;
	private String type;
	private String age;
	
	public static ArrayList<Player2> players = new ArrayList<Player2>();
	public static LinkedList<Player2> lPlayers = new LinkedList<Player2>();
	public static HashMap<String, ArrayList<Player2>> byTypes = new HashMap<String, ArrayList<Player2>>();
	
	public Player2(String name, String type, String age) {
		this.name = name;
		this.type = type;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}
	
	public static void main(String[] args) throws IOException {
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
		long start = System.currentTimeMillis();
		sc.close();
		
		for(String command : commands) {
			String[] words = command.split(" ");
			switch(words[0]){
				case "add":
					add(new Player2(words[1], words[2], words[3]), parseInt(words[4]));
					break;
				case "find":
					find(words[1]);
					break;
				case "ranklist":
					rankList(parseInt(words[1]), parseInt(words[2]));
			}
		}
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static void add(Player2 pl, int pos) {
		if(!lPlayers.isEmpty()) {
			lPlayers.add(pos-1, pl);			
		}else {
			lPlayers.add(pl);
		}
		if(!byTypes.containsKey(pl.type)) {
			byTypes.put(pl.type, new ArrayList<Player2>());
		}
		byTypes.get(pl.type).add(pl);	
		System.out.println("Added player " + pl.name + " to position " + pos );
	}
	
	public static void rankList(int start, int end) {
		if(players.size() < lPlayers.size()) {
			if(players.size() == 0) {
				players.addAll(lPlayers);
			}else {
				players.clear();
				players.addAll(lPlayers);
			}
		}
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
		ArrayList<Player2> types = byTypes.get(type);
		Collections.sort(types, new Comparator<Player2>() {

			@Override
			public int compare(Player2 o1, Player2 o2) {
				if(o1.name.equals(o2.name)) {
//					return o1.age > o2.age ? -1 :(o1.age < o2.age ? 1 : 0);
					return -o1.age.compareTo(o2.age);
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
	
	public static int parseInt( final String s )
	{
	    // Check for a sign.
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
}