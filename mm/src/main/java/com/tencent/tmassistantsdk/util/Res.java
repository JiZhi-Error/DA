package com.tencent.tmassistantsdk.util;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class Res {
    private static final String TAG = "Res";
    protected final String RclassName = (this.ctx.getPackageName() + ".R");
    protected Context ctx;

    public Res(Context context) {
        AppMethodBeat.i(102524);
        this.ctx = context;
        AppMethodBeat.o(102524);
    }

    private int reflectResouce(String str, String str2) {
        AppMethodBeat.i(102525);
        if (this.RclassName == null || str == null || str2 == null) {
            AppMethodBeat.o(102525);
            return 0;
        }
        try {
            Class<?> cls = Class.forName(this.RclassName + "$" + str);
            int i2 = Util.getInt(cls.getField(str2).get(cls.newInstance()).toString(), -1);
            AppMethodBeat.o(102525);
            return i2;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102525);
            return -1;
        }
    }

    public int string(String str) {
        AppMethodBeat.i(102526);
        int reflectResouce = reflectResouce("string", str);
        AppMethodBeat.o(102526);
        return reflectResouce;
    }

    public int drawable(String str) {
        AppMethodBeat.i(102527);
        int reflectResouce = reflectResouce("drawable", str);
        AppMethodBeat.o(102527);
        return reflectResouce;
    }

    public int layout(String str) {
        AppMethodBeat.i(102528);
        int reflectResouce = reflectResouce("layout", str);
        AppMethodBeat.o(102528);
        return reflectResouce;
    }

    public int id(String str) {
        AppMethodBeat.i(102529);
        int reflectResouce = reflectResouce("id", str);
        AppMethodBeat.o(102529);
        return reflectResouce;
    }

    public int style(String str) {
        AppMethodBeat.i(102530);
        int reflectResouce = reflectResouce(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, str);
        AppMethodBeat.o(102530);
        return reflectResouce;
    }
}
