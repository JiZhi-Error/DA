package com.tencent.mm.plugin.webview.fts.c;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private static float dT(Context context) {
        AppMethodBeat.i(78159);
        float f2 = 0.0f;
        try {
            f2 = ((float) Settings.System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (Settings.SettingNotFoundException e2) {
            Log.e("MicroMsg.FTS.FtsVideoPlayerUtils", "ex %s", e2.getMessage());
        }
        AppMethodBeat.o(78159);
        return f2;
    }

    public static float dV(Context context) {
        AppMethodBeat.i(78160);
        WindowManager.LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
        if (attributes.screenBrightness < 0.0f) {
            float dT = dT(context);
            AppMethodBeat.o(78160);
            return dT;
        }
        float f2 = attributes.screenBrightness;
        AppMethodBeat.o(78160);
        return f2;
    }

    public static String AF(long j2) {
        String str;
        AppMethodBeat.i(78161);
        if (j2 < Util.MILLSECONDS_OF_HOUR) {
            str = "mm:ss";
        } else {
            str = "HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String format = simpleDateFormat.format(Long.valueOf(j2));
        AppMethodBeat.o(78161);
        return format;
    }

    public static float[] a(JSONObject jSONObject, Context context) {
        AppMethodBeat.i(78162);
        float[] fArr = new float[5];
        if (jSONObject.has("x")) {
            fArr[0] = (float) a.fromDPToPix(context, jSONObject.optInt("x"));
        } else {
            fArr[0] = Float.MAX_VALUE;
        }
        if (jSONObject.has("y")) {
            fArr[1] = (float) a.fromDPToPix(context, jSONObject.optInt("y"));
        } else {
            fArr[1] = Float.MAX_VALUE;
        }
        if (jSONObject.has("width")) {
            fArr[2] = (float) a.fromDPToPix(context, jSONObject.optInt("width"));
        } else {
            fArr[2] = Float.MAX_VALUE;
        }
        if (jSONObject.has("height")) {
            fArr[3] = (float) a.fromDPToPix(context, jSONObject.optInt("height"));
        } else {
            fArr[3] = Float.MAX_VALUE;
        }
        fArr[4] = 0.0f;
        AppMethodBeat.o(78162);
        return fArr;
    }

    public static int M(JSONObject jSONObject) {
        AppMethodBeat.i(78163);
        if (!jSONObject.has("visible")) {
            AppMethodBeat.o(78163);
            return Integer.MAX_VALUE;
        } else if (jSONObject.optBoolean("visible")) {
            AppMethodBeat.o(78163);
            return 0;
        } else {
            AppMethodBeat.o(78163);
            return 1;
        }
    }

    public static String bX(JSONObject jSONObject) {
        AppMethodBeat.i(78164);
        JSONArray optJSONArray = jSONObject.optJSONArray("playUrl");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            try {
                String string = optJSONArray.getString(0);
                AppMethodBeat.o(78164);
                return string;
            } catch (JSONException e2) {
                Log.e("MicroMsg.FTS.FtsVideoPlayerUtils", "ex %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(78164);
        return "";
    }
}
