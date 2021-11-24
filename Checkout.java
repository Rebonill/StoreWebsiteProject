import java.util.*;
public class Checkout extends ItemStock{
ArrayList <String> checkOut = new ArrayList <String>();
ArrayList <Integer> itemcost = new ArrayList <Integer>();
  public Checkout(){
  }

  public void setcheckOutList(int i){
    checkOut.add(getitemName(i));
  }

  public void getcheckoutList(){
    for(int i=0; i < checkOut.size(); i++){
     System.out.println(checkOut.get(i));
    }
  }

}
