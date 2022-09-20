package com.simplon.course_voilier.model;

import java.lang.reflect.Field;
import java.util.ArrayList;

public interface Model {

	public ArrayList<String> getAttributesValues();
	
	static ArrayList<String> getAttributes(Class<?> c){
		ArrayList<String> r = new ArrayList<>();
		
		for(Field f : c.getDeclaredFields()){
			r.add(f.getName());
		}
		
		return r;
	}
	
	static ArrayList<String> getAttributesClass(Class<?> c){
		ArrayList<String> r = new ArrayList<>();
		
		for(Field f : c.getDeclaredFields()){
			String fieldname = f.getGenericType().getTypeName();
			r.add(fieldname.substring(fieldname.lastIndexOf(".")+1));
		}
		
		return r;
	}
}
