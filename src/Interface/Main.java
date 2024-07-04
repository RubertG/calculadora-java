package Interface;

import javax.swing.*;

import Logic.Evaluator;
import Logic.Latex;
import Logic.Matrix;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.singularsys.jep.EvaluationException;
import com.singularsys.jep.ParseException;
import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main extends JFrame {
    private Matrix matrix;
    private Latex latex;
    private Evaluator evaluator;
    boolean isND = false;
    boolean isRad = false;

    private JButton btnAC;
    private JButton btnPercentage;
    private JButton btnDivide;
    private JPanel PrincipalPanel;
    private JTextField txtEntry;
    private JButton btnLeftParenthesis;
    private JButton btnRightParenthesis;
    private JButton btn2RaisedNd;
    private JButton btnXRaised2;
    private JButton btnXRaised3;
    private JButton btnXRaisedY;
    private JButton btnERaisedX;
    private JButton btn10RaisedX;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnMultiplication;
    private JButton btn1XSachet;
    private JButton btnSquareRootX;
    private JButton btnCubeRootX;
    private JButton btnRootYOfX;
    private JButton btnLn;
    private JButton btnLogarithm10;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btnSubtraction;
    private JButton btnSin;
    private JButton btnFactorial;
    private JButton btnCos;
    private JButton btnTan;
    private JButton btnE;
    private JButton btnEE;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btnSum;
    private JButton btnSinh;
    private JButton btnDeg;
    private JButton btnCosh;
    private JButton btnTanh;
    private JButton btnPi;
    private JButton btnRand;
    private JButton btn0;
    private JButton btnComma;
    private JButton btnResult;
    private JTextField txtResponse;
    private JButton btnDel;
    private JButton btnPlusMinus;

    private void setButtonIcon(JButton button, String latexSymbol) {
        button.setIcon(latex.iconEnLatex(latexSymbol));
    }

    /**
     * Establece los iconos de LaTeX para los botones en la interfaz de usuario.
     */
    private void setLatexIcons() {
        setButtonIcon(btnLeftParenthesis, "(");
        setButtonIcon(btnRightParenthesis, ")");
        setButtonIcon(btnAC, "AC");
        setButtonIcon(btnDel, "DEL");
        setButtonIcon(btnPlusMinus, "+/-");
        setButtonIcon(btnPercentage, "\\%");
        setButtonIcon(btnDivide, "/");
        setButtonIcon(btn7, "7");
        setButtonIcon(btn8, "8");
        setButtonIcon(btn9, "9");
        setButtonIcon(btnMultiplication, "x");
        setButtonIcon(btn10RaisedX, "10^x");
        setButtonIcon(btnERaisedX, "e^x");
        setButtonIcon(btnXRaisedY, "x^y");
        setButtonIcon(btnXRaised3, "x^3");
        setButtonIcon(btnXRaised2, "x^2");
        setButtonIcon(btn2RaisedNd, "2^{nd}");

        setButtonIcon(btn1XSachet, "1/x");
        setButtonIcon(btnSquareRootX, "\\sqrt[2]{x}");
        setButtonIcon(btnCubeRootX, "\\sqrt[3]{x}");
        setButtonIcon(btnRootYOfX, "\\sqrt[y]{x}");
        setButtonIcon(btnLn, "ln");
        setButtonIcon(btnLogarithm10, "log_{10}");
        setButtonIcon(btn4, "4");
        setButtonIcon(btn5, "5");
        setButtonIcon(btn6, "6");
        setButtonIcon(btnSubtraction, "-");

        setButtonIcon(btnFactorial, "fact");
        updateTrigonometricIcons();
        setButtonIcon(btnE, "e");
        setButtonIcon(btnEE, "EE");
        setButtonIcon(btn1, "1");
        setButtonIcon(btn2, "2");
        setButtonIcon(btn3, "3");
        setButtonIcon(btnSum, "+");

        setButtonIcon(btnDeg, "Deg");
        setButtonIcon(btnSinh, "sinh");
        setButtonIcon(btnCosh, "cosh");
        setButtonIcon(btnTanh, "tanh");
        setButtonIcon(btnPi, "\\pi");
        setButtonIcon(btnRand, "Rand");
        setButtonIcon(btn0, "0");
        setButtonIcon(btnComma, ".");
        setButtonIcon(btnResult, "=");
    }

    /**
     * Actualiza los iconos de los botones trigonométricos en la interfaz de usuario.
     * Los iconos se establecen en función del valor de la variable booleana isND.
     * Si isND es verdadero, los iconos se establecen en las funciones inversas trigonométricas,
     * de lo contrario se establecen en las funciones trigonométricas regulares.
     */
    private void updateTrigonometricIcons() {
        if (isND) {
            btnSin.setIcon(latex.iconEnLatex("sin^{-1}"));
            btnCos.setIcon(latex.iconEnLatex("cos^{-1}"));
            btnTan.setIcon(latex.iconEnLatex("tan^{-1}"));
        } else {
            btnSin.setIcon(latex.iconEnLatex("sin"));
            btnCos.setIcon(latex.iconEnLatex("cos"));
            btnTan.setIcon(latex.iconEnLatex("tan"));
        }
    }

    /**
     * Diseña el diseño de los botones para la interfaz de calculadora.
     */
    private void designButtons(){
        String btnSize = "w 100%, h 100%,";
        PrincipalPanel.setLayout(new MigLayout("fill, wrap 10", matrix.getColConstrains(), matrix.getRowConstrains()));
        PrincipalPanel.add(txtEntry, "w 100%, h 80!, span");
        PrincipalPanel.add(txtResponse, "w 100%, h 40!, span");

        PrincipalPanel.add(btnLeftParenthesis,btnSize);
        PrincipalPanel.add(btnRightParenthesis,btnSize);
        PrincipalPanel.add(btnAC,btnSize + "cell 6 2");
        PrincipalPanel.add(btnPlusMinus,btnSize + "cell 5 2");
        PrincipalPanel.add(btnDel,btnSize);

        PrincipalPanel.add(btnPercentage,btnSize);
        PrincipalPanel.add(btnDivide,btnSize +"wrap");
        PrincipalPanel.add(btn2RaisedNd,btnSize);
        PrincipalPanel.add(btnXRaised2,btnSize);
        PrincipalPanel.add(btnXRaised3,btnSize);
        PrincipalPanel.add(btnXRaisedY,btnSize);
        PrincipalPanel.add(btnERaisedX,btnSize);
        PrincipalPanel.add(btn10RaisedX,btnSize);
        PrincipalPanel.add(btn7,btnSize);
        PrincipalPanel.add(btn8,btnSize);
        PrincipalPanel.add(btn9,btnSize);
        PrincipalPanel.add(btnMultiplication,btnSize);

        PrincipalPanel.add(btn1XSachet,btnSize);
        PrincipalPanel.add(btnSquareRootX,btnSize);
        PrincipalPanel.add(btnCubeRootX,btnSize);
        PrincipalPanel.add(btnRootYOfX,btnSize);
        PrincipalPanel.add(btnLn,btnSize);
        PrincipalPanel.add(btnLogarithm10,btnSize);
        PrincipalPanel.add(btn4,btnSize);
        PrincipalPanel.add(btn5,btnSize);
        PrincipalPanel.add(btn6,btnSize);
        PrincipalPanel.add(btnSubtraction,btnSize);

        PrincipalPanel.add(btnFactorial,btnSize);
        PrincipalPanel.add(btnSin,btnSize);
        PrincipalPanel.add(btnCos,btnSize);
        PrincipalPanel.add(btnTan,btnSize);
        PrincipalPanel.add(btnE,btnSize);
        PrincipalPanel.add(btnEE,btnSize);
        PrincipalPanel.add(btn1,btnSize);
        PrincipalPanel.add(btn2,btnSize);
        PrincipalPanel.add(btn3,btnSize);
        PrincipalPanel.add(btnSum,btnSize);

        PrincipalPanel.add(btnDeg,btnSize);
        PrincipalPanel.add(btnSinh,btnSize);
        PrincipalPanel.add(btnCosh,btnSize);
        PrincipalPanel.add(btnTanh,btnSize);
        PrincipalPanel.add(btnPi,btnSize);
        PrincipalPanel.add(btnRand,btnSize);
        PrincipalPanel.add(btn0,btnSize + "span 2");
        PrincipalPanel.add(btnComma,btnSize);
        PrincipalPanel.add(btnResult,btnSize);

        add(PrincipalPanel);
    }

    /**
     * Inicializa los componentes de la clase.
     * Este método crea nuevas instancias de las clases Matrix, Latex y Evaluator.
     * También llama a los métodos setLatexIcons y designButtons para establecer los
     * iconos y diseñar los botones.
     * El método también establece el tamaño, tamaño mínimo, ubicación, título y operación
     * de cierre predeterminada de la ventana.
     */
    private void initSettings() {
        matrix = new Matrix();
        latex = new Latex();
        evaluator = new Evaluator();

        setLatexIcons();
        designButtons();

        // Detalles de la ventana
        setSize(1000, 600);
        setMinimumSize(new Dimension(850, 450));
        setLocationRelativeTo(null);
        setTitle("Calculadora científica");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Metodo constructor
    public Main() {
        initSettings();

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("1");
            }
        });

        btnAC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtEntry.setText("");
                txtResponse.setText("");
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("2");
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("3");
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("4");
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("5");
            }
        });

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("6");
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("7");
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("8");
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("9");
            }
        });
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("0");
            }
        });
        btnComma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton(".");
            }
        });
        btnSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("+");
            }
        });
        btnSubtraction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("-");
            }
        });
        btnMultiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("*");
            }
        });
        btnDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("/");
            }
        });
        btnResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult(txtEntry.getText());
            }
        });

        btnLeftParenthesis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("(");
            }
        });
        btnRightParenthesis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton(")");
            }
        });
        btnSin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isND) {
                    actionButton("asin(");
                } else {
                    actionButton("sin(");
                }
            }
        });
        btnCos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isND) {
                    actionButton("acos(");
                } else {
                    actionButton("cos(");
                }

            }
        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtEntry.getText().isEmpty()) {
                    txtEntry.setText(txtEntry.getText().substring(0, txtEntry.getText().length() - 1));
                    if (txtEntry.getText().isEmpty()) {
                        txtResponse.setText("");
                    }
                }
            }
        });
        btnTan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isND) {
                    actionButton("atan(");
                } else {
                    actionButton("tan(");
                }
            }
        });
        btnTan.addMouseListener(new MouseAdapter() {
        });
        btnFactorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("fact(");
            }
        });
        btnE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("e");
            }
        });
        btnSinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("sinh(");
            }
        });
        btnCosh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("cosh(");
            }
        });
        btnTanh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("tanh(");
            }
        });
        btnPi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("pi");
            }
        });
        btnRand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                txtEntry.setText("" + random.nextDouble());
            }
        });
        btn1XSachet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("1/");
            }
        });
        btnSquareRootX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("sqrt(");
            }
        });
        btnCubeRootX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("raiz(3,");
            }
        });

        btnRootYOfX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("raiz(,");
            }
        });
        btnLn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("ln(");
            }
        });
        btnLogarithm10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("log(");
            }
        });
        btnXRaised2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("^2");
            }
        });
        btnXRaised3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("^3");
            }
        });
        btnXRaisedY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("^");
            }
        });
        btnERaisedX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("e^");
            }
        });
        btn10RaisedX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("10^");
            }
        });
        btnEE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("EE");
            }
        });
        txtEntry.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!isValidCharacter(c)) {
                    e.consume();
                }
            }

            private boolean isValidCharacter(char c) {
                return Character.isDigit(c) ||
                        "+-*/().".indexOf(c) != -1 ||
                        c == KeyEvent.VK_BACK_SPACE ||
                        c == KeyEvent.VK_DELETE;
            }
        });
        btnPercentage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButton("%");
            }
        });
        btn2RaisedNd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isND) {
                    isND = true;
                    btn2RaisedNd.setBackground(new Color(54, 117, 39));
                    updateTrigonometricIcons();
                } else {
                    isND = false;
                    btn2RaisedNd.setBackground(new Color(86, 86, 86));
                    updateTrigonometricIcons();
                }
            }
        });
        btnDeg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isRad) {
                    isRad = true;
                    btnDeg.setIcon(latex.iconEnLatex("Rad"));
                } else {
                    isRad = false;
                    btnDeg.setIcon(latex.iconEnLatex("Deg"));
                }
            }
        });
        btnPlusMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = 0, num2, num3;
                    num2 = Integer.parseInt(txtEntry.getText());
                    num3 = num1 - num2;
                    txtEntry.setText(String.valueOf(num3));
                } catch (Exception ex) {
                    txtResponse.setText("Error");
                }
            }
        });
    }

    /**
     * Un método para insertar texto en la posición del cursor en el campo de entrada de texto.
     */
    private void actionButton(String textToInsert) {
        int caretPosition = txtEntry.getCaretPosition();
        String currentText = txtEntry.getText();
        String newText = currentText.substring(0, caretPosition) + textToInsert +
                currentText.substring(caretPosition);
        txtEntry.setText(newText);
    }

    /**
     * Calcula el resultado de la expresión de texto dada y actualiza el campo de texto de respuesta correspondiente.
     */
    private void calculateResult(String text) {
        if (!text.isEmpty()) {
            try {
                txtResponse.setText("= " + evaluator.calculateExpression(text, isRad).toString());
            } catch (ParseException | EvaluationException e) {
                txtResponse.setText("Error");
            }
        } else {
            txtResponse.setText("");
        }

    }

    public static void main(String[] args) {
        try {
            FlatMacDarkLaf.setup();
        } catch (Exception ex) {
            System.err.println("Error al iniciar el programa: " + ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
