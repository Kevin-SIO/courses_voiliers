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
}
