package gejapao.promessa.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import gejapao.library.animation.GuillotineAnimation;
import gejapao.promessa.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    public final static String EXTRA = "hololo0";

    ImageView bg2, bt1, bt2, bt3, bt4, bt5, bt6;
    LinearLayout iconLin;
    RelativeLayout gRel;

    private static final long RIPPLE_DURATION = 250;

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    View guillotineMenu;

    @InjectView(R.id.root)
    FrameLayout root;

    @InjectView(R.id.content_hamburger)
    View contentHamburger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        ButterKnife.inject(this);

        setUI();
    }

    public void setUI(){
        // navigation bar
        if (Build.VERSION.SDK_INT > 20) {
            Window window = getWindow();
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }

        // custom toolbar
        if (toolbar != null) { setSupportActionBar(toolbar);
            if(getSupportActionBar() != null) {
                getSupportActionBar().setTitle(null);
            }}

        // set all views and click listeners
        setViews();

        // creating guillotine
        new GuillotineAnimation.GuillotineBuilder
                (guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build()
                .setLayoutToFade(iconLin, bg2);
    }

    //TODO button icon animation don't know a effect that would be nice

    public void setViews(){
        guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        root.addView(guillotineMenu);

        // views to fade
        gRel  = (RelativeLayout) findViewById(R.id.gRel);
        bg2 = (ImageView) findViewById(R.id.bg2);
        iconLin = (LinearLayout) findViewById(R.id.iconsLay);

        // icons
        bt1 = (ImageButton) findViewById(R.id.imageButton);
        bt2 = (ImageButton) findViewById(R.id.imageButton4);
        bt3 = (ImageButton) findViewById(R.id.imageButton2);
        bt4 = (ImageButton) findViewById(R.id.imageButton5);
        bt5 = (ImageButton) findViewById(R.id.imageButton3);
        bt6 = (ImageButton) findViewById(R.id.imageButton6);

        clickListeners();
    }

    public void clickListeners() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send(1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send(2);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send(3);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send(4);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send(5);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send(6);
            }
        });
    }

    public void send(int v){
        intent = new Intent(this, ListEtapas.class);
        intent.putExtra(EXTRA, v);
        startActivity(intent);
    }
}
