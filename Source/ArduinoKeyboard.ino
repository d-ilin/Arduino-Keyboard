

int incomingByte;      // a variable to read incoming serial data into
int frequency;

void setup() {
  // initialize serial communication:
  Serial.begin(9600);
}

void loop() {
  // see if there's incoming serial data:
  if (Serial.available() > 0) {
    // read the oldest byte in the serial buffer:
    incomingByte = Serial.read();

    // If a zero is received, do not play a tone:
    if(incomingByte == 0) {
      noTone(8);
    }
    else {
      frequency = convert(incomingByte);
      tone(13, frequency);
    }
  }
}

int convert(int input) {
  switch (input) {
    case 1  :  // C1
      return 33;
    case 2  :  // C#1
      return 35;
    case 3  :  // D1
      return 37;
    case 4  :  // D#1
      return 39;
    case 5  :  // E1
      return 41;
    case 6  :  // F1
      return 44;
    case 7  :  // F#1
      return 46;
    case 8  :  // G1
      return 49;
    case 9  :  // G#1
      return 52;
    case 10 :  // A1
      return 55;
    case 11 :  // A#1
      return 58;
    case 12 :  // B1
      return 62;
    case 13 :  // C2
      return 65;
    case 14 :  // C#2
      return 69;
    case 15 :  // D2
      return 73;
    case 16 :  // D#2
      return 78;
    case 17 :  // E2
      return 82;
    case 18 :  // F2
      return 87;
    case 19 :  // F#2
      return 93;
    case 20 :  // G2
      return 98;
    case 21 :  // G#2
      return 104;
    case 22 :  // A2
      return 110;
    case 23 :  // A#2
      return 117;
    case 24 :  // B2
      return 123;
    case 25 :  // C3
      return 131;
    case 26 :  // C#3
      return 139;
    case 27 :  // D3
      return 147;
    case 28 :  // D#3
      return 156;
    case 29 :  // E3
      return 165;
    case 30 :  // F3
      return 175;
    case 31 :  // F#3
      return 185;
    case 32 :  // G3
      return 196;
    case 33 :  // G#3
      return 208;
    case 34 :  // A3
      return 220;
    case 35 :  // A#3
      return 233;
    case 36 :  // B3
      return 247;
    case 37 :  // C4
      return 262;
    case 38 :  // C#4
      return 277;
    case 39 :  // D4
      return 294;
    case 40 :  // D#4
      return 311;
    case 41 :  // E4
      return 330;
    case 42 :  // F4
      return 349;
    case 43 :  // F#4
      return 370;
    case 44 :  // G4
      return 392;
    case 45 :  // G#4
      return 415;
    case 46 :  // A4
      return 440;
    case 47 :  // A#4
      return 466;
    case 48 :  // B4
      return 494;
    case 49 :  // C5
      return 523;
    case 50 :  // C#5
      return 554;
    case 51 :  // D5
      return 587;
    case 52 :  // D#5
      return 622;
    case 53 :  // E5
      return 659;
    case 54 :  // F5
      return 698;
    case 55 :  // F#5
      return 740;
    case 56 :  // G5
      return 784;
    case 57 :  // G#5
      return 831;
    case 58 :  // A5
      return 880;
    case 59 :  // A#5
      return 932;
    case 60 :  // B5
      return 988;
    case 61 :  // C6
      return 1047;
    case 62 :  // C#6
      return 1109;
    case 63 :  // D6
      return 1175;
    case 64 :  // D#6
      return 1245;
    case 65 :  // E6
      return 1319;
    case 66 :  // F6
      return 1397;
    case 67 :  // F#6
      return 1480;
    case 68 :  // G6
      return 1568;
    case 69 :  // G#6
      return 1661;
    case 70 :  // A6
      return 1760;
    case 71 :  // A#6
      return 1865;
    case 72 :  // B6
      return 1976;
    case 73 :  // C7
      return 2093;
    case 74 :  // C#7
      return 2217;
    case 75 :  // D7
      return 2349;
    case 76 :  // D#7
      return 2489;
    case 77 :  // E7
      return 2637;
    case 78 :  // F7
      return 2794;
    case 79 :  // F#7
      return 2960;
    case 80 :  // G7
      return 3136;
    case 81 :  // G#7
      return 3322;
    case 82 :  // A7
      return 3520;
    case 83 :  // A#7
      return 3729;
    case 84 :  // B7
      return 3951;
    case 85 :  // C8
      return 4186;
  }
}
