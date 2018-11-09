package miniproject;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Restaurant_Main extends JFrame {
	Restaurant_Menu rMenu;
	
	public Restaurant_Main() {
		rMenu = new Restaurant_Menu();
		
		this.setTitle("Dobby"); // 프레임 타이틀
		
		//프레임에 붙임
		this.add(BorderLayout.CENTER, rMenu);
		
		this.setSize(900, 800);
		this.setVisible(true);
		setResizable(true); // 크기조절 가능
		//setResizable(false); //크기 조절 불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Restaurant_Main();

	}

}
