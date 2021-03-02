package com.tencent.mm.ui.widget.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;

public class ViewTitleWithAnimation extends LinearLayout {
    private TextView Dym;
    private ImageView QFI;
    private TextView QFJ;
    private ImageView QFK;
    private TextView QFL;
    private View QFM;
    private TextView ayz;
    private ViewGroup zhm;

    public ViewTitleWithAnimation(Context context) {
        super(context);
        AppMethodBeat.i(143504);
        bh(context);
        AppMethodBeat.o(143504);
    }

    public ViewTitleWithAnimation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143505);
        bh(context);
        AppMethodBeat.o(143505);
    }

    public ViewTitleWithAnimation(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143506);
        bh(context);
        AppMethodBeat.o(143506);
    }

    private void bh(Context context) {
        AppMethodBeat.i(143507);
        LayoutInflater.from(context).inflate(R.layout.lc, this);
        this.ayz = (TextView) findViewById(R.id.iyx);
        this.QFM = findViewById(R.id.isv);
        this.QFI = (ImageView) findViewById(R.id.e4p);
        this.Dym = (TextView) findViewById(R.id.iyo);
        this.QFJ = (TextView) findViewById(R.id.ixd);
        this.QFK = (ImageView) findViewById(R.id.e4r);
        this.QFL = (TextView) findViewById(R.id.ixe);
        this.zhm = (ViewGroup) findViewById(R.id.e9u);
        AppMethodBeat.o(143507);
    }

    public ImageView getIconImageView() {
        return this.QFI;
    }

    public void setTitle(String str) {
        AppMethodBeat.i(143508);
        this.ayz.setText(str);
        AppMethodBeat.o(143508);
    }

    public void setSubTitle(String str) {
        AppMethodBeat.i(143509);
        this.Dym.setText(str);
        AppMethodBeat.o(143509);
    }

    public void setCompanyText(String str) {
        AppMethodBeat.i(143510);
        if (!Util.isNullOrNil(str)) {
            this.QFJ.setVisibility(0);
            this.QFJ.setText(str);
            AppMethodBeat.o(143510);
            return;
        }
        this.QFJ.setVisibility(8);
        AppMethodBeat.o(143510);
    }

    public void setTopPaddingVisibility(int i2) {
        AppMethodBeat.i(175969);
        this.QFM.setVisibility(i2);
        AppMethodBeat.o(175969);
    }

    public final void gZm() {
        AppMethodBeat.i(143511);
        this.zhm.setVisibility(4);
        this.QFL.setVisibility(0);
        AppMethodBeat.o(143511);
    }

    public final void startLoading() {
        AppMethodBeat.i(143512);
        this.QFK.clearAnimation();
        this.ayz.setVisibility(8);
        this.QFJ.setVisibility(8);
        this.QFI.setVisibility(8);
        this.QFK.setVisibility(0);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.QFK.startAnimation(rotateAnimation);
        AppMethodBeat.o(143512);
    }

    public final void hideLoading() {
        AppMethodBeat.i(143513);
        this.QFK.clearAnimation();
        this.QFK.setVisibility(8);
        this.ayz.setVisibility(0);
        this.QFI.setVisibility(0);
        this.QFJ.setVisibility(0);
        AppMethodBeat.o(143513);
    }
}
