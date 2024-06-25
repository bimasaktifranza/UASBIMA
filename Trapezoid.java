import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Trapezoid {
    public static void main(String[] args) {
        String namaFile = "C:\\Users\\ASUS R5\\IdeaProjects\\UASPL\\src\\trapezoid.csv";
        List<Trapesium> tr = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] dipisahkan = line.split(",");
                Trapesium trape = new Trapesium(dipisahkan[0], dipisahkan[1], dipisahkan[2]);
                tr.add(trape);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        tr.sort(Comparator.comparing(Trapesium :: keliling));
        try(FileWriter fw = new FileWriter("C:\\Users\\ASUS R5\\IdeaProjects\\UASPL\\src\\BelumUrut.txt")) {
            for (Trapesium trr : tr) {
                double luas = trr.luas();
                double keliling = trr.keliling();
                System.out.println("luas Trapesium: " + luas);
                fw.write(trr.keliling() + "\n");
            }
            System.out.println("Keliling sudah ditulis");

        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}


