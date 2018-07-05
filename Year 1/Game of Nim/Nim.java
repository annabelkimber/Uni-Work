// Student Number: 864191
// Level 3


import java.util.Scanner ;
class Nim {
	
		public static void main (String [] args) {
		Scanner in = new Scanner (System.in);
		
		// Populating Variables
		int maxTokens = 10 ; 
		int bagOne = maxTokens ;
		int bagTwo = maxTokens ;
		int bagThree = maxTokens;
		int userInputBag ;
		int userInputToken ;			
		int currentPlayer = 0 ;
		int gameover = 1;
		
		while (gameover == 1){
		
			//Player 1
			
			//User input bag number
				System.out.print("Player 1 - choose bag: ");
				
			//Only integer entered
				while(!in.hasNextInt()) {
					System.out.print("Please enter a valid bag number: ");
					in.nextLine(); 
				}
				userInputBag = in.nextInt();
			
			//Makes sure that bag number entered is between 1 and 3	
				while ((userInputBag > 3) || (userInputBag < 1)) { 
					System.out.print ("There are only three bags! ");
					System.out.print("Player 1 - choose bag: ");
					
					while(!in.hasNextInt()) {
						System.out.print("Please enter a valid bag number: ");
						in.nextLine(); 
					}
						
					userInputBag = in.nextInt();
				}
			
			//User input token amount 
				System.out.print ("Now choose no. of tokens: ") ;
				
			//Only integer entered
				while(!in.hasNextInt()) {
					System.out.print ("Please select correct number of tokens: ") ;
					in.nextLine(); 
				}
				userInputToken = in.nextInt();
				
			//Makes sure that bag number entered is between 1 and 10
				while ((userInputToken > 10) || (userInputToken < 1)) {
					System.out.print ("Please select correct number of tokens: ");
					System.out.print (" Now choose no. of tokens: ") ;
					
					while(!in.hasNextInt()) {
						System.out.print("Please enter a valid token number: ");
						in.nextLine(); 
					}
		
					userInputToken = in.nextInt();
				}
				
				if (userInputBag == 1) {
					bagOne = bagOne - userInputToken ;
				}
								
				if (userInputBag == 2) {
					bagTwo = bagTwo - userInputToken ;
				}
				
				if (userInputBag == 3) {
					bagThree= bagThree - userInputToken ;
				}
			
			//Bag status
				System.out.println ("Bag Status: " + bagOne + ", " + bagTwo + ", " + bagThree) ;
			
				if (bagOne == 0 & bagTwo == 0 & bagThree == 0){
					gameover = 0 ;
					System.out.println("Game Over - Player 1 wins");
					return;
				}
		
			//Player 2
			
			//User input bag number
				System.out.print("Player 2 - choose bag: ");
				
			//Only integer entered
				while(!in.hasNextInt()) {
					System.out.print("Please enter a valid bag number: ");
					in.nextLine(); 
				}
				userInputBag = in.nextInt();
			
			//Makes sure that bag number entered is between 1 and 3	
				while ((userInputBag > 3) || (userInputBag < 1)) { 
					System.out.print ("There are only three bags! ");
					System.out.println("Player 2 - choose bag: ");
					
					while(!in.hasNextInt()) {
						System.out.print("Please enter a valid bag number: ");
						in.nextLine(); 
					}
						
					userInputBag = in.nextInt();
				}
			
			//User input token amount 
				System.out.print ("Now choose no. of tokens: ") ;
				
			//Only integer entered
				while(!in.hasNextInt()) {
					System.out.print ("Please select correct number of tokens: ") ;
					in.nextLine(); 
				}
				userInputToken = in.nextInt();
				
			//Makes sure that bag number entered is between 1 and 10
				while ((userInputToken > 10) || (userInputToken < 1)) {
					System.out.print ("Please select correct number of tokens: ");
					System.out.print (" Now choose no. of tokens:") ;
					
					while(!in.hasNextInt()) {
						System.out.print("Please enter a valid token number: ");
						in.nextLine(); 
					}
		
					userInputToken = in.nextInt();
				}
				
				if (userInputBag == 1) {
					bagOne = bagOne - userInputToken ;
				}
								
				if (userInputBag == 2) {
					bagTwo = bagTwo - userInputToken ;
				}
				
				if (userInputBag == 3) {
					bagThree= bagThree - userInputToken ;
				}
			
			//Bag status
				System.out.println ("Bag Status: " + bagOne + ", " + bagTwo + ", " + bagThree) ;
			
				if (bagOne == 0 & bagTwo == 0 & bagThree == 0){
					gameover = 0 ;
					System.out.println("Game Over - Player 2 wins");
					return;
				}
		}
	}
}
	

	
