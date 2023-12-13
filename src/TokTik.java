/*
 * @author Tendai Nyevedzanai
 *         NYVTEN001
 * a class that runs as the user interface for all prompts in our system
 */
import java.io.File;
//import java.util.ArrayList;
import java.util.Scanner;
//import java.io.File;
import java.io.FileNotFoundException;


/*
 * @author tendai k nyevedzanai
 * @date 15/04/2023
 * TokTik class that contains all the prompts within a class
 * 
 */

public class TokTik {
   /*declaration of BinarySearchTree object of the type account
    * which can be used in the instance of the class.
    with variable name tree
     */
    static BinarySearchTree<Account> tree= new BinarySearchTree<>();
       /*
        * main class to make the out puts
        */
    public static void main(String[] args) {

        
       
        Scanner firstInput=new Scanner(System.in);
        int input1;
        /*
         * @function while loop runs until input is 8 as in this method the system is set to exit, thus true
         */
        while(true){
            
       
            /*
             * menu prompts for the user to give
             */

            System.out.println(
                "Choose an action from the menu:\n1. Find the profile description for a given account\n2. List all accounts\n3. Create an account\n4. Delete an account\n5. Display all posts for a single account\n6. Add a new post for an account\n7. Load a file of actions from disk and process this\n8. Quit");

            System.out.println("Enter your choice:"); 
            /*reads in a line of text using .nextLine then returns the value as an integer */
            //input1 = Integer.parseInt(firstInput.nextLine());
            /*
             * @function if the user inputs 1 the following method will request for account name which it will use
             *           to check if it exists in our database using a tempAccount object with the account name.
             * @implementation description is set null as we searching for it in this case
             *                 account object will simply use the name
             *                 an object of BinaryTreeNode type account is made to search for such an account in a node using our tree object 
             */
            input1 = Integer.parseInt(firstInput.nextLine());
            if (input1==1){
                System.out.println("Enter the account name:");// can also add a password stage for creativity
                String inputAccountName=firstInput.nextLine();// changed from NEXTLINE() TO NEXT()
                //String placeHolder="placeHolder";
                Account tempAccount = new Account(inputAccountName, null);
                BinaryTreeNode<Account> inDataBase=tree.find(tempAccount);
                /**Create part for prompt 1 */
                /*
                 * @function if we enter the node and dont find the account then it is null, in such a case we ask the user if they wish to create an account
                 *           if yes we just use the same account name they entered and just add a description on it
                 * 
                 * @implementation a new account object of the name account1 is created with arugements of the account name and the new description
                 *                 now the object of binary search tree is used to insert the newly made account
                 */
                if(inDataBase==null){
                    System.out.println("The account you entered does not exist do you wish to create a new one\nYes-Y\nNo-N");
                    String createNewAccount=firstInput.nextLine();
                    if(createNewAccount.equals("Y")){
                        System.out.print("Enter the new description:");
                        String accDescript= firstInput.nextLine();
                        Account account1= new Account(inputAccountName, accDescript);
                        tree.insert(account1);
                        System.out.println("The account has been added:)");// to simply notify the user the account has been added
                        
                    }
                    else{/*if the user inputs N then they will return to main menu to start the prompt again */
                        System.out.println("Return to menu");
                        
                    }
                }
                else{/* if the account name does exist then the coresponding description is printed */
                    String pointNode =inDataBase.data.getDescription();
                    System.out.println("The account description is as follows:"+pointNode);
                    
                }
                /**END of creativity */
               
                }
                //else {  System.out.println("The profile was not found"); }
                    
                
            
            if(input1==2){
                /*Traverses through the database using the object of binary search tree
                 * wich is tree, then prints out the values using an inorder traversal
                 */
                tree.inOrder();

                

            }
             /*if the input is 3 we request the users account name
              * account decription and store each in respective  variables
              @param this takes in the account name and account description as parameters

              an account object is created and both string variables stored
              the account is then stored
              */
            if(input1==3){
               
                System.out.println("Enter the name of the account:");

                String acccName=firstInput.nextLine();
                System.out.println("Enter the description:");
                String accDesctipt=firstInput.nextLine();

                Account account1 = new Account(acccName, accDesctipt);
                tree.insert(account1);
            
            }/*@ param 
            this prompt option will basically search through the database using the tree object
            and there after delete the value using the delete method
            null is used a variable type since we can just use an account name is used to ssearch
            once account is deleted a string is printed out
             */
            if(input1==4){
                
                System.out.println("Enter the account to be deleted:");
                String accNum= firstInput.nextLine();
                
                Account account= new Account(accNum, null);
                tree.delete(account);
                System.out.println("Account deleted");
            }
            /*
             * @param input5 takes in a string of the account name
             * 
             * uses account object to search for account name then 
             * account is searched and in that node the posts of the account are printed out
             */
            if(input1==5){
                System.out.println("Enter the account name:");
                String input5=firstInput.nextLine();
                Account account= new Account(input5, null);//can use null instead of a substitute value string
                System.out.println("The posts  for the class are:"+tree.find(account).data.postFields);// returns an entire arrayList of postFields
            }
               
            if(input1==6){
               
                System.out.println("Enter the account name:");
                String accName= firstInput.nextLine();
                System.out.println("Enter the video title:");
                String accTitle= firstInput.nextLine();
                System.out.println("Enter the video description:");
                String vidDescript= firstInput.nextLine();
                System.out.println("Enter the number of likes:");
                int likes = Integer.parseInt(firstInput.nextLine());/*@param takes in an integer then converts to a string */
/*
 * posts object to atake in the new input values 
 * accoun account object to take in the account name
 * the account object is used to search fr the account using tree object
 * 
 * once account node is found the posts are inserted in that account then in that node 
 */
                Posts post= new Posts(accTitle, vidDescript, likes);
                Account account= new Account(accName, null);
                BinaryTreeNode<Account> acca=tree.find(account);
                //final BinarySearchTree<Account> tree= new BinarySearchTree<>();
                acca.data.postFields.add(post);
                System.out.println("posts added!!");
            
                
                //tree.find(acca);
                //acca.insert(post);3

                //Posts posts= new Posts();

            }
            if(input1==7){
                // Load a file of actions from disk and process this
                /*
                 * @ param reads in a file and splits the values into an array
                 */
                try{
                    File file = new File("dataset.txt");
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()){//checks if there still more lines of text to raed
                        String  firstString=scanner.nextLine();
                        String[] prompts= firstString.split(" ");// splits the values into an array
                        String  createAccount="Create";
                        String addAccount="Add";
                        
                        
                        if (prompts[0].equals(createAccount)){// a condition in which the first string in the array is equal to the word create
                                int endIndex=prompts.length-1;//checks index positions of the values
                                String accOwner=prompts[1];
                                String accDescript=prompts[2]+prompts[endIndex];
                                Account account = new Account(accOwner, accDescript);
                                tree.insert(account);
                            }
                            
                        else if (prompts[0].equals(addAccount)){
                            int endIndex=prompts.length-1;
                            String accOwnerHere=prompts[1];
                            int vidLikes=Integer.parseInt(prompts[2]);
                            String videoDescript=prompts[3]+prompts[endIndex];
                            Posts posts = new Posts(addAccount, videoDescript, vidLikes);
                            Account account= new Account(accOwnerHere, null);
                            BinaryTreeNode<Account> nodeFinder= tree.find(account);
                            nodeFinder.data.postFields.add(posts);
                                

                            }
                        else{System.out.println("cannot find required command!!");}


                        
                    }
                    scanner.close();// when done reading the text file we close the scanner
                }catch(FileNotFoundException e){System.out.println("File not Found");}
            }
            if(input1==8){
                //exit and print the following
                System.out.println("Bye!");
                System.exit(0);
            }
            if(input1<1||input1>8){// this condition prints out a string when the input value is not one of the strings
                System.out.println("Unfortunately this action does not exist:(\nPlease try again.");
            }
           
           
        }        
        
    }
}

