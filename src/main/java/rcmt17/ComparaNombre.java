/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rcmt17;

import java.util.Comparator;

/**
 *
 * @author rchamac
 */
public class ComparaNombre implements Comparator {
    public int compare(Object o1, Object o2){
        Libro l1 = (Libro) o1;
        Libro l2 = (Libro) o2;
        return l1.nombre.compareToIgnoreCase(l2.nombre);
    }
}
