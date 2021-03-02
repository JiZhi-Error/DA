package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class g {
    static long endTime;
    static long oPR;
    static long oPS;
    static long startTime;
    private SimpleDateFormat oMZ = new SimpleDateFormat("yyyyMMdd");
    MTimerHandler oPT;

    public g() {
        AppMethodBeat.i(21726);
        AppMethodBeat.o(21726);
    }

    static void init() {
        startTime = 0;
        endTime = 0;
        oPR = 0;
        oPS = 0;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final void a(int i2, long j2, long j3, boolean z) {
        AppMethodBeat.i(21727);
        if (j3 == 0) {
            Log.e("MicroMsg.BackupLogManager", "reportKv logSize is 0, skip report");
            AppMethodBeat.o(21727);
            return;
        }
        long j4 = j3 / (j2 / 1000);
        Log.i("MicroMsg.BackupLogManager", "reportKv, backupMode[%d], time[%d ms], logSize[%d KB], aveLogSize[%d B/s]", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        switch (i2) {
            case 11:
                if (!z) {
                    h.INSTANCE.idkeyStat(400, 81, j3 / 1024, false);
                    if (j2 != 0) {
                        h.INSTANCE.idkeyStat(400, 82, j4, false);
                    }
                    Bq(i2);
                    AppMethodBeat.o(21727);
                    return;
                }
                h.INSTANCE.idkeyStat(400, 83, j3 / 1024, false);
                AppMethodBeat.o(21727);
                return;
            case 12:
                if (!z) {
                    h.INSTANCE.idkeyStat(400, 86, j3 / 1024, false);
                    if (j2 != 0) {
                        h.INSTANCE.idkeyStat(400, 87, j4, false);
                    }
                    Bq(i2);
                    AppMethodBeat.o(21727);
                    return;
                }
                h.INSTANCE.idkeyStat(400, 88, j3 / 1024, false);
                AppMethodBeat.o(21727);
                return;
            case 21:
                if (!z) {
                    h.INSTANCE.idkeyStat(485, 91, j3 / 1024, false);
                    if (j2 != 0) {
                        h.INSTANCE.idkeyStat(485, 92, j4, false);
                    }
                    Bq(i2);
                    AppMethodBeat.o(21727);
                    return;
                }
                h.INSTANCE.idkeyStat(485, 93, j3 / 1024, false);
                AppMethodBeat.o(21727);
                return;
            case 22:
                if (z) {
                    h.INSTANCE.idkeyStat(485, 98, j3 / 1024, false);
                    break;
                } else {
                    h.INSTANCE.idkeyStat(485, 96, j3 / 1024, false);
                    if (j2 != 0) {
                        h.INSTANCE.idkeyStat(485, 97, j4, false);
                    }
                    Bq(i2);
                    AppMethodBeat.o(21727);
                    return;
                }
        }
        AppMethodBeat.o(21727);
    }

    private void Bq(final int i2) {
        AppMethodBeat.i(21728);
        final Long valueOf = Long.valueOf(Util.nowMilliSecond());
        final Long valueOf2 = Long.valueOf(Bw(Util.nowMilliSecond()));
        if (valueOf.longValue() == 0 || valueOf2.longValue() == 0) {
            Log.e("MicroMsg.BackupLogManager", "startLogAfterTimeHandler is zero, startAfterLogTime[%d], startAfterLogSize[%d], skip", valueOf, valueOf2);
            AppMethodBeat.o(21728);
            return;
        }
        this.oPT = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.backup.g.g.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(21725);
                Long valueOf = Long.valueOf(Util.nowMilliSecond());
                Long valueOf2 = Long.valueOf(g.this.K(valueOf.longValue(), valueOf.longValue()));
                Log.i("MicroMsg.BackupLogManager", "backupAfterLogTimeHandler, backupMode[%d], endAfterLogTime[%d], startAfterLogTime[%d], endAfterLogSize[%d], startAfterLogSize[%d]", Integer.valueOf(i2), valueOf, valueOf, valueOf2, valueOf2);
                if (valueOf2.longValue() != 0 && valueOf2.longValue() > valueOf2.longValue()) {
                    g.this.a(i2, valueOf.longValue() - valueOf.longValue(), valueOf2.longValue() - valueOf2.longValue(), true);
                }
                AppMethodBeat.o(21725);
                return false;
            }
        }, false);
        this.oPT.startTimer(300000);
        AppMethodBeat.o(21728);
    }

    /* access modifiers changed from: package-private */
    public final long K(long j2, long j3) {
        AppMethodBeat.i(21729);
        long j4 = 0;
        while (j2 <= j3 + Util.MILLSECONDS_OF_DAY) {
            j4 += Bw(j2);
            j2 += Util.MILLSECONDS_OF_DAY;
        }
        AppMethodBeat.o(21729);
        return j4;
    }

    /* access modifiers changed from: package-private */
    public final long Bw(long j2) {
        AppMethodBeat.i(21730);
        String format = this.oMZ.format(new Date(j2));
        String str = ar.NSf + "/MM_" + format + ".xlog";
        if (s.YS(str)) {
            long boW = s.boW(str);
            AppMethodBeat.o(21730);
            return boW;
        }
        String str2 = b.aKQ() + "/MM_" + format + ".xlog";
        if (s.YS(str2)) {
            long boW2 = s.boW(str2);
            AppMethodBeat.o(21730);
            return boW2;
        }
        AppMethodBeat.o(21730);
        return 0;
    }
}
