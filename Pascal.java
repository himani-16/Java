/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitaldisplay;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Bharath
 */
public class Pascal {
    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        System.out.println("enter the no of lines ");
        Scanner scan= new Scanner (System.in);
        String number = scan.next();
        
        Pattern stringPattern = Pattern.compile("[0-9]*");
        
        Matcher numberMatcher = stringPattern.matcher(number);

        if(!numberMatcher.matches()){
            System.out.println("Invalid Input! Please enter only numbers");
        } else if(Integer.parseInt(number)>17){
            System.out.println("Warning! The pascal triangle will be too big to display");
            System.out.println("Do you still want to proceed? Y/N");
            
            String answer = scan.next();
            
            if(answer.equalsIgnoreCase("y")){
                createTriangle(Integer.parseInt(number));
            } else{
                System.out.println("Quit Successful!");
            }
    
        }else if(Integer.parseInt(number)<=0){
            System.out.println("Invalid Input! Please enter a number greater than 0");     
        }else{
            createTriangle(Integer.parseInt(number));
        }
        
       
    }
    
    
    private static void createTriangle(int number){
        
        int spaces = number;        
        
        int multiple = (number-6)/4;
        String distance = "";
        String space = "";
        
        if(number>=6){
            for (int s =0 ; s <=multiple+1 ; s++){
            distance += " ";
        }
        for (int d =0 ; d <=(((multiple+1)*2)) ; d++){
            space += " ";
        }
        }else{
            distance = " ";
            space = " ";
        }

        int no=1;
        for(int i=0;i<number;i++)
        {
            for (int j=0;j<=spaces-i;j++) //for spaces
            {
                System.out.print(distance);
            }
            no =1;
            int noOfDigits =1;

            for(int k=0;k<=i;k++) //for pascal values
            {

                System.out.print(space + no);
                no=no*(i-k)/(k+1);
                
                int tempNo = String.valueOf(no).length();
                
                if(tempNo > noOfDigits){
                     space = space.substring(0, space.length() - 1);
                }else if(tempNo < noOfDigits){
                    space += " ";
                }
                
                noOfDigits = tempNo;
            }
            System.out.println();
        }
    }
}
