import processing.core.*; 
import processing.xml.*; 

import processing.serial.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class ArduinoKeyboard extends PApplet {

// Keyboard interface for Arduino

 

Serial port;

int currentNote = 0;
int newNote;

int octave = 0;

int keyPress = 0;


int keyColor[]  = {
  255, 0, 255, 0, 255, 255, 0, 255, 0, 255, 0, 255, 255
};

public void setup() {
  // Create window
  size(440, 450);

  // List all the available serial ports in the output pane.
  // You will need to choose the port that the Arduino board is
  // connected to from this list. The first port in the list is
  // port #0 and the third port in the list is port #2.
  println(Serial.list()); 

  // Open the port that the Arduino board is connected to (in this case #0)
  // Make sure to open the port at the same speed Arduino is using (9600bps)
  port = new Serial(this, Serial.list()[0], 9600);
}

public void draw() {

  // Note output to Arduino via serial
  if (currentNote != newNote) {
    currentNote = newNote;
    println(currentNote);
    port.write(currentNote);
  }

  // Draw octave indicators
  noStroke();
  fill(0xff888888);
  rect(45, 140, 50, 50);
  fill(0xff999999);
  rect(95, 140, 50, 50);
  fill(0xffAAAAAA);
  rect(145, 140, 50, 50);
  fill(0xffBBBBBB);
  rect(195, 140, 50, 50);
  fill(0xffCCCCCC);
  rect(245, 140, 50, 50);
  fill(0xffDDDDDD);
  rect(295, 140, 50, 50);
  fill(0xffEEEEEE);
  rect(345, 140, 50, 50);

  noFill();
  stroke(0);
  rect(45, 140, 350, 50);

  noStroke();
  fill(0xffFF6600);
  if (octave == 0) { 
    rect(46, 141, 49, 49);
  }
  else if (octave == 1) {
    rect(95, 141, 50, 49);
  }
  else if (octave == 2) {
    rect(145, 141, 50, 49);
  }
  else if (octave == 3) {
    rect(195, 141, 50, 49);
  }
  else if (octave == 4) {
    rect(245, 141, 50, 49);
  }
  else if (octave == 5) {
    rect(295, 141, 50, 49);
  }
  else if (octave == 6) {
    rect(345, 141, 50, 49);
  }

  stroke(0);

  // Draw white keys
  fill(keyColor[0]);
  rect(20, 200, 50, 150);      // C  key
  fill(keyColor[2]);
  rect(70, 200, 50, 150);      // D  key
  fill(keyColor[4]);
  rect(120, 200, 50, 150);     // E  key
  fill(keyColor[5]);
  rect(170, 200, 50, 150);     // F  key
  fill(keyColor[7]);
  rect(220, 200, 50, 150);     // G  key
  fill(keyColor[9]);
  rect(270, 200, 50, 150);     // A  key
  fill(keyColor[11]);
  rect(320, 200, 50, 150);     // B  key
  fill(keyColor[12]);
  rect(370, 200, 50, 150);     // C  key (next octave up)

  // Draw black keys
  fill(keyColor[1]);
  rect(55, 200, 30, 90);      // C# key
  fill(keyColor[3]);
  rect(105, 200, 30, 90);     // D# key
  fill(keyColor[6]);
  rect(205, 200, 30, 90);     // F# key
  fill(keyColor[8]);
  rect(255, 200, 30, 90);     // G# key
  fill(keyColor[10]);
  rect(305, 200, 30, 90);     // A# key

  fill(0);
  // Octave button text
  text("1", 65, 170);
  text("2", 115, 170);
  text("3", 165, 170);
  text("4", 215, 170);
  text("5", 265, 170);
  text("6", 315, 170);
  text("7", 365, 170);
  // White key note text
  text("C", 40, 340);
  text("D", 90, 340);
  text("E", 140, 340);
  text("F", 190, 340);
  text("G", 240, 340);
  text("A", 290, 340);
  text("B", 340, 340);
  text("C", 390, 340);
  // Black key note text
  fill(255);
  text("C#", 60, 275);
  text("D#", 110, 275);
  text("F#", 210, 275);
  text("G#", 260, 275);
  text("A#", 310, 275);
}

public void keyPressed() {
  if (key == 'a') {      // C
    keyColor[0]  = 150;
    newNote = 1 + (octave * 12);
    keyPress = 1;
  }
  else if (key == 'w') {  // C#
    keyColor[1]  = 150;
    newNote = 2 + (octave * 12);
    keyPress = 2;
  }
  else if (key == 's') {  // D
    keyColor[2]  = 150;
    newNote = 3 + (octave * 12);
    keyPress = 3;
  }
  else if (key == 'e') {  // D#
    keyColor[3]  = 150;
    newNote = 4 + (octave * 12);
    keyPress = 4;
  }
  else if (key == 'd') {  // E
    keyColor[4]  = 150;
    newNote = 5 + (octave * 12);
    keyPress = 5;
  }
  else if (key == 'f') {  // F
    keyColor[5]  = 150;
    newNote = 6 + (octave * 12);
    keyPress = 6;
  }
  else if (key == 't') {  // F#
    keyColor[6]  = 150;
    newNote = 7 + (octave * 12);
    keyPress = 7;
  }
  else if (key == 'g') {  // G
    keyColor[7]  = 150;
    newNote = 8 + (octave * 12);
    keyPress = 8;
  }
  else if (key =='y') {  // G#
    keyColor[8]  = 150;
    newNote = 9 + (octave * 12);
    keyPress = 9;
  }
  else if (key =='h') {  // A
    keyColor[9]  = 150;
    newNote = 10 + (octave * 12);
    keyPress = 10;
  }
  else if (key == 'u') {  // A#
    keyColor[10]  = 150;
    newNote = 11 + (octave * 12);
    keyPress = 11;
  }
  else if (key == 'j') {  // B
    keyColor[11]  = 150;
    newNote = 12 + (octave * 12);
    keyPress = 12;
  }
  else if (key == 'k') {  // C
    keyColor[12]  = 150;
    newNote = 1 + ((octave + 1) * 12);
    keyPress = 13;
  }
  else if (key == 'z') {  // Octave down
    if (octave == 0) octave = 6;
    else octave--;
  }
  else if (key == 'x') {  // Octave up
    if (octave == 6) octave = 0;
    else octave++;
  }
}

public void keyReleased() {
  if (key == 'a') {      // C
    keyColor[0]  = 255;
    if (keyPress == 1) newNote = 0;
  }
  else if (key == 'w') {  // C#
    keyColor[1]  = 0;
    if (keyPress == 2) newNote = 0;
  }
  else if (key == 's') {  // D
    keyColor[2]  = 255;
    if (keyPress == 3) newNote = 0;
  }
  else if (key == 'e') {  // D#
    keyColor[3]  = 0;
    if (keyPress == 4) newNote = 0;
  }
  else if (key == 'd') {  // E
    keyColor[4]  = 255;
    if (keyPress == 5) newNote = 0;
  }
  else if (key == 'f') {  // F
    keyColor[5]  = 255;
    if (keyPress == 6) newNote = 0;
  }
  else if (key == 't') {  // F#
    keyColor[6]  = 0;
    if (keyPress == 7) newNote = 0;
  }
  else if (key == 'g') {  // G
    keyColor[7]  = 255;
    if (keyPress == 8) newNote = 0;
  }
  else if (key =='y') {  // G#
    keyColor[8]  = 0;
    if (keyPress == 9) newNote = 0;
  }
  else if (key =='h') {  // A
    keyColor[9]  = 255;
    if (keyPress == 10) newNote = 0;
  }
  else if (key == 'u') {  // A#
    keyColor[10]  = 0;
    if (keyPress == 11) newNote = 0;
  }
  else if (key == 'j') {  // B
    keyColor[11]  = 255;
    if (keyPress == 12) newNote = 0;
  }
  else if (key == 'k') {  // C
    keyColor[12]  = 255;
    if (keyPress == 13) newNote = 0;
  }
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "ArduinoKeyboard" });
  }
}
