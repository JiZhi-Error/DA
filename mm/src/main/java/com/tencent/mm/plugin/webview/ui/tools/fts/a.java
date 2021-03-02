package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Array;

public class a {
    protected int JoK;
    protected int JoL;
    protected int JoM;
    protected View JoN;
    protected View JoO;
    protected View JoP;
    protected View JoQ;
    protected View JoR;
    protected View JoS;
    protected View JoT;
    protected float[][] JoU;
    protected float[] JoV;
    protected b JoW = b.Init;
    protected AbstractC1990a JoX;
    protected ValueAnimator.AnimatorUpdateListener JoY = new ValueAnimator.AnimatorUpdateListener() {
        /* class com.tencent.mm.plugin.webview.ui.tools.fts.a.AnonymousClass4 */

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(80732);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f2 = ((a.this.JoU[1][1] - a.this.JoU[1][0]) * floatValue) + a.this.JoU[1][0];
            float f3 = ((a.this.JoU[0][1] - a.this.JoU[0][0]) * floatValue) + a.this.JoU[0][0];
            a.this.JoN.setX(f2);
            a.this.JoN.setY(f3);
            a.this.nmd.setY(((a.this.JoV[1] - a.this.JoV[0]) * floatValue) + a.this.JoV[0]);
            a.this.nmd.setAlpha(1.0f - floatValue);
            a.this.JoN.setPadding((int) ((((float) (a.this.JoM - a.this.JoL)) * floatValue) + ((float) a.this.JoL)), 0, 0, 0);
            Log.v("MicroMsg.WebSearch.SosAnimatorBaseController", "searchBarView.paddingLeft %d value %f", Integer.valueOf(a.this.JoN.getPaddingLeft()), Float.valueOf(floatValue));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a.this.JoN.getLayoutParams();
            int i2 = (int) ((1.0f - floatValue) * ((float) a.this.zSm));
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            layoutParams.width = ((a.this.zSm - i2) * 2) + ((int) a.this.JoU[2][0]);
            a.this.JoN.setLayoutParams(layoutParams);
            AppMethodBeat.o(80732);
        }
    };
    protected ValueAnimator.AnimatorUpdateListener JoZ = new ValueAnimator.AnimatorUpdateListener() {
        /* class com.tencent.mm.plugin.webview.ui.tools.fts.a.AnonymousClass5 */

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(80733);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.JoN.setAlpha(floatValue);
            a.this.nmd.setAlpha(floatValue);
            a.this.JoN.setX(a.this.JoU[1][1]);
            a.this.JoN.setY(a.this.JoU[0][1]);
            a.this.nmd.setY(a.this.JoV[1]);
            a.this.JoN.setPadding((int) ((floatValue * ((float) (a.this.JoM - a.this.JoL))) + ((float) a.this.JoL)), 0, 0, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a.this.JoN.getLayoutParams();
            if (layoutParams.leftMargin != 0) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.width = ((int) a.this.JoU[2][0]) + (a.this.zSm * 2);
                a.this.JoN.setLayoutParams(layoutParams);
            }
            AppMethodBeat.o(80733);
        }
    };
    protected ValueAnimator.AnimatorUpdateListener Jpa = new ValueAnimator.AnimatorUpdateListener() {
        /* class com.tencent.mm.plugin.webview.ui.tools.fts.a.AnonymousClass6 */

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(80734);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f2 = ((a.this.JoU[1][0] - a.this.JoU[1][1]) * floatValue) + a.this.JoU[1][1];
            float f3 = ((a.this.JoU[0][0] - a.this.JoU[0][1]) * floatValue) + a.this.JoU[0][1];
            a.this.JoN.setX(f2);
            a.this.JoN.setY(f3);
            a.this.nmd.setY(((a.this.JoV[0] - a.this.JoV[1]) * floatValue) + a.this.JoV[1]);
            a.this.nmd.setAlpha(floatValue);
            a.this.JoN.setPadding((int) ((((float) (a.this.JoL - a.this.JoM)) * floatValue) + ((float) a.this.JoM)), 0, 0, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a.this.JoN.getLayoutParams();
            int i2 = (int) (floatValue * ((float) a.this.zSm));
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            layoutParams.width = ((a.this.zSm - i2) * 2) + ((int) a.this.JoU[2][0]);
            a.this.JoN.setLayoutParams(layoutParams);
            AppMethodBeat.o(80734);
        }
    };
    protected ValueAnimator.AnimatorUpdateListener Jpb = new ValueAnimator.AnimatorUpdateListener() {
        /* class com.tencent.mm.plugin.webview.ui.tools.fts.a.AnonymousClass7 */

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(211293);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (((double) Math.abs(floatValue - 1.0f)) <= 0.001d) {
                a.this.JoN.setX(a.this.JoU[1][0]);
                a.this.JoN.setY(a.this.JoU[0][0]);
                a.this.nmd.setY(a.this.JoV[0]);
                a.this.JoN.setPadding(0, 0, 0, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a.this.JoN.getLayoutParams();
                layoutParams.leftMargin = a.this.zSm;
                layoutParams.rightMargin = a.this.zSm;
                layoutParams.width = (int) a.this.JoU[2][0];
                a.this.JoN.setLayoutParams(layoutParams);
                a.this.JoN.setAlpha(1.0f);
                a.this.nmd.setAlpha(1.0f);
                AppMethodBeat.o(211293);
                return;
            }
            a.this.nmd.setAlpha(1.0f - floatValue);
            a.this.JoN.setAlpha(1.0f - floatValue);
            AppMethodBeat.o(211293);
        }
    };
    protected boolean isAnimating;
    protected View nmd;
    protected int zSh;
    protected int zSm;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.a$a  reason: collision with other inner class name */
    public interface AbstractC1990a {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public a(Context context, final View view, final View view2, View view3, View view4, View view5, View view6, final View view7, View view8) {
        AppMethodBeat.i(211295);
        this.zSm = com.tencent.mm.cb.a.fromDPToPix(context, 24);
        this.zSh = com.tencent.mm.cb.a.fromDPToPix(context, 14);
        this.JoU = (float[][]) Array.newInstance(Float.TYPE, 3, 2);
        this.JoV = new float[2];
        this.JoN = view;
        this.nmd = view2;
        this.JoO = view3;
        this.JoP = view4;
        this.JoQ = view5;
        this.JoR = view6;
        this.JoS = view7;
        this.JoT = view8;
        this.JoL = 0;
        this.JoM = this.zSm * 2;
        this.JoN.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(80729);
                a.this.JoU[0][0] = view.getY();
                a.this.JoU[0][1] = 0.0f;
                a.this.JoU[1][0] = view.getX();
                a.this.JoU[1][1] = 0.0f;
                a.this.JoU[2][0] = (float) view.getMeasuredWidth();
                a.this.JoU[2][1] = (float) (view.getMeasuredWidth() + (a.this.zSm * 2));
                float[][] fArr = a.this.JoU;
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < fArr.length; i2++) {
                    for (int i3 = 0; i3 < fArr[i2].length; i3++) {
                        stringBuffer.append(String.format("[%d,%d]: %.2f,", Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(fArr[i2][i3])));
                    }
                }
                Log.i("MicroMsg.WebSearch.SosAnimatorBaseController", "printArray:" + stringBuffer.toString());
                AppMethodBeat.o(80729);
            }
        }, 100);
        this.nmd.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(80730);
                a.this.JoV[0] = view2.getY();
                a.this.JoV[1] = view2.getY() - view.getY();
                float[] fArr = a.this.JoV;
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < fArr.length; i2++) {
                    stringBuffer.append(String.format("[%d]: %.2f,", Integer.valueOf(i2), Float.valueOf(fArr[i2])));
                }
                Log.i("MicroMsg.WebSearch.SosAnimatorBaseController", "printArray:" + stringBuffer.toString());
                AppMethodBeat.o(80730);
            }
        }, 150);
        this.JoS.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(211292);
                a.this.JoK = view7.getMeasuredHeight();
                AppMethodBeat.o(211292);
            }
        });
        AppMethodBeat.o(211295);
    }

    public final void agW(int i2) {
        this.JoU[0][0] = (float) i2;
    }

    public enum b {
        Init,
        Search;

        public static b valueOf(String str) {
            AppMethodBeat.i(80737);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(80737);
            return bVar;
        }

        static {
            AppMethodBeat.i(80738);
            AppMethodBeat.o(80738);
        }
    }

    public final void a(b bVar) {
        this.JoW = bVar;
    }

    public void b(b bVar) {
        AppMethodBeat.i(80740);
        if (bVar == this.JoW) {
            AppMethodBeat.o(80740);
            return;
        }
        switch (bVar) {
            case Init:
                gha();
                break;
            case Search:
                ghb();
                break;
        }
        this.JoW = bVar;
        AppMethodBeat.o(80740);
    }

    /* access modifiers changed from: protected */
    public void gha() {
    }

    /* access modifiers changed from: protected */
    public void ghb() {
    }

    public final void a(AbstractC1990a aVar) {
        this.JoX = aVar;
    }
}
