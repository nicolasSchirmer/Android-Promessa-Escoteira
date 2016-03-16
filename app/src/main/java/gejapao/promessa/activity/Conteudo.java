package gejapao.promessa.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flavienlaurent.discrollview.lib.DiscrollView;

import gejapao.promessa.R;
import gejapao.promessa.widget.Library;

public class Conteudo extends AppCompatActivity {

    // value , position
    int[] values;
    Intent intent;

    Boolean backClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo);

        intent = getIntent();
        values = getIntent().getIntArrayExtra(ListEtapas.EXTRA);

        setContent();
    }

    public void setContent(){
        TextView tx = (TextView) findViewById(R.id.titleContent);
        ImageView img = (ImageView) findViewById(R.id.bgTitle);

        RelativeLayout rel = (RelativeLayout) findViewById(R.id.barsView);

        tx.setText(Library.getText(values[0], values[1]));
        img.setImageResource(Library.getBg(values[0], values[1]));

        fillStatusBarGap();
        setBackBt();




    }


    public void fillStatusBarGap(){
        // setting status bar and navigation bar to translucent
        if (Build.VERSION.SDK_INT > 20) {
            Window window = getWindow();
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            // set status bar gap from translucent
            FrameLayout status = (FrameLayout) findViewById(R.id.statusBarGap);
            status.setMinimumHeight(getStatusBarHeight());
        }
    }

    // each resolution have different status bar height
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public void setBackBt(){
        ImageView back = (ImageView) findViewById(R.id.backBt);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backClicked = true;
                onPause();
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
        // navigate trough activity
        // has also navigateUpTo (Activity sourceActivity, Intent upIntent)
        if(backClicked) { NavUtils.navigateUpFromSameTask(this); }
    }
}
