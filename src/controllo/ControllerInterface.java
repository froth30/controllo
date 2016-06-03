package controllo;

// TODO

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.event.KeyEvent;

/**
 * The ControllerInterface is inherited by all ControllerGroup and Controller classes.
 */
public interface ControllerInterface<T> {

    @Controllo.Invisible public void init();

    public int getWidth();

    public int getHeight();

    public T setValue(float theValue);

    public float getValue();

    public T setStringValue(String theValue);

    public String getStringValue();

    public T setArrayValue(float[] theArray);

    public float[] getArrayValue();

    public T setArrayValue(int theIndex, float theValue);

    public float getArrayValue(int theIndex);

    public int getId();

    public float[] getPosition();

    @Controllo.Invisible public T setPosition(float theX, float theY);

    @Controllo.Invisible public T setPosition(float[] thePosition);

    public T setAbsolutePosition(float[] thePosition);

    public float[] getAbsolutePosition();

    public T updateAbsolutePosition();

    public ControllerInterface<?> getParent();

    public T update();

    public T setUpdate(boolean theFlag);

    public T bringToFront();

    public T bringToFront(ControllerInterface<?> theController);

    public boolean isUpdate();

    @Controllo.Invisible public T updateEvents();

    @Controllo.Invisible public void continuousUpdateEvents();

    /**
     * A method for putting input events like e.g. mouse or keyboard events and queries. This has been taken out of the
     * draw method for better overwriting capability.
     * @param theApplet
     * @return
     */
    @Controllo.Invisble public T updateInternalEvents(PApplet theApplet);

    @Controllo.Invisible public void draw(PGraphics theGraphics);

    public T add(ControllerInterface<?> theElement);

    public T remove(ControllerInterface<?> theElement);

    public void remove();

    public String getName();

    public String getAddress();

    public ControlWindow getWindow();

    public Tab getTab();

    public boolean setMousePressed(boolean theStatus);

    @Controllo.Invisible public void keyEvent(KeyEvent theEvent);

    @Controllo.Invisible public T setAddress(String theAddress);

    public T setId(int theValue);

    public T setLabel(String theString);

    public T setColorActive(int theColor);

    public T setColorForeground(int theColor);

    public T setColorBackground(int theColor);

    public T setColorLabel(int theColor);

    public T setColorValue(int theColor);

    public T setColor(CColor theColor);

    public CColor getColor();

    public T show();

    public T hide();

    public boolean isVisible();

    public T moveTo(ControllerGroup<?> theGroup, Tab theTab, ControlWindow theWindow);

    public T moveTo(ControllerGroup<?> theGroup);

    @Controllo.Invisible public int getPickingColor();

    public ControllerProperty getProperty(String thePropertyName);

    public ControllerProperty getProperty(String theSetter, String theGetter);

    public T registerProperty(String thePropertyName);

    public T registerProperty(String theSetter, String theGetter);

    public T removeProperty(String thePropertyName);

    public T removeProperty(String theSetter, String theGetter);

    public T setMouseOver(boolean theFlag);

    public boolean isMouseOver();

    public T setFont(PFont theFont);

    public T setFont(ControlFont theFont);

    public T addListener(ControlListener theListener);

    public T setCaptionLabel(String theValue);

}
