package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class l {
    public static boolean aaW(String str) {
        AppMethodBeat.i(234647);
        boolean aaW = h.aaW(str);
        AppMethodBeat.o(234647);
        return aaW;
    }

    public static boolean f(c cVar) {
        return cVar instanceof f;
    }

    private static float dT(Context context) {
        AppMethodBeat.i(137848);
        float f2 = 0.0f;
        try {
            f2 = (float) Settings.System.getInt(context.getContentResolver(), "screen_brightness");
            f2 /= (float) bIT();
        } catch (Settings.SettingNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.VideoPlayerUtils", e2, "", new Object[0]);
        }
        AppMethodBeat.o(137848);
        return f2;
    }

    private static int bIT() {
        AppMethodBeat.i(234648);
        int i2 = 255;
        try {
            Resources system = Resources.getSystem();
            int identifier = system.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android");
            if (identifier != 0) {
                i2 = system.getInteger(identifier);
            }
            Log.d("MicroMsg.VideoPlayerUtils", "getMaxBrightness %d", Integer.valueOf(i2));
        } catch (Exception e2) {
            Log.i("MicroMsg.VideoPlayerUtils", "get max brightness fail, fallback to 255");
        }
        AppMethodBeat.o(234648);
        return i2;
    }

    public static float dV(Context context) {
        AppMethodBeat.i(137849);
        if (!(context instanceof Activity)) {
            AppMethodBeat.o(137849);
            return 1.0f;
        }
        WindowManager.LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
        if (attributes.screenBrightness < 0.0f) {
            float dT = dT(context);
            AppMethodBeat.o(137849);
            return dT;
        }
        float f2 = attributes.screenBrightness;
        AppMethodBeat.o(137849);
        return f2;
    }

    public static void b(Context context, float f2) {
        AppMethodBeat.i(234649);
        if (!(context instanceof Activity)) {
            AppMethodBeat.o(234649);
            return;
        }
        if (f2 < 0.01f) {
            f2 = 0.01f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        Activity activity = (Activity) context;
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = f2;
        activity.getWindow().setAttributes(attributes);
        AppMethodBeat.o(234649);
    }

    public static String AF(long j2) {
        String str;
        AppMethodBeat.i(137850);
        if (j2 < Util.MILLSECONDS_OF_HOUR) {
            str = "mm:ss";
        } else {
            str = "HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String format = simpleDateFormat.format(Long.valueOf(j2));
        AppMethodBeat.o(137850);
        return format;
    }
}
