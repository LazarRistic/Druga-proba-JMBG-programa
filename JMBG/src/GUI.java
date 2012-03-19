import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUnosenjeJMBGa;
	private JTextField textDatumRodjenja;
	private JTextField textPol;
	private JTextField textDrzavaRodjenja;
	private JTextField textMestoRodjenja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Dole se dodaje akcija kad se klikne dugme ENTER na tastaturi
		
		txtUnosenjeJMBGa = new JTextField();
		txtUnosenjeJMBGa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) {
			        Toolkit.getDefaultToolkit().beep();
			        JMBG j = new JMBG();
					
					j.setJmbg(txtUnosenjeJMBGa.getText());
					
					j.jmbgUDatumRodjenja();
					j.stringUKalendar();
					j.Pol();
					j.RegionRodjenja();
					
					if ( j.getGreska() != 0) {
						
						do {
							if (j.brojacGUI == 3 ) {
								JOptionPane.showMessageDialog(null, "Previse puta ste pokusali dovidjenja :D ");

						        System.exit(0);
							}
							else {
								j.setGreska(0);
						  String ans;
					        ans = JOptionPane.showInputDialog(null, "Pogresno ste uneli vas JMBG, probajte ponovo.");
					        j.setJmbg(ans);
					        
					        j.jmbgUDatumRodjenja();
							j.stringUKalendar();
							j.Pol();
							j.RegionRodjenja();
					        
					        textDatumRodjenja.setText(j.getDatumRodjenja());
							textDrzavaRodjenja.setText(j.getDrzavaRodjenja());
							textMestoRodjenja.setText(j.getMestoRodjenja());
							textPol.setText(j.getPol());
							j.brojacGUI++;
							
							}
						}
						
						while (j.getGreska() == 1 || j.brojacGUI < 3);
							
					}
					
					else {
					textDatumRodjenja.setText(j.getDatumRodjenja());
					textDrzavaRodjenja.setText(j.getDrzavaRodjenja());
					textMestoRodjenja.setText(j.getMestoRodjenja());
					textPol.setText(j.getPol());
					}
					
				
			     }
			}
		});
		
		// Zavrseno ENTER dodavanje
		
		txtUnosenjeJMBGa.setText("Unesite vas jmbg");
		txtUnosenjeJMBGa.setBounds(10, 42, 208, 20);
		contentPane.add(txtUnosenjeJMBGa);
		txtUnosenjeJMBGa.setColumns(10);
		
		// Pravim Bitton za Unosenje jmbg, i komanda koja ce se uneti
		
		JButton btnUnesiJMBG = new JButton("Unesi");
		btnUnesiJMBG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JMBG j = new JMBG();
				
				j.setJmbg(txtUnosenjeJMBGa.getText());
				
				j.jmbgUDatumRodjenja();
				j.stringUKalendar();
				j.Pol();
				j.RegionRodjenja();
				
				if ( j.getGreska() != 0) {
					
					do {
						if (j.brojacGUI == 3 ) {
							JOptionPane.showMessageDialog(null, "Previse puta ste pokusali dovidjenja :D ");

					        System.exit(0);
						}
						else {
							j.setGreska(0);
					  String ans;
				        ans = JOptionPane.showInputDialog(null, "Pogresno ste uneli vas JMBG, probajte ponovo.");
				        j.setJmbg(ans);
				        
				        j.jmbgUDatumRodjenja();
						j.stringUKalendar();
						j.Pol();
						j.RegionRodjenja();
				        
				        textDatumRodjenja.setText(j.getDatumRodjenja());
						textDrzavaRodjenja.setText(j.getDrzavaRodjenja());
						textMestoRodjenja.setText(j.getMestoRodjenja());
						textPol.setText(j.getPol());
						j.brojacGUI++;
						
						}
					}
					
					while (j.getGreska() == 1 || j.brojacGUI < 3);
						
				}
				
				else {
				textDatumRodjenja.setText(j.getDatumRodjenja());
				textDrzavaRodjenja.setText(j.getDrzavaRodjenja());
				textMestoRodjenja.setText(j.getMestoRodjenja());
				textPol.setText(j.getPol());
				}
				
			}
		});
		
		//Button zavrsen
		
		btnUnesiJMBG.setBounds(297, 41, 89, 23);
		contentPane.add(btnUnesiJMBG);
		
		JLabel lblUTextBox = new JLabel("U text box ispod unesite vas Jedinstveni Maticni Broj Gradjanja");
		lblUTextBox.setBounds(10, 11, 414, 20);
		contentPane.add(lblUTextBox);
		
		JLabel lblDatumRodjenja = new JLabel("Datum Rodjenja:");
		lblDatumRodjenja.setBounds(10, 124, 131, 14);
		contentPane.add(lblDatumRodjenja);
		
		textDatumRodjenja = new JTextField();
		textDatumRodjenja.setBounds(151, 121, 235, 20);
		contentPane.add(textDatumRodjenja);
		textDatumRodjenja.setColumns(10);
		
		JLabel lblPol = new JLabel("Pol:");
		lblPol.setBounds(10, 155, 131, 14);
		contentPane.add(lblPol);
		
		textPol = new JTextField();
		textPol.setBounds(151, 152, 235, 20);
		contentPane.add(textPol);
		textPol.setColumns(10);
		
		JLabel lblDrzavaRodjenja = new JLabel("Drzava Rodjenja:");
		lblDrzavaRodjenja.setBounds(10, 186, 131, 14);
		contentPane.add(lblDrzavaRodjenja);
		
		textDrzavaRodjenja = new JTextField();
		textDrzavaRodjenja.setBounds(151, 183, 235, 20);
		contentPane.add(textDrzavaRodjenja);
		textDrzavaRodjenja.setColumns(10);
		
		textMestoRodjenja = new JTextField();
		textMestoRodjenja.setBounds(151, 214, 235, 20);
		contentPane.add(textMestoRodjenja);
		textMestoRodjenja.setColumns(10);
		
		JLabel lblMestoRodjenja = new JLabel("Mesto Rodjenja:");
		lblMestoRodjenja.setBounds(10, 217, 131, 14);
		contentPane.add(lblMestoRodjenja);
		
		JLabel lblPodaciOVama = new JLabel("Podaci o vama, na osnovu vaseg JMBG-a se nalaze ispod");
		lblPodaciOVama.setBounds(10, 73, 325, 30);
		contentPane.add(lblPodaciOVama);
	}
}
