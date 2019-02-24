package com.cognizant.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DynamicIntializationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//static intialization
		MyClass mc=new MyClass();
		mc.x(10,20);
		
		//Dynamic Intialization
		Class<MyClass> classData=MyClass.class;//class Data
		
		//Reflection API
		try {
			Constructor<MyClass> constructor=classData.getConstructor();
			MyClass mc1=constructor.newInstance();
			
			
			Method xMethod=classData.getMethod("x",int.class,int.class);
			xMethod.invoke(mc1, new Object[]{30,40});
			
			//Alternative
			
			MyClass mc2=(MyClass)Class.forName("com.cognizant.demo.MyClass").newInstance();
			
			xMethod.invoke(mc2, new Object[]{40,50});
			
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
