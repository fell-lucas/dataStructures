public class DoubleNode {
  private int matricula;
  private Estudante estud;
  private DoubleNode prox;
  private DoubleNode prev;
 
  public DoubleNode (int mat, Estudante est) {
    this.matricula = mat;
    this.estud= est;
    this.prox = null;
  }

  public DoubleNode (int mat, Estudante est, DoubleNode prox) {
    this.matricula = mat;
    this.estud= est;
    this.prox = prox;
  }
  
  public void setMat(int mat){
    this.matricula = mat;
  }

  public void setEst(Estudante est){
    this.estud = est;
  }

  public int getMat() {
    return this.matricula;
  }

  public Estudante getEstud() {
    return this.estud;
  }
 
  public DoubleNode getProx() {
    return this.prox;
  }
  public void setProx(DoubleNode n) {
    this.prox = n;
  }
  public DoubleNode getPrev() {
    return this.prev;
  }
  public void setPrev(DoubleNode n) {
    this.prev = n;
  }
 }
 

