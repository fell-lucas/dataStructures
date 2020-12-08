import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class VetorOrdenado implements Map<Integer, Estudante> {
  private Integer[] keys;
  private Estudante[] values;
  private int nElements;

  public VetorOrdenado(int max) {
    keys = new Integer[max];
    values = new Estudante[max];
    nElements = 0;
  }

  public void sort(){
    Integer[] auxKeys= new Integer[keys.length];
    auxKeys = keys;
    int aux;
    for(int i=0; i<nElements; i++){
      for(int j=0; j<nElements-1; j++){
         if(auxKeys[j] > auxKeys[j+1]){
            aux = auxKeys[j];
            auxKeys[j] = auxKeys[j+1];
            auxKeys[j+1] = aux;
         }
      }
    }

    Estudante[] newValues = new Estudante[values.length];
    for(int i=0; i<nElements; i++){
      newValues[i]=get(auxKeys[i]);
    }

    this.keys = auxKeys;
    this.values = newValues;
  }

  public int countEngSoft(){
    int count=0;
    for(int i=0; i<nElements; i++){
      if(values[i].getCurso().equals("Engenharia de Software")){
        count++;
      }
    }
    return count;
  }

  @Override
  public int size() {
    return nElements;
  }

  @Override
  public boolean isEmpty() {
    return nElements == 0;
  }

  @Override
  public boolean containsKey(Object key) {
    for(int k : keys) {
      if(k == (int) key)
        return true;
    }
    return false;
  }

  @Override
  public boolean containsValue(Object value) {
    for(Estudante e : values) {
      if(e.compareTo((Estudante) value) == 0)
        return true;
    }
    return false;
  }

  public void printAll(){
    for(int i=0; i<nElements; i++){
      System.out.println("Chave: "+keys[i]+".  Valor: "+get(keys[i]));
    }
  }

  @Override
  public Estudante get(Object key) {
    for(Estudante e : values) {
      if((int) key == e.getMatricula())
        return e;
    }
    return null;
  }

  @Override
  public Estudante put(Integer key, Estudante value) {
    if(size() < values.length) {
      keys[nElements] = key;
      values[nElements] = value;
      nElements++;
      return value;
    }
    return null;
  }

  @Override
  public Estudante remove(Object key) {
    for(int i = 0; i < size(); i++) {
      if((int) key == values[i].getMatricula()) {
        Estudante e = values[i];
        values[i] = null;
        keys[i] = null;
        nElements--;
        return e;
      }
    }
    return null;
  }

  public void removeUntil(int key) {
    for(int i = 0; i < size(); i++) {
      if(values[i].getMatricula() > key)
        break;
      else {
        values[i] = null;
        keys[i] = null;
        nElements--;
      }
    }
    keys = Arrays.stream(keys).filter(Objects::nonNull).toArray(Integer[]::new);
    values = Arrays.stream(values).filter(Objects::nonNull).toArray(Estudante[]::new);
  }

  @Override
  public void putAll(Map<? extends Integer, ? extends Estudante> m) {
    // TODO Auto-generated method stub

  }

  @Override
  public void clear() {
    for(int i = 0; i < size(); i++) {
      values[i] = null;
      keys[i] = null;
      nElements--;
    }
  }

  @Override
  public Set<Integer> keySet() {
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < size(); i++) {
      set.add(keys[i]);
    }
    return set;
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
}