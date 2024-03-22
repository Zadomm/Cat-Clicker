package Basic_clicker_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.text.DecimalFormat;


public class Basic_clicker_game extends JPanel implements KeyListener , MouseListener, MouseMotionListener  {
	int InGameTimeForNiceClicks=0;
	int NumClickerModifer=1;
	int Buismonopoly=1; 
	int ulttimer;
	int timerstart=0;
	int GlobalLimit=15;
	int TheEnd;
	int ingametimeforend=0;
	int QuickBuyTimes;
	int presBoxSizeChange;
	int QuickBuyOn;
	int CatPres=1;
	int Z;
	int quickbuyboxsizechange;
	String QuickBuyValue="";
	int BuismonopolyBoxSizeChange;
	int CatChing=0;
	int CatChingBoxSize;
	int I=0;
	int LoveHotelBoxSizeChange;
	int LoveHotel=1;
	int NiceClicks=0;
	int IsAPressed=0;
	int LoveSofa;
	int PetSmartBoxSizeChange;
	int CaducationBoxSizeChange;
	int displayednewcost;
	int CatSizeShift;
	int LoveSofaBoxSizeChange;
	Image image4 = (new ImageIcon("BackGround2.png")).getImage();
	int xPosition4 = 0, yPosition4 = 0, xSize4 = 1440, ySize4 = 900;
	Image image5 = (new ImageIcon("Cat1.png")).getImage();
	int xPosition5 = -72, yPosition5 = 100, xSize5 = 700, ySize5 = 700;
	Image image6 = (new ImageIcon("Nice Clicks.png")).getImage();
	int xPosition6 = 0, yPosition6 = 0, xSize6 = 1440, ySize6 = 900;
	Image image7=(new ImageIcon("The end.png")).getImage();
	int xPosition7 = 0, yPosition7 = 0, xSize7 = 1440, ySize7 = 900;
	double CatCount=0.0;
	int MouseClickModifer=1;
	int MouseX;
	int MouseY;	
	int IngameTimer;
	double tempvar=50;
	
	public static void main(String  [] args ) throws InterruptedException{
		Basic_clicker_game game = new Basic_clicker_game();
		JFrame gui = new JFrame();
		gui.setSize(1440,900);
		gui.setTitle("Cat Clicker");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.add(game);
		gui.addMouseListener(game);
		gui.addKeyListener(game);
		gui.addMouseMotionListener(game);
		gui.setVisible(true);
		while(true) {
			gui.repaint();
			Thread.sleep(10);	
		}
	}
	public void paint(Graphics g) {
		if(TheEnd==0&& timerstart==1) {
		ulttimer++;
		}
		if (IngameTimer == 180) {
			CatCount=CatCount+(LoveSofa*LoveHotel);
			IngameTimer = 0;
			
		}
		IngameTimer++;
		g.drawImage(image4, xPosition4, yPosition4, xSize4, ySize4, this);
		g.drawImage(image5, xPosition5, yPosition5, xSize5, ySize5, this);
		//petsmart:
		displayednewcost=10-CatChing;
		if( displayednewcost<0) {
			displayednewcost=0;
		}
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString("Cat Count:"+ NumChange(CatCount),40, 887);
		g.setFont(new Font("Arial",Font.BOLD,30+PetSmartBoxSizeChange));
		g.drawString("Pet Smart",590,40);
		g.setFont(new Font("Arial",Font.BOLD,25+PetSmartBoxSizeChange));
		g.drawString("#:"+NumClickerModifer,1350,40);
		g.setColor(new Color(105,105,105));
		g.setFont(new Font("Arial",Font.BOLD,25+PetSmartBoxSizeChange));
		g.drawString("Cost: "+ displayednewcost+ " Cats. Gives you more cats per click.",590,80);
		//catducation:
		displayednewcost=(GlobalLimit*GlobalLimit)-CatChing;
		if( displayednewcost<0) {
			displayednewcost=0;
		}
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Arial",Font.BOLD,30+CaducationBoxSizeChange));
		g.drawString("EduCATion",590,140);
		g.setFont(new Font("Arial",Font.BOLD,25+CaducationBoxSizeChange));
		g.drawString("#:"+GlobalLimit,1350,140);
		g.setColor(new Color(105,105,105));
		g.setFont(new Font("Arial",Font.BOLD,25+CaducationBoxSizeChange));
		g.drawString("Cost: " +displayednewcost+" Cats. Is the max of upgrades for everything.",590,180);
		//love sofa:
		displayednewcost=100-CatChing;
		if( displayednewcost<0) {
			displayednewcost=0;
		}
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Arial",Font.BOLD,30+LoveSofaBoxSizeChange));
		g.drawString("Cat Machine",590,240);
		g.setFont(new Font("Arial",Font.BOLD,25+LoveSofaBoxSizeChange));
		g.drawString("#: "+LoveSofa,1350,240);
		g.setColor(new Color(105,105,105));
		g.setFont(new Font("Arial",Font.BOLD,25+LoveSofaBoxSizeChange));
		g.drawString("Cost:"+displayednewcost+ " Cats. Creates cats passively.",590,280);
		//Love Hotel
		displayednewcost=(LoveHotel*LoveHotel*LoveHotel)-CatChing;
		if( displayednewcost<0) {
			displayednewcost=0;
		}
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Arial",Font.BOLD,30+LoveHotelBoxSizeChange));
		g.drawString("Cat Factory",590,340);
		g.setFont(new Font("Arial",Font.BOLD,25+LoveHotelBoxSizeChange));
		g.drawString("#:"+LoveHotel,1350,340);
		g.setColor(new Color(105,105,105));
		g.setFont(new Font("Arial",Font.BOLD,25+LoveHotelBoxSizeChange));
		g.drawString("Cost: "+displayednewcost +" Cats. Multiples your cat gain from the Cat Machine.",590,380);
		//Monopoly
		displayednewcost=(Buismonopoly*Buismonopoly)-CatChing;
		if( displayednewcost<0) {
			displayednewcost=0;
		}
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Arial",Font.BOLD,30+BuismonopolyBoxSizeChange));
		g.drawString("Business Monopoly",590,440);
		g.setFont(new Font("Arial",Font.BOLD,25+BuismonopolyBoxSizeChange));
		g.drawString("#:"+Buismonopoly,1350,440);
		g.setColor(new Color(105,105,105));
		g.setFont(new Font("Arial",Font.BOLD,25+BuismonopolyBoxSizeChange));
		g.drawString("Cost: "+displayednewcost+" Cats. Multiples your cat gain from Pet Smarts.",590,480);
		//CatChing
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Arial",Font.BOLD,30+CatChingBoxSize));
		g.drawString("Cat-Ching",590,540);
		g.setFont(new Font("Arial",Font.BOLD,25+CatChingBoxSize));
		g.drawString("#:"+CatChing,1350,540);
		g.setColor(new Color(105,105,105));
		g.setFont(new Font("Arial",Font.BOLD,25+CatChingBoxSize));
		g.drawString("Cost: 30 Cats. Reduces the cost up other upgrades.",590,580);	
		//Cat Presidency
		displayednewcost=30-CatChing;
		if( displayednewcost<0) {
			displayednewcost=1;
		}
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Arial",Font.BOLD,30+presBoxSizeChange));
		g.drawString("Cat Presidency",590,640);
		g.setFont(new Font("Arial",Font.BOLD,25+presBoxSizeChange));
		g.drawString("#:"+CatPres,1350,640);
		g.setColor(new Color(105,105,105));
		g.setFont(new Font("Arial",Font.BOLD,25+presBoxSizeChange));
		g.drawString("Cost:"+GlobalLimit+" Cats. Muliplies your max upgarde number.",590,680);	
		//QuickBuyUpgrade
		displayednewcost=100-CatChing;
		if( displayednewcost<0) {
			displayednewcost=1;
		}
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Arial",Font.BOLD,30+quickbuyboxsizechange));
		g.drawString("QuickBuy",590,740);
		g.setFont(new Font("Arial",Font.BOLD,25+quickbuyboxsizechange));
		g.drawString("#:"+QuickBuyOn,1350,740);
		g.setColor(new Color(105,105,105));
		g.setFont(new Font("Arial",Font.BOLD,25+quickbuyboxsizechange));
		g.drawString("Cost:"+displayednewcost+" Cats. Makes buying some upgrades quicker.",590,780);	
		//quickbuy
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Arial",Font.BOLD,23));
		g.drawString("Quickbuy: "+QuickBuyTimes,590,833);
		//achievemnts:
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Arial",Font.BOLD,23));
		g.drawString("Press A for achievements.",850,833);
		//achievemnts: 
			if(CatCount>=100 && NiceClicks==0) {
				if(InGameTimeForNiceClicks<700) {
				g.drawImage(image6, xPosition6, yPosition6, xSize6, ySize6, this);
				InGameTimeForNiceClicks++;
				}
			}
			if(InGameTimeForNiceClicks==130) {
			NiceClicks=1;
			}
			if(CatCount>=1000000 && TheEnd==0) {
				g.drawImage(image7, xPosition7, yPosition7, xSize7, ySize7, this);
				if(TheEnd==0) {
				TheEnd++;
				}
			}
			if(ingametimeforend>-1 && ingametimeforend<130 && TheEnd==1){
				g.setColor(new Color(0,0,0));
				g.setFont(new Font("Arial",Font.BOLD,38));
				g.drawImage(image7, xPosition7, yPosition7, xSize7, ySize7, this);
				g.drawString(""+ulttimer,425,530);
				ingametimeforend++;
			}
			
			//
			
				
				
		//debug menu:
		if (I == 1 ) {
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.drawString("MouseXposition"+MouseX,350,350);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.drawString("MouseYposition"+MouseY,350,300);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.drawString("ClickModifer:"+MouseClickModifer,350,250);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.drawString("InGameTime:"+IngameTimer,350,200);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.drawString("QuickBuyValue:"+QuickBuyValue,350,400);
		g.setFont(new Font("Arial",Font.BOLD,25));
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Arial",Font.BOLD,23));
		g.drawString(""+ulttimer,350,450);	
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Arial",Font.BOLD,23));
		g.drawString(""+ingametimeforend,350,500);	
		}
		if (IsAPressed == 1 ) {
			if(NiceClicks==1) {
			g.drawImage(image6, xPosition6, yPosition6-400, xSize6, ySize6, this);
			}
			if(TheEnd==1) {
				g.setColor(new Color(0,0,0));
				g.setFont(new Font("Arial",Font.BOLD,38));
				g.drawImage(image7, xPosition7, yPosition7, xSize7, ySize7, this);
				g.drawString(""+ulttimer,425,530);
			}
			}
	}
	public String NumChange(double a) {
		String e = "" + a;
		int b = e.length();
		if (e.indexOf(".0")!= - 1) {
			return e.substring(0,b-2);
		}
		return ""+e;
	}
	public void mouseDragged(MouseEvent e) {
	}
	public void mouseMoved(MouseEvent e) {
		MouseX=e.getX();
		MouseY=e.getY();

	}
	public void mouseClicked(MouseEvent e) {
		if(MouseX>=582 && MouseX<=1420 && MouseY<=78 && MouseY>=11 && NumClickerModifer < GlobalLimit*CatPres && CatCount >=( 10-CatChing) ) {
			if(QuickBuyTimes>0 && QuickBuyOn==1) {
				if((( 10-CatChing)*QuickBuyTimes)>CatCount) {
					QuickBuyTimes=(int)CatCount/( 10-CatChing);
				}
				if(QuickBuyTimes>(GlobalLimit*CatPres)-NumClickerModifer)
					QuickBuyTimes=(GlobalLimit*CatPres)-NumClickerModifer;
				if(QuickBuyTimes > 0) {
					MouseClickModifer = MouseClickModifer+QuickBuyTimes ;
					NumClickerModifer= NumClickerModifer+QuickBuyTimes ;
					if(10-CatChing>0) {
					CatCount=CatCount-(30*QuickBuyTimes);
					}
					QuickBuyTimes=0;
					QuickBuyValue="";
				}
				}else 
					if( 10-CatChing <0) {
					MouseClickModifer = MouseClickModifer+1 ;
					NumClickerModifer= NumClickerModifer + 1 ;
					} else {
					if(CatCount>=10-CatChing) {
					MouseClickModifer = MouseClickModifer+1 ;
					CatCount=CatCount-(10-CatChing);
					NumClickerModifer= NumClickerModifer + 1 ;
					}
						}
		}
		if(MouseX<=556 && MouseY<=827) {
			CatCount = CatCount+MouseClickModifer*Buismonopoly ;
			timerstart=1;
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=178 && MouseY>=113 && CatCount>=(GlobalLimit*GlobalLimit)) {
			if( (GlobalLimit*GlobalLimit) <0) {
				CatCount=CatCount-(GlobalLimit*GlobalLimit);
				GlobalLimit=GlobalLimit+1;
	
				} else {
					CatCount=CatCount-((GlobalLimit*GlobalLimit)-CatChing);
					GlobalLimit=GlobalLimit+1;
				}	
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=278 && MouseY>=210 && CatCount>=100 && LoveSofa<GlobalLimit*CatPres) {
				if(QuickBuyTimes>0 && QuickBuyOn==1) {
					if((( 100-CatChing)*QuickBuyTimes)>CatCount) {
						QuickBuyTimes=(int)CatCount/( 100-CatChing);
					}
					if(QuickBuyTimes>(GlobalLimit*CatPres)-LoveSofa)
						QuickBuyTimes=(GlobalLimit*CatPres)-LoveSofa-1;
					if(QuickBuyTimes > 0) {
						LoveSofa=LoveSofa+QuickBuyTimes;
						if(100-CatChing>0) {
						CatCount=CatCount-(100*QuickBuyTimes);
						}
						QuickBuyTimes=0;
						QuickBuyValue="";
					}
				}
				if(100-CatChing <0) {
					LoveSofa++;
					} else {
						LoveSofa++;
						CatCount=CatCount-(100-CatChing);
					}
		}	
		if(MouseX>=582 && MouseX<=1420 && MouseY<=378 && MouseY>=310 && CatCount>=LoveHotel*LoveHotel*LoveHotel && LoveHotel<GlobalLimit*CatPres) {
			if((LoveHotel*LoveHotel*LoveHotel)-CatChing <0) {
				LoveHotel++;
				} else {
					CatCount=CatCount-((LoveHotel*LoveHotel*LoveHotel)-CatChing);
					LoveHotel++;
				}	
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=516 && MouseY>=436 && CatCount>=(Buismonopoly*Buismonopoly) && Buismonopoly<GlobalLimit*CatPres) {
			if((Buismonopoly*Buismonopoly)-CatChing <0 ) {
				Buismonopoly++;	
				} else {
					CatCount=CatCount-((Buismonopoly*Buismonopoly)-CatChing);
					Buismonopoly++;	
				}
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=589 && MouseY>=512 && CatCount>=30 && CatChing<GlobalLimit *CatPres) {
			if(QuickBuyTimes>0 && QuickBuyOn==1) {
			if((30*QuickBuyTimes)>CatCount) {
				QuickBuyTimes=(int)CatCount/30;
			}
			if(QuickBuyTimes>(GlobalLimit*CatPres)-CatChing)
				QuickBuyTimes=(GlobalLimit*CatPres)-CatChing;
			if(QuickBuyTimes > 0) {
				CatChing=CatChing+QuickBuyTimes;
				CatCount=CatCount-(30*QuickBuyTimes);
				QuickBuyTimes=0;
				QuickBuyValue="";
			
			}
			}else {
				if(CatCount>=30) {
			CatCount=CatCount-30;
			CatChing++;
								}				
				}
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=690 && MouseY>=610 && CatCount>=GlobalLimit && CatPres<GlobalLimit) {
			if(QuickBuyTimes>0 && QuickBuyOn==1) { //Checks if the quick buy is on
				if((GlobalLimit*QuickBuyTimes)>CatCount) { //checks of the play has money equal to Cost* QuickBuyTimes
					QuickBuyTimes=(int)CatCount/GlobalLimit;// If the cost times quick time buys is more than the player has changes the cost to the most they can afford
				}
				if(QuickBuyTimes>GlobalLimit-CatPres)// Checks if the global limit checks out
					QuickBuyTimes=GlobalLimit-CatPres;
				if(QuickBuyTimes > 0) { //actually does the base upgrade
					CatPres=CatPres+QuickBuyTimes;
					CatCount=CatCount-(GlobalLimit*QuickBuyTimes);
					QuickBuyTimes=0; //resets the quick buy
					QuickBuyValue="";
				
				}
			}else { // base function:
					if(CatCount>=GlobalLimit) {
						CatCount=CatCount-GlobalLimit;
						CatPres++;
									}				
					}
			
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=790 && MouseY>=710 && CatCount>=100-CatChing && QuickBuyOn!=1) {
			QuickBuyOn=1;
			CatCount=CatCount-100-CatChing;
				
		}
	}
	public void mousePressed(MouseEvent e) {
		if(MouseX<=556 && MouseY<=827) {
			xSize5=xSize5+10;
			ySize5=ySize5-10;
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=78 && MouseY>=11 && CatCount>=10 && NumClickerModifer < GlobalLimit*CatPres) {
			PetSmartBoxSizeChange=10;		
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=178 && MouseY>=113 && CatCount>=(GlobalLimit*GlobalLimit)) {
			CaducationBoxSizeChange=10;
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=278 && MouseY>=210 && CatCount>=100 && LoveSofa<GlobalLimit*CatPres) {
			LoveSofaBoxSizeChange=10;
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=378 && MouseY>=310 && CatCount>=LoveHotel*LoveHotel*LoveHotel && LoveHotel<GlobalLimit*CatPres) {
			LoveHotelBoxSizeChange=10;
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=516 && MouseY>=436 && CatCount>=(Buismonopoly*Buismonopoly) && Buismonopoly<GlobalLimit*CatPres) {
			BuismonopolyBoxSizeChange=10;
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=589 && MouseY>=512 && CatCount>=30 && CatChing<GlobalLimit*CatPres) {
			CatChingBoxSize=10;

		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=690 && MouseY>=610 && CatCount>=30 && CatPres<GlobalLimit*CatPres) {
			presBoxSizeChange=10;
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=790 && MouseY>=710 && CatCount>=100-CatChing && QuickBuyOn!=1) {
			quickbuyboxsizechange=10;	
		}
		
	}
	public void mouseReleased(MouseEvent e) {
		if(MouseX<=556 && MouseY<=827) {
			xSize5=xSize5-10;
			ySize5=ySize5+10;
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=78 && MouseY>=11 && CatCount>=10 && NumClickerModifer < GlobalLimit*CatPres) {
			PetSmartBoxSizeChange=0;		
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=178 && MouseY>=113 && CatCount>=(GlobalLimit*GlobalLimit)) {
			CaducationBoxSizeChange=0;
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=278 && MouseY>=210 && CatCount>=100 && LoveSofa<GlobalLimit*CatPres) {
			LoveSofaBoxSizeChange=0;
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=378 && MouseY>=310 && CatCount>=LoveHotel*LoveHotel*LoveHotel && LoveHotel<GlobalLimit*CatPres) {
			LoveHotelBoxSizeChange=0;
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=516 && MouseY>=436 && CatCount>=(Buismonopoly*Buismonopoly) && Buismonopoly<GlobalLimit*CatPres) {
			BuismonopolyBoxSizeChange=0;
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=589 && MouseY>=512 && CatCount>=30 && CatChing<GlobalLimit*CatPres) {
			CatChingBoxSize=0;
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=690 && MouseY>=610 && CatCount>=30 && CatPres<GlobalLimit*CatPres) {
			presBoxSizeChange=0;
		}
		if(MouseX>=582 && MouseX<=1420 && MouseY<=790 && MouseY>=710 && CatCount>=100-CatChing && QuickBuyOn!=1) {
			quickbuyboxsizechange=0;	
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {		
	}
	public void keyTyped(KeyEvent I) {
	}
	public void keyPressed(KeyEvent i) {
		// TODO Auto-generated method stub
		if(i.getKeyChar()=='i') {
		I=1;
		}
		if(i.getKeyChar()=='a') {
			IsAPressed=1;
			}
		if(i.getKeyChar()=='1' ) {
			QuickBuyValue=QuickBuyValue+"1"; 
		}
		if(i.getKeyChar()=='2' ) {
			QuickBuyValue=QuickBuyValue+"2"; 
		}
		if(i.getKeyChar()=='3' ) {
			QuickBuyValue=QuickBuyValue+"3"; 
		}
		if(i.getKeyChar()=='4' ) {
			QuickBuyValue=QuickBuyValue+"4"; 
		}
		if(i.getKeyChar()=='5' ) {
			QuickBuyValue=QuickBuyValue+"5"; 
		}
		if(i.getKeyChar()=='6' ) {
			QuickBuyValue=QuickBuyValue+"6"; 
		}
		if(i.getKeyChar()=='7' ) {
			QuickBuyValue=QuickBuyValue+"7"; 
		}
		if(i.getKeyChar()=='8' ) {
			QuickBuyValue=QuickBuyValue+"8"; 
		}
		if(i.getKeyChar()=='9' ) {
			QuickBuyValue=QuickBuyValue+"9"; 
		}
		if(i.getKeyChar()=='0' ) {
			QuickBuyValue=QuickBuyValue+"0"; 
		}
		if(i.getKeyChar()=='b' ) {
			QuickBuyTimes=Integer.parseInt(QuickBuyValue);
		}
		if(i.getKeyChar()=='c' ) {
			QuickBuyValue=""; 
			QuickBuyTimes=0;
		}
}
	public void keyReleased(KeyEvent i) {
		if(i.getKeyChar()=='i') {
			I=0;
			}
		if(i.getKeyChar()=='a') {
			IsAPressed=0;
			}	
	}
}
