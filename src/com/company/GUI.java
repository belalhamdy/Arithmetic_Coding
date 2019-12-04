package com.company;

import com.company.ArithmeticCoding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GUI {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField Encodetxt;
    private JButton encodeButton;
    private JTextField Decodetxt;
    private JButton decodeButton;
    private JSpinner decodeCntSpn;
    private JTextField FromPathtxt;
    private JTextField toPathtxt;
    private JButton EncodeFilebtn;
    private JButton DecodeFilebtn;
    private JSpinner DecodeFilespn;
    private JButton ChooseTobtn;
    private JButton ChooseFrombtn;
    private JButton enterDictionaryButton;

    public GUI() {
        JFrame form = new JFrame("Arithmetic Encoder");
        form.setResizable(false);

        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setContentPane(panel1);
        form.pack();
        form.setVisible(true);

        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = Encodetxt.getText();
                if (txt == null || txt.isEmpty()){
                    INVALID();
                    return;
                }
                try{
                Decodetxt.setText(ArithmeticCoding.Encode(txt));
                }catch (Exception ex)
                {
                    INVALID();
                }
            }
        });
        decodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = Decodetxt.getText();

                try {
                    decodeCntSpn.commitEdit();
                    if (txt == null || txt.isEmpty()) throw new Exception("hi");
                } catch ( Exception ex )
                {
                    INVALID();
                    return;
                }
                int n = (Integer) decodeCntSpn.getValue();
                try {
                    Encodetxt.setText(ArithmeticCoding.Decode(txt,n));
                } catch (Exception ex) {
                    INVALID();
                }
            }
        });
        enterDictionaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FillDictionary();

            }
        });
        ChooseFrombtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int response = chooser.showSaveDialog(null);
                if (response == JFileChooser.APPROVE_OPTION) {
                    FromPathtxt.setText(String.valueOf(chooser.getSelectedFile()));
                }
            }
        });
        ChooseTobtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int response = chooser.showSaveDialog(null);
                if (response == JFileChooser.APPROVE_OPTION) {
                    toPathtxt.setText(String.valueOf(chooser.getSelectedFile()));
                }
            }
        });
        EncodeFilebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    EncodeFile(FromPathtxt.getText(),toPathtxt.getText());
                } catch (IOException ex) {
                    INVALID();
                }
                FromPathtxt.setText("");
                toPathtxt.setText("");
            }
        });
        DecodeFilebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DecodeFile(FromPathtxt.getText(),toPathtxt.getText(), (Integer) DecodeFilespn.getValue());
                } catch (Exception ex) {
                    INVALID();
                }
                FromPathtxt.setText("");
                toPathtxt.setText("");
            }
        });
    }
    public void EncodeFile(String f,String t) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(f));
        FileWriter to = new FileWriter(t);
        String st = br.readLine();
        String res = ArithmeticCoding.Encode(st);
        to.write(res);
        br.close();
        to.close();
    }
    public void DecodeFile(String f,String t,int n) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(f));
        FileWriter to = new FileWriter(t);
        String st = br.readLine();
        System.out.println(st);
        String res = ArithmeticCoding.Decode(st,n);
        to.write(res);
        br.close();
        to.close();
    }
    private void INVALID() {
        Encodetxt.setText("");
        Decodetxt.setText("");
        JOptionPane.showMessageDialog(null, "INVALID INPUT", "INVALID", JOptionPane.ERROR_MESSAGE);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
