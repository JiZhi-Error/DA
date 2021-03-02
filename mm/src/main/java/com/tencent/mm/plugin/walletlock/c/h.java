package com.tencent.mm.plugin.walletlock.c;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class h {
    private static long sessionId = -1;

    public static void jY(int i2, int i3) {
        int i4;
        AppMethodBeat.i(129934);
        switch (i3) {
            case 6:
                i4 = 5;
                break;
            case 1004:
                i4 = 6;
                break;
            case TXLiteAVCode.EVT_CAMERA_REMOVED:
                if (i2 != 3) {
                    i4 = -1;
                    break;
                } else {
                    i4 = 4;
                    break;
                }
            default:
                i4 = -1;
                break;
        }
        if (i4 != -1) {
            Log.i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock idkey report id: %d, key: %d, value: %d", 713, Integer.valueOf(i4), 1L);
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(713, (long) i4, 1, false);
        }
        AppMethodBeat.o(129934);
    }

    public static void yG(boolean z) {
        long j2;
        AppMethodBeat.i(129935);
        Log.i("MicroMsg.WalletLockReportManager", "alvinluo idkey fingerprint open result: %b", Boolean.valueOf(z));
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        if (z) {
            j2 = 0;
        } else {
            j2 = 1;
        }
        hVar.idkeyStat(713, j2, 1, false);
        AppMethodBeat.o(129935);
    }

    public static void fVw() {
        AppMethodBeat.i(129936);
        Log.i("MicroMsg.WalletLockReportManager", "alvinluo idkey report fingerprintlock verify by passwd success");
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(713, 2, 1, false);
        AppMethodBeat.o(129936);
    }

    public static void fVx() {
        AppMethodBeat.i(129937);
        Log.i("MicroMsg.WalletLockReportManager", "alvinluo idkey report close wallet lock success");
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(713, 3, 1, false);
        AppMethodBeat.o(129937);
    }

    public static void fVy() {
        AppMethodBeat.i(129938);
        sessionId = System.currentTimeMillis();
        Log.i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report create session: %d", Long.valueOf(sessionId));
        AppMethodBeat.o(129938);
    }

    public static void aJ(int i2, int i3, int i4) {
        AppMethodBeat.i(129939);
        if (sessionId == -1) {
            Log.e("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report sessionId is -1, not create session, ignore");
            AppMethodBeat.o(129939);
        } else if (i2 == -1) {
            AppMethodBeat.o(129939);
        } else {
            Log.i("MicroMsg.WalletLockReportManager", "alvinluo reportVerifyWalletLock session: %d, protectScene: %d, walletLockType: %d, result: %d", Long.valueOf(sessionId), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14839, Long.valueOf(sessionId), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            AppMethodBeat.o(129939);
        }
    }
}
