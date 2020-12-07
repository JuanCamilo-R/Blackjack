package comunes;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Carta extends JLabel implements Serializable{
    private String valor;
    private String palo;
    private BufferedImage imagen;
    public Carta(String valor, String palo) {
		this.valor = valor;
		this.palo = palo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}
	
	public String toString() {
		return valor+palo;
	}
	
	private Image scaledImage(Image img, int w, int h) {
		 BufferedImage resizedImage = new BufferedImage( w , h , BufferedImage.TYPE_INT_RGB);
		 //Se crea grafica 2d para renderizar y escalar la imagen.
		 Graphics2D g2 = resizedImage.createGraphics();
		 //Se renderiza y se dibuja.
		 g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		 g2.drawImage(img, 0, 0, w, h, null);
		 //Libero los recursos nativos a la grafica
		 g2.dispose();
		 return resizedImage;
	 }
	
	public void setImagen(BufferedImage imagen) {
		 this.imagen= (BufferedImage) scaledImage(imagen,100,50);
		 setIcon(new ImageIcon(scaledImage(imagen,80,110)));
	 }
}
