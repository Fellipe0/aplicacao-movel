package back.api.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * @author suleiman-am
 *
 */
public class DateUtil {

	private static SimpleDateFormat formatador = new SimpleDateFormat();
	public static String FORMATO_PADRAO_HORAS = "dd/MM/yyyy HH:mm:ss";
	public static String FORMATO_PADRAO = "dd/MM/yyyy";

	public static String getDiaMesAno(Date data) {
		verificarData(data);
		formatador.applyPattern("dd/MM/yyyy");
		return formatador.format(data);
	}

	public static Date parseData(String data, String formato) throws ParseException {
		formatador.setTimeZone(TimeZone.getTimeZone("America/Recife"));
		formatador.applyPattern(formato);
		return formatador.parse(data);
	}

	public static String getDiaMesAnoHorasMinutosSegundos(Date data, Date data2) {
		if (data != null) {
			return formatador.format(data);
		} else {
			return formatador.format(data2);
		}
	}

	public static String getDiaMesAnoHorasMinutosSegundos(Date data) {
		verificarData(data);
		formatador.applyPattern(FORMATO_PADRAO_HORAS);
		return formatador.format(data);
	}

	public static String getHorasMinutosSegundos(Date data) {
		verificarData(data);
		formatador.applyPattern("HH:mm:ss");
		return formatador.format(data);
	}

	public static String getDataPorExtenso(Date data) {
		verificarData(data);
		formatador.applyPattern("EEEEE dd 'de' MMMMM 'de' yyyy");
		return formatador.format(data);
	}

	public static String getDataPorExtensoSemCidade(Date data) {
		verificarData(data);
		formatador.applyPattern("dd 'de' MMMMM 'de' yyyy");
		return formatador.format(data);
	}

	public static String getDataAtualPorExtensoSemCidade() {
		return getDataPorExtensoSemCidade(new Date());
	}

	public static String getDataAtualPorExtenso() {
		return getDataPorExtenso(new Date());
	}
	
	public static String getDataFormatadaPadrao(Date data) {
		verificarData(data);
		formatador.applyPattern(FORMATO_PADRAO);
		return formatador.format(data);
		
	}

	public static String getDataFormatada(Date data, String formato) {
		verificarData(data);
		verificarFormato(formato);
		formatador.applyPattern(formato);
		return formatador.format(data);

	}

	public static String getDataAtualFormatada(String formato) {
		verificarFormato(formato);
		formatador.applyPattern(formato);
		return formatador.format(new Date());

	}

	public static void verificarData(Date data) {
		if (data == null) {
			throw new IllegalArgumentException("A data n??o pode ser nula!");
		}
	}

	public static void verificarFormato(String formato) {
		if (StringUtil.isNullOrEmpity(formato)) {
			throw new IllegalArgumentException("O formato n??o pode ser vazio!");
		}
	}

	public static String getDataFormatoSQL(String data) {
		if (StringUtil.isNotNullOrEmpity(data)) {
			String[] array = data.split("/");
			return String.format("%s-%s-%s", array[2], array[1], array[0]);
		}
		return "";
	}

	public static Date getDataDe(String data) throws ParseException {
		return StringUtil.isNullOrEmpity(data) ? DateUtil.parseData("01/01/1990", "dd/MM/yyyy")
				: DateUtil.parseData(data, "dd/MM/yyyy");
	}

	public static Date getDataAte(String data) throws ParseException {
		return StringUtil.isNullOrEmpity(data) ? dataAdd(new Date(), Calendar.DAY_OF_MONTH, 1)
				: DateUtil.parseData(data + " 23:59:59", "dd/MM/yyyy HH:mm:ss");
	}

	public static Date dataAdd(Date data, int field, int value) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(data);
			calendar.add(field, value);
			return calendar.getTime();
		} catch (Exception e) {
			return data;
		}
	}
	
	public static Long diferencaEntreDataEmDias(Date data1, Date data2) {
		try {
			final long dt = (data1.getTime() - data2.getTime()) + 3600000;
			return dt / 86400000L;
		} catch (Exception e) {
			return 0l;
		}
	}
	
	public static Date arrumarDataParaBuscaDoIgpdi(Date data) {
		try {
			data = data == null ? new Date() : data;
			Calendar c = Calendar.getInstance();
			c.setTime(data);
			c.set(Calendar.DAY_OF_MONTH, 01);
			c.add(Calendar.MONTH, 1);
			return c.getTime();
		} catch (Exception e) {
			return data;
		}
	}
}
