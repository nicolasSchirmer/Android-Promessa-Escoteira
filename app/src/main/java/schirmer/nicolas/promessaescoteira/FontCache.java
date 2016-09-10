package schirmer.nicolas.promessaescoteira;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

// https://stackoverflow.com/questions/16648190/how-to-set-a-particular-font-for-a-button-text-in-android/16648457#16648457
public class FontCache {

    private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();

    public static Typeface get(String name, Context context) {
        Typeface tf = fontCache.get(name);
        if(tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), name);
            }
            catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }
}
