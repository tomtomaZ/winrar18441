
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
   
     public class Caracters{
     public char letra;
     public  int ocorrencia;
     public Caracters( char letra, int ocorrencia){
     this.letra= letra;
     this.ocorrencia= ocorrencia; 
      }      
      public Caracters(Caracters exemplo)
      {
      this.letra=exemplo.letra;
      this.ocorrencia=exemplo.ocorrencia;
      }
     public int getOcorrencia(){
     return this.ocorrencia;
     }     
     public char getLetra(){
     return this.letra;
     }  
     public void setCaracters(Caracters exemplo)
     {
     if(exemplo.letra!=0)
      this.letra=exemplo.letra;
     if(exemplo.ocorrencia!=0)
      this.ocorrencia=exemplo.ocorrencia;
    
     }
     public int compareTo(Caracters comp){
     if(this.ocorrencia>comp.ocorrencia)
         return 1;
     else if(this.ocorrencia<comp.ocorrencia)    
     return -1;
     
     return 0;
     }
     public boolean ocorrenciaMaior(int ocorrencia){
     if(this.ocorrencia>ocorrencia)//=?
        return true;
        else 
         return false;
     }
     @Override
     public String toString(){
     return this.letra+": "+this.ocorrencia;
     }
     } 
      Caracters[] lista = new Caracters[1000];
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

              Caracters[] lista1= new Caracters[1000];
            for (char c : new String(vetByte).toCharArray())
                {
                    System.out.println(c);
                    ocorrencias[c]++; // conta ocorrencia
                }
            
            int a=0;
             for(int i=0; i<ocorrencias.length; i++){
                if (ocorrencias[i]>0){
                System.out.println(ocorrencias[i]+" "+((char)i)+" "+i);  
                lista1[a]= new Caracters((char)i,ocorrencias[i]);
                 a++;}
                
            }
             
            List<Caracters> lista;
            lista = new ArrayList<>();
            for(int e=0; e<lista1.length;e++){
            if(lista1[e]!=null)
                lista.add(lista1[e]);
            }
            
            ComparadorCarac comp = new ComparadorCarac();
            
            Collections.sort(lista, comp);
            System.out.println(lista);
           // for(Caracters i: lista){
             //   System.out.println(i);
            //}
        }catch (FileNotFoundException err){
            System.out.print(err.getMessage());
        }catch (IOException err){
            System.out.print(err.getMessage());
        }
    }
     public class ComparadorCarac implements Comparator<Caracters> {
    
    @Override
    public int compare(Caracters letra1, Caracters letra2) {
    
      return letra1.compareTo(letra2);

  }
  
}
     
}

