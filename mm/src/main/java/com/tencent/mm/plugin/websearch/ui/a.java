package com.tencent.mm.plugin.websearch.ui;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class a {
    public static float dV(Context context) {
        AppMethodBeat.i(110226);
        WindowManager.LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
        if (attributes.screenBrightness < 0.0f) {
            float dT = dT(context);
            AppMethodBeat.o(110226);
            return dT;
        }
        float f2 = attributes.screenBrightness;
        AppMethodBeat.o(110226);
        return f2;
    }

    private static float dT(Context context) {
        AppMethodBeat.i(110227);
        float f2 = 0.0f;
        try {
            f2 = ((float) Settings.System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (Exception e2) {
        }
        AppMethodBeat.o(110227);
        return f2;
    }

    public static String AF(long j2) {
        String str;
        AppMethodBeat.i(110228);
        if (j2 < Util.MILLSECONDS_OF_HOUR) {
            str = "mm:ss";
        } else {
            str = "HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String format = simpleDateFormat.format(Long.valueOf(j2));
        AppMethodBeat.o(110228);
        return format;
    }
}
