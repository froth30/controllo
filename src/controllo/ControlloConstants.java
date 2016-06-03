package controllo;

// TODO

import processing.core.PApplet;

/**
 * Constant variables used with Controllo are stored here.
 */
public interface ControlloConstants {

    public static final String eventMethod = "controlEvent";
    public static final boolean VERBOSE = false;
    public static final float PI = (float) Math.PI;
    public static final float TWO_PI = PI * 2;
    public static final float HALF_PI = PI / 2;
    public static final int INVALID = -1;
    public static final int METHOD = 0;
    public static final int FIELD = 1;
    public static final int EVENT = 2;
    public static final int INTEGER = 1;
    public static final int FLOAT = 2;
    public static final int BOOLEAN = 3;
    public static final int STRING = 4;
    public static final int ARRAY = 5;
    public static final int BITFONT = 100;
    public static final Class<?>[] acceptClassList = {int.class, float.class, boolean.class, String.class};
    public static final Class<?> controlEventClass = ControlEvent.class;
    public static final int UP = PApplet.UP;
    public static final int DOWN = PApplet.DOWN;
    public static final int LEFT = PApplet.LEFT;
    public static final int RIGHT = PApplet.RIGHT;
    public static final int SHIFT = PApplet.SHIFT;
    public static final int DELETE = PApplet.DELETE;
    public static final int BACKSPACE = PApplet.BACKSPACE;
    public static final int ENTER = PApplet.ENTER;
    public static final int ESCAPE = PApplet.ESC;
    public static final int ALT = PApplet.ALT;
    public static final int CONTROL = PApplet.CONTROL;
    public static final int COMMANDKEY = 157;
    public static final int TAB = PApplet.TAB;
    public static final char INCREASE = PApplet.UP;
    public static final char DECREASE = PApplet.DOWN;
    public static final char SWITCH_FORE = PApplet.LEFT;
    public static final char SWITCH_BACK = PApplet.RIGHT;
    public static final char SAVE = 'S';
    public static final char RESET = 'R';
    public static final char PRINT = ' ';
    public static final char HIDE = 'H';
    public static final char LOAD = 'L';
    public static final char MENU = 'M';
    public static final char KEYCONTROL = 'K';
    public static final int TOP = 101;
    public static final int BOTTOM = 102;
    public static final int CENTER = 3;
    public static final int BASELINE = 0;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public static final int DEFAULT = 0;
    public static final int OVER = 1;
    public static final int ACTIVE = 2;
    public static final int HIGHLIGHT = 3;
    public static final int IMAGE = 1;
    public static final int SPRITE = 2;
    public static final int CUSTOM = 3;
    public static final int SWITCH = 100;
    public static final int MOVE = 0;
    public static final int RELEASE = 2;
    public static final int RELEASED = 2;
    public static final int PRESSED = 1;
    public static final int PRESS = 1;
    public static final int LINE = 1;
    public static final int ELLIPSE = 2;
    public static final int ARC = 3;
    public static final int INACTIVE = 0;
    public static final int WAIT = 1;
    public static final int TRANSITION_WAIT_FADEIN = 2;
    public static final int FADEIN = 3;
    public static final int IDLE = 4;
    public static final int FADEOUT = 5;
    public static final int DONE = 6;
    public static final int SINGLE_COLUMN = 0;
    public static final int SINGLE_ROW = 1;
    public static final int MULTIPLES = 2;
    public static final int LIST = 0;
    public static final int DROPDOWN = 1;
    public static final int CHECKBOX = 2;  // TODO
    public static final int TREE = 3;  // TODO

    @Deprecated public static final int ACTION_PRESSED = 1;
    public static final int ACTION_PRESS = 1;

    @Deprecated public static final int ACTION_RELEASED = 2;
    public static final int ACTION_RELEASE = 2;

    public static final int ACTION_CLICK = 3;
    public static final int ACTION_DRAG = 4;
    public static final int ACTION_MOVE = 5;
    public static final int ACTION_ENTER = 6;
    public static final int ACTION_LEAVE = 7;
    public static final int ACTION_EXIT = 7;
    public static final int ACTION_WHEEL = 8;
    @Deprecated public static final int ACTION_RELEASEDOUTSIDE = 9;
    public static final int ACTION_RELEASE_OUTSIDE = 9;
    public static final int ACTION_START_DRAG = 10;
    public static final int ACTION_END_DRAG 11;
    public static final int ACTION_DOUBLE_PRESS = 12;
    public static final int ACTION_BROADCAST = 100;
    public static final int LEFT_OUTSIDE = 10;
    public static final int RIGHT_OUTSIDE = 11;
    public static final int TOP_OUTSIDE = 12;
    public static final int BOTTOM_OUTSIDE = 13;
    public static final int CAPTIONLABEL = 0;
    public static final int VALUELABEL = 1;
    public static final int SINGLE = 0;

    @Deprecated public static final int ALL = 1;
    public static final int MULTI = 1;

    // http://clrs.cc/
    public static final int NAVY = 0xFF001F3F;
    public static final int BLUE = 0xFF0074D9;
    public static final int AQUA = 0xFF7FDBFF;
    public static final int TEAL = 0xFF39CCCC;
    public static final int OLIVE = 0xFF3D9970;
    public static final int GREEN = 0xFF2ECC40;
    public static final int LIME = 0xFF01FF70;
    public static final int YELLOW = 0xFFFFDC00;
    public static final int ORANGE = 0xFFFF851B;
    public static final int RED = 0xFFFF4136;
    public static final int MAROON = 0xFF85144B;
    public static final int FUCHSIA = 0xFFF012BE;
    public static final int PURPLE = 0xFFB10DC9;
    public static final int WHITE = 0xFFFFFFFF;
    public static final int SILVER = 0xFFDDDDDD;
    public static final int GRAY = 0xFFAAAAAA;
    public static final int BLACK = 0xFF111111;

    // fg, bg, active, caption, value
    public static final CColor THEME_RETRO = new CColor(0xff00698c, 0xff003652, 0xff08a2cf, 0xffffffff, 0xffffffff);
    public static final CColor THEME_CP52014 = new CColor(0xff0074D9, 0xff002D5A, 0xff00aaff, 0xffffffff, 0xffffffff);
    public static final CColor THEME_CP5BLUE  = new CColor(0xff016c9e, 0xff02344d, 0xff00b4ea, 0xffffffff, 0xffffffff);
    public static final CColor THEME_RED  = new CColor(0xffaa0000, 0xff660000, 0xffff0000, 0xffffffff, 0xffffffff);
    public static final CColor THEME_GREY = new CColor(0xffeeeeee, 0xffbbbbbb, 0xffffffff, 0xff555555, 0xff555555 );
    public static final CColor THEME_A = new CColor(0xff00FFC8, 0xff00D7FF, 0xffffff00, 0xff00B0FF, 0xff00B0FF);

    // other colors: #ff3838 red-salmon; #08ffb4 turquoise; #40afff light-blue; #f3eddb beige;

    public static final int standard58 = 0;
    public static final int standard56 = 1;
    public static final int synt24 = 2;
    public static final int grixel = 3;
    public static final int J2D = 1;
    public static final int P2D = 2;
    public static final int P3D = 3;

    public static final String JSON = "JSON";
    public static final String SERIALIZED = "SERIALIZED";

    public static final String delimiter = " ";
    public static final String pathdelimiter = "/";

}
