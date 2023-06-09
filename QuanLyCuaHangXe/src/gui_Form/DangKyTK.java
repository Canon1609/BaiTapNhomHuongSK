package gui_Form;

import dao.DAO_Login;
import entity.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class DangKyTK extends JFrame {
    DAO_Login lgDao;
    JLabel lbHo,lbTen,lbTK,lbMail,lbGT,lbPass,lbXN;
    JTextField txtHo,txtTen,txtTaiKhoan,txtMail,txtKq,txtTb1,txtTb2;
    JPasswordField txtPass,txtXacNhan;
    JLabel lblKq,lbTieuDe;
    JButton btnDangKy,btnQL;
    JComboBox<String> cbc;
    public DangKyTK(){
        setSize(700,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Đăng Ký Tài Khoản");

        Container cp = getContentPane();
        JPanel pnNorth = new JPanel();
        pnNorth.add(lbTieuDe = new JLabel("ĐĂNG KÝ TÀI KHOẢN"));
        lbTieuDe.setFont(new Font("Arial",Font.BOLD,18));
        lbTieuDe.setForeground(Color.RED);
        JPanel pnCenter = new JPanel();
        Box b,b1,b2,b3,b4,b5,b6,b7;
        b = Box.createVerticalBox();
        b.setPreferredSize(new Dimension(500,250));
        b.add(b1 = Box.createHorizontalBox());
        b1.add(lbHo = new JLabel("Họ:"));
        b1.add(txtHo = new JTextField("Họ"));
        txtHo.setForeground(Color.GRAY);
        txtHo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtHo.getText().equals("Họ")) {
                    txtHo.setText("");
                    txtHo.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtHo.getText().isEmpty()) {
                    txtHo.setForeground(Color.GRAY);
                    txtHo.setText("Họ");
                }
            }
        });
        b1.add(Box.createHorizontalStrut(20));
        b1.add(lbTen = new JLabel("Tên:"));
        lbTen.setHorizontalAlignment(JLabel.CENTER);
        b1.add(txtTen = new JTextField("Tên"));
        txtTen.setForeground(Color.GRAY);
        txtTen.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTen.getText().equals("Tên")) {
                    txtTen.setText("");
                    txtTen.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtTen.getText().isEmpty()) {
                    txtTen.setForeground(Color.GRAY);
                    txtTen.setText("Tên");
                }
            }
        });
        b.add(Box.createVerticalStrut(15));

        b.add(b2 = Box.createHorizontalBox());
        b2.add(lbTK = new JLabel("Tài Khoản:"));
        b2.add(txtTaiKhoan = new JTextField("Tài khoản"));
        txtTaiKhoan.setForeground(Color.GRAY);
        txtTaiKhoan.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTaiKhoan.getText().equals("Tài khoản")) {
                    txtTaiKhoan.setText("");
                    txtTaiKhoan.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtTaiKhoan.getText().isEmpty()) {
                    txtTaiKhoan.setForeground(Color.GRAY);
                    txtTaiKhoan.setText("Tài khoản");
                }
            }
        });
        b2.add(Box.createHorizontalStrut(20));
        b2.add(lbMail = new JLabel("EMail:"));
        b2.add(txtMail = new JTextField("Địa chỉ"));
        txtMail.setHorizontalAlignment(JLabel.LEFT);
        txtMail.setForeground(Color.GRAY);
        txtMail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtMail.getText().equals("Địa chỉ")) {
                    txtMail.setText("");
                    txtMail.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtMail.getText().isEmpty()) {
                    txtMail.setForeground(Color.GRAY);
                    txtMail.setText("Địa chỉ");
                }
            }
        });
        b.add(Box.createVerticalStrut(15));


        b.add(b3 = Box.createHorizontalBox());
        b3.add(lbPass = new JLabel("Mật Khẩu: "));
        b2.add(Box.createHorizontalStrut(5));
        b3.add(txtPass = new JPasswordField());
        b3.add(Box.createHorizontalStrut(20));
        b3.add(lbXN = new JLabel("Xác Nhận:   "));
        b3.add(txtXacNhan = new JPasswordField());
        //b.add(Box.createVerticalStrut(15));

        b.add(b6 = Box.createHorizontalBox());
        b6.add(Box.createHorizontalStrut(60));
        b6.add(txtTb1 = new JTextField());

        txtTb1.setBorder(null);
        txtTb1.setEditable(false);
        txtTb1.setForeground(Color.RED);
        txtTb1.setFont(new Font("Arial",Font.ITALIC,12));

        b.add(b4 = Box.createHorizontalBox());

        b4.add(lbGT = new JLabel("Giới Tính: "));
        b4.add(cbc = new JComboBox<String>());
        cbc.addItem("Nam");
        cbc.addItem("Nữ");
        b.add(Box.createVerticalStrut(15));


        b.add(b5 = Box.createHorizontalBox());
        b5.add(lblKq = new JLabel("6 + 7 ="));
        b5.add(txtKq = new JTextField("Nhập kết quả"));
        txtKq.setForeground(Color.GRAY);
        txtKq.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtKq.getText().equals("Nhập kết quả")) {
                    txtKq.setText("");
                    txtKq.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtKq.getText().isEmpty()) {
                    txtKq.setForeground(Color.GRAY);
                    txtKq.setText("Nhập kết quả");
                }
            }
        });
        b.add(b7 = Box.createHorizontalBox());
        b7.add(Box.createHorizontalStrut(60));
        b7.add(txtTb2 = new JTextField());

        txtTb2.setBorder(null);
        txtTb2.setEditable(false);
        txtTb2.setForeground(Color.RED);
        txtTb2.setFont(new Font("Arial",Font.ITALIC,12));
        //txtTb2.setText("Sai");
        b.add(Box.createVerticalStrut(10));


        JPanel pnSouth = new JPanel();
        pnSouth.add(btnDangKy = new JButton("Đăng Ký Ngay"));
        pnSouth.add(btnQL = new JButton("Quay Lại"));
        btnQL.setFont(new Font("Arial",Font.BOLD,17));
        btnQL.setForeground(Color.WHITE);
        btnQL.setBackground(Color.blue);
        btnQL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui_Form.Login_gui lg = new gui_Form.Login_gui();
                lg.setVisible(true);
                setVisible(false);
            }
        });

        btnDangKy.setFont(new Font("Arial",Font.BOLD,17));
        btnDangKy.setForeground(Color.WHITE);
        btnDangKy.setBackground(Color.ORANGE);
        
        lgDao = new DAO_Login();
        btnDangKy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
				boolean kq = kt();
				if(kq==true) {
					JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại");
				}else {
					 if(valid()){
		                    if(txtPass.getText().equals(txtXacNhan.getText())) {
		                        if(Integer.parseInt(txtKq.getText())==13) {
		                            txtTb2.setText("Tạo tài khoản thành công!");
		                            entity.Login lg = new Login(txtHo.getText().trim(), txtTen.getText().trim(),
		                                    txtTaiKhoan.getText().trim(),
		                                    txtMail.getText().trim(),
		                                    txtPass.getText(),
		                                    cbc.getSelectedItem().toString());
		                            lgDao = new DAO_Login();
		                            lgDao.addLogin(lg);
		                        }else{
		                            txtTb2.setText("Kết quả không chính xác!");
		                        }
		                    }else {
		                        txtTb1.setText("Mật khẩu không khớp!");
		                    }
		                }
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
               
            }
        });
        pnSouth.setPreferredSize(new Dimension(0,80));
        pnCenter.add(b);
        cp.add(pnNorth,BorderLayout.NORTH);
        cp.add(pnCenter,BorderLayout.CENTER);
        cp.add(pnSouth,BorderLayout.SOUTH);

        txtTaiKhoan.setPreferredSize(txtHo.getPreferredSize());
        txtMail.setPreferredSize(txtXacNhan.getPreferredSize());
        txtTen.setPreferredSize(txtXacNhan.getPreferredSize());
        lbHo.setPreferredSize(lbTK.getPreferredSize());
        lbMail.setPreferredSize(lbXN.getPreferredSize());
        lbTen.setPreferredSize(lbXN.getPreferredSize());
        lbGT.setPreferredSize(lbTK.getPreferredSize());
        lblKq.setPreferredSize(lbTK.getPreferredSize());
        txtPass.setPreferredSize(txtHo.getPreferredSize());
    }
    public boolean valid() {
    	if(txtHo.getText().equals("") || txtTen.getText().equals("") 
    			|| txtTaiKhoan.getText().equals("")||txtMail.getText().equals("")||txtPass.getText().equals("")||txtXacNhan.getText().equals("")) {
    		JOptionPane.showMessageDialog(null, "Không được rỗng");
    		txtHo.requestFocus();
    		return false;
    	}
    	if(!(txtHo.getText().matches("[A-Z]{1}[a-z]+"))) {
    		JOptionPane.showMessageDialog(null, "Họ theo mẫu : Nguyen");
    		txtHo.requestFocus();
    		return false;
    	}
    	if(!(txtTen.getText().matches("[A-Z]{1}[a-z]+"))) {
    		JOptionPane.showMessageDialog(null, "Tên theo mẫu: Huy");
    		txtTen.requestFocus();
    		return false;
    	}
    	if(!(txtMail.getText().matches("[a-z]+[0-9]*@gmail\\.com"))) {
    		JOptionPane.showMessageDialog(null, "Mail theo mẫu : huy123@gmail.com");
    		return false;
    	}
    	if(!(txtTaiKhoan.getText().matches("^[a-zA-Z0-9]*$"))) {
    		JOptionPane.showMessageDialog(null, "Tài khoản theo mẫu: huy123");
    		txtTaiKhoan.requestFocus();
    		return false;
    	}
    	if(!(txtXacNhan.getText().equals(txtPass.getText()))) {
    		JOptionPane.showMessageDialog(null, "Xác nhận mật khẩu không đúng");
    		txtXacNhan.requestFocus();
    		return false;
    	}
    	if((txtKq.getText().equals(""))) {
    		JOptionPane.showMessageDialog(null, "Bạn chưa nhập kết quả");
    		txtKq.requestFocus();
    		return false;
    	}
    	
    	return true;
    }

    public static void main(String[] args) {
        DangKyTK dk = new DangKyTK();
        dk.setVisible(true);

    }
    public boolean kt() throws Exception {
        for(Login lg : lgDao.getLS()) {
            if(txtTaiKhoan.getText().equals(lg.getTaiKhoan()))
                return true;
        }
        return false;
    }
}
