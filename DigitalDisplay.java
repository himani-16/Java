/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitaldisplay;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Bharath
 */
public class DigitalDisplay {

    /**
     * @param args the command line arguments
     */
    
    private static Map< String, int[][]> activationMatrix = new HashMap< String, int[][]>();
    
        
        
    public static void main(String[] args) {
        
        // Setup initial activation matrix
        setupActivationMatrix();

        //Start the configured display
        startDisplay();
        
    }
    
    
    //Method to display the symbol based on activation matrix
    private static void displaySymbol(int symbol[][]){
        
        System.out.println("=========================================");
      
        for (int i=0; i<8; i++){
            System.out.print("               ");  
            for (int j =0; j<5 ; j++){
                if(symbol[i][j]==1){
                   System.out.print("* ");   
                }else{
                    System.out.print("  ");  
                }                      
            }
             System.out.println("");
        }
        System.out.println("=========================================");

    }
    
    // Search the activation function for the given input
    private static void lookUpActivationMatrix(String value){
        
        try{
            int[][] matrix = activationMatrix.get(value);
            if(matrix!=null){
                displaySymbol(matrix);
            }else{
                System.out.println("Error occured. Please try again!");
            }
            
        }catch(Exception ex){
            System.out.println("An exception occured! Please try again.");
        }
      
    }
    
    // Start the configure digital display
    private static void startDisplay(){
        

        Pattern stringPattern = Pattern.compile("[a-zA-Z0-9]*");
        
        Scanner scan = new Scanner(System.in);
 
        System.out.println("Starting Digital Display");
        System.out.println("=========================================");
     
        while (true){
            
        System.out.println("Please enter a character or a number: ");
        String input = scan.next();
        
        Matcher characterMatcher = stringPattern.matcher(input);
        
        if(!characterMatcher.matches()){
            System.out.println("Invalid Input! Special characters are not allowed.");    
        }
        else if(input.length()>1){
            System.out.println("Invalid Input! Please enter only one charater.");    
        } else lookUpActivationMatrix(input);
        
        System.out.println("Would you like to try again? Y/N only : ");
        
        String answer = scan.next();
        
        if(answer.equalsIgnoreCase("N")){
            break;
            }       
       
        }
        System.out.println("=========================================");
        System.out.println("Signing Out! Thanks for using our digital display.");
    }
    
    private static void setupActivationMatrix(){
        
        activationMatrix.put("A",new int[][]{{0,0,1,0,0},{0,1,0,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,1,1,1,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1}});

        activationMatrix.put("B",new int[][]{{1,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,1,1,1,0}});

        activationMatrix.put("C",new int[][]{{1,1,1,1,1},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,1,1,1,1}});

        activationMatrix.put("D",new int[][]{{1,1,1,0,0},{1,0,0,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,1,0},{1,1,1,0,0}});

