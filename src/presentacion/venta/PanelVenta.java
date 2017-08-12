package presentacion.venta;

import integracion.transacciones.conexion.Excepciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import negocio.venta.TransferCarrito;
import negocio.venta.TransferLineaVenta;
import negocio.venta.TransferVenta;
import presentacion.comando.IDEventos;
import presentacion.controlador.Controlador;

import java.sql.Date;

public class PanelVenta extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Object VACIO = null;
	private TransferVenta vtr;
	private TransferCarrito crtr;
	
	private javax.swing.JButton abrirV;
    private javax.swing.JButton anadirProd;
    private javax.swing.JButton eliminarProd;
    private javax.swing.JButton cerrarV;
    private javax.swing.JButton devolucion;

    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JList jList19;
    private javax.swing.JList jList20;
    private javax.swing.JList jList22;
    private javax.swing.JList jList23;
    private javax.swing.JList jList25;
    private javax.swing.JList jList26;

    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField cantidadV;
    private javax.swing.JTextField totalVV;
    private javax.swing.JTextField fechaV;
    private javax.swing.JTextField idVDev;
    private javax.swing.JTextField idPDev;
    private javax.swing.JTextField cantidadDev;
    private javax.swing.JTextField idVC;
    private javax.swing.JTextField idCC;
    private javax.swing.JTextField totalVC;
    private javax.swing.JTextField fechaC;
    private javax.swing.JTextField idCV;
    private javax.swing.JTextField idPV;
    private javax.swing.JButton listar;
    private javax.swing.JPanel venta;
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
		crtr = new TransferCarrito();
		initGUI();
	}
	
	private void initGUI() {
		
		venta = new javax.swing.JPanel();
	    jTabbedPane3 = new javax.swing.JTabbedPane();
	    jPanel8 = new javax.swing.JPanel();
	    jLabel62 = new javax.swing.JLabel();
	    idCV = new javax.swing.JTextField();
	    abrirV = new javax.swing.JButton();
	    jSeparator8 = new javax.swing.JSeparator();
	    jLabel63 = new javax.swing.JLabel();
	    idPV = new javax.swing.JTextField();
	    jLabel64 = new javax.swing.JLabel();
	    cantidadV = new javax.swing.JTextField();
	    anadirProd = new javax.swing.JButton();
	    eliminarProd = new javax.swing.JButton();
	    jScrollPane1 = new javax.swing.JScrollPane();
	    jList19 = new javax.swing.JList();
	    jScrollPane20 = new javax.swing.JScrollPane();
	    jList20 = new javax.swing.JList();
	    jLabel65 = new javax.swing.JLabel();
	    jLabel66 = new javax.swing.JLabel();
	    jSeparator9 = new javax.swing.JSeparator();
	    jLabel67 = new javax.swing.JLabel();
	    totalVV = new javax.swing.JTextField();
	    cerrarV = new javax.swing.JButton();
	    jLabel68 = new javax.swing.JLabel();
	    fechaV = new javax.swing.JTextField();
	    jPanel9 = new javax.swing.JPanel();
	    jLabel69 = new javax.swing.JLabel();
	    idVDev = new javax.swing.JTextField();
	    jLabel70 = new javax.swing.JLabel();
	    idPDev = new javax.swing.JTextField();
	    jLabel71 = new javax.swing.JLabel();
	    cantidadDev = new javax.swing.JTextField();
	    devolucion = new javax.swing.JButton();
	    jPanel10 = new javax.swing.JPanel();
	    jLabel72 = new javax.swing.JLabel();
	    idVC = new javax.swing.JTextField();
	    jLabel73 = new javax.swing.JLabel();
	    idCC = new javax.swing.JTextField();
	    jSeparator10 = new javax.swing.JSeparator();
	    jLabel74 = new javax.swing.JLabel();
	    totalVC = new javax.swing.JTextField();
	    jLabel75 = new javax.swing.JLabel();
	    fechaC = new javax.swing.JTextField();
	    consultarUn = new javax.swing.JButton();
	    jPanel11 = new javax.swing.JPanel();
	    jLabel77 = new javax.swing.JLabel();
	    jScrollPane22 = new javax.swing.JScrollPane();
	    jList22 = new javax.swing.JList();
	    jScrollPane23 = new javax.swing.JScrollPane();
	    jList23 = new javax.swing.JList();
	    jLabel79 = new javax.swing.JLabel();
	    jLabel80 = new javax.swing.JLabel();
	    jScrollPane25 = new javax.swing.JScrollPane();
	    jList25 = new javax.swing.JList();
	    listar = new javax.swing.JButton();
	    jScrollPane26 = new javax.swing.JScrollPane();
	    jList26 = new javax.swing.JList();
	    jLabel81 = new javax.swing.JLabel();
	    jSeparator11 = new javax.swing.JSeparator();
		
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
	
	     javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
	     jPanel8.setLayout(jPanel8Layout);
	     jPanel8Layout.setHorizontalGroup(
	         jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel8Layout.createSequentialGroup()
	             .addGap(35, 35, 35)
	             .addComponent(jLabel62)
	             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	             .addComponent(idCV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
	             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	             .addComponent(abrirV)
	             .addGap(47, 47, 47))
	         .addGroup(jPanel8Layout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(jSeparator8)
	             .addContainerGap())
	         .addGroup(jPanel8Layout.createSequentialGroup()
	             .addGap(35, 35, 35)
	             .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                 .addGroup(jPanel8Layout.createSequentialGroup()
	                     .addComponent(anadirProd)
	                     .addGap(30, 30, 30)
	                     .addComponent(eliminarProd))
	                 .addGroup(jPanel8Layout.createSequentialGroup()
	                     .addComponent(jLabel64)
	                     .addGap(30, 30, 30)
	                     .addComponent(cantidadV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
	                 .addGroup(jPanel8Layout.createSequentialGroup()
	                     .addComponent(jLabel63)
	                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                     .addComponent(idPV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                     .addGap(100, 100, 100)
	             .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                 .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
	             .addGap(34, 34, 34)
	             .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                 .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                 .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
	             .addGap(60, 60, 60)))

	         .addGroup(jPanel8Layout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(jSeparator9)
	             .addContainerGap())
	         .addGroup(jPanel8Layout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(jLabel67)
	             .addGap(18, 18, 18)
	             .addComponent(totalVV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
	             .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(jLabel68)
	             .addGap(18, 18, 18)
	             .addComponent(fechaV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
	             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	             .addComponent(cerrarV)
	             .addGap(46, 46, 46))
	     );
	     jPanel8Layout.setVerticalGroup(
	         jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel8Layout.createSequentialGroup()
	             .addGap(29, 29, 29)
	             .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel62)
	                 .addComponent(idCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                 .addComponent(abrirV))
	             .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                 .addGroup(jPanel8Layout.createSequentialGroup()
	                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                     .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	                     .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                         .addGroup(jPanel8Layout.createSequentialGroup()
	                             .addGap(27, 27, 27)
	                             .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                 .addComponent(jLabel63)
	                                 .addComponent(idPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                             .addGap(30, 30, 30)
	                             .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                 .addComponent(jLabel64)
	                                 .addComponent(cantidadV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                             .addGap(23, 23, 23)
	                             .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                 .addComponent(anadirProd)
	                                 .addComponent(eliminarProd)))
	                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
	                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                             .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                 .addGroup(jPanel8Layout.createSequentialGroup()
	                     .addGap(42, 42, 42)
	                     .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                         .addComponent(jLabel65)
	                         .addComponent(jLabel66))
	                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                     .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	             .addGap(15, 15, 15)
	             .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	             .addGap(18, 18, 18)
	             .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel67)
	                 .addComponent(totalVV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	             .addGap(18, 18, 18)
	             .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                 .addComponent(cerrarV)
	                 .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                     .addComponent(jLabel68)
	                     .addComponent(fechaV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	             .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
	
	     javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
	     jPanel9.setLayout(jPanel9Layout);
	     jPanel9Layout.setHorizontalGroup(
	         jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel9Layout.createSequentialGroup()
	             .addGap(30, 30, 30)
	             .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                 .addGroup(jPanel9Layout.createSequentialGroup()
	                     .addComponent(jLabel71)
	                     .addGap(43, 43, 43)
	                     .addComponent(cantidadDev, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
	                 .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                     .addGroup(jPanel9Layout.createSequentialGroup()
	                         .addComponent(jLabel70)
	                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                         .addComponent(idPDev, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
	                     .addGroup(jPanel9Layout.createSequentialGroup()
	                         .addComponent(jLabel69)
	                         .addGap(47, 47, 47)
	                         .addComponent(idVDev, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
	             .addGap(394, 394, 394))
	         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(devolucion)
	             .addGap(71, 71, 71))
	     );
	     jPanel9Layout.setVerticalGroup(
	         jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel9Layout.createSequentialGroup()
	             .addGap(41, 41, 41)
	             .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel69)
	                 .addComponent(idVDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	             .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel70)
	                 .addComponent(idPDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	             .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel71)
	                 .addComponent(cantidadDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
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
	   
	     javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
	     jPanel10.setLayout(jPanel10Layout);
	     jPanel10Layout.setHorizontalGroup(
	         jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel10Layout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(jSeparator10)
	             .addContainerGap())
	         .addGroup(jPanel10Layout.createSequentialGroup()
	             .addGap(32, 32, 32)
	             .addComponent(jLabel72)
	             .addGap(18, 18, 18)
	             .addComponent(idVC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
	             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	             .addComponent(consultarUn)
	             .addGap(61, 61, 61))
	         .addGroup(jPanel10Layout.createSequentialGroup()
	             .addGap(27, 27, 27)
	             .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                 .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
	                     .addComponent(jLabel75)
	                     .addGap(18, 18, 18)
	                     .addComponent(fechaC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
	                 .addGroup(jPanel10Layout.createSequentialGroup()
	                     .addComponent(jLabel73)
	                     .addGap(26, 26, 26)
	                     .addComponent(idCC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
	             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
	             .addComponent(jLabel74)
	             .addGap(26, 26, 26)
	             .addComponent(totalVC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
	             .addGap(70, 70, 70))
	     );
	     jPanel10Layout.setVerticalGroup(
	         jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel10Layout.createSequentialGroup()
	             .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                 .addGroup(jPanel10Layout.createSequentialGroup()
	                     .addGap(53, 53, 53)
	                     .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                         .addComponent(jLabel72)
	                         .addComponent(idVC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
	                     .addContainerGap()
	                     .addComponent(consultarUn)))
	             .addGap(18, 18, 18)
	             .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	             .addGap(18, 18, 18)
	             .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel73)
	                 .addComponent(idCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                 .addComponent(jLabel74)
	                 .addComponent(totalVC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	             .addGap(18, 18, 18)
	             .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel75)
	                 .addComponent(fechaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	             .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
	
	     javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
	     jPanel11.setLayout(jPanel11Layout);
	     jPanel11Layout.setHorizontalGroup(
	         jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel11Layout.createSequentialGroup()
	             .addComponent(jSeparator11)
	             .addContainerGap())
	         .addGroup(jPanel11Layout.createSequentialGroup()
	             .addContainerGap()
	             .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                 .addGroup(jPanel11Layout.createSequentialGroup()
	                		 .addGap(100, 100, 100)
	                     .addComponent(jLabel77)
	                     .addGap(50, 50, 50)
	                     .addComponent(jLabel79)
	                     .addGap(69, 69, 69)
	                     .addComponent(jLabel80)
	                     .addGap(80, 80, 80)
	                     .addComponent(jLabel81)
	                     .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                 .addGroup(jPanel11Layout.createSequentialGroup()
	                		 .addGap(100, 100, 100)
	                     .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                     .addGap(40, 40, 40)
	                     .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
	                     .addGap(26, 26, 26)
	                     .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
	                     .addGap(26, 26, 26)
	                     .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
	                     .addGap(77, 77, 77))
	                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
	                     .addGap(0, 0, Short.MAX_VALUE)
	                     .addComponent(listar))))
	     );
	     jPanel11Layout.setVerticalGroup(
	         jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	         .addGroup(jPanel11Layout.createSequentialGroup()
	             .addContainerGap()
	             .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                 .addComponent(jLabel77)
	                 .addComponent(jLabel79)
	                 .addComponent(jLabel80)
	                 .addComponent(jLabel81))
	             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	             .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	             .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                     .addComponent(jScrollPane22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
	                     .addComponent(jScrollPane26, javax.swing.GroupLayout.Alignment.TRAILING)
	                     .addComponent(jScrollPane23, javax.swing.GroupLayout.Alignment.TRAILING))
	                 .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
	             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	             .addComponent(listar)
	             .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	     );
	
	     jTabbedPane3.addTab("Listar", jPanel11);
	
	     javax.swing.GroupLayout ventaLayout = new javax.swing.GroupLayout(venta);
	     venta.setLayout(ventaLayout);
	     ventaLayout.setHorizontalGroup(
	         ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	         .addGroup(ventaLayout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(jTabbedPane3)
	             .addContainerGap())
	     );
	     ventaLayout.setVerticalGroup(
	         ventaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	         .addGroup(ventaLayout.createSequentialGroup()
	             .addContainerGap()
	             .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
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

			
				TransferLineaVenta lv = new TransferLineaVenta();
				
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
				
				
				TransferLineaVenta lv = new TransferLineaVenta();
				
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
				
				TransferLineaVenta lv = new TransferLineaVenta();
				
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
			
				if ( datos instanceof TransferVenta) {
					
					vtr = (TransferVenta) datos;
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
				
				if ( datos instanceof Excepciones ) {
					
		    		JOptionPane.showMessageDialog(frame,((Excepciones)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
		    		JOptionPane.showMessageDialog(frame,"Error raro", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		 @SuppressWarnings("serial")
			public void actualizarVentanaAnadirProductoCarrito(IDEventos idEvento, Object datos) {

			    	if ( IDEventos.EVENTO_ANADIR_PRODUCTO_CARRITO == idEvento ) {
			    		
			    		if ( datos instanceof TransferCarrito) {

			    			listIDProdVenta = new Integer[vtr.getCarrito().size()];
	    					listCantidadVenta = new Integer[vtr.getCarrito().size()];
			                	
							
							int k = 0; 
							Iterator<Entry<Integer, TransferLineaVenta>> it = vtr.getCarrito().entrySet().iterator();
							while(it.hasNext()) {
								Entry<Integer, TransferLineaVenta> e = it.next();
								
								listIDProdVenta[k] = e.getKey();
					               listCantidadVenta[k] = e.getValue().getCantidad();
		                			
		                			jList19.setSelectedIndex(k);
				                	jList20.setSelectedIndex(k);
								
								k++;
							}
								
	                			
			                
			                jList19.setModel(new javax.swing.AbstractListModel() {
			                    Integer[] listIDModel = listIDProdVenta;     
			                    public int getSize() { return listIDModel.length; }
			                    public Integer getElementAt(int i) { return listIDModel[i]; }
			                });
			                
			                jList20.setModel(new javax.swing.AbstractListModel() {
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

			    		if ( datos instanceof Excepciones ) {

			    			JFrame frame = new JFrame();
			    			JOptionPane.showMessageDialog(frame,((Excepciones)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
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
		    		
    				if ( datos instanceof TransferCarrito) {

    					listIDProdVenta = new Integer[vtr.getCarrito().size()];
    					listCantidadVenta = new Integer[vtr.getCarrito().size()];
    					
    					int k = 0; 
						Iterator<Entry<Integer, TransferLineaVenta>> it = vtr.getCarrito().entrySet().iterator();
						while(it.hasNext()) {
							Entry<Integer, TransferLineaVenta> e = it.next();
							
							listIDProdVenta[k] = e.getKey();
				               listCantidadVenta[k] = e.getValue().getCantidad();
	                			
	                			jList19.setSelectedIndex(k);
			                	jList20.setSelectedIndex(k);
							
							k++;
						} 	
				                	
				                
				                jList19.setModel(new javax.swing.AbstractListModel() {
				                    Integer[] listIDModel = listIDProdVenta;     
				                    public int getSize() { return listIDModel.length; }
				                    public Integer getElementAt(int i) { return listIDModel[i]; }
				                });
				                
				                jList20.setModel(new javax.swing.AbstractListModel() {
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

		    		if ( datos instanceof Excepciones ) {

		    			JFrame frame = new JFrame();
		    			JOptionPane.showMessageDialog(frame,((Excepciones)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
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
						DefaultListModel model = new DefaultListModel();
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
				DefaultListModel model = new DefaultListModel();
				jList19.setModel(model);
				jList20.setModel(model);
				
				if ( datos instanceof Excepciones ) {
					
		    		JOptionPane.showMessageDialog(frame,((Excepciones)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
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
				
				if ( datos instanceof Excepciones ) {
					
		    		JOptionPane.showMessageDialog(frame,((Excepciones)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
		    		JOptionPane.showMessageDialog(frame,"Error raro", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		 public void actualizarVentanaConsulta(IDEventos idEvento, Object datos) {
				
				if ( IDEventos.EVENTO_CONSULTAR_UNA_VENTA == idEvento ) {
				
					if ( datos instanceof TransferVenta) {
						
						TransferVenta v = (TransferVenta) datos;
						
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
					
					if ( datos instanceof Excepciones ) {
						
			    		JOptionPane.showMessageDialog(frame,((Excepciones)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
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
						ArrayList<TransferVenta> arrayListv = (ArrayList<TransferVenta>) datos;
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
		               
		                
		                jList22.setModel(new javax.swing.AbstractListModel() {
		                    Integer[] listIDModel = listIDVentaListar;     
		                    public int getSize() { return listIDModel.length; }
		                    public Integer getElementAt(int i) { return listIDModel[i]; }
		                });
		                
		                jList23.setModel(new javax.swing.AbstractListModel() {
		                    Integer[] listDNIModel = listIDClienteListar;     
		                    public int getSize() { return listDNIModel.length; }
		                    public Integer getElementAt(int i) { return listDNIModel[i]; }
		                });
		                
		                jList25.setModel(new javax.swing.AbstractListModel() {
		                    Float[] listNombreModel = listTotalVentaListar;     
		                    public int getSize() { return listNombreModel.length; }
		                    public Float getElementAt(int i) { return listNombreModel[i]; }
		                });
		                
		                jList26.setModel(new javax.swing.AbstractListModel() {
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

		    		if ( datos instanceof Excepciones ) {

		    			JFrame frame = new JFrame();
		    			JOptionPane.showMessageDialog(frame,((Excepciones)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
		    		}
		    		else {

		    			JFrame frame = new JFrame();
		    			JOptionPane.showMessageDialog(frame,"Error raro", "Error", JOptionPane.ERROR_MESSAGE);
		    		}
		    	}
		    }
}
