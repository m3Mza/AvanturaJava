package gamePackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, imagePanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, imageLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHP, monsterHP, silverRing;
	String weapon, position;
	ImageIcon image;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	// ImageIcon logo = new ImageIcon(".//res//ikonica.jpg");
	
	ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("ikonica.jpg"));
	
	



	public static void main(String[] args) {

		new Game();
	}
	
	public Game(){
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setIconImage(logo.getImage());
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("AVANTURA");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);	
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
		window.setVisible(true);
	}
	
	public void createGameScreen(){
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(50, 350, 430, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);		
		mainTextArea = new JTextArea("!!!!!!!");
		mainTextArea.setBounds(50, 350, 430, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true); 
		mainTextArea.setEditable(false); 	
		
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(500, 350, 250, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler); 
		choice1.setActionCommand("c1"); 
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
//		choice4.setContentAreaFilled(false);  // Disable highlighting on press!!!
		

		playerPanel = new JPanel();
		playerPanel.setBounds(500, 100, 270, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(2,2));
		con.add(playerPanel);
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Oruzje:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		weaponLabel.setBackground(Color.red);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		imagePanel = new JPanel();
		imagePanel.setBounds(50,50,400,300);
		imagePanel.setBackground(Color.black);
		
		imageLabel = new JLabel();
		
		image = new ImageIcon(".//res2//strazarMali.jpg");
		
		imageLabel.setIcon(image);
		imagePanel.add(imageLabel);
		
		
		con.add(imagePanel);
		
		

		playerSetup();

	}
	public void playerSetup(){
		
		playerHP = 15;
		monsterHP = 20;
		weapon = "Stap";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		
		townGate();
	}
	
	public void townGate(){
		
		image = new ImageIcon(".//res2//strazarMali.jpg");
		imageLabel.setIcon(image);
		
		position = "townGate";
		mainTextArea.setText("Nalazis se ispred kapije zamka, ispred tebe je strazar.\n");
		choice1.setText("Razgovor");
		choice2.setText("Napad");
		choice3.setText("Napusti");
		choice4.setText("");
	}
	

	public void talkGuard(){
		position = "talkGuard";
		mainTextArea.setText("Strazar: Nedaleko odavde nalazi se cudoviste. \nUkoliko ga pobedis dobices pristup zamku.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void attackGuard(){
		position = "attackGuard";
		mainTextArea.setText("Strazar: Stani!\n\nStrazar te udara, jako.\n(Primas 3 DMG)");
		//playerHP = playerHP -3;
		playerHP -=3;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void crossRoad(){
		
		image = new ImageIcon(".//res2//oblaci.jpg");
		imageLabel.setIcon(image);
				
		position = "crossRoad";
		mainTextArea.setText("Nalazis se na raskrsnici.\nAko se okrenes na jug vracas se do zamka.");
		choice1.setText("Sever");
		choice2.setText("Istok");
		choice3.setText("Jug");
		choice4.setText("Zapad");
	}
	public void north(){
		
		image = new ImageIcon(".//res2//reka.png");
		imageLabel.setIcon(image);
		
		position = "north";
		mainTextArea.setText("Pronalazis reku. \nPravis kamp i odmaras pored reke. \n\n(HP ti se povecava za 2)");
		playerHP = playerHP + 2;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("Nazad");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void east(){
		
		image = new ImageIcon(".//res2//mac.jpg");
		imageLabel.setIcon(image);
		
		position = "east";
		mainTextArea.setText("Zalazis u sumu i pronalazis grob nepoznatog viteza!\n\n(Pronalazis Mac)");
		weapon = "Mac";
		weaponLabelName.setText(weapon);
		choice1.setText("Nazad");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void west(){
		
		image = new ImageIcon(".//res2//ogr.jpg");
		imageLabel.setIcon(image);
		
		position = "west";
		mainTextArea.setText("Nailazis na Ogra!");
		choice1.setText("Napad");
		choice2.setText("Beg");
		choice3.setText("");
		choice4.setText("");
	}
	public void fight(){
		
		image = new ImageIcon(".//res2//ogr.jpg");
		imageLabel.setIcon(image);
		
		position = "fight";
		mainTextArea.setText("Ogr HP: " + monsterHP + "\n\nSta radis?");
		choice1.setText("Napad");
		choice2.setText("Beg");
		choice3.setText("");
		choice4.setText("");
	}
	public void playerAttack(){
		position = "playerAttack";
		
		int playerDamage = 0;
		
		if(weapon.equals("Stap")){
			playerDamage = new java.util.Random().nextInt(3);
		}
		else if(weapon.equals("Mac")){
			playerDamage = new java.util.Random().nextInt(12); 
		}
		
		mainTextArea.setText("Napadas cudoviste i radis mu " + playerDamage + " HP stete!");
		
		monsterHP = monsterHP - playerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	public void monsterAttack(){
		position = "monsterAttack";
		
		int monsterDamage = 0;
		
		monsterDamage = new java.util.Random().nextInt(6); 
		
		mainTextArea.setText("Ogr te napada i radi ti " + monsterDamage + " HP stete!");
		
		playerHP = playerHP - monsterDamage;
		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
	}
	public void win(){
		position = "win";
		
		mainTextArea.setText("Ogr je ubijen!\nUzimas mu prsten sa ruke!\n\n(Dobio si srebrni prsten)");
		
		silverRing = 1;
		
		choice1.setText("Nazad");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void lose(){
		position = "lose";
		
		mainTextArea.setText("MRTAV!\n\nGAME OVER");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void ending(){
		position = "ending";
		
		mainTextArea.setText("Strazar: Ogr je ubijen!?\nU ime naroda ti se zahvaljujem!\nDobrodosao u zamak!\n");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}




	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
		}
	}
	

	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
			
			switch(position){
			case "townGate":
				switch(yourChoice){
				case "c1": 
					if(silverRing==1){
						ending();
					}
					else{
						talkGuard();
					}
					break;
				case "c2": attackGuard();break;
				case "c3": crossRoad();break;
				}
				break;
			case "talkGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
				}
				break;
			case "attackGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
				}
				break;
			case "crossRoad":
				switch(yourChoice){
				case "c1": north(); break;
				case "c2": east();break;
				case "c3": townGate(); break;
				case "c4": west();break;
				}
				break;
			case "north":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
				break;
			case "east":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
				break;
			case "west":
				switch(yourChoice){
				case "c1": fight(); break;
				case "c2": crossRoad(); break;
				}
				break;
			case "fight":
				switch(yourChoice){
				case "c1": playerAttack();break;
				case "c2": crossRoad(); break;
				}
				break;
			case "playerAttack":
				switch(yourChoice){
				case "c1": 
					if(monsterHP <1 ){
						win();
					}
					else{
						monsterAttack();
					}
					break;
				}
				break;
			case "monsterAttack":
				switch(yourChoice){
				case "c1": 
					if(playerHP <1 ){
						lose();
					}
					else{
						fight();
					}
					break;
				}
				break;
			case "win":
				switch(yourChoice){
				case "c1": crossRoad();
				}
				break;
				
			}
			
			
		}
	}

}
