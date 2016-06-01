package controllo;

import java.util.ArrayList;

/**
 * <p>
 *     Controller is an abstract class that is extended by any available controller within Controllo.
 * </p>
 */
public abstract class Controller<T> implements ControllerInterface<T>, CDrawable, ControlloConstants {

    protected float[] position = new float[2];
    protected float[] positionBuffer = new float[2];
    //
    protected Controllo cont;
    //
    private T me;
    protected boolean isDragged;

    public Controller(Controllo controllo, String name) {
        this(controllo, controllo.getDefaultTab(), name, 0, 0, autoWidth, autoHeight);
        controllo.register(controllo.papplet, name, this);
    }

    protected Controller(final Controllo controllo, final ControllerGroup<?> parent, final String name, final float x, final float y, final int w, final int h) {
        cont = controllo;
        me = (T) this;
        if (cont == null) {
            isBroadcast = false;
        }
        myName = name;

        set(position, x, y);
        set(positionBuffer, x, y);

        setParent(parent);
        if (parent != null) {
            color.set(parent.color);
        } else {
            color.set(cont.color);
        }
        width = w;
        height = h;

        myCaptionLabel = new Label(cont, name);
        myCaptionLabel.setColor(color.getCaptionLabel());
        myValueLabel = new Label(cont, "-");
        myValueLabel.setColor(color.getCaptionLabel());

        myControllerPlugList = new ArrayList<ControllerPlug>();
    }

}
