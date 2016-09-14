package edu.eci.arsw.par1t;

import edu.eci.arsw.par1t.priv.Logger;


public class Main {

	public static void main(String[] args) {
		
		DataProcessor dp=new DataProcessor();
		int[] res=dp.processData();
		
		Logger.log("Data processing done. Printing data sample...");
		for (int i=0;i<res.length;i++){
			if (i%10000==0){
				System.out.println("Element No."+i+":"+res[i]);	
			}			
		}
		
	}
	
}
