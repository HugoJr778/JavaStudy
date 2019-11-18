package pf_pj_project.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import pf_pj_project.entities.Pessoa;
import pf_pj_project.entities.PessoaFisica;
import pf_pj_project.entities.PessoaJuridica;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoa> p = new ArrayList<>();
		
		System.out.print("Enter the Number of Tax Payers: ");
		int quantPessoas = sc.nextInt();
		
		for(int i = 1; i <= quantPessoas; i++) {
			System.out.println("Tax Payer #" + i + " Data ---");
			System.out.print("Individual or Company (i/c)? ");
			char tipoPessoa = sc.next().charAt(0);
			System.out.print("Name: ");
			String nome = sc.next();
			System.out.print("Anual Income: ");
			double rendaAnual = sc.nextDouble();
			
			if(tipoPessoa == 'c' || tipoPessoa == 'C') {
				System.out.print("Number of Employees: ");
				int numeroFuncionarios = sc.nextInt(); 
				p.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
			} else {
				System.out.print("Health Exependitures: ");
				double gastosSaude = sc.nextDouble(); 
				p.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
			}
		}
		
		System.out.println("\nTAXES PAID ---");
		double total = 0;
		for(Pessoa pessoa : p) {
			System.out.println(pessoa.getNome() + ": $ " + String.format("%.2f", pessoa.calculoImposto()));
			total += pessoa.calculoImposto();
		}
		System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", total));
		sc.close();
	}
}