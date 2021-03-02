package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.model.BallReportInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class b {
    public static void a(BallInfo ballInfo, List<BallInfo> list) {
        String str;
        int i2;
        AppMethodBeat.i(216985);
        int i3 = ballInfo.oWs.oWz;
        Log.v("MicroMsg.FloatBallReportLogic", "alvinluo addBallReport overLimitType: %d", Integer.valueOf(i3));
        int size = list.size();
        int i4 = 0;
        int i5 = 1;
        int i6 = 1;
        int i7 = 0;
        while (i7 < size) {
            BallInfo ballInfo2 = list.get(i7);
            if (ballInfo2.oWr) {
                i4++;
            }
            if (ballInfo2.oWr != ballInfo.oWr || ballInfo2.oWs.oWC < i5) {
                i2 = i6;
            } else {
                i2 = ballInfo2.oWs.oWC;
                i5 = ballInfo2.oWs.oWC + 1;
            }
            i7++;
            i6 = i2;
        }
        BallReportInfo ballReportInfo = ballInfo.oWs;
        g.aAf();
        ballReportInfo.oWA = String.format("%s_%d", a.ayV(), Long.valueOf(ballInfo.createTime));
        BallReportInfo ballReportInfo2 = ballInfo.oWs;
        if (size <= 1) {
            str = String.format("Aggre_%s", ballInfo.oWs.oWA);
        } else {
            str = list.get(0).oWs.oWB;
        }
        ballReportInfo2.oWB = str;
        ballInfo.oWs.oWC = i5;
        if (ballInfo.oWs.hCZ == 6) {
            ballInfo.oWs.oWC = i6;
        }
        BallReportInfo ballReportInfo3 = ballInfo.oWs;
        try {
            Object[] objArr = new Object[15];
            objArr[0] = Long.valueOf(ballInfo.oWp);
            objArr[1] = Integer.valueOf(ballReportInfo3.hCZ);
            objArr[2] = Integer.valueOf(ballReportInfo3.oWx);
            objArr[3] = ballReportInfo3.oWA;
            objArr[4] = ballReportInfo3.oWB;
            objArr[5] = Integer.valueOf(ballReportInfo3.oWC);
            objArr[6] = Integer.valueOf(size - i4);
            objArr[7] = Integer.valueOf(i4);
            objArr[8] = Integer.valueOf(ballInfo.oWr ? 1 : 2);
            objArr[9] = Integer.valueOf(ballReportInfo3.hDa);
            objArr[10] = q.encode(Util.nullAsNil(ballReportInfo3.dPJ));
            objArr[11] = q.encode(Util.nullAsNil(ballReportInfo3.oWy));
            objArr[12] = q.encode(Util.nullAsNil(ballReportInfo3.iNV));
            objArr[13] = Integer.valueOf(ballInfo.cig());
            objArr[14] = Integer.valueOf(i3);
            String format = String.format("%d,%d,%d,%s,%s,%d,%d,%d,%d,%d,%s,%s,%s,%d,%d", objArr);
            Log.v("MicroMsg.FloatBallReportLogic", "addBallReport reportStr:%s", format);
            h.INSTANCE.kvStat(17602, format);
            AppMethodBeat.o(216985);
        } catch (Exception e2) {
            AppMethodBeat.o(216985);
        }
    }

    static void y(BallInfo ballInfo) {
        boolean z;
        AppMethodBeat.i(106091);
        if (ballInfo.oWs.opType == -1) {
            AppMethodBeat.o(106091);
            return;
        }
        int i2 = ballInfo.oWs.opType;
        if (i2 == 7 || i2 == 4 || i2 == 5 || i2 == 12 || i2 == 13) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Log.w("MicroMsg.FloatBallReportLogic", "minimizeBallReport unexpected opType:%d", Integer.valueOf(ballInfo.oWs.opType));
            ballInfo.oWs.opType = 6;
        }
        a(ballInfo, 0, 0, 0, Util.nowMilliSecond() - ballInfo.oWp);
        AppMethodBeat.o(106091);
    }

    static void b(BallInfo ballInfo, boolean z) {
        boolean z2;
        long j2;
        AppMethodBeat.i(106092);
        int i2 = ballInfo.oWs.opType;
        if (i2 == 10 || i2 == 9 || i2 == 8 || i2 == 11 || i2 == 14) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            Log.w("MicroMsg.FloatBallReportLogic", "removeBallReport unexpected opType:%d", Integer.valueOf(ballInfo.oWs.opType));
            AppMethodBeat.o(106092);
            return;
        }
        long nowMilliSecond = Util.nowMilliSecond();
        long j3 = nowMilliSecond - ballInfo.oWp;
        long j4 = nowMilliSecond - ballInfo.createTime;
        if (z && !Util.isNullOrNil(ballInfo.oWs.oWB)) {
            String[] split = ballInfo.oWs.oWB.split("_", -1);
            if (split.length == 3) {
                try {
                    j2 = nowMilliSecond - Util.safeParseLong(split[2]);
                } catch (Exception e2) {
                }
                a(ballInfo, 0, j2, j4, j3);
                AppMethodBeat.o(106092);
            }
        }
        j2 = 0;
        a(ballInfo, 0, j2, j4, j3);
        AppMethodBeat.o(106092);
    }

    static void a(BallInfo ballInfo, long j2, long j3, long j4, long j5) {
        AppMethodBeat.i(106093);
        BallReportInfo ballReportInfo = ballInfo.oWs;
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(ballReportInfo.opType);
        objArr[1] = ballReportInfo.oWA;
        objArr[2] = ballReportInfo.oWB;
        objArr[3] = Long.valueOf(j2);
        objArr[4] = Long.valueOf(j3);
        objArr[5] = Long.valueOf(j4);
        objArr[6] = Integer.valueOf(ballInfo.oWr ? 1 : 2);
        objArr[7] = Integer.valueOf(ballReportInfo.oWC);
        objArr[8] = Long.valueOf(j5);
        String format = String.format("%d,%s,%s,%d,%d,%d,%d,%d,%d", objArr);
        h.INSTANCE.kvStat(17604, format);
        Log.v("MicroMsg.FloatBallReportLogic", "doOpBallReport reportStr:%s", format);
        AppMethodBeat.o(106093);
    }
}
