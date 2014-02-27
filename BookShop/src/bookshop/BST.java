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
 
 class BST {
     private BSTNode root;
    
     public BST(){
         root = null;
     }
     
     public void insert(String bname,String aname,String sname,int isbn) {
         root = insert(root, bname,aname,sname,isbn);
     }
    
     private BSTNode insert(BSTNode node, String bname,String aname,String sname,int isbn){
         if (node == null)
            node = new BSTNode(bname,aname,sname,isbn);
         else{
             int c=bname.compareTo(node.getBname());
             if (c <= 0)
                 node.left = insert(node.left, bname,sname,sname,isbn);
             else
                 node.right = insert(node.right, bname,aname,sname,isbn);
         }
         return node;
     }
     
 }