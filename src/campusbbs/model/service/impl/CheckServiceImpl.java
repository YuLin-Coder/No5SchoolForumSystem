package campusbbs.model.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.awt.FontMetrics;

import campusbbs.model.service.CheckService;

public class CheckServiceImpl implements CheckService{
	
	public BufferedImage getCheckImage(String check,int width,int height){
		
		BufferedImage checkImg=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d=(Graphics2D)checkImg.getGraphics();		
		int len=check.length();
		int step=width/len;
		Random ran=new Random();
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, width+20, height);
		
		g2d.setFont(new Font("黑体", Font.PLAIN, 24));
		FontMetrics fm=g2d.getFontMetrics();
		Rectangle2D r2d=fm.getStringBounds("0", g2d);
		int fw=(int)r2d.getWidth();
		int fh=(int)r2d.getHeight();
		
		//绘制验证码
		for(int i=0;i<len;i++){
			char ch=check.charAt(i);
			int h=(height+3*fh)/4-ran.nextInt((height-fh)/2);
			int w=((4*i+1)*step-fw)/4+ran.nextInt((step-fw)/2); 
			int degree = ran.nextInt(60)-30;//控制旋转角度
			g2d.setColor(getRandomColor(20, 180));
			
			g2d.rotate(degree*Math.PI/180, step*i+step/2, height/2);
			g2d.drawString(String.valueOf(ch), w,h);
			g2d.rotate(-degree*Math.PI/180, w, h);
		}
		
		int n=ran.nextInt(5)+5;
		g2d.rotate(0, 0, 0);
		for(int i=0;i<n;i++){
			int x1=ran.nextInt(width);
			int y1=ran.nextInt(height);
			int x2=ran.nextInt(width);
			int y2=ran.nextInt(height);
			g2d.setColor(getRandomColor(25, 200));
			g2d.drawLine(x1, y1, x2, y2);
		}
		
		return checkImg;
	}
	
	public String getCheckString(int checkLenght){		
		StringBuilder check=new StringBuilder();		
		Random ran=new Random();
		for(int i=0;i<checkLenght;i++){
			int num=ran.nextInt(102);
			char ch;
			if(num<26){
				ch=(char)(num+'a');
			}else if(num<52){
				num-=26;
				ch=(char)(num+'A');
			}else{
				num-=52;
				num%=10;
				ch=(char)(num+'0');
			}
			check.append(ch);
		}			
		return check.toString();
	}
	
	private Color getRandomColor(int s,int e) {
		// TODO Auto-generated method stub
		Random ran=new Random();
		int r=ran.nextInt(e)+s;
		int g=ran.nextInt(e)+s;
		int b=ran.nextInt(e)+s;
		if(r>255) r%=255;
		if(g>255) g%=255;
		if(b>255) b%=255;
		return new Color(r, g, b);
	}
	
}















































