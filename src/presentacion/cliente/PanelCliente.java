package presentacion.cliente;

import javax.swing.*;

import business.customer.TransferCustomer;
import business.customer.TransferQuery;
import dao.transations.connection.Exceptions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import presentacion.comando.IDEventos;
import presentacion.controlador.Controlador;


public class PanelCliente extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Auxiliares
	private final Object VACIO = null;
	private final Float CERO = (float) 0;
	
	private JTextField DNIA;
    private JTextField DNIC;
    private JTextField DNIM;
    private JTextField activoC;
    private JButton alta;
    private JPanel altaCliente;
    private JTextField apellidosA;
    private JTextField apellidosC;
    private JTextField apellidosM;
    private JButton baja;
    private JPanel bajaCliente;
    private JPanel cliente;
    private JPanel consultarUnCliente;
    private JTextField fechaFin;
    private JTextField fechaInicio;
    private JTextField idB;
    private JTextField idC;
    private JTextField idM;
    private JButton consultarUn;
    private JButton listar;
    private JButton topTen;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel30;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JList<Integer> jList1; //Id
    private JList<String> jList2; //DNI
    private JList<String> jList3; //Nombre
    private JList<String> jList4; //Apellidos
    private JList<Float> jList5; //Limite
    private JList<Boolean> jList6; //News
    private JList<Boolean> jList7; //Activo
    private JList<Integer> jList8; //Id
    private JList<String> jList10; //DNI
    private JList<String> jList12; //Nombre
    private JList<String> jList13; //Apellidos
    private JScrollPane jScrollPane11;
    private JScrollPane jScrollPane13;
    private JScrollPane jScrollPane14;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane8;
    private JScrollPane jScrollPane9;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JTabbedPane jTabbedPane1;
    private JTextField limiteCreditoA;
    private JTextField limiteCreditoC;
    private JTextField limiteCreditoM;
    private JPanel listarClientes;
    private JButton modificar;
    private JPanel modificarCliente;
    private JTextField nEuros;
    private JCheckBox newsletterA;
    private JCheckBox newsletterC;
    private JCheckBox newsletterM;
    private JTextField nombreA;
    private JTextField nombreC;
    private JTextField nombreM;
    private JPanel topTenClientes;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    
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
		
        cliente = new JPanel();
        jTabbedPane1 = new JTabbedPane();
        altaCliente = new JPanel();
        nombreA = new JTextField();
        apellidosA = new JTextField();
        newsletterA = new JCheckBox();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        limiteCreditoA = new JTextField();
        alta = new JButton();
        alta.addActionListener(this);
        jLabel4 = new JLabel();
        DNIA = new JTextField();
        bajaCliente = new JPanel();
        idB = new JTextField();
        jLabel9 = new JLabel();
        baja = new JButton();
        baja.addActionListener(this);
        modificarCliente = new JPanel();
        jLabel5 = new JLabel();
        DNIM = new JTextField();
        nombreM = new JTextField();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        apellidosM = new JTextField();
        newsletterM = new JCheckBox();
        limiteCreditoM = new JTextField();
        jLabel8 = new JLabel();
        modificar = new JButton();
        modificar.addActionListener(this);
        jSeparator1 = new JSeparator();
        idM = new JTextField();
        jLabel10 = new JLabel();
        consultarUnCliente = new JPanel();
        jLabel11 = new JLabel();
        idC = new JTextField();
        jSeparator2 = new JSeparator();
        nombreC = new JTextField();
        apellidosC = new JTextField();
        newsletterC = new JCheckBox();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        limiteCreditoC = new JTextField();
        jLabel15 = new JLabel();
        DNIC = new JTextField();
        jLabel16 = new JLabel();
        activoC = new JTextField();
        consultarUn = new JButton();
        consultarUn.addActionListener(this);
        listarClientes = new JPanel();
        jScrollPane2 = new JScrollPane();
        jList1 = new JList<Integer>();
        jScrollPane3 = new JScrollPane();
        jList2 = new JList<String>();
        jScrollPane4 = new JScrollPane();
        jList3 = new JList<String>();
        jScrollPane5 = new JScrollPane();
        jList4 = new JList<String>();
        jSeparator3 = new JSeparator();
        jScrollPane6 = new JScrollPane();
        jList5 = new JList<Float>();
        jScrollPane7 = new JScrollPane();
        jList6 = new JList<Boolean>();
        jScrollPane8 = new JScrollPane();
        jList7 = new JList<Boolean>();
        jLabel17 = new JLabel();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        jLabel22 = new JLabel();
        jLabel23 = new JLabel();
        listar = new JButton();
        listar.addActionListener(this);
        topTenClientes = new JPanel();
        jScrollPane9 = new JScrollPane();
        jList8 = new JList<Integer>();
        jScrollPane11 = new JScrollPane();
        jList10 = new JList<String>();
        jLabel25 = new JLabel();
        jScrollPane13 = new JScrollPane();
        jList12 = new JList<String>();
        jLabel26 = new JLabel();
        jLabel27 = new JLabel();
        jScrollPane14 = new JScrollPane();
        jList13 = new JList<String>();
        jLabel28 = new JLabel();
        jSeparator4 = new JSeparator();
        topTen = new JButton();
        topTen.addActionListener(this);
        jLabel24 = new JLabel();
        nEuros = new JTextField();
        jLabel29 = new JLabel();
        fechaInicio = new JTextField();
        fechaInicio.setToolTipText("AAAA-MM-DD");
        
        jLabel30 = new JLabel();
        fechaFin = new JTextField();
        fechaFin.setToolTipText("AAAA-MM-DD"); 
        jLabel31 = new JLabel();
        jLabel32 = new JLabel();
        jLabel33 = new JLabel();

     

        jLabel1.setText("DNI:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellidos:");

        alta.setText("Alta");

        jLabel4.setText("Limite credito:");
        
        jLabel31.setText("NewsLetter");


        GroupLayout altaClienteLayout = new GroupLayout(altaCliente);
        altaCliente.setLayout(altaClienteLayout);
        altaClienteLayout.setHorizontalGroup(
            altaClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, altaClienteLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(alta)
                .addGap(29, 29, 29))
            .addGroup(altaClienteLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(altaClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(altaClienteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DNIA, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                    .addGroup(altaClienteLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(altaClienteLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addGroup(GroupLayout.Alignment.TRAILING, altaClienteLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreA, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                            .addGroup(altaClienteLayout.createSequentialGroup()
                                .addComponent(limiteCreditoA, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(newsletterA)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31)))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(apellidosA, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        altaClienteLayout.setVerticalGroup(
            altaClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, altaClienteLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(altaClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(DNIA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(apellidosA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(altaClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(limiteCreditoA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(newsletterA)
                    .addComponent(jLabel31))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(alta)
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Alta", altaCliente);

        jLabel9.setText("ID cliente:");

        baja.setText("Baja");

        GroupLayout bajaClienteLayout = new GroupLayout(bajaCliente);
        bajaCliente.setLayout(bajaClienteLayout);
        bajaClienteLayout.setHorizontalGroup(
            bajaClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bajaClienteLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idB, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, bajaClienteLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(baja)
                .addGap(65, 65, 65))
        );
        bajaClienteLayout.setVerticalGroup(
            bajaClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bajaClienteLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(bajaClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(idB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
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

        GroupLayout modificarClienteLayout = new GroupLayout(modificarCliente);
        modificarCliente.setLayout(modificarClienteLayout);
        modificarClienteLayout.setHorizontalGroup(
            modificarClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, modificarClienteLayout.createSequentialGroup()
                .addContainerGap(496, Short.MAX_VALUE)
                .addComponent(modificar)
                .addGap(19, 19, 19))
            .addGroup(modificarClienteLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(modificarClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(modificarClienteLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DNIM, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                    .addGroup(modificarClienteLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(modificarClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, modificarClienteLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreM, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                            .addGroup(modificarClienteLayout.createSequentialGroup()
                                .addComponent(limiteCreditoM, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(newsletterM)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32)))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(apellidosM, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addContainerGap())
            .addGroup(modificarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(modificarClienteLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel10)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idM, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        modificarClienteLayout.setVerticalGroup(
            modificarClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, modificarClienteLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(modificarClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(idM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(modificarClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(DNIM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addGap(30, 30, 30)
                    .addComponent(apellidosM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(modificarClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(limiteCreditoM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(newsletterM)
                    .addComponent(jLabel32))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
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
        

        GroupLayout consultarUnClienteLayout = new GroupLayout(consultarUnCliente);
        consultarUnCliente.setLayout(consultarUnClienteLayout);
        consultarUnClienteLayout.setHorizontalGroup(
            consultarUnClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(consultarUnClienteLayout.createSequentialGroup()
                .addGroup(consultarUnClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(consultarUnClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(consultarUnClienteLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel11)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, consultarUnClienteLayout.createSequentialGroup()
                .addGap(0, 378, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(consultarUnClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(consultarUn)
                    .addComponent(activoC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
            .addGroup(consultarUnClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(consultarUnClienteLayout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(consultarUnClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(consultarUnClienteLayout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(DNIC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addGroup(consultarUnClienteLayout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(consultarUnClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, consultarUnClienteLayout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(nombreC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                .addGroup(consultarUnClienteLayout.createSequentialGroup()
                                    .addComponent(limiteCreditoC, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(newsletterC)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel33)))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                    .addComponent(jLabel14)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(apellidosC, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)))
        );
        consultarUnClienteLayout.setVerticalGroup(
            consultarUnClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(consultarUnClienteLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(consultarUnClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(idC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addGroup(consultarUnClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(activoC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103)
                .addComponent(consultarUn)
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(consultarUnClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(consultarUnClienteLayout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addGroup(consultarUnClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(DNIC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14)
                        .addComponent(apellidosC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(41, 41, 41)
                    .addGroup(consultarUnClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(limiteCreditoC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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

        GroupLayout listarClientesLayout = new GroupLayout(listarClientes);
        listarClientes.setLayout(listarClientesLayout);
        listarClientesLayout.setHorizontalGroup(
            listarClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(listarClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listarClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(listarClientesLayout.createSequentialGroup()
                        .addGroup(listarClientesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(listar)
                            .addGroup(listarClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
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
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel22)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel23))
                                .addGroup(listarClientesLayout.createSequentialGroup()
                                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane7, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane8, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        listarClientesLayout.setVerticalGroup(
            listarClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(listarClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listarClientesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(listarClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane8, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        GroupLayout topTenClientesLayout = new GroupLayout(topTenClientes);
        topTenClientes.setLayout(topTenClientesLayout);
        topTenClientesLayout.setHorizontalGroup(
            topTenClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(topTenClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topTenClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(topTenClientesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(topTen))
                    .addGroup(topTenClientesLayout.createSequentialGroup()
                        .addGroup(topTenClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(topTenClientesLayout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaInicio))
                            .addGroup(topTenClientesLayout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechaFin))
                            .addGroup(topTenClientesLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nEuros, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(topTenClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4)
                            .addGroup(topTenClientesLayout.createSequentialGroup()
                                .addGroup(topTenClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(topTenClientesLayout.createSequentialGroup()
                                        .addComponent(jScrollPane9, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane11, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane13, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane14, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
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
            topTenClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(topTenClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topTenClientesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(topTenClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(topTenClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane13, GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane11, GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane9, GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane14, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE))
                    .addGroup(topTenClientesLayout.createSequentialGroup()
                        .addGroup(topTenClientesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(nEuros, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(topTenClientesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(fechaInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(topTenClientesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(fechaFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(topTen)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Top 10", topTenClientes);

        GroupLayout clienteLayout = new GroupLayout(cliente);
        cliente.setLayout(clienteLayout);
        clienteLayout.setHorizontalGroup(
            clienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        clienteLayout.setVerticalGroup(
            clienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
      
        this.add(cliente);

	}

	
	//ActionListener
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == alta) {

			TransferCustomer c = new TransferCustomer();
			
			if(!DNIA.getText().equals("") && !nombreA.getText().equals("") && !apellidosA.getText().equals("") && !limiteCreditoA.getText().equals("")) {
				
				c.setIdNumber(DNIA.getText());
				c.setName(nombreA.getText());
				c.setLastName(apellidosA.getText());
				c.setCreditLimit(Float.parseFloat(limiteCreditoA.getText()));
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
			
			TransferCustomer c = new TransferCustomer();
			
			if(!idM.getText().equals("")){
				
					if(!DNIM.getText().equals("") && !nombreM.getText().equals("") && !apellidosM.getText().equals("") && 
							!limiteCreditoM.getText().equals("")) {
						
					c.setIdCustomer(Integer.parseInt(idM.getText()));
					c.setIdNumber(DNIM.getText());
					c.setName(nombreM.getText());
					c.setLastName(apellidosM.getText());
					c.setCreditLimit(Float.parseFloat(limiteCreditoM.getText()));
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
				
				topCli.setNEuros(Float.parseFloat(nEuros.getText()));
				topCli.setStartDate(fechaInicio.getText());
				topCli.setFinalDate(fechaFin.getText());
				
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
				
				if ( datos instanceof Exceptions ) {
					
		    		JOptionPane.showMessageDialog(frame,((Exceptions)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
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
			
			if ( IDEventos.EVENTO_CONSULTAR_UN_CLIENTE == idEvento ) {
			
				if ( datos instanceof TransferCustomer) {
					
					TransferCustomer c = (TransferCustomer) datos;
					
					if ( c != null ) {
						
						DNIC.setText(c.getIdNumber());
						nombreC.setText(c.getName());
						apellidosC.setText(c.getLastName());
						if(c.getCreditLimit() != null) {
							limiteCreditoC.setText(c.getCreditLimit().toString());
							newsletterC.setSelected(false);
	                	}
	                	else {
	                		limiteCreditoC.setText(CERO.toString());
	                		newsletterC.setSelected(c.getNewsletter());
	                	}
						
							
						activoC.setText(c.getEnable().toString());
						
					}		
				}
				else {
					JFrame frame = new JFrame();
		    		JOptionPane.showMessageDialog(frame,"Error al consultar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if ( IDEventos.ERROR_EVENTO_CONSULTAR_UN_CLIENTE == idEvento ) {
				
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

	    	if ( IDEventos.EVENTO_LISTAR_CLIENTES == idEvento ) {
	    		
	    		if ( datos instanceof ArrayList) {

	    			
	    			 //Cargar datos en lists
	                @SuppressWarnings("unchecked")
					ArrayList<TransferCustomer> arrayListc = (ArrayList<TransferCustomer>) datos;
	                listIDListar = new Integer[arrayListc.size()];
	                listDNIListar = new String[arrayListc.size()];
	                listNombreListar = new String[arrayListc.size()];
	                listApellidoListar = new String[arrayListc.size()];
	                listLimiteListar = new Float[arrayListc.size()];
	                listNewsListar = new Boolean[arrayListc.size()];
	                listActivoListar = new Boolean[arrayListc.size()];
	                
	                for(int i = 0; i < arrayListc.size(); i++) {
	                	listIDListar[i] = arrayListc.get(i).getIdCustomer();
	                	listDNIListar[i] = arrayListc.get(i).getIdNumber();
	                	listNombreListar[i] = arrayListc.get(i).getName();
	                	listApellidoListar[i] = arrayListc.get(i).getLastName();
	                	if(arrayListc.get(i).getCreditLimit() != null) {
	                		listLimiteListar[i] = arrayListc.get(i).getCreditLimit();
	                	}
	                	else {
	                		listLimiteListar[i] = CERO;
	                	}
	                	listNewsListar[i] = arrayListc.get(i).getNewsletter();
	                	listActivoListar[i] = arrayListc.get(i).getEnable();

	                	jList1.setSelectedIndex(i);
	                	jList2.setSelectedIndex(i);
	                	jList3.setSelectedIndex(i);
	                	jList4.setSelectedIndex(i);
	                	jList5.setSelectedIndex(i);
	                	jList6.setSelectedIndex(i);
	                	jList7.setSelectedIndex(i);
	                	
	                }
	               
	                
	                jList1.setModel(new AbstractListModel<Integer>() {
	                    Integer[] listIDModel = listIDListar;     
	                    public int getSize() { return listIDModel.length; }
	                    public Integer getElementAt(int i) { return listIDModel[i]; }
	                });
	                
	                jList2.setModel(new AbstractListModel<String>() {
	                    String[] listDNIModel = listDNIListar;     
	                    public int getSize() { return listDNIModel.length; }
	                    public String getElementAt(int i) { return listDNIModel[i]; }
	                });
	                
	                jList3.setModel(new AbstractListModel<String>() {
	                    String[] listNombreModel = listNombreListar;     
	                    public int getSize() { return listNombreModel.length; }
	                    public String getElementAt(int i) { return listNombreModel[i]; }
	                });
	                
	                jList4.setModel(new AbstractListModel<String>() {
	                    String[] listApellidoModel = listApellidoListar;     
	                    public int getSize() { return listApellidoModel.length; }
	                    public String getElementAt(int i) { return listApellidoModel[i]; }
	                });
	                
	                jList5.setModel(new AbstractListModel<Float>() {
	                    Float[] listLimiteModel = listLimiteListar;     
	                    public int getSize() { return listLimiteModel.length; }
	                    public Float getElementAt(int i) { return listLimiteModel[i]; }
	                });
	                
	                jList6.setModel(new AbstractListModel<Boolean>() {
	                    Boolean[] listNewsModel = listNewsListar;     
	                    public int getSize() { return listNewsModel.length; }
	                    public Boolean getElementAt(int i) { return listNewsModel[i]; }
	                });
	                
	                jList7.setModel(new AbstractListModel<Boolean>() {
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
	 
	 
	 @SuppressWarnings("serial")
	public void actualizarVentanaTopTen(IDEventos idEvento, Object datos) {

	    	if ( IDEventos.EVENTO_TOP_TEN_CLIENTES == idEvento ) {
	    		
	    		if ( datos instanceof ArrayList) {

	    			
	    			 //Cargar datos en lists
	                @SuppressWarnings("unchecked")
					ArrayList<TransferCustomer> arrayListc = (ArrayList<TransferCustomer>) datos;
	                listIDTop = new Integer[arrayListc.size()];
	                listDNITop = new String[arrayListc.size()];
	                listNombreTop = new String[arrayListc.size()];
	                listApellidoTop = new String[arrayListc.size()];
	                
	                
	                for(int i = 0; i < arrayListc.size(); i++) {
	                	listIDTop[i] = arrayListc.get(i).getIdCustomer();
	                	listDNITop[i] = arrayListc.get(i).getIdNumber();
	                	listNombreTop[i] = arrayListc.get(i).getName();
	                	listApellidoTop[i] = arrayListc.get(i).getLastName();
	                	

	                	jList8.setSelectedIndex(i);
	                	jList10.setSelectedIndex(i);
	                	jList12.setSelectedIndex(i);
	                	jList13.setSelectedIndex(i);
	                	
	                	
	                }
	               
	                
	                jList8.setModel(new AbstractListModel<Integer>() {
	                    Integer[] listIDModel = listIDTop;     
	                    public int getSize() { return listIDModel.length; }
	                    public Integer getElementAt(int i) { return listIDModel[i]; }
	                });
	                
	                jList10.setModel(new AbstractListModel<String>() {
	                    String[] listDNIModel = listDNITop;     
	                    public int getSize() { return listDNIModel.length; }
	                    public String getElementAt(int i) { return listDNIModel[i]; }
	                });
	                
	                jList12.setModel(new AbstractListModel<String>() {
	                    String[] listNombreModel = listNombreTop;     
	                    public int getSize() { return listNombreModel.length; }
	                    public String getElementAt(int i) { return listNombreModel[i]; }
	                });
	                
	                jList13.setModel(new AbstractListModel<String>() {
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
