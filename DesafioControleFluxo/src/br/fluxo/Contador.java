package br.fluxo;

import java.util.Scanner;


public class Contador {

	public static void main(String[] args) {
	
	Scanner terminal = new Scanner(System.in);
		
		try {
					
		System.out.println(" digite o primeiro numero");
		int parametroUm = terminal.nextInt();
		
		System.out.println(" digite o primeiro numero");
		int parametroDois = terminal.nextInt();
		
						
			//chamando o metodo contendo a logica de contagem
			 
			
			contar ( parametroUm, parametroDois);
			
					
		
			}catch (ParametrosInvalidosException Exception ) {
				
			System.out.println("O segundo parametro deve ser maior que o primeiro");
			}
		
	}
	
	static void contar (int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
		if (parametroUm < parametroDois) {
			// validar se parametroUm é maior que parametroDois e lancar a exceçao
			int contagem = parametroDois - parametroUm;
			// realizar o for para imprimir os numeros com base na variavel contagem 
				for (int i =0; i < contagem ; i++) {
					System.out.println(i);
				}
			}else {
				throw new ParametrosInvalidosException ();
			}

	
}	
}