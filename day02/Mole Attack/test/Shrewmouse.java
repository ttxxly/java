package test;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * �������Ϸ
 * @author mike
 *
 */
public class Shrewmouse extends JFrame implements Runnable {
    private JLabel[] mouses;// �����ʾ�����ǩ������
    private ImageIcon imgMouse;// ����ͼƬ����
    private int clickedNumber = 0;// ���еĵ�������
    private long[] jumpTime;// ���������ĵ�ǰʱ������

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    Shrewmouse frame = new Shrewmouse();// ��������
                    frame.setVisible(true);// ��ʾ����
                    new Thread(frame).start();// �����߳�
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Shrewmouse() {
        super();
        setResizable(false);// ��ֹ���������С
        getContentPane().setLayout(null);// �贰�岻ʹ�ò��ֹ�����
        setTitle("���״������Ϸ");// ����
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ��ʼ������ͼ�����
        ImageIcon img = new ImageIcon(getClass().getResource("background.jpg"));
        // ��ʼ������ͼƬ����
        imgMouse = new ImageIcon(getClass().getResource("mouse.png"));
        mouses = new JLabel[6];// ������ʾ����ı�ǩ����
        jumpTime = new long[6];// ������ʾ���������ĵ�ǰʱ������
        for (int i = 0; i < mouses.length; i++) {// ��������
            mouses[i] = new JLabel(); // ��ʼ��ÿ������
            // ���ñ�ǩ�����ͼƬͬ���Ĵ�С
            mouses[i].setSize(imgMouse.getIconWidth(), imgMouse.getIconHeight());
            mouses[i].addMouseListener(new MouseAdapter() {// Ϊ��ǩ�������¼�����������
                /**
                 * ������굥���¼��ķ���
                 */
                @Override
                public void mouseClicked(MouseEvent e) {
                    Object source = e.getSource();// ��ȡ�¼�Դ���������ǩ
                    JLabel mouse = (JLabel) source;
                    if (mouse.getIcon() != null) {// ��������ǩ���ڵ���ͼƬ������Ϊ��
                        mouse.setIcon(null);
                        clickedNumber++;// �����е�����������
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
        // ���ñ�ǩ�뱳��ͼƬ��ͬ�Ĵ�С
        backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        // ���ô�����Ʊ���ͼƬ��С
        setBounds(100, 100, img.getIconWidth(), img.getIconHeight() + 30);
        backLabel.setIcon(img);// ��ӱ�������ǩ
        getContentPane().add(backLabel);// ��ӱ���ͼƬ������

    }

    /**
     * �̵߳ĺ��ķ���
     */
    @Override
    public void run() {
        while (true) { // ʹ������ѭ��
            for (int i = 0; i < jumpTime.length; i++) {// ѭ�����������ĵ�ǰʱ������
                if (System.currentTimeMillis() - jumpTime[i] > 1000) {// ���������ʾʱ�䳬��1�룬����ͼƬΪ��
                    mouses[i].setIcon(null);
                }
            }
            try {
                Thread.sleep(1000);// ʹ�߳�����1��
                int index = (int) (Math.random() * 6);// ��������ĵ�������
                if (mouses[index].getIcon() == null) {// �����������û������ͼƬ
                    mouses[index].setIcon(imgMouse);// Ϊ�ñ�ǩ��ӵ���ͼƬ
                    jumpTime[index] = System.currentTimeMillis();
                }
                if (clickedNumber == 10) {// �������20�������Ӯ��
                    int result =JOptionPane.showConfirmDialog(this, "<html><body>You Win!!<br/>�Ƿ������</body></html>", "��ʾ��Ϣ", JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE);
                    if (result==JOptionPane.YES_OPTION) {
                        clickedNumber=0;
                        continue;//����ѭ��
                    }else {
                        break;// ����ѭ��
                    }

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}