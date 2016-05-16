package Calculadora;
/*Copyright (C) <2016>  <David García> <@Apuntes_autodi>

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
 * @author David García 
 * Twitter: Apuntes_autodi Blog: www.apuntesdeunautodidacta.es
 */
public class Calculadora extends JFrame {

    //--------------------Declaración de variables--------------------------------
    private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnBorrar, btnCE, btnPunto,
            btnDividir,btnIgual, btnMenos, btnMultiplicar, btnResta, btnSuma;
    private JPanel jPanel1, jPanelNumeros, jPanelOperaciones, jPanelPantalla;
    private JToggleButton jToggleBtnApagar;
    private JTextField txtFieldOperador, txtFieldAvisos;
    private JFormattedTextField txtFieldLinea1, txtFieldLinea2, txtFieldResultado;

    //Formateo del valor que se muestra en el JTextField txtFieldResultado
    private DecimalFormat df;
    //Variable de tipo doble para almacenar el parseo del campo en el que se encuentra la calculadora
    private double lineaActual;
    //Variable de tipo booleano para cambiar entre el campo txtFieldResultado y txtFieldLinea1. Si es false escribe
    //en txtFieldResultado. Si es true txtFieldLinea1
    private boolean cambia;
    
    private static final long serialVersionUID = 1L;
    //----------------Fin declaración e iniciación de variables útiles-------------

