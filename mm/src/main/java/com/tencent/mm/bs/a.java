package com.tencent.mm.bs;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<Integer, Integer> Kye = new HashMap();

    static {
        AppMethodBeat.i(32071);
        AppMethodBeat.o(32071);
    }

    public static void aiT(int i2) {
        AppMethodBeat.i(32068);
        Kye.put(Integer.valueOf(i2), Integer.valueOf(Util.nullAsNil(Kye.get(Integer.valueOf(i2))) + 1));
        AppMethodBeat.o(32068);
    }

    public static String gsY() {
        AppMethodBeat.i(32069);
        String str = "[a=" + (bg.aVF() == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1") + " ";
        if (bg.aVF() == null) {
            AppMethodBeat.o(32069);
            return str;
        }
        StringBuilder append = new StringBuilder().append(str).append("c=");
        bg.aVF();
        String str2 = append.append(c.azQ() == null ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1").append(" ").toString() + "u=" + (bg.aAc() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO) + "]";
        AppMethodBeat.o(32069);
        return str2;
    }

    public static void bfX(String str) {
        AppMethodBeat.i(32070);
        String str2 = str + gsY();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : Kye.entrySet()) {
            if (!(entry == null || entry.getKey() == null || entry.getValue() == null || entry.getValue().intValue() == 0)) {
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
                sb.append(',');
            }
        }
        Kye.clear();
        if (sb.length() > 0) {
            Log.d("MicroMsg.PostTaskFMessageCardStat", "append fmesage card click");
            cf.I(10, sb.toString());
        }
        Log.d("MicroMsg.PostTaskFMessageCardStat", "dkfm :".concat(String.valueOf(str2 + gsY())));
        try {
            bg.aVF();
            c.azQ().set(66819, Long.valueOf(Util.nowSecond()));
            AppMethodBeat.o(32070);
        } catch (Exception e2) {
            Log.e("MicroMsg.PostTaskFMessageCardStat", "e:" + e2.getMessage());
            AppMethodBeat.o(32070);
        }
    }

    public static void run() {
        boolean z;
        AppMethodBeat.i(32067);
        bg.aVF();
        if (Util.secondsToNow(Util.nullAs((Long) c.azQ().get(66819, (Object) null), 0)) * 1000 > 1800000) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            bfX("");
        }
        AppMethodBeat.o(32067);
    }
}
