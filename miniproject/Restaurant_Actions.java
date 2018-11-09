package miniproject;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Restaurant_Actions {
   Restaurant_Menu rMenu;
   
   int num = 1; // 주문번호
   
   public Restaurant_Actions() { }
   
   //음식 버튼 누를시 텍스트 필드 액션
   public void meal_Actions(String name, int price, 
         JTextField nameTF, JTextField priceTF, JTextField amountTF) {
      int amount = 1;
       nameTF.setText(name);
       priceTF.setText(Integer.toString(price));
       amountTF.setText(Integer.toString(amount));
   } // 메뉴를 누를 경우 기본 수량을 1로 하여
   
   //플러스 버튼 액션
   public void p_Actions(JTextField amountTF, JTextField nameTF) {
      if(nameTF.getText().equals("")) {
         JOptionPane.showMessageDialog(null, "메뉴를 먼저 선택해주세요!", "메뉴 선택", JOptionPane.ERROR_MESSAGE);
         return; // 메뉴 이름이 담긴 텍스트필드를 읽어서 공백일 경우 메뉴가 선택되지 않은 것이므로 메세지 출력 
      } else {
         int count = Integer.parseInt(amountTF.getText());
         count++;
         amountTF.setText(Integer.toString(count));
      }
   }
   
   //마이너스 버튼 액션
   public void m_Actions(JTextField amountTF, JTextField nameTF) {
      if(nameTF.getText().equals("")) {
         JOptionPane.showMessageDialog(null, "메뉴를 먼저 선택해주세요!", "메뉴 선택", JOptionPane.ERROR_MESSAGE);
         return; // 메뉴 이름이 담긴 텍스트필드를 읽어서 공백일 경우 메뉴가 선택되지 않은 것이므로 메세지 출력 
      } else {
         int count = Integer.parseInt(amountTF.getText());
         if(count <= 1) {
            JOptionPane.showMessageDialog(null, "0 마리 이하는 주문 하실 수 없습니다!", "수량 오류", JOptionPane.ERROR_MESSAGE);
            return;
         } // 음수로 주문 할 수  설정
         count--;
         amountTF.setText(Integer.toString(count));
      }
   }

   //주문 등록 버튼 액션
   public void reg_Actions(JTextField nameTF, JTextField amountTF,
            JTextField priceTF, DefaultTableModel dft) {      
         
            if(amountTF.getText().equals("")) {
            	JOptionPane.showMessageDialog(null, "음식을 선택해 주세요", "주문 오류", JOptionPane.ERROR_MESSAGE);
            	return;
            }else {
            	String[] row = new String[4];
                row[0] = Integer.toString(num++);
                row[1] = nameTF.getText().trim();
                row[2] = amountTF.getText().trim();
                row[3] = priceTF.getText().trim();
                dft.addRow(row);
            }
            //주문등록 후 텍스트 필드 초기화
            nameTF.setText("");
            amountTF.setText("");
            priceTF.setText("");
            
   }//end reg_Actions() 
   
   //주문제거 버튼 액션
   public void del_Actions(JTable table, DefaultTableModel dft) {
	   int row = table.getSelectedRow();
	   if(row == -1) {
		   JOptionPane.showMessageDialog(table, "주문 제거할 메뉴를 선택해주세요.");
		   return;
	   }
	   dft = (DefaultTableModel) table.getModel();
	   dft.removeRow(row);
	   
	   
   }//end del_Actions
   
   //주문 결정 버튼 액션
   public void dec_Actions(JTable table, DefaultTableModel tableModel) {
         
	    int chk = JOptionPane.showConfirmDialog(table, "주문 결정하시겠습니까?", "주문 결정", JOptionPane.YES_NO_OPTION);
	    
		if(chk == JOptionPane.NO_OPTION) {
			return;
		}else if (chk == JOptionPane.YES_OPTION) {
			tableModel.setRowCount(0); //table 초기화
		}
		
   }//end dec_Actions
   
   
   
}//end class