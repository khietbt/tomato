package tomato.plugins.jmeter.utils;

import javax.swing.text.JTextComponent;
import java.awt.*;

public class GuiUtils {
    public static void createPlaceHolder(String placeHolder, JTextComponent textComponent) {
        var prompt = new TextPrompt(placeHolder, textComponent);

        prompt.changeAlpha(0.5f);
        prompt.changeStyle(Font.ITALIC);
    }
}
