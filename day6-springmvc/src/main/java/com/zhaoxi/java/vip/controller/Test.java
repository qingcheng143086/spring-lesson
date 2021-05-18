package com.zhaoxi.java.vip.controller;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
public class Test {


    public static class test {
        public static void main(String[] args) throws AWTException {

            Robot robot = new Robot();// 创建Robot对象（机器人）
            robot.delay(6000);// 延迟六秒，主要是为了预留出打开窗口的时间，括号内的单位为毫秒
            Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
            for (int j = 0; j < 1000; j++) {//循环次数
                String sentencet = "爱你"+j+"次";
                System.out.println(sentencet);
                Transferable tText = new StringSelection(sentencet);
                clip.setContents(tText, null);
                // 以下两行按下了ctrl+v，完成粘贴功能
                robot.keyPress(KeyEvent.VK_CONTROL);// 按下Control键
                robot.keyPress(KeyEvent.VK_V);// 按下V键
                robot.keyRelease(KeyEvent.VK_CONTROL);// 释放ctrl按键，像ctrl，退格键，删除键这样的功能性按键，在按下后一定要释放，不然会出问题。crtl如果按住没有释放，在按其他字母按键是，敲出来的回事ctrl的快捷键。
                robot.delay(100);// 延迟一秒再发送，不然会一次性全发布出去，因为电脑的处理速度很快，每次粘贴发送的速度几乎是一瞬间，所以给人的感觉就是一次性发送了全部。这个时间可以自己改，想几秒发送一条都可以
                robot.keyPress(KeyEvent.VK_ENTER);// 回车
                // }
            }
        }
    }

}
