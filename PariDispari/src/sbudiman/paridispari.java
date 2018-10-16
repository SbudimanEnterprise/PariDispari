package sbudiman;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class paridispari 
{

	int giocatore = (int) (Math.random() * 2 + 1);
	String tipogioc1;
	String tipogioc2;
	int gioc1;
	int gioc2;
	int risultato=0;
	int c1=0;
	int c2=0;
	
	
	JFrame frame;
	
	Panel Sfondo = new Panel();
	Label lblsfondo = new Label("A chi tocca scegliere...?");
	Label lblnumgioc1 = new Label();
	Label lblnumgioc2 = new Label();
	
	Panel Scelte = new Panel();
	Label lblg1 = new Label("Giocatore 1");
	TextField tfgioc2 = new TextField();
	Button btnconferma1 = new Button("Conferma");
	Label lblg2 = new Label("Giocatore 2");
	TextField tfgioc1 = new TextField();
	Button btnconferma2 = new Button("Conferma");
	Label lbldivisore = new Label("|");
	Button btnconferma3 = new Button("Continua!");
	
	Panel Inizio = new Panel();
	Label lblgiocatore = new Label("Giocatore " +giocatore+" scegli tu!");
	Button btndispari = new Button("Dispari");
	Button btnpari = new Button("Pari");
	Label lblmsgsimp = new Label("Non voglio portare sfortuna per\u00F2 scegli bene.");
	Label lbltipo = new Label("");

	public static void main(String[] args)
	{
		paridispari window = new paridispari();
		window.frame.setVisible(true);
		musica();
	}
			public paridispari() 
			{
				System.out.println("[DEBUG]: Sceglie Giocatore "+giocatore);
				frame = new JFrame("Pari o Dispari?");
				frame.setBounds(100, 100, 715, 350);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(Sfondo);
				Sfondo.setBackground(Color.ORANGE);
				Sfondo.setLayout(null);
				Scelte.setBounds(0, 144, 699, 167);
				Scelte.setBackground(Color.RED);
				Scelte.setVisible(true);
				Scelte.setLayout(null);
				lblg1.setFont(new Font("Dialog", Font.PLAIN, 40));
				lblg1.setAlignment(Label.CENTER);
				lblg1.setBounds(0, 0, 345, 46);
				lblg1.setVisible(false);
				btnconferma1.setBounds(0, 116, 345, 22);
				btnconferma3.setVisible(false);
				btnconferma3.setBounds(0, 145, 699, 22);
				lbldivisore.setFont(new Font("Dialog", Font.PLAIN, 99));
				lbldivisore.setName("");
				lbldivisore.setAlignment(Label.CENTER);
				lbldivisore.setBounds(0, 0, 699, 167);
				Inizio.setBounds(0, 0, 699, 167);
				Inizio.setLayout(null);
				lblgiocatore.setBounds(0, 5, 699, 54);
				lblgiocatore.setFont(new Font("Dialog", Font.PLAIN, 40));
				lblgiocatore.setAlignment(Label.CENTER);
				btndispari.setBounds(349, 65, 350, 41);
				btnpari.setBounds(0, 65, 350, 41);
				lblmsgsimp.setAlignment(Label.CENTER);
				lblmsgsimp.setBounds(0, 135, 699, 22);
				lbltipo.setVisible(false);
				lbltipo.setFont(new Font("Dialog", Font.BOLD, 36));
				lbltipo.setBounds(0, 88, 699, 50);
				lbltipo.setAlignment(Label.CENTER);
				lblnumgioc1.setVisible(false);
				lblnumgioc1.setFont(new Font("Dialog", Font.BOLD, 36));
				lblnumgioc1.setAlignment(Label.CENTER);
				lblnumgioc1.setBounds(0, 0, 350, 50);
				lblnumgioc2.setVisible(false);
				lblnumgioc2.setFont(new Font("Dialog", Font.BOLD, 36));
				lblnumgioc2.setAlignment(Label.CENTER);
				lblnumgioc2.setBounds(349, 0, 350, 50);
				lblsfondo.setFont(new Font("Dialog", Font.BOLD, 27));
				lblsfondo.setAlignment(Label.CENTER);
				lblsfondo.setBounds(10, 10, 679, 128);
				btnconferma1.setVisible(false);
				lbldivisore.setVisible(false);				
				lblg2.setFont(new Font("Dialog", Font.PLAIN, 40));
				lblg2.setAlignment(Label.CENTER);
				lblg2.setBounds(351, 0, 348, 46);
				lblg2.setVisible(false);
				tfgioc2.setText("Inserisci un numero compreso tra 1 e 10");
				tfgioc2.setBounds(356, 50, 343, 41);
				tfgioc2.setVisible(false);
				tfgioc1.setText("Inserisci un numero compreso tra 1 e 10");
				tfgioc1.setBounds(0, 50, 343, 41);
				tfgioc1.setVisible(false);
				
				Sfondo.add(lbltipo);
				Sfondo.add(lblnumgioc1);
				Sfondo.add(lblnumgioc2);
				Sfondo.add(lblsfondo);
				Sfondo.add(Scelte);
				
				Scelte.add(lblg1);
				Scelte.add(lblg2);
				Scelte.add(tfgioc1);
				Scelte.add(tfgioc2);
				Scelte.add(btnconferma1);
				Scelte.add(btnconferma2);
				Scelte.add(btnconferma3);
				Scelte.add(lbldivisore);
				Scelte.add(Inizio);
				
				Inizio.add(lblgiocatore);
				Inizio.add(btndispari);
				Inizio.add(btnpari);
				Inizio.add(lblmsgsimp);
				
				tfgioc1.addMouseListener(new MouseAdapter()
				{
		            @Override
		            public void mouseClicked(MouseEvent e)
		            {
		                tfgioc1.setText(null);
		            }
		        });
				
				tfgioc2.addMouseListener(new MouseAdapter()
				{
		            @Override
		            public void mouseClicked(MouseEvent e)
		            {
		                tfgioc2.setText(null);
		            }
		        });
				btnconferma2.setBounds(354, 116, 345, 22);
				btnconferma2.setVisible(false);

				
				btnconferma2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						if(tfgioc2.getText()=="Inserisci un numero compreso tra 1 e 10" || tfgioc2.getText()=="Attendi il numero del giocatore 2")
						{
							JOptionPane.showMessageDialog(null, "Inserisci un input valido GIOCATORE 2!");
						}
						else
						{
							gioc2 = Integer.parseInt(tfgioc2.getText());
						}
						
						if(gioc1>0)
						{
							somma();
						}
						else
						{
							tfgioc2.setText("Attendi il numero del giocatore 1");
							btnconferma2.setEnabled(false);
						}
					}
				});
				
				btnpari.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						if(giocatore==1)
						{
							tipogioc1 = "Pari";
						}
						else
						{
							tipogioc2 = "Pari";
						}
						
						if(giocatore == 2 && tipogioc1 == null	&& tipogioc2 == "Pari" )
						{
							tipogioc1 = "Dispari";
						}
						
						if(giocatore == 2 && tipogioc1 == null	&& tipogioc2 == "Dispari" )
						{
							tipogioc1 = "Pari";
						}
						
						if(giocatore == 1 && tipogioc2 == null	&& tipogioc1 == "Pari" )
						{
							tipogioc2 = "Dispari";
						}
						
						if(giocatore == 1 && tipogioc2 == null	&& tipogioc1 == "Dispari" )
						{
							tipogioc2 = "Pari";
						}
						lblsfondo.setText("Giocatore " +giocatore+ " ha scelto pari");
						System.out.println("[DEBUG]: Giocatore 1 è "+tipogioc1);
						System.out.println("[DEBUG]: Giocatore 2 è "+tipogioc2);
						gui();
						Inizio.setVisible(false);
						lblnumgioc1.setText("Giocatore 1: "+String.valueOf(c1));
						lblnumgioc2.setText("Giocatore 2: "+String.valueOf(c2));
					}
				});
				
				btndispari.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e)
					{
						if(giocatore==1)
						{
							tipogioc1 = "Dispari";
						}
						else
						{
							tipogioc2 = "Dispari";
						}
						
						if(giocatore == 2 && tipogioc1 == null	&& tipogioc2 == "Pari" )
						{
							tipogioc1 = "Dispari";
						}
						
						if(giocatore == 2 && tipogioc1 == null	&& tipogioc2 == "Dispari" )
						{
							tipogioc1 = "Pari";
						}
						
						if(giocatore == 1 && tipogioc2 == null	&& tipogioc1 == "Pari" )
						{
							tipogioc2 = "Dispari";
						}
						
						if(giocatore == 1 && tipogioc2 == null	&& tipogioc1 == "Dispari" )
						{
							tipogioc2 = "Pari";
						}
						lblsfondo.setText("Giocatore " +giocatore+ " ha scelto dispari");
						System.out.println("[DEBUG]: Giocatore 1 è "+tipogioc1);
						System.out.println("[DEBUG]: Giocatore 2 è "+tipogioc2);
						gui();
						Inizio.setVisible(false);
						lblnumgioc1.setText("Giocatore 1: "+String.valueOf(c1));
						lblnumgioc2.setText("Giocatore 2: "+String.valueOf(c2));
					}
				});
				
				btnconferma1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						if(tfgioc1.getText()=="Inserisci un numero compreso tra 1 e 10" || tfgioc1.getText()=="Attendi il numero del giocatore 1")
						{
							JOptionPane.showMessageDialog(null, "Inserisci un input valido GIOCATORE 1!");
						}
						else
						{
							gioc1 = Integer.parseInt(tfgioc1.getText());
						}
						
						if(gioc2>0)
						{
							somma();
						}
						else
						{
							tfgioc1.setText("Attendi il numero del giocatore 2");
							btnconferma1.setEnabled(false);
						}
						
					}
				});
				
				btnconferma3.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
					{
						gioc1=0;
						gioc2=0;
						risultato=0;
						lblnumgioc1.setText("Giocatore 1: "+String.valueOf(c1));
						lblnumgioc2.setText("Giocatore 2: "+String.valueOf(c2));
						tfgioc1.setText("Inserisci un numero compreso tra 1 e 10");
						tfgioc2.setText("Inserisci un numero compreso tra 1 e 10");
						gui();
					}
				});
			}
			
			
			
		public void gui()
		{
			lblg1.setVisible(true);
			tfgioc2.setVisible(true);
			btnconferma1.setVisible(true);
			btnconferma1.setEnabled(true);
			lblg2.setVisible(true);
			tfgioc1.setVisible(true);
			btnconferma2.setVisible(true);
			btnconferma2.setEnabled(true);
			lbldivisore.setVisible(true);
			btnconferma3.setVisible(false);
		}
		
		public void somma()
		{
			btnconferma1.setVisible(false);
			btnconferma2.setVisible(false);
			lblsfondo.setVisible(false);
			btnconferma3.setVisible(true);
			lbltipo.setVisible(true);
			lblnumgioc1.setVisible(true);
			lblnumgioc1.setText("Giocatore 1: "+String.valueOf(c1));
			lblnumgioc2.setVisible(true);
			lblnumgioc2.setText("Giocatore 2: "+String.valueOf(c2));
			risultato = gioc1+gioc2;
			risultato = risultato%2;
			System.out.println(risultato);
			if(risultato == 0)
			{
				if(tipogioc1=="Pari")
				{
					lbltipo.setText("Giocatore 1 (PARI) ha vinto!");
					c1++;
					lblnumgioc1.setText("Giocatore 1: "+String.valueOf(c1));
				}
				else
				{
					lbltipo.setText("Giocatore 2 (PARI) ha vinto!");
					c2++;
					lblnumgioc2.setText("Giocatore 2: "+String.valueOf(c2));
				}
				
			}
			else
			{
				
				if(tipogioc1=="Dispari")
				{
					lbltipo.setText("Giocatore 1 (DISPARI) ha vinto!");
					c1++;
					lblnumgioc1.setText("Giocatore 1: "+String.valueOf(c1));
				}
				else
				{
					lbltipo.setText("Giocatore 2 (DISPARI) ha vinto!");
					c2++;
					lblnumgioc2.setText("Giocatore 2: "+String.valueOf(c2));
				}
				
			}
			
			
			
			if(c1==3)
			{
				lbltipo.setText("Partita finita! Vince Giocatore 1");
				btnconferma1.setEnabled(false);
				btnconferma2.setEnabled(false);
				btnconferma3.setVisible(false);
				tfgioc1.setText("HAI VINTO!");
				tfgioc2.setText("Hai perso :(");
			}
			if(c2==3)
			{
				lbltipo.setText("Partita finita! Vince Giocatore 2");
				btnconferma1.setEnabled(false);
				btnconferma2.setEnabled(false);
				btnconferma3.setVisible(false);
				tfgioc1.setText("Hai perso :(");
				tfgioc2.setText("HAI VINTO!");
			}
			
		}
		
		public static void musica() 
		{
		    try {
		        Clip clip = AudioSystem.getClip();
		        URL url = paridispari.class.getResource("/sbudiman/pesto.wav");
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(url);
		        clip.open(inputStream);
		        FloatControl gainControl =
		        	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		        	gainControl.setValue(-12.0f);
		        clip.start();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
}




