package com.tencent.mm.bq;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.s;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.n.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    private static String JSi = "";
    private static String gLY = "";

    public static String apJ() {
        AppMethodBeat.i(116804);
        if (Util.isNullOrNil(gLY)) {
            gLY = com.tencent.mm.kernel.a.apK().getString("message_channel_id", "message_channel_new_id");
        }
        String str = gLY;
        AppMethodBeat.o(116804);
        return str;
    }

    public static void bcS(String str) {
        gLY = str;
    }

    public static String glD() {
        AppMethodBeat.i(116805);
        if (Util.isNullOrNil(JSi)) {
            JSi = com.tencent.mm.kernel.a.apK().getString("voip_notify_channel_new_id", "voip_notify_channel_new_id");
        }
        String str = JSi;
        AppMethodBeat.o(116805);
        return str;
    }

    public static int ezb() {
        if (Build.VERSION.SDK_INT < 19) {
            return R.drawable.cj7;
        }
        return R.drawable.cj8;
    }

    public static s.c cd(Context context, String str) {
        AppMethodBeat.i(116806);
        s.c cVar = new s.c(context, str);
        AppMethodBeat.o(116806);
        return cVar;
    }

    public static String glE() {
        boolean z;
        AppMethodBeat.i(116807);
        if (d.oD(26)) {
            Time time = new Time();
            time.setToNow();
            int i2 = time.hour;
            int i3 = time.minute;
            MMApplicationContext.getContext();
            if (!b.ct(i2, i3)) {
                Log.w("MicroMsg.NotificationHelper", "no shake & sound notification during background deactive time");
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(116807);
                return "message_dnd_mode_channel_id";
            }
        }
        String apJ = apJ();
        AppMethodBeat.o(116807);
        return apJ;
    }
}
