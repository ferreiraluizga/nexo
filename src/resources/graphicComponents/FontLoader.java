package resources.graphicComponents;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {

    public static Font loadFont(String fontName, float size) {
        try {
            InputStream is = FontLoader.class.getResourceAsStream("/resources/fonts/" + fontName);
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            return font.deriveFont(size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
