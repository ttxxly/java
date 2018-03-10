package com.ttxxly.test;

public interface Hello {
	
	default void getType(String string) {
	System.out.println(string);
	};	
	static void getType(double dd) {
						dd = 2.0;	
	};
	public static void main(String[] args) {
		
		
	}
}
