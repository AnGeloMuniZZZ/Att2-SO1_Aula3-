package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}

	private String OS() {
		return System.getProperty("os.name");
	}

	public void ListaProcessos() {
		Process p;
		try {
			if (this.OS().contains("Windows")) {
				p = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream dados = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(dados);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
			} else {
				p = Runtime.getRuntime().exec("ps -ef");
				InputStream dados = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(dados);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mataPid(int PID) {
		try {
			if (this.OS().contains("Windows")) {
				Runtime.getRuntime().exec("TASKKILL /PID" + " " + PID);
			} else {
				Runtime.getRuntime().exec("kill -9" + " " + PID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void mataNome(String nome) {
		try {
			if (this.OS().contains("Windows")) {
				Runtime.getRuntime().exec("TASKKILL /IM" + " " + nome);
			} else {
				Runtime.getRuntime().exec("pkill -f" + " " + nome);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
