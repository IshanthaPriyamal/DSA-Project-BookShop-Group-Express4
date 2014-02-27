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
     
     public int countNodes() {
         return countNodes(root);
     }
    
     private int countNodes(BSTNode r){
         if (r == null)
             return 0;
         else{
             int l = 1;
             l += countNodes(r.getLeft());
             l += countNodes(r.getRight());
             return l;
         }
     }
     
     public void inorder(){
         inorder(root);
     }

     private void inorder(BSTNode r){
         if (r != null){
             inorder(r.getLeft());
             System.out.println(r.getBname() +" ");
             inorder(r.getRight());
         }
     }
    
     public void preorder(){
         preorder(root);
     }

     private void preorder(BSTNode r){
         if (r != null){
             System.out.println(r.getBname() +" ");
             preorder(r.getLeft());             
             preorder(r.getRight());
         }
     }
    
     public void postorder(){
         postorder(root);
     }

     private void postorder(BSTNode r){
         if (r != null){
             postorder(r.getLeft());             
             postorder(r.getRight());
             System.out.println(r.getBname() +" ");
         }
     }   
     
 }