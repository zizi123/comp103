
/**
 * Write a description of class BasicArrays here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import ecs100.*;
import java.util.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
    
    public class BasicArrays{
        private int a = 1;
        private int top = 50, left = 50;
        private int s = 50;
        public BasicArrays(){
        UI.initialise();
        UI.addButton("Vertical line",this::doVerticalLine);
        UI.addButton("Box",this::doBox );       
        UI.addButton("Spiral",this::doSpiral );
        UI.addButton("Clear",this::doClear);    
        UI.addButton("Quit",UI::quit);              
    }
        public void doClear(){
        UI.clearPanes();
        UI.clearGraphics();
    }
        public void doVerticalLine(){
            UI.clearGraphics();
            int size = UI.askInt("size of array: ");
            int[]image = new int[size];
            a = size;
            for(int i = 0;i < size;i++){
                image[i] = a;
                UI.setColor(this.getColor(size, image[i]));
                UI.fillRect(left,top,s,s);
                UI.setColor(Color.white);
                UI.setFontSize(20);
                UI.drawString(""+image[i],left+20,top+30);
                top = top + 50;
                a--;
            }
            top = 50;
    }  

   
        public void doBox(){
        UI.clearGraphics();
        int row = UI.askInt("size of row: ");
        int col = UI.askInt("size of col: ");
        int size = row*col; 
        int[][]imagec = new int[row][col];
        for(int c=0; c<row; c++){
            for(int r=0; r<col; r++){
                imagec[r][c]= a;
                UI.setColor(this.getColor(size,imagec[r][c]));
                UI.fillRect(left,top,50,50);
                UI.setColor(Color.white);
                UI.setFontSize(20);
                UI.drawString(""+imagec[r][c],left+20,top+30);
                left=left+50;
                a=a+1;
            }
            left=50;
            top=top+50;
        }
        top=50;
    }
    
    public void doSpiral(){
    
    }
    
    private Color getColor(int numItems, int value){
        return new Color(value*255/numItems);
    }
    
}