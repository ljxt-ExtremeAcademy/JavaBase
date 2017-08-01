package com.xuetang9.javabase.chapter11.modeldemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 * 游戏窗体
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年7月10日 下午6:29:35
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
public class GameFrame extends JFrame implements ImageObserver{
	/** 参加游戏的两个英雄对象 */
	private Hero hero1 = null;
	private Hero hero2 = null;
	/** "KO"图片对象 */
	private Image koImage;
	/** 胜利者对象 */
	private Hero winner = null;
	
	public GameFrame(Hero hero1, Hero hero2) throws IOException{
		this.hero1 = hero1;
		this.hero2 = hero2;
		this.hero1.setImage(new ImageIcon("images/马化腾.png").getImage());
		this.hero2.setImage(new ImageIcon("images/马云.png").getImage());
		koImage = new ImageIcon("images/ko.png").getImage();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("示例：模板模式的应用" + "--两个英雄相距：" + hero1.getDistance(hero1.getX(), hero1.getY(), hero2.getX(), hero2.getY()));
		initComponents();
		setSize(800, 600);		
		setVisible(true);
	}

	private void initComponents() throws IOException {	
		//分别添加鼠标拖拽和单击事件
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				//判断鼠标的坐标是否在某个英雄的图片范围内（图片宽、高默认为120）
				if(e.getX() < hero1.getX() + 120 && e.getY() < hero1.getY() + 120){
					hero1.setX(hero1.getX() + (e.getX() - hero1.getX()));
					hero1.setY(hero1.getY() + (e.getY() - hero1.getY()));					
				}
				else if(e.getX() < hero2.getX() + 120 && e.getY() < hero2.getY() + 120){
					hero2.setX(hero2.getX() + (e.getX() - hero2.getX()));
					hero2.setY(hero2.getY() + (e.getY() - hero2.getY()));
				}
				setTitle("两个英雄相距：" + hero1.getDistance(hero1.getX(), hero1.getY(), hero2.getX(), hero2.getY()));
				repaint();//自动调用paint()重绘界面
			}

		});
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getX() < hero1.getX() + 120 && e.getY() < hero1.getY() + 120){
					//英雄2先攻击英雄1
					hero2.PK(hero1);
				}
				else if(e.getX() < hero2.getX() + 120 && e.getY() < hero2.getY() + 120){
					hero1.PK(hero2);	
				}
				if(hero1.getHp() <= 0){
					winner = hero2;
				}else if(hero2.getHp() <= 0){
					winner = hero1;
				}
				repaint();
			}
		});
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//绘制英雄的图片
		g.drawImage(hero1.getImage(), hero1.getX(), hero1.getY(), this);
		g.drawImage(hero2.getImage(), hero2.getX(), hero2.getY(), this);
		
		//绘制血槽
		g.setColor(Color.RED);
		g.drawRect(50, 50, 300, 25);
		g.drawImage(koImage, 360, 50, this);
		g.drawRect(425, 50, 300, 25);
		g.setColor(Color.YELLOW);
		g.fillRect(51, 51, (int)(298 * (hero1.getHp() * 1.0 / hero1.getMaxHp())), 23);
		//马云掉血时，视觉效果是从左往右减血，这里获得失去的长度
		int lostWidth = 298 - (int)(298 * (hero2.getHp() * 1.0 / hero2.getMaxHp()));
		//填充矩形的x坐标加上失去的长度，看起来就是从左往右掉血了
		g.fillRect(426 + lostWidth, 51, (int)(298 * (hero2.getHp() * 1.0 / hero2.getMaxHp())), 23);

		g.setFont(new Font("微软雅黑", Font.BOLD, 24));
		if(winner != null){
			g.setColor(Color.red);
			g.drawString(winner.getName() + "胜利！", 400, 500);
		}else{
			//绘制提示文字
			g.setColor(Color.BLACK);			
			g.drawString("单击头像攻击对方！", 400, 500);
		}
		
	}
		

	public static void main(String[] args) throws IOException {
		Hero hero1 = new Warrior(10000, "马化腾", 150, 200);
		Hero hero2 = new Magical(30000, "马云", 500, 450, 200);
		new GameFrame(hero1, hero2);

	}

}
