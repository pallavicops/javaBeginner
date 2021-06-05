import java.util.ArrayList;
import java.util.Collections;
public class ArrayInt {
 public static void main(String[] args) {
	 ArrayList<String> pallu=new ArrayList<String>();
	 pallu.add("Ford");
	 pallu.add("Mazda");
	 pallu.add("BmW");
	 pallu.add("Volvo");
	Collections.sort(pallu);
	for(String i : pallu) {
		System.out.println(i);
	}
 }
}
