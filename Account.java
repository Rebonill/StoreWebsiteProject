import java.io.Serializable;

public class Account implements AccountInterface, Serializable{
  String fName;
  //String lName;
 // String email;
  //String password;

  public Account(String fName){
    this.fName = fName;
  }

  public String getfName(){
    return fName;
  }




}
