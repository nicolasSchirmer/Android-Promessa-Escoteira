package schirmer.nicolas.promessaescoteira.GuillotineMenu.Animation;

import android.view.View;
import android.view.animation.AlphaAnimation;


// Created by Nicolas

public class FadeAnimation {
    /**
     * FUCTIONS TO FADE IN AND OUT
     **/

    //view 1 is from the first layout
    View view1, view2;


    //alpha values
    float in = 1f, out = 0f;

    //int TimeInView2 = 150;

    public FadeAnimation setLayoutToFade(View v1, View v2){
        view1 = v1;
        view2 = v2;

        return this;
    }

    // 0 is time default otherwise is time custom
    // when guillotine menu opens
    final public void openMenu(){
        fadeIn(view2, 350);
        fadeOut(view1, 350);
    }

    // when guillotine menu close
    final public void closeMenu(){
        fadeOut(view2, 350);
        fadeIn(view1, 0);
    }

    public void fadeIn(View v, int t){
        if(t == 0){ t = 500; }

        AlphaAnimation anim = new AlphaAnimation(out, in);
        anim.setDuration(t);
        v.startAnimation(anim);
    }

    public void fadeOut(View v, int t){
        if(t == 0){ t = 600; }

        AlphaAnimation anim = new AlphaAnimation(in, out);
        anim.setDuration(t);
        v.startAnimation(anim);
    }
}