import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {


  public static void main(String[] args) throws IOException {
    VetorOrdenado v = new VetorOrdenado(100000);
    
    long start = System.nanoTime();
    for(int i = 0; i < 100000; i++) {
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

    // v.printAll();

    BufferedWriter bw = new BufferedWriter(
      new FileWriter("data/adicionar.dat")
    );
    bw.append("1 Vetor "+addElapsed);
    bw.close();

    bw = new BufferedWriter(new FileWriter("data/printOrdenado.dat"));
    bw.append("1 Vetor "+sortAndPrint);
    bw.close();

    bw = new BufferedWriter(new FileWriter("data/countES.dat"));
    bw.append("1 Vetor "+countElapsed);
    bw.close();

    bw = new BufferedWriter(new FileWriter("data/remove.dat"));
    bw.append("1 Vetor "+removeElapsed);
    bw.close();

    Estudante eS = new Estudante();
    ListaDuplamente ld = new ListaDuplamente(eS.getMatricula(), eS);
    
    long startLd = System.nanoTime();
    for(int i = 0; i < 99999; i++) {
      Estudante e = new Estudante();
      ld.put(e.getMatricula(), e);
    }
    long addElapsedLd = System.nanoTime() - startLd;

    startLd = System.nanoTime();
    ld.sort();
    long sortElapsedLd = System.nanoTime() - startLd;

    startLd = System.nanoTime();
    ld.printAll();
    long printElapsedLd = System.nanoTime() - startLd;
    long sortAndPrintLd = sortElapsedLd + printElapsedLd;
    

    startLd = System.nanoTime();
    int countLd = ld.countEngSoft();
    long countElapsedLd = System.nanoTime() - startLd;
    System.out.println("Estudantes em Engenharia de Software: "+countLd);

    startLd = System.nanoTime();
    ld.removeUntil(202050000);
    long removeElapsedLd = System.nanoTime() - startLd;

    // ld.printAll();

    bw = new BufferedWriter(new FileWriter("data/adicionar.dat",true));
    bw.append("\n2 ListaEncadeada "+addElapsedLd);
    bw.close();

    bw = new BufferedWriter(new FileWriter("data/printOrdenado.dat",true));
    bw.append("\n2 ListaEncadeada "+sortAndPrintLd);
    bw.close();

    bw = new BufferedWriter(new FileWriter("data/countES.dat",true));
    bw.append("\n2 ListaEncadeada "+countElapsedLd);
    bw.close();

    bw = new BufferedWriter(new FileWriter("data/remove.dat",true));
    bw.append("\n2 ListaEncadeada "+removeElapsedLd);
    bw.close();
  }


}
