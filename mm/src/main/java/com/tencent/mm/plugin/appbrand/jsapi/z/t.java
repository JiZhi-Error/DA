package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class t<C extends f> extends d<C> {
    public static final int CTRL_INDEX = 230;
    public static final String NAME = "vibrateShort";

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public void a(C c2, JSONObject jSONObject, int i2) {
        int i3;
        char c3;
        String str;
        int i4;
        AppMethodBeat.i(137690);
        Log.d("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort services!");
        if (c2.getAppState() != b.kQH) {
            c2.i(i2, h("fail:not allowed in background", null));
            AppMethodBeat.o(137690);
            return;
        }
        if (jSONObject == null) {
            i3 = -1;
        } else if (!jSONObject.has(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
            i3 = -1;
        } else {
            String optString = jSONObject.optString(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            if (!Util.isNullOrNil(optString)) {
                switch (optString.hashCode()) {
                    case -1078030475:
                        if (optString.equals(FirebaseAnalytics.b.MEDIUM)) {
                            c3 = 1;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 99152071:
                        if (optString.equals("heavy")) {
                            c3 = 2;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 102970646:
                        if (optString.equals("light")) {
                            c3 = 0;
                            break;
                        }
                        c3 = 65535;
                        break;
                    default:
                        c3 = 65535;
                        break;
                }
                switch (c3) {
                    case 0:
                        i3 = 1;
                        break;
                    case 1:
                        i3 = 2;
                        break;
                    case 2:
                        i3 = 3;
                        break;
                }
            }
            i3 = -2;
        }
        Log.d("MicroMsg.JsApiVibrateShort", "vibrationIntensity: ".concat(String.valueOf(i3)));
        try {
            Vibrator vibrator = (Vibrator) c2.getContext().getSystemService("vibrator");
            if (vibrator == null) {
                c2.i(i2, h("fail: vibrate is not support", null));
                AppMethodBeat.o(137690);
                return;
            }
            if (-2 == i3) {
                vibrator.vibrate(15);
                str = "fail: style is illegal";
            } else if (-1 == i3) {
                vibrator.vibrate(15);
                str = "ok";
            } else if (Build.VERSION.SDK_INT < 26 || !vibrator.hasAmplitudeControl()) {
                vibrator.vibrate(15);
                str = "fail: style is not support";
            } else {
                Log.d("MicroMsg.JsApiVibrateShort", "vibrateSupportAmplitude");
                switch (i3) {
                    case 1:
                        i4 = 128;
                        break;
                    case 2:
                        i4 = 192;
                        break;
                    case 3:
                        i4 = 255;
                        break;
                    default:
                        i4 = -1;
                        break;
                }
                if (-1 == i4) {
                    vibrator.vibrate(15);
                } else {
                    vibrator.vibrate(VibrationEffect.createOneShot(15, i4));
                }
                str = "ok";
            }
            c2.i(i2, h(str, null));
            AppMethodBeat.o(137690);
        } catch (Exception e2) {
            Log.w("MicroMsg.JsApiVibrateShort", "vibrateShort exception %s", e2.getMessage());
            c2.i(i2, h("fail: system internal error", null));
            AppMethodBeat.o(137690);
        }
    }
}
