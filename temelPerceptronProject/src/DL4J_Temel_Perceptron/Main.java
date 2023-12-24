package DL4J_Temel_Perceptron;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        TemelPerceptron perceptron = new TemelPerceptron();
        Veriseti veriset = new Veriseti(75);
        
        
        double x1 = 0,x2 = 0;
        
        /*
        int i = 1;
        while(true){
        System.out.print("x1:");     x1 = scanner.nextDouble();
        System.out.print("x2:");     x2 = scanner.nextDouble();
        System.out.println("\n"+i+"- Output Layer:"+perceptron.AktivasyonFonksiyon(24, 15));   
        
        i++;
        }
        */
        int t=0,cx = 0;
        while(t < 1){
        for(int i = 0 ; i < veriset.buyukluk ; i++){
            int makineTahmin = perceptron.AktivasyonFonksiyon(veriset.x1_In[i], veriset.x2_In[i]);
            System.out.print("#\nIterasyon:"+(i+1)
                    + "\nx1: "+veriset.x1_In[i]+"<---->"
                    + "x2: "+veriset.x2_In[i]+"\n"
                            + "w1: "+perceptron.w1+"<---->"
                                    + "w2: "+perceptron.w2+"\n"
                            + "Output:"+veriset.y_Out[i]+"\n"
                                    + "Makine Tahmin:"+makineTahmin+"\n");
            //basarili tahminleri sayalim
            if(veriset.y_Out[i] == /*perceptron.AktivasyonFonksiyon(veriset.x1_In[i], veriset.x2_In[i])
                    ikinci cagirmada weight degerleri degisiyor bunlari dongu basinda tutup kiyas yapmaliyiz*/
                    makineTahmin)
            cx++;
            
        }//for
    t++;
    }
        System.out.println("\n\nBasarili Tahmin Sayisi:"+cx);
        System.out.printf("Basari Yuzdesi %.2f:\n",(double)cx/veriset.buyukluk*100);
    
    }
    
}
