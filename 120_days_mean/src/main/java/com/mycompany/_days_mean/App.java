/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._days_mean;

import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import com.mycompany._days_mean.algos;
/**
 *
 * 
 * 
 * 
 * @author s
 */

public class App {
    //delimiter on csv file
  public static final String COMMA_DELIMITER = ",";
 
    public static void main(String[] args) throws FileNotFoundException, IOException, PythonExecutionException {
           
         //datas from price
        Vector <Double> price_closure = new Vector();
        //read the  closure price of market from data  file to a vector 
        String csvFile_Source ="infomoney (changed ; to , on separator  )";
        String csvFile = "IVVB11-(InfoMoney).csv";
        String line,auxx;
     //   List closure_prices =new List();
        String csvSplitBy = ";";
       int i=1,j=0;
       double aux;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                // Process the data array (e.g., print values)
                 i=1;
                for (String value : data) {
                   // System.out.print(value );
                   i=i+1;
                   ///i=4 for use closing datas ,i=3 for use opening data
                   if(i==4 && j>0)
                   { /// remove special characther  on initial position and final position
                       auxx=value.substring(1, value.length() - 1);
                       //change characther , to .
                       auxx =auxx.replace(",", ".");
                      aux=Double.parseDouble(auxx);
                       System.out.println(auxx );
                       
                     //ignore the last number that its change from void to 0 
                       if(aux ==0)
                           continue;
                       else 
                           price_closure.add(aux);
                    //
                   }
                }
                j=j+1;
               // System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
          System.out.println( "size vector price ="+price_closure.size());
        //need python and matplotlib to run 
          Plot plt = Plot.create();
          plt.plot()
    .add(price_closure)
    .label("label")
    .linestyle("-");
          plt.xlabel("xlabel");
          plt.ylabel("ylabel");
          plt.title("Title!");
plt.legend();
plt.show();
          
          
    }
}
