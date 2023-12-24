package DL4J_Temel_Perceptron;

import java.util.Random;


public class TemelPerceptron {
    //weightleri tanimlarim
    double w1,w2;

     //baslangicta weightlere random deger atama
    Random rand = new Random();
    public void randomAtamaWeight(){
        //0-1 arasi deger dondurur -1 ve 1 cekecegiz kullanılcak aktivasyon fonksiyonuna bagli
        w1 = (rand.nextDouble()-0.5)*2;
        w2 = (rand.nextDouble()-0.5)*2;
        System.out.print("\nw1:"+w1+" w2:"+w2);
    }
    
    
    //agirlik ve inputlarin carpilacagi fonksiyon // input double
    public double toplamaFonksiyon(double x1 , double x2){
        randomAtamaWeight();
        double toplam = ((w1 * x1) + (w2 * x2));
        return toplam;
    }
    
   
    //aktivasyon fonksiyonu // output int
    public int AktivasyonFonksiyon(double x1 , double x2){
        
        double toplam = toplamaFonksiyon(x1, x2);
        
        if(toplam > 1)
            return 1;
        else
            return -1;
        
    }
    
    
}
