package DL4J_Temel_Perceptron;

import java.util.Random;


public class TemelPerceptron {
    //BIAS TANIMLAMA
    public double w0;
    public int bias = 1;
    
    //weightleri tanimlarim
    public double w1,w2;
    public double OgrenmeOrani = 0.1f;

     //baslangicta weightlere random deger atama
    Random rand = new Random();
    public void randomAtamaWeight(){
        //0-1 arasi deger dondurur -1 ve 1 cekecegiz kullanılcak aktivasyon fonksiyonuna bagli
        w0 = (rand.nextDouble()-0.5)*2;
        
        w1 = (rand.nextDouble()-0.5)*2;
        w2 = (rand.nextDouble()-0.5)*2;
        //System.out.print("\nw1:"+w1+" w2:"+w2);
    }
    
    
    //agirlik ve inputlarin carpilacagi fonksiyon // input double
    public double toplamaFonksiyon(double x1 , double x2){
        //randomAtamaWeight(); 
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
    //verisetinde olusturulan makineTahmin dizisini buradan dolduracagiz 3.ASAMA icin
    
    public int[] makineTahminSeti(double[] x1_in , double[] x2_in , int buyukluk){
        int[] sonuclar = new int[buyukluk];
        for(int i = 0 ; i < buyukluk ; i++){
            sonuclar[i] = AktivasyonFonksiyon(x1_in[i], x2_in[i]);
        }
        return sonuclar;
    }
    
    //agirliklari
    public void modeliEgit(double x1_In , double x2_In , int y_Out){
        
        int aktivasyonCiktisi = AktivasyonFonksiyon(x1_In, x2_In);
        int ciktiFark = y_Out - aktivasyonCiktisi; // 0 veya -2 veya 2 çıkabilir çıktıFark
        
        w1 += ciktiFark*x1_In * OgrenmeOrani;
        w2 += ciktiFark*x2_In * OgrenmeOrani;
    }
    
    //PERCEPTRONUN EKSENI KESTIGI NOKTALAR
    public double X1_KESTIGI(){
        return (-w2 * 0) / w1;
    } 
    public double X2_KESTIGI(){
        return (-w1 * 0) / w2;
    } 
    public double X1T_KESTIGI(){
        return (-w1 * 10) / w2;
    } 
    public double X2T_KESTIGI(){
        return (-w1 * -10) / w2;
    } 
    
}
