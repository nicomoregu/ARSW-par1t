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

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String args[]) {
        Bandera band = new Bandera();
        DataSourceStream dss = new DataSourceStream(band);
        DataStreamProcessor dsps[] = new DataStreamProcessor[30];
        
        
        for (int i=0;i<dsps.length;i++){
            dsps[i]=new DataStreamProcessor("Thread #"+i,dss,band);
        }

        new AbortGUI(dsps).open();
        
        dss.start();
        
        for (DataStreamProcessor dsp : dsps) {
            dsp.start();
        }
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(">>>>>" + ProcessStatistics.getDataCount());

    }

}

class AbortGUI extends JFrame {

    private DataStreamProcessor dsps[];

    public void open() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLayout(new FlowLayout());      // set the layout manager
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(200, 100);                
                JButton abortButton = new JButton("Abort");
                abortButton.addActionListener(
                        new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < dsps.length; i++) {
                            dsps[i].setAbortRequested(true);
                        }
                        System.out.println("Received items count:" + ProcessStatistics.getDataCount());
                        System.exit(0);
                    }
                }
                );

                add(abortButton);
                setVisible(true);

            }
        });
    }

    public AbortGUI(DataStreamProcessor[] dsps) {

        this.dsps = dsps;
    }

}
