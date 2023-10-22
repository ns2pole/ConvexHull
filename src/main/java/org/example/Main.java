package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

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

        JFrame frame = new JFrame("Draw Line Example");

//        frame.setLayout(new BorderLayout());

//        JPanel panel = new JPanel();
//        panel.setBackground(Color.LIGHT_GRAY);

//        JButton button1 = new JButton("Button 1");
//        JButton button2 = new JButton("Button 2");
//
//        panel.add(button1);
//        panel.add(button2);

//        frame.add(panel, BorderLayout.NORTH); // ボタンが置かれるパネルをフレームの上部に配置

            BufferedImage image = new BufferedImage(550, 250, BufferedImage.TYPE_INT_ARGB);
            Graphics g = image.getGraphics();
            g.setColor(Color.BLACK);
            g.drawLine( 10, 10, 400, 400);
            g.fillRect(100, 50, 50, 50);
            JLabel label = new JLabel(new ImageIcon(image));
            frame.add(label);
            frame.pack();
            frame.setVisible(true);
    //
//        URL imageUrl = Main.class.getResource("/bridge.png");
////         JLabelにImageIconをセット

//        JLabel label = new JLabel("Hello, world!");
//         JFrameにJLabelを追加
    }
}