import java.util.Scanner;
public class AirlineReservationSystem {
	static boolean[] arrSeats = new boolean[10];
	Scanner sc = new Scanner(System.in);
	// SET
	// assigns to the menu first empty seat
	public boolean assignSeat(String section) {
		if (section == "first") {
			if (getFreeSeats(section) > 0) {
				for (int i = 0; i < 10; i++) {
					if (arrSeats[i] == false) {
						arrSeats[i] = true;
						printBoardingPass(i);
						return true;
					}
				}
			}
			else if (section == "economy") {
			if (getFreeSeats(section) > 0) {
				for (int i = 5; i < arrSeats.length; i++) {
					if (arrSeats[i] == false) {
						arrSeats[i] = true;
						printBoardingPass(i);
						return true;
					}
				}
			}
		// check if OK to assign to other section
		System.out.printf("Would you like to move to section \"%s\" (y/n)? ",
				(section == "first") ? "economy" : "first");
		if (sc.next().charAt(0) == 'y')assignSeat((section == "first") ? "economy" : "first");
		else
			System.out.println("\nNext flight leaves in hours.\n");
		return false;
	}
	// GET
	// returns number of free seats in each section
	private static int getFreeSeats(String section) {
		int total = 0;
		if (section == "first") {
			// first class 1-5 (array 0-4)
			for (int i = 0; i < 5; i++) {
				if (arrSeats[i] == false)
					total += 1;
			}
		} else if (section == "economy") {
			// economy 6-10 (array 5-9)
			for (int i = 5; i < arrSeats.length; i++) {
				if (arrSeats[i] == false)
					total += 1;
			}
		}
		return total;
	}
	public static void printGreeting() {
		System.out.println("\nWelcome to The Airlines Booking system.\n");
	}
	// print the menu with remaining number of seats for each section
	public static void printMenu() {
		System.out.printf("1. Economy class %s\n",
				(getFreeSeats("economy") > 0) ? "(" + Integer.toString(getFreeSeats("economy")) + ")" : "(full)");
		System.out.printf("2. First class %s\n",
				(getFreeSeats("first") > 0 ? "(" + Integer.toString(getFreeSeats("first")) + ")" : "(full)"));
		System.out.print("> ");
	}
	// prints the boarding pass
	private static void printBoardingPass(int seat) {
		System.out.println("\nBoarding pass for Turkish Airlines.");
		System.out.printf("\nSECTION: %s\nSEAT NUMBER: %d\n\n\n", (seat < 5) ? "first" : "economy", seat + 1);
	}
	public static void main(String[] args) {
		// call printGreeting
		printGreeting();
		printMenu();
		printBoardingPass(0);
		printBoardingPass(5);
		// assign seat for each section
		String seats1 = "(1-5)";
		String seats2 = "(6-10)";
		System.out.println(seats1 + "or" + seats2);
	}
}