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
class BSTNode{
     BSTNode left, right;
     String bname;//bookname
     String aname;//author name
     String sname;//surname
     int isbn;//isbn
     
     public BSTNode() {
         left = null;
         right = null;
         bname = null;
     }
     
     public BSTNode(String bname,String aname,String sname,int isbn) {
        left = null;
        right = null;
        this.bname=bname;
        this.aname=aname;
        this.sname=sname;
        this.isbn=isbn; 
     }
    
     public void setLeft(BSTNode n){
         left = n;
     }
     
     public void setRight(BSTNode n){
         right = n;
     }
   
     public BSTNode getLeft(){
         return left;
     }
    
     public BSTNode getRight(){
         return right;
     }
     
     public void setData(String d){
         bname = d;
     }
 
     public String getBname(){
         return bname;
     }      
 }
 

 