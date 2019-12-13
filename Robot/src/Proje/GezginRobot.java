/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proje;

public abstract class GezginRobot extends Robot{
        private int hiz;

    public GezginRobot() {
    }
        
        public GezginRobot(int motorSayisi,int yükMiktari,String robotTipi,int hiz)
        {
            super(motorSayisi,yükMiktari,robotTipi);
            this.hiz=hiz;
        }
        public abstract double EngelGecmeSuresiBul();
    /**
     * @return the hiz
     */
    public int getHiz() {
        return hiz;
    }

    /**
     * @param hiz the hiz to set
     */
    public void setHiz(int hiz) {
        this.hiz = hiz;
    }
        
}