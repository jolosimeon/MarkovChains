package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import javax.swing.JButton;
import controller.MarkovChainsController;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class MarkovChainsView extends JPanel implements IMarkovChainsView, ActionListener, KeyListener  {
	private MainFrame mainFrame;

	/** Controller */
	private MarkovChainsController controller;
        
	
     

    public MarkovChainsView(MainFrame mainFrame) {
            setLayout(null);

            controller = new MarkovChainsController(this);
            
                try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (Exception e) {
        }
    


    JButton btnOpenFile = new JButton("Open File");
    JButton btnClear = new JButton("Clear");
    JButton btnGenerate = new JButton("Generate");
    JTextArea txtAreaInput = new JTextArea();
    JTextArea txtAreaOutput = new JTextArea();

    add(btnGenerate);
    add(btnOpenFile);
    add(btnClear);
    add(txtAreaInput);
    add(txtAreaOutput);
    
    btnGenerate.setBounds(125,125,150,25);
    btnOpenFile.setBounds(50,260,150,25);
    btnClear.setBounds(250,260,150,25);
    txtAreaInput.setBounds(10,10,420,110);
    txtAreaOutput.setBounds(10,150,420,110);
    
    txtAreaInput.setText("");
    btnGenerate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            controller.CreateMarkovChains(txtAreaInput.getText());
            txtAreaOutput.setText(controller.getGeneratedMarkovChains(5));
        }

    });
    
    btnClear.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtAreaInput.setText(""); 

        }

    });
    

    
    btnOpenFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(fileChooser);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    fileChooser.setVisible(false);
                }
        

            }

        });

    }
    




    @Override
    public void keyPressed(KeyEvent ke) {
    //		if(ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getSource() == chatInputTxtField)	{
    //            
    //		}
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
            // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
            // TODO Auto-generated method stub

    }


    


    @Override
    public void actionPerformed(ActionEvent ae)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInput()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    


      
}