
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author u18441
 */
public class Leitor {
   
      Arvore arvore = new Arvore();     
      Arvore.No[] lista1 = new Arvore.No[1000];
     public  void lerArquivo(String NomeArquivo) throws IOException{
        FileInputStream     arquivoFisico;
        BufferedInputStream buffReader;
        DataInputStream     data;
    
        try {
            arquivoFisico = new FileInputStream(NomeArquivo);
            buffReader = new BufferedInputStream(arquivoFisico);
            data = new DataInputStream(buffReader);
            
            byte vetByte[];
            vetByte = new byte[arquivoFisico.available()];
            int[] ocorrencias = new int[10000];

            data.read(vetByte);  // dados do arquivo

              
            for (char c : new String(vetByte).toCharArray())
                {
                   
                    ocorrencias[c]++; // conta ocorrencia
                }
            
            int a=0;
             for(int i=0; i<ocorrencias.length; i++){
                if (ocorrencias[i]>0){
                System.out.println(ocorrencias[i]+" "+((char)i)+" "+i);  
                lista1[a]= arvore. new No((char)i,ocorrencias[i]);
                 a++;}
                
            }
             
            List<Arvore.No> lista;
            lista = new ArrayList<>();
            for(int e=0; e<lista1.length;e++){
            if(lista1[e]!=null)
                lista.add(lista1[e]);
            }
            
            Arvore.ComparadorCarac comp = new Arvore.ComparadorCarac();
            
            Collections.sort(lista, comp);
            System.out.println(lista);
            arvore.geraArvore(lista);
           // for(Caracters i: lista){
             //   System.out.println(i);
            //}
        }catch (FileNotFoundException err){
            System.out.print(err.getMessage());
        }catch (IOException err){
            System.out.print(err.getMessage());
        }
    }
    
        
    }
  

     
     


