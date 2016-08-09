package myframe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import emp.Employee;


public class AlterPabel extends JPanel {
	private JLabel jlName;
	private JTextField jTextName;
	private JLabel jlGender;
	private JRadioButton jRadioButton;
	private JLabel jlAddress;
	private JTextField jTextAddress;
	private JLabel jlEmployeeType;
	private JComboBox comboBox;
	private JLabel jlsalary;
	private JTextField jTextsalary;
	private JLabel jlTitle;
	private JRadioButton jRadioButton1;

	public AlterPabel(final MyFrame frame) {
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		JPanel jp1 = new JPanel();
		JPanel jp = new JPanel();

		this.jlName = new JLabel("�� ��       ");
		jp.add(jlName);
		this.jTextName = new JTextField(15);
		jp.add(jTextName);

		this.jlGender = new JLabel("      �� ��");
		jp.add(jlGender);
		ButtonGroup bg=new ButtonGroup();
		this.jRadioButton = new JRadioButton(" �� ",true);
		this.jRadioButton1 = new JRadioButton(" Ů ");
		bg.add(jRadioButton);
		bg.add(jRadioButton1);
		jp.add(jRadioButton);
		jp.add(jRadioButton1);
		this.jlGender = new JLabel("                       ");
		jp.add(jlGender);

		this.jlEmployeeType = new JLabel("Ա������  ");
		jp.add(jlEmployeeType);
		comboBox = new JComboBox();
		comboBox.addItem("                                               ");
		comboBox.addItem("��н��Ա��");
		comboBox.addItem("��н��Ա��");
		comboBox.addItem("��ʱ��");
		jp.add(comboBox);

		this.jlsalary = new JLabel("��������");
		jp.add(jlsalary);
		this.jTextsalary = new JTextField(15);
		jp.add(jTextsalary);

		this.jlAddress = new JLabel("   �� ַ      ");
		jp.add(jlAddress);
		this.jTextAddress = new JTextField(36);
		jp.add(jTextAddress);

		this.jlTitle = new JLabel("==== ��ӭʹ��T88Ա������ϵͳ  ====");
		jp.add(jlTitle);
		
		JButton jb_save = new JButton("����");
		jb_save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(comboBox.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(null, "��ѡ��Ա�����ͣ�");
					return;
				}
				//�õ����ѡ���ж�Ӧ��LovoVector
				LovoVector v = frame.getTp().getTable().getKey();
				
				if(v == null){
					JOptionPane.showMessageDialog(null,"��ѡ����");
					return;
				}
				
				//�õ�ѡ���е�ID
				int id = v.getKey();
				Employee emp = new Employee();
				emp.setEmployeeID(id);
				emp.setEmployeeName(jTextName.getText());
				emp.setGender(jRadioButton.isSelected() ? "��":"Ů");
				emp.setEmployeeType(comboBox.getSelectedItem().toString());
				emp.setSalary(Integer.parseInt(jTextsalary.getText()));
				emp.setAddress(jTextAddress.getText());
				
				frame.getTp().getService().editEmpployee(emp);
				
				LovoVector l = new LovoVector(emp.getEmployeeID());
				l.add(emp.getEmployeeName());
				l.add(emp.getGender());
				l.add(emp.getAddress());
				l.add(emp.getEmployeeType());
				l.add(emp.getSalary());
				
				frame.getTp().getTable().updateData(l);
			}
		});
		JButton jb_return = new JButton("����");
		jb_return.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.switchPanel("TitlePanel");
			}
		});
		jp1.add(jb_save);
		jp1.add(jb_return);
		this.add(jp,BorderLayout.CENTER);
		this.add(jp1,BorderLayout.SOUTH);
	}
}
