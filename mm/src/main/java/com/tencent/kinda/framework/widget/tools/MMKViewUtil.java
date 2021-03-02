package com.tencent.kinda.framework.widget.tools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;

public class MMKViewUtil {
    private static final String TAG = "MMKViewUtil";
    private static float density = -1.0f;

    public static float dpToPx(Context context, float f2) {
        AppMethodBeat.i(19389);
        if (context == null) {
            Log.e(TAG, "DpToPx method parameter is illegal! context is null! stack: \n" + android.util.Log.getStackTraceString(new Throwable()));
            float f3 = 2.0f * f2;
            AppMethodBeat.o(19389);
            return f3;
        }
        float fromDPToPix = (float) BackwardSupportUtil.BitmapFactory.fromDPToPix(context, f2);
        AppMethodBeat.o(19389);
        return fromDPToPix;
    }

    public static float pxToDp(Context context, float f2) {
        AppMethodBeat.i(19390);
        if (context == null) {
            Log.e(TAG, "dpToPx method parameter is illegal! context is null! stack: \n" + android.util.Log.getStackTraceString(new Throwable()));
            float f3 = f2 / 2.0f;
            AppMethodBeat.o(19390);
            return f3;
        }
        float f4 = (160.0f * f2) / ((float) context.getResources().getDisplayMetrics().densityDpi);
        AppMethodBeat.o(19390);
        return f4;
    }

    public static int argbColor(long j2) {
        AppMethodBeat.i(19391);
        int argb = Color.argb((int) ((j2 >> 24) & 255), (int) ((j2 >> 16) & 255), (int) ((j2 >> 8) & 255), (int) (255 & j2));
        AppMethodBeat.o(19391);
        return argb;
    }

    @SuppressLint({"ResourceType"})
    public static void setId4KindaImplView(Context context, String str, View view) {
        AppMethodBeat.i(214575);
        int identifier = context.getResources().getIdentifier(str, "id", context.getPackageName());
        if (identifier > 0) {
            view.setId(identifier);
            Log.d(TAG, "setViewId has set rid: ".concat(String.valueOf(str)));
            AppMethodBeat.o(214575);
            return;
        }
        Log.d(TAG, "setViewId has not set rid: " + str + ", because no found res.");
        AppMethodBeat.o(214575);
    }
}
