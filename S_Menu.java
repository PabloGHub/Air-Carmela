import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;

//import static Funciones.*;

/**
 * S_Menu
 * @author Pablooo!
 * @version 0.1.2
 */
/**
 * La clase S_Menu representa el menú principal del sistema de venta de boletos de Air Carmela.
 * Proporciona funcionalidad para crear la interfaz de usuario y manejar las interacciones del usuario.
 */
public class S_Menu
{
    public static void main(String[] args)
    {
        S_Menu _menu = new S_Menu();
        _menu.ppal();

    }

    JDialog dialog = new JDialog();
    public void ppal()
    {
        //---( CREAR MARCO )---//
        //JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame _marco = new JFrame("Air Carmela");
        //_marco.setLayout(new BorderLayout());
        _marco.setSize(900, 300);

        _marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension _tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        _marco.setLocation((int) Math.round((_tamañoPantalla.getWidth()/2) - _marco.getWidth() / 2), 150);
    
        //---( CREAR COMPONENTES )---//
        // Paneles
        JPanel _panelBase = new JPanel();
        _panelBase.setBackground(Color.getHSBColor(0.632f, 0.5f, 0.5f)); 
        _panelBase.setLayout(new BoxLayout(_panelBase, BoxLayout.Y_AXIS)); // Antiguo: new BorderLayout()


        JPanel _panelTitulo = new JPanel();
        _panelTitulo.setBackground(Color.white);
        _panelTitulo.setLayout(new FlowLayout());
        _panelTitulo.setBorder(new EmptyBorder(0, 100, 10, 100));


        //---------------------------------( PANEL TITULO )---//
        
        // Titulo
        JLabel _titulo = new JLabel("PUNTO DE VENTA DE BILLETES");
        _titulo.setBackground(new java.awt.Color(102, 153, 255));
        _titulo.setForeground(Color.gray);
        _titulo.setFont(new Font("Arial", Font.BOLD, 20));
        // Como podria hacer achicar el panle de titulo para que no ocupe tanto espacio
        _titulo.setBorder(new EmptyBorder(10, 0, 0, 0));



        //---------------------------------( PANEL CUERPOS )---//

        JPanel _panelCuerpo = new JPanel();
        _panelCuerpo.setLayout(new GridLayout(1, 2));
        _panelCuerpo.setOpaque(false);

        JPanel _panelCuIz = new JPanel();
        _panelCuIz.setLayout(new GridLayout(3, 1));
        _panelCuIz.setOpaque(false);
        
        JPanel _panelCuDer = new JPanel();
        _panelCuDer.setLayout(new GridLayout(1, 1));
        _panelCuDer.setOpaque(false);


        //---------------------------------( PANEL IZQUIERDO )---//

        // --- MODALIDAD < del panel izquierdo
        JPanel _ModalidadExterno = new JPanel();
        _ModalidadExterno.setLayout(new BorderLayout());
        _ModalidadExterno.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 45));
        _ModalidadExterno.setOpaque(false);

        JLabel _ModalidadTitulo = new JLabel();
        _ModalidadTitulo.setText("Modalidad");
        _ModalidadTitulo.setForeground(Color.WHITE);

        JPanel _Contenedor_ModalidadTitulo = new JPanel();
        _Contenedor_ModalidadTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, -5, 0));
        _Contenedor_ModalidadTitulo.setOpaque(false);

        JPanel _ModalidadInterno = new JPanel();
        _ModalidadInterno.setLayout(new GridLayout(1, 2));
        _ModalidadInterno.setBackground(new java.awt.Color(102, 153, 255));


        // Contenedor de los RadioButtons (Ida e IdaVuelta)
            JPanel _Contenedor_Ida = new JPanel(new FlowLayout());
            _Contenedor_Ida.setOpaque(false);

            JRadioButton _Ida = new JRadioButton("Ida");
            //_Ida.setForeground(Color.WHITE);
            _Ida.setOpaque(false);

            JPanel _Contenedor_IdaVuelta = new JPanel(new FlowLayout());
            _Contenedor_IdaVuelta.setOpaque(false);

            JRadioButton _IdaVuelta = new JRadioButton("Ida/Vuelta");
            //_IdaVuelta.setForeground(Color.WHITE);
            _IdaVuelta.setOpaque(false);
        // Fin Contenedor de los RadioButtons (Ida e IdaVuelta)
        ButtonGroup _grupo_IdaVuelta = new ButtonGroup();
        _grupo_IdaVuelta.add(_Ida);
        _grupo_IdaVuelta.add(_IdaVuelta);


        // Meses para Las Fechas (Ida y Vuelta)
        String[] _meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre", "Enero"};
        SpinnerListModel _MesesIda = new SpinnerListModel(_meses)
        {
            @Override
            public Object getNextValue()
            {
                Object value = super.getNextValue();
                if (value == null)
                {
                    value = getList().get(0); // Vuelve al inicio si se llega al final
                }
                return value;
            }
        
            @Override
            public Object getPreviousValue()
            {
                Object value = super.getPreviousValue();
                if (value == null)
                {
                    value = getList().get(getList().size() - 1); // Vuelve al final si se llega al inicio
                }
                return value;
            }
        };
        
        SpinnerListModel _MesesVuelta = new SpinnerListModel(_meses)
        {
            @Override
            public Object getNextValue()
            {
                Object value = super.getNextValue();
                if (value == null)
                {
                    value = getList().get(0); // Vuelve al inicio si se llega al final
                }
                return value;
            }
        
            @Override
            public Object getPreviousValue()
            {
                Object value = super.getPreviousValue();
                if (value == null)
                {
                    value = getList().get(getList().size() - 1); // Vuelve al final si se llega al inicio
                }
                return value;
            }
        };

        // --- FECHA IDA < del panel izquierdo
        JPanel _FechaIdaExterna = new JPanel();
        _FechaIdaExterna.setLayout(new BorderLayout());
        _FechaIdaExterna.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 45));
        _FechaIdaExterna.setOpaque(false);

        JLabel _FechaIdaTitulo = new JLabel();
        _FechaIdaTitulo.setText("Fecha Ida");
        _FechaIdaTitulo.setForeground(Color.WHITE);

        JPanel _FechaIdaInterna = new JPanel();
        _FechaIdaInterna.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        _FechaIdaInterna.setLayout(new GridLayout(1, 3));
        _FechaIdaInterna.setBackground(new java.awt.Color(102, 153, 255));


        
        // --- FECHA VUELTA < del panel izquierdo
        JPanel _FechaVueltaExterna = new JPanel();
        _FechaVueltaExterna.setLayout(new BorderLayout());
        _FechaVueltaExterna.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 45));
        _FechaVueltaExterna.setOpaque(false);

        JLabel _FechaVueltaTitulo = new JLabel();
        _FechaVueltaTitulo.setText("Fecha Vuelta");
        _FechaVueltaTitulo.setForeground(Color.WHITE);

        JPanel _FechaVueltaInterna = new JPanel();
        _FechaVueltaInterna.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        _FechaVueltaInterna.setLayout(new GridLayout(1, 3));
        _FechaVueltaInterna.setBackground(new java.awt.Color(102, 153, 255));

        // Contenedores y SpinField
            JPanel _Cont_DiaVuelta = new JPanel();
            _Cont_DiaVuelta.setOpaque(false);

            SpinnerNumberModel _DiaVue_modelo = new SpinnerNumberModel(1, 1, 31, 1); 
            JSpinner _DiaVue = new JSpinner(_DiaVue_modelo);
            _DiaVue.setPreferredSize(new Dimension(40, 20));


            JPanel _Cont_MesVuelta = new JPanel();
            _Cont_MesVuelta.setOpaque(false);

            JSpinner _MesVue = new JSpinner(_MesesVuelta);
            _MesVue.setPreferredSize(new Dimension(90, 20));


            JPanel _Cont_AnioVuelta = new JPanel();
            _Cont_AnioVuelta.setOpaque(false);

            SpinnerNumberModel _AnioVue_modelo = new SpinnerNumberModel(LocalDate.now().getYear(), LocalDate.now().getYear(), 3999, 1); 
            JSpinner _AnioVue = new JSpinner(_AnioVue_modelo);
            _AnioVue.setPreferredSize(new Dimension(50, 20));
        // Fin Contenedores y SpinField


        // Contenedores y SpinField
            JPanel _Cont_DiaIda = new JPanel();
            _Cont_DiaIda.setOpaque(false);
            SpinnerNumberModel _DiaIda_modelo = new SpinnerNumberModel(1, 1, 31, 1);
            JSpinner _DiaIda = new JSpinner(_DiaIda_modelo);
            _DiaIda.setPreferredSize(new Dimension(40, 20));

            JPanel _Cont_MesIda = new JPanel();
            _Cont_MesIda.setOpaque(false);
            JSpinner _MesIda = new JSpinner(_MesesIda);
            _MesIda.setPreferredSize(new Dimension(90, 20));

            JPanel _Cont_AnioIda = new JPanel();
            _Cont_AnioIda.setOpaque(false);
            SpinnerNumberModel _AnioIda_modelo = new SpinnerNumberModel(LocalDate.now().getYear(), LocalDate.now().getYear(), 3999, 1);
            JSpinner _AnioIda = new JSpinner(_AnioIda_modelo);
            _AnioIda.setPreferredSize(new Dimension(50, 20));
        // Fin Contenedores y SpinField


        //---------------------------------( PANEL DERECHO )---//

        // --- TRAYECTO < del panel derecho
        JPanel _TrayectoExterno = new JPanel(new BorderLayout());
        _TrayectoExterno.setBorder(BorderFactory.createEmptyBorder(0, 45, 5, 5));
        _TrayectoExterno.setOpaque(false);

        JLabel _TrayectoTitulo = new JLabel();
        _TrayectoTitulo.setText("Trayecto");
        _TrayectoTitulo.setForeground(Color.WHITE);

        JPanel _Cont_TrayectoTitulo = new JPanel();
        _Cont_TrayectoTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, -5, 0));
        _Cont_TrayectoTitulo.setOpaque(false);

        JPanel _TrayectoInterno = new JPanel();
        _TrayectoInterno.setLayout(new BorderLayout());
        _TrayectoInterno.setBackground(new java.awt.Color(102, 153, 255));


        // Origen y Destino
        JPanel _panelOrigenDestino = new JPanel();
        _panelOrigenDestino.setLayout(new GridLayout(2, 1));
        _panelOrigenDestino.setOpaque(false);

        // Origen
            JPanel _panelOrigen = new JPanel();
            _panelOrigen.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
            _panelOrigen.setOpaque(false);

            JLabel _origen = new JLabel("Origen: ");
            _origen.setForeground(Color.WHITE);

            JComboBox _origenLista = new JComboBox();
            _origenLista.setPreferredSize(new Dimension(120, 30));
            _origenLista.setEditable(false);
            _origenLista.addItem("---------");
            _origenLista.addItem("Sevilla");
            _origenLista.addItem("Lisboa");
        // Fin Origen


        // Destino
            JPanel _panelDestino = new JPanel();
            _panelDestino.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
            _panelDestino.setOpaque(false);

            JLabel _destino = new JLabel("Destino: ");
            _destino.setForeground(Color.WHITE);

            JComboBox _destinoLista = new JComboBox();
            _destinoLista.setPreferredSize(new Dimension(120, 30));
            _destinoLista.setEditable(false);
            _destinoLista.addItem("---------");
            _destinoLista.addItem("Sevilla");
            _destinoLista.addItem("Lisboa");
        // Fin Destino

        // NUMERO DE PERSONAS + BUSCAR 
            JPanel _panelBusca = new JPanel();
            _panelBusca.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
            _panelBusca.setOpaque(false);

            JLabel _personas = new JLabel("Nº Personas: ");
            _personas.setForeground(Color.WHITE);

            SpinnerNumberModel _numPersonas_modelo = new SpinnerNumberModel(1, 1, 10, 1); 
            JSpinner _numPersonas = new JSpinner(_numPersonas_modelo);
            _numPersonas.setPreferredSize(new Dimension(50, 20));

            JButton _busca = new JButton("Buscar");
            _busca.setBackground(new java.awt.Color(0, 80, 200)); // color boton mas oscuro
            _busca.setForeground(Color.WHITE);
        // Fin NUMERO DE PERSONAS + BUSCAR
        
        // Fecha NOMBRES
        // new JLabel("Dia:");
        // new JLabel("Mes:");
        // new JLabel("Año:");



        //---( ACCIONES: ( PARTE INTERACTIVA ) )---//

        _Ida.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                boolean _IdaAct = (e.getStateChange() == ItemEvent.SELECTED);
                _DiaVue.setEnabled(!_IdaAct);
                _MesVue.setEnabled(!_IdaAct);
                _AnioVue.setEnabled(!_IdaAct);
            }
        });

        _IdaVuelta.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                _DiaVue.setValue(_DiaIda.getValue());
                _MesVue.setValue(_MesIda.getValue());
                _AnioVue.setValue(_AnioIda.getValue());
            }
        });
        
        _DiaIda.addChangeListener(new ChangeListener()
        { 
            public void stateChanged(ChangeEvent e)
            {
                // Puntos _puntos = new Puntos();
                // int _maximo = _puntos.Punto5();
                // _DiaIda_modelo.setMaximum(5);
                // linea siguiente:  si est activo el Ida

                if (!_Ida.isSelected() || (!_Ida.isSelected() && !_IdaVuelta.isSelected()))
                    _DiaVue.setValue(_DiaIda.getValue());
            }
        });

        _MesIda.addChangeListener(new ChangeListener()
        { 
            public void stateChanged(ChangeEvent e)
            {
                // aqui llamar opcion 4
                // _DiaIda_modelo.setMaximum(5);

                if (!_Ida.isSelected() || (!_Ida.isSelected() && !_IdaVuelta.isSelected()))
                    _MesVue.setValue(_MesIda.getValue());
            }
        });

        _AnioIda.addChangeListener(new ChangeListener()
        { 
            public void stateChanged(ChangeEvent e)
            {
                if (!_Ida.isSelected() || (!_Ida.isSelected() && !_IdaVuelta.isSelected()))
                    _AnioVue.setValue(_AnioIda.getValue());
            }
        });

        

        JPanel _CuerpoVuelos = new JPanel();
        JButton _Bconfirmar = new JButton("Confirmar Elecciones");
        ButtonGroup _grupoVuelta = new ButtonGroup();
        ButtonGroup _grupoIda = new ButtonGroup();
        JPanel _panelBotonConfirm = new JPanel();

        _busca.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String _Contenido = "";
                if (_Ida.isSelected())
                {
                    _Contenido = "Ida: " + _origenLista.getSelectedItem() + "/" + _destinoLista.getSelectedItem() + " " + _DiaIda.getValue() + "-" + _MesIda.getValue() + "-" + _AnioIda.getValue();
                    _Contenido += "\n(" + _numPersonas.getValue() + " personas)";
                }
                else if (_IdaVuelta.isSelected())
                {
                    _Contenido = "Ida: " + _origenLista.getSelectedItem() + "/" + _destinoLista.getSelectedItem() + " " + _DiaIda.getValue() + "-" + _MesIda.getValue() + "-" + _AnioIda.getValue();
                    _Contenido += "\nVuelta: " + _destinoLista.getSelectedItem() + "/" + _origenLista.getSelectedItem() + " " + _DiaIda.getValue() + "-" + _MesVue.getValue() + "-" + _AnioVue.getValue();
                    _Contenido += "\n(" + _numPersonas.getValue() + " personas)";
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No has seleccionado la Modalidad", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                


                // --- CREACION DE VENTANA DE CONFIRMACION
                JButton _Bsi = new JButton("Sí");
                _Bsi.setBackground(new java.awt.Color(10, 180, 100)); // color verde oscuro
                _Bsi.setForeground(Color.WHITE);
                _Bsi.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        borrarTodo();
                        crearExtensionVuelos();
                    }

                    void borrarTodo()
                    {
                        _CuerpoVuelos.removeAll();
                        _CuerpoVuelos.revalidate();
                        _CuerpoVuelos.repaint();
                        _marco.setVisible(true);
                    }

                    void crearExtensionVuelos()
                    {
                        // DATOS (Simulacion)
                        String[] _datos = {"COSO-P2D2 25:61 26:62 69,69€", "ICKKCK-BI 25:61 26:62 69,69€"};


                        _grupoVuelta.clearSelection();
                        _grupoIda.clearSelection();
                        
                        _CuerpoVuelos.setLayout(new BorderLayout());
                        _CuerpoVuelos.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
                        _CuerpoVuelos.setOpaque(false);
                        //{
                            JPanel _CuerpoVuelosTitulo = new JPanel();
                            _CuerpoVuelosTitulo.setOpaque(false);
                            JLabel _VuelosTitulo = new JLabel("LOS VUELOS DISPONIBLES SON:");
                            _VuelosTitulo.setFont(new Font("Arial", Font.BOLD, 15));
                            _VuelosTitulo.setForeground(Color.WHITE);
                            

                            JPanel _ConIdaVuelta = new JPanel();
                            _ConIdaVuelta.setLayout(new GridLayout(1, _Ida.isSelected() ? 1 : 2));
                            _ConIdaVuelta.setOpaque(false);
                        //}


                        //IDA
                        JPanel _Con_Ida = new JPanel();
                        _Con_Ida.setLayout(new BorderLayout());
                        _Con_Ida.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 25));
                        _Con_Ida.setOpaque(false);

                        JLabel _IdaTitulo = new JLabel("Ida");
                        _IdaTitulo.setForeground(Color.WHITE);

                        JPanel _panelIda = new JPanel();
                        _panelIda.setLayout(new GridLayout(_datos.length, 1));
                        _panelIda.setBackground(new java.awt.Color(102, 153, 255));

                        JRadioButton[] _IdaRadio = new JRadioButton[_datos.length];
                        for (int i = 0; i < _datos.length; i++)
                        {
                            _IdaRadio[i] = new JRadioButton(_datos[i]);
                            _IdaRadio[i].setForeground(Color.WHITE);
                            _IdaRadio[i].setOpaque(false);
                            _panelIda.add(_IdaRadio[i]);
                            _grupoIda.add(_IdaRadio[i]);
                        }

                        
                        // Mini Implementacion
                        _Con_Ida.add(_IdaTitulo, BorderLayout.NORTH);
                        _Con_Ida.add(_panelIda, BorderLayout.CENTER);
                        _ConIdaVuelta.add(_Con_Ida);
                        
                        if (_IdaVuelta.isSelected())
                        {
                            //VUELTA
                            JPanel _Con_Vuelta = new JPanel();
                            _Con_Vuelta.setLayout(new BorderLayout());
                            _Con_Vuelta.setBorder(BorderFactory.createEmptyBorder(0, 25, 5, 5));
                            _Con_Vuelta.setOpaque(false);

                            JLabel _VueltaTitulo = new JLabel("Vuelta");
                            _VueltaTitulo.setForeground(Color.WHITE);

                            JPanel _panelVuelta = new JPanel();
                            _panelVuelta.setLayout(new GridLayout(_datos.length, 1));
                            _panelVuelta.setBackground(new java.awt.Color(102, 153, 255));

                            JRadioButton[] _VueltaRadio = new JRadioButton[_datos.length];
                            for (int i = 0; i < _datos.length; i++)
                            {
                                _VueltaRadio[i] = new JRadioButton(_datos[i]);
                                _VueltaRadio[i].setForeground(Color.WHITE);
                                _VueltaRadio[i].setOpaque(false);
                                _panelVuelta.add(_VueltaRadio[i]);
                                _grupoVuelta.add(_VueltaRadio[i]);
                            }

                            // Mini Implementacion
                            _Con_Vuelta.add(_VueltaTitulo, BorderLayout.NORTH);
                            _Con_Vuelta.add(_panelVuelta, BorderLayout.CENTER);
                            _ConIdaVuelta.add(_Con_Vuelta);
                        }

                        //JPanel _panelBotonConfirm = new JPanel();
                        _panelBotonConfirm.setLayout(new BorderLayout());
                        _panelBotonConfirm.setOpaque(false);

                        //JButton _Bconfirmar = new JButton("Confirmar Elecciones");
                        _Bconfirmar.setBackground(new java.awt.Color(0, 80, 200)); // color azul oscuro
                        _Bconfirmar.setForeground(Color.WHITE);
                        

                        // --- Implementacion --- //
                        _CuerpoVuelosTitulo.add(_VuelosTitulo, BorderLayout.NORTH);
                        _CuerpoVuelos.add(_CuerpoVuelosTitulo, BorderLayout.NORTH);
                        
                        _CuerpoVuelos.add(_ConIdaVuelta, BorderLayout.CENTER);

                        _panelBotonConfirm.add(_Bconfirmar, BorderLayout.NORTH);
                        _CuerpoVuelos.add(_panelBotonConfirm, BorderLayout.SOUTH);

                        _panelBase.add(_CuerpoVuelos, BorderLayout.SOUTH);

                        dialog.dispose();
                        _marco.pack();
                        _marco.setVisible(true);
                    }
                });

                JButton _Bno = new JButton("No");
                _Bno.setBackground(new java.awt.Color(200, 80, 100)); // color rojo oscuro
                _Bno.setForeground(Color.WHITE);
                _Bno.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        dialog.dispose();
                    }
                });

                JButton _Bcancelar = new JButton("Cancelar");
                _Bcancelar.setBackground(new java.awt.Color(0, 80, 200)); // color azul oscuro
                _Bcancelar.setForeground(Color.WHITE);
                _Bcancelar.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        dialog.dispose();
                    }
                });

                Object[] _o = {_Bsi, _Bno, _Bcancelar};

                JOptionPane _ocionePane = new JOptionPane(_Contenido, JOptionPane.QUESTION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, _o, _o[0]);

                dialog = _ocionePane.createDialog("Selecciona una Opción"); 
                dialog.setVisible(true);
            }
        });



        // --- BOTON DE CONFIRMACION ACCION --- //
        _Bconfirmar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // No tengo ni idea de como ve van a venir los datos
                //Double[] _Precios = {25.61, 26.62};

                
                if (_Ida.isSelected() && _grupoIda.getSelection() == null)
                {
                    JOptionPane.showMessageDialog(null, "No seleccionaste el Vuelo", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else if (_IdaVuelta.isSelected() && _grupoVuelta.getSelection() != null && _grupoIda.getSelection() == null)
                {
                    JOptionPane.showMessageDialog(null, "No seleccionaste el Vuelo de Ida", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } 
                else if (_IdaVuelta.isSelected() && _grupoVuelta.getSelection() == null && _grupoIda.getSelection() != null)
                {
                    JOptionPane.showMessageDialog(null, "No seleccionaste el Vuelo de Vuelta", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else if (_IdaVuelta.isSelected() && _grupoVuelta.getSelection() == null && _grupoIda.getSelection() == null)
                {
                    JOptionPane.showMessageDialog(null, "No seleccionaste ningun Vuelo", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //---------------------------------( CREACION DEL TERCER ( 3º ) BLOQUE )---//

                JPanel _Cuerpo3Bloque = new JPanel();
                _Cuerpo3Bloque.setLayout(new BorderLayout());
                _Cuerpo3Bloque.setOpaque(false);
                

                JPanel _AnchoDetalles = new JPanel();
                Dimension tamaño = new Dimension(100, 100);
                _AnchoDetalles.setPreferredSize(tamaño);
                _AnchoDetalles.setMinimumSize(tamaño);
                _AnchoDetalles.setMaximumSize(tamaño);
                _AnchoDetalles.setOpaque(false);


                JPanel _Con_Detalles = new JPanel();
                _Con_Detalles.setLayout(new BorderLayout());
                _Con_Detalles.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                
                _Con_Detalles.setOpaque(false);              

                JPanel _Detalles = new JPanel();
                _Detalles.setLayout(new GridLayout(3, 1));
                _Detalles.setBorder(BorderFactory.createTitledBorder("Detalles"));
                _Detalles.setOpaque(false);

                // Asientos
                    JPanel _CuerpoAsiento = new JPanel();
                    _CuerpoAsiento.setLayout(new FlowLayout());
                    _CuerpoAsiento.setOpaque(false);

                    JLabel _Asiento = new JLabel("Asiento");
                    _Asiento.setForeground(Color.WHITE);


                    JPanel _Con_Asientos = new JPanel();
                    _Con_Asientos.setLayout(new GridLayout(2, 1));
                    _Con_Asientos.setBackground(new java.awt.Color(102, 153, 255));

                    //
                        JPanel _Con_Filas = new JPanel();
                        _Con_Filas.setLayout(new FlowLayout());
                        _Con_Filas.setOpaque(false);

                        JLabel _Filas = new JLabel("Filas: ");
                        _Filas.setForeground(Color.WHITE);

                        JLabel _NumeroAsiento = new JLabel("1");
                        _NumeroAsiento.setForeground(Color.WHITE);

                    //

                    JPanel _Con_ControlAsieto = new JPanel();
                    _Con_ControlAsieto.setOpaque(false);

                    JSlider _ControlAsieto = new JSlider(JSlider.HORIZONTAL, 1, 26, 1);
                    _ControlAsieto.setMajorTickSpacing(5);
                    _ControlAsieto.setMinorTickSpacing(1);
                    _ControlAsieto.setPaintTicks(true);
                    _ControlAsieto.setPaintLabels(true);
                    _ControlAsieto.setOpaque(false);
                // Fin Asientos

                // Posición
                    JPanel _Con_Posiciones = new JPanel();
                    _Con_Posiciones.setLayout(new BorderLayout());
                    _Con_Posiciones.setOpaque(false);


                    JPanel _Con_Posicion = new JPanel();
                    _Con_Posicion.setLayout(new FlowLayout());
                    _Con_Posicion.setOpaque(false);

                    JLabel _Posicion = new JLabel("Posición");
                    _Posicion.setForeground(Color.WHITE);


                    JPanel _Con_PosicionRadio = new JPanel();
                    _Con_PosicionRadio.setLayout(new GridLayout(1, 3));
                    _Con_PosicionRadio.setBackground(new java.awt.Color(102, 153, 255));

                    JRadioButton _Pasillo = new JRadioButton("Pasillo");
                    _Pasillo.setForeground(Color.WHITE);
                    _Pasillo.setOpaque(false);

                    JRadioButton _Centro = new JRadioButton("Centro");
                    _Centro.setForeground(Color.WHITE);
                    _Centro.setOpaque(false);

                    JRadioButton _Ventana = new JRadioButton("Ventana");
                    _Ventana.setForeground(Color.WHITE);
                    _Ventana.setOpaque(false);


                    ButtonGroup _grupoPosicion = new ButtonGroup();
                    _grupoPosicion.add(_Pasillo);
                    _grupoPosicion.add(_Centro);
                    _grupoPosicion.add(_Ventana);
                // Fin Posición

                // Extras 
                    JPanel _Con_Extras = new JPanel();
                    _Con_Extras.setLayout(new GridLayout());
                    _Con_Extras.setOpaque(false);

                    JLabel _Extras = new JLabel("Extras");
                    _Extras.setForeground(Color.WHITE);

                    JPanel _Con_ExtrasCheck = new JPanel();
                    _Con_ExtrasCheck.setLayout(new GridLayout(1, 2));

                    JCheckBox _Embarque = new JCheckBox("Embarque Prior.");
                    _Embarque.setForeground(Color.WHITE);
                    _Embarque.setOpaque(false);

                    JCheckBox _Entretenimiento = new JCheckBox("Equipaje");
                    _Entretenimiento.setForeground(Color.WHITE);
                    _Entretenimiento.setOpaque(false);
                // Fin Extras

                // Importes

                // Fin Importes

                //JTextField _AsientoTexto = new JTextField(10); 

                // Fila del Asiento
                    _Con_ControlAsieto.add(_ControlAsieto);

                    _Con_Filas.add(_Filas);
                    _Con_Filas.add(_NumeroAsiento);

                    _Con_Asientos.add(_Con_Filas);
                    _Con_Asientos.add(_Con_ControlAsieto);

                    _CuerpoAsiento.add(_Asiento);
                    _CuerpoAsiento.add(_Con_Asientos);

                    _Detalles.add(_CuerpoAsiento);
                // Fin Fila del Asiento
                

                // Posicion Asiento
                    _Con_Posiciones.add(_Posicion, BorderLayout.NORTH);

                        _Con_PosicionRadio.add(_Pasillo);
                        _Con_PosicionRadio.add(_Centro);
                        _Con_PosicionRadio.add(_Ventana);
                    _Con_Posicion.add(_Con_PosicionRadio);

                    _Con_Posiciones.add(_Con_Posicion, BorderLayout.CENTER);

                    _Detalles.add(_Con_Posiciones);
                // Fin Posicion Asiento


                // Finale
                        _Con_Detalles.add(_Detalles);
                        _AnchoDetalles.add(_Con_Detalles);
                    _Cuerpo3Bloque.add(_AnchoDetalles);
                _panelBotonConfirm.add(_Cuerpo3Bloque, BorderLayout.SOUTH);

                _marco.pack();
                _marco.setVisible(true);
            }
        });
        


        //---( IMPLEMENTAR COMPONENTES )---//
                _panelTitulo.add(_titulo);
                // ^ (PA ATRAS): Añadir el titulo

                            _Contenedor_ModalidadTitulo.add(_ModalidadTitulo);
                        _ModalidadExterno.add(_Contenedor_ModalidadTitulo, BorderLayout.NORTH);

                                _Contenedor_Ida.add(_Ida);
                            _ModalidadInterno.add(_Contenedor_Ida);
                                _Contenedor_IdaVuelta.add(_IdaVuelta);
                            _ModalidadInterno.add(_Contenedor_IdaVuelta);
                        _ModalidadExterno.add(_ModalidadInterno, BorderLayout.CENTER);
                    _panelCuIz.add(_ModalidadExterno);

                        _FechaIdaExterna.add(_FechaIdaTitulo, BorderLayout.NORTH);

                                _Cont_DiaIda.add(new JLabel("Dia"));
                                _Cont_DiaIda.add(_DiaIda);
                            _FechaIdaInterna.add(_Cont_DiaIda);
                                _Cont_MesIda.add(new JLabel("Mes"));
                                _Cont_MesIda.add(_MesIda);
                            _FechaIdaInterna.add(_Cont_MesIda);
                                _Cont_AnioIda.add(new JLabel("Año"));
                                _Cont_AnioIda.add(_AnioIda);
                            _FechaIdaInterna.add(_Cont_AnioIda);
                        _FechaIdaExterna.add(_FechaIdaInterna, BorderLayout.CENTER);
                    _panelCuIz.add(_FechaIdaExterna);

                        _FechaVueltaExterna.add(_FechaVueltaTitulo, BorderLayout.NORTH);

                                _Cont_DiaVuelta.add(new JLabel("Dia"));
                                _Cont_DiaVuelta.add(_DiaVue);
                            _FechaVueltaInterna.add(_Cont_DiaVuelta);
                                _Cont_MesVuelta.add(new JLabel("Mes"));
                                _Cont_MesVuelta.add(_MesVue);
                            _FechaVueltaInterna.add(_Cont_MesVuelta);
                                _Cont_AnioVuelta.add(new JLabel("Año"));
                                _Cont_AnioVuelta.add(_AnioVue);
                            _FechaVueltaInterna.add(_Cont_AnioVuelta);
                        _FechaVueltaExterna.add(_FechaVueltaInterna, BorderLayout.CENTER);
                    _panelCuIz.add(_FechaVueltaExterna);
                    // ^ (PA ATRAS): Todo el primer panel de la izquierda

                            _Cont_TrayectoTitulo.add(_TrayectoTitulo);
                        _TrayectoExterno.add(_Cont_TrayectoTitulo, BorderLayout.NORTH);

                                    _panelOrigen.add(_origen);
                                    _panelOrigen.add(_origenLista);
                                _panelOrigenDestino.add(_panelOrigen);
                                    _panelDestino.add(_destino);
                                    _panelDestino.add(_destinoLista);
                                _panelOrigenDestino.add(_panelDestino);
                            _TrayectoInterno.add(_panelOrigenDestino, BorderLayout.NORTH);

                                _panelBusca.add(_personas);
                                _panelBusca.add(_numPersonas);
                                _panelBusca.add(_busca);
                            _TrayectoInterno.add(_panelBusca, BorderLayout.SOUTH);
                        _TrayectoExterno.add(_TrayectoInterno, BorderLayout.CENTER);
                    _panelCuDer.add(_TrayectoExterno);
                    // ^ (PA ATRAS): Todo el primer panel de la derecha

                _panelCuerpo.add(_panelCuIz);
                _panelCuerpo.add(_panelCuDer);

            _panelBase.add(_panelTitulo); // , BorderLayout.NORTH
            _panelBase.add(_panelCuerpo); // , BorderLayout.CENTER
        
        _marco.add(_panelBase); // , BorderLayout.CENTER

        _marco.pack();
        _marco.setVisible(true);
    }
}

//---( CODIGOS QUE SE PUEDEN USAR EN EL FUTURO )---//
/*

//import com.formdev.flatlaf.FlatLightLaf;

try {
    UIManager.setLookAndFeel(new FlatLightLaf());
} catch( Exception ex ) {
    System.err.println( "Fallo la Inicializacion de LaF" );
}

// --- Crear un panel con bordes redondeados (Sin usar el UIManager)
JPanel _FechaIdaInterna = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                int arc = 10;
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arc, arc);
            }
        };
        _FechaIdaInterna.setOpaque(false);


        // Para que los bordes sean redondeados
        UIManager.put("JPanel.arc", 100);
        //_ModalidadInterno.putClientProperty("JComponent.roundRect", true);

*/