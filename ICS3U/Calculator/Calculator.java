package com.company;
// import java swing, awt and script
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.script.*;
/*
Name: Jerry Zhang
Project: Calculator
Purpose: program a fully functional calculator using Java Swing
Date: Apr.6
 */
public class Calculator {
    // initialize global variables
    static String textFieldInput;
    public static void main(String[] args) {
        // initialize image icon
        ImageIcon img = new ImageIcon("com/company/Calculator-icon.png");
        // initialize Jframe
        JFrame frame = new JFrame("Calculator");
        frame.setSize(470,540);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(23,24,26));
        frame.setIconImage(img.getImage());
        // initialize textfield
        JTextField display = new JTextField("Welcome To Jerry's Calculator");
        display.setBackground(new Color(37,41,50));
        display.setForeground(Color.WHITE);
        display.setPreferredSize(new Dimension(350,125));
        display.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        display.setHorizontalAlignment(SwingConstants.CENTER);
        display.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                // update the textfield input every time the text field is changed
                textFieldInput = display.getText();
                // for debug
                // System.out.println(textFieldInput);
            }
        });
        // initialize the Jpanel
        JPanel mainPanel = new JPanel();
        mainPanel.setSize(340,415);
        mainPanel.setLayout(new GridLayout(6,5,1,1));
        mainPanel.setBackground(new Color(23,24,26));

        // User Interface color: Dark Mode
        // Avogadro's Number used in Chemistry Calculations
        JButton buttonNA = new JButton("N\u2090");
        // set the font as well as font size
        buttonNA.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        // set font color
        buttonNA.setForeground(Color.WHITE);
        // set background color
        buttonNA.setBackground(new Color(37,41,50));
        // Set preferred size
        buttonNA.setPreferredSize(new Dimension(75,75));
        // For MacOS Only, Do not need setOpaque for Windows
        buttonNA.setOpaque(true);
        buttonNA.setBorderPainted(false);
        buttonNA.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("6.02*10^23");
                // Avogadro's number
                display.setText(display.getText()+"6.02e23");
            }
        });
        // natural logarithm
        JButton buttonLog = new JButton("log");
        buttonLog.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        buttonLog.setForeground(Color.WHITE);
        buttonLog.setBackground(new Color(37,41,50));
        buttonLog.setPreferredSize(new Dimension(75,75));
        buttonLog.setOpaque(true);
        buttonLog.setBorderPainted(false);
        buttonLog.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("log");
                display.setText(display.getText()+"log(");
            }
        });
        // absolute value
        JButton buttonabs = new JButton("abs");
        buttonabs.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        buttonabs.setForeground(Color.WHITE);
        buttonabs.setBackground(new Color(37,41,50));
        buttonabs.setPreferredSize(new Dimension(75,75));
        buttonabs.setOpaque(true);
        buttonabs.setBorderPainted(false);
        buttonabs.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("abs");
                display.setText(display.getText()+"abs(");
            }
        });
        // Square root
        JButton buttonsqrt = new JButton("\u221A");
        buttonsqrt.setFont(new Font("sans serif", Font.PLAIN, 25));
        buttonsqrt.setForeground(Color.WHITE);
        buttonsqrt.setBackground(new Color(37,41,50));
        buttonsqrt.setPreferredSize(new Dimension(75,75));
        buttonsqrt.setOpaque(true);
        buttonsqrt.setBorderPainted(false);
        buttonsqrt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("√");
                display.setText(display.getText()+"√(");
            }
        });
        // modulo
        JButton buttonRem = new JButton("%");
        buttonRem.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        buttonRem.setForeground(Color.WHITE);
        buttonRem.setBackground(new Color(37,41,50));
        buttonRem.setPreferredSize(new Dimension(75,75));
        buttonRem.setOpaque(true);
        buttonRem.setBorderPainted(false);
        buttonRem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("%");
                display.setText(display.getText()+"%");
            }
        });
        // sine
        JButton buttons = new JButton("sin");
        buttons.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        buttons.setForeground(Color.WHITE);
        buttons.setBackground(new Color(37,41,50));
        buttons.setPreferredSize(new Dimension(75,75));
        buttons.setOpaque(true);
        buttons.setBorderPainted(false);
        buttons.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("sin");
                display.setText(display.getText()+"sin(");
            }
        });
        // cosine
        JButton buttonc = new JButton("cos");
        buttonc.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        buttonc.setForeground(Color.WHITE);
        buttonc.setBackground(new Color(37,41,50));
        buttonc.setPreferredSize(new Dimension(75,75));
        buttonc.setOpaque(true);
        buttonc.setBorderPainted(false);
        buttonc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("cos");
                display.setText(display.getText()+"cos(");
            }
        });
        // tangent
        JButton buttont = new JButton("tan");
        buttont.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        buttont.setForeground(Color.WHITE);
        buttont.setBackground(new Color(37,41,50));
        buttont.setPreferredSize(new Dimension(75,75));
        buttont.setOpaque(true);
        buttont.setBorderPainted(false);
        buttont.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("tan");
                display.setText(display.getText()+"tan(");
            }
        });
        // exponent of euler's constant
        JButton buttonExp = new JButton("\u2107");
        buttonExp.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        buttonExp.setForeground(Color.WHITE);
        buttonExp.setBackground(new Color(37,41,50));
        buttonExp.setPreferredSize(new Dimension(75,75));
        buttonExp.setOpaque(true);
        buttonExp.setBorderPainted(false);
        buttonExp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("exp");
                display.setText(display.getText()+"exp(");
            }
        });
        // Clear
        JButton button1 = new JButton("AC");
        button1.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button1.setForeground(Color.WHITE);
        button1.setBackground(new Color(255,149,0));
        button1.setPreferredSize(new Dimension(75,75));
        // For MacOS Only, Do not need setOpaque for Windows
        button1.setOpaque(true);
        button1.setBorderPainted(false);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("AC");
                display.setText("");
            }
        });
        // Delete the last digit
        JButton buttonDEL = new JButton("DEL");
        buttonDEL.setFont(new Font("Helveti⚙ca Neue", Font.PLAIN, 25));
        buttonDEL.setForeground(Color.WHITE);
        buttonDEL.setBackground(new Color(255,149,0));
        buttonDEL.setPreferredSize(new Dimension(75,75));
        // For MacOS Only, Do not need setOpaque for Windows
        buttonDEL.setOpaque(true);
        buttonDEL.setBorderPainted(false);
        buttonDEL.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("DEL");
                textFieldInput = display.getText();
                if(textFieldInput != null && textFieldInput.length() > 0){
                    textFieldInput = textFieldInput.substring(0,textFieldInput.length()-1);
                    display.setText(textFieldInput);
                }
            }
        });
        // bracket
        JButton button2 = new JButton("(");
        button2.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button2.setForeground(Color.WHITE);
        button2.setBackground(new Color(37,41,50));
        button2.setPreferredSize(new Dimension(75,75));
        button2.setOpaque(true);
        button2.setBorderPainted(false);
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("(");
                display.setText(display.getText()+"(");
            }
        });
        // bracket
        JButton button3 = new JButton(")");
        button3.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button3.setForeground(Color.WHITE);
        button3.setBackground(new Color(37,41,50));
        button3.setPreferredSize(new Dimension(75,75));
        button3.setOpaque(true);
        button3.setBorderPainted(false);
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(")");
                display.setText(display.getText()+")");
            }
        });
        // division
        JButton button4 = new JButton("÷");
        button4.setFont(new Font("Helvetica Neue", Font.PLAIN, 35));
        button4.setForeground(Color.WHITE);
        button4.setBackground(new Color(46,201,115));
        button4.setPreferredSize(new Dimension(75,75));
        button4.setOpaque(true);
        button4.setBorderPainted(false);
        button4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("÷");
                display.setText(display.getText()+"÷");
            }
        });
        // number 7
        JButton button5 = new JButton("7");
        button5.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button5.setForeground(Color.WHITE);
        button5.setBackground(new Color(37,41,50));
        button5.setPreferredSize(new Dimension(75,75));
        button5.setOpaque(true);
        button5.setBorderPainted(false);
        button5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("7");
                display.setText(display.getText()+"7");
            }
        });
        //number 8
        JButton button6 = new JButton("8");
        button6.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button6.setForeground(Color.WHITE);
        button6.setBackground(new Color(37,41,50));
        button6.setPreferredSize(new Dimension(75,75));
        button6.setOpaque(true);
        button6.setBorderPainted(false);
        button6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("8");
                display.setText(display.getText()+"8");
            }
        });
        // number 9
        JButton button7 = new JButton("9");
        button7.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button7.setForeground(Color.WHITE);
        button7.setBackground(new Color(37,41,50));
        button7.setPreferredSize(new Dimension(75,75));
        button7.setOpaque(true);
        button7.setBorderPainted(false);
        button7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("9");
                display.setText(display.getText()+"9");
            }
        });
        // multiply
        JButton button8 = new JButton("x");
        button8.setFont(new Font("Helvetica Neue", Font.PLAIN, 35));
        button8.setForeground(Color.WHITE);
        button8.setBackground(new Color(46,201,115));
        button8.setPreferredSize(new Dimension(75,75));
        button8.setOpaque(true);
        button8.setBorderPainted(false);
        button8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("x");
                display.setText(display.getText()+"*");
            }
        });
        // number 4
        JButton button9 = new JButton("4");
        button9.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button9.setForeground(Color.WHITE);
        button9.setBackground(new Color(37,41,50));
        button9.setPreferredSize(new Dimension(75,75));
        button9.setOpaque(true);
        button9.setBorderPainted(false);
        button9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("4");
                display.setText(display.getText()+"4");
            }
        });
        // number 5
        JButton button10 = new JButton("5");
        button10.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button10.setForeground(Color.WHITE);
        button10.setBackground(new Color(37,41,50));
        button10.setPreferredSize(new Dimension(75,75));
        button10.setOpaque(true);
        button10.setBorderPainted(false);
        button10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("5");
                display.setText(display.getText()+"5");
            }
        });

        // number 6
        JButton button11 = new JButton("6");
        button11.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button11.setForeground(Color.WHITE);
        button11.setBackground(new Color(37,41,50));
        button11.setPreferredSize(new Dimension(75,75));
        button11.setOpaque(true);
        button11.setBorderPainted(false);
        button11.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("6");
                display.setText(display.getText()+"6");
            }
        });
        // subtract
        JButton button12 = new JButton("-");
        button12.setFont(new Font("Helvetica Neue", Font.PLAIN, 35));
        button12.setForeground(Color.WHITE);
        button12.setBackground(new Color(46,201,115));
        button12.setPreferredSize(new Dimension(75,75));
        button12.setOpaque(true);
        button12.setBorderPainted(false);
        button12.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("-");
                display.setText(display.getText()+"-");
            }
        });
        // number 1
        JButton button13 = new JButton("1");
        button13.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button13.setForeground(Color.WHITE);
        button13.setBackground(new Color(37,41,50));
        button13.setPreferredSize(new Dimension(75,75));
        button13.setOpaque(true);
        button13.setBorderPainted(false);
        button13.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("1");
                display.setText(display.getText()+"1");
            }
        });
        // number 2
        JButton button14 = new JButton("2");
        button14.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button14.setForeground(Color.WHITE);
        button14.setBackground(new Color(37,41,50));
        button14.setPreferredSize(new Dimension(75,75));
        button14.setOpaque(true);
        button14.setBorderPainted(false);
        button14.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("2");
                display.setText(display.getText()+"2");
            }
        });
        // number 3
        JButton button15 = new JButton("3");
        button15.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button15.setForeground(Color.WHITE);
        button15.setBackground(new Color(37,41,50));
        button15.setPreferredSize(new Dimension(75,75));
        button15.setOpaque(true);
        button15.setBorderPainted(false);
        button15.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                display.setText(display.getText()+"3");
                System.out.println("3");
            }
        });
        // add
        JButton button16 = new JButton("+");
        button16.setFont(new Font("Helvetica Neue", Font.PLAIN, 35));
        button16.setForeground(Color.WHITE);
        button16.setBackground(new Color(46,201,115));
        button16.setPreferredSize(new Dimension(75,75));
        button16.setOpaque(true);
        button16.setBorderPainted(false);
        button16.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("+");
                display.setText(display.getText()+"+");
            }
        });
        //pi
        JButton button17 = new JButton("π");
        button17.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button17.setForeground(Color.WHITE);
        button17.setBackground(new Color(37,41,50));
        button17.setPreferredSize(new Dimension(75,75));
        button17.setOpaque(true);
        button17.setBorderPainted(false);
        button17.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("π");
                display.setText(display.getText()+"π");
            }
        });
        //number zero
        JButton button18 = new JButton("0");
        button18.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button18.setForeground(Color.WHITE);
        button18.setBackground(new Color(37,41,50));
        button18.setPreferredSize(new Dimension(75,75));
        button18.setOpaque(true);
        button18.setBorderPainted(false);
        button18.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                display.setText(display.getText()+"0");
                System.out.println("0");
            }
        });
        // decimal
        JButton button19 = new JButton(".");
        button19.setFont(new Font("Helvetica Neue", Font.PLAIN, 25));
        button19.setForeground(Color.WHITE);
        button19.setBackground(new Color(37,41,50));
        button19.setPreferredSize(new Dimension(75,75));
        button19.setOpaque(true);
        button19.setBorderPainted(false);
        button19.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                display.setText(display.getText()+".");
                System.out.println(".");
            }
        });
        // equals button
        JButton button20 = new JButton("=");
        button20.setFont(new Font("Helvetica Neue", Font.PLAIN, 35));
        button20.setForeground(Color.WHITE);
        button20.setBackground(new Color(46,201,115));
        button20.setPreferredSize(new Dimension(75,75));
        button20.setOpaque(true);
        button20.setBorderPainted(false);
        button20.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // get the textfield input
                textFieldInput = display.getText();
                System.out.println("=");
                // initialize script engine
                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByName("JavaScript");
                // check if it equals to null
                if(textFieldInput.equals("")){
                    JOptionPane error_window = new JOptionPane();
                    JOptionPane.showMessageDialog(frame,"Input Cannot be Null","Error",JOptionPane.ERROR_MESSAGE);
                }
                // if not null
                else {
                    try {
                        String finalText;
                        // replace the math symbols to text
                        finalText = textFieldInput.replace("√", "sqrt");
                        finalText = textFieldInput.replace("π", "pi");
                        // replace text with math functions
                        engine.eval("var log = Math.log");
                        engine.eval("var sin = Math.sin");
                        engine.eval("var cos = Math.cos");
                        engine.eval("var tan = Math.tan");
                        engine.eval("var abs = Math.abs");
                        engine.eval("var sqrt = Math.sqrt");
                        engine.eval("var exp = Math.exp");
                        engine.eval("var pi = Math.PI");
                        if(engine.eval(finalText)==null){
                            JOptionPane.showMessageDialog(frame, "The result is NULL, Please input your number again", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                        else {
                            // debug
                            System.out.println(engine.eval(finalText));
                            // display the input as well as the answer
                            display.setText((textFieldInput) + " = " + engine.eval(finalText));
                        }
                    } catch (ArithmeticException ex) {
                        // catch if something is divided by 0
                        JOptionPane.showMessageDialog(frame, "Arithmetic Error", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (ScriptException ex) {
                        // Display Warning to the user and ask them to input again
                        JOptionPane.showMessageDialog(frame, "ERROR, Please input your number again", "Warning", JOptionPane.WARNING_MESSAGE);
                    } catch (Exception ex) {
                        // catch exception
                        JOptionPane.showMessageDialog(frame, "Exception", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        // Add key listeners
        display.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                // when user pressed enter, calculate automatically
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("Equals");
                    // function to press the equals button within the program
                    button20.doClick();
                }
            }
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
                // when user typed C, clear automatically
                if(e.getKeyCode()==KeyEvent.VK_C) {
                    System.out.println("Clear");
                    display.setText("");
                }
            }
        });
        // add every button to the Jpanel and forms the user interface
        mainPanel.add(buttonLog);
        mainPanel.add(buttons);
        mainPanel.add(buttonc);
        mainPanel.add(buttont);
        mainPanel.add(buttonExp);
        mainPanel.add(buttonNA);
        mainPanel.add(buttonsqrt);
        mainPanel.add(buttonabs);
        mainPanel.add(button2);
        mainPanel.add(button3);
        mainPanel.add(button5);
        mainPanel.add(button6);
        mainPanel.add(button7);
        mainPanel.add(button1);
        mainPanel.add(buttonDEL);
        mainPanel.add(button9);
        mainPanel.add(button10);
        mainPanel.add(button11);
        mainPanel.add(button8);
        mainPanel.add(button4);
        mainPanel.add(button13);
        mainPanel.add(button14);
        mainPanel.add(button15);
        mainPanel.add(button16);
        mainPanel.add(button12);
        mainPanel.add(button17);
        mainPanel.add(button18);
        mainPanel.add(button19);
        mainPanel.add(buttonRem);
        mainPanel.add(button20);
        // set the layout and add each component
        frame.add(display, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        // set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set jpanel visible
        frame.setVisible(true);
    }
}


