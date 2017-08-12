package presentacion.main;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import presentacion.cliente.ClienteGUI;
import presentacion.producto.ProductoGUI;
import presentacion.venta.VentaGUI;


public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
    private JPanel cliente;
    private JPanel jPanel1;
    private JTabbedPane jTabbedPane;
    private JPanel producto;
    private JPanel venta;
    private JPanel portada;
	
	public MainWindow() {
		super("MShoes");
		initGUI();
	}
	
	private void initGUI() {
		
		jPanel1 = new JPanel();
        jTabbedPane = new JTabbedPane();
       
        //Portada
        portada = new JPanel();
        portada.setLayout(new BorderLayout());
        ImageIcon icon = createImageIcon("Mshoes.PNG");
        JLabel picLabel = new JLabel(icon);
        portada.add(picLabel, BorderLayout.CENTER);
        jTabbedPane.addTab("MShoes", portada);

        //PanelCliente
        cliente = ClienteGUI.getInstance().getPanelCliente();
        jTabbedPane.addTab("Cliente", cliente);
        
        //Panel producto
        producto = ProductoGUI.getInstance().getPanelProducto();
        jTabbedPane.addTab("Producto", producto);

        
        //Panel venta
        venta = VentaGUI.getInstance().getPanelVenta();
        jTabbedPane.addTab("Venta", venta);

        
        
        //MainWindow
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(664, 664, 664)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
	}
	
	
	public static void main(String[] args) {
		
		 java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new MainWindow().setVisible(true);
	            }
	        });
	}
	
	private static ImageIcon createImageIcon(String path) { 
		java.net.URL imgURL = MainWindow.class.getResource(path);
		if (imgURL != null) return new ImageIcon(imgURL);
		return null;	
	}

}
	