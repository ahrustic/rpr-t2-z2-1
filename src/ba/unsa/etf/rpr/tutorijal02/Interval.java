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
        if(this.pocetnaTacka < i.pocetnaTacka) {
            novi.pocetnaTacka = i.pocetnaTacka;
            novi.pocetnaPripada = i.pocetnaPripada;
        }
            else {
                novi.pocetnaTacka = this.pocetnaTacka;
                novi.pocetnaPripada = this.pocetnaPripada;
            }
        if(this.krajnjaTacka < i.krajnjaTacka) {
            novi.krajnjaTacka = i.krajnjaTacka;
            novi.krajnjaPripada = i.krajnjaPripada;
        }
            else {
                novi.krajnjaTacka = this.krajnjaTacka;
                novi.krajnjaPripada = this.krajnjaPripada;
        }
        if ((this.pocetnaTacka > i.krajnjaTacka) || (i.pocetnaTacka > this.krajnjaTacka)) {
            Interval prazan = new Interval();
            return  prazan;
        }   
            
        return novi;    
    }
    
    
    public static Interval intersect(Interval i, Interval i2) {
        Interval novi = new Interval();
        if(i.pocetnaTacka < i2.pocetnaTacka) {
            novi.pocetnaTacka = i2.pocetnaTacka;
            novi.pocetnaPripada = i2.pocetnaPripada;
                }
        else {
            novi.pocetnaTacka = i.pocetnaTacka;
            novi.pocetnaPripada = i.pocetnaPripada;
        }
        if(i.krajnjaTacka < i2.krajnjaTacka) {
            novi.krajnjaTacka = i.krajnjaTacka;
            novi.krajnjaPripada = i.krajnjaPripada;
        }
        else {
            novi.krajnjaTacka = i2.krajnjaTacka;
            novi.krajnjaPripada = i2.krajnjaPripada;
        }
        if ((i.pocetnaTacka > i2.krajnjaTacka) || (i2.pocetnaTacka > i.krajnjaTacka)) {
            Interval prazan = new Interval();
            return  prazan;
        }
        return novi;

    }

    public boolean isIn(double v) {
        if (v>pocetnaTacka || (v == pocetnaTacka && pocetnaPripada == true) && (v<krajnjaTacka || (v == krajnjaTacka && krajnjaPripada == true))) return true;
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        Interval i =  (Interval) obj;
        if (i.pocetnaTacka == pocetnaTacka && i.krajnjaTacka == krajnjaTacka && pocetnaPripada == i.pocetnaPripada && krajnjaPripada == i.krajnjaPripada)   return  true;
        return false;
    }

    @Override
    public String toString() {
        if(this.pocetnaTacka==0 && this.krajnjaTacka==0 && this.pocetnaPripada==false && this.krajnjaPripada==false) return "()";

        String s = "";

        if(pocetnaPripada == true) s +="[";
        else if (pocetnaPripada == false) s += "(";

        s += this.pocetnaTacka + "," + this.krajnjaTacka;

        if(krajnjaPripada == true) s +="]";
        else if (krajnjaPripada == false) s += ")";

        return  s;
    }
}
