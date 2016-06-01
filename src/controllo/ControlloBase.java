package controllo;

// TODO

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import processing.core.PApplet;
import processing.event.Event;

import static controllo.Controller.*;

/**
 * The ControlloBase supports the Controllo class and implements all adder methods to add controllers to controllo.
 */
public class ControlloBase {

    protected Controllo cont;
    protected ControllerProperties myProperties;
    private ControllerAutomator myAutomator;
    // TODO

    public Tab getDefaultTab() {
        return (Tab) cont.controlWindow.getTabs().get(1);
    }

    protected void init(Controllo theControllo) {
        super.init(theControllo);
        cont = theControllo;
        myProperties = new ControllerProperties(cont);
        myAutomator = new ControlloAutomator(cont);
        currentGroupPointer = cont.controlWindow.getTab("default");
    }

    // TODO

}
