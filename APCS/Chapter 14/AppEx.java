import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppEx{
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setForeground(Color.WHITE);

		JButton button1 = new JButton("WAZAAAAAA");
		button1.setForeground(Color.BLACK);
		button1.addActionListener(new MessageListener());

		JButton button2 = new JButton("JAJAJA");
		button2.setForeground(Color.BLACK);


		frame.add(button1);
		frame.add(button2);
		frame.setLayout(new FlowLayout());
		frame.pack();





	}
}

class MessageListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
		JOptionPane.showMessageDialog(null, "You pressed the button my nigga");
	}

}