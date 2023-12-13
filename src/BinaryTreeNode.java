// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
/*
 * @ param node
 * node class takes the datatype we need to put om 
 * use
 * checks left and right
 */
public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   /*
    * constructor takes in the value of data left and right side with data type of
    class
    */
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
   }
   
   BinaryTreeNode<dataType> getLeft () { return left; }
   BinaryTreeNode<dataType> getRight () { return right; }
}
