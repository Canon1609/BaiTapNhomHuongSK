package gui_Form;

import dao.*;
import entity.*;
import model.KHTableModel;
import model.LoaiXeTableModel;
import model.PhieuNhapModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhap_Form extends JPanel {
    JComboBox<String> cbcML;
    DAO_CT_PhieuNhap ctpnDao;
    DAO_PhieuNhap pnDao;
    JPanel pnHienThi;
    LoaiXe_Form lxF;
    DAO_NhaCC nccDao;
    DAO_NhanVien nvDao;
    GD_Chinh gd;
    DAO_LoaiXe lxDao;
    JTable table;
    LoaiXeTableModel tableModel;
    LoaiXe_Form lx;
    JButton btnThem,btnXoa,btnSua,btnHuy,btnIn,btnThoat,btnNhap;
    JLabel lblMaPN,lblMaNCC,lblMaNV,lblNgayNhap,lblMaLoai,lblThue;
    JTextField txtMaPN,txtThue,txtNgayNhap;
    JComboBox<String> cbcMaNV,cbcMaNCC;
    public PhieuNhap_Form(){
        doShow();
    }
    public void doShow(){
        this.setLayout(new BorderLayout());
        //Tiêu đề
        JPanel pnNorth = new JPanel();
        pnNorth.setPreferredSize(new Dimension(1000,50));
        JLabel lblTieuDe = new JLabel("NHẬP HÀNG");
        lblTieuDe.setFont(new Font("Arial",Font.BOLD,25));
        lblTieuDe.setForeground(Color.BLUE);
        pnNorth.add(lblTieuDe);

        //Center
        JPanel pnCenter = new JPanel();
        pnCenter.setPreferredSize(new Dimension(1000,520));
        pnCenter.setBorder(new TitledBorder("Chọn tác vụ:"));
        JPanel pnPNhap = new JPanel();
        pnPNhap.setBorder(new TitledBorder("Phiếu Nhập"));
        pnPNhap.setPreferredSize(new Dimension(950,170));
        Box b1,b11,b12,b13;
        b1 = Box.createVerticalBox();
        b1.add(Box.createVerticalStrut(10));
        b1.setPreferredSize(new Dimension(900,150));
        b1.add(b11 = Box.createHorizontalBox());
        b11.add(lblMaPN = new JLabel("Mã Phiếu Nhập:"));
        b11.add(txtMaPN = new JTextField());
        b11.add(Box.createHorizontalStrut(20));
        b11.add(lblMaNCC = new JLabel("Mã Nhà CC:"));
        cbcMaNCC = new JComboBox<>();
        nccDao = new DAO_NhaCC();
        for(NhaCungCap ncc : nccDao.getLS()){
            System.out.println(ncc.getMaNCC());
            cbcMaNCC.addItem(ncc.getMaNCC());}
        cbcMaNCC.setPreferredSize(new Dimension(400,20));
        b11.add(cbcMaNCC);
        b1.add(Box.createVerticalStrut(20));
        b1.add(b12 = Box.createHorizontalBox());
        b12.add(lblNgayNhap = new JLabel("Ngày Nhập:"));
        b12.add(txtNgayNhap = new JTextField("YYYY-MM-DD"));
        txtNgayNhap.setForeground(Color.GRAY);
        txtNgayNhap.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtNgayNhap.getText().equals("YYYY-MM-DD")) {
                    txtNgayNhap.setText("");
                    txtNgayNhap.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtNgayNhap.getText().isEmpty()) {
                    txtNgayNhap.setForeground(Color.GRAY);
                    txtNgayNhap.setText("YYYY-MM-DD");
                }
            }
        });
        b12.add(Box.createHorizontalStrut(20));
        b12.add(lblMaNV = new JLabel("Mã Nhân Viên:"));
        cbcMaNV = new JComboBox<>();
        nvDao = new DAO_NhanVien();
        for(NhanVien nv : nvDao.getLS()){
            System.out.println(nv.getMaNV());
            cbcMaNV.addItem(nv.getMaNV());}
        cbcMaNV.setPreferredSize(new Dimension(400,20));
        b12.add(cbcMaNV);
        b1.add(Box.createVerticalStrut(10));
        b1.add(b13 = Box.createHorizontalBox());
        b13.add(btnNhap = new JButton("Nhập Hàng"));
        btnNhap.setFont(new Font("Arial",Font.BOLD,17));
        btnNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nhapHang.png")));
        btnNhap.setForeground(Color.WHITE);
        btnNhap.setBackground(Color.GREEN);
        b1.add(Box.createVerticalStrut(15));
        pnPNhap.add(b1);



        JPanel pnCTPNhap = new JPanel();
        pnCTPNhap.setBorder(new TitledBorder("CT - Phiếu Nhập"));
        pnCTPNhap.setPreferredSize(new Dimension(950,80));
        Box b2,b21,b22;
        b2 = Box.createVerticalBox();
        b2.setPreferredSize(new Dimension(900,60));
        b2.add(Box.createVerticalStrut(10));
        b2.add(b21 = Box.createHorizontalBox());

        b21.add(lblMaLoai = new JLabel("Mã Loại: "));
        cbcML = new JComboBox<String>();
        lxDao = new DAO_LoaiXe();
        for(LoaiXe lx : lxDao.getLS()){
            System.out.println(lx.getMaLoai());
            cbcML.addItem(lx.getMaLoai());
        }
        cbcML.setPreferredSize(new Dimension(310,20));
        b21.add(cbcML);
        cbcML.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cbcML.removeAllItems();;
                lxDao = new DAO_LoaiXe();
                for(LoaiXe lx : lxDao.getLS()){
                    System.out.println(lx.getMaLoai());
                    cbcML.addItem(lx.getMaLoai());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        b21.add(Box.createHorizontalStrut(20));
        b21.add(lblThue = new JLabel("Thuế: "));
        b21.add(txtThue = new JTextField());
        txtThue.setPreferredSize(new Dimension(110,20));
        b2.add(Box.createVerticalStrut(20));
        pnCTPNhap.add(b2);

        pnHienThi = new JPanel();
        pnHienThi.setPreferredSize(new Dimension(950,200));
        pnHienThi.setBorder(new TitledBorder("Thông Tin Loại Xe Nhập"));
        lxDao = new DAO_LoaiXe();
        table = new JTable();
        List<LoaiXe> ls;
        ls = new ArrayList<>();
        tableModel = new LoaiXeTableModel(ls);
        table.setModel(tableModel);
        JScrollPane sc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sc.setPreferredSize(new Dimension(900,150));
        pnHienThi.add(sc);



        pnCenter.add(pnPNhap);
        pnCenter.add(pnCTPNhap);
        pnCenter.add(pnHienThi);
        btnNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lx = new LoaiXe_Form();
                lx.setVisible(true);
            }
        });
        //Chức vụ
        JPanel pnSouth  = new JPanel();
        Box bcv = Box.createHorizontalBox();
        pnSouth.add(bcv);
        pnSouth.setPreferredSize(new Dimension(1000,70));
        pnSouth.setBorder(new TitledBorder("Chọn tác vụ:"));
        bcv.add(btnThem = new JButton("Tạo Phiếu Nhập"));
        btnThem.setFont(new Font("Arial",Font.BOLD,17));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/them.png")));
//        bcv.add(Box.createHorizontalStrut(50));
//        bcv.add(btnXoa = new JButton("Xóa"));
//        btnXoa.setFont(new Font("Arial",Font.BOLD,17));
//        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xoa.png")));
//        bcv.add(Box.createHorizontalStrut(50));
//        bcv.add(btnSua = new JButton("Sửa"));
//        btnSua.setFont(new Font("Arial",Font.BOLD,17));
//        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sua.png")));
        bcv.add(Box.createHorizontalStrut(50));
        bcv.add(btnHuy = new JButton("Xóa Rỗng"));
        btnHuy.setFont(new Font("Arial",Font.BOLD,17));
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/huy.png")));
        bcv.add(Box.createHorizontalStrut(50));
        bcv.add(btnIn = new JButton("In Hóa Đơn"));
        btnIn.setFont(new Font("Arial",Font.BOLD,17));
        btnIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inHoaDon.png")));
        bcv.add(Box.createHorizontalStrut(50));
        bcv.add(btnThoat = new JButton("Thoát"));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png")));
        btnThoat.setBackground(Color.RED);
        btnThoat.setFont(new Font("Arial",Font.CENTER_BASELINE,17));
        btnThoat.setForeground(Color.WHITE);
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                //pn =new TrangChu();
                gd = new GD_Chinh();
                gd.trangChu();
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(valid())
            	{
                    pnDao = new DAO_PhieuNhap();
                    ctpnDao = new DAO_CT_PhieuNhap();
                    if(!txtMaPN.getText().equals("")){
                        try {
                            boolean kq = kt();
                            if(kq == true) {
                                JOptionPane.showMessageDialog(null, "Mã phiếu nhập đã tồn tại!");
                            }else if(kq == false){
                                if(!txtNgayNhap.getText().equals("YYYY-MM-DD")) {
                                    if (!txtThue.getText().equals("")) {
                                        PhieuNhap pn = taoPhieuNhap();
                                        CT_PhieuNhap ct = tao_CT_PhieuNhap();
                                        System.out.println(pn);
                                        System.out.println(ct);
                                        if (pnDao.addPhieuNhap(pn) && ctpnDao.addCTPhieuNhap(ct)) {
                                            lxDao = new DAO_LoaiXe();
                                            table.setModel(new LoaiXeTableModel(lxDao.TimKiem(cbcML.getSelectedItem().toString())));

                                        }
                                    } else
                                        JOptionPane.showMessageDialog(null, "Bạn Chưa Nhập Giá Trị Thuế!");
                                }else
                                    JOptionPane.showMessageDialog(null,"Bạn Chưa Nhập Ngày!");
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }else
                        JOptionPane.showMessageDialog(null,"Bạn chưa nhập thông tin!");
            	}
            }
        });
        btnIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Form_HD_NhapHang hdnh = new Form_HD_NhapHang();
                hdnh.setVisible(true);
            }
        });
        btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaRong();
				txtMaPN.requestFocus();
				
			}
		});
//        btnXoa.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int row = table.getSelectedRow();
//				if(row!=-1) {
//					int tb = JOptionPane.showConfirmDialog(null,"Bạn chắc chắn muốn xóa dòng này?","Delete",
//                            JOptionPane.YES_NO_OPTION);
//					if(tb == JOptionPane.YES_OPTION) {
//                        String maLoai = tableModel.getValueAt(row, 1).toString();
//                        if (lxDao.deleteXe(maLoai)) {
//                            try {
//                            	table.setModel(new LoaiXeTableModel(lxDao.getLS()));
//                            } catch (Exception ex) {
//                                ex.printStackTrace();
//                            }
//                        }
//                        xoaRong();
//                    }
//				}else {
//                    JOptionPane.showMessageDialog(null,"Bạn chưa chọn dòng cần xóa!");
//
//				}
//				
//			}
//		});

        lblMaLoai.setPreferredSize(lblMaPN.getPreferredSize());
        lblMaNCC.setPreferredSize(lblMaNV.getPreferredSize());
        lblThue.setPreferredSize(lblMaLoai.getPreferredSize());
        lblNgayNhap.setPreferredSize(lblMaPN.getPreferredSize());
        this.add(pnSouth,BorderLayout.SOUTH);
        this.add(pnCenter,BorderLayout.CENTER);
        this.add(pnNorth,BorderLayout.NORTH);
    }
    private void xoaRong() {
    	txtMaPN.setText("");
    	txtNgayNhap.setText("");
    	txtThue.setText("");
    	cbcMaNCC.setSelectedItem("NCC01");
    	cbcMaNV.setSelectedItem("NV01");
    	cbcML.setSelectedItem("LX01");
    }
    public void taoTable(){
        List<LoaiXe> ds = new ArrayList<>();
        lxF = new LoaiXe_Form();
        ds.add(lxF.taoLoaiXe());
        tableModel = new LoaiXeTableModel(ds);
        table.setModel(tableModel);
    }
    public PhieuNhap taoPhieuNhap(){
        String ma = txtMaPN.getText();
        NhaCungCap ncc = new NhaCungCap(cbcMaNCC.getSelectedItem().toString());
        NhanVien nv = new NhanVien(cbcMaNV.getSelectedItem().toString());
        String ngay = txtNgayNhap.getText();
        PhieuNhap pn = new PhieuNhap(ma,ngay);
        pn.setNhaCC(ncc);
        pn.setNhanVien(nv);
        return pn;
    }
    public CT_PhieuNhap tao_CT_PhieuNhap(){
        Double thue = Double.parseDouble(txtThue.getText());
        LoaiXe lx = new LoaiXe(cbcML.getSelectedItem().toString());
        PhieuNhap pn = new PhieuNhap(txtMaPN.getText());
        CT_PhieuNhap ct = new CT_PhieuNhap(thue);
        ct.setLoaiXe(lx);
        ct.setpNhap(pn);
        return ct;
    }
    public boolean kt() throws Exception {
        for(PhieuNhap pnq : pnDao.getLS()) {
            if(txtMaPN.getText().equals(pnq.getMaPN()));
                return true;
        }
        return false;
    }
    
    public boolean valid() {
    	if(txtMaPN.getText().equals("") || txtNgayNhap.getText().equals("") ||txtThue.getText().equals("")) 
    	{
    		JOptionPane.showMessageDialog(null, "Không được rỗng");
    		return false;
    	}
    	if(!(txtMaPN.getText().matches("PN\\d+"))) {
    		JOptionPane.showMessageDialog(null, "Mã theo mẫu : PN01");
    		txtMaPN.requestFocus();
    		return false;
    	}
    	if(!(txtNgayNhap.getText().matches("^([0-9]{4})-([0-9]{2})-([0-9]{2})$"))) {
    		JOptionPane.showMessageDialog(null, "Ngày nhập  phải theo mẫu: YYYY-MM-DD");
    		txtNgayNhap.requestFocus();
    		return false;
    	}
    	double thue = Double.parseDouble(txtThue.getText());
    	if(thue <=0)
    	{
    		JOptionPane.showMessageDialog(null,"Thuế phải lớn hơn 0");
    		txtThue.requestFocus();
    		return false;
    	}
    	return true;
    }
}
