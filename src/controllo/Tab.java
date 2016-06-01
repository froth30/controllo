package controllo;

// TODO

import processing.core.PGraphics;

/**
 * Tabs are used to organize controllers. Tabs are arranged horizontally from the top-left corner by default. For more
 * available methods, see the ControllerGroup documentation. Reposition tabs with
 * {@link controllo.ControlWindow#setPositionOfTabs(int, int)}.
 *
 * @example TODO
 * @nosuperclasses ControllerGroup ControllerGroup
 */
public class Tab extends ControllerGroup<Tab> {

    protected int myOffsetX = -1000;
    protected int myOffsetY = -1000;
    protected boolean isActive = false;
    private boolean isAlwaysActive = false;
    protected boolean isEventActive = false;
    protected float myValue = 0;
    protected String myStringValue = "";
    public static int padding = 4;
    public boolean autoWidth = true;

    // TODO
    public Tab(Controllo theControllo, ControlWindow theControlWindow, String theName) {
        super(theControllo, null, theName, 0, 0);
        position = new float[2];
        absolutePosition = new float[2];
        isMoveable = false;
        isEventActive = theControllo.isTabEventsActive;
        myHeight = 16;
        myWidth = myLabel.getWidth() + padding * 2;
        myLabel.align(LEFT, CENTER).setPadding(0, 0);
    }

    protected void setOffset(int theX, int theY) {
        myOffsetX = theX;
        myOffsetY = theY;
    }

    protected int height() {
        return myHeight;
    }

    protected boolean updateLabel() {
        isInside = inside();
        return cont.getWindow().getTabs().size() > 2;
    }

    // TODO

}
