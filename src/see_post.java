// 포스트들에 관련된 (공지사항 더보기, 상벌점 더보기, 청소구역 전체보기 ) UI


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;


class noticeUI extends JFrame { // 공지사항
	
	noticeUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel index = new JLabel("공지사항을 여기에 써주세용!!");
		index.setFont(new Font("나눔고딕", 20, 20)); // 폰트 설정
		index.setBounds(170, 200, 400, 70);
		this.add(index);
		
		ImageIcon notice_back = new ImageIcon("img//notice_back.jpg");
		JLabel notice_back_label = new JLabel(notice_back);
		notice_back_label.setBounds(0, 0, 1080, 720);
		this.add(notice_back_label);
		

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}


class plus_and_minusUI extends JFrame { // 상벌점 더보기
	
	plus_and_minusUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		String header[] = { "날짜", "내용", "점수" };

		String contents[][] = { { "2018.05.01", "여기에는", "+3" }, { "2018.09.17", "DB", "-4" },
				{ "2018.11.02", "내 생일", "-1" }, { "2018.11.07", "초코쿠키 먹고싶당", "+0.5" } };

		JTable table = new JTable(contents, header);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(170, 200, 700, 400);
		this.add(scrollpane);
		
		
		ImageIcon plusandminus = new ImageIcon("img//plusandminus.jpg");
		JLabel plusandminus_label = new JLabel(plusandminus);
		plusandminus_label.setBounds(0, 0, 1080, 720);
		this.add(plusandminus_label);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class cleanclassUI extends JFrame { // 청소구역 전체보기
	
	cleanclassUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel clean_face_room = new JLabel("501");
		clean_face_room.setFont(new Font("나눔고딕", 35, 35)); // 세면실
		clean_face_room.setBounds(300, 200, 400, 70);
		this.add(clean_face_room);
		
		
		JLabel shower_room = new JLabel("502");
		shower_room.setFont(new Font("나눔고딕", 35, 35)); // 샤워실
		shower_room.setBounds(300, 300, 400, 70);
		this.add(shower_room);
		
		
		JLabel laundry_room = new JLabel("503");
		laundry_room.setFont(new Font("나눔고딕", 35, 35)); // 세탁실
		laundry_room.setBounds(300, 410, 400, 70);
		this.add(laundry_room);
		
		JLabel bath_room = new JLabel("504");
		bath_room.setFont(new Font("나눔고딕", 35, 35)); // 화장실
		bath_room.setBounds(300, 510, 400, 70);
		this.add(bath_room);

		
		JLabel hall_room = new JLabel("505");
		hall_room.setFont(new Font("나눔고딕", 35, 35)); // 복도
		hall_room.setBounds(730, 230, 400, 70);
		this.add(hall_room);
		
		
		JLabel stair_room = new JLabel("506");
		stair_room.setFont(new Font("나눔고딕", 35, 35)); // 계단
		stair_room.setBounds(730, 340, 400, 70);
		this.add(stair_room);
		
		
		JLabel rest_room = new JLabel("507");
		rest_room.setFont(new Font("나눔고딕", 35, 35)); // 휴게실
		rest_room.setBounds(730, 445, 400, 70);
		this.add(rest_room);
		
		/////
		
		
		ImageIcon backicon = new ImageIcon("img//cleanroom_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);
		
		// this.setResizable(false); // 프로그램을 함부로 크기 조정할 수 있나?
		// this.setPreferredSize(new Dimension(1080, 1080 / 12 * 9)); // 왼쪽, 오른쪽 둘 다 넣을
		// 수 있게 하는게 디맨션
		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class student_listUI extends JFrame { // 학생 리스트 전체보기
	
	student_listUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel index = new JLabel("학생 리스트 전체보기");
		index.setFont(new Font("나눔고딕", 50, 50)); // 폰트 설정
		index.setBounds(170, 200, 600, 70);
		this.add(index);
		
//		ImageIcon backicon = new ImageIcon("img//write_out_back.jpg");
//		JLabel backlabel = new JLabel(backicon);
//		backlabel.setBounds(0, 0, 1080, 720);
//		this.add(backlabel);
		
		// this.setResizable(false); // 프로그램을 함부로 크기 조정할 수 있나?
		// this.setPreferredSize(new Dimension(1080, 1080 / 12 * 9)); // 왼쪽, 오른쪽 둘 다 넣을
		// 수 있게 하는게 디맨션
		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}



public class see_post {
	public static void main(String[] args) {
		//new cleanclassUI();
	}

}


