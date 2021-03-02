package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.plugin.ball.b.c;
import com.tencent.mm.plugin.ball.f.e;

public class FloatIndicatorView extends FrameLayout {
    private Vibrator paT;
    private ImageView pcg;
    private ImageView pch;
    private TextView pci;
    private c pcj;
    private Animator pck;
    private Animator pcl;
    private a pcm;
    private boolean pcn;

    public interface a {
        void jY(boolean z);
    }

    public FloatIndicatorView(Context context) {
        this(context, null);
    }

    public FloatIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatIndicatorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(106480);
        View.inflate(context, R.layout.ayp, this);
        this.pcg = (ImageView) findViewById(R.id.y2);
        this.pch = (ImageView) findViewById(R.id.dxv);
        this.pci = (TextView) findViewById(R.id.dxw);
        this.paT = (Vibrator) context.getSystemService("vibrator");
        this.pcj = new c(this);
        float f2 = e.oYQ;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.pcg, "scaleX", f2, 1.0f);
        ofFloat.setDuration(200L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.pcg, "scaleY", f2, 1.0f);
        ofFloat2.setDuration(200L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.pck = animatorSet;
        float f3 = e.oYQ;
        AnimatorSet animatorSet2 = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.pcg, "scaleX", 1.0f, f3);
        ofFloat3.setDuration(200L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.pcg, "scaleY", 1.0f, f3);
        ofFloat4.setDuration(200L);
        animatorSet2.playTogether(ofFloat3, ofFloat4);
        this.pcl = animatorSet2;
        AppMethodBeat.o(106480);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(106481);
        super.onConfigurationChanged(configuration);
        if (!(this.pcm == null || configuration == null)) {
            this.pcm.jY(configuration.orientation == 2);
        }
        AppMethodBeat.o(106481);
    }

    public final void CC(int i2) {
        AppMethodBeat.i(106482);
        if (i2 >= 5) {
            b.i("MicroMsg.FloatIndicatorView", "onFloatBallInfoCountChanged, float ball full, count:%s", Integer.valueOf(i2));
            this.pcn = true;
            this.pci.setText(R.string.dcy);
            this.pci.setTextColor(android.support.v4.content.b.n(getContext(), R.color.r9));
            this.pcg.setImageResource(R.drawable.es);
            this.pch.setImageDrawable(com.tencent.mm.svg.a.a.h(getResources(), R.raw.float_indicator_full_icon));
            AppMethodBeat.o(106482);
            return;
        }
        b.i("MicroMsg.FloatIndicatorView", "onFloatBallInfoCountChanged, float ball not full, count:%s", Integer.valueOf(i2));
        this.pcn = false;
        this.pci.setText(R.string.bwz);
        this.pci.setTextColor(android.support.v4.content.b.n(getContext(), R.color.r_));
        this.pcg.setImageResource(R.drawable.et);
        this.pch.setImageDrawable(com.tencent.mm.svg.a.a.h(getResources(), R.raw.float_indicator_icon));
        AppMethodBeat.o(106482);
    }

    public void setOnOrientationChangedListener(a aVar) {
        this.pcm = aVar;
    }
}
