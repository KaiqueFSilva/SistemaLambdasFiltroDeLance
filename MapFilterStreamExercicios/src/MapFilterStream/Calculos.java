package MapFilterStream;

import java.util.function.Consumer;

public class Calculos {
	
	String nome;
	double lance;
	String city;
	
	 Calculos(String nome, double lance, String city){
		
		this.nome = nome;
		this.lance = lance;
		this.city = city;
		
	}

	@Override
	public String toString() {
		return "\nNome= " + this.nome + "\nlance= " + this.lance + "\ncity= " + this.city + "\n\n";
	}
	
	
	
	
	
	

}
