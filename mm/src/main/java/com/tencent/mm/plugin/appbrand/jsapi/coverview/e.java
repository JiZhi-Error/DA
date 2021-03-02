package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends d {
    public static final int CTRL_INDEX = 342;
    public static final String NAME = "animateCoverView";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(137519);
        int i2 = jSONObject.getInt("viewId");
        AppMethodBeat.o(137519);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean b(h hVar, int i2, final View view, JSONObject jSONObject, final i iVar) {
        int i3;
        AppMethodBeat.i(137520);
        int i4 = -1;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("finalStyle");
            float a2 = g.a(jSONObject2, "left", g.aS(view.getX()));
            float a3 = g.a(jSONObject2, "top", g.aS(view.getY()));
            float optDouble = (float) jSONObject2.optDouble("opacity", (double) view.getAlpha());
            float optDouble2 = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, (double) view.getRotation());
            float optDouble3 = (float) jSONObject2.optDouble("scaleX", (double) view.getScaleX());
            float optDouble4 = (float) jSONObject2.optDouble("scaleY", (double) view.getScaleY());
            if (jSONObject2.has("width")) {
                i3 = g.a(jSONObject2, "width", g.zC(view.getWidth()));
            } else {
                i3 = -1;
            }
            if (jSONObject2.has("height")) {
                i4 = g.a(jSONObject2, "height", g.zC(view.getWidth()));
            }
            int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 300);
            String optString = jSONObject.optString("easing", "linear");
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "x", view.getX(), a2);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "y", view.getY(), a3);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", view.getAlpha(), optDouble);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "rotation", view.getRotation(), optDouble2);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "scaleX", view.getScaleX(), optDouble3);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view, "scaleY", view.getScaleY(), optDouble4);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration((long) optInt);
            TimeInterpolator timeInterpolator = null;
            if (optString != null) {
                if (optString.equals("ease")) {
                    timeInterpolator = new AccelerateDecelerateInterpolator();
                } else if (optString.equals("ease-in")) {
                    timeInterpolator = new AccelerateInterpolator();
                } else if (optString.equals("ease-out")) {
                    timeInterpolator = new DecelerateInterpolator();
                }
            }
            if (timeInterpolator == null) {
                timeInterpolator = new LinearInterpolator();
            }
            animatorSet.setInterpolator(timeInterpolator);
            animatorSet.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.e.AnonymousClass1 */

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(137518);
                    iVar.ZA(e.this.h("ok", null));
                    AppMethodBeat.o(137518);
                }
            });
            ArrayList arrayList = new ArrayList();
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            arrayList.add(ofFloat4);
            arrayList.add(ofFloat5);
            arrayList.add(ofFloat6);
            if (i3 != -1) {
                ValueAnimator ofInt = ValueAnimator.ofInt(view.getWidth(), i3);
                arrayList.add(ofInt);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.e.AnonymousClass2 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(193665);
                        view.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        view.requestLayout();
                        AppMethodBeat.o(193665);
                    }
                });
            }
            if (i4 != -1) {
                ValueAnimator ofInt2 = ValueAnimator.ofInt(view.getHeight(), i4);
                arrayList.add(ofInt2);
                ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.coverview.e.AnonymousClass3 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(193666);
                        view.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        view.requestLayout();
                        AppMethodBeat.o(193666);
                    }
                });
            }
            animatorSet.playTogether(arrayList);
            animatorSet.start();
            AppMethodBeat.o(137520);
            return true;
        } catch (JSONException e2) {
            Log.w("MicroMsg.JsApiAnimateCoverView", "get finalStyle error : %s", android.util.Log.getStackTraceString(e2));
            iVar.ZA(h("fail:missing finalStyle", null));
            AppMethodBeat.o(137520);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean bEV() {
        return true;
    }
}
