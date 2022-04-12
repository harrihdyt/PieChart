import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

public class Main extends JPanel {
//    mendefinisikan field untuk menyimpan data
    String[] nilaiUjian = {"A", "B", "C", "D", "E"};
    int[] jumlahMahasiswa = {3, 10,23, 5, 2};
    Color [] warna = {Color.blue, Color.orange, Color.yellow, Color.green, Color.red};

//    Gunakan anti alias, agar hasil bagus
   @Override
    public void paintComponent (Graphics g){
       super.paintComponent(g);
       Graphics2D g2 = (Graphics2D) g;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       Shape bg = new Rectangle2D.Float(10, 10, 250, 200);
       g2 .setColor(Color.white);
       g2.fill(bg);
       g2.setColor(Color.black);
       g2.draw(bg);

       float total = 0.0f;
       for (int k = 0; k< jumlahMahasiswa.length; k++){
           total += jumlahMahasiswa[k];
       }

       float sudut, awal = 90;
       float lx = 20, ly = 70, lw = 10, lh = 10;
       for (int k = 0; k < jumlahMahasiswa.length; k++){
           sudut = 360.0f * jumlahMahasiswa[k] / total;
           Shape sektor = new Arc2D.Float(30, 30, 150, 150, awal, sudut, Arc2D.PIE);
           g2.setColor(warna[k]);
           g2.fill(sektor);
           awal += sudut;
           g2.fill(new Rectangle2D.Float(lx, ly, lw, lh));
           g2.setColor(Color.BLACK);
           g2.drawString(nilaiUjian[k], lx + lw + 5, ly + lh);
           ly += (lh+5);
       }

       g2.setColor(Color.darkGray);
       g2.drawString("Powered by Harri Hidayat", 15, 25);
   }

   public static void main(String[] args){
       JFrame f = new JFrame("PIE CHART");
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Main canvas = new Main();
       f.getContentPane().add(canvas);
       f.setSize(320, 320);
       f.setVisible(true);
   }
}
