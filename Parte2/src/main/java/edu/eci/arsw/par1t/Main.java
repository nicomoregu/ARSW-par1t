package edu.eci.arsw.par1t;

import edu.eci.arsw.par1t.priv.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		DataProcessor dp=ac.getBean(DataProcessor.class);
		int[] res=dp.processData();
		
		Logger.log("Data processing done. Printing data sample...");
		for (int i=0;i<res.length;i++){
			if (i%10000==0){
				System.out.println("Element No."+i+":"+res[i]);	
			}			
		}
		
	}
	
}
