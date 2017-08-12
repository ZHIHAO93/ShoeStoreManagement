package presentacion.producto;

import presentacion.comando.IDEventos;


public abstract class ProductoGUI {

	private static ProductoGUI ProductoGUIInstance;

	public abstract void update(IDEventos evento_actual, Object datos);

	public static ProductoGUI getInstance() {

		createProductoGUI();

		return ProductoGUIInstance;
	}

	private static synchronized void createProductoGUI() {

		if (ProductoGUIInstance == null) {
			ProductoGUIInstance = new ProductoGUIImp();
		}
	}
	
	public abstract PanelProducto getPanelProducto();

}
