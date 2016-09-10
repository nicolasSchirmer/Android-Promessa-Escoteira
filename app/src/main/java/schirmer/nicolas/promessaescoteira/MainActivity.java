package schirmer.nicolas.promessaescoteira;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import schirmer.nicolas.promessaescoteira.GuillotineMenu.Animation.GuillotineAnimation;

public class MainActivity extends AppCompatActivity {

    // injeta views no guillotine
    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.root)
    FrameLayout root;

    @InjectView(R.id.content_hamburger)
    View contentHamburger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        setUI();
    }

    private void setUI(){
        // muda cor navigation bar
        if (Build.VERSION.SDK_INT > 20) {
            Window window = getWindow();
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }

        // set do guillotine menu
        View guillotineView =  LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        root.addView(guillotineView);


        // creating guillotine
        // TODO tentar resolver problema de animação
        new GuillotineAnimation.GuillotineBuilder
                (guillotineView, guillotineView.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(250)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build()
                .setLayoutToFade(findViewById(R.id.relativeRootMain), findViewById(R.id.bg2));

        // typeface
        TextView title = (TextView) findViewById(R.id.titleMain);
        title.setTypeface(FontCache.get("fonts/canaro_extra_bold.otf", this));
    }

    public void loboClick(View view){

    }

    public void escClick(View view){

    }

    public void senClick(View view){

    }

    public void pioClick(View view){

    }

    public void adClick(View view){

    }

    public void uebClick(View view){

    }
}
