//Vinicius Roriz Meireles Silva 20/10/2020

package principal;

import javax.swing.*;

import com.formdev.flatlaf.FlatIntelliJLaf;
import interface_grafica.MenuPrincipal;

public class Principal {
	public static void main(String[] args) {
		FlatIntelliJLaf.install();
		JFrame frame = new MenuPrincipal();
		frame.setVisible(true);
	}

}
