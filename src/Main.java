import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		int screenWidth = 500;
		int screenHeight= 500;
		int N = 10;
		Circle[] circles = new Circle[N];
		int R = 50;
		for(int i=0;i<N;i++)
		{
			int x=(int)(Math.random()*(screenWidth-2*R))+R;
			int y=(int)(Math.random()*(screenHeight-2*R))+R;
			int vx=(int)(Math.random()*11)-5;
			int vy=(int)(Math.random()*11)-5;
			circles[i]=new Circle(x,y,R,vx,vy);
		}
		EventQueue.invokeLater(()->{
			AlgoFrame  frame = new AlgoFrame("Welcome",screenWidth,screenHeight);
			
			new Thread(()->{
				while(true) {
					//绘制数据
					frame.render(circles);
					AlgoVisHelper.pause(20);	
					//更新数据
					for(Circle circle:circles) {
						circle.move(0,0,screenWidth,screenHeight);
					}
				}
			}).start();
			
			
		});
	}
}
