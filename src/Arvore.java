
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
public class Arvore {
public class No {
    
    private int ocorrencia;
    private char letra;
    private No Dir;
    private No Esq;
   
    public No( int ocorrencia ){
        
                //this.letra= null;
		this.ocorrencia = ocorrencia;
	}
    public No(char letra, int ocorrencia, No esq, No dir){
     this.letra=letra;
     this.ocorrencia=ocorrencia;
     this.Esq=esq;
     this.Dir=dir;
    }
    public No( char letra, int ocorrencia){
     this.letra= letra;
     this.ocorrencia= ocorrencia; 
      }   
    public int somaOcorrencia(No a){
    int result = this.ocorrencia+a.getOcorrencia();
    return result;
    }
    public int getOcorrencia(){
     return this.ocorrencia;
    }     
     public char getLetra(){
     return this.letra;
     }  
    public void setOcorrencia(int ocorrencia) {
            this.ocorrencia = ocorrencia;
    }
     public void setCaracters(No exemplo)
     {
     if(exemplo.letra!=0)
      this.letra=exemplo.letra;
     if(exemplo.ocorrencia!=0)
      this.ocorrencia=exemplo.ocorrencia;
    
     }
    public void setDir(No D){
       Dir= D;
	}
    public No getDir(){
		return Dir;
	}
    public void setEsq(No E){
		Esq = E;
	}
    public No getEsq(){
	    return Esq;
	} 
    public int compareTo(No comp){
     if(this.ocorrencia>comp.ocorrencia)
         return 1;
     else if(this.ocorrencia<comp.ocorrencia)    
     return -1;
     
     return 0;
     }

    public String toString(){
        return this.getLetra()+": "+this.getOcorrencia();
    }
} 
    public static class ComparadorCarac implements Comparator<No> {
    
    @Override
    public int compare(No letra1, No letra2) {
      return letra1.compareTo(letra2);
  }
}
    protected No Raiz;

    public Arvore(){
         Raiz=null;
    }
    /*public  void incluir(No Novo){
        incluir(new No(Novo));
    }
    public  void incluir(No Novo){
        if (Novo==null) return;
        
        if (Raiz==null) Raiz = Novo;
        else
            incluir(Novo);
    }
    private  void incluir(No Raiz, No Novo){

        if (Raiz==null)
	    Raiz = Novo;
        else
            if (Novo.getInfo().compareTo(Raiz.getInfo())>0){ // Direita
                    if (Raiz.getDir()==null)
                            Raiz.setDir(Novo);
                    else
                            incluir(Raiz.getDir(),Novo);
            }else // Esquerda
               if (Raiz.getEsq()==null)
                       Raiz.setEsq(Novo);
               else
                       incluir (Raiz.getEsq(), Novo);
    }

    public void remover(No Info){
        No aRemover = this.Raiz;
        No paiDele = null;
        boolean filhoDaEsquerda = true;
        
        // Encontrar o No com a Info do parametro e guardar quem é o PAI Dele
         while(!aRemover.getLetra().equals(Info) ){
                paiDele = aRemover;
                if(Info.compareTo(aRemover.getInfo())<0){
                    filhoDaEsquerda = true;
                    aRemover = aRemover.getEsq();
                }
                else{
                    filhoDaEsquerda = false;
                    aRemover = aRemover.getDir();
                }
                if(aRemover == null)
                    return;  // não está na arvore, já esta removido
         
          // Vamos excluir
          if(aRemover.getEsq()==null && aRemover.getDir()==null){  // FOLHA
             acertaNos(aRemover, paiDele, filhoDaEsquerda, null);
          }
          else if(aRemover.getDir()==null) // Não tem elementos pra DIREITA
            acertaNos(aRemover, paiDele, filhoDaEsquerda, aRemover.getEsq());
        
          else if(aRemover.getEsq()==null) // Não tem elementos pra ESQUERDA
            acertaNos(aRemover, paiDele, filhoDaEsquerda, aRemover.getDir());

          else{  // Tem subarvore pros dois lados
                No successor = getSuccessor(aRemover);
                acertaNos(aRemover, paiDele, filhoDaEsquerda, successor);
                successor.setEsq(aRemover.getEsq());
          }
    }
          */    

    
    private void acertaNos(No aRemover, No paiDele, boolean filhoDaEsquerda,
                      No SubArvore){
            if(aRemover == this.Raiz)
                  this.Raiz = SubArvore;
              else if(filhoDaEsquerda)
                  paiDele.setEsq(SubArvore);
              else
                  paiDele.setDir(SubArvore);
    }
    private No getSuccessor(No NoARemover){
                No pai = NoARemover;
		No successor = NoARemover;
		No atual = NoARemover.getDir();

		while(atual != null){
                        pai = successor;
			successor = atual;
			atual = atual.getEsq();
		}
                
                
                
		if(successor != NoARemover.getDir()){
			pai.setEsq(successor.getDir());
		 	successor.setDir(NoARemover.getDir());
		}
		return successor;
    }
  
