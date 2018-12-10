package 김요셉;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MainClass extends JFrame implements ActionListener {

	ProgTest1 pt1 = new ProgTest1();
	ProgTest2 pt2 = new ProgTest2();
	JLabel l1, l2, l3, l4;
	JTextField t1, t2, t3;
	JRadioButton rbt1, rbt2;

	JButton bt1, bt2, bt3, bt4;

	JPanel jp1, jp2, jp3;
	ButtonGroup bg;
	JTextArea ar1;

	MainClass() {
		super("프로그래밍언어 활용평가");
		ar1 = new JTextArea(20, 100);
		l1 = new JLabel("회원ID:");
		l2 = new JLabel("회원이름:");
		l3 = new JLabel("전화번호:");
		l4 = new JLabel("성별:");
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		t3 = new JTextField(10);
		bt1 = new JButton("회원등록");
		bt2 = new JButton("회원삭제");
		bt3 = new JButton("전체회원조회");
		bt4 = new JButton("구구단보기");
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);

		bg = new ButtonGroup();
		rbt1 = new JRadioButton("남");
		rbt2 = new JRadioButton("여");
		bg.add(rbt1);
		bg.add(rbt2);

		Box abox = Box.createHorizontalBox();
		abox.add(l1);
		abox.add(t1);
		abox.add(l2);
		abox.add(t2);
		abox.add(l3);
		abox.add(t3);
		abox.add(l4);
		abox.add(rbt1);
		abox.add(rbt2);
		abox.add(Box.createGlue());

		Box bbox = Box.createHorizontalBox();
		bbox.add(bt1);
		bbox.add(bt2);
		bbox.add(bt3);

		jp1 = new JPanel();
		jp1.add(abox);
		jp1.add(bbox);

		jp1.setBorder(new TitledBorder(new EtchedBorder(), "회원등록,삭제,조회"));
		Box cbox = Box.createHorizontalBox();
		cbox.add(bt4);

		jp2 = new JPanel();
		jp2.add(cbox);
		jp2.setBorder(new TitledBorder(new EtchedBorder(), "구구단"));
		Box dbox = Box.createHorizontalBox();
		dbox.add(ar1, "South");

		jp3 = new JPanel();
		jp3.add(dbox);
		jp3.setBorder(new TitledBorder(new EtchedBorder(), "결과"));
		Box qbox = Box.createVerticalBox();
		qbox.add(jp1);
		qbox.add(jp2);
		qbox.add(jp3);
		add(qbox, "Center");

		setSize(800, 400);
		setVisible(true);

	}

	public static void main(String[] args) {
		MainClass cl = new MainClass();
		cl.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt1) {
			int con = JOptionPane.showConfirmDialog(null, "회원을 등록하시겠습니까?", "회원등록", JOptionPane.YES_NO_OPTION);
			if (con == JOptionPane.YES_OPTION) {
				String strGender = "";
				Enumeration<AbstractButton> enums = bg.getElements();
				while (enums.hasMoreElements()) {
					AbstractButton ab = enums.nextElement();
					JRadioButton jb = (JRadioButton) ab;
					if (jb.isSelected())
						strGender = jb.getText();
				}
				pt2.mapListadd(t1.getText(), t2.getText(), t3.getText(), strGender);

			} else if (con == JOptionPane.CLOSED_OPTION) {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		}
		if (e.getSource() == bt2) {
			int con2 = JOptionPane.showConfirmDialog(this, "회원을 삭제하겠습니까?", "회원삭제", JOptionPane.YES_NO_OPTION);
			if (con2 == JOptionPane.YES_OPTION) {
				pt2.mapListRemove(t1.getText());

			} else {

			}
		}

		if (e.getSource() == bt3) {

			ar1.setText("회원ID" + "\t" + "회원이름" + "\t" + "전화번호" + "\t" + "성별" + "\n");
			for (int i = 0; i < pt2.getMapList().size(); i++) {
				ar1.append(pt2.getMapList().get(i).getMemberID() + "\t" + pt2.getMapList().get(i).getName() + "\t"
						+ pt2.getMapList().get(i).getTel() + "\t" + pt2.getMapList().get(i).getGender() + "\n ");
			}

		}
		if (e.getSource() == bt4) {
			String dan = JOptionPane.showInputDialog("몇단누를거니 ?");

			if (dan.equals(dan)) {
				ar1.setText(dan + "단 : " + "\n" + pt1.getGugudan(Integer.parseInt(dan)));
			}

		}

	}

}
