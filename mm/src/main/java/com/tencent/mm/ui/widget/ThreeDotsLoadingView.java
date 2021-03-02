package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.WebView;

public class ThreeDotsLoadingView extends FrameLayout {
    private static int QFh = WebView.NIGHT_MODE_COLOR;
    private boolean FR = false;
    private int QFi = QFh;
    private boolean QFj = false;
    private ViewGroup QFk;
    private ImageView QFl;
    private ImageView QFm;
    private ImageView QFn;
    private final Runnable QFo = new Runnable() {
        /* class com.tencent.mm.ui.widget.ThreeDotsLoadingView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(131602);
            ThreeDotsLoadingView.a(ThreeDotsLoadingView.this);
            ((AnimationDrawable) ThreeDotsLoadingView.this.QFl.getDrawable()).start();
            ((AnimationDrawable) ThreeDotsLoadingView.this.QFm.getDrawable()).start();
            ((AnimationDrawable) ThreeDotsLoadingView.this.QFn.getDrawable()).start();
            AppMethodBeat.o(131602);
        }
    };

    public ThreeDotsLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(131603);
        init(context, attributeSet);
        AppMethodBeat.o(131603);
    }

    public ThreeDotsLoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(131604);
        init(context, attributeSet);
        AppMethodBeat.o(131604);
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(131605);
        this.QFk = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.azb, (ViewGroup) this, true);
        QFh = context.getResources().getColor(R.color.fo);
        this.QFi = QFh;
        this.QFl = (ImageView) this.QFk.findViewById(R.id.epc);
        this.QFm = (ImageView) this.QFk.findViewById(R.id.epd);
        this.QFn = (ImageView) this.QFk.findViewById(R.id.epe);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.a.ThreeDotsLoadingView);
            this.QFi = obtainStyledAttributes.getColor(0, QFh);
            obtainStyledAttributes.recycle();
        }
        gZj();
        AppMethodBeat.o(131605);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(131606);
        if (8 == i2 || 4 == i2) {
            gZi();
        }
        super.setVisibility(i2);
        AppMethodBeat.o(131606);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(131607);
        super.onAttachedToWindow();
        if (this.QFj) {
            this.QFj = false;
            gZh();
        }
        AppMethodBeat.o(131607);
    }

    public void setAlpha(float f2) {
        AppMethodBeat.i(131608);
        this.QFl.setAlpha(f2);
        this.QFm.setAlpha(f2);
        this.QFn.setAlpha(f2);
        if (getBackground() != null) {
            getBackground().setAlpha(Math.round(255.0f * f2));
        }
        AppMethodBeat.o(131608);
    }

    public final void gZh() {
        AppMethodBeat.i(131609);
        if (!u.aD(this)) {
            this.QFj = true;
            AppMethodBeat.o(131609);
        } else if (this.FR) {
            AppMethodBeat.o(131609);
        } else {
            this.FR = true;
            gZj();
            postDelayed(this.QFo, 300);
            AppMethodBeat.o(131609);
        }
    }

    public final void gZi() {
        AppMethodBeat.i(131610);
        this.QFj = false;
        if (!this.FR) {
            AppMethodBeat.o(131610);
            return;
        }
        this.FR = false;
        removeCallbacks(this.QFo);
        if (this.QFl.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) this.QFl.getDrawable()).stop();
            ((AnimationDrawable) this.QFm.getDrawable()).stop();
            ((AnimationDrawable) this.QFn.getDrawable()).stop();
        }
        AppMethodBeat.o(131610);
    }

    private void gZj() {
        AppMethodBeat.i(131611);
        this.QFl.setImageDrawable(n(this.QFi, 0.5f));
        this.QFm.setImageDrawable(n(this.QFi, 0.4f));
        this.QFn.setImageDrawable(n(this.QFi, 0.3f));
        AppMethodBeat.o(131611);
    }

    private static AnimationDrawable g(int i2, float[] fArr) {
        AppMethodBeat.i(131612);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        Log.i("ThreeDotsLoadingView", "AnimationDrawable hash:" + animationDrawable.hashCode());
        animationDrawable.setOneShot(false);
        for (int i3 = 0; i3 < 3; i3++) {
            animationDrawable.addFrame(n(i2, fArr[i3]), 300);
        }
        AppMethodBeat.o(131612);
        return animationDrawable;
    }

    private static Drawable n(int i2, float f2) {
        AppMethodBeat.i(131613);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(i2);
        shapeDrawable.getPaint().setAlpha((int) (255.0f * f2));
        AppMethodBeat.o(131613);
        return shapeDrawable;
    }

    static /* synthetic */ void a(ThreeDotsLoadingView threeDotsLoadingView) {
        AppMethodBeat.i(131614);
        threeDotsLoadingView.QFl.setImageDrawable(g(threeDotsLoadingView.QFi, new float[]{0.4f, 0.3f, 0.5f}));
        threeDotsLoadingView.QFm.setImageDrawable(g(threeDotsLoadingView.QFi, new float[]{0.5f, 0.4f, 0.3f}));
        threeDotsLoadingView.QFn.setImageDrawable(g(threeDotsLoadingView.QFi, new float[]{0.3f, 0.5f, 0.4f}));
        AppMethodBeat.o(131614);
    }
}
