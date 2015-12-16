package grp27_ueb05;

import java.util.Arrays;

/**
 *
 * @author Robin
 */
public class Color {

    private int red;
    private int green;
    private int blue;

    public enum ColorName {

        RED, ORANGE, YELLOW, BLUEVIOLET, BLUE, GREEN, GREY, BLACK, WHITE
    }

    private final static int[][] COLOR_VALUES = {{0xFF, 0x00, 0x00}, {0xFF, 0x45, 0x00},
    {0xFF, 0xFF, 0x00}, {0x8A, 0x2B, 0xE2}, {0x00, 0x00, 0xFF}, {0x00, 0xFF, 0x00},
    {0xBE, 0xBE, 0xBE}, {0x00, 0x00, 0x00}, {0xFF, 0xFF, 0xFF}};

    public static void main(String[] args) {

        //Konstruktor für einzelne Farbwerte ergibt definierte Farbe
        // Input: drei einzelne Werte
        Color color = new Color(0xFF, 0, 0); // RED
        // Input: Array mit Werten
        Color color2 = new Color(new int[]{0xFF, 0x45, 0}); // ORANGE
        // Input: Element vom Farbenum
        Color color3 = new Color(ColorName.YELLOW); // YELLOW
        // Input: Farbe als String
        Color color4 = Color.stringToColor("blueviolet"); // BLUEVIOLET
        // Input: Falscher String
        Color color5 = Color.stringToColor("gibtsNichtFarbe"); // NULL

        assert Arrays.equals(new int[]{0xFF, 0, 0}, color.getRGB());
        assert "RED".equals(color.toString());
        assert Arrays.equals(new int[]{0xFF, 0x45, 0}, color2.getRGB());
        assert "ORANGE".equals(color2.toString());
        assert Arrays.equals(new int[]{0xFF, 0xFF, 0x00}, color3.getRGB());
        assert "YELLOW".equals(color3.toString());
        assert Arrays.equals(new int[]{0x8A, 0x2B, 0xE2}, color4.getRGB());
        assert "BLUEVIOLET".equals(color4.toString());
        assert color5 == null;


        //Konstruktor für einzelne Farbwerte ergibt undefinierte Farbe
        //color = new Color(10, 128, 255);
        //assert Arrays.equals(new int[]{10, 128, 255}, color.getRGB());
        //assert "# A80FF".equals(color.toString());

        //assert 9055202 == color4.getPackedRGB();

    }

    /**
     * Konstruktor für direkte Farbwertsetzung
     *
     * @param red
     * @param green
     * @param blue
     */
    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Color(int farbArray[]) {
        this(farbArray[0], farbArray[1], farbArray[2]);
    }

    public Color(ColorName nameOfColor) {
        this(COLOR_VALUES[nameOfColor.ordinal()]);
    }

    public static Color stringToColor(String nameOfColor) {
        if (isColorName(nameOfColor.toUpperCase())) {
            return new Color(ColorName.valueOf(nameOfColor.toUpperCase()));
        } else {
            return null;
        }
    }

    public static boolean isColorName(String nameOfInputColor) {

        for (ColorName nameOfEnumColor : ColorName.values()) {
            if (nameOfEnumColor.toString().equals(nameOfInputColor)) {
                return true;
            }
        }

        return false;
    }

    public int[] getRGB() {

        int[] arrayForRGB = {this.red, this.green, this.blue};
        return arrayForRGB;
    }

    public int getRGB(int channel) {
        if (channel == 1) {
            return this.red;
        } else if (channel == 2) {
            return this.green;
        } else if (channel == 3) {
            return this.blue;
        } else {
            return -1;
        }
    }

    public int getPackedRGB2() {
        return Integer.parseInt(Integer.toHexString(this.red).toUpperCase() + Integer.toHexString(this.green).toUpperCase() + Integer.toHexString(this.blue).toUpperCase(), 16);
    }

    public int getPackedRGB() {

        return ((this.red << 16) + (this.green << 8) + (this.blue << 1));
    }

    @Override
    public String toString() {
        for (int i = 0; i < COLOR_VALUES.length; i++) {
            if (COLOR_VALUES[i][0] == this.red && COLOR_VALUES[i][1] == this.green && COLOR_VALUES[i][2] == this.blue) {

                return (ColorName.values()[i]).toString();
            }

        }

        return String.format("#%2s%2s%2s", Integer.toHexString(this.red).toUpperCase(), Integer.toHexString(this.green).toUpperCase(), Integer.toHexString(this.blue).toUpperCase());
    }
}
