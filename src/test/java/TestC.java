import java.util.ArrayList;
import java.util.List;

public class TestC {
	
	public static void main(String[] args){
		
		List<String> list = new ArrayList<String>();
		
		list.add("1");
		list.add("2");
		
		System.out.println(list.toString());
		
		String[] array = new String[]{"1","2"};
		
		System.out.println(array.toString());
	}
	
}
