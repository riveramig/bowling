import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int FRAMES=10;
    private static String game="";

    public static void main(String[] args) throws IOException {
        System.out.println("Ingrese la serie de bowling a validar!");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        game = reader.readLine();
        game=game.trim();

        float frameCounter=0;
        int result=0;
        for (int i = 0; i < game.length(); i++) {
            char currentRoll=game.charAt(i);
            if(frameCounter==10){
                break;
            }else{
                switch (currentRoll){
                    case 'X':
                        frameCounter+=1;
                        result+=10+(evalueSym(game.charAt(i+1),i+1)+evalueSym(game.charAt(i+2),i+2));
                        break;
                    case'/':
                        frameCounter+=0.5;
                        result+=evalueSym(game.charAt(i),i)+evalueSym(game.charAt(i+1),i+1);
                        break;
                    case'-':
                        frameCounter+=0.5;
                        result+=evalueSym(game.charAt(i),i);
                        break;
                    default:
                        frameCounter+=0.5;
                        result+=Character.getNumericValue(game.charAt(i));
                        break;
                }
            }
        }
        System.out.println("Bowling result "+result);
    }

    private static int evalueSym(char sym, int pos){
        switch (sym){
            case 'X':
                return 10;
            case'/':
                return (10-Character.getNumericValue(game.charAt(pos-1)));
            case'-':
                return 0;
            default:
                return Character.getNumericValue(sym);
        }
    }

}
