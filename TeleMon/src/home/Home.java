package home;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;


public class Home extends JFrame implements ActionListener{

	public static final String search = "search";
	public static final String library = "library";
	public static final String polock = "polock";
	public static final String save = "save";

		public void OpenHome() {
			this.setTitle("Home");
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setSize(480,620);
			this.setLocationRelativeTo(null);
			this.setResizable(false);

			JLayeredPane pane = new JLayeredPane();
			HomeLayout HL = new HomeLayout();
			HL.setBounds(0,0,480,620);

			Container contentPane = getContentPane();

			JButton btn1 = new JButton("search");
			JButton btn2 = new JButton("library");
			JButton btn3 = new JButton("polock");
			JButton btn4 = new JButton("save");

			btn1.setActionCommand(search);
			btn1.addActionListener(this);
			btn2.setActionCommand(library);
            btn2.addActionListener(this);
            btn3.setActionCommand(polock);
            btn3.addActionListener(this);
            btn4.setActionCommand(save);
            btn4.addActionListener(this);


			btn1.setBounds(60,570,80,20);
			btn2.setBounds(150,570,80,20);
			btn3.setBounds(240,570,80,20);
			btn4.setBounds(330,570,80,20);

			pane.add(btn1);
			pane.add(btn2);
			pane.add(btn3);
			pane.add(btn4);
			pane.setLayer(btn1, 50);
			pane.setLayer(btn2, 51);
			pane.setLayer(btn3, 52);
			pane.setLayer(btn4, 53);
			pane.add(HL);
			pane.setLayer(HL, 42);
			contentPane.add(pane);

}


public void actionPerformed(ActionEvent event){

	String cmd = event.getActionCommand();

	if(cmd.equals(search)) {
System.out.println("press bottun");
int random = (int)(Math.random()*2);//モンスターの数4ひき
switch(random) {

case 0:
	JOptionPane.showMessageDialog(null, "モンスターが出現中！！");
	main.Main.OpenE();
break;

case 1:
	main.Main.OpenE();
break;}
}
	else if(cmd.equals(library)) {
		System.out.println("press bottun");
		main.Main.OpenL();}
	else if(cmd.equals(polock)) {
		JOptionPane.showMessageDialog(null, "polock");
		}
	else if(cmd.equals(save)) {
		JOptionPane.showMessageDialog(null, "セーブ中、、、");
		}
}
}

