package com.cognizant.demo;



public class DeprecatedDemo {
	
	@Deprecated
	public void x(){
		System.out.println("--x--");
	}
	
	public void xNew(){
		System.out.println("--xNew--");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		java.util.Date date=new java.util.Date();
		date.getMonth();
	}

}
