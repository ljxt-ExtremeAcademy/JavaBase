package com.xuetang9.javabase.chapter7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 图形界面实现的绘制任意三角形
 * @author 老九学堂·窖头
 * @version 1.0
 * @date 2017年6月26日 上午8:47:59
 * @copyright 老九学堂
 * @remarks TODO
 *
 */
 
public class ComputeAngles extends JFrame{
	private ComputeAngles me = this;
	//三个起始点坐标
	static int x1 = 90, y1 = 180;
	static int x2 = 205, y2 = 85;	
	static int x3 = 310, y3 = 240;
	static int radius = 10;//半径
	
	public ComputeAngles(){
		super("绘制三角形");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//鼠标点击事件的监听
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);				
			}
		});
		getContentPane().addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				double dis1 = getDistance(x1, y1, e.getX(), e.getY());
				double dis2 = getDistance(x2, y2, e.getX(), e.getY());
				double dis3 = getDistance(x3, y3, e.getX(), e.getY());
				
				if(dis1 <= radius){
					//System.out.println("A角范围内！");
					x1 = e.getX();
					y1 = e.getY();
					repaint();
				}
				if(dis2 <= radius){
					x2 = e.getX();
					y2 = e.getY();
					repaint();
				}
				if(dis3 <= radius){
					x3 = e.getX();
					y3 = e.getY();
					repaint();
				}
					
				showArea();
			}
		});
		showArea();
		setSize(400, 500);
		setVisible(true);
	}
	
	/**
	 * 返回两点之间的距离
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	private double getDistance(int x1, int y1, int x2, int y2){
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
	/**
	 * 根据三条边的边长计算三角形面积
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private void showArea(){
		double a = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
		double b = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
		double c = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));	
		//海伦公式：S=√[p(p-a)(p-b)(p-c)]
		double p = (a + b + c) / 2;	//半周长
		double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		setTitle("三角形面积为：" + Math.round(s * 100) / 100.0);
	}
	
	@Override
	public void update(Graphics g) {
		super.update(g);
		paint(g);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g= getContentPane().getGraphics();
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		Point p3 = new Point(x3, y3);
		g.setColor(Color.BLACK);
		g.drawLine(p1.x, p1.y, p2.x, p2.y); 
		g.drawLine(p1.x, p1.y, p3.x, p3.y);
		g.drawLine(p2.x, p2.y, p3.x, p3.y);

		String str1 = String.format("(%d, %d)", x1, y1);
		String str2 = String.format("(%d, %d)", x2, y2);
		String str3 = String.format("(%d, %d)", x3, y3);
		g.drawString(str1, x1 - 50, y1 - 10);
		g.drawString(str2, x2 - 20, y2 - 10);
		g.drawString(str3, x3, y3 - 10);
		
		//绘制一个能包含住一矩形的圆
		//假想有个矩形刚好把圆包住，那么矩形的左上角坐标就是(x,y),
		//矩形的右下角的坐标就是 （x+width,y+height）
		//圆心坐标是（x+width/2,y+height/2） 半径是（width/2）
		//换算：圆心坐标就是 x1-radius, y1-radius
		//g.drawOval(x1 - radius, y1 - radius, radius * 2, radius * 2);
		//g.drawOval(x2 - radius, y2 - radius, radius * 2, radius * 2);
		//g.drawOval(x3 - radius, y3 - radius, radius * 2, radius * 2);
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
//		1、两点之间距离公式：√(〖(𝒙𝟐−𝒙𝟏)〗^𝟐+〖(𝒚𝟐−𝒚𝟏)〗^𝟐 )
//		2、可以通过以下公式计算角度：
//		A = acos((a * a - b * b - c * c) / (-2 * b * c))
//		B = acos((b * b - a * a - c * c) / (-2 * a * c))
//		C = acos((c * c - b * b - a * a) / (-2 * b * a))
		Scanner input = new Scanner(System.in);
		//1.用户输入三个点的坐标
		//2.根据坐标计算三条边的值
		//3.根据三条边的值计算角度（弧度）
		//4.弧度转度
		double a = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
		double b = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
		double c = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));		
		//计算三个角的弧度
		double radiansA = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
		double radiansB = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
		double radiansC = Math.acos((c * c - a * a - b * b) / (-2 * a * b));
		/** 弧度转度 */
		double degreeA = Math.toDegrees(Math.round(radiansA * 100) / 100.0);
		double degreeB = Math.toDegrees(radiansB);
		double degreeC = Math.toDegrees(radiansC);
		
		System.out.println(a + "\t" + b + "\t" + c);
		System.out.printf("三个角度分别为（弧度）：%.2f\t%.2f\t%.2f\n", radiansA, radiansB, radiansC );
		System.out.printf("三个角度分别为（度）：%.2f\t%.2f\t%.2f\n", degreeA, degreeB, degreeC);
		
//		Process proc = Runtime.getRuntime().exec("cmd");
//		PrintWriter out = new PrintWriter(proc.getOutputStream());
//		out.println("cd /system");
//		out.flush();
//		proc.waitFor();
		new ComputeAngles();
	}

}
