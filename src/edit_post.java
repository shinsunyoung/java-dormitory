
// 사감 선생님 (상벌점, 공지사항, 청소구역)

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

class plus_and_minus_edit_UI extends JFrame { // 상벌점 추가/삭제
	
	public static Connection conn = null;
	
	public void chgScore(String reason, int plus, int minus) throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		// 학생 총 점수 수정 삭제
		UImain.sscore += plus;
		UImain.sscore -= minus;
		
		int rscore = plus - minus; // 내역에 추가할 상벌점
		System.out.println(plus + " " + minus);
		
		PreparedStatement ps = conn.prepareStatement("UPDATE student SET score = ? where id = ?"); // 총 점수
		ps.setInt(1, UImain.sscore);
		ps.setInt(2, UImain.sid);
		int res = ps.executeUpdate();
		
		ps = conn.prepareStatement("INSERT INTO score(id, score, reason) VALUES(?, ?, ?)"); // 상벌점 내역 추가
		ps.setInt(1, UImain.sid);
		ps.setInt(2, rscore);
		System.out.println(rscore);
		ps.setString(3, reason);
		res = ps.executeUpdate();
		
		if(res > 0) System.out.println(String.format("%d row update success", res));
		
		ps.close();

		conn.close();
		
		UImain.chgStatus(); // 사감 선생님 메인 화면 초기화
	}

	plus_and_minus_edit_UI() { // 상벌점 GUI

		this.setTitle("Dormitory Management System check_score");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JTextField why = new JTextField(); // 항목
		why.setBounds(460, 265, 250, 40);
		this.add(why);
		
		JTextField plus = new JTextField(); // 상점
		plus.setBounds(460, 330, 70, 40);
		this.add(plus);
		
		JTextField minus = new JTextField(); // 벌점
		minus.setBounds(460, 400, 70, 40);
		this.add(minus);
		
		ImageIcon changbtn = new ImageIcon("img//changbtn.png");
		JLabel changbtn_label = new JLabel(changbtn);
		changbtn_label.setBounds(460, 560, 170, 70);
		this.add(changbtn_label);

		changbtn_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					System.out.println(minus.getText());
					chgScore(why.getText(), Integer.parseInt(plus.getText()), Integer.parseInt(minus.getText()));
					JOptionPane.showMessageDialog(null, "변경사항이 적용되었습니다!");
					dispose();
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		ImageIcon backicon = new ImageIcon("img//add_plus_and_minus_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class classroom_edit_UI extends JFrame { 
	public static Connection conn = null;
	
	public void edit_cleanroom(int areanum, int roomnum) throws ClassNotFoundException, SQLException { // 청소구역 수정
		String clean_where_db[] = {"washroom", "shower", "laundary", "toilet", "hall", "stair", "restarea"};

		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		PreparedStatement ps = conn.prepareStatement("UPDATE clean SET room = ? where area = ?");
		ps.setInt(1, roomnum);
		ps.setString(2, clean_where_db[areanum]);
		int res = ps.executeUpdate();
		
		if(res > 0) System.out.println(String.format("%d row update success", res));
		
		ps.close();
		conn.close();
	}

	classroom_edit_UI() { // 청소구역 GUI

		this.setTitle("Dormitory Management System check_clean");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		String clean_where[] = { "세면실", "샤워실", "세탁실", "화장실", "복도", "계단", "휴게실" };

		JComboBox room_arr = new JComboBox(clean_where);
		room_arr.setBounds(570, 285, 100, 40);
		this.add(room_arr);

		JTextField search = new JTextField();
		search.setBounds(570, 375, 100, 40);
		this.add(search);

		ImageIcon changbtn = new ImageIcon("img//changbtn.png");
		JLabel changbtn_label = new JLabel(changbtn);
		changbtn_label.setBounds(460, 560, 170, 70);
		this.add(changbtn_label);

		changbtn_label.addMouseListener(new MouseAdapter() {			
			public void mouseClicked(MouseEvent e) {
				try {
					String value = room_arr.getSelectedItem().toString();
					
					int i = 0;
					for(i = 0; i < clean_where.length; i++) {
						if(value.equals(clean_where[i])) break;
					}
					
					String rnum = search.getText();
					int rrnum = Integer.parseInt(rnum);
					edit_cleanroom(i, rrnum);
					
					JOptionPane.showMessageDialog(null, "변경사항이 모두 잘 적용되었습니다!");
					dispose();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		ImageIcon backicon = new ImageIcon("img//change_cleanroom_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class notice_edit_UI extends JFrame { // 공지사항 수정
	
	public static Connection conn = null;
	
	public void addNotice(String notice) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO notice(notice) VALUES(?)");

		ps.setString(1, notice);
		
		int res = ps.executeUpdate();
		
		if(res == 1) System.out.println(String.format("%d row insert success", res));
		
		ps.close();
		conn.close();
	}

	notice_edit_UI() {

		this.setTitle("Dormitory Management System write_notice");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JTextField search = new JTextField();
		search.setBounds(120, 150, 840, 410);
		this.add(search);

		ImageIcon changbtn = new ImageIcon("img//changbtn.png");
		JLabel changbtn_label = new JLabel(changbtn);
		changbtn_label.setBounds(420, 590, 170, 70);
		this.add(changbtn_label);

		changbtn_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					addNotice(search.getText());
					JOptionPane.showMessageDialog(null, "변경사항이 적용되었습니다!");
					dispose();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		ImageIcon backicon = new ImageIcon("img//upload_notice.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

public class edit_post {
	public static void main(String[] args) {
		new notice_edit_UI();
	}
}
