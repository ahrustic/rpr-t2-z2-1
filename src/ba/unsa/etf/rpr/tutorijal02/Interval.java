package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double pocetnaTacka, krajnjaTacka;
    boolean pocetnaPripada, krajnjaPripada;

    public Interval(double v, double v1, boolean b, boolean b1) {
        pocetnaTacka = v;
        krajnjaTacka = v1;
        pocetnaPripada = b;
        krajnjaPripada = b1;
        if (v>v1) throw (new IllegalArgumentException());
    }

    public Interval()  { 
        pocetnaTacka = 0;
        krajnjaTacka = 0;
        pocetnaPripada = false;
        krajnjaPripada = false;
        
    }

    public boolean isNull() {
        if(pocetnaTacka == 0 && krajnjaTacka == 0 && pocetnaPripada == false && krajnjaPripada ==false) return true;
        return false;
        
    }

    public Interval intersect(Interval i) {
        Interval novi = new Interval();
        if(this.pocetnaTacka < i.pocetnaTacka) novi.pocetnaTacka = i.pocetnaTacka;
            else novi.pocetnaTacka = this.pocetnaTacka;
        if(this.krajnjaTacka < i.krajnjaTacka) novi.krajnjaTacka = novi.krajnjaTacka;
            else novi.krajnjaTacka = i.krajnjaTacka;
        if ((this.pocetnaTacka > i.krajnjaTacka) || (i.pocetnaTacka > this.krajnjaTacka)) {
            Interval prazan = new Interval();
            return  prazan;
        }   
            
        return novi;    
    }
    
    
    public static Interval intersect(Interval i, Interval i2) {
        Interval novi = new Interval();
        if(i.pocetnaTacka < i2.pocetnaTacka) novi.pocetnaTacka = i2.pocetnaTacka;
        else novi.pocetnaTacka = i.pocetnaTacka;
        if(i.krajnjaTacka < i2.krajnjaTacka) novi.krajnjaTacka = i.krajnjaTacka;
        else novi.krajnjaTacka = i2.krajnjaTacka;
        if ((i.pocetnaTacka > i2.krajnjaTacka) || (i2.pocetnaTacka > i.krajnjaTacka)) {
            Interval prazan = new Interval();
            return  prazan;
        }
        return novi;

    }

    public boolean isIn(double v) {
        if (v>pocetnaTacka && v<krajnjaTacka) return true;
        return false;
    }
    
    
    
}
