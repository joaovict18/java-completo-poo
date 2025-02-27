package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> lista = new ArrayList<>();
		
		System.out.print("Enter the number of tax players: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Tax player #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String nome = sc.nextLine();
			System.out.print("Anual income: ");
			double ganhoAnual = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double gastosComSaude = sc.nextDouble();
				lista.add(new PessoaFisica(nome, ganhoAnual, gastosComSaude));
			}
			else {
				System.out.print("Number of employees: ");
				int numeroDeEmpregados = sc.nextInt();
				lista.add(new PessoaJuridica(nome, ganhoAnual, numeroDeEmpregados));
			}
		}
		
		System.out.println("TAXES PAID:");
		for (Pessoa pessoa : lista) {
			System.out.println(pessoa.getName() + ": $" + String.format("%.2f", pessoa.pagaImposto()));
		}
		
		System.out.println();
		
		double soma = 0;
		for (Pessoa pessoa : lista) {
			soma += pessoa.pagaImposto();
		}
		System.out.printf("TOTAL TAXES: $ %.2f%n", soma);
		
		sc.close();
	
	}

}
