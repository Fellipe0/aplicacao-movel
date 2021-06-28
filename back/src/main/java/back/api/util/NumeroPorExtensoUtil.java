package back.api.util;

/**
 * 
 * @author felipe-ll
 *
 */
public class NumeroPorExtensoUtil {

	public static String numeroExtenso(double valor, boolean dinheiro) {

		if (valor == 0)
			return ("zero");

		long inteiro = (long) Math.abs(valor); // parte inteira do valor
		double resto = valor - inteiro; // parte fracionária do valor

		String valorString = String.valueOf(inteiro);
		if (valorString.length() > 15)
			return ("Erro: valor superior a 999 trilhões.");

		String valorFim = "", saux, valorParte;
		String centavos = String.valueOf((int) Math.round(resto * 100));

		String[] unidade = { "", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze",
				"doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove" };
		String[] centena = { "", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos",
				"setecentos", "oitocentos", "novecentos" };
		String[] dezena = { "", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta",
				"noventa" };
		String[] qualificaS = { "", "mil", "milhão", "bilhão", "trilhão" };
		String[] qualificaP = { "", "mil", "milhões", "bilhões", "trilhões" };

		// definindo o extenso da parte inteira do valor
		int n, unid, dez, cent, tamanho, i = 0;
		boolean umReal = false, tem = false;
		while (!valorString.equals("0")) {
			tamanho = valorString.length();
			// retira do valor a 1a. parte, 2a. parte, por exemplo, para 123456789:
			// 1a. parte = 789 (centena)
			// 2a. parte = 456 (mil)
			// 3a. parte = 123 (milhões)
			if (tamanho > 3) {
				valorParte = valorString.substring(tamanho - 3, tamanho);
				valorString = valorString.substring(0, tamanho - 3);
			} else { // última parte do valor
				valorParte = valorString;
				valorString = "0";
			}
			if (!valorParte.equals("000")) {
				saux = "";
				if (valorParte.equals("100"))
					saux = "cem";
				else {
					n = Integer.parseInt(valorParte, 10); // para n = 371, tem-se:
					cent = n / 100; // cent = 3 (centena trezentos)
					dez = (n % 100) / 10; // dez = 7 (dezena setenta)
					unid = (n % 100) % 10; // unid = 1 (unidade um)
					if (cent != 0)
						saux = centena[cent];
					if ((n % 100) <= 19) {
						if (saux.length() != 0)
							saux = saux + " e " + unidade[n % 100];
						else
							saux = unidade[n % 100];
					} else {
						if (saux.length() != 0)
							saux = saux + " e " + dezena[dez];
						else
							saux = dezena[dez];
						if (unid != 0) {
							if (saux.length() != 0)
								saux = saux + " e " + unidade[unid];
							else
								saux = unidade[unid];
						}
					}
				}
				if (valorParte.equals("1") || valorParte.equals("001")) {
					if (i == 0) // 1a. parte do valor (um real)
						umReal = true;
					else
						saux = saux + " " + qualificaS[i];
				} else if (i != 0)
					saux = saux + " " + qualificaP[i];
				if (valorFim.length() != 0)
					valorFim = saux + ", " + valorFim;
				else
					valorFim = saux;
			}
			if (((i == 0) || (i == 1)) && valorFim.length() != 0)
				tem = true; // tem centena ou mil no valor
			i = i + 1; // próximo qualificador: 1- mil, 2- milhão, 3- bilhão, ...
		}

		if (valorFim.length() != 0 && dinheiro) {
			if (umReal)
				valorFim = valorFim + " real";
			else if (tem)
				valorFim = valorFim + " reais";
			else
				valorFim = valorFim + " de reais";
		}

		// definindo o extenso dos centavos do valor
		if (!centavos.equals("0") && dinheiro) { // valor com centavos
			if (valorFim.length() != 0) // se não é valor somente com centavos
				valorFim = valorFim + " e ";
			if (centavos.equals("1"))
				valorFim = valorFim + "um centavo";
			else {
				n = Integer.parseInt(centavos, 10);
				if (n <= 19)
					valorFim = valorFim + unidade[n];
				else { // para n = 37, tem-se:
					unid = n % 10; // unid = 37 % 10 = 7 (unidade sete)
					dez = n / 10; // dez = 37 / 10 = 3 (dezena trinta)
					valorFim = valorFim + dezena[dez];
					if (unid != 0)
						valorFim = valorFim + " e " + unidade[unid];
				}
				valorFim = valorFim + " centavos";
			}
		}
		return (valorFim);
	}
}
