import java.io.IOException;
import java.lang.Thread;
import java.util.*;

public class Main {

	public static void output(float arr[]) { 
		System.out.print("\n[");
		for (int i = 0; i < arr.length; i++) {
			if (i == (arr.length - 1)) {
				System.out.print(arr[i] + "]");
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
		System.out.println("");
	}

	public static void header() throws IOException, InterruptedException {
		new ProcessBuilder("clear").inheritIO().start().waitFor();
		System.out.println("PL-M1: ACT1 - Sorting 1");
		System.out.println("DELA CRUZ, JOHN LORENZ N.\n");
	}

	public static void ascendingSort(float arr[]) {  
		for (int i = 1; i < arr.length; i++) {
			float key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}  

	public static void descendingSort(float arr[]) {
		for (int i = 1; i < arr.length; i++) {
			float key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] < key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}  

	public static void main(String[] args) throws IOException, InterruptedException{

		header();
		int i = 0;
		float[] numberArray = new float[10];

		do {
			float number = 0;
			boolean flag = false;
			System.out.print("Enter number " + (i + 1) + " : ");
			do {
				try {
					Scanner input = new Scanner(System.in);
					number = input.nextFloat();
					flag = true;
				} catch(InputMismatchException ex) {
					flag = false;
					System.out.println("Invalid input. Please enter a valid number.");
					Thread.sleep(1250);
					header();
					for (int j = 0; j < i; j++) {
						System.out.println("Enter number " + (j + 1) + " : " + numberArray[j]);
					}
					System.out.print("Enter number " + (i + 1) + " : ");		
				}
			} while (!flag);
			numberArray[i] = number;
			i ++;
		} while (i < 10);

		System.out.print("\nInput Array: ");
		output(numberArray);

		ascendingSort(numberArray);
		System.out.print("Ascending Order: ");
		output(numberArray);

		descendingSort(numberArray);
		System.out.print("Descending Order: ");
		output(numberArray);
	}

}