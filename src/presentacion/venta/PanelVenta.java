package presentacion.venta;

import javax.swing.*;

import business.sale.TransferCart;
import business.sale.TransferLifeLine;
import business.sale.TransferSale;
import dao.transations.connection.Exceptions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import presentacion.comando.IDEventos;
import presentacion.controlador.Controlador;

import java.sql.Date;

public class PanelVenta extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Object VACIO = null;
	private TransferSale vtr;
	private TransferCart crtr;
	
	private JButton abrirV;
    private JButton anadirProd;
    private JButton eliminarProd;
    private JButton cerrarV;
    private JButton devolucion;

    private JLabel jLabel62;
    private JLabel jLabel63;
    private JLabel jLabel64;
    private JLabel jLabel65;
    private JLabel jLabel66;
    private JLabel jLabel67;
    private JLabel jLabel68;
    private JLabel jLabel69;
    private JLabel jLabel70;
    private JLabel jLabel71;
    private JLabel jLabel72;
    private JLabel jLabel73;
    private JLabel jLabel74;
    private JLabel jLabel75;
    private JLabel jLabel77;
    private JLabel jLabel79;
    private JLabel jLabel80;
    private JLabel jLabel81;
    private JList<Integer> jList19;
    private JList<Integer> jList20;
    private JList<Integer> jList22;
    private JList<Integer> jList23;
    private JList<Float> jList25;
    private JList<Date> jList26;

    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane20;
    private JScrollPane jScrollPane22;
    private JScrollPane jScrollPane23;
    private JScrollPane jScrollPane25;
    private JScrollPane jScrollPane26;
    private JSeparator jSeparator10;
    private JSeparator jSeparator11;
    private JSeparator jSeparator8;
    private JSeparator jSeparator9;
    private JTabbedPane jTabbedPane3;
    private JTextField cantidadV;
    private JTextField totalVV;
    private JTextField fechaV;
    private JTextField idVDev;
    private JTextField idPDev;
    private JTextField cantidadDev;
    private JTextField idVC;
    private JTextField idCC;
    private JTextField totalVC;
    private JTextField fechaC;
    private JTextField idCV;
    private JTextField idPV;
    private JButton listar;
    private JPanel venta;
	private JButton consultarUn;
	
	
	 //Listas venta
    private Integer[] listIDProdVenta;
    private Integer[] listCantidadVenta;
    
    //Listas listar
    private Integer[] listIDVentaListar;
    private Integer[] listIDClienteListar;
    private Float[] listTotalVentaListar;
    private Date[] listFechaListar;
	
	
	public PanelVenta() {
		crtr = new TransferCart();
		initGUI();
	}
	
	private void initGUI() {
		
		venta = new JPanel();
	    jTabbedPane3 = new JTabbedPane();
	    jPanel8 = new JPanel();
	    jLabel62 = new JLabel();
	    idCV = new JTextField();
	    abrirV = new JButton();
	    jSeparator8 = new JSeparator();
	    jLabel63 = new JLabel();
	    idPV = new JTextField();
	    jLabel64 = new JLabel();
	    cantidadV = new JTextField();
	    anadirProd = new JButton();
	    eliminarProd = new JButton();
	    jScrollPane1 = new JScrollPane();
	    jList19 = new JList<Integer>();
	    jScrollPane20 = new JScrollPane();
	    jList20 = new JList<Integer>();
	    jLabel65 = new JLabel();
	    jLabel66 = new JLabel();
	    jSeparator9 = new JSeparator();
	    jLabel67 = new JLabel();
	    totalVV = new JTextField();
	    cerrarV = new JButton();
	    jLabel68 = new JLabel();
	    fechaV = new JTextField();
	    jPanel9 = new JPanel();
	    jLabel69 = new JLabel();
	    idVDev = new JTextField();
	    jLabel70 = new JLabel();
	    idPDev = new JTextField();
	    jLabel71 = new JLabel();
	    cantidadDev = new JTextField();
	    devolucion = new JButton();
	    jPanel10 = new JPanel();
	    jLabel72 = new JLabel();
	    idVC = new JTextField();
	    jLabel73 = new JLabel();
	    idCC = new JTextField();
	    jSeparator10 = new JSeparator();
	    jLabel74 = new JLabel();
	    totalVC = new JTextField();
	    jLabel75 = new JLabel();
	    fechaC = new JTextField();
	    consultarUn = new JButton();
	    jPanel11 = new JPanel();
	    jLabel77 = new JLabel();
	    jScrollPane22 = new JScrollPane();
	    jList22 = new JList<Integer>();
	    jScrollPane23 = new JScrollPane();
	    jList23 = new JList<Integer>();
	    jLabel79 = new JLabel();
	    jLabel80 = new JLabel();
	    jScrollPane25 = new JScrollPane();
	    jList25 = new JList<Float>();
	    listar = new JButton();
	    jScrollPane26 = new JScrollPane();
	    jList26 = new JList<Date>();
	    jLabel81 = new JLabel();
	    jSeparator11 = new JSeparator();
		
	    listIDProdVenta = new Integer[10];
        listCantidadVenta = new Integer[10];
	     
	     jLabel62.setText("ID Cliente: ");
	
	     abrirV.setText("Abrir Venta");
	     abrirV.addActionListener(this);
	
	     jLabel63.setText("ID Producto: ");
	
	     jLabel64.setText("Cantidad: ");
	
	     eliminarProd.setText("Eliminar");
	     eliminarProd.addActionListener(this);
	    
	     anadirProd.setText("Anadir");
	     anadirProd.addActionListener(this);
	    
	
	   
	     jScrollPane1.setViewportView(jList19);
	
	 
	     jScrollPane20.setViewportView(jList20);
	
	     jLabel65.setText("ID Producto");
	
	     jLabel66.setText("Cantidad");
	
	     jLabel67.setText("Total Venta: ");
	
	     cerrarV.setText("Cerrar Venta");
	     cerrarV.addActionListener(this);
	
	     jLabel68.setText("Fecha: ");
	
	     GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
	     jPanel8.setLayout(jPanel8Layout);
	     jPanel8Layout.setHorizontalGroup(
	         jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel8Layout.createSequentialGroup()
	             .addGap(35, 35, 35)
	             .addComponent(jLabel62)
	             .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	             .addComponent(idCV, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
	             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	             .addComponent(abrirV)
	             .addGap(47, 47, 47))
	         .addGroup(jPanel8Layout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(jSeparator8)
	             .addContainerGap())
	         .addGroup(jPanel8Layout.createSequentialGroup()
	             .addGap(35, 35, 35)
	             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                 .addGroup(jPanel8Layout.createSequentialGroup()
	                     .addComponent(anadirProd)
	                     .addGap(30, 30, 30)
	                     .addComponent(eliminarProd))
	                 .addGroup(jPanel8Layout.createSequentialGroup()
	                     .addComponent(jLabel64)
	                     .addGap(30, 30, 30)
	                     .addComponent(cantidadV, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
	                 .addGroup(jPanel8Layout.createSequentialGroup()
	                     .addComponent(jLabel63)
	                     .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                     .addComponent(idPV, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
	                     .addGap(100, 100, 100)
	             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                 .addComponent(jLabel65, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                 .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
	             .addGap(34, 34, 34)
	             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                 .addComponent(jLabel66, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                 .addComponent(jScrollPane20, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	             .addGap(60, 60, 60)))

	         .addGroup(jPanel8Layout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(jSeparator9)
	             .addContainerGap())
	         .addGroup(jPanel8Layout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(jLabel67)
	             .addGap(18, 18, 18)
	             .addComponent(totalVV, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
	             .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	         .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(jLabel68)
	             .addGap(18, 18, 18)
	             .addComponent(fechaV, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	             .addComponent(cerrarV)
	             .addGap(46, 46, 46))
	     );
	     jPanel8Layout.setVerticalGroup(
	         jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel8Layout.createSequentialGroup()
	             .addGap(29, 29, 29)
	             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel62)
	                 .addComponent(idCV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                 .addComponent(abrirV))
	             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                 .addGroup(jPanel8Layout.createSequentialGroup()
	                     .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                     .addComponent(jSeparator8, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
	                     .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                         .addGroup(jPanel8Layout.createSequentialGroup()
	                             .addGap(27, 27, 27)
	                             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                                 .addComponent(jLabel63)
	                                 .addComponent(idPV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                             .addGap(30, 30, 30)
	                             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                                 .addComponent(jLabel64)
	                                 .addComponent(cantidadV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                             .addGap(23, 23, 23)
	                             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                                 .addComponent(anadirProd)
	                                 .addComponent(eliminarProd)))
	                         .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
	                             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                             .addComponent(jScrollPane20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
	                 .addGroup(jPanel8Layout.createSequentialGroup()
	                     .addGap(42, 42, 42)
	                     .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                         .addComponent(jLabel65)
	                         .addComponent(jLabel66))
	                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                     .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	             .addGap(15, 15, 15)
	             .addComponent(jSeparator9, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
	             .addGap(18, 18, 18)
	             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel67)
	                 .addComponent(totalVV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	             .addGap(18, 18, 18)
	             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                 .addComponent(cerrarV)
	                 .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                     .addComponent(jLabel68)
	                     .addComponent(fechaV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	             .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	     );
	     
	     cantidadV.setEditable(false);
	     idPV.setEditable(false);
	     totalVV.setEditable(false);
	     fechaV.setEditable(false);
	     
	     jTabbedPane3.addTab("Venta", jPanel8);
	
	     jLabel69.setText("ID Venta: ");
	
	     jLabel70.setText("ID Producto: ");
	
	     jLabel71.setText("Cantidad: ");
	
	     devolucion.setText("Devolucion");
	     devolucion.addActionListener(this);
	
	     GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
	     jPanel9.setLayout(jPanel9Layout);
	     jPanel9Layout.setHorizontalGroup(
	         jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel9Layout.createSequentialGroup()
	             .addGap(30, 30, 30)
	             .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                 .addGroup(jPanel9Layout.createSequentialGroup()
	                     .addComponent(jLabel71)
	                     .addGap(43, 43, 43)
	                     .addComponent(cantidadDev, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
	                 .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
	                     .addGroup(jPanel9Layout.createSequentialGroup()
	                         .addComponent(jLabel70)
	                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                         .addComponent(idPDev, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
	                     .addGroup(jPanel9Layout.createSequentialGroup()
	                         .addComponent(jLabel69)
	                         .addGap(47, 47, 47)
	                         .addComponent(idVDev, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))))
	             .addGap(394, 394, 394))
	         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(devolucion)
	             .addGap(71, 71, 71))
	     );
	     jPanel9Layout.setVerticalGroup(
	         jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel9Layout.createSequentialGroup()
	             .addGap(41, 41, 41)
	             .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel69)
	                 .addComponent(idVDev, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	             .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	             .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel70)
	                 .addComponent(idPDev, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	             .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	             .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel71)
	                 .addComponent(cantidadDev, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
	             .addComponent(devolucion)
	             .addGap(63, 63, 63))
	     );
	
	     jTabbedPane3.addTab("Devolucion", jPanel9);
	
	     jLabel72.setText("ID Venta: ");
	
	     jLabel73.setText("ID Cliente: ");
	
	     jLabel74.setText("Total Venta:");
	
	     jLabel75.setText("Fecha: ");
	
	     consultarUn.setText("Consultar");
	     consultarUn.addActionListener(this);
	   
	     GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
	     jPanel10.setLayout(jPanel10Layout);
	     jPanel10Layout.setHorizontalGroup(
	         jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel10Layout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(jSeparator10)
	             .addContainerGap())
	         .addGroup(jPanel10Layout.createSequentialGroup()
	             .addGap(32, 32, 32)
	             .addComponent(jLabel72)
	             .addGap(18, 18, 18)
	             .addComponent(idVC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
	             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	             .addComponent(consultarUn)
	             .addGap(61, 61, 61))
	         .addGroup(jPanel10Layout.createSequentialGroup()
	             .addGap(27, 27, 27)
	             .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	                 .addGroup(GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
	                     .addComponent(jLabel75)
	                     .addGap(18, 18, 18)
	                     .addComponent(fechaC, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	                 .addGroup(jPanel10Layout.createSequentialGroup()
	                     .addComponent(jLabel73)
	                     .addGap(26, 26, 26)
	                     .addComponent(idCC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
	             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
	             .addComponent(jLabel74)
	             .addGap(26, 26, 26)
	             .addComponent(totalVC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
	             .addGap(70, 70, 70))
	     );
	     jPanel10Layout.setVerticalGroup(
	         jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel10Layout.createSequentialGroup()
	             .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                 .addGroup(jPanel10Layout.createSequentialGroup()
	                     .addGap(53, 53, 53)
	                     .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                         .addComponent(jLabel72)
	                         .addComponent(idVC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
	                     .addContainerGap()
	                     .addComponent(consultarUn)))
	             .addGap(18, 18, 18)
	             .addComponent(jSeparator10, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
	             .addGap(18, 18, 18)
	             .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel73)
	                 .addComponent(idCC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                 .addComponent(jLabel74)
	                 .addComponent(totalVC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	             .addGap(18, 18, 18)
	             .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel75)
	                 .addComponent(fechaC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	             .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	     );
	     
	     fechaC.setEditable(false);
	     idCC.setEditable(false);
	     totalVC.setEditable(false);
	     
	     jTabbedPane3.addTab("Consultar", jPanel10);
	
	     jLabel77.setText("ID Cliente");
	
	     
	     jScrollPane22.setViewportView(jList22);
	
	     
	     jScrollPane23.setViewportView(jList23);
	
	     jLabel79.setText("Fecha");
	
	     jLabel80.setText("ID Venta");
	
	     
	     jScrollPane25.setViewportView(jList25);
	
	     listar.setText("Listar");
	     listar.addActionListener(this);
	
	    
	     jScrollPane26.setViewportView(jList26);
	
	     jLabel81.setText("Total Venta");
	
	     GroupLayout jPanel11Layout = new GroupLayout(jPanel11);
	     jPanel11.setLayout(jPanel11Layout);
	     jPanel11Layout.setHorizontalGroup(
	         jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel11Layout.createSequentialGroup()
	             .addComponent(jSeparator11)
	             .addContainerGap())
	         .addGroup(jPanel11Layout.createSequentialGroup()
	             .addContainerGap()
	             .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                 .addGroup(jPanel11Layout.createSequentialGroup()
	                		 .addGap(100, 100, 100)
	                     .addComponent(jLabel77)
	                     .addGap(50, 50, 50)
	                     .addComponent(jLabel79)
	                     .addGap(69, 69, 69)
	                     .addComponent(jLabel80)
	                     .addGap(80, 80, 80)
	                     .addComponent(jLabel81)
	                     .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                 .addGroup(jPanel11Layout.createSequentialGroup()
	                		 .addGap(100, 100, 100)
	                     .addComponent(jScrollPane23, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
	                     .addGap(40, 40, 40)
	                     .addComponent(jScrollPane26, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	                     .addGap(26, 26, 26)
	                     .addComponent(jScrollPane22, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	                     .addGap(26, 26, 26)
	                     .addComponent(jScrollPane25, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	                     .addGap(77, 77, 77))
	                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
	                     .addGap(0, 0, Short.MAX_VALUE)
	                     .addComponent(listar))))
	     );
	     jPanel11Layout.setVerticalGroup(
	         jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel11Layout.createSequentialGroup()
	             .addContainerGap()
	             .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel77)
	                 .addComponent(jLabel79)
	                 .addComponent(jLabel80)
	                 .addComponent(jLabel81))
	             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	             .addComponent(jSeparator11, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
	             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	             .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                     .addComponent(jScrollPane22, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
	                     .addComponent(jScrollPane26, GroupLayout.Alignment.TRAILING)
	                     .addComponent(jScrollPane23, GroupLayout.Alignment.TRAILING))
	                 .addComponent(jScrollPane25, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE))
	             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	             .addComponent(listar)
	             .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	     );
	
	     jTabbedPane3.addTab("Listar", jPanel11);
	
	     GroupLayout ventaLayout = new GroupLayout(venta);
	     venta.setLayout(ventaLayout);
	     ventaLayout.setHorizontalGroup(
	         ventaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	         .addGroup(ventaLayout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(jTabbedPane3)
	             .addContainerGap())
	     );
	     ventaLayout.setVerticalGroup(
	         ventaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	         .addGroup(ventaLayout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(jTabbedPane3, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
	             .addContainerGap(16, Short.MAX_VALUE))
	     );
	
	     this.add(venta);
	}
	
	//ActionListener
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == abrirV) {				
				
				if(!idCV.getText().equals("")) {
					
					Controlador.getInstance().handleRequest(IDEventos.EVENTO_ABRIR_VENTA, Integer.parseInt(idCV.getText()));
					
				}
				else {
					JFrame frameError = new JFrame();
					JOptionPane.showMessageDialog(frameError, "Error de formato en los datos de entrada", "Error en abrir venta", JOptionPane.WARNING_MESSAGE);
				}
			}
			
			else if(e.getSource() == cerrarV) {
				
			    Controlador.getInstance().handleRequest(IDEventos.EVENTO_CERRAR_VENTA, vtr);
				
				
			} 
			else if(e.getSource() == anadirProd) {

			
				TransferLifeLine lv = new TransferLifeLine();
				
				if(!idPV.getText().equals("") && !cantidadV.getText().equals("")) {
				
					
					
					lv.setIDProducto(Integer.parseInt(idPV.getText()));
					crtr.setCantidad(Integer.parseInt(cantidadV.getText()));
					crtr.setIDProducto(Integer.parseInt(idPV.getText()));
					
					

											
					Controlador.getInstance().handleRequest(IDEventos.EVENTO_ANADIR_PRODUCTO_CARRITO, crtr);
					
					lv.setCantidad(crtr.getCarrito().get(Integer.parseInt(idPV.getText())).getCantidad());
					crtr.getCarrito().put((Integer.parseInt(idPV.getText())), lv);
					
					
				}
				else {
					JFrame frameError = new JFrame();
					JOptionPane.showMessageDialog(frameError, "Error de formato en los datos de entrada", "Error en anadir producto al carrito", JOptionPane.WARNING_MESSAGE);
				}
						
			} 
			else if(e.getSource() == eliminarProd) {
				
				
				TransferLifeLine lv = new TransferLifeLine();
				
				if(!idPV.getText().equals("") && !cantidadV.getText().equals("")) {
				
					lv.setIDProducto(Integer.parseInt(idPV.getText()));
					crtr.setCantidad(Integer.parseInt(cantidadV.getText()));
					crtr.setIDProducto(Integer.parseInt(idPV.getText()));
					
					
			
						Controlador.getInstance().handleRequest(IDEventos.EVENTO_ELIMINAR_PRODUCTO_CARRITO, crtr);
						
				}
				else {
					JFrame frameError = new JFrame();
					JOptionPane.showMessageDialog(frameError, "Error de formato en los datos de entrada", "Error en eliminar producto del carrito", JOptionPane.WARNING_MESSAGE);
				}
						
			} 
			else if(e.getSource() == devolucion) {
				
				TransferLifeLine lv = new TransferLifeLine();
				
				if(!idVDev.getText().equals("") && !idPDev.getText().equals("") && !cantidadDev.getText().equals("")) {
				
					lv.setCantidad(Integer.parseInt(cantidadDev.getText()));
					lv.setIDProducto(Integer.parseInt(idPDev.getText()));
					lv.setIdVenta(Integer.parseInt(idVDev.getText()));
					
					Controlador.getInstance().handleRequest(IDEventos.EVENTO_DEVOLUCION_VENTA, lv);
					
				}
				else {
					JFrame frameError = new JFrame();
					JOptionPane.showMessageDialog(frameError, "Error de formato en los datos de entrada", "Error en devolucion", JOptionPane.WARNING_MESSAGE);
				}
						
			} 
			else if(e.getSource() == consultarUn) {
				
				
				if(!idVC.getText().equals("")) {
					
					Controlador.getInstance().handleRequest(IDEventos.EVENTO_CONSULTAR_UNA_VENTA, Integer.parseInt(idVC.getText()));
				}
				else {
					JFrame frameError = new JFrame();
					JOptionPane.showMessageDialog(frameError, "Error de formato en los datos de entrada", "Error en consultar una venta", JOptionPane.WARNING_MESSAGE);
				}
			} 
			else if(e.getSource() == listar) {
				
				Controlador.getInstance().handleRequest(IDEventos.EVENTO_LISTAR_VENTAS, VACIO);
			} 
		}
		
		public void actualizarVentanaAbrirVenta(IDEventos idEvento, Object datos) {
			
			if ( IDEventos.EVENTO_ABRIR_VENTA == idEvento ) {
			
				if ( datos instanceof TransferSale) {
					
					vtr = (TransferSale) datos;
					crtr.setCarrito(vtr.getCarrito());
					
					if ( vtr != null ) {
						
						cantidadV.setEditable(true);
					    idPV.setEditable(true);
						
						
					}
				}
				else {
						
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "Error en abrir venta", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
			else if ( IDEventos.ERROR_EVENTO_ABRIR_VENTA == idEvento ) {
				
				JFrame frame = new JFrame();
				
				if ( datos instanceof Exceptions ) {
					
		    		JOptionPane.showMessageDialog(frame,((Exceptions)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
		    		JOptionPane.showMessageDialog(frame,"Error raro", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		 @SuppressWarnings("serial")
			public void actualizarVentanaAnadirProductoCarrito(IDEventos idEvento, Object datos) {

			    	if ( IDEventos.EVENTO_ANADIR_PRODUCTO_CARRITO == idEvento ) {
			    		
			    		if ( datos instanceof TransferCart) {

			    			listIDProdVenta = new Integer[vtr.getCarrito().size()];
	    					listCantidadVenta = new Integer[vtr.getCarrito().size()];
			                	
							
							int k = 0; 
							Iterator<Entry<Integer, TransferLifeLine>> it = vtr.getCarrito().entrySet().iterator();
							while(it.hasNext()) {
								Entry<Integer, TransferLifeLine> e = it.next();
								
								listIDProdVenta[k] = e.getKey();
					               listCantidadVenta[k] = e.getValue().getCantidad();
		                			
		                			jList19.setSelectedIndex(k);
				                	jList20.setSelectedIndex(k);
								
								k++;
							}
								
	                			
			                
			                jList19.setModel(new AbstractListModel<Integer>() {
			                    Integer[] listIDModel = listIDProdVenta;     
			                    public int getSize() { return listIDModel.length; }
			                    public Integer getElementAt(int i) { return listIDModel[i]; }
			                });
			                
			                jList20.setModel(new AbstractListModel<Integer>() {
			                    Integer[] listCantidadModel = listCantidadVenta;     
			                    public int getSize() { return listCantidadModel.length; }
			                    public Integer getElementAt(int i) { return listCantidadModel[i]; }
			                });
			 	
			    		}
			    		else {
			    			JFrame frame = new JFrame();
				    		JOptionPane.showMessageDialog(frame,"Error al anadir producto a carrito", "Error", JOptionPane.ERROR_MESSAGE);
			    		}
			    	}
			    	else if ( IDEventos.ERROR_EVENTO_ANADIR_PRODUCTO_CARRITO== idEvento ) {

			    		if ( datos instanceof Exceptions ) {

			    			JFrame frame = new JFrame();
			    			JOptionPane.showMessageDialog(frame,((Exceptions)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			    		}
			    		else {

			    			JFrame frame = new JFrame();
			    			JOptionPane.showMessageDialog(frame,"Error raro", "Error", JOptionPane.ERROR_MESSAGE);
			    		}
			    	}
			    }
		 
		 @SuppressWarnings("serial")
			public void actualizarVentanaEliminarProductoCarrito(IDEventos idEvento, Object datos) {

			 		
    			if ( IDEventos.EVENTO_ELIMINAR_PRODUCTO_CARRITO == idEvento ) {
		    		
    				if ( datos instanceof TransferCart) {

    					listIDProdVenta = new Integer[vtr.getCarrito().size()];
    					listCantidadVenta = new Integer[vtr.getCarrito().size()];
    					
    					int k = 0; 
						Iterator<Entry<Integer, TransferLifeLine>> it = vtr.getCarrito().entrySet().iterator();
						while(it.hasNext()) {
							Entry<Integer, TransferLifeLine> e = it.next();
							
							listIDProdVenta[k] = e.getKey();
				               listCantidadVenta[k] = e.getValue().getCantidad();
	                			
	                			jList19.setSelectedIndex(k);
			                	jList20.setSelectedIndex(k);
							
							k++;
						} 	
				                	
				                
				                jList19.setModel(new AbstractListModel<Integer>() {
				                    Integer[] listIDModel = listIDProdVenta;     
				                    public int getSize() { return listIDModel.length; }
				                    public Integer getElementAt(int i) { return listIDModel[i]; }
				                });
				                
				                jList20.setModel(new AbstractListModel<Integer>() {
				                    Integer[] listCantidadModel = listCantidadVenta;     
				                    public int getSize() { return listCantidadModel.length; }
				                    public Integer getElementAt(int i) { return listCantidadModel[i]; }
				                });
				               
		                	
			 	
		    		}
		    		else {
		    			JFrame frame = new JFrame();
			    		JOptionPane.showMessageDialog(frame,"Error al anadir producto a carrito", "Error", JOptionPane.ERROR_MESSAGE);
		    		}
		    	
		    	}
		    	else if ( IDEventos.ERROR_EVENTO_ELIMINAR_PRODUCTO_CARRITO== idEvento ) {

		    		if ( datos instanceof Exceptions ) {

		    			JFrame frame = new JFrame();
		    			JOptionPane.showMessageDialog(frame,((Exceptions)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
		    		}
		    		else {

		    			JFrame frame = new JFrame();
		    			JOptionPane.showMessageDialog(frame,"Error raro", "Error", JOptionPane.ERROR_MESSAGE);
		    		}
		    	}
			
			    
		 }
		
		public void actualizarVentanaCerrarVenta(IDEventos idEvento, Object datos) {
			
			if ( IDEventos.EVENTO_CERRAR_VENTA == idEvento ) {
			
				if ( datos instanceof Boolean) {
					
					Boolean correcto = (Boolean) datos;
					
					if ( correcto ) {
						totalVV.setText(vtr.getTotalVenta().toString());
						fechaV.setText(vtr.getFecha().toString());
					}
				}
				else {
						totalVV.setText("");
						fechaV.setText("");
						cantidadV.setText("");
						idPV.setText("");
						cantidadV.setEditable(false);
						idPV.setEditable(false);
						//Vaciar lista
						DefaultListModel<Integer> model = new DefaultListModel<Integer>();
						jList19.setModel(model);
						jList20.setModel(model);
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "Error en cerrar venta", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
			else if ( IDEventos.ERROR_EVENTO_CERRAR_VENTA == idEvento ) {
				
				JFrame frame = new JFrame();
				totalVV.setText("");
				fechaV.setText("");
				cantidadV.setText("");
				idPV.setText("");
				cantidadV.setEditable(false);
				idPV.setEditable(false);
				//Vaciar lista
				DefaultListModel<Integer> model = new DefaultListModel<Integer>();
				jList19.setModel(model);
				jList20.setModel(model);
				
				if ( datos instanceof Exceptions ) {
					
		    		JOptionPane.showMessageDialog(frame,((Exceptions)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
		    		JOptionPane.showMessageDialog(frame,"Error raro", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		public void actualizarVentanaDevolucion(IDEventos idEvento, Object datos) {
			
			if ( IDEventos.EVENTO_DEVOLUCION_VENTA == idEvento ) {
			
				if ( datos instanceof Boolean) {
					
					Boolean correcto = (Boolean) datos;
					
					if ( correcto ) {
						
						cantidadDev.setText("");
						idPDev.setText("");
						idVDev.setText("");
						
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "Producto devuelto", "Correcto", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "Error en devolucion", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			else if ( IDEventos.ERROR_EVENTO_DEVOLUCION_VENTA == idEvento ) {
				
				JFrame frame = new JFrame();
				
				if ( datos instanceof Exceptions ) {
					
		    		JOptionPane.showMessageDialog(frame,((Exceptions)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
		    		JOptionPane.showMessageDialog(frame,"Error raro", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		 public void actualizarVentanaConsulta(IDEventos idEvento, Object datos) {
				
				if ( IDEventos.EVENTO_CONSULTAR_UNA_VENTA == idEvento ) {
				
					if ( datos instanceof TransferSale) {
						
						TransferSale v = (TransferSale) datos;
						
						if ( v != null ) {
							
							fechaC.setText(v.getFecha().toString());
							idCC.setText(v.getIDCliente().toString());
							totalVC.setText(v.getTotalVenta().toString());
							
							
						}		
					}
					else {
						idVC.setText("");
						fechaC.setText("");
						idCC.setText("");
						totalVC.setText("");
						JFrame frame = new JFrame();
			    		JOptionPane.showMessageDialog(frame,"Error al consultar la venta", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if ( IDEventos.ERROR_EVENTO_CONSULTAR_UNA_VENTA == idEvento ) {
					
					JFrame frame = new JFrame();
					
					if ( datos instanceof Exceptions ) {
						
			    		JOptionPane.showMessageDialog(frame,((Exceptions)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
						
			    		JOptionPane.showMessageDialog(frame,"Error raro", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		
		 @SuppressWarnings("serial")
		public void actualizarVentanaListar(IDEventos idEvento, Object datos) {

		    	if ( IDEventos.EVENTO_LISTAR_VENTAS == idEvento ) {
		    		
		    		if ( datos instanceof ArrayList) {

		    			
		    			 //Cargar datos en lists
		                @SuppressWarnings("unchecked")
						ArrayList<TransferSale> arrayListv = (ArrayList<TransferSale>) datos;
		                listIDVentaListar = new Integer[arrayListv.size()];
		                listIDClienteListar = new Integer[arrayListv.size()];
		                listTotalVentaListar = new Float[arrayListv.size()];
		                listFechaListar = new Date[arrayListv.size()];
		                
		                for(int i = 0; i < arrayListv.size(); i++) {
		                	listIDVentaListar[i] = arrayListv.get(i).getIDVenta();
		                	listIDClienteListar[i] = arrayListv.get(i).getIDCliente();
		                	listTotalVentaListar[i] = arrayListv.get(i).getTotalVenta();
		                	listFechaListar[i] = arrayListv.get(i).getFecha();

		                	jList22.setSelectedIndex(i);
		                	jList23.setSelectedIndex(i);
		                	jList25.setSelectedIndex(i);
		                	jList26.setSelectedIndex(i);
		                	
		                }
		               
		                
		                jList22.setModel(new AbstractListModel<Integer>() {
		                    Integer[] listIDModel = listIDVentaListar;     
		                    public int getSize() { return listIDModel.length; }
		                    public Integer getElementAt(int i) { return listIDModel[i]; }
		                });
		                
		                jList23.setModel(new AbstractListModel<Integer>() {
		                    Integer[] listDNIModel = listIDClienteListar;     
		                    public int getSize() { return listDNIModel.length; }
		                    public Integer getElementAt(int i) { return listDNIModel[i]; }
		                });
		                
		                jList25.setModel(new AbstractListModel<Float>() {
		                    Float[] listNombreModel = listTotalVentaListar;     
		                    public int getSize() { return listNombreModel.length; }
		                    public Float getElementAt(int i) { return listNombreModel[i]; }
		                });
		                
		                jList26.setModel(new AbstractListModel<Date>() {
		                    Date[] listApellidoModel = listFechaListar;     
		                    public int getSize() { return listApellidoModel.length; }
		                    public Date getElementAt(int i) { return listApellidoModel[i]; }
		                });
		                
		               
		    			

		    		}
		    		else {
		    			JFrame frame = new JFrame();
			    		JOptionPane.showMessageDialog(frame,"Error al listar ventas", "Error", JOptionPane.ERROR_MESSAGE);
		    		}
		    	}
		    	else if ( IDEventos.ERROR_EVENTO_LISTAR_VENTAS== idEvento ) {

		    		if ( datos instanceof Exceptions ) {

		    			JFrame frame = new JFrame();
		    			JOptionPane.showMessageDialog(frame,((Exceptions)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
		    		}
		    		else {

		    			JFrame frame = new JFrame();
		    			JOptionPane.showMessageDialog(frame,"Error raro", "Error", JOptionPane.ERROR_MESSAGE);
		    		}
		    	}
		    }
}
