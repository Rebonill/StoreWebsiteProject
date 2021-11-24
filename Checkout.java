import java.util.*;
public class Checkout{
ArrayList <String> checkOut = new ArrayList <String>();
ArrayList <Integer> itemcost = new ArrayList <Integer>();
ItemStock IS = new ItemStock();
  public Checkout(){
  }

  public void setcheckOutList(int i){
    checkOut.add(IS.getitemName(i));
  }

  public void getcheckoutList(){
    for(int i=0; i < checkOut.size(); i++){
     System.out.println(checkOut.get(i));
    }
  }

}
