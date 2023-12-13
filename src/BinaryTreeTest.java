// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTreeTest
{
   public static void main ( String [] args )
   {
      BinaryTree<Integer> bt = new BinaryTree<Integer> ();
   
/*
      // test for single node
      bt.root = new BinaryTreeNode<Integer> (10, null, null);
*/      
   
/*
      // test for 2-level tree
      bt.root = new BinaryTreeNode<Integer> (
          1, 
          new BinaryTreeNode<Integer> (2, null, null),
          new BinaryTreeNode<Integer> (3, null, null)
      );
*/      


      // test for 3-level tree
      bt.root = new BinaryTreeNode<Integer> (
          1, 
          new BinaryTreeNode<Integer> (
            2, 
            new BinaryTreeNode<Integer> (
              4, 
              null, 
              null
            ), 
            new BinaryTreeNode<Integer> (
              5, 
              null, 
              null
            )
          ),
          new BinaryTreeNode<Integer> (
            3, 
            new BinaryTreeNode<Integer> (
              6, 
              null, 
              null
            ), 
            null
          )
         );   
      

      System.out.println ("Height : " + bt.getHeight ());
      System.out.println ("Size : " + bt.getSize ());
      System.out.println ("Inorder : ");
      bt.inOrder ();
      System.out.println ("Preorder : ");
      bt.preOrder ();
      System.out.println ("Postorder : ");
      bt.postOrder ();
      System.out.println ("Level order : ");
      bt.levelOrder ();
   }
}
