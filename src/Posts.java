/**?
@ author Tendai Nyevedzanai 
         NYVTEN001
@date    17/04/23         
         a class that runs the post field values
@param  takes in the string values of title, videoname and the int of likes

 */
public class Posts{
    public String title;
    public String videoName;
    private int likes;
/**
a constructor that takes in the given values of the class posts
 */
public Posts(String t, String v, int l){
    this.title=t;
    this.videoName=v;
    this.likes=l;
}
/**
get methods to retrieve the data of each respective value to be returned */
public String getTite(String t){
    return t;
}
public String getVideoName(String v){
    return v;
}
public String getLikes(String l){
    return l;
}
//public Account add(Posts post){
  //  return post;
//}
/**a to string method that changes the valures to string  */
public String toString(){
    return "Title"+ this.title+"\nVideo"+this.videoName+"\nNumber of likes:"+this.likes;
}

 
}