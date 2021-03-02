package com.tencent.mm.modelstat;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.appbrand.jsapi.p.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.TrafficStats;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public final class n {
    static {
        AppMethodBeat.i(151110);
        if (Build.VERSION.SDK_INT >= 28) {
            TrafficStats.reset(MMApplicationContext.getContext());
            AppMethodBeat.o(151110);
            return;
        }
        TrafficStats.reset();
        AppMethodBeat.o(151110);
    }

    public static void D(long j2, long j3) {
        AppMethodBeat.i(177294);
        if (ag.dm(MMApplicationContext.getContext())) {
            Log.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", Long.valueOf(j2), Long.valueOf(j3), 0);
            b(j2, j3, 0);
            AppMethodBeat.o(177294);
            return;
        }
        Log.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", Long.valueOf(j2), Long.valueOf(j3), 0);
        c(j2, j3, 0);
        AppMethodBeat.o(177294);
    }

    public static void b(long j2, long j3, int i2) {
        AppMethodBeat.i(177295);
        k kVar = new k();
        kVar.joq = j2;
        kVar.joC = j3;
        kVar.cSx = 12585984;
        c(kVar);
        a(kVar, i2);
        q.bgo().a(kVar);
        AppMethodBeat.o(177295);
    }

    public static void c(long j2, long j3, int i2) {
        AppMethodBeat.i(177296);
        k kVar = new k();
        kVar.jop = j2;
        kVar.joB = j3;
        kVar.cSx = 12585984;
        c(kVar);
        a(kVar, i2);
        q.bgo().a(kVar);
        AppMethodBeat.o(177296);
    }

    private static void c(k kVar) {
        AppMethodBeat.i(151109);
        if (Build.VERSION.SDK_INT >= 28) {
            TrafficStats.updateNsm(MMApplicationContext.getContext());
        } else {
            TrafficStats.update();
        }
        kVar.jor = TrafficStats.getMobileRx(0);
        kVar.joD = TrafficStats.getMobileTx(0);
        kVar.jos = TrafficStats.getWifiRx(0);
        kVar.joE = TrafficStats.getWifiTx(0);
        kVar.joF = TrafficStats.getWxMobileRx(0);
        kVar.joH = TrafficStats.getWxMobileTx(0);
        kVar.joG = TrafficStats.getWxWifiRx(0);
        kVar.joI = TrafficStats.getWxWifiTx(0);
        kVar.cSx = kVar.cSx | 8192 | TPMediaCodecProfileLevel.HEVCHighTierLevel62 | 4096 | TPMediaCodecProfileLevel.HEVCMainTierLevel62 | 134217728 | 536870912 | 67108864 | 268435456;
        AppMethodBeat.o(151109);
    }

    private static void a(k kVar, int i2) {
        switch (i2) {
            case 109:
            case 123:
                kVar.jok = kVar.jop + kVar.joq;
                kVar.cSx |= 32;
                return;
            case 110:
                kVar.jow = kVar.joB + kVar.joC;
                kVar.cSx |= 131072;
                return;
            case TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH /*{ENCODED_INT: 127}*/:
                kVar.joy = kVar.joB + kVar.joC;
                kVar.cSx |= 524288;
                return;
            case 128:
                kVar.jom = kVar.jop + kVar.joq;
                kVar.cSx |= 128;
                return;
            case 138:
            case b.CTRL_INDEX /*{ENCODED_INT: 139}*/:
                kVar.joi = kVar.jop + kVar.joq;
                kVar.cSx |= 8;
                return;
            case 149:
                kVar.joA = kVar.joB + kVar.joC;
                kVar.cSx |= TPMediaCodecProfileLevel.HEVCHighTierLevel6;
                return;
            case 150:
                kVar.joo = kVar.jop + kVar.joq;
                kVar.cSx |= 512;
                return;
            case 522:
                kVar.jou = kVar.joB + kVar.joC;
                kVar.cSx |= 32768;
                return;
            default:
                return;
        }
    }
}