    public String toString(){
       return  escreveArvore(Raiz);
    }
    
    private String escreveArvore(No Raiz){
	if (Raiz == null) return "";

	return escreveArvore(Raiz.getEsq()) + 
	       //" " + Raiz.getInfo() + " " + 
	       escreveArvore(Raiz.getDir());
    }
    
    public int qtosNos(){
        return qtNos(this.Raiz);
    }
    public int qtasFolhas(){
        return qtFolhas(this.Raiz);
    }
    
    private int qtNos(No RaizTemporaria){
         if (RaizTemporaria==null) return 0;
         return 1 + qtNos(RaizTemporaria.getDir()) +
                    qtNos(RaizTemporaria.getEsq());
    
    }
    private int qtFolhas(No RaizTemporaria){
         if (RaizTemporaria==null) return 0;
         
         if ( (RaizTemporaria.getDir()==null) &&
              (RaizTemporaria.getEsq()==null))  // Folha
             return 1;
         
         return qtFolhas(RaizTemporaria.getDir()) + 
                 qtFolhas(RaizTemporaria.getEsq());
    }
    
    public boolean equals(Arvore A){
      if (A==null) return false;
      return eq(A.Raiz, this.Raiz);
    }
    
    private boolean eq(No A, No B){
        if ((A==null) && (B==null)) return true;
        if ((A==null) || (B==null)) return false;
        
        return (eq(A.getDir(), B.getDir())  &&
                eq(A.getEsq(), B.getEsq()));
    }
    
    public boolean EhExtritamenteBinaria(){
        return Extritamente(this.Raiz);
    }
    private boolean Extritamente(No Raiz){
        if (Raiz==null) return false;
        
        if ((Raiz.getDir()==null) &&
            (Raiz.getEsq()==null)) // folha
            return true;
        
        if ((Raiz.getDir()==null) ||
            (Raiz.getEsq()==null)) 
            return false;
        
        return Extritamente(Raiz.getDir()) &&
               Extritamente(Raiz.getEsq());
    }
    
    public int getAltura(){
        return altura(this.Raiz);
        
    }
    private int altura(No Raiz){
        if (Raiz==null) return 0;
        
        if ((Raiz.getDir()==null) && 
            (Raiz.getEsq()==null)) return 0;
                
        return 1 + maior(altura(Raiz.getDir()), 
                          altura(Raiz.getEsq()));
    }
    private int maior(int a, int b){
        if (a>b) return a;
        return b;
    }

    public void geraArvore(List<No> lista){
    
        while (lista.size()!=1){
            No dir = lista.get(0);
            No esq = lista.get(1);
            No novo = new No('#',dir.somaOcorrencia(esq));
            novo.setDir(dir);
            novo.setEsq(esq);
            
            lista.remove(1);
            lista.remove(0);
            lista.add(novo);  
            System.out.println(lista);

        }
        Raiz= lista.get(0);
        System.out.println(Raiz);


}
}



