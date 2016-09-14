/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.arsw.datastream;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class DataStreamProcessor extends Thread{
    private DataSourceStream dss;
    private ProcessStatistics ps=new ProcessStatistics();
    
    private boolean abortRequested=false;
    
    public DataStreamProcessor(String name,DataSourceStream dss) {
        super(name);
        this.dss = dss;
    }

    public void setAbortRequested(boolean abortRequested) {
        this.abortRequested = abortRequested;
    }
    
    
    
    @Override
    public void run(){
        while(!abortRequested){
            Integer entry=dss.getData();
            if (entry!=null){
                    System.out.println("Thread "+this.getName()+" processed:"+ entry);
                    ps.incrementCount();
            }            
        }
    }
}
