package DL4J_Temel_Perceptron;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        TemelPerceptron perceptron = new TemelPerceptron();
        Veriseti veriset = new Veriseti(75);
        perceptron.randomAtamaWeight();
        
        Timer timer = new Timer(); //swing timer degil util timer kullanacagiz
        veriset.makineTahmin = perceptron.makineTahminSeti(veriset.x1_In, veriset.x2_In, veriset.buyukluk);
        
        JFrame Frame = new JFrame("Grafik Gosterim");
        Frame.add(veriset);
        Frame.setSize(800,800);
        Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        Frame.setResizable(false);
        Frame.setVisible(true);
        
        double x1 = 0,x2 = 0;
        
        //----------------------1.ASAMA---
        /*
        int i = 1;
        while(true){
        System.out.print("x1:");     x1 = scanner.nextDouble();
        System.out.print("x2:");     x2 = scanner.nextDouble();
        System.out.println("\n"+i+"- Output Layer:"+perceptron.AktivasyonFonksiyon(24, 15));   
        
        i++;
        }
        */
        //----------------------2.ASAMA---
        
        int t=1,cx = 0;
        while(t <= 1){
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
            if(veriset.y_Out[i] == makineTahmin)
            cx++;
            
            
        timer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
            //veri setinin icindeki degerleri alacak modeliEgit metodu icinde W ayarlamasi yapacak ve egitilecek
            perceptron.modeliEgit(
                    veriset.x1_In[veriset.iTimer % veriset.buyukluk], 
                    veriset.x2_In[veriset.iTimer % veriset.buyukluk], 
                    veriset.y_Out[veriset.iTimer % veriset.buyukluk]);
            
        veriset.makineTahmin = perceptron.makineTahminSeti(veriset.x1_In, veriset.x2_In, veriset.buyukluk);
        Frame.repaint();
        veriset.iTimer++;
            if(veriset.iTimer == 10){
                System.out.println("10");
            }
            
            }//run
        },0,1000);
          
            
            
        }//for
        
        System.out.printf("\nBasarili Tahmin Sayisi %d , T iterasyonu %d , Basari Yuzde %f",cx,t,(double)cx/veriset.buyukluk*100);
        if(cx >= 50) System.out.print("------------------------------BASARI");
        cx = 0;
        //MAX CX = 56
    t++;
    }//while
        
     
        
        //----------------------3.ASAMA---
           
        //olusturdugumuz ekranda canl� olarak egitim surecini gormek icin timer olusturuyoruz belli
        //surede ekran guncellensin
        /*
        Timer timer = new Timer(); //swing timer degil util timer kullanacagiz
        
        timer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
            //veri setinin icindeki degerleri alacak modeliEgit metodu icinde W ayarlamasi yapacak ve egitilecek
            perceptron.modeliEgit(
                    veriset.x1_In[veriset.iTimer % veriset.buyukluk], 
                    veriset.x2_In[veriset.iTimer % veriset.buyukluk], 
                    veriset.y_Out[veriset.iTimer % veriset.buyukluk]);
            
        veriset.makineTahmin = perceptron.makineTahminSeti(veriset.x1_In, veriset.x2_In, veriset.buyukluk);
        Frame.repaint();
        veriset.iTimer++;
            if(veriset.iTimer == 10){
                System.out.println("10");
            }
            
            }//run
        },0,100);
      */
        
    }//main metod
    
}
