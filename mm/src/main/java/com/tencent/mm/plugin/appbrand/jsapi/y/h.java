package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.sdk.platformtools.Log;

public final class h {
    private static boolean mEnable = false;
    private static String mqI = "";
    private static String mqJ = "";
    private static g mqK = new g();
    private static ad.a mqL = ad.a.NONE;
    private static ad.a mqM = ad.a.NONE;

    static {
        AppMethodBeat.i(137644);
        AppMethodBeat.o(137644);
    }

    public static void A(f fVar) {
        AppMethodBeat.i(137640);
        mqI = fVar.getAppId();
        mEnable = true;
        mqK.h(fVar);
        if (mqM == ad.a.NONE || !mqJ.equalsIgnoreCase(mqI)) {
            mqM = ad.a.NONE;
        } else {
            mqK.b(mqM);
        }
        Log.i("MicroMsg.OrientationConfigListenerHelper", "init mJsAppid:" + mqI + "; mEnable:" + mEnable);
        AppMethodBeat.o(137640);
    }

    public static void B(f fVar) {
        AppMethodBeat.i(137641);
        if (fVar.getAppId().equalsIgnoreCase(mqI)) {
            Log.i("MicroMsg.OrientationConfigListenerHelper", "unInit mAppid:" + mqI);
            mqI = "";
            mEnable = false;
            mqM = ad.a.NONE;
        }
        AppMethodBeat.o(137641);
    }

    public static void a(Configuration configuration, String str) {
        AppMethodBeat.i(137642);
        if (configuration.orientation == 2) {
            if (mqL == ad.a.REVERSE_LANDSCAPE) {
                mqM = ad.a.REVERSE_LANDSCAPE;
            } else {
                mqM = ad.a.LANDSCAPE;
            }
        } else if (configuration.orientation == 1) {
            mqM = ad.a.PORTRAIT;
        } else {
            mqM = ad.a.NONE;
        }
        Log.i("MicroMsg.OrientationConfigListenerHelper", "onConfigurationChanged mAppid:" + mqI + "; appid:" + str + "; mOrientation:" + mqM.name());
        if (mqI.equalsIgnoreCase("") || !mqI.equalsIgnoreCase(str) || !mEnable) {
            mqJ = str;
            AppMethodBeat.o(137642);
            return;
        }
        mqK.b(mqM);
        AppMethodBeat.o(137642);
    }

    public static void c(ad.a aVar) {
        AppMethodBeat.i(137643);
        mqL = aVar;
        if (mEnable && mqM == ad.a.LANDSCAPE && (aVar == ad.a.REVERSE_LANDSCAPE || aVar == ad.a.LANDSCAPE)) {
            mqK.b(aVar);
            Log.i("MicroMsg.OrientationConfigListenerHelper", "onFourOrientationsChange mAppid:" + mqI + "; mOrientation:" + aVar.name());
        }
        AppMethodBeat.o(137643);
    }
}
