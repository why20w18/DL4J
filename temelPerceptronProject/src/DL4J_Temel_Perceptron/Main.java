package DL4J_Temel_Perceptron;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        TemelPerceptron perceptron = new TemelPerceptron();
        
        double x1 = 0,x2 = 0;
        int i = 1;
        while(true){
        //System.out.print("x1:");     x1 = scanner.nextDouble();
        //System.out.print("x2:");     x2 = scanner.nextDouble();
        System.out.println("\n"+i+"- Output Layer:"+perceptron.tempAktivasyonFonksiyon(24, 15));   
        i++;
        }
        
        
        
    }
    
}
