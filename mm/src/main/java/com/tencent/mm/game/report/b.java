package com.tencent.mm.game.report;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class b extends com.tencent.mm.game.report.api.a {
    @Override // com.tencent.mm.game.report.api.a
    public final void a(com.tencent.mm.game.report.api.b bVar) {
        AppMethodBeat.i(108240);
        e.a(bVar);
        AppMethodBeat.o(108240);
    }

    @Override // com.tencent.mm.game.report.api.a
    public final void a(String str, String str2, int i2, int i3, String str3, int i4) {
        AppMethodBeat.i(108241);
        Log.d("MicroMsg.GameReportImpl", "rejectGameMsg, fromUserName = " + str + ", appId = " + str2 + ", msgType = " + i2 + ", scene = " + i3 + ", actionName = " + str3);
        if (Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.GameReportImpl", "rejectGameMsg fail, appId is null");
            AppMethodBeat.o(108241);
            return;
        }
        h.INSTANCE.a(10546, str, str2, Integer.valueOf(i2), com.tencent.mm.game.report.e.a.axg(), Integer.valueOf(i3), str3, Integer.valueOf(i4));
        AppMethodBeat.o(108241);
    }

    @Override // com.tencent.mm.game.report.api.a
    public final void a(Context context, String str, String str2, String str3, int i2, String str4, int i3) {
        AppMethodBeat.i(108242);
        Log.d("MicroMsg.GameReportImpl", "reportMsgClick, appId = " + str + ", pkgName = " + str2);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.GameReportImpl", "reportDelGameMsg fail, appId is null");
            AppMethodBeat.o(108242);
            return;
        }
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        e.a(com.tencent.mm.game.report.api.b.e(10583, str, Integer.valueOf(com.tencent.mm.game.report.e.a.E(context, str2)), com.tencent.mm.game.report.e.a.axg(), str3, Integer.valueOf(i2), str4, Integer.valueOf(i3), 0, Integer.valueOf(com.tencent.mm.game.report.e.a.getNetworkType(context))));
        AppMethodBeat.o(108242);
    }

    @Override // com.tencent.mm.game.report.api.a
    public final void a(String str, String str2, int i2, int i3, String str3, long j2, boolean z, String str4, int i4) {
        AppMethodBeat.i(108243);
        Log.d("MicroMsg.GameReportImpl", "reportReadMsg, appId = ".concat(String.valueOf(str)));
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.GameReportImpl", "reportReadMsg fail, appId is null");
            AppMethodBeat.o(108243);
            return;
        }
        String zn = com.tencent.mm.game.report.e.a.zn(j2);
        Object[] objArr = new Object[9];
        objArr[0] = str;
        objArr[1] = zn;
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = str3;
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(z ? 1 : 0);
        objArr[7] = str4;
        objArr[8] = Integer.valueOf(i4);
        Log.i("MicroMsg.reportReadMsg", "%s,%s,%s,%s,%s,%s,%s,%s,%d", objArr);
        h hVar = h.INSTANCE;
        Object[] objArr2 = new Object[9];
        objArr2[0] = str;
        objArr2[1] = zn;
        objArr2[2] = str2;
        objArr2[3] = Integer.valueOf(i2);
        objArr2[4] = str3;
        objArr2[5] = Integer.valueOf(i3);
        objArr2[6] = Integer.valueOf(z ? 1 : 0);
        objArr2[7] = str4;
        objArr2[8] = Integer.valueOf(i4);
        hVar.a(10532, objArr2);
        AppMethodBeat.o(108243);
    }

    @Override // com.tencent.mm.game.report.api.a
    public final void m(String str, int i2, int i3) {
        AppMethodBeat.i(108244);
        Log.d("MicroMsg.GameReportImpl", "reportGameDetail, appId = " + str + ", scene = " + i2);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.GameReportImpl", "reportGameDetail fail, appId is null");
            AppMethodBeat.o(108244);
            return;
        }
        h.INSTANCE.a(10700, str, 1, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(108244);
    }

    @Override // com.tencent.mm.game.report.api.a
    public final void k(String str, String str2, String str3) {
        AppMethodBeat.i(108245);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.GameReportImpl", "null open or null username");
            AppMethodBeat.o(108245);
            return;
        }
        h.INSTANCE.a(10738, str, str2, str, str3);
        AppMethodBeat.o(108245);
    }

    @Override // com.tencent.mm.game.report.api.a
    public final void k(Context context, String str, String str2) {
        AppMethodBeat.i(108246);
        Log.d("MicroMsg.GameReportImpl", "reportRegToWx, appId = " + str + ", pkgName = " + str2);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.GameReportImpl", "reportRegToWx fail, appId is null");
            AppMethodBeat.o(108246);
            return;
        }
        h.INSTANCE.a(10534, str, Integer.valueOf(com.tencent.mm.game.report.e.a.E(context, str2)), com.tencent.mm.game.report.e.a.axg(), Long.valueOf(System.currentTimeMillis() / 1000));
        AppMethodBeat.o(108246);
    }

    @Override // com.tencent.mm.game.report.api.a
    public final void a(Context context, String str, String str2, String str3, int i2, int i3, int i4, String str4, long j2, String str5, String str6) {
        AppMethodBeat.i(190323);
        a(context, str, str2, str3, i2, i3, i4, str4, 0, str5, str6, 0);
        AppMethodBeat.o(190323);
    }

    @Override // com.tencent.mm.game.report.api.a
    public final void a(Context context, String str, String str2, String str3, int i2, int i3, int i4, String str4, long j2, String str5, String str6, int i5) {
        AppMethodBeat.i(108248);
        Log.d("MicroMsg.GameReportImpl", "reportMsgClick 10531, appId = %s, pkgName = %s, msgSvrId:%d, snsOgjId:%s", str, str2, Long.valueOf(j2), str5);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.GameReportImpl", "reportMsgClick fail, appId is null");
            AppMethodBeat.o(108248);
            return;
        }
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        g o = com.tencent.mm.pluginsdk.model.app.h.o(str, false, false);
        if (o == null) {
            Log.e("MicroMsg.GameReportImpl", "reportMsgClick fail, appinfo is null");
            AppMethodBeat.o(108248);
            return;
        }
        Object[] objArr = new Object[19];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(com.tencent.mm.game.report.e.a.E(context, str2));
        objArr[2] = com.tencent.mm.game.report.e.a.axg();
        objArr[3] = str3;
        objArr[4] = Integer.valueOf(i2);
        objArr[5] = str4;
        objArr[6] = Integer.valueOf(i3);
        objArr[7] = Integer.valueOf(i4);
        objArr[8] = Integer.valueOf(com.tencent.mm.game.report.e.a.getNetworkType(context));
        objArr[9] = Util.nullAsNil(o.field_packageName);
        objArr[10] = Util.nullAsNil(o.field_signature);
        objArr[11] = Long.toString(j2);
        objArr[12] = "";
        objArr[13] = str5;
        objArr[14] = "";
        objArr[15] = Integer.valueOf(o.NA() ? 1 : 0);
        objArr[16] = str6;
        objArr[17] = "";
        objArr[18] = Integer.valueOf(i5);
        com.tencent.mm.game.report.api.b e2 = com.tencent.mm.game.report.api.b.e(10531, objArr);
        Log.i("MicroMsg.reportMsgClick", e2.hht);
        e.a(e2);
        AppMethodBeat.o(108248);
    }

    @Override // com.tencent.mm.game.report.api.a
    public final void a(GameWebPerformanceInfo gameWebPerformanceInfo) {
        AppMethodBeat.i(108249);
        if (gameWebPerformanceInfo == null || Util.isNullOrNil(gameWebPerformanceInfo.url)) {
            Log.e("MicroMsg.GameReportImpl", "info is null");
            AppMethodBeat.o(108249);
        } else if (MMApplicationContext.isMMProcess()) {
            b(gameWebPerformanceInfo);
            AppMethodBeat.o(108249);
        } else {
            com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, gameWebPerformanceInfo, a.class, null);
            AppMethodBeat.o(108249);
        }
    }

    @Override // com.tencent.mm.game.report.api.a
    public final void a(int i2, String str, String str2, long j2) {
        AppMethodBeat.i(184036);
        Log.d("MicroMsg.GameReportImpl", "reportGameCommEvent, opId:%d, params:%s, result:%s, costTime:%d", Integer.valueOf(i2), str, str2, Long.valueOf(j2));
        h.INSTANCE.a(16171, 0, Integer.valueOf(i2), str, str2, Long.valueOf(j2));
        AppMethodBeat.o(184036);
    }

    @Override // com.tencent.mm.game.report.api.a
    public final void c(String str, int i2, int i3, String str2, String str3) {
        AppMethodBeat.i(175994);
        a.axd();
        a.b(str, i2, i3, str2, str3);
        AppMethodBeat.o(175994);
    }

    static void b(GameWebPerformanceInfo gameWebPerformanceInfo) {
        int i2;
        AppMethodBeat.i(108251);
        Log.i("MicroMsg.GameReportImpl", "reportWebPerformanceInMM, %s", gameWebPerformanceInfo.toString());
        long j2 = gameWebPerformanceInfo.hhE - gameWebPerformanceInfo.startTime > 0 ? gameWebPerformanceInfo.hhE - gameWebPerformanceInfo.startTime : 0;
        long j3 = gameWebPerformanceInfo.hhF - gameWebPerformanceInfo.startTime;
        if (gameWebPerformanceInfo.hhG > 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        long j4 = 0;
        long j5 = 0;
        if (i2 == 1) {
            j4 = gameWebPerformanceInfo.hhG - gameWebPerformanceInfo.startTime;
            j5 = gameWebPerformanceInfo.hhH - gameWebPerformanceInfo.startTime;
        }
        long j6 = 0;
        long j7 = 0;
        if (gameWebPerformanceInfo.hhx == 1) {
            j6 = gameWebPerformanceInfo.hhI - gameWebPerformanceInfo.startTime;
            j7 = gameWebPerformanceInfo.hhJ - gameWebPerformanceInfo.startTime;
        }
        long j8 = gameWebPerformanceInfo.hhK - gameWebPerformanceInfo.startTime;
        long j9 = gameWebPerformanceInfo.hhL - gameWebPerformanceInfo.startTime;
        long j10 = gameWebPerformanceInfo.hhM - gameWebPerformanceInfo.startTime;
        long j11 = gameWebPerformanceInfo.hhN - gameWebPerformanceInfo.startTime;
        long j12 = 0;
        if (gameWebPerformanceInfo.hhO != 0) {
            j12 = gameWebPerformanceInfo.hhO - gameWebPerformanceInfo.startTime;
            if (gameWebPerformanceInfo.hhx == 0 && j12 < 0) {
                j12 = -1;
            }
        }
        long j13 = gameWebPerformanceInfo.hhP - gameWebPerformanceInfo.startTime;
        long j14 = gameWebPerformanceInfo.hhQ - gameWebPerformanceInfo.startTime;
        if (gameWebPerformanceInfo.hhx == 0 && j14 <= 0) {
            j14 = -1;
        }
        int i3 = gameWebPerformanceInfo.hhR > 0 ? 1 : 0;
        long j15 = gameWebPerformanceInfo.hhR - gameWebPerformanceInfo.startTime;
        if (i3 == 0 || (gameWebPerformanceInfo.hhx == 0 && j15 <= 0)) {
            j15 = -1;
        }
        long j16 = 0;
        long j17 = 0;
        if (gameWebPerformanceInfo.hhz == 0) {
            j16 = gameWebPerformanceInfo.hhS - gameWebPerformanceInfo.startTime;
            if (j16 <= 0) {
                j16 = -1;
            }
            j17 = gameWebPerformanceInfo.hhT - gameWebPerformanceInfo.startTime;
            if (j17 <= 0) {
                j17 = -1;
            }
        }
        long j18 = gameWebPerformanceInfo.hhV - gameWebPerformanceInfo.startTime;
        Log.i("MicroMsg.GameReportImpl", "url : %s, pkgId: %s, isLuggage : %d, isWePkg: %d, isPreloadWePkg: %d, isPreloadWebCore: %d, hasLoadFinished: %d, gameCenterUICreate: %d, startWebUI: %d,preloadWePkgBgn: %d, preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d,webUICreate: %d, webUIOnshowBgn: %d, createViewBgn: %d, createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d, onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInfront: %d,webUIDestroy: %d", gameWebPerformanceInfo.url, gameWebPerformanceInfo.hhD, Integer.valueOf(gameWebPerformanceInfo.hhv), Integer.valueOf(gameWebPerformanceInfo.hhw), Integer.valueOf(i2), Integer.valueOf(gameWebPerformanceInfo.hhx), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9), Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13), Long.valueOf(j14), Long.valueOf(j15), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(gameWebPerformanceInfo.hhU), Long.valueOf(j18));
        String str = "";
        try {
            str = URLEncoder.encode(gameWebPerformanceInfo.url, ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e2) {
        }
        h.INSTANCE.a(16141, str, Integer.valueOf(gameWebPerformanceInfo.hhv), Integer.valueOf(gameWebPerformanceInfo.hhw), Integer.valueOf(i2), Integer.valueOf(gameWebPerformanceInfo.hhx), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9), Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13), Long.valueOf(j14), Long.valueOf(j15), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(gameWebPerformanceInfo.hhU), Long.valueOf(j18), Integer.valueOf(i3), gameWebPerformanceInfo.hhD, Integer.valueOf(gameWebPerformanceInfo.hhy), gameWebPerformanceInfo.hhu, NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()), Integer.valueOf(gameWebPerformanceInfo.hhB), Integer.valueOf(gameWebPerformanceInfo.hhz), Integer.valueOf(gameWebPerformanceInfo.hhC), gameWebPerformanceInfo.hhY, gameWebPerformanceInfo.hhZ, gameWebPerformanceInfo.hia);
        if (i3 == 1) {
            if (gameWebPerformanceInfo.hhB == 0) {
                h.INSTANCE.n(949, 4, 1);
            }
            if (gameWebPerformanceInfo.hhT == -1) {
                h.INSTANCE.n(949, 7, 1);
                AppMethodBeat.o(108251);
                return;
            }
        } else if (gameWebPerformanceInfo.hhw == 1) {
            h.INSTANCE.n(949, 5, 1);
            AppMethodBeat.o(108251);
            return;
        } else {
            h.INSTANCE.n(949, 6, 1);
        }
        AppMethodBeat.o(108251);
    }

    static class a implements com.tencent.mm.ipcinvoker.b<GameWebPerformanceInfo, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(GameWebPerformanceInfo gameWebPerformanceInfo, d<Bundle> dVar) {
            AppMethodBeat.i(108239);
            b.b(gameWebPerformanceInfo);
            if (dVar != null) {
                dVar.bn(null);
            }
            AppMethodBeat.o(108239);
        }
    }
}
