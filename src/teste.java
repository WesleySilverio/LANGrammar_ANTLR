import java.util.Scanner;

public class teste {
	public static void main(String[] args) {
		Scanner _scTrx = new Scanner(System.in);
		String a;
		String b;
		int x;
		double z;
		double k;
		x = (4 * 10) / 5 + 2 - 7;
		k = 3.5;
		z = 4.3 + 5.8 - k + 2;
		b = "compiladores";
		System.out.println("segue o valor do inteiro 'x':");
		System.out.println(x);
		System.out.println("abaixo estará o valor do ponto flutuante 'z':");
		System.out.println(z);
		System.out.println("e por último o valor da String 'b'");
		System.out.println(b);
		System.out.println("\n");
		System.out.println("agora é hora de digitar !!! escreva uma frase:");
		a = _scTrx.nextLine();
		System.out.println("repetindo o que você escreveu:");
		System.out.println(a);
		System.out.println("\n");
		if (x < 5) {
			do {
				x = x - 1;
			} while (x != 0);
			if (x == 0) {
				System.out.println("a condição 'se' foi ativada, logo x chegou ao valor zero!");
			}
		} else {
			System.out.println("a condição 'senao' foi ativada, logo x é maior que 5");
		}
		while (k <= z) {
			k = k + 1;
		}
		System.out.println("looping finalizado, agora k é maior que z. Seu valor é:");
		System.out.println(k);

	}
}
