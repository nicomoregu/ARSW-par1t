package edu.eci.arsw.par1t.priv;

import java.util.Random;

import edu.eci.arsw.par1t.DataLoader;

public class DataLoaderTwo implements DataLoader{

	private static final int MAX_RES_SIZE = DataLoaderOne.MAX_RES_SIZE;

	@Override
	public int[] loadData() {
		Random rn=new Random(System.currentTimeMillis());
		
		int[] res=new int[MAX_RES_SIZE];
		
		for (int i=0;i<MAX_RES_SIZE;i++){
			
			if (i%30003==0){
				res[i]=-1;
			}
			else{
				res[i]=rn.nextInt(99999999);	
			}			
			
			if (i>MAX_RES_SIZE-5000){
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}							
			}
		}
		
		return res;
	}

	
	
}