    /**
     * Constructor de la clase Calculadora
     */
    public Calculadora() {

        //------------------Iniciación de variables ----------------------------
        jPanelOperaciones = new JPanel();
        btnSuma = new JButton();
        btnResta = new JButton();
        btnMultiplicar = new JButton();
        btnDividir = new JButton();
        btnIgual = new JButton();
        btnCE = new JButton();
        jToggleBtnApagar = new JToggleButton();
        btnBorrar = new JButton();
        jPanelPantalla = new JPanel();
        txtFieldLinea2 = new JFormattedTextField(new Double(0));
        txtFieldLinea1 = new JFormattedTextField(new Double(0));
        txtFieldOperador = new JTextField();
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
        btnMenos = new JButton();
        btnPunto = new JButton();
        btn0 = new JButton();
        jPanel1 = new JPanel();
        txtFieldAvisos = new JTextField();

        df = new DecimalFormat("#.############");
        cambia = false;
        
        
        //----------------Fin iniciación de variables------------------------

        /*/Configuración del JFrame
        * No permite cambiar de tamaño la ventana para que mantenga el orden de los elementos.
        * Se le asigna una localización al frame de 400 y 400 píxeles
        * Título del JFrame: Calculadora
        */
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(400,400);
        setTitle("Calculadora");

        //---------------------ASIGNACIÓN DE LOS TEXTOS A LOS BOTONES DE OPERACIÓN Y SU RESPECTIVA FUNCIÓN ------
        btnSuma.setText("+");
        btnOperacion(btnSuma);

        btnResta.setText("-");
        btnOperacion(btnResta);

        btnMultiplicar.setText("*");
        btnOperacion(btnMultiplicar);

        btnDividir.setText("/");
        btnOperacion(btnDividir);

        btnIgual.setText("=");
        btnOperacion(btnIgual);

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
                                                .addComponent(btnSuma, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnResta, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelOperacionesLayout.createSequentialGroup()
                                                .addComponent(btnMultiplicar, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDividir, GroupLayout.PREFERRED_SIZE, 60,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelOperacionesLayout.createSequentialGroup()
                                                .addGroup(jPanelOperacionesLayout.createParallelGroup(
                                                        GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnIgual, GroupLayout.PREFERRED_SIZE, 60,
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
                                        .addComponent(btnSuma, GroupLayout.PREFERRED_SIZE, 60,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnResta, GroupLayout.PREFERRED_SIZE, 60,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelOperacionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnDividir, GroupLayout.PREFERRED_SIZE, 60,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMultiplicar, GroupLayout.PREFERRED_SIZE, 60,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelOperacionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCE, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnIgual, GroupLayout.PREFERRED_SIZE, 60,
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
        txtFieldOperador.setEditable(false);
        txtFieldOperador.setFont(new Font("Dialog", 0, 24)); // NOI18N
        txtFieldOperador.setHorizontalAlignment(JTextField.RIGHT);
        txtFieldOperador.setText("");
        txtFieldOperador.setBorder(null);
        jPanelPantalla.add(txtFieldOperador);
        txtFieldOperador.setBounds(12, 40, 330, 30);

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

        btnMenos.setText("+/-");
        btnOperacionEspecial (btnMenos);

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
                                                .addComponent(btnMenos, GroupLayout.PREFERRED_SIZE, 60,
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
                                        .addComponent(btnMenos, GroupLayout.PREFERRED_SIZE, 60,
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
  
    /* El método compruebaCero comprueba que el valor del campo no está vacio.
    * @param textField - Recibe como argumento un campo formateado, del que comprobrará que no está vacio.
    * Si lo está, le pasa como valor un 0.
    */
    private void compruebaCero (JFormattedTextField textField) {

        if (textField.getText().equals(" ")) {

            textField.setText("0");
        } else if (textField.getText().equals("")){

            textField.setText("0");
        }
    }

    /* Método ponSigno para poner el signo del operador al pulsar el boton
    * @param btnsigno - Recibe como argumento un botón que es del que se coge el signo para escribirlo en
    * el campo txtFieldOperador
    */
    private void ponSigno (JButton btnSigno) {

        if (!btnSigno.getText().equals("=")) {

            txtFieldOperador.setText(btnSigno.getText());

        }
    }

    /*Método para devolver el campo en el que la calculadora tiene que escribir. Si el campo de operador
    * txtfieldOperador no tiene ningún valor escribe en la primera línea de la pantalla de la calculadora que se
    * corresponde con el campo txtFieldLinea1. Si tiene algún signo escribe en la tercera línea de la pantalla los
    * dígitos que pulsemos, esta tercera línea se corresponde con el campo txtFieldLinea2.
     */
    private JFormattedTextField campo () {

        JFormattedTextField var;

        if (txtFieldOperador.getText().equals("")) {

            var = txtFieldLinea1;

        } else {

            var = txtFieldLinea2;

        }

        return var;

    }

    /*Método para calcular el resto de un valor de un campo. El fin de este método es determinar si el campo tiene
    * un valor doble o entero. Si hay resto, es doble. Si el resto es 0 es entero.
    * @param campoAComprobar - Recibe el campo sobre que el se quiere calcular el resto
    * @return resto - devuelve el resto
    */
    private double calculoResto (JFormattedTextField campoAComprobar) {

        lineaActual = Double.parseDouble(campoAComprobar.getText());

        int entero = (int) lineaActual;

        double resto = lineaActual - entero;

        return resto;

    }

    /*Método apra calcular el resto de un doble. Este método sirve para saber si hay resto en el campo o no.
    * @param resultadoACalcular - campo de tipo doble sobre el que calcular el resto
    */
    private  double calculaResto (double resultadoACalcular) {

        int entero = (int) resultadoACalcular;

        double resto = resultadoACalcular - entero;

        return resto;

    }

    /*Método para escribir en el campo txtFieldResultado el valor entero o doble.
    */
    private void escribeValor (double valorAEscribir) {

        int entero = (int) valorAEscribir;

        double resto = valorAEscribir - entero;

        if (resto != 0.0) {

            String res = df.format(resto);

            res = res.replace(",",".");

            txtFieldResultado.setText(res);

        } else {

            txtFieldResultado.setText(Integer.toString((int) valorAEscribir));
        }
    }

    /*Método para actualizar los campos de la pantalla.
    * @param valor - Recibe como argumento un valor de tipo doble que va a ser el que va a escribir en la primera
    * línea de la pantalla de la calculadora.
    */
    private void actualizarCampos (double valor) {

        if (!(calculaResto(valor) == 0.0)) {

            txtFieldLinea1.setText(Double.toString(valor));

        } else {

            txtFieldLinea1.setText(Integer.toString((int) valor));

        }

        txtFieldLinea2.setText("");

        txtFieldResultado.setText("");
    }
    
    /* Método para cambiar el tamaño de los campos sobre los que se está escribiendo según la longitud que tengan
    * @param longitudCampo - campo sobre el que trabajar
    * @param boton - boton del que recibe el dígito que tiene que escribir en el campo
    * 
    */
    private void compruebaLongitudCampo (JTextField longitudCampo, JButton boton) {
    	
    	if (longitudCampo.getText().length() < 20) {
        	
    		if (longitudCampo.getText().length() < 6) {
    			
    			longitudCampo.setFont(new Font("Dialog", 1, 18));
    			                	                			
    		} else if (longitudCampo.getText().length() >6 && longitudCampo.getText().length() < 14) {	
    			
    	        longitudCampo.setFont(new Font("Dialog", 1, 16)); // NOI18N

    		} 
    		
    		longitudCampo.setText(longitudCampo.getText() + boton.getText());
        	
        } else if (longitudCampo.getText().length() == 20){
        	
        	longitudCampo.setText(longitudCampo.getText());
        	
        } else if (longitudCampo.getText().length() == 0) {
        	
        	longitudCampo.setFont(new Font("Dialog", 1, 18));
        };
    }
        

    /*/Método btn
    * @param boton - recibe como parámetro el botón sobre el que lo usamos. Añade un KeyListener para capturar las
    * teclas y pulsar el botón correspondiente. También se añade un ActionListener para ejecutar las acciones asignadas
    * a ese botón. Este método es solo para los botones numéricos. Comprueba si se pulsa el botón del punto "."
    * para escribir después del punto.
    *
    */
    private void btn (final JButton boton) {

        boton.setFocusable(false);
        
        
        //Añade un KeyListener para capturar las teclas del teclado
        boton.addKeyListener(new PresionarTecla());

        //Añade un ActionListener para realizar escribir el número en el campo
        boton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                //Hace una llamada al método compruebaCero para poner a Cero el campo en caso de que sea null
                compruebaCero(campo());

                //Inicia la variable lineaActual con una conversión a doble de la cadena que hay en el campo
                lineaActual = Double.parseDouble(campo().getText());

                //Si el valor de la lineaActual es 0 y el campo no contiene un punto escribe el dígito del botón.
                //Este caso ocurre cuando escribimos el primer dígito y no existe nada en el campo.
                if (lineaActual == 0 && !campo().getText().contains(".")) {

                    campo().setText(boton.getText());

                //En caso de que no se cumplan las anteriores escribe el dígito del botón después del valor del campo
                } else {
                	
                	compruebaLongitudCampo(campo(), boton);
                	
                }
            }
        });
    }

    /* Este método es para los botones de cambio de valor "+/-" y el botón del punto "."
    * @param - boton - Comprueba si se han pulsado y les indica que hacer en tal caso. Recibe como parámetro el
    * propio botón. En cualquiera de los dos casos realiza la acción del botón en cuestión.
    */
    private void btnOperacionEspecial (final JButton boton) {

        boton.setFocusable(false);

        boton.addKeyListener(new PresionarTecla());

        boton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                compruebaCero(campo());

                double campoCambiaSigno = Double.parseDouble(campo().getText());

                switch (boton.getText()) {

                    case "+/-":

                        campoCambiaSigno = -+campoCambiaSigno;
       
                        if (!(calculoResto(campo()) == 0.0)) {
               
                            campo().setText(Double.toString(campoCambiaSigno));

                        } else {
               
                            campo().setText(Integer.toString((int) campoCambiaSigno));

                        }

                        break;

                    case ".":

                        if (campo().getText().equals("0")) {

                            campo().setText("0.");
                        }

                        if (!campo().getText().contains(".")) {

                            campo().setText(campo().getText()+".");
                        }

                        break;

                }
            }
        });
    }

    /*Método para obtener el resultado.
    * @param boton - Recibe como parámetro el propio botón. Añade un KeyListener para escuchar las teclas que se
    * pulsan en el teclado y pulsar el botón correspondiente en la calcuadora. Además añade un ActionListener para
    * realizar la función asignada.
    */
    private void btnOperacion (final JButton boton) {

        boton.setFocusable(false);

        boton.addKeyListener(new PresionarTecla());

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Llama al método para poner el signo del botón que se ha pulsado en el campo txtFieldOperador
                ponSigno(boton);

                //Comprueba que los campos no están vacíos
                compruebaCero(campo());
                compruebaCero(txtFieldLinea1);
                compruebaCero(txtFieldLinea2);
                compruebaCero(txtFieldResultado);

                //Se crean cuatro variables para convertir los valores de los campos a doble y a String para el signo
                double linea1 = Double.parseDouble(txtFieldLinea1.getText());
                double linea2 = Double.parseDouble(txtFieldLinea2.getText());
                String signo = txtFieldOperador.getText();
                double resultado = Double.parseDouble(txtFieldResultado.getText());

                if (linea1 != 0.0 && linea2 == 0.0) {

                    ponSigno(boton);

                } else if (linea1 != 0.0 && linea2 != 0.0 && resultado == 0.0
                        || linea1 == 0.0 && linea2 != 0.0 && resultado != 0.0
                        || linea1 == 0.0 && linea2 != 0.0 && resultado == 0.0) {

                    //switch case para realizar los cálculos
                    switch (boton.getText()) {

                        case "+":

                            resultado = linea1 + linea2;

                            break;

                        case "-":

                            resultado = linea1 - linea2;

                            break;

                        case "*":

                            resultado = linea1 * linea2;

                            break;

                        case "/":

                            resultado = linea1 / linea2;

                            break;

                        //Si se pulsa el signo = realiza la operación según el signo del campo txtFieldOperador
                        case "=":

                            if (signo.equals("+")) {

                                resultado = linea1 + linea2;
                            }

                            if (signo.equals("-")) {

                                resultado = linea1 - linea2;
                            }

                            if (signo.equals("*")) {

                                resultado = linea1 * linea2;
                            }

                            if (signo.equals("/")) {

                                resultado = linea1 / linea2;
                            }

                            break;

                    }

                    /*Si el resultado es cero comprueba que los valores de linea1 y linea2 son diferentes de 0 y
                    * si la variable cambia es falsa. Por defecto está iniciada en false para que muestre el resultado
                    * en el campo txtFieldResultado. Cuando lo muestra cambia el valor de la variable cambia a true
                    * por si se vuelve a pulsar y el resultado sigue siendo cero. Si se cumple escribe en la primera
                    * línea de la calculadora (txtFieldLinea1) el valor del campo txtFieldResultado
                    */
                    if (resultado==0) {

                        if (linea1 != 0 && linea2 != 0 && cambia == false) {

                            escribeValor(resultado);

                            cambia = true;

                        } else {

                            actualizarCampos(resultado);

                            cambia = false;
                        }
                    }

                    /*Comprueba si el resultado tiene decimales. Si los tiene aplica el formato de la variable df
                    * y lo escribe en el campo txtFieldResultado. Si no solo escribe la parte entera en el campo.
                    */
                    if (!(calculaResto(resultado) == 0.0)) {

                            String res = df.format(resultado);

                            res = res.replace(",", ".");

                        txtFieldResultado.setText(res);


                    } else {

                        txtFieldResultado.setText(Integer.toString((int) resultado));

                    }

                    /*Si la primera línea es 0, línea2 y resultado son diferentes de cero escribe el signo del botón
                    * pulsado en el campo txtFieldOperador y escribe el valor de resultado en la primera línea
                    * txtFieldLinea1
                    */

                    if (linea1 == 0.0 && linea2 !=0.0 && resultado !=0.0) {

                        if (!cambia) {

                            if (!(calculaResto(resultado) == 0.0)) {

                                String res = df.format(resultado);

                                res = res.replace(",", ".");

                                txtFieldResultado.setText(res);

                            } else {

                                txtFieldResultado.setText(Integer.toString((int) resultado));

                            }

                            cambia = true;

                        } else if (cambia) {

                            actualizarCampos(resultado);

                            cambia = false;
                        }
                    }

                } else if ((linea1 != 0.0 && linea2 != 0.0 && resultado != 0.0)
                        || (linea1 == 0.0 && linea2 != 0.0 && resultado !=0.0)) {

                    ponSigno(boton);

                    actualizarCampos(resultado);

                }
            }
        });
    }

    /* Este método es para los botones de retroceso y borrado de la pantalla
    * @param boton - Recibe como parámetro el propio botón. Si el botón es el de retroceso borra el último carácter de
    * la línea y escribe un cero si el carácter es un cero "0", un signo "-" o un cero y un punto "0.". 
    * Si es el botón de borrado, vacía todos los campos y deja el cursor en el primer JFormattedTextField 
    * txtFieldLinea1.
    */
    private void btnBorrar (final JButton boton) {

        boton.setFocusable(false);

        boton.addKeyListener(new PresionarTecla());

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                compruebaCero(campo());

                switch (boton.getText()) {

                    case "Bor":

                        String cadena = campo().getText();

                        if (cadena.length() != 0) {

                            cadena = cadena.substring(0, cadena.length() - 1);

                            if (cadena.length() >=8 && cadena.length() <=20) {
                            	
                    	        campo().setFont(new Font("Dialog", 1, 16)); // NOI18N
                    	        
                            } else if (cadena.length() <=8) {
                            	
                            	campo().setFont(new Font("Dialog", 1, 18));
                            	
                            }
                        		
                        	campo().setText(cadena);
                            
                            }
     
                            if (cadena.length() == 0 || cadena.equals("-") || cadena.equals("-0")) {
                            	
                            	campo().setFont(new Font("Dialog", 1, 18));

                                campo().setText("0");

                            }

                        break;

                    case "CE":

                        txtFieldLinea1.setText("");
                        txtFieldLinea2.setText("");
                        txtFieldOperador.setText("");
                        txtFieldResultado.setText("");

                        break;

                }
            }
        });
    }

    //Método para capturar la tecla del teclado que se ha pulsado y pulsar el botón correspondiente en la calculadora
    private class PresionarTecla extends KeyAdapter {

        public void keyPressed(KeyEvent ke) {

            switch (ke.getKeyChar()) {

                case '/':

                    btnDividir.doClick();

                    break;

                case '*':

                    btnMultiplicar.doClick();

                    break;

                case '+':

                    btnSuma.doClick();

                    break;

                case '-':

                    btnResta.doClick();

                    break;

                case '=':

                    btnIgual.doClick();

                    break;

                case '.':

                    btnPunto.doClick();

                    break;

                case '0':

                    btn0.doClick();

                    break;

                case '1':

                    btn1.doClick();

                    break;

                case '2':

                    btn2.doClick();

                    break;

                case '3':

                    btn3.doClick();

                    break;

                case '4':

                    btn4.doClick();

                    break;

                case '5':

                    btn5.doClick();

                    break;

                case '6':

                    btn6.doClick();

                    break;

                case '7':

                    btn7.doClick();

                    break;

                case '8':

                    btn8.doClick();

                    break;

                case '9':

                    btn9.doClick();

                    break;

                case 'c':

                    btnCE.doClick();

                    break;

                case 'C':

                    btnCE.doClick();

                    break;

            }

            switch (ke.getKeyCode()) {

                case KeyEvent.VK_ENTER:

                    btnIgual.doClick();

                    break;

                case KeyEvent.VK_BACK_SPACE:

                    btnBorrar.doClick();

                    break;

                case KeyEvent.VK_CONTROL:

                    btnMenos.doClick();

                    break;

                case KeyEvent.VK_ESCAPE:

                    jToggleBtnApagar.doClick();

                    break;

            }
        }
    }
}
