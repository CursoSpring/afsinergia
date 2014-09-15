package com.afsinergia.org.utils;

public class Utilidades {

	public String getFechaActual()
	{
		java.util.Date date = new java.util.Date(); 
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.format(date);
	}

	public String getFecha(java.util.Date d)
	{
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d);
	}
	
	public char convertBooleanToBit(Boolean valor)
	{
		if(valor)
			return '1';
		else
			return '0';
	}
	/*Main de pruebas
	public static void main(String[] args) {

		Utilidades u = new Utilidades();
		System.out.println(u.getFechaActual());
	}*/
}
