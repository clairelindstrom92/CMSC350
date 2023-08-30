// Claire Lindstrom CMSC350: Contains main method which has GUI

package main;

import javax.swing.*; //imports swing components
import java.awt.*; // abstract window toolkit
import java.awt.event.ActionEvent; //event class for handling clicks
import java.awt.event.ActionListener; //event class for handling clicks
import conversion.Converter;

public class ExpressionConverterApp {

    private JFrame mainFrame; //window/frame
    private JTextField userInputField; //user input field
    private JButton swapButton; // triggers conv
    private JLabel resultLabel; //displays resutls of result

    public ExpressionConverterApp() {
        // Setting up the main window
        mainFrame = new JFrame("Prefix and Postfix Converter");
        mainFrame.setSize(400, 200);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());

        userInputField = new JTextField(20);
        swapButton = new JButton("Swap");
        resultLabel = new JLabel("Your result will show up here.");

        // Adding components to the frame
        mainFrame.add(new JLabel("Drop your expression here:"));
        mainFrame.add(userInputField);
        mainFrame.add(swapButton);
        mainFrame.add(resultLabel);

        // What happens when you click the button? Magic (and some logic)!
        swapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userExpression = userInputField.getText().trim();

                // If it starts with an operator, we're thinking it's prefix.
                if (Converter.isOperand(Character.toString(userExpression.charAt(0)))) {
                    String postfixMagic = Converter.convertPrefixToPostfix(userExpression);
                    resultLabel.setText("Postfix Magic: " + postfixMagic);
                } else {
                    // Otherwise, let's turn that postfix into prefix.
                    String prefixMagic = Converter.convertPostfixToPrefix(userExpression);
                    resultLabel.setText("Prefix Magic: " + prefixMagic);
                }
            }
        });

        // makes the GUI Visible
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        // Keeps the GUI creation thread-safe.
        SwingUtilities.invokeLater(() -> new ExpressionConverterApp());
    }
}
