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
    System.out.println(checkOut.get(0));
    System.out.println(checkOut.get(1));
  }

}
