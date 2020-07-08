import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AlgoFrame extends JFrame{
	private int canvasWidth;
	private int canvasHeight;
	
	public AlgoFrame(String title,int canvasWidth,int canvasHeight) {
		super(title);
		
		this.canvasWidth=canvasWidth;
		this.canvasHeight=canvasHeight;
		AlgoCanvas canvas = new AlgoCanvas();
		//canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
		setContentPane(canvas);
		pack();
		//this.setSize(canvasWidth,canvasHeight);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public AlgoFrame(String title){
		this(title,500,500);
	}
	
	public int getCanvasWidth() {
		return canvasWidth;
	}
	public int getCanvasHeight() {
		return canvasHeight;
	}
	private Circle[] circles;
	public void render(Circle[] circles) {
		this.circles= circles;
		repaint();//JFrame的函数
	}

	private class AlgoCanvas extends JPanel{
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//g.drawOval(50, 50, 300, 300);
			Graphics2D g2d = (Graphics2D)g;
			RenderingHints hints = new RenderingHints(
					RenderingHints.KEY_ANTIALIASING, 
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.addRenderingHints(hints);
			//具体绘制
			/*
			 * AlgoVisHelper.setStrokeWidth(g2d, 5); AlgoVisHelper.setColor(g2d,
			 * Color.BLUE); AlgoVisHelper.fillCircle(g2d, canvasWidth/2, canvasHeight/2,
			 * 200); AlgoVisHelper.setColor(g2d, Color.RED); AlgoVisHelper.strokeCircle(g2d,
			 * canvasWidth/2, canvasHeight/2, 200);
			 */
			 AlgoVisHelper.setStrokeWidth(g2d, 1);
			 AlgoVisHelper.setColor(g2d, Color.RED);
			 for(Circle circle : circles) {
				 AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
			 }
		}
		@Override
		public Dimension getPreferredSize()
		{
			return new Dimension(canvasWidth,canvasHeight);
			
		}
		
		
	}
	
}
