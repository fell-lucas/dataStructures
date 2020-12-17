import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ListaDuplamente 
implements Map<Integer, Estudante> {
  private DoubleNode firstNode = null;
  private DoubleNode lastNode = null;
  private DoubleNode actualNode = null;

  public ListaDuplamente(int mat, Estudante est) {
    this.firstNode = new DoubleNode(mat, est);
    this.lastNode = this.firstNode;
  }

  public void printAll(){
    this.actualNode = this.firstNode;
      while(this.actualNode!=null){
        System.out.println("Chave: "+actualNode.getMat()+"  Valor: "+actualNode.getEstud());
        this.actualNode=this.actualNode.getProx();
    }
  }

  public void removeUntil(int key) {
    DoubleNode i = this.firstNode;
    while (i != null) {
      if(i.getMat() > key)
        break;
      else{
        if(i==this.firstNode){
          this.firstNode=i.getProx();
        }else{
          i.getPrev().setProx(i.getProx());
        }
        
      }
      i = i.getProx();
    }
  }

  public int countEngSoft() {
    DoubleNode i = this.firstNode;
    int count = 0;
    while (i != null) {
      if (i.getEstud().getCurso().equals("Engenharia de Software")) {
        count++;
      }
      i = i.getProx();
    }
    return count;
  }

  public void sort() {
    DoubleNode i = this.firstNode;
    DoubleNode j;
    int aux;
    Estudante aux2;
    while (i != null) {
      j = this.firstNode;
      while (j != this.lastNode) {
        if (j.getMat() > j.getProx().getMat()) {
          aux = j.getMat();
          aux2 = j.getEstud();
          j.setMat(j.getProx().getMat());
          j.setEst(j.getProx().getEstud());
          j.getProx().setMat(aux);
          j.getProx().setEst(aux2);
        }
        j = j.getProx();
      }
      i = i.getProx();
    }
  }

  @Override
  public Estudante put(Integer key, Estudante value) {
    DoubleNode novo = new DoubleNode(key, value, null);
    novo.setPrev(this.lastNode);
    this.lastNode.setProx(novo);
    this.lastNode = novo;
    return novo.getEstud();
  }

  @Override
  public Estudante remove(Object key) {
    DoubleNode i = this.firstNode;
    while (i != null) {
      if (i.getMat()==(int)key) {
        i.getPrev().setProx(i.getProx());
        return i.getEstud();
      }
    }
    return i.getEstud();
  }

  @Override
  public int size() {
    int cont=0;
    DoubleNode i = this.firstNode;
    while (i != null) {
      cont++;
    }
    return cont;
  }

  @Override
  public boolean isEmpty() {
    return this.firstNode==null;
  }

  @Override
  public boolean containsKey(Object key) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean containsValue(Object value) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Estudante get(Object key) {
    // TODO Auto-generated method stub
    return null;
  }


  @Override
  public void putAll(Map<? extends Integer, ? extends Estudante> m) {
    // TODO Auto-generated method stub

  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub

  }

  @Override
  public Set<Integer> keySet() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Collection<Estudante> values() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Set<Entry<Integer, Estudante>> entrySet() {
    // TODO Auto-generated method stub
    return null;
  }
  // public void selectionSort(){
  // DoubleNode aux1, aux2, menor;
  // int auxInfo;
  // aux1 = this.firstNode;
  // while(aux1 != null){
  // menor = aux1;
  // aux2 = aux1.getProx();
  // while(aux2!=null){
  // if(menor.getInfo() > aux2.getInfo())
  // menor = aux2;
  // aux2 = aux2.getProx();
  // }
  // auxInfo = aux1.getInfo();
  // aux1.setInfo(menor.getInfo());
  // menor.setInfo(auxInfo);
//         aux1 = aux1.getProx();
//     }
// }
//   public void sort(){
//     DoubleNode i = this.firstNode;
// 		DoubleNode j;
// 		int aux;
// 		if(this.firstNode!=null){
// 			i = this.firstNode.getProx();
// 			while(i!=null){
// 				j = i;
// 				while(j != this.firstNode){
// 					if(j.getInfo() < j.getPrev().getInfo()){
// 						aux = j.getInfo();
// 						j.setInfo(j.getPrev().getInfo());
// 						j.getPrev().setInfo(aux);
// 					}
// 					j = j.getPrev();
// 				}
// 				i = i.getProx();
// 			}
// 		}
//   }
}
