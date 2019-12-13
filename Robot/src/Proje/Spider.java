/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proje;


public class Spider extends GezginRobot {
    private int bacakSayisi;

    public Spider() {
    }
    
    public Spider(int motorSayisi,int yükMiktari,String robotTipi,int hiz,int bacakSayisi)
        {
            super(motorSayisi,yükMiktari,robotTipi,hiz);
            this.bacakSayisi=bacakSayisi;
        }
    public double EngelGecmeSuresiBul()
    {
        return 0;
    }

    /**
     * @return the bacakSayisi
     */
    public int getBacakSayisi() {
        return bacakSayisi;
    }

    /**
     * @param bacakSayisi the bacakSayisi to set
     */
    public void setBacakSayisi(int bacakSayisi) {
        this.bacakSayisi = bacakSayisi;
    }
    
    
}