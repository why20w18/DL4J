package DL4J_Temel_Perceptron;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;
/*
x1 = x eksenini temsil ediyor
x2 = y eksenini temsil ediyor

(x1,x2) koordinatinda x1 > x2'den y=x dogrusunun altinda kalacaktir o nokta
ve bu verisetinde hep y=x'in altinda kalan kisimlar +1 ust kisminda kalan noktalar -1
olarak etiketlendi

x1 yesil

*/

public class Veriseti extends JPanel{
    
    //girdiler
    public double[] x1_In , x2_In;

    //outputlar
    public int[] y_Out;
    
    //veriseti buyuklugu
    public int buyukluk;
    
    //makinenin yaptigi tahminleride tutalim
    public int[] makineTahmin;
    
    //timer icin dongu degiskenini buraya olusturup buradan eriselim
    public int iTimer = 0;
    
    
    public double ekranMax = 800f;
    public double ekranMin = 0f;
    public double setMax = 10f;
    public double setMin = -10f;
    
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
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.white);
        g2.fillRect(0, 0, (int)ekranMax, (int)ekranMax);
        
        g2.setColor(Color.black);
        //sadece inputlari yani x1 ve x2'leri ekrana basiyoruz
        
        for(int i = 0 ; i < buyukluk ; i++){
            
            if(y_Out[i] == 1){
                g2.setColor(Color.green);
            }
            else{
                g2.setColor(Color.red);
            }
            g2.fillOval(mapping(x1_In[i]), (int)ekranMax-mapping(x2_In[i]), 12, 12);

            //yukarida cizilenlerden dogru tahmin yapip cizilenlerin icini acik maviye boyayacagiz
            if(makineTahmin[i] == y_Out[i]){ //makine dogru tahmin ettiyse
                g2.setColor(Color.white);
            }
            else{
                g2.setColor(Color.black);
            }
                                              //y=x icin asagi gidince y degeri sifira yaklasir bu sebeple cikarttik
            g2.fillOval(mapping(x1_In[i])+2, (int)ekranMax-mapping(x2_In[i])+2, 6, 6);
            
        }//for
            
            //KOORDINATLAR
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(400, 0, 400, 800); //y ekseni
            
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke(3));
            g2.drawLine(0, 400, 800, 400);
        
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(800, 0, 0, 800);//y=x dogrusu
    }
    
        //x1 ve x2 araliklari -10 ve +10 arasinda panel 500 x 500 aralik cekecegiz
        public int mapping(double input1_2){
         return (int)(ekranMin+(ekranMax-ekranMin) * (input1_2 -setMin) / (setMax -setMin));
        }
    
    
    
}
