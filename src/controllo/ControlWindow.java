package controllo;

import processing.core.PApplet;

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
    // TODO

    public ControlWindow(final Controllo theControllo, final PApplet theApplet) {
        // TODO
    }

}
