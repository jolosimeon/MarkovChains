package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	private JPanel mainPanel;
	private IMarkovChainsView mainView;
        private final String iconPath;
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		/** Frame setup */
		this.setTitle("Markov Chains");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 800, 350);
                this.setSize(450, 200);
		iconPath = "src/advdiscIcon.png";
                ImageIcon img = new ImageIcon(iconPath);
                setIconImage(img.getImage());
		this.setLocationRelativeTo(null);
	}

	public void renderMainView() {
		/** Show Chat View */
		mainView = new MarkovChainsView(this);
                frameRevalidate();
		this.setContentPane((JPanel) mainView);
	}
	
        public void frameRevalidate()
	{
		validate();
		repaint();
		setVisible(true);
	}

}
