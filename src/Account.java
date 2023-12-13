/**
@Author Tendai Nyevedazanai
        NYVTEN001
@Date 18/04/23

a class that opperates the accounts 
 */
import java.util.ArrayList;

/***
class implements comparable to compare the accounts on each node
with datatype of account
@param of string accountName, description and arrayList postFields
 */
public class Account implements Comparable<Account> {
    // inserted a comment
    public String  accountName;
    public String description;
    ArrayList<Posts> postFields;
   

    /**
     * 
     * @param accountName
     * @param description

     */
    public Account(String accountName, String description){
    this.accountName=accountName;
    this.description=description;
    postFields= new ArrayList<>();
    }

    public String getAccountName(String name){
        return name;//getname()
    }
    /**
    compares current account to the account that exists
    compare to method to compare the accounts if they exhibit the same characteristics
     */

    public int compareTo(Account account){
        return getAccountName(accountName).compareTo(account.getAccountName(accountName)); //accountName.compareTo(another.accountName);
    }
    public String FindDes(String name){ return this.description;}//finds the destination of the account

    public int compareName(String names){ return this.accountName.compareTo(names);}

    public String toString(){
        return accountName;
    }


   
   /*
   @param getPostFields
    */
    public String getDescription(){
        return description;
    }
    public ArrayList<Posts> getPostFields(ArrayList<Posts> postFields){
        return postFields;
    }

    //public void add(Posts post) {
    //}
}