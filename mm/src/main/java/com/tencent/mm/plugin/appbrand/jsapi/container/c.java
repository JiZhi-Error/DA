package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends d {
    public static final int CTRL_INDEX = 510;
    public static final String NAME = "updatePositioningContainer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean c(h hVar, int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(137514);
        if (!(view instanceof WrapperNativeContainerView)) {
            AppMethodBeat.o(137514);
            return false;
        }
        int a2 = g.a(jSONObject, "contentOffsetLeft", 0);
        int a3 = g.a(jSONObject, "contentOffsetTop", 0);
        int optInt = jSONObject.optInt("animate", 0);
        WrapperNativeContainerView wrapperNativeContainerView = (WrapperNativeContainerView) view;
        try {
            wrapperNativeContainerView.setVisibility(jSONObject.getBoolean("visible") ? 0 : 4);
        } catch (JSONException e2) {
        }
        final AppBrandNativeContainerView appBrandNativeContainerView = (AppBrandNativeContainerView) wrapperNativeContainerView.aB(AppBrandNativeContainerView.class);
        Log.i("MicroMsg.JsApiUpdatePositioningContainer", "scrollLeft:%d, scrollTop:%d, animation:%d", Integer.valueOf(a2), Integer.valueOf(a3), Integer.valueOf(optInt));
        if (optInt == 1) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(appBrandNativeContainerView, "x", appBrandNativeContainerView.getX(), (float) (-a2));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(appBrandNativeContainerView, "y", appBrandNativeContainerView.getY(), (float) (-a3));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.container.c.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(137509);
                    appBrandNativeContainerView.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    AppMethodBeat.o(137509);
                }
            });
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.container.c.AnonymousClass2 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(137510);
                    appBrandNativeContainerView.setY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    AppMethodBeat.o(137510);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(1000L);
            animatorSet.setInterpolator(new a(this));
            animatorSet.setTarget(appBrandNativeContainerView);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.start();
        } else {
            appBrandNativeContainerView.setX((float) (-a2));
            appBrandNativeContainerView.setY((float) (-a3));
        }
        int a4 = g.a(jSONObject, "innerHeight", appBrandNativeContainerView.getHeight());
        int a5 = g.a(jSONObject, "innerWidth", appBrandNativeContainerView.getWidth());
        Log.i("MicroMsg.JsApiUpdatePositioningContainer", "innerHeight:%d, innerWidth:%d", Integer.valueOf(a4), Integer.valueOf(a5));
        ViewGroup.LayoutParams layoutParams = appBrandNativeContainerView.getLayoutParams();
        layoutParams.height = a4;
        layoutParams.width = a5;
        appBrandNativeContainerView.setLayoutParams(layoutParams);
        AppMethodBeat.o(137514);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(137515);
        int i2 = jSONObject.getInt("containerId");
        AppMethodBeat.o(137515);
        return i2;
    }

    public class a implements Interpolator {
        private int lSG;
        private final PointF lSH;
        private final PointF lSI;
        protected PointF lSJ;
        protected PointF lSK;
        protected PointF lSL;
        protected PointF lSM;
        protected PointF lSN;

        private a(PointF pointF, PointF pointF2) {
            AppMethodBeat.i(137511);
            this.lSG = 0;
            this.lSH = new PointF();
            this.lSI = new PointF();
            this.lSL = new PointF();
            this.lSM = new PointF();
            this.lSN = new PointF();
            if (pointF.x < 0.0f || pointF.x > 1.0f) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("startX value must be in the range [0, 1]");
                AppMethodBeat.o(137511);
                throw illegalArgumentException;
            } else if (pointF2.x < 0.0f || pointF2.x > 1.0f) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("endX value must be in the range [0, 1]");
                AppMethodBeat.o(137511);
                throw illegalArgumentException2;
            } else {
                this.lSJ = pointF;
                this.lSK = pointF2;
                AppMethodBeat.o(137511);
            }
        }

        public a(c cVar) {
            this(new PointF(0.0f, 0.0f), new PointF(0.58f, 1.0f));
            AppMethodBeat.i(137512);
            AppMethodBeat.o(137512);
        }

        public final float getInterpolation(float f2) {
            AppMethodBeat.i(137513);
            float f3 = f2;
            for (int i2 = 1; i2 < 14; i2++) {
                this.lSN.x = this.lSJ.x * 3.0f;
                this.lSM.x = ((this.lSK.x - this.lSJ.x) * 3.0f) - this.lSN.x;
                this.lSL.x = (1.0f - this.lSN.x) - this.lSM.x;
                float f4 = ((this.lSN.x + ((this.lSM.x + (this.lSL.x * f3)) * f3)) * f3) - f2;
                if (((double) Math.abs(f4)) < 0.001d) {
                    break;
                }
                f3 -= f4 / (this.lSN.x + (((2.0f * this.lSM.x) + ((this.lSL.x * 3.0f) * f3)) * f3));
            }
            this.lSN.y = this.lSJ.y * 3.0f;
            this.lSM.y = ((this.lSK.y - this.lSJ.y) * 3.0f) - this.lSN.y;
            this.lSL.y = (1.0f - this.lSN.y) - this.lSM.y;
            float f5 = (this.lSN.y + ((this.lSM.y + (this.lSL.y * f3)) * f3)) * f3;
            AppMethodBeat.o(137513);
            return f5;
        }
    }
}
