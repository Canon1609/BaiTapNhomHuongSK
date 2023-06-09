package gui_Form;

import javax.swing.*;

import dao.DAO_Login;
import entity.Login;
import entity.XeMay;

import java.awt.*;
import java.awt.event.*;

public class Login_gui extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DAO_Login lgDao;
    JLabel lblUser,lblPass,lbFG,lbCR,lbDK;
    JCheckBox cbk;
    JTextField txtUser;
    JPasswordField txtPass;
    JButton btnDn,btnHelp,btnThoat,btnDK;
    public Login_gui(){
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Đăng Nhập");

        Container cp = getContentPane();
        cp.setBackground(Color.gray);
        JPanel pnNorth = new JPanel();
        JLabel lblTieuDe = new JLabel("ĐĂNG NHẬP");
        lblTieuDe.setFont(new Font("Arial", 1, 30)); 
        lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
        lblTieuDe.setForeground(new Color(255, 0, 204));
        pnNorth.add(lblTieuDe);

        JPanel pnCenter = new JPanel();
        Box b,bTD,b1,b2,b3,b4,b5;
        b = Box.createVerticalBox();
        b.add(bTD = Box.createHorizontalBox());
        bTD.add(pnNorth);
        b.add(Box.createVerticalStrut(20));
        b.add(b1 = Box.createHorizontalBox());
        b.setPreferredSize(new Dimension(450,300));
        Font ft = new Font("Arial",Font.BOLD,13);
        Font ft1 = new Font("Arial",Font.ITALIC,13);
        b1.add(lblUser = new JLabel("UserName: "));
        lblUser.setFont(ft);
        b1.add(txtUser = new JTextField());


        txtUser.setFont(ft1);
        b.add(Box.createVerticalStrut(30));

        b.add(b2 = Box.createHorizontalBox());
        b2.add(lblPass = new JLabel("Password: "));
        lblPass.setFont(ft);
        b2.add(txtPass = new JPasswordField());
        System.out.println(txtPass.getPassword());
        txtPass.setFont(ft1);
        System.out.println(txtPass.getPassword());

        b.add(Box.createVerticalStrut(5));

        b.add(b4 = Box.createHorizontalBox());
        b4.add(Box.createHorizontalStrut(70));

        b.add(Box.createVerticalStrut(10));
        b.add(b3 = Box.createHorizontalBox());
        b3.add(Box.createHorizontalStrut(20));
        b3.add(btnDn = new JButton("ĐĂNG NHẬP"));
        btnDn.setIcon(new ImageIcon(getClass().getResource("/images/login2.png")));
        btnDn.setFont(new Font("Arial",Font.BOLD,12));

        b3.add(Box.createHorizontalStrut(7));
        b3.add(btnThoat = new JButton("THOÁT"));
        btnThoat.setIcon(new ImageIcon(getClass().getResource("/images/exit1.png")));
        btnThoat.setFont(new Font("Arial",Font.BOLD,12));
        btnThoat.setMnemonic(KeyEvent.VK_E);
        btnThoat.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        b.add(Box.createVerticalStrut(30));
        b.add(b5 = Box.createHorizontalBox());
        b5.add(lbDK = new JLabel("TẠO TÀI KHOẢN MỚI --> "));
        lbDK.setForeground(Color.MAGENTA);
        lbDK.setFont(new Font("Arial",Font.BOLD,16));
        b5.add(btnDK = new JButton("TẠO TÀI KHOẢN"));
        btnDK.setFont(new Font("Arial",Font.BOLD,16));
        btnDK.setForeground(Color.WHITE);
        btnDK.setBackground(Color.pink);
        btnDK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DangKyTK dk = new DangKyTK();
                dk.setVisible(true);
                setVisible(false);
            }
        });
        pnCenter.add(b);
        cp.add(pnCenter,BorderLayout.CENTER);
        lgDao = new DAO_Login();
        lblPass.setPreferredSize(lblUser.getPreferredSize());
        btnDn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int d = lgDao.TimKiem(txtUser.getText(), txtPass.getText()).toArray().length;
                System.out.println(d);
                if(!txtUser.getText().equals("") && !txtPass.getPassword().equals("")) {
                    System.out.println(txtPass.getText());
                    System.out.println(lgDao.TimKiem(txtUser.getText(), txtPass.getText()));
                    if (lgDao.TimKiem(txtUser.getText(), txtPass.getText()) != null) {
                        if(lgDao.TimKiem(txtUser.getText(), txtPass.getText()).toArray().length == 0) {
                            JOptionPane.showMessageDialog(null, "Thông tin tài khoản, mật khẩu không chính xác");
                            txtUser.setText("");
                            txtPass.setText("");
                            txtUser.requestFocus();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Đăng nhập hệ thống thành công");
                            GD_Chinh test = new GD_Chinh();
                            test.setVisible(true);
                            setVisible(false);
                        }
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");

            }
        });
    }

    public static void main(String[] args) {
        Login_gui lg = new Login_gui();
        lg.setVisible(true);
    }

}
