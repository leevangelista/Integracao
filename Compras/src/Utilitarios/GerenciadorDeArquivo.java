/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 24825-4
 */
public class GerenciadorDeArquivo {
        
    
    public static void gravaEmArquivo(String arquivo, ArrayList<String> dados) 
            throws IOException {
        // criando o escritor do arquivo e fazendo a ligação com o arquivo
        FileWriter escritor = new FileWriter(arquivo, true);

        BufferedWriter buffer = new BufferedWriter(escritor);

        // o buffer irá fazer com que o escritor escreva essa entrada no arquivo em memória(RAM)
        for(String dado : dados) {
            buffer.append(dado+"\n");
        }

        // o buffer pega o arquivo em memória e grava no disco dispensando o objeto escritor e finalizando a tarefa do buffer
        buffer.close();
    }
    
    public static ArrayList<String> leituraDeDadosEmArquivo(String arquivo) 
            throws FileNotFoundException, IOException {
        File file = new File(arquivo);
        
        FileReader leitor = new FileReader(arquivo);      
        BufferedReader buffer = new BufferedReader(leitor);
        String registro = "";    
        ArrayList<String> dados = new ArrayList<String>();
        
        while(true) {
            registro = buffer.readLine();
            if (registro == null) {
                break;
            }
            dados.add(registro);
        }
        buffer.close();
        return dados;
    }
 
    public static ArrayList<String> leituraDeDadosEmArquivo(File arquivo) 
            throws FileNotFoundException, IOException {
        FileReader leitor = new FileReader(arquivo);      
        BufferedReader buffer = new BufferedReader(leitor);
        String registro = "";    
        ArrayList<String> dados = new ArrayList<String>();
        
        while(true) {
            registro = buffer.readLine();
            if (registro == null) {
                break;
            }
            dados.add(registro);
        }
        buffer.close();
        return dados;
    }
}
