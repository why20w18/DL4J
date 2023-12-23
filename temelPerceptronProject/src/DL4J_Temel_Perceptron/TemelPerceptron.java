package DL4J_Temel_Perceptron;

import java.util.Random;


public class TemelPerceptron {
    //weightleri tanimlarim
    double w1,w2;
    TemelPerceptron referans = new TemelPerceptron();
    
    //agirlik ve inputlarin carpilacagi fonksiyon
    public double toplamaFonksiyon(double x1 , double x2){
        
        double toplam = ((w1 * x1) + (w2 * x2));
        return toplam;
    }
    
    //baslangicta weightlere random deger atama
    Random rand = new Random();
    public void randomAtamaWeight(){
        //0-1 arasi deger dondurur -1 ve 1 cekecegiz
        w1 = (rand.nextDouble()-0.5)*2;
        w2 = (rand.nextDouble()-0.5)*2;
    }
    
    //gecici aktivasyon fonksiyonu
    public double tempAktivasyonFonksiyon(TemelPerceptron referans){
        
        double toplam = referans.toplamaFonksiyon(w1, w2);
        
        if(toplam > 1)
            return 1;
        else
            return -1;
        
    }
    
    
}
