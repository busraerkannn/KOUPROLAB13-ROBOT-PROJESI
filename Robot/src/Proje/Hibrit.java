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
public class Hibrit extends GezginRobot {
    private int yükTasimaKapasitesi;
    private int kolUzunlugu;
    private int tasimaHizi;

    public Hibrit() {
    }
    
    public Hibrit(int motorSayisi,int yükMiktari,String robotTipi,int yükTasimaKapasitesi,int kolUzunlugu,int tasimaHizi,int hiz)
    {
        super(motorSayisi,yükMiktari,robotTipi,hiz);
        this.kolUzunlugu=kolUzunlugu;
        this.tasimaHizi=tasimaHizi;
        this.yükTasimaKapasitesi=yükTasimaKapasitesi;
    }
    
    public double EngelGecmeSuresiBul()
    {
        if(getRobotTipi().contains("tekerlekli"))
        {
            return getMotorSayisi()*0.5;
        }
        else if(getRobotTipi().contains("paletli"))
        {
            return getMotorSayisi()*3;
        }
        return 0;
    }

    /**
     * @return the yükTasimaKapasitesi
     */
    public int getYükTasimaKapasitesi() {
        return yükTasimaKapasitesi;
    }

    /**
     * @param yükTasimaKapasitesi the yükTasimaKapasitesi to set
     */
    public void setYükTasimaKapasitesi(int yükTasimaKapasitesi) {
        this.yükTasimaKapasitesi = yükTasimaKapasitesi;
    }

    /**
     * @return the kolUzunlugu
     */
    public int getKolUzunlugu() {
        return kolUzunlugu;
    }

    /**
     * @param kolUzunlugu the kolUzunlugu to set
     */
    public void setKolUzunlugu(int kolUzunlugu) {
        this.kolUzunlugu = kolUzunlugu;
    }

    /**
     * @return the tasimaHizi
     */
    public int getTasimaHizi() {
        return tasimaHizi;
    }

    /**
     * @param tasimaHizi the tasimaHizi to set
     */
    public void setTasimaHizi(int tasimaHizi) {
        this.tasimaHizi = tasimaHizi;
    }
    
}