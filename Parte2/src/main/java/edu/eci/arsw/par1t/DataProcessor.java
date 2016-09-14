package edu.eci.arsw.par1t;

import edu.eci.arsw.par1t.priv.DataLoaderOne;
import edu.eci.arsw.par1t.priv.Logger;
import edu.eci.arsw.par1t.priv.SorterTwo;

public class DataProcessor {

	private DataLoaderOne dl1=new DataLoaderOne();
	private SorterTwo srt=new SorterTwo();
	
	public int[] processData(){
		
		Logger.log("Loading data...");
		
		int[] data=dl1.loadData();
		
		Logger.log("Sorting data...");
		
		srt.sort(data);
		
		Logger.log("Data sorted...");
		
		return data;
		
	}
	
}