        activationMatrix.put("E",new int[][]{{1,1,1,1,1},{1,0,0,0,0},{1,0,0,0,0},{1,1,1,1,1},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,1,1,1,1}});

        activationMatrix.put("F",new int[][]{{1,1,1,1,1},{1,0,0,0,0},{1,0,0,0,0},{1,1,1,1,1},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0}});

        activationMatrix.put("G",new int[][]{{0,0,1,1,1},{0,1,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,1,1},{0,1,0,0,1},{0,0,1,1,1}});

        activationMatrix.put("H",new int[][]{{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,1,1,1,1},{1,1,1,1,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1}});

        activationMatrix.put("I",new int[][]{{1,1,1,1,1},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{1,1,1,1,1}});

        activationMatrix.put("J",new int[][]{{1,1,1,1,1},{0,0,0,1,0},{0,0,0,1,0},{0,0,0,1,0},{0,0,0,1,0},{1,0,0,1,0},{1,0,0,1,0},{0,1,1,0,0}});

        activationMatrix.put("K",new int[][]{{1,0,0,0,1},{1,0,0,1,0},{1,0,1,0,0},{1,1,0,0,0},{1,1,0,0,0},{1,0,1,0,0},{1,0,0,1,0},{1,0,0,0,1}});

        activationMatrix.put("L",new int[][]{{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,1,1,1,1}});

        activationMatrix.put("M",new int[][]{{1,0,0,0,1},{1,1,0,1,1},{1,0,1,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1}});

        activationMatrix.put("N",new int[][]{{1,0,0,0,1},{1,1,0,0,1},{1,0,1,0,1},{1,0,0,1,1},{1,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}});

        activationMatrix.put("O",new int[][]{{0,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{0,1,1,1,0}});

        activationMatrix.put("P",new int[][]{{1,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,1,0},{1,1,1,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0}});

        activationMatrix.put("Q",new int[][]{{0,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,1,0},{0,1,1,0,1}});

        activationMatrix.put("R",new int[][]{{1,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,1,0},{1,1,0,0,0},{1,0,1,0,0},{1,0,0,1,0},{1,0,0,0,1}});

        activationMatrix.put("S",new int[][]{{0,1,1,1,1},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{0,1,1,1,0},{0,0,0,0,1},{0,0,0,0,1},{1,1,1,1,0}});

        activationMatrix.put("T",new int[][]{{1,1,1,1,1},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0}});

        activationMatrix.put("U",new int[][]{{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{0,1,1,1,0}});

        activationMatrix.put("V",new int[][]{{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{0,1,0,1,0},{0,0,1,0,0},{0,0,0,0,0},{0,0,0,0,0}});

        activationMatrix.put("W",new int[][]{{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,1,0,1},{1,1,0,1,1},{1,0,0,0,1}});

        activationMatrix.put("X",new int[][]{{1,0,0,0,1},{1,0,0,0,1},{0,1,0,1,0},{0,0,1,0,0},{0,0,1,0,0},{0,1,0,1,0},{1,0,0,0,1},{1,0,0,0,1}});

        activationMatrix.put("Y",new int[][]{{1,0,0,0,1},{0,1,0,1,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0}});

        activationMatrix.put("Z",new int[][]{{1,1,1,1,1},{1,0,0,0,1},{0,0,0,0,1},{0,0,0,1,0},{0,0,1,0,0},{0,1,0,0,0},{1,0,0,0,1},{1,1,1,1,1}});

        activationMatrix.put("0",new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,1,1,1,1}});

        activationMatrix.put("1",new int[][]{{0,0,1,0,0},{0,1,1,0,0},{1,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{1,1,1,1,1}});

        activationMatrix.put("2",new int[][]{{0,1,1,1,0},{0,0,0,0,1},{0,0,0,0,1},{0,0,0,1,0},{0,0,1,0,0},{0,1,0,0,0},{1,0,0,0,0},{1,1,1,1,1}});

        activationMatrix.put("3",new int[][]{{1,1,1,1,0},{0,0,0,0,1},{0,0,0,0,1},{0,0,0,1,0},{1,1,1,1,0},{0,0,0,1,0},{0,0,0,0,1},{1,1,1,1,1}});

        activationMatrix.put("4",new int[][]{{0,0,0,1,0},{0,0,1,1,0},{0,1,0,1,0},{1,0,0,1,0},{1,1,1,1,1},{0,0,0,1,0},{0,0,0,1,0},{0,0,0,1,0}});

        activationMatrix.put("5",new int[][]{{1,1,1,1,1},{1,0,0,0,0},{1,0,0,0,0},{1,1,1,1,0},{0,0,0,0,1},{0,0,0,0,1},{0,0,0,1,0},{1,1,1,1,0}});

        activationMatrix.put("6",new int[][]{{0,1,1,1,1},{1,0,0,0,0},{1,0,0,0,0},{1,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{0,1,1,1,0}});

        activationMatrix.put("7",new int[][]{{1,1,1,1,1},{0,0,0,1,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0}});

        activationMatrix.put("8",new int[][]{{0,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{0,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{0,1,1,1,0}});

        activationMatrix.put("9",new int[][]{{0,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{0,1,1,1,1},{0,0,0,0,1},{0,0,0,0,1},{0,0,0,0,1}});

        activationMatrix.put("a",new int[][]{{0,1,1,1,0},{1,0,0,0,1},{0,0,0,0,1},{0,1,1,0,1},{1,0,0,1,1},{1,0,0,0,1},{1,0,0,1,1},{0,1,1,0,1}});

        activationMatrix.put("b",new int[][]{{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,1,1,1,0}});

        activationMatrix.put("c",new int[][]{{0,0,0,0,0},{0,0,0,0,0},{1,1,1,1,1},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,1,1,1,1}});

        activationMatrix.put("d",new int[][]{{0,0,0,0,1},{0,0,0,0,1},{0,0,0,0,1},{0,1,1,1,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{0,1,1,1,1}});

        activationMatrix.put("e",new int[][]{{0,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,1,1,1,1},{1,0,0,0,0},{1,0,0,0,0},{0,1,0,0,0},{0,0,1,1,1}});

        activationMatrix.put("f",new int[][]{{0,0,1,1,1},{0,1,0,0,0},{0,1,0,0,0},{1,1,1,1,1},{0,1,0,0,0},{0,1,0,0,0},{0,1,0,0,0},{1,1,1,0,0}});

        activationMatrix.put("g",new int[][]{{0,1,1,1,1},{1,0,0,0,1},{1,0,0,0,1},{0,1,1,1,1},{0,0,0,0,1},{0,0,0,0,1},{1,0,0,0,1},{0,1,1,1,0}});

        activationMatrix.put("h",new int[][]{{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1}});

        activationMatrix.put("i",new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0}});

        activationMatrix.put("j",new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{1,1,0,0,0}});

        activationMatrix.put("k",new int[][]{{1,0,0,0,0},{1,0,0,0,0},{1,0,1,0,0},{1,1,0,0,0},{1,0,0,0,0},{1,1,0,0,0},{1,0,1,0,0},{1,0,0,1,0}});

        activationMatrix.put("l",new int[][]{{0,1,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,1,1,1,0}});

        activationMatrix.put("m",new int[][]{{0,0,0,0,0},{1,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1},{1,0,1,0,1},{1,0,1,0,1},{1,0,1,0,1},{1,0,1,0,1}});

        activationMatrix.put("n",new int[][]{{1,0,0,0,0},{1,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1}});

        activationMatrix.put("o",new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{0,1,1,1,0}});

        activationMatrix.put("p",new int[][]{{0,1,1,1,0},{1,0,0,0,1},{1,0,0,0,1},{1,1,1,1,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0}});

        activationMatrix.put("q",new int[][]{{0,0,0,1,0},{0,1,1,0,0},{1,0,0,1,0},{1,0,0,1,0},{0,1,1,1,0},{0,0,0,1,0},{0,0,0,1,1},{0,0,0,1,0}});

        activationMatrix.put("r",new int[][]{{1,0,1,1,1},{1,1,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0}});

        activationMatrix.put("s",new int[][]{{0,0,0,0,0},{0,1,1,1,1},{1,0,0,0,0},{1,0,0,0,0},{0,1,1,1,0},{0,0,0,0,1},{1,1,1,1,0},{0,0,0,0,0}});

        activationMatrix.put("t",new int[][]{{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{1,1,1,1,1},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,1,1}});

        activationMatrix.put("u",new int[][]{{0,0,0,0,0},{0,0,0,0,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{0,1,1,1,1},{0,0,0,0,0}});

        activationMatrix.put("v",new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{1,0,0,0,1},{0,1,0,1,0},{0,0,1,0,0},{0,0,0,0,0}});

        activationMatrix.put("w",new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,1,0,1},{1,1,1,1,1}});

        activationMatrix.put("x",new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{1,0,0,0,1},{0,1,0,1,0},{0,0,1,0,0},{0,1,0,1,0},{1,0,0,0,1}});

        activationMatrix.put("z",new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{1,1,1,1,1},{0,0,0,1,0},{0,0,1,0,0},{0,1,0,0,0},{1,1,1,1,1}});
        
        activationMatrix.put("y", new int[][]{{0,0,0,0,0},{1,0,0,0,1},{1,0,0,0,1},{1,0,0,0,1},{0,1,1,1,1},{0,0,0,0,1},{0,0,0,0,1},{0,0,1,1,1}});

    }
    
}
