package controllo;

// TODO

import processing.core.PFont;
import processing.core.PGraphics;

import java.util.List;

/**
 * A custom label using controllo's BitFonts- or PFont-based ControlFonts.
 *
 * @see controllo.ControlFont
 * @example controllers/ControlloTextlabel
 */
public class Label implements CDrawable {

    public static boolean isToUpperCaseDefault = true;
    protected int myLetterSpacing = 0;
    protected boolean isMultiline;
    protected boolean isFixedSize;
    protected ControllerStyle myControllerStyle = new ControllerStyle();
    protected boolean isVisible = true;
    protected int myColor = 0xffffffff;
    protected boolean isColorBackground;
    protected boolean isToUpperCase = isToUpperCaseDefault;
    protected boolean changed;
    protected int myColorBackground = 0xffffffff;
    protected int myHeight = -1;
    protected int myWidth = -1;
    protected String myText = "";
    protected ControlFont myFontLabel;
    protected int myLineHeight = 0;
    protected int alignX = Controllo.LEFT;
    protected int alignY = Controllo.LEFT;
    protected int textAlign = Controllo.LEFT;
    public static int paddingX = 4;
    public static int paddingY = 4;
    public int myPaddingX = paddingX;
    public int myPaddingY = paddingY;
    protected Labeltype myLabeltype;
    protected int myTextHeight = 1;
    protected float offsetYratio = 0;
    private Controllo cont;

    private Label(Label theLabel) {
        myText = theLabel.getText();
        isToUpperCase = theLabel.isToUpperCase();
        myLetterSpacing = theLabel.getLetterSpacing();
        myLineHeight = theLabel.getLineHeight();
        myFontLabel = theLabel.getFont();
        myLabeltype = theLabel.getLabeltype();
    }

    public Label(Controllo theControllo, String theValue) {
        init(theControllo, theValue, 0, 0, myColor);
    }

    public Label(Controllo theControllo, String theValue, int theWidth, int theHeight, int theColor) {
        init(theControllo, theValue, theWidth, theHeight, theColor);
    }

    private void init(Controllo theControllo, String theValue, int theWidth, int theHeight, int theColor) {
        cont = theControllo;
        myWidth = theWidth;
        myHeight = theHeight;
        myText = theValue;
        myColor = theColor;
        setLabeltype(new SinglelineLabel());
        setFont(cont.controlFont);
        setLabeltype(new SinglelineLabel());
        set(myText);
        myControllerStyle = new ControllerStyle();
    }

    Label setLabeltype(Labeltype theType) {
        myLabeltype = theType;
        return this;
    }

    Labeltype getLabeltype() {
        return myLabeltype;
    }

    public Label align(int[] a) {
        alignX = a[0];
        alignY = a[1];
        return this;
    }

    public Label align(int theX, int theY) {
        alignX = theX;
        alignY = theY;
        return this;
    }

    public Label alignX(int theX) {
        alignX = theX;
        return this;
    }

    public Label alignY(int theY) {
        alignY = theY;
        return this;
    }

    public int[] getAlign() {
        return new int[] {alignX, alignY};
    }

    public Label setPadding(int thePaddingX, int thePaddingY) {
        myPaddingX = thePaddingX;
        myPaddingY = thePaddingY;
        return this;
    }

    public Label setPaddingX(int thePaddingX) {
        myPaddingX = thePaddingX;
    }

    public Label setPaddingY(int thePaddingY) {
        myPaddingY = thePaddingY;
        return this;
    }

    public void draw(PGraphics theGraphics, int theX, int theY, ControllerInterface<?> theController) {
        if (isVisible) {
            getLabeltype().draw(this, theGraphics, theX, theY, theController);
        }
    }

    public void draw(PGraphics theGraphics, int theX, int theY, int theW, int theH) {
        if (isVisible) {
            getLabeltype().draw(this, theGraphics, theX, theY, theW, theH);
        }
    }

