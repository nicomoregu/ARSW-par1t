package edu.eci.arsw.par1t.priv;

import java.util.Random;

import edu.eci.arsw.par1t.DataLoader;

public class DataLoaderOne implements DataLoader{

	public static final int MAX_RES_SIZE = 99999999;

	@Override
	public int[] loadData() {
		Random rn=new Random(System.currentTimeMillis());
		
		int[] res=new int[MAX_RES_SIZE];
		
		for (int i=0;i<MAX_RES_SIZE;i++){
			if (i%10003==0){
				res[i]=-1;
			}
			else{
				res[i]=rn.nextInt(99999999);	
			}			
			
			if (i>MAX_RES_SIZE-10000){
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}							
			}
		}
		
		// TODO Auto-generated method stub
		return res;
	}

    @Override
    public String getName() {
        return "DataLoaderOne";
    }

	
	
}
