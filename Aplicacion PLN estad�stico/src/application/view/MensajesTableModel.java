package application.view;

import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que extiende {@link DefaultTableModel}. Modifica el modelo de tabla
 * haciendo que las celdas no sean editables y que las celdas de la primera
 * columna sea un {@link JCheckBox}
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
@SuppressWarnings("serial")
public class MensajesTableModel extends DefaultTableModel {

	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0) {
			return Boolean.class;
		} else {
			return super.getColumnClass(columnIndex);
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		if (column == 0) {
			return true;
		}
		return false;
	}

}
