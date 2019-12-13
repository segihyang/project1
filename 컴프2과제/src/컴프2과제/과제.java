package 컴프2과제;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class 과제 extends JFrame{
	JLabel la = new JLabel("영화관 예약프로그램");//제목
	JPanel re = new JPanel();//전체결과문
	JLabel re1 = new JLabel("예약자명: "); //예약자명 출력
	JLabel re2 = new JLabel("예약좌석: "); //예약한 좌석출력
	int [] num= new int[30]; //예약한 좌석 저장용 배열
	JTextField input = new JTextField();//예약자입력
	Container c = getContentPane();
	JPanel p = new JPanel();	//좌석포함하는 패널
	JPanel q = new JPanel();	//좌석제어 패널
	JButton[] b=new JButton[30]; //좌석버튼
	JButton b1=new JButton("선택초기화"); //좌석선택초기화용
	JButton b2=new JButton("결정완료"); //예약좌석 결정완료
	JButton end=new JButton("예약저장"); //예약프로그램 완료 및 다음 예약 실행
	int count=0; //예약저장판별용 변수
public 과제() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout((new GridLayout(5, 1))); //전체개형
		c.add(la);
		c.add(input);
		input.setText("");
		p.setLayout((new GridLayout(6,5))); //좌석개형
		for(int i=0; i<30;i++) {
			b[i]= new JButton((i+1)+""); //좌석설정
			b[i].setBackground(Color.white);
			b[i].addActionListener(new MyActionListener());
			p.add(b[i]);}
		c.add(p);
		q.add(b1);
		q.add(b2);
		b1.addActionListener(new MyActionListener());
		b2.addActionListener(new MyActionListener());
		c.add(q);
		re.setLayout((new GridLayout(1,3))); //전체결과문개형
		re.add(re1);
		re.add(re2);
		re.add(end);
		end.addActionListener(new MyActionListener());
		c.add(re);
		setSize(900, 750);	//프레임 사이즈설정
		setVisible(true);	//프레임 출력
		c.setFocusable(true); // 컨텐트팬이 포커스를 받을 수 있도록 설정
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
			re2.setText("예약좌석: ");}
		if(e.getSource()==b2) {
			if(count==1) {
				return;
				}
			for(int j=0;j<30;j++) {
				for(int i=0; i<30;i++) {
					Color color= b[i].getBackground();
					if(color==Color.pink) {
						num[i]=i+1;} //예약한 좌석 저장할 배열
					else {
						num[i]=0;} //배열 전부 정의
					}
				if(num[j]==j+1) {
					re2.setText(re2.getText()+num[j]+" "); //예약한 좌석 전부 출력
					}
				}
			count=1; //예약저장 시행완료
			re1.setText("예약자명: "+input.getText()); //예약자명 저장
			}
		if(e.getSource()==end) {
			re1.setText("예약자명: ");
			re2.setText("예약좌석: ");
			for(int i=0; i<30;i++) {
				b[i].setBackground(Color.white);}
			input.setText("");
			
			count =0;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 과제();
	}

}
