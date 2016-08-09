package myframe;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.util.Enumeration;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;


public class MyFrame extends JFrame{
	private TitlePanel tp;
	private AddEmpPanel addp;
	private AlterPabel altp;
	private Container contentP;
	//���ֹ�����
	private CardLayout card = new CardLayout();
	
	public MyFrame() {
		this.init();
		
		tp = new TitlePanel(this);
		addp = new AddEmpPanel(this);
		altp = new AlterPabel(this);
		
		contentP.add(tp,"TitlePanel");
		contentP.add(addp,"AddEmpPanel");
		contentP.add(altp,"AlterPabel");

		this.setVisible(true);
	}

	/**��ʼ��������*/
	public void init(){
		//����ȫ������
		this.initGlobalFontSetting(new Font("Dialog",0,12));
		//������
		this.contentP = this.getContentPane();
		this.setLayout(card);
		this.setTitle("T88Ա������ϵͳ");
		//���ô����С���ܱ��ı�
//		this.setResizable(false);
		//����JFrame�Ĳ��ֹ�����ΪCardLayout
		this.setSize(500, 300);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
	}
	/**
	 * �����л����
	 * */
	public void switchPanel(String panelName){
		//��Ƭ���ֹ��������л����ķ�������һ�����������������
		card.show(this.getContentPane(), panelName);
	}
	//����ȫ������
	public static void initGlobalFontSetting(Font fnt)
	{
		FontUIResource fontRes = new FontUIResource(fnt);
		for(Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements();)
		{
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if(value instanceof FontUIResource)
				UIManager.put(key, fontRes);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}

	public TitlePanel getTp() {
		return tp;
	}

	public void setTp(TitlePanel tp) {
		this.tp = tp;
	}

	public Container getContentP() {
		return contentP;
	}

	public void setContentP(Container contentP) {
		this.contentP = contentP;
	}

	public CardLayout getCard() {
		return card;
	}

	public void setCard(CardLayout card) {
		this.card = card;
	}

	public AddEmpPanel getAddp() {
		return addp;
	}

	public void setAddp(AddEmpPanel addp) {
		this.addp = addp;
	}

	public AlterPabel getAltp() {
		return altp;
	}

	public void setAltp(AlterPabel altp) {
		this.altp = altp;
	}
}
