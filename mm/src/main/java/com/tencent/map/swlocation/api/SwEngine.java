package com.tencent.map.swlocation.api;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.b.a.a.q;
import com.b.a.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwEngine {
    public static void startContinousLocationUpdate(Handler handler, int i2, int i3, LocationUpdateListener locationUpdateListener, ServerMessageListener serverMessageListener) {
        AppMethodBeat.i(87876);
        t.a(handler, (long) i3, locationUpdateListener, serverMessageListener);
        AppMethodBeat.o(87876);
    }

    public static void stopContinousLocationUpdate() {
        AppMethodBeat.i(87877);
        t.Jt();
        AppMethodBeat.o(87877);
    }

    public static void creatLocationEngine(Context context, q qVar) {
        AppMethodBeat.i(87878);
        t.a(context, qVar);
        AppMethodBeat.o(87878);
    }

    public static void setImei(String str) {
        AppMethodBeat.i(87879);
        if (TextUtils.isEmpty(str)) {
            NullPointerException nullPointerException = new NullPointerException("SenseWhereEngine:invalid imei!");
            AppMethodBeat.o(87879);
            throw nullPointerException;
        }
        t.setImei(str);
        AppMethodBeat.o(87879);
    }

    public static void onDestroy() {
        AppMethodBeat.i(87880);
        t.finish();
        AppMethodBeat.o(87880);
    }
}
