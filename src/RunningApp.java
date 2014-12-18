import java.util.Scanner;


public class RunningApp {
	public static void main(String[] args) {
		RunningModel calc = new RunningModel();
		Scanner cin = new Scanner(System.in);
		
		System.out.print("Enter a track size (200/400): ");
		calc.setTrackSize(cin.nextInt());
		System.out.print("Enter Distance: ");
		calc.setDistance(cin.nextInt());
		
		calc.calcNumberLaps();
		System.out.println("Laps: " + calc.getNumberLaps());
		
		System.out.print("Enter a time (XX:XX): ");
		calc.setTotalTime(cin.next());
		cin.close();
		
		calc.calcLapSeconds();
		calc.calcLapTime();
		
		System.out.println("Each lap will be: " + calc.getLapTime() + " or " + calc.getLapSeconds() + "s.");
		calc.lapPrinter();
	}
}
