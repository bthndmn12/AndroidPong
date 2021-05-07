
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
  void sNeffect() {
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
  color noisyColor() {
    rand = int(random(255));
    randCol = color(rand);
    return randCol;
  }
}
