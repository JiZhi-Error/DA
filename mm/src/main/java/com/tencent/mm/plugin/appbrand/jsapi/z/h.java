package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class h extends d {
    public static final int CTRL_INDEX = 232;
    public static final String NAME = "getScreenBrightness";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137667);
        Log.d("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness!");
        Context context = fVar.getContext();
        if (context == null) {
            fVar.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiGetScreenBrightness", "context is null, invoke fail!");
            AppMethodBeat.o(137667);
        } else if (!(context instanceof Activity)) {
            fVar.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiGetScreenBrightness", "context is not Activity, invoke fail!");
            AppMethodBeat.o(137667);
        } else {
            WindowManager.LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
            float f2 = attributes.screenBrightness;
            if (f2 < 0.0f) {
                f2 = dT(context);
            }
            Log.i("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness %f/%f", Float.valueOf(f2), Float.valueOf(attributes.screenBrightness));
            HashMap hashMap = new HashMap();
            hashMap.put("value", Float.valueOf(f2));
            fVar.i(i2, n("ok", hashMap));
            AppMethodBeat.o(137667);
        }
    }

    private static float dT(Context context) {
        AppMethodBeat.i(137668);
        float f2 = 0.0f;
        try {
            f2 = ((float) Settings.System.getInt(context.getContentResolver(), "screen_brightness")) / ((float) bIT());
        } catch (Settings.SettingNotFoundException e2) {
            Log.e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", e2.getMessage());
        } catch (IllegalArgumentException e3) {
            Log.e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent IllegalArgumentException: %s", e3.getMessage());
        } catch (Exception e4) {
            Log.e("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", e4.getMessage());
        }
        AppMethodBeat.o(137668);
        return f2;
    }

    private static int bIT() {
        AppMethodBeat.i(137669);
        int i2 = 255;
        try {
            Resources system = Resources.getSystem();
            int identifier = system.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android");
            if (identifier != 0) {
                i2 = system.getInteger(identifier);
            }
        } catch (Exception e2) {
            Log.i("MicroMsg.JsApiGetScreenBrightness", "get max brightness fail, fallback to 255");
        }
        AppMethodBeat.o(137669);
        return i2;
    }
}
