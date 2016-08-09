package myframe;

import java.awt.Container;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 * ������
 * @author ibm
 *
 */
public class LovoTable extends JTable {
	/**��ͷ*/
	private Vector<String> headVector = new Vector<String>();
	/**����*/
	private Vector<LovoVector> dataVector = new Vector<LovoVector>();
	
	private JScrollPane jsp = new JScrollPane(this);
	
	/**
	 * ���췽��
	 * @param jf ��������
	 * @param headArray ��ͷ�ֶ�
	 */
	public LovoTable(Container jf,String[] headArray){
		jf.add(jsp);
		
		for(String str : headArray){
			this.headVector.add(str);
		}
		this.updateTable();
		
		JTableHeader jth=this.getTableHeader();
		jth.setReorderingAllowed(false);//���ñ�ͷ�����϶�������
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//���ñ��һ��ֻ��ѡ��һ��
	}
	
	private void updateTable(){
		this.setModel(new DefaultTableModel(this.dataVector,this.headVector));
	}
	
	/**
	 * ���±������
	 * @param v
	 */
	public void updateLovoTable(Vector<LovoVector> v){
		this.dataVector = v;
		this.updateTable();
	}
	
	/**
	 * �������
	 * @param v
	 */
	public void addData(LovoVector v){
		this.dataVector.add(v);
		this.updateTable();
	}
	
	/**
	 * ɾ��ѡ����
	 * @return ɾ�����кţ�û��ѡ�з���-1
	 */
	public int removeKey(){
		int index = this.getSelectedRow();
		if(index != -1){
			this.dataVector.remove(index);
			this.updateTable();
		}
		return index;
	}
	
	/**
	 * �õ�ѡ���û��ѡ�б�񷵻�Ϊnull
	 * @return
	 */
	public LovoVector getKey(){
		int index = this.getSelectedRow();
		
		if(index != -1){
			LovoVector lv = this.dataVector.get(index);
			return lv;
		}
		else{
			return null;
		}
	}
	
	/**
	 * �޸�ѡ������ûѡ�з���-1
	 * @return 
	 */
	public int updateData(LovoVector data){
		int index = this.getSelectedRow();
		
		if(index != -1){
			this.dataVector.set(index,data);
			this.updateTable();
			return index;
		}
		else{
			return -1;
		}
	}
	
	/**
	 * ���ô�С��λ��
	 * @param x X����
	 * @param y Y����
	 * @param width ���
	 * @param height �߶�
	 */
	public void setSizeAndLocation(int x,int y,int width,int height){
		this.jsp.setBounds(x, y, width, height);
	}
	
	/**
	 * ���ñ�񲻿ɱ༭
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean isCellEditable(int row,int column){
		return false;
	}
	
//	public TableCellRenderer getCellRenderer(int row, int column) {
//        TableCellRenderer renderer = super.getCellRenderer(row, column);
//        if (renderer instanceof JLabel) {
//            ((JLabel) renderer).setHorizontalAlignment(JLabel.CENTER);
//        }
//        return renderer;
//    }
}
