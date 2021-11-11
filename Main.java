import java.util.*;
import java.io.*;

public class Main{
  int[] itemQuantity = new int[5];
  String[] itemName = new String[5]; 
  int i;
  int ssd;
  public static void main(String[] args){
    new Main();
     
  }

  public Main(){
   ItemStock IS = new ItemStock();
   System.out.println(IS.getStock());
   IS.addStock();
   System.out.println(IS.getStock());
   IS.writeFile();
   //readFile();
   // fillItem();
    //add(ssd);
    //System.out.println(ssd);
  }//end cunstructor
    
 /* public void readFile(){
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
   }*/ 

 /* public void fillItem(){
    int gpu = item[0];
    int cpu = item[1];
    int psu = item[2];
    int ram = item[3];
    this.ssd = item[4];
    System.out.println(gpu);
    System.out.println(ssd);
  }
  
  public void add(int i){
  int sum = i+1;
  this.ssd = sum;
  }*/

  
}//end Main
