/**
 *  ITU SEN964 OOP with JAVA Final project:
 * 
 *  Title: Scientific Calculator
 * 
 *  Students:
 *      Mei Qiao        (ITU id: 85325)
 *      Xueyuan Zhang   (ITU id: 86209)
 *      Xi Wang         (ITU id: 88614)
 *      Hanwen Yang     (ITU id: 86971)
 *      Ling Lok Ngai   (ITU id: 88582)
 *      Benben Li       (ITU id: 89151)
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
    private final int BUTTON_PER_LINE = 7;

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
        this.setTitle("SEN964 - Scientific Calculator");
        this.setResizable(false);
        this.setLocationByPlatform(true);
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
        String [] buttonsText = {"(", ")", "abs", "", "BACK", "C", "/",
                                 "ceil", "floor", "log", "7", "8", "9", "*",
                                 "sin", "asin", "exp", "4", "5", "6", "-",
                                 "cos", "acos", "sqrt", "1", "2", "3", "+",
                                 "tan", "atan", "round", "0", ".", "%", "="};
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
        String str = new String(evt.getActionCommand());
        calculator.addInput(str);
        jTextField.setText(calculator.getOutput());
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
        if (ch == '\n' || ch == '=') {
            ch = '=';
        }
        
        if (Character.isDigit(ch) || ch == '.' ||
                ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' ||
                ch == '(' || ch == ')' || ch == '=') {

            calculator.addInput(ch);
            //jTextField.setText(jTextField.getText() + String.valueOf(ch));
            jTextField.setText(calculator.getOutput());
            System.out.println(String.format("Key Pressed: %c", ch));
        } else {
            // ignore other inputs
        }
    }

    private static boolean jvmSupported(){
        String version = System.getProperty("java.version");
        if (version.startsWith("1.6") || version.startsWith("1.7") || version.startsWith("1.8")) {
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
        
        //if (!testCalculator()) {return;}

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
    private java.util.ArrayList<String> list = null;
    private String ans = null;
    private int open_bracket = 0;
    private boolean first_input = true;
    public Calculator(){
        list = new java.util.ArrayList<String>();
    }

    public void addInput(char c) {
        addInput(String.valueOf(c));
    }

    public void addInput(String s) {
        if (s.equals("=")) {
            //parseInput();
            System.out.println(ans);
            first_input = true;
            if(!list.isEmpty()) {
                ans = calculate(ans);
                return;
            }
        } else if (s.equals("C")) {
            this.reset();
        } else if (s.equals("BACK")) {
            if(!this.list.isEmpty()) {
                if(list.get(list.size() - 1).contains("(")) {
                    open_bracket--;
                }
                list.remove(list.size() - 1);
            }
        } else if (s.equals("(")) {
            if(this.list.isEmpty()) {
                list.add(s);
                this.open_bracket++;
            } else {
                String lastElement = list.get(list.size()-1);
                if(!this.isUnaryOperator(lastElement) && !this.isBinaryOperator(lastElement)) {
                    list.add("*"+s);
                this.open_bracket++;
                }
            }
        } else if (s.equals(")")) {
            list.add(s);
            if(this.open_bracket>=0) {
                this.open_bracket--;                
            }
        } else if (this.isUnaryOperator(s)) { // sin, cos, ...
            if(this.list.isEmpty()) {
                list.add("Math."+s+"(");
                open_bracket++;
            }
            else{
                String lastElement = list.get(list.size()-1);
                if(this.isUnaryOperator(lastElement)){
                    String withStar = lastElement.startsWith("*")?"*":"";
                    list.set(list.size() - 1, withStar + "Math."+s+"(");
                } else if(this.isBinaryOperator(lastElement)){
                    list.add("Math."+s+"(");
                    open_bracket++;
                } else if (first_input) {
                    list.set(list.size() - 1, "Math."+s+"(");
                    open_bracket++;
                } else {
                    list.add("*Math."+s+"(");
                    open_bracket++;
                }
            }
        } else if (this.isBinaryOperator(s)) {
            if(this.list.isEmpty()) {
                list.add(s);
            }
            else{
                String lastElement = list.get(list.size()-1);
                if(this.isBinaryOperator(lastElement)){
                    list.set(list.size() - 1, s);
                } else {
                    list.add(s);
                }
            }
        } else {
            // if previous result is number and current input is number as well
            if(list.isEmpty()) {
                list.add(s);
            } else if (first_input) {
                list.set(list.size() - 1, s);
            } else {
                list.add(s);
            }
        }
        first_input = false;
        parseInput();
    }
    
    private void parseInput() {
        String str = "";
        for(int i = 0; i<list.size(); i++) {
            str += list.get(i);
        }
        for(int i = 0; i<open_bracket; i++) {
            str += ")";
        }
        ans = str;
    }
    private void reset() {
        open_bracket = 0;
        list.clear();
    }
    private String calculate(String str) {
        try {
            Object result = engine.eval(str);
            System.out.println("Result " + result.toString());
            reset();
            if (("NaN").equals(result.toString())) {
                return "Fail to parse " + str;
            } else {
                list.add(result.toString());
                return result.toString();
            }
        } catch (javax.script.ScriptException se) {
            System.out.println(se.toString());
            reset();
            //return se.toString();
            return "Fail to parse " + str;
        }
    }
    private boolean isBinaryOperator(String str) {
        return str.equals("+")  || str.equals("-")  ||
               str.equals("*")  || str.equals("/");
    }
    private boolean isUnaryOperator(String str) {
        return str.equals("sin")  || str.equals("asin")  ||
               str.equals("cos")  || str.equals("acos")  ||
               str.equals("log")  || str.equals("ln")    ||
               str.equals("tan")  || str.equals("atan")  ||
               str.equals("sqrt") || str.equals("round") ||
               str.equals("exp")  || str.equals("abs")   ||
               str.equals("floor")|| str.equals("ceil")  ||

               str.equals("Math.sin(")  || str.equals("Math.asin(")  ||
               str.equals("Math.cos(")  || str.equals("Math.acos(")  ||
               str.equals("Math.log(")  || str.equals("Math.ln(")    ||
               str.equals("Math.tan(")  || str.equals("Math.atan(")  ||
               str.equals("Math.sqrt(") || str.equals("Math.round(") ||
               str.equals("Math.exp(")  || str.equals("Math.abs(")   ||
               str.equals("Math.floor(")|| str.equals("Math.ceil(")  ||

               str.equals("*Math.sin(")  || str.equals("*Math.asin(")  ||
               str.equals("*Math.cos(")  || str.equals("*Math.acos(")  ||
               str.equals("*Math.log(")  || str.equals("*Math.ln(")    ||
               str.equals("*Math.tan(")  || str.equals("*Math.atan(")  ||
               str.equals("*Math.sqrt(") || str.equals("*Math.round(") ||
               str.equals("*Math.exp(")  || str.equals("*Math.abs(")   ||
               str.equals("*Math.floor(")|| str.equals("*Math.ceil(");
    }
    public String getOutput() {
        return ans;
    }
}
