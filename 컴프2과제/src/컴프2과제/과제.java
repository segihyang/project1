package ����2����;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ���� extends JFrame{
	JLabel la = new JLabel("��ȭ�� �������α׷�");//����
	JPanel re = new JPanel();//��ü�����
	JLabel re1 = new JLabel("�����ڸ�: "); //�����ڸ� ���
	JLabel re2 = new JLabel("�����¼�: "); //������ �¼����
	int [] num= new int[30]; //������ �¼� ����� �迭
	JTextField input = new JTextField();//�������Է�
	Container c = getContentPane();
	JPanel p = new JPanel();	//�¼������ϴ� �г�
	JPanel q = new JPanel();	//�¼����� �г�
	JButton[] b=new JButton[30]; //�¼���ư
	JButton b1=new JButton("�����ʱ�ȭ"); //�¼������ʱ�ȭ��
	JButton b2=new JButton("�����Ϸ�"); //�����¼� �����Ϸ�
	JButton end=new JButton("��������"); //�������α׷� �Ϸ� �� ���� ���� ����
	int count=0; //���������Ǻ��� ����
public ����() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout((new GridLayout(5, 1))); //��ü����
		c.add(la);
		c.add(input);
		input.setText("");
		p.setLayout((new GridLayout(6,5))); //�¼�����
		for(int i=0; i<30;i++) {
			b[i]= new JButton((i+1)+""); //�¼�����
			b[i].setBackground(Color.white);
			b[i].addActionListener(new MyActionListener());
			p.add(b[i]);}
		c.add(p);
		q.add(b1);
		q.add(b2);
		b1.addActionListener(new MyActionListener());
		b2.addActionListener(new MyActionListener());
		c.add(q);
		re.setLayout((new GridLayout(1,3))); //��ü���������
		re.add(re1);
		re.add(re2);
		re.add(end);
		end.addActionListener(new MyActionListener());
		c.add(re);
		setSize(900, 750);	//������ �������
		setVisible(true);	//������ ���
		c.setFocusable(true); // ����Ʈ���� ��Ŀ���� ���� �� �ֵ��� ����
		c.requestFocus();
	}
	class  MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		for(int i=0; i<30;i++) {
			if(e.getSource()==b[i]) {
			b[i].setBackground(Color.pink);}}
		if(e.getSource()==b1) {
			for(int i=0; i<30;i++) {
				b[i].setBackground(Color.white);}
			count=0;
			re2.setText("�����¼�: ");}
		if(e.getSource()==b2) {
			if(count==1) {
				return;
				}
			for(int j=0;j<30;j++) {
				for(int i=0; i<30;i++) {
					Color color= b[i].getBackground();
					if(color==Color.pink) {
						num[i]=i+1;} //������ �¼� ������ �迭
					else {
						num[i]=0;} //�迭 ���� ����
					}
				if(num[j]==j+1) {
					re2.setText(re2.getText()+num[j]+" "); //������ �¼� ���� ���
					}
				}
			count=1; //�������� ����Ϸ�
			re1.setText("�����ڸ�: "+input.getText()); //�����ڸ� ����
			}
		if(e.getSource()==end) {
			re1.setText("�����ڸ�: ");
			re2.setText("�����¼�: ");
			for(int i=0; i<30;i++) {
				b[i].setBackground(Color.white);}
			input.setText("");
			
			count =0;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ����();
	}

}
