package gejapao.promessa.activity;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gejapao.promessa.List.CustomAdapter;
import gejapao.promessa.R;
import gejapao.promessa.List.itemRow;
import gejapao.promessa.widget.Library;


public class ListEtapas extends AppCompatActivity {

    public final static String EXTRA = "hololo02";

    //@InjectView(R.id.toolbar)
    Toolbar toolbar;
    LinearLayout lin;

    Boolean backClicked = false;

    ListView list;
    List<itemRow> rowItem;

    Intent intent;
    int value;

    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_etapas);

        // receiving from the other activity
        intent = getIntent();
        value = intent.getIntExtra(MainActivity.EXTRA, value);

        setUI();
    }

    public void setUI(){
        // custom toolbar
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if(getSupportActionBar() != null) {
                getSupportActionBar().setTitle(null);
            }
        }

        setViews();
        setBackBt();
        setUIparam();
    }

    public void setViews(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        lin = (LinearLayout) findViewById(R.id.rootListaLin);

        setListView();

        list = (ListView) findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(this, R.layout.etapa, rowItem);
        list.setAdapter(adapter);

        listClick();
    }

    // set itens to show in the list view
    public void setListView(){
        rowItem = new ArrayList<>();
        for (int i = 0; i < Library.getLength(value); i++) {
            itemRow item = new itemRow(
                    Library.getBg(value, i),
                    Library.getIcon(value, i),
                    Library.getText(value ,i));
            rowItem.add(item);
        }
    }

    public void listClick(){
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Item long" + (pos + 1) + ": " + rowItem.get(pos),
                        Toast.LENGTH_SHORT);
                toast.show();

                // put the value that list received and the position
                int[] values = {value, pos};
                send(values);
            }
        });
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


    public void setUIparam(){
        // get the color for UI
        int c = Library.wichColor(this, value);
        // get title for tool bar
        String t = Library.getTitleToolbar(this, value);


        // status bar and navigation bar
        if (Build.VERSION.SDK_INT > 20) {
            Window window = getWindow();
            window.setStatusBarColor(c);
            window.setNavigationBarColor(c);
        }

        // select font
        if(value == 6){ title = (TextView) findViewById(R.id.titlej); }
        else { title = (TextView) findViewById(R.id.title); }

        title.setText(t);
        title.setVisibility(View.VISIBLE);

        toolbar.setBackgroundColor(c);

        // the continuity of colors is very important
        if(haveNavBar()){
            lin.setBackgroundColor(c);
        } else {
            // gradient color, when scroll with too much force, show root lin
            // top will be the default color for each and bottom will be black
            // i did that because the effect was not good with only one solid color
            int[] colors = new int[]{c,0x000000};
            GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);

            lin.setBackgroundDrawable(gd);
        }
    }

    public Boolean haveNavBar(){
        boolean hasMenuKey = ViewConfiguration.get(this).hasPermanentMenuKey();
        boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);

        if(!hasMenuKey && !hasBackKey) {
            // if have buttons will assume that this device have a navigation bar
            // not having a proper way to do that is very frustrating
            return true;
        }
        return false;
    }

    public void send(int[] i){
        intent = new Intent(this, Conteudo.class);
        intent.putExtra(EXTRA, i);
        startActivity(intent);
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
