package exercicios.java;
import java.time.LocalDateTime;
import java.util.Locale;
import java.time.format.TextStyle;
import java.time.LocalDate;

public class ManipulacaoDatas {

	public static void main(String[] args) {
		

	
		// mensagem de Saudacao

		        String nome = "Adriana";

		// ISO 8601
		        LocalDate hoje = LocalDate.now();
		        Locale brasil = new Locale ("pt", "BR");
		//Locale brasil = new Locale ("pt", "BR");
		       // System.out.println(hoje.getDayOfWeek().getDisplayName(TextStyle.FULL,brasil));
		        String diaSemana = hoje.getDayOfWeek().getDisplayName(TextStyle.FULL,brasil);
		        String saudacao = null;
		        LocalDateTime agora =  LocalDateTime.now();
		        if(agora.getHour() < 12){
		            saudacao = "Bom dia!!!";

		        } else if (agora.getHour() <= 18){
		            saudacao = "Boa Tarde!!";

		        } else if (agora.getHour() > 19){
		            saudacao = "Boa noite!!! ";
		        }
		        System.out.printf("Olá, %s. Hoje é %s, %s.%n", nome, diaSemana, saudacao.toUpperCase());


		  }
}

	

