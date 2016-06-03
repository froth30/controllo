package controllo;

import processing.core.PApplet;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by theof_000 on 5/29/2016.
 */
public class ControlWindow {

    protected Controllo cont;
    protected Controller<?> isControllerActive;
    public int background = 0x00000000;
    protected CColor color = new CColor();
    private String myName = "main";
    protected PApplet myApplet;
    protected ControllerList myTabs;
    protected boolean isVisible = true;
    protected boolean isInit = false;
    protected boolean isRemove = false;
    protected CDrawable myDrawable;
    protected boolean isAutoDraw;
    protected boolean isUpdate;
    protected List<Canvas> myCanvas;
    protected boolean isDrawBackground = true;
    protected boolean isUndecorated = false;
    protected float[] autoPosition = new float[]{10,30,0};
    protected float tempAutoPositionHeight = 0;
    protected boolean rendererNotification = false;
    protected float[] positionOfTabs = new float[]{0,0,0};
    private int myFrameCount = 0;
    private boolean isMouse = true;
    private Pointer myPointer;
    private int mouseWheelMoved = 0;
    private List<ControllerInterface<?>> mouseoverList;
    private boolean isMouseOver;
    protected int mouseX;
    protected int mouseY;
    protected int pmouseX;
    protected int pmouseY;
    protected boolean mousePressed;
    protected long mousePressedTime;
    protected long pmousePressedTime;
    protected boolean mouseLock;
    protected char key;
    protected int keyCode;
    private final int numKeys = 1024;
    private boolean[] keys = new boolean[numKeys];
    private int numActiveKeys = 0;
    private boolean focused = true;

    /**
     * TODO
     * @exclude
     * @param theControllo
     * @param theApplet
     */
    public ControlWindow(final Controllo theControllo, final PApplet theApplet) {
        // TODO
    }

    protected void init() {

        myPointer = new Pointer();
        // TODO

    }

    // TODO

    /**
     * Returns the name of the control window
     * @return
     */
    public String name() {
        return myName;
    }

    private void mousePressedEvent() {
        if (isVisible) {
            mousePressed = true;
            pmousePressedTime = mousePressedTime;
            mousePressedTime = System.currentTimeMillis();
            for (int i = 0; i < myTabs.size(); i++) {
                if (((ControllerInterface<?>) myTabs.get(i)).setMousePressed(true)) {
                    mouseLock = true;
                    return;
                }
            }
        }
    }

    private void mouseReleasedEvent() {
        if (isVisible) {
            mousePressed = false;
            mouseLock = false;
            for (int i = 0; i < myTabs.size(); i++) {
                ((ControllerInterface<?>) myTabs.get(i)).setMousePressed(false);
            }
        }
    }

    /*private*/ void setMouseWheelRotation(int theRotation) {
        if (isMouseOver()) {
            mouseWheelMoved = theRotation;
        }
    }

    @SuppressWarnings("unchecked") private void handleMouseWheelMoved() {
        if (mouseWheelMoved != 0) {
            List<ControllerInterface<?>> mouseList = new CopyOnWriteArrayList<ControllerInterface<?>>(mouseoverList);
            for (ControllerInterface<?> c : mouseList) {
                if (c.isVisible()) {
                    if (c instanceof Controller) {
                        ((Controller) c).onScroll(mouseWheelMoved);
                        cont.getControlBroadcaster().invokeAction(new CallbackEvent((Controller) c, Controllo.ACTION_WHEEL));
                        ((Controller) c).callListener(Controllo.ACTION_WHEEL);
                    }
                    if (c instanceof ControllerGroup) {
                        ((ControllerGroup) c).onScroll(mouseWheelMoved);
                    }
                    if (c instanceof Slider) {
                        ((Slider) c).scrolled(mouseWheelMoved);
                    } else if (c instanceof Knob) {
                        ((Knob) c).scrolled(mouseWheelMoved);
                    } else if (c instanceof Numberbox) {
                        ((Numberbox) c).scrolled(mouseWheelMoved);
                    } else if (c instanceof Textarea) {
                        ((Textarea) c).scrolled(mouseWheelMoved);
                    } else if (c instanceof ColorWheel) {
                        ((ColorWheel) c).scrolled(mouseWheelMoved);
                    }
                    break;
                }
            }
        }
        mouseWheelMoved = 0;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    /**
     * TODO
     * @exclude
     * @param theKeyEvent
     */
    public void handleKeyEvent(KeyEvent theKeyEvent) {
        for (int i = 0; i < myTabs.size(); i++) {
            ((ControllerInterface<?>) myTabs.get(i)).keyEvent(theKeyEvent);
        }
    }

    // TODO

    public Pointer getPointer() {
        return myPointer;
    }

    public ControlWindow enablePointer() {
        myPointer.enable();
        return this;
    }

    public ControlWindow disablePointer() {
        myPointer.disable();
        return this;
    }

    public class Pointer {

        public Pointer setX(int theX) {
            mouseX = theX;
            return this;
        }

        public Pointer setY(int theY) {
            mouseY = theY;
            return this;
        }

        public int getX() {
            return mouseX;
        }

        public int getY() {
            return mouseY;
        }

        public int getPreviousX() {
            return pmouseX;
        }

        public int getPreviousY() {
            return pmouseY;
        }

        public Pointer set(int theX, int theY) {
            setX(theX);
            setY(theY);
            return this;
        }

        public Pointer set(int theX, int theY, boolean pressed) {
            setX(theX);
            setY(theY);
            if (pressed) {
                if (!mousePressed) {
                    pressed();
                }
            } else {
                if (mousePressed) {
                    released();
                }
            }
            return this;
        }

        public Pointer pressed() {
            mousePressedEvent();
            return this;
        }

        public Pointer released() {
            mouseReleasedEvent();
            return this;
        }

        public void enable() {
            isMouse = false;
        }

        public void disable() {
            isMouse = true;
        }

        public boolean isEnabled() {
            return !isMouse;
        }
    }

    /**
     * Hide the controllers and tabs of the control window
     * @return
     */
    public ControlWindow hide() {
        isVisible = false;
        isMouseOver = false;
        return this;
    }

}
