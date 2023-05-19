import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		List<Corredor> corredores = new ArrayList<Corredor>();

		// Variáveis de apoio
		int quantCorredores = 50;
		int indiceMenorTempo = 0;
		float tempoCorredorAnterior = 0;
		float tempoAtual;
		float somaMediasF = 0;
		float somaMediasM = 0;
		int quantHomens = 0;
		int quantMulheres = 0;

		// Arrays para cálculo de tempo e média
		float[] tempoDeProvas = new float[quantCorredores];
		float[] mediaTempoSexoF = new float[quantCorredores];
		float[] mediaTempoSexoM = new float[quantCorredores];

		// chamando método de inicialização do projeto
		menu();

		// for para execução de parte lógica do problema
		for (int i = 0; i < quantCorredores; i++) {
			System.out.println("Digite o nome do corredor " + (i + 1) + "(Ex: João Silva): ");
			String nome = leitor.nextLine();

			System.out.println("Digite o sexo do corredor " + (i + 1) + "(feminino/masculino/f/m): ");
			String sexo = leitor.next();

			char sexoCorredor = sexo.charAt(0);

			while (sexoCorredor != 'f' && sexoCorredor != 'm' && sexoCorredor != 'F' && sexoCorredor != 'M') {
				System.out.println("Você digitou um sexo inválido!");
				System.out.println("Digite o sexo do corredor " + (i + 1) + " novamente: ");
				sexo = leitor.next();
				sexoCorredor = sexo.charAt(0);
			}
			System.out.println("Digite o tempo de prova do corredor " + (i + 1) + "(Ex: 3,45): ");
			tempoDeProvas[i] = leitor.nextFloat();

			tempoAtual = tempoDeProvas[i];

			if (sexoCorredor == 'f' || sexoCorredor == 'F') {
				quantMulheres++;
				mediaTempoSexoF[i] = tempoAtual;
				float media = mediaTempoSexoF[i];
				somaMediasF += media;
			} else if (sexoCorredor == 'm' || sexoCorredor == 'M') {
				quantHomens++;
				mediaTempoSexoM[i] = tempoAtual;
				float media = mediaTempoSexoM[i];
				somaMediasM += media;
			}

			if (tempoDeProvas[i] < tempoCorredorAnterior) {
				indiceMenorTempo = i;
			}

			tempoCorredorAnterior = tempoAtual;

			leitor.nextLine();

			Corredor corredor = new Corredor(nome, sexoCorredor, tempoAtual);

			corredores.add(corredor);

		}

		System.out.println("o menor tempo foi o do corredor " + (indiceMenorTempo + 1));

		System.out.println(corredores.get(indiceMenorTempo));

		// calculando média...
		float calculoMediaF = somaMediasF / quantMulheres;
		float calculoMediaM = somaMediasM / quantHomens;

		// exibindo resultado do cálculo da média de homens e mulheres
		System.out.println("A média de tempo das mulheres foi de " + calculoMediaF);
		System.out.println("A média de tempo dos homens foi de " + calculoMediaM);

		System.out.println("\nObrigado por utilizar nosso software :D :) ");
	}

	private static void menu() {
		System.out.println("Olá!!!");
		System.out.println("Seja bem vindo ao sistema de temporizador" + " da Corrida de São Silvestre");
		System.out.println("Vamos começar?" + "\n");
	}
}
