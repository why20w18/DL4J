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
        Veriseti veriset = new Veriseti(400);
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
        //long ogrenmeBaslangic = 0;
        //long ogrenmeBitis = 0;
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
            
            
        //ogrenmeBaslangic = System.currentTimeMillis();
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
        
         /*if (veriset.iTimer >= 750) {
                            System.out.println("ogrenme yeterli");
                            timer.cancel(); 
                        }*/
         
                        
         veriset.X1_KESEN = perceptron.X1T_KESTIGI();
         veriset.X2_KESEN = perceptron.X2T_KESTIGI();
         
         
            }//run
        },0,100); //100 dersek daha hýzlý cagirir ms cinsinden
        
     }//for
        
        System.out.printf("\nBasarili Tahmin Sayisi %d , T iterasyonu %d , Basari Yuzde %f",cx,t,(double)cx/veriset.buyukluk*100);
        if(cx >= veriset.buyukluk/2) System.out.print("-------------------------------------->%50 UZERINDE BASARI");
        cx = 0;
        t++;
    }//while
        
        /*
        ogrenmeBitis = System.currentTimeMillis();
        long ogrenmeSuresi = (ogrenmeBitis-ogrenmeBaslangic)/1000;
        System.out.println("\n\nOgrenme Suresi: "+ogrenmeSuresi);
       */
        
    }//main metod
    
}
