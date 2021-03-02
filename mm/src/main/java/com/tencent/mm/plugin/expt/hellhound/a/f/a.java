package com.tencent.mm.plugin.expt.hellhound.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.c;
import java.util.Iterator;

public final class a {
    static c<String, Integer> cPM() {
        AppMethodBeat.i(122041);
        String apk = b.apk("Chat_User");
        Log.d("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUI, userName: %s", apk);
        int aqi = aqi(apk);
        Log.i("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUI, chatType: %d", Integer.valueOf(aqi));
        c<String, Integer> Q = com.tencent.mm.vending.j.a.Q(apk, Integer.valueOf(aqi));
        AppMethodBeat.o(122041);
        return Q;
    }

    static c<String, Integer> cPN() {
        String str = null;
        AppMethodBeat.i(122042);
        cyi cNX = com.tencent.mm.plugin.expt.hellhound.core.b.b.c.cNX();
        if (cNX != null && !cNX.MDh.isEmpty()) {
            Iterator<cgh> it = cNX.MDh.iterator();
            cgh cgh = null;
            while (it.hasNext()) {
                cgh next = it.next();
                if (next == null || !"Chat_User".equals(next.key)) {
                    next = cgh;
                }
                cgh = next;
            }
            if (cgh != null) {
                str = cgh.value;
            }
        }
        Log.d("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUIFragment, userName: %s", str);
        int aqi = aqi(str);
        Log.i("HABBYGE-MALI.HellChattingType", "getParamsOfChattingUIFragment, chatType: %d", Integer.valueOf(aqi));
        c<String, Integer> Q = com.tencent.mm.vending.j.a.Q(str, Integer.valueOf(aqi));
        AppMethodBeat.o(122042);
        return Q;
    }

    private static int aqi(String str) {
        int i2;
        AppMethodBeat.i(122043);
        if (str == null) {
            AppMethodBeat.o(122043);
            return -1;
        }
        if (ab.Jx(str)) {
            i2 = 4;
        } else if (ab.JF(str) || ab.IJ(str)) {
            i2 = 5;
        } else if (str.startsWith("gh_")) {
            i2 = 2;
        } else if (ab.Eq(str)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        Log.i("HABBYGE-MALI.HellChattingType", "getChatType: %s, %d", str, Integer.valueOf(i2));
        AppMethodBeat.o(122043);
        return i2;
    }
}
