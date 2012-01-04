package application.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 * Clase que nos permite detectar cuando el header una {@link JTable} ha sido
 * pulsado
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class HeaderListener extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent e) {
		JTable tabla = ((JTableHeader) e.getSource()).getTable();
		TableColumnModel model = tabla.getColumnModel();

		int columnModelIndex = model.getColumnIndexAtX(e.getX());
		int modelIndex = model.getColumn(columnModelIndex).getModelIndex();

		if (modelIndex < 0)
			return;
	}

}
