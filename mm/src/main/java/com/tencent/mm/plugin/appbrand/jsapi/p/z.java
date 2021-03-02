package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.df;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class z extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 198;
    public static final String NAME = "setNavigationBarColor";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, final int i2) {
        final int i3;
        final String str;
        AppMethodBeat.i(138233);
        final com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        try {
            final int afE = g.afE(jSONObject.getString("frontColor"));
            final int afE2 = g.afE(jSONObject.getString("backgroundColor"));
            final double optDouble = jSONObject.optDouble("alpha", 1.0d);
            JSONObject optJSONObject = jSONObject.optJSONObject("animation");
            if (optJSONObject != null) {
                i3 = optJSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                str = optJSONObject.optString("timingFunc");
            } else {
                i3 = 0;
                str = "";
            }
            AnonymousClass1 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.p.z.AnonymousClass1 */

                public final void run() {
                    TimeInterpolator timeInterpolator = null;
                    AppMethodBeat.i(138232);
                    final ac i2 = df.i(dVar2);
                    if (i2 == null) {
                        dVar2.i(i2, z.this.h("fail:page don't exist", null));
                        AppMethodBeat.o(138232);
                    } else if (!i2.isRunning()) {
                        AppMethodBeat.o(138232);
                    } else {
                        int backgroundColor = i2.bRi().getBackgroundColor();
                        int foregroundColor = i2.bRi().getForegroundColor();
                        double backgroundAlpha = i2.bRi().getBackgroundAlpha();
                        if ("linear".equals(str)) {
                            timeInterpolator = new LinearInterpolator();
                        } else if ("easeIn".equals(str)) {
                            timeInterpolator = new AccelerateInterpolator();
                        } else if ("easeOut".equals(str)) {
                            timeInterpolator = new DecelerateInterpolator();
                        } else if ("easeInOut".equals(str)) {
                            timeInterpolator = new AccelerateDecelerateInterpolator();
                        }
                        ValueAnimator valueAnimator = new ValueAnimator();
                        valueAnimator.setIntValues(backgroundColor, afE2);
                        valueAnimator.setEvaluator(new ArgbEvaluator());
                        valueAnimator.setDuration((long) i3);
                        valueAnimator.setInterpolator(timeInterpolator);
                        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.p.z.AnonymousClass1.AnonymousClass1 */

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AppMethodBeat.i(138229);
                                i2.wz(((Integer) valueAnimator.getAnimatedValue()).intValue());
                                AppMethodBeat.o(138229);
                            }
                        });
                        ValueAnimator valueAnimator2 = new ValueAnimator();
                        valueAnimator2.setIntValues(foregroundColor, afE);
                        valueAnimator2.setEvaluator(new ArgbEvaluator());
                        valueAnimator2.setDuration((long) i3);
                        valueAnimator2.setInterpolator(timeInterpolator);
                        valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.p.z.AnonymousClass1.AnonymousClass2 */

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AppMethodBeat.i(138230);
                                i2.wA(((Integer) valueAnimator.getAnimatedValue()).intValue());
                                AppMethodBeat.o(138230);
                            }
                        });
                        ValueAnimator valueAnimator3 = new ValueAnimator();
                        valueAnimator3.setFloatValues((float) backgroundAlpha, (float) optDouble);
                        valueAnimator3.setDuration((long) i3);
                        valueAnimator3.setInterpolator(timeInterpolator);
                        valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.p.z.AnonymousClass1.AnonymousClass3 */

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AppMethodBeat.i(138231);
                                i2.s((double) ((Float) valueAnimator.getAnimatedValue()).floatValue());
                                AppMethodBeat.o(138231);
                            }
                        });
                        valueAnimator.start();
                        valueAnimator2.start();
                        AppMethodBeat.o(138232);
                    }
                }
            };
            if ((dVar2 instanceof ac) || !dVar2.getRuntime().bry()) {
                dVar2.P(r0);
            } else {
                dVar2.getRuntime().O(r0);
            }
            dVar2.i(i2, h("ok", null));
            AppMethodBeat.o(138233);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiSetNavigationBarColor", "Color parse error");
            dVar2.i(i2, h("fail:invalid color", null));
            AppMethodBeat.o(138233);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }
}
