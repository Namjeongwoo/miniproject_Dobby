package miniproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Dobby_Consumer_Menu extends JPanel{
   //음식이름, 음식가격, 음식수량, 총 가격에 대한 라벨
   JLabel mealNameL, mealPriceL, mealAmountL, fullPriceL;
   //음식이름, 음식가격에 대한 텍스트필드
   JTextField mealNameTF, mealPriceTF, mealAmountTF, fullPriceTF;
   //주문 정보를 등록, 제거, 결정 버튼
   JButton registerB, removeB, decideB;
   //음식, 음료 버튼
   JButton chikenB, yangChikenB, soyChikenB, cokeB, ciderB;
   //더하기, 빼기 버튼
   JButton plusB, minusB;
   //주문 정보를 보여줄 테이블
   JTable table;
   JScrollPane scroll;
   DefaultTableModel tableModel;
   
   //테이블 헤드 이름
   String[] cols = { "음식명", "수량", "금액" };

   public Dobby_Consumer_Menu() {
      //JLabel 부분
      mealNameL = new JLabel("음식명");
      mealPriceL = new JLabel("음식가격");
      mealAmountL = new JLabel("음식수량");
      fullPriceL = new JLabel("총 금액");

      //라벨 위치 조정
      mealNameL.setHorizontalAlignment(JLabel.CENTER);
      mealPriceL.setHorizontalAlignment(JLabel.CENTER);
      mealPriceL.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
      mealAmountL.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
      
      fullPriceL.setHorizontalAlignment(JLabel.CENTER);
      
      //JTextField 부분
      mealNameTF = new JTextField(12);
      mealPriceTF = new JTextField(10);
      mealAmountTF = new JTextField(10);
      fullPriceTF = new JTextField(10);
      fullPriceTF.setText(Integer.toString(0));
      
      mealNameTF.setEditable(false); // 음식을 고르면 값, 이름을 출력하기 위해 수정 불가 설정
      mealPriceTF.setEditable(false);
      mealAmountTF.setEditable(false);
      fullPriceTF.setEditable(false);
      
      //버튼에 등록할 이미지 크기 조절 (내부 클래스 이용)
      class Resizing {
         public ImageIcon Icon(String str) {
            ImageIcon Icon = new ImageIcon(str); // 이미지 아이콘 받음
            Image getImg = Icon.getImage(); // 아이콘에서 이미지 추출
            Image imgResize = getImg.getScaledInstance(70, 70, Image.SCALE_SMOOTH); // 40*40 사이즈로 리사이징
            ImageIcon reIcon = new ImageIcon(imgResize); // 리사이징한 이미지 아이콘으로 만듬
            
            return reIcon;
         }
      }
      
      //JButton 부분
      registerB = new JButton("주문 등록");
      removeB = new JButton("주문 제거");
      decideB = new JButton("주문 결정");
      chikenB = new JButton(new Resizing().Icon("src/miniproject/Chicken.jpg")); // 치킨
      soyChikenB = new JButton(new Resizing().Icon("src/miniproject/SoyChicken.png")); // 간장치킨
      yangChikenB = new JButton(new Resizing().Icon("src/miniproject/YangyumChicken.png")); // 양념치킨
      cokeB = new JButton(new Resizing().Icon("src/miniproject/Coke.jpg")); // 콜라
      ciderB = new JButton(new Resizing().Icon("src/miniproject/Cider.jpg")); // 사이다
      plusB = new JButton("+");
      minusB = new JButton("-");
      
      chikenB.setBorder(new EmptyBorder(5, 5, 5, 5));
      soyChikenB.setBorder(new EmptyBorder(5, 5, 5, 5));
      yangChikenB.setBorder(new EmptyBorder(5, 5, 5, 5));
      cokeB.setBorder(new EmptyBorder(5, 5, 5, 5));
      ciderB.setBorder(new EmptyBorder(5, 5, 5, 5));
      
      chikenB.setToolTipText("후라이드치킨");
      soyChikenB.setToolTipText("간장치킨");
      yangChikenB.setToolTipText("양념치킨");
      cokeB.setToolTipText("콜라");
      ciderB.setToolTipText("사이다");
      
      //Jtable 부분
      //Innerclass 사용하여 셀을 건드리지 못하도록 설정
      tableModel = new DefaultTableModel(cols, 0) {
         public boolean isCellEditable(int row, int col) {
            return false;
         }
      };
      table = new JTable(tableModel);
      scroll = new JScrollPane(table);
 
      table.getColumnModel().getColumn(0).setPreferredWidth(50); // 음식명
      table.getColumnModel().getColumn(1).setPreferredWidth(10); // 음식 수량
      table.getColumnModel().getColumn(2).setPreferredWidth(50); // 총 금액
      table.getTableHeader().setReorderingAllowed(false); // 테이블 컬럼 이동 불가 설정
      table.setRowSelectionAllowed(false);
      //특정 셀이 선택되었을 때, 동일한 행에 있는 나머지 셀들이 전부 선택되는 기본 동작 불가 설정
      table.setColumnSelectionAllowed(false);
      //특정 셀이 선택되었을 때, 동일한 열에 있는 나머지 셀들이 전부 선택되는 기본 동작 불가 설정
      
      //배치하기
      //이름, 가격, 수량 라벨 패널
      JPanel mlabelPanel = new JPanel(new GridLayout(1, 3));
      mlabelPanel.add(mealNameL);
      mlabelPanel.add(mealPriceL);
      mlabelPanel.add(mealAmountL);
      
      //수량 조절을 위한 플러스, 마이너스 버튼 패널
      JPanel pmPanel = new JPanel(new GridLayout(2, 1));
      pmPanel.add(plusB);
      pmPanel.add(minusB);
      
      //음식에 대한 정보를 출력할 텍스트 필드가 담긴 패널
      JPanel minfoPanel = new JPanel(new FlowLayout());
      minfoPanel.add(mealNameTF);
      minfoPanel.add(mealPriceTF);
      minfoPanel.add(mealAmountTF);
      minfoPanel.add(pmPanel);
      
      //총 가격에 대한 패널
      JPanel mfullPricePanel= new JPanel(new FlowLayout());
      mfullPricePanel.add(fullPriceL);
      mfullPricePanel.add(fullPriceTF);
      mfullPricePanel.setBorder(new TitledBorder("총 가격"));
      
      //음식 고르기 버튼
      JPanel meal_drink_buttonPanel = new JPanel(new FlowLayout());
      meal_drink_buttonPanel.add(chikenB);
      meal_drink_buttonPanel.add(soyChikenB);
      meal_drink_buttonPanel.add(yangChikenB);
      meal_drink_buttonPanel.add(cokeB);
      meal_drink_buttonPanel.add(ciderB);
      meal_drink_buttonPanel.setBorder(new TitledBorder("음료 & 음식"));
      
      //주문 등록, 주문 제거, 주문 결정 버튼 패널
      JPanel buybutton_Panel = new JPanel(new FlowLayout());
      buybutton_Panel.add(registerB);
      buybutton_Panel.add(removeB);
      buybutton_Panel.add(decideB);
      
      //음식 정보, 라벨의 패널들을 묶은 패널
      JPanel mlabel_info_Panel = new JPanel(new GridLayout(4, 1));
      mlabel_info_Panel.add(mlabelPanel);
      mlabel_info_Panel.add(minfoPanel);
      mlabel_info_Panel.add(buybutton_Panel);
      mlabel_info_Panel.add(mfullPricePanel);
      
      //음식을 고르는 버튼 패널과 음식 정보가 담길 패널이 담긴 종합 패널
      JPanel mealPanel = new JPanel(new GridLayout(2, 1));
      mealPanel.add(meal_drink_buttonPanel);
      mealPanel.add(mlabel_info_Panel);
       
      //총 배치
      setLayout(new GridLayout(1, 2));
      add(mealPanel);
      add(scroll); // 테이블
   }      
}//end Restaurant_Menu