/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proje;


public abstract class ManipülatorRobot extends Robot{
    private int yükTasimaKapasitesi;
    private int kolUzunlugu;
    private int tasimaHizi;

    public ManipülatorRobot() {
    }
    
    public ManipülatorRobot(int motorSayisi,int yükMiktari,String robotTipi,int yükTasimaKapasitesi,int kolUzunlugu,int tasimaHizi)
    {
        super(motorSayisi,yükMiktari,robotTipi);
        this.yükTasimaKapasitesi=yükTasimaKapasitesi;
        this.kolUzunlugu=kolUzunlugu;
        this.tasimaHizi=tasimaHizi;
        
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