
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;


class message_room_student extends JFrame {
	
	message_room_student() {
		
	
		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
			// ��Ź�� ��ư
		

		JLabel date = new JLabel("2018-11-21");
		date.setFont(new Font("��������", 20, 20)); // ��Ʈ ����
		date.setBounds(170, 200, 170, 70);
		this.add(date);

		JLabel label = new JLabel("���ִ� ������Ű�� �Ծ����ϴ�.");
		label.setFont(new Font("��������", 20, 20)); // ��Ʈ ����
		label.setBounds(340, 200, 300, 70);
		this.add(label);

		
		ImageIcon backicon = new ImageIcon("img//messageroom_student.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);
		
		// this.setResizable(false); // ���α׷��� �Ժη� ũ�� ������ �� �ֳ�?
		// this.setPreferredSize(new Dimension(1080, 1080 / 12 * 9)); // ����, ������ �� �� ����
		// �� �ְ� �ϴ°� ��Ǽ�
		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}


class message_room_teacher extends JFrame {
	
	message_room_teacher() {
		
	
		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
			// ��Ź�� ��ư
		

		JLabel date = new JLabel("2018-11-21");
		date.setFont(new Font("��������", 20, 20)); // ��Ʈ ����
		date.setBounds(170, 200, 150, 70);
		this.add(date);
		
		JLabel receiver = new JLabel("�迹��");
		receiver.setFont(new Font("��������", 20, 20)); // ��Ʈ ����
		receiver.setBounds(380, 200, 100, 70);
		this.add(receiver);

		JLabel label = new JLabel("�鿣�� ȭ���� ��v�� �������� ���������");
		label.setFont(new Font("��������", 20, 20)); // ��Ʈ ����
		label.setBounds(530, 200, 300, 70);
		this.add(label);

		
		ImageIcon backicon = new ImageIcon("img//messageroom_teacher.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}







public class message {
	public static void main(String[] args) {
//
//		new message_room_teacher();
//		
	}

}