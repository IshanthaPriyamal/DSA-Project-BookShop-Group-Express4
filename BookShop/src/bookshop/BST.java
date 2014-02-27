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
     
     public boolean search(String val){
         return search(root, val);
     }
    
     private boolean search(BSTNode r, String val){
         boolean found = false;
         while ((r != null) && !found){
             String rval = r.getBname();
             int c=val.compareTo(rval);
             if (c < 0)
                 r = r.getLeft();
             else if (val.compareTo(rval) > 0)
                 r = r.getRight();
             else{
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     
      public boolean isEmpty(){//check tree is empty
         return root == null;
     }
     
      public String delete(String k){
         String r=null;
         if (isEmpty())
             //System.out.println("Tree Empty");
             r="E";
         else if (search(k) == false)
             //System.out.println("Sorry "+ k +" is not present");
             r="NO";
         else{
             root = delete(root, k);
            // System.out.println(k+ " deleted from the tree");
             r="OK";
         }
         return r;
     }
     
     private BSTNode delete(BSTNode root, String k) {
         BSTNode p, p2, n;
              
         if (root.getBname().equals(k)){
             BSTNode lt, rt;
             lt = root.getLeft();
             rt = root.getRight();
             if (lt == null && rt == null)
                 return null;
             else if (lt == null){
                 p = rt;
                 return p;
             }
             else if (rt == null){
                 p = lt;
                 return p;
             }
             else{
                 p2 = rt;
                 p = rt;
                 while (p.getLeft() != null)
                     p = p.getLeft();
                 p.setLeft(lt);
                 return p2;
             }
         }
         int c=k.compareTo(root.getBname());
         
         if (c <0){
             n = delete(root.getLeft(), k);
             root.setLeft(n);
         }
         else{
             n = delete(root.getRight(), k);
             root.setRight(n);             
         }
         return root;
     }
 }
 
 