package gejapao.promessa;

import android.app.Application;
import android.graphics.Typeface;

public class App extends Application {
    private static final String CANARO_EXTRA_BOLD_PATH = "fonts/canaro_extra_bold.otf";
    public static Typeface canaroExtraBold;

    private static final String WONTON_PATH = "fonts/Wonton.ttf";
    public static Typeface wonton;

    private static final String Bariol_regular_PATH = "fonts/Bariol_Regular.otf";
    public static Typeface bariolReg;

    @Override
    public void onCreate() {
        super.onCreate();
        initTypeface();
    }

    private void initTypeface() {
        bariolReg = Typeface.createFromAsset(getAssets(), Bariol_regular_PATH);
        wonton = Typeface.createFromAsset(getAssets(), WONTON_PATH);
        canaroExtraBold = Typeface.createFromAsset(getAssets(), CANARO_EXTRA_BOLD_PATH);
    }
}
