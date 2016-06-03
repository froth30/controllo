package controllo;

// TODO

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;

/**
 * A ControlFont is a container for a PFont that can be used to customize the font of a label.
 *
 * @ example extra/ControlloControlFont  TODO
 */
public class ControlFont {

    public static boolean DEBUG = false;

    public static boolean RENDER_2X;

    public static void sharp() {
        RENDER_2X = true;
    }

    public static void normal() {
        RENDER_2X = false;
    }

    PFont pfont;
    List<String> txt;
    String s = "";
    private int top;
    private int bottom;
    private int center;
    private int width;
    private int height;
    private int baseline = 0;
    private int myTextHeight = 1;
    private int[] offset = new int[2];
    private int size;

    public ControlFont(PFont theFont) {
        this(theFont, checkFontSize(theFont));
    }

    public ControlFont(PFont theFont, int theFontSize) {
        this(theFont, theFontSize, theFontSize + 2);
    }

    public ControlFont(PFont theFont, int theFontSize, int theLineHeight) {
        pfont = theFont;
        size = theFontSize;
        txt = new ArrayList<>();
    }

    private static int checkFontSize(PFont theFont) {
        if (theFont != null) {
            return theFont.getSize();
        } else {
            System.out.println("Controllo: could not find font-size details for font " + theFont.getName()
                    + ", use constructor ControlFont(PFont theFont, int theFontSize) to specify the font size.");
            return 10;
        }
    }

    public void init(Label theLabel) {
        // When the font changes, init is called.
    }

    public void setSize(int theSize) {
        size = theSize;
    }

    public int getSize() {
        return size;
    }

    public int getOffset(int theIndex) {
        return offset[theIndex];
    }

    public int getTextHeight() {
        return myTextHeight;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    public int getCenter() {
        return center;
    }

    public int getBaseline() {
        return baseline;
    }

    public PFont getFont() {
        return pfont;
    }

    public void adjust(PGraphics theGraphics, Label theLabel) {
        if (theLabel.isChanged()) {
            theGraphics.textFont(pfont, size);
            // The origin of a PFont Label is the top-left corner...
            top = (int) -theGraphics.textAscent();
            bottom = (int) theGraphics.textDescent();
            center = (int) ((top + bottom) / 2);
            width = theLabel.isMultiline() ? theLabel.getWidth() :
                    (int) (theGraphics.textAscent() + theGraphics.textDescent());
            height = theLabel.isMultiline() ? theLabel.getHeight() :
                    (int) theGraphics.textWidth(theLabel.getTextFormatted());
            if (theLabel.isMultiline()) {
                calculateHeight(theGraphics, theLabel);
            }
            theLabel.setChanged(false);
        }
    }

    private void calculateHeight(PGraphics theGraphics, Label theLabel) {
        txt.clear();
        String myString = theLabel.getTextFormatted();
        List<String> paragraphs = Arrays.asList(myString.split("\n"));
        // does not recognize linebreaks at the end of theString
        myString = "";
        for (String p : paragraphs) {
            List<String> words = Arrays.asList(p.split("\\s"));
            for (String w : words) {
                if (theGraphics.textWidth(myString + w) < width) {
                    myString += w + " ";
                } else {
                    txt.add(myString.substring(0, PApplet.max(0, myString.length() - 1)));
                    myString = w + " ";
                }
            }
            txt.add(myString.substring(0, myString.length() - 1));
            myString = "";
        }
        if (theLabel.getHeight() % theLabel.getLineHeight() != 0) {
            txt.add("");
        }
        myTextHeight = (PApplet.round(txt.size() * theLabel.getLineHeight()));
        int maxLineNum = PApplet.round(theLabel.getHeight() / theLabel.getLineHeight());
        int offset = (int) (PApplet.max(0, txt.size() - maxLineNum) * (PApplet.abs(theLabel.getOffsetYratio())));
        int lim = PApplet.min(txt.size(), maxLineNum);
        s = "";
        for (int i = 0; i < lim; i++) {
            s += txt.get(i + offset) + "\n";
        }
    }

    public int getOverflow() {
        return myTextHeight- height;
    }

    public void draw(Controllo theControllo, Label theLabel) {
        draw(theControllo.pg, theLabel);
    }

    public void draw(PGraphics theGraphics, Label theLabel) {

        PFont loadedFont = theGraphics.textFont;
        float loadedSize = theGraphics.textSize;
        if (loadedFont == null) {
            theGraphics.textSize(loadedSize);  // forces default font
            loadedFont = theGraphics.textFont;
        }
        int loadedAlign = theGraphics.textAlign;

        theGraphics.textFont(pfont, size);
        theGraphics.textAlign(theLabel.textAlign);
        theGraphics.fill(theLabel.getColor());

        if (theLabel.isMultiline()) {
            theGraphics.fill(theLabel.getColor());
            theGraphics.textLeading(theLabel.getLineHeight());
            theGraphics.text(s, 0, 0, theLabel.getWidth(), theLabel.getHeight());
        } else {
            theGraphics.translate(0, 1 - top);
            debug(theGraphics, theLabel);
            theGraphics.fill(theLabel.getColor());
            theGraphics.textLeading(theLabel.getLineHeight());
            theGraphics.text(theLabel.getTextFormatted(), 0, 0);
            if (RENDER_2X) {
                theGraphics.text(theLabel.getTextFormatted(), 0, 0);
            }
        }

        theGraphics.textFont(loadedFont, loadedSize);
        theGraphics.textAlign(loadedAlign);

    }

    private void debug(PGraphics theGraphics, Label theLabel) {
        if (DEBUG) {

            theGraphics.stroke(0, 255, 0);  // baseline
            theGraphics.line(0, getBaseline(), theGraphics.textWidth(theLabel.getText()), getBaseline());

            theGraphics.stroke(0, 0, 255);  // top
            theGraphics.line(0, getTop(), theGraphics.textWidth(theLabel.getText()), getTop());

            theGraphics.stroke(255, 255, 0);  // bottom
            theGraphics.line(0, getBottom(), theGraphics.textWidth(theLabel.getText()), getBottom());

            theGraphics.stroke(255, 0, 0);  // center
            theGraphics.line(0, getCenter(), theGraphics.textWidth(theLabel.getText()), getCenter());

            theGraphics.stroke(255, 128, 0);  // center caps
            theGraphics.line(0, getTop() / 2, theGraphics.textWidth(theLabel.getText()), getTop() / 2);

            theGraphics.noStroke();
        }
    }

    public static int getWidthFor(String theText, Label theLabel, PGraphics theGraphics) {
        theGraphics.textFont(theLabel.getFont().pfont, theLabel.getFont().size);
        return (int) theGraphics.textWidth(theText);
    }

}
