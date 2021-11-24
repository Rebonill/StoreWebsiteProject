import java.util.*;
public class Checkout extends ItemStock{
  ArrayList <String> checkout = new ArrayList <String>();
  ArrayList <Integer> itemcost = new ArrayList <Integer>();
  int Total = 0;
  public Checkout(){
  }

  public void setcheckOutList(int i){
    checkout.add(getitemName(i));
    itemcost.add(getCost(i));
  }

  public void getcheckoutList(){
    System.out.println("Here Is Your CheckOut List");
    for(int i=0; i < checkout.size(); i++){
     System.out.println(checkout.get(i));
     System.out.println(itemcost.get(i));
    }
  }
  
  public void getTotalCost(){
    for(int i=0; i < checkout.size(); i++){
      Total +=itemcost.get(i);   
    }
    System.out.println("Your Total Cost Will Be:");
    System.out.println("$"+Total);
  }
}
