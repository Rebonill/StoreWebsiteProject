import java.util.*;
import java.io.*;

public class ItemStock{
  String[] itemName = new String[3];
  int[] itemQuantity = new int[3];
  int[] itemCost = new int[3];
  int i;
  public  ItemStock(){
    readFile();
  }

  public void readFile(){
    try{
      File item = new File("ItemStock.dat");
      Scanner input = new Scanner(item);
      while (input.hasNext()){
        itemName[i] = input.nextLine();

	String quantity = input.nextLine();
        int Quantity = Integer.parseInt(quantity);
        itemQuantity[i] = Quantity; 

        String cost = input.nextLine();
        int Cost = Integer.parseInt(cost);
        itemCost[i] = Cost; 
	i++; 
      } //end while
    }//end try
          catch (IOException e){
            System.out.println(e.getMessage());
	  } //end catch
   }//end readFile
  
  public void writeFile(){
    try{
      File file = new File("ItemStock.dat");
      FileWriter fw = new FileWriter(file);
      PrintWriter pw = new PrintWriter(fw);
      
      for(int i = 0; i < itemName.length; i++){  
        pw.println(itemName[i]);
        pw.println(itemQuantity[i]);
        pw.println(itemCost[i]);
      }//end for loop
      
      pw.close();
    }//end try
    
    catch(IOException e){
      System.out.println(e.getMessage());
    }//end catch
   
  }//end writeFile
  public void itemList(){
    for(int i=0; i<itemName.length; i++){
      System.out.println(itemName[i]+": $"+itemCost[i]);
    }//end for loop
  }//end itemList
  public String getitemName(int i){
    return itemName[i];
  }//end getitemName
   
  public int getStock(int i){
    return itemQuantity[i];
  }//end getStock
  public int getCost(int i){
    return itemCost[i];
  }//end getCost
  public void decreaseStock(int i){
    itemQuantity[i]-=1;
  }//end decreaseStock
}//end ItemStock
