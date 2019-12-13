/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proje;


import java.awt.Color;
import java.util.Scanner;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Proje extends JFrame implements ActionListener{
    private int x,y,engelSayisi;
    int[] engelKonumuX=new int[engelSayisi];
    int[] engelKonumuY=new int[engelSayisi];
    private String robotTipi;
    String yonBilgisi=new String();
    String yonBilgisi2=new String();
    String yonBilgisi3=new String();
    ArrayList <Integer> list=new ArrayList <Integer>();
     ArrayList <Integer> list1=new ArrayList <Integer>();
    ManipülatorRobot r2;
    GezginRobot r1;
    Hibrit r3;

    public Proje(int x,int y,String robotTipi,ArrayList<String> yonBilgisi,ManipülatorRobot r1){
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,1000);
        setVisible(true);
        this.x=x;
        this.y=y;
        this.robotTipi=robotTipi;
        this.yonBilgisi=yonBilgisi.toString();
        this.r2=r1;
        
    }
    public Proje(int x,int y,int engelSayisi,int[] engelKonumuX,int[] engelKonumuY,String robotTipi,ArrayList<String> yonBilgisi,GezginRobot r1)
    {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,1000);
        setVisible(true);
        this.x=x;
        this.y=y;
        this.engelSayisi=engelSayisi;
        this.robotTipi=robotTipi;
        for(int i=0;i<engelKonumuX.length;i++)
        {
            list.add(engelKonumuX[i]);
        }
        for(int i=0;i<engelKonumuY.length;i++)
        {
            list1.add(engelKonumuY[i]);
        }
        this.yonBilgisi=yonBilgisi.toString();
        this.r1=r1;
    }
    public Proje(int x,int y,String robotTipi,ArrayList<String> yonBilgisi,int engelSayisi,int[] engelKonumuX,int[] engelKonumuY,ArrayList<String> yonBilgisi2,Hibrit r3)
    {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,1000);
        setVisible(true);
        
        this.robotTipi=robotTipi;
        for(int i=0;i<engelKonumuX.length;i++)
        {
            list.add(engelKonumuX[i]);
        }
        for(int i=0;i<engelKonumuY.length;i++)
        {
            list1.add(engelKonumuY[i]);
        }
        this.yonBilgisi=yonBilgisi.toString();
        this.x=x;
        this.y=y;
        this.engelSayisi=engelSayisi;
        for(int i=0;i<engelKonumuX.length;i++)
        {
            list.add(engelKonumuX[i]);
        }
        for(int i=0;i<engelKonumuY.length;i++)
        {
            list1.add(engelKonumuY[i]);
        }
        this.yonBilgisi2=yonBilgisi2.toString();
        this.r3=r3;
    }
    public void paint(Graphics g){
        super.paint(g);
        int i,j=0,k=30,t=0;
        while(j<20)
        {
            for(i=0;i<600;i+=30)
            {
                g.drawRect(k,50+i,30,30);
               
            }
            k+=30;
            j++;
        }
        if(getRobotTipi().equalsIgnoreCase("seri"))
        {
            int x=0,q;
            i=0;
            q=0;
            int[] hareketS=new int[20];
            int[] index=new int[20];
            String[] sayi=new String[20];
            g.setColor(Color.blue);
            g.fillRect(getX(),getY(),15,15);
            g.drawLine(getX(),getY(),getX()-10,getY()+10);
            g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            int y=yonBilgisi.indexOf(" ");
            String den=yonBilgisi.substring(1,y);
            sayi[q]=den;
            int z=0;
            q++;

            
            while(i<yonBilgisi.length())
            {
                if(yonBilgisi.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi.length();j++)
                    {
                        int w=yonBilgisi.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
            }
            
            int a=0;
            int f=1;
            int d=index[a];
            int toplamX=getX();
            int toplamY=getY();
            int s=0;
            double yerDegistirme=0,yerDegistirme2=0;
            int oncekiKonumX,oncekiKonumY;
            boolean devam=true;
            String yon=yonBilgisi.toString();
            while(devam)
            {
                
                String tmp=yonBilgisi.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>(double)r2.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        System.out.println(yon+" kol uzunluğunu aşmaktadır");
                        double sn=(double)r2.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                        devam=false;
                       
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r2.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yon+" kol uzunluğunu aşmaktadır");
                        double sn=(double)r2.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>(double)r2.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yon+" kol uzunluğunu aşmaktadır");
                        double sn=(double)r2.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r2.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yon+" kol uzunluğunu aşmaktadır");
                        double sn=(double)r2.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                    g.setColor(Color.red);
                    g.drawString("Son Konum",toplamX,toplamY);
                    double sn=(double)r2.getTasimaHizi()/yerDegistirme;
                    System.out.println("Geçen süre:"+sn+" saniye");
                }
                
            }
            
           
        }
        if(getRobotTipi().equalsIgnoreCase("paralel"))
        {
            g.setColor(Color.green);
            g.fillRect(getX(),getY(),15,15);
            g.drawLine(getX(),getY(),getX()-10,getY()+10);
            g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            int x=0,q;
            i=0;
            q=0;
            int[] index=new int[20];
            String[] sayi=new String[20];
            int y=yonBilgisi.indexOf(" ");
            String den=yonBilgisi.substring(1,y);
            sayi[q]=den;
            int z=0;
            q++;
            
            while(i<yonBilgisi.length())
            {
                if(yonBilgisi.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi.length();j++)
                    {
                        int w=yonBilgisi.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
            }
            int a=0;
            int f=1;
            int d=index[a];
            int toplamX=getX();
            int toplamY=getY();
            int s=0;
            boolean devam=true;
            double yerDegistirme=0,yerDegistirme2=0;
            String yon=yonBilgisi.toString();
            int oncekiKonumX,oncekiKonumY;
            while(devam)
            {
                
                String tmp=yonBilgisi.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r2.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yon+" kol uzunluğunu aşmaktadır");
                        double sn=(double)r2.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    if(devam)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r2.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yon+" kol uzunluğunu aşmaktadır");
                        double sn=(double)r2.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    if(devam)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r2.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yon+" kol uzunluğunu aşmaktadır");
                        double sn=(double)r2.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    if(devam)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    System.out.println(r);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r2.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yon+" kol uzunluğunu aşmaktadır");
                        double sn=(double)r2.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    if(devam)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                    g.setColor(Color.red);
                    g.drawString("Son Konum",toplamX,toplamY);
                    double sn=(double)r2.getTasimaHizi()/yerDegistirme;
                    System.out.println("Geçen süre:"+sn+" saniye");
                }
            }
            
        }
        if(getRobotTipi().equalsIgnoreCase("tekerlekli"))
        {
            i=0;
            double engelSure=0;
            while(t<getEngelSayisi())
            {
                g.setColor(Color.red);
                g.fillRect(list.get(i),list1.get(i),30,30);
                i++;
                t++;
            }
            g.setColor(Color.pink);
            g.fillRect(getX(),getY(),15,15);
            g.drawLine(getX()+5,getY()+15,getX()+5,getY()+20);
            g.drawLine(getX()+10,getY()+15,getX()+10,getY()+20);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            
            int x=0,q;
            i=0;
            q=0;
            int[] index=new int[20];
            String[] sayi=new String[20];
            int y=yonBilgisi.indexOf(" ");
            String den=yonBilgisi.substring(1,y);
            sayi[q]=den;
            int z=0;
            q++;
            
            while(i<yonBilgisi.length())
            {
                if(yonBilgisi.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi.length();j++)
                    {
                        int w=yonBilgisi.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
                
            }
            int a=0;
            int f=1;
            int d=index[a];
            int toplamX=getX();
            int toplamY=getY();
            int s=0;
            boolean devam=true; 
            double yerDegistirme=0,yerDegistirme2=0;
            int oncekiKonumX,oncekiKonumY;
            while(devam)
            {
                
                String tmp=yonBilgisi.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.pink);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            double sn=((double)r1.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list1.size();i++)
                    {
                        if(oncekiKonumY<list1.get(i) && list1.get(i)<=toplamY)
                        {
                            engelSure+=r1.EngelGecmeSuresiBul();
                            
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.pink);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.pink);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            double sn=((double)r1.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list1.size();i++)
                    {
                        if(oncekiKonumY<list1.get(i) && list1.get(i)<=toplamY)
                        {
                            engelSure+=r1.EngelGecmeSuresiBul();
                            
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.pink);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.pink);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            double sn=((double)r1.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list.size();i++)
                    {
                        if(oncekiKonumX<list.get(i) && list.get(i)<=toplamX)
                        {
                            engelSure+=r1.EngelGecmeSuresiBul();
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.pink);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.pink);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            double sn=((double)r1.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list.size();i++)
                    {
                        if(toplamX<=list.get(i) && list.get(i)<oncekiKonumX)
                        {
                            engelSure+=r1.EngelGecmeSuresiBul();
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.pink);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                    g.setColor(Color.red);
                    g.drawString("Son Konum",toplamX,toplamY-10);
                    double sn=((double)r1.getHiz()/yerDegistirme)+engelSure;
                    System.out.println("Geçen süre:"+sn+" saniye");
                }
                
            }
            
            
        }
        if(getRobotTipi().equalsIgnoreCase("paletli"))
        {
            i=0;
            double engelSure=0;
            while(t<getEngelSayisi())
            {
                g.setColor(Color.red);
                g.fillRect(list.get(i),list1.get(i),30,30);
                i++;
                t++;
            }
            g.setColor(Color.yellow);
            g.fillRect(getX(),getY(),15,15);
            g.drawLine(getX()+5,getY()+15,getX()+5,getY()+20);
            g.drawLine(getX()+10,getY()+15,getX()+10,getY()+20);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            
            int x=0,q;
            i=0;
            q=0;
            int[] index=new int[20];
            String[] sayi=new String[20];
            int y=yonBilgisi.indexOf(" ");
            String den=yonBilgisi.substring(1,y);
            sayi[q]=den;
            int z=0;
            q++;
            
            while(i<yonBilgisi.length())
            {
                if(yonBilgisi.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi.length();j++)
                    {
                        int w=yonBilgisi.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
                
            }
            int a=0;
            int f=1;
            int d=index[a];
            int toplamX=getX();
            int toplamY=getY();
            int s=0;
            double yerDegistirme=0,yerDegistirme2=0;
            boolean devam=true;
            int oncekiKonumY,oncekiKonumX;
            while(devam)
            {
                
                String tmp=yonBilgisi.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.yellow);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            double sn=((double)r1.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list1.size();i++)
                    {
                        if(oncekiKonumY<list1.get(i) && list1.get(i)<=toplamY)
                        {
                            engelSure+=r1.EngelGecmeSuresiBul();
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.yellow);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.yellow);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            double sn=((double)r1.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list1.size();i++)
                    {
                        if(toplamY<=list1.get(i) && list1.get(i)<oncekiKonumY)
                        {
                            engelSure+=r1.EngelGecmeSuresiBul();
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.yellow);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.pink);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            double sn=((double)r1.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list.size();i++)
                    {
                        if(oncekiKonumX<list.get(i) && list.get(i)<=toplamX)
                        {
                            engelSure+=r1.EngelGecmeSuresiBul();
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.yellow);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.pink);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            double sn=((double)r1.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list.size();i++)
                    {
                        if(toplamX<=list.get(i) && list.get(i)<oncekiKonumX)
                        {
                            engelSure+=r1.EngelGecmeSuresiBul();
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.yellow);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                    g.setColor(Color.red);
                    g.drawString("Son Konum",toplamX,toplamY-10);
                    double sn=((double)r1.getHiz()/yerDegistirme)+engelSure;
                    System.out.println("Geçen süre:"+sn+" saniye");
                }
                
            }
            
            
        }
        if(getRobotTipi().equalsIgnoreCase("spider"))
        {
            i=0;
            while(t<getEngelSayisi())
            {
                g.setColor(Color.red);
                g.fillRect(list.get(i),list1.get(i),30,30);
                i++;
                t++;
            }
            g.setColor(Color.orange);
            g.fillRect(getX(),getY(),15,15);
            g.drawLine(getX()+5,getY()+15,getX()+5,getY()+20);
            g.drawLine(getX()+10,getY()+15,getX()+10,getY()+20);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            int x=0,q;
            i=0;
            q=0;
            int[] index=new int[20];
            String[] sayi=new String[20];
            int y=yonBilgisi.indexOf(" ");
            String den=yonBilgisi.substring(1,y);
            sayi[q]=den;
            int z=0;
            q++;
            
            while(i<yonBilgisi.length())
            {
                if(yonBilgisi.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi.length();j++)
                    {
                        int w=yonBilgisi.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
                
            }
            int a=0;
            int f=1;
            int d=index[a];
            int toplamX=getX();
            int toplamY=getY();
            int s=0;
            int oncekiKonumX,oncekiKonumY;
            boolean devam=true;
            double yerDegistirme=0,yerDegistirme2=0;
            while(devam)
            {
                
                String tmp=yonBilgisi.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    for(i=0;i<list1.size();i++)
                    {
                        if(oncekiKonumY<list1.get(i) && list1.get(i)<=toplamY)
                        {
                           g.setColor(Color.orange);
                           g.fillRect(toplamX,list1.get(i)-15,15,15);
                           g.drawLine(toplamX+5,list1.get(i)-15,toplamX+5,(list1.get(i)-15)+20);
                           g.drawLine(toplamX+10,(list1.get(i)-15)+15,toplamX+10,(list1.get(i)-15)+20);
                           devam=false;
                        }
                    }
                    if(devam==true)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            double sn=((double)r1.getHiz()/yerDegistirme2);
                            System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.orange);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            devam=false;
                        }
                    }    
                    if(devam==true)
                    {
                        g.setColor(Color.orange);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    for(i=0;i<list1.size();i++)
                    {
                        if(toplamY<=list1.get(i) && list1.get(i)<oncekiKonumY)
                        {
                           g.setColor(Color.orange);
                           g.fillRect(toplamX,list1.get(i)-15,15,15);
                           g.drawLine(toplamX+5,list1.get(i)-15,toplamX+5,(list1.get(i)-15)+20);
                           g.drawLine(toplamX+10,(list1.get(i)-15)+15,toplamX+10,(list1.get(i)-15)+20);
                           devam=false;
                        }
                    }
                    if(devam==true)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            double sn=((double)r1.getHiz()/yerDegistirme2);
                            System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.orange);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            devam=false;
                        }
                    }    
                    if(devam==true)
                    {
                        g.setColor(Color.orange);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    for(i=0;i<list.size();i++)
                    {
                        if(oncekiKonumX<list.get(i) && list.get(i)<=toplamX)
                        {
                           g.setColor(Color.orange);
                           g.fillRect(list.get(i)-15,toplamY,15,15);
                           g.drawLine((list.get(i)-15)+5,toplamY+15,(list.get(i)-15)+5,toplamY+20);
                           g.drawLine((list.get(i)-15)+10,toplamY+15,(list.get(i)-15)+10,toplamY+20);
                           devam=false;
                        }
                    }
                    if(devam==true)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            double sn=((double)r1.getHiz()/yerDegistirme2);
                            System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.orange);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            devam=false;
                        }
                    }    
                    if(devam==true)
                    {
                        g.setColor(Color.orange);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    for(i=0;i<list.size();i++)
                    {
                        if(toplamX<=list.get(i) && list.get(i)<oncekiKonumX)
                        {
                           g.setColor(Color.orange);
                           g.fillRect(list.get(i)-15,toplamY,15,15);
                           g.drawLine((list.get(i)-15)+5,toplamY+15,(list.get(i)-15)+5,toplamY+20);
                           g.drawLine((list.get(i)-15)+10,toplamY+15,(list.get(i)-15)+10,toplamY+20);
                           devam=false;
                        }
                    }
                    if(devam==true)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            double sn=((double)r1.getHiz()/yerDegistirme2);
                            System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.orange);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            devam=false;
                        }
                    }    
                    if(devam==true)
                    {
                        g.setColor(Color.orange);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                    g.setColor(Color.red);
                    g.drawString("Son Konum",toplamX,toplamY-10);
                    double sn=((double)r1.getHiz()/yerDegistirme);
                    System.out.println("Geçen süre:"+sn+" saniye");
                }
            }
            

            
        }
        if(getRobotTipi().equalsIgnoreCase("tekerlekliSeri"))
        {
            i=0;
            while(t<getEngelSayisi())
            {
                g.setColor(Color.red);
                g.fillRect(list.get(i),list1.get(i),30,30);
                i++;
                t++;
            }
            g.setColor(Color.magenta);
            g.fillRect(getX(),getY(),15,15);
            g.drawLine(getX()+5,getY()+15,getX()+5,getY()+20);
            g.drawLine(getX()+10,getY()+15,getX()+10,getY()+20);
            g.drawLine(getX(),getY(),getX()-10,getY()+10);
            g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            
            double engelSure=0;
            int x=0,q;
            i=0;
            q=0;
            int[] index=new int[20];
            String[] sayi=new String[20];
            int y=yonBilgisi.indexOf(" ");
            String den=yonBilgisi.substring(1,y);
            sayi[q]=den;
            int z=0;
            q++;
            
            while(i<yonBilgisi.length())
            {
                if(yonBilgisi.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi.length();j++)
                    {
                        int w=yonBilgisi.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
                
            }
            
            int a=0;
            int f=1;
            int d=index[a];
            int toplamX=getX();
            int toplamY=getY();
            int s=0;
            double sn=0;
            boolean devam=true;
            double yerDegistirme=0,yerDegistirme2=0;
            int oncekiKonumX,oncekiKonumY;
            while(a<z || devam)
            {
                
                String tmp=yonBilgisi.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                        g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                            sn=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list1.size();i++)
                    {
                        if(oncekiKonumY<list1.get(i) && list1.get(i)<=toplamY)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                        
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                        g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                        g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                            sn=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list1.size();i++)
                    {
                        if(toplamY<=list1.get(i) && list1.get(i)<oncekiKonumY)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                           
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                        g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                            sn=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list.size();i++)
                    {
                        if(oncekiKonumX<list.get(i) && list.get(i)<=toplamX)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                         
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                            sn=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list.size();i++)
                    {
                        if(toplamX<=list.get(i) && list.get(i)<oncekiKonumX)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                      
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                    /*g.setColor(Color.red);
                    g.drawString("Son Konum",toplamX,toplamY-10);
                    sn=((double)r3.getHiz()/yerDegistirme)+engelSure;
                    System.out.println("Geçen süre:"+sn+" saniye");*/
                }
                
            }
            
            if(devam)
            {
                if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.magenta);
                g.fillRect(toplamX,toplamY,15,15);
                g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                g.drawLine(toplamX,toplamY,toplamX-10,toplamY+10);
                g.drawLine(toplamX+15,toplamY,toplamX+25,toplamY+10);
                sn=((double)r3.getHiz()/yerDegistirme)+engelSure;
                System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                System.out.println("Geçen süre:"+sn+" saniye");
                }
                else
                {
                g.setColor(Color.magenta);
                g.fillRect(toplamX,toplamY,15,15);
                g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                g.drawLine(toplamX,toplamY,toplamX-10,toplamY+10);
                g.drawLine(toplamX+15,toplamY,toplamX+25,toplamY+10);
                sn=((double)r3.getHiz()/yerDegistirme)+engelSure;
                System.out.println("Geçen süre:"+sn+" saniye");
                }
            }
            int as;
            
            q=0;
            as=yonBilgisi2.indexOf(" ");
            String sa=yonBilgisi2.substring(1,as);
            sayi[q]=sa;
            z=0;
            q++;
            
            while(i<yonBilgisi2.length())
            {
                if(yonBilgisi2.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi2.length();j++)
                    {
                        int w=yonBilgisi2.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi2.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
            }
            a=0;
            f=1;
            d=index[a];
            s=0;
            devam=true;
            while(devam)
            {
                
                String tmp=yonBilgisi2.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                }
                
            }
            if(devam)
            {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.black);
                g.fillOval(toplamX,toplamY,15,15);
                sn+=(double)r3.getTasimaHizi()/yerDegistirme;
                System.out.println("Geçen süre:"+sn+" saniye");
            }
           
        }
        if(getRobotTipi().equalsIgnoreCase("paletliSeri"))
        {
            i=0;
            while(t<getEngelSayisi())
            {
                g.setColor(Color.red);
                g.fillRect(list.get(i),list1.get(i),30,30);
                i++;
                t++;
            }
            g.setColor(Color.magenta);
            g.fillRect(getX(),getY(),15,15);
            g.drawLine(getX()+5,getY()+15,getX()+5,getY()+20);
            g.drawLine(getX()+10,getY()+15,getX()+10,getY()+20);
            g.drawLine(getX(),getY(),getX()-10,getY()+10);
            g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            
            int x=0,q;
            i=0;
            q=0;
            int[] index=new int[20];
            String[] sayi=new String[20];
            int y=yonBilgisi.indexOf(" ");
            String den=yonBilgisi.substring(1,y);
            sayi[q]=den;
            int z=0;
            q++;
            
            while(i<yonBilgisi.length())
            {
                if(yonBilgisi.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi.length();j++)
                    {
                        int w=yonBilgisi.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;  
                
            }
            int a=0;
            int f=1;
            int d=index[a];
            int toplamX=getX();
            int toplamY=getY();
            int s=0;
            int oncekiKonumY,oncekiKonumX;
            double engelSure=0;
            boolean devam=true;
            double sn=0;
            double yerDegistirme=0,yerDegistirme2=0;
            while(devam)
            {
                
                String tmp=yonBilgisi.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                        g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                            sn+=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list1.size();i++)
                    {
                        if(oncekiKonumY<list1.get(i) && list1.get(i)<=toplamY)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                        g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                        g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                            sn+=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list1.size();i++)
                    {
                        if(toplamY<=list1.get(i) && list1.get(i)<oncekiKonumY)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                        g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                            sn+=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list.size();i++)
                    {
                        if(oncekiKonumX<list.get(i) && list.get(i)<=toplamX)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                            sn+=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list.size();i++)
                    {
                        if(toplamX<=list.get(i) && list.get(i)<oncekiKonumX)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                }
                
            }
            
            if(devam)
            {
                if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.magenta);
                g.fillRect(toplamX,toplamY,15,15);
                g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                g.drawLine(toplamX,toplamY,toplamX-10,toplamY+10);
                g.drawLine(toplamX+15,toplamY,toplamX+25,toplamY+10);
                sn=((double)r3.getHiz()/yerDegistirme)+engelSure;
                System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                System.out.println("Geçen süre:"+sn+" saniye");
                }
                else
                {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.magenta);
                g.fillRect(toplamX,toplamY,15,15);
                g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                sn=((double)r3.getHiz()/yerDegistirme)+engelSure;
                System.out.println("Geçen süre:"+sn+" saniye");
                }
            }
            q=0;
            y=yonBilgisi2.indexOf(" ");
            den=yonBilgisi2.substring(1,y);
            sayi[q]=den;
            z=0;
            q++;
            
            while(i<yonBilgisi2.length())
            {
                if(yonBilgisi2.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi2.length();j++)
                    {
                        int w=yonBilgisi2.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi2.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
            }
            a=0;
            f=1;
            d=index[a];
            s=0;
            devam=true;
            while(devam)
            {
                
                String tmp=yonBilgisi2.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                }
                
            }
            if(devam)
            {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.black);
                g.fillOval(toplamX,toplamY,15,15);
                sn+=(double)r3.getTasimaHizi()/yerDegistirme;
                System.out.println("Geçen süre:"+sn+" saniye");
            }
        }
        if(getRobotTipi().equalsIgnoreCase("spiderSeri"))
        {
            i=0;
            while(t<getEngelSayisi())
            {
                g.setColor(Color.red);
                g.fillRect(list.get(i),list1.get(i),30,30);
                i++;
                t++;
            }
            g.setColor(Color.magenta);
            g.fillRect(getX(),getY(),15,15);
            g.drawLine(getX()+5,getY()+15,getX()+5,getY()+20);
            g.drawLine(getX()+10,getY()+15,getX()+10,getY()+20);
            g.drawLine(getX(),getY(),getX()-10,getY()+10);
            g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
            
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            double engelSure=0;
            int x=0,q;
            i=0;
            q=0;
            int[] index=new int[20];
            String[] sayi=new String[20];
            int y=yonBilgisi.indexOf(" ");
            String den=yonBilgisi.substring(1,y);
            sayi[q]=den;
            int z=0;
            q++;
            
            while(i<yonBilgisi.length())
            {
                if(yonBilgisi.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi.length();j++)
                    {
                        int w=yonBilgisi.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
                
            }
            int a=0;
            int f=1;
            int d=index[a];
            int toplamX=getX();
            int toplamY=getY();
            int s=0;
            int oncekiKonumX,oncekiKonumY;
            boolean devam=true;
            double sn=0,yerDegistirme=0,yerDegistirme2=0;
            while(devam)
            {
                
                String tmp=yonBilgisi.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    for(i=0;i<list1.size();i++)
                    {
                        if(oncekiKonumY<list1.get(i) && list1.get(i)<=toplamY)
                        {
                           sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                           System.out.println("Geçen süre:"+sn+" saniye");
                           g.setColor(Color.red);
                           g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                           g.setColor(Color.magenta);
                           g.fillRect(toplamX,list1.get(i)-15,15,15);
                           g.drawLine(toplamX+5,list1.get(i)-15,toplamX+5,(list1.get(i)-15)+20);
                           g.drawLine(toplamX+10,(list1.get(i)-15)+15,toplamX+10,(list1.get(i)-15)+20);
                           g.drawLine(toplamX,(list1.get(i)-15),toplamX-10,(list1.get(i)-15)+10);
                           g.drawLine(toplamX+15,(list1.get(i)-15),toplamX+25,(list1.get(i)-15)+10);
                           devam=false;
                        }
                    }
                    if(devam==true)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                            System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                        g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                            devam=false;
                        }
                    }    
                    if(devam==true)
                    {
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                        g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    for(i=0;i<list1.size();i++)
                    {
                        if(toplamY<=list1.get(i) && list1.get(i)<oncekiKonumY)
                        {
                           sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                           System.out.println("Geçen süre:"+sn+" saniye");
                           g.setColor(Color.red);
                           g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                           g.setColor(Color.orange);
                           g.fillRect(toplamX,list1.get(i)-15,15,15);
                           g.drawLine(toplamX+5,list1.get(i)-15,toplamX+5,(list1.get(i)-15)+20);
                           g.drawLine(toplamX+10,(list1.get(i)-15)+15,toplamX+10,(list1.get(i)-15)+20);
                           g.drawLine(toplamX,(list1.get(i)-15),toplamX-10,(list1.get(i)-15)+10);
                           g.drawLine(toplamX+15,(list1.get(i)-15),toplamX+25,(list1.get(i)-15)+10);
                           devam=false;
                        }
                    }
                    if(devam==true)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                           System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                        g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                            devam=false;
                        }
                    }    
                    if(devam==true)
                    {
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                        g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    for(i=0;i<list.size();i++)
                    {
                        if(oncekiKonumX<list.get(i) && list.get(i)<=toplamX)
                        {
                           sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                           System.out.println("Geçen süre:"+sn+" saniye");
                           g.setColor(Color.red);
                           g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                           g.setColor(Color.magenta);
                           g.fillRect(list.get(i)-15,toplamY,15,15);
                           g.drawLine((list.get(i)-15)+5,toplamY+15,(list.get(i)-15)+5,toplamY+20);
                           g.drawLine((list.get(i)-15)+10,toplamY+15,(list.get(i)-15)+10,toplamY+20);
                           g.drawLine((list.get(i)-15),toplamY,(list.get(i)-15)-10,toplamY+10);
                            g.drawLine((list.get(i)-15)+15,toplamY,(list.get(i)-15)+25,toplamY+10);
                           devam=false;
                        }
                    }
                    if(devam==true)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                           System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                            devam=false;
                        }
                    }    
                    if(devam==true)
                    {
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    for(i=0;i<list.size();i++)
                    {
                        if(toplamX<=list.get(i) && list.get(i)<oncekiKonumX)
                        {
                           sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                           System.out.println("Geçen süre:"+sn+" saniye");
                           g.setColor(Color.red);
                           g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                           g.setColor(Color.magenta);
                           g.fillRect(list.get(i)-15,toplamY,15,15);
                           g.drawLine((list.get(i)-15)+5,toplamY+15,(list.get(i)-15)+5,toplamY+20);
                           g.drawLine((list.get(i)-15)+10,toplamY+15,(list.get(i)-15)+10,toplamY+20);
                           g.drawLine((list.get(i)-15),toplamY,(list.get(i)-15)-10,toplamY+10);
                            g.drawLine((list.get(i)-15)+15,toplamY,(list.get(i)-15)+25,toplamY+10);
                           devam=false;
                        }
                    }
                    if(devam==true)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                           System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                            devam=false;
                        }
                    }    
                    if(devam==true)
                    {
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                }
                
            }
            if(devam)
            {
                if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.magenta);
                g.fillRect(toplamX,toplamY,15,15);
                g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                g.drawLine(toplamX,toplamY,toplamX-10,toplamY+10);
                g.drawLine(toplamX+15,toplamY,toplamX+25,toplamY+10);
                sn=((double)r3.getHiz()/yerDegistirme);
                System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                System.out.println("Geçen süre:"+sn+" saniye");
                }
                else
                {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.magenta);
                g.fillRect(toplamX,toplamY,15,15);
                g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                g.drawLine(toplamX,toplamY,toplamX-10,toplamY+10);
                g.drawLine(toplamX+15,toplamY,toplamX+25,toplamY+10);
                sn=((double)r3.getHiz()/yerDegistirme);
                System.out.println("Geçen süre:"+sn+" saniye");
                }
            }
            
            q=0;
            y=yonBilgisi2.indexOf(" ");
            den=yonBilgisi2.substring(1,y);
            sayi[q]=den;
            z=0;
            q++;
            
            while(i<yonBilgisi2.length())
            {
                if(yonBilgisi2.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi2.length();j++)
                    {
                        int w=yonBilgisi2.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi2.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
            }
            a=0;
            f=1;
            d=index[a];
            s=0;
            devam=true;
            while(devam)
            {
                
                String tmp=yonBilgisi2.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                }
            }
            if(devam)
            {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.black);
                g.fillOval(toplamX,toplamY,15,15);
                sn+=(double)r3.getTasimaHizi()/yerDegistirme;
                System.out.println("Geçen süre:"+sn+" saniye");
            }
           
            
            
        }
        if(getRobotTipi().equalsIgnoreCase("tekerlekliParalel"))
        {
            i=0;
            while(t<getEngelSayisi())
            {
                g.setColor(Color.red);
                g.fillRect(list.get(i),list1.get(i),30,30);
                i++;
                t++;
            }
            g.setColor(Color.magenta);
            g.fillRect(getX(),getY(),15,15);
            g.drawLine(getX()+5,getY()+15,getX()+5,getY()+20);
            g.drawLine(getX()+10,getY()+15,getX()+10,getY()+20);
            g.drawLine(getX(),getY(),getX()-10,getY()+10);
            g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            
            int x=0,q;
            i=0;
            q=0;
            int[] index=new int[20];
            String[] sayi=new String[20];
            int y=yonBilgisi.indexOf(" ");
            String den=yonBilgisi.substring(1,y);
            sayi[q]=den;
            int z=0;
            q++;
            
            while(i<yonBilgisi.length())
            {
                if(yonBilgisi.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi.length();j++)
                    {
                        int w=yonBilgisi.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
                
            }
            int a=0;
            int f=1;
            int d=index[a];
            int toplamX=getX();
            int toplamY=getY();
            int s=0;
            double engelSure=0;
            int oncekiKonumX,oncekiKonumY;
            boolean devam=true; 
            double sn=0,yerDegistirme=0,yerDegistirme2=0;
            while(devam)
            {
                
                String tmp=yonBilgisi.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                            g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                            sn=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list1.size();i++)
                    {
                        if(oncekiKonumY<list1.get(i) && list1.get(i)<=toplamY)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                            
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.pink);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                            g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                            g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                            sn=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list1.size();i++)
                    {
                        if(toplamY<=list1.get(i) && list1.get(i)<oncekiKonumY)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                            
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(toplamX,oncekiKonumY,toplamX-10,oncekiKonumY+10);
                        g.drawLine(toplamX+15,oncekiKonumY,toplamX+25,oncekiKonumY+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                            sn=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list.size();i++)
                    {
                        if(oncekiKonumX<list.get(i) && list.get(i)<=toplamX)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                        g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                            sn=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list.size();i++)
                    {
                        if(toplamX<=list.get(i) && list.get(i)<oncekiKonumX)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            g.drawLine(oncekiKonumX,toplamY,oncekiKonumX-10,toplamY+10);
                            g.drawLine(oncekiKonumX+15,toplamY,oncekiKonumX+25,toplamY+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                }
                
            }
            
            if(devam)
            {
                if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.magenta);
                g.fillRect(toplamX,toplamY,15,15);
                g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                g.drawLine(toplamX,toplamY,toplamX-10,toplamY+10);
                g.drawLine(toplamX+15,toplamY,toplamX+25,toplamY+10);
                sn=((double)r3.getHiz()/yerDegistirme)+engelSure;
                System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                System.out.println("Geçen süre:"+sn+" saniye");
                }
                else
                {
                g.setColor(Color.magenta);
                g.fillRect(toplamX,toplamY,15,15);
                g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                sn=((double)r3.getHiz()/yerDegistirme)+engelSure;
                System.out.println("Geçen süre:"+sn+" saniye");
                }
            }
            q=0;
            y=yonBilgisi2.indexOf(" ");
            den=yonBilgisi2.substring(1,y);
            sayi[q]=den;
            z=0;
            q++;
            
            while(i<yonBilgisi2.length())
            {
                if(yonBilgisi2.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi2.length();j++)
                    {
                        int w=yonBilgisi2.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi2.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
            }
            a=0;
            f=1;
            d=index[a];
            s=0;
            devam=true;
            while(devam)
            {
                
                String tmp=yonBilgisi2.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                }
            }
            if(devam)
            {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.black);
                g.fillOval(toplamX,toplamY,15,15);
                sn+=(double)r2.getTasimaHizi()/yerDegistirme;
                System.out.println("Geçen süre:"+sn+" saniye");
            }            
        }
        if(getRobotTipi().equalsIgnoreCase("paletliParalel"))
        {
            i=0;
            while(t<getEngelSayisi())
            {
                g.setColor(Color.red);
                g.fillRect(list.get(i),list1.get(i),30,30);
                i++;
                t++;
            }
            g.setColor(Color.magenta);
            g.fillRect(getX(),getY(),15,15);
            g.drawLine(getX()+5,getY()+15,getX()+5,getY()+20);
            g.drawLine(getX()+10,getY()+15,getX()+10,getY()+20);
            g.drawLine(getX(),getY(),getX()-10,getY()+10);
            g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            
            
            int x=0,q;
            i=0;
            q=0;
            int[] index=new int[20];
            String[] sayi=new String[20];
            int y=yonBilgisi.indexOf(" ");
            String den=yonBilgisi.substring(1,y);
            sayi[q]=den;
            int z=0;
            q++;
            
            while(i<yonBilgisi.length())
            {
                if(yonBilgisi.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi.length();j++)
                    {
                        int w=yonBilgisi.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
                
            }
            int a=0;
            int f=1;
            int d=index[a];
            int toplamX=getX();
            int toplamY=getY();
            int s=0;
            int oncekiKonumY,oncekiKonumX;
            double engelSure=0;
            boolean devam=true;
            double sn=0,yerDegistirme=0,yerDegistirme2=0;
            while(devam)
            {
                
                String tmp=yonBilgisi.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            g.drawLine(getX(),getY(),getX()-10,getY()+10);
                            g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                            sn=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list1.size();i++)
                    {
                        if(oncekiKonumY<list1.get(i) && list1.get(i)<=toplamY)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                        
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(getX(),getY(),getX()-10,getY()+10);
                        g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            g.drawLine(getX(),getY(),getX()-10,getY()+10);
                            g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                            sn=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list1.size();i++)
                    {
                        if(toplamY<=list1.get(i) && list1.get(i)<oncekiKonumY)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                           
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            g.drawLine(getX(),getY(),getX()-10,getY()+10);
                            g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                            sn=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list.size();i++)
                    {
                        if(oncekiKonumX<list.get(i) && list.get(i)<=toplamX)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                         
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(getX(),getY(),getX()-10,getY()+10);
                            g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    
                    if(devam)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            g.drawLine(getX(),getY(),getX()-10,getY()+10);
                            g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                            sn=((double)r3.getHiz()/yerDegistirme2)+engelSure;
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            System.out.println("Geçen süre:"+sn+" saniye");
                            devam=false;
                        }
                    }
                    for(i=0;i<list.size();i++)
                    {
                        if(toplamX<=list.get(i) && list.get(i)<oncekiKonumX)
                        {
                            engelSure+=r3.EngelGecmeSuresiBul();
                      
                        }
                    }
                    if(devam)
                    {
                        
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(getX(),getY(),getX()-10,getY()+10);
                            g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                    
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                }
            }
            if(devam)
            {
                if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.magenta);
                g.fillRect(toplamX,toplamY,15,15);
                g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                g.drawLine(getX(),getY(),getX()-10,getY()+10);
                g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                sn=((double)r3.getHiz()/yerDegistirme)+engelSure;
                System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                System.out.println("Geçen süre:"+sn+" saniye");
                }
                else
                {
                g.setColor(Color.magenta);
                g.fillRect(toplamX,toplamY,15,15);
                g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                g.drawLine(getX(),getY(),getX()-10,getY()+10);
                g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                sn=((double)r3.getHiz()/yerDegistirme)+engelSure;
                System.out.println("Geçen süre:"+sn+" saniye");
                }
            }
            q=0;
            y=yonBilgisi2.indexOf(" ");
            den=yonBilgisi2.substring(1,y);
            sayi[q]=den;
            z=0;
            q++;
            
            while(i<yonBilgisi2.length())
            {
                if(yonBilgisi2.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi2.length();j++)
                    {
                        int w=yonBilgisi2.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi2.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
            }
            a=0;
            f=1;
            d=index[a];
            s=0;
            devam=true;
            while(devam)
            {
                
                String tmp=yonBilgisi2.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                }
            }
            if(devam)
            {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.black);
                g.fillOval(toplamX,toplamY,15,15);
                sn+=(double)r3.getTasimaHizi()/yerDegistirme;
                System.out.println("Geçen süre:"+sn+" saniye");
            }            
        }
        if(getRobotTipi().equalsIgnoreCase("spiderParalel"))
        {
            i=0;
            while(t<getEngelSayisi())
            {
                g.setColor(Color.red);
                g.fillRect(list.get(i),list1.get(i),30,30);
                i++;
                t++;
            }
            g.setColor(Color.magenta);
            g.fillRect(getX(),getY(),15,15);
            g.drawLine(getX()+5,getY()+15,getX()+5,getY()+20);
            g.drawLine(getX()+10,getY()+15,getX()+10,getY()+20);
            g.drawLine(getX(),getY(),getX()-10,getY()+10);
            g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            int x=0,q;
            i=0;
            q=0;
            int[] index=new int[20];
            String[] sayi=new String[20];
            int y=yonBilgisi.indexOf(" ");
            String den=yonBilgisi.substring(1,y);
            sayi[q]=den;
            int z=0;
            q++;
            
            while(i<yonBilgisi.length())
            {
                if(yonBilgisi.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi.length();j++)
                    {
                        int w=yonBilgisi.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
                
            }
            int a=0;
            int f=1;
            int d=index[a];
            int toplamX=getX();
            int toplamY=getY();
            int s=0;
            int oncekiKonumX,oncekiKonumY;
            boolean devam=true;
            double sn=0,yerDegistirme=0,yerDegistirme2=0;
            while(devam)
            {
                
                String tmp=yonBilgisi.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    for(i=0;i<list1.size();i++)
                    {
                        if(oncekiKonumY<list1.get(i) && list1.get(i)<=toplamY)
                        {
                            sn=((double)r3.getHiz()/yerDegistirme2);
                            System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                           g.setColor(Color.magenta);
                           g.fillRect(toplamX,list1.get(i)-15,15,15);
                           g.drawLine(toplamX+5,list1.get(i)-15,toplamX+5,(list1.get(i)-15)+20);
                           g.drawLine(toplamX+10,(list1.get(i)-15)+15,toplamX+10,(list1.get(i)-15)+20);
                           g.drawLine(getX(),getY(),getX()-10,getY()+10);
                           g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                           devam=false;
                        }
                    }
                    if(devam==true)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            sn=((double)r3.getHiz()/yerDegistirme2);
                            System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            g.drawLine(getX(),getY(),getX()-10,getY()+10);
                           g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                            devam=false;
                        }
                    }    
                    if(devam==true)
                    {
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(getX(),getY(),getX()-10,getY()+10);
                           g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    for(i=0;i<list1.size();i++)
                    {
                        if(toplamY<=list1.get(i) && list1.get(i)<oncekiKonumY)
                        {
                            sn=((double)r3.getHiz()/yerDegistirme2);
                            System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                           g.setColor(Color.magenta);
                           g.fillRect(toplamX,list1.get(i)-15,15,15);
                           g.drawLine(toplamX+5,list1.get(i)-15,toplamX+5,(list1.get(i)-15)+20);
                           g.drawLine(toplamX+10,(list1.get(i)-15)+15,toplamX+10,(list1.get(i)-15)+20);
                           g.drawLine(getX(),getY(),getX()-10,getY()+10);
                           g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                           devam=false;
                        }
                    }
                    if(devam==true)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            sn=((double)r3.getHiz()/yerDegistirme2);
                             System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",toplamX,oncekiKonumY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(toplamX,oncekiKonumY,15,15);
                            g.drawLine(toplamX+5,oncekiKonumY+15,toplamX+5,oncekiKonumY+20);
                            g.drawLine(toplamX+10,oncekiKonumY+15,toplamX+10,oncekiKonumY+20);
                            g.drawLine(getX(),getY(),getX()-10,getY()+10);
                           g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                            devam=false;
                        }
                    }    
                    if(devam==true)
                    {
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    for(i=0;i<list.size();i++)
                    {
                        if(oncekiKonumX<list.get(i) && list.get(i)<=toplamX)
                        {
                            sn=((double)r3.getHiz()/yerDegistirme2);
                            System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                           g.setColor(Color.magenta);
                           g.fillRect(list.get(i)-15,toplamY,15,15);
                           g.drawLine((list.get(i)-15)+5,toplamY+15,(list.get(i)-15)+5,toplamY+20);
                           g.drawLine((list.get(i)-15)+10,toplamY+15,(list.get(i)-15)+10,toplamY+20);
                           g.drawLine(getX(),getY(),getX()-10,getY()+10);
                           g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                           devam=false;
                        }
                    }
                    if(devam==true)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            sn=((double)r3.getHiz()/yerDegistirme2);
                            System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            g.drawLine(getX(),getY(),getX()-10,getY()+10);
                           g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                            devam=false;
                        }
                    }    
                    if(devam==true)
                    {
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(getX(),getY(),getX()-10,getY()+10);
                           g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    for(i=0;i<list.size();i++)
                    {
                        if(toplamX<=list.get(i) && list.get(i)<oncekiKonumX)
                        {
                            sn=((double)r3.getHiz()/yerDegistirme2);
                            System.out.println("Geçen süre:"+sn+" saniye");
                           g.setColor(Color.red);
                           g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                           g.setColor(Color.magenta);
                           g.fillRect(list.get(i)-15,toplamY,15,15);
                           g.drawLine((list.get(i)-15)+5,toplamY+15,(list.get(i)-15)+5,toplamY+20);
                           g.drawLine((list.get(i)-15)+10,toplamY+15,(list.get(i)-15)+10,toplamY+20);
                           g.drawLine(getX(),getY(),getX()-10,getY()+10);
                           g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                           devam=false;
                        }
                    }
                    if(devam==true)
                    {
                        if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                        {
                            System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                            sn=((double)r3.getHiz()/yerDegistirme2);
                            System.out.println("Geçen süre:"+sn+" saniye");
                            g.setColor(Color.red);
                            g.drawString("Son Konum",oncekiKonumX,toplamY-10);
                            g.setColor(Color.magenta);
                            g.fillRect(oncekiKonumX,toplamY,15,15);
                            g.drawLine(oncekiKonumX+5,toplamY+15,oncekiKonumX+5,toplamY+20);
                            g.drawLine(oncekiKonumX+10,toplamY+15,oncekiKonumX+10,toplamY+20);
                            g.drawLine(getX(),getY(),getX()-10,getY()+10);
                           g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                            devam=false;
                        }
                    }    
                    if(devam==true)
                    {
                        g.setColor(Color.magenta);
                        g.fillRect(toplamX,toplamY,15,15);
                        g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                        g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                        g.drawLine(getX(),getY(),getX()-10,getY()+10);
                           g.drawLine(getX()+15,getY(),getX()+25,getY()+10);
                    }
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                }
            }
            if(devam)
            {
                if(toplamX>=630 || toplamX<30 || toplamY>=650 || toplamY<50)
                {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.magenta);
                g.fillRect(toplamX,toplamY,15,15);
                g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                
                System.out.println(yonBilgisi+" gittikten sonra ızgara dışına çıkar");
                sn=((double)r3.getHiz()/yerDegistirme);
                System.out.println("Geçen süre:"+sn+" saniye");
                }
                else
                {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.magenta);
                g.fillRect(toplamX,toplamY,15,15);
                g.drawLine(toplamX+5,toplamY+15,toplamX+5,toplamY+20);
                g.drawLine(toplamX+10,toplamY+15,toplamX+10,toplamY+20);
                sn=((double)r3.getHiz()/yerDegistirme);
                System.out.println("Geçen süre:"+sn+" saniye");
                }
            }
            q=0;
            y=yonBilgisi2.indexOf(" ");
            den=yonBilgisi2.substring(1,y);
            sayi[q]=den;
            z=0;
            q++;
            
            while(i<yonBilgisi2.length())
            {
                if(yonBilgisi2.charAt(i)==',')
                {
                    for(j=i;j<yonBilgisi2.length();j++)
                    {
                        int w=yonBilgisi2.indexOf(" ",j);
                        index[z]=w;
                        String test=yonBilgisi2.substring(i+1,w);
                        sayi[q]=test;
                        q++;
                        z++;
                        break;
                    }
                }
                i++;
            }
            a=0;
            f=1;
            d=index[a];
            s=0;
            devam=true;
            while(devam)
            {
                
                String tmp=yonBilgisi2.substring(f,d);
                if(tmp.contains("ileri"))
                {
                    oncekiKonumY=toplamY;
                    int v=Integer.parseInt(sayi[s]);
                    toplamY+=(v*30);
                    yerDegistirme+=(v*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("geri"))
                {
                    oncekiKonumY=toplamY;
                    int p=Integer.parseInt(sayi[s]);
                    toplamY-=(p*30);
                    yerDegistirme+=(p*10);
                    yerDegistirme2+=(oncekiKonumY/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",toplamX,oncekiKonumY);
                        g.setColor(Color.black);
                        g.fillOval(toplamX,oncekiKonumY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("saga"))
                {
                    oncekiKonumX=toplamX;
                    int h=Integer.parseInt(sayi[s]);
                    toplamX+=(h*30);
                    yerDegistirme+=(h*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                else if(tmp.contains("sola"))
                {
                    oncekiKonumX=toplamX;
                    int r=Integer.parseInt(sayi[s]);
                    toplamX-=(r*30);
                    yerDegistirme+=(r*10);
                    yerDegistirme2+=(oncekiKonumX/30)*10;
                    if(yerDegistirme>r3.getKolUzunlugu())
                    {
                        g.setColor(Color.red);
                        g.drawString("Son Konum",oncekiKonumX,toplamY);
                        g.setColor(Color.black);
                        g.fillOval(oncekiKonumX,toplamY,15,15);
                        devam=false;
                        System.out.println(yonBilgisi2+" kol uzunluğunu aşmaktadır");
                        sn+=(double)r3.getTasimaHizi()/yerDegistirme2;
                        System.out.println("Geçen süre:"+sn+" saniye");
                    }
                    else if(devam==true)
                    {
                        g.setColor(Color.black);
                        g.fillOval(toplamX,toplamY,15,15);
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                a++;
                s++;
                f=index[a-1];
                d=index[a];
                if(a==z)
                {
                    devam=false;
                }
            }
            if(devam)
            {
                g.setColor(Color.red);
                g.drawString("Son Konum",toplamX,toplamY-10);
                g.setColor(Color.blue);
                g.fillRect(toplamX,toplamY,15,15);
                g.drawLine(toplamX,toplamY,toplamX-10,toplamY+10);
                g.drawLine(toplamX+15,toplamY,toplamX+25,toplamY+10);
                sn+=(double)r3.getTasimaHizi()/yerDegistirme;
                System.out.println("Geçen süre:"+sn+" saniye");
            }            
        }


    }
    
    public void actionPerformed(ActionEvent event){
       
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Tanımlanacak robot sayısı:");
        int robotSayisi=sc.nextInt();
        String robotTipi;
        //String[] robotTipi12=new String[20];
        ArrayList <String> tip=new ArrayList <String>();
        ArrayList <String> robotTipi1=new ArrayList <String>();
        robotTipi=sc.nextLine();
        for(int i=0;i<robotSayisi;i++)
        {
            System.out.println("Tanımlanacak robot tipi:");
            robotTipi=sc.nextLine();
            tip.add(robotTipi);
            
        }
        int motorSayisi,yükMiktari;
        int m,k=0;
        m=0;
        boolean s=true;
        int hizSeri=10;
        int hizParalel=20;
        int yükSeri=5;
        int yükParalel=10;
        int hizTekerlekli=30;
        int hizPaletli=20;
        int hizSpider=10;
        Tekerlekli g1=new Tekerlekli();
        Paletli g2=new Paletli();
        Spider g3=new Spider();
        Seri m1=new Seri();
        Paralel m2=new Paralel();
        Hibrit h1=new Hibrit();
        Hibrit h2=new Hibrit();
        Hibrit h3=new Hibrit();
        Hibrit h4=new Hibrit();
        Hibrit h5=new Hibrit();
        Hibrit h6=new Hibrit();
        Robot[] robot=new Robot[robotSayisi];
        int hiz1,hiz2,hiz3,tekerlekSayisi,paletSayisi,bacakSayisi,tasimaHizi1,yükTasimaKapasitesi1,kolUzunlugu1,tasimaHizi2,yükTasimaKapasitesi2,kolUzunlugu2;
        while(m<robotSayisi){
            robotTipi=tip.get(m).toString();
        if(robotTipi.contains("gezgin"))
        {  
            System.out.println("Gezgin robot türünü seçiniz:"+m);
            System.out.println("Tekerlekli için 1");
            System.out.println("Paletli için 2");
            System.out.println("Spider için 3");
            int secim=sc.nextInt();
            String str;
            int cevap;
            int[] konumX=new int[20];
            int[] konumY=new int[20];
            ArrayList <String> yonBilgisi=new ArrayList <String>();
            int engelSayisi=0;
            switch(secim)
            {
                case 1:
                    robotTipi1.add("tekerlekli");
                    robotTipi="tekerlekli";
                    System.out.println("Motor sayısını giriniz:");
                    motorSayisi=sc.nextInt();
                    System.out.println("Yük miktarini giriniz:");
                    yükMiktari=sc.nextInt();
                    do
                    {
                        System.out.println("Tekerli robotun tekerlek sayısını giriniz:");
                        tekerlekSayisi=sc.nextInt();
                        System.out.println("Tekerlekli robotun hızını giriniz:");
                        hiz1=sc.nextInt();
                    }while(hiz1<hizTekerlekli);
                    g1=new Tekerlekli(motorSayisi, yükMiktari, robotTipi, hiz1, tekerlekSayisi);
                    
                    break;
                case 2:
                   robotTipi="paletli";
                   robotTipi1.add("paletli");
                   System.out.println("Motor sayısını giriniz:");
                    motorSayisi=sc.nextInt();
                    System.out.println("Yük miktarini giriniz:");
                    yükMiktari=sc.nextInt();
                    do
                    {
                        System.out.println("Paletli robotun palet sayısını giriniz:");
                        paletSayisi=sc.nextInt();
                        System.out.println("Paletli robotun hızını giriniz:");
                        hiz2=sc.nextInt();
                    }while(hiz2<hizPaletli);
                    g2=new Paletli(motorSayisi, yükMiktari, robotTipi, hiz2, paletSayisi);
                    
                    break;
                case 3:
                    robotTipi="spider";
                    robotTipi1.add("spider");
                    System.out.println("Motor sayısını giriniz:");
                    motorSayisi=sc.nextInt();
                    System.out.println("Yük miktarini giriniz:");
                    yükMiktari=sc.nextInt();
                    do
                    {
                        System.out.println("Spider robotun bacak sayısını giriniz:");
                        bacakSayisi=sc.nextInt();
                        System.out.println("Spider robotun hızını giriniz:");
                        hiz3=sc.nextInt(); 
                    }while(hiz3<hizSpider);
                    g3=new Spider(motorSayisi, yükMiktari, robotTipi, hiz3, bacakSayisi);
                    
                    break;
                    
            }
        }
        else if(robotTipi.equalsIgnoreCase("manipülatör robot") ||  robotTipi.equalsIgnoreCase("gezmeyen"))
        {
            
            System.out.println("Manipülatör robot türünü seçiniz:");
            System.out.println("Seri için 1");
            System.out.println("Paralel için 2");
            int secim=sc.nextInt();
            
            ArrayList <String> yonBilgisi=new ArrayList <String>();
            
            switch(secim)
            {
                case 1:
                    robotTipi="seri";
                    robotTipi1.add("seri");
                    System.out.println("Motor sayısını giriniz:");
                    motorSayisi=sc.nextInt();
                    System.out.println("Yük miktarini giriniz:");
                    yükMiktari=sc.nextInt();
                    do
                    {
                        System.out.println("Seri robotun yük taşıma kapasitesini giriniz:");
                        yükTasimaKapasitesi1=sc.nextInt();
                        System.out.println("Seri robotun taşıma hızını giriniz:");
                        tasimaHizi1=sc.nextInt();
                        System.out.println("Seri robotun kol uzunluğunu giriniz:");
                        kolUzunlugu1=sc.nextInt();
                    }while(tasimaHizi1<hizSeri && yükTasimaKapasitesi1<yükSeri);
                    while(yükMiktari>yükTasimaKapasitesi1)
                    {
                        System.out.println("Seri robotun yük miktarını giriniz:");
                        yükMiktari=sc.nextInt();
                    }
                    m1=new Seri(motorSayisi, yükMiktari, robotTipi, yükTasimaKapasitesi1, kolUzunlugu1, tasimaHizi1);
                    
                    break;
                case 2:
                    robotTipi="paralel";
                    robotTipi1.add("paralel");
                    System.out.println("Motor sayısını giriniz:");
                    motorSayisi=sc.nextInt();
                    System.out.println("Yük miktarini giriniz:");
                    yükMiktari=sc.nextInt();
                    do
                    {
                        System.out.println("Paralel robotun yük taşıma kapasitesini giriniz:");
                        yükTasimaKapasitesi2=sc.nextInt();
                        System.out.println("Paralel robotun taşıma hızını giriniz:");
                        tasimaHizi2=sc.nextInt();
                        System.out.println("Paralel robotun kol uzunluğunu giriniz:");
                        kolUzunlugu2=sc.nextInt();
                    }while(tasimaHizi2<hizParalel && yükTasimaKapasitesi2<yükParalel);
                    while(yükMiktari>yükTasimaKapasitesi2)
                    {
                        System.out.println("Seri robotun yük miktarını giriniz:");
                        yükMiktari=sc.nextInt();
                    }
                    m2=new Paralel(motorSayisi, yükMiktari, robotTipi, yükTasimaKapasitesi2, kolUzunlugu2, tasimaHizi2);
                    
                    break;
                    
                    
            }
        }
        else if(robotTipi.contains("hibrit") || robotTipi.contains("gezgin manipülatör"))
        {
            
            System.out.println("Kullanılacak robot tipini seçiniz:");
            System.out.println("Tekerlekli seri için 1");
            System.out.println("Paletli seri için 2");
            System.out.println("Spider seri için 3");
            System.out.println("Tekerlekli paralel için 4");
            System.out.println("Paletli paralel için 5");
            System.out.println("Spider paralel için 6");
            int secim=sc.nextInt();
            String str1,str2;
            int cevap;
            int[] konumX=new int[20];
            int[] konumY=new int[20];
            ArrayList <String> yonBilgisi1=new ArrayList <String>();
            ArrayList <String> yonBilgisi2=new ArrayList <String>();
            int engelSayisi=0;
            switch(secim)
            {
                case 1:
                    robotTipi="tekerlekliSeri";
                    robotTipi1.add("tekerlekliSeri");
                    System.out.println("Motor sayısını giriniz:");
                    motorSayisi=sc.nextInt();
                    System.out.println("Yük miktarini giriniz:");
                    yükMiktari=sc.nextInt();
                    do
                    {
                        System.out.println("Tekerli robotun tekerlek sayısını giriniz:");
                        tekerlekSayisi=sc.nextInt();
                        System.out.println("Tekerlekli robotun hızını giriniz:");
                        hiz1=sc.nextInt();
                        System.out.println("Seri robotun yük taşıma kapasitesini giriniz:");
                        yükTasimaKapasitesi1=sc.nextInt();
                        System.out.println("Seri robotun taşıma hızını giriniz:");
                        tasimaHizi1=sc.nextInt();
                        System.out.println("Seri robotun kol uzunluğunu giriniz:");
                        kolUzunlugu1=sc.nextInt();
                    }while(hiz1<hizTekerlekli && tasimaHizi1<hizSeri && yükTasimaKapasitesi1<yükSeri);
                    while(yükMiktari>yükTasimaKapasitesi1)
                    {
                        System.out.println("Seri robotun yük miktarını giriniz:");
                        yükMiktari=sc.nextInt();
                    }
                    h1=new Hibrit(motorSayisi, yükMiktari, robotTipi, yükTasimaKapasitesi1, kolUzunlugu1, tasimaHizi1, hiz1);
                   
                    break;
                    
                 case 2:
                    robotTipi="paletliSeri";
                     robotTipi1.add("paletliSeri");
                     System.out.println("Motor sayısını giriniz:");
                    motorSayisi=sc.nextInt();
                    System.out.println("Yük miktarini giriniz:");
                    yükMiktari=sc.nextInt();
                    do
                    {
                        System.out.println("Paletli robotun tekerlek sayısını giriniz:");
                        paletSayisi=sc.nextInt();
                        System.out.println("Paletli robotun hızını giriniz:");
                        hiz2=sc.nextInt();
                        System.out.println("Seri robotun yük taşıma kapasitesini giriniz:");
                        yükTasimaKapasitesi1=sc.nextInt();
                        System.out.println("Seri robotun taşıma hızını giriniz:");
                        tasimaHizi1=sc.nextInt();
                        System.out.println("Seri robotun kol uzunluğunu giriniz:");
                        kolUzunlugu1=sc.nextInt();
                    }while(hiz2<hizPaletli && tasimaHizi1<hizSeri && yükTasimaKapasitesi1<yükSeri);
                    while(yükMiktari>yükTasimaKapasitesi1)
                    {
                        System.out.println("Seri robotun yük miktarını giriniz:");
                        yükMiktari=sc.nextInt();
                    }
                    h2=new Hibrit(motorSayisi, yükMiktari, robotTipi, yükTasimaKapasitesi1, kolUzunlugu1, tasimaHizi1, hiz2);
                    break;
                    
                case 3:
                    robotTipi="spiderSeri";
                    robotTipi1.add("spiderSeri");
                    System.out.println("Motor sayısını giriniz:");
                    motorSayisi=sc.nextInt();
                    System.out.println("Yük miktarini giriniz:");
                    yükMiktari=sc.nextInt();
                    do
                    {
                        System.out.println("Spider robotun tekerlek sayısını giriniz:");
                        bacakSayisi=sc.nextInt();
                        System.out.println("Spider robotun hızını giriniz:");
                        hiz3=sc.nextInt();
                        System.out.println("Seri robotun yük taşıma kapasitesini giriniz:");
                        yükTasimaKapasitesi1=sc.nextInt();
                        System.out.println("Seri robotun taşıma hızını giriniz:");
                        tasimaHizi1=sc.nextInt();
                        System.out.println("Seri robotun kol uzunluğunu giriniz:");
                        kolUzunlugu1=sc.nextInt();
                    }while(hiz3<hizSpider && tasimaHizi1<hizSeri && yükTasimaKapasitesi1<yükSeri);
                    while(yükMiktari>yükTasimaKapasitesi1)
                    {
                        System.out.println("Seri robotun yük miktarını giriniz:");
                        yükMiktari=sc.nextInt();
                    }
                    h3=new Hibrit(motorSayisi, yükMiktari, robotTipi, yükTasimaKapasitesi1, kolUzunlugu1, tasimaHizi1, hiz3);
                    break;
                    
                case 4:
                    robotTipi="tekerlekliParalel";
                    robotTipi1.add("tekerlekliParalel");
                    System.out.println("Motor sayısını giriniz:");
                    motorSayisi=sc.nextInt();
                    System.out.println("Yük miktarini giriniz:");
                    yükMiktari=sc.nextInt();
                    do
                    {
                        System.out.println("Tekerli robotun tekerlek sayısını giriniz:");
                        tekerlekSayisi=sc.nextInt();
                        System.out.println("Tekerlekli robotun hızını giriniz:");
                        hiz1=sc.nextInt();
                        System.out.println("Paralel robotun yük taşıma kapasitesini giriniz:");
                        yükTasimaKapasitesi2=sc.nextInt();
                        System.out.println("Paralel robotun taşıma hızını giriniz:");
                        tasimaHizi2=sc.nextInt();
                        System.out.println("Paralel robotun kol uzunluğunu giriniz:");
                        kolUzunlugu2=sc.nextInt();
                    }while(hiz1<hizTekerlekli && tasimaHizi2<hizParalel && yükTasimaKapasitesi2<yükParalel);
                    while(yükMiktari>yükTasimaKapasitesi2)
                    {
                        System.out.println("Paralel robotun yük miktarını giriniz:");
                        yükMiktari=sc.nextInt();
                    }
                    h4=new Hibrit(motorSayisi, yükMiktari, robotTipi, yükTasimaKapasitesi2, kolUzunlugu2, tasimaHizi2, hiz1);
                    
                    break;
                    
                case 5:
                    robotTipi="paletliParalel";
                    robotTipi1.add("paletliParalel");
                    System.out.println("Motor sayısını giriniz:");
                    motorSayisi=sc.nextInt();
                    System.out.println("Yük miktarini giriniz:");
                    yükMiktari=sc.nextInt();
                    do
                    {
                        System.out.println("Paletli robotun tekerlek sayısını giriniz:");
                        paletSayisi=sc.nextInt();
                        System.out.println("Paletli robotun hızını giriniz:");
                        hiz2=sc.nextInt();
                        System.out.println("Paralel robotun yük taşıma kapasitesini giriniz:");
                        yükTasimaKapasitesi2=sc.nextInt();
                        System.out.println("Paralel robotun taşıma hızını giriniz:");
                        tasimaHizi2=sc.nextInt();
                        System.out.println("Paralel robotun kol uzunluğunu giriniz:");
                        kolUzunlugu2=sc.nextInt();
                    }while(hiz2<hizPaletli && tasimaHizi2<hizParalel && yükTasimaKapasitesi2<yükParalel);
                    while(yükMiktari>yükTasimaKapasitesi2)
                    {
                        System.out.println("Paralel robotun yük miktarını giriniz:");
                        yükMiktari=sc.nextInt();
                    }
                    h5=new Hibrit(motorSayisi, yükMiktari, robotTipi, yükTasimaKapasitesi2, kolUzunlugu2, tasimaHizi2, hiz2);
                    
                    break;
                    
                case 6:
                    robotTipi="spiderParalel";
                    robotTipi1.add("spiderParalel");
                    System.out.println("Motor sayısını giriniz:");
                    motorSayisi=sc.nextInt();
                    System.out.println("Yük miktarini giriniz:");
                    yükMiktari=sc.nextInt();
                    do
                    {
                        System.out.println("Spider robotun tekerlek sayısını giriniz:");
                        bacakSayisi=sc.nextInt();
                        System.out.println("Spider robotun hızını giriniz:");
                        hiz3=sc.nextInt();
                        System.out.println("Paralel robotun yük taşıma kapasitesini giriniz:");
                        yükTasimaKapasitesi2=sc.nextInt();
                        System.out.println("Paralel robotun taşıma hızını giriniz:");
                        tasimaHizi2=sc.nextInt();
                        System.out.println("Paralel robotun kol uzunluğunu giriniz:");
                        kolUzunlugu2=sc.nextInt();
                    }while(hiz3<hizSpider && tasimaHizi2<hizParalel && yükTasimaKapasitesi2<yükParalel);
                    while(yükMiktari>yükTasimaKapasitesi2)
                    {
                        System.out.println("Paralel robotun yük miktarını giriniz:");
                        yükMiktari=sc.nextInt();
                    }
                    h6=new Hibrit(motorSayisi, yükMiktari, robotTipi, yükTasimaKapasitesi2, kolUzunlugu2, tasimaHizi2, hiz3);
                    
                    break;
                    
        }
        
        
    }   
        m++;
        
}
      
        m=0;
        System.out.println("Hangi sıradaki robot hareket ettirilecek:");
        int sira=sc.nextInt();
        int cevap,engelSayisi=0;
        int[] konumX=new int[20];
        int[] konumY=new int[20];
        String str,str1,str2;
        int i=0,x,y;
        x=0;
        y=0;
        ArrayList <String> yonBilgisi=new ArrayList <String>();
        ArrayList <String> yonBilgisi1=new ArrayList <String>();
        ArrayList <String> yonBilgisi2=new ArrayList <String>();
        if(robotTipi1.get((sira-1)).contains("tekerlekli"))
        {
            System.out.println("Engel yerleştirmek istiyor musunuz?(evet:1 / hayır:2");
                    cevap=sc.nextInt();
                    if(cevap==1)
                    {
                        System.out.println("Engel sayisi:");
                        engelSayisi=sc.nextInt();
                        for(i=0;i<engelSayisi;i++)
                        {
                            System.out.println((i+1)+".Engelin konumu(x,y)");
                            konumX[i]=sc.nextInt();
                            konumY[i]=sc.nextInt();
                        }
                    }
                    System.out.println("Başlangıç noktasını giriniz:");
                    x=sc.nextInt();
                    y=sc.nextInt();
                    i=0;
                    System.out.println("Tekerlekli robotun yön bilgisini giriniz:");
                    while(i<2)
                    {
                        
                        str=sc.nextLine();
                        yonBilgisi.add(0, str);
                        i++;
                    }
                    
                    Proje t=new Proje(x, y,engelSayisi, konumX, konumY, robotTipi, yonBilgisi,g1);
                    
        }
        else if(robotTipi1.get((sira-1)).contains("paletli"))
        {
            System.out.println("Engel yerleştirmek istiyor musunuz?(evet:1 / hayır:2");
                    cevap=sc.nextInt();
                    if(cevap==1)
                    {
                        System.out.println("Engel sayisi:");
                        engelSayisi=sc.nextInt();
                        for(i=0;i<engelSayisi;i++)
                        {
                            System.out.println((i+1)+".Engelin konumu(x,y)");
                            konumX[i]=sc.nextInt();
                            konumY[i]=sc.nextInt();
                        }
                    }
                    System.out.println("Başlangıç noktasını giriniz:");
                    x=sc.nextInt();
                    y=sc.nextInt();
                     i=0;
                    System.out.println("Paletli robotun yön bilgisini giriniz:");
                    while(i<2)
                    {
                        
                        str=sc.nextLine();
                        yonBilgisi.add(0, str);
                        i++;
                    }
                    
                    
                    Proje n=new Proje(x, y,engelSayisi, konumX, konumY, robotTipi, yonBilgisi,g2);
        }
        else if(robotTipi1.get((sira-1)).contains("spider"))
        {
            System.out.println("Engel yerleştirmek istiyor musunuz?(evet:1 / hayır:2");
                    cevap=sc.nextInt();
                    if(cevap==1)
                    {
                        System.out.println("Engel sayisi:");
                        engelSayisi=sc.nextInt();
                        for(i=0;i<engelSayisi;i++)
                        {
                            System.out.println((i+1)+".Engelin konumu(x,y)");
                            konumX[i]=sc.nextInt();
                            konumY[i]=sc.nextInt();
                        }
                    }
                    System.out.println("Başlangıç noktasını giriniz:");
                    x=sc.nextInt();
                    y=sc.nextInt();
                     i=0;
                    System.out.println("Spider robotun yön bilgisini giriniz:");
                    while(i<2)
                    {
                        
                        str=sc.nextLine();
                        yonBilgisi.add(0, str);
                        i++;
                    }
                    
                    
                    //Spider r3=new Spider(motorSayisi,yükMiktari,robotTipi,hiz3,bacakSayisi);
                    Proje g=new Proje(x, y,engelSayisi, konumX, konumY, robotTipi, yonBilgisi,g3);
            }
          
        
        else if(robotTipi1.get((sira-1)).contains("seri"))
        {
            System.out.println("Başlangıç noktasını giriniz:");
                    x=sc.nextInt();
                    y=sc.nextInt();
              
                    i=0;
                    System.out.println("Seri robotun yön bilgisini giriniz:");
                    while(i<2)
                    {
                        
                        str=sc.nextLine();
                        yonBilgisi.add(0, str);
                        i++;
                    }
                    Proje p=new Proje(x,y,robotTipi,yonBilgisi,m1);
                    
        }
        else if(robotTipi1.get((sira-1)).contains("paralel"))
        {
            System.out.println("Başlangıç noktasını giriniz:");
                     x=sc.nextInt();
                     y=sc.nextInt();
                    
                    i=0;
                    System.out.println("Paralel robotun yön bilgisini giriniz:");
                    while(i<2)
                    {
                        
                        str=sc.nextLine();
                        yonBilgisi.add(0, str);
                        i++;
                    }
                    Proje v=new Proje(x,y,robotTipi,yonBilgisi,m2);
        }
        else if(robotTipi1.get((sira-1)).contains("tekerlekliSeri"))
        {
            System.out.println("Engel yerleştirmek istiyor musunuz?(evet:1 / hayır:2");
                    cevap=sc.nextInt();
                    if(cevap==1)
                    {
                        System.out.println("Engel sayisi:");
                        engelSayisi=sc.nextInt();
                        for(i=0;i<engelSayisi;i++)
                        {
                            System.out.println((i+1)+".Engelin konumu(x,y)");
                            konumX[i]=sc.nextInt();
                            konumY[i]=sc.nextInt();
                        }
                    }
                    System.out.println("Başlangıç noktasını giriniz:");
                    x=sc.nextInt();
                    y=sc.nextInt();
                    i=0;
                    System.out.println("Tekerlekli robotun yön bilgisini giriniz:");
                    boolean d=true;
                    while(d)
                    {
                        
                        str1=sc.nextLine();
                        yonBilgisi1.add(str1);
                        d=false;
                    }
                    i=0;
                    d=true;
                    System.out.println("Seri robotun yön bilgisini giriniz:");
                    while(d)
                    {
                        
                        str2=sc.nextLine();
                        yonBilgisi2.add(0, str2);
                        d=false;
                    }
                  
                    Proje h=new Proje(x, y, robotTipi, yonBilgisi1, engelSayisi, konumX, konumY, yonBilgisi2,h1);
        }
        else if(robotTipi1.get((sira-1)).contains("paletliSeri"))
        {
            System.out.println("Engel yerleştirmek istiyor musunuz?(evet:1 / hayır:2");
                    cevap=sc.nextInt();
                    if(cevap==1)
                    {
                        System.out.println("Engel sayisi:");
                        engelSayisi=sc.nextInt();
                        for(i=0;i<engelSayisi;i++)
                        {
                            System.out.println((i+1)+".Engelin konumu(x,y)");
                            konumX[i]=sc.nextInt();
                            konumY[i]=sc.nextInt();
                        }
                    }
                    System.out.println("Başlangıç noktasını giriniz:");
                    x=sc.nextInt();
                    y=sc.nextInt();
                    i=0;
                    System.out.println("Paletli robotun yön bilgisini giriniz:");
                    while(i<2)
                    {
                        
                        str1=sc.nextLine();
                        yonBilgisi1.add(0, str1);
                        i++;
                    }
                    i=0;
                    System.out.println("Seri robotun yön bilgisini giriniz:");
                    while(i<2)
                    {
                        
                        str2=sc.nextLine();
                        yonBilgisi2.add(0, str2);
                        i++;
                    }
                    
                    Proje n2=new Proje(x, y, robotTipi, yonBilgisi1, engelSayisi, konumX, konumY, yonBilgisi2,h2);
        }
        else if(robotTipi1.get((sira-1)).contains("spiderSeri"))
        {
            System.out.println("Engel yerleştirmek istiyor musunuz?(evet:1 / hayır:2");
                    cevap=sc.nextInt();
                    if(cevap==1)
                    {
                        System.out.println("Engel sayisi:");
                        engelSayisi=sc.nextInt();
                        for(i=0;i<engelSayisi;i++)
                        {
                            System.out.println((i+1)+".Engelin konumu(x,y)");
                            konumX[i]=sc.nextInt();
                            konumY[i]=sc.nextInt();
                        }
                    }
                    System.out.println("Başlangıç noktasını giriniz:");
                    x=sc.nextInt();
                    y=sc.nextInt();
                    i=0;
                    System.out.println("Spider robotun yön bilgisini giriniz:");
                    while(i<2)
                    {
                        
                        str1=sc.nextLine();
                        yonBilgisi1.add(0, str1);
                        i++;
                    }
                    i=0;
                    System.out.println("Seri robotun yön bilgisini giriniz:");
                    while(i<2)
                    {
                        
                        str2=sc.nextLine();
                        yonBilgisi2.add(0, str2);
                        i++;
                    }
                    
                    Proje n3=new Proje(x, y, robotTipi, yonBilgisi1, engelSayisi, konumX, konumY, yonBilgisi2,h3);
        }
        else if(robotTipi1.get((sira-1)).contains("tekerlekliParalel"))
        {
            System.out.println("Engel yerleştirmek istiyor musunuz?(evet:1 / hayır:2");
                    cevap=sc.nextInt();
                    if(cevap==1)
                    {
                        System.out.println("Engel sayisi:");
                        engelSayisi=sc.nextInt();
                        for(i=0;i<engelSayisi;i++)
                        {
                            System.out.println((i+1)+".Engelin konumu(x,y)");
                            konumX[i]=sc.nextInt();
                            konumY[i]=sc.nextInt();
                        }
                    }
                    System.out.println("Başlangıç noktasını giriniz:");
                    x=sc.nextInt();
                    y=sc.nextInt();
                    i=0;
                    System.out.println("Tekerlekli robotun yön bilgisini giriniz:");
                    while(i<2)
                    {
                        
                        str1=sc.nextLine();
                        yonBilgisi1.add(0, str1);
                        i++;
                    }
                    
                    i=0;
                    System.out.println("Paralel robotun yön bilgisini giriniz:");
                    while(i<2)
                    {
                        
                        str2=sc.nextLine();
                        yonBilgisi2.add(0, str2);
                        i++;
                    }
                    
                    Proje n4=new Proje(x, y, robotTipi, yonBilgisi1, engelSayisi, konumX, konumY, yonBilgisi2,h4);
        }
        else if(robotTipi1.get((sira-1)).contains("paletliParalel"))
        {
            System.out.println("Engel yerleştirmek istiyor musunuz?(evet:1 / hayır:2");
                    cevap=sc.nextInt();
                    if(cevap==1)
                    {
                        System.out.println("Engel sayisi:");
                        engelSayisi=sc.nextInt();
                        for(i=0;i<engelSayisi;i++)
                        {
                            System.out.println((i+1)+".Engelin konumu(x,y)");
                            konumX[i]=sc.nextInt();
                            konumY[i]=sc.nextInt();
                        }
                    }
                    System.out.println("Başlangıç noktasını giriniz:");
                    x=sc.nextInt();
                    y=sc.nextInt();
                    i=0;
                    System.out.println("Paletli robotun yön bilgisini giriniz:");
                    while(i<2)
                    {
                        
                        str1=sc.nextLine();
                        yonBilgisi1.add(0, str1);
                        i++;
                    }
                    
                    i=0;
                    System.out.println("Paralel robotun yön bilgisini giriniz:");
                    while(i<2)
                    {
                        
                        str2=sc.nextLine();
                        yonBilgisi2.add(0, str2);
                        i++;
                    }
                    
                    Proje n5=new Proje(x, y, robotTipi, yonBilgisi1, engelSayisi, konumX, konumY, yonBilgisi2,h5);
        }
        else if(robotTipi1.get((sira-1)).contains("spiderParalel"))
        {
            System.out.println("Engel yerleştirmek istiyor musunuz?(evet:1 / hayır:2");
                    cevap=sc.nextInt();
                    sc.nextLine();
                    if(cevap==1)
                    {
                        System.out.println("Engel sayisi:");
                        engelSayisi=sc.nextInt();
                        for(i=0;i<engelSayisi;i++)
                        {
                            System.out.println((i+1)+".Engelin konumu(x,y)");
                            konumX[i]=sc.nextInt();
                            konumY[i]=sc.nextInt();
                        }
                    }
                    /*System.out.println("Başlangıç noktasını giriniz:");
                    x=sc.nextInt();
                    y=sc.nextInt();
                    
                    sc.nextLine();
                    sc.nextLine();*/
                    //i=0;
                    boolean f=true;
                    while(f)
                    {
                        System.out.println("Başlangıç noktasını giriniz:");
                    x=sc.nextInt();
                    y=sc.nextInt();
                    
                    sc.nextLine();
                    sc.nextLine();
                        System.out.println("Spider  robotun yön bilgisini giriniz:");
                        str1=sc.nextLine();
                        //yonBilgisi1.add(str1);
                        sc.nextInt();
                        sc.nextLine();
                        System.out.println("Paralel robotun yön bilgisini giriniz:");
                        str2=sc.nextLine();
                        yonBilgisi1.add(str1);
                        yonBilgisi2.add(str2);
                        f=false; 
                    }
                    
                    
                    /*System.out.println("Spider  robotun yön bilgisini giriniz:");
                    str1=sc.nextLine();
                    yonBilgisi1.add(0, str1);
                    /*while(i<2)
                    {
                        str1=sc.nextLine();
                        yonBilgisi1.add(0, str1);
                        i++;
                    }*/
                    //i=0;
                    //str2=sc.nextLine();
                   //sc.nextInt();
                    //sc.nextLine();
                    
                    /*System.out.println("Paralel robotun yön bilgisini giriniz:");
                    str1=sc.nextLine();
                    yonBilgisi2.add(0, str1);
                    /*while(i<2)
                    {
                        
                        str2=sc.nextLine();
                        yonBilgisi2.add(0, str2);
                        i++;
                    }*/
                    
                    Proje n6=new Proje(x, y, robotTipi, yonBilgisi1, engelSayisi, konumX, konumY, yonBilgisi2,h6);
                   
                    
                    
        }
        
    }
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the engelSayisi
     */
    public int getEngelSayisi() {
        return engelSayisi;
    }

    /**
     * @param engelSayisi the engelSayisi to set
     */
    public void setEngelSayisi(int engelSayisi) {
        this.engelSayisi = engelSayisi;
    }

    /**
     * @return the engelKonumuX
     */
    public int[] getEngelKonumuX() {
        return engelKonumuX;
    }

    /**
     * @param engelKonumuX the engelKonumuX to set
     */
    public void setEngelKonumuX(int[] engelKonumuX) {
        this.engelKonumuX = engelKonumuX;
    }

    /**
     * @return the engelKonumuY
     */
    public int[] getEngelKonumuY() {
        return engelKonumuY;
    }

    /**
     * @param engelKonumuY the engelKonumuY to set
     */
    public void setEngelKonumuY(int[] engelKonumuY) {
        this.engelKonumuY = engelKonumuY;
    }

    /**
     * @return the robotTipi
     */
    public String getRobotTipi() {
        return robotTipi;
    }

    /**
     * @param robotTipi the robotTipi to set
     */
    public void setRobotTipi(String robotTipi) {
        this.robotTipi = robotTipi;
    }

    /**
     * @return the yonBilgisi
     */
    /*public String getYonBilgisi() {
        return yonBilgisi;
    }

    /**
     * @param yonBilgisi the yonBilgisi to set
     */
    /*public void setYonBilgisi(String yonBilgisi) {
        this.yonBilgisi = yonBilgisi;
    }*/

}

