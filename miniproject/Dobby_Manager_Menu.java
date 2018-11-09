package miniproject;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Dobby_Manager_Menu extends JPanel {
	// 주문내역, 재고 수량, 판매 집계, 총매출금액 라벨
	JLabel orderHistoryL, stockL, salesCountL, totalSalesCountL;
	// 주문내역 , 재고 수량, 판매 집계 테이블
	JTable orderHistoryT, stockT, salesCountT;
	// 총매출금액 표시 텍스트필드
	JTextField totalSalesCountTF;
	JScrollPane scroll, scroll2, scroll3;
	DefaultTableModel ohTableModel, stTableModel, scTableModel;

	// 주문내역 메세지 텍스트아레아
	JTextArea orderHistoryTA;

	// 초기화 버튼
	JButton resetB;

	String[] cols = { "주문시간", "음식명", "수량", "금액" };
	String[] cols2 = { "제품 id", "제품명", "수량" };
	String[] cols3 = { "음식명", "수량", "금액" };

	public Dobby_Manager_Menu() {
		
		// JLabel 부분
		orderHistoryL = new JLabel("주문내역");
		stockL = new JLabel("재고 수량");
		salesCountL = new JLabel("판매 집계");
		totalSalesCountL = new JLabel("총매출금액");

		// 라벨 위치 조정
		orderHistoryL.setHorizontalAlignment(JLabel.CENTER);
		stockL.setHorizontalAlignment(JLabel.CENTER);
		salesCountL.setHorizontalAlignment(JLabel.CENTER);

		// JTextField 부분
		totalSalesCountTF = new JTextField(20);

		// JTextArea 부분
		orderHistoryTA = new JTextArea("주문 확인");

		// Jbutton 부분
		resetB = new JButton("초기화");

		// JTable 부분 (주문 내역)
		// Innerclass 사용하여 셀을 건드리지 못하도록 설정
		ohTableModel = new DefaultTableModel(cols, 30) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		orderHistoryT = new JTable(ohTableModel);
		scroll = new JScrollPane(orderHistoryT);
		orderHistoryT.setRowHeight(20);// 라인의 높이
		orderHistoryT.getColumnModel().getColumn(0).setPreferredWidth(20); // 주문 시간
		orderHistoryT.getColumnModel().getColumn(1).setPreferredWidth(40); // 음식명
		orderHistoryT.getColumnModel().getColumn(2).setPreferredWidth(10); // 음식 수량
		orderHistoryT.getColumnModel().getColumn(3).setPreferredWidth(20); // 금액
		orderHistoryT.getTableHeader().setReorderingAllowed(false); // 테이블 컬럼 이동 불가 설정
		orderHistoryT.setRowSelectionAllowed(false);
		// 특정 셀이 선택되었을 때, 동일한 행에 있는 나머지 셀들이 전부 선택되는 기본 동작 불가 설정
		orderHistoryT.setColumnSelectionAllowed(false);
		// 특정 셀이 선택되었을 때, 동일한 열에 있는 나머지 셀들이 전부 선택되는 기본 동작 불가 설정

		// JTable 부분 (재고 수량)
		stTableModel = new DefaultTableModel(cols2, 30) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		stockT = new JTable(stTableModel);
		scroll2 = new JScrollPane(stockT);
		stockT.setRowHeight(20);// 라인의 높이
		stockT.getColumnModel().getColumn(0).setPreferredWidth(50); // 제품 id
		stockT.getColumnModel().getColumn(1).setPreferredWidth(50); // 제품명
		stockT.getColumnModel().getColumn(2).setPreferredWidth(10); // 수량
		stockT.getTableHeader().setReorderingAllowed(false); // 테이블 컬럼 이동 불가 설정
		stockT.setRowSelectionAllowed(false);
		// 특정 셀이 선택되었을 때, 동일한 행에 있는 나머지 셀들이 전부 선택되는 기본 동작 불가 설정
		stockT.setColumnSelectionAllowed(false);
		// 특정 셀이 선택되었을 때, 동일한 열에 있는 나머지 셀들이 전부 선택되는 기본 동작 불가 설정

		// JTable 부분 (판매 집계)
		scTableModel = new DefaultTableModel(cols3, 30) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		salesCountT = new JTable(scTableModel);
		scroll3 = new JScrollPane(salesCountT);
		salesCountT.setRowHeight(20);// 라인의 높이
		salesCountT.getColumnModel().getColumn(0).setPreferredWidth(50); // 음식명
		salesCountT.getColumnModel().getColumn(1).setPreferredWidth(50); // 수량
		salesCountT.getColumnModel().getColumn(2).setPreferredWidth(10); // 금액
		salesCountT.getTableHeader().setReorderingAllowed(false); // 테이블 컬럼 이동 불가 설정
		salesCountT.setRowSelectionAllowed(false);
		// 특정 셀이 선택되었을 때, 동일한 행에 있는 나머지 셀들이 전부 선택되는 기본 동작 불가 설정
		salesCountT.setColumnSelectionAllowed(false);
		// 특정 셀이 선택되었을 때, 동일한 열에 있는 나머지 셀들이 전부 선택되는 기본 동작 불가 설정

		// 주문 내역 패널
		JPanel ohPanel = new JPanel(new GridLayout(2, 1));
		JPanel ohL_S_Panel = new JPanel(new BorderLayout());
		JPanel ohLPanel = new JPanel();
		JPanel ohTAPanel = new JPanel(new BorderLayout());
		ohLPanel.add(orderHistoryL);
		ohL_S_Panel.add("North", ohLPanel);
		ohL_S_Panel.add("Center", scroll);
		ohTAPanel.add("Center", orderHistoryTA);
		ohTAPanel.add("South", resetB);

		ohPanel.add(ohL_S_Panel);
		ohPanel.add(ohTAPanel);
		
		// 재고 수량 패널
		JPanel stPanel = new JPanel(new BorderLayout());
		JPanel stLPanel = new JPanel();
		stLPanel.add(stockL);
		stPanel.add("North", stLPanel);
		stPanel.add("Center", scroll2);

		// 판매 집계 패널
		JPanel scPanel = new JPanel(new BorderLayout());
		JPanel scLPanel = new JPanel();
		scLPanel.add(salesCountL);
		scPanel.add("North", scLPanel);
		scPanel.add("Center", scroll3);

		JPanel tscPanel = new JPanel();
		tscPanel.add(totalSalesCountL);
		tscPanel.add(totalSalesCountTF);
		scPanel.add("South", tscPanel);

		JPanel scTotalPanel = new JPanel(new GridLayout(2, 1));
		scTotalPanel.add(scPanel);

		// this.setLayout(new BorderLayout());
		// this.add("Center", ohPanel);

		this.setLayout(new GridLayout(1, 3));
		this.add(ohPanel);
		this.add(stPanel);
		this.add(scTotalPanel);

		

	}// end Dobby_Manager_Menu()//////

}// end class
