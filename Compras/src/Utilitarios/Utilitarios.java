/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Pedro
 */
public class Utilitarios {
    
    public static String formatarData(Calendar c) {
        
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(c.getTime());
    }
    
}
