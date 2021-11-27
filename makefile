StoreWebsite.class: StoreWebsite.java Website.class Account.class ItemStock.class AccountInterface.class CustomerMenu.class Checkout.class
	javac -g StoreWebsite.java

Website.class: Website.java 
	javac -g Website.java

CustomerMenu.class: CustomerMenu.java
	javac -g CustomerMenu.java

ItemStock.class: ItemStock.java
	javac -g ItemStock.java

Account.class: Account.java
	javac -g Account.java

clean:
	rm *.class
      
run: StoreWebsite.class
	java StoreWebsite

debug: StoreWebsite.class
	jdb StoreWebsite
