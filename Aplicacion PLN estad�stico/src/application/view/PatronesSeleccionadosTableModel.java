package application.view;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que extiende {@link DefaultTableModel}. Modifica el modelo de tabla
 * haciendo que las celdas no sean editables y que las celdas de la primera
 * columna sea un {@link JComboBox}
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
@SuppressWarnings("serial")
public class PatronesSeleccionadosTableModel extends DefaultTableModel {

	public Class<?> getColumnClass(int columnIndex) {
		// if (columnIndex == 0) {
		// return JComboBoxTable.class;
		// } else {
		// return super.getColumnClass(columnIndex);
		// }
		return super.getColumnClass(columnIndex);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		if (column == 0) {
			return true;
		}
		return false;
	}
}
