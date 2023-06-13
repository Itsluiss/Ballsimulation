import GLOOP.*;
public class Ballsimulation{
    private GLKamera kamera;
    GLLicht licht;
    GLHimmel himmel;
    GLBoden boden;
    private GLTastatur tastatur;

    private Ball ball;
    private Farbball ball2;
    private GravBall ball3;
    private Speedball ball4;
    private Riesen ball5;
    private Hindernis[] hindernis;

    public Ballsimulation(){
        kamera = new GLSchwenkkamera(800,500);
        kamera.setzePosition(0,500,2000);
        licht  = new GLLicht();       
        boden  = new GLBoden("src/Boden.jpg");
        himmel = new GLHimmel("src/Himmel.jpg");
        tastatur = new GLTastatur();

        hindernis = new Hindernis[2];
        hindernis[0] = new Hindernis(1000,200,0, 50,5000,1300);
        hindernis[1] = new Hindernis(-1000,200,0, 50,5000,1300);


        ball = new Ball (0,200,-200, 20);
        ball.werfen(new GLVektor(1,0,0));
        ball2 = new Farbball (0,200,-100, 20);
        ball2.werfen(new GLVektor(1,0,0));
        ball3 = new GravBall (0,2000,0, 20);
        ball3.werfen(new GLVektor(1,-0.1,0));
        ball4 = new Speedball (0,200,100, 20);
        ball4.werfen(new GLVektor(2,0,0));
        ball5 = new Riesen(0,200,200, 20);
        ball5.werfen(new GLVektor(1,0,0));
        fuehreAus();
    }

    public void fuehreAus(){
        while (!tastatur.esc()) {

            ball.bewegeDich();
            ball2.bewegeDich();
            ball3.bewegeDich();
            ball4.bewegeDich();
            ball5.bewegeDich();

            int j;
            for (j = 0; j < 2; j++) {
                ball.bearbeiteHindernis(hindernis[j]);
            ball2.bearbeiteHindernis(hindernis[j]);
            ball3.bearbeiteHindernis(hindernis[j]);
            ball4.bearbeiteHindernis(hindernis[j]);
            ball5.bearbeiteHindernis(hindernis[j]);
        }
            Sys.warte();
        }
        Sys.beenden();
    }
    
}
