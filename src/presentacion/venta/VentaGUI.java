package presentacion.venta;

import presentacion.comando.IDEventos;


public abstract class VentaGUI {

	private static VentaGUI VentaGUIInstance;

	public abstract void update(IDEventos evento_actual, Object datos);

	public static VentaGUI getInstance() {

		createVentaGUI();

		return VentaGUIInstance;
	}

	private static synchronized void createVentaGUI() {

		if (VentaGUIInstance == null) {
			VentaGUIInstance = new VentaGUIImp();
		}
	}
	
	public abstract PanelVenta getPanelVenta();

}
