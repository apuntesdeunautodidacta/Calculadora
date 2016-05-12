/*Copyright (C) <2016>  <David García> <@Garci0679>

        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with this program.  If not, see <http://www.gnu.org/licenses/>
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Calculadora. Sencilla calculadora que permite utilizarse pulsando sobre los botones con el ratón
 * o escribiendo directamente con el teclado. Reconoce el teclado numérico y el teclado normal. También
 * captura la pulsación de la tecla shift para el signo * y el signo /. Con la tecla Ctrl cambia el signo
 * al número que se esté escribiendo y con la tecla ESC cierra la ventana.
 * @author @Garci0679
 */
public class Calculadora extends JFrame {

    /**
     * Constructor de la clase Calculadora
     */

    public Calculadora() {


        /**
         * Iniciación de variables
         */

        jPanelOperaciones = new JPanel();
        btnsuma = new JButton();
        btnresta = new JButton();
        btnmultiplicar = new JButton();
        btndividir = new JButton();
        btnigual = new JButton();
        btnCE = new JButton();
        jToggleBtnApagar = new JToggleButton();
        btnBorrar = new JButton();
        jPanelPantalla = new JPanel();
        txtFieldLinea2 = new JFormattedTextField(new Double(0));
        txtFieldLinea1 = new JFormattedTextField(new Double(0));
        txtField2Operador = new JTextField();
        txtFieldResultado = new JFormattedTextField(new Double(0));
        jPanelNumeros = new JPanel();
        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();
        btnmenos = new JButton();
        btnPunto = new JButton();
        btn0 = new JButton();
        jPanel1 = new JPanel();
        txtFieldAvisos = new JTextField();

        //Fin iniciación de variables

        /*/Configuración del JFrame
        * No permite cambiar de tamaño la ventana para que mantenga el orden de los elementos.
        * Se le asigna una localización al frame de 400 y 400 píxeles
        * Título del JFrame: Calculadora
        */
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(400,400);
        setTitle("Calculadora - @Garci0679");

        //---------------------ASIGNACIÓN DE LOS TEXTOS A LOS BOTONES DE OPERACIÓN Y SU RESPECTIVA FUNCIÓN ------
        btnsuma.setText("+");
        btnOperacion(btnsuma);

        btnresta.setText("-");
        btnOperacion(btnresta);

        btnmultiplicar.setText("*");
        btnOperacion(btnmultiplicar);

        btndividir.setText("/");
        btnOperacion(btndividir);

        btnigual.setText("=");
        btnOperacion(btnigual);

        btnCE.setText("CE");
        btnBorrar(btnCE);

        //Al botón de apagado se le asigna mediante una clase anónima la acción a realizar
        jToggleBtnApagar.setText("Off");
        jToggleBtnApagar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //Fin botón de apagado

        btnBorrar.setText("Bor");
        btnBorrar(btnBorrar);
        //------------------------FIN ASIGNACIÓN DE TEXTOS Y FUNCIONES------------------------------


        //Inicio del grouplayout que contiene los botones de operaciones
        GroupLayout jPanelOperacionesLayout = new GroupLayout(jPanelOperaciones);
        jPanelOperaciones.setLayout(jPanelOperacionesLayout);
        jPanelOperacionesLayout.setHorizontalGroup(
                jPanelOperacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelOperacionesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelOperacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelOperacionesLayout.createSequentialGroup()
                                                .addComponent(btnsuma, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnresta, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelOperacionesLayout.createSequentialGroup()
                                                .addComponent(btnmultiplicar, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btndividir, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelOperacionesLayout.createSequentialGroup()
                                                .addGroup(jPanelOperacionesLayout.createParallelGroup(
                                                        GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnigual, GroupLayout.PREFERRED_SIZE, 60,
                                                                GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 60,
                                                                GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelOperacionesLayout.createParallelGroup(
                                                        GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jToggleBtnApagar, GroupLayout.DEFAULT_SIZE, 60,
                                                                Short.MAX_VALUE)
                                                        .addComponent(btnCE, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOperacionesLayout.setVerticalGroup(
                jPanelOperacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelOperacionesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelOperacionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnsuma, GroupLayout.PREFERRED_SIZE, 60,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnresta, GroupLayout.PREFERRED_SIZE, 60,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelOperacionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btndividir, GroupLayout.PREFERRED_SIZE, 60,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnmultiplicar, GroupLayout.PREFERRED_SIZE, 60,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelOperacionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCE, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnigual, GroupLayout.PREFERRED_SIZE, 60,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelOperacionesLayout.createParallelGroup(
                                        GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnBorrar, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(jToggleBtnApagar, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        //Fin grouplauout de los botones de operaciones



        /* JPanel que funcionará como pantalla de la calculadora
        * La calculadora tiene 4 líneas. La primera y la tercera para introducir numeros, la segunda para el signo
        * de las operaciones y la cuarta para el resultado.
        */
        jPanelPantalla.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jPanelPantalla.setLayout(null);
        jPanelPantalla.setBackground(Color.white);

        //JFormattedTextField 2 de la pantalla
        txtFieldLinea2.setEditable(false);
        txtFieldLinea2.setHorizontalAlignment(JTextField.RIGHT);
        txtFieldLinea2.setText(" ");
        txtFieldLinea2.setBorder(null);
        txtFieldLinea2.setFont(new Font("Dialog", 1, 18)); // NOI18N
        txtFieldLinea2.setAutoscrolls(false);
        jPanelPantalla.add(txtFieldLinea2);
        txtFieldLinea2.setBounds(12, 70, 330, 30);

        //JFormattedTextField 1 de la pantalla
        txtFieldLinea1.setEditable(false);
        txtFieldLinea1.setHorizontalAlignment(JTextField.RIGHT);
        txtFieldLinea1.setText(" ");
        txtFieldLinea1.setBorder(null);
        txtFieldLinea1.addKeyListener(new PresionarTecla());
        txtFieldLinea1.setFont(new Font("Dialog", 1, 18)); // NOI18N
        txtFieldLinea1.setAutoscrolls(false);
        jPanelPantalla.add(txtFieldLinea1);
        txtFieldLinea1.setBounds(12, 10, 330, 30);


        /*txtFieldLinea1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                txtFieldAvisos.setText("Ctrl = +/- | C = Limpiar");
            }

            @Override
            public void focusLost(FocusEvent e) {

                txtFieldAvisos.setText("");

            }
        });*/

        //JFormattedTextField para el signo
        txtField2Operador.setEditable(false);
        txtField2Operador.setFont(new Font("Dialog", 0, 24)); // NOI18N
        txtField2Operador.setHorizontalAlignment(JTextField.RIGHT);
        txtField2Operador.setText("");
        txtField2Operador.setBorder(null);
        jPanelPantalla.add(txtField2Operador);
        txtField2Operador.setBounds(12, 40, 330, 30);

        //JFormattedTextField para el resultado de los cálculos
        txtFieldResultado.setEditable(false);
        txtFieldResultado.setFont(new Font("Dialog", 1, 20)); // NOI18N
        txtFieldResultado.setHorizontalAlignment(JTextField.RIGHT);
        txtFieldResultado.setText(" ");
        jPanelPantalla.add(txtFieldResultado);
        txtFieldResultado.setBounds(12, 109, 330, 30);

        /* La función de esta línea es para escribir avisos
        * No está implementada y está sin uso en este momento
        */
        txtFieldAvisos.setEditable(false);

        //Botones numéricos, botón del punto y cambio de valor y las llamadas a sus funciones
        btn1.setText("1");
        btn(btn1);

        btn2.setText("2");
        btn(btn2);

        btn3.setText("3");
        btn(btn3);

        btn4.setText("4");
        btn(btn4);

        btn5.setText("5");
        btn(btn5);

        btn6.setText("6");
        btn(btn6);

        btn7.setText("7");
        btn(btn7);

        btn8.setText("8");
        btn(btn8);

        btn9.setText("9");
        btn(btn9);

        btnmenos.setText("+/-");
        btnOperacionEspecial (btnmenos);

        btnPunto.setText(".");
        btnOperacionEspecial (btnPunto);

        btn0.setText("0");
        btn(btn0);
        //Fin de los botones numéricos, botón del punto, cambio de valor y llamadas a sus funciones

        //GroupLayout que contiene los botones númericos, botón del punto y cambio de valor
        GroupLayout jPanelNumerosLayout = new GroupLayout(jPanelNumeros);
        jPanelNumeros.setLayout(jPanelNumerosLayout);
        jPanelNumerosLayout.setHorizontalGroup(
                jPanelNumerosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelNumerosLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelNumerosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanelNumerosLayout.createSequentialGroup()
                                                .addComponent(btn1, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn2, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn3, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelNumerosLayout.createSequentialGroup()
                                                .addComponent(btn4, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn5, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn6, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelNumerosLayout.createSequentialGroup()
                                                .addComponent(btn7, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn8, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn9, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelNumerosLayout.createSequentialGroup()
                                                .addComponent(btnmenos, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn0, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnPunto, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addGap(180, 180, 180))
        );
        jPanelNumerosLayout.setVerticalGroup(
                jPanelNumerosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelNumerosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelNumerosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelNumerosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelNumerosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn8, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn9, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelNumerosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnmenos, GroupLayout.PREFERRED_SIZE, 60,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPunto, GroupLayout.PREFERRED_SIZE, 60,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn0, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //Fin groupLayout botones númericos, botón punto y botón cambio de valor

        //GroupLauout para el JTextfield de avisos al usuario
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(txtFieldAvisos)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(txtFieldAvisos, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );
        //Fin GroupLayout avisos al usuario

        //GroupLayout principal para colocar cada panel en su lugar
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelNumeros, GroupLayout.PREFERRED_SIZE, 215,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanelOperaciones, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanelPantalla, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelPantalla, GroupLayout.PREFERRED_SIZE, 154,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanelOperaciones, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanelNumeros, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //Fin GroupLayout principal

        pack();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         *
         * Intenta cargar el Look and Feel Nimbus
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });


    }

    // Declaración de variables
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnBorrar;
    private JButton btnCE;
    private JButton btnPunto;
    private JButton btndividir;
    private JButton btnigual;
    private JButton btnmenos;
    private JButton btnmultiplicar;
    private JButton btnresta;
    private JButton btnsuma;
    private JPanel jPanel1;
    private JPanel jPanelNumeros;
    private JPanel jPanelOperaciones;
    private JPanel jPanelPantalla;
    private JToggleButton jToggleBtnApagar;
    private JTextField txtField2Operador;
    private JTextField txtFieldAvisos;
    private JFormattedTextField txtFieldLinea1;
    private JFormattedTextField txtFieldLinea2;
    private JFormattedTextField txtFieldResultado;
    //Fin declaración de variables

    //Declaración e iniciación de variables útiles para las clases de cálculo y control
    //sumaResultado almacenará el valor del JTextField txtFieldResultado
    double sumaResultado = 0;
    //entra actua como indicador de la línea actual en la que se está escribiendo
    boolean entra = false;
    //Formateo del valor que se muestra en el JTextField txtFieldResultado
    DecimalFormat df = new DecimalFormat("#.############");
    //Fin declaración e iniciación de variables útiles


    /* El método compruebaCero comprueba que el valor del campo no está vacio.
    * @ param textField - Recibe como parámetro un campo formateado, del que comprobrará que no está vacio.
    * Si lo está, le pasa como valor un 0.
    */
    private void compruebaCero (JFormattedTextField textField) {

        if (textField.getText().equals(" ")) {

            textField.setText("0");
        }
    }


    /* Método ponSigno para poner el signo del operador al pulsar el boton
    * @param btnsigno - Recibe un boton que es del que se coge el signo
    */
    private void ponSigno (JButton btnSigno) {

        if (!btnSigno.getText().equals("=")) {

            txtField2Operador.setText(btnSigno.getText());

            entra = true;

        }
    }

    /*/Método btn
    * @param boton - recibe como parámetro el botón sobre el que lo usamos. De esta manera le añade un ActionListener
    * para ejecutar las acciones asignadas a ese botón. Este método es solo para los botones numéricos. Comprueba si
    * en los campos txtFieldLinea1 y txtFieldLinea2 el valor es 0, de ser así no muestra más que un solo 0. En caso
    * de pulsarse el . muestra el valor existente más el punto y deja escribir después
    *
    */
    private void btn (final JButton boton) {

        boton.addKeyListener(new PresionarTecla());

        boton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) throws NullPointerException {

                if (!entra) {

                    compruebaCero(txtFieldLinea1);

                    if (Double.parseDouble(txtFieldLinea1.getText()) == 0.0
                            && !txtFieldLinea1.getText().contains(".")) {

                            txtFieldLinea1.setText(boton.getText());


                        } else if (Double.parseDouble(txtFieldLinea1.getText()) == 0.0
                            && txtFieldLinea1.getText().contains(".")) {

                        txtFieldLinea1.setText(txtFieldLinea1.getText()+boton.getText());

                    } else {

                        txtFieldLinea1.setText(txtFieldLinea1.getText() + boton.getText());

                    }


            } else if (entra) {

                    compruebaCero(txtFieldLinea2);

                    if (Double.parseDouble(txtFieldLinea2.getText()) == 0.0
                            && !txtFieldLinea2.getText().contains(".")) {

                        txtFieldLinea2.setText(boton.getText());

                    } else if (Double.parseDouble(txtFieldLinea2.getText()) == 0.0
                            && txtFieldLinea2.getText().contains(".")) {

                        txtFieldLinea2.setText(txtFieldLinea2.getText()+boton.getText());


                    } else {

                        txtFieldLinea2.setText(txtFieldLinea2.getText() + boton.getText());

                    }
                }
            }
        });
    }

    /* Este método es para los botones de cambio de valor "+/-" y el botón del punto "."
    * @param - boton - Comprueba si se han pulsado y les indica que hacer en tal caso. Recibe como parámetro el
    * propio botón. En cualquiera de los dos casos comprueba la línea en la que se encuentra y realiza la acción
    * del botón en cuestión.
    */

    private void btnOperacionEspecial (final JButton boton) {

        boton.addKeyListener(new PresionarTecla());

        boton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (!entra) {

                    compruebaCero(txtFieldLinea1);

                    double valor = Double.parseDouble(txtFieldLinea1.getText());

                    int enteros = (int) valor;

                    double resto = valor - enteros;

                    if (boton.getText().equals("+/-"))  {

                        valor = -+valor;

                        if (resto != 0.0) {

                            txtFieldLinea1.setText(Double.toString(valor));

                        } else {

                            txtFieldLinea1.setText(Integer.toString((int) valor));
                        }


                    } else if (boton.getText().equals(".")) {



                        if (txtFieldLinea1.getText() == "0" )  {

                            txtFieldLinea1.setText("0.");

                        }

                        if (txtFieldLinea1.getText().indexOf(".") == -1) {

                            txtFieldLinea1.setText(txtFieldLinea1.getText() + ".");

                        } else if (txtFieldLinea1.getText() == "0.") {



                            txtFieldLinea1.setText(txtFieldLinea1.getText() + ".");
                        }
                    }

                } else if (entra) {

                    compruebaCero(txtFieldLinea2);

                    double valor = Double.parseDouble(txtFieldLinea2.getText());

                    int enteros = (int) valor;

                    double resto = valor - enteros;

                    if (boton.getText().equals("+/-")) {

                        valor = -+ valor;

                        if (resto != 0) {

                            txtFieldLinea2.setText(Double.toString(valor));

                        } else {

                            txtFieldLinea2.setText(Integer.toString((int) valor));
                        }

                    } else if (boton.getText().equals(".")) {


                        if (txtFieldLinea2.getText().indexOf(".") == -1) {

                            txtFieldLinea2.setText(txtFieldLinea2.getText() + ".");

                        }

                    }
                }
            }
        });
    }

    /*Método para obtener el resultado.
    * @param boton - Recibe como parámetro el propio botón. Le añade un ActionListener para realizar la función
    * asignada. Comprueba los valores existentes en las cuatro líneas de la pantalla: txtFieldLinea1, txtFieldOperador,
    * txtFieldLinea2 y txtfieldResultado. Dependiendo de si existen valores o no en ellos realiza una acción u otra
    */

    private void btnOperacion (final JButton boton) {


        boton.addKeyListener(new PresionarTecla());

        boton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                compruebaCero(txtFieldLinea1);

                compruebaCero(txtFieldLinea2);

                compruebaCero(txtFieldResultado);

                if (Double.parseDouble(txtFieldLinea1.getText()) != 0.0
                        && Double.parseDouble(txtFieldLinea2.getText()) == 0.0) {

                    ponSigno(boton);

                } else if (Double.parseDouble(txtFieldLinea1.getText()) != 0.0 &&
                      Double.parseDouble(txtFieldLinea2.getText()) != 0.0 &&
                            Double.parseDouble(txtFieldResultado.getText()) == 0.0) {

                    if (boton.getText().equals("+")) {

                        sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                + Double.parseDouble(txtFieldLinea2.getText());

                    } else if (boton.getText().equals("-")) {

                        sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                - Double.parseDouble(txtFieldLinea2.getText());

                    } else if (boton.getText().equals("*")) {

                        sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                * Double.parseDouble(txtFieldLinea2.getText());

                    } else if (boton.getText().equals("/")) {

                        sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                / Double.parseDouble(txtFieldLinea2.getText());

                    } else if (boton.getText().equals("=")) {

                        if (txtField2Operador.getText().equals("+")) {

                            sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                    + Double.parseDouble(txtFieldLinea2.getText());

                        } else if (txtField2Operador.getText().equals("-")) {

                            sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                    - Double.parseDouble(txtFieldLinea2.getText());

                        } else if (txtField2Operador.getText().equals("*")) {

                            sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                    * Double.parseDouble(txtFieldLinea2.getText());

                        } else if (txtField2Operador.getText().equals("/")) {

                            sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                    / Double.parseDouble(txtFieldLinea2.getText());
                        }
                    }

                    double lin1 = Double.parseDouble(txtFieldLinea1.getText());
                    double lin2 = Double.parseDouble(txtFieldLinea2.getText());



                    if (txtField2Operador.getText().equals("-")) {

                        if (lin1 - lin2 == 0) {

                            txtFieldLinea1.setText(txtFieldResultado.getText());

                            txtFieldLinea2.setText("0");

                            txtFieldResultado.setText("0");

                            entra = true;

                        }
                    } else if (txtField2Operador.getText().equals("/")) {

                        if (lin1 / lin2 == 0) {

                            txtFieldLinea1.setText(txtFieldResultado.getText());

                            txtFieldLinea2.setText("0");

                            txtFieldResultado.setText("0");

                            entra = true;
                        }
                    } else if (txtField2Operador.getText().equals("+")) {

                        if (lin1 + lin2 == 0) {

                            txtFieldLinea1.setText(txtFieldResultado.getText());

                            txtFieldLinea2.setText("0");

                            txtFieldResultado.setText("0");

                            entra = true;


                        }

                    } else if (txtField2Operador.getText().equals("=")) {

                        if (lin1 + lin2 == 0) {

                            txtFieldLinea1.setText(txtFieldResultado.getText());

                            txtFieldLinea2.setText("0");

                            txtFieldResultado.setText("0");

                            entra = true;


                        }

                    }

                    int entero = (int) sumaResultado;

                    double resto = sumaResultado - entero;

                    if (resto != 0) {

                        df.format(sumaResultado);

                        String res = df.format(sumaResultado);

                        res = res.replace(",", ".");

                        txtFieldResultado.setText(res);

                    } else {

                        txtFieldResultado.setText(Integer.toString((int) sumaResultado));
                    }

                } else if (Double.parseDouble(txtFieldLinea1.getText()) != 0.0
                        || Double.parseDouble(txtFieldLinea2.getText()) != 0.0 &&
                            Double.parseDouble(txtFieldResultado.getText()) != 0.0) {

                    txtFieldLinea1.setText(txtFieldResultado.getText());

                    txtFieldLinea2.setText("0");

                    txtFieldResultado.setText("0");

                    entra = true;

                } else if (Double.parseDouble(txtFieldLinea1.getText()) == 0.0 &&
                        Double.parseDouble(txtFieldLinea2.getText()) != 0.0) {

                    ponSigno(boton);

                    if (boton.getText().equals("+")) {

                        sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                + Double.parseDouble(txtFieldLinea2.getText());

                    } else if (boton.getText().equals("-")) {

                        sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                - Double.parseDouble(txtFieldLinea2.getText());

                    } else if (boton.getText().equals("*")) {

                        sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                * Double.parseDouble(txtFieldLinea2.getText());

                    } else if (boton.getText().equals("/")) {

                        sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                / Double.parseDouble(txtFieldLinea2.getText());

                    } else if (boton.getText().equals("=")) {

                        if (txtField2Operador.getText().equals("+")) {

                            sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                    + Double.parseDouble(txtFieldLinea2.getText());

                        } else if (txtField2Operador.getText().equals("-")) {

                            sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                    - Double.parseDouble(txtFieldLinea2.getText());

                        } else if (txtField2Operador.getText().equals("*")) {

                            sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                    * Double.parseDouble(txtFieldLinea2.getText());

                        } else if (txtField2Operador.getText().equals("/")) {

                            sumaResultado = Double.parseDouble(txtFieldLinea1.getText())
                                    / Double.parseDouble(txtFieldLinea2.getText());
                        }

                    }

                    int entero = (int) sumaResultado;

                    double resto = sumaResultado - entero;

                    if (resto != 0) {

                        df.format(sumaResultado);

                        String res = df.format(sumaResultado);

                        res = res.replace(",", ".");

                        txtFieldResultado.setText(res);

                    } else {

                        txtFieldResultado.setText(Integer.toString((int) sumaResultado));
                    }

                } }
        });
    }


    /* Este método es para los botones de retroceso y borrado de la pantalla
    * @param boton - Recibe como parámetro el propio botón. Si el botón es el de retroceso, comprueba la línea en la
    * que se encuentra y borra el último caracter introducido. Si es el botón de borrado, vacía todos los campos
    * y deja el cursor en el primer JTextField txtFieldLinea1.
    */
    private void btnBorrar (final JButton boton) {

        boton.addKeyListener(new PresionarTecla());

        boton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (!entra) {

                    compruebaCero(txtFieldLinea1);

                   if (boton.getText().equals("Bor")) {

                       String cadena = txtFieldLinea1.getText();

                       if (cadena.length() != 0) {

                           cadena = cadena.substring(0, cadena.length() - 1);

                           txtFieldLinea1.setText(cadena);

                           if (cadena.length() == 0) {

                               txtFieldLinea1.setText("0");
                        }

                    } else {

                           txtFieldLinea1.setText("0");
                       }

                   }

                } else if (entra) {

                    compruebaCero(txtFieldLinea2);

                    if (boton.getText().equals("Bor")) {

                        String cadena = txtFieldLinea2.getText();

                        if (cadena.length() != 0) {

                            cadena = cadena.substring(0, cadena.length() - 1);

                            txtFieldLinea2.setText(cadena);

                            if (cadena.length() == 0) {

                                txtFieldLinea2.setText("0");
                            }

                        } else {

                            txtFieldLinea2.setText("0");
                        }

                    }

                }

                if (boton.getText().equals("CE")) {



                    txtFieldLinea1.setText(" ");
                    txtFieldLinea2.setText(" ");
                    txtFieldResultado.setText(" ");
                    txtField2Operador.setText(" ");

                    entra = false;

                }

            }

        });

    }

    /* Método que controla si se pulsan las teclas en el teclado y "pulsa" el botón en cuestión
    * Con la variable swcontrol se control si se pulsa la tecla shift. Si se pulsa, swcontrol pasa a ser verdadero
    * y se comprueba si lo es y si se ha pulsado la tecla 7 o el + del teclado.
    *
    * Por otro lado captura los números del teclado y el teclado numérico además de los signos de cálculo.
    */
    private class PresionarTecla extends KeyAdapter {

        boolean swcontrol = false;

        public void keyPressed(KeyEvent ke) {

            if (ke.getKeyCode() == 16) {

                swcontrol = true;

            }

            if (swcontrol == true && ke.getKeyCode() == KeyEvent.VK_7) {

                btndividir.doClick();

                swcontrol = false;

            } else if (ke.getKeyCode() == KeyEvent.VK_7 || ke.getKeyCode() == KeyEvent.VK_NUMPAD7) {

                btn7.doClick();

            }

            if (swcontrol == true && ke.getKeyCode() == KeyEvent.VK_PLUS) {

                btnmultiplicar.doClick();

                swcontrol = false;

            } else if (ke.getKeyCode() == KeyEvent.VK_ADD || ke.getKeyCode() == KeyEvent.VK_PLUS) {

                btnsuma.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_0 || ke.getKeyCode() == KeyEvent.VK_NUMPAD0) {

                btn0.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_1 || ke.getKeyCode() == KeyEvent.VK_NUMPAD1) {

                btn1.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_2 || ke.getKeyCode() == KeyEvent.VK_NUMPAD2) {

                btn2.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_3 || ke.getKeyCode() == KeyEvent.VK_NUMPAD3) {

                btn3.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_4 || ke.getKeyCode() == KeyEvent.VK_NUMPAD4) {

                btn4.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_5 || ke.getKeyCode() == KeyEvent.VK_NUMPAD5) {

                btn5.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_6 || ke.getKeyCode() == KeyEvent.VK_NUMPAD6) {

                btn6.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_8 || ke.getKeyCode() == KeyEvent.VK_NUMPAD8) {

                btn8.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_9 || ke.getKeyCode() == KeyEvent.VK_NUMPAD9) {

                btn9.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_SUBTRACT || ke.getKeyCode() == KeyEvent.VK_MINUS) {

                btnresta.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_MULTIPLY) {

                btnmultiplicar.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_DIVIDE) {

                btndividir.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_DECIMAL || ke.getKeyCode() == KeyEvent.VK_PERIOD) {

                btnPunto.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_ENTER) {

                btnigual.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

                btnBorrar.doClick();

            }

            if (ke.getKeyCode() == KeyEvent.VK_CONTROL) {

                btnmenos.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_C) {

                btnCE.doClick();
            }

            if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

                jToggleBtnApagar.doClick();
            }

        }

    }

}
