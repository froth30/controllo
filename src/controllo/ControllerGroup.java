package controllo;

// TODO

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.event.KeyEvent;

/**
 * ControllerGroup is an abstract class and is extended by class ControlGroup, Tab, or the ListBox.
 */
public abstract class ControllerGroup<T> implements ControllerInterface<T>, ControlloConstants, ControlListener {

    protected float[] position = new float[2];
    protected float[] positionBuffer = new float[2];
    protected float[] absolutePosition = new float[2];
    protected ControllerList controllers;
    protected List<ControlListener> myControlListeners;
    // protected ControlWindow myControlWindow
    protected Controllo cont;
    protected ControllerGroup<?> myParent;
    protected String myName;
    protected int myId = -1;
    protected CColor color = new CColor();
    protected boolean isMousePressed = false;
    // only applies to the area of the title bar of a group
    protected boolean isInside = false;
    // applies to the area including controllers, currently only supported for listbox
    protected boolean isInsideGroup = false;
    protected boolean isVisible = true;
    protected boolean isOpen = true;
    protected boolean isBarVisible = true;
    protected boolean isArrowVisible = true;
    protected Button myCloseButton;
    protected boolean isMoveable = true;
    protected Label myLabel;
    protected Label myValueLabel;
    protected int myWidth = 99;
    protected int myHeight = 9;
    protected boolean isUpdate;
    protected List<Canvas> myCanvas;
    protected float myValue;
    protected String myStringValue;
    protected float[] myArrayValue;
    protected boolean isCollapse = true;
    protected int myPickingColor = 0x6600ffff;
    protected float[] autoPosition = new float[] {10, 30};
    protected float tempAutoPositionHeight = 0;
    protected float autoPositionOffsetX = 10;
    private String myAddress = "";
    private boolean mouseover;
    protected final T me;

    /**
     * Convenience constructor to extend ControllerGroup.
     * @param theControllo
     * @param theName
     */
    public ControllerGroup(Controllo theControllo, String theName) {
        this(theControllo, theControllo.getDefaultTab(), theName, 0, 0);
        theControllo.register(theControllo.papplet, theName, this);
    }

    public ControllerGroup(Controllo theControllo, ControllerGroup<?> theParent, String theName, float theX, float theY) {
        position = new float[]{theX, theY};
        cont = theControllo;
        me = (T) this;
        color.set(theParent == null ? cont.color : theParent.color);
        myName = theName;
        controllers = new ControllerList();
        myCanvas = new ArrayList<Canvas>();
        myControlListeners = new ArrayList<>();
        myLabel = new Label(cont, myName);
        myLabel.setText(myName);
        myLabel.setColor(color.getCaptionLabel());
        myLabel.align(LEFT, TOP);
        setParent(theParent == null ? this : theParent);
    }

    protected ControllerGroup(int theX, int theY) {
        position = new float[] {theX, theY};
        me = (T) this;
        controllers = new ControllerList();
        myCanvas = new ArrayList<Canvas>();
    }

    @Controllo.Invisible public void init() {

    }

    // TODO

}
