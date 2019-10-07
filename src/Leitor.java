
import java.io.BufferedInputStream;
import java.io.DataInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomaz Marques
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
        DataInputStream data;
        
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
                    ocorrencias[c]++;  
                }   
            
            int a=0;
             for(int i=0; i<ocorrencias.length; i++){
                if (ocorrencias[i]>0){
                System.out.println(ocorrencias[i]+" "+((char)i)+" "+i);  
                lista[a]= new Caracters((char)i,ocorrencias[i]);
                 a++;}
                
            }
         
                  listandoCaracters(lista); 
        }
     
        catch (FileNotFoundException err){
            System.out.print(err.getMessage());
        }catch (IOException err){
            System.out.print(err.getMessage());
        }
    }
        
       public void listandoCaracters(Caracters[] vetor){
         
        //int e=0;
         //for(;vetor[e]!=null;e++);
          //e--;
          //System.out.println(e);
          //while(e>=0){
          //for(int a=0;a>0;a--){
          //if(vetor[e].ocorrencia>(vetor[e-1].ocorrencia)){
          //Caracters auxi;
          //auxi= new Caracters(lista[e-1]);
          //vetor[e-1]=vetor[e];
          //vetor[e]=auxi;
          //System.out.println(auxi+" ");
          //}
          //else
          //    e--;
          //System.out.println(Arrays.toString(vetor));
          //}}
         int index1, index2;
         Caracters aux;  
         for(index1 =0; vetor[index1]!=null; index1++){  
             for(index2 =0; vetor[index2] !=null; index2++){  
                if(vetor[index2].ocorrencia>(vetor[index2+1].ocorrencia)){  
                     aux = vetor[index2];  
                     vetor[index2] = vetor[index2+1];  
                     vetor[index2+1] = aux;  
                 }  
             }  
         }System.out.println(Arrays.toString(vetor));
         
          
        //System.out.println(Arrays.toString(vetor));
        }   
}
