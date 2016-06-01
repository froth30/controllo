package controllo;

// TODO

import processing.core.PApplet;

/**
 * Constant variables used with Controllo are stored here.
 */
public interface ControlloConstants {

    public final static String eventMethod = "controlEvent";
    public final static boolean VERBOSE = false;
    public final static float PI = (float) Math.PI;
    public final static float TWO_PI = PI * 2;
    public final static float HALF_PI = PI / 2;
    public final static int INVALID = -1;
    public final static int METHOD = 0;
    public final static int FIELD = 1;
    public final static int EVENT = 2;
    public final static int INTEGER = 1;
    public final static int FLOAT = 2;
    public final static int BOOLEAN = 3;
    public final static int STRING = 4;
    public final static int ARRAY = 5;
    public final static int BITFONT = 100;
    public final static Class<?>[] acceptClassList = {int.class, float.class, boolean.class, String.class};
    public final static Class<?> controlEventClass = ControlEvent.class;
    public final static int UP = PApplet.UP;
    public final static int DOWN = PApplet.DOWN;
    public final static int LEFT = PApplet.LEFT;
    public final static int RIGHT = PApplet.RIGHT;
    public final static int SHIFT = PApplet.SHIFT;
    public final static int DELETE = PApplet.DELETE;
    public final static int BACKSPACE = PApplet.BACKSPACE;
    public final static int ENTER = PApplet.ENTER;
    public final static int ESCAPE = PApplet.ESC;
    public final static int ALT = PApplet.ALT;
    public final static int CONTROL = PApplet.CONTROL;
    public final static int COMMANDKEY = 157;
    public final static int TAB = PApplet.TAB;
    public final static char INCREASE = PApplet.UP;
    public final static char DECREASE = PApplet.DOWN;
    public final static char SWITCH_FORE = PApplet.LEFT;
    public final static char SWITCH_BACK = PApplet.RIGHT;
    public final static char SAVE = 'S';
    public final static char RESET = 'R';
    public final static char PRINT = ' ';
    public final static char HIDE = 'H';
    public final static char LOAD = 'L';
    public final static char MENU = 'M';
    public final static char KEYCONTROL = 'K';
    public final static int TOP = 101;
    public final static int BOTTOM = 102;
    public final static int CENTER = 3;
    public final static int BASELINE = 0;
    public final static int HORIZONTAL = 0;
    public final static int VERTICAL = 1;
    public final static int DEFAULT = 0;
    public final static int OVER = 1;
    public final static int ACTIVE = 2;
    public final static int HIGHLIGHT = 3;
    public final static int IMAGE = 1;
    public final static int SPRITE = 2;
    public final static int CUSTOM = 3;
    public final static int SWITCH = 100;
    public final static int MOVE = 0;
    public final static int RELEASE = 2;
    public final static int RELEASED = 2;
    public final static int PRESSED = 1;
    public final static int PRESS = 1;
    public final static int LINE = 1;
    public final static int ELLIPSE = 2;
    public final static int ARC = 3;
    public final static int INACTIVE = 0;
    public final static int WAIT = 1;
    public final static int TRANSITION_WAIT_FADEIN = 2;
    public final static int FADEIN = 3;
    public final static int IDLE = 4;
    public final static int FADEOUT = 5;
    public final static int DONE = 6;
    public final static int SINGLE_COLUMN = 0;
    public final static int SINGLE_ROW = 1;
    public final static int MULTIPLES = 2;
    public final static int LIST = 0;
    public final static int DROPDOWN = 1;
    public final static int CHECKBOX = 2;  // TODO
    public final static int TREE = 3;  // TODO

    @Deprecated public final static int ACTION_PRESSED = 1;
    public final static int ACTION_PRESS = 1;

    @Deprecated public final static int ACTION_RELEASED = 2;
    public final static int ACTION_RELEASE = 2;

    public final static int ACTION_CLICK = 3;
    public final static int ACTION_DRAG = 4;
    public final static int ACTION_MOVE = 5;
    public final static int ACTION_ENTER = 6;
    public final static int ACTION_LEAVE = 7;
    public final static int ACTION_EXIT = 7;
    public final static int ACTION_WHEEL = 8;
    @Deprecated public final static int ACTION_RELEASEDOUTSIDE = 9;
    public final static int ACTION_RELEASE_OUTSIDE = 9;
    public final static int ACTION_START_DRAG = 10;
    public final static int ACTION_END_DRAG 11;
    public final static int ACTION_DOUBLE_PRESS = 12;
    public final static int ACTION_BROADCAST = 100;
    public final static int LEFT_OUTSIDE = 10;
    public final static int RIGHT_OUTSIDE = 11;
    public final static int TOP_OUTSIDE = 12;
    public final static int BOTTOM_OUTSIDE = 13;
    public final static int CAPTIONLABEL = 0;
    public final static int VALUELABEL = 1;
    public final static int SINGLE = 0;

    // TODO

}
