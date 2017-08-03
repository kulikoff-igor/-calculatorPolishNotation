package uiConsole;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class UiGame21 extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel computerCards;
    private JPanel cardPlayer;
    private JPanel actionGames;
    private String your_session_id;

    public UiGame21() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String toservlet = "http://localhost:8080/Games21/GamesStartController";
                try
                {
                URL servleturl = new URL(toservlet);
                URLConnection servletconnection = servleturl.openConnection();
                servletconnection.setDoInput(true);
                servletconnection.setDoOutput(true);
                servletconnection.setUseCaches(true);
                servletconnection.setDefaultUseCaches(true);

                DataOutputStream out=new DataOutputStream(servletconnection.getOutputStream());

                DataInputStream inputFromClient = new DataInputStream(servletconnection.getInputStream());
                    your_session_id = servletconnection.getHeaderField("Set-Cookie");

                    System.out.print(your_session_id.toString());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputFromClient));
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    try {
                        while ((line = reader.readLine()) != null) {
                            sb.append(line + "\n");
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } finally {
                        try {
                            inputFromClient.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }

                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(sb.toString());
                    //System.out.print(obj.toString());
                    JSONObject json = (JSONObject) obj;
                    System.out.print(json.get("plauer1CardCount").toString());


            }
            catch(Exception e1)
            {
                e1.printStackTrace();
            }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String toservlet = "http://localhost:8080/Games21/ControllerTakingNewCard";
                try
                {
                    URL servleturl = new URL(toservlet);
                    URLConnection servletconnection = servleturl.openConnection();
                    servletconnection.setDoInput(true);
                    servletconnection.setDoOutput(true);
                    servletconnection.setUseCaches(false);
                    servletconnection.setDefaultUseCaches(false);
                    servletconnection.setRequestProperty(
                            "Cookie", your_session_id);

                    DataOutputStream out=new DataOutputStream(servletconnection.getOutputStream());

                    DataInputStream inputFromClient = new DataInputStream(servletconnection.getInputStream());
                    //System.out.print(inputFromClient.readUTF().);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputFromClient));
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    try {
                        while ((line = reader.readLine()) != null) {
                            sb.append(line + "\n");
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } finally {
                        try {
                            inputFromClient.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }

                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(sb.toString());
                    System.out.print(obj.toString());
                    JSONObject json = (JSONObject) obj;
                   // System.out.print(json.get("plauer1CardCount").toString());


                }
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }

            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        UiGame21 dialog = new UiGame21();
        dialog.pack();
        dialog.setVisible(true);

        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
