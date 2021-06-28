package back.api.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DoubleUtil {
	private static final DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
	
	public static Boolean isNull(Double valor) {
		return valor == null;
	}
	
	public static Boolean isNotNull(Double valor) {
		return !isNull(valor);
	}
	
	public static String parseDoubleToDinheiroComCifrao(Double valor) {
		return isNotNull(valor) ? "R$ " + df.format(valor) : "R$ 0,00";
	}
	
	public static String parseDoubleToDinheiroComCifrao(Double valor, DecimalFormat decimalFormat) {
		return isNotNull(valor) ? "R$ " + decimalFormat.format(valor) : "R$ 0,00";
	}
	
	public static String parseDoubleToDinheiroSemCifrao(Double valor) {
		return isNotNull(valor) ? df.format(valor) : "0,00";
	}
	
	public static Double getZeroOuValor(Double valor) {
		return isNotNull(valor) ? valor : 0.0;
	}
	
	public static Double diminuirValorPorPorcentagem(Double valor, Double porcentagem) {
		return getZeroOuValor(valor) * getZeroOuValor(porcentagem) / 100.0;
	}

	public static Double duasCasas(Double valorAtualizar) {
		return new Double(StringUtil.duasCasas(valorAtualizar.toString()));
	}
	
	/**
	 * @return valor1 / valor2 * 100
	 */
	public static Double calculaPorcentagem(Double valor1, Double valor2) {
		return getZeroOuValor(valor1) / getZeroOuValor(valor2) * 100.0;
	}
}
