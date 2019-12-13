/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proje;

public abstract class Robot {
    
    private int motorSayisi;
    private int yükMiktari;
    private String robotTipi;
    public Robot()
    {
        
    }
    public Robot(int motorSayisi,int yükMiktari,String robotTipi)
    {
        this.motorSayisi=motorSayisi;
        this.yükMiktari=yükMiktari;
        this.robotTipi=robotTipi;
    }

    /**
     * @return the motorSayisi
     */
    public int getMotorSayisi() {
        return motorSayisi;
    }

    /**
     * @param motorSayisi the motorSayisi to set
     */
    public void setMotorSayisi(int motorSayisi) {
        this.motorSayisi = motorSayisi;
    }

    /**
     * @return the yükMiktari
     */
    public int getYükMiktari() {
        return yükMiktari;
    }

    /**
     * @param yükMiktari the yükMiktari to set
     */
    public void setYükMiktari(int yükMiktari) {
        this.yükMiktari = yükMiktari;
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
    
                
         
}