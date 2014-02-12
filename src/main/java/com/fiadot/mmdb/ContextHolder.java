package com.fiadot.mmdb;



public class ContextHolder {
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	
	public static void setType(String dbType) {
		contextHolder.set(dbType);
	}

	public static String getType() {
		return ((String) contextHolder.get());
	}

	public static void clearType() {
		contextHolder.remove();
	}
		  
}

