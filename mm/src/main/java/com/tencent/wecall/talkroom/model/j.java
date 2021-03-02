package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;

public final class j {
    public static boolean bru(String str) {
        AppMethodBeat.i(62717);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(62717);
            return false;
        }
        boolean startsWith = str.startsWith("client_");
        AppMethodBeat.o(62717);
        return startsWith;
    }

    public static int hrA() {
        int i2 = 0;
        AppMethodBeat.i(62718);
        try {
            i2 = a.hqJ().yvK;
            AppMethodBeat.o(62718);
        } catch (Exception e2) {
            b.w("tagorewang:VoiceGroupUtil", "getActiveRoomId err: ", e2);
            AppMethodBeat.o(62718);
        }
        return i2;
    }

    public static long hrB() {
        AppMethodBeat.i(62719);
        try {
            long j2 = a.hqJ().HgX;
            AppMethodBeat.o(62719);
            return j2;
        } catch (Exception e2) {
            b.w("tagorewang:VoiceGroupUtil", "getActiveRoomKey err: ", e2);
            AppMethodBeat.o(62719);
            return 0;
        }
    }
}
