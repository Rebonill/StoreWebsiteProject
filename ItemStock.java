import java.util.*;
import java.io.*;

public class ItemStock{

  int[] itemQuantity = new int[5];
  String[] itemName = new String[5];
  int i;
  public  ItemStock(){
    readFile();
  }

  public void readFile(){
	  try {
		  File theFile = new File("ItemStock.dat");
		  Scanner input = new Scanner(theFile);
		  while (input.hasNext()){
                    itemName[i] = input.nextLine();
	            String num = input.nextLine();
                    int Num = Integer.parseInt(num);
                    itemQuantity[i] = Num;  
	           // System.out.println(item[i]);
                    i++;
		  } // end while
	  } catch (IOException e){
		  System.out.println(e.getMessage());
	  } // end try
   }
  
 
  public int getStock(){

    return itemQuantity[0];
  }
  
  public void addStock(){
    //int sum = itemQuantity[0]+1;
    itemQuantity[0]+=1;
  }






}//end ItemStock
