import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumbTri {
    
    public static void main(String[] args) throws IOException{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        printTriangle(n);
        
    }
    
    public static void printTriangle(int num){
    	StringBuilder test = new StringBuilder();
        for(int i = 1; i < num; i++){
            for(int j = 1; j <= i; j++){
                if(j == i){
                    test.append(j + "\n");
                } 
                else{
                	test.append(j + " ");
                }
            }
            
        }
        for(int i = num; i > 0; i--){
            for(int j = 1; j <= i; j++){
                if(j == i){
                	test.append(j + "\n");
                } 
                else{
                	test.append(j + " ");
                }
            }
            
        }
        System.out.println(test);
    }
    
    
}