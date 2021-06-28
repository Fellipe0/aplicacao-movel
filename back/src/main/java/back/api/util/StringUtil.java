package back.api.util;

public class StringUtil {
	/**
	 * 
	 * @param texto
	 * @return
	 */
	public static String tratarStringUninformed(String texto) {
		texto = texto.equalsIgnoreCase(ConstantesUtil.UNINFORMED) ? "" : texto;
		return texto;
	}

	public static String tratarStringUndefinedAndStringNull(String texto) {
		texto = texto == null || texto.equalsIgnoreCase(ConstantesUtil.UNDEFINED) || texto.equalsIgnoreCase("null") ? ""
				: texto;
		return texto;
	}

	public static String tratarStringUndefinedAndStringNullReturnPorcentOrText(String texto) {
		texto = texto == null || texto.equalsIgnoreCase(ConstantesUtil.UNDEFINED) || texto.equalsIgnoreCase("null") ? ""
				: texto;
		return texto.equals("") ? "%":texto;
	}

	public static Boolean isEmpity(String texto) {
		return texto.trim().equals("");
	}

	public static Boolean isNull(String texto) {
		return texto == null;
	}

	public static Boolean isNotEmpity(String texto) {
		return !isEmpity(texto);
	}

	public static Boolean isNotNull(String texto) {
		return !isNull(texto);
	}

	public static Boolean isNullOrEmpity(String texto) {
		return isNull(texto) || isEmpity(texto);
	}

	public static Boolean isNotNullOrEmpity(String texto) {
		return isNotNull(texto) && isNotEmpity(texto);
	}

	public static String isNotNullOrEmpityReturnArgOrThis(String texto, String arg) {
		return isNotNullOrEmpity(texto) ? texto : arg;
	}

	public static String isNotNullOrEmpityReturnVazioOrThis(String texto) {
		return isNotNullOrEmpity(texto) ? texto : "";
	}

	public static String isNotNullOrEmpityReturnTracoOrThis(String texto) {
		return isNotNullOrEmpity(texto) ? texto : "-";
	}

	public static String tratarObjectStringNotNull(Object object) {
		return object != null ? object.toString() : "-";
	}

	public static Integer compareTo(String a, String b) {
		a = a == null ? "" : a;
		b = b == null ? "" : b;
		return a.compareTo(b);
	}

	public static String getFormactTextHTML(String texto) {
		if (texto == null) {
			return "";
		}

		if (texto.matches("<.*?(label|class).*?>")) {
			texto = texto.replaceAll("</div>", "\n");
			texto = texto.replaceAll("<.*?>", "");
		}
		return texto;
	}

	public static String maskMoney(Double value) {
		if (value == null)
			return null;
		return maskMoney(value.toString());
	}

	public static String maskMoney(String value) {
		if (isNullOrEmpity(value))
			return value;
		if (value.toString().indexOf("R$") > -1) {
			value = value.replace(".", "");
			value = value.split(" ")[1].replace(",", ".");
		}
		String decimal = value.split("[.\\^]")[1];
		String valueToTransform = value.split("[.\\^]")[0];
		int begin = 0;
		for (int i = valueToTransform.length() - 1, j = 1; i > -1; i--) {
			if ((j % 3 == 0) && (i - 1 > -1)) {
				valueToTransform = valueToTransform.substring(begin, i) + "." + valueToTransform.substring(i);
				j++;
			} else {
				if (valueToTransform.charAt(i) != '.') {
					j++;
				}
			}
		}
		if (decimal.length() == 1) {
			return valueToTransform + "," + decimal + "0";
		} else {
			if (decimal.length() < 1) {
				return valueToTransform + "," + "00";
			} else {
				return valueToTransform + "," + decimal;
			}
		}
	}

	public static Double duasCasas(Double valorAtualizar) {
		return new Double(StringUtil.duasCasas(valorAtualizar.toString()));
	}

	public static String duasCasas(String valorAtualizar) {
		int inicio = 0;
		int ponto = valorAtualizar.indexOf('.');
		int fim = valorAtualizar.length();
		String valorNotDecimal = valorAtualizar.substring(inicio, ponto);
		String decimal = valorAtualizar.substring(ponto + 1, fim);
		if (decimal.length() > 2) {
			if (new Double(decimal.charAt(2) + "") > 5) {
				if (new Double(decimal.charAt(1) + "") + 1 > 9) {
					decimal = new Double(new Double(decimal.charAt(0) + "") + 1).toString()
							+ new Double(new Double(decimal.charAt(1) + "") + 1).toString().charAt(1);
				} else {
					decimal = decimal.charAt(0) + "" + new Double(new Double(decimal.charAt(1) + "") + 1).toString();
				}
				int ponto2 = decimal.indexOf(".");
				decimal = decimal.substring(0, ponto2);
			} else {
				decimal = (decimal.charAt(0) + "") + (decimal.charAt(1) + "");
			}
			valorAtualizar = valorNotDecimal + "." + decimal;
		}
		return valorAtualizar;
	}
}
