
import java.util.*;
class Cart
{
  public static void addtoCart(Map<String,Integer> itemWithStock,Map<String,Integer> itemWithPrice,Map<String,Integer> cart)
  {
    Scanner in=new Scanner(System.in);
    System.out.println("Enter item to add : ");
    String str=in.nextLine();
    if(!itemWithStock.containsKey(str))
    {
      System.out.println("Sorry! Item Not Found");
    }
    else
    {
      System.out.println("Enter Number of items");
      Integer numberofItem=in.nextInt();
      if(numberofItem>itemWithStock.get(str))
      {
        System.out.println("Number of Items not Available ");
      }
      else
      {
        cart.put(str,numberofItem*itemWithPrice.get(str));
        itemWithStock.replace(str,itemWithStock.get(str)-numberofItem);
      }
    }
  }
 
  //To Remove an Element of cart

   public static void removefromCart(Map<String,Integer> itemWithStock,Map<String,Integer> itemWithPrice,Map<String,Integer> Cart)
   {
     Scanner sc=new Scanner(System.in);
     if(Cart.isEmpty()){
		  System.out.println("The cart is empty now !!! ");
	  }
     else
     {
     System.out.println("Enter Product Name ");
     String s=sc.nextLine();
     if(!Cart.containsKey(s))
     {
       System.out.println("Sorry! Item Not Found ");
     }
     else
     {
       System.out.println("Enter Number of Elements ");
       Integer numberofItems=sc.nextInt();
       if(numberofItems>Cart.get(s))
       {
         System.out.println("Enter Value Correctly ");
       }
       else
       {
         Cart.replace(s,Cart.get(s)-(numberofItems*itemWithPrice.get(s)));
         itemWithStock.replace(s,itemWithStock.get(s)+numberofItems);
       }
      }
     }
   }

  //To Display the Cart
 
  public static void Display(Map<String,Integer> Cart)
  {
	  if(Cart.isEmpty()){
		  System.out.println("The cart is empty now !!! ");
	  }
	  else{
		  for(Map.Entry<String,Integer> entry:Cart.entrySet())
			    System.out.println("Product : "+entry.getKey()+"\tPrice : "+entry.getValue());
	  }
    }  
  public static Integer bill(Map<String,Integer> Cart)
  {		
	  if(Cart.isEmpty()){
		  return 0;
	  }
	  else{
	  Integer sum=0;
	  for(Map.Entry ele:Cart.entrySet())
	    {
	      int val=((int)ele.getValue());
	      sum=sum+val;
	    }
	  return sum;
	  }
  }
 

  public static void main(String...arg)
  {
    Map<String,Integer> itemWithStock = new HashMap<String,Integer>();
    Map<String,Integer> itemWithPrice = new HashMap<String,Integer>();
    Map<String,Integer> cart = new HashMap<String,Integer>();
    Scanner sc=new Scanner(System.in);
    Integer choice,flag=1,sum=0;
    String url;
    itemWithStock.put("Realme 6",10);
    itemWithStock.put("Headphones",20);
    itemWithStock.put("Charger",10);
    itemWithStock.put("USB cable",25);

    itemWithPrice.put("Realme 6",15000);
    itemWithPrice.put("Headphones",5000);
    itemWithPrice.put("Charger",450);
    itemWithPrice.put("USB cable",370);

    while(flag==1)
    {
      System.out.println("\nAvailable Items For shopping : ");
      for(Map.Entry<String,Integer> entry:itemWithStock.entrySet())
      System.out.println(entry.getKey()+"  :  "+entry.getValue()); 
      System.out.println("1.  Add items to Cart");
      System.out.println("2.  Remove items from Cart");
      System.out.println("3.  Display the items of Cart ");
      System.out.println("4.  Display the bill of Cart ");
      System.out.println("5.  Exit ");
      System.out.println("Enter Choice : ");
      choice = sc.nextInt();
      switch(choice){
      case 1 : addtoCart(itemWithStock,itemWithPrice,cart);
      			break;
      case 2 : removefromCart(itemWithStock,itemWithPrice,cart);
      			break;
      case 3 : Display(cart);
      			break;
      case 4 : sum=bill(cart);
      		   if(sum==0){
      			 System.out.println("Sorry! the cart is empty.");
      		   }
      		   else{
      		   System.out.println("Total Amount "+sum);
      		   }
      		   break;
      case 5 : flag=0;
      			break;
      default : System.out.println("Wrong Choice!!! ");
      }
    }
  }
}
