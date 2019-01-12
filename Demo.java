
//API : http://mabe02.github.io/lanterna/apidocs/2.1/
import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;
import java.util.ArrayList;

public class Demo{
  static ArrayList<Wall> grid = new ArrayList<Wall>();
  static ArrayList<Greebler> greeblers = new ArrayList<Greebler>();
  static ArrayList<Baby> babies = new ArrayList<Baby>();
  static Player one = new Player(1000, 10, 10, 10, "wallie", '\u00a6', 4);

  //perimeter
  static Wall side0 = new Wall(0,0, "");
  static Wall side1 = new Wall(1,0, "");
  static Wall side2 = new Wall(2,0, "");
  static Wall side3 = new Wall(3,0, "");
  static Wall side4 = new Wall(4,0, "");
  static Wall side5 = new Wall(5,0, "");
  static Wall side6 = new Wall(6,0, "");
  static Wall side7 = new Wall(7,0, "");
  static Wall side8 = new Wall(8,0, "");
  static Wall side9 = new Wall(9,0, "");
  static Wall side10 = new Wall(10,0, "");
  static Wall side11 = new Wall(11,0, "");
  static Wall side12 = new Wall(12,0, "");
  static Wall side13 = new Wall(13,0, "");
  static Wall side14 = new Wall(14,0, "");
  static Wall side15 = new Wall(15,0, "");
  static Greebler greeb1 = new Greebler(20, 15);
  static Greebler greeb2 = new Greebler(30,20);
  static Baby baby1 = new Baby(40, 10);

  public static void fillScreen(Terminal t, ArrayList<Wall> perimeter ){
    grid.add(side0);
    grid.add(side1);
    grid.add(side2);
    grid.add(side3);
    grid.add(side4);
    grid.add(side5);
    grid.add(side6);
    grid.add(side7);
    grid.add(side8);
    grid.add(side9);
    grid.add(side10);
    grid.add(side11);
    grid.add(side12);
    grid.add(side13);
    grid.add(side14);
    grid.add(side15);
    greeblers.add(greeb1);
    greeblers.add(greeb2);
    babies.add(baby1);
    for(int i = 0; i < grid.size(); i++){
      t.moveCursor(grid.get(i).getwallX(), grid.get(i).getwallY());
      t.putCharacter(grid.get(i).getBarrier());
    }
    for(int j = 0; j < greeblers.size(); j++){
      t.moveCursor(greeblers.get(j).getX(), greeblers.get(j).getY());
      t.putCharacter(greeblers.get(j).getGraphic());
    }
    for(int k = 0; k < babies.size(); k++){
      t.moveCursor(babies.get(k).getX(), babies.get(k).getY());
      t.putCharacter(babies.get(k).getGraphic());
    }
  }

