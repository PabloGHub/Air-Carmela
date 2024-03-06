import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.time.Year;
import java.util.ArrayList;

//import static Funciones.*;

/**
 * S_Menu
 * @author Pablooo!
 * @version 0.1.2
 * 
 * La clase S_Menu representa el menú principal del sistema de venta de boletos de Air Carmela.
 * Proporciona funcionalidad para crear la interfaz de usuario y manejar las interacciones del usuario.
 * 
 * Consta de un funcion principal (ppal) que crea el primer bloque
 * dentro de ella esta dividido en: crear objetos, Interactividad que son los Eventos, implementacion que costa de unir los objetos
 * 
 * 
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
        ApoyoPuntoVenta _apoyo = new ApoyoPuntoVenta();

        //---( CREAR MARCO )---//
        //JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame _marco = new JFrame("Air Carmela");
        //_marco.setLayout(new BorderLayout());
        _marco.setSize(900, 300);

        _marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension _tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        _marco.setLocation((int) Math.round((_tamañoPantalla.getWidth()/2) - _marco.getWidth() / 2), (int) Math.round((_tamañoPantalla.getHeight()/2) - _marco.getHeight() / 2));
    
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
        String[] _meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        /*
         * @param _meses: Array de los meses del año
         * @return: SpinnerListModel con los meses del año
         * 
         * Se crea un Spinner para recorer los meses del año (Ida y Vuelta)
         * Sobreescribe los metodos del objeto permitiendo avanzar de año
         */
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
        
        /*
         * @param _meses: Array de los meses del año
         * @return: SpinnerListModel con los meses del año
         * 
         * Se crea un Spinner para recorer los meses del año (Ida y Vuelta) 
         * Sobreescribe los metodos del objeto permitiendo avanzar de año
         */
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
            _MesVue.setValue("Septiembre");


            JPanel _Cont_AnioVuelta = new JPanel();
            _Cont_AnioVuelta.setOpaque(false);

            SpinnerNumberModel _AnioVue_modelo = new SpinnerNumberModel(2022, 1900, 3999, 1); 
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
            _MesIda.setValue("Septiembre");

            JPanel _Cont_AnioIda = new JPanel();
            _Cont_AnioIda.setOpaque(false);
            SpinnerNumberModel _AnioIda_modelo = new SpinnerNumberModel(2022, 1900, 3999, 1);
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

        // Inserccion de datos en el hasMap de las "cuidades"
        _apoyo.insert();

        // Origen
            JPanel _panelOrigen = new JPanel();
            _panelOrigen.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
            _panelOrigen.setOpaque(false);

            JLabel _origen = new JLabel("Origen: ");
            _origen.setForeground(Color.WHITE);

            JComboBox<String> _origenLista = new JComboBox<>();
            _origenLista.setPreferredSize(new Dimension(120, 30));
            _origenLista.setEditable(false);
            _origenLista.addItem("---------");
            for (String _ciudad : _apoyo.CiudadCodigo.keySet())
                _origenLista.addItem(_ciudad);
        // Fin Origen


        // Destino
            JPanel _panelDestino = new JPanel();
            _panelDestino.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
            _panelDestino.setOpaque(false);

            JLabel _destino = new JLabel("Destino: ");
            _destino.setForeground(Color.WHITE);

            JComboBox<String> _destinoLista = new JComboBox<>();
            _destinoLista.setPreferredSize(new Dimension(120, 30));
            _destinoLista.setEditable(false);
            _destinoLista.addItem("---------");
            for (String _ciudad : _apoyo.CiudadCodigo.keySet())
                _destinoLista.addItem(_ciudad);
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
        



        //---( ACCIONES: ( PARTE INTERACTIVA ) )---//

        /*
         * Evento que desactica los campos de Vuelta si esta activado Solo Ida
         */
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

        /*
         * Evento que cambia los valores de Vuelta cuando los de Ida cambien
         */
        _IdaVuelta.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                _DiaVue.setValue(_DiaIda.getValue());
                _MesVue.setValue(_MesIda.getValue());
                _AnioVue.setValue(_AnioIda.getValue());
            }
        });
        
        // EVENTOS IDA
        /*
         * Evento que llama para cambiar los maximos de los dias de Ida
         * Tambien comprueba si no es de Ida y que Ida como Ida/Vuelta esta desactivados para cambiar o no el _DiaVue
         */
        _DiaIda.addChangeListener(new ChangeListener()
        { 
            public void stateChanged(ChangeEvent e)
            {
                Integer NuevoMas = Integer.parseInt(_apoyo.Opcion4((String) _MesIda.getValue(), Year.of( (Integer) _AnioIda.getValue())));
                _DiaIda_modelo.setMaximum(NuevoMas);

                if ((Integer) _DiaIda.getValue() > NuevoMas)
                {
                    _DiaIda.setValue(NuevoMas);
                }

                if (!_Ida.isSelected() || (!_Ida.isSelected() && !_IdaVuelta.isSelected()))
                    _DiaVue.setValue(_DiaIda.getValue());

            }
        });

        
        /*
         * Evento que llama para cambiar los maximos de los meses de Ida
         * Ademas de cambiar el año si se pasa de Diciembre a Enero o viceversa
         * Tambien comprueba si no es de Ida y que Ida como Ida/Vuelta esta desactivados para cambiar o no el _mesVue
         */
        final String[] _MesIdaAnteriorFinal = new String[1];
        _MesIda.addChangeListener(new ChangeListener()
        { 
            public void stateChanged(ChangeEvent e)
            {
                Integer NuevoMas = Integer.parseInt(_apoyo.Opcion4((String) _MesIda.getValue(), Year.of( (Integer) _AnioIda.getValue())));
                _DiaIda_modelo.setMaximum(NuevoMas);

                if ((Integer) _DiaIda.getValue() > NuevoMas)
                {
                    _DiaIda.setValue(NuevoMas);
                }
                
                if (!_Ida.isSelected() || (!_Ida.isSelected() && !_IdaVuelta.isSelected()))
                    _MesVue.setValue(_MesIda.getValue());

                    
                _MesIdaAnteriorFinal[0] = (_MesIdaAnteriorFinal[0] == null) ? (String) _MesIda.getValue() : _MesIdaAnteriorFinal[0];

                if (_MesIdaAnteriorFinal[0].equals("Diciembre") && ((String) _MesIda.getValue()).equals("Enero"))
                {
                    _AnioIda.setValue((Integer) _AnioIda.getValue() + 1);
                }
                else if (_MesIdaAnteriorFinal[0].equals("Enero") && ((String) _MesIda.getValue()).equals("Diciembre"))
                {
                    _AnioIda.setValue((Integer) _AnioIda.getValue() - 1);
                }
                
                _MesIdaAnteriorFinal[0] = (String) _MesIda.getValue();
            }
        });

        /*
         * Evento que comprueba si no es de Ida y que Ida como Ida/Vuelta esta desactivados para cambiar o no el _mesVue
         */
        _AnioIda.addChangeListener(new ChangeListener()
        { 
            public void stateChanged(ChangeEvent e)
            {
                if (!_Ida.isSelected() || (!_Ida.isSelected() && !_IdaVuelta.isSelected()))
                    _AnioVue.setValue(_AnioIda.getValue());
            }
        });

        // EVENTOS VUELTA
        /*
         * Evento que llama para cambiar los maximos de los dias de Vuelta
         * Tambien comprueba si _DiaVue es mayor que el maximo 
         */
        _DiaVue.addChangeListener(new ChangeListener()
        { 
            public void stateChanged(ChangeEvent e)
            {
                Integer NuevoMas = Integer.parseInt(_apoyo.Opcion4((String) _MesVue.getValue(), Year.of( (Integer) _AnioVue.getValue())));
                _DiaVue_modelo.setMaximum(NuevoMas);
                
                if ((Integer) _DiaVue.getValue() > NuevoMas)
                {
                    _DiaVue.setValue(NuevoMas);
                }
            }
        });


        /*
         * Evento que llama para cambiar los maximos de los meses de Vuelta
         * Tambien comprueba si _DiaVue es mayor que el maximo
         * Ademas de cambiar el año si se pasa de Diciembre a Enero o viceversa
        */
        final String[] _MesVueAnteriorFinal = new String[1];
        _MesVue.addChangeListener(new ChangeListener()
        { 
            public void stateChanged(ChangeEvent e)
            {
                Integer NuevoMas = Integer.parseInt(_apoyo.Opcion4((String) _MesVue.getValue(), Year.of( (Integer) _AnioVue.getValue())));
                _DiaVue_modelo.setMaximum(NuevoMas);

                if ((Integer) _DiaVue.getValue() > NuevoMas)
                {
                    _DiaVue.setValue(NuevoMas);
                }

                _MesVueAnteriorFinal[0] = (_MesVueAnteriorFinal[0] == null) ? (String) _MesVue.getValue() : _MesVueAnteriorFinal[0];

                if (_MesVueAnteriorFinal[0].equals("Diciembre") && ((String) _MesVue.getValue()).equals("Enero"))
                {
                    _AnioVue.setValue((Integer) _AnioVue.getValue() + 1);
                }
                else if (_MesVueAnteriorFinal[0].equals("Enero") && ((String) _MesVue.getValue()).equals("Diciembre"))
                {
                    _AnioVue.setValue((Integer) _AnioVue.getValue() - 1);
                }

                _MesVueAnteriorFinal[0] = (String) _MesVue.getValue();
            }
        });

        
        //DefaultComboBoxModel<String> _ModeloDestino = new DefaultComboBoxModel<>();
        //_destinoLista.setModel(_ModeloDestino);

        /*
         * Evento que comprueba si el origen y el destino son iguales 
         * pone barras si lo son
         */
        _origenLista.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                if (_origenLista.getSelectedItem().equals(_destinoLista.getSelectedItem()))
                {
                    _origenLista.setSelectedItem("---------");
                }
                /*
                _ModeloDestino.removeAllElements();
                _ModeloDestino.addElement("---------");
                for (String _ciudad : _apoyo.CiudadCodigo.keySet())
                {
                    if (!_ciudad.equals((String) _origenLista.getSelectedItem()))
                        _ModeloDestino.addElement(_ciudad);
                }
                */
            }
        });

        // Crear un modelo de lista para _origenLista
        //DefaultComboBoxModel<String> _ModeloOrigen = new DefaultComboBoxModel<>();
        //_origenLista.setModel(_ModeloOrigen);
        //_ModeloOrigen.addElement("---------");
        
        /*
         * Evento que comprueba si el origen y el destino son iguales
         * pone barras si lo son
         */
        _destinoLista.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                if (_destinoLista.getSelectedItem().equals(_origenLista.getSelectedItem()))
                {
                    _destinoLista.setSelectedItem("---------");
                }
                
                /*
                _ModeloOrigen.removeAllElements();
                _ModeloOrigen.addElement("---------");
                for (String _ciudad : _apoyo.CiudadCodigo.keySet())
                {
                    if (!_ciudad.equals((String) _destinoLista.getSelectedItem()))
                        _ModeloOrigen.addElement(_ciudad);
                }
                */
            }
        }); 
        

        /*
         * Declaraciones para el evento 
         * Evento que comprueba si origen como destino estan seleccionados
         * comprueba si la modalidad esta seleccionada
         */
        JPanel _CuerpoVuelos = new JPanel();
        JButton _Bconfirmar = new JButton("Confirmar Elecciones");
        ButtonGroup _grupoVuelta = new ButtonGroup();
        ButtonGroup _grupoIda = new ButtonGroup();
        JPanel _panelBotonConfirm = new JPanel();

        final String[] _PrecioIda = new String[1];
        final String[] _PrecioVuelta = new String[1];

        _busca.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if ("---------".equals(_origenLista.getSelectedItem()) || "---------".equals(_destinoLista.getSelectedItem()))
                {
                    JOptionPane.showMessageDialog(null, "No has seleccionado el Origen o el Destino", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

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
                /*
                 * Evento que crea una ventana de confirmacion
                 * Primero borra todo para asegurar que no haya dos bloques
                 * Luego crea el segundo bloque con los vuelos disponibles
                 */
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
                        //ArrayList<String> _datosIda = _apoyo.Opcion5((String) _origenLista.getSelectedItem(), (String) _destinoLista.getSelectedItem());

                        ArrayList<ArrayList<String>> _datosIda = _apoyo.Opcion5((String) _origenLista.getSelectedItem(), (String) _destinoLista.getSelectedItem());


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
                        _panelIda.setLayout(new GridLayout(_datosIda.get(0).size(), 1));
                        _panelIda.setBackground(new java.awt.Color(102, 153, 255));

                        JRadioButton[] _IdaRadio = new JRadioButton[_datosIda.get(0).size()];
                        for (int i = 0; i < _datosIda.get(0).size(); i++)
                        {
                            final int indiceFinal = i;

                            _IdaRadio[i] = new JRadioButton(_datosIda.get(0).get(i));
                            _IdaRadio[i].setForeground(Color.WHITE);
                            _IdaRadio[i].setOpaque(false);
                            _panelIda.add(_IdaRadio[i]);
                            _grupoIda.add(_IdaRadio[i]);

                            _IdaRadio[i].addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {
                                    _PrecioIda[0] = _datosIda.get(1).get(indiceFinal);
                                    //System.out.println(_PrecioIda[0]);
                                }
                            });
                        }

                        
                        // Mini Implementacion
                        _Con_Ida.add(_IdaTitulo, BorderLayout.NORTH);
                        _Con_Ida.add(_panelIda, BorderLayout.CENTER);
                        _ConIdaVuelta.add(_Con_Ida);
                        
                        if (_IdaVuelta.isSelected())
                        {
                            ArrayList<ArrayList<String>> _datosVuelta = _apoyo.Opcion5((String) _destinoLista.getSelectedItem(), (String) _origenLista.getSelectedItem());

                            //VUELTA
                            JPanel _Con_Vuelta = new JPanel();
                            _Con_Vuelta.setLayout(new BorderLayout());
                            _Con_Vuelta.setBorder(BorderFactory.createEmptyBorder(0, 25, 5, 5));
                            _Con_Vuelta.setOpaque(false);

                            JLabel _VueltaTitulo = new JLabel("Vuelta");
                            _VueltaTitulo.setForeground(Color.WHITE);

                            JPanel _panelVuelta = new JPanel();
                            _panelVuelta.setLayout(new GridLayout(_datosVuelta.get(0).size(), 1));
                            _panelVuelta.setBackground(new java.awt.Color(102, 153, 255));

                            JRadioButton[] _VueltaRadio = new JRadioButton[_datosVuelta.get(0).size()];
                            for (int i = 0; i < _datosVuelta.get(0).size(); i++)
                            {
                                final int indiceFinal = i;

                                _VueltaRadio[i] = new JRadioButton(_datosVuelta.get(0).get(i));
                                _VueltaRadio[i].setForeground(Color.WHITE);
                                _VueltaRadio[i].setOpaque(false);
                                _panelVuelta.add(_VueltaRadio[i]);
                                _grupoVuelta.add(_VueltaRadio[i]);

                                _VueltaRadio[i].addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        _PrecioVuelta[0] = _datosVuelta.get(1).get(indiceFinal);
                                        //System.out.println(_PrecioVuelta[0]);
                                    }
                                });
                            }

                            // Mini Implementacion
                            _Con_Vuelta.add(_VueltaTitulo, BorderLayout.NORTH);
                            _Con_Vuelta.add(_panelVuelta, BorderLayout.CENTER);
                            _ConIdaVuelta.add(_Con_Vuelta);
                        }

                        //JPanel _panelBotonConfirm = new JPanel();
                        _panelBotonConfirm.setLayout(new BorderLayout());
                        _panelBotonConfirm.setOpaque(false);

                        JPanel _Con_Bconfirmar = new JPanel();
                        _Con_Bconfirmar.setLayout(new FlowLayout());
                        _Con_Bconfirmar.setOpaque(false);

                        //JButton _Bconfirmar = new JButton("Confirmar Elecciones");
                        _Bconfirmar.setBackground(new java.awt.Color(0, 80, 200)); // color azul oscuro
                        _Bconfirmar.setForeground(Color.WHITE);
                        

                        // --- Implementacion --- //
                        _CuerpoVuelosTitulo.add(_VuelosTitulo, BorderLayout.NORTH);
                        _CuerpoVuelos.add(_CuerpoVuelosTitulo, BorderLayout.NORTH);
                        
                        _CuerpoVuelos.add(_ConIdaVuelta, BorderLayout.CENTER);

                            _Con_Bconfirmar.add(_Bconfirmar);
                        _panelBotonConfirm.add(_Con_Bconfirmar, BorderLayout.NORTH);
                        _CuerpoVuelos.add(_panelBotonConfirm, BorderLayout.SOUTH);

                        _panelBase.add(_CuerpoVuelos, BorderLayout.SOUTH);

                        dialog.dispose();
                        _marco.pack();
                        _marco.setLocation((int) Math.round((_tamañoPantalla.getWidth()/2) - _marco.getWidth() / 2), (int) Math.round((_tamañoPantalla.getHeight()/2) - _marco.getHeight() / 2));
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
        /*
         * Evento del boton de confirmacion
         * Comprueba si el vuelo de Ida esta seleccionado
         * Comprueba si el vuelo de Vuelta esta seleccionado
         * Comprueba si los dos vuelos estan seleccionados
         * Comprueba si no se selecciono ningun vuelo
         */
        _Bconfirmar.addActionListener(new ActionListener()
        {

            // Declaraciones Importes (Esto deberia haber hecho yo desde un principio que soy gilipollas)
            JPanel _Con_Importe = new JPanel();
            JLabel _ImporteTitulo = new JLabel("Importe");

            JPanel _Contenedor = new JPanel(new GridBagLayout());
            JPanel _Con_MiniImportes = new JPanel();

            JPanel _Con_Asiento = new JPanel();
            JLabel _AsientoTexto = new JLabel("Asiento: ");
            JTextField _AsientoCampo = new JTextField(4);

            JPanel _Con_Enbarque = new JPanel();
            JLabel _EmbarqueLabel = new JLabel("Embarque: ");
            JTextField _EmbarqueCampo = new JTextField(4);

            JPanel _Con_Equipaje = new JPanel();
            JLabel _EquipajeLabel = new JLabel("Equipaje: ");
            JTextField _EquipajeCampo = new JTextField(4);

            JPanel _Total = new JPanel();
            JLabel _TotalLabel = new JLabel("Precio Final: ");
            JTextField _TotalCampo = new JTextField(5);

            JPanel _panelBoto = new JPanel();
            JButton _Bcomprar = new JButton(new ImageIcon("img/aceptar.png"));
            JButton _Bcancelar = new JButton(new ImageIcon("img/rechazar.png"));


            JLabel _imagBillete = new JLabel(new ImageIcon("img/PNG.png"));
            JCheckBox _Equipaje = new JCheckBox("Equipaje");
            JCheckBox _Embarque = new JCheckBox("Embarque Prior.");
            JLabel _NumeroAsiento = new JLabel("1");

            JPanel _Cuerpo3Bloque = new JPanel();

            public void actionPerformed(ActionEvent e)
            {
                // Borrado para la creacion //
                _Cuerpo3Bloque.removeAll();
                _Cuerpo3Bloque.revalidate();
                _Cuerpo3Bloque.repaint();

                
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

                crearBloque3();
            }

            /*
             * Metodo que crea el tercer bloque
             */
            void crearBloque3()
            {
                //---------------------------------( CREACION DEL TERCER ( 3º ) BLOQUE )---//

                _Cuerpo3Bloque.setLayout(new GridBagLayout());
                _Cuerpo3Bloque.setOpaque(false);
                
                GridBagConstraints _restricciones = new GridBagConstraints();

                JPanel _AnchoDetalles = new JPanel();
                // Dimension tamaño = new Dimension(100, 100);
                // _AnchoDetalles.setPreferredSize(tamaño);
                // _AnchoDetalles.setMinimumSize(tamaño);
                // _AnchoDetalles.setMaximumSize(tamaño);
                _AnchoDetalles.setOpaque(false);


                JPanel _Con_Detalles = new JPanel();
                _Con_Detalles.setLayout(new BorderLayout());
                _Con_Detalles.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                
                _Con_Detalles.setOpaque(false);              

                JPanel _Detalles = new JPanel();
                _Detalles.setLayout(new BorderLayout());
                TitledBorder _TituloBranco = BorderFactory.createTitledBorder("Detalles");
                _TituloBranco.setTitleColor(Color.WHITE);
                _Detalles.setBorder(_TituloBranco);
                _Detalles.setOpaque(false);

                // Asientos
                    JPanel _CuerpoAsiento = new JPanel();
                    _CuerpoAsiento.setLayout(new BorderLayout());
                    _CuerpoAsiento.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                    _CuerpoAsiento.setOpaque(false);

                    JLabel _Asiento = new JLabel("Asiento");
                    _Asiento.setForeground(Color.WHITE);


                    JPanel _Con_Asientos = new JPanel();
                    _Con_Asientos.setLayout(new BorderLayout());
                    _Con_Asientos.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                    _Con_Asientos.setBackground(new java.awt.Color(102, 153, 255));
                    //
                        JPanel _Con_Filas = new JPanel();
                        _Con_Filas.setLayout(new FlowLayout());
                        _Con_Filas.setOpaque(false);

                        JLabel _Filas = new JLabel("Filas: ");
                        _Filas.setForeground(Color.WHITE);

                        //JLabel _NumeroAsiento = new JLabel("1");
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
                    _Con_Posiciones.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                    _Con_Posiciones.setOpaque(false);


                    JPanel _Con_Posicion = new JPanel();
                    _Con_Posicion.setLayout(new FlowLayout());
                    _Con_Posicion.setOpaque(false);

                    JLabel _Posicion = new JLabel("Posición");
                    _Posicion.setForeground(Color.WHITE);


                    JPanel _Con_PosicionRadio = new JPanel();
                    _Con_PosicionRadio.setLayout(new GridLayout(1, 3));
                    _Con_PosicionRadio.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    _Con_PosicionRadio.setBackground(new java.awt.Color(102, 153, 255));

                    JRadioButton _Pasillo = new JRadioButton("Pasillo");
                    _Pasillo.setForeground(Color.WHITE);
                    _Pasillo.setOpaque(false);

                    JRadioButton _Centro = new JRadioButton("Centro");
                    _Centro.setForeground(Color.WHITE);
                    _Centro.setOpaque(false);

                    JRadioButton _Ventana = new JRadioButton("Ventana");
                    _Ventana.setForeground(Color.WHITE);
                    _Ventana.setSelected(true);
                    _Ventana.setOpaque(false);


                    ButtonGroup _grupoPosicion = new ButtonGroup();
                    _grupoPosicion.add(_Pasillo);
                    _grupoPosicion.add(_Centro);
                    _grupoPosicion.add(_Ventana);
                // Fin Posición

                // Extras 
                    JPanel _Con_Extras = new JPanel();
                    _Con_Extras.setLayout(new BorderLayout());
                    _Con_Extras.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                    _Con_Extras.setOpaque(false);

                    JLabel _Extras = new JLabel("Extras");
                    _Extras.setForeground(Color.WHITE);

                    JPanel _Con_ExtrasCheck = new JPanel();
                    _Con_ExtrasCheck.setLayout(new GridLayout(1, 2));
                    _Con_ExtrasCheck.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    _Con_ExtrasCheck.setBackground(new java.awt.Color(102, 153, 255));

                    //JCheckBox _Embarque = new JCheckBox("Embarque Prior.");
                    _Embarque.setForeground(Color.WHITE);
                    _Embarque.setSelected(true);
                    _Embarque.setOpaque(false);

                    //JCheckBox _Equipaje = new JCheckBox("Equipaje");
                    _Equipaje.setForeground(Color.WHITE);
                    _Equipaje.setSelected(true);
                    _Equipaje.setOpaque(false);
                // Fin Extras

                // Importe
                    //JPanel _Con_Importe = new JPanel();
                    _Con_Importe.setLayout(new BorderLayout());
                    _Con_Importe.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                    _Con_Importe.setOpaque(false);

                    //JLabel _ImporteTitulo = new JLabel("Importe"); // dentro de _Con_Importe en NORTH
                    _ImporteTitulo.setForeground(Color.WHITE);

                    //JPanel _Contenedor = new JPanel(); // dentro de _Con_Importe en CENTER
                    //_Contenedor.setLayout(new FlowLayout());
                    _Contenedor.setBackground(new java.awt.Color(102, 153, 255));


                    //JPanel _Con_MiniImportes = new JPanel(); // dentro de _Contenedor
                    _Con_MiniImportes.setLayout(new GridLayout(1, 3));
                    _Con_MiniImportes.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                    _Con_MiniImportes.setOpaque(false);
                    //
                        //JPanel _Con_Asiento = new JPanel(); // dentro de _Con_MiniImportes
                        _Con_Asiento.setOpaque(false);

                        //JLabel _AsientoTexto = new JLabel("Asiento: "); // dentro de _Con_Asiento
                        _AsientoTexto.setForeground(Color.WHITE);

                        //JTextField _AsientoCampo = new JTextField(6);  // dentro de _Con_Asiento
                        _AsientoCampo.setEditable(false);
                        _AsientoCampo.setText("12,00€");

                        //JPanel _Con_Enbarque = new JPanel(); // dentro de _Con_MiniImportes
                        _Con_Enbarque.setOpaque(false);

                        //JLabel _EmbarqueLabel = new JLabel("Embarque: "); // dentro de _Con_Enbarque
                        _EmbarqueLabel.setForeground(Color.WHITE);

                        //JTextField _EmbarqueCampo = new JTextField(6); // dentro de _Con_Enbarque
                        _EmbarqueCampo.setEditable(false);
                        _EmbarqueCampo.setText("10,00€");

                        //JPanel _Con_Equipaje = new JPanel(); // dentro de _Con_MiniImportes
                        _Con_Equipaje.setOpaque(false);

                        //JLabel _EquipajeLabel = new JLabel("Equipaje: ");  // dentro de _Con_Equipaje
                        _EquipajeLabel.setForeground(Color.WHITE);

                        //JTextField _EquipajeCampo = new JTextField(6); // dentro de _Con_Equipaje
                        _EquipajeCampo.setEditable(false);
                        _EquipajeCampo.setText("25,00€");
                    //


                    //JPanel _Total = new JPanel(); // dentro de _Contenedor
                    _Total.setLayout(new FlowLayout());
                    _Total.setOpaque(false);
                    //
                        //JLabel _TotalLabel = new JLabel("Precio Final: ");
                        _TotalLabel. setFont(new Font("Arial", Font.BOLD, 15)); 
                        _TotalLabel.setForeground(Color.WHITE);
    
                        //JTextField _TotalCampo = new JTextField(8);
                        _TotalCampo.setFont(new Font("Arial", Font.BOLD, 15));
                        _TotalCampo.setEditable(false);
                        _TotalCampo.setText("00,00€");
                    //


                    //JPanel _panelBoto = new JPanel(); // dentro de _Contenedor
                    _panelBoto.setLayout(new GridLayout(2, 1));
                    _panelBoto.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                    _panelBoto.setOpaque(false);
                    //
                        //JButton _Bcomprar = new JButton(new ImageIcon("img/aceptar.png"));
                        _Bcomprar.setBackground(new java.awt.Color(0, 80, 200));
                        _Bcomprar.setForeground(Color.WHITE);

                        //JButton _Bcancelar = new JButton(new ImageIcon("img/rechazar.png"));
                        _Bcancelar.setBackground(new java.awt.Color(0, 80, 200)); 
                        _Bcancelar.setForeground(Color.WHITE);
                    //
                // Fin Importe

                // Billete
                    JPanel _Billete = new JPanel();
                    _Billete.setLayout(new BorderLayout());
                    _Billete.setOpaque(false);
                    _marco.setVisible(true);
                    //_Billete.setMinimumSize(new Dimension(_Con_Importe.getWidth(), _Con_Importe.getHeight()));

                    TitledBorder _BilleteTitulo = BorderFactory.createTitledBorder("Billete");
                    _BilleteTitulo.setTitleColor(Color.WHITE);
                    _Billete.setBorder(_BilleteTitulo);

                    // JPanel _tamaImag = new JPanel();
                    // _tamaImag.setOpaque(false);
                    // _tamaImag.setPreferredSize(new Dimension(455, 98));
                    // System.out.println(_Con_Importe.getWidth() + " " + _Con_Importe.getHeight());
                    // _tamaImag.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                    //JLabel _imagBillete = new JLabel(new ImageIcon("img/PNG.png")); // "img/ico_bill_av_ida.png"
                    _imagBillete.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                // Fin Billete

                // --- Interactividad --- //
                /*
                 * Evento que actualiza el texto de _NumeroAsiento
                 */
                _ControlAsieto.addChangeListener(new ChangeListener()
                {
                    public void stateChanged(ChangeEvent e)
                    {
                        JSlider source = (JSlider)e.getSource();
                        int valor = (int)source.getValue();
                        
                        _NumeroAsiento.setText(Integer.toString(valor));

                        actualizarImporte();
                    }
                });

                _Pasillo.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        actualizarImporte();
                    }
                });

                _Centro.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        actualizarImporte();
                    }
                });

                _Ventana.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        actualizarImporte();
                    }
                });

                _Embarque.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        actualizarImporte();
                    }
                });

                _Equipaje.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        actualizarImporte();
                    }
                });

                /*
                 * Evento que cambia la imagen del billete
                 * Muestra un mensaje de que ya puede retirar el billete
                 * Borra todo y vuelve a la pantalla principal
                 */
                _Bcomprar.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        if (_Ida.isSelected())
                        {
                            _imagBillete.setIcon(new ImageIcon("img/ico_bill_av_ida.png"));
                        }
                        else
                        {
                            _imagBillete.setIcon(new ImageIcon("img/ico_bill_av_iv.png"));
                        }

                        JOptionPane.showMessageDialog(null, "Ya puede retirar su billete", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        _marco.removeAll();
                        _marco.revalidate();
                        _marco.repaint();
                        _marco.dispose();
                        ppal();
                    }
                });

                /*
                 * Evento que borra todo y vuelve a la pantalla principal
                 */
                _Bcancelar.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        _marco.removeAll();
                        _marco.revalidate();
                        _marco.repaint();
                        _marco.dispose();
                        ppal();
                    }
                });

                // --- Implementacion --- //
                //JTextField _AsientoTexto = new JTextField(10); 

                // Fila del Asiento
                    _Con_ControlAsieto.add(_ControlAsieto);

                    _Con_Filas.add(_Filas);
                    _Con_Filas.add(_NumeroAsiento);

                    _Con_Asientos.add(_Con_Filas, BorderLayout.NORTH);
                    _Con_Asientos.add(_Con_ControlAsieto, BorderLayout.CENTER);

                    _CuerpoAsiento.add(_Asiento, BorderLayout.NORTH);
                    _CuerpoAsiento.add(_Con_Asientos, BorderLayout.CENTER);

                    _Detalles.add(_CuerpoAsiento, BorderLayout.NORTH);
                // Fin Fila del Asiento
                

                // Posicion Asiento
                    _Con_Posiciones.add(_Posicion, BorderLayout.NORTH);

                        _Con_PosicionRadio.add(_Pasillo);
                        _Con_PosicionRadio.add(_Centro);
                        _Con_PosicionRadio.add(_Ventana);
                    //_Con_Posicion.add(_Con_PosicionRadio, BorderLayout.CENTER);

                    _Con_Posiciones.add(_Con_PosicionRadio, BorderLayout.CENTER);

                    _Detalles.add(_Con_Posiciones, BorderLayout.CENTER);
                // Fin Posicion Asiento

                // Extras
                    _Con_ExtrasCheck.add(_Embarque);
                    _Con_ExtrasCheck.add(_Equipaje);

                    _Con_Extras.add(_Extras, BorderLayout.NORTH);
                    _Con_Extras.add(_Con_ExtrasCheck, BorderLayout.CENTER);

                    _Detalles.add(_Con_Extras, BorderLayout.SOUTH);
                // Fin Extras

                // Importe
                        _Con_Asiento.add(_AsientoTexto);
                        _Con_Asiento.add(_AsientoCampo);
                    _Con_MiniImportes.add(_Con_Asiento);

                        _Con_Enbarque.add(_EmbarqueLabel);
                        _Con_Enbarque.add(_EmbarqueCampo);
                    _Con_MiniImportes.add(_Con_Enbarque);

                        _Con_Equipaje.add(_EquipajeLabel);
                        _Con_Equipaje.add(_EquipajeCampo);
                    _Con_MiniImportes.add(_Con_Equipaje);


                    _Total.add(_TotalLabel);
                    _Total.add(_TotalCampo);

                    _panelBoto.add(_Bcomprar);
                    _panelBoto.add(_Bcancelar);

                    _restricciones.gridx = 1;_restricciones.gridy = 0;_restricciones.gridheight = 1;
                    _Contenedor.add(_Con_MiniImportes, _restricciones);

                    _restricciones.gridx = 1;_restricciones.gridy = 1;_restricciones.gridheight = 1;
                    _Contenedor.add(_Total, _restricciones);

                    _restricciones.gridx = 2;_restricciones.gridy = 0;_restricciones.gridheight = 2;
                    _Contenedor.add(_panelBoto, _restricciones);

                    _Con_Importe.add(_ImporteTitulo, BorderLayout.NORTH);
                    _Con_Importe.add(_Contenedor, BorderLayout.CENTER);
                // Fin Importe

                // Billete
                        _Billete.add(_imagBillete, BorderLayout.CENTER);
                // Fin Billete

                // Finale

                            _Con_Detalles.add(_Detalles);
                        _AnchoDetalles.add(_Con_Detalles);
                        _restricciones.gridx = 0;_restricciones.gridy = 0;_restricciones.gridheight = 2;
                    _Cuerpo3Bloque.add(_AnchoDetalles, _restricciones);

                    _restricciones.gridx = 1;_restricciones.gridy = 0;_restricciones.gridheight = 1;
                    _Cuerpo3Bloque.add(_Con_Importe, _restricciones);

                    _restricciones.gridx = 1;_restricciones.gridy = 1;_restricciones.gridheight = 1;
                    _Cuerpo3Bloque.add(_Billete, _restricciones);

                _panelBotonConfirm.add(_Cuerpo3Bloque, BorderLayout.SOUTH);

                actualizarImporte();

                _marco.pack();
                _marco.setLocation((int) Math.round((_tamañoPantalla.getWidth()/2) - _marco.getWidth() / 2), (int) Math.round((_tamañoPantalla.getHeight()/2) - _marco.getHeight() / 2));
                _marco.setVisible(true);
            }


            /*
             * Metodo que actualiza todo el importe
             */
            void actualizarImporte()
            {
                Double _Total = 0.0;
                DecimalFormat FormatoDecimales = new DecimalFormat("#.##");

                _Total += Double.parseDouble(_PrecioIda[0].replace(",", "."));
                _Total += !_IdaVuelta.isSelected() ? 0 : Double.parseDouble(_PrecioVuelta[0].replace(",", "."));


                if (6 >= Integer.parseInt(_NumeroAsiento.getText()))
                {
                    _Total += 12.00;
                    _AsientoCampo.setText("12,00€");
                }
                else if (19 >= Integer.parseInt(_NumeroAsiento.getText()))
                {
                    _Total += 8.00;
                    _AsientoCampo.setText("8,00€");
                }
                else 
                {
                    _Total += 4.00;
                    _AsientoCampo.setText("4,00€");
                }

                
                if (_Embarque.isSelected())
                {
                    _Total += 10.00;
                    _EmbarqueCampo.setText("10,00€");
                }
                else
                {
                    _EmbarqueCampo.setText("0,00€");
                }


                if (_Equipaje.isSelected())
                {
                    _Total += 25.00;
                    _EquipajeCampo.setText("25,00€");
                }
                else
                {
                    _EquipajeCampo.setText("0,00€");
                }

                _Total *= Double.parseDouble(_numPersonas.getValue().toString());

                _TotalCampo.setText(FormatoDecimales.format(_Total) + "€");
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

// Codigo para sacar el precio del string
String str = "Hola Mundo";
String lastTwoExceptLast = str.substring(str.length() - 5, str.length() - 1);



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