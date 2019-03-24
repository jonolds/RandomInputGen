import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;


public class InputGen {

	public static void main(String[] args) throws IOException {
		int[] allZips = new int[] {11111, 22222, 33333, 44444, 55555, 66666, 77777, 88888, 99999};
		
		int numRecords = 200;
		
		
		String[] ids = getRandoId(numRecords, 6);
		String[] lasts = getRandoLast(200);
		String[] firsts = getRandoFirst(200);		
		int[] ages = getRandoInts(numRecords, 18, 87);
		int[] randoZips = getRandoArrFromArr(numRecords, allZips);
		
		for(int i = 0; i < numRecords; i++)
			println(ids[i] + "\t" + lasts[i] + " " + firsts[i] + " " + ages[i] + " " + randoZips[i]);

	}
	
	
	//lower bound inclusive, upper bound exclusive
	public static int[] getRandoInts(int num, int lower, int upper) {
		return new Random().ints(lower, upper).limit(num).toArray();
		
	}
	
	static String[] getRandoId(int count, int numDigits) {
		return new Random().ints(0, (int)Math.pow(10, numDigits)).limit(count).boxed().map(x->String.format("%06d", x)).toArray(String[]::new);
	}
	
	static int[] getRandoArrFromArr(int count, int[] arr) {
		return new Random().ints(0, arr.length).limit(count).map(x->arr[x]).toArray();
	}
	
	static String[] getRandoFirst(int count) throws IOException {
		List<String> names = FileUtils.readLines(new File("baseInput" + File.separator + "200first.txt"), "UTF-8");
		return new Random().ints(0, names.size()).limit(count).boxed().map(x->names.get(x)).toArray(String[]::new);		
	}
	
	static String[] getRandoLast(int count) throws IOException {
		List<String> names = FileUtils.readLines(new File("baseInput" + File.separator + "200last.txt"), "UTF-8");
		return new Random().ints(0, names.size()).limit(count).boxed().map(x->names.get(x)).toArray(String[]::new);		
	}
	
	static <T> void println(T t) {
		System.out.println(t.toString());
	}
}
