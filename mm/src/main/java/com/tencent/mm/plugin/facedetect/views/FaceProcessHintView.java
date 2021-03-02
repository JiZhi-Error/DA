package com.tencent.mm.plugin.facedetect.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;

public class FaceProcessHintView extends LinearLayout {
    private int acm;
    private h sWG;
    private Animation sWH;

    public FaceProcessHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceProcessHintView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(104182);
        this.sWG = null;
        this.acm = 0;
        this.sWH = null;
        setOrientation(0);
        setMinimumHeight(BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 36.0f));
        this.sWH = AnimationUtils.loadAnimation(context, R.anim.bf);
        this.sWH.setInterpolator(new AccelerateDecelerateInterpolator());
        AppMethodBeat.o(104182);
    }

    @SuppressLint({"SetTextI18n"})
    public void setDataAndInvalidate(h hVar) {
        AppMethodBeat.i(104183);
        this.sWG = hVar;
        if (this.sWG == null || this.sWG.sQS <= 0) {
            Log.e("MicroMsg.FaceProcessHintView", "hy: model invalid");
            AppMethodBeat.o(104183);
            return;
        }
        removeAllViews();
        for (int i2 = 0; i2 < this.sWG.sQS; i2++) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.a6c, (ViewGroup) null, false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            ((TextView) inflate.findViewById(R.id.bjh)).setText(String.valueOf(i2 + 1));
            addView(inflate, layoutParams);
        }
        getChildAt(getChildCount() - 1).findViewById(R.id.c_b).setVisibility(8);
        setCurrentProcessing(0);
        invalidate();
        AppMethodBeat.o(104183);
    }

    private void setCurrentProcessing(int i2) {
        AppMethodBeat.i(104184);
        TextView textView = (TextView) getChildAt(i2).findViewById(R.id.bjh);
        textView.setTextColor(getResources().getColor(R.color.afz));
        textView.setBackgroundResource(R.drawable.ui);
        AppMethodBeat.o(104184);
    }
}
