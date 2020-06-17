import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;


public class Main  {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Path to image");
		String path = sc.nextLine();
		BufferedImage img =  ImageIO.read(new FileInputStream(path));
		System.out.println("Enter X coord");
		int	coordX = sc.nextInt();
		System.out.println("Enter Y coord");
		int coordY = sc.nextInt();
		Color col = new Color(img.getRGB(coordX,coordY));
		System.out.println(col.getRed()+" "+col.getGreen()+" "+col.getBlue());
	}
}
