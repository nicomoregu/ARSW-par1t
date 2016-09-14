package edu.eci.arsw.par1t;

import edu.eci.arsw.par1t.priv.DataLoaderOne;
import edu.eci.arsw.par1t.priv.Logger;
import edu.eci.arsw.par1t.priv.SorterTwo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataProcessor {

    private DataLoader dl;
    private Sorter srt;
    public DataLoader getDl() {
        return dl;
    }

    public void setDl(DataLoader dl) {
        this.dl = dl;
    }

    public Sorter getSrt() {
        return srt;
    }

    public void setSrt(Sorter srt) {
        this.srt = srt;
    }
    
    public int[] processData(){

        Logger.log("Loading data...");

        int[] data=dl.loadData();

        Logger.log("Sorting data...");

        srt.sort(data);

        Logger.log("Data sorted...");

        return data;

    }
	
}