  public static void putString(int r, int c,Terminal t, String s){
		t.moveCursor(r,c);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i));
		}
	}
  //checks position in front of creature for a
  //creature, wall, or baby and returns a String with the
  //type of thing in front of it
  //commented out and moved to creature class
  public static String checkInFront(Creature n){
    for (int i = 0; i < grid.size(); i++){
      //Checks which direction the greebler is looking and then if there is a wall in fron of the creature
      if (n.getDirection().equals("up")){
        if (grid.get(i).getwallX() == n.getX() && grid.get(i).getwallY() == n.getY() + 1){
          return "wall";
        }
      }
      if (n.getDirection().equals("down")){
        if (grid.get(i).getwallX() == n.getX() && grid.get(i).getwallY() == n.getY() - 1){
          return "wall";
        }
      }
      if (n.getDirection().equals("right")){
        if (grid.get(i).getwallX() == n.getX() + 1 && grid.get(i).getwallY() == n.getY()){
          return "wall";
        }
      }
      if (n.getDirection().equals("left")){
        if (grid.get(i).getwallX() == n.getX() - 1 && grid.get(i).getwallY() == n.getY()){
          return "wall";
        }
      }
    }

    //Checks if there is a greebler in the direction of the creature
    for (int i = 0; i < greeblers.size(); i++){
      if (n.getDirection().equals("up")){
        if (greeblers.get(i).getX() == n.getX() && greeblers.get(i).getY() == n.getY() + 1){
          return "greebler";
        }
      }
      if (n.getDirection().equals("down")){
        if (greeblers.get(i).getX() == n.getX() && greeblers.get(i).getY() == n.getY() - 1){
          return "greebler";
        }
      }
      if (n.getDirection().equals("right")){
        if (greeblers.get(i).getX() == n.getX() + 1 && greeblers.get(i).getY() == n.getY()){
          return "greebler";
        }
      }
      if (n.getDirection().equals("left")){
        if (greeblers.get(i).getX() == n.getX() - 1 && greeblers.get(i).getY() == n.getY()){
          return "greebler";
        }
      }
    }

    //checks if there is a baby in front of anything
    for (int i = 0; i < babies.size(); i++){
      if (n.getDirection().equals("up")){
        if (babies.get(i).getX() == n.getX() && babies.get(i).getY() == n.getY() + 1){
          return "baby";
        }
      }
      if (n.getDirection().equals("down")){
        if (babies.get(i).getX() == n.getX() && babies.get(i).getY() == n.getY() - 1){
          return "baby";
        }
      }
      if (n.getDirection().equals("right")){
        if (babies.get(i).getX() == n.getX() + 1 && babies.get(i).getY() == n.getY()){
          return "baby";
        }
      }
      if (n.getDirection().equals("left")){
        if (babies.get(i).getX() == n.getX() - 1 && babies.get(i).getY() == n.getY()){
          return "baby";
        }
      }
    }

    //checks for player in front of creature
    if (n.getDirection().equals("up")){
      if (one.getX() == n.getX() && one.getY() == n.getY() + 1){
        return "baby";
      }
    }
    if (n.getDirection().equals("down")){
      if (one.getX() == n.getX() && one.getY() == n.getY() - 1){
        return "baby";
      }
    }
    if (n.getDirection().equals("right")){
      if (one.getX() == n.getX() + 1 && one.getY() == n.getY()){
        return "baby";
      }
    }
    if (n.getDirection().equals("left")){
      if (one.getX() == n.getX() - 1 && one.getY() == n.getY()){
        return "baby";
      }
    }

    return "";
  }






  public static void main(String[] args){
    Terminal terminal = TerminalFacade.createTextTerminal();
    terminal.enterPrivateMode();
    TerminalSize size = terminal.getTerminalSize();
    size.setRows(50);
    size.setColumns(50);
    terminal.setCursorVisible(false);
    boolean running = true;

    int x = 10;
    int y = 10;

    while(running){

			terminal.moveCursor(x,y);
			terminal.applyBackgroundColor(Terminal.Color.WHITE);
			terminal.applyForegroundColor(Terminal.Color.BLACK);
			//applySGR(a,b) for multiple modifiers (bold,blink) etc.
			terminal.applySGR(Terminal.SGR.ENTER_UNDERLINE);
			terminal.putCharacter('\u00a4');
			//terminal.putCharacter(' ');
			terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			terminal.applyForegroundColor(Terminal.Color.DEFAULT);
			terminal.applySGR(Terminal.SGR.RESET_ALL);


			terminal.moveCursor(size.getColumns()-5,5);
			terminal.applyBackgroundColor(Terminal.Color.RED);
			terminal.applyForegroundColor(Terminal.Color.YELLOW);
			terminal.applySGR(Terminal.SGR.ENTER_BOLD);
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter('\u262d');
			terminal.putCharacter(' ');
			terminal.moveCursor(size.getColumns()-5,6);
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.applyForegroundColor(Terminal.Color.DEFAULT);

      fillScreen(terminal, grid);

			Key key = terminal.readInput();

			if (key != null)
			{

				if (key.getKind() == Key.Kind.Escape) {

					terminal.exitPrivateMode();
					running = false;
					System.out.println(one.getX());
					System.out.println(one.getY());
				}

				if (key.getKind() == Key.Kind.ArrowLeft) {
					terminal.moveCursor(one.getX(),one.getY());
					terminal.putCharacter(' ');
          one.setDirection("left");
          if (checkInFront(one).equals("")){
				        one.moveLeft();
            }
				}

				if (key.getKind() == Key.Kind.ArrowRight) {
					terminal.moveCursor(one.getX(),one.getY());
					terminal.putCharacter(' ');
          one.setDirection("right");
          if (checkInFront(one).equals("")){
					   one.moveRight();
          }
				}

				if (key.getKind() == Key.Kind.ArrowUp) {
					terminal.moveCursor(one.getX(),one.getY());
					terminal.putCharacter(' ');
          one.setDirection("up");
          if (checkInFront(one).equals("")){
					   one.moveUp();
          }
				}

				if (key.getKind() == Key.Kind.ArrowDown) {
					terminal.moveCursor(one.getX(),one.getY());
					terminal.putCharacter(' ');
          one.setDirection("down");
					if (checkInFront(one).equals("")){
					  one.moveDown();
          }
				}
				//space moves it diagonally
				if (key.getCharacter() == ' ') {
					terminal.moveCursor(one.getX(),one.getY());

				}
      }
    }
  }
}
