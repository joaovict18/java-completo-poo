package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Set<Integer> A = new HashSet<>();

		System.out.print("How many students for course A?");
		int I = sc.nextInt();
		for (int i=1; i<=I; i++) {
			A.add(sc.nextInt());
		}
		
		Set<Integer> B = new HashSet<>();
		
		System.out.print("How many students for course B?");
		int J = sc.nextInt();
		for (int i=1; i<=J; i++) {
			B.add(sc.nextInt());
		}
		
		Set<Integer> C = new HashSet<>();
	
		System.out.print("How many students for course C?");
		int K = sc.nextInt();
		for (int i=1; i<=K; i++) {
			C.add(sc.nextInt());
		}
		
		Set<Integer> total = new HashSet<>();
		total.addAll(A);
		total.addAll(B);
		total.addAll(C);
		
		System.out.println("Total students: " + total.size());
		
		sc.close();
	}

}
