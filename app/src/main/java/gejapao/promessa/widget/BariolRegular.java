package gejapao.promessa.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import gejapao.promessa.App;

public class BariolRegular extends TextView {
    public BariolRegular(Context context) {
        this(context, null);
    }

    public BariolRegular(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BariolRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(App.bariolReg);
    }
}
