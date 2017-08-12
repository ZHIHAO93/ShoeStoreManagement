package presentacion.cliente;

import integracion.transacciones.conexion.Excepciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import presentacion.comando.IDEventos;
import presentacion.controlador.Controlador;
import negocio.cliente.TransferCliente;
import negocio.cliente.TransferQuery;


public class PanelCliente extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Auxiliares
	private final Object VACIO = null;
	private final Float CERO = (float) 0;
	
	private javax.swing.JTextField DNIA;
    private javax.swing.JTextField DNIC;
    private javax.swing.JTextField DNIM;
    private javax.swing.JTextField activoC;
    private javax.swing.JButton alta;
    private javax.swing.JPanel altaCliente;
    private javax.swing.JTextField apellidosA;
    private javax.swing.JTextField apellidosC;
    private javax.swing.JTextField apellidosM;
    private javax.swing.JButton baja;
    private javax.swing.JPanel bajaCliente;
    private javax.swing.JPanel cliente;
    private javax.swing.JPanel consultarUnCliente;
    private javax.swing.JTextField fechaFin;
    private javax.swing.JTextField fechaInicio;
    private javax.swing.JTextField idB;
    private javax.swing.JTextField idC;
    private javax.swing.JTextField idM;
    private javax.swing.JButton consultarUn;
    private javax.swing.JButton listar;
    private javax.swing.JButton topTen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1; //Id
    private javax.swing.JList jList2; //DNI
    private javax.swing.JList jList3; //Nombre
    private javax.swing.JList jList4; //Apellidos
    private javax.swing.JList jList5; //Limite
    private javax.swing.JList jList6; //News
    private javax.swing.JList jList7; //Activo
    private javax.swing.JList jList8; //Id
    private javax.swing.JList jList10; //DNI
    private javax.swing.JList jList12; //Nombre
    private javax.swing.JList jList13; //Apellidos
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField limiteCreditoA;
    private javax.swing.JTextField limiteCreditoC;
    private javax.swing.JTextField limiteCreditoM;
    private javax.swing.JPanel listarClientes;
    private javax.swing.JButton modificar;
    private javax.swing.JPanel modificarCliente;
    private javax.swing.JTextField nEuros;
    private javax.swing.JCheckBox newsletterA;
    private javax.swing.JCheckBox newsletterC;
    private javax.swing.JCheckBox newsletterM;
    private javax.swing.JTextField nombreA;
    private javax.swing.JTextField nombreC;
    private javax.swing.JTextField nombreM;
    private javax.swing.JPanel topTenClientes;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    
    //Listas listar
    private Integer[] listIDListar;
    private String[] listDNIListar;
    private String[] listNombreListar;
    private String[] listApellidoListar;
    private Float[] listLimiteListar;
    private Boolean[] listNewsListar;
    private Boolean[] listActivoListar;

    //Listas top
	private Integer[] listIDTop;
	private String[] listDNITop;
	private String[] listNombreTop;
	private String[] listApellidoTop;
    
	
	public PanelCliente() {
		initGUI();	
	}

	//Panel Cliente
	private void initGUI() {
		
        cliente = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        altaCliente = new javax.swing.JPanel();
        nombreA = new javax.swing.JTextField();
        apellidosA = new javax.swing.JTextField();
        newsletterA = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        limiteCreditoA = new javax.swing.JTextField();
        alta = new javax.swing.JButton();
        alta.addActionListener(this);
        jLabel4 = new javax.swing.JLabel();
        DNIA = new javax.swing.JTextField();
        bajaCliente = new javax.swing.JPanel();
        idB = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        baja = new javax.swing.JButton();
        baja.addActionListener(this);
        modificarCliente = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        DNIM = new javax.swing.JTextField();
        nombreM = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        apellidosM = new javax.swing.JTextField();
        newsletterM = new javax.swing.JCheckBox();
        limiteCreditoM = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        modificar = new javax.swing.JButton();
        modificar.addActionListener(this);
        jSeparator1 = new javax.swing.JSeparator();
        idM = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        consultarUnCliente = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        idC = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        nombreC = new javax.swing.JTextField();
        apellidosC = new javax.swing.JTextField();
        newsletterC = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        limiteCreditoC = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        DNIC = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        activoC = new javax.swing.JTextField();
        consultarUn = new javax.swing.JButton();
        consultarUn.addActionListener(this);
        listarClientes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList7 = new javax.swing.JList();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        listar = new javax.swing.JButton();
        listar.addActionListener(this);
        topTenClientes = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList8 = new javax.swing.JList();
        jScrollPane11 = new javax.swing.JScrollPane();
        jList10 = new javax.swing.JList();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jList12 = new javax.swing.JList();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jList13 = new javax.swing.JList();
        jLabel28 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        topTen = new javax.swing.JButton();
        topTen.addActionListener(this);
        jLabel24 = new javax.swing.JLabel();
        nEuros = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        fechaInicio = new javax.swing.JTextField();
        fechaInicio.setToolTipText("AAAA-MM-DD");
        
        jLabel30 = new javax.swing.JLabel();
        fechaFin = new javax.swing.JTextField();
        fechaFin.setToolTipText("AAAA-MM-DD"); 
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

     

        jLabel1.setText("DNI:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellidos:");

        alta.setText("Alta");

        jLabel4.setText("Limite credito:");
        
        jLabel31.setText("NewsLetter");


        javax.swing.GroupLayout altaClienteLayout = new javax.swing.GroupLayout(altaCliente);
        altaCliente.setLayout(altaClienteLayout);
        altaClienteLayout.setHorizontalGroup(
            altaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altaClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(alta)
                .addGap(29, 29, 29))
            .addGroup(altaClienteLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(altaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(altaClienteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DNIA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(altaClienteLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(altaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altaClienteLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(altaClienteLayout.createSequentialGroup()
                                .addComponent(limiteCreditoA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(newsletterA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(apellidosA, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        altaClienteLayout.setVerticalGroup(
            altaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altaClienteLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(altaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DNIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(apellidosA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(altaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limiteCreditoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(newsletterA)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(alta)
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Alta", altaCliente);

        jLabel9.setText("ID cliente:");

        baja.setText("Baja");

        javax.swing.GroupLayout bajaClienteLayout = new javax.swing.GroupLayout(bajaCliente);
        bajaCliente.setLayout(bajaClienteLayout);
        bajaClienteLayout.setHorizontalGroup(
            bajaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bajaClienteLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bajaClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(baja)
                .addGap(65, 65, 65))
        );
        bajaClienteLayout.setVerticalGroup(
            bajaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bajaClienteLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(bajaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addComponent(baja)
                .addGap(50, 50, 50))
        );

        jTabbedPane1.addTab("Baja", bajaCliente);

        jLabel5.setText("DNI:");


        jLabel6.setText("Nombre:");

        jLabel7.setText("Apellidos:");


        jLabel8.setText("Limite credito:");

        modificar.setText("Modificar");

        jLabel10.setText("ID Cliente:");
        
        jLabel32.setText("NewsLetter");

        javax.swing.GroupLayout modificarClienteLayout = new javax.swing.GroupLayout(modificarCliente);
        modificarCliente.setLayout(modificarClienteLayout);
        modificarClienteLayout.setHorizontalGroup(
            modificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modificarClienteLayout.createSequentialGroup()
                .addContainerGap(496, Short.MAX_VALUE)
                .addComponent(modificar)
                .addGap(19, 19, 19))
            .addGroup(modificarClienteLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(modificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modificarClienteLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(modificarClienteLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(modificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modificarClienteLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreM, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(modificarClienteLayout.createSequentialGroup()
                                .addComponent(limiteCreditoM, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(newsletterM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(apellidosM, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addContainerGap())
            .addGroup(modificarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(modificarClienteLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idM, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        modificarClienteLayout.setVerticalGroup(
            modificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modificarClienteLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(modificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(modificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addGap(30, 30, 30)
                    .addComponent(apellidosM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(modificarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limiteCreditoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(newsletterM)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(modificar)
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Modificar", modificarCliente);

        jLabel11.setText("ID Cliente:");

      

        jLabel12.setText("DNI:");

        jLabel13.setText("Nombre:");

        jLabel14.setText("Apellidos:");

        jLabel15.setText("Limite credito:");


        jLabel16.setText("Activo:");

        consultarUn.setText("Consultar");
        
        jLabel33.setText("NewsLetter");
        

        javax.swing.GroupLayout consultarUnClienteLayout = new javax.swing.GroupLayout(consultarUnCliente);
        consultarUnCliente.setLayout(consultarUnClienteLayout);
        consultarUnClienteLayout.setHorizontalGroup(
            consultarUnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultarUnClienteLayout.createSequentialGroup()
                .addGroup(consultarUnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consultarUnClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(consultarUnClienteLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultarUnClienteLayout.createSequentialGroup()
                .addGap(0, 378, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(consultarUnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consultarUn)
                    .addComponent(activoC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
            .addGroup(consultarUnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(consultarUnClienteLayout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(consultarUnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(consultarUnClienteLayout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(DNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(consultarUnClienteLayout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(consultarUnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultarUnClienteLayout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(nombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(consultarUnClienteLayout.createSequentialGroup()
                                    .addComponent(limiteCreditoC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(newsletterC)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel33)))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                    .addComponent(jLabel14)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(apellidosC, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)))
        );
        consultarUnClienteLayout.setVerticalGroup(
            consultarUnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultarUnClienteLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(consultarUnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(idC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addGroup(consultarUnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(activoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103)
                .addComponent(consultarUn)
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(consultarUnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(consultarUnClienteLayout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addGroup(consultarUnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14)
                        .addComponent(apellidosC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(41, 41, 41)
                    .addGroup(consultarUnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(limiteCreditoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(newsletterC)
                        .addComponent(jLabel33))
                    .addContainerGap(223, Short.MAX_VALUE)))
        );

        DNIC.setEditable(false);
        nombreC.setEditable(false);
        apellidosC.setEditable(false);
        limiteCreditoC.setEditable(false);
        newsletterC.setEnabled(false);
        activoC.setEditable(false);
        
        
        jTabbedPane1.addTab("Consultar", consultarUnCliente);

       
       
           
            //Listas
       
        jScrollPane2.setViewportView(jList1);

        
        jScrollPane3.setViewportView(jList2);

        
        jScrollPane4.setViewportView(jList3);

        
        jScrollPane5.setViewportView(jList4);

        
        jScrollPane6.setViewportView(jList5);

        
        jScrollPane7.setViewportView(jList6);

        
        jScrollPane8.setViewportView(jList7);
        

        jLabel17.setText("ID");

        jLabel18.setText("DNI");

        jLabel19.setText("Nombre");

        jLabel20.setText("Apellidos");

        jLabel21.setText("Limite");

        jLabel22.setText("NewsLt");

        jLabel23.setText("Activo");

        listar.setText("Listar");

        javax.swing.GroupLayout listarClientesLayout = new javax.swing.GroupLayout(listarClientes);
        listarClientes.setLayout(listarClientesLayout);
        listarClientesLayout.setHorizontalGroup(
            listarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listarClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(listarClientesLayout.createSequentialGroup()
                        .addGroup(listarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(listar)
                            .addGroup(listarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(listarClientesLayout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(50, 50, 50)
                                    .addComponent(jLabel18)
                                    .addGap(69, 69, 69)
                                    .addComponent(jLabel19)
                                    .addGap(95, 95, 95)
                                    .addComponent(jLabel20)
                                    .addGap(104, 104, 104)
                                    .addComponent(jLabel21)
                                     .addGap(20, 20, 20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel23))
                                .addGroup(listarClientesLayout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        listarClientesLayout.setVerticalGroup(
            listarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listarClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(listarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listar)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Listar", listarClientes);

        
        //Listas top
        jScrollPane9.setViewportView(jList8);

        
        jScrollPane11.setViewportView(jList10);

        jLabel25.setText("ID");

       
        jScrollPane13.setViewportView(jList12);

        jLabel26.setText("DNI");

        jLabel27.setText("Nombre");

        
        jScrollPane14.setViewportView(jList13);

        jLabel28.setText("Apellidos");

        topTen.setText("Top 10");

        jLabel24.setText("Euros:");

        jLabel29.setText("F.Inicio:");

        jLabel30.setText("F.Fin:");

        javax.swing.GroupLayout topTenClientesLayout = new javax.swing.GroupLayout(topTenClientes);
        topTenClientes.setLayout(topTenClientesLayout);
        topTenClientesLayout.setHorizontalGroup(
            topTenClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topTenClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topTenClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topTenClientesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(topTen))
                    .addGroup(topTenClientesLayout.createSequentialGroup()
                        .addGroup(topTenClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(topTenClientesLayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaInicio))
                            .addGroup(topTenClientesLayout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechaFin))
                            .addGroup(topTenClientesLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nEuros, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(topTenClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4)
                            .addGroup(topTenClientesLayout.createSequentialGroup()
                                .addGroup(topTenClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(topTenClientesLayout.createSequentialGroup()
                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(topTenClientesLayout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel26)
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel27)
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabel28)))
                                .addGap(0, 44, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        topTenClientesLayout.setVerticalGroup(
            topTenClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topTenClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topTenClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(topTenClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topTenClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(topTenClientesLayout.createSequentialGroup()
                        .addGroup(topTenClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(nEuros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(topTenClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(topTenClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(topTen)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Top 10", topTenClientes);

        javax.swing.GroupLayout clienteLayout = new javax.swing.GroupLayout(cliente);
        cliente.setLayout(clienteLayout);
        clienteLayout.setHorizontalGroup(
            clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        clienteLayout.setVerticalGroup(
            clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
      
        this.add(cliente);

	}

	
	//ActionListener
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == alta) {

			TransferCliente c = new TransferCliente();
			
			if(!DNIA.getText().equals("") && !nombreA.getText().equals("") && !apellidosA.getText().equals("") && !limiteCreditoA.getText().equals("")) {
				
				c.setDNI(DNIA.getText());
				c.setNombre(nombreA.getText());
				c.setApellidos(apellidosA.getText());
				c.setLimiteCredito(Float.parseFloat(limiteCreditoA.getText()));
				c.setNewsletter(newsletterA.isSelected());
				
				Controlador.getInstance().handleRequest(IDEventos.EVENTO_ALTA_CLIENTE, c);
			}
			else {
				JFrame frameError = new JFrame();
				JOptionPane.showMessageDialog(frameError, "Error de formato en los datos de entrada", "Error en alta", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		else if(e.getSource() == baja) {
			
			if(!idB.getText().equals("")) {
				
				Controlador.getInstance().handleRequest(IDEventos.EVENTO_BAJA_CLIENTE, Integer.parseInt(idB.getText()));
			}
			else {	
				JFrame frameError = new JFrame();
				JOptionPane.showMessageDialog(frameError, "Error de formato en los datos de entrada", "Error en baja", JOptionPane.WARNING_MESSAGE);
			}
			
			
			
		} 
		else if(e.getSource() == modificar) {
			
			TransferCliente c = new TransferCliente();
			
			if(!idM.getText().equals("")){
				
					if(!DNIM.getText().equals("") && !nombreM.getText().equals("") && !apellidosM.getText().equals("") && 
							!limiteCreditoM.getText().equals("")) {
						
					c.setIDCliente(Integer.parseInt(idM.getText()));
					c.setDNI(DNIM.getText());
					c.setNombre(nombreM.getText());
					c.setApellidos(apellidosM.getText());
					c.setLimiteCredito(Float.parseFloat(limiteCreditoM.getText()));
					c.setNewsletter(newsletterM.isSelected());
					
					Controlador.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_CLIENTE, c);
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
				
				Controlador.getInstance().handleRequest(IDEventos.EVENTO_CONSULTAR_UN_CLIENTE, Integer.parseInt(idC.getText()));
			}
			else {
				JFrame frameError = new JFrame();
				JOptionPane.showMessageDialog(frameError, "Error de formato en los datos de entrada", "Error en consultar un cliente", JOptionPane.WARNING_MESSAGE);
			}
		} 
		else if(e.getSource() == listar) {
			
			Controlador.getInstance().handleRequest(IDEventos.EVENTO_LISTAR_CLIENTES, VACIO);	
			
		} 
		else if(e.getSource() == topTen) {
			
			TransferQuery topCli = new TransferQuery();
			
			if(!nEuros.getText().equals("") && !fechaInicio.getText().equals("") && !fechaFin.getText().equals("")) {
				
				topCli.setnEuros(Float.parseFloat(nEuros.getText()));
				topCli.setFechaInicio(fechaInicio.getText());
				topCli.setFechaFin(fechaFin.getText());
				
				Controlador.getInstance().handleRequest(IDEventos.EVENTO_TOP_TEN_CLIENTES, topCli);
			}
			else {
				JFrame frameError = new JFrame();
				JOptionPane.showMessageDialog(frameError, "Error de formato en los datos de entrada", "Error en top 10 clientes", JOptionPane.WARNING_MESSAGE);
			}	
				
		} 
	}
	
	 public void actualizarVentanaAlta(IDEventos idEvento, Object datos) {
			
			if ( IDEventos.EVENTO_ALTA_CLIENTE == idEvento ) {
				if(datos instanceof Boolean)
				{
					Boolean correcto = (Boolean) datos;
					
					if (correcto) {

			    		DNIA.setText(""); 
						nombreA.setText(""); 
						apellidosA.setText("");
						limiteCreditoA.setText("");
						newsletterA.setSelected(false);
						
						
						JFrame frame = new JFrame();
			    		JOptionPane.showMessageDialog(frame,"Cliente dado de alta", "Correcto", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JFrame frame = new JFrame();
			    		JOptionPane.showMessageDialog(frame,"Error en alta cliente", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			else if ( IDEventos.ERROR_EVENTO_ALTA_CLIENTE == idEvento ) {
				
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
	    	
	    	if ( IDEventos.EVENTO_BAJA_CLIENTE == idEvento ) {

	    		if ( datos instanceof Boolean ) {

	    			Boolean correcto = (Boolean) datos;

	    			if (correcto) {
	    				
	    				idB.setText("");

	    				JFrame frame = new JFrame();
			    		JOptionPane.showMessageDialog(frame,"Cliente dado de baja", "Correcto", JOptionPane.INFORMATION_MESSAGE);
	    			}
	    			else {

	    				JFrame frame = new JFrame();
			    		JOptionPane.showMessageDialog(frame,"Error en baja cliente", "Error", JOptionPane.ERROR_MESSAGE);
	    			}
	    		}
	    	}
	    	else if ( IDEventos.ERROR_EVENTO_BAJA_CLIENTE == idEvento) {

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
		    
	    	if ( IDEventos.EVENTO_MODIFICAR_CLIENTE == idEvento ) {
				
				if ( datos instanceof Boolean ) {
					
					Boolean correcto = (Boolean) datos;
					
					if (correcto) {
						
						idM.setText("");
						DNIM.setText("");
						nombreM.setText("");
						apellidosM.setText("");
						limiteCreditoM.setText("");
						newsletterM.setSelected(false);
						
						
						
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "Cliente modificado", "Correcto", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "Error en modificar cliente", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			else if ( IDEventos.ERROR_EVENTO_MODIFICAR_CLIENTE == idEvento) {
				
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
			
			if ( IDEventos.EVENTO_CONSULTAR_UN_CLIENTE == idEvento ) {
			
				if ( datos instanceof TransferCliente) {
					
					TransferCliente c = (TransferCliente) datos;
					
					if ( c != null ) {
						
						DNIC.setText(c.getDNI());
						nombreC.setText(c.getNombre());
						apellidosC.setText(c.getApellidos());
						if(c.getLimiteCredito() != null) {
							limiteCreditoC.setText(c.getLimiteCredito().toString());
							newsletterC.setSelected(false);
	                	}
	                	else {
	                		limiteCreditoC.setText(CERO.toString());
	                		newsletterC.setSelected(c.getNewsletter());
	                	}
						
							
						activoC.setText(c.getActivo().toString());
						
					}		
				}
				else {
					JFrame frame = new JFrame();
		    		JOptionPane.showMessageDialog(frame,"Error al consultar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if ( IDEventos.ERROR_EVENTO_CONSULTAR_UN_CLIENTE == idEvento ) {
				
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

	    	if ( IDEventos.EVENTO_LISTAR_CLIENTES == idEvento ) {
	    		
	    		if ( datos instanceof ArrayList) {

	    			
	    			 //Cargar datos en lists
	                @SuppressWarnings("unchecked")
					ArrayList<TransferCliente> arrayListc = (ArrayList<TransferCliente>) datos;
	                listIDListar = new Integer[arrayListc.size()];
	                listDNIListar = new String[arrayListc.size()];
	                listNombreListar = new String[arrayListc.size()];
	                listApellidoListar = new String[arrayListc.size()];
	                listLimiteListar = new Float[arrayListc.size()];
	                listNewsListar = new Boolean[arrayListc.size()];
	                listActivoListar = new Boolean[arrayListc.size()];
	                
	                for(int i = 0; i < arrayListc.size(); i++) {
	                	listIDListar[i] = arrayListc.get(i).getIDCliente();
	                	listDNIListar[i] = arrayListc.get(i).getDNI();
	                	listNombreListar[i] = arrayListc.get(i).getNombre();
	                	listApellidoListar[i] = arrayListc.get(i).getApellidos();
	                	if(arrayListc.get(i).getLimiteCredito() != null) {
	                		listLimiteListar[i] = arrayListc.get(i).getLimiteCredito();
	                	}
	                	else {
	                		listLimiteListar[i] = CERO;
	                	}
	                	listNewsListar[i] = arrayListc.get(i).getNewsletter();
	                	listActivoListar[i] = arrayListc.get(i).getActivo();

	                	jList1.setSelectedIndex(i);
	                	jList2.setSelectedIndex(i);
	                	jList3.setSelectedIndex(i);
	                	jList4.setSelectedIndex(i);
	                	jList5.setSelectedIndex(i);
	                	jList6.setSelectedIndex(i);
	                	jList7.setSelectedIndex(i);
	                	
	                }
	               
	                
	                jList1.setModel(new javax.swing.AbstractListModel() {
	                    Integer[] listIDModel = listIDListar;     
	                    public int getSize() { return listIDModel.length; }
	                    public Integer getElementAt(int i) { return listIDModel[i]; }
	                });
	                
	                jList2.setModel(new javax.swing.AbstractListModel() {
	                    String[] listDNIModel = listDNIListar;     
	                    public int getSize() { return listDNIModel.length; }
	                    public String getElementAt(int i) { return listDNIModel[i]; }
	                });
	                
	                jList3.setModel(new javax.swing.AbstractListModel() {
	                    String[] listNombreModel = listNombreListar;     
	                    public int getSize() { return listNombreModel.length; }
	                    public String getElementAt(int i) { return listNombreModel[i]; }
	                });
	                
	                jList4.setModel(new javax.swing.AbstractListModel() {
	                    String[] listApellidoModel = listApellidoListar;     
	                    public int getSize() { return listApellidoModel.length; }
	                    public String getElementAt(int i) { return listApellidoModel[i]; }
	                });
	                
	                jList5.setModel(new javax.swing.AbstractListModel() {
	                    Float[] listLimiteModel = listLimiteListar;     
	                    public int getSize() { return listLimiteModel.length; }
	                    public Float getElementAt(int i) { return listLimiteModel[i]; }
	                });
	                
	                jList6.setModel(new javax.swing.AbstractListModel() {
	                    Boolean[] listNewsModel = listNewsListar;     
	                    public int getSize() { return listNewsModel.length; }
	                    public Boolean getElementAt(int i) { return listNewsModel[i]; }
	                });
	                
	                jList7.setModel(new javax.swing.AbstractListModel() {
	                	Boolean[] listActivoModel = listActivoListar;     
	                    public int getSize() { return listActivoModel.length; }
	                    public Boolean getElementAt(int i) { return listActivoModel[i]; }
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
	    			JOptionPane.showMessageDialog(frame,"Excepcion controlada", "Error", JOptionPane.ERROR_MESSAGE);
	    		}
	    	}
	    }
	 
	 
	 @SuppressWarnings("serial")
	public void actualizarVentanaTopTen(IDEventos idEvento, Object datos) {

	    	if ( IDEventos.EVENTO_TOP_TEN_CLIENTES == idEvento ) {
	    		
	    		if ( datos instanceof ArrayList) {

	    			
	    			 //Cargar datos en lists
	                @SuppressWarnings("unchecked")
					ArrayList<TransferCliente> arrayListc = (ArrayList<TransferCliente>) datos;
	                listIDTop = new Integer[arrayListc.size()];
	                listDNITop = new String[arrayListc.size()];
	                listNombreTop = new String[arrayListc.size()];
	                listApellidoTop = new String[arrayListc.size()];
	                
	                
	                for(int i = 0; i < arrayListc.size(); i++) {
	                	listIDTop[i] = arrayListc.get(i).getIDCliente();
	                	listDNITop[i] = arrayListc.get(i).getDNI();
	                	listNombreTop[i] = arrayListc.get(i).getNombre();
	                	listApellidoTop[i] = arrayListc.get(i).getApellidos();
	                	

	                	jList8.setSelectedIndex(i);
	                	jList10.setSelectedIndex(i);
	                	jList12.setSelectedIndex(i);
	                	jList13.setSelectedIndex(i);
	                	
	                	
	                }
	               
	                
	                jList8.setModel(new javax.swing.AbstractListModel() {
	                    Integer[] listIDModel = listIDTop;     
	                    public int getSize() { return listIDModel.length; }
	                    public Integer getElementAt(int i) { return listIDModel[i]; }
	                });
	                
	                jList10.setModel(new javax.swing.AbstractListModel() {
	                    String[] listDNIModel = listDNITop;     
	                    public int getSize() { return listDNIModel.length; }
	                    public String getElementAt(int i) { return listDNIModel[i]; }
	                });
	                
	                jList12.setModel(new javax.swing.AbstractListModel() {
	                    String[] listNombreModel = listNombreTop;     
	                    public int getSize() { return listNombreModel.length; }
	                    public String getElementAt(int i) { return listNombreModel[i]; }
	                });
	                
	                jList13.setModel(new javax.swing.AbstractListModel() {
	                    String[] listApellidoModel = listApellidoTop;     
	                    public int getSize() { return listApellidoModel.length; }
	                    public String getElementAt(int i) { return listApellidoModel[i]; }
	                });
	                
	               
	    			

	    		}
	    		else {
	    			JFrame frame = new JFrame();
		    		JOptionPane.showMessageDialog(frame,"Error al en top 10 clientes", "Error", JOptionPane.ERROR_MESSAGE);
	    		}
	    	}
	    	else if ( IDEventos.ERROR_EVENTO_TOP_TEN_CLIENTES== idEvento ) {

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
