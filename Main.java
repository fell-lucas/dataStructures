import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    VetorOrdenado v = new VetorOrdenado(100);
    
    long start = System.nanoTime();
    for(int i = 0; i < 100; i++) {
      Estudante e = new Estudante();
      v.put(e.getMatricula(), e);
    }
    long addElapsed = System.nanoTime() - start;

    start = System.nanoTime();
    v.sort();
    long sortElapsed = System.nanoTime() - start;

    start = System.nanoTime();
    v.printAll();
    long printElapsed = System.nanoTime() - start;
    long sortAndPrint = sortElapsed + printElapsed;
    

    start = System.nanoTime();
    int count = v.countEngSoft();
    long countElapsed = System.nanoTime() - start;
    System.out.println("Estudantes em Engenharia de Software: "+count);

    start = System.nanoTime();
    v.removeUntil(202050000);
    long removeElapsed = System.nanoTime() - start;

    v.printAll();

    BufferedWriter bw = new BufferedWriter(new FileWriter("data/adicionar.dat"));
    bw.write("");
    bw.append("1 Vetor "+addElapsed);
    bw.close();

    bw = new BufferedWriter(new FileWriter("data/printOrdenado.dat"));
    bw.write("");
    bw.append("1 Vetor "+sortAndPrint);
    bw.close();

    bw = new BufferedWriter(new FileWriter("data/countES.dat"));
    bw.write("");
    bw.append("1 Vetor "+countElapsed);
    bw.close();

    bw = new BufferedWriter(new FileWriter("data/remove.dat"));
    bw.write("");
    bw.append("1 Vetor "+removeElapsed);
    bw.close();

  }
}
