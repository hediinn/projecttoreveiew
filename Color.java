public class Color {
    
    public int R;
    public int G;
    public int B;



    public Color(int red, int green, int blue) {

            this.R = red;
            this.G = green;
            this.B = blue;


    }


    public static String ColorCode(Color BG, Color FG) {
        /*
          ANSI escape sequence for background and foreground
          color is captured by the code:
          \033[48;2;<BR>;<BG>;<BB>;38;2;<FR>;<FG>;<FB>m
        */
        return String.format("\033[48;2;%d;%d;%d;38;2;%d;%d;%dm",
        BG.R, BG.G, BG.B, FG.R, FG.G, FG.B);
    }
    
}