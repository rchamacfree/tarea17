
package rcmt17;

import java.util.ArrayList;
import java.util.Objects;


public class Libro {
   public String ISBN;
   public String nombre;
   public String precio;
   public ArrayList <String> autores;
    
    
    Libro (String i, String n, String p, ArrayList a){
        this.ISBN = i;
        this.nombre = n;
        this.precio = p;
        this.autores = a;
               
    }
    
      
    @Override
    public String toString(){
        String r = String.format("%s%nISBN: %s%nPrecio: %s€ %nAurores:", this.nombre,this.ISBN,this.precio);
       //r = r.concat(this.aut ores.toString());
       
        for (String x: this.autores) r += x;
        
        return r;
    }

    
   

    
 
    
}
