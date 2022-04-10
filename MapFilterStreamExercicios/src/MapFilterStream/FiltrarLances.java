package MapFilterStream;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import javax.swing.JOptionPane;

public class FiltrarLances {

	public static void main(String[] args) {
		
		int parar = 1;
		ArrayList<Calculos> pessoa = new ArrayList();
		
		while (parar != 2) {
			
			String nomeCliente = JOptionPane.showInputDialog("nome: ").toUpperCase();
			
			String lanceCliente = JOptionPane.showInputDialog("Lance:");
			double lanceC = Double.parseDouble(lanceCliente);
			
			String cidade = JOptionPane.showInputDialog("Cidade (SP, SC, BH, MT...):").toUpperCase();
			

			Calculos cliente = new Calculos(nomeCliente, lanceC, cidade);
			
			
			pessoa.add(cliente);
			
			String respostaC = JOptionPane.showInputDialog("Digite 1 para adicionar + / ou digite 2 para finalisar processo");
			int resposta = Integer.parseInt(respostaC);
			
			parar = resposta;

			
		
		}
		
		
 
		Consumer<Double> printD = System.out::print; 
		Consumer<Calculos> print = System.out::print; 
		
		pessoa.stream().forEach(print);
	
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Qual valor mínimo aceitavel no lance?\nR$");
		double lanceMinimo = leitor.nextDouble();
		
		Predicate<Calculos> lanceM = r -> r.lance >= lanceMinimo;
		pessoa.stream().filter(lanceM).forEach(print);
		
		
		
		System.out.print("\n\nInforme a cidade preferível: ");
		String cidadePreferida = leitor.next().toUpperCase();
		
		Predicate<Calculos> cidadeP = c -> c.city.equals(cidadePreferida);
		
		
		System.out.println("\n\nCLIENTE QUALIFICADO NO MOMENTO");
		pessoa.stream().filter(lanceM).filter(cidadeP).forEach(print);
		
		Function<Calculos,Double> diferencaLance = 
				c -> (c.lance - lanceMinimo);
				
				System.out.print("\nO valor da diferença do lance e o valor MÍNIMO é de ");
				 pessoa.stream().filter(lanceM).filter(cidadeP).map(diferencaLance).forEach(printD);
		
		
		leitor.close();
		
		
		
	}
	
	
	
}
