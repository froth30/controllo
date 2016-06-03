package controllo;

// TODO

import java.io.Serializable;

/**
 * A controller property saves the value, address, setter, and getter of a registered controller.
 *
 * @example controllers/ControlloProperties  TODO
 */
public class ControllerProperty implements Serializable, Cloneable {

    private static final long serialVersionUID = 4506431150330867327L;
    private String setter;
    private String getter;
    private Class<?> type;
    private Object value;
    protected String address;
    private int id;
    private transient boolean active;
    private transient ControllerInterface<?> controller;

    ControllerProperty(ControllerInterface<?> theController, String theSetter, String theGetter) {
        setController(theController);
        setAddress(theController.getAddress());
        setSetter(theSetter);
        setGetter(theGetter);
        setActive(true);
        setId(theController.getId());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ControllerProperty clone = (ControllerProperty) super.clone();
        // TODO
        return clone;
    }

    // TODO

    public void enable() {
        active = true;
    }

    public void disable() {
        active = false;
    }

    @Override
    public String toString() {
        return address + " " + setter + ", " + getter;
    }

    void setAddress(String theAddress) {
        address = theAddress;
    }

    String getAddress() {
        return address;
    }

    void setController(ControllerInterface<?> theController) {
        controller = theController;
    }

    ControllerInterface<?> getController() {
        return controller;
    }

    void setValue(Object theValue) {
        value = theValue;
    }

    Object getValue() {
        return value;
    }

    void setType(Class<?> theType) {
        type = theType;
    }

    Class<?> getType() {
        return type;
    }

    void setActive(boolean theFlag) {
        active = theFlag;
    }

    boolean isActive() {
        return active;
    }

    void setSetter(String theSetter) {
        setter = theSetter
    }

    String getSetter() {
        return setter;
    }

    void setGetter(String theGetter) {
        getter = theGetter;
    }

    String getGetter() {
        return getter;
    }

    void setId(int theId) {
        id = theId;
    }

    int getId() {
        return id;
    }

}
