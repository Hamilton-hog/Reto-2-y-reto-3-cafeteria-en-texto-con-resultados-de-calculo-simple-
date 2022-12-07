import java.util.ArrayList;
import java.util.Scanner;
class Calcs {
    
    public ArrayList<String> Add(String x,ArrayList<String> ladd){
        String[] h=x.split(" ");
        String f=h[0];
        for (String cadena: ladd) {
            String[] c=cadena.split(" ");
            String d=c[0];
            if (f.equals(d)){
                ladd.add("ERROR");
                return ladd;
            }
        }  
        ladd.add(x);
         return ladd;
    }
    public ArrayList<String> Act(String x,ArrayList<String> lact){
        String[] h=x.split(" ");
        String f=h[0];
        for (String cadena: lact) {
            String[] c=cadena.split(" ");
            String d=c[0];
            if (f.equals(d)){
                int g= Integer.parseInt(d);
                lact.set((int)g-1, x);
                return lact;
            }
        }  
        lact.add("ERROR");
         return lact;
    }
    public ArrayList<String> Del(String x,ArrayList<String> ldel){
        String[] h=x.split(" ");
        String a1=h[0];
        String b1=h[1];
        double c1= Double.parseDouble(h[2]);
        String d1=h[3];
        String a2;
        String b2;
        double c2;
        String d2;
        for (String cadena: ldel) {
            String[] f=cadena.split(" ");
            a2=f[0];
            b2=f[1];
            c2=Double.parseDouble(f[2]);
            d2=f[3];
            if (a1.equals(a2) && b1.equals(b2) && c1==c2 && d1.equals(d2)){
                int n= Integer.parseInt(a2);
                ldel.remove((int)n-1);
                return ldel;
            }
        }  
        ldel.add("ERROR");
         return ldel;
    }
    public String Inf(ArrayList<String> linf){
        if (linf.contains("ERROR")){
            return "ERROR";
        }else{
            int con1=0;
            int con2=0;
            double f=0.0;
            double c;
            double w;
            double b=0.0;
            double h=9999999999.0;
            String d="";
            String al="";
            String ba="";
            for (String i: linf) {
                String[] a=i.split(" ");
                c=Double.parseDouble(a[2]);
                f=f+c;
                if (c>b){
                    b=c;
                }
                if (c<h){
                    h=c;
                }
            }
            for (String j: linf) {
                String[] g=j.split(" ");
                w=Double.parseDouble(g[2]);
                if (w==b && con1<1){
                    al=g[1];
                    con1=con1+1;
                }
                if (w==h && con2<1){
                    ba=g[1];
                    con2=con2+1;
                }
            }  
            f=Math.round((f/linf.size()) * 10.0) /10.0;
            String y= String.valueOf(f);
            d=al+" "+ba+" "+y;
            return d;
        }
    } 
}
class Reto3 {
    

    public static void main(String[] args) throws Exception {
        
        
        ArrayList<String> sdi = new ArrayList<String>();
        sdi.add("1 Manzanas 5000.0 25");
        sdi.add("2 Limones 2300.0 15");
        sdi.add("3 Peras 2700.0 33");
        sdi.add("4 Arandanos 9300.0 5");
        sdi.add("5 Tomates 2100.0 42");
        sdi.add("6 Fresas 4100.0 3");
        sdi.add("7 Helado 4500.0 41");
        sdi.add("8 Galletas 500.0 8");
        sdi.add("9 Chocolates 3500.0 80");
        sdi.add("10 Jamon 15000.0 10");
        Scanner sc = new Scanner(System.in);
        Calcs w = new Calcs();
        String Action = sc.nextLine();
        String mnl = sc.nextLine();
        if (Action.equals("ACTUALIZAR")){
            System.out.println(w.Inf(w.Act(mnl,sdi)));
        }else if(Action.equals("BORRAR")){
            System.out.println(w.Inf(w.Del(mnl,sdi)));
        }else if(Action.equals("AGREGAR")){
            System.out.println(w.Inf(w.Add(mnl,sdi)));
        }

        sc.close();

    }
}
