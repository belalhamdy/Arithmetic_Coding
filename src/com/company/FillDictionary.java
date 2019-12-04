package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import static com.company.ArithmeticCoding.MAX_CHARACTERS;

public class FillDictionary {
    private JPanel panel1;
    private JButton addButton;
    private JTextField characterText;
    private JTextField probabilityText;
    private JTable DictTable;
    private JButton doneButton;
    BigDecimal[] probabilities = new BigDecimal[MAX_CHARACTERS];
    boolean visible = true;

    private void INVALID() {
        characterText.setText("");
        probabilityText.setText("");
        JOptionPane.showMessageDialog(null, "INVALID INPUT", "INVALID", JOptionPane.ERROR);
    }

    public FillDictionary() {
        JFrame form = new JFrame("Probabilities");
        form.setResizable(false);

        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setContentPane(panel1);
        form.pack();
        form.setVisible(true);
        for (int f = 0 ; f<probabilities.length ; ++f)
        {
            probabilities[f] = new BigDecimal(0);
        }
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (characterText.getText().isEmpty() || probabilityText.getText().isEmpty() || characterText.getText().length() > 1) {
                    INVALID();
                    return;
                }
                char c = characterText.getText().charAt(0);
                String p = probabilityText.getText();
                BigDecimal prob;
                try {
                    prob = new BigDecimal(p);
                    if (!probabilities[c].toString().equals("0")){
                        throw new Exception("hi");
                    }
                } catch (Exception ex) {
                    INVALID();
                    return;
                }
                probabilities[c] = prob;
                characterText.setText("");
                probabilityText.setText("");
                DefaultTableModel model = (DefaultTableModel) DictTable.getModel();
                model.addRow(new Object[]{c,p});
            }
        });
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArithmeticCoding.setProbabilities(probabilities);
                form.setVisible(false);
                form.dispose();
                visible = false;
            }
        });
    }

    private void createUIComponents() {
        String[] col = new String[]{"Character", "Probability"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        DictTable = new JTable(model);
    }
}
