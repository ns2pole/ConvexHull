package org.example;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.example.Linear2DEquation.getSolution;
import static org.example.Vector2D.get2DVector;

public class Main {
    public static void main(String[] args) {
//        JFrame frame = new JFrame("Simple Button Example");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // ウィンドウを閉じるとプログラムも終了
//        frame.setSize(500, 500);  // ウィンドウのサイズを設定
//
//        JButton button = new JButton("Click Me");  // ボタンを作成
//        frame.setLayout(new FlowLayout());  // レイアウトマネージャーをFlowLayoutに設定
//        // ActionListenerをボタンに追加
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(frame, "Hello, Keito");
//            }
//        });
//        frame.add(button);  // ボタンをフレームに追加
//
//        frame.setVisible(true);  // ウィンドウを可視化


//        frame.setLayout(new BorderLayout());

//        JPanel panel = new JPanel();
//        panel.setBackground(Color.LIGHT_GRAY);
//
//        JButton button1 = new JButton("Button 1");
//        JButton button2 = new JButton("Button 2");
//
//        panel.add(button1);
//        panel.add(button2);
//
//        frame.add(panel, BorderLayout.NORTH); // ボタンが置かれるパネルをフレームの上部に配置
        JFrame frame = new JFrame("Draw Line Example");
        BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.BLACK);
        HashSet<Dot> dots = new HashSet<>();
        for(int i = 0; i < 200; i++) {
            dots.add(Dot.getRandomly());
        }
        Dot.drawConvexHull(dots,g);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.pack();
        frame.setVisible(true);

//        Line l1= new Line(d2,d4);
//        Vector2D v1 = get2DVector(d2, d4);
//        Vector2D v2 = v1.getNormalVector();
//        Vector2D v3 = get2DVector(d2, d1);
//        Vector2D v4 = get2DVector(d2, d3);
//        Linear2DEquation le2D1_1 = new Linear2DEquation(v1.x,v2.getX(),v3.getX());
//        Linear2DEquation le2D1_2 = new Linear2DEquation(v1.y,v2.getY(),v3.getY());
//        Linear2DEquation le2D2_1 = new Linear2DEquation(v1.getX(),v2.getX(),v4.getX());
//        Linear2DEquation le2D2_2 = new Linear2DEquation(v1.getY(),v2.getY(),v4.getY());
//        System.out.println(getSolution(le2D1_1, le2D1_2));
//        System.out.println(getSolution(le2D2_1, le2D2_2));
//            BufferedImage image = ImageIO.read(new File("C:\\beach.jpg"));
//            g2d.drawImage(image, null, 10, 10);
    //
//        URL imageUrl = Main.class.getResource("/bridge.png");
////         JLabelにImageIconをセット

//        JLabel label = new JLabel("Hello, world!");
//         JFrameにJLabelを追加
    }
}