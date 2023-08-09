import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random r=new Random();
        int n=r.nextInt(21);
        CallHandle call=new CallHandle(n);
        if(n>0)
        {
            GUI ob=new GUI(call.allocate());
        }

    }
}

class CallHandle
{
    private Stack freshers=new Stack();
    private Queue call=new LinkedList();
    int n;
    static int tol;
    CallHandle(int n)
    {
        this.n=n;
        freshers.push("F7");
        freshers.push("F6");
        freshers.push("F5");
        freshers.push("F4");
        freshers.push("F3");
        freshers.push("F2");
        freshers.push("F1");
    }
    boolean free()
    {
        if(freshers.empty())
        {
            return false;
        }
        return true;
    }
    Queue allocate()
    {
        int i=1;
        while(i<=n)
        {
            if(free())
            {
                call.add("call "+i);
                freshers.pop();
            }
            else
            {
                call.add("call "+i);
                break;
            }
            i++;
        }
        if(i<n)
        {
            call.add("call "+(i+1));
            tol=n-i;
        }
        return call;
    }
}
class GUI{
    JFrame frame;
    Queue call;
    ArrayList in1=new ArrayList();
    public GUI(Queue call){
        this.call=call;
        Font fon=new Font("Arial",Font.BOLD,20);
        Font fon1=new Font("Arial",Font.BOLD,24);
        frame=new JFrame("call");

        JLabel l1=new JLabel("freshers 1");
        l1.setBounds(50,50,100,50);
        JLabel l2=new JLabel("freshers 2");
        l2.setBounds(250,50,100,50);
        JLabel l3=new JLabel("freshers 3");
        l3.setBounds(450,50,100,50);
        JLabel l4=new JLabel("freshers 4");
        l4.setBounds(50,200,100,50);
        JLabel l5=new JLabel("freshers 5");
        l5.setBounds(250,200,100,50);
        JLabel l6=new JLabel("freshers 6");
        l6.setBounds(450,200,100,50);
        JLabel l7=new JLabel("freshers 7");
        l7.setBounds(50,350,100,50);
        JLabel l8=new JLabel("Lead");
        l8.setBounds(250,350,100,50);
        JLabel l9=new JLabel("Manager");
        l9.setBounds(450,350,100,50);
        JLabel l10=new JLabel("");
        l10.setBounds(650,50,100,50);
        JLabel l11=new JLabel("");
        l11.setBounds(650,200,100,50);
        JLabel l12=new JLabel("");
        l12.setBounds(650,350,100,50);
        JLabel l13=new JLabel(CallHandle.tol+" Calls Are Waiting");
        l13.setBounds(250,450,200,50);
        JLabel l14=new JLabel("");
        l14.setBounds(500,450,200,50);
        JTextField t1=new JTextField();
        t1.setBounds(125,50,100,50);
        t1.setEditable(false);
        in1.add(t1);
        JTextField t2=new JTextField();
        t2.setBounds(325,50,100,50);
        t2.setEditable(false);
        in1.add(t2);
        JTextField t3=new JTextField();
        t3.setBounds(525,50,100,50);
        t3.setEditable(false);
        in1.add(t3);
        JTextField t4=new JTextField();
        t4.setBounds(125,200,100,50);
        t4.setEditable(false);
        in1.add(t4);
        JTextField t5=new JTextField();
        t5.setBounds(325,200,100,50);
        t5.setEditable(false);
        in1.add(t5);
        JTextField t6=new JTextField();
        t6.setBounds(525,200,100,50);
        t6.setEditable(false);
        in1.add(t6);
        JTextField t7=new JTextField();
        t7.setBounds(125,350,100,50);
        t7.setEditable(false);
        in1.add(t7);
        JTextField t8=new JTextField();
        t8.setBounds(325,350,100,50);
        t8.setEditable(false);
        in1.add(t8);
        JTextField t9=new JTextField();
        t9.setBounds(525,350,100,50);
        t9.setEditable(false);
        in1.add(t9);

        for(int i=0;i<9;i++){
            String a=getstr();
            JTextField t=(JTextField) in1.get(i);
            if (!a.equals("")) {
                t.setText("In "+a);
            }else{
                t.setText("Free");
            }
        }
        frame.add(l1);frame.add(t1);frame.add(l2);frame.add(t2);frame.add(l3);frame.add(t3);frame.add(l10);
        frame.add(l4);frame.add(t4);frame.add(l5);frame.add(t5);frame.add(l6);frame.add(t6);frame.add(l11);
        frame.add(l7);frame.add(t7);frame.add(l8);frame.add(t8);frame.add(l9);frame.add(t9);frame.add(l12);
        frame.add(l13);frame.add(l14);


        frame.setSize(700, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public String getstr(){
        if(call.isEmpty()){
            return "";
        }
        return (String)call.remove();
    }
}