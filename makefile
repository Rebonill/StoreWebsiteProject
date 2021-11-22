Main.class: Main.java StoreWebsite.class Account.class ItemStock.class AccountInterface.class CustomerMenu.class
	javac -g Main.java
StoreWebsite.class: StoreWebsite.java
	javac -g StoreWebsite.java
clean:
	rm *.class
      
run: Main.class
	java Main
debug: Main.class
	jdb Main
