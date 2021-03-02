package com.tencent.mm.plugin.game.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.b.a.b;
import com.tencent.mm.plugin.game.commlib.c.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.List;

public final class h {
    /* synthetic */ h(byte b2) {
        this();
    }

    public static class a {
        private static h xIv = new h((byte) 0);

        static {
            AppMethodBeat.i(41703);
            AppMethodBeat.o(41703);
        }
    }

    private h() {
    }

    public final void pP(final boolean z) {
        AppMethodBeat.i(204186);
        com.tencent.mm.plugin.game.commlib.c.a.dTf().a("game_silent_download", new a.AbstractC1395a() {
            /* class com.tencent.mm.plugin.game.model.a.h.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.game.commlib.c.a.AbstractC1395a
            public final void cBm() {
                AppMethodBeat.i(204182);
                h.this.pQ(z);
                AppMethodBeat.o(204182);
            }
        });
        AppMethodBeat.o(204186);
    }

    public final void pQ(boolean z) {
        final d dVar;
        AppMethodBeat.i(41704);
        while (true) {
            g dSM = ((f) g.af(f.class)).dSM();
            Cursor rawQuery = dSM.rawQuery(String.format("select * from %s where %s=1 limit 1", "GameSilentDownload", "isRunning"), new String[0]);
            if (rawQuery == null) {
                Log.i("MicroMsg.GameSilentDownloadStorage", "first cursor is null");
                dVar = null;
            } else if (rawQuery.moveToFirst()) {
                d dVar2 = new d();
                dVar2.convertFrom(rawQuery);
                rawQuery.close();
                dVar = dVar2;
            } else {
                Log.i("MicroMsg.GameSilentDownloadStorage", "no running task");
                rawQuery.close();
                Cursor rawQuery2 = dSM.rawQuery(String.format("select * from %s where %s < ? limit 1", "GameSilentDownload", "nextCheckTime"), String.valueOf(Util.nowSecond()));
                if (rawQuery2 == null) {
                    Log.i("MicroMsg.GameSilentDownloadStorage", "second cursor is null");
                    dVar = null;
                } else if (rawQuery2.moveToFirst()) {
                    d dVar3 = new d();
                    dVar3.convertFrom(rawQuery2);
                    rawQuery2.close();
                    dVar = dVar3;
                } else {
                    rawQuery2.close();
                    Log.i("MicroMsg.GameSilentDownloadStorage", "no record");
                    dVar = null;
                }
            }
            if (dVar == null) {
                Log.i("MicroMsg.GameSilentDownloader", "silentDownload witch can check is empty!");
                AppMethodBeat.o(41704);
                return;
            }
            Log.i("MicroMsg.GameSilentDownloader", "[appid:%s] in DB to check download", dVar.field_appId);
            if (dVar.field_expireTime <= Util.nowSecond()) {
                Log.i("MicroMsg.GameSilentDownloader", "task expire time, appId:%s", dVar.field_appId);
                f.aAr(dVar.field_appId);
                cancelDownload(dVar.field_appId);
                z = false;
            } else if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                Log.i("MicroMsg.GameSilentDownloader", "NetType is not WIFI");
                com.tencent.mm.game.report.api.a.hhr.a(12, dVar.field_appId, "not_wifi", 0);
                AppMethodBeat.o(41704);
                return;
            } else {
                ((f) g.af(f.class)).dSM().aAt(dVar.field_appId);
                g.aAi();
                if (!g.aAh().isSDCardAvailable()) {
                    Log.i("MicroMsg.GameSilentDownloader", "sdcard isnt available");
                    com.tencent.mm.game.report.api.a.hhr.a(12, dVar.field_appId, "sdcard_not_available", 0);
                    AppMethodBeat.o(41704);
                    return;
                }
                ((f) g.af(f.class)).dSM().aAu(dVar.field_appId);
                if (dVar.field_size <= 0 || com.tencent.mm.plugin.downloader.model.h.CF(dVar.field_size) || com.tencent.mm.plugin.downloader.model.h.CE(dVar.field_size)) {
                    ((f) g.af(f.class)).dSM().aAv(dVar.field_appId);
                    Log.i("MicroMsg.GameSilentDownloader", "fromBattery：%b", Boolean.valueOf(z));
                    if (!z) {
                        a.C1404a dWb = a.dWb();
                        Log.i("MicroMsg.GameSilentDownloader", "battery isCharging:%b  percent:%f", Boolean.valueOf(dWb.ohV), Float.valueOf(dWb.xIk));
                        if (dWb.ohV || ((double) dWb.xIk) >= 0.2d) {
                            ((f) g.af(f.class)).dSM().aAw(dVar.field_appId);
                        } else {
                            Log.i("MicroMsg.GameSilentDownloader", "battery is low");
                            com.tencent.mm.game.report.api.a.hhr.a(12, dVar.field_appId, "battery_is_low", 0);
                            AppMethodBeat.o(41704);
                            return;
                        }
                    } else {
                        ((f) g.af(f.class)).dSM().aAw(dVar.field_appId);
                    }
                    com.tencent.mm.ch.a.post(new Runnable() {
                        /* class com.tencent.mm.plugin.game.model.a.h.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(204184);
                            com.tencent.mm.pluginsdk.model.app.h.cX(dVar.field_appId, false);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.game.model.a.h.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    boolean z;
                                    long nowSecond;
                                    AppMethodBeat.i(204183);
                                    if (dVar.field_isFirst) {
                                        g dSM = ((f) g.af(f.class)).dSM();
                                        String str = dVar.field_appId;
                                        if (Util.isNullOrNil(str)) {
                                            Log.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag: appid is null");
                                        } else {
                                            Log.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag ret:%b", Boolean.valueOf(dSM.execSQL("GameSilentDownload", String.format("update %s set %s=0 where %s='%s'", "GameSilentDownload", "isFirst", "appId", str))));
                                        }
                                        long j2 = dVar.field_randomTime;
                                        if (j2 <= 0) {
                                            nowSecond = 0;
                                        } else {
                                            int intRandom = Util.getIntRandom((int) j2, 0);
                                            Log.i("MicroMsg.GameSilentDownloader", "random time interval:%d", Integer.valueOf(intRandom));
                                            nowSecond = ((long) intRandom) + Util.nowSecond();
                                        }
                                        ((f) g.af(f.class)).dSM().ay(dVar.field_appId, nowSecond);
                                        if (Util.nowSecond() >= nowSecond) {
                                            z = true;
                                        }
                                        z = false;
                                    } else {
                                        if (Util.nowSecond() >= dVar.field_nextCheckTime) {
                                            z = true;
                                        }
                                        z = false;
                                    }
                                    if (z) {
                                        h hVar = h.this;
                                        String str2 = dVar.field_appId;
                                        Log.i("MicroMsg.GameSilentDownloader", "source:%d, appid:%s", 1, str2);
                                        d.a aVar = new d.a();
                                        aVar.funcId = 2819;
                                        aVar.iLP = 0;
                                        aVar.respCmdId = 0;
                                        aVar.uri = "/cgi-bin/mmgame-bin/checkappdownloadquota";
                                        com.tencent.mm.plugin.game.b.a.a aVar2 = new com.tencent.mm.plugin.game.b.a.a();
                                        aVar2.xub = 1;
                                        aVar2.jfi = str2;
                                        com.tencent.mm.plugin.downloader.g.a alb = com.tencent.mm.plugin.downloader.model.d.alb(str2);
                                        if (alb != null) {
                                            aVar2.xuc = alb.field_downloadUrl;
                                            aVar2.xud = alb.field_downloadedSize;
                                        }
                                        aVar.iLN = aVar2;
                                        aVar.iLO = new b();
                                        aa.a(aVar.aXF(), new aa.a(str2) {
                                            /* class com.tencent.mm.plugin.game.model.a.h.AnonymousClass3 */
                                            final /* synthetic */ String val$appId;

                                            {
                                                this.val$appId = r2;
                                            }

                                            @Override // com.tencent.mm.ak.aa.a
                                            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                                                FileDownloadTaskInfo alh;
                                                AppMethodBeat.i(204185);
                                                if (i2 == 0 && i3 == 0) {
                                                    b bVar = (b) dVar.iLL.iLR;
                                                    if (bVar == null) {
                                                        AppMethodBeat.o(204185);
                                                        return 0;
                                                    }
                                                    Log.i("MicroMsg.GameSilentDownloader", "op:%d", Integer.valueOf(bVar.op));
                                                    switch (bVar.op) {
                                                        case 1:
                                                            ((f) g.af(f.class)).dSM().aAx(this.val$appId);
                                                            if (bVar.xuf != null && bVar.xuf.qGP != null && !Util.isNullOrNil(bVar.xuf.qGP.gqB)) {
                                                                d aAs = ((f) g.af(f.class)).dSM().aAs(this.val$appId);
                                                                if (aAs != null) {
                                                                    com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(this.val$appId, false, false);
                                                                    if (o != null) {
                                                                        long j2 = (long) bVar.xuf.qGP.qGt;
                                                                        long aAH = (long) c.aAH(o.field_packageName);
                                                                        Log.i("MicroMsg.GameSilentDownloader", "serverVersionCode: %d, localVersionCode:%d", Long.valueOf(j2), Long.valueOf(aAH));
                                                                        if (j2 > 0 && j2 > aAH) {
                                                                            Log.i("MicroMsg.GameSilentDownloader", "force update, serverVersionCode(%d) > localVersionCode(%d)", Long.valueOf(j2), Long.valueOf(aAH));
                                                                            if (aAH == 0) {
                                                                                ((f) g.af(f.class)).dSM().ej(this.val$appId, 2);
                                                                            } else {
                                                                                ((f) g.af(f.class)).dSM().ej(this.val$appId, 1);
                                                                            }
                                                                        } else if (com.tencent.mm.pluginsdk.model.app.h.a(MMApplicationContext.getContext(), o)) {
                                                                            Log.i("MicroMsg.GameSilentDownloader", "app is installed, appid = %s", this.val$appId);
                                                                            f.P(aAs.field_appId, 4, 0);
                                                                            h.cancelDownload(aAs.field_appId);
                                                                            h.this.pQ(false);
                                                                            AppMethodBeat.o(204185);
                                                                            return 0;
                                                                        }
                                                                        if (!bVar.xuf.qGP.gqB.equals(Util.nullAsNil(aAs.field_downloadUrl))) {
                                                                            Log.i("MicroMsg.GameSilentDownloader", "update downloadInfo. [oldDownloadUrl]:%s, [newDownloadUrl]:%s, [size]:%d, [md5]:%s, [SecondaryUrl]:%s", aAs.field_downloadUrl, bVar.xuf.qGP.gqB, Long.valueOf(bVar.xuf.qGP.qGq), bVar.xuf.qGP.qGr, bVar.xuf.qGP.qGw);
                                                                            if (!Util.isNullOrNil(aAs.field_downloadUrl) || (alh = com.tencent.mm.plugin.downloader.model.f.cBv().alh(bVar.xuf.qGP.gqB)) == null || alh.id <= 0 || alh.status == 4 || alh.status == 5) {
                                                                                aAs.field_downloadUrl = bVar.xuf.qGP.gqB;
                                                                                aAs.field_size = bVar.xuf.qGP.qGq;
                                                                                aAs.field_md5 = bVar.xuf.qGP.qGr;
                                                                                aAs.field_SecondaryUrl = bVar.xuf.qGP.qGw;
                                                                                if (!Util.isNullOrNil(bVar.xuf.qGP.qGp)) {
                                                                                    aAs.field_packageName = bVar.xuf.qGP.qGp;
                                                                                }
                                                                                aAs.field_downloadInWidget = bVar.xuf.qGT;
                                                                                if (!Util.isNullOrNil(bVar.xuf.qGP.qGz)) {
                                                                                    com.tencent.mm.plugin.downloader.c.b.q qVar2 = new com.tencent.mm.plugin.downloader.c.b.q();
                                                                                    qVar2.qGz = bVar.xuf.qGP.qGz;
                                                                                    try {
                                                                                        aAs.field_sectionMd5Byte = qVar2.toByteArray();
                                                                                    } catch (IOException e2) {
                                                                                    }
                                                                                }
                                                                                ((f) g.af(f.class)).dSM().update(aAs, new String[0]);
                                                                            } else {
                                                                                Log.i("MicroMsg.GameSilentDownloader", "download task already exists");
                                                                                ((f) g.af(f.class)).dSM().ej(this.val$appId, 3);
                                                                                f.P(this.val$appId, 6, 0);
                                                                                ((f) g.af(f.class)).dSM().delete(aAs, new String[0]);
                                                                                h.this.pQ(false);
                                                                                AppMethodBeat.o(204185);
                                                                                return 0;
                                                                            }
                                                                        }
                                                                        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                                                                            if (aAs.field_size > 0 && !com.tencent.mm.plugin.downloader.model.h.CF(aAs.field_size) && !com.tencent.mm.plugin.downloader.model.h.CE(aAs.field_size)) {
                                                                                Log.i("MicroMsg.GameSilentDownloader", "sdcard dont have enough space");
                                                                                com.tencent.mm.game.report.api.a.hhr.a(12, this.val$appId, "space_not_enough", 0);
                                                                                break;
                                                                            } else {
                                                                                com.tencent.mm.game.report.api.a.hhr.a(12, this.val$appId, "ok", 0);
                                                                                int i4 = bVar.xuf.qGP.qGs;
                                                                                if (aAs != null && !Util.isNullOrNil(aAs.field_downloadUrl)) {
                                                                                    Log.i("MicroMsg.GameSilentDownloader", "startDownload, appId:%s, url:%s, size:%d, md5:%s, packageName:%s, expireTime:%d, isFirst:%b, nextCheckTime:%d, isRunning:%b", aAs.field_appId, aAs.field_downloadUrl, Long.valueOf(aAs.field_size), aAs.field_md5, aAs.field_packageName, Long.valueOf(aAs.field_expireTime), Boolean.valueOf(aAs.field_isFirst), Long.valueOf(aAs.field_nextCheckTime), Boolean.valueOf(aAs.field_isRunning));
                                                                                    FileDownloadTaskInfo alh2 = com.tencent.mm.plugin.downloader.model.f.cBv().alh(aAs.field_downloadUrl);
                                                                                    if (alh2 != null && alh2.id > 0 && alh2.status == 2) {
                                                                                        Log.i("MicroMsg.GameSilentDownloader", "resume downloadTask");
                                                                                        long j3 = alh2.id;
                                                                                        com.tencent.mm.plugin.downloader.model.f.cBv().qIA = true;
                                                                                        com.tencent.mm.plugin.downloader.model.f.cBv().Cq(j3);
                                                                                        break;
                                                                                    } else {
                                                                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(858, 9, 1, false);
                                                                                        b.a(aAs, i4);
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    Log.e("MicroMsg.GameSilentDownloader", "downloadInfo is null");
                                                                                    break;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            Log.i("MicroMsg.GameSilentDownloader", "cgi response back, but not in wifi");
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        Log.i("MicroMsg.GameSilentDownloader", "local appInfo is null, appid:%s", this.val$appId);
                                                                        AppMethodBeat.o(204185);
                                                                        return 0;
                                                                    }
                                                                } else {
                                                                    Log.i("MicroMsg.GameSilentDownloader", "local SilentDownloadTask is deleted");
                                                                    AppMethodBeat.o(204185);
                                                                    return 0;
                                                                }
                                                            } else {
                                                                Log.e("MicroMsg.GameSilentDownloader", "downloadInfo is null");
                                                                com.tencent.mm.plugin.downloader.f.a.aa(this.val$appId, 20);
                                                                AppMethodBeat.o(204185);
                                                                return 0;
                                                            }
                                                            break;
                                                        case 2:
                                                            Log.i("MicroMsg.GameSilentDownloader", "delay, nextInterval:%d", Long.valueOf(bVar.xue));
                                                            ((f) g.af(f.class)).dSM().ay(this.val$appId, Util.nowSecond() + bVar.xue);
                                                            h.this.pQ(false);
                                                            break;
                                                        case 3:
                                                            f.P(this.val$appId, 5, 0);
                                                            h.cancelDownload(this.val$appId);
                                                            h.this.pQ(false);
                                                            break;
                                                        default:
                                                            com.tencent.mm.plugin.downloader.f.a.aa(this.val$appId, 19);
                                                            break;
                                                    }
                                                    AppMethodBeat.o(204185);
                                                    return 0;
                                                }
                                                Log.e("MicroMsg.GameSilentDownloader", "Check Error, errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                                                com.tencent.mm.plugin.downloader.f.a.aa(this.val$appId, 18);
                                                AppMethodBeat.o(204185);
                                                return 0;
                                            }
                                        });
                                        AppMethodBeat.o(204183);
                                        return;
                                    }
                                    com.tencent.mm.game.report.api.a.hhr.a(12, dVar.field_appId, "random_time", 0);
                                    AppMethodBeat.o(204183);
                                }
                            });
                            AppMethodBeat.o(204184);
                        }
                    });
                    AppMethodBeat.o(41704);
                    return;
                }
                Log.i("MicroMsg.GameSilentDownloader", "sdcard dont have enough space");
                com.tencent.mm.game.report.api.a.hhr.a(12, dVar.field_appId, "space_not_enough", 0);
                AppMethodBeat.o(41704);
                return;
            }
        }
    }

    public static void pauseDownload() {
        AppMethodBeat.i(41705);
        List<d> dWc = ((f) g.af(f.class)).dSM().dWc();
        if (Util.isNullOrNil(dWc)) {
            AppMethodBeat.o(41705);
            return;
        }
        for (d dVar : dWc) {
            if (dVar != null) {
                if (dVar.field_expireTime <= Util.nowSecond()) {
                    Log.i("MicroMsg.GameSilentDownloader", "pauseDownload, task expire time, appId:%s", dVar.field_appId);
                    f.aAr(dVar.field_appId);
                    cancelDownload(dVar.field_appId);
                } else {
                    FileDownloadTaskInfo alg = com.tencent.mm.plugin.downloader.model.f.cBv().alg(dVar.field_appId);
                    if (alg != null && alg.id > 0 && alg.status == 1) {
                        Log.i("MicroMsg.GameSilentDownloader", "pauseDownload, appid:%s, ret:%b", alg.appId, Boolean.valueOf(b.Cp(alg.id)));
                    }
                }
            }
        }
        AppMethodBeat.o(41705);
    }

    static void cancelDownload(String str) {
        FileDownloadTaskInfo alg;
        AppMethodBeat.i(41706);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41706);
            return;
        }
        d dVar = new d();
        dVar.field_appId = str;
        boolean delete = ((f) g.af(f.class)).dSM().delete(dVar, new String[0]);
        Log.i("MicroMsg.GameSilentDownloader", "remove SilentDownload DB, appid:%s, ret:%b", str, Boolean.valueOf(delete));
        if (delete && (alg = com.tencent.mm.plugin.downloader.model.f.cBv().alg(str)) != null && alg.id > 0) {
            com.tencent.mm.plugin.downloader.model.f.cBv().Cn(alg.id);
            Log.i("MicroMsg.GameSilentDownloader", "remove download task, appid:%s", alg.appId);
        }
        AppMethodBeat.o(41706);
    }
}
