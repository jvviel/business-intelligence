package br.edu.fema.bi.util;

import java.sql.Timestamp;

public class Util {

	public static String codigo() {
		Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
		String codigo = dataDeHoje.toString();
		codigo = codigo.replace(":", "");
		codigo = codigo.replace("-", "");
		codigo = codigo.replace(" ", "");
		codigo = codigo.replace(".", "");
		
		return codigo;
	}
}
