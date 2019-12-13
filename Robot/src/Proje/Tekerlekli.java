/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proje;

/**
 *
 * @author busra
 */
public class Tekerlekli extends GezginRobot{
    private int  tekerlekSayisi;

    public Tekerlekli() {
    }
     public Tekerlekli(int motorSayisi,int yükMiktari,String robotTipi,int hiz,int tekerlekSayisi)
        {
            super(motorSayisi,yükMiktari,robotTipi,hiz);
            this.tekerlekSayisi=tekerlekSayisi;
        }
     public double EngelGecmeSuresiBul()
     {
         return getMotorSayisi()*0.5;
     }

    /**
     * @return the tekerlekSayisi
     */
    public int getTekerlekSayisi() {
        return tekerlekSayisi;
    }

    /**
     * @param tekerlekSayisi the tekerlekSayisi to set
     */
    public void setTekerlekSayisi(int tekerlekSayisi) {
        this.tekerlekSayisi = tekerlekSayisi;
    }
    
}