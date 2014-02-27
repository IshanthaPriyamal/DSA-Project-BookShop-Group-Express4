/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookshop;

/**
 *
 * @author Ishantha
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class BookShop {
    BST bst=new BST();
    int x=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public void UserInsert(String bname,String aname,String sname,int isbn){ 
        System.out.println(x);
        try{
            if(x==0){
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
            
            }
            x=1;
            System.out.println("");  
            bst.insert(bname, aname, sname, isbn);// Insert data to BST
           
            System.out.println("");  
        } 
        catch (IOException | BiffException ex) {
            Logger.getLogger(BookShop.class.getName()).log(Level.SEVERE, null, ex);
        }                   
    } 
    
      public void CountNodes(){  
          bst.countNodes();
      }  
      
      public void TreeTrevalsal(){         
          bst.postorder();           
          bst.preorder();          
          bst.inorder();
      }  
    
}
