package application.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import application.busqueda.*;
import application.classifier.FiltroMensajes;
import application.classifier.SimpleSimhashing;
import application.main.Main;
import application.model.Campo;
import application.model.Etiqueta;
import application.model.Grupo;
import application.model.Mensaje;
import application.model.Patron;
import application.model.Tipo;
import application.model.Individuo;
import application.operations.*;
import application.util.TimeStamp;

import com.toedter.calendar.*;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 * 
 * 
 * @author Alberto Rodríguez Peón
 */
@SuppressWarnings("serial")
public class VentanaPrincipal extends javax.swing.JFrame {
	{
		// Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager
					.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private JMenuBar barraMenu;
	private JMenu archivoMenu;
	private JMenu ayudaMenu;
	private JCheckBox mostrarGruposCheckBox;
	private JButton cancelarAddFiltroButton;
	private JComboBox miembrosClasesComboBox;
	private JLabel miembrosClasesLabel;
	private JComboBox fuenteClasesComboBox;
	private JLabel fuenteClasesLabel;
	private JComboBox materialEntrenamientoComboBox;
	private JLabel materialEntrenamientoLabel;
	private JTextField nombreAddFiltroTextField;
	private JLabel nombreFiltroLabel;
	private JPanel addNuevoFiltroPanel;
	private JDialog addFiltroDialog;
	private AbstractAction cancelarBusquedaAction;
	private AbstractAction busquedaAction;
	private JTextField busquedaTextField;
	private JComboBox busquedaComboBox;
	private int estadoAnterior;
	private JButton aceptarBusquedaButton;
	private AbstractAction aceptarAddFiltroAction;
	private AbstractAction fuenteClasesAction;
	private AbstractAction removeGrupoAddGrupoUsuariosMismasTagsAction;
	private AbstractAction addGrupoAddGrupoUsuariosMismasTagsAction;
	private AbstractAction addGrupoUsuariosRecibenMensajesSimilaresAction;
	private JMenuItem addGrupoUsuariosRecibenMensajesSimilaresMenuItem;
	private JComboBox tipoBusquedaComboBox;
	private AbstractAction guardarDatosAction;
	private AbstractAction borrarPatronActualAction;
	private AbstractAction addPatronActualAction;
	private AbstractAction addPatronAction;
	private AbstractAction mostrarMensajesComunidadAction;
	private AbstractAction ocultarMensajesComunidadAction;
	private AbstractAction ignorarMensajesComunidadAction;
	private AbstractAction mostrarMensajesPosterioresAction;
	private AbstractAction mostrarMensajesAnterioresAction;
	private AbstractAction ocultarMensajesDeAction;
	private AbstractAction okAddUsuarioGrupoAction;
	private AbstractAction borrarGrupoAction;
	private AbstractAction addGrupoAction;
	private AbstractAction cancelAddUsuarioGrupoAction;
	private AbstractAction addNuevoGrupoAction;
	private AbstractAction ignorarMensajesDeLosGruposAction;
	private AbstractAction mostrarMensajesSolamenteAction;
	private AbstractAction buscarTodosAction;
	private JButton buscarTodosButton;
	private AbstractAction okBusquedaAction;
	private JScrollPane jScrollPane10;
	private JTextArea verVistaPreviaTextArea;
	private JDialog verPreviewDialog;
	private AbstractAction okEtiquetarSimilaresAction;
	private AbstractAction cerrarEtiquetarSimilaresAction;
	private JComboBox etiquetaSeleccionadaEtiquetarSimilaresComboBox;
	private JLabel etiquetaSeleccionadaEtiquetarSimilaresLabel;
	private JLabel similitudEtiquetarSimilaresLabel;
	private JLabel seleccionarAlgoritmoEtiquetarSimilaresLabel;
	private JSpinner similitudEtiquetarSimilaresSpinner;
	private JButton okEtiquetarSimilaresButton;
	private JComboBox seleccionarAlgoritmoEtiquetarSimilaresComboBox;
	private JButton ayudaEtiquetarSimilaresButton;
	private JButton cancelarEtiquetarSimilaresButton;
	private JDialog etiquetarSimilaresDialog;
	private AbstractAction okEtiquetarMensajeAction;
	private AbstractAction cerrarEtiquetarMensajeAction;
	private AbstractAction borrarEtiquetaAction;
	private AbstractAction seleccionarEtiquetaAction;
	private AbstractAction addEtiquetaSueltaAction;
	private AbstractAction etiquetarMensajesSimilaresAction;
	private JMenuItem etiquetarMensajesSimilaresMenuItem;
	private AbstractAction mensajesAnterioresAction;
	private AbstractAction mensajesSiguientesAction;
	private JLabel paginaActualValueLabel;
	private JLabel paginaActualLabel;
	private JLabel numMensajesValueLabel;
	private JLabel numMensajesLabel;
	private JButton mensajesPosterioresButton;
	private JButton mensajesAnterioresButton;
	private AbstractAction importarDatosAction;
	private JFileChooser importarArchivoFileChooser;
	private AbstractAction okPreferenciasAction;
	private JComboBox idiomaPreferenciasComboBox;
	private JLabel idiomaPreferenciasLabel;
	private JButton okPreferenciasButton;
	private JButton cancelPreferenciasButton;
	private JDialog preferenciasDialog;
	private AbstractAction preferenciasAction;
	private AbstractAction okAddGrupoUsuariosMismasTagsAction;
	private JLabel busquedaRapidaAddGrupoUsuariosMismasTagsLabel;
	private JTextField busquedaRapidaAddGrupoUsuariosMismasTagsTextField;
	private JLabel etiquetasSeleccionadasAddGrupoUsuariosMismasTagsLabel;
	private JLabel etiquetasDisponiblesAddGrupoUsuariosMismasTagsLabel;
	private JList gruposDisponiblesAddGrupoUsuariosMismasTagsList;
	private JScrollPane jScrollPane15;
	private JButton removeGrupoAddGrupoUsuariosMismasTagsButton;
	private JButton addGrupoAddGrupoUsuariosMismasTagsButton;
	private JList gruposActualesAddGrupoUsuariosMismasTagsList;
	private JScrollPane jScrollPane9;
	private JPanel primerPasoAddGrupoUsuariosMismasTagsPanel;
	private JPanel botonesAddGrupoUsuariosMismasTagsPanel;
	private AbstractAction backEtiquetadoMediantePatronAction;
	private AbstractAction nextEtiquetadoMediantePatronAction;
	private JPanel segundoPasoEtiquetadoMediantePatronPanel;
	private JScrollPane patronesSeleccionadosEtiquetadoMediantePatronScrollPane;
	private JTable patronesSeleccionadosEtiquetadoMediantePatronTable;
	private JTextField nombreFiltroEtiquetadoMediantePatronTextField;
	private JLabel nombreFiltroEtiquetadoMediantePatroLabel;
	private JButton backEtiquetadoMediantePatronButton;
	private JPanel botonesEtiquetadoMediantePatronPanel;
	private JPanel primerPasoEtiquetadoMediantePatronPanel;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JPanel busquedaTextFieldPanel;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JLabel secondsDesdeLabel;
	private JLabel minutosDesdeLabel;
	private JLabel horasDesdeLabel;
	private JDateChooser desdeDateChooser;
	private JSpinner segundosDesdeSpinner;
	private JSpinner minutosDesdeSpinner;
	private JSpinner horasDesdeSpinner;
	private JPanel desdePanel;
	private JSpinner segundosHastaSpinner;
	private JPanel hastaPanel;
	private JSpinner minutosHastaSpinner;
	private JSpinner horasHastaSpinner;
	private JDateChooser hastaDateChooser;
	private JLabel busquedaLabel;
	private AbstractAction busquedaTiempoAction;
	private AbstractAction addGrupoUsuariosMismasTagsAction;
	private JButton okAddGrupoUsuariosMismasTagsButton;
	private JButton cancelAddGrupoUsuariosMismasTagsButon;
	private JDialog addGrupoUsuariosMismasTagsDialog;
	private AbstractAction ocultarMensajesMismasTagsAction;
	private AbstractAction ignorarMensajesMismasTagsAction;
	private AbstractAction buscarMensajesMismasTagsAction;
	private AbstractAction addTagsMensajeAction;
	private AbstractAction etiquetarMensajeAction;
	private JButton okEtiquetarMensajeButton;
	private JButton cancelEtiquetarMensajeButton;
	private JButton addEtiquetaEtiquetarMensajeButton;
	private JTextField addEtiquetaEtiquetarMensajeTextField;
	private JLabel addEtiquetaEtiquetarMensajeLabel;
	private JTextField busquedaRapidaTextField;
	private JLabel busquedaRapidaEtiquetarLabel;
	private JScrollPane jScrollPane6;
	private JScrollPane jScrollPane5;
	private JButton borrarEtiquetaSeleccionadaButton;
	private JButton seleccionarEtiquetaButton;
	private JList etiquetasSeleccionadasList;
	private JList etiquetasActualesList;
	private JDialog etiquetarMensajeDialog;
	private AbstractAction ignorarMensajesSimilaresAction;
	private AbstractAction buscarMensajesSimilaresAction;
	private JButton okBuscarMensajesSimilaresButton;
	private JButton cancelBuscarMensajesSimilaresButton;
	private JButton ayudaBuscarMensajesSimilaresButton;
	private JSpinner similitudBuscarMensajesSimilaresSpinner;
	private JLabel similitudBuscarMensajesSimilaresLabel;
	private JComboBox algoritmoBuscarMensajesSimilaresComboBox;
	private JLabel algoritmoBuscarMensajesSimilaresLabel;
	private JDialog buscarMensajesSimilaresDialog;
	private AbstractAction addUsuarioGrupoAction;
	private JButton okAddUsuarioGrupoButton;
	private JButton cancelAddUsuarioGrupoButton;
	private JLabel addNuevoGrupoLabel;
	private JButton addNuevoGrupoButton;
	private JTextField addNuevoGrupoTextField;
	private JLabel gruposActualesLabel;
	private JLabel gruposDisponiblesLabel;
	private JButton borrarGrupoButton;
	private JButton addGrupoButton;
	private JScrollPane jScrollPane4;
	private JScrollPane jScrollPane3;
	private JList gruposActualesList;
	private JList gruposDisponiblesList;
	private JDialog addUsuarioGrupoDialog;
	private AbstractAction cancelEtMediantePatronAction;
	private JButton addPatronButton;
	private JScrollPane jScrollPane2;
	private JList patronesSeleccionadosList;
	private JButton borrarPatronActualButton;
	private JButton addPatronActualButton;
	private JScrollPane jScrollPane1;
	private JList patronesActualesList;
	private JTextField busquedaRapidaEtMediantePatronTextField;
	private JLabel busquedaRapidaEtMediantePatronLabel;
	private JButton nextEtiquetadoMediantePatronButton;
	private JButton cancelEtiquetadoMediantePatronButton;
	private JDialog etiquetadoMediantePatronDialog;
	private AbstractAction etiquetadoMediantePatronAction;
	// private JMenuItem medianteExtraccionAutomaticaMenuItem;
	private JMenuItem mediantePatronMenuItem;
	private JMenu etiquetadoAutomaticoMenu;
	private JMenuItem addGrupoUsuariosMismasTagsMenuItem;
	private JMenuItem addTagsMenuItem;
	private JMenuItem ocultarMensajesMismasTagsMenuItem;
	private JMenuItem ignorarMensajesMismasTagsMenuItem;
	private JMenuItem buscarMensajesMismasTagsMenuItem;
	private JPopupMenu tagPopupMenu;
	private JMenuItem etiquetarMensajeMenuItem;
	private JMenuItem ignorarMensajesSimilaresMenuItem;
	private JMenuItem buscarMensajesSimilaresMenuItem;
	private JPopupMenu messagePopupMenu;
	private JMenuItem mostrarMensajesPosterioresMenuItem;
	private JMenuItem mostrarMensajesAnterioresMenuItem;
	private JPopupMenu timestampPopupMenu;
	private JMenuItem ocultarMensajesComunidadMenuItem;
	private JMenuItem mostrarMensajesComunidadMenuItem;
	private JMenuItem ignorarMensajesComunidadMenuItem;
	private JPopupMenu belongsPopupMenu;
	private JMenuItem addAGrupoMenuItem;
	private JMenuItem ocultarMensajesMenuItem;
	private JMenuItem ignorarMensajesDeLosGruposMenuItem;
	private JMenuItem mostrarMensajesSolamenteMenuItem;
	private JMenuItem ignorarMensajesMenuItem;
	private JPopupMenu fromPopupMenu;
	private AbstractAction addNuevoFiltroAction;
	private AbstractAction cancelarAddFiltroAction;
	private JButton aceptarAddFiltroButton;
	private JButton cancelarBusquedaButton;
	private JDialog busquedaDialog;
	private AbstractAction salirAction;
	private JMenuItem preferenciasMenuItem;
	private JMenuItem aplicarFiltroMenuItem;
	private JMenuItem addNuevoFiltroMenuItem;
	// private JMenuItem eliminarFiltroMenuItem;
	// private JMenuItem borrarIndicesMenuItem;
	// private JMenuItem keyboardBasedMenuItem;
	// private JMenuItem shinglingMenuItem;
	// private JMenu addIndicesMenu;
	// private JMenu indicesMenu;
	private JMenuItem salirMenuItem;
	private JMenuItem guardarDatosMenuItem;
	private JMenuItem importarDatosDeArchivoMenuItem;
	private JButton cerrarAcercaDeButton;
	private JLabel creadorLabel;
	private AbstractAction cerrarAcercaDeAction;
	private AbstractAction okPreviewAlgoritmoAction;
	private JButton okPreviewAlgoritmoButton;
	private AbstractAction ayudaEtiquetarSimilaresAction;
	private AbstractAction ayudaBuscarMensajesSimilaresAction;
	private JScrollPane jScrollPane8;
	private JTextArea descripcionAlgoritmoTextArea;
	private JLabel jLabel4;
	private JLabel nombreAlgoritmoLabel;
	private JPanel previewAlgoritmoPanel;
	private JDialog previewAlgoritmoDialog;
	private AbstractAction cancelPreferenciasAction;
	private JLabel patronesSeleccionadosLabel;
	private JLabel patronesDisponiblesLabel;
	private JLabel etiquetasActualesEtiquetarMensajeLabel;
	private JLabel etiquetasDisponiblesEtiquetarMensajeLabel;
	private JLabel addMiembroClaseAplicarFiltroLabel;
	private JLabel accionAplicarFiltroLabel;
	private AbstractAction cancelAddGrupoUsuariosMismasTagsAction;
	private AbstractAction borrarDatosAction;
	private JLabel cargaProgresoLabel;
	private JProgressBar barraCargaProgresoProgressBar;
	private JPanel cargaProgresoPanel;
	private JDialog cargaProgresoDialog;
	private AbstractAction addNuevoGrupoMismasTagsAction;
	private JButton addNuevoGrupoMismasTagsButton;
	private JTextField addNuevoGrupoMismasTagsTextField;
	private JLabel addNuevoGrupoMismasTagsLabel;
	private AbstractAction addEtiquetaEtiquetarSimilaresAction;
	private JButton addEtiquetaEtiquetarSimilaresButton;
	private JTextField addEtiquetaEtiquetarSimilaresTextField;
	private AbstractAction addEtiquetaEtiquetadoMediantePatronAction;
	private JButton addEtiquetaEtiquetadoMediantePatronButton;
	private JComboBox nombreEtiquetaEtiquetadoMediantePatronComboBox;
	private AbstractAction cancelBuscarMensajesSimilaresAction;
	private AbstractAction tipoAplicarFiltroAction;
	private AbstractAction aplicarFiltroAction;
	private AbstractAction addMiembroClaseAplicarFiltroAction;
	private AbstractAction okAplicarFiltroAction;
	private AbstractAction cancelarAplicarFiltroAction;
	private JButton okAplicarFiltroButton;
	private JButton cancelarAplicarFiltroButton;
	private JButton addMiembroClaseAplicarFiltroButton;
	private JTextField addMiembroClaseAplicarFiltroTextField;
	private JComboBox miembroClaseAplicarFiltroComboBox;
	private JComboBox tipoAplicarFiltroComboBox;
	private JComboBox categoriaAplicarFiltroComboBox;
	private JLabel categoriaAplicarFiltroLabel;
	private JDialog aplicarFiltroDialog;
	private JLabel categoriaNombreEntrenamientoManualLabel;
	private JLabel preguntaEntrenamientoManualLabel;
	private AbstractAction siEntrenamientoManualAction;
	private JButton siEntrenamientoManualButton;
	private AbstractAction noEntrenamientoManualAction;
	private JButton noEntrenamientoManualButton;
	private AbstractAction terminarEntrenamientoManualAction;
	private JButton terminarEntrenamientoManualButton;
	private JScrollPane jScrollPane7;
	private JTextArea textoEntrenamienoManualTextArea;
	private JLabel textoEntrenamientoManualLabel;
	private JLabel categoriaEntrenamientoManualLabel;
	private JDialog entrenamientoManualDialog;
	private AbstractAction buscarSimilaresAction;
	private JDialog acercaDeDialog;
	private AbstractAction acercaDeAction;
	private JPanel checkBoxMensajesPanel;
	private JMenuItem acercaDeMenuItem;
	private JScrollPane tablaScrollPane;
	private JCheckBox mostrarMensajesOcultosCheckBox;
	private JTable tablaMensajes;
	private JButton busquedaBoton;
	private JMenu opcionesMenu;
	private JMenu filtrosMenu;
	private Main main;
	private TableModel tablaMensajesModel;
	private int primerMensajeMostrado;
	private int ultimoMensajeMostrado;
	private int numMensajesCargadosPorIteracion;
	private Operacion operacion;
	private AbstractAction ignorarMensajesAction;
	private List<Mensaje> mostrados;
	private Mensaje mensajeSeleccionado;
	private Individuo individuoSeleccionado;
	private List<Patron> patronesSeleccionados;
	private List<Etiqueta> etiquetasProvisionales;
	private List<Mensaje> entrenados;
	private JMenuItem borrarDatosMenuItem;

	public VentanaPrincipal(Main main) {
		super();
		this.main = main;
		reiniciarIndices();
		this.numMensajesCargadosPorIteracion = 200;
		initGUI();
		getMensajesAnterioresButton().setEnabled(false);
	}

	public void cargarDatosInicio() {
		operacion = new CargarBDOperacion(getMain());
		ejecutarOperacion();
	}

	public List<Patron> getPatronesSeleccionados() {
		return patronesSeleccionados;
	}

	private void reiniciarIndices() {
		this.primerMensajeMostrado = 0;
		this.ultimoMensajeMostrado = 0;
		getPaginaActualValueLabel().setText("1");
	}

	public int getNumMensajesCargadosPorIteracion() {
		return this.numMensajesCargadosPorIteracion;
	}

	private String getWord(String key) {
		return ResourceBundle.getBundle("strings").getString(key);
	}

	public List<Mensaje> getListaBusqueda() {
		return this.main.getListaBusqueda();
	}

	public void setListaBusqueda(List<Mensaje> listaBusqueda) {
		if (!listaBusqueda.isEmpty()) {
			this.main.setListaBusqueda(listaBusqueda);
			getNumMensajesValueLabel().setText(getListaBusqueda().size() + "");
			reiniciarIndices();
			getMensajesAnterioresButton().setEnabled(false);
		}
	}

	public List<Mensaje> getMostrados() {
		return mostrados;
	}

	public void setMostrados(List<Mensaje> mostrados) {
		this.mostrados = mostrados;
	}

	/**
	 * Inicia la ventana principal
	 */
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle(getWord("titulo_aplicacion"));
			GroupLayout thisLayout = new GroupLayout(
					(JComponent) getContentPane());
			getContentPane().setLayout(thisLayout);
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					preguntarGrabarDatos();
				}
			});
			this.setVisible(false);
			this.setPreferredSize(new java.awt.Dimension(1147, 700));
			{
				busquedaBoton = new JButton();
				busquedaBoton.setText(getWord("boton_busqueda"));
				busquedaAction = null;
				busquedaBoton.setAction(getBusquedaAction());
			}
			{
				tablaScrollPane = new JScrollPane();
				tablaScrollPane.setFocusable(false);

				{
					tablaMensajesModel = new MensajesTableModel();
					Object[] headers = new Object[8];
					headers[0] = getWord("visible");
					headers[1] = getWord("desde");
					headers[2] = getWord("desde_pertenece");
					headers[3] = getWord("para");
					headers[4] = getWord("para_pertenece");
					headers[5] = getWord("timestamp");
					headers[6] = getWord("message");
					headers[7] = getWord("tags");
					((DefaultTableModel) tablaMensajesModel)
							.setColumnIdentifiers(headers);

					tablaMensajes = new JTable();
					setComponentPopupMenu(tablaScrollPane, getFromPopupMenu());
					setComponentPopupMenu(tablaScrollPane,
							getBelongsPopupMenu());
					setComponentPopupMenu(tablaScrollPane,
							getMessagePopupMenu());
					setComponentPopupMenu(tablaScrollPane, getTagPopupMenu());
					setComponentPopupMenu(tablaScrollPane,
							getTimestampPopupMenu());
					tablaScrollPane.setViewportView(tablaMensajes);
					tablaMensajes.setModel(tablaMensajesModel);
					tablaMensajes.setBorder(new LineBorder(new java.awt.Color(
							0, 0, 0), 1, false));
					tablaMensajes.getTableHeader().setFocusable(true);
					tablaMensajes.setCellSelectionEnabled(true);
					tablaMensajes.getTableHeader().addMouseListener(
							new HeaderListener());
					tablaMensajes
							.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					tablaMensajes.getTableHeader().setReorderingAllowed(false);
					tablaMensajes.addMouseListener(new MouseAdapter() {

						public void mouseClicked(MouseEvent e) {
							int row = tablaMensajes.rowAtPoint(e.getPoint());
							int column = tablaMensajes.columnAtPoint(e
									.getPoint());
							if (row != -1) {
								mensajeSeleccionado = getMensaje(row);
								if (column == 1) {
									individuoSeleccionado = mensajeSeleccionado
											.getEmisor();
								} else {
									individuoSeleccionado = mensajeSeleccionado
											.getReceptor();
								}
							}
							if (SwingUtilities.isRightMouseButton(e)) {
								mostrarPopup(e);
							}
							if (SwingUtilities.isLeftMouseButton(e)
									&& e.getClickCount() == 2) {
								mostrarPreview(e);
							}
							if (SwingUtilities.isLeftMouseButton(e)) {
								if (column == 0) {
									boolean visible = mensajeSeleccionado
											.isVisible();
									mensajeSeleccionado.setVisible(!visible);
								}
							}
						}

						private void mostrarPreview(MouseEvent e) {

							Point p = e.getPoint();
							int column = tablaMensajes.columnAtPoint(p);
							int row = tablaMensajes.rowAtPoint(p);
							String text = null;
							if (tablaMensajes.getValueAt(row, column) != null)
								text = tablaMensajes.getValueAt(row, column)
										.toString();
							if (column != 0) {
								if (text != null && !text.equals("")) {
									getVerVistaPreviaTextArea().setText(text);
									abrirVentana(getVerPreviewDialog());
								}
							}
						}

						private void mostrarPopup(MouseEvent e) {
							Point p = e.getPoint();
							int column = tablaMensajes.columnAtPoint(p);
							int row = tablaMensajes.rowAtPoint(p);
							String value = null;
							if (tablaMensajes.getValueAt(row, column) != null) {
								value = tablaMensajes.getValueAt(row, column)
										.toString();
							}
							JPopupMenu menu = getMenu(column);
							if (menu != null && value != null
									&& !(value.equals(""))) {
								menu.pack();
								menu.show(tablaMensajes, e.getX(), e.getY());
							}
						}

						private JPopupMenu getMenu(int index) {
							switch (index) {
							case 1:
								return getFromPopupMenu();
							case 2:
								if (mostrarGruposCheckBox.isSelected()) {
									return getBelongsPopupMenu();
								}
								return getFromPopupMenu();
							case 3:
								if (mostrarGruposCheckBox.isSelected()) {
									return getFromPopupMenu();
								}
								return getTimestampPopupMenu();
							case 4:
								if (mostrarGruposCheckBox.isSelected()) {
									return getBelongsPopupMenu();
								}
								return getMessagePopupMenu();
							case 5:
								if (mostrarGruposCheckBox.isSelected()) {
									return getTimestampPopupMenu();
								}
								return getTagPopupMenu();
							case 6:
								return getMessagePopupMenu();
							case 7:
								return getTagPopupMenu();

							default:
								return null;
							}
						}
					});
				}
			}
			{
				checkBoxMensajesPanel = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout(
						(JComponent) checkBoxMensajesPanel);
				checkBoxMensajesPanel.setLayout(jPanel1Layout);
				checkBoxMensajesPanel.setBorder(BorderFactory
						.createTitledBorder(new LineBorder(new java.awt.Color(
								0, 0, 0), 1, false), getWord("visualizacion"),
								TitledBorder.LEADING, TitledBorder.TOP));
				checkBoxMensajesPanel.setEnabled(true);
				{
					mostrarMensajesOcultosCheckBox = new JCheckBox();
					mostrarMensajesOcultosCheckBox
							.setText(getWord("mostrar_mensajes_ocultos"));
					mostrarMensajesOcultosCheckBox.setSelected(true);
					mostrarMensajesOcultosCheckBox
							.addItemListener(new ItemListener() {
								public void itemStateChanged(ItemEvent e) {
									rellenarTabla();
								}
							});
				}
				{
					mostrarGruposCheckBox = new JCheckBox();
					mostrarGruposCheckBox.setText(getWord("mostrar_grupos"));
					mostrarGruposCheckBox.setSelected(true);
					mostrarGruposCheckBox.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent e) {
							Object[] headers;
							if (mostrarGruposCheckBox.isSelected()) {
								headers = new Object[8];
								headers[0] = getWord("visible");
								headers[1] = getWord("desde");
								headers[2] = getWord("desde_pertenece");
								headers[3] = getWord("para");
								headers[4] = getWord("para_pertenece");
								headers[5] = getWord("timestamp");
								headers[6] = getWord("message");
								headers[7] = getWord("tags");
							} else {
								headers = new Object[6];
								headers[0] = getWord("visible");
								headers[1] = getWord("desde");
								headers[2] = getWord("para");
								headers[3] = getWord("timestamp");
								headers[4] = getWord("message");
								headers[5] = getWord("tags");
							}
							((DefaultTableModel) tablaMensajesModel)
									.setColumnIdentifiers(headers);
							rellenarTabla();
						}
					});

				}
				jPanel1Layout
						.setHorizontalGroup(jPanel1Layout
								.createParallelGroup()
								.add(GroupLayout.LEADING,
										mostrarMensajesOcultosCheckBox,
										GroupLayout.PREFERRED_SIZE, 205,
										GroupLayout.PREFERRED_SIZE)
								.add(GroupLayout.LEADING,
										jPanel1Layout
												.createSequentialGroup()
												.add(mostrarGruposCheckBox,
														GroupLayout.PREFERRED_SIZE,
														165,
														GroupLayout.PREFERRED_SIZE)
												.add(0, 40, Short.MAX_VALUE)));
				jPanel1Layout.setVerticalGroup(jPanel1Layout
						.createSequentialGroup()
						.add(mostrarMensajesOcultosCheckBox,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.RELATED, 0,
								Short.MAX_VALUE)
						.add(mostrarGruposCheckBox, GroupLayout.PREFERRED_SIZE,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.PREFERRED_SIZE).addContainerGap());
			}
			thisLayout
					.setVerticalGroup(thisLayout
							.createSequentialGroup()
							.addContainerGap(17, 17)
							.add(thisLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getBuscarTodosButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getNumMensajesLabel(),
											GroupLayout.PREFERRED_SIZE, 18,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getNumMensajesValueLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getPaginaActualLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getPaginaActualValueLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE, busquedaBoton,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(tablaScrollPane, 0, 439, Short.MAX_VALUE)
							.addPreferredGap(LayoutStyle.RELATED, 0,
									GroupLayout.PREFERRED_SIZE)
							.add(thisLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getMensajesAnterioresButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getMensajesPosterioresButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.RELATED, 0,
									GroupLayout.PREFERRED_SIZE)
							.add(checkBoxMensajesPanel,
									GroupLayout.PREFERRED_SIZE, 78,
									GroupLayout.PREFERRED_SIZE)
							.addContainerGap(43, 43));
			thisLayout
					.setHorizontalGroup(thisLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(thisLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											thisLayout
													.createSequentialGroup()
													.add(thisLayout
															.createParallelGroup()
															.add(GroupLayout.LEADING,
																	thisLayout
																			.createSequentialGroup()
																			.add(getNumMensajesLabel(),
																					GroupLayout.PREFERRED_SIZE,
																					94,
																					GroupLayout.PREFERRED_SIZE)
																			.add(getNumMensajesValueLabel(),
																					GroupLayout.PREFERRED_SIZE,
																					127,
																					GroupLayout.PREFERRED_SIZE))
															.add(GroupLayout.LEADING,
																	thisLayout
																			.createSequentialGroup()
																			.add(getMensajesAnterioresButton(),
																					GroupLayout.PREFERRED_SIZE,
																					215,
																					GroupLayout.PREFERRED_SIZE)
																			.add(6))
															.add(GroupLayout.LEADING,
																	thisLayout
																			.createSequentialGroup()
																			.add(checkBoxMensajesPanel,
																					GroupLayout.PREFERRED_SIZE,
																					215,
																					GroupLayout.PREFERRED_SIZE)
																			.add(6)))
													.add(0, 336,
															Short.MAX_VALUE)
													.add(getBuscarTodosButton(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.add(47)
													.add(thisLayout
															.createParallelGroup()
															.add(GroupLayout.LEADING,
																	thisLayout
																			.createSequentialGroup()
																			.add(getPaginaActualLabel(),
																					GroupLayout.PREFERRED_SIZE,
																					100,
																					GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(
																					LayoutStyle.RELATED)
																			.add(getPaginaActualValueLabel(),
																					GroupLayout.PREFERRED_SIZE,
																					63,
																					GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(
																					LayoutStyle.RELATED)
																			.add(busquedaBoton,
																					GroupLayout.PREFERRED_SIZE,
																					138,
																					GroupLayout.PREFERRED_SIZE))
															.add(GroupLayout.LEADING,
																	thisLayout
																			.createSequentialGroup()
																			.add(0,
																					96,
																					GroupLayout.PREFERRED_SIZE)
																			.add(getMensajesPosterioresButton(),
																					GroupLayout.PREFERRED_SIZE,
																					215,
																					GroupLayout.PREFERRED_SIZE))))
									.add(GroupLayout.LEADING, tablaScrollPane,
											0, 1074, Short.MAX_VALUE))
							.addContainerGap(47, 47));
			thisLayout.linkSize(new Component[] {
					getMensajesAnterioresButton(),
					getMensajesPosterioresButton() }, GroupLayout.HORIZONTAL);
			{
				barraMenu = new JMenuBar();
				setJMenuBar(barraMenu);
				{
					archivoMenu = new JMenu();
					barraMenu.add(archivoMenu);
					archivoMenu.setText(getWord("archivo"));
					archivoMenu.add(getImportarDatosDeArchivoMenuItem());
					archivoMenu.add(getGuardarDatosMenuItem());
					archivoMenu.add(getBorrarDatosMenuItem());
					archivoMenu.add(getSalirMenuItem());
				}
				{
					// indicesMenu = new JMenu();
					// barraMenu.add(indicesMenu);
					// indicesMenu.setText(getWord("indices"));
					// indicesMenu.add(getAddIndicesMenu());
					// indicesMenu.add(getBorrarIndicesMenuItem());

				}
				{
					filtrosMenu = new JMenu();
					barraMenu.add(filtrosMenu);
					filtrosMenu.setText(getWord("filtros"));
					filtrosMenu.add(getAddNuevoFiltroMenuItem());
					// filtrosMenu.add(getEliminarFiltroMenuItem());
					filtrosMenu.add(getAplicarFiltroMenuItem());
				}
				{
					opcionesMenu = new JMenu();
					barraMenu.add(opcionesMenu);
					opcionesMenu.setText(getWord("opciones"));
					opcionesMenu.add(getEtiquetadoAutomaticoMenu());
					opcionesMenu.add(getPreferenciasMenuItem());
				}
				{
					ayudaMenu = new JMenu();
					barraMenu.add(ayudaMenu);
					ayudaMenu.setText(getWord("ayuda"));
					{
						acercaDeMenuItem = new JMenuItem();
						ayudaMenu.add(acercaDeMenuItem);
						acercaDeMenuItem.setText(getWord("acerca_de"));
						acercaDeMenuItem.setAction(getAcercaDeAction());
						acercaDeMenuItem.setAccelerator(KeyStroke
								.getKeyStroke("ctrl pressed A"));
					}
				}
			}
			pack();
			this.setSize(1147, 700);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void preguntarGrabarDatos() {
		int response = JOptionPane.showConfirmDialog(this,
				getWord("salir_grabar"), getWord("confirm_exit"),
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (response == JOptionPane.CANCEL_OPTION)
			return;
		if (response == JOptionPane.YES_OPTION)
			grabarDatosSalida();
		if (response == JOptionPane.NO_OPTION) {
			this.dispose();
			System.exit(0);
		}
	}

	private void rellenarTabla(int min, int numMensajes) {
		borrarTodasFilasTabla();
		List<Mensaje> m = obtenerMensajes(min, numMensajes);
		for (int i = 0; i < m.size(); i++) { // CAMBIAR
			Object[] ob = m.get(i).getRow(mostrarGruposCheckBox.isSelected());
			((DefaultTableModel) tablaMensajesModel).addRow(ob);
		}
		this.mostrados = m;
		actualizarIndicesMensajes(min, numMensajes);
	}

	private void borrarTodasFilasTabla() {
		while (((DefaultTableModel) tablaMensajesModel).getRowCount() > 0) {
			((DefaultTableModel) tablaMensajesModel).removeRow(0);
		}
	}

	private void borrarTodasFilasTabla(DefaultTableModel model) {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	private void actualizarIndicesMensajes(int min, int numMensajes) {
		this.primerMensajeMostrado = min;
		this.ultimoMensajeMostrado = min + numMensajes;
	}

	private AbstractAction getAcercaDeAction() {
		if (acercaDeAction == null) {
			acercaDeAction = new AbstractAction(getWord("acerca_de"), null) {
				public void actionPerformed(ActionEvent evt) {
					abrirVentana(getAcercaDeDialog());
				}
			};
		}
		return acercaDeAction;
	}

	private JDialog getAcercaDeDialog() {
		if (acercaDeDialog == null) {
			acercaDeDialog = new JDialog(this);
			GroupLayout acercaDeDialogLayout = new GroupLayout(
					(JComponent) acercaDeDialog.getContentPane());
			acercaDeDialog.getContentPane().setLayout(acercaDeDialogLayout);
			acercaDeDialog.setResizable(false);
			acercaDeDialog.setModalityType(ModalityType.DOCUMENT_MODAL);
			acercaDeDialog.setTitle(getWord("acerca_de"));
			acercaDeDialog.setSize(523, 182);
			acercaDeDialogLayout
					.setHorizontalGroup(acercaDeDialogLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(acercaDeDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getCreadorLabel(), 0, 483,
											Short.MAX_VALUE)
									.add(GroupLayout.LEADING,
											acercaDeDialogLayout
													.createSequentialGroup()
													.add(0, 376,
															Short.MAX_VALUE)
													.add(getCerrarAcercaDeButton(),
															GroupLayout.PREFERRED_SIZE,
															107,
															GroupLayout.PREFERRED_SIZE)))
							.addContainerGap());
			acercaDeDialogLayout.setVerticalGroup(acercaDeDialogLayout
					.createSequentialGroup()
					.addContainerGap(65, 65)
					.add(getCreadorLabel(), GroupLayout.PREFERRED_SIZE,
							GroupLayout.PREFERRED_SIZE,
							GroupLayout.PREFERRED_SIZE)
					.add(0, 33, Short.MAX_VALUE)
					.add(getCerrarAcercaDeButton(), GroupLayout.PREFERRED_SIZE,
							29, GroupLayout.PREFERRED_SIZE).addContainerGap());
		}
		return acercaDeDialog;
	}

	private JLabel getCreadorLabel() {
		if (creadorLabel == null) {
			creadorLabel = new JLabel();
			creadorLabel.setText("PFC de Alberto Rodríguez Peón");
			creadorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return creadorLabel;
	}

	private JButton getCerrarAcercaDeButton() {
		if (cerrarAcercaDeButton == null) {
			cerrarAcercaDeButton = new JButton();
			cerrarAcercaDeButton.setText(getWord("ok"));
			cerrarAcercaDeButton.setAction(getCerrarAcercaDeAction());
		}
		return cerrarAcercaDeButton;
	}

	private AbstractAction getCerrarAcercaDeAction() {
		if (cerrarAcercaDeAction == null) {
			cerrarAcercaDeAction = new AbstractAction(getWord("ok"), null) {
				public void actionPerformed(ActionEvent evt) {
					getAcercaDeDialog().dispose();
				}
			};
		}
		return cerrarAcercaDeAction;
	}

	private JMenuItem getImportarDatosDeArchivoMenuItem() {
		if (importarDatosDeArchivoMenuItem == null) {
			importarDatosDeArchivoMenuItem = new JMenuItem();
			importarDatosDeArchivoMenuItem.setText(getWord("importar_datos"));
			importarDatosDeArchivoMenuItem.setAction(getImportarDatosAction());
		}
		return importarDatosDeArchivoMenuItem;
	}

	private JMenuItem getGuardarDatosMenuItem() {
		if (guardarDatosMenuItem == null) {
			guardarDatosMenuItem = new JMenuItem();
			guardarDatosMenuItem.setText(getWord("guardar_datos"));
			guardarDatosMenuItem.setAction(getGuardarDatosAction());
		}
		return guardarDatosMenuItem;
	}

	private JMenuItem getBorrarDatosMenuItem() {
		if (borrarDatosMenuItem == null) {
			borrarDatosMenuItem = new JMenuItem();
			borrarDatosMenuItem.setText(getWord("borrar_datos"));
			borrarDatosMenuItem.setAction(getBorrarDatosAction());
		}
		return borrarDatosMenuItem;
	}

	private AbstractAction getBorrarDatosAction() {
		if (borrarDatosAction == null) {
			borrarDatosAction = new AbstractAction(getWord("borrar_datos"),
					null) {
				public void actionPerformed(ActionEvent evt) {
					borrarDatos();
				}
			};
		}
		return borrarDatosAction;
	}

	protected void borrarDatos() {
		int option = JOptionPane.showConfirmDialog(this, getWord("delete?"),
				getWord("confirmation_dialog"), JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			operacion = new BorrarBDOperacion(getMain());
			ejecutarOperacion();
		}
	}

	private JMenuItem getSalirMenuItem() {
		if (salirMenuItem == null) {
			salirMenuItem = new JMenuItem();
			salirMenuItem.setText(getWord("salir"));
			salirMenuItem.setAction(getSalirAction());
		}
		return salirMenuItem;
	}

	private JMenuItem getAddNuevoFiltroMenuItem() {
		if (addNuevoFiltroMenuItem == null) {
			addNuevoFiltroMenuItem = new JMenuItem();
			addNuevoFiltroMenuItem.setText(getWord("nuevo_filtro"));
			addNuevoFiltroMenuItem.setAction(getAddNuevoFiltroAction());
		}
		return addNuevoFiltroMenuItem;
	}

	private JMenuItem getAplicarFiltroMenuItem() {
		if (aplicarFiltroMenuItem == null) {
			aplicarFiltroMenuItem = new JMenuItem();
			aplicarFiltroMenuItem.setText(getWord("aplicar_filtro"));
			aplicarFiltroMenuItem.setAction(getAplicarFiltroAction());
		}
		return aplicarFiltroMenuItem;
	}

	private AbstractAction getAplicarFiltroAction() {
		if (aplicarFiltroAction == null) {
			aplicarFiltroAction = new AbstractAction(getWord("aplicar_filtro"),
					null) {
				public void actionPerformed(ActionEvent evt) {
					getAddMiembroClaseAplicarFiltroButton().setEnabled(false);
					ComboBoxModel categoriaModel = new DefaultComboBoxModel(
							getMain().getCategoriasFiltro());
					if (categoriaModel.getSize() == 0) {
						getOkAplicarFiltroButton().setEnabled(false);
						getCategoriaAplicarFiltroComboBox().setEnabled(false);
					} else {
						getOkAplicarFiltroButton().setEnabled(true);
						getCategoriaAplicarFiltroComboBox().setEnabled(true);
					}
					getCategoriaAplicarFiltroComboBox()
							.setModel(categoriaModel);
					getTipoAplicarFiltroComboBox().setModel(
							new DefaultComboBoxModel(new String[] {
									getWord("tags"),
									getWord("desde_pertenece"),
									getWord("para_pertenece") }));
					getMiembroClaseAplicarFiltroComboBox().setModel(
							new DefaultComboBoxModel(getMain().getEtiquetas()
									.toArray()));
					if (getMiembroClaseAplicarFiltroComboBox().getModel()
							.getSize() == 0) {
						getMiembroClaseAplicarFiltroComboBox()
								.setEnabled(false);
					} else {
						getMiembroClaseAplicarFiltroComboBox().setEnabled(true);
					}
					abrirVentana(getAplicarFiltroDialog());
				}
			};
		}
		return aplicarFiltroAction;
	}

	private JMenuItem getPreferenciasMenuItem() {
		if (preferenciasMenuItem == null) {
			preferenciasMenuItem = new JMenuItem();
			preferenciasMenuItem.setText(getWord("preferencias"));
			preferenciasMenuItem.setAction(getPreferenciasAction());
		}
		return preferenciasMenuItem;
	}

	private AbstractAction getSalirAction() {
		if (salirAction == null) {
			salirAction = new AbstractAction(getWord("salir"), null) {
				public void actionPerformed(ActionEvent evt) {
					preguntarGrabarDatos();
				}
			};
			salirAction.putValue(javax.swing.Action.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke("ctrl pressed Q"));
		}
		return salirAction;
	}

	private JDialog getBusquedaDialog() {
		if (busquedaDialog == null) {
			estadoAnterior = 0;
			busquedaDialog = new JDialog(this);
			GroupLayout busquedaDialogLayout = new GroupLayout(
					(JComponent) busquedaDialog.getContentPane());
			busquedaDialog.getContentPane().setLayout(busquedaDialogLayout);
			busquedaDialog.setTitle("");
			busquedaDialog.setPreferredSize(new java.awt.Dimension(488, 272));
			busquedaDialog.setSize(488, 272);
			getAceptarBusquedaButton().setEnabled(false);
			busquedaDialogLayout.setHorizontalGroup(busquedaDialogLayout
					.createSequentialGroup().add(getJPanel1(), 0, 472,
							Short.MAX_VALUE));
			busquedaDialogLayout.setVerticalGroup(busquedaDialogLayout
					.createSequentialGroup().add(getJPanel1(), 0, 234,
							Short.MAX_VALUE));
		}
		return busquedaDialog;
	}

	private JButton getCancelarBusquedaButton() {
		if (cancelarBusquedaButton == null) {
			cancelarBusquedaButton = new JButton();
			cancelarBusquedaButton.setText(getWord("cancelar"));
			cancelarBusquedaButton.setAction(getCancelarBusquedaAction());
		}
		return cancelarBusquedaButton;
	}

	private JButton getAceptarBusquedaButton() {
		if (aceptarBusquedaButton == null) {
			aceptarBusquedaButton = new JButton();
			aceptarBusquedaButton.setText(getWord("ok"));
			aceptarBusquedaButton.setEnabled(false);
			aceptarBusquedaButton.setAction(getOkBusquedaAction());
		}
		return aceptarBusquedaButton;
	}

	private JComboBox getBusquedaComboBox() {
		if (busquedaComboBox == null) {
			ComboBoxModel busquedaComboBoxModel = new DefaultComboBoxModel(
					new String[] { getWord("desde"), getWord("para"),
							getWord("timestamp"), getWord("message"),
							getWord("tags"), getWord("groups") });
			busquedaComboBox = new JComboBox();
			busquedaComboBox.setModel(busquedaComboBoxModel);
			busquedaComboBox.setAction(getBusquedaTiempoAction());
		}
		return busquedaComboBox;
	}

	private JTextField getBusquedaTextField() {
		if (busquedaTextField == null) {
			busquedaTextField = new JTextField();
			busquedaTextField.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					if (busquedaTextField.getText().equals("")) {
						getAceptarBusquedaButton().setEnabled(false);
					} else {
						getAceptarBusquedaButton().setEnabled(true);
					}
				}
			});
		}
		return busquedaTextField;
	}

	private AbstractAction getBusquedaAction() {
		if (busquedaAction == null) {
			busquedaAction = new AbstractAction("Búsqueda", null) {
				public void actionPerformed(ActionEvent evt) {
					getBusquedaDialog().setTitle(getWord("busqueda"));
					abrirVentana(getBusquedaDialog());
				}
			};
		}
		return busquedaAction;
	}

	private AbstractAction getCancelarBusquedaAction() {
		if (cancelarBusquedaAction == null) {
			cancelarBusquedaAction = new AbstractAction(getWord("cancelar"),
					null) {
				public void actionPerformed(ActionEvent evt) {
					getBusquedaDialog().dispose();
				}
			};
		}
		return cancelarBusquedaAction;
	}

	private JDialog getAddFiltroDialog() {
		if (addFiltroDialog == null) {
			addFiltroDialog = new JDialog(this);
			addFiltroDialog.setTitle(getWord("nuevo_filtro"));
			addFiltroDialog.setPreferredSize(new java.awt.Dimension(538, 271));
			addFiltroDialog.getContentPane().add(getAddNuevoFiltroPanel(),
					BorderLayout.CENTER);
			addFiltroDialog.setSize(538, 271);
			getAceptarAddFiltroButton().setEnabled(false);
		}
		return addFiltroDialog;
	}

	private JPanel getAddNuevoFiltroPanel() {
		if (addNuevoFiltroPanel == null) {
			addNuevoFiltroPanel = new JPanel();
			GroupLayout addNuevoFiltroPanelLayout = new GroupLayout(
					(JComponent) addNuevoFiltroPanel);
			addNuevoFiltroPanel.setLayout(addNuevoFiltroPanelLayout);
			addNuevoFiltroPanel.setPreferredSize(new java.awt.Dimension(563,
					231));
			addNuevoFiltroPanelLayout
					.setHorizontalGroup(addNuevoFiltroPanelLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(addNuevoFiltroPanelLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											addNuevoFiltroPanelLayout
													.createSequentialGroup()
													.add(getNombreFiltroLabel(),
															GroupLayout.PREFERRED_SIZE,
															60,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.UNRELATED)
													.add(getNombreAddFiltroTextField(),
															GroupLayout.PREFERRED_SIZE,
															131,
															GroupLayout.PREFERRED_SIZE))
									.add(addNuevoFiltroPanelLayout
											.createSequentialGroup()
											.add(24)
											.add(addNuevoFiltroPanelLayout
													.createParallelGroup()
													.add(GroupLayout.LEADING,
															addNuevoFiltroPanelLayout
																	.createSequentialGroup()
																	.add(getMaterialEntrenamientoComboBox(),
																			GroupLayout.PREFERRED_SIZE,
																			139,
																			GroupLayout.PREFERRED_SIZE)
																	.add(14))
													.add(GroupLayout.LEADING,
															getMaterialEntrenamientoLabel(),
															GroupLayout.PREFERRED_SIZE,
															153,
															GroupLayout.PREFERRED_SIZE))
											.add(24)))
							.add(addNuevoFiltroPanelLayout
									.createParallelGroup()
									.add(addNuevoFiltroPanelLayout
											.createSequentialGroup()
											.add(addNuevoFiltroPanelLayout
													.createParallelGroup()
													.add(GroupLayout.LEADING,
															getFuenteClasesLabel(),
															GroupLayout.PREFERRED_SIZE,
															153,
															GroupLayout.PREFERRED_SIZE)
													.add(GroupLayout.LEADING,
															addNuevoFiltroPanelLayout
																	.createSequentialGroup()
																	.add(getFuenteClasesComboBox(),
																			GroupLayout.PREFERRED_SIZE,
																			139,
																			GroupLayout.PREFERRED_SIZE)
																	.add(14)))
											.addPreferredGap(
													LayoutStyle.RELATED)
											.add(addNuevoFiltroPanelLayout
													.createParallelGroup()
													.add(GroupLayout.LEADING,
															addNuevoFiltroPanelLayout
																	.createSequentialGroup()
																	.add(getMiembrosClasesComboBox(),
																			GroupLayout.PREFERRED_SIZE,
																			139,
																			GroupLayout.PREFERRED_SIZE)
																	.add(0,
																			20,
																			Short.MAX_VALUE))
													.add(addNuevoFiltroPanelLayout
															.createSequentialGroup()
															.add(getMiembrosClasesLabel(),
																	GroupLayout.PREFERRED_SIZE,
																	159,
																	GroupLayout.PREFERRED_SIZE)
															.add(0,
																	0,
																	Short.MAX_VALUE))))
									.add(GroupLayout.LEADING,
											addNuevoFiltroPanelLayout
													.createSequentialGroup()
													.add(94)
													.add(getAceptarAddFiltroButton(),
															GroupLayout.PREFERRED_SIZE,
															97,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.UNRELATED)
													.add(getCancelarAddFiltroButton(),
															GroupLayout.PREFERRED_SIZE,
															97,
															GroupLayout.PREFERRED_SIZE)
													.add(0, 20, Short.MAX_VALUE)))
							.addContainerGap(36, 36));
			addNuevoFiltroPanelLayout.linkSize(new Component[] {
					getMaterialEntrenamientoComboBox(),
					getFuenteClasesComboBox(), getMiembrosClasesComboBox() },
					GroupLayout.HORIZONTAL);
			addNuevoFiltroPanelLayout.linkSize(
					new Component[] { getAceptarAddFiltroButton(),
							getCancelarAddFiltroButton() },
					GroupLayout.HORIZONTAL);
			addNuevoFiltroPanelLayout
					.setVerticalGroup(addNuevoFiltroPanelLayout
							.createSequentialGroup()
							.addContainerGap(44, 44)
							.add(addNuevoFiltroPanelLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getNombreAddFiltroTextField(),
											GroupLayout.PREFERRED_SIZE, 22,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getNombreFiltroLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.add(22)
							.add(addNuevoFiltroPanelLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getMiembrosClasesLabel(),
											GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getFuenteClasesLabel(),
											GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getMaterialEntrenamientoLabel(),
											GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(addNuevoFiltroPanelLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getMiembrosClasesComboBox(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getFuenteClasesComboBox(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getMaterialEntrenamientoComboBox(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.add(0, 60, Short.MAX_VALUE)
							.add(addNuevoFiltroPanelLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getAceptarAddFiltroButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getCancelarAddFiltroButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addContainerGap());
			addNuevoFiltroPanelLayout.linkSize(new Component[] {
					getMaterialEntrenamientoLabel(), getFuenteClasesLabel(),
					getMiembrosClasesLabel() }, GroupLayout.VERTICAL);
		}
		return addNuevoFiltroPanel;
	}

	private JLabel getNombreFiltroLabel() {
		if (nombreFiltroLabel == null) {
			nombreFiltroLabel = new JLabel();
			nombreFiltroLabel.setText(getWord("nombre"));
		}
		return nombreFiltroLabel;
	}

	private JTextField getNombreAddFiltroTextField() {
		if (nombreAddFiltroTextField == null) {
			nombreAddFiltroTextField = new JTextField();
			nombreAddFiltroTextField.addKeyListener(new KeyAdapter() {

				@Override
				public void keyReleased(KeyEvent e) {
					if (nombreAddFiltroTextField.getText().equals("")) {
						getAceptarAddFiltroButton().setEnabled(false);
					} else {
						if (getMiembrosClasesComboBox().getModel().getSize() > 0)
							getAceptarAddFiltroButton().setEnabled(true);
					}
				}
			});
		}
		return nombreAddFiltroTextField;
	}

	private JLabel getMaterialEntrenamientoLabel() {
		if (materialEntrenamientoLabel == null) {
			materialEntrenamientoLabel = new JLabel();
			materialEntrenamientoLabel
					.setText(getWord("material_entrenamiento"));
		}
		return materialEntrenamientoLabel;
	}

	private JComboBox getMaterialEntrenamientoComboBox() {
		if (materialEntrenamientoComboBox == null) {
			ComboBoxModel materialEntrenamientoComboBoxModel = new DefaultComboBoxModel(
					new String[] { getWord("message") });
			materialEntrenamientoComboBox = new JComboBox();
			materialEntrenamientoComboBox
					.setModel(materialEntrenamientoComboBoxModel);
		}
		return materialEntrenamientoComboBox;
	}

	private JLabel getFuenteClasesLabel() {
		if (fuenteClasesLabel == null) {
			fuenteClasesLabel = new JLabel();
			fuenteClasesLabel.setText(getWord("fuente_clases"));
		}
		return fuenteClasesLabel;
	}

	private JComboBox getFuenteClasesComboBox() {
		if (fuenteClasesComboBox == null) {
			ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(
					new String[] { getWord("tags"), getWord("desde_pertenece"),
							getWord("para_pertenece") });
			fuenteClasesComboBox = new JComboBox();
			fuenteClasesComboBox.setModel(jComboBox1Model);
			fuenteClasesComboBox.setAction(getFuenteClasesAction());
		}
		return fuenteClasesComboBox;
	}

	private AbstractAction getFuenteClasesAction() {
		if (fuenteClasesAction == null) {
			fuenteClasesAction = new AbstractAction("abstractAction1", null) {
				public void actionPerformed(ActionEvent evt) {
					if (getFuenteClasesComboBox().getSelectedIndex() == 0) {
						getMiembrosClasesComboBox().setModel(
								new DefaultComboBoxModel(getMain()
										.getEtiquetas().toArray()));
					} else {
						getMiembrosClasesComboBox().setModel(
								new DefaultComboBoxModel(getMain().getGrupos()
										.toArray()));
					}
					if (getMiembrosClasesComboBox().getModel().getSize() == 0) {
						getAceptarAddFiltroButton().setEnabled(false);
						getMiembrosClasesComboBox().setEnabled(false);
					} else {
						getMiembrosClasesComboBox().setEnabled(true);
					}

				}
			};
		}
		return fuenteClasesAction;
	}

	private JLabel getMiembrosClasesLabel() {
		if (miembrosClasesLabel == null) {
			miembrosClasesLabel = new JLabel();
			miembrosClasesLabel.setText(getWord("miembros_clases"));
		}
		return miembrosClasesLabel;
	}

	private JComboBox getMiembrosClasesComboBox() {
		if (miembrosClasesComboBox == null) {
			ComboBoxModel jComboBox2Model = new DefaultComboBoxModel(getMain()
					.getEtiquetas().toArray());
			miembrosClasesComboBox = new JComboBox();
			miembrosClasesComboBox.setModel(jComboBox2Model);
		}
		return miembrosClasesComboBox;
	}

	private JButton getCancelarAddFiltroButton() {
		if (cancelarAddFiltroButton == null) {
			cancelarAddFiltroButton = new JButton();
			cancelarAddFiltroButton.setText(getWord("cancelar"));
			cancelarAddFiltroButton.setAction(getCancelarAddFiltroAction());
		}
		return cancelarAddFiltroButton;
	}

	private JButton getAceptarAddFiltroButton() {
		if (aceptarAddFiltroButton == null) {
			aceptarAddFiltroButton = new JButton();
			aceptarAddFiltroButton.setText(getWord("ok"));
			aceptarAddFiltroButton.setEnabled(false);
			aceptarAddFiltroButton.setAction(getAceptarAddFiltroAction());
		}
		return aceptarAddFiltroButton;
	}

	private AbstractAction getAceptarAddFiltroAction() {
		if (aceptarAddFiltroAction == null) {
			aceptarAddFiltroAction = new AbstractAction(getWord("ok"), null) {
				public void actionPerformed(ActionEvent evt) {
					crearFiltro();
					getNombreAddFiltroTextField().setText("");
					getAceptarAddFiltroButton().setEnabled(false);
				}
			};
		}
		return aceptarAddFiltroAction;
	}

	private void crearFiltro() {
		String categoria = getNombreAddFiltroTextField().getText();
		switch (getFuenteClasesComboBox().getSelectedIndex()) {
		case 0:
			operacion = new AddFiltroOperacion(getMain(), categoria,
					new Etiqueta(
							((DefaultComboBoxModel) getMiembrosClasesComboBox()
									.getModel()).getSelectedItem().toString()));
			break;
		case 1:
			operacion = new AddFiltroOperacion(getMain(), categoria, new Grupo(
					((DefaultComboBoxModel) getMiembrosClasesComboBox()
							.getModel()).getSelectedItem().toString()), true);
			break;
		default:
			operacion = new AddFiltroOperacion(getMain(), categoria, new Grupo(
					((DefaultComboBoxModel) getMiembrosClasesComboBox()
							.getModel()).getSelectedItem().toString()), false);
			break;
		}
		ejecutarOperacion(getAddFiltroDialog());
	}

	private AbstractAction getCancelarAddFiltroAction() {
		if (cancelarAddFiltroAction == null) {
			cancelarAddFiltroAction = new AbstractAction(getWord("cancelar"),
					null) {
				public void actionPerformed(ActionEvent evt) {
					getAddFiltroDialog().dispose();
				}
			};
		}
		return cancelarAddFiltroAction;
	}

	private AbstractAction getAddNuevoFiltroAction() {
		if (addNuevoFiltroAction == null) {
			addNuevoFiltroAction = new AbstractAction(getWord("nuevo_filtro"),
					null) {
				public void actionPerformed(ActionEvent evt) {
					getMaterialEntrenamientoComboBox().setModel(
							new DefaultComboBoxModel(new String[] {
									getWord("message"), getWord("tags") }));
					getFuenteClasesComboBox().setModel(
							new DefaultComboBoxModel(new String[] {
									getWord("tags"),
									getWord("desde_pertenece"),
									getWord("para_pertenece") }));
					rellenarComboBox(
							(DefaultComboBoxModel) getMiembrosClasesComboBox()
									.getModel(), getMain().getEtiquetas());
					if (getMiembrosClasesComboBox().getModel().getSize() == 0) {
						getAceptarAddFiltroButton().setEnabled(false);
						getMiembrosClasesComboBox().setEnabled(false);
					} else {
						getMiembrosClasesComboBox().setEnabled(true);
					}
					abrirVentana(getAddFiltroDialog());
				}
			};
			addNuevoFiltroAction.putValue(javax.swing.Action.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke("ctrl pressed F"));
		}
		return addNuevoFiltroAction;
	}

	private JPopupMenu getFromPopupMenu() {
		if (fromPopupMenu == null) {
			fromPopupMenu = new JPopupMenu();
			fromPopupMenu.setBounds(499, 202, 86, 20);
			fromPopupMenu.add(getIgnorarMensajesMenuItem());
			fromPopupMenu.add(getMostrarMensajesSolamenteMenuItem());
			fromPopupMenu.add(getIgnorarMensajesDeLosGruposMenuItem());
			fromPopupMenu.add(getOcultarMensajesMenuItem());
			fromPopupMenu.add(getAddAGrupoMenuItem());
		}
		return fromPopupMenu;
	}

	/**
	 * Auto-generated method for setting the popup menu for a component
	 */
	private void setComponentPopupMenu(final java.awt.Component parent,
			final javax.swing.JPopupMenu menu) {
		parent.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent e) {
				if (e.isPopupTrigger())
					menu.show(parent, e.getX(), e.getY());
			}

			public void mouseReleased(java.awt.event.MouseEvent e) {
				if (e.isPopupTrigger())
					menu.show(parent, e.getX(), e.getY());
			}
		});
	}

	private JMenuItem getIgnorarMensajesMenuItem() {
		if (ignorarMensajesMenuItem == null) {
			ignorarMensajesMenuItem = new JMenuItem();
			ignorarMensajesMenuItem.setText(getWord("ignorar_mensajes_de"));
			ignorarMensajesMenuItem.setAction(getIgnorarMensajesAction());
		}
		return ignorarMensajesMenuItem;
	}

	private JMenuItem getMostrarMensajesSolamenteMenuItem() {
		if (mostrarMensajesSolamenteMenuItem == null) {
			mostrarMensajesSolamenteMenuItem = new JMenuItem();
			mostrarMensajesSolamenteMenuItem
					.setText(getWord("mostrar_mensajes_solamente_de"));
			mostrarMensajesSolamenteMenuItem
					.setAction(getMostrarMensajesSolamenteAction());
		}
		return mostrarMensajesSolamenteMenuItem;
	}

	private JMenuItem getIgnorarMensajesDeLosGruposMenuItem() {
		if (ignorarMensajesDeLosGruposMenuItem == null) {
			ignorarMensajesDeLosGruposMenuItem = new JMenuItem();
			ignorarMensajesDeLosGruposMenuItem
					.setText(getWord("ignorar_mensajes_grupos_pertenece"));
			ignorarMensajesDeLosGruposMenuItem
					.setAction(getIgnorarMensajesDeLosGruposAction());
		}
		return ignorarMensajesDeLosGruposMenuItem;
	}

	private JMenuItem getOcultarMensajesMenuItem() {
		if (ocultarMensajesMenuItem == null) {
			ocultarMensajesMenuItem = new JMenuItem();
			ocultarMensajesMenuItem
					.setText(getWord("ocultar_mensajes_enviados"));
			ocultarMensajesMenuItem.setAction(getOcultarMensajesDeAction());
		}
		return ocultarMensajesMenuItem;
	}

	private JMenuItem getAddAGrupoMenuItem() {
		if (addAGrupoMenuItem == null) {
			addAGrupoMenuItem = new JMenuItem();
			addAGrupoMenuItem.setText(getWord("add_grupo"));
			addAGrupoMenuItem.setAction(getAddUsuarioGrupoAction());
		}
		return addAGrupoMenuItem;
	}

	private JPopupMenu getBelongsPopupMenu() {
		if (belongsPopupMenu == null) {
			belongsPopupMenu = new JPopupMenu();
			belongsPopupMenu.setBounds(499, 202, 86, 20);
			belongsPopupMenu.add(getIgnorarMensajesComunidadMenuItem());
			belongsPopupMenu.add(getMostrarMensajesComunidadMenuItem());
			belongsPopupMenu.add(getOcultarMensajesComunidadMenuItem());
		}
		return belongsPopupMenu;
	}

	private JMenuItem getIgnorarMensajesComunidadMenuItem() {
		if (ignorarMensajesComunidadMenuItem == null) {
			ignorarMensajesComunidadMenuItem = new JMenuItem();
			ignorarMensajesComunidadMenuItem
					.setText(getWord("ignorar_mensajes_usuarios_pertenecientes"));
			ignorarMensajesComunidadMenuItem
					.setAction(getIgnorarMensajesComunidadAction());
		}
		return ignorarMensajesComunidadMenuItem;
	}

	private JMenuItem getMostrarMensajesComunidadMenuItem() {
		if (mostrarMensajesComunidadMenuItem == null) {
			mostrarMensajesComunidadMenuItem = new JMenuItem();
			mostrarMensajesComunidadMenuItem
					.setText(getWord("mostrar_solamente_mensajes_usuarios_pertenecientes"));
			mostrarMensajesComunidadMenuItem
					.setAction(getMostrarMensajesComunidadAction());
		}
		return mostrarMensajesComunidadMenuItem;
	}

	private JMenuItem getOcultarMensajesComunidadMenuItem() {
		if (ocultarMensajesComunidadMenuItem == null) {
			ocultarMensajesComunidadMenuItem = new JMenuItem();
			ocultarMensajesComunidadMenuItem
					.setText(getWord("ocultar_mensajes_usuarios_pertenecientes"));
			ocultarMensajesComunidadMenuItem
					.setAction(getOcultarMensajesComunidadAction());
		}
		return ocultarMensajesComunidadMenuItem;
	}

	private JPopupMenu getTimestampPopupMenu() {
		if (timestampPopupMenu == null) {
			timestampPopupMenu = new JPopupMenu();
			timestampPopupMenu.setBounds(499, 202, 86, 20);
			timestampPopupMenu.add(getMostrarMensajesAnterioresMenuItem());
			timestampPopupMenu.add(getMostrarMensajesPosterioresMenuItem());
			// timestampPopupMenu.add(getMostrarMensajesCercanosMenuItem());
			// timestampPopupMenu.add(getSeleccionarRangoMenuItem());
		}
		return timestampPopupMenu;
	}

	private JMenuItem getMostrarMensajesAnterioresMenuItem() {
		if (mostrarMensajesAnterioresMenuItem == null) {
			mostrarMensajesAnterioresMenuItem = new JMenuItem();
			mostrarMensajesAnterioresMenuItem
					.setText(getWord("mostrar_mensajes_anteriores"));
			mostrarMensajesAnterioresMenuItem
					.setAction(getMostrarMensajesAnterioresAction());
		}
		return mostrarMensajesAnterioresMenuItem;
	}

	private JMenuItem getMostrarMensajesPosterioresMenuItem() {
		if (mostrarMensajesPosterioresMenuItem == null) {
			mostrarMensajesPosterioresMenuItem = new JMenuItem();
			mostrarMensajesPosterioresMenuItem
					.setText(getWord("mostrar_mensajes_posteriores"));
			mostrarMensajesPosterioresMenuItem
					.setAction(getMostrarMensajesPosterioresAction());
		}
		return mostrarMensajesPosterioresMenuItem;
	}

	// private JMenuItem getMostrarMensajesCercanosMenuItem() {
	// if(mostrarMensajesCercanosMenuItem == null) {
	// mostrarMensajesCercanosMenuItem = new JMenuItem();
	// mostrarMensajesCercanosMenuItem.setText(getWord("mostrar_mensajes_cercanos_tiempo"));
	// mostrarMensajesCercanosMenuItem.setAction(getMostrarMensajesCercanosTiempoAction());
	// }
	// return mostrarMensajesCercanosMenuItem;
	// }

	// private JMenuItem getSeleccionarRangoMenuItem() {
	// if(seleccionarRangoMenuItem == null) {
	// seleccionarRangoMenuItem = new JMenuItem();
	// seleccionarRangoMenuItem.setText(getWord("seleccionar_rango"));
	// }
	// return seleccionarRangoMenuItem;
	// }

	private JPopupMenu getMessagePopupMenu() {
		if (messagePopupMenu == null) {
			messagePopupMenu = new JPopupMenu();
			messagePopupMenu.add(getBuscarMensajesSimilaresMenuItem());
			messagePopupMenu.add(getIgnorarMensajesSimilaresMenuItem());
			messagePopupMenu.add(getEtiquetarMensajeMenuItem());
			messagePopupMenu.add(getEtiquetarMensajesSimilaresMenuItem());
			messagePopupMenu
					.add(getAddGrupoUsuariosRecibenMensajesSimilaresMenuItem());
		}
		return messagePopupMenu;
	}

	private JMenuItem getBuscarMensajesSimilaresMenuItem() {
		if (buscarMensajesSimilaresMenuItem == null) {
			buscarMensajesSimilaresMenuItem = new JMenuItem();
			buscarMensajesSimilaresMenuItem
					.setText(getWord("buscar_mensajes_similares"));
			buscarMensajesSimilaresMenuItem
					.setAction(getBuscarMensajesSimilaresAction());
		}
		return buscarMensajesSimilaresMenuItem;
	}

	private JMenuItem getIgnorarMensajesSimilaresMenuItem() {
		if (ignorarMensajesSimilaresMenuItem == null) {
			ignorarMensajesSimilaresMenuItem = new JMenuItem();
			ignorarMensajesSimilaresMenuItem
					.setText(getWord("ignorar_mensajes_similares"));
			ignorarMensajesSimilaresMenuItem
					.setAction(getIgnorarMensajesSimilaresAction());
		}
		return ignorarMensajesSimilaresMenuItem;
	}

	private JMenuItem getEtiquetarMensajeMenuItem() {
		if (etiquetarMensajeMenuItem == null) {
			etiquetarMensajeMenuItem = new JMenuItem();
			etiquetarMensajeMenuItem.setText(getWord("etiquetar_mensaje"));
			etiquetarMensajeMenuItem.setAction(getEtiquetarMensajeAction());
		}
		return etiquetarMensajeMenuItem;
	}

	private JPopupMenu getTagPopupMenu() {
		if (tagPopupMenu == null) {
			tagPopupMenu = new JPopupMenu();
			tagPopupMenu.add(getBuscarMensajesMismasTagsMenuItem());
			tagPopupMenu.add(getIgnorarMensajesMismasTagsMenuItem());
			tagPopupMenu.add(getOcultarMensajesMismasTagsMenuItem());
			tagPopupMenu.add(getAddTagsMenuItem());
			tagPopupMenu.add(getAddGrupoUsuariosMismasTagsMenuItem());
		}
		return tagPopupMenu;
	}

	private JMenuItem getBuscarMensajesMismasTagsMenuItem() {
		if (buscarMensajesMismasTagsMenuItem == null) {
			buscarMensajesMismasTagsMenuItem = new JMenuItem();
			buscarMensajesMismasTagsMenuItem
					.setText(getWord("buscar_mensajes_mismas_tags"));
			buscarMensajesMismasTagsMenuItem
					.setAction(getBuscarMensajesMismasTagsAction());
		}
		return buscarMensajesMismasTagsMenuItem;
	}

	private JMenuItem getIgnorarMensajesMismasTagsMenuItem() {
		if (ignorarMensajesMismasTagsMenuItem == null) {
			ignorarMensajesMismasTagsMenuItem = new JMenuItem();
			ignorarMensajesMismasTagsMenuItem
					.setText(getWord("ignorar_mensajes_mismas_tags"));
			ignorarMensajesMismasTagsMenuItem
					.setAction(getIgnorarMensajesMismasTagsAction());
		}
		return ignorarMensajesMismasTagsMenuItem;
	}

	private JMenuItem getOcultarMensajesMismasTagsMenuItem() {
		if (ocultarMensajesMismasTagsMenuItem == null) {
			ocultarMensajesMismasTagsMenuItem = new JMenuItem();
			ocultarMensajesMismasTagsMenuItem
					.setText(getWord("ocultar_mensajes_mismas_tags"));
			ocultarMensajesMismasTagsMenuItem
					.setAction(getOcultarMensajesMismasTagsAction());
		}
		return ocultarMensajesMismasTagsMenuItem;
	}

	private JMenuItem getAddTagsMenuItem() {
		if (addTagsMenuItem == null) {
			addTagsMenuItem = new JMenuItem();
			addTagsMenuItem.setText(getWord("etiquetar_mensaje"));
			addTagsMenuItem.setAction(getAddTagsMensajeAction());
		}
		return addTagsMenuItem;
	}

	private JMenuItem getAddGrupoUsuariosMismasTagsMenuItem() {
		if (addGrupoUsuariosMismasTagsMenuItem == null) {
			addGrupoUsuariosMismasTagsMenuItem = new JMenuItem();
			addGrupoUsuariosMismasTagsMenuItem
					.setText(getWord("add_grupo_usuarios_mismas_tags"));
			addGrupoUsuariosMismasTagsMenuItem
					.setAction(getAddGrupoUsuariosMismasTagsAction());
		}
		return addGrupoUsuariosMismasTagsMenuItem;
	}

	// private JMenu getAddIndicesMenu() {
	// if (addIndicesMenu == null) {
	// addIndicesMenu = new JMenu();
	// addIndicesMenu.setText(getWord("add"));
	// addIndicesMenu.add(getShinglingMenuItem());
	// addIndicesMenu.add(getKeyboardBasedMenuItem());
	// }
	// return addIndicesMenu;
	// }
	//
	// private JMenuItem getShinglingMenuItem() {
	// if (shinglingMenuItem == null) {
	// shinglingMenuItem = new JMenuItem();
	// shinglingMenuItem.setText(getWord("shingling"));
	// }
	// return shinglingMenuItem;
	// }
	//
	// private JMenuItem getKeyboardBasedMenuItem() {
	// if (keyboardBasedMenuItem == null) {
	// keyboardBasedMenuItem = new JMenuItem();
	// keyboardBasedMenuItem.setText(getWord("keyboard_based"));
	// }
	// return keyboardBasedMenuItem;
	// }

	private JMenu getEtiquetadoAutomaticoMenu() {
		if (etiquetadoAutomaticoMenu == null) {
			etiquetadoAutomaticoMenu = new JMenu();
			etiquetadoAutomaticoMenu.setText(getWord("etiquetado_automatico"));
			etiquetadoAutomaticoMenu.add(getMediantePatronMenuItem());
		}
		return etiquetadoAutomaticoMenu;
	}

	private JMenuItem getMediantePatronMenuItem() {
		if (mediantePatronMenuItem == null) {
			mediantePatronMenuItem = new JMenuItem();
			mediantePatronMenuItem.setText(getWord("mediante_patron"));
			mediantePatronMenuItem
					.setAction(getEtiquetadoMediantePatronAction());
		}
		return mediantePatronMenuItem;
	}

	private AbstractAction getEtiquetadoMediantePatronAction() {
		if (etiquetadoMediantePatronAction == null) {
			etiquetadoMediantePatronAction = new AbstractAction(
					getWord("mediante_patron"), null) {
				public void actionPerformed(ActionEvent evt) {
					getBackEtiquetadoMediantePatronButton().setEnabled(false);
					getNextEtiquetadoMediantePatronButton().setEnabled(false);
					getPrimerPasoEtiquetadoMediantePatronPanel().setVisible(
							true);
					getSegundoPasoEtiquetadoMediantePatronPanel().setVisible(
							false);
					cargarLista((DefaultListModel) getPatronesActualesList()
							.getModel(), getMain().getPatrones());
					cargarLista(
							(DefaultListModel) getPatronesSeleccionadosList()
									.getModel(), null);
					abrirVentana(getEtiquetadoMediantePatronDialog());
				}
			};
			etiquetadoMediantePatronAction.putValue(
					javax.swing.Action.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke("ctrl pressed P"));
		}
		return etiquetadoMediantePatronAction;
	}

	private JDialog getEtiquetadoMediantePatronDialog() {
		if (etiquetadoMediantePatronDialog == null) {
			etiquetadoMediantePatronDialog = new JDialog(this);
			patronesSeleccionados = new LinkedList<Patron>();
			GroupLayout etiquetadoMediantePatronDialogLayout = new GroupLayout(
					(JComponent) etiquetadoMediantePatronDialog
							.getContentPane());
			etiquetadoMediantePatronDialog.getContentPane().setLayout(
					etiquetadoMediantePatronDialogLayout);
			etiquetadoMediantePatronDialog
					.setTitle(getWord("etiquetado_automatico_mediante_patron"));
			etiquetadoMediantePatronDialog
					.setPreferredSize(new java.awt.Dimension(710, 447));
			etiquetadoMediantePatronDialog.setSize(710, 447);
			getNextEtiquetadoMediantePatronButton().setEnabled(false);
			getPrimerPasoEtiquetadoMediantePatronPanel().setVisible(true);
			getSegundoPasoEtiquetadoMediantePatronPanel().setVisible(false);
			etiquetadoMediantePatronDialogLayout
					.setHorizontalGroup(etiquetadoMediantePatronDialogLayout
							.createParallelGroup()
							.add(GroupLayout.LEADING,
									getPrimerPasoEtiquetadoMediantePatronPanel(),
									0, 694, Short.MAX_VALUE)
							.add(etiquetadoMediantePatronDialogLayout
									.createSequentialGroup()
									.addPreferredGap(
											getPrimerPasoEtiquetadoMediantePatronPanel(),
											getSegundoPasoEtiquetadoMediantePatronPanel(),
											LayoutStyle.INDENT)
									.add(etiquetadoMediantePatronDialogLayout
											.createParallelGroup()
											.add(GroupLayout.LEADING,
													getSegundoPasoEtiquetadoMediantePatronPanel(),
													0, 684, Short.MAX_VALUE)
											.add(GroupLayout.LEADING,
													etiquetadoMediantePatronDialogLayout
															.createSequentialGroup()
															.add(0,
																	328,
																	Short.MAX_VALUE)
															.add(getBotonesEtiquetadoMediantePatronPanel(),
																	GroupLayout.PREFERRED_SIZE,
																	336,
																	GroupLayout.PREFERRED_SIZE)
															.add(20)))));
			etiquetadoMediantePatronDialogLayout
					.setVerticalGroup(etiquetadoMediantePatronDialogLayout
							.createParallelGroup()
							.add(GroupLayout.LEADING,
									etiquetadoMediantePatronDialogLayout
											.createSequentialGroup()
											.add(getPrimerPasoEtiquetadoMediantePatronPanel(),
													GroupLayout.PREFERRED_SIZE,
													352,
													GroupLayout.PREFERRED_SIZE)
											.add(getSegundoPasoEtiquetadoMediantePatronPanel(),
													GroupLayout.PREFERRED_SIZE,
													351,
													GroupLayout.PREFERRED_SIZE)
											.addContainerGap(58,
													Short.MAX_VALUE))
							.add(GroupLayout.LEADING,
									etiquetadoMediantePatronDialogLayout
											.createSequentialGroup()
											.add(9)
											.add(getBotonesEtiquetadoMediantePatronPanel(),
													0, 389, Short.MAX_VALUE)
											.addContainerGap()));
		}
		return etiquetadoMediantePatronDialog;
	}

	private JButton getCancelEtiquetadoMediantePatronButton() {
		if (cancelEtiquetadoMediantePatronButton == null) {
			cancelEtiquetadoMediantePatronButton = new JButton();
			cancelEtiquetadoMediantePatronButton.setText(getWord("cancelar"));
			cancelEtiquetadoMediantePatronButton
					.setAction(getCancelEtMediantePatronAction());
		}
		return cancelEtiquetadoMediantePatronButton;
	}

	private JButton getNextEtiquetadoMediantePatronButton() {
		if (nextEtiquetadoMediantePatronButton == null) {
			nextEtiquetadoMediantePatronButton = new JButton();
			nextEtiquetadoMediantePatronButton.setText(getWord("next"));
			nextEtiquetadoMediantePatronButton.setEnabled(false);
			nextEtiquetadoMediantePatronButton
					.setAction(getNextEtiquetadoMediantePatronAction());
		}
		return nextEtiquetadoMediantePatronButton;
	}

	private JButton getBackEtiquetadoMediantePatronButton() {
		if (backEtiquetadoMediantePatronButton == null) {
			backEtiquetadoMediantePatronButton = new JButton();
			backEtiquetadoMediantePatronButton.setText(getWord("back"));
			backEtiquetadoMediantePatronButton.setEnabled(false);
			backEtiquetadoMediantePatronButton
					.setAction(getBackEtiquetadoMediantePatronAction());
		}
		return backEtiquetadoMediantePatronButton;
	}

	private JLabel getBusquedaRapidaEtMediantePatronLabel() {
		if (busquedaRapidaEtMediantePatronLabel == null) {
			busquedaRapidaEtMediantePatronLabel = new JLabel();
			busquedaRapidaEtMediantePatronLabel
					.setText(getWord("busqueda_rapida"));
		}
		return busquedaRapidaEtMediantePatronLabel;
	}

	private JTextField getBusquedaRapidaEtMediantePatronTextField() {
		if (busquedaRapidaEtMediantePatronTextField == null) {
			busquedaRapidaEtMediantePatronTextField = new JTextField();
			busquedaRapidaEtMediantePatronTextField
					.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							actualizarListPatrones(
									(DefaultListModel) getPatronesActualesList()
											.getModel(),
									(DefaultListModel) getPatronesSeleccionadosList()
											.getModel(),
									busquedaRapidaEtMediantePatronTextField
											.getText());
						}
					});
		}
		return busquedaRapidaEtMediantePatronTextField;
	}

	private void actualizarListPatrones(DefaultListModel todos,
			DefaultListModel restriccion, String text) {
		todos.clear();
		for (Patron p : getMain().getPatrones()) {
			if (p.toString().startsWith(text)
					&& !listaContiene(p.toString(), restriccion)) {
				todos.addElement(p.toString());
			}
		}
	}

	private boolean listaContiene(String string, DefaultListModel restriccion) {
		for (int i = 0; i < restriccion.size(); i++) {
			if (string.equals(restriccion.getElementAt(i).toString()))
				return true;
		}
		return false;
	}

	private JList getPatronesActualesList() {
		if (patronesActualesList == null) {
			ListModel patronesActualesListModel = new DefaultListModel();
			patronesActualesList = new JList();
			patronesActualesList.setModel(patronesActualesListModel);
			patronesActualesList
					.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return patronesActualesList;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getPatronesActualesList());
		}
		return jScrollPane1;
	}

	private JButton getAddPatronActualButton() {
		if (addPatronActualButton == null) {
			addPatronActualButton = new JButton();
			addPatronActualButton.setText(">");
			addPatronActualButton.setAction(getAddPatronActualAction());
		}
		return addPatronActualButton;
	}

	private AbstractAction getAddPatronActualAction() {
		if (addPatronActualAction == null) {
			addPatronActualAction = new AbstractAction(">", null) {
				public void actionPerformed(ActionEvent evt) {
					if (getPatronesActualesList().getSelectedIndex() != -1) {
						Patron p = new Patron(
								((DefaultListModel) getPatronesActualesList()
										.getModel()).get(
										getPatronesActualesList()
												.getSelectedIndex()).toString());
						patronesSeleccionados.add(p);
						moverElementoList(getPatronesActualesList(),
								getPatronesSeleccionadosList());
						getNextEtiquetadoMediantePatronButton()
								.setEnabled(true);

					}
				}
			};
		}
		return addPatronActualAction;
	}

	private JButton getBorrarPatronActualButton() {
		if (borrarPatronActualButton == null) {
			borrarPatronActualButton = new JButton();
			borrarPatronActualButton.setText("<");
			borrarPatronActualButton.setAction(getBorrarPatronActualAction());
		}
		return borrarPatronActualButton;
	}

	private AbstractAction getBorrarPatronActualAction() {
		if (borrarPatronActualAction == null) {
			borrarPatronActualAction = new AbstractAction("<", null) {
				public void actionPerformed(ActionEvent evt) {
					if (getPatronesSeleccionadosList().getSelectedIndex() != -1) {
						Patron p = new Patron(
								((DefaultListModel) getPatronesSeleccionadosList()
										.getModel()).get(
										getPatronesSeleccionadosList()
												.getSelectedIndex()).toString());
						patronesSeleccionados.remove(p);
						moverElementoList(getPatronesSeleccionadosList(),
								getPatronesActualesList());
						if (getPatronesSeleccionadosList().getModel().getSize() == 0)
							getNextEtiquetadoMediantePatronButton().setEnabled(
									false);
					}
				}
			};
		}
		return borrarPatronActualAction;
	}

	private JList getPatronesSeleccionadosList() {
		if (patronesSeleccionadosList == null) {
			ListModel patronesSeleccionadosListModel = new DefaultListModel();
			patronesSeleccionadosList = new JList();
			patronesSeleccionadosList.setModel(patronesSeleccionadosListModel);
			patronesSeleccionadosList
					.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return patronesSeleccionadosList;
	}

	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getPatronesSeleccionadosList());
		}
		return jScrollPane2;
	}

	private JButton getAddPatronButton() {
		if (addPatronButton == null) {
			addPatronButton = new JButton();
			addPatronButton.setText(getWord("add_patron"));
			addPatronButton.setAction(getAddPatronAction());
		}
		return addPatronButton;
	}

	private AbstractAction getAddPatronAction() {
		if (addPatronAction == null) {
			addPatronAction = new AbstractAction(getWord("add_patron"), null) {
				public void actionPerformed(ActionEvent evt) {
					getBusquedaDialog().setTitle(getWord("add_patron"));
					abrirVentana(getBusquedaDialog());
				}
			};
		}
		return addPatronAction;
	}

	private AbstractAction getCancelEtMediantePatronAction() {
		if (cancelEtMediantePatronAction == null) {
			cancelEtMediantePatronAction = new AbstractAction(
					getWord("cancelar"), null) {
				public void actionPerformed(ActionEvent evt) {
					retrocederEtiquetadoMediantePatron();
					patronesSeleccionados = new LinkedList<Patron>();
					getEtiquetadoMediantePatronDialog().dispose();
				}
			};
		}
		return cancelEtMediantePatronAction;
	}

	private JDialog getAddUsuarioGrupoDialog() {
		if (addUsuarioGrupoDialog == null) {
			addUsuarioGrupoDialog = new JDialog(this);
			GroupLayout addUsuarioGrupoDialogLayout = new GroupLayout(
					(JComponent) addUsuarioGrupoDialog.getContentPane());
			addUsuarioGrupoDialog.getContentPane().setLayout(
					addUsuarioGrupoDialogLayout);
			addUsuarioGrupoDialog.setTitle(getWord("add_grupo"));
			addUsuarioGrupoDialog.setPreferredSize(new java.awt.Dimension(509,
					336));
			addUsuarioGrupoDialog.setSize(509, 336);
			addUsuarioGrupoDialogLayout
					.setHorizontalGroup(addUsuarioGrupoDialogLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(addUsuarioGrupoDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getJScrollPane4(),
											GroupLayout.PREFERRED_SIZE, 187,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											getGruposDisponiblesLabel(),
											GroupLayout.PREFERRED_SIZE, 187,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											addUsuarioGrupoDialogLayout
													.createSequentialGroup()
													.add(getAddNuevoGrupoLabel(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.UNRELATED)
													.add(getAddNuevoGrupoTextField(),
															GroupLayout.PREFERRED_SIZE,
															88,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.UNRELATED)
													.add(getAddNuevoGrupoButton(),
															GroupLayout.PREFERRED_SIZE,
															44,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.RELATED)))
							.addPreferredGap(LayoutStyle.UNRELATED)
							.add(addUsuarioGrupoDialogLayout
									.createParallelGroup()
									.add(addUsuarioGrupoDialogLayout
											.createSequentialGroup()
											.add(0, 0, Short.MAX_VALUE)
											.add(addUsuarioGrupoDialogLayout
													.createParallelGroup()
													.add(GroupLayout.LEADING,
															getAddGrupoButton(),
															GroupLayout.PREFERRED_SIZE,
															81,
															GroupLayout.PREFERRED_SIZE)
													.add(GroupLayout.LEADING,
															getBorrarGrupoButton(),
															GroupLayout.PREFERRED_SIZE,
															81,
															GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(
													LayoutStyle.RELATED)
											.add(addUsuarioGrupoDialogLayout
													.createParallelGroup()
													.add(GroupLayout.LEADING,
															getJScrollPane3(),
															GroupLayout.PREFERRED_SIZE,
															187,
															GroupLayout.PREFERRED_SIZE)
													.add(GroupLayout.LEADING,
															getGruposActualesLabel(),
															GroupLayout.PREFERRED_SIZE,
															187,
															GroupLayout.PREFERRED_SIZE)))
									.add(GroupLayout.LEADING,
											addUsuarioGrupoDialogLayout
													.createSequentialGroup()
													.add(0, 52, Short.MAX_VALUE)
													.add(getOkAddUsuarioGrupoButton(),
															GroupLayout.PREFERRED_SIZE,
															106,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.UNRELATED,
															1,
															GroupLayout.PREFERRED_SIZE)
													.add(getCancelAddUsuarioGrupoButton(),
															GroupLayout.PREFERRED_SIZE,
															106,
															GroupLayout.PREFERRED_SIZE)))
							.addContainerGap());
			addUsuarioGrupoDialogLayout.linkSize(new Component[] {
					getBorrarGrupoButton(), getAddGrupoButton() },
					GroupLayout.HORIZONTAL);
			addUsuarioGrupoDialogLayout.linkSize(new Component[] {
					getCancelAddUsuarioGrupoButton(),
					getOkAddUsuarioGrupoButton() }, GroupLayout.HORIZONTAL);
			addUsuarioGrupoDialogLayout
					.setVerticalGroup(addUsuarioGrupoDialogLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(addUsuarioGrupoDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getGruposActualesLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getGruposDisponiblesLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(addUsuarioGrupoDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getJScrollPane3(),
											GroupLayout.PREFERRED_SIZE, 194,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											getJScrollPane4(),
											GroupLayout.PREFERRED_SIZE, 194,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											addUsuarioGrupoDialogLayout
													.createSequentialGroup()
													.add(54)
													.add(getAddGrupoButton(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.add(25)
													.add(getBorrarGrupoButton(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.add(63)))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(addUsuarioGrupoDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getAddNuevoGrupoTextField(),
											GroupLayout.PREFERRED_SIZE, 22,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getAddNuevoGrupoLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getAddNuevoGrupoButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.add(addUsuarioGrupoDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getCancelAddUsuarioGrupoButton(),
											GroupLayout.PREFERRED_SIZE, 29,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getOkAddUsuarioGrupoButton(),
											GroupLayout.PREFERRED_SIZE, 29,
											GroupLayout.PREFERRED_SIZE))
							.addContainerGap(15, 15));
			addUsuarioGrupoDialogLayout.linkSize(new Component[] {
					getOkAddUsuarioGrupoButton(),
					getCancelAddUsuarioGrupoButton() }, GroupLayout.VERTICAL);
		}
		return addUsuarioGrupoDialog;
	}

	private JList getGruposDisponiblesList() {
		if (gruposDisponiblesList == null) {
			ListModel gruposDisponiblesListModel = new DefaultListModel();
			gruposDisponiblesList = new JList();
			gruposDisponiblesList.setModel(gruposDisponiblesListModel);
			gruposDisponiblesList.setPreferredSize(new java.awt.Dimension(183,
					190));
			gruposDisponiblesList
					.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return gruposDisponiblesList;
	}

	private JList getGruposActualesList() {
		if (gruposActualesList == null) {
			ListModel gruposActualesListModel = new DefaultListModel();
			gruposActualesList = new JList();
			gruposActualesList.setModel(gruposActualesListModel);
			gruposActualesList
					.setPreferredSize(new java.awt.Dimension(165, 173));
			gruposActualesList
					.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return gruposActualesList;
	}

	private JScrollPane getJScrollPane3() {
		if (jScrollPane3 == null) {
			jScrollPane3 = new JScrollPane();
			jScrollPane3.setViewportView(getGruposActualesList());
		}
		return jScrollPane3;
	}

	private JScrollPane getJScrollPane4() {
		if (jScrollPane4 == null) {
			jScrollPane4 = new JScrollPane();
			jScrollPane4.setViewportView(getGruposDisponiblesList());
		}
		return jScrollPane4;
	}

	private JButton getAddGrupoButton() {
		if (addGrupoButton == null) {
			addGrupoButton = new JButton();
			addGrupoButton.setText(">");
			addGrupoButton.setAction(getAddGrupoAction());
		}
		return addGrupoButton;
	}

	private JButton getBorrarGrupoButton() {
		if (borrarGrupoButton == null) {
			borrarGrupoButton = new JButton();
			borrarGrupoButton.setText("<");
			borrarGrupoButton.setAction(getBorrarGrupoAction());
		}
		return borrarGrupoButton;
	}

	private JLabel getGruposDisponiblesLabel() {
		if (gruposDisponiblesLabel == null) {
			gruposDisponiblesLabel = new JLabel();
			gruposDisponiblesLabel.setText(getWord("grupos_disponibles"));
			gruposDisponiblesLabel
					.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return gruposDisponiblesLabel;
	}

	private JLabel getGruposActualesLabel() {
		if (gruposActualesLabel == null) {
			gruposActualesLabel = new JLabel();
			gruposActualesLabel.setText(getWord("grupos_actuales"));
			gruposActualesLabel.setFocusTraversalPolicyProvider(true);
			gruposActualesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return gruposActualesLabel;
	}

	private JTextField getAddNuevoGrupoTextField() {
		if (addNuevoGrupoTextField == null) {
			addNuevoGrupoTextField = new JTextField();
		}
		return addNuevoGrupoTextField;
	}

	private JButton getAddNuevoGrupoButton() {
		if (addNuevoGrupoButton == null) {
			addNuevoGrupoButton = new JButton();
			addNuevoGrupoButton.setText("+");
			addNuevoGrupoButton.setAction(getAddNuevoGrupoAction());
		}
		return addNuevoGrupoButton;
	}

	private JLabel getAddNuevoGrupoLabel() {
		if (addNuevoGrupoLabel == null) {
			addNuevoGrupoLabel = new JLabel();
			addNuevoGrupoLabel.setText(getWord("add"));
		}
		return addNuevoGrupoLabel;
	}

	private JButton getCancelAddUsuarioGrupoButton() {
		if (cancelAddUsuarioGrupoButton == null) {
			cancelAddUsuarioGrupoButton = new JButton();
			cancelAddUsuarioGrupoButton.setText(getWord("cancelar"));
			cancelAddUsuarioGrupoButton
					.setAction(getCancelAddUsuarioGrupoAction());
		}
		return cancelAddUsuarioGrupoButton;
	}

	private JButton getOkAddUsuarioGrupoButton() {
		if (okAddUsuarioGrupoButton == null) {
			okAddUsuarioGrupoButton = new JButton();
			okAddUsuarioGrupoButton.setText(getWord("ok"));
			okAddUsuarioGrupoButton.setAction(getOkAddUsuarioGrupoAction());
		}
		return okAddUsuarioGrupoButton;
	}

	private AbstractAction getAddUsuarioGrupoAction() {
		if (addUsuarioGrupoAction == null) {
			addUsuarioGrupoAction = new AbstractAction(getWord("add_grupo"),
					null) {
				public void actionPerformed(ActionEvent evt) {
					int column = tablaMensajes.getSelectedColumn();
					if (column == 1) {
						cargarLista(
								((DefaultListModel) getGruposDisponiblesList()
										.getModel()), getMain().getGrupos(),
								mensajeSeleccionado.getEmisor().getGrupos());
						cargarLista(((DefaultListModel) getGruposActualesList()
								.getModel()), mensajeSeleccionado.getEmisor()
								.getGrupos());
					} else {
						cargarLista(
								((DefaultListModel) getGruposDisponiblesList()
										.getModel()), getMain().getGrupos(),
								mensajeSeleccionado.getReceptor().getGrupos());
						cargarLista(((DefaultListModel) getGruposActualesList()
								.getModel()), mensajeSeleccionado.getReceptor()
								.getGrupos());
					}
					abrirVentana(getAddUsuarioGrupoDialog());
				}
			};
		}
		return addUsuarioGrupoAction;
	}

	private JDialog getBuscarMensajesSimilaresDialog() {
		if (buscarMensajesSimilaresDialog == null) {
			buscarMensajesSimilaresDialog = new JDialog(this);
			GroupLayout buscarMensajesSimilaresDialogLayout = new GroupLayout(
					(JComponent) buscarMensajesSimilaresDialog.getContentPane());
			buscarMensajesSimilaresDialog.getContentPane().setLayout(
					buscarMensajesSimilaresDialogLayout);
			buscarMensajesSimilaresDialog
					.setTitle(getWord("mostrar_mensajes_similares"));
			buscarMensajesSimilaresDialogLayout
					.setHorizontalGroup(buscarMensajesSimilaresDialogLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(buscarMensajesSimilaresDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											buscarMensajesSimilaresDialogLayout
													.createSequentialGroup()
													.add(getSimilitudBuscarMensajesSimilaresLabel(),
															GroupLayout.PREFERRED_SIZE,
															66,
															GroupLayout.PREFERRED_SIZE)
													.add(8))
									.add(GroupLayout.LEADING,
											getAlgoritmoBuscarMensajesSimilaresLabel(),
											GroupLayout.PREFERRED_SIZE, 74,
											GroupLayout.PREFERRED_SIZE))
							.add(18)
							.add(buscarMensajesSimilaresDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											buscarMensajesSimilaresDialogLayout
													.createSequentialGroup()
													.add(getSimilitudBuscarMensajesSimilaresSpinner(),
															GroupLayout.PREFERRED_SIZE,
															56,
															GroupLayout.PREFERRED_SIZE)
													.add(getOkBuscarMensajesSimilaresButton(),
															GroupLayout.PREFERRED_SIZE,
															112,
															GroupLayout.PREFERRED_SIZE)
													.add(6))
									.add(GroupLayout.LEADING,
											getAlgoritmoBuscarMensajesSimilaresComboBox(),
											GroupLayout.PREFERRED_SIZE, 174,
											GroupLayout.PREFERRED_SIZE))
							.add(buscarMensajesSimilaresDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getCancelBuscarMensajesSimilaresButton(),
											0, 112, Short.MAX_VALUE)
									.add(GroupLayout.LEADING,
											buscarMensajesSimilaresDialogLayout
													.createSequentialGroup()
													.add(0, 15, Short.MAX_VALUE)
													.add(getAyudaBuscarMensajesSimilaresButton(),
															GroupLayout.PREFERRED_SIZE,
															97,
															GroupLayout.PREFERRED_SIZE)))
							.addContainerGap());
			buscarMensajesSimilaresDialogLayout.linkSize(new Component[] {
					getOkBuscarMensajesSimilaresButton(),
					getCancelBuscarMensajesSimilaresButton() },
					GroupLayout.HORIZONTAL);
			buscarMensajesSimilaresDialogLayout
					.setVerticalGroup(buscarMensajesSimilaresDialogLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(buscarMensajesSimilaresDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getAyudaBuscarMensajesSimilaresButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getAlgoritmoBuscarMensajesSimilaresComboBox(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getAlgoritmoBuscarMensajesSimilaresLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(buscarMensajesSimilaresDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getSimilitudBuscarMensajesSimilaresSpinner(),
											GroupLayout.PREFERRED_SIZE, 22,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getSimilitudBuscarMensajesSimilaresLabel(),
											GroupLayout.PREFERRED_SIZE, 13,
											GroupLayout.PREFERRED_SIZE))
							.add(0, 17, Short.MAX_VALUE)
							.add(buscarMensajesSimilaresDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getOkBuscarMensajesSimilaresButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getCancelBuscarMensajesSimilaresButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addContainerGap());
			buscarMensajesSimilaresDialogLayout.linkSize(new Component[] {
					getOkBuscarMensajesSimilaresButton(),
					getCancelBuscarMensajesSimilaresButton() },
					GroupLayout.VERTICAL);
		}
		return buscarMensajesSimilaresDialog;
	}

	private JLabel getAlgoritmoBuscarMensajesSimilaresLabel() {
		if (algoritmoBuscarMensajesSimilaresLabel == null) {
			algoritmoBuscarMensajesSimilaresLabel = new JLabel();
			algoritmoBuscarMensajesSimilaresLabel.setText(getWord("algoritmo"));
		}
		return algoritmoBuscarMensajesSimilaresLabel;
	}

	private JComboBox getAlgoritmoBuscarMensajesSimilaresComboBox() {
		if (algoritmoBuscarMensajesSimilaresComboBox == null) {
			// ComboBoxModel algoritmoBuscarMensajesSimilaresComboBoxModel = new
			// DefaultComboBoxModel(
			// new String[] { getWord("simhashing"),
			// getWord("clustering_shingling"),
			// getWord("busqueda_informacion_preexistente") });
			ComboBoxModel algoritmoBuscarMensajesSimilaresComboBoxModel = new DefaultComboBoxModel(
					new String[] { getWord("simhashing") });

			algoritmoBuscarMensajesSimilaresComboBox = new JComboBox();
			algoritmoBuscarMensajesSimilaresComboBox
					.setModel(algoritmoBuscarMensajesSimilaresComboBoxModel);
			algoritmoBuscarMensajesSimilaresComboBox
					.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (algoritmoBuscarMensajesSimilaresComboBox
									.getSelectedIndex() == 0) {
								getSimilitudBuscarMensajesSimilaresSpinner()
										.setEnabled(false);
							} else {
								getSimilitudBuscarMensajesSimilaresSpinner()
										.setEnabled(true);
							}
						}
					});
		}
		return algoritmoBuscarMensajesSimilaresComboBox;
	}

	private JLabel getSimilitudBuscarMensajesSimilaresLabel() {
		if (similitudBuscarMensajesSimilaresLabel == null) {
			similitudBuscarMensajesSimilaresLabel = new JLabel();
			similitudBuscarMensajesSimilaresLabel.setText(getWord("similitud"));
		}
		return similitudBuscarMensajesSimilaresLabel;
	}

	private JSpinner getSimilitudBuscarMensajesSimilaresSpinner() {
		if (similitudBuscarMensajesSimilaresSpinner == null) {
			SpinnerNumberModel similitudBuscarMensajesSimilaresSpinnerModel = new SpinnerNumberModel(
					1, 1, 100, 1);
			similitudBuscarMensajesSimilaresSpinner = new JSpinner();
			similitudBuscarMensajesSimilaresSpinner
					.setModel(similitudBuscarMensajesSimilaresSpinnerModel);
			similitudBuscarMensajesSimilaresSpinner.setEnabled(false);
			getSimilitudBuscarMensajesSimilaresSpinner().getEditor()
					.setEnabled(false);
		}
		return similitudBuscarMensajesSimilaresSpinner;
	}

	private JButton getAyudaBuscarMensajesSimilaresButton() {
		if (ayudaBuscarMensajesSimilaresButton == null) {
			ayudaBuscarMensajesSimilaresButton = new JButton();
			ayudaBuscarMensajesSimilaresButton.setText(getWord("ayuda"));
			ayudaBuscarMensajesSimilaresButton
					.setAction(getAyudaBuscarMensajesSimilaresAction());
		}
		return ayudaBuscarMensajesSimilaresButton;
	}

	private AbstractAction getAyudaBuscarMensajesSimilaresAction() {
		if (ayudaBuscarMensajesSimilaresAction == null) {
			ayudaBuscarMensajesSimilaresAction = new AbstractAction(
					getWord("ayuda"), null) {
				public void actionPerformed(ActionEvent evt) {
					cargarAyudaAlgoritmo(getAlgoritmoBuscarMensajesSimilaresComboBox()
							.getSelectedIndex());
				}
			};
		}
		return ayudaBuscarMensajesSimilaresAction;
	}

	protected void cargarAyudaAlgoritmo(int option) {
		String algoritmo = null;
		switch (option) {
		case 0:
			algoritmo = "simhashing";
			break;
		}
		if (algoritmo != null) {
			getNombreAlgoritmoLabel().setText(getWord(algoritmo));
			getDescripcionAlgoritmoTextArea().setText(
					getWord(algoritmo + "_descripcion"));
			abrirVentana(getPreviewAlgoritmoDialog());
		}
	}

	private JButton getCancelBuscarMensajesSimilaresButton() {
		if (cancelBuscarMensajesSimilaresButton == null) {
			cancelBuscarMensajesSimilaresButton = new JButton();
			cancelBuscarMensajesSimilaresButton.setText(getWord("cancelar"));
			cancelBuscarMensajesSimilaresButton
					.setAction(getCancelBuscarMensajesSimilaresAction());
		}
		return cancelBuscarMensajesSimilaresButton;
	}

	private JButton getOkBuscarMensajesSimilaresButton() {
		if (okBuscarMensajesSimilaresButton == null) {
			okBuscarMensajesSimilaresButton = new JButton();
			okBuscarMensajesSimilaresButton.setText(getWord("ok"));
			okBuscarMensajesSimilaresButton
					.setAction(getBuscarSimilaresAction());
		}
		return okBuscarMensajesSimilaresButton;
	}

	private AbstractAction getBuscarMensajesSimilaresAction() {
		if (buscarMensajesSimilaresAction == null) {
			buscarMensajesSimilaresAction = new AbstractAction(
					getWord("mostrar_mensajes_similares"), null) {
				public void actionPerformed(ActionEvent evt) {
					getBuscarMensajesSimilaresDialog().setTitle(
							getWord("mostrar_mensajes_similares"));
					abrirVentana(getBuscarMensajesSimilaresDialog());
				}
			};
		}
		return buscarMensajesSimilaresAction;
	}

	private AbstractAction getIgnorarMensajesSimilaresAction() {
		if (ignorarMensajesSimilaresAction == null) {
			ignorarMensajesSimilaresAction = new AbstractAction(
					getWord("ignorar_mensajes_similares"), null) {
				public void actionPerformed(ActionEvent evt) {
					getBuscarMensajesSimilaresDialog().setTitle(
							getWord("ignorar_mensajes_similares"));
					abrirVentana(getBuscarMensajesSimilaresDialog());
				}
			};
		}
		return ignorarMensajesSimilaresAction;
	}

	private JDialog getEtiquetarMensajeDialog() {
		if (etiquetarMensajeDialog == null) {
			etiquetarMensajeDialog = new JDialog(this);
			GroupLayout etiquetarMensajeDialogLayout = new GroupLayout(
					(JComponent) etiquetarMensajeDialog.getContentPane());
			etiquetarMensajeDialog.getContentPane().setLayout(
					etiquetarMensajeDialogLayout);
			etiquetarMensajeDialog.setTitle(getWord("etiquetar_mensaje"));
			etiquetarMensajeDialog.setSize(701, 382);
			etiquetarMensajeDialogLayout
					.setHorizontalGroup(etiquetarMensajeDialogLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(etiquetarMensajeDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getJScrollPane5(),
											GroupLayout.PREFERRED_SIZE, 255,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											etiquetarMensajeDialogLayout
													.createSequentialGroup()
													.add(getAddEtiquetaEtiquetarMensajeLabel(),
															GroupLayout.PREFERRED_SIZE,
															87,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.RELATED)
													.add(getAddEtiquetaEtiquetarMensajeTextField(),
															GroupLayout.PREFERRED_SIZE,
															112,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.UNRELATED)
													.add(getAddEtiquetaEtiquetarMensajeButton(),
															GroupLayout.PREFERRED_SIZE,
															42,
															GroupLayout.PREFERRED_SIZE))
									.add(GroupLayout.LEADING,
											etiquetarMensajeDialogLayout
													.createSequentialGroup()
													.add(getBusquedaRapidaEtiquetarLabel(),
															GroupLayout.PREFERRED_SIZE,
															124,
															GroupLayout.PREFERRED_SIZE)
													.add(getBusquedaRapidaTextField(),
															GroupLayout.PREFERRED_SIZE,
															131,
															GroupLayout.PREFERRED_SIZE))
									.add(GroupLayout.LEADING,
											getEtiquetasDisponiblesEtiquetarMensajeLabel(),
											GroupLayout.PREFERRED_SIZE, 255,
											GroupLayout.PREFERRED_SIZE))
							.add(37)
							.add(etiquetarMensajeDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getSeleccionarEtiquetaButton(),
											GroupLayout.PREFERRED_SIZE, 97,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											getBorrarEtiquetaSeleccionadaButton(),
											GroupLayout.PREFERRED_SIZE, 97,
											GroupLayout.PREFERRED_SIZE))
							.add(31)
							.add(etiquetarMensajeDialogLayout
									.createParallelGroup()
									.add(etiquetarMensajeDialogLayout
											.createSequentialGroup()
											.add(getJScrollPane6(),
													GroupLayout.PREFERRED_SIZE,
													241,
													GroupLayout.PREFERRED_SIZE)
											.add(0, 0, Short.MAX_VALUE))
									.add(etiquetarMensajeDialogLayout
											.createSequentialGroup()
											.add(getEtiquetasActualesEtiquetarMensajeLabel(),
													GroupLayout.PREFERRED_SIZE,
													241,
													GroupLayout.PREFERRED_SIZE)
											.add(0, 0, Short.MAX_VALUE))
									.add(GroupLayout.LEADING,
											etiquetarMensajeDialogLayout
													.createSequentialGroup()
													.addPreferredGap(
															getJScrollPane6(),
															getOkEtiquetarMensajeButton(),
															LayoutStyle.INDENT)
													.add(getOkEtiquetarMensajeButton(),
															GroupLayout.PREFERRED_SIZE,
															97,
															GroupLayout.PREFERRED_SIZE)
													.add(0, 28, Short.MAX_VALUE)
													.add(getCancelEtiquetarMensajeButton(),
															GroupLayout.PREFERRED_SIZE,
															106,
															GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(24, 24));
			etiquetarMensajeDialogLayout
					.setVerticalGroup(etiquetarMensajeDialogLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(etiquetarMensajeDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getBusquedaRapidaTextField(),
											GroupLayout.PREFERRED_SIZE, 22,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getBusquedaRapidaEtiquetarLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.add(21)
							.add(etiquetarMensajeDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getEtiquetasDisponiblesEtiquetarMensajeLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getEtiquetasActualesEtiquetarMensajeLabel(),
											GroupLayout.PREFERRED_SIZE, 14,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(etiquetarMensajeDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getJScrollPane6(),
											GroupLayout.PREFERRED_SIZE, 199,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											getJScrollPane5(),
											GroupLayout.PREFERRED_SIZE, 196,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											etiquetarMensajeDialogLayout
													.createSequentialGroup()
													.add(19)
													.add(getSeleccionarEtiquetaButton(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.add(60)
													.add(getBorrarEtiquetaSeleccionadaButton(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.add(74)))
							.add(19)
							.add(etiquetarMensajeDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											etiquetarMensajeDialogLayout
													.createParallelGroup(
															GroupLayout.BASELINE)
													.add(GroupLayout.BASELINE,
															getAddEtiquetaEtiquetarMensajeTextField(),
															GroupLayout.PREFERRED_SIZE,
															22,
															GroupLayout.PREFERRED_SIZE)
													.add(GroupLayout.BASELINE,
															getAddEtiquetaEtiquetarMensajeLabel(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.add(GroupLayout.BASELINE,
															getAddEtiquetaEtiquetarMensajeButton(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE))
									.add(etiquetarMensajeDialogLayout
											.createSequentialGroup()
											.add(22)
											.add(etiquetarMensajeDialogLayout
													.createParallelGroup(
															GroupLayout.BASELINE)
													.add(GroupLayout.BASELINE,
															getOkEtiquetarMensajeButton(),
															GroupLayout.PREFERRED_SIZE,
															29,
															GroupLayout.PREFERRED_SIZE)
													.add(GroupLayout.BASELINE,
															getCancelEtiquetarMensajeButton(),
															GroupLayout.PREFERRED_SIZE,
															29,
															GroupLayout.PREFERRED_SIZE))))
							.addContainerGap());
			etiquetarMensajeDialogLayout.linkSize(new Component[] {
					getOkEtiquetarMensajeButton(),
					getCancelEtiquetarMensajeButton() }, GroupLayout.VERTICAL);
		}
		return etiquetarMensajeDialog;
	}

	private void cargarLista(DefaultListModel model, List<?> todas,
			List<?> restriccion) {
		if (restriccion == null) {
			cargarLista(model, todas);
		} else {
			model.clear();
			for (Object e : todas) {
				if (!restriccion.contains(e)) {
					model.addElement(e.toString());
				}
			}
		}
	}

	private void cargarLista(DefaultListModel model, List<?> todas) {
		model.clear();
		if (todas != null)
			for (Object e : todas) {
				model.addElement(e.toString());
			}
	}

	private JList getEtiquetasActualesList() {
		if (etiquetasActualesList == null) {
			ListModel etiquetasActualesListModel = new DefaultListModel();
			etiquetasActualesList = new JList();
			etiquetasActualesList.setModel(etiquetasActualesListModel);
			etiquetasActualesList.setSize(276, 210);
			etiquetasActualesList
					.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		}
		return etiquetasActualesList;
	}

	private JList getEtiquetasSeleccionadasList() {
		if (etiquetasSeleccionadasList == null) {
			ListModel etiquetasSeleccionadasListModel = new DefaultListModel();
			etiquetasSeleccionadasList = new JList();
			etiquetasSeleccionadasList
					.setModel(etiquetasSeleccionadasListModel);
			etiquetasSeleccionadasList.setSize(276, 210);
			etiquetasSeleccionadasList
					.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return etiquetasSeleccionadasList;
	}

	private JButton getSeleccionarEtiquetaButton() {
		if (seleccionarEtiquetaButton == null) {
			seleccionarEtiquetaButton = new JButton();
			seleccionarEtiquetaButton.setText(">");
			seleccionarEtiquetaButton.setAction(getSeleccionarEtiquetaAction());
		}
		return seleccionarEtiquetaButton;
	}

	private JButton getBorrarEtiquetaSeleccionadaButton() {
		if (borrarEtiquetaSeleccionadaButton == null) {
			borrarEtiquetaSeleccionadaButton = new JButton();
			borrarEtiquetaSeleccionadaButton.setText("<");
			borrarEtiquetaSeleccionadaButton
					.setAction(getBorrarEtiquetaAction());
		}
		return borrarEtiquetaSeleccionadaButton;
	}

	private JScrollPane getJScrollPane5() {
		if (jScrollPane5 == null) {
			jScrollPane5 = new JScrollPane();
			jScrollPane5.setViewportView(getEtiquetasActualesList());
		}
		return jScrollPane5;
	}

	private JScrollPane getJScrollPane6() {
		if (jScrollPane6 == null) {
			jScrollPane6 = new JScrollPane();
			jScrollPane6.setViewportView(getEtiquetasSeleccionadasList());
		}
		return jScrollPane6;
	}

	private JLabel getBusquedaRapidaEtiquetarLabel() {
		if (busquedaRapidaEtiquetarLabel == null) {
			busquedaRapidaEtiquetarLabel = new JLabel();
			busquedaRapidaEtiquetarLabel.setText(getWord("busqueda_rapida"));
		}
		return busquedaRapidaEtiquetarLabel;
	}

	private void actualizarListEtiquetas(DefaultListModel listModel,
			DefaultListModel listModelRestriccion, String text) {
		List<String> etiquetas = obtenerEtiquetasActuales(listModelRestriccion);
		listModel.clear();
		for (String s : etiquetas) {
			if (s.startsWith(text)) {
				listModel.addElement(s);
			}
		}
	}

	private List<String> obtenerEtiquetasActuales(
			DefaultListModel listModelRestriccion) {
		List<String> etiquetas = new LinkedList<String>();
		List<String> etiquetasRestriccion = new LinkedList<String>();
		for (int i = 0; i < listModelRestriccion.size(); i++) {
			etiquetasRestriccion.add(listModelRestriccion.get(i).toString());
		}
		for (Etiqueta e : getMain().getEtiquetas()) {
			if (!etiquetasRestriccion.contains(e.toString()))
				etiquetas.add(e.toString());
		}
		return etiquetas;
	}

	private JTextField getBusquedaRapidaTextField() {
		if (busquedaRapidaTextField == null) {
			busquedaRapidaTextField = new JTextField();
			busquedaRapidaTextField.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					actualizarListEtiquetas(
							(DefaultListModel) getEtiquetasActualesList()
									.getModel(),
							(DefaultListModel) getEtiquetasSeleccionadasList()
									.getModel(), busquedaRapidaTextField
									.getText());
				}
			});
		}
		return busquedaRapidaTextField;
	}

	private JLabel getAddEtiquetaEtiquetarMensajeLabel() {
		if (addEtiquetaEtiquetarMensajeLabel == null) {
			addEtiquetaEtiquetarMensajeLabel = new JLabel();
			addEtiquetaEtiquetarMensajeLabel.setText(getWord("add_etiqueta"));
		}
		return addEtiquetaEtiquetarMensajeLabel;
	}

	private JTextField getAddEtiquetaEtiquetarMensajeTextField() {
		if (addEtiquetaEtiquetarMensajeTextField == null) {
			addEtiquetaEtiquetarMensajeTextField = new JTextField();
			addEtiquetaEtiquetarMensajeTextField
					.addKeyListener(new KeyAdapter() {
						@Override
						public void keyReleased(KeyEvent e) {
							if (addEtiquetaEtiquetarMensajeTextField.getText()
									.equals("")) {
								getAddEtiquetaEtiquetarMensajeButton()
										.setEnabled(false);
							} else {
								getAddEtiquetaEtiquetarMensajeButton()
										.setEnabled(true);
							}
						}
					});
		}
		return addEtiquetaEtiquetarMensajeTextField;
	}

	private JButton getAddEtiquetaEtiquetarMensajeButton() {
		if (addEtiquetaEtiquetarMensajeButton == null) {
			addEtiquetaEtiquetarMensajeButton = new JButton();
			addEtiquetaEtiquetarMensajeButton.setText("+");
			addEtiquetaEtiquetarMensajeButton
					.setAction(getAddEtiquetaSueltaAction());
		}
		return addEtiquetaEtiquetarMensajeButton;
	}

	private JButton getCancelEtiquetarMensajeButton() {
		if (cancelEtiquetarMensajeButton == null) {
			cancelEtiquetarMensajeButton = new JButton();
			cancelEtiquetarMensajeButton.setText(getWord("cancelar"));
			cancelEtiquetarMensajeButton
					.setAction(getCerrarEtiquetarMensajeAction());
		}
		return cancelEtiquetarMensajeButton;
	}

	private JButton getOkEtiquetarMensajeButton() {
		if (okEtiquetarMensajeButton == null) {
			okEtiquetarMensajeButton = new JButton();
			okEtiquetarMensajeButton.setText(getWord("ok"));
			okEtiquetarMensajeButton.setAction(getOkEtiquetarMensajeAction());
		}
		return okEtiquetarMensajeButton;
	}

	private void abrirVentana(JDialog dialog) {
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.setResizable(false);
		dialog.pack();
		// dialog.setLocationRelativeTo(null);
		dialog.setLocationRelativeTo(this);
		dialog.setVisible(true);
	}

	private void abrirVentanaProgreso() {
		abrirVentana(getCargaProgresoDialog());
	}

	private AbstractAction getEtiquetarMensajeAction() {
		if (etiquetarMensajeAction == null) {
			etiquetarMensajeAction = new AbstractAction(
					getWord("etiquetar_mensaje"), null) {
				public void actionPerformed(ActionEvent evt) {
					etiquetarMensaje();
				}
			};
		}
		return etiquetarMensajeAction;
	}

	private void etiquetarMensaje() {
		cargarLista(((DefaultListModel) getEtiquetasActualesList().getModel()),
				getMain().getEtiquetas(), mensajeSeleccionado.getEtiquetas());
		cargarLista(((DefaultListModel) getEtiquetasSeleccionadasList()
				.getModel()), mensajeSeleccionado.getEtiquetas());
		etiquetasProvisionales = new LinkedList<Etiqueta>();
		etiquetasProvisionales.addAll(mensajeSeleccionado.getEtiquetas());
		getAddEtiquetaEtiquetarMensajeButton().setEnabled(false);

		abrirVentana(getEtiquetarMensajeDialog());
	}

	private Mensaje getMensaje(int selectedRow) {
		return this.mostrados.get(selectedRow);
	}

	private AbstractAction getAddTagsMensajeAction() {
		if (addTagsMensajeAction == null) {
			addTagsMensajeAction = new AbstractAction(getWord("add_etiqueta"),
					null) {
				public void actionPerformed(ActionEvent evt) {
					etiquetarMensaje();
				}
			};
		}
		return addTagsMensajeAction;
	}

	private AbstractAction getBuscarMensajesMismasTagsAction() {
		if (buscarMensajesMismasTagsAction == null) {
			buscarMensajesMismasTagsAction = new AbstractAction(
					getWord("buscar_mensajes_mismas_tags"), null) {
				public void actionPerformed(ActionEvent evt) {
					operacion = new MostrarMensajesMismasTagsOperacion(
							getMain(), mensajeSeleccionado);
					ejecutarOperacion();
				}
			};
		}
		return buscarMensajesMismasTagsAction;
	}

	private AbstractAction getIgnorarMensajesMismasTagsAction() {
		if (ignorarMensajesMismasTagsAction == null) {
			ignorarMensajesMismasTagsAction = new AbstractAction(
					getWord("ignorar_mensajes_mismas_tags"), null) {

				public void actionPerformed(ActionEvent evt) {
					// getBuscarMensajesMismasTagsDialog().setTitle(getWord("ignorar_mensajes_mismas_tags"));
					// abrirVentana(getBuscarMensajesMismasTagsDialog());
					operacion = new IgnorarMensajesMismasTagsOperacion(
							getMain(), mensajeSeleccionado);
					ejecutarOperacion();
				}
			};
		}
		return ignorarMensajesMismasTagsAction;
	}

	private AbstractAction getOcultarMensajesMismasTagsAction() {
		if (ocultarMensajesMismasTagsAction == null) {
			ocultarMensajesMismasTagsAction = new AbstractAction(
					getWord("ocultar_mensajes_mismas_tags"), null) {

				public void actionPerformed(ActionEvent evt) {
					operacion = new OcultarMensajesMismasTagsOperacion(
							getMain(), mensajeSeleccionado);
					ejecutarOperacion();

				}
			};
		}
		return ocultarMensajesMismasTagsAction;
	}

	private JDialog getAddGrupoUsuariosMismasTagsDialog() {
		if (addGrupoUsuariosMismasTagsDialog == null) {
			addGrupoUsuariosMismasTagsDialog = new JDialog(this);
			GroupLayout addGrupoUsuariosMismasTagsLayout = new GroupLayout(
					(JComponent) addGrupoUsuariosMismasTagsDialog
							.getContentPane());
			addGrupoUsuariosMismasTagsDialog.getContentPane().setLayout(
					addGrupoUsuariosMismasTagsLayout);
			addGrupoUsuariosMismasTagsDialog
					.setPreferredSize(new java.awt.Dimension(569, 413));
			addGrupoUsuariosMismasTagsDialog
					.setTitle(getWord("add_grupo_usuarios_mismas_tags"));
			addGrupoUsuariosMismasTagsDialog.setSize(569, 413);
			addGrupoUsuariosMismasTagsLayout
					.setHorizontalGroup(addGrupoUsuariosMismasTagsLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(addGrupoUsuariosMismasTagsLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											addGrupoUsuariosMismasTagsLayout
													.createSequentialGroup()
													.add(getPrimerPasoAddGrupoUsuariosMismasTagsPanel(),
															0, 533,
															Short.MAX_VALUE)
													.add(10))
									.add(GroupLayout.LEADING,
											addGrupoUsuariosMismasTagsLayout
													.createSequentialGroup()
													.add(0, 203,
															Short.MAX_VALUE)
													.add(getBotonesAddGrupoUsuariosMismasTagsPanel(),
															GroupLayout.PREFERRED_SIZE,
															340,
															GroupLayout.PREFERRED_SIZE))));
			addGrupoUsuariosMismasTagsLayout
					.setVerticalGroup(addGrupoUsuariosMismasTagsLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(getPrimerPasoAddGrupoUsuariosMismasTagsPanel(),
									GroupLayout.PREFERRED_SIZE, 309,
									GroupLayout.PREFERRED_SIZE)
							.add(0, 15, Short.MAX_VALUE)
							.add(getBotonesAddGrupoUsuariosMismasTagsPanel(),
									GroupLayout.PREFERRED_SIZE, 29,
									GroupLayout.PREFERRED_SIZE)
							.addContainerGap());
		}
		return addGrupoUsuariosMismasTagsDialog;
	}

	private JButton getCancelAddGrupoUsuariosMismasTagsButon() {
		if (cancelAddGrupoUsuariosMismasTagsButon == null) {
			cancelAddGrupoUsuariosMismasTagsButon = new JButton();
			cancelAddGrupoUsuariosMismasTagsButon.setText(getWord("cancelar"));
			cancelAddGrupoUsuariosMismasTagsButon
					.setAction(getCancelAddGrupoUsuariosMismasTagsAction());
		}
		return cancelAddGrupoUsuariosMismasTagsButon;
	}

	private JButton getOkAddGrupoUsuariosMismasTagsButton() {
		if (okAddGrupoUsuariosMismasTagsButton == null) {
			okAddGrupoUsuariosMismasTagsButton = new JButton();
			okAddGrupoUsuariosMismasTagsButton.setText(getWord("ok"));
			okAddGrupoUsuariosMismasTagsButton.setEnabled(false);
			okAddGrupoUsuariosMismasTagsButton
					.setAction(getOkAddGrupoUsuariosMismasTagsAction());
		}
		return okAddGrupoUsuariosMismasTagsButton;
	}

	private AbstractAction getAddGrupoUsuariosMismasTagsAction() {
		if (addGrupoUsuariosMismasTagsAction == null) {
			addGrupoUsuariosMismasTagsAction = new AbstractAction(
					getWord("add_grupo_usuarios_mismas_tags"), null) {
				public void actionPerformed(ActionEvent evt) {
					cargarLista(
							(DefaultListModel) getGruposDisponiblesAddGrupoUsuariosMismasTagsList()
									.getModel(), getMain().getGrupos(),
							mensajeSeleccionado.getReceptor().getGrupos());
					cargarLista(
							(DefaultListModel) getGruposActualesAddGrupoUsuariosMismasTagsList()
									.getModel(), mensajeSeleccionado
									.getReceptor().getGrupos());
					getAddNuevoGrupoMismasTagsButton().setEnabled(false);
					abrirVentana(getAddGrupoUsuariosMismasTagsDialog());
				}
			};
		}
		return addGrupoUsuariosMismasTagsAction;
	}

	private AbstractAction getBusquedaTiempoAction() {
		if (busquedaTiempoAction == null) {
			busquedaTiempoAction = new AbstractAction("", null) {
				public void actionPerformed(ActionEvent evt) {
					int valor = getBusquedaComboBox().getSelectedIndex();
					if (valor == 0 || valor == 1 || valor == 3) {
						getTipoBusquedaComboBox().setModel(
								new DefaultComboBoxModel(new String[] {
										getWord("contiene"),
										getWord("no_contiene"),
										getWord("empieza_por"),
										getWord("termina_por") }));
					}
					if (valor == 4 || valor == 5) {
						getTipoBusquedaComboBox().setModel(
								new DefaultComboBoxModel(new String[] {
										getWord("contiene"),
										getWord("no_contiene") }));
					}
					modificarBusquedaDialog(estadoAnterior,
							getBusquedaComboBox().getSelectedIndex());
					estadoAnterior = getBusquedaComboBox().getSelectedIndex();
				}

				private void modificarBusquedaDialog(int estadoAnterior,
						int estadoActual) {
					if (estadoAnterior != 2 && estadoAnterior >= 0
							&& estadoAnterior < 6 && estadoActual == 2) {
						cambiarCalendarios();
					}
					if (estadoAnterior == 2 && estadoActual != 2
							&& estadoActual >= 0 && estadoActual < 6) {
						cambiarTextField();
					}
					if (getBusquedaTextField().getText().equals("")
							&& estadoActual != 2) {
						getAceptarBusquedaButton().setEnabled(false);
					}
					if (estadoActual == 2) {
						getAceptarBusquedaButton().setEnabled(true);

					}
				}

				private void cambiarCalendarios() {
					getBusquedaTextFieldPanel().setVisible(false);

					getHastaPanel().setVisible(true);
					getDesdePanel().setVisible(true);

				}

				private void cambiarTextField() {
					getHastaPanel().setVisible(false);
					getDesdePanel().setVisible(false);

					getBusquedaTextFieldPanel().setVisible(true);
				}

			};
		}
		return busquedaTiempoAction;
	}

	private JLabel getBusquedaLabel() {
		if (busquedaLabel == null) {
			busquedaLabel = new JLabel();
			busquedaLabel.setText(getWord("texto_buscar"));
			busquedaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return busquedaLabel;
	}

	private JDateChooser getHastaDateChooser() {
		if (hastaDateChooser == null) {
			hastaDateChooser = new JDateChooser();
			hastaDateChooser.setDate(Calendar.getInstance().getTime());

		}
		return hastaDateChooser;
	}

	private JSpinner getHorasHastaSpinner() {
		if (horasHastaSpinner == null) {
			SpinnerNumberModel horasHastaSpinnerModel = new SpinnerNumberModel(
					23, 0, 23, 1);
			horasHastaSpinner = new JSpinner();
			horasHastaSpinner.setModel(horasHastaSpinnerModel);
		}
		return horasHastaSpinner;
	}

	private JSpinner getMinutosHastaSpinner() {
		if (minutosHastaSpinner == null) {
			SpinnerNumberModel minutosHastaSpinnerModel = new SpinnerNumberModel(
					59, 0, 59, 1);
			minutosHastaSpinner = new JSpinner();
			minutosHastaSpinner.setModel(minutosHastaSpinnerModel);
		}
		return minutosHastaSpinner;
	}

	private JPanel getHastaPanel() {
		if (hastaPanel == null) {
			hastaPanel = new JPanel();
			GroupLayout jPanel1Layout11 = new GroupLayout(
					(JComponent) hastaPanel);
			hastaPanel.setLayout(jPanel1Layout11);
			hastaPanel.setName(getWord("hasta"));
			hastaPanel.setBorder(BorderFactory.createTitledBorder(
					new LineBorder(new java.awt.Color(0, 0, 0), 1, false),
					"Hasta", TitledBorder.LEADING, TitledBorder.TOP));
			hastaPanel.setEnabled(false);
			hastaPanel.setBounds(240, 66, 222, 114);
			hastaPanel.setVisible(false);
			jPanel1Layout11
					.setHorizontalGroup(jPanel1Layout11
							.createSequentialGroup()
							.addContainerGap()
							.add(jPanel1Layout11
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getHastaDateChooser(), 0, 190,
											Short.MAX_VALUE)
									.add(jPanel1Layout11
											.createSequentialGroup()
											.addPreferredGap(
													getHastaDateChooser(),
													getJLabel3(),
													LayoutStyle.INDENT)
											.add(jPanel1Layout11
													.createParallelGroup()
													.add(GroupLayout.LEADING,
															getJLabel3(),
															GroupLayout.PREFERRED_SIZE,
															48,
															GroupLayout.PREFERRED_SIZE)
													.add(GroupLayout.LEADING,
															jPanel1Layout11
																	.createSequentialGroup()
																	.addPreferredGap(
																			getJLabel3(),
																			getHorasHastaSpinner(),
																			LayoutStyle.INDENT)
																	.add(getHorasHastaSpinner(),
																			GroupLayout.PREFERRED_SIZE,
																			GroupLayout.PREFERRED_SIZE,
																			GroupLayout.PREFERRED_SIZE)))
											.add(jPanel1Layout11
													.createParallelGroup()
													.add(GroupLayout.LEADING,
															getJLabel2(),
															GroupLayout.PREFERRED_SIZE,
															53,
															GroupLayout.PREFERRED_SIZE)
													.add(GroupLayout.LEADING,
															jPanel1Layout11
																	.createSequentialGroup()
																	.addPreferredGap(
																			getJLabel2(),
																			getMinutosHastaSpinner(),
																			LayoutStyle.INDENT)
																	.add(getMinutosHastaSpinner(),
																			GroupLayout.PREFERRED_SIZE,
																			GroupLayout.PREFERRED_SIZE,
																			GroupLayout.PREFERRED_SIZE)
																	.addPreferredGap(
																			LayoutStyle.RELATED)))
											.add(jPanel1Layout11
													.createParallelGroup()
													.add(GroupLayout.LEADING,
															getJLabel1(),
															GroupLayout.PREFERRED_SIZE,
															69,
															GroupLayout.PREFERRED_SIZE)
													.add(GroupLayout.LEADING,
															jPanel1Layout11
																	.createSequentialGroup()
																	.add(0,
																			0,
																			Short.MAX_VALUE)
																	.add(getSegundosHastaSpinner(),
																			GroupLayout.PREFERRED_SIZE,
																			GroupLayout.PREFERRED_SIZE,
																			GroupLayout.PREFERRED_SIZE)
																	.add(0,
																			10,
																			GroupLayout.PREFERRED_SIZE)))
											.add(10))));
			jPanel1Layout11.setVerticalGroup(jPanel1Layout11
					.createSequentialGroup()
					.add(getHastaDateChooser(), GroupLayout.PREFERRED_SIZE, 28,
							GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.RELATED)
					.add(jPanel1Layout11
							.createParallelGroup(GroupLayout.BASELINE)
							.add(GroupLayout.BASELINE, getJLabel1(),
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.add(GroupLayout.BASELINE, getJLabel2(),
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.add(GroupLayout.BASELINE, getJLabel3(),
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.RELATED)
					.add(jPanel1Layout11
							.createParallelGroup(GroupLayout.BASELINE)
							.add(GroupLayout.BASELINE, getHorasHastaSpinner(),
									0, 25, Short.MAX_VALUE)
							.add(GroupLayout.BASELINE,
									getSegundosHastaSpinner(), 0, 23,
									Short.MAX_VALUE)
							.add(GroupLayout.BASELINE,
									getMinutosHastaSpinner(), 0, 23,
									Short.MAX_VALUE)).addContainerGap());
		}
		return hastaPanel;
	}

	private JSpinner getSegundosHastaSpinner() {
		if (segundosHastaSpinner == null) {
			SpinnerNumberModel jSpinner1Model = new SpinnerNumberModel(59, 0,
					59, 1);
			segundosHastaSpinner = new JSpinner();
			segundosHastaSpinner.setModel(jSpinner1Model);
		}
		return segundosHastaSpinner;
	}

	private JPanel getDesdePanel() {
		if (desdePanel == null) {
			desdePanel = new JPanel();
			GroupLayout jPanel1Layout1 = new GroupLayout(
					(JComponent) desdePanel);
			desdePanel.setLayout(jPanel1Layout1);
			desdePanel.setName(getWord("desde_panel"));
			desdePanel.setBorder(BorderFactory.createTitledBorder(
					new LineBorder(new java.awt.Color(0, 0, 0), 1, false),
					"Desde", TitledBorder.LEADING, TitledBorder.TOP));
			desdePanel.setEnabled(false);
			desdePanel.setBounds(10, 66, 220, 114);
			desdePanel.setVisible(false);
			desdePanel.setComponentPopupMenu(getFromPopupMenu());
			jPanel1Layout1
					.setHorizontalGroup(jPanel1Layout1
							.createSequentialGroup()
							.addContainerGap()
							.add(jPanel1Layout1
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getDesdeDateChooser(), 0, 191,
											Short.MAX_VALUE)
									.add(jPanel1Layout1
											.createSequentialGroup()
											.add(jPanel1Layout1
													.createParallelGroup()
													.add(GroupLayout.LEADING,
															jPanel1Layout1
																	.createSequentialGroup()
																	.addPreferredGap(
																			getHorasDesdeLabel(),
																			getHorasDesdeSpinner(),
																			LayoutStyle.INDENT)
																	.add(getHorasDesdeSpinner(),
																			GroupLayout.PREFERRED_SIZE,
																			GroupLayout.PREFERRED_SIZE,
																			GroupLayout.PREFERRED_SIZE))
													.add(GroupLayout.LEADING,
															getHorasDesdeLabel(),
															GroupLayout.PREFERRED_SIZE,
															48,
															GroupLayout.PREFERRED_SIZE))
											.add(14)
											.add(jPanel1Layout1
													.createParallelGroup()
													.add(GroupLayout.LEADING,
															jPanel1Layout1
																	.createSequentialGroup()
																	.add(0,
																			0,
																			Short.MAX_VALUE)
																	.add(getMinutosDesdeLabel(),
																			GroupLayout.PREFERRED_SIZE,
																			53,
																			GroupLayout.PREFERRED_SIZE)
																	.addPreferredGap(
																			LayoutStyle.RELATED,
																			0,
																			GroupLayout.PREFERRED_SIZE)
																	.add(getSecondsDesdeLabel(),
																			GroupLayout.PREFERRED_SIZE,
																			69,
																			GroupLayout.PREFERRED_SIZE))
													.add(GroupLayout.LEADING,
															jPanel1Layout1
																	.createSequentialGroup()
																	.addPreferredGap(
																			LayoutStyle.RELATED)
																	.add(jPanel1Layout1
																			.createParallelGroup()
																			.add(GroupLayout.LEADING,
																					jPanel1Layout1
																							.createSequentialGroup()
																							.add(0,
																									0,
																									Short.MAX_VALUE)
																							.add(getMinutosDesdeSpinner(),
																									GroupLayout.PREFERRED_SIZE,
																									GroupLayout.PREFERRED_SIZE,
																									GroupLayout.PREFERRED_SIZE)
																							.add(23))
																			.add(GroupLayout.LEADING,
																					jPanel1Layout1
																							.createSequentialGroup()
																							.add(22)
																							.add(getFromPopupMenu(),
																									GroupLayout.PREFERRED_SIZE,
																									40,
																									GroupLayout.PREFERRED_SIZE)
																							.add(0,
																									0,
																									Short.MAX_VALUE)))
																	.addPreferredGap(
																			LayoutStyle.UNRELATED,
																			1,
																			GroupLayout.PREFERRED_SIZE)
																	.add(getSegundosDesdeSpinner(),
																			GroupLayout.PREFERRED_SIZE,
																			GroupLayout.PREFERRED_SIZE,
																			GroupLayout.PREFERRED_SIZE)
																	.add(11))))));
			jPanel1Layout1.linkSize(new Component[] { getMinutosDesdeSpinner(),
					getHorasDesdeSpinner(), getSegundosDesdeSpinner() },
					GroupLayout.HORIZONTAL);
			jPanel1Layout1
					.setVerticalGroup(jPanel1Layout1
							.createSequentialGroup()
							.add(getDesdeDateChooser(),
									GroupLayout.PREFERRED_SIZE, 28,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.RELATED)
							.add(jPanel1Layout1
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											jPanel1Layout1
													.createParallelGroup(
															GroupLayout.BASELINE)
													.add(GroupLayout.BASELINE,
															getSecondsDesdeLabel(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.add(GroupLayout.BASELINE,
															getMinutosDesdeLabel(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.add(GroupLayout.BASELINE,
															getHorasDesdeLabel(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE))
									.add(GroupLayout.LEADING,
											jPanel1Layout1
													.createSequentialGroup()
													.addPreferredGap(
															LayoutStyle.RELATED)
													.add(getFromPopupMenu(),
															GroupLayout.PREFERRED_SIZE,
															10,
															GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(jPanel1Layout1
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getSegundosDesdeSpinner(), 0, 25,
											Short.MAX_VALUE)
									.add(GroupLayout.BASELINE,
											getMinutosDesdeSpinner(),
											GroupLayout.PREFERRED_SIZE, 25,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getHorasDesdeSpinner(),
											GroupLayout.PREFERRED_SIZE, 25,
											GroupLayout.PREFERRED_SIZE))
							.addContainerGap());
			jPanel1Layout1.linkSize(new Component[] { getMinutosDesdeSpinner(),
					getHorasDesdeSpinner(), getSegundosDesdeSpinner() },
					GroupLayout.VERTICAL);
		}
		return desdePanel;
	}

	private JSpinner getHorasDesdeSpinner() {
		if (horasDesdeSpinner == null) {
			SpinnerNumberModel jSpinner2Model = new SpinnerNumberModel(23, 0,
					23, 1);
			horasDesdeSpinner = new JSpinner();
			horasDesdeSpinner.setModel(jSpinner2Model);
			horasDesdeSpinner.setValue(23);
		}
		return horasDesdeSpinner;
	}

	private JSpinner getMinutosDesdeSpinner() {
		if (minutosDesdeSpinner == null) {
			SpinnerNumberModel jSpinner3Model = new SpinnerNumberModel(59, 0,
					59, 1);
			minutosDesdeSpinner = new JSpinner();
			minutosDesdeSpinner.setModel(jSpinner3Model);
		}
		return minutosDesdeSpinner;
	}

	private JSpinner getSegundosDesdeSpinner() {
		if (segundosDesdeSpinner == null) {
			SpinnerNumberModel jSpinner4Model = new SpinnerNumberModel(59, 0,
					59, 1);
			segundosDesdeSpinner = new JSpinner();
			segundosDesdeSpinner.setModel(jSpinner4Model);
		}
		return segundosDesdeSpinner;
	}

	private JDateChooser getDesdeDateChooser() {
		if (desdeDateChooser == null) {
			desdeDateChooser = new JDateChooser();
			desdeDateChooser.setDate(Calendar.getInstance().getTime());

		}
		return desdeDateChooser;
	}

	private JLabel getHorasDesdeLabel() {
		if (horasDesdeLabel == null) {
			horasDesdeLabel = new JLabel();
			horasDesdeLabel.setText(getWord("horas"));
			horasDesdeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return horasDesdeLabel;
	}

	private JLabel getMinutosDesdeLabel() {
		if (minutosDesdeLabel == null) {
			minutosDesdeLabel = new JLabel();
			minutosDesdeLabel.setText(getWord("minutos"));
			minutosDesdeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return minutosDesdeLabel;
	}

	private JLabel getSecondsDesdeLabel() {
		if (secondsDesdeLabel == null) {
			secondsDesdeLabel = new JLabel();
			secondsDesdeLabel.setText(getWord("segundos"));
			secondsDesdeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return secondsDesdeLabel;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText(getWord("segundos"));
			jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabel1;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText(getWord("minutos"));
			jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabel2;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText(getWord("horas"));
			jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabel3;
	}

	private JPanel getBusquedaTextFieldPanel() {
		if (busquedaTextFieldPanel == null) {
			busquedaTextFieldPanel = new JPanel();
			GroupLayout jPanel1Layout2 = new GroupLayout(
					(JComponent) busquedaTextFieldPanel);
			busquedaTextFieldPanel.setLayout(jPanel1Layout2);
			jPanel1Layout2
					.setHorizontalGroup(jPanel1Layout2
							.createSequentialGroup()
							.addContainerGap()
							.add(getTipoBusquedaComboBox(),
									GroupLayout.PREFERRED_SIZE, 143,
									GroupLayout.PREFERRED_SIZE)
							.add(60)
							.add(getBusquedaLabel(),
									GroupLayout.PREFERRED_SIZE, 79,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.UNRELATED)
							.add(getBusquedaTextField(),
									GroupLayout.PREFERRED_SIZE, 109,
									GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE,
									Short.MAX_VALUE));
			jPanel1Layout2.setVerticalGroup(jPanel1Layout2
					.createParallelGroup(GroupLayout.BASELINE)
					.add(GroupLayout.BASELINE, getBusquedaLabel(), 0, 31,
							Short.MAX_VALUE)
					.add(GroupLayout.BASELINE, getBusquedaTextField(), 0, 22,
							Short.MAX_VALUE)
					.add(GroupLayout.BASELINE, getTipoBusquedaComboBox(),
							GroupLayout.PREFERRED_SIZE, 23,
							GroupLayout.PREFERRED_SIZE));
		}
		return busquedaTextFieldPanel;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			GroupLayout jPanel1Layout3 = new GroupLayout((JComponent) jPanel1);
			jPanel1.setLayout(jPanel1Layout3);
			jPanel1Layout3
					.setHorizontalGroup(jPanel1Layout3
							.createSequentialGroup()
							.addContainerGap()
							.add(jPanel1Layout3
									.createParallelGroup()
									.add(jPanel1Layout3
											.createSequentialGroup()
											.add(jPanel1Layout3
													.createParallelGroup()
													.add(GroupLayout.LEADING,
															getDesdePanel(),
															GroupLayout.PREFERRED_SIZE,
															222,
															GroupLayout.PREFERRED_SIZE)
													.add(GroupLayout.LEADING,
															jPanel1Layout3
																	.createSequentialGroup()
																	.add(getBusquedaComboBox(),
																			GroupLayout.PREFERRED_SIZE,
																			143,
																			GroupLayout.PREFERRED_SIZE)
																	.add(79)))
											.addPreferredGap(
													LayoutStyle.RELATED)
											.add(jPanel1Layout3
													.createParallelGroup()
													.add(jPanel1Layout3
															.createSequentialGroup()
															.add(getHastaPanel(),
																	0,
																	222,
																	Short.MAX_VALUE)
															.addPreferredGap(
																	LayoutStyle.RELATED))
													.add(GroupLayout.LEADING,
															getJPanel2(), 0,
															222,
															Short.MAX_VALUE))
											.add(10))
									.add(GroupLayout.LEADING,
											getBusquedaTextFieldPanel(), 0,
											462, Short.MAX_VALUE)));
			jPanel1Layout3.linkSize(new Component[] { getDesdePanel(),
					getHastaPanel() }, GroupLayout.HORIZONTAL);
			jPanel1Layout3.setVerticalGroup(jPanel1Layout3
					.createSequentialGroup()
					.addContainerGap()
					.add(getBusquedaComboBox(), GroupLayout.PREFERRED_SIZE,
							GroupLayout.PREFERRED_SIZE,
							GroupLayout.PREFERRED_SIZE)
					.add(35)
					.add(jPanel1Layout3
							.createParallelGroup()
							.add(GroupLayout.LEADING, getHastaPanel(), 0, 114,
									Short.MAX_VALUE)
							.add(jPanel1Layout3
									.createSequentialGroup()
									.add(getDesdePanel(),
											GroupLayout.PREFERRED_SIZE, 114,
											GroupLayout.PREFERRED_SIZE)
									.add(0, 0, Short.MAX_VALUE))
							.add(GroupLayout.LEADING,
									jPanel1Layout3
											.createSequentialGroup()
											.add(getBusquedaTextFieldPanel(),
													GroupLayout.PREFERRED_SIZE,
													42,
													GroupLayout.PREFERRED_SIZE)
											.add(0, 72, Short.MAX_VALUE)))
					.add(18)
					.add(getJPanel2(), GroupLayout.PREFERRED_SIZE, 30,
							GroupLayout.PREFERRED_SIZE).add(6));
			jPanel1Layout3.linkSize(new Component[] { getDesdePanel(),
					getHastaPanel() }, GroupLayout.VERTICAL);
		}
		return jPanel1;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			GroupLayout jPanel2Layout = new GroupLayout((JComponent) jPanel2);
			jPanel2.setLayout(jPanel2Layout);
			jPanel2Layout.setHorizontalGroup(jPanel2Layout
					.createSequentialGroup()
					.add(getAceptarBusquedaButton(),
							GroupLayout.PREFERRED_SIZE, 103,
							GroupLayout.PREFERRED_SIZE)
					.add(0, 20, Short.MAX_VALUE)
					.add(getCancelarBusquedaButton(),
							GroupLayout.PREFERRED_SIZE, 103,
							GroupLayout.PREFERRED_SIZE));
			jPanel2Layout.linkSize(new Component[] {
					getAceptarBusquedaButton(), getCancelarBusquedaButton() },
					GroupLayout.HORIZONTAL);
			jPanel2Layout.setVerticalGroup(jPanel2Layout
					.createParallelGroup()
					.add(GroupLayout.LEADING,
							jPanel2Layout
									.createSequentialGroup()
									.add(getAceptarBusquedaButton(),
											GroupLayout.PREFERRED_SIZE, 30,
											GroupLayout.PREFERRED_SIZE)
									.add(0, 7, Short.MAX_VALUE))
					.add(GroupLayout.LEADING, getCancelarBusquedaButton(), 0,
							36, Short.MAX_VALUE));
		}
		return jPanel2;
	}

	private JPanel getPrimerPasoEtiquetadoMediantePatronPanel() {
		if (primerPasoEtiquetadoMediantePatronPanel == null) {
			primerPasoEtiquetadoMediantePatronPanel = new JPanel();
			GroupLayout jPanel3Layout = new GroupLayout(
					(JComponent) primerPasoEtiquetadoMediantePatronPanel);
			primerPasoEtiquetadoMediantePatronPanel.setLayout(jPanel3Layout);
			primerPasoEtiquetadoMediantePatronPanel.setSize(677, 318);
			jPanel3Layout
					.setVerticalGroup(jPanel3Layout
							.createSequentialGroup()
							.addContainerGap()
							.add(jPanel3Layout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getBusquedaRapidaEtMediantePatronTextField(),
											GroupLayout.PREFERRED_SIZE, 22,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getBusquedaRapidaEtMediantePatronLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.add(22)
							.add(jPanel3Layout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getPatronesDisponiblesLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getPatronesSeleccionadosLabel(),
											GroupLayout.PREFERRED_SIZE, 14,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(jPanel3Layout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getJScrollPane1(),
											GroupLayout.PREFERRED_SIZE, 219,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											getJScrollPane2(),
											GroupLayout.PREFERRED_SIZE, 219,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											jPanel3Layout
													.createSequentialGroup()
													.add(59)
													.add(getAddPatronActualButton(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.add(24)
													.add(getBorrarPatronActualButton(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.add(90)))
							.addPreferredGap(LayoutStyle.UNRELATED)
							.add(getAddPatronButton(),
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addContainerGap(24, 24));
			jPanel3Layout.linkSize(new Component[] { getJScrollPane1(),
					getJScrollPane2() }, GroupLayout.VERTICAL);
			jPanel3Layout
					.setHorizontalGroup(jPanel3Layout
							.createSequentialGroup()
							.addContainerGap(25, 25)
							.add(jPanel3Layout
									.createParallelGroup()
									.add(jPanel3Layout
											.createSequentialGroup()
											.add(jPanel3Layout
													.createParallelGroup()
													.add(GroupLayout.LEADING,
															getBusquedaRapidaEtMediantePatronLabel(),
															GroupLayout.PREFERRED_SIZE,
															118,
															GroupLayout.PREFERRED_SIZE)
													.add(GroupLayout.LEADING,
															jPanel3Layout
																	.createSequentialGroup()
																	.add(getAddPatronButton(),
																			GroupLayout.PREFERRED_SIZE,
																			102,
																			GroupLayout.PREFERRED_SIZE)
																	.add(16)))
											.add(getBusquedaRapidaEtMediantePatronTextField(),
													GroupLayout.PREFERRED_SIZE,
													107,
													GroupLayout.PREFERRED_SIZE)
											.add(10))
									.add(GroupLayout.LEADING,
											getJScrollPane1(),
											GroupLayout.PREFERRED_SIZE, 235,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											getPatronesDisponiblesLabel(),
											GroupLayout.PREFERRED_SIZE, 235,
											GroupLayout.PREFERRED_SIZE))
							.add(52)
							.add(jPanel3Layout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getAddPatronActualButton(),
											GroupLayout.PREFERRED_SIZE, 97,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											getBorrarPatronActualButton(),
											GroupLayout.PREFERRED_SIZE, 97,
											GroupLayout.PREFERRED_SIZE))
							.add(35)
							.add(jPanel3Layout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getJScrollPane2(),
											GroupLayout.PREFERRED_SIZE, 235,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											getPatronesSeleccionadosLabel(),
											GroupLayout.PREFERRED_SIZE, 235,
											GroupLayout.PREFERRED_SIZE))
							.addContainerGap(15, Short.MAX_VALUE));
			jPanel3Layout.linkSize(new Component[] { getJScrollPane1(),
					getJScrollPane2() }, GroupLayout.HORIZONTAL);
		}
		return primerPasoEtiquetadoMediantePatronPanel;
	}

	private JPanel getBotonesEtiquetadoMediantePatronPanel() {
		if (botonesEtiquetadoMediantePatronPanel == null) {
			botonesEtiquetadoMediantePatronPanel = new JPanel();
			GroupLayout jPanel4Layout = new GroupLayout(
					(JComponent) botonesEtiquetadoMediantePatronPanel);
			botonesEtiquetadoMediantePatronPanel.setLayout(jPanel4Layout);
			jPanel4Layout.setHorizontalGroup(jPanel4Layout
					.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.add(getBackEtiquetadoMediantePatronButton(),
							GroupLayout.PREFERRED_SIZE, 92,
							GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.UNRELATED, 1,
							GroupLayout.PREFERRED_SIZE)
					.add(getNextEtiquetadoMediantePatronButton(),
							GroupLayout.PREFERRED_SIZE, 92,
							GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.UNRELATED)
					.add(getCancelEtiquetadoMediantePatronButton(),
							GroupLayout.PREFERRED_SIZE, 92,
							GroupLayout.PREFERRED_SIZE));
			jPanel4Layout.linkSize(new Component[] {
					getCancelEtiquetadoMediantePatronButton(),
					getNextEtiquetadoMediantePatronButton(),
					getBackEtiquetadoMediantePatronButton() },
					GroupLayout.HORIZONTAL);
			jPanel4Layout.setVerticalGroup(jPanel4Layout
					.createSequentialGroup()
					.addPreferredGap(LayoutStyle.RELATED, 0, Short.MAX_VALUE)
					.add(jPanel4Layout
							.createParallelGroup(GroupLayout.BASELINE)
							.add(GroupLayout.BASELINE,
									getBackEtiquetadoMediantePatronButton(),
									GroupLayout.PREFERRED_SIZE, 29,
									GroupLayout.PREFERRED_SIZE)
							.add(GroupLayout.BASELINE,
									getNextEtiquetadoMediantePatronButton(),
									GroupLayout.PREFERRED_SIZE, 29,
									GroupLayout.PREFERRED_SIZE)
							.add(GroupLayout.BASELINE,
									getCancelEtiquetadoMediantePatronButton(),
									GroupLayout.PREFERRED_SIZE, 29,
									GroupLayout.PREFERRED_SIZE)));
			jPanel4Layout.linkSize(new Component[] {
					getCancelEtiquetadoMediantePatronButton(),
					getNextEtiquetadoMediantePatronButton(),
					getBackEtiquetadoMediantePatronButton() },
					GroupLayout.VERTICAL);
		}
		return botonesEtiquetadoMediantePatronPanel;
	}

	private JLabel getNombreFiltroEtiquetadoMediantePatroLabel() {
		if (nombreFiltroEtiquetadoMediantePatroLabel == null) {
			nombreFiltroEtiquetadoMediantePatroLabel = new JLabel();
			nombreFiltroEtiquetadoMediantePatroLabel
					.setText(getWord("etiqueta"));
		}
		return nombreFiltroEtiquetadoMediantePatroLabel;
	}

	private JTextField getNombreFiltroEtiquetadoMediantePatronTextField() {
		if (nombreFiltroEtiquetadoMediantePatronTextField == null) {
			nombreFiltroEtiquetadoMediantePatronTextField = new JTextField();
			nombreFiltroEtiquetadoMediantePatronTextField
					.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent e) {
							if (nombreFiltroEtiquetadoMediantePatronTextField
									.getText().equals("")) {
								getAddEtiquetaEtiquetadoMediantePatronButton()
										.setEnabled(false);
							} else {
								getAddEtiquetaEtiquetadoMediantePatronButton()
										.setEnabled(true);
							}
						}
					});
		}
		return nombreFiltroEtiquetadoMediantePatronTextField;
	}

	private JTable getPatronesSeleccionadosEtiquetadoMediantePatronTable() {
		if (patronesSeleccionadosEtiquetadoMediantePatronTable == null) {
			DefaultTableModel patronesSeleccionadosEtiquetadoMediantePatronTableModel = new PatronesSeleccionadosTableModel();
			// Object[] headers = new Object[5];
			// headers[0] = "";
			// headers[1] = getWord("campo");
			// headers[2] = getWord("patron");
			// headers[3] = getWord("valor");
			// headers[4] = getWord("valor2");
			Object[] headers = new Object[4];
			headers[0] = getWord("campo");
			headers[1] = getWord("patron");
			headers[2] = getWord("valor");
			headers[3] = getWord("valor2");
			(patronesSeleccionadosEtiquetadoMediantePatronTableModel)
					.setColumnIdentifiers(headers);
			patronesSeleccionadosEtiquetadoMediantePatronTable = new JTable();
			patronesSeleccionadosEtiquetadoMediantePatronTable
					.setModel(patronesSeleccionadosEtiquetadoMediantePatronTableModel);
			// TableColumn tc =
			// patronesSeleccionadosEtiquetadoMediantePatronTable
			// .getColumnModel().getColumn(0);
			// String[] values = new String[] { getWord("AND"), getWord("OR") };
			// tc.setCellRenderer(new JComboBoxTable(values));
			// // tc.setCellEditor(new JComboBoxTableEditor(values));
			// // JComboBox comboBox = new JComboBox(new String[] {
			// getWord("AND"),
			// // getWord("OR")});
			// // DefaultCellEditor defaultCellEditor=new
			// // DefaultCellEditor(comboBox);
			// // tc.setCellEditor(defaultCellEditor);

		}
		return patronesSeleccionadosEtiquetadoMediantePatronTable;
	}

	private JScrollPane getPatronesSeleccionadosEtiquetadoMediantePatronScrollPane() {
		if (patronesSeleccionadosEtiquetadoMediantePatronScrollPane == null) {
			patronesSeleccionadosEtiquetadoMediantePatronScrollPane = new JScrollPane();
			patronesSeleccionadosEtiquetadoMediantePatronScrollPane
					.setViewportView(getPatronesSeleccionadosEtiquetadoMediantePatronTable());
		}
		return patronesSeleccionadosEtiquetadoMediantePatronScrollPane;
	}

	private JPanel getSegundoPasoEtiquetadoMediantePatronPanel() {
		if (segundoPasoEtiquetadoMediantePatronPanel == null) {
			segundoPasoEtiquetadoMediantePatronPanel = new JPanel();
			GroupLayout jPanel3Layout1 = new GroupLayout(
					(JComponent) segundoPasoEtiquetadoMediantePatronPanel);
			segundoPasoEtiquetadoMediantePatronPanel.setLayout(jPanel3Layout1);
			segundoPasoEtiquetadoMediantePatronPanel.setVisible(false);
			segundoPasoEtiquetadoMediantePatronPanel.setVisible(false);
			jPanel3Layout1
					.setHorizontalGroup(jPanel3Layout1
							.createSequentialGroup()
							.addContainerGap()
							.add(jPanel3Layout1
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											jPanel3Layout1
													.createSequentialGroup()
													.add(getNombreFiltroEtiquetadoMediantePatroLabel(),
															GroupLayout.PREFERRED_SIZE,
															80,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.RELATED)
													.add(getNombreEtiquetaEtiquetadoMediantePatronComboBox(),
															GroupLayout.PREFERRED_SIZE,
															105,
															GroupLayout.PREFERRED_SIZE)
													.add(19)
													.add(getNombreFiltroEtiquetadoMediantePatronTextField(),
															GroupLayout.PREFERRED_SIZE,
															115,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.UNRELATED)
													.add(getAddEtiquetaEtiquetadoMediantePatronButton(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.add(0, 259,
															Short.MAX_VALUE))
									.add(jPanel3Layout1
											.createSequentialGroup()
											.add(getPatronesSeleccionadosEtiquetadoMediantePatronScrollPane(),
													GroupLayout.PREFERRED_SIZE,
													665,
													GroupLayout.PREFERRED_SIZE)
											.add(0, 0, Short.MAX_VALUE)))
							.addContainerGap());
			jPanel3Layout1
					.setVerticalGroup(jPanel3Layout1
							.createSequentialGroup()
							.addContainerGap(24, 24)
							.add(jPanel3Layout1
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getNombreFiltroEtiquetadoMediantePatronTextField(),
											GroupLayout.PREFERRED_SIZE, 22,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getNombreFiltroEtiquetadoMediantePatroLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getNombreEtiquetaEtiquetadoMediantePatronComboBox(),
											GroupLayout.PREFERRED_SIZE, 18,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getAddEtiquetaEtiquetadoMediantePatronButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.UNRELATED)
							.add(getPatronesSeleccionadosEtiquetadoMediantePatronScrollPane(),
									GroupLayout.PREFERRED_SIZE, 278,
									GroupLayout.PREFERRED_SIZE)
							.addContainerGap(16, Short.MAX_VALUE));
		}
		return segundoPasoEtiquetadoMediantePatronPanel;
	}

	private AbstractAction getNextEtiquetadoMediantePatronAction() {
		if (nextEtiquetadoMediantePatronAction == null) {
			nextEtiquetadoMediantePatronAction = new AbstractAction(
					getWord("next"), null) {
				public void actionPerformed(ActionEvent evt) {
					avanzarEtiquetadoMediantePatron();

				}

				private void cargarTablaPatrones() {
					DefaultTableModel model = (DefaultTableModel) getPatronesSeleccionadosEtiquetadoMediantePatronTable()
							.getModel();
					borrarTodasFilasTabla(model);
					for (Patron p : patronesSeleccionados) {
						model.addRow(getRow(p));
					}
				}

				public Object[] getRow(Patron p) {
					Object[] patrones = new Object[4];
					patrones[0] = p.getCampo().toString();
					patrones[1] = p.getTipo().toString();
					patrones[2] = p.getValor();
					if (p.getValor2() == null) {
						patrones[3] = "";
					} else {
						patrones[3] = p.getValor2();
					}

					return patrones;
				}

				public void avanzarEtiquetadoMediantePatron() {
					if (getPrimerPasoEtiquetadoMediantePatronPanel()
							.isVisible()) {
						getNombreEtiquetaEtiquetadoMediantePatronComboBox()
								.setEnabled(true);
						getNombreEtiquetaEtiquetadoMediantePatronComboBox()
								.setModel(
										new DefaultComboBoxModel(getMain()
												.getEtiquetas().toArray()));
						getPrimerPasoEtiquetadoMediantePatronPanel()
								.setVisible(false);
						getSegundoPasoEtiquetadoMediantePatronPanel()
								.setVisible(true);
						getBackEtiquetadoMediantePatronButton()
								.setEnabled(true);
						getNextEtiquetadoMediantePatronButton().setText(
								getWord("ok"));

						cargarTablaPatrones();
						if (getNombreEtiquetaEtiquetadoMediantePatronComboBox()
								.getModel().getSize() == 0) {
							getNextEtiquetadoMediantePatronButton().setEnabled(
									false);
							getNombreEtiquetaEtiquetadoMediantePatronComboBox()
									.setEnabled(false);
						}

					} else if (getSegundoPasoEtiquetadoMediantePatronPanel()
							.isVisible()) {
						// PROCESAR
						List<CriterioBusqueda> listCB = new LinkedList<CriterioBusqueda>();
						Etiqueta e = new Etiqueta(
								getNombreEtiquetaEtiquetadoMediantePatronComboBox()
										.getModel()
										.getElementAt(
												getNombreEtiquetaEtiquetadoMediantePatronComboBox()
														.getSelectedIndex())
										.toString());
						getMain().addEtiquetaSuelta(e);
						int i = 0;
						for (Patron p : patronesSeleccionados) {
							CriterioBusqueda cb = p.getCriterioBusqueda();
							// obtenerEstadoCriterioBusqueda(cb, i);
							listCB.add(cb);
							i++;
						}
						operacion = new EtiquetarCriterioBusquedaOperacion(
								getMain(), listCB, e);
						ejecutarOperacion();
						patronesSeleccionados.clear();
						getEtiquetadoMediantePatronDialog().dispose();
						getNombreFiltroEtiquetadoMediantePatronTextField()
								.setText("");
						retrocederEtiquetadoMediantePatron();
					}

				}

				// private void obtenerEstadoCriterioBusqueda(CriterioBusqueda
				// cb,
				// int fila) {
				// Object o =
				// getPatronesSeleccionadosEtiquetadoMediantePatronTable()
				// .getModel().getValueAt(fila, 0);
				// if (o instanceof JComboBox) {
				// JComboBox jcbt = (JComboBox) o;
				// if (jcbt.getSelectedIndex() == 0) {
				// cb.setAnd(true);
				// } else {
				// cb.setAnd(false);
				// }
				// System.out.println(((JComboBoxTable) o)
				// .getSelectedItem().toString());
				// } else {
				// if (o.toString().equals(getWord("AND"))) {
				// cb.setAnd(true);
				// } else {
				// cb.setAnd(false);
				// }
				// System.out.println(o);
				// }
				//
				// // String s = (String)
				// // getPatronesSeleccionadosEtiquetadoMediantePatronTable()
				// // .getModel().getValueAt(fila, 0);
				// // System.out.println(s);
				// // if (s.equals(getWord("and"))) {
				// // cb.setAnd(true);
				// // } else {
				// // cb.setAnd(false);
				// // }
				// }
			};
		}
		return nextEtiquetadoMediantePatronAction;
	}

	private AbstractAction getBackEtiquetadoMediantePatronAction() {
		if (backEtiquetadoMediantePatronAction == null) {
			backEtiquetadoMediantePatronAction = new AbstractAction(
					getWord("back"), null) {
				public void actionPerformed(ActionEvent evt) {
					retrocederEtiquetadoMediantePatron();
				}
			};
		}
		return backEtiquetadoMediantePatronAction;
	}

	private void retrocederEtiquetadoMediantePatron() {
		if (getSegundoPasoEtiquetadoMediantePatronPanel().isVisible()) {
			getPrimerPasoEtiquetadoMediantePatronPanel().setVisible(true);
			getSegundoPasoEtiquetadoMediantePatronPanel().setVisible(false);
			getBackEtiquetadoMediantePatronButton().setEnabled(false);
			getNextEtiquetadoMediantePatronButton().setText(getWord("next"));
			getNextEtiquetadoMediantePatronButton().setEnabled(true);
		}
	}

	private JPanel getBotonesAddGrupoUsuariosMismasTagsPanel() {
		if (botonesAddGrupoUsuariosMismasTagsPanel == null) {
			botonesAddGrupoUsuariosMismasTagsPanel = new JPanel();
			GroupLayout jPanel3Layout2 = new GroupLayout(
					(JComponent) botonesAddGrupoUsuariosMismasTagsPanel);
			botonesAddGrupoUsuariosMismasTagsPanel.setLayout(jPanel3Layout2);
			jPanel3Layout2.setHorizontalGroup(jPanel3Layout2
					.createSequentialGroup()
					.addContainerGap(83, 83)
					.add(getOkAddGrupoUsuariosMismasTagsButton(),
							GroupLayout.PREFERRED_SIZE, 114,
							GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.UNRELATED, 1,
							GroupLayout.PREFERRED_SIZE)
					.add(getCancelAddGrupoUsuariosMismasTagsButon(),
							GroupLayout.PREFERRED_SIZE, 114,
							GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE));
			jPanel3Layout2.linkSize(new Component[] {
					getCancelAddGrupoUsuariosMismasTagsButon(),
					getOkAddGrupoUsuariosMismasTagsButton() },
					GroupLayout.HORIZONTAL);
			jPanel3Layout2.setVerticalGroup(jPanel3Layout2
					.createParallelGroup(GroupLayout.BASELINE)
					.add(GroupLayout.BASELINE,
							getOkAddGrupoUsuariosMismasTagsButton(),
							GroupLayout.PREFERRED_SIZE, 29,
							GroupLayout.PREFERRED_SIZE)
					.add(GroupLayout.BASELINE,
							getCancelAddGrupoUsuariosMismasTagsButon(),
							GroupLayout.PREFERRED_SIZE, 29,
							GroupLayout.PREFERRED_SIZE));
			jPanel3Layout2.linkSize(new Component[] {
					getOkAddGrupoUsuariosMismasTagsButton(),
					getCancelAddGrupoUsuariosMismasTagsButon() },
					GroupLayout.VERTICAL);
		}
		return botonesAddGrupoUsuariosMismasTagsPanel;
	}

	private JPanel getPrimerPasoAddGrupoUsuariosMismasTagsPanel() {
		if (primerPasoAddGrupoUsuariosMismasTagsPanel == null) {
			primerPasoAddGrupoUsuariosMismasTagsPanel = new JPanel();
			GroupLayout jPanel3Layout3 = new GroupLayout(
					(JComponent) primerPasoAddGrupoUsuariosMismasTagsPanel);
			primerPasoAddGrupoUsuariosMismasTagsPanel.setLayout(jPanel3Layout3);
			jPanel3Layout3
					.setHorizontalGroup(jPanel3Layout3
							.createSequentialGroup()
							.addContainerGap()
							.add(jPanel3Layout3
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											jPanel3Layout3
													.createSequentialGroup()
													.add(getJScrollPane15(),
															GroupLayout.PREFERRED_SIZE,
															199,
															GroupLayout.PREFERRED_SIZE)
													.add(17))
									.add(GroupLayout.LEADING,
											jPanel3Layout3
													.createSequentialGroup()
													.add(getJLabel4(),
															GroupLayout.PREFERRED_SIZE,
															187,
															GroupLayout.PREFERRED_SIZE)
													.add(29))
									.add(GroupLayout.LEADING,
											jPanel3Layout3
													.createSequentialGroup()
													.add(getBusquedaRapidaAddGrupoUsuariosMismasTagsLabel(),
															GroupLayout.PREFERRED_SIZE,
															124,
															GroupLayout.PREFERRED_SIZE)
													.add(getBusquedaRapidaAddGrupoUsuariosMismasTagsTextField(),
															GroupLayout.PREFERRED_SIZE,
															92,
															GroupLayout.PREFERRED_SIZE))
									.add(GroupLayout.LEADING,
											jPanel3Layout3
													.createSequentialGroup()
													.add(getAddNuevoGrupoMismasTagsLabel(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.UNRELATED)
													.add(getAddNuevoGrupoMismasTagsTextField(),
															0, 102,
															Short.MAX_VALUE)
													.addPreferredGap(
															LayoutStyle.RELATED)
													.add(getAddNuevoGrupoMismasTagsButton(),
															GroupLayout.PREFERRED_SIZE,
															45,
															GroupLayout.PREFERRED_SIZE)
													.add(19)))
							.add(jPanel3Layout3
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getAddGrupoAddGrupoUsuariosMismasTagsButton(),
											GroupLayout.PREFERRED_SIZE, 81,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											getRemoveGrupoAddGrupoUsuariosMismasTagsButton(),
											GroupLayout.PREFERRED_SIZE, 81,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(jPanel3Layout3
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getJScrollPane9(), 0, 199,
											Short.MAX_VALUE)
									.add(GroupLayout.LEADING,
											jPanel3Layout3
													.createSequentialGroup()
													.addPreferredGap(
															getJScrollPane9(),
															getEtiquetasSeleccionadasAddGrupoUsuariosMismasTagsLabel(),
															LayoutStyle.INDENT)
													.add(getEtiquetasSeleccionadasAddGrupoUsuariosMismasTagsLabel(),
															GroupLayout.PREFERRED_SIZE,
															187,
															GroupLayout.PREFERRED_SIZE)
													.add(0, 0, Short.MAX_VALUE)))
							.addContainerGap(21, 21));
			jPanel3Layout3.linkSize(new Component[] { getJScrollPane9(),
					getJScrollPane15() }, GroupLayout.HORIZONTAL);
			jPanel3Layout3
					.setVerticalGroup(jPanel3Layout3
							.createSequentialGroup()
							.addContainerGap()
							.add(jPanel3Layout3
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getBusquedaRapidaAddGrupoUsuariosMismasTagsTextField(),
											GroupLayout.PREFERRED_SIZE, 22,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getBusquedaRapidaAddGrupoUsuariosMismasTagsLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.add(8)
							.add(jPanel3Layout3
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getEtiquetasSeleccionadasAddGrupoUsuariosMismasTagsLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE, getJLabel4(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.UNRELATED)
							.add(jPanel3Layout3
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getJScrollPane9(),
											GroupLayout.PREFERRED_SIZE, 194,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											getJScrollPane15(),
											GroupLayout.PREFERRED_SIZE, 194,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											jPanel3Layout3
													.createSequentialGroup()
													.add(54)
													.add(getAddGrupoAddGrupoUsuariosMismasTagsButton(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.add(24)
													.add(getRemoveGrupoAddGrupoUsuariosMismasTagsButton(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.add(70)))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(jPanel3Layout3
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getAddNuevoGrupoMismasTagsButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getAddNuevoGrupoMismasTagsLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getAddNuevoGrupoMismasTagsTextField(),
											GroupLayout.PREFERRED_SIZE, 20,
											GroupLayout.PREFERRED_SIZE))
							.addContainerGap(20, 20));
		}
		return primerPasoAddGrupoUsuariosMismasTagsPanel;
	}

	private JScrollPane getJScrollPane9() {
		if (jScrollPane9 == null) {
			jScrollPane9 = new JScrollPane();
			jScrollPane9
					.setViewportView(getGruposActualesAddGrupoUsuariosMismasTagsList());
		}
		return jScrollPane9;
	}

	private JList getGruposActualesAddGrupoUsuariosMismasTagsList() {
		if (gruposActualesAddGrupoUsuariosMismasTagsList == null) {
			ListModel jList5Model = new DefaultListModel();
			gruposActualesAddGrupoUsuariosMismasTagsList = new JList();
			gruposActualesAddGrupoUsuariosMismasTagsList.setModel(jList5Model);
			gruposActualesAddGrupoUsuariosMismasTagsList
					.setPreferredSize(new java.awt.Dimension(138, 190));
			gruposActualesAddGrupoUsuariosMismasTagsList
					.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return gruposActualesAddGrupoUsuariosMismasTagsList;
	}

	private JButton getAddGrupoAddGrupoUsuariosMismasTagsButton() {
		if (addGrupoAddGrupoUsuariosMismasTagsButton == null) {
			addGrupoAddGrupoUsuariosMismasTagsButton = new JButton();
			addGrupoAddGrupoUsuariosMismasTagsButton.setText(">");
			addGrupoAddGrupoUsuariosMismasTagsButton
					.setAction(getAddGrupoAddGrupoUsuariosMismasTagsAction());
		}
		return addGrupoAddGrupoUsuariosMismasTagsButton;
	}

	private AbstractAction getAddGrupoAddGrupoUsuariosMismasTagsAction() {
		if (addGrupoAddGrupoUsuariosMismasTagsAction == null) {
			addGrupoAddGrupoUsuariosMismasTagsAction = new AbstractAction(">",
					null) {
				public void actionPerformed(ActionEvent evt) {
					moverElementoList(
							getGruposDisponiblesAddGrupoUsuariosMismasTagsList(),
							getGruposActualesAddGrupoUsuariosMismasTagsList());
					getOkAddGrupoUsuariosMismasTagsButton().setEnabled(true);

				}
			};
		}
		return addGrupoAddGrupoUsuariosMismasTagsAction;
	}

	private JButton getRemoveGrupoAddGrupoUsuariosMismasTagsButton() {
		if (removeGrupoAddGrupoUsuariosMismasTagsButton == null) {
			removeGrupoAddGrupoUsuariosMismasTagsButton = new JButton();
			removeGrupoAddGrupoUsuariosMismasTagsButton.setText("<");
			removeGrupoAddGrupoUsuariosMismasTagsButton
					.setAction(getRemoveGrupoAddGrupoUsuariosMismasTagsAction());
		}
		return removeGrupoAddGrupoUsuariosMismasTagsButton;
	}

	private AbstractAction getRemoveGrupoAddGrupoUsuariosMismasTagsAction() {
		if (removeGrupoAddGrupoUsuariosMismasTagsAction == null) {
			removeGrupoAddGrupoUsuariosMismasTagsAction = new AbstractAction(
					"<", null) {
				public void actionPerformed(ActionEvent evt) {
					moverElementoList(
							getGruposActualesAddGrupoUsuariosMismasTagsList(),
							getGruposDisponiblesAddGrupoUsuariosMismasTagsList());
					// if (getGruposActualesAddGrupoUsuariosMismasTagsList()
					// .getModel().getSize() == 0) {
					// getOkAddGrupoUsuariosMismasTagsButton().setEnabled(
					// false);
					// }
				}
			};
		}
		return removeGrupoAddGrupoUsuariosMismasTagsAction;
	}

	private JScrollPane getJScrollPane15() {
		if (jScrollPane15 == null) {
			jScrollPane15 = new JScrollPane();
			jScrollPane15
					.setViewportView(getGruposDisponiblesAddGrupoUsuariosMismasTagsList());
		}
		return jScrollPane15;
	}

	private JList getGruposDisponiblesAddGrupoUsuariosMismasTagsList() {
		if (gruposDisponiblesAddGrupoUsuariosMismasTagsList == null) {
			ListModel jList6Model = new DefaultListModel();
			gruposDisponiblesAddGrupoUsuariosMismasTagsList = new JList();
			gruposDisponiblesAddGrupoUsuariosMismasTagsList
					.setModel(jList6Model);
			gruposDisponiblesAddGrupoUsuariosMismasTagsList
					.setPreferredSize(new java.awt.Dimension(184, 190));
			gruposDisponiblesAddGrupoUsuariosMismasTagsList
					.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return gruposDisponiblesAddGrupoUsuariosMismasTagsList;
	}

	private JLabel getJLabel4() {
		if (etiquetasDisponiblesAddGrupoUsuariosMismasTagsLabel == null) {
			etiquetasDisponiblesAddGrupoUsuariosMismasTagsLabel = new JLabel();
			etiquetasDisponiblesAddGrupoUsuariosMismasTagsLabel
					.setText(getWord("grupos_disponibles"));
			etiquetasDisponiblesAddGrupoUsuariosMismasTagsLabel
					.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return etiquetasDisponiblesAddGrupoUsuariosMismasTagsLabel;
	}

	private JLabel getEtiquetasSeleccionadasAddGrupoUsuariosMismasTagsLabel() {
		if (etiquetasSeleccionadasAddGrupoUsuariosMismasTagsLabel == null) {
			etiquetasSeleccionadasAddGrupoUsuariosMismasTagsLabel = new JLabel();
			etiquetasSeleccionadasAddGrupoUsuariosMismasTagsLabel
					.setText(getWord("grupos_actuales"));
			etiquetasSeleccionadasAddGrupoUsuariosMismasTagsLabel
					.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return etiquetasSeleccionadasAddGrupoUsuariosMismasTagsLabel;
	}

	private JTextField getBusquedaRapidaAddGrupoUsuariosMismasTagsTextField() {
		if (busquedaRapidaAddGrupoUsuariosMismasTagsTextField == null) {
			busquedaRapidaAddGrupoUsuariosMismasTagsTextField = new JTextField();
		}
		return busquedaRapidaAddGrupoUsuariosMismasTagsTextField;
	}

	private JLabel getBusquedaRapidaAddGrupoUsuariosMismasTagsLabel() {
		if (busquedaRapidaAddGrupoUsuariosMismasTagsLabel == null) {
			busquedaRapidaAddGrupoUsuariosMismasTagsLabel = new JLabel();
			busquedaRapidaAddGrupoUsuariosMismasTagsLabel
					.setText(getWord("busqueda_rapida"));
		}
		return busquedaRapidaAddGrupoUsuariosMismasTagsLabel;
	}

	private AbstractAction getOkAddGrupoUsuariosMismasTagsAction() {
		if (okAddGrupoUsuariosMismasTagsAction == null) {
			okAddGrupoUsuariosMismasTagsAction = new AbstractAction(
					getWord("ok"), null) {
				public void actionPerformed(ActionEvent evt) {
					List<Grupo> grupos = new LinkedList<Grupo>();
					for (int i = 0; i < ((DefaultListModel) getGruposActualesAddGrupoUsuariosMismasTagsList()
							.getModel()).size(); i++) {
						grupos.add(new Grupo(
								((DefaultListModel) getGruposActualesAddGrupoUsuariosMismasTagsList()
										.getModel()).elementAt(i).toString()));
					}
					operacion = new AddGrupoMensajesMismasTagsOperacion(
							getMain(), mensajeSeleccionado, grupos);
					ejecutarOperacion(getAddGrupoUsuariosMismasTagsDialog());
				}

			};
		}
		return okAddGrupoUsuariosMismasTagsAction;
	}

	private JDialog getPreferenciasDialog() {
		if (preferenciasDialog == null) {
			preferenciasDialog = new JDialog(this);
			GroupLayout preferenciasDialogLayout = new GroupLayout(
					(JComponent) preferenciasDialog.getContentPane());
			preferenciasDialog.setLayout(preferenciasDialogLayout);
			preferenciasDialog.setTitle(getWord("preferencias"));
			preferenciasDialog.setSize(444, 223);
			preferenciasDialogLayout
					.setHorizontalGroup(preferenciasDialogLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(getIdiomaPreferenciasLabel(),
									GroupLayout.PREFERRED_SIZE, 88,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.UNRELATED)
							.add(preferenciasDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											preferenciasDialogLayout
													.createSequentialGroup()
													.add(0, 0, Short.MAX_VALUE)
													.add(getIdiomaPreferenciasComboBox(),
															GroupLayout.PREFERRED_SIZE,
															201,
															GroupLayout.PREFERRED_SIZE)
													.add(10))
									.add(GroupLayout.LEADING,
											preferenciasDialogLayout
													.createSequentialGroup()
													.add(0, 114,
															Short.MAX_VALUE)
													.add(getOkPreferenciasButton(),
															GroupLayout.PREFERRED_SIZE,
															97,
															GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(LayoutStyle.UNRELATED)
							.add(getCancelPreferenciasButton(), 0, 103,
									Short.MAX_VALUE).add(11));
			preferenciasDialogLayout.setVerticalGroup(preferenciasDialogLayout
					.createSequentialGroup()
					.addContainerGap(62, 62)
					.add(preferenciasDialogLayout
							.createParallelGroup(GroupLayout.BASELINE)
							.add(GroupLayout.BASELINE,
									getIdiomaPreferenciasComboBox(),
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.add(GroupLayout.BASELINE,
									getIdiomaPreferenciasLabel(),
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.add(0, 66, Short.MAX_VALUE)
					.add(preferenciasDialogLayout
							.createParallelGroup(GroupLayout.BASELINE)
							.add(GroupLayout.BASELINE,
									getOkPreferenciasButton(),
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.add(GroupLayout.BASELINE,
									getCancelPreferenciasButton(),
									GroupLayout.PREFERRED_SIZE, 29,
									GroupLayout.PREFERRED_SIZE))
					.addContainerGap());
			preferenciasDialogLayout.linkSize(new Component[] {
					getOkPreferenciasButton(), getCancelPreferenciasButton() },
					GroupLayout.VERTICAL);
		}
		return preferenciasDialog;
	}

	private AbstractAction getPreferenciasAction() {
		if (preferenciasAction == null) {
			preferenciasAction = new AbstractAction(getWord("preferencias"),
					null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					abrirVentana(getPreferenciasDialog());
				}
			};
		}
		return preferenciasAction;
	}

	private JButton getCancelPreferenciasButton() {
		if (cancelPreferenciasButton == null) {
			cancelPreferenciasButton = new JButton();
			cancelPreferenciasButton.setText(getWord("cancelar"));
			cancelPreferenciasButton.setAction(getCancelPreferenciasAction());
		}
		return cancelPreferenciasButton;
	}

	private AbstractAction getCancelPreferenciasAction() {
		if (cancelPreferenciasAction == null) {
			cancelPreferenciasAction = new AbstractAction(getWord("cancelar"),
					null) {
				public void actionPerformed(ActionEvent evt) {
					getPreferenciasDialog().dispose();
				}
			};
		}
		return cancelPreferenciasAction;
	}

	private JButton getOkPreferenciasButton() {
		if (okPreferenciasButton == null) {
			okPreferenciasButton = new JButton();
			okPreferenciasButton.setText(getWord("ok"));
			okPreferenciasButton.setAction(getOkPreferenciasAction());
		}
		return okPreferenciasButton;
	}

	private JLabel getIdiomaPreferenciasLabel() {
		if (idiomaPreferenciasLabel == null) {
			idiomaPreferenciasLabel = new JLabel();
			idiomaPreferenciasLabel.setText(getWord("idioma"));
			idiomaPreferenciasLabel
					.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return idiomaPreferenciasLabel;
	}

	private JComboBox getIdiomaPreferenciasComboBox() {
		if (idiomaPreferenciasComboBox == null) {
			ComboBoxModel idiomaPreferenciasComboBoxModel = new DefaultComboBoxModel(
					new String[] { getWord("spanish"), getWord("english") });
			idiomaPreferenciasComboBox = new JComboBox();
			idiomaPreferenciasComboBox
					.setModel(idiomaPreferenciasComboBoxModel);
		}
		return idiomaPreferenciasComboBox;
	}

	private AbstractAction getOkPreferenciasAction() {
		if (okPreferenciasAction == null) {
			okPreferenciasAction = new AbstractAction(getWord("ok"), null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					realizarCambios();
				}

				private void realizarCambios() {
					Locale l = getIdioma(getIdiomaPreferenciasComboBox()
							.getSelectedIndex());
					System.out.println(Locale.getDefault());
					if (!l.getLanguage().equals(
							Locale.getDefault().getLanguage())) {
						Locale.setDefault(l);
						System.out.println(Locale.getDefault());
						reiniciarVentana();
					}
					getPreferenciasDialog().dispose();
				}

				private void reiniciarVentana() {
					main.reiniciarInterfaz();

				}

				private Locale getIdioma(int nIdioma) {
					Locale l = null;
					switch (nIdioma) {
					case 0:
						l = new Locale("es"); // ESPAÑOL
						break;
					case 1:
						l = new Locale("en"); // INGLÉS
						break;
					}

					return l;
				}
			};
		}
		return okPreferenciasAction;
	}

	private JFileChooser getImportarArchivoFileChooser() {
		if (importarArchivoFileChooser == null) {
			importarArchivoFileChooser = new JFileChooser();
			importarArchivoFileChooser.setCurrentDirectory(new File("app.db"));
		}
		return importarArchivoFileChooser;
	}

	private AbstractAction getImportarDatosAction() {
		if (importarDatosAction == null) {
			importarDatosAction = new AbstractAction(getWord("importar_datos"),
					null) {
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					mostrarFileChooser();
					cargarDatos();
				}
			};
		}
		return importarDatosAction;
	}

	private void mostrarFileChooser() {
		int returnVal = getImportarArchivoFileChooser().showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			this.main.setPath(getImportarArchivoFileChooser().getSelectedFile()
					.getPath());
		}
	}

	private void cargarDatos() {
		operacion = new CargarOperacion(this.main);
		ejecutarOperacion();
	}

	public JProgressBar getProgreso() {
		return getBarraCargaProgresoProgressBar();
	}

	public void finalizarCarga() {
		getBarraCargaProgresoProgressBar().setIndeterminate(true);
		if (getCargaProgresoDialog().isVisible())
			getCargaProgresoDialog().dispose();
		if (tablaMensajesModel.getRowCount() == 0)
			rellenarTabla(primerMensajeMostrado, ultimoMensajeMostrado
					+ numMensajesCargadosPorIteracion);
	}

	private JButton getMensajesAnterioresButton() {
		if (mensajesAnterioresButton == null) {
			mensajesAnterioresButton = new JButton();
			mensajesAnterioresButton.setText(getWord("mensajes_anteriores"));
			mensajesAnterioresButton.setAction(getMensajesAnterioresAction());
		}
		return mensajesAnterioresButton;
	}

	private JButton getMensajesPosterioresButton() {
		if (mensajesPosterioresButton == null) {
			mensajesPosterioresButton = new JButton();
			mensajesPosterioresButton.setText(getWord("mensajes_posteriores"));
			mensajesPosterioresButton.setAction(getMensajesSiguientesAction());
		}
		return mensajesPosterioresButton;
	}

	private JLabel getNumMensajesLabel() {
		if (numMensajesLabel == null) {
			numMensajesLabel = new JLabel();
			numMensajesLabel.setText(getWord("num_mensajes"));
		}
		return numMensajesLabel;
	}

	private JLabel getNumMensajesValueLabel() {
		if (numMensajesValueLabel == null) {
			numMensajesValueLabel = new JLabel();
			numMensajesValueLabel.setText("0");
		}
		return numMensajesValueLabel;
	}

	private JLabel getPaginaActualLabel() {
		if (paginaActualLabel == null) {
			paginaActualLabel = new JLabel();
			paginaActualLabel.setText(getWord("pagina_actual"));
		}
		return paginaActualLabel;
	}

	private JLabel getPaginaActualValueLabel() {
		if (paginaActualValueLabel == null) {
			paginaActualValueLabel = new JLabel();
			paginaActualValueLabel.setText("1");
		}
		return paginaActualValueLabel;
	}

	private AbstractAction getMensajesSiguientesAction() {
		if (mensajesSiguientesAction == null) {
			mensajesSiguientesAction = new AbstractAction(
					getWord("mensajes_posteriores"), null) {
				private static final long serialVersionUID = 7392623200147269654L;

				public void actionPerformed(ActionEvent evt) {
					rellenarTabla(ultimoMensajeMostrado,
							numMensajesCargadosPorIteracion);
					incrementarPagina();
					if (primerMensajeMostrado + numMensajesCargadosPorIteracion != ultimoMensajeMostrado
							|| tablaMensajesModel.getRowCount() < numMensajesCargadosPorIteracion) {
						getMensajesPosterioresButton().setEnabled(false);
					}
					if (!getMensajesAnterioresButton().isEnabled()) {
						getMensajesAnterioresButton().setEnabled(true);
					}
				}
			};
		}
		return mensajesSiguientesAction;
	}

	private AbstractAction getMensajesAnterioresAction() {
		if (mensajesAnterioresAction == null) {
			mensajesAnterioresAction = new AbstractAction(
					getWord("mensajes_anteriores"), null) {
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					rellenarTabla(primerMensajeMostrado
							- numMensajesCargadosPorIteracion,
							numMensajesCargadosPorIteracion);
					decrementarPagina();
					if (getPaginaActualValueLabel().getText().equals("1")) {
						getMensajesAnterioresButton().setEnabled(false);
					}
					if (!getMensajesPosterioresButton().isEnabled()) {
						getMensajesPosterioresButton().setEnabled(true);
					}
				}
			};
		}
		return mensajesAnterioresAction;
	}

	private void incrementarPagina() {
		getPaginaActualValueLabel().setText(
				((Integer.parseInt(getPaginaActualValueLabel().getText())) + 1)
						+ "");
	}

	private void decrementarPagina() {
		getPaginaActualValueLabel().setText(
				((Integer.parseInt(getPaginaActualValueLabel().getText())) - 1)
						+ "");
	}

	private void rellenarTabla() {
		borrarTodasFilasTabla();
		List<Mensaje> m = obtenerMensajes(primerMensajeMostrado,
				numMensajesCargadosPorIteracion);
		for (int i = 0; i < m.size(); i++) { // CAMBIAR
			Object[] ob = m.get(i).getRow(mostrarGruposCheckBox.isSelected());
			((DefaultTableModel) tablaMensajesModel).addRow(ob);
		}
		if (tablaMensajesModel.getRowCount() < numMensajesCargadosPorIteracion) {
			getMensajesPosterioresButton().setEnabled(false);
		} else {
			getMensajesPosterioresButton().setEnabled(true);
		}
		this.mostrados = m;
		actualizarIndicesMensajes(primerMensajeMostrado,
				tablaMensajesModel.getRowCount());
	}

	private List<Mensaje> obtenerMensajes(int min, int numMensajes) {
		List<Mensaje> parcial = new LinkedList<Mensaje>();
		int i = min;
		while (i < getListaBusqueda().size()) {
			if (parcial.size() == numMensajes) {
				break;
			}
			if (!mostrarMensajesOcultosCheckBox.isSelected()) {
				if (getListaBusqueda().get(i).isVisible()) {
					parcial.add(getListaBusqueda().get(i));
				}
			} else {
				parcial.add(getListaBusqueda().get(i));

			}
			i++;
		}
		return parcial;
	}

	public TableModel getMensajesTableModel() {
		return tablaMensajesModel;
	}

	public JTable getTablaMensajes() {
		return tablaMensajes;
	}

	public Main getMain() {
		return main;
	}

	private AbstractAction getBuscarSimilaresAction() {
		if (buscarSimilaresAction == null) {
			buscarSimilaresAction = new AbstractAction(getWord("ok"), null) {
				public void actionPerformed(ActionEvent evt) {
					int comboboxValue = getAlgoritmoBuscarMensajesSimilaresComboBox()
							.getSelectedIndex();
					getBarraCargaProgresoProgressBar().setIndeterminate(false);
					FiltroMensajes filtro = seleccionarAlgoritmo(comboboxValue);
					if (getWord("ignorar_mensajes_similares").equals(
							getBuscarMensajesSimilaresDialog().getTitle())) {
						operacion = new IgnorarMensajesSimilaresOperacion(
								getMain(), mensajeSeleccionado, filtro);
					} else {

						operacion = new MostrarMensajesSimilaresOperacion(
								getMain(), mensajeSeleccionado, filtro);
					}
					ejecutarOperacion(getBuscarMensajesSimilaresDialog());
				}
			};
		}
		return buscarSimilaresAction;
	}

	private FiltroMensajes seleccionarAlgoritmo(int valor) {
		switch (valor) {
		case 0: // Simhashing
			return new SimpleSimhashing();
		case 1:
			return null;
		case 2:
			return null;
		}
		return null;

	}

	private void ejecutarOperacion(JDialog jDialog) {
		if (jDialog.isVisible())
			jDialog.dispose();
		ejecutarOperacion();
	}

	private void ejecutarOperacion() {
		operacion.execute();
		abrirVentanaProgreso();
	}

	private JMenuItem getEtiquetarMensajesSimilaresMenuItem() {
		if (etiquetarMensajesSimilaresMenuItem == null) {
			etiquetarMensajesSimilaresMenuItem = new JMenuItem();
			etiquetarMensajesSimilaresMenuItem
					.setText(getWord("etiquetar_mensajes_similares"));
			etiquetarMensajesSimilaresMenuItem
					.setAction(getEtiquetarMensajesSimilaresAction());
		}
		return etiquetarMensajesSimilaresMenuItem;
	}

	private AbstractAction getEtiquetarMensajesSimilaresAction() {
		if (etiquetarMensajesSimilaresAction == null) {
			etiquetarMensajesSimilaresAction = new AbstractAction(
					getWord("etiquetar_mensajes_similares"), null) {
				public void actionPerformed(ActionEvent evt) {
					getEtiquetaSeleccionadaEtiquetarSimilaresLabel().setText(
							getWord("etiqueta"));
					getEtiquetarSimilaresDialog().setTitle(
							getWord("etiquetar_mensajes_similares"));
					rellenarComboBox(
							(DefaultComboBoxModel) getEtiquetaSeleccionadaEtiquetarSimilaresComboBox()
									.getModel(), getMain().getEtiquetas());
					if (((DefaultComboBoxModel) getEtiquetaSeleccionadaEtiquetarSimilaresComboBox()
							.getModel()).getSize() == 0) {
						getEtiquetaSeleccionadaEtiquetarSimilaresComboBox()
								.setEnabled(false);
						getOkEtiquetarSimilaresButton().setEnabled(false);
					} else {
						getEtiquetaSeleccionadaEtiquetarSimilaresComboBox()
								.setEnabled(true);
						getOkEtiquetarSimilaresButton().setEnabled(true);
					}

					abrirVentana(getEtiquetarSimilaresDialog());
				}
			};
		}
		return etiquetarMensajesSimilaresAction;
	}

	private JMenuItem getAddGrupoUsuariosRecibenMensajesSimilaresMenuItem() {
		if (addGrupoUsuariosRecibenMensajesSimilaresMenuItem == null) {
			addGrupoUsuariosRecibenMensajesSimilaresMenuItem = new JMenuItem();
			addGrupoUsuariosRecibenMensajesSimilaresMenuItem
					.setText(getWord("add_grupo_usuarios_mensajes_similares"));
			addGrupoUsuariosRecibenMensajesSimilaresMenuItem
					.setAction(getAddGrupoUsuariosRecibenMensajesSimilaresAction());
		}
		return addGrupoUsuariosRecibenMensajesSimilaresMenuItem;
	}

	private AbstractAction getAddGrupoUsuariosRecibenMensajesSimilaresAction() {
		if (addGrupoUsuariosRecibenMensajesSimilaresAction == null) {
			addGrupoUsuariosRecibenMensajesSimilaresAction = new AbstractAction(
					getWord("add_grupo_usuarios_mensajes_similares"), null) {
				public void actionPerformed(ActionEvent evt) {
					getEtiquetaSeleccionadaEtiquetarSimilaresLabel().setText(
							getWord("grupo"));
					getEtiquetarSimilaresDialog().setTitle(
							getWord("add_grupo_usuarios_mensajes_similares"));
					rellenarComboBox(
							(DefaultComboBoxModel) getEtiquetaSeleccionadaEtiquetarSimilaresComboBox()
									.getModel(), getMain().getGrupos());
					if (((DefaultComboBoxModel) getEtiquetaSeleccionadaEtiquetarSimilaresComboBox()
							.getModel()).getSize() == 0) {
						getEtiquetaSeleccionadaEtiquetarSimilaresComboBox()
								.setEnabled(false);
						getOkEtiquetarSimilaresButton().setEnabled(false);

					} else {
						getEtiquetaSeleccionadaEtiquetarSimilaresComboBox()
								.setEnabled(true);
						getOkEtiquetarSimilaresButton().setEnabled(true);
					}
					abrirVentana(getEtiquetarSimilaresDialog());
				}
			};
		}
		return addGrupoUsuariosRecibenMensajesSimilaresAction;
	}

	private void rellenarComboBox(DefaultComboBoxModel model, List<?> list) {
		model.removeAllElements();
		for (Object o : list) {
			model.addElement(o.toString());
		}
	}

	private AbstractAction getAddEtiquetaSueltaAction() {
		if (addEtiquetaSueltaAction == null) {
			addEtiquetaSueltaAction = new AbstractAction("+", null) {
				public void actionPerformed(ActionEvent evt) {
					int etiquetas = getMain().getEtiquetas().size();
					String text = getAddEtiquetaEtiquetarMensajeTextField()
							.getText();
					if (text != null && !text.equals("")) {
						getMain().addEtiquetaSuelta(new Etiqueta(text));
						if (etiquetas < getMain().getEtiquetas().size()) {
							((DefaultListModel) getEtiquetasActualesList()
									.getModel()).addElement(text);
						}

					}
					getAddEtiquetaEtiquetarMensajeTextField().setText("");
				}
			};
		}
		return addEtiquetaSueltaAction;
	}

	private AbstractAction getSeleccionarEtiquetaAction() {
		if (seleccionarEtiquetaAction == null) {
			seleccionarEtiquetaAction = new AbstractAction(">", null) {
				public void actionPerformed(ActionEvent evt) {
					moverElementoList(getEtiquetasActualesList(),
							getEtiquetasSeleccionadasList());
					getOkEtiquetarMensajeButton().setEnabled(true);
				}
			};
		}
		return seleccionarEtiquetaAction;
	}

	private AbstractAction getBorrarEtiquetaAction() {
		if (borrarEtiquetaAction == null) {
			borrarEtiquetaAction = new AbstractAction("<", null) {
				public void actionPerformed(ActionEvent evt) {
					moverElementoList(getEtiquetasSeleccionadasList(),
							getEtiquetasActualesList());
					getOkEtiquetarMensajeButton().setEnabled(true);
				}
			};
		}
		return borrarEtiquetaAction;
	}

	private void moverElementoList(JList from, JList to) {
		Object o = from.getSelectedValue();
		if (o != null) {
			((DefaultListModel) from.getModel()).removeElement(o);
			((DefaultListModel) to.getModel()).addElement(o);
		}
	}

	private AbstractAction getCerrarEtiquetarMensajeAction() {
		if (cerrarEtiquetarMensajeAction == null) {
			cerrarEtiquetarMensajeAction = new AbstractAction(
					getWord("cancelar"), null) {
				public void actionPerformed(ActionEvent evt) {
					getEtiquetarMensajeDialog().dispose();
				}
			};
		}
		return cerrarEtiquetarMensajeAction;
	}

	private AbstractAction getOkEtiquetarMensajeAction() {
		if (okEtiquetarMensajeAction == null) {
			okEtiquetarMensajeAction = new AbstractAction(getWord("ok"), null) {
				public void actionPerformed(ActionEvent evt) {
					List<Etiqueta> etiquetas = new LinkedList<Etiqueta>();
					for (int i = 0; i < ((DefaultListModel) getEtiquetasSeleccionadasList()
							.getModel()).size(); i++) {
						etiquetas
								.add(new Etiqueta(
										((DefaultListModel) getEtiquetasSeleccionadasList()
												.getModel()).elementAt(i)
												.toString()));
					}
					getMain().cambiarEtiquetasMensaje(mensajeSeleccionado,
							etiquetas);
					rellenarTabla();
					if (getEtiquetarMensajeDialog().isVisible()) {
						getEtiquetarMensajeDialog().dispose();
					}
				}
			};
		}
		return okEtiquetarMensajeAction;
	}

	private JDialog getEtiquetarSimilaresDialog() {
		if (etiquetarSimilaresDialog == null) {
			etiquetarSimilaresDialog = new JDialog(this);
			GroupLayout etiquetarSimilaresDialogLayout = new GroupLayout(
					(JComponent) etiquetarSimilaresDialog.getContentPane());
			etiquetarSimilaresDialog.getContentPane().setLayout(
					etiquetarSimilaresDialogLayout);
			etiquetarSimilaresDialog.setPreferredSize(new java.awt.Dimension(
					409, 201));
			etiquetarSimilaresDialog.setSize(409, 201);
			etiquetarSimilaresDialog
					.setModalityType(ModalityType.APPLICATION_MODAL);
			etiquetarSimilaresDialogLayout
					.setHorizontalGroup(etiquetarSimilaresDialogLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(etiquetarSimilaresDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getSimilitudEtiquetarSimilaresLabel(),
											GroupLayout.PREFERRED_SIZE, 75,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											etiquetarSimilaresDialogLayout
													.createSequentialGroup()
													.add(getEtiquetaSeleccionadaEtiquetarSimilaresLabel(),
															GroupLayout.PREFERRED_SIZE,
															66,
															GroupLayout.PREFERRED_SIZE)
													.add(9))
									.add(GroupLayout.LEADING,
											getSeleccionarAlgoritmoEtiquetarSimilaresLabel(),
											GroupLayout.PREFERRED_SIZE, 74,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(etiquetarSimilaresDialogLayout
									.createParallelGroup()
									.add(etiquetarSimilaresDialogLayout
											.createSequentialGroup()
											.add(etiquetarSimilaresDialogLayout
													.createParallelGroup()
													.add(GroupLayout.LEADING,
															etiquetarSimilaresDialogLayout
																	.createSequentialGroup()
																	.add(getSimilitudEtiquetarSimilaresSpinner(),
																			GroupLayout.PREFERRED_SIZE,
																			56,
																			GroupLayout.PREFERRED_SIZE)
																	.add(27)
																	.add(getOkEtiquetarSimilaresButton(),
																			GroupLayout.PREFERRED_SIZE,
																			97,
																			GroupLayout.PREFERRED_SIZE))
													.add(GroupLayout.LEADING,
															etiquetarSimilaresDialogLayout
																	.createSequentialGroup()
																	.add(getSeleccionarAlgoritmoEtiquetarSimilaresComboBox(),
																			GroupLayout.PREFERRED_SIZE,
																			174,
																			GroupLayout.PREFERRED_SIZE)
																	.add(6)))
											.addPreferredGap(
													LayoutStyle.RELATED)
											.add(etiquetarSimilaresDialogLayout
													.createParallelGroup()
													.add(etiquetarSimilaresDialogLayout
															.createSequentialGroup()
															.add(getCancelarEtiquetarSimilaresButton(),
																	GroupLayout.PREFERRED_SIZE,
																	97,
																	GroupLayout.PREFERRED_SIZE))
													.add(etiquetarSimilaresDialogLayout
															.createSequentialGroup()
															.add(getAyudaEtiquetarSimilaresButton(),
																	GroupLayout.PREFERRED_SIZE,
																	97,
																	GroupLayout.PREFERRED_SIZE)))
											.add(0, 0, Short.MAX_VALUE))
									.add(GroupLayout.LEADING,
											etiquetarSimilaresDialogLayout
													.createSequentialGroup()
													.add(getEtiquetaSeleccionadaEtiquetarSimilaresComboBox(),
															GroupLayout.PREFERRED_SIZE,
															111,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.UNRELATED)
													.add(getAddEtiquetaEtiquetarSimilaresTextField(),
															0, 108,
															Short.MAX_VALUE)
													.addPreferredGap(
															LayoutStyle.UNRELATED,
															1,
															GroupLayout.PREFERRED_SIZE)
													.add(getAddEtiquetaEtiquetarSimilaresButton(),
															GroupLayout.PREFERRED_SIZE,
															44,
															GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(21, 21));
			etiquetarSimilaresDialogLayout
					.setVerticalGroup(etiquetarSimilaresDialogLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(etiquetarSimilaresDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getAddEtiquetaEtiquetarSimilaresButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getEtiquetaSeleccionadaEtiquetarSimilaresComboBox(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getAddEtiquetaEtiquetarSimilaresTextField(),
											GroupLayout.PREFERRED_SIZE, 20,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getEtiquetaSeleccionadaEtiquetarSimilaresLabel(),
											GroupLayout.PREFERRED_SIZE, 16,
											GroupLayout.PREFERRED_SIZE))
							.add(15)
							.add(etiquetarSimilaresDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getAyudaEtiquetarSimilaresButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getSeleccionarAlgoritmoEtiquetarSimilaresComboBox(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getSeleccionarAlgoritmoEtiquetarSimilaresLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.add(17)
							.add(etiquetarSimilaresDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getSimilitudEtiquetarSimilaresSpinner(),
											GroupLayout.PREFERRED_SIZE, 22,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getSimilitudEtiquetarSimilaresLabel(),
											GroupLayout.PREFERRED_SIZE, 13,
											GroupLayout.PREFERRED_SIZE))
							.add(0, 18, Short.MAX_VALUE)
							.add(etiquetarSimilaresDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getCancelarEtiquetarSimilaresButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getOkEtiquetarSimilaresButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addContainerGap());
		}
		return etiquetarSimilaresDialog;
	}

	private JButton getCancelarEtiquetarSimilaresButton() {
		if (cancelarEtiquetarSimilaresButton == null) {
			cancelarEtiquetarSimilaresButton = new JButton();
			cancelarEtiquetarSimilaresButton.setText(getWord("cancelar"));
			cancelarEtiquetarSimilaresButton
					.setAction(getCerrarEtiquetarSimilaresAction());
		}
		return cancelarEtiquetarSimilaresButton;
	}

	private JButton getAyudaEtiquetarSimilaresButton() {
		if (ayudaEtiquetarSimilaresButton == null) {
			ayudaEtiquetarSimilaresButton = new JButton();
			ayudaEtiquetarSimilaresButton.setText(getWord("ayuda"));
			ayudaEtiquetarSimilaresButton
					.setAction(getAyudaEtiquetarSimilaresAction());
		}
		return ayudaEtiquetarSimilaresButton;
	}

	private AbstractAction getAyudaEtiquetarSimilaresAction() {
		if (ayudaEtiquetarSimilaresAction == null) {
			ayudaEtiquetarSimilaresAction = new AbstractAction(
					getWord("ayuda"), null) {
				public void actionPerformed(ActionEvent evt) {
					cargarAyudaAlgoritmo(getSeleccionarAlgoritmoEtiquetarSimilaresComboBox()
							.getSelectedIndex());
				}
			};
		}
		return ayudaEtiquetarSimilaresAction;
	}

	private JComboBox getSeleccionarAlgoritmoEtiquetarSimilaresComboBox() {
		if (seleccionarAlgoritmoEtiquetarSimilaresComboBox == null) {
			ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(
					new String[] { getWord("simhashing") });

			seleccionarAlgoritmoEtiquetarSimilaresComboBox = new JComboBox();
			seleccionarAlgoritmoEtiquetarSimilaresComboBox
					.setModel(jComboBox1Model);
			seleccionarAlgoritmoEtiquetarSimilaresComboBox
					.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (seleccionarAlgoritmoEtiquetarSimilaresComboBox
									.getSelectedIndex() == 0) {
								getSimilitudEtiquetarSimilaresSpinner()
										.setEnabled(false);
							} else {
								getSimilitudEtiquetarSimilaresSpinner()
										.setEnabled(true);
							}
						}
					});
		}
		return seleccionarAlgoritmoEtiquetarSimilaresComboBox;
	}

	private JButton getOkEtiquetarSimilaresButton() {
		if (okEtiquetarSimilaresButton == null) {
			okEtiquetarSimilaresButton = new JButton();
			okEtiquetarSimilaresButton.setText(getWord("ok"));
			okEtiquetarSimilaresButton
					.setAction(getOkEtiquetarSimilaresAction());
		}
		return okEtiquetarSimilaresButton;
	}

	private JSpinner getSimilitudEtiquetarSimilaresSpinner() {
		if (similitudEtiquetarSimilaresSpinner == null) {
			SpinnerNumberModel jSpinner1Model = new SpinnerNumberModel(1, 1,
					100, 1);
			similitudEtiquetarSimilaresSpinner = new JSpinner();
			similitudEtiquetarSimilaresSpinner.setModel(jSpinner1Model);
			similitudEtiquetarSimilaresSpinner.setEnabled(false);
		}
		return similitudEtiquetarSimilaresSpinner;
	}

	private JLabel getSeleccionarAlgoritmoEtiquetarSimilaresLabel() {
		if (seleccionarAlgoritmoEtiquetarSimilaresLabel == null) {
			seleccionarAlgoritmoEtiquetarSimilaresLabel = new JLabel();
			seleccionarAlgoritmoEtiquetarSimilaresLabel
					.setText(getWord("algoritmo"));
		}
		return seleccionarAlgoritmoEtiquetarSimilaresLabel;
	}

	private JLabel getSimilitudEtiquetarSimilaresLabel() {
		if (similitudEtiquetarSimilaresLabel == null) {
			similitudEtiquetarSimilaresLabel = new JLabel();
			similitudEtiquetarSimilaresLabel.setText(getWord("similitud"));
		}
		return similitudEtiquetarSimilaresLabel;
	}

	private JLabel getEtiquetaSeleccionadaEtiquetarSimilaresLabel() {
		if (etiquetaSeleccionadaEtiquetarSimilaresLabel == null) {
			etiquetaSeleccionadaEtiquetarSimilaresLabel = new JLabel();
			etiquetaSeleccionadaEtiquetarSimilaresLabel
					.setText(getWord("etiqueta"));
		}
		return etiquetaSeleccionadaEtiquetarSimilaresLabel;
	}

	private JComboBox getEtiquetaSeleccionadaEtiquetarSimilaresComboBox() {
		if (etiquetaSeleccionadaEtiquetarSimilaresComboBox == null) {
			ComboBoxModel jComboBox2Model = new DefaultComboBoxModel();
			etiquetaSeleccionadaEtiquetarSimilaresComboBox = new JComboBox();
			etiquetaSeleccionadaEtiquetarSimilaresComboBox
					.setModel(jComboBox2Model);
		}
		return etiquetaSeleccionadaEtiquetarSimilaresComboBox;
	}

	private AbstractAction getCerrarEtiquetarSimilaresAction() {
		if (cerrarEtiquetarSimilaresAction == null) {
			cerrarEtiquetarSimilaresAction = new AbstractAction(
					getWord("cancelar"), null) {
				public void actionPerformed(ActionEvent evt) {
					getEtiquetarSimilaresDialog().dispose();
				}
			};
		}
		return cerrarEtiquetarSimilaresAction;
	}

	private AbstractAction getOkEtiquetarSimilaresAction() {
		if (okEtiquetarSimilaresAction == null) {
			okEtiquetarSimilaresAction = new AbstractAction(getWord("ok"), null) {
				public void actionPerformed(ActionEvent evt) {
					int comboboxValue = getSeleccionarAlgoritmoEtiquetarSimilaresComboBox()
							.getSelectedIndex();
					FiltroMensajes filtro = seleccionarAlgoritmo(comboboxValue);
					if (!getEtiquetaSeleccionadaEtiquetarSimilaresLabel()
							.getText().equals(getWord("etiqueta"))) {
						operacion = new AddGrupoReceptorMensajesSimilaresOperacion(
								getMain(),
								mensajeSeleccionado,
								getMain()
										.getGrupo(
												getEtiquetaSeleccionadaEtiquetarSimilaresComboBox()
														.getSelectedIndex()),
								filtro);
					} else {
						operacion = new EtiquetarMensajesSimilaresOperacion(
								getMain(),
								mensajeSeleccionado,
								getMain()
										.getEtiqueta(
												getEtiquetaSeleccionadaEtiquetarSimilaresComboBox()
														.getSelectedIndex()),
								filtro);
					}
					ejecutarOperacion(getEtiquetarSimilaresDialog());
				}

			};
		}
		return okEtiquetarSimilaresAction;
	}

	private JDialog getVerPreviewDialog() {
		if (verPreviewDialog == null) {
			verPreviewDialog = new JDialog(this);
			GroupLayout verPreviewDialogLayout = new GroupLayout(
					(JComponent) verPreviewDialog.getContentPane());
			verPreviewDialog.getContentPane().setLayout(verPreviewDialogLayout);
			verPreviewDialog.setTitle("Preview");
			verPreviewDialogLayout.setHorizontalGroup(verPreviewDialogLayout
					.createSequentialGroup().addContainerGap(20, 20)
					.add(getJScrollPane10(), 0, 483, Short.MAX_VALUE)
					.addContainerGap(20, 20));
			verPreviewDialogLayout.setVerticalGroup(verPreviewDialogLayout
					.createSequentialGroup().addContainerGap(9, 9)
					.add(getJScrollPane10(), 0, 131, Short.MAX_VALUE)
					.addContainerGap(20, 20));
		}
		return verPreviewDialog;
	}

	private JTextArea getVerVistaPreviaTextArea() {
		if (verVistaPreviaTextArea == null) {
			verVistaPreviaTextArea = new JTextArea();
			verVistaPreviaTextArea.setEditable(false);
			verVistaPreviaTextArea.setLineWrap(true);
			verVistaPreviaTextArea.setWrapStyleWord(true);

		}
		return verVistaPreviaTextArea;
	}

	private JScrollPane getJScrollPane10() {
		if (jScrollPane10 == null) {
			jScrollPane10 = new JScrollPane();
			jScrollPane10.setViewportView(getVerVistaPreviaTextArea());
		}
		return jScrollPane10;
	}

	private AbstractAction getOkBusquedaAction() {
		if (okBusquedaAction == null) {
			okBusquedaAction = new AbstractAction(getWord("ok"), null) {
				public void actionPerformed(ActionEvent evt) {
					try {
						Patron p = null;
						if (getBusquedaComboBox().getSelectedIndex() == 2) {
							// TIMESTAMP
							p = new Patron(getCampo(), getTipo(),
									obtenerTimeStamp(getDesdeDateChooser(),
											getHorasDesdeSpinner(),
											getMinutosDesdeSpinner(),
											getSegundosDesdeSpinner())
											.toString(), obtenerTimeStamp(
											getHastaDateChooser(),
											getHorasHastaSpinner(),
											getMinutosHastaSpinner(),
											getSegundosHastaSpinner())
											.toString());

						} else {
							p = new Patron(getCampo(), getTipo(),
									getBusquedaTextField().getText());
						}
						CriterioBusqueda cb = p.getCriterioBusqueda();
						if (getBusquedaDialog().getTitle().equals(
								getWord("busqueda"))) {
							operacion = new MostrarCriterioBusquedaOperacion(
									getMain(), cb);
							ejecutarOperacion(getBusquedaDialog());
						} else {
							getMain().getPatrones().add(p);
							cargarLista(
									(DefaultListModel) getPatronesActualesList()
											.getModel(), getMain()
											.getPatrones(),
									getPatronesSeleccionados());
							getBusquedaDialog().dispose();
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			};
		}
		return okBusquedaAction;
	}

	private JFrame getVentanaPrincipal() {
		return this;
	}

	private TimeStamp obtenerTimeStamp(JDateChooser dateChooser,
			JSpinner horasSpinner, JSpinner minutosSpinner,
			JSpinner segundosSpinner) {
		Date d = dateChooser.getDate();
		TimeStamp t = new TimeStamp(d);
		t.setHora((Integer) horasSpinner.getValue());
		t.setMinuto((Integer) minutosSpinner.getValue());
		t.setSegundo((Integer) segundosSpinner.getValue());
		return t;
	}

	public void mostrarResultadoVacia() {
		getMensajesAnterioresButton().setEnabled(false);
		getMensajesPosterioresButton().setEnabled(false);
		getNumMensajesValueLabel().setText("0");
		rellenarTabla();
		if (getCargaProgresoDialog().isVisible()) {
			getCargaProgresoDialog().setModalityType(ModalityType.MODELESS);
			getCargaProgresoDialog().dispose();
		}
	}

	public void mostrarResultado(List<Mensaje> resultado) {
		if (getCargaProgresoDialog().isVisible()) {
			getCargaProgresoDialog().setModalityType(ModalityType.MODELESS);
			getCargaProgresoDialog().dispose();
		}
		if (resultado.isEmpty()) {
			JOptionPane.showMessageDialog(getVentanaPrincipal(),
					getWord("no_message"), getWord("message"),
					JOptionPane.INFORMATION_MESSAGE);
			getMensajesAnterioresButton().setEnabled(false);
			getMensajesPosterioresButton().setEnabled(false);
		} else {
			rellenarTabla();
		}
	}

	public void mostrarResultado() {
		if (getCargaProgresoDialog().isVisible()) {
			getBarraCargaProgresoProgressBar().setValue(0);
			getCargaProgresoDialog().dispose();
		}
		rellenarTabla();
	}

	private JButton getBuscarTodosButton() {
		if (buscarTodosButton == null) {
			buscarTodosButton = new JButton();
			buscarTodosButton.setText(getWord("buscar_todos_memoria"));
			buscarTodosButton.setAction(getBuscarTodosAction());
		}
		return buscarTodosButton;
	}

	private AbstractAction getBuscarTodosAction() {
		if (buscarTodosAction == null) {
			buscarTodosAction = new AbstractAction(
					getWord("buscar_todos_memoria"), null) {
				public void actionPerformed(ActionEvent evt) {
					setListaBusqueda(getMain().getMensajes());
					rellenarTabla();
				}
			};
		}
		return buscarTodosAction;
	}

	private AbstractAction getIgnorarMensajesAction() {
		if (ignorarMensajesAction == null) {
			ignorarMensajesAction = new AbstractAction(
					getWord("ignorar_mensajes_de"), null) {
				public void actionPerformed(ActionEvent evt) {
					int column = getTablaMensajes().getSelectedColumn();
					if (column == 1) {
						operacion = new IgnorarMensajesIndividuoOperacion(
								getMain(), mensajeSeleccionado.getEmisor());
					} else {
						operacion = new IgnorarMensajesIndividuoOperacion(
								getMain(), mensajeSeleccionado.getReceptor());

					}
					ejecutarOperacion();
				}

			};
		}
		return ignorarMensajesAction;
	}

	private AbstractAction getMostrarMensajesSolamenteAction() {
		if (mostrarMensajesSolamenteAction == null) {
			mostrarMensajesSolamenteAction = new AbstractAction(
					getWord("mostrar_mensajes_solamente_de"), null) {
				public void actionPerformed(ActionEvent evt) {
					int column = getTablaMensajes().getSelectedColumn();
					if (column == 1) {
						operacion = new MostrarMensajesIndividuoOperacion(
								getMain(), mensajeSeleccionado.getEmisor());
					} else {
						operacion = new MostrarMensajesIndividuoOperacion(
								getMain(), mensajeSeleccionado.getReceptor());

					}
					ejecutarOperacion();
				}
			};
		}
		return mostrarMensajesSolamenteAction;
	}

	private AbstractAction getIgnorarMensajesDeLosGruposAction() {
		if (ignorarMensajesDeLosGruposAction == null) {
			ignorarMensajesDeLosGruposAction = new AbstractAction(
					getWord("ignorar_mensajes_grupos_pertenece"), null) {
				public void actionPerformed(ActionEvent evt) {
					int column = getTablaMensajes().getSelectedColumn();
					if (column == 1) {
						operacion = new IgnorarMensajesComunidadOperacion(
								getMain(), mensajeSeleccionado.getEmisor()
										.getGrupos());
					} else {
						operacion = new IgnorarMensajesComunidadOperacion(
								getMain(), mensajeSeleccionado.getReceptor()
										.getGrupos());

					}
					ejecutarOperacion();
				}
			};
		}
		return ignorarMensajesDeLosGruposAction;
	}

	private AbstractAction getAddNuevoGrupoAction() {
		if (addNuevoGrupoAction == null) {
			addNuevoGrupoAction = new AbstractAction("+", null) {
				public void actionPerformed(ActionEvent evt) {
					int grupos = getMain().getGrupos().size();
					String text = getAddNuevoGrupoTextField().getText();
					if (text != null && !text.equals("")) {
						getMain().addGrupoSuelto(new Grupo(text));
						if (grupos < getMain().getGrupos().size()) {
							((DefaultListModel) getGruposDisponiblesList()
									.getModel()).addElement(text);
						}
						getAddNuevoGrupoTextField().setText("");
					}
				}
			};
		}
		return addNuevoGrupoAction;
	}

	private AbstractAction getCancelAddUsuarioGrupoAction() {
		if (cancelAddUsuarioGrupoAction == null) {
			cancelAddUsuarioGrupoAction = new AbstractAction(
					getWord("cancelar"), null) {
				public void actionPerformed(ActionEvent evt) {
					getAddUsuarioGrupoDialog().dispose();
				}
			};
		}
		return cancelAddUsuarioGrupoAction;
	}

	private AbstractAction getAddGrupoAction() {
		if (addGrupoAction == null) {
			addGrupoAction = new AbstractAction(">", null) {
				public void actionPerformed(ActionEvent evt) {
					moverElementoList(getGruposDisponiblesList(),
							getGruposActualesList());
					getOkAddUsuarioGrupoButton().setEnabled(true);

				}
			};
		}
		return addGrupoAction;
	}

	private AbstractAction getBorrarGrupoAction() {
		if (borrarGrupoAction == null) {
			borrarGrupoAction = new AbstractAction("<", null) {
				public void actionPerformed(ActionEvent evt) {
					moverElementoList(getGruposActualesList(),
							getGruposDisponiblesList());
					getOkAddUsuarioGrupoButton().setEnabled(true);
				}
			};
		}
		return borrarGrupoAction;
	}

	private AbstractAction getOkAddUsuarioGrupoAction() {
		if (okAddUsuarioGrupoAction == null) {
			okAddUsuarioGrupoAction = new AbstractAction(getWord("ok"), null) {
				public void actionPerformed(ActionEvent evt) {
					List<Grupo> grupos = new LinkedList<Grupo>();
					for (int i = 0; i < ((DefaultListModel) getGruposActualesList()
							.getModel()).size(); i++) {
						grupos.add(new Grupo(
								((DefaultListModel) getGruposActualesList()
										.getModel()).elementAt(i).toString()));
					}
					getMain().addGruposMismoIndividuo(individuoSeleccionado,
							grupos);
					rellenarTabla();
					if (getAddUsuarioGrupoDialog().isVisible()) {
						getAddUsuarioGrupoDialog().dispose();
					}
				}
			};
		}
		return okAddUsuarioGrupoAction;
	}

	private AbstractAction getOcultarMensajesDeAction() {
		if (ocultarMensajesDeAction == null) {
			ocultarMensajesDeAction = new AbstractAction(
					getWord("ocultar_mensajes_enviados"), null) {
				public void actionPerformed(ActionEvent evt) {
					int column = getTablaMensajes().getSelectedColumn();
					if (column == 1) {
						operacion = new OcultarMensajesIndividuoOperacion(
								getMain(), mensajeSeleccionado.getEmisor());
					} else {
						operacion = new OcultarMensajesIndividuoOperacion(
								getMain(), mensajeSeleccionado.getReceptor());

					}
					ejecutarOperacion();
				}
			};
		}
		return ocultarMensajesDeAction;
	}

	private AbstractAction getMostrarMensajesAnterioresAction() {
		if (mostrarMensajesAnterioresAction == null) {
			mostrarMensajesAnterioresAction = new AbstractAction(
					getWord("mostrar_mensajes_anteriores"), null) {
				public void actionPerformed(ActionEvent evt) {
					TimeStamp t = mensajeSeleccionado.getTimestamp();
					List<Mensaje> resultado = getMain()
							.obtenerMensajesAnteriores(getListaBusqueda(), t);
					main.getInterfaz().setListaBusqueda(resultado);
					main.getInterfaz().mostrarResultado(resultado);
				}
			};
		}
		return mostrarMensajesAnterioresAction;
	}

	private AbstractAction getMostrarMensajesPosterioresAction() {
		if (mostrarMensajesPosterioresAction == null) {
			mostrarMensajesPosterioresAction = new AbstractAction(
					getWord("mostrar_mensajes_posteriores"), null) {
				public void actionPerformed(ActionEvent evt) {
					TimeStamp t = mensajeSeleccionado.getTimestamp();
					List<Mensaje> resultado = getMain()
							.obtenerMensajesPosteriores(getListaBusqueda(), t);
					main.getInterfaz().setListaBusqueda(resultado);
					main.getInterfaz().mostrarResultado(resultado);
				}
			};
		}
		return mostrarMensajesPosterioresAction;
	}

	//
	// private AbstractAction getCancelMostrarMensajesCercanosTiempoAction() {
	// if(cancelMostrarMensajesCercanosTiempoAction == null) {
	// cancelMostrarMensajesCercanosTiempoAction = new
	// AbstractAction(getWord("cancelar"), null) {
	// public void actionPerformed(ActionEvent evt) {
	// getMostrarMensajesCercanosTiempoDialog().dispose();
	// }
	// };
	// }
	// return cancelMostrarMensajesCercanosTiempoAction;
	// }

	// private AbstractAction getOkMostrarMensajesCercanosTiempoAction() {
	// if(okMostrarMensajesCercanosTiempoAction == null) {
	// okMostrarMensajesCercanosTiempoAction = new AbstractAction(getWord("ok"),
	// null) {
	// public void actionPerformed(ActionEvent evt) {
	// TimeStamp t = mensajeSeleccionado.getTimestamp();
	// }
	// };
	// }
	// return okMostrarMensajesCercanosTiempoAction;
	// }

	private AbstractAction getIgnorarMensajesComunidadAction() {
		if (ignorarMensajesComunidadAction == null) {
			ignorarMensajesComunidadAction = new AbstractAction(
					getWord("ignorar_mensajes_usuarios_pertenecientes"), null) {
				public void actionPerformed(ActionEvent evt) {
					int column = getTablaMensajes().getSelectedColumn();
					if (column == 2) {
						operacion = new IgnorarMensajesComunidadOperacion(
								getMain(), mensajeSeleccionado.getEmisor()
										.getGrupos());
					} else {
						operacion = new IgnorarMensajesComunidadOperacion(
								getMain(), mensajeSeleccionado.getReceptor()
										.getGrupos());
					}
					ejecutarOperacion();

				}
			};
		}
		return ignorarMensajesComunidadAction;
	}

	private AbstractAction getOcultarMensajesComunidadAction() {
		if (ocultarMensajesComunidadAction == null) {
			ocultarMensajesComunidadAction = new AbstractAction(
					getWord("ocultar_mensajes_usuarios_pertenecientes"), null) {
				public void actionPerformed(ActionEvent evt) {
					int column = getTablaMensajes().getSelectedColumn();
					if (column == 2) {
						operacion = new OcultarMensajesComunidadOperacion(
								getMain(), mensajeSeleccionado.getEmisor()
										.getGrupos());
					} else {
						operacion = new OcultarMensajesComunidadOperacion(
								getMain(), mensajeSeleccionado.getReceptor()
										.getGrupos());
					}
					ejecutarOperacion();
				}
			};
		}
		return ocultarMensajesComunidadAction;
	}

	private AbstractAction getMostrarMensajesComunidadAction() {
		if (mostrarMensajesComunidadAction == null) {
			mostrarMensajesComunidadAction = new AbstractAction(
					getWord("mostrar_solamente_mensajes_usuarios_pertenecientes"),
					null) {
				public void actionPerformed(ActionEvent evt) {
					int column = getTablaMensajes().getSelectedColumn();
					if (column == 2) {
						operacion = new MostrarMensajesComunidadOperacion(
								getMain(), mensajeSeleccionado.getEmisor()
										.getGrupos());
					} else {
						operacion = new MostrarMensajesComunidadOperacion(
								getMain(), mensajeSeleccionado.getReceptor()
										.getGrupos());
					}
					ejecutarOperacion();
				}

			};
		}
		return mostrarMensajesComunidadAction;
	}

	private AbstractAction getGuardarDatosAction() {
		if (guardarDatosAction == null) {
			guardarDatosAction = new AbstractAction(getWord("guardar_datos"),
					null) {
				public void actionPerformed(ActionEvent evt) {
					grabarDatos();
				}
			};
			guardarDatosAction.putValue(javax.swing.Action.ACCELERATOR_KEY,
					KeyStroke.getKeyStroke("ctrl pressed S"));
		}
		return guardarDatosAction;
	}

	protected void grabarDatos() {
		operacion = new GrabarBDOperacion(getMain());
		ejecutarOperacion();
	}

	protected void grabarDatosSalida() {
		operacion = new GrabarBDSalidaOperacion(getMain());
		ejecutarOperacion();
	}

	public void quit() {
		this.dispose();
		System.exit(0);

	}

	public void progresoGrabar() {
		getCargaProgresoLabel().setText(getWord("guardando"));
	}

	public void progresoBorrar() {
		getCargaProgresoLabel().setText(getWord("borrando"));
	}

	public void progresoCargar() {
		getCargaProgresoLabel().setText(getWord("carga"));
	}

	private JComboBox getTipoBusquedaComboBox() {
		if (tipoBusquedaComboBox == null) {
			ComboBoxModel tipoBusquedaComboBoxModel = new DefaultComboBoxModel(
					new String[] { getWord("contiene"), getWord("no_contiene"),
							getWord("empieza_por"), getWord("termina_por") });
			tipoBusquedaComboBox = new JComboBox();
			tipoBusquedaComboBox.setModel(tipoBusquedaComboBoxModel);
		}
		return tipoBusquedaComboBox;
	}

	private Campo getCampo() throws Exception {
		int valor = getBusquedaComboBox().getSelectedIndex();
		switch (valor) {
		case 0:
			return Campo.EMISOR;
		case 1:
			return Campo.DESTINATARIO;
		case 2:
			return Campo.TIMESTAMP;
		case 3:
			return Campo.MENSAJE;
		case 4:
			return Campo.ETIQUETAS;
		case 5:
			return Campo.GRUPOS;
		default:
			throw new Exception("Campo inválido");
		}
	}

	private Tipo getTipo() throws Exception {
		int valorCampo = getBusquedaComboBox().getSelectedIndex();
		int valorTipo = getTipoBusquedaComboBox().getSelectedIndex();
		if (valorCampo == 2)
			return Tipo.ENTRE;

		if (valorCampo == 0 || valorCampo == 1 || valorCampo == 3) {
			switch (valorTipo) {
			case 0:
				return Tipo.CONTIENE;
			case 1:
				return Tipo.NO_CONTIENE;
			case 2:
				return Tipo.EMPIEZA_POR;
			case 3:
				return Tipo.TERMINA_POR;
			}
		}
		if (valorCampo == 4 || valorCampo == 5) {
			switch (valorTipo) {
			case 0:
				return Tipo.CONTIENE;
			case 1:
				return Tipo.NO_CONTIENE;
			}
		}
		throw new Exception("Tipo inválido");
	}

	public void finalizarEntrenamiento(List<Mensaje> list, String categoria) {

		if (list.size() < 100) {
			Object[] options = { getWord("add_entrenamiento"),
					getWord("fin_entrenamiento") };
			int response = JOptionPane.showOptionDialog(this,
					getWord("mas_entrenamiento?"), getWord("entrenamiento"),
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, options, options[0]);
			if (response == JOptionPane.YES_OPTION) {
				addEntrenamientoManual(list, categoria);
			}
		}
	}

	private void addEntrenamientoManual(List<Mensaje> list, String categoria) {
		entrenados = new LinkedList<Mensaje>(list);
		getCategoriaNombreEntrenamientoManualLabel().setText(categoria);
		this.mensajeSeleccionado = seleccionarMensajeAleatorio(
				this.main.getMensajes(), this.entrenados);
		getTextoEntrenamienoManualTextArea().setText(
				this.mensajeSeleccionado.getTexto());
		abrirVentana(getEntrenamientoManualDialog());

	}

	//
	// private void addEntrenamientoManual(String categoria) {
	// entrenados = new LinkedList<Mensaje>(this.main.getListaBusqueda());
	// getCategoriaNombreEntrenamientoManualLabel().setText(categoria);
	// this.mensajeSeleccionado = seleccionarMensajeAleatorio(
	// this.main.getMensajes(), this.entrenados);
	// getTextoEntrenamienoManualTextArea().setText(
	// this.mensajeSeleccionado.getTexto());
	// abrirVentana(getEntrenamientoManualDialog());
	// }

	private Mensaje seleccionarMensajeAleatorio(List<Mensaje> todos,
			List<Mensaje> restriccion) {
		while (true) {
			Mensaje m = todos.get(new Random().nextInt(todos.size()));
			if (!restriccion.contains(m))
				return m;
		}
	}

	private JDialog getEntrenamientoManualDialog() {
		if (entrenamientoManualDialog == null) {
			entrenamientoManualDialog = new JDialog(this);
			GroupLayout entrenamientoManualDialogLayout = new GroupLayout(
					(JComponent) entrenamientoManualDialog.getContentPane());
			entrenamientoManualDialog.getContentPane().setLayout(
					entrenamientoManualDialogLayout);
			entrenamientoManualDialog.setSize(471, 242);
			entrenamientoManualDialog.setTitle(getWord("entrenamiento"));
			entrenamientoManualDialogLayout
					.setHorizontalGroup(entrenamientoManualDialogLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(entrenamientoManualDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getCategoriaEntrenamientoManualLabel(),
											GroupLayout.PREFERRED_SIZE, 66,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											getTextoEntrenamientoManualLabel(),
											GroupLayout.PREFERRED_SIZE, 66,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.UNRELATED)
							.add(entrenamientoManualDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getJScrollPane7(), 0, 369,
											Short.MAX_VALUE)
									.add(GroupLayout.LEADING,
											entrenamientoManualDialogLayout
													.createSequentialGroup()
													.add(getCategoriaNombreEntrenamientoManualLabel(),
															0, 94,
															Short.MAX_VALUE)
													.addPreferredGap(
															LayoutStyle.RELATED)
													.add(entrenamientoManualDialogLayout
															.createParallelGroup()
															.add(GroupLayout.LEADING,
																	getPreguntaEntrenamientoManualLabel(),
																	0,
																	269,
																	Short.MAX_VALUE)
															.add(GroupLayout.LEADING,
																	entrenamientoManualDialogLayout
																			.createSequentialGroup()
																			.addPreferredGap(
																					getPreguntaEntrenamientoManualLabel(),
																					getSiEntrenamientoManualButton(),
																					LayoutStyle.INDENT)
																			.add(getSiEntrenamientoManualButton(),
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.PREFERRED_SIZE)
																			.add(0,
																					16,
																					Short.MAX_VALUE)
																			.add(getNoEntrenamientoManualButton(),
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(
																					LayoutStyle.UNRELATED)
																			.add(getTerminarEntrenamientoManualButton(),
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.PREFERRED_SIZE)))))
							.addContainerGap());
			entrenamientoManualDialogLayout
					.setVerticalGroup(entrenamientoManualDialogLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(entrenamientoManualDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getPreguntaEntrenamientoManualLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getCategoriaEntrenamientoManualLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getCategoriaNombreEntrenamientoManualLabel(),
											GroupLayout.PREFERRED_SIZE, 14,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(entrenamientoManualDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											getJScrollPane7(),
											GroupLayout.PREFERRED_SIZE, 109,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											entrenamientoManualDialogLayout
													.createSequentialGroup()
													.add(getTextoEntrenamientoManualLabel(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE)
													.add(95)))
							.add(24)
							.add(entrenamientoManualDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getSiEntrenamientoManualButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getNoEntrenamientoManualButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getTerminarEntrenamientoManualButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addContainerGap(27, 27));
		}
		return entrenamientoManualDialog;
	}

	private JLabel getCategoriaEntrenamientoManualLabel() {
		if (categoriaEntrenamientoManualLabel == null) {
			categoriaEntrenamientoManualLabel = new JLabel();
			categoriaEntrenamientoManualLabel.setText(getWord("nombre"));
		}
		return categoriaEntrenamientoManualLabel;
	}

	private JLabel getTextoEntrenamientoManualLabel() {
		if (textoEntrenamientoManualLabel == null) {
			textoEntrenamientoManualLabel = new JLabel();
			textoEntrenamientoManualLabel.setText(getWord("texto"));
		}
		return textoEntrenamientoManualLabel;
	}

	private JTextArea getTextoEntrenamienoManualTextArea() {
		if (textoEntrenamienoManualTextArea == null) {
			textoEntrenamienoManualTextArea = new JTextArea();
			textoEntrenamienoManualTextArea
					.setPreferredSize(new java.awt.Dimension(340, 106));
			textoEntrenamienoManualTextArea.setWrapStyleWord(true);
			textoEntrenamienoManualTextArea.setLineWrap(true);
			textoEntrenamienoManualTextArea.setEditable(false);

		}
		return textoEntrenamienoManualTextArea;
	}

	private JScrollPane getJScrollPane7() {
		if (jScrollPane7 == null) {
			jScrollPane7 = new JScrollPane();
			jScrollPane7.setViewportView(getTextoEntrenamienoManualTextArea());
		}
		return jScrollPane7;
	}

	private JButton getTerminarEntrenamientoManualButton() {
		if (terminarEntrenamientoManualButton == null) {
			terminarEntrenamientoManualButton = new JButton();
			terminarEntrenamientoManualButton
					.setText(getWord("terminar_entrenamiento"));
			terminarEntrenamientoManualButton
					.setAction(getTerminarEntrenamientoManualAction());
		}
		return terminarEntrenamientoManualButton;
	}

	private AbstractAction getTerminarEntrenamientoManualAction() {
		if (terminarEntrenamientoManualAction == null) {
			terminarEntrenamientoManualAction = new AbstractAction(
					getWord("terminar_entrenamiento"), null) {
				public void actionPerformed(ActionEvent evt) {
					getEntrenamientoManualDialog().dispose();
				}
			};
		}
		return terminarEntrenamientoManualAction;
	}

	private JButton getNoEntrenamientoManualButton() {
		if (noEntrenamientoManualButton == null) {
			noEntrenamientoManualButton = new JButton();
			noEntrenamientoManualButton.setText(getWord("no"));
			noEntrenamientoManualButton
					.setAction(getNoEntrenamientoManualAction());
		}
		return noEntrenamientoManualButton;
	}

	private AbstractAction getNoEntrenamientoManualAction() {
		if (noEntrenamientoManualAction == null) {
			noEntrenamientoManualAction = new AbstractAction(getWord("no"),
					null) {
				public void actionPerformed(ActionEvent evt) {
					siguienteEntrenamientoManual();
				}
			};
		}
		return noEntrenamientoManualAction;
	}

	private JButton getSiEntrenamientoManualButton() {
		if (siEntrenamientoManualButton == null) {
			siEntrenamientoManualButton = new JButton();
			siEntrenamientoManualButton.setText(getWord("si"));
			siEntrenamientoManualButton
					.setAction(getSiEntrenamientoManualAction());
		}
		return siEntrenamientoManualButton;
	}

	private AbstractAction getSiEntrenamientoManualAction() {
		if (siEntrenamientoManualAction == null) {
			siEntrenamientoManualAction = new AbstractAction(getWord("si"),
					null) {
				public void actionPerformed(ActionEvent evt) {
					getMain().getClasificador().entrenar(
							mensajeSeleccionado,
							getCategoriaNombreEntrenamientoManualLabel()
									.getText());
					siguienteEntrenamientoManual();
				}
			};
		}
		return siEntrenamientoManualAction;
	}

	private JLabel getPreguntaEntrenamientoManualLabel() {
		if (preguntaEntrenamientoManualLabel == null) {
			preguntaEntrenamientoManualLabel = new JLabel();
			preguntaEntrenamientoManualLabel.setText(getWord("pertenece?"));
		}
		return preguntaEntrenamientoManualLabel;
	}

	private void siguienteEntrenamientoManual() {
		entrenados.add(mensajeSeleccionado);
		mensajeSeleccionado = seleccionarMensajeAleatorio(getMain()
				.getMensajes(), entrenados);
		getTextoEntrenamienoManualTextArea().setText(
				mensajeSeleccionado.getTexto());
	}

	private JLabel getCategoriaNombreEntrenamientoManualLabel() {
		if (categoriaNombreEntrenamientoManualLabel == null) {
			categoriaNombreEntrenamientoManualLabel = new JLabel();
			categoriaNombreEntrenamientoManualLabel.setText("jLabel4");
		}
		return categoriaNombreEntrenamientoManualLabel;
	}

	private JDialog getAplicarFiltroDialog() {
		if (aplicarFiltroDialog == null) {
			aplicarFiltroDialog = new JDialog(this);
			aplicarFiltroDialog.setTitle(getWord("aplicar_filtro"));
			GroupLayout aplicarFiltroDialogLayout = new GroupLayout(
					(JComponent) aplicarFiltroDialog.getContentPane());
			aplicarFiltroDialog.getContentPane().setLayout(
					aplicarFiltroDialogLayout);
			aplicarFiltroDialog.setPreferredSize(new java.awt.Dimension(454,
					222));
			aplicarFiltroDialog.setSize(454, 222);
			aplicarFiltroDialogLayout
					.setHorizontalGroup(aplicarFiltroDialogLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(aplicarFiltroDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											aplicarFiltroDialogLayout
													.createSequentialGroup()
													.add(getCategoriaAplicarFiltroLabel(),
															GroupLayout.PREFERRED_SIZE,
															49,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.RELATED)
													.add(getCategoriaAplicarFiltroComboBox(),
															GroupLayout.PREFERRED_SIZE,
															90,
															GroupLayout.PREFERRED_SIZE)
													.add(0, 83, Short.MAX_VALUE))
									.add(GroupLayout.LEADING,
											aplicarFiltroDialogLayout
													.createSequentialGroup()
													.add(getAccionAplicarFiltroLabel(),
															GroupLayout.PREFERRED_SIZE,
															99,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.RELATED)
													.add(aplicarFiltroDialogLayout
															.createParallelGroup()
															.add(GroupLayout.LEADING,
																	getTipoAplicarFiltroComboBox(),
																	0,
																	123,
																	Short.MAX_VALUE)
															.add(GroupLayout.LEADING,
																	aplicarFiltroDialogLayout
																			.createSequentialGroup()
																			.add(30)
																			.add(getAddMiembroClaseAplicarFiltroLabel(),
																					GroupLayout.PREFERRED_SIZE,
																					93,
																					GroupLayout.PREFERRED_SIZE)
																			.add(0,
																					0,
																					Short.MAX_VALUE)))))
							.addPreferredGap(LayoutStyle.RELATED)
							.add(aplicarFiltroDialogLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											aplicarFiltroDialogLayout
													.createSequentialGroup()
													.add(getOkAplicarFiltroButton(),
															GroupLayout.PREFERRED_SIZE,
															90,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.UNRELATED)
													.add(getCancelarAplicarFiltroButton(),
															GroupLayout.PREFERRED_SIZE,
															90,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.RELATED))
									.add(aplicarFiltroDialogLayout
											.createSequentialGroup()
											.addPreferredGap(
													getOkAplicarFiltroButton(),
													getMiembroClaseAplicarFiltroComboBox(),
													LayoutStyle.INDENT)
											.add(aplicarFiltroDialogLayout
													.createParallelGroup()
													.add(aplicarFiltroDialogLayout
															.createSequentialGroup()
															.add(getMiembroClaseAplicarFiltroComboBox(),
																	GroupLayout.PREFERRED_SIZE,
																	180,
																	GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(
																	LayoutStyle.RELATED))
													.add(GroupLayout.LEADING,
															aplicarFiltroDialogLayout
																	.createSequentialGroup()
																	.add(getAddMiembroClaseAplicarFiltroTextField(),
																			GroupLayout.PREFERRED_SIZE,
																			132,
																			GroupLayout.PREFERRED_SIZE)
																	.addPreferredGap(
																			LayoutStyle.RELATED)
																	.add(getAddMiembroClaseAplicarFiltroButton(),
																			GroupLayout.PREFERRED_SIZE,
																			44,
																			GroupLayout.PREFERRED_SIZE)))))
							.addContainerGap());
			aplicarFiltroDialogLayout.linkSize(new Component[] {
					getOkAplicarFiltroButton(),
					getCancelarAplicarFiltroButton() }, GroupLayout.HORIZONTAL);
			aplicarFiltroDialogLayout
					.setVerticalGroup(aplicarFiltroDialogLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(aplicarFiltroDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getCategoriaAplicarFiltroComboBox(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getCategoriaAplicarFiltroLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.add(22)
							.add(aplicarFiltroDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getMiembroClaseAplicarFiltroComboBox(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getTipoAplicarFiltroComboBox(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getAccionAplicarFiltroLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.UNRELATED)
							.add(aplicarFiltroDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getAddMiembroClaseAplicarFiltroButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getAddMiembroClaseAplicarFiltroTextField(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getAddMiembroClaseAplicarFiltroLabel(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.add(0, 43, Short.MAX_VALUE)
							.add(aplicarFiltroDialogLayout
									.createParallelGroup(GroupLayout.BASELINE)
									.add(GroupLayout.BASELINE,
											getOkAplicarFiltroButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.BASELINE,
											getCancelarAplicarFiltroButton(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addContainerGap());
		}
		return aplicarFiltroDialog;
	}

	private JLabel getAccionAplicarFiltroLabel() {
		if (accionAplicarFiltroLabel == null) {
			accionAplicarFiltroLabel = new JLabel();
			accionAplicarFiltroLabel.setText(getWord("seleccionar_accion")
					+ ":");
			accionAplicarFiltroLabel
					.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return accionAplicarFiltroLabel;
	}

	private JLabel getAddMiembroClaseAplicarFiltroLabel() {
		if (addMiembroClaseAplicarFiltroLabel == null) {
			addMiembroClaseAplicarFiltroLabel = new JLabel();
			addMiembroClaseAplicarFiltroLabel.setText(getWord("add") + ":");
			addMiembroClaseAplicarFiltroLabel
					.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return addMiembroClaseAplicarFiltroLabel;
	}

	private JLabel getCategoriaAplicarFiltroLabel() {
		if (categoriaAplicarFiltroLabel == null) {
			categoriaAplicarFiltroLabel = new JLabel();
			categoriaAplicarFiltroLabel.setText(getWord("nombre"));
		}
		return categoriaAplicarFiltroLabel;
	}

	private JComboBox getCategoriaAplicarFiltroComboBox() {
		if (categoriaAplicarFiltroComboBox == null) {
			ComboBoxModel categoriaAplicarFiltroComboBoxModel = new DefaultComboBoxModel(
					this.main.getCategoriasFiltro());
			categoriaAplicarFiltroComboBox = new JComboBox();
			categoriaAplicarFiltroComboBox
					.setModel(categoriaAplicarFiltroComboBoxModel);
			if (categoriaAplicarFiltroComboBoxModel.getSize() == 0)
				categoriaAplicarFiltroComboBox.setEnabled(false);
		}
		return categoriaAplicarFiltroComboBox;
	}

	private JComboBox getTipoAplicarFiltroComboBox() {
		if (tipoAplicarFiltroComboBox == null) {
			ComboBoxModel tipoAplicarFiltroComboBoxModel = new DefaultComboBoxModel(
					new String[] { getWord("tags"), getWord("desde_pertenece"),
							getWord("para_pertenece") });
			tipoAplicarFiltroComboBox = new JComboBox();
			tipoAplicarFiltroComboBox.setModel(tipoAplicarFiltroComboBoxModel);
			tipoAplicarFiltroComboBox.setAction(getTipoAplicarFiltroAction());
		}
		return tipoAplicarFiltroComboBox;
	}

	private AbstractAction getTipoAplicarFiltroAction() {
		if (tipoAplicarFiltroAction == null) {
			tipoAplicarFiltroAction = new AbstractAction("", null) {
				public void actionPerformed(ActionEvent evt) {
					if (getTipoAplicarFiltroComboBox().getSelectedIndex() == 0) {
						getMiembroClaseAplicarFiltroComboBox().setModel(
								new DefaultComboBoxModel(getMain()
										.getEtiquetas().toArray()));
					} else {
						getMiembroClaseAplicarFiltroComboBox().setModel(
								new DefaultComboBoxModel(getMain().getGrupos()
										.toArray()));
					}
					getMiembroClaseAplicarFiltroComboBox().setEnabled(true);
					getOkAplicarFiltroButton().setEnabled(true);
					if (getMiembroClaseAplicarFiltroComboBox().getModel()
							.getSize() == 0) {
						getMiembroClaseAplicarFiltroComboBox()
								.setEnabled(false);
						getOkAplicarFiltroButton().setEnabled(false);
					}
				}
			};
		}
		return tipoAplicarFiltroAction;
	}

	private JComboBox getMiembroClaseAplicarFiltroComboBox() {
		if (miembroClaseAplicarFiltroComboBox == null) {
			ComboBoxModel miemboClaseAplicarFiltroComboBoxModel = new DefaultComboBoxModel();
			miembroClaseAplicarFiltroComboBox = new JComboBox();
			miembroClaseAplicarFiltroComboBox
					.setModel(miemboClaseAplicarFiltroComboBoxModel);
		}
		return miembroClaseAplicarFiltroComboBox;
	}

	private JTextField getAddMiembroClaseAplicarFiltroTextField() {
		if (addMiembroClaseAplicarFiltroTextField == null) {
			addMiembroClaseAplicarFiltroTextField = new JTextField();
			addMiembroClaseAplicarFiltroTextField
					.addKeyListener(new KeyAdapter() {

						@Override
						public void keyReleased(KeyEvent e) {
							if (addMiembroClaseAplicarFiltroTextField.getText()
									.equals("")) {
								getAddMiembroClaseAplicarFiltroButton()
										.setEnabled(false);
							} else {
								getAddMiembroClaseAplicarFiltroButton()
										.setEnabled(true);
							}
						}
					});
		}
		return addMiembroClaseAplicarFiltroTextField;
	}

	private JButton getAddMiembroClaseAplicarFiltroButton() {
		if (addMiembroClaseAplicarFiltroButton == null) {
			addMiembroClaseAplicarFiltroButton = new JButton();
			addMiembroClaseAplicarFiltroButton.setText("+");
			addMiembroClaseAplicarFiltroButton.setEnabled(false);
			addMiembroClaseAplicarFiltroButton
					.setAction(getAddMiembroClaseAplicarFiltroAction());
		}
		return addMiembroClaseAplicarFiltroButton;
	}

	private AbstractAction getAddMiembroClaseAplicarFiltroAction() {
		if (addMiembroClaseAplicarFiltroAction == null) {
			addMiembroClaseAplicarFiltroAction = new AbstractAction("+", null) {
				public void actionPerformed(ActionEvent evt) {
					if (getTipoAplicarFiltroComboBox().getSelectedIndex() == 0) {
						getMain()
								.addEtiquetaSuelta(
										new Etiqueta(
												getAddMiembroClaseAplicarFiltroTextField()
														.getText()));
					} else {
						getMain()
								.addGrupoSuelto(
										new Grupo(
												getAddMiembroClaseAplicarFiltroTextField()
														.getText()));
					}
					recargarMiembroClaseAddFiltroComboBox();
					getAddMiembroClaseAplicarFiltroTextField().setText("");
					getOkAplicarFiltroButton().setEnabled(true);
				}
			};
		}
		return addMiembroClaseAplicarFiltroAction;
	}

	protected void recargarMiembroClaseAddFiltroComboBox() {
		if (getTipoAplicarFiltroComboBox().getSelectedIndex() == 0) {
			getMiembroClaseAplicarFiltroComboBox()
					.setModel(
							new DefaultComboBoxModel(this.main.getEtiquetas()
									.toArray()));
		} else {
			getMiembroClaseAplicarFiltroComboBox().setModel(
					new DefaultComboBoxModel(this.main.getGrupos().toArray()));

		}
		getMiembroClaseAplicarFiltroComboBox().setEnabled(true);

	}

	private JButton getCancelarAplicarFiltroButton() {
		if (cancelarAplicarFiltroButton == null) {
			cancelarAplicarFiltroButton = new JButton();
			cancelarAplicarFiltroButton.setText(getWord("cancelar"));
			cancelarAplicarFiltroButton
					.setAction(getCancelarAplicarFiltroAction());
		}
		return cancelarAplicarFiltroButton;
	}

	private AbstractAction getCancelarAplicarFiltroAction() {
		if (cancelarAplicarFiltroAction == null) {
			cancelarAplicarFiltroAction = new AbstractAction(
					getWord("cancelar"), null) {
				public void actionPerformed(ActionEvent evt) {
					getAplicarFiltroDialog().dispose();
				}
			};
		}
		return cancelarAplicarFiltroAction;
	}

	private JButton getOkAplicarFiltroButton() {
		if (okAplicarFiltroButton == null) {
			okAplicarFiltroButton = new JButton();
			okAplicarFiltroButton.setText(getWord("ok"));
			okAplicarFiltroButton.setAction(getOkAplicarFiltroAction());
		}
		return okAplicarFiltroButton;
	}

	private AbstractAction getOkAplicarFiltroAction() {
		if (okAplicarFiltroAction == null) {
			okAplicarFiltroAction = new AbstractAction(getWord("ok"), null) {
				public void actionPerformed(ActionEvent evt) {
					String categoria = getCategoriaAplicarFiltroComboBox()
							.getModel()
							.getElementAt(
									getCategoriaAplicarFiltroComboBox()
											.getSelectedIndex()).toString();
					switch (getTipoAplicarFiltroComboBox().getSelectedIndex()) {
					case 0:
						operacion = new EtiquetarAplicarFiltroOperacion(
								getMain(),
								categoria,
								new Etiqueta(
										getMiembroClaseAplicarFiltroComboBox()
												.getModel()
												.getElementAt(
														getMiembroClaseAplicarFiltroComboBox()
																.getSelectedIndex())
												.toString()));

						break;
					case 1:
						operacion = new AddGrupoEmisorAplicarFiltroOperacion(
								getMain(),
								categoria,
								new Grupo(
										getMiembroClaseAplicarFiltroComboBox()
												.getModel()
												.getElementAt(
														getMiembroClaseAplicarFiltroComboBox()
																.getSelectedIndex())
												.toString()));
						break;
					default:
						operacion = new AddGrupoReceptorAplicarFiltroOperacion(
								getMain(),
								categoria,
								new Grupo(
										getMiembroClaseAplicarFiltroComboBox()
												.getModel()
												.getElementAt(
														getMiembroClaseAplicarFiltroComboBox()
																.getSelectedIndex())
												.toString()));
						break;
					}
					ejecutarOperacion(getAplicarFiltroDialog());
				}
			};
		}
		return okAplicarFiltroAction;
	}

	private AbstractAction getCancelBuscarMensajesSimilaresAction() {
		if (cancelBuscarMensajesSimilaresAction == null) {
			cancelBuscarMensajesSimilaresAction = new AbstractAction(
					getWord("cancelar"), null) {
				public void actionPerformed(ActionEvent evt) {
					getBuscarMensajesSimilaresDialog().dispose();
				}
			};
		}
		return cancelBuscarMensajesSimilaresAction;
	}

	private JComboBox getNombreEtiquetaEtiquetadoMediantePatronComboBox() {
		if (nombreEtiquetaEtiquetadoMediantePatronComboBox == null) {
			ComboBoxModel nombreEtiquetaEtiquetadoMediantePatronComboBoxModel = new DefaultComboBoxModel();
			nombreEtiquetaEtiquetadoMediantePatronComboBox = new JComboBox();
			nombreEtiquetaEtiquetadoMediantePatronComboBox
					.setModel(nombreEtiquetaEtiquetadoMediantePatronComboBoxModel);
		}
		return nombreEtiquetaEtiquetadoMediantePatronComboBox;
	}

	private JButton getAddEtiquetaEtiquetadoMediantePatronButton() {
		if (addEtiquetaEtiquetadoMediantePatronButton == null) {
			addEtiquetaEtiquetadoMediantePatronButton = new JButton();
			addEtiquetaEtiquetadoMediantePatronButton.setText("+");
			addEtiquetaEtiquetadoMediantePatronButton
					.setAction(getAddEtiquetaEtiquetadoMediantePatronAction());
			addEtiquetaEtiquetadoMediantePatronButton.setEnabled(false);
		}
		return addEtiquetaEtiquetadoMediantePatronButton;
	}

	private AbstractAction getAddEtiquetaEtiquetadoMediantePatronAction() {
		if (addEtiquetaEtiquetadoMediantePatronAction == null) {
			addEtiquetaEtiquetadoMediantePatronAction = new AbstractAction("+",
					null) {
				public void actionPerformed(ActionEvent evt) {
					Etiqueta e = new Etiqueta(
							getNombreFiltroEtiquetadoMediantePatronTextField()
									.getText());
					getMain().addEtiquetaSuelta(e);
					getNombreEtiquetaEtiquetadoMediantePatronComboBox()
							.setModel(
									new DefaultComboBoxModel(getMain()
											.getEtiquetas().toArray()));
					getNombreFiltroEtiquetadoMediantePatronTextField().setText(
							"");
					getAddEtiquetaEtiquetadoMediantePatronButton().setEnabled(
							false);
					getNombreEtiquetaEtiquetadoMediantePatronComboBox()
							.setEnabled(true);
					if (getPatronesSeleccionadosEtiquetadoMediantePatronTable()
							.getModel().getRowCount() > 0)
						getNextEtiquetadoMediantePatronButton()
								.setEnabled(true);
				}
			};
		}
		return addEtiquetaEtiquetadoMediantePatronAction;
	}

	private JTextField getAddEtiquetaEtiquetarSimilaresTextField() {
		if (addEtiquetaEtiquetarSimilaresTextField == null) {
			addEtiquetaEtiquetarSimilaresTextField = new JTextField();
			addEtiquetaEtiquetarSimilaresTextField
					.addKeyListener(new KeyAdapter() {
						@Override
						public void keyReleased(KeyEvent e) {
							if (addEtiquetaEtiquetarSimilaresTextField
									.getText().equals("")) {
								getAddEtiquetaEtiquetarSimilaresButton()
										.setEnabled(false);
							} else {
								getAddEtiquetaEtiquetarSimilaresButton()
										.setEnabled(true);
							}
						}
					});
		}
		return addEtiquetaEtiquetarSimilaresTextField;
	}

	private JButton getAddEtiquetaEtiquetarSimilaresButton() {
		if (addEtiquetaEtiquetarSimilaresButton == null) {
			addEtiquetaEtiquetarSimilaresButton = new JButton();
			addEtiquetaEtiquetarSimilaresButton.setText("+");
			addEtiquetaEtiquetarSimilaresButton
					.setAction(getAddEtiquetaEtiquetarSimilaresAction());
			addEtiquetaEtiquetarSimilaresButton.setEnabled(false);
		}
		return addEtiquetaEtiquetarSimilaresButton;
	}

	private AbstractAction getAddEtiquetaEtiquetarSimilaresAction() {
		if (addEtiquetaEtiquetarSimilaresAction == null) {
			addEtiquetaEtiquetarSimilaresAction = new AbstractAction("+", null) {
				public void actionPerformed(ActionEvent evt) {
					if (!getEtiquetaSeleccionadaEtiquetarSimilaresLabel()
							.getText().equals(getWord("grupo"))) {
						getMain()
								.addEtiquetaSuelta(
										new Etiqueta(
												getAddEtiquetaEtiquetarSimilaresTextField()
														.getText()));
						getEtiquetaSeleccionadaEtiquetarSimilaresComboBox()
								.setModel(
										new DefaultComboBoxModel(getMain()
												.getEtiquetas().toArray()));
					} else {
						getMain()
								.addGrupoSuelto(
										new Grupo(
												getAddEtiquetaEtiquetarSimilaresTextField()
														.getText()));
						getEtiquetaSeleccionadaEtiquetarSimilaresComboBox()
								.setModel(
										new DefaultComboBoxModel(getMain()
												.getGrupos().toArray()));
					}
					getEtiquetaSeleccionadaEtiquetarSimilaresComboBox()
							.setEnabled(true);
					getOkEtiquetarSimilaresButton().setEnabled(true);
					getAddEtiquetaEtiquetarSimilaresTextField().setText("");
					getAddEtiquetaEtiquetarSimilaresButton().setEnabled(false);
				}
			};
		}
		return addEtiquetaEtiquetarSimilaresAction;
	}

	private JLabel getAddNuevoGrupoMismasTagsLabel() {
		if (addNuevoGrupoMismasTagsLabel == null) {
			addNuevoGrupoMismasTagsLabel = new JLabel();
			addNuevoGrupoMismasTagsLabel.setText(getWord("add"));
		}
		return addNuevoGrupoMismasTagsLabel;
	}

	private JTextField getAddNuevoGrupoMismasTagsTextField() {
		if (addNuevoGrupoMismasTagsTextField == null) {
			addNuevoGrupoMismasTagsTextField = new JTextField();
			addNuevoGrupoMismasTagsTextField.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					if (addNuevoGrupoMismasTagsTextField.getText().equals("")) {
						getAddNuevoGrupoMismasTagsButton().setEnabled(false);
					} else {
						getAddNuevoGrupoMismasTagsButton().setEnabled(true);
					}
				};
			});
		}
		return addNuevoGrupoMismasTagsTextField;
	}

	private JButton getAddNuevoGrupoMismasTagsButton() {
		if (addNuevoGrupoMismasTagsButton == null) {
			addNuevoGrupoMismasTagsButton = new JButton();
			addNuevoGrupoMismasTagsButton.setText("+");
			addNuevoGrupoMismasTagsButton.setEnabled(false);
			addNuevoGrupoMismasTagsButton
					.setAction(getAddNuevoGrupoMismasTagsAction());
		}
		return addNuevoGrupoMismasTagsButton;
	}

	private AbstractAction getAddNuevoGrupoMismasTagsAction() {
		if (addNuevoGrupoMismasTagsAction == null) {
			addNuevoGrupoMismasTagsAction = new AbstractAction("+", null) {
				public void actionPerformed(ActionEvent evt) {
					crearAddNuevoGrupoMismasTags();
				}
			};
		}
		return addNuevoGrupoMismasTagsAction;
	}

	private void crearAddNuevoGrupoMismasTags() {
		if (!getAddNuevoGrupoMismasTagsTextField().getText().equals("")) {
			int n = getMain().getGrupos().size();
			Grupo g = new Grupo(getAddNuevoGrupoMismasTagsTextField().getText());
			getMain().addGrupoSuelto(g);
			if (n < getMain().getGrupos().size()) {
				((DefaultListModel) getGruposDisponiblesAddGrupoUsuariosMismasTagsList()
						.getModel()).addElement(g.toString());
				getAddNuevoGrupoMismasTagsTextField().setText("");
			}
		}
		getAddNuevoGrupoMismasTagsButton().setEnabled(false);
	}

	private JDialog getCargaProgresoDialog() {
		if (cargaProgresoDialog == null) {
			cargaProgresoDialog = new JDialog(this);
			cargaProgresoDialog.getContentPane().add(getCargaProgresoPanel(),
					BorderLayout.CENTER);
			cargaProgresoDialog.setTitle(getWord("progreso"));
			cargaProgresoDialog.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			cargaProgresoDialog.setModalityType(ModalityType.DOCUMENT_MODAL);
			cargaProgresoDialog.setResizable(false);
		}
		return cargaProgresoDialog;
	}

	private JPanel getCargaProgresoPanel() {
		if (cargaProgresoPanel == null) {
			crearCargaProgresoPanel();
		}
		return cargaProgresoPanel;
	}

	private void crearCargaProgresoPanel() {
		cargaProgresoPanel = new JPanel();
		GroupLayout cargaProgresoPanelLayout = new GroupLayout(
				(JComponent) cargaProgresoPanel);
		cargaProgresoPanel.setLayout(cargaProgresoPanelLayout);
		cargaProgresoPanelLayout.setHorizontalGroup(cargaProgresoPanelLayout
				.createSequentialGroup()
				.addContainerGap()
				.add(cargaProgresoPanelLayout
						.createParallelGroup()
						.add(GroupLayout.LEADING,
								getBarraCargaProgresoProgressBar(), 0, 369,
								Short.MAX_VALUE)
						.add(GroupLayout.LEADING,
								cargaProgresoPanelLayout
										.createSequentialGroup()
										.add(getCargaProgresoLabel(),
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.add(0, 335, Short.MAX_VALUE)))
				.addContainerGap());
		cargaProgresoPanelLayout.setVerticalGroup(cargaProgresoPanelLayout
				.createSequentialGroup()
				.addContainerGap(42, Short.MAX_VALUE)
				.add(getCargaProgresoLabel(), GroupLayout.PREFERRED_SIZE,
						GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.UNRELATED)
				.add(getBarraCargaProgresoProgressBar(),
						GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE,
						GroupLayout.PREFERRED_SIZE).addContainerGap(57, 57));
	}

	private JProgressBar getBarraCargaProgresoProgressBar() {
		if (barraCargaProgresoProgressBar == null) {
			barraCargaProgresoProgressBar = new JProgressBar();
		}
		return barraCargaProgresoProgressBar;
	}

	private JLabel getCargaProgresoLabel() {
		if (cargaProgresoLabel == null) {
			cargaProgresoLabel = new JLabel();
			cargaProgresoLabel.setText(getWord("carga"));
		}
		return cargaProgresoLabel;
	}

	/**
	 * Cambia de estado la barra de progreso
	 * 
	 * @param indeterminado
	 *            si es true, la barra de progreso pasa a estado indeterminado y
	 *            si es false a estado determinado
	 */
	public void setProgresoIndeterminado(boolean indeterminado) {
		getBarraCargaProgresoProgressBar().setIndeterminate(indeterminado);
	}

	/**
	 * Cambia el valor de la barra de progreso
	 * 
	 * @param integer
	 *            el nuevo valor de la barra de progreso
	 */
	public void actualizarValorProgreso(Integer integer) {
		getBarraCargaProgresoProgressBar().setValue(integer);

	}

	/**
	 * prepara la barra de progreso para la operación, la pone en modo
	 * determinado, selecciona el máximo valor y pone el valor actual a cero.
	 * 
	 * @param size
	 */
	public void seleccionarMaxTareaProgreso(int size) {
		getBarraCargaProgresoProgressBar().setIndeterminate(false);
		getBarraCargaProgresoProgressBar().setMaximum(size);
		getBarraCargaProgresoProgressBar().setValue(0);

	}

	private AbstractAction getCancelAddGrupoUsuariosMismasTagsAction() {
		if (cancelAddGrupoUsuariosMismasTagsAction == null) {
			cancelAddGrupoUsuariosMismasTagsAction = new AbstractAction(
					getWord("cancelar"), null) {
				public void actionPerformed(ActionEvent evt) {
					getAddGrupoUsuariosMismasTagsDialog().dispose();
				}
			};
		}
		return cancelAddGrupoUsuariosMismasTagsAction;
	}

	private JLabel getEtiquetasDisponiblesEtiquetarMensajeLabel() {
		if (etiquetasDisponiblesEtiquetarMensajeLabel == null) {
			etiquetasDisponiblesEtiquetarMensajeLabel = new JLabel();
			etiquetasDisponiblesEtiquetarMensajeLabel
					.setText(getWord("etiquetas_disponibles"));
			etiquetasDisponiblesEtiquetarMensajeLabel
					.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return etiquetasDisponiblesEtiquetarMensajeLabel;
	}

	private JLabel getEtiquetasActualesEtiquetarMensajeLabel() {
		if (etiquetasActualesEtiquetarMensajeLabel == null) {
			etiquetasActualesEtiquetarMensajeLabel = new JLabel();
			etiquetasActualesEtiquetarMensajeLabel
					.setText(getWord("etiquetas_seleccionadas"));
			etiquetasActualesEtiquetarMensajeLabel
					.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return etiquetasActualesEtiquetarMensajeLabel;
	}

	private JLabel getPatronesDisponiblesLabel() {
		if (patronesDisponiblesLabel == null) {
			patronesDisponiblesLabel = new JLabel();
			patronesDisponiblesLabel.setText(getWord("patrones_disponibles"));
			patronesDisponiblesLabel
					.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return patronesDisponiblesLabel;
	}

	private JLabel getPatronesSeleccionadosLabel() {
		if (patronesSeleccionadosLabel == null) {
			patronesSeleccionadosLabel = new JLabel();
			patronesSeleccionadosLabel
					.setText(getWord("patrones_seleccionados"));
			patronesSeleccionadosLabel
					.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return patronesSeleccionadosLabel;
	}

	private JDialog getPreviewAlgoritmoDialog() {
		if (previewAlgoritmoDialog == null) {
			previewAlgoritmoDialog = new JDialog(this);
			previewAlgoritmoDialog.setSize(507, 317);
			previewAlgoritmoDialog.setTitle(getWord("ayuda"));
			previewAlgoritmoDialog.setPreferredSize(new java.awt.Dimension(507,
					317));
			previewAlgoritmoDialog.getContentPane().add(
					getPreviewAlgoritmoPanel(), BorderLayout.CENTER);
		}
		return previewAlgoritmoDialog;
	}

	private JPanel getPreviewAlgoritmoPanel() {
		if (previewAlgoritmoPanel == null) {
			previewAlgoritmoPanel = new JPanel();
			GroupLayout previewAlgoritmoPanelLayout = new GroupLayout(
					(JComponent) previewAlgoritmoPanel);
			previewAlgoritmoPanel.setLayout(previewAlgoritmoPanelLayout);
			previewAlgoritmoPanel.setPreferredSize(new java.awt.Dimension(404,
					234));
			previewAlgoritmoPanelLayout
					.setHorizontalGroup(previewAlgoritmoPanelLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(previewAlgoritmoPanelLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING,
											previewAlgoritmoPanelLayout
													.createSequentialGroup()
													.add(getJLabel4x(),
															GroupLayout.PREFERRED_SIZE,
															61,
															GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(
															LayoutStyle.UNRELATED)
													.add(getNombreAlgoritmoLabel(),
															GroupLayout.PREFERRED_SIZE,
															132,
															GroupLayout.PREFERRED_SIZE)
													.add(0, 197,
															Short.MAX_VALUE)
													.add(getOkPreviewAlgoritmoButton(),
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE,
															GroupLayout.PREFERRED_SIZE))
									.add(GroupLayout.LEADING,
											getJScrollPane8(), 0, 471,
											Short.MAX_VALUE)).addContainerGap());
			previewAlgoritmoPanelLayout
					.setVerticalGroup(previewAlgoritmoPanelLayout
							.createSequentialGroup()
							.addContainerGap()
							.add(previewAlgoritmoPanelLayout
									.createParallelGroup()
									.add(GroupLayout.LEADING, getJLabel4x(),
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.add(GroupLayout.LEADING,
											getNombreAlgoritmoLabel(), 0, 14,
											Short.MAX_VALUE))
							.addPreferredGap(LayoutStyle.UNRELATED)
							.add(getJScrollPane8(), GroupLayout.PREFERRED_SIZE,
									188, GroupLayout.PREFERRED_SIZE)
							.add(16)
							.add(getOkPreviewAlgoritmoButton(),
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addContainerGap(16, 16));
		}
		return previewAlgoritmoPanel;
	}

	private JLabel getNombreAlgoritmoLabel() {
		if (nombreAlgoritmoLabel == null) {
			nombreAlgoritmoLabel = new JLabel();
			nombreAlgoritmoLabel.setText("aaaa");
		}
		return nombreAlgoritmoLabel;
	}

	private JLabel getJLabel4x() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText(getWord("nombre"));
		}
		return jLabel4;
	}

	private JTextArea getDescripcionAlgoritmoTextArea() {
		if (descripcionAlgoritmoTextArea == null) {
			descripcionAlgoritmoTextArea = new JTextArea();
			descripcionAlgoritmoTextArea.setWrapStyleWord(true);
			descripcionAlgoritmoTextArea.setLineWrap(true);
		}
		return descripcionAlgoritmoTextArea;
	}

	private JScrollPane getJScrollPane8() {
		if (jScrollPane8 == null) {
			jScrollPane8 = new JScrollPane();
			jScrollPane8.setName(getWord("descripcion"));
			jScrollPane8.setBounds(10, 36, 471, 188);
			jScrollPane8.setViewportView(getDescripcionAlgoritmoTextArea());
		}
		return jScrollPane8;
	}

	private JButton getOkPreviewAlgoritmoButton() {
		if (okPreviewAlgoritmoButton == null) {
			okPreviewAlgoritmoButton = new JButton();
			okPreviewAlgoritmoButton.setText(getWord("ok"));
			okPreviewAlgoritmoButton.setAction(getOkPreviewAlgoritmoAction());
		}
		return okPreviewAlgoritmoButton;
	}

	private AbstractAction getOkPreviewAlgoritmoAction() {
		if (okPreviewAlgoritmoAction == null) {
			okPreviewAlgoritmoAction = new AbstractAction(getWord("ok"), null) {
				public void actionPerformed(ActionEvent evt) {
					getPreviewAlgoritmoDialog().dispose();
				}
			};
		}
		return okPreviewAlgoritmoAction;
	}
}
