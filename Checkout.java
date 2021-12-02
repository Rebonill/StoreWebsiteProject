import java.util.*;
public class Checkout extends ItemStock{
  ArrayList <String> checkout = new ArrayList <String>();
  ArrayList <Integer> itemcost = new ArrayList <Integer>();
  String List="";
  int Total = 0;
  public Checkout(){
  }//end constructor

  public void setcheckOutList(int i){
    checkout.add(getitemName(i));
    itemcost.add(getCost(i));
  }//end setcheckOutList

  public String getcheckoutList(){
    for(int i=0; i < checkout.size(); i++){
     List +=checkout.get(i) +"\n"+ "$"+ itemcost.get(i)+"\n";
    }//end for loop
    return List;
  }//end getcheckoutList
  
  public int getTotalCost(){
    for(int i=0; i < checkout.size(); i++){
      Total +=itemcost.get(i);   
    }//end for loop
    return Total;
  }//end fetTotalCost
}
