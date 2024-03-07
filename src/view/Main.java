package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {

		KillController kill = new KillController();
		kill.ListaProcessos();
		String i = JOptionPane.showInputDialog(null, "1- Mata com PID\n 2- Mata com Nome", JOptionPane.PLAIN_MESSAGE);
		switch (Integer.parseInt(i)) {
		case 1: {
			kill.mataPid(Integer.parseInt(JOptionPane.showInputDialog("Coloque o número do PID")));
			break;
		}
		case 2:{
			kill.mataNome(JOptionPane.showInputDialog("Coloque o nome do processo"));
			break;
		}
		default:
			break;
		}
		
	}

}
