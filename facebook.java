package jdbc;

// Demonstrate Labels
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
<applet code="Que.class" width=300 height=200>
</applet>
*/
public class facebook extends Applet implements ActionListener,ItemListener {
String str;
int col1=0,col2=0;
Button b[];
CheckboxGroup g[];
Checkbox c[];
TextField tf[];
TextArea ta1,ta2;
Label l[];
FileOutputStream fout=null;
String msg1=null,msg2=null;
//Back obj=new Back();
int i=0;
File file =new File("graph.txt");
        FileWriter writer=null;
   
public void init() {

	b=new Button[10];
	tf=new TextField[10];
	g=new CheckboxGroup[5];
	c=new Checkbox[20];
	l=new Label[10];
        tf[1]=new TextField("username");
	l[1]=new Label("Select x-axis");
	l[2]=new Label("Select y-axis");
	//b[1]=new Button("Submit DB name");
	b[1]=new Button("Submit Query");
	g[1]=new CheckboxGroup();
	g[2]=new CheckboxGroup();
	c[1]=new Checkbox("username",g[1],false);
	c[2]=new Checkbox("friends",g[1],false);
	c[3]=new Checkbox("post",g[1],false);
	c[4]=new Checkbox("time",g[1],false);
	c[5]=new Checkbox("like",g[1],false);
	c[6]=new Checkbox("comment",g[1],false);
	c[7]=new Checkbox("share",g[1],false);
        
	c[8]=new Checkbox("username",g[2],false);
	c[9]=new Checkbox("friends",g[2],false);
	c[10]=new Checkbox("post",g[2],false);
	c[11]=new Checkbox("time",g[2],false);
	c[12]=new Checkbox("like",g[2],false);
	c[13]=new Checkbox("comment",g[2],false);
	c[14]=new Checkbox("share",g[2],false);
	//tf[1]=new TextField(10);
	//tf[2]=new TextField(500);
	//b2=new Button("");
	//b3=new Button("button 3");
	//c[1]=new Checkbox("Facebook",g1,false);
	//c[2]=new Checkbox("Instagram",g1,false);
	//l[1]=new Label("Mark the social networking sites on which you have an account");
	setLayout(null);
        add(tf[1]);
        tf[1].setBounds(10,1,250,20);
        add(l[1]);
	l[1].setBounds(20,15,100,50);
	
        add(c[1]);
	c[1].setBounds(150,20,100,50);
	add(c[2]);
	c[2].setBounds(300,20,100,50);
	add(c[3]);
	c[3].setBounds(400,20,100,50);
	add(c[4]);
	c[4].setBounds(500,20,100,50);
	add(c[5]);
	c[5].setBounds(600,20,100,50);
	add(c[6]);
	c[6].setBounds(700,20,100,50);
	add(c[7]);
	c[7].setBounds(800,20,100,50);
	
	add(l[2]);
	l[2].setBounds(20,90,100,50);
	add(c[8]);
	c[8].setBounds(150,100,100,50);
	add(c[9]);
	c[9].setBounds(300,100,100,50);
	add(c[10]);
	c[10].setBounds(400,100,100,50);
	add(c[11]);
	c[11].setBounds(500,100,100,50);
	add(c[12]);
	c[12].setBounds(600,100,100,50);
	add(c[13]);
	c[13].setBounds(700,100,100,50);
	add(c[14]);
	c[14].setBounds(800,100,100,50);
	
	//tf[1].setBounds(200,200,200,30);
	//add(tf[2]);
	//tf[2].setBounds(450,200,200,30);
	//add(b[1]);
	//b[1].setBounds(200,280,200,50);
	//add(b[2]);
	//b[2].setBounds(450,280,200,50);
	//add(b3);

	//add(c[1]);
	//c[1].setBounds(20,20,100,50);
	//add(c[2]);
	//c[2].setBounds(200,20,100,50);
	//add(l[1]);
	//l[1].setBounds(20,80,1000,20);
	//b[1].addActionListener(this);
	//b[2].addActionListener(this);
	//tf[1].addActionListener(this);
	//tf[2].addActionListener(this);
	//b3.addActionListener(this);
	c[1].addItemListener(this);
	c[2].addItemListener(this);
	c[3].addItemListener(this);
	c[4].addItemListener(this);
	c[5].addItemListener(this);
	c[6].addItemListener(this);
	c[7].addItemListener(this);
	c[8].addItemListener(this);
	c[9].addItemListener(this);
	c[10].addItemListener(this);
	c[11].addItemListener(this);
	c[12].addItemListener(this);
	c[13].addItemListener(this);
	c[14].addItemListener(this);
        tf[1].addActionListener(this);
	//obj.initialise();
        try{
            file.createNewFile();
        writer=new FileWriter(file);
        
        
        }
        catch(Exception e2){}
}
public void actionPerformed (ActionEvent e){
	try
        {
            
    //fout.write(tf[1].getText());
    /*String str=e.getActionCommand(),s;
	if(str.equals("Submit DB name"))
	{
		s=tf[1].getText();
		obj.createDatabase(s);
		msg="database"+s+"created";
		obj.useDatabase(s);
		msg1="database"+s+"currently selected";
	}
	else if(str.equals("Submit Query"))
	{
		s=tf[2].getText();
		obj.anyQuery(s);
		msg="Query executed";
		msg1="---------";
		
	}
	else
	{
		msg1="abc";
		msg="def";
	}
	//if(str.equals("button 2"))msg="b2 pressed";
	//if(str.equals("button 3"))msg="b3 pressed";
	repaint();*/
            
        }
        catch(Exception e1)
        {
        }
        
        }


public void itemStateChanged(ItemEvent e){
try{	
    String str1=g[1].getSelectedCheckbox().getLabel();
	String str2=g[2].getSelectedCheckbox().getLabel();
	if(str1.equals("username")) {msg1="username";}
        if(str1.equals("friends")){msg1="friends";col1=1;}
	if(str1.equals("post")){msg1="post";col1=2;}
	if(str1.equals("time")){msg1="time";col1=3;}
	if(str1.equals("like")){msg1="like";col1=4;}
	if(str1.equals("comment")){msg1="comment";col1=5;}
	if(str1.equals("share")){msg1="share";col1=6;}
	
	
if(str2.equals("username")) {msg2="username";}
        if(str2.equals("friends")){msg2="friends";col1=1;}
	if(str2.equals("post")){msg2="post";col1=2;}
	if(str2.equals("time")){msg2="time";col1=3;}
	if(str2.equals("like")){msg2="like";col1=4;}
	if(str2.equals("comment")){msg2="comment";col1=5;}
	if(str2.equals("share")){msg2="share";col1=6;}
	
        writer.write(tf[1].getText());
        writer.write(System.getProperty( "line.separator" ));
        writer.append(String.valueOf(col1));
        writer.write(System.getProperty( "line.separator" ));
        writer.append(String.valueOf(col2));
        
        
        writer.flush();
                writer.close();
        gnischay2 a=new gnischay2(msg1,msg2);
        a.main(null);
        Abc ob=new Abc();
        ob.main1();
	repaint();
}
catch(Exception e1)
{
    
}
}

public void paint(Graphics g){
    
    try{
	//g.drawString(msg,10,100);
	//g.drawString(msg1,30,100);
    }
    catch(Exception e3){}
}
}

class Abcd {
public static void main1() throws IOException
{
try {
    Process p = Runtime
                    .getRuntime()
                    .exec("cmd /c start cmd.exe /K \"python likegraph.py\"");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}
}
}