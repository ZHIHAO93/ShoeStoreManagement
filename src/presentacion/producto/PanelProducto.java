package presentacion.producto;

import integracion.transacciones.conexion.Excepciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentacion.comando.IDEventos;
import presentacion.controlador.Controlador;
import negocio.producto.TransferProducto;


public class PanelProducto extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Object VACIO = null;
	
    private javax.swing.JTextField marcaA;
    private javax.swing.JTextField marcaM;
    private javax.swing.JTextField marcaC;
    private javax.swing.JTextField marcaT;
    private javax.swing.JButton alta1;
    private javax.swing.JButton modificar;
    private javax.swing.JButton consultarUn;
    private javax.swing.JButton top;
    private javax.swing.JTextField colorA;
    private javax.swing.JTextField colorM;
    private javax.swing.JTextField colorC;
    private javax.swing.JTextField colorT;
    private javax.swing.JButton baja1;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JList jList11;
    private javax.swing.JList jList14;
    private javax.swing.JList jList15;
    private javax.swing.JList jList16;
    private javax.swing.JList jList17;
    private javax.swing.JList jList18;
    private javax.swing.JList jList9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField precioA;
    private javax.swing.JTextField precioM;
    private javax.swing.JTextField idM;
    private javax.swing.JTextField idC;
    private javax.swing.JTextField precioC;
    private javax.swing.JTextField precioT;
    private javax.swing.JTextField idT;
    private javax.swing.JTextField stockA;
    private javax.swing.JTextField stockM;
    private javax.swing.JTextField stockC;
    private javax.swing.JTextField stockT;
    private javax.swing.JButton listar1;
    private javax.swing.JTextField tipoA;
    private javax.swing.JTextField tipoM;
    private javax.swing.JTextField tipoC;
    private javax.swing.JTextField tipoT;
    private javax.swing.JPanel producto;
	private JTextField idB1;
	
	  //Listas listar
    private Integer[] listIDListar;
    private String[] listMarcaListar;
    private String[] listTipoListar;
    private String[] listColorListar;
    private Integer[] listStockListar;
    private Float[] listPrecioListar;
    private Boolean[] listActivoListar;

	
	public PanelProducto() {
		initGUI();
	}
	
	private void initGUI() {
		producto = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        tipoA = new javax.swing.JTextField();
        colorA = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        stockA = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        marcaA = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        precioA = new javax.swing.JTextField();
        alta1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        idB1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        baja1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        stockM = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        marcaM = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        precioM = new javax.swing.JTextField();
        tipoM = new javax.swing.JTextField();
        colorM = new javax.swing.JTextField();
        modificar = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel42 = new javax.swing.JLabel();
        idM = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        stockC = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        marcaC = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        idC = new javax.swing.JTextField();
        precioC = new javax.swing.JTextField();
        tipoC = new javax.swing.JTextField();
        colorC = new javax.swing.JTextField();
        consultarUn = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList9 = new javax.swing.JList();
        jScrollPane12 = new javax.swing.JScrollPane();
        jList11 = new javax.swing.JList();
        listar1 = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        jList14 = new javax.swing.JList();
        jScrollPane16 = new javax.swing.JScrollPane();
        jList15 = new javax.swing.JList();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jList16 = new javax.swing.JList();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jList17 = new javax.swing.JList();
        jLabel53 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jList18 = new javax.swing.JList();
        jPanel7 = new javax.swing.JPanel();
        marcaT = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        precioT = new javax.swing.JTextField();
        tipoT = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        colorT = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        top = new javax.swing.JButton();
        stockT = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        idT = new javax.swing.JTextField();
        

        
        jLabel31.setText("Marca:");

        jLabel32.setText("Tipo:");

        jLabel33.setText("Color:");

        jLabel34.setText("Stock:");

      

        jLabel35.setText("Precio:");

        alta1.setText("Alta");
        alta1.addActionListener(this);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(alta1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stockA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(jLabel35))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(marcaA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel32)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tipoA, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(precioA))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorA, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marcaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(colorA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(precioA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addComponent(alta1)
                .addGap(42, 42, 42))
        );

        jTabbedPane2.addTab("Alta", jPanel2);

        jLabel36.setText("ID producto:");

        baja1.setText("Baja");
        baja1.addActionListener(this);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel36)
                .addGap(47, 47, 47)
                .addComponent(idB1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(baja1)
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                .addComponent(baja1)
                .addGap(46, 46, 46))
        );

        jTabbedPane2.addTab("Baja", jPanel3);

        jLabel37.setText("Stock:");

   

        jLabel38.setText("Precio:");

        modificar.setText("Modificar");
        modificar.addActionListener(this);
        

        jLabel39.setText("Marca:");

        jLabel40.setText("Tipo:");

        jLabel41.setText("Color:");

        jLabel42.setText("ID Producto: ");

        idM.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modificar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stockM, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(jLabel38))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(marcaM, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel40)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tipoM, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(precioM))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorM, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator5)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idM, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(idM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marcaM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(colorM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(precioM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addComponent(modificar)
                .addGap(42, 42, 42))
        );

        jTabbedPane2.addTab("Modificar", jPanel4);

        jLabel43.setText("Tipo:");

        jLabel44.setText("Color:");

        jLabel45.setText("Stock:");

    

        jLabel46.setText("ID Producto: ");

        jLabel47.setText("Precio:");

        idC.setToolTipText("");

        consultarUn.setText("Consultar");
        consultarUn.addActionListener(this);

        jLabel48.setText("Marca:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stockC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jLabel47))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(marcaC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel43)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tipoC, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(precioC))
                .addGap(18, 18, 18)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(colorC, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator6)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(consultarUn)
                .addGap(39, 39, 39))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(idC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultarUn))
                .addGap(40, 40, 40)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marcaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(colorC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel47)
                    .addComponent(precioC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147))
        );
        
        marcaC.setEditable(false);
		tipoC.setEditable(false);
		colorC.setEditable(false);
		stockC.setEditable(false);
		precioC.setEditable(false);

        jTabbedPane2.addTab("Consultar", jPanel5);

        jLabel49.setText("Activo");

        //listas
        
        jScrollPane10.setViewportView(jList9);

        
        jScrollPane12.setViewportView(jList11);

        listar1.setText("Listar");
        listar1.addActionListener(this);

        
        jScrollPane15.setViewportView(jList14);

        
        jScrollPane16.setViewportView(jList15);

        jLabel50.setText("ID");

        
        jScrollPane17.setViewportView(jList16);

        jLabel51.setText("Marca");

        jLabel52.setText("Tipo");

        
        jScrollPane18.setViewportView(jList17);

        jLabel53.setText("Color");

        jLabel54.setText("Stock");

        jLabel55.setText("Precio");

        
        jScrollPane19.setViewportView(jList18);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(listar1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel51)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel52)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel53)
                         .addGap(70, 70, 70)
                        .addComponent(jLabel54)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel55)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel49)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane19)
                    .addComponent(jScrollPane18)
                    .addComponent(jScrollPane12)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listar1)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Listar", jPanel6);

      

        jLabel56.setText("Precio:");

        jLabel57.setText("Tipo:");

        jLabel58.setText("Color:");

        top.setText("Top");
        top.addActionListener(this);

        jLabel59.setText("Marca:");

        jLabel60.setText("Stock:");

        jLabel61.setText("ID Producto: ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stockT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(jLabel56))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(marcaT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel57)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tipoT)
                            .addComponent(precioT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorT, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap(501, Short.MAX_VALUE)
                    .addComponent(top)
                    .addGap(36, 36, 36)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(idT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marcaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58)
                    .addComponent(colorT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(jLabel56)
                    .addComponent(precioT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(273, 273, 273)
                    .addComponent(top)
                    .addContainerGap(104, Short.MAX_VALUE)))
        );
        
        idT.setEditable(false);
		marcaT.setEditable(false);
		tipoT.setEditable(false);
		colorT.setEditable(false);
		stockT.setEditable(false);
		precioT.setEditable(false);

        jTabbedPane2.addTab("Top", jPanel7);

        javax.swing.GroupLayout productoLayout = new javax.swing.GroupLayout(producto);
        producto.setLayout(productoLayout);
        productoLayout.setHorizontalGroup(
            productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        productoLayout.setVerticalGroup(
            productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        this.add(producto);
	}
	
	
	
	
	
	
	//ActionListener
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == alta1) {

			TransferProducto p = new TransferProducto();
			
			
			if(!marcaA.getText().equals("") && !tipoA.getText().equals("") && !colorA.getText().equals("") && !stockA.getText().equals("") &&
					!precioA.getText().equals("")) {
				p.setMarca(marcaA.getText());
				p.setTipo(tipoA.getText());
				p.setColor(colorA.getText());
				p.setStock(Integer.parseInt(stockA.getText()));
				p.setPrecio(Float.parseFloat(precioA.getText()));
				
				Controlador.getInstance().handleRequest(IDEventos.EVENTO_ALTA_PRODUCTO, p);
				
			}
			else {
				JFrame frameError = new JFrame();
				JOptionPane.showMessageDialog(frameError, "Error de formato en los datos de entrada", "Error en alta", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		else if(e.getSource() == baja1) {
			
			if(!idB1.getText().equals("")) {
				
				Controlador.getInstance().handleRequest(IDEventos.EVENTO_BAJA_PRODUCTO, Integer.parseInt(idB1.getText()));
			}
			else {	
				JFrame frameError = new JFrame();
				JOptionPane.showMessageDialog(frameError, "Error de formato en los datos de entrada", "Error en baja", JOptionPane.WARNING_MESSAGE);
			}
			
			
			
		} 
		else if(e.getSource() == modificar) {
			
			TransferProducto p = new TransferProducto();
			
			if(!idM.getText().equals("")) {
			
				if(!marcaM.getText().equals("") && !tipoM.getText().equals("") && !colorM.getText().equals("") && !stockM.getText().equals("") &&
						!precioM.getText().equals("")) {
					
					p.setIDProducto(Integer.parseInt(idM.getText()));
					p.setMarca(marcaM.getText());
					p.setTipo(tipoM.getText());
					p.setColor(colorM.getText());
					p.setStock(Integer.parseInt(stockM.getText()));
					p.setPrecio(Float.parseFloat(precioM.getText()));
					
					Controlador.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_PRODUCTO, p);
				}
				else {
					JFrame frameError = new JFrame();
					JOptionPane.showMessageDialog(frameError, "Error de formato en los datos de entrada", "Error en modificar", JOptionPane.WARNING_MESSAGE);
				}
			}
			else {
				JFrame frameError = new JFrame();
				JOptionPane.showMessageDialog(frameError, "Error de formato en los datos de entrada", "Error en modificar", JOptionPane.WARNING_MESSAGE);
			}
					
		} 
		else if(e.getSource() == consultarUn) {
			
			
			if(!idC.getText().equals("")) {
				
				Controlador.getInstance().handleRequest(IDEventos.EVENTO_CONSULTAR_UN_PRODUCTO, Integer.parseInt(idC.getText()));
			}
			else {
				JFrame frameError = new JFrame();
				JOptionPane.showMessageDialog(frameError, "Error de formato en los datos de entrada", "Error en consultar un producto", JOptionPane.WARNING_MESSAGE);
			}
		} 
		else if(e.getSource() == listar1) {
			
			Controlador.getInstance().handleRequest(IDEventos.EVENTO_LISTAR_PRODUCTOS, VACIO);
		} 
		else if(e.getSource() == top) {
			
			Controlador.getInstance().handleRequest(IDEventos.EVENTO_TOP_PRODUCTO, VACIO);			
		} 
	}

	 public void actualizarVentanaAlta(IDEventos idEvento, Object datos) {
			
			if ( IDEventos.EVENTO_ALTA_PRODUCTO == idEvento ) {
				if(datos instanceof Boolean)
				{
					Boolean correcto = (Boolean) datos;
					
					if (correcto) {

			    		marcaA.setText(""); 
						tipoA.setText(""); 
						colorA.setText("");
						stockA.setText("");
						precioA.setText("");
						
						JFrame frame = new JFrame();
			    		JOptionPane.showMessageDialog(frame,"Producto dado de alta", "Correcto", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JFrame frame = new JFrame();
			    		JOptionPane.showMessageDialog(frame,"Error en alta producto", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			else if ( IDEventos.ERROR_EVENTO_ALTA_PRODUCTO == idEvento ) {
				
				JFrame frame = new JFrame();
				
				if ( datos instanceof Excepciones ) {
					
		    		JOptionPane.showMessageDialog(frame,((Excepciones)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(frame, "Excepcion controlada", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
	}
	 
	 public void actualizarVentanaBorra(IDEventos idEvento, Object datos){
	    	
	    	if ( IDEventos.EVENTO_BAJA_PRODUCTO == idEvento ) {

	    		if ( datos instanceof Boolean ) {

	    			Boolean correcto = (Boolean) datos;

	    			if (correcto) {
	    				
	    				idB1.setText("");

	    				JFrame frame = new JFrame();
			    		JOptionPane.showMessageDialog(frame,"Producto dado de baja", "Correcto", JOptionPane.INFORMATION_MESSAGE);
	    			}
	    			else {

	    				JFrame frame = new JFrame();
			    		JOptionPane.showMessageDialog(frame,"Error en baja producto", "Error", JOptionPane.ERROR_MESSAGE);
	    			}
	    		}
	    	}
	    	else if ( IDEventos.ERROR_EVENTO_BAJA_PRODUCTO == idEvento) {

	    		if ( datos instanceof Excepciones ) {

	    			JFrame frame = new JFrame();
	    			JOptionPane.showMessageDialog(frame,((Excepciones)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
	    		}
	    		else {
	    			JFrame frame = new JFrame();
	    			JOptionPane.showMessageDialog(frame,"Excepcion controlada", "Error", JOptionPane.ERROR_MESSAGE);
	    		}
	    	}
	    }
	 
	 public void actualizarVentanaModificar(IDEventos idEvento, Object datos){
		    
	    	if ( IDEventos.EVENTO_MODIFICAR_PRODUCTO == idEvento ) {
				
				if ( datos instanceof Boolean ) {
					
					Boolean correcto = (Boolean) datos;
					
					if (correcto) {
						
						idM.setText("");
						marcaM.setText("");
						tipoM.setText("");
						colorM.setText("");
						stockM.setText("");
						precioM.setText("");
						
						
						
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "Producto modificado", "Correcto", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "Error en modificar producto", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			else if ( IDEventos.ERROR_EVENTO_MODIFICAR_PRODUCTO == idEvento) {
				
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
	 
	 public void actualizarVentanaConsulta(IDEventos idEvento, Object datos) {
			
			if ( IDEventos.EVENTO_CONSULTAR_UN_PRODUCTO == idEvento ) {
			
				if ( datos instanceof TransferProducto) {
					
					TransferProducto p = (TransferProducto) datos;
					
					if ( p != null ) {
						
						marcaC.setText(p.getMarca());
						tipoC.setText(p.getTipo());
						colorC.setText(p.getColor());
						stockC.setText(p.getStock().toString());
						precioC.setText(p.getPrecio().toString());	
						
					}		
				}
				else {
					JFrame frame = new JFrame();
		    		JOptionPane.showMessageDialog(frame,"Error al consultar el producto", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if ( IDEventos.ERROR_EVENTO_CONSULTAR_UN_PRODUCTO == idEvento ) {
				
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

		 if ( IDEventos.EVENTO_LISTAR_PRODUCTOS == idEvento ) {
	    		
	    		if ( datos instanceof ArrayList) {
	    			
	    			 //Cargar datos en lists
	                @SuppressWarnings("unchecked")
					ArrayList<TransferProducto> arrayListp = (ArrayList<TransferProducto>) datos;
	                listIDListar = new Integer[arrayListp.size()];
	                listMarcaListar = new String[arrayListp.size()];
	                listTipoListar = new String[arrayListp.size()];
	                listColorListar = new String[arrayListp.size()];
	                listStockListar = new Integer[arrayListp.size()];
	                listPrecioListar = new Float[arrayListp.size()];
	                listActivoListar = new Boolean[arrayListp.size()];
	                
	                for(int i = 0; i < arrayListp.size(); i++) {
	                	listIDListar[i] = arrayListp.get(i).getIDProducto();
	                	listMarcaListar[i] = arrayListp.get(i).getMarca();
		                listTipoListar[i] = arrayListp.get(i).getTipo();
		                listColorListar[i] = arrayListp.get(i).getColor();
		                listStockListar[i] = arrayListp.get(i).getStock();
		                listPrecioListar[i] = arrayListp.get(i).getPrecio();
	                	listActivoListar[i] = arrayListp.get(i).getActivo();

	                	jList9.setSelectedIndex(i);
	                	jList11.setSelectedIndex(i);
	                	jList17.setSelectedIndex(i);
	                	jList18.setSelectedIndex(i);
	                	jList15.setSelectedIndex(i);
	                	jList14.setSelectedIndex(i);
	                	jList16.setSelectedIndex(i);
	                	
	                }

	                jList9.setModel(new javax.swing.AbstractListModel() {
	                    Integer[] listIDModel = listIDListar;     
	                    public int getSize() { return listIDModel.length; }
	                    public Integer getElementAt(int i) { return listIDModel[i]; }
	                });
	                
	                jList16.setModel(new javax.swing.AbstractListModel() {
	                    String[] listDNIModel = listTipoListar;     
	                    public int getSize() { return listDNIModel.length; }
	                    public String getElementAt(int i) { return listDNIModel[i]; }
	                });
	                
	                jList18.setModel(new javax.swing.AbstractListModel() {
	                    Integer[] listNombreModel = listStockListar;     
	                    public int getSize() { return listNombreModel.length; }
	                    public Integer getElementAt(int i) { return listNombreModel[i]; }
	                });
	                
	                jList11.setModel(new javax.swing.AbstractListModel() {
	                    Float[] listApellidoModel = listPrecioListar;     
	                    public int getSize() { return listApellidoModel.length; }
	                    public Float getElementAt(int i) { return listApellidoModel[i]; }
	                });
	                
	                jList15.setModel(new javax.swing.AbstractListModel() {
	                    Boolean[] listLimiteModel = listActivoListar;     
	                    public int getSize() { return listLimiteModel.length; }
	                    public Boolean getElementAt(int i) { return listLimiteModel[i]; }
	                });
	                
	                jList14.setModel(new javax.swing.AbstractListModel() {
	                    String[] listNewsModel = listMarcaListar;     
	                    public int getSize() { return listNewsModel.length; }
	                    public String getElementAt(int i) { return listNewsModel[i]; }
	                });
	                
	                jList17.setModel(new javax.swing.AbstractListModel() {
	                	String[] listActivoModel = listColorListar;     
	                    public int getSize() { return listActivoModel.length; }
	                    public String getElementAt(int i) { return listActivoModel[i]; }
	                });

	    		}
	    		else {
	    			JFrame frame = new JFrame();
		    		JOptionPane.showMessageDialog(frame,"Error al listar productos", "Error", JOptionPane.ERROR_MESSAGE);
	    		}
	    	}
	    	else if ( IDEventos.ERROR_EVENTO_LISTAR_PRODUCTOS== idEvento ) {

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
	 
	 public void actualizarVentanaTop(IDEventos idEvento, Object datos) {

		 if ( IDEventos.EVENTO_TOP_PRODUCTO == idEvento ) {
	    		
	    		if ( datos instanceof TransferProducto) {
					
					TransferProducto p = (TransferProducto) datos;
					
					if ( p != null ) {
						
						idT.setText(p.getIDProducto().toString());
						marcaT.setText(p.getMarca());
						tipoT.setText(p.getTipo());
						colorT.setText(p.getColor());
						stockT.setText(p.getStock().toString());
						precioT.setText(p.getPrecio().toString());
					}		
				}
				else {
					JFrame frame = new JFrame();
		    		JOptionPane.showMessageDialog(frame,"Error en top producto", "Error", JOptionPane.ERROR_MESSAGE);
				}
	    	}
	    	else if ( IDEventos.ERROR_EVENTO_TOP_PRODUCTO== idEvento ) {

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
