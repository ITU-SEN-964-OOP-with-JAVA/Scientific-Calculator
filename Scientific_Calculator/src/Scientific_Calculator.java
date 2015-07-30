/**
 * @author Xueyuan
 */

public class Scientific_Calculator extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton [] jButtons = null;
    private javax.swing.JTextField jTextField = null;
    private Calculator calculator = new Calculator();
    // End of variables declaration//GEN-END:variables

    // Constant values
    private final int BUTTON_WIDTH  = 65;
    private final int BUTTON_HEIGHT = 30;
    private final int BUTTON_PER_LINE = 8;

    /**
     * Creates new form Scientific_Calculator
     */
    public Scientific_Calculator() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // TextField
        this.jTextField = new javax.swing.JTextField();
        this.jTextField.setEditable(false);
        this.jTextField.setColumns(20);
        //this.jTextField.setRows(2);
        this.jTextField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        //this.jTextField.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        this.jTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldFocusLost(evt);
            }
        });
        this.jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldKeyReleased(evt);
            }
        });

        // Buttons
        // Refer to http://docs.oracle.com/javase/7/docs/api/java/lang/Math.html
        String [] buttonsText = {"(", ")", "log", "ln", "back", "CE", "C", "/",
                                 "abs", "neg", "exp", "", "7", "8", "9", "*",
                                 "sin", "csc", "sqrt", "cbrt", "4", "5", "6", "-",
                                 "cos", "sec", "", "", "1", "2", "3", "+",
                                 "tan", "cot", "", "", "0", ".", "%", "="};
        // init all buttons
        this.jButtons = new javax.swing.JButton[buttonsText.length];

        // button listener
        java.awt.event.ActionListener btnActionListener = new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        };

        for(int i=0; i<buttonsText.length; i++) {
            jButtons[i] = new javax.swing.JButton();
            jButtons[i].setText(buttonsText[i]);
            jButtons[i].addActionListener(btnActionListener);
            if ("".equals(buttonsText[i])) {
                jButtons[i].setEnabled(false);
            }
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        // Turn on automatically adding gaps between components
        layout.setAutoCreateGaps(true);

        // Turn on automatically creating gaps between components that touch
        // the edge of the container and the container.
        layout.setAutoCreateContainerGaps(true);

        getContentPane().setLayout(layout);

        javax.swing.GroupLayout.ParallelGroup vGroup = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE);

        javax.swing.GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup()
            .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE);

        
        javax.swing.GroupLayout.SequentialGroup hTmpGroup = null;
        javax.swing.GroupLayout.ParallelGroup   vTmpGroup = null;
        for(int i=0; i<buttonsText.length; i++) {
            if (i%BUTTON_PER_LINE == 0) {
                hTmpGroup = layout.createSequentialGroup();
                vTmpGroup = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE);
            }

            hTmpGroup.addComponent(jButtons[i], javax.swing.GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, javax.swing.GroupLayout.PREFERRED_SIZE);
            vTmpGroup.addComponent(jButtons[i], javax.swing.GroupLayout.PREFERRED_SIZE, BUTTON_HEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE);

            if (i%BUTTON_PER_LINE == (BUTTON_PER_LINE-1)) {
                vGroup.addGroup(hTmpGroup);
                hGroup.addGroup(vTmpGroup);
            }
        }

        layout.setHorizontalGroup(vGroup);

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hGroup)
        );

        pack();
    }

    private void jTextFieldFocusLost(java.awt.event.FocusEvent evt) {                                     
        // TODO add your handling code here:
        this.jTextField.requestFocus();
    }
    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        // TODO add your handling code here:
        System.out.println(evt.getActionCommand());
        calculator.addInput(evt.getActionCommand());
        jTextField.setText(jTextField.getText() + evt.getActionCommand());
        //jTextField.append(evt.getActionCommand());
    }
    private void jTextFieldKeyReleased(java.awt.event.KeyEvent evt) {                                       
        // TODO add your handling code here:
        char ch = evt.getKeyChar();
        
        //System.out.println(event.toString());
        //System.out.println(String.format("Key Pressed: %c", ch));
        
        if (evt.getKeyCode() == 27) { // 27 is key "Esc"
            System.exit(0);
            // TODO change to CE?
        }
        
         // replace '\n' to '='
        if (ch == '\n') { ch = '='; }
        
        if (Character.isDigit(ch) || ch == '.' ||
                ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' ||
                ch == '=' ||
                ch == '(' || ch == ')') {
            calculator.addInput(String.valueOf(ch));
            jTextField.setText(jTextField.getText() + String.valueOf(ch));
            System.out.println(String.format("Key Pressed: %c", ch));
        } else {
            // ignore other inputs
        }
    }
    private static boolean jvmSupported(){
        String version = System.getProperty("java.version");
        if (version.startsWith("1.7") || version.startsWith("1.8")) {
            return true;
        } else {
            System.out.println("JVM version " + version + " not supported.");
            return false;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // check the version of JVM, lower than 1.7 not supported.
        if (!jvmSupported()) {return;}

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Scientific_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scientific_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scientific_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scientific_Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Scientific_Calculator().setVisible(true);
            }
        });
    }
}

class Calculator {
    // private parameters
    private javax.script.ScriptEngineManager manager = new javax.script.ScriptEngineManager();
    private javax.script.ScriptEngine engine = manager.getEngineByName("js");

    public Calculator(){}

    public void addInput(String c) {
        ;
    }
    public String getInput() {
        return "";
    }
    public String getOutput() {
        try {
            Object result = engine.eval("Math.sin(3+4)");
            System.out.println(result.toString());
            return result.toString();
        } catch (javax.script.ScriptException se) {
            System.out.println(se.toString());
            return se.toString();
        }
    }
}