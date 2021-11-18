import java.io.Serializable;

public class Account implements AccountInterface, Serializable{
  String fName;
  String lName;
 // String email;
  //String password;

  public Account(String fName, String lName){
    this.fName = fName;
    this.lName = lName;
  }

  public String getfName(){
    return fName;
  }
  public String getlName(){
    return lName;
  }




}
