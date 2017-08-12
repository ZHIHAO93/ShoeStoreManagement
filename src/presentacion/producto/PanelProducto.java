package presentacion.producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import business.product.TransferProduct;
import dao.transations.connection.Exceptions;
import presentacion.comando.IDEventos;
import presentacion.controlador.Controlador;


public class PanelProducto extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Object VACIO = null;
	
    private JTextField marcaA;
    private JTextField marcaM;
    private JTextField marcaC;
    private JTextField marcaT;
    private JButton alta1;
    private JButton modificar;
    private JButton consultarUn;
    private JButton top;
    private JTextField colorA;
    private JTextField colorM;
    private JTextField colorC;
    private JTextField colorT;
    private JButton baja1;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    private JLabel jLabel34;
    private JLabel jLabel35;
    private JLabel jLabel36;
    private JLabel jLabel37;
    private JLabel jLabel38;
    private JLabel jLabel39;
    private JLabel jLabel40;
    private JLabel jLabel41;
    private JLabel jLabel42;
    private JLabel jLabel43;
    private JLabel jLabel44;
    private JLabel jLabel45;
    private JLabel jLabel46;
    private JLabel jLabel47;
    private JLabel jLabel48;
    private JLabel jLabel49;
    private JLabel jLabel50;
    private JLabel jLabel51;
    private JLabel jLabel52;
    private JLabel jLabel53;
    private JLabel jLabel54;
    private JLabel jLabel55;
    private JLabel jLabel56;
    private JLabel jLabel57;
    private JLabel jLabel58;
    private JLabel jLabel59;
    private JLabel jLabel60;
    private JLabel jLabel61;
    private JList<Float> jList11;
    private JList<String> jList14;
    private JList<Boolean> jList15;
    private JList<String> jList16;
    private JList<String> jList17;
    private JList<Integer> jList18;
    private JList<Integer> jList9;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JScrollPane jScrollPane10;
    private JScrollPane jScrollPane12;
    private JScrollPane jScrollPane15;
    private JScrollPane jScrollPane16;
    private JScrollPane jScrollPane17;
    private JScrollPane jScrollPane18;
    private JScrollPane jScrollPane19;
    private JSeparator jSeparator5;
    private JSeparator jSeparator6;
    private JSeparator jSeparator7;
    private JTabbedPane jTabbedPane2;
    private JTextField precioA;
    private JTextField precioM;
    private JTextField idM;
    private JTextField idC;
    private JTextField precioC;
    private JTextField precioT;
    private JTextField idT;
    private JTextField stockA;
    private JTextField stockM;
    private JTextField stockC;
    private JTextField stockT;
    private JButton listar1;
    private JTextField tipoA;
    private JTextField tipoM;
    private JTextField tipoC;
    private JTextField tipoT;
    private JPanel producto;
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
		producto = new JPanel();
        jTabbedPane2 = new JTabbedPane();
        jPanel2 = new JPanel();
        tipoA = new JTextField();
        colorA = new JTextField();
        jLabel31 = new JLabel();
        jLabel32 = new JLabel();
        jLabel33 = new JLabel();
        stockA = new JTextField();
        jLabel34 = new JLabel();
        marcaA = new JTextField();
        jLabel35 = new JLabel();
        precioA = new JTextField();
        alta1 = new JButton();
        jPanel3 = new JPanel();
        idB1 = new JTextField();
        jLabel36 = new JLabel();
        baja1 = new JButton();
        jPanel4 = new JPanel();
        stockM = new JTextField();
        jLabel37 = new JLabel();
        marcaM = new JTextField();
        jLabel38 = new JLabel();
        precioM = new JTextField();
        tipoM = new JTextField();
        colorM = new JTextField();
        modificar = new JButton();
        jLabel39 = new JLabel();
        jLabel40 = new JLabel();
        jLabel41 = new JLabel();
        jSeparator5 = new JSeparator();
        jLabel42 = new JLabel();
        idM = new JTextField();
        jPanel5 = new JPanel();
        jLabel43 = new JLabel();
        jLabel44 = new JLabel();
        stockC = new JTextField();
        jLabel45 = new JLabel();
        jSeparator6 = new JSeparator();
        marcaC = new JTextField();
        jLabel46 = new JLabel();
        jLabel47 = new JLabel();
        idC = new JTextField();
        precioC = new JTextField();
        tipoC = new JTextField();
        colorC = new JTextField();
        consultarUn = new JButton();
        jLabel48 = new JLabel();
        jPanel6 = new JPanel();
        jLabel49 = new JLabel();
        jScrollPane10 = new JScrollPane();
        jList9 = new JList<Integer>();
        jScrollPane12 = new JScrollPane();
        jList11 = new JList<Float>();
        listar1 = new JButton();
        jScrollPane15 = new JScrollPane();
        jList14 = new JList<String>();
        jScrollPane16 = new JScrollPane();
        jList15 = new JList<Boolean>();
        jLabel50 = new JLabel();
        jScrollPane17 = new JScrollPane();
        jList16 = new JList<String>();
        jLabel51 = new JLabel();
        jLabel52 = new JLabel();
        jScrollPane18 = new JScrollPane();
        jList17 = new JList<String>();
        jLabel53 = new JLabel();
        jSeparator7 = new JSeparator();
        jLabel54 = new JLabel();
        jLabel55 = new JLabel();
        jScrollPane19 = new JScrollPane();
        jList18 = new JList<Integer>();
        jPanel7 = new JPanel();
        marcaT = new JTextField();
        jLabel56 = new JLabel();
        precioT = new JTextField();
        tipoT = new JTextField();
        jLabel57 = new JLabel();
        colorT = new JTextField();
        jLabel58 = new JLabel();
        top = new JButton();
        stockT = new JTextField();
        jLabel59 = new JLabel();
        jLabel60 = new JLabel();
        jLabel61 = new JLabel();
        idT = new JTextField();
        

        
        jLabel31.setText("Marca:");

        jLabel32.setText("Tipo:");

        jLabel33.setText("Color:");

        jLabel34.setText("Stock:");

      

        jLabel35.setText("Precio:");

        alta1.setText("Alta");
        alta1.addActionListener(this);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(alta1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stockA, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(jLabel35))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(marcaA, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel32)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(tipoA, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(precioA))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorA, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(marcaA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(colorA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(stockA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(precioA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addComponent(alta1)
                .addGap(42, 42, 42))
        );

        jTabbedPane2.addTab("Alta", jPanel2);

        jLabel36.setText("ID producto:");

        baja1.setText("Baja");
        baja1.addActionListener(this);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel36)
                .addGap(47, 47, 47)
                .addComponent(idB1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(baja1)
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(idB1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
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

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modificar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stockM, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(jLabel38))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(marcaM, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel40)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(tipoM, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(precioM))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel41)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorM, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator5)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel42)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idM, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(idM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(marcaM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(colorM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(stockM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(precioM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stockC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jLabel47))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(marcaC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel43)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(tipoC, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(precioC))
                .addGap(18, 18, 18)
                .addComponent(jLabel44)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(colorC, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator6)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel46)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(consultarUn)
                .addGap(39, 39, 39))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(idC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultarUn))
                .addGap(40, 40, 40)
                .addComponent(jSeparator6, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(marcaC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(colorC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(stockC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel47)
                    .addComponent(precioC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(listar1)
                            .addGroup(GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane10, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane15, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane17, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane18, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane19, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane12, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane16, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
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
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52)
                    .addComponent(jLabel54, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel53))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane17, GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane15, GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane10, GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane19)
                    .addComponent(jScrollPane18)
                    .addComponent(jScrollPane12)
                    .addComponent(jScrollPane16, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idT, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stockT, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(jLabel56))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(marcaT, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel57)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(tipoT)
                            .addComponent(precioT, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel58)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorT, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
            .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap(501, Short.MAX_VALUE)
                    .addComponent(top)
                    .addGap(36, 36, 36)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(idT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(marcaT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58)
                    .addComponent(colorT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(stockT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(jLabel56)
                    .addComponent(precioT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
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

        GroupLayout productoLayout = new GroupLayout(producto);
        producto.setLayout(productoLayout);
        productoLayout.setHorizontalGroup(
            productoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(productoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        productoLayout.setVerticalGroup(
            productoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(productoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        this.add(producto);
	}
	
	
	
	
	
	
	//ActionListener
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == alta1) {

			TransferProduct p = new TransferProduct();
			
			
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
			
			TransferProduct p = new TransferProduct();
			
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
				
				if ( datos instanceof Exceptions ) {
					
		    		JOptionPane.showMessageDialog(frame,((Exceptions)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
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

	    		if ( datos instanceof Exceptions ) {

	    			JFrame frame = new JFrame();
	    			JOptionPane.showMessageDialog(frame,((Exceptions)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
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
	 
	 public void actualizarVentanaConsulta(IDEventos idEvento, Object datos) {
			
			if ( IDEventos.EVENTO_CONSULTAR_UN_PRODUCTO == idEvento ) {
			
				if ( datos instanceof TransferProduct) {
					
					TransferProduct p = (TransferProduct) datos;
					
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

		 if ( IDEventos.EVENTO_LISTAR_PRODUCTOS == idEvento ) {
	    		
	    		if ( datos instanceof ArrayList) {
	    			
	    			 //Cargar datos en lists
	                @SuppressWarnings("unchecked")
					ArrayList<TransferProduct> arrayListp = (ArrayList<TransferProduct>) datos;
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

	                jList9.setModel(new AbstractListModel<Integer>() {
	                    Integer[] listIDModel = listIDListar;     
	                    public int getSize() { return listIDModel.length; }
	                    public Integer getElementAt(int i) { return listIDModel[i]; }
	                });
	                
	                jList16.setModel(new AbstractListModel<String>() {
	                    String[] listDNIModel = listTipoListar;     
	                    public int getSize() { return listDNIModel.length; }
	                    public String getElementAt(int i) { return listDNIModel[i]; }
	                });
	                
	                jList18.setModel(new AbstractListModel<Integer>() {
	                    Integer[] listNombreModel = listStockListar;     
	                    public int getSize() { return listNombreModel.length; }
	                    public Integer getElementAt(int i) { return listNombreModel[i]; }
	                });
	                
	                jList11.setModel(new AbstractListModel<Float>() {
	                    Float[] listApellidoModel = listPrecioListar;     
	                    public int getSize() { return listApellidoModel.length; }
	                    public Float getElementAt(int i) { return listApellidoModel[i]; }
	                });
	                
	                jList15.setModel(new AbstractListModel<Boolean>() {
	                    Boolean[] listLimiteModel = listActivoListar;     
	                    public int getSize() { return listLimiteModel.length; }
	                    public Boolean getElementAt(int i) { return listLimiteModel[i]; }
	                });
	                
	                jList14.setModel(new AbstractListModel<String>() {
	                    String[] listNewsModel = listMarcaListar;     
	                    public int getSize() { return listNewsModel.length; }
	                    public String getElementAt(int i) { return listNewsModel[i]; }
	                });
	                
	                jList17.setModel(new AbstractListModel<String>() {
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
	 
	 public void actualizarVentanaTop(IDEventos idEvento, Object datos) {

		 if ( IDEventos.EVENTO_TOP_PRODUCTO == idEvento ) {
	    		
	    		if ( datos instanceof TransferProduct) {
					
					TransferProduct p = (TransferProduct) datos;
					
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
