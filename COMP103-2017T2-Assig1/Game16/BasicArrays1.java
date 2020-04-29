
/**
 * Write a description of class BasicArrays1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import ecs100.*;
import java.awt.Color;
public class BasicArrays1{
    private int[] line;
    private int[][] box;
    //layout of the grid
    private final int gridLeft = 10;
    private final int gridTop = 10;
    private final int cellSize = 40;
    public BasicArrays1(){
        UI.addButton("Vertical line",() ->{populateLine(); drawLine();});
        UI.addButton("Box",() ->{populateBox(); drawBox();});
        UI.addButton("Spiral",() ->{populateSpiral(); drawBox();});
        UI.addButton("Clear",UI::clearPanes);
        UI.addButton("QUit",UI::quit);
    }
    
    public void populateLine(){
        int size = UI.askInt("size of array");
        if(size < 0){
            UI.print("the size must be positive");
            return;
        }
        line =new int[size];
        for(int i = 0;i < line.length;i++){
            line[i] = size - i; 
        }
    }
    
    private void drawLine(){
        if(line == null)return;
        for(int row = 0;row <line.length;row++){
            drawLineCell(row);
        }
    }
    
    private void drawLineCell(int row){
        
        double left = gridLeft;
        double top = gridTop + row*cellSize;
        UI.setColor(getColor(line.length,line[row]));
        UI.fillRect(left,top,cellSize,cellSize);
        
        UI.setColor(Color.white);
        double x = left + cellSize *0.35;
        double y = top + cellSize *0.6;
        UI.drawString(""+line[row],x,y);
    }
    
    private Color getColor(int numItems, int value){
        return new Color(value*255/numItems);
    }
    
    public static void main(String[] arguments){
        new BasicArrays();
    }
    
    public void populateBox(){
        int rows = UI.askInt("row of array");
        int cols = UI.askInt("col of array");
        if(rows < 0||cols < 0){
            UI.print("the size must be positive");
            return;
        }
        box = new int[rows][cols];
        for(int row = 0;row < box.length;row++){
            for(int col = 0;col < box[0].length;col++){
                box[row][col]= row * box[0].length + col + 1;
            }
        }
    }
    
    private void drawBox(){
        if(box == null)return;
        for(int row = 0;row <box.length;row++){
            for(int col = 0;col<box[0].length;col++){
                drawBoxCell(row,col);
            }
        }
    }
    
    private void drawBoxCell(int row,int col){
        double left = gridLeft +col*cellSize;
        double top = gridTop + row*cellSize;
        UI.setColor(getColor(box.length*box[0].length,box[row][col]));
        UI.fillRect(left,top,cellSize,cellSize);
        
        UI.setColor(Color.white);
        double x = left + cellSize *0.35;
        double y = top + cellSize *0.6;
        UI.drawString(""+box[row][col],x,y);
    }
    
    public void populateSpiral(){
        int rows = UI.askInt("row of array");
        int cols = UI.askInt("col of array");
        if(rows < 0||cols < 0){
            UI.print("the size must be positive");
            return;
        }
        box = new int[rows][cols];
        int target = rows * cols;
        int start = 1;
        
        int minRow = 0;
        int maxRow = rows-1;
        int minCol = 0;
        int maxCol = cols-1;
        while(start <= target){
            for(int col = minCol;start <= target && col <= maxCol; col++){
                box[minRow][col] = start++;
            }
                minRow++;
            for(int row = minRow;start <= target && row <= maxRow; row++){
                box[row][maxCol] = start++;
            }
                maxCol--;
            for(int col = maxCol;start <= target && col >= minCol; col--){
                box[maxRow][col] = start++;
            }
                maxRow--;
            for(int row = maxRow;start <= target && row >= minRow; row--){
                box[row][minCol] = start++;
            }
                minCol++;
        }
        
    }
}
