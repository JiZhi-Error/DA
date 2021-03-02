package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.WebView;

@SuppressLint({"ViewConstructor"})
public final class aj extends ai {
    private bb nmX;
    private a nrP;
    private b nrQ;
    private boolean nrR = false;
    private LinearLayout nrS;
    private TextView nrT;
    private View nrU;
    private ImageView nrV;
    private ImageView nrW;
    private ImageView nrX;
    private final Runnable nrY = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.page.aj.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(135222);
            aj.this.nrS.setTranslationY((float) (-aj.this.nrS.getHeight()));
            AppMethodBeat.o(135222);
        }
    };
    private long nrZ = 0;

    public interface a {
        void bQy();
    }

    public interface b {
        void hK(int i2);
    }

    public aj(Context context, bb bbVar) {
        super(context);
        AppMethodBeat.i(135223);
        this.nmX = bbVar;
        this.nrS = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ex, (ViewGroup) this, false);
        LinearLayout linearLayout = this.nrS;
        View wrapperView = bbVar.getWrapperView();
        this.nrE = linearLayout;
        this.nrF = new FrameLayout(getContext());
        this.nrF.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.nrF.addView(linearLayout);
        this.nms = new FrameLayout(getContext());
        this.nms.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.nms.addView(wrapperView);
        addView(this.nrF);
        addView(this.nms);
        this.nrT = (TextView) findViewById(R.id.qe);
        this.nrU = findViewById(R.id.qa);
        this.nrV = (ImageView) findViewById(R.id.qb);
        this.nrW = (ImageView) findViewById(R.id.qc);
        this.nrX = (ImageView) findViewById(R.id.qd);
        AppMethodBeat.o(135223);
    }

    public final void setOnPullDownListener(a aVar) {
        this.nrP = aVar;
    }

    public final void setOnPullDownOffsetListener(b bVar) {
        this.nrQ = bVar;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(185197);
        super.onAttachedToWindow();
        post(this.nrY);
        AppMethodBeat.o(185197);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.ai
    public final void yM(int i2) {
        AppMethodBeat.i(135226);
        if (this.nrQ != null) {
            this.nrQ.hK(i2);
        }
        if (!this.nrR) {
            AppMethodBeat.o(135226);
            return;
        }
        removeCallbacks(this.nrY);
        if (i2 > this.nrS.getHeight()) {
            i2 = this.nrS.getHeight();
        }
        LinearLayout linearLayout = this.nrS;
        linearLayout.setTranslationY((float) (i2 - linearLayout.getHeight()));
        AppMethodBeat.o(135226);
    }

    public final void bRT() {
        AppMethodBeat.i(135227);
        long currentTimeMillis = System.currentTimeMillis() - this.nrZ;
        if (currentTimeMillis < 1000) {
            postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.page.aj.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(185196);
                    aj.this.bRQ();
                    AppMethodBeat.o(185196);
                }
            }, 1000 - currentTimeMillis);
            AppMethodBeat.o(135227);
            return;
        }
        bRQ();
        AppMethodBeat.o(135227);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.ai
    public final boolean MN() {
        AppMethodBeat.i(135228);
        boolean MN = this.nmX.MN();
        AppMethodBeat.o(135228);
        return MN;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.ai
    public final int getStayHeight() {
        AppMethodBeat.i(135229);
        int height = this.nrS.getHeight();
        AppMethodBeat.o(135229);
        return height;
    }

    public final void setHeadViewHeight(int i2) {
        AppMethodBeat.i(135230);
        if (i2 <= this.nrS.getHeight()) {
            AppMethodBeat.o(135230);
            return;
        }
        this.nrS.getLayoutParams().height = i2;
        this.nrS.requestLayout();
        AppMethodBeat.o(135230);
    }

    public final void cb(String str, int i2) {
        AppMethodBeat.i(135231);
        setBackgroundTextStyle(str);
        setPullDownBackgroundColor(i2);
        AppMethodBeat.o(135231);
    }

    public final void setBackgroundTextStyle(String str) {
        AppMethodBeat.i(135232);
        if ("light".equals(str)) {
            if (this.nrV == null) {
                Log.w("MicroMsg.AppBrandPullDownWebView", "setupLightLoading but mLoading0 is null, try protect");
            } else {
                this.nrV.setImageDrawable(g(-1, new float[]{0.2f, 0.6f, 0.4f, 0.2f}));
                this.nrW.setImageDrawable(g(-1, new float[]{0.2f, 0.2f, 0.6f, 0.4f}));
                this.nrX.setImageDrawable(g(-1, new float[]{0.2f, 0.4f, 0.2f, 0.6f}));
            }
            this.nrT.setTextColor(-1);
            this.nrT.setAlpha(0.4f);
            AppMethodBeat.o(135232);
            return;
        }
        if ("dark".equals(str) || !"ignore".equals(str)) {
            bRV();
            bRU();
        }
        AppMethodBeat.o(135232);
    }

    private void bRU() {
        AppMethodBeat.i(135234);
        this.nrT.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.nrT.setAlpha(0.2f);
        AppMethodBeat.o(135234);
    }

    public final void setPullDownText(String str) {
        AppMethodBeat.i(135235);
        if (Util.isNullOrNil(str)) {
            this.nrT.setVisibility(8);
            AppMethodBeat.o(135235);
            return;
        }
        this.nrT.setVisibility(0);
        this.nrT.setText(str);
        AppMethodBeat.o(135235);
    }

    public final void ij(boolean z) {
        AppMethodBeat.i(135236);
        this.nrR = z;
        setNeedStay(z);
        this.nrU.setVisibility(z ? 0 : 4);
        AppMethodBeat.o(135236);
    }

    private void bRV() {
        AppMethodBeat.i(135238);
        if (this.nrV == null) {
            Log.w("MicroMsg.AppBrandPullDownWebView", "setupDarkLoading but mLoading0 is null, try protect");
            AppMethodBeat.o(135238);
            return;
        }
        this.nrV.setImageDrawable(g(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.4f, 0.2f, 0.1f}));
        this.nrW.setImageDrawable(g(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.1f, 0.4f, 0.2f}));
        this.nrX.setImageDrawable(g(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.2f, 0.1f, 0.4f}));
        AppMethodBeat.o(135238);
    }

    private static AnimationDrawable g(int i2, float[] fArr) {
        AppMethodBeat.i(135239);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        Log.i("MicroMsg.AppBrandPullDownWebView", "AnimationDrawable hash:" + animationDrawable.hashCode());
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(n(i2, fArr[0]), 0);
        animationDrawable.addFrame(n(i2, fArr[1]), 300);
        animationDrawable.addFrame(n(i2, fArr[2]), 300);
        animationDrawable.addFrame(n(i2, fArr[3]), 300);
        AppMethodBeat.o(135239);
        return animationDrawable;
    }

    private static Drawable n(int i2, float f2) {
        AppMethodBeat.i(135240);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(i2);
        shapeDrawable.getPaint().setAlpha((int) (255.0f * f2));
        AppMethodBeat.o(135240);
        return shapeDrawable;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.ai
    public final void bRR() {
        AppMethodBeat.i(135224);
        if (this.nrV == null) {
            Log.e("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation, mLoading0 is null");
        } else {
            if (this.nrV.getDrawable() == null) {
                Log.w("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation but drawable is null, try protect");
                bRV();
                bRU();
            }
            ((AnimationDrawable) this.nrV.getDrawable()).start();
            ((AnimationDrawable) this.nrW.getDrawable()).start();
            ((AnimationDrawable) this.nrX.getDrawable()).start();
        }
        if (this.nrP != null) {
            this.nrP.bQy();
        }
        this.nrZ = System.currentTimeMillis();
        AppMethodBeat.o(135224);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.ai
    public final void bRS() {
        AppMethodBeat.i(135225);
        if (this.nrV == null || this.nrV.getDrawable() == null) {
            Log.w("MicroMsg.AppBrandPullDownWebView", "stopLoadingAnimation but drawable is null, try protect");
            AppMethodBeat.o(135225);
            return;
        }
        ((AnimationDrawable) this.nrV.getDrawable()).stop();
        ((AnimationDrawable) this.nrV.getDrawable()).selectDrawable(0);
        ((AnimationDrawable) this.nrW.getDrawable()).stop();
        ((AnimationDrawable) this.nrW.getDrawable()).selectDrawable(0);
        ((AnimationDrawable) this.nrX.getDrawable()).stop();
        ((AnimationDrawable) this.nrX.getDrawable()).selectDrawable(0);
        AppMethodBeat.o(135225);
    }
}
