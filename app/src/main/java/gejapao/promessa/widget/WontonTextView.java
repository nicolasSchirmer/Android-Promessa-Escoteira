package gejapao.promessa.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import gejapao.promessa.App;

public class WontonTextView extends TextView {
    public WontonTextView(Context context) {
        this(context, null);
    }

    public WontonTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WontonTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(App.wonton);
    }

}
