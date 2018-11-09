package miniproject;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Dobby_Main extends JFrame implements ActionListener {
	Dobby_Menu dMenu;
	
	public Dobby_Main() {
		dMenu = new Dobby_Menu();
		
		this.setTitle("Dobby"); // 프레임 타이틀
		
		//프레임에 붙임
		this.add(BorderLayout.CENTER, dMenu);
		this.setSize(900, 600);
		this.setVisible(true);
		setResizable(false); //크기 조절 불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//버튼 이벤트 리스너 연결
	    dMenu.chikenB.addActionListener(this);
	    dMenu.soyChikenB.addActionListener(this);
	    dMenu.yangChikenB.addActionListener(this);
	    dMenu.cokeB.addActionListener(this);
	    dMenu.ciderB.addActionListener(this);
	    dMenu.plusB.addActionListener(this); 
	    dMenu.minusB.addActionListener(this);
	    dMenu.registerB.addActionListener(this);
	    dMenu.removeB.addActionListener(this);
	    dMenu.decideB.addActionListener(this);
	} // end Dobby_Main()
	
	public static void main(String[] args) {
		new Dobby_Main();

	} // end main()
	
	@Override
	   public void actionPerformed(ActionEvent e) {
	      Object obj = e.getSource();
	      if(obj == dMenu.chikenB) {
	    	  meal_Actions("후라이드치킨", 16500, dMenu.mealNameTF, dMenu.mealPriceTF, dMenu.mealAmountTF);
	      } else if(obj == dMenu.soyChikenB) {
	    	  meal_Actions("간장 치킨", 17000, dMenu.mealNameTF, dMenu.mealPriceTF, dMenu.mealAmountTF);
	      } else if(obj == dMenu.yangChikenB) {
	    	  meal_Actions("양념 치킨", 17000, dMenu.mealNameTF, dMenu.mealPriceTF, dMenu.mealAmountTF);
	      } else if(obj == dMenu.cokeB) {
	    	  meal_Actions("코카콜라", 1500, dMenu.mealNameTF, dMenu.mealPriceTF, dMenu.mealAmountTF);
	      } else if(obj == dMenu.ciderB) {
	    	  meal_Actions("사이다", 1500, dMenu.mealNameTF, dMenu.mealPriceTF, dMenu.mealAmountTF);
	      } // 메뉴 선택 액션
	      
	      else if(obj == dMenu.plusB) {
	    	  pAction();
	      } else if(obj == dMenu.minusB) {
	    	  mAction();
	      } // 수량 증감 액션
	      
	      else if(obj == dMenu.registerB) {
	    	  regAction();
	      } else if(obj == dMenu.removeB) {
	    	  delAction();
	      } else if(obj == dMenu.decideB) {
	    	  decAction();
	      }
	   }//end actionPerformed()
	
	private void meal_Actions(String name, int price, 
			JTextField nameTF, JTextField priceTF, JTextField amountTF) {
		int amount = 1; // 메뉴를 누를 경우 기본 수량을 1로 하여 메뉴 선택
		nameTF.setText(name);
		priceTF.setText(Integer.toString(price));
		amountTF.setText(Integer.toString(amount));
	}  // end meal_Actions();
	
	private void pAction() {
		if(dMenu.mealNameTF.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "메뉴를 먼저 선택해주세요!", "메뉴 선택", JOptionPane.ERROR_MESSAGE);
			return; // 메뉴 이름이 담긴 텍스트필드를 읽어서 공백일 경우 메뉴가 선택되지 않은 것이므로 메세지 출력 
		} else {
			int count = Integer.parseInt(dMenu.mealAmountTF.getText());
			count++;
			dMenu.mealAmountTF.setText(Integer.toString(count));
		}
	} // end pAction()
	
    private void mAction() {
		if(dMenu.mealNameTF.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "메뉴를 먼저 선택해주세요!", "메뉴 선택", JOptionPane.ERROR_MESSAGE);
			return; // 메뉴 이름이 담긴 텍스트필드를 읽어서 공백일 경우 메뉴가 선택되지 않은 것이므로 메세지 출력 
		} else {
			int count = Integer.parseInt(dMenu.mealAmountTF.getText());
			if(count <= 1) {
				JOptionPane.showMessageDialog(this, "0 마리 이하는 주문 하실 수 없습니다!", "수량 오류", JOptionPane.ERROR_MESSAGE);
				return;
			} // 음수로 주문 할 수 없도록 경고 메세지 출력
			count--;
			dMenu.mealAmountTF.setText(Integer.toString(count));
		}
    } // end mAction()
  
   private void regAction() { // 등록버튼 액션
	   if (dMenu.mealAmountTF.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "음식을 선택해 주세요", "주문 오류", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			String[] row = new String[3];
			row[0] = dMenu.mealNameTF.getText().trim();
			row[1] = dMenu.mealAmountTF.getText().trim();
			row[2] = dMenu.mealPriceTF.getText().trim();
			dMenu.tableModel.addRow(row); // 음식 정보를 받아서 테이블에 삽입
			
			int fPrice = 0;
			for(int i = 0; i < dMenu.table.getRowCount(); i++) {
				fPrice += Integer.parseInt((String)dMenu.tableModel.getValueAt(i, 2));
				dMenu.fullPriceTF.setText(Integer.toString(fPrice));
			}
		}
		
		// 음식 정보 테이블 삽입 후 텍스트 필드 초기화
		dMenu.mealNameTF.setText("");
		dMenu.mealAmountTF.setText("");
		dMenu.mealPriceTF.setText("");

	} // end regAction()

	private void delAction() { // 삭제버튼 액션
		int row = dMenu.table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "주문 제거할 메뉴를 선택해주세요.");
			return;
		} // 삭제할 게 없으면 출력
		dMenu.tableModel.removeRow(row);// 행삭제
		
		int fPrice = 0;
		
		for(int i = 0; i < dMenu.table.getRowCount(); i++) {
			fPrice += Integer.parseInt((String)dMenu.tableModel.getValueAt(i, 2));
			dMenu.fullPriceTF.setText(Integer.toString(fPrice));
		}
	} // end delAction()
	
	private void decAction() { // 결정버튼 액션
		int chk = JOptionPane.showConfirmDialog(this, "주문 결정하시겠습니까?", "주문 결정", JOptionPane.YES_NO_OPTION);

		if (chk == JOptionPane.NO_OPTION) {
			return;
		} else if (chk == JOptionPane.YES_OPTION) {
			dMenu.tableModel.setRowCount(0); // table 초기화
		}
	} // end decAction()
}