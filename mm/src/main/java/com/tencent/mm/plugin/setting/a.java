package com.tencent.mm.plugin.setting;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.wxmm.v2helper;

public final class a {
    public static int Xm(int i2) {
        switch (i2) {
            case 0:
                return JsApiAddDownloadTaskStraight.CTRL_INDEX;
            case 1:
            default:
                return 400;
            case 2:
            case 3:
                return v2helper.VOIP_ENC_HEIGHT_LV1;
            case 4:
            case 5:
            case 6:
            case 7:
                return 340;
        }
    }

    public static void g(Context context, float f2) {
        AppMethodBeat.i(256452);
        SharedPreferences.Editor edit = context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
        edit.putFloat("current_text_size_scale_key", f2);
        Log.i("MicroMsg.FontSizeService", "CURRENT_TEXT_SIZE_KEY put result: ".concat(String.valueOf(edit.commit())));
        AppMethodBeat.o(256452);
    }

    public static float gV(Context context) {
        float f2 = 1.0f;
        AppMethodBeat.i(256453);
        if (context != null) {
            f2 = context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", 1.0f);
        }
        AppMethodBeat.o(256453);
        return f2;
    }
}
