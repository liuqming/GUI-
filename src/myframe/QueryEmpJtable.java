package myframe;

import java.sql.*;
import javax.swing.table.*;
import javax.swing.*;
import java.util.Vector;
//������������
//String[] col_names = {"����",
//		"�Ա�",
//		"��ַ",
//		"Ա������",
//		"��������"};
////���ݳ�ʼ�����洢�ڶ�ά����
//Object[][] tableData = {
//		{"Kathy", "Smith","Snowboarding", new Integer(5), new Boolean(false)},
//		{"John", "Doe","Rowing", new Integer(3), new Boolean(true)},
//		{"Sue", "Black","Knitting", new Integer(2), new Boolean(false)},
//		{"Jane", "White","Speed reading", new Integer(20), new Boolean(true)},
//		{"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}
//};
////���ű��ʹ����Щ���ݺ���������һ�����
//tableModel = new DefaultTableModel(tableData,col_names);
//table = new JTable(tableModel);
//table.setRowHeight(20);
////��������ӱ��
//JScrollPane scrollPane = new JScrollPane(table);
//table.setFillsViewportHeight(true);
//this.add(scrollPane);
////		this.add(table.getTableHeader(), BorderLayout.PAGE_START);
////		this.add(table,BorderLayout.CENTER);
//
////�ı�ÿһ�еĿ��
//TableColumn column = null;
//for (int i = 0; i < 5; i++) {
//	column = table.getColumnModel().getColumn(i);
//	if (i == 2) {
//		column.setPreferredWidth(150);
//	} else {
//		column.setPreferredWidth(50);
//	}
//}
//TableColumn sportColumn = table.getColumnModel().getColumn(3);
//JComboBox comboBox = new JComboBox();
//comboBox.addItem("��н��Ա��");
//comboBox.addItem("��н��Ա��");
//comboBox.addItem("��ʱ��");
//sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

public class QueryEmpJtable {
	public static void main(String args []) throws SQLException{
		// A ע��oracle jdbc ����
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		// B �������ݿ�����
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","tiger");
		// C ���� Statment ����
		Statement stmt = conn.createStatement();
		// D ִ�� select ָ��,��ѯ�������ResultSet����
		ResultSet rset = stmt.executeQuery("select * FROM employee");
		// E ����ѯ�����ʾ��JTable
		DisplayResult(rset);
		rset.close();
		stmt.close();
		conn.close();
	}
	public static void DisplayResult(ResultSet rset)throws SQLException{
		JFrame frame = new JFrame();
		DefaultTableModel tableModel = new DefaultTableModel();
		JTable table = new JTable(tableModel);
		JScrollPane resultPan = new JScrollPane(table);
		ResultSetMetaData md = rset.getMetaData();
		Vector col_names = new Vector();
		// ȡ�� ResultSet �������ֶ�����
		int no_cols = md.getColumnCount();
		System.out.println(no_cols);
		//ȡ�� ResultSet �������ֶε�����
		for(int i=0;i<no_cols;i++)
			col_names.add(md.getColumnLabel(i+1));
			System.out.println(col_names);
		Vector tableData = new Vector();
		//ȡ��ÿ������
		while(rset.next())
		{
			Vector rowData = new Vector();
			for(int i=1; i<=no_cols;i++){
				rowData.add(rset.getString(i));
			}
			// ��ÿ������ rowData ����tableData
			tableData.add(rowData);
		}
		tableModel.setDataVector(tableData,col_names);
		frame.setTitle("Employees information");
		frame.getContentPane().add(resultPan);
		frame.pack();
		frame.setVisible(true);
	}
	public QueryEmpJtable() {
	}
}