package com.afsinergia.org.utils;

import java.util.Calendar;

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
		
		if(d != null){
			System.out.println("!= null fecha"+sdf.format(d));
			
			return sdf.format(d);
		}
		
		else{
			Calendar myCal = Calendar.getInstance();
			myCal.set(Calendar.YEAR, 1000);
			myCal.set(Calendar.MONTH, 1);
			myCal.set(Calendar.DAY_OF_MONTH, 1);
			
			System.out.println("== null fecha"+sdf.format(myCal.getTime()));
			
			return sdf.format(myCal.getTime());
		}
	}
	
	public char convertBooleanToBit(Boolean valor)
	{
		if(valor)
			return '1';
		else
			return '0';
	}
	//Main de pruebas
	public static void main(String[] args) {

		Utilidades u = new Utilidades();
		System.out.println(u.getFecha(null));
	}
}
