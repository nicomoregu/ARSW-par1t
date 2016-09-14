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

import co.edu.eci.isw.asynchronousdatasource.DataSource;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class DataSourceStream extends Thread{
    
    private Bandera band;
    
    private ConcurrentLinkedQueue<Integer> queue;
    
    Random r=new Random(System.currentTimeMillis());

    public DataSourceStream(Bandera band) {
        this.queue = new ConcurrentLinkedQueue<>();
        this.band = band;
    }

    public void run() {
        while (true) {
            queue.add(DataSource.getInstance().getNextEntry());
            band.setBand(true);
            synchronized(band){
                band.notifyAll();
            }
            System.out.println("Buffer size:" + queue.size());
        }
    }
    
    public Integer getData(){
        if(queue.size()<=1){
            band.setBand(false);
        }
        return queue.poll();
    }
    
    public Integer getQueueSize(){
        return queue.size();
    }
}
