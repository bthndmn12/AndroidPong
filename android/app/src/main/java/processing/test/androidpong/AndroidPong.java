package processing.test.androidpong;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class AndroidPong extends PApplet {

//Mehmet Batuhan Duman






float xpos;
float ypos;                

int xPos;
int yPos;

int speed = 10;
int vx = speed;
int vy = speed;

int countP1 = 0;
int countP2 = 0;

boolean effect = false;
boolean start = true;
boolean textStart = false;
Pulse pulse;
Pulse music;
LineEffect lest;
screenNoise sNoise;
int randCol;
int rand;

public void setup() {

  
  frameRate(60);
  noStroke();      
  orientation(LANDSCAPE);  

  xPos = width/2;
  yPos = height/2;

  lest = new LineEffect(height, width, 10);
  sNoise = new screenNoise(height, width);

  pulse = new Pulse(this);
  pulse.amp(0.01f);
  pulse.play();

  blendMode(EXCLUSION);
}

public void draw() {
  background(0);

  println(frameRate); 

  if (effect == true) {
    sNoise.sNeffect();
    lest.lines();
  }

  if (start == loopGame()) {
    textSize(100);
    text(countP1/12, 100, 100);
    text(countP2/12, 1700, 100);
    rect(1820, mouseY, 30, 200, 10);
    rect(100, mouseY, 30, 200, 10);
    circle(xPos, yPos, 20);
    stroke(255);
    line(width/2, 0, width/2, height);
  }

  xpos = mouseY;
  ypos = mouseY;
  xPos+=vx;
  yPos+=vy;

  //  if((xPos <= width+speed && xPos >= width)||(xPos <= speed && xPos >= 0)){
  //   vx= -vx;
  //   pulse.stop();
  //}
  if ((yPos <= height+speed/2 && yPos >= height) || (yPos <=speed && yPos >= 0)) {
    vy= -vy;
    pulse.stop();
  }
  if (((xPos <= 130) && (xPos >=99)) && ((yPos <= ypos+200) && ((yPos >=ypos)))) {
    vx= -vx;
    pulse.play();
  }
  if (((xPos <= 1850) && (xPos >=1820)) && ((yPos <= xpos+200) && ((yPos >=xpos)))) {
    vx= -vx;
    pulse.play();
  }
  if ((xPos >= 1830)) {
    countP1++;
  }
  if ((xPos >= 0)&&(xPos<=130)) {
    countP2++;
  }
  if ((xPos > 150)&&(xPos<1800)) {
    pulse.stop();
  }
  if ((xPos <= 20)&&(xPos>=0)||(xPos >= 1900)&&(xPos<=1920)) {
    xPos = width/2;
    yPos = height/2;
  }
  if (countP1/12 == 10 && countP2/12<10) {
    start = false;
    text("P1 WINS", 100, 100);
  }
  if (countP2/12 == 10 && countP1/12<10) {
    start = false;
    text("P2 WINS", 100, 100);
  }
  println(mouseX+" "+mouseY);
}
public boolean loopGame() {
  if (start == false) {
    countP1 = 0;
    countP2 = 0;
    start = true;
  }
  return start;
}
class LineEffect {
  int heightS;
  int widthS;
  int speedS;
  int y, yV;
  LineEffect(int h, int w, int speed) {
    heightS = h;
    widthS = w;
    speedS = speed;
  }
  public void lines() {
    yV-=speedS;
    stroke(255);
    line(0, yV, widthS, yV);
    if (yV < 0) { 
      yV = heightS;
    }
  }
}

class screenNoise {

  int heightS;
  int widthS;
  //int x;
  //int y;
  //int cols;
  //int rows;
  //float dampening = 0.99;

  //float[][] current;
  //float[][] previous;
  screenNoise(int h, int w ) {
    heightS = h;
    widthS = w;

    //cols = h;
    //rows = w;
    // current = new float[cols][rows];
    //previous = new float[cols][rows];
  }
  public void sNeffect() {
    //pushMatrix();
    //  cols = width;
    //rows = height;

    //previous[x][y] = 100; 

    loadPixels();
    for (int i=0; i < widthS*heightS; i+=500) {
      if (i>=widthS*heightS) {
        i = 0;
      }
      pixels[i] = noisyColor();
    }
    //   for (int i = 1; i < cols-1; i++) {
    //  for (int j = 1; j < rows-1; j++) {
    //    current[i][j] = (
    //      previous[i-1][j] + 
    //      previous[i+1][j] +
    //      previous[i][j-1] + 
    //      previous[i][j+1]) / 2 -
    //      current[i][j];
    //    current[i][j] = current[i][j] * dampening;
    //    int index = i + j * cols;
    //    pixels[index] = color(current[i][j]);
    //  }
    //}
    updatePixels();
    //float[][] temp = previous;
    //previous = current;
    //current = temp;
    //   popMatrix();
  }
  public int noisyColor() {
    rand = PApplet.parseInt(random(255));
    randCol = color(rand);
    return randCol;
  }
}
  public void settings() {  fullScreen(); }
}