    @Override
    public void draw(PGraphics theGraphics) {
        if (isVisible) {
            myFontLabel.adjust(theGraphics, this);
            draw(theGraphics, 0, 0);
        }
    }

    public void draw(PGraphics theGraphics, int theX, int theY) {
        if (isVisible) {
            theGraphics.pushMatrix();
            theGraphics.translate(myControllerStyle.marginLeft, myControllerStyle.marginTop);
            theGraphics.translate(theX, theY);

            if (isColorBackground) {

                float w = getStyle().paddingRight + getStyle().paddingLeft;
                if(getStyle().backgroundWidth > -1) {
                    w += myControllerStyle.backgroundWidth;
                } else {
                    w += myFontLabel.getWidth();
                }

                float h = getStyle().paddingBottom + getStyle().paddingTop;
                if (getStyle().backgroundHeight > -1) {
                    h += getStyle().backgroundHeight;
                } else {
                    h += myFontLabel.getHeight();
                }

                theGraphics.fill(myColorBackground);
                theGraphics.rect(0, 1, w, h);
            }

            theGraphics.translate(myControllerStyle.paddingLeft, myControllerStyle.paddingTop);
            myFontLabel.draw(theGraphics, this);
            theGraphics.popMatrix();
        }
    }

    public Label show() {
        return setVisible(true);
    }

    public Label hide() {
        return setVisible(false);
    }

    public Label setVisible(boolean theFlag) {
        isVisible = theFlag;
        return this;
    }

    public Label updateFont(ControlFont theFont) {
        return setFont(theFont);
    }

    public Label setText(String theText) {
        myText = theText;
        setChanged(true);
        return this;
    }

    public String getText() {
        return myText;
    }

    public String getTextFormatted() {
        return getLabeltype().getTextFormatted();
    }

    public Label setFixedSize(boolean theFlag) {
        isFixedSize = theFlag;
        return this;
    }

    public boolean isFixedSize() {
        return isMultiline ? false : isFixedSize;
    }

    public ControllerStyle getStyle() {
        return myControllerStyle;
    }

    public Label setWidth(int theWidth) {
        myWidth = theWidth;
        setChanged(true);
        return this;
    }

    public int getWidth() {
        return myWidth;
    }

    public Label setHeight(int theHeight) {
        myHeight = theHeight;
        setChanged(true);
        return this;
    }

    public int getHeight() {
        return myHeight;
    }

    public int getOverflow() {
        return getLabeltype().getOverflow();
    }

    public Label setMultiline(boolean theFlag) {
        isMultiline = theFlag;
        myLabeltype = isMultiline ? new MultilineLabel() : new SinglelineLabel();
        return this;
    }

    public Label toUpperCase(boolean theFlag) {
        isToUpperCase = theFlag;
        setChanged(true);
        return this;
    }

    public Label setFont(int theBitFontIndex) {
        Controllo.logger.warning("Bitfont is now of type PFont, use setFont(PFont) instead.");
        return this;
    }

    public Label setFont(PFont thePFont) {
        return setFont(new ControlFont(thePFont));
    }

    public Label setFont(ControlFont theFont) {
        setLineHeight(theFont.getSize());
        myFontLabel = new ControlFont(theFont.getFont(), theFont.getSize());
        myFontLabel.init(this);
        setChanged(true);
        return this;
    }

    public ControlFont getFont() {
        return myFontLabel;
    }

    public Label setSize(int theSize) {
        myFontLabel.setSize(theSize);
        return this;
    }

    protected Label setChanged(boolean theFlag) {
        changed = theFlag;
        return this;
    }

    protected boolean isChanged() {
        return changed;
    }

    Label setTextHeight(int theHeight) {
        myTextHeight = theHeight;
        return this;
    }

    public int getTextHeight() {
        return myFontLabel.getTextHeight();
    }

    // TODO

}
