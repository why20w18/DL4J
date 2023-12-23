package DL4J_Temel_Perceptron;


public class TemelPerceptron {
    //weightleri tanimlarim
    double w1,w2;
    
    
    //agirlik ve inputlarin carpilacagi fonksiyon
    public double toplamaFonksiyon(double x1 , double x2){
        
        double toplam = ((w1 * x1) + (w2 * x2));
        return toplam;
    }
    
    
    
}
