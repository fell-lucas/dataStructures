import java.util.Collection;
import java.util.Map;
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

  @Override
  public int size() {
    return nElements;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return false;
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
  public Estudante put(Integer key, Estudante value) {
    if(size() < values.length) {
      keys[nElements] = key;
      values[nElements] = value;
      nElements++;
    }
    return value;
  }

  @Override
  public Estudante remove(Object key) {
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
}