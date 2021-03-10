import java.util.Random;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception { //the structure of the game
        String[][] array1 = new String[5][5];//2D array number 1
		String[][] array2 = new String[5][5];//2D array number 2
		array1 = fill(array1,"_");//fills the first array with _
		array2 = fill(array2,"S");//fills the second array with S
		array2 = random(array2);//fills the second array with 5 B in a random combination
		//print(array2); //test value
		game(array1,array2,1,0);//recursive method that runs the game
    }

    //------------------------------where the methods go----------------------------------------------------------------------------
    public static void game(String[][]array1,String[][] array2,int round, int score) {//the method that runs the game
        //----------------------step 7------------------------------------------------------------------
        if (round == 21){
            System.out.println("congrats you win");
            print(array2);
            return;
        }
        Scanner scan = new Scanner(System.in);//method for user input
		int row;//variable for choosing which spot in the row to change
		int col;//variable for choosing which spot in the column to change
		System.out.println("Our field for round " + round);
		print(array1);//displays the array with _
        
        //----------------------step 8------------------------------------------------------------------------------
        
        System.out.println("Please enter a position to sweep for mines:");
		do {// loop that validates if the numbers entered meets the standards 
			System.out.println("enter a row number");
			row = scan.nextInt();
			System.out.println("enter a column number");
			col = scan.nextInt();
			if(row<=-1||col>4||col<=-1||row>4) {
				System.out.println("That is an invalid position, please enter a "+
                "position between 0 and 4 for the row and column.");
			}
            if (array1[row][col].equals("S"))
            {
                System.out.println("You have already chose that position, try again");
            }
		}while(row<=-1||col>4||col<=-1||row>4||array1[row][col].equals("S"));//choose only numbers between 0 and 4
        
        //--------------------step 9-------------------------------------------------------------------------------------------------
        
        if(array2[row][col].equals("B")) {//sequence that determines if the position choseden is equal to a B or an S
			array1[row][col] = "B";
			print(array1);
			System.out.println("Sorry! You stepped on a "+
            "mine in round "+round+". You had "+score+" points. ");
			System.out.println("The actual field! ");
			print(array2);
			return;//exits the method if b was in that spot
		}

		array1[row][col] = "S";//sets the position in the first array from a _ to an S
		game(array1,array2,round + 1,score+1);
	}
    public static String[][] fill(String[][] array,String value) {      // fills a 2d array with vallues
		for(int loop = 0; loop < array[0].length;loop++) {            // this loop fills a 2D array with a single character 
			for(int loop1 = 0; loop1 < array[1].length;loop1++) {
				array[loop][loop1] = value;                        // sets that position equal to the string value
			}
		}
		return array;  //returns that array
	}
    public static String[][] random(String[][] array){      //fills a 2d array with five B's in random spots
        Random rand = new Random();       // object that can be used to generate random numbers
		int row;
		int col;
			for(int loop1 = 0; loop1 < 5;loop1++) {   //this loop will add the letter B in 5 random positions in the 2D array
				row = rand.nextInt(4);    //calling the object to generate a random number between 0 and 4
				col = rand.nextInt(4);    //calling the object to generate a random number between 0 and 4
				if (array[row][col] == "B"){        //checks the 2D array if that position already has a Bin that spot
					loop1-=1;
				}
				array[row][col] = "B";
			}
		return array;      //return that 2D array for use in the program
	}
    public static void print(String[][] array) {            //prints out a 2d array
		for(int loop = 0; loop < array[0].length;loop++) {           //traverses the 2D array
			for(int loop1 = 0; loop1 < array[1].length;loop1++) {
				System.out.print(array[loop][loop1] + " ");          //prints out the array
			}
			System.out.println();         //goes down to the next row
		}
	}
    //------------------------------where the methods ends----------------------------------------------------------------------
}

