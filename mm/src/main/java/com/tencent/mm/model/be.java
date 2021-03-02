package com.tencent.mm.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class be {
    public static void rY(int i2) {
        AppMethodBeat.i(150167);
        boolean apN = b.apN();
        boolean apP = b.apP();
        boolean apQ = b.apQ();
        boolean apR = b.apR();
        boolean apV = b.apV();
        boolean aqe = b.aqe();
        int aqf = b.aqf();
        int aqh = b.aqh();
        int aqg = b.aqg();
        int aqi = b.aqi();
        g.aAi();
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(73217, Boolean.TRUE)).booleanValue();
        g.aAi();
        boolean booleanValue2 = ((Boolean) g.aAh().azQ().get(73218, Boolean.TRUE)).booleanValue();
        boolean z = booleanValue || booleanValue2;
        Log.i("MicroMsg.KvNotificationStat", "doStatNotification, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, isNotificationShowDetail: %s, isNotificationSound: %s, isNotificationShake: %s, isActiveSilentTime: %s, activeBegin: %s, activeEnd: %s, scene: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", Boolean.valueOf(apN), Boolean.valueOf(apP), Boolean.valueOf(apQ), Boolean.valueOf(apR), Boolean.valueOf(apV), Boolean.valueOf(aqe), rZ(aqf) + rZ(aqh), rZ(aqg) + rZ(aqi), Integer.valueOf(i2), Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2), Boolean.valueOf(z));
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[10];
        objArr[0] = Integer.valueOf(apN ? 1 : 2);
        objArr[1] = Integer.valueOf(apP ? 1 : 2);
        objArr[2] = Integer.valueOf(apQ ? 1 : 2);
        objArr[3] = Integer.valueOf(apR ? 1 : 2);
        objArr[4] = Integer.valueOf(apV ? 1 : 2);
        objArr[5] = Integer.valueOf(aqe ? 2 : 1);
        objArr[6] = rZ(aqg) + rZ(aqi);
        objArr[7] = rZ(aqf) + rZ(aqh);
        objArr[8] = Integer.valueOf(i2);
        objArr[9] = Integer.valueOf(z ? 1 : 2);
        hVar.a(15308, objArr);
        AppMethodBeat.o(150167);
    }

    private static String rZ(int i2) {
        AppMethodBeat.i(150168);
        if (i2 > 10) {
            String valueOf = String.valueOf(i2);
            AppMethodBeat.o(150168);
            return valueOf;
        }
        String concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2));
        AppMethodBeat.o(150168);
        return concat;
    }

    public static void m(boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        int i5 = 2;
        AppMethodBeat.i(150169);
        boolean apN = b.apN();
        boolean apP = b.apP();
        g.aAi();
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(73217, Boolean.TRUE)).booleanValue();
        g.aAi();
        boolean booleanValue2 = ((Boolean) g.aAh().azQ().get(73218, Boolean.TRUE)).booleanValue();
        boolean z3 = booleanValue || booleanValue2;
        Log.i("MicroMsg.KvNotificationStat", "doStatSysNotificationAfterModify, switchNewMsg: %s, switchVoipInvite: %s, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(apN), Boolean.valueOf(apP), Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2), Boolean.valueOf(z3));
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[8];
        if (apN) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[0] = Integer.valueOf(i2);
        if (apP) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        objArr[1] = Integer.valueOf(i3);
        if (z3) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        objArr[2] = Integer.valueOf(i4);
        objArr[3] = 0;
        objArr[4] = Integer.valueOf(z ? apN ? 2 : 1 : 0);
        if (!z2) {
            i5 = 0;
        } else if (!apP) {
            i5 = 1;
        }
        objArr[5] = Integer.valueOf(i5);
        objArr[6] = 0;
        objArr[7] = 0;
        hVar.a(14852, objArr);
        AppMethodBeat.o(150169);
    }
}
