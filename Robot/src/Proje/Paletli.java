/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proje;


public class Paletli extends GezginRobot{
    private int paletSayisi;

    public Paletli() {
    }
    
    public Paletli(int motorSayisi,int yükMiktari,String robotTipi,int hiz,int paletSayisi)
        {
            super(motorSayisi,yükMiktari,robotTipi,hiz);
            this.paletSayisi=paletSayisi;
        }
    public double EngelGecmeSuresiBul()
     {
         return getMotorSayisi()*3;
     }

    /**
     * @return the paletSayisi
     */
    public int getPaletSayisi() {
        return paletSayisi;
    }

    /**
     * @param paletSayisi the paletSayisi to set
     */
    public void setPaletSayisi(int paletSayisi) {
        this.paletSayisi = paletSayisi;
    }
    
}