/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookshop;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author Ishantha
 */
public class FileData {
    
    public String[] GetData(String bname){
        String []book=new String[3];
        try{
                Workbook workbook = Workbook.getWorkbook(new File("BookShop_Express4.xls"));     
                Sheet sheet = workbook.getSheet(0); 
                int row=sheet.getRows();
                
                      for(int i=1;i<row;i++){
                      Cell cbn = sheet.getCell(0,i);
                      String bn=cbn.getContents();  
                        
                      if(bname.equals(bn)){
                          Cell can = sheet.getCell(1,i);
                          book[0]=can.getContents(); 
                  
                          Cell csn = sheet.getCell(2,i);
                          book[1]=csn.getContents(); 
                          
                         Cell cin = sheet.getCell(3,i);
                         book[2]=cin.getContents(); 
                         i=row;
                      }
                }                                    
                workbook.close();            
           }
           catch(IOException | BiffException | IndexOutOfBoundsException a){
                System.out.println(a);           
           } 
        return book;
    }
    
    public  void SetTree(){
        
        try{
            BST bst = new BST();
            Workbook workbook = Workbook.getWorkbook(new File("BookShop_Express4.xls"));
            Sheet sheet = workbook.getSheet(0);
            int row=sheet.getRows();
            for(int i=1;i<row;i++){
                Cell cbn = sheet.getCell(0,i);//Get Book Name from Excel File
                String bn=cbn.getContents();
            
                Cell can = sheet.getCell(1,i);//Get Author Name from Excel File
                String an=can.getContents();
            
                Cell csn = sheet.getCell(2,i);//Get Surame from Excel File
                String sn=csn.getContents();
            
                Cell cisbn = sheet.getCell(3,i);//Get ISBN from Excel File
                int isb=Integer.parseInt(cisbn.getContents());
                bst.insert(bn,an,sn,isb); //Create BST from Excel file data
            }
            workbook.close();         
            
            System.out.println("");          
        } 
        catch (IOException | BiffException ex) {
            Logger.getLogger(BookShop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
