package com.tencent.mm.sdk.vendor;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class Oppo {
    private static final String TAG = "MicroMsg.Vendor.Oppo";
    public static Boolean _isUnDefaultFont = null;

    public static boolean oppohasCutOut(Context context) {
        AppMethodBeat.i(153482);
        if (context == null) {
            AppMethodBeat.o(153482);
            return false;
        }
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        AppMethodBeat.o(153482);
        return hasSystemFeature;
    }

    public static boolean isUnDefaultFont() {
        AppMethodBeat.i(153483);
        if (_isUnDefaultFont != null) {
            boolean booleanValue = _isUnDefaultFont.booleanValue();
            AppMethodBeat.o(153483);
            return booleanValue;
        }
        _isUnDefaultFont = Boolean.FALSE;
        try {
            Class<?> cls = Class.forName(Build.VERSION.SDK_INT > 29 ? "oplus.content.res.OplusFontUtils" : "oppo.content.res.OppoFontUtils");
            _isUnDefaultFont = Boolean.valueOf(cls.getField("isFlipFontUsed").getBoolean(cls));
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        if (_isUnDefaultFont != null) {
            boolean booleanValue2 = _isUnDefaultFont.booleanValue();
            AppMethodBeat.o(153483);
            return booleanValue2;
        }
        AppMethodBeat.o(153483);
        return false;
    }
}
