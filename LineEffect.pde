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
  void lines() {
    yV-=speedS;
    stroke(255);
    line(0, yV, widthS, yV);
    if (yV < 0) { 
      yV = heightS;
    }
  }
}
