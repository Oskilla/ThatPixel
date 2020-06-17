import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Main  {
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		JFrame fen = new JFrame();
		fen.setTitle("That Pixel");
		fen.setSize(800, 150);
		fen.setLocationRelativeTo(null);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pan = new JPanel();
		JLabel lab1 = new JLabel("Path :");
		pan.add(lab1);
		JTextField jt1 = new JTextField(70);
		pan.add(jt1);
		JLabel lab2 = new JLabel("Coord X :");
		pan.add(lab2);
		JTextField jt2 = new JTextField(10);
		pan.add(jt2);
		JLabel lab3 = new JLabel("Coord Y :");
		pan.add(lab3);
		JTextField jt3 = new JTextField(10);
		pan.add(jt3);
		JButton bouton = new JButton("Get that pixel");
		bouton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String path = jt1.getText();
				int coordX = Integer.parseInt(jt2.getText());
				int coordY = Integer.parseInt(jt3.getText());
				BufferedImage img;
				try {
					img = ImageIO.read(new FileInputStream(path));
					Color col = new Color(img.getRGB(coordX,coordY));
					String o = col.getRed()+" "+col.getGreen()+" "+col.getBlue();
					JLabel lab4 = new JLabel(o);
					pan.add(lab4);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		pan.add(bouton);
		fen.setContentPane(pan);
		fen.setVisible(true);

	}
}
