package xdvrx1ProjectSwing;

/** 
 * Java Swing is a great GUI framework of Java.
 * This is the lighweight version of AWT.
 * JavaFX, on the other hand, is the most
 * recent GUI framework particularly for
 * mobile apps.
 */

//importing the three packages
//so that there will be no error in compiling
//javax.swing is widely used today than java.awt
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.Image;
import javax.swing.ImageIcon;

import java.io.*;

class UIClass {  
   
   private final BackgroundImage backgroundImage;
   private final Image bg;
   private final ImageIcon imageIcon;
   
   //a DefaultListModel is needed to hold the 
   //items that will be displayed on JList
   //the type is String      
   private final DefaultListModel<String> items;
   
   private final Font f;
   private final Font f2;
   
   //a List View component creation through JList with the items,      
   //the type is String also, so not to issue a warning
   //from the compiler   
   private final JList<String> returnResultJL;
   
   private final DefaultListCellRenderer renderer;
   private final JFrame frame;
   
   //creation of a JLabel to hold some string message   
   private final JLabel text;
   
   //JTextField named 'cm' was called here
   //it belongs to the same class, under the same
   //constructor, so the object can be called  
   private final JTextField cm;
   
   private final FlowLayout flowLayout;
   
   private final JPanel textPanel; 
   //a creation of a JButton with a text "Convert"    
   private final JButton b;
   
   //a creation of a JScrollPane
   //so that if the items are out of 
   //range, it can still be seen   
   private final JScrollPane scroll;
   
   private final JPanel convertPanel;
   private final JButton b2;
   
   //another creation of a JPanel to hold the second button 
   private final JPanel resetPanel;
   
   //at last the main panel
   private final JPanel mainPanel;
   
   public UIClass() throws Exception {
      
      backgroundImage = new BackgroundImage(); 
      
      bg = backgroundImage.backgroundImage(ResourcePath.path);
      imageIcon = new ImageIcon(bg);
      
      items = new DefaultListModel<String>();       
      f = new Font("Consolas", Font.PLAIN, 24);
      f2 = new Font("Comic Sans MS", Font.ITALIC, 24);
      returnResultJL= new JList<String>(items);
      
      renderer = (DefaultListCellRenderer)returnResultJL.getCellRenderer();
      
      frame = new JFrame("Converter");
      
      text = new JLabel("");
      
      cm = new JTextField();   
      
      flowLayout = new FlowLayout();
      textPanel = new JPanel(flowLayout); 
      
      b = new JButton ("Convert");
      b2 = new JButton("Reset");
      
      scroll = new JScrollPane(returnResultJL); 
      
      convertPanel = new JPanel(flowLayout);      
      resetPanel = new JPanel ();    
      mainPanel = new PanelWithBackgroundImage(bg);
   }
   
   void init() {             
      
      renderer.setHorizontalAlignment(SwingConstants.CENTER);
      
      returnResultJL.setFont(f2);      
      
      text.setText("Centimeters:"); 
      text.setFont(f);     
      
      cm.setFont(f);          
      cm.setColumns(10);
      cm.setHorizontalAlignment(JTextField.CENTER);
      cm.setDocument(new JTextFieldLimit(8));
      
      int align = flowLayout.CENTER;
      
      textPanel.setOpaque(false);      
      //after a textPanel was created, text label will be added 
      textPanel.add(text,BorderLayout.PAGE_START );
      //also the 'cm' JTextField was added
      textPanel.add(cm);
      
      //changing the font to the specified font
      b.setFont(f);
      b.setOpaque(false);
      textPanel.add(b);    
      
      b2.setFont(f);      
      resetPanel.add(b2);
      resetPanel.setOpaque(false); 
      
      scroll.setPreferredSize (new Dimension(700, 110));
      
      convertPanel.add(scroll);
      convertPanel.setOpaque(false);           
      
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));      
      //adding all the panels here in order
      mainPanel.add(Box.createVerticalStrut(110));
      mainPanel.add(textPanel);  
      mainPanel.add(Box.createVerticalStrut(30));
      mainPanel.add(convertPanel);
      mainPanel.add(Box.createVerticalStrut(30));
      mainPanel.add(resetPanel);
      mainPanel.add(Box.createVerticalStrut(210));
      
      //and finally adding the main panel to the frame
      frame.add(mainPanel);
      
      //setting the frame behavior
      frame.setIconImage(imageIcon.getImage());
      frame.setResizable(false);
      frame.setVisible(true);
      frame.pack();
      frame.setLocationRelativeTo(null);      
      //a command to simply close the frame
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
      
      //in this part is where after an action
      //there will be a corresponding event    
      b.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){
            ComputeValue compute = new ComputeValue();
            String cmFormatted = cm.getText();
            
            String result = compute.compute(cmFormatted);
            
            if (result == "malformed") {
               JOptionPane.showMessageDialog(frame,
                                             "Malformed number or empty",
                                             "Error",
                                             JOptionPane.ERROR_MESSAGE);
            } else if (result == "outB") {
               JOptionPane.showMessageDialog(frame,
                                             "Out of Bounds.",
                                             "Error",
                                             JOptionPane.ERROR_MESSAGE); 
            } else if (result == "too small") {
               JOptionPane.showMessageDialog(frame,
                                             "Number too small.",
                                             "Error",
                                             JOptionPane.ERROR_MESSAGE);             
            } else {
               
               //at this point, the formatted string will
               //be added to the Listview               
               items.add(0,result); 
               returnResultJL.grabFocus();
               returnResultJL.setSelectedIndex(0);
               returnResultJL.ensureIndexIsVisible(0);
               
               //the 'cm' should be set to blank, 
               //to enable receiving inputs again 
               cm.setText("");
               
            }
         }
      });
      
      b2.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){
            cm.setText("");
            items.clear(); 
            cm.grabFocus();
         }
      });    
      
   }
}
