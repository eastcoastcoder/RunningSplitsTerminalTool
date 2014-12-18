import java.util.Scanner;


public class RunningApp {
	public static void main(String[] args) {
		RunningModel calc = new RunningModel();
		Scanner cin = new Scanner(System.in);
		
		System.out.print("Enter a track size (200/400): ");
		calc.setTrackSize(cin.nextInt());
		System.out.print("Enter Distance: ");
		calc.setDistance(cin.nextInt());
		System.out.println("Laps: " + calc.calcLaps());
		
		System.out.println("Enter a time (XX:XX): ");
		calc.setTime(cin.next());
		cin.close();
		
		System.out.println("Each lap will be: " + calc.doMath() + ".");
		calc.lapPrinter();
	}
}
