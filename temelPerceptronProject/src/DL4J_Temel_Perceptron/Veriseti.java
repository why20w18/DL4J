package DL4J_Temel_Perceptron;

import java.util.Random;
/*
x1 = x eksenini temsil ediyor
x2 = y eksenini temsil ediyor

(x1,x2) koordinatinda x1 > x2'den y=x dogrusunun altinda kalacaktir o nokta
ve bu verisetinde hep y=x'in altinda kalan kisimlar +1 ust kisminda kalan noktalar -1
olarak etiketlendi

*/

public class Veriseti {
    
    //girdiler
    public double[] x1_In , x2_In;
    //outputlar
    public int[] y_Out;
    //veriseti buyuklugu
    public int buyukluk;
    
    Random rand = new Random();
    
    public Veriseti(int buyukluk){
        this.buyukluk = buyukluk;
       
        //dizilerin boyutu ayarlandi girdiye gore
        x1_In = new double[buyukluk];
        x2_In = new double[buyukluk];
        y_Out = new int[buyukluk];
        
        //verisetini olusturma asamasi
        for(int i = 0 ; i < buyukluk ; i++){
            x1_In[i] = (rand.nextDouble() - 0.5) *20; //10 ve -10 arasi input atayacak hep
            x2_In[i] = (rand.nextDouble() - 0.5) *20; 
            
            //ilk input ikinciden buyukse hep 1 cevirmis
            if(x1_In[i] > x2_In[i]){
                y_Out[i] = 1;
            }
            else
                y_Out[i] = -1;
            
        }//for
        
    }
    
    
    
}
