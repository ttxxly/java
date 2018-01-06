package test;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * 打地鼠游戏
 * @author mike
 *
 */
public class Shrewmouse extends JFrame implements Runnable {
    private JLabel[] mouses;// 存放显示地鼠标签的数组
    private ImageIcon imgMouse;// 地鼠图片对象
    private int clickedNumber = 0;// 击中的地鼠数量
    private long[] jumpTime;// 地鼠跳出的当前时间数组

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    Shrewmouse frame = new Shrewmouse();// 创建窗体
                    frame.setVisible(true);// 显示窗体
                    new Thread(frame).start();// 启动线程
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Shrewmouse() {
        super();
        setResizable(false);// 禁止调整窗体大小
        getContentPane().setLayout(null);// 设窗体不使用布局管理器
        setTitle("简易打地鼠游戏");// 标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 初始化背景图像对象
        ImageIcon img = new ImageIcon(getClass().getResource("background.jpg"));
        // 初始化地鼠图片对象
        imgMouse = new ImageIcon(getClass().getResource("mouse.png"));
        mouses = new JLabel[6];// 创建显示地鼠的标签数组
        jumpTime = new long[6];// 创建显示地鼠跳出的当前时间数组
        for (int i = 0; i < mouses.length; i++) {// 遍历数组
            mouses[i] = new JLabel(); // 初始化每个数组
            // 设置标签与地鼠图片同样的大小
            mouses[i].setSize(imgMouse.getIconWidth(), imgMouse.getIconHeight());
            mouses[i].addMouseListener(new MouseAdapter() {// 为标签添加鼠标事件监听适配器
                /**
                 * 处理鼠标单击事件的方法
                 */
                @Override
                public void mouseClicked(MouseEvent e) {
                    Object source = e.getSource();// 获取事件源，即地鼠标签
                    JLabel mouse = (JLabel) source;
                    if (mouse.getIcon() != null) {// 如果地鼠标签存在地鼠图片，设置为空
                        mouse.setIcon(null);
                        clickedNumber++;// 被击中地鼠数量自增
                    }
                }
            });
            getContentPane().add(mouses[i]);
        }
        mouses[0].setLocation(253, 300);
        mouses[1].setLocation(333, 250);
        mouses[2].setLocation(388, 296);
        mouses[3].setLocation(362, 364);
        mouses[4].setLocation(189, 353);
        mouses[5].setLocation(240, 409);

        final JLabel backLabel = new JLabel();
        // 设置标签与背景图片相同的大小
        backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        // 设置窗体近似背景图片大小
        setBounds(100, 100, img.getIconWidth(), img.getIconHeight() + 30);
        backLabel.setIcon(img);// 添加背景到标签
        getContentPane().add(backLabel);// 添加背景图片到窗体

    }

    /**
     * 线程的核心方法
     */
    @Override
    public void run() {
        while (true) { // 使用无限循环
            for (int i = 0; i < jumpTime.length; i++) {// 循环地鼠跳出的当前时间数组
                if (System.currentTimeMillis() - jumpTime[i] > 1000) {// 如果地鼠显示时间超过1秒，设置图片为空
                    mouses[i].setIcon(null);
                }
            }
            try {
                Thread.sleep(1000);// 使线程休眠1秒
                int index = (int) (Math.random() * 6);// 生成随机的地鼠索引
                if (mouses[index].getIcon() == null) {// 如果地鼠索引没有设置图片
                    mouses[index].setIcon(imgMouse);// 为该标签添加地鼠图片
                    jumpTime[index] = System.currentTimeMillis();
                }
                if (clickedNumber == 10) {// 如果击中20个地鼠就赢了
                    int result =JOptionPane.showConfirmDialog(this, "<html><body>You Win!!<br/>是否继续？</body></html>", "提示信息", JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE);
                    if (result==JOptionPane.YES_OPTION) {
                        clickedNumber=0;
                        continue;//继续循环
                    }else {
                        break;// 跳出循环
                    }

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}