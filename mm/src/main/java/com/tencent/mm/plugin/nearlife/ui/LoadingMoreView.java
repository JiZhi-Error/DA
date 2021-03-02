package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class LoadingMoreView extends LinearLayout {
    private Context context;
    private ImageView dPk = ((ImageView) findViewById(R.id.eb2));
    protected LinearLayout pXt;

    public LoadingMoreView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(26591);
        this.context = context2;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.azn, (ViewGroup) this, true);
        this.pXt = (LinearLayout) inflate.findViewById(R.id.epm);
        this.pXt.setVisibility(0);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.dPk.startAnimation(rotateAnimation);
        AppMethodBeat.o(26591);
    }
}
