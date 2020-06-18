import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Main implements ActionListener {
	static File f = null;
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action.equals(("Select file"))) {
			JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory(new File(System.getProperty("user.home")+ System.getProperty("file.separator")+ "Pictures"));
			fc.setMultiSelectionEnabled(false);
			fc.addChoosableFileFilter(new FilterExtended());
			int res = fc.showOpenDialog(null);
			if (res == JFileChooser.CANCEL_OPTION) { return;}				
			f = fc.getSelectedFile();
		}else if (action.equals("Get that pixel")){
			
		}
	}
	Main(){
	}
	public static void main(String[] args) throws IOException {
		JFrame fen = new JFrame();
		fen.setTitle("That Pixel");
		fen.setSize(500, 150);
		fen.setLocationRelativeTo(null);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pan = new JPanel();
		JLabel lab1 = new JLabel("Path :");
		pan.add(lab1);
		JButton bouton1 = new JButton("Select file");
		Main fc = new Main();
		bouton1.addActionListener(fc);
		pan.add(bouton1);
		JLabel lab2 = new JLabel("Coord X :");
		pan.add(lab2);
		JTextField jt2 = new JTextField(10);
		pan.add(jt2);
		JLabel lab3 = new JLabel("Coord Y :");
		pan.add(lab3);
		JTextField jt3 = new JTextField(10);
		pan.add(jt3);
		JButton bouton2 = new JButton("Get that pixel");
		bouton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String path = f.getAbsolutePath();
				int coordX = Integer.parseInt(jt2.getText());
				int coordY = Integer.parseInt(jt3.getText());
				BufferedImage img;
				try {
					img = ImageIO.read(new FileInputStream(path));
					Color col = new Color(img.getRGB(coordX,coordY));
					String o = col.getRed()+" "+col.getGreen()+" "+col.getBlue();
					JLabel lab4 = new JLabel(o);
					pan.add(lab4);
					fen.setVisible(true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		pan.add(bouton2);
		fen.setContentPane(pan);
		fen.setVisible(true);

	}
}
