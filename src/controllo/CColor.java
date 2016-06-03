package controllo;

// TODO

import java.io.Serializable;

/**
 * A CColor instance contains the colors of a controller including the foreground-, background-, active-, captionlabel-,
 * and valuelabel-colors.
 */
public class CColor implements Serializable {

    private int colorBackground = 0xff003652;
    private int colorForeground = 0xff00698c;
    private int colorActive = 0xff08a2cf;  // 0699C4;
    private int colorCaptionLabel = 0xffffffff;
    private int colorValueLabel = 0xffffffff;
    private int colorBackgroundAlpha = 0xff;
    private int colorForegroundAlpha = 0xff;
    private int colorActiveAlpha = 0xff;  // 0699C4;
    private int colorCaptionLabelAlpha = 0xff;
    private int colorValueLabelAlpha = 0xff;

    private int alpha = 0xff;
    private int maskA = 0x00ffffff;
    int maskR = 0xff00ffff;
    int maskG = 0xffff00ff;
    int maskB = 0xffffff00;

    protected CColor set(CColor theColor) {
        // TODO
        return this;
    }

    protected CColor copyTo(ControllerInterface<?> theControl) {
        // TODO
        return this;
    }

    @Override
    public String toString() {
        return ( "bg (" + ( colorBackground >> 16 & 0xff ) + "," + ( colorBackground >> 8 & 0xff ) + "," + ( colorBackground >> 0 & 0xff ) + "), " + "fg (" + ( colorForeground >> 16 & 0xff ) + "," + ( colorForeground >> 8 & 0xff ) + ","
                + ( colorForeground >> 0 & 0xff ) + "), " + "active (" + ( colorActive >> 16 & 0xff ) + "," + ( colorActive >> 8 & 0xff ) + "," + ( colorActive >> 0 & 0xff ) + "), " + "captionlabel (" + ( colorCaptionLabel >> 16 & 0xff ) + ","
                + ( colorCaptionLabel >> 8 & 0xff ) + "," + ( colorCaptionLabel >> 0 & 0xff ) + "), " + "valuelabel (" + ( colorValueLabel >> 16 & 0xff ) + "," + ( colorValueLabel >> 8 & 0xff ) + "," + ( colorValueLabel >> 0 & 0xff ) + ")" );
    }

    public CColor() {
        set(Controllo.getColor());
    }

    public CColor(int cfg, int cbg, int ca, int ccl, int cvl) {
        setForeground(cfg);
        setBackground(cbg);
        setActive(ca);
        setCaptionLabel(ccl);
        setValueLabel(cvl);
    }

    public CColor(CColor theColor) {
        set(theColor);
    }

    /**
     *
     * @exclude
     * @param theAlpha
     * @return
     */
    public CColor setAlpha(int theAlpha) {
        System.out.println("controllo.CColor.setAlpha: setting alpha values disabled for this version of controllo.");
        return this;
    }

    public CColor setForeground(int theColor) {

    }

    public CColor setBackground(int theColor) {

    }

    public CColor setActive(int theColor) {

    }

    public CColor setCaptionLabel(int theColor) {

    }

    public CColor setValueLabel(int theColor) {

    }

    public int getAlpha() {
        return alpha;
    }

    public int getForeground() {
        return colorForeground;
    }

    public int getBackground() {
        return colorBackground;
    }

    public int getActive() {
        return colorActive;
    }

    public int getCaptionLabel() {
        return colorCaptionLabel;
    }

    public int getValueLabel() {
        return colorValueLabel;
    }

    @Override
    public int hashCode() {
        int result = 23;
        result = 37 * result + colorBackground;
        result = 37 * result + colorForeground;
        result = 37 * result + colorActive;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CColor cc = (CColor) o;
        if (colorBackground != cc.colorBackground || colorForeground != cc.colorForeground || colorActive != cc.colorActive || colorCaptionLabel != cc.colorCaptionLabel || colorValueLabel != cc.colorValueLabel) {
            return false;
        }
        return true;
    }

}
