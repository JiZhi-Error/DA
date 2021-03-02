package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v4.app.s;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.q;
import com.tencent.mm.d.c;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.plugin.downloader.h.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class f {
    private static int lCZ = 2;
    private static Map<Long, Long> qIr = new HashMap();
    private static f qIz;
    public boolean qIA = false;
    private n qIs;
    private n qIt;
    private n qIu;
    private a qIv;
    private b qIw;
    private n qIx;
    public c qIy;

    static /* synthetic */ void b(String str, String str2, String str3, PendingIntent pendingIntent) {
        AppMethodBeat.i(89002);
        a(str, str2, str3, pendingIntent);
        AppMethodBeat.o(89002);
    }

    static {
        AppMethodBeat.i(89004);
        AppMethodBeat.o(89004);
    }

    public static f cBv() {
        AppMethodBeat.i(88974);
        if (qIz == null) {
            qIz = new f();
        }
        f fVar = qIz;
        AppMethodBeat.o(88974);
        return fVar;
    }

    private f() {
        AppMethodBeat.i(88975);
        cBC();
        if (g.aAf().azp()) {
            g.aAf();
            if (!com.tencent.mm.kernel.a.azj()) {
                lCZ = Util.getInt(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("FileDownloaderType"), 2);
                Log.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", Integer.valueOf(lCZ));
                this.qIy = new c();
                AppMethodBeat.o(88975);
            }
        }
        Log.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
        this.qIy = new c();
        AppMethodBeat.o(88975);
    }

    public final n cBw() {
        AppMethodBeat.i(88976);
        Log.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + lCZ);
        if (this.qIs != null) {
            n nVar = this.qIs;
            AppMethodBeat.o(88976);
            return nVar;
        }
        jr jrVar = new jr();
        EventCenter.instance.publish(jrVar);
        int i2 = jrVar.dOB.dNv;
        Log.i("MicroMsg.FileDownloadManager", "gameDebugDownloaderType = ".concat(String.valueOf(i2)));
        if (i2 > 0) {
            lCZ = i2;
        }
        if (lCZ == 1) {
            this.qIs = cBx();
        } else {
            this.qIs = cBz();
        }
        n nVar2 = this.qIs;
        AppMethodBeat.o(88976);
        return nVar2;
    }

    private n cBx() {
        AppMethodBeat.i(88977);
        if (this.qIu == null) {
            this.qIu = new i(this.qIy);
        }
        n nVar = this.qIu;
        AppMethodBeat.o(88977);
        return nVar;
    }

    private n cBy() {
        AppMethodBeat.i(88978);
        if (this.qIt == null) {
            this.qIt = new k(this.qIy);
        }
        n nVar = this.qIt;
        AppMethodBeat.o(88978);
        return nVar;
    }

    public final a cBz() {
        AppMethodBeat.i(88979);
        if (this.qIv == null) {
            this.qIv = new a(this.qIy);
        }
        a aVar = this.qIv;
        AppMethodBeat.o(88979);
        return aVar;
    }

    public final b cBA() {
        AppMethodBeat.i(88980);
        if (this.qIw == null) {
            this.qIw = new b(this.qIy);
        }
        b bVar = this.qIw;
        AppMethodBeat.o(88980);
        return bVar;
    }

    private n cBB() {
        AppMethodBeat.i(88981);
        if (this.qIx == null) {
            this.qIx = new l(this.qIy);
        }
        n nVar = this.qIx;
        AppMethodBeat.o(88981);
        return nVar;
    }

    public final long a(g gVar) {
        AppMethodBeat.i(88982);
        Log.i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", Integer.valueOf(gVar.qIG), gVar.mAppId);
        if (gVar.qIG == 2) {
            long a2 = cBB().a(gVar);
            AppMethodBeat.o(88982);
            return a2;
        }
        a(gVar.mAppId, gVar);
        if (g.aAf().azp()) {
            g.aAf();
            if (!com.tencent.mm.kernel.a.azj()) {
                Log.i("MicroMsg.FileDownloadManager", "account ok, getDownloader");
                long a3 = cBw().a(gVar);
                AppMethodBeat.o(88982);
                return a3;
            }
        }
        long a4 = cBx().a(gVar);
        if (a4 >= 0) {
            qIr.put(Long.valueOf(a4), 0L);
            MMApplicationContext.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a4), 0).commit();
            Log.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", Long.valueOf(a4));
            AppMethodBeat.o(88982);
            return a4;
        }
        Log.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
        cBy().a(gVar);
        AppMethodBeat.o(88982);
        return a4;
    }

    public final long b(g gVar) {
        AppMethodBeat.i(88983);
        Log.i("MicroMsg.FileDownloadManager", "addDownloadTaskByCDNDownloader, appId = %s", gVar.mAppId);
        a(gVar.mAppId, gVar);
        if (g.aAf().azp()) {
            g.aAf();
            if (!com.tencent.mm.kernel.a.azj()) {
                long a2 = cBA().a(gVar);
                AppMethodBeat.o(88983);
                return a2;
            }
        }
        long a3 = cBx().a(gVar);
        if (a3 >= 0) {
            qIr.put(Long.valueOf(a3), 0L);
            MMApplicationContext.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a3), 0).commit();
            Log.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", Long.valueOf(a3));
            AppMethodBeat.o(88983);
            return a3;
        }
        Log.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
        cBy().a(gVar);
        AppMethodBeat.o(88983);
        return a3;
    }

    public final int Cn(long j2) {
        AppMethodBeat.i(88984);
        Log.i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = ".concat(String.valueOf(j2)));
        if (CB(j2)) {
            int Cn = cBx().Cn(j2);
            AppMethodBeat.o(88984);
            return Cn;
        }
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw != null && (Cw.field_downloadInWifi || Cw.field_reserveInWifi)) {
            Cw.field_downloadInWifi = false;
            Cw.field_reserveInWifi = false;
            d.e(Cw);
        }
        if (Cw == null || Cw.field_downloaderType != 3) {
            int Cn2 = cBw().Cn(j2);
            AppMethodBeat.o(88984);
            return Cn2;
        }
        int Cn3 = cBA().Cn(j2);
        AppMethodBeat.o(88984);
        return Cn3;
    }

    public final FileDownloadTaskInfo Co(long j2) {
        FileDownloadTaskInfo Co;
        AppMethodBeat.i(88985);
        if (CB(j2)) {
            FileDownloadTaskInfo Co2 = cBx().Co(j2);
            AppMethodBeat.o(88985);
            return Co2;
        }
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw != null && Cw.field_status == 3 && s.YS(Cw.field_filePath)) {
            Co = new FileDownloadTaskInfo();
            Co.id = j2;
            Co.url = Cw.field_downloadUrl;
            Co.status = 3;
            Co.path = Cw.field_filePath;
            Co.md5 = Cw.field_md5;
            Co.qJe = Cw.field_downloadedSize;
            Co.oJj = Cw.field_totalSize;
            Co.qJf = Cw.field_autoDownload;
            Co.dNv = Cw.field_downloaderType;
        } else if (Cw == null || Cw.field_downloaderType != 3) {
            Co = cBw().Co(j2);
            if (Cw != null) {
                Co.qJf = Cw.field_autoDownload;
                Co.dNv = Cw.field_downloaderType;
            }
        } else {
            Co = cBA().Co(j2);
        }
        if (Co == null) {
            Co = new FileDownloadTaskInfo();
        }
        if (Co.status == 3 || Co.status == 6) {
            if (!s.YS(Co.path)) {
                Co.status = 0;
            } else if (Co.status == 6) {
                Co.status = 1;
            }
        }
        if (Cw != null) {
            Co.qJg = Cw.field_downloadInWifi;
            Co.appId = Cw.field_appId;
            Co.qJh = Cw.field_reserveInWifi;
        }
        Log.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", Long.valueOf(Co.id), Co.url, Integer.valueOf(Co.status), Co.path, Co.md5, Long.valueOf(Co.oJj), Boolean.valueOf(Co.qJf), Integer.valueOf(Co.dNv));
        AppMethodBeat.o(88985);
        return Co;
    }

    public final FileDownloadTaskInfo alg(String str) {
        AppMethodBeat.i(88986);
        com.tencent.mm.plugin.downloader.g.a alb = d.alb(str);
        if (alb != null) {
            FileDownloadTaskInfo Co = Co(alb.field_downloadId);
            AppMethodBeat.o(88986);
            return Co;
        }
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        AppMethodBeat.o(88986);
        return fileDownloadTaskInfo;
    }

    public final FileDownloadTaskInfo alh(String str) {
        AppMethodBeat.i(88987);
        com.tencent.mm.plugin.downloader.g.a ale = d.ale(str);
        if (ale != null) {
            FileDownloadTaskInfo Co = Co(ale.field_downloadId);
            AppMethodBeat.o(88987);
            return Co;
        }
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        AppMethodBeat.o(88987);
        return fileDownloadTaskInfo;
    }

    public final boolean Cp(long j2) {
        AppMethodBeat.i(88989);
        Log.i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = ".concat(String.valueOf(j2)));
        CD(j2);
        if (CB(j2)) {
            boolean Cp = cBx().Cp(j2);
            AppMethodBeat.o(88989);
            return Cp;
        }
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw != null && (Cw.field_downloadInWifi || Cw.field_reserveInWifi)) {
            Cw.field_downloadInWifi = false;
            Cw.field_reserveInWifi = false;
            d.e(Cw);
        }
        if (Cw == null || Cw.field_downloaderType != 3) {
            boolean Cp2 = cBw().Cp(j2);
            AppMethodBeat.o(88989);
            return Cp2;
        }
        boolean Cp3 = cBA().Cp(j2);
        AppMethodBeat.o(88989);
        return Cp3;
    }

    public final boolean Cq(long j2) {
        AppMethodBeat.i(88990);
        Log.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(j2)));
        CD(j2);
        if (CB(j2)) {
            boolean Cq = cBx().Cq(j2);
            AppMethodBeat.o(88990);
            return Cq;
        }
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw != null && !Cw.field_reserveInWifi && Cw.field_downloadInWifi) {
            Cw.field_downloadInWifi = false;
            d.e(Cw);
        }
        if (Cw == null || Cw.field_downloaderType != 3) {
            boolean Cq2 = cBw().Cq(j2);
            AppMethodBeat.o(88990);
            return Cq2;
        }
        boolean n = cBA().n(j2, true);
        AppMethodBeat.o(88990);
        return n;
    }

    public static void a(m mVar) {
        AppMethodBeat.i(261890);
        c.a(mVar);
        AppMethodBeat.o(261890);
    }

    public static void b(m mVar) {
        AppMethodBeat.i(261891);
        c.b(mVar);
        AppMethodBeat.o(261891);
    }

    private static void cBC() {
        AppMethodBeat.i(88991);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("off_line_download_ids", 0);
        if (sharedPreferences == null) {
            AppMethodBeat.o(88991);
            return;
        }
        Map<String, ?> all = sharedPreferences.getAll();
        if (all == null || all.size() == 0) {
            AppMethodBeat.o(88991);
            return;
        }
        qIr.clear();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry != null && !Util.isNullOrNil(entry.getKey())) {
                try {
                    long j2 = Util.getLong(entry.getKey(), 0);
                    long longValue = ((Long) entry.getValue()).longValue();
                    long currentTimeMillis = System.currentTimeMillis() - j2;
                    if (currentTimeMillis - j2 > 0 && currentTimeMillis - j2 < Util.MILLSECONDS_OF_DAY) {
                        qIr.put(Long.valueOf(j2), Long.valueOf(longValue));
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.FileDownloadManager", "parse download task failed: " + e2.toString());
                    Log.printErrStackTrace("MicroMsg.FileDownloadManager", e2, "", new Object[0]);
                }
            }
        }
        sharedPreferences.edit().clear();
        for (Map.Entry<Long, Long> entry2 : qIr.entrySet()) {
            sharedPreferences.edit().putLong(new StringBuilder().append(entry2.getKey()).toString(), entry2.getValue().longValue());
        }
        sharedPreferences.edit().commit();
        AppMethodBeat.o(88991);
    }

    static void a(String str, String str2, String str3, PendingIntent pendingIntent) {
        AppMethodBeat.i(88992);
        s.c cd = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id");
        if (!TextUtils.isEmpty(str2)) {
            cd.f(str2);
        } else {
            com.tencent.mm.pluginsdk.model.app.g o = h.o(str, false, false);
            if (o == null || Util.isNullOrNil(o.field_appName)) {
                cd.f("");
            } else {
                cd.f(o.field_appName);
            }
        }
        cd.g(str3);
        cd.as(17301634);
        cd.E(true);
        if (pendingIntent != null) {
            cd.Hv = pendingIntent;
        } else {
            cd.Hv = PendingIntent.getActivity(MMApplicationContext.getContext(), 0, new Intent(), 0);
        }
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().c(cd.build());
        Log.i("MicroMsg.FileDownloadManager", "show notification");
        AppMethodBeat.o(88992);
    }

    static boolean CB(long j2) {
        AppMethodBeat.i(88993);
        boolean containsKey = qIr.containsKey(Long.valueOf(j2));
        AppMethodBeat.o(88993);
        return containsKey;
    }

    static void N(long j2, long j3) {
        AppMethodBeat.i(88994);
        qIr.put(Long.valueOf(j2), Long.valueOf(j3));
        MMApplicationContext.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(j2), j3).commit();
        AppMethodBeat.o(88994);
    }

    static long CC(long j2) {
        AppMethodBeat.i(88995);
        Long l = qIr.get(Long.valueOf(j2));
        if (l == null) {
            AppMethodBeat.o(88995);
            return -1;
        }
        long longValue = l.longValue();
        AppMethodBeat.o(88995);
        return longValue;
    }

    /* access modifiers changed from: package-private */
    public final void o(long j2, final boolean z) {
        final int bdO;
        AppMethodBeat.i(88996);
        Log.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", Long.valueOf(j2), Util.getStack());
        MMApplicationContext.getContext();
        if (CB(j2)) {
            this.qIy.c(j2, Co(j2).path, z);
            AppMethodBeat.o(88996);
            return;
        }
        final com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw == null) {
            AppMethodBeat.o(88996);
            return;
        }
        if (Util.isNullOrNil(Cw.field_packageName)) {
            String ali = ali(Cw.field_filePath);
            if (!Util.isNullOrNil(ali)) {
                Cw.field_packageName = ali;
                Log.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", Cw.field_filePath, ali);
                d.e(Cw);
            }
        }
        String str = Cw.field_filePath;
        if (Util.isNullOrNil(str)) {
            bdO = 0;
        } else {
            bdO = r.bdO(str);
            if (bdO == 0) {
                bdO = r.bdO(q.k(str, false));
            }
        }
        Log.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", Cw.field_packageName, Cw.field_filePath, Integer.valueOf(bdO));
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.f.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(88972);
                t tVar = g.aAg().hqi;
                if (tVar == null) {
                    AppMethodBeat.o(88972);
                    return;
                }
                com.tencent.mm.network.g gVar = tVar.iMw;
                if (gVar == null) {
                    AppMethodBeat.o(88972);
                    return;
                }
                new af(Cw.field_packageName, bdO).doScene(gVar, new i() {
                    /* class com.tencent.mm.plugin.downloader.model.f.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(88971);
                        qVar.setHasCallbackToQueue(true);
                        if (i2 == 0 && i3 == 0) {
                            String string = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.aps()).getString(Cw.field_packageName, "");
                            Log.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", string);
                            if (Util.isNullOrNil(string) || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(322, 26, 1, false);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 4026, String.format("%s,%s", Cw.field_packageName, Cw.field_filePath));
                            } else {
                                try {
                                    c.g(new File(com.tencent.mm.vfs.s.k(Cw.field_filePath, true)), string);
                                    Log.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(322, 25, 1, false);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 4025, String.format("%s,%s,%s", Cw.field_packageName, Cw.field_filePath, string));
                                } catch (Exception e2) {
                                    Log.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + e2.getMessage());
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(322, 27, 1, false);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 4027, String.format("%s,%s,%s", Cw.field_packageName, Cw.field_filePath, e2.getMessage()));
                                }
                            }
                        } else {
                            Log.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(322, 28, 1, false);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 4028, String.format("%s,%s,%d,%d", Cw.field_packageName, Cw.field_filePath, Integer.valueOf(i2), Integer.valueOf(i3)));
                            if (!Util.isNullOrNil(Cw.field_appId) && h.gq(Cw.field_appId)) {
                                Log.i("MicroMsg.FileDownloadManager", "onSceneEnd, fail, appId: %s", Cw.field_appId);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(710, 24, 1, false);
                            }
                        }
                        MMHandlerThread.postToMainThread(new Runnable(Cw, z) {
                            /* class com.tencent.mm.plugin.downloader.model.f.AnonymousClass2 */
                            final /* synthetic */ com.tencent.mm.plugin.downloader.g.a qIi;
                            final /* synthetic */ boolean qIn;

                            {
                                this.qIi = r2;
                                this.qIn = r3;
                            }

                            public final void run() {
                                AppMethodBeat.i(88973);
                                PendingIntent pendingIntent = null;
                                if (this.qIi.field_fileType == 1) {
                                    pendingIntent = f.a(this.qIi.field_filePath, this.qIi);
                                }
                                if (this.qIi.field_showNotification && !Util.isNullOrNil(this.qIi.field_notificationTitle)) {
                                    f.b(this.qIi.field_appId, this.qIi.field_notificationTitle, MMApplicationContext.getContext().getString(R.string.cdn), pendingIntent);
                                } else if (this.qIi.field_showNotification && Util.isNullOrNil(this.qIi.field_fileName)) {
                                    f.b(this.qIi.field_appId, MMApplicationContext.getContext().getString(R.string.cdn), "", pendingIntent);
                                } else if (this.qIi.field_showNotification && !Util.isNullOrNil(this.qIi.field_fileName)) {
                                    f.b(this.qIi.field_appId, this.qIi.field_fileName, MMApplicationContext.getContext().getString(R.string.cdn), pendingIntent);
                                }
                                if (this.qIi.field_autoInstall && this.qIi.field_fileType == 1 && !this.qIi.field_reserveInWifi) {
                                    f.i(this.qIi);
                                }
                                f.this.qIy.c(this.qIi.field_downloadId, this.qIi.field_filePath, this.qIn);
                                AppMethodBeat.o(88973);
                            }
                        });
                        AppMethodBeat.o(88971);
                    }
                });
                AppMethodBeat.o(88972);
            }
        });
        AppMethodBeat.o(88996);
    }

    public static String ali(String str) {
        AppMethodBeat.i(192260);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(192260);
            return "";
        }
        String bdN = r.bdN(str);
        if (Util.isNullOrNil(bdN)) {
            bdN = r.bdN(q.k(str, false));
        }
        AppMethodBeat.o(192260);
        return bdN;
    }

    private void a(String str, g gVar) {
        com.tencent.mm.plugin.downloader.g.a alb;
        AppMethodBeat.i(88997);
        if (!this.qIA && (alb = d.alb(str)) != null && alb.field_autoDownload) {
            ja jaVar = new ja();
            jaVar.dNH.dNI = str;
            EventCenter.instance.publish(jaVar);
            if (gVar != null) {
                alb.field_autoInstall = gVar.qIH;
                alb.field_showNotification = gVar.lCY;
                alb.field_autoDownload = gVar.qIJ;
            } else {
                alb.field_autoInstall = true;
                alb.field_showNotification = true;
                alb.field_autoDownload = false;
            }
            d.e(alb);
            Log.i("MicroMsg.FileDownloadManager", "remove silentDownload, appId:%s", str);
        }
        this.qIA = false;
        AppMethodBeat.o(88997);
    }

    private void CD(long j2) {
        AppMethodBeat.i(88998);
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw == null) {
            this.qIA = false;
            AppMethodBeat.o(88998);
            return;
        }
        a(Cw.field_appId, (g) null);
        AppMethodBeat.o(88998);
    }

    public final boolean Cr(long j2) {
        AppMethodBeat.i(88999);
        Log.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = ".concat(String.valueOf(j2)));
        if (CB(j2)) {
            AppMethodBeat.o(88999);
            return false;
        }
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw == null || Cw.field_downloaderType != 3) {
            boolean Cr = cBz().Cr(j2);
            AppMethodBeat.o(88999);
            return Cr;
        }
        boolean Cr2 = cBA().Cr(j2);
        AppMethodBeat.o(88999);
        return Cr2;
    }

    public final boolean h(com.tencent.mm.plugin.downloader.g.a aVar) {
        AppMethodBeat.i(89000);
        if (aVar == null || aVar.field_downloaderType != 3) {
            boolean n = cBz().n(aVar.field_downloadId, true);
            AppMethodBeat.o(89000);
            return n;
        }
        boolean n2 = cBA().n(aVar.field_downloadId, true);
        AppMethodBeat.o(89000);
        return n2;
    }

    public static LinkedList<FileDownloadTaskInfo> U(LinkedList<String> linkedList) {
        LinkedList linkedList2 = null;
        AppMethodBeat.i(88988);
        b aSU = d.aSU();
        if (aSU != null && !Util.isNullOrNil(linkedList)) {
            Cursor rawQuery = aSU.rawQuery(String.format("select * from %s where %s in %s or %s in %s", "FileDownloadInfo", "appId", b.W(linkedList), "rawAppId", b.W(linkedList)), new String[0]);
            if (rawQuery != null) {
                linkedList2 = new LinkedList();
                if (rawQuery.moveToFirst()) {
                    do {
                        com.tencent.mm.plugin.downloader.g.a aVar = new com.tencent.mm.plugin.downloader.g.a();
                        aVar.convertFrom(rawQuery);
                        linkedList2.add(aVar);
                    } while (rawQuery.moveToNext());
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        LinkedList<FileDownloadTaskInfo> linkedList3 = new LinkedList<>();
        if (linkedList2 != null && linkedList2.size() > 0) {
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.downloader.g.a aVar2 = (com.tencent.mm.plugin.downloader.g.a) it.next();
                FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
                if (aVar2.field_status != 3 || com.tencent.mm.vfs.s.YS(aVar2.field_filePath)) {
                    fileDownloadTaskInfo.status = aVar2.field_status;
                } else {
                    fileDownloadTaskInfo.status = 0;
                }
                fileDownloadTaskInfo.appId = aVar2.field_appId;
                fileDownloadTaskInfo.id = aVar2.field_downloadId;
                fileDownloadTaskInfo.url = aVar2.field_downloadUrl;
                fileDownloadTaskInfo.path = aVar2.field_filePath;
                fileDownloadTaskInfo.md5 = aVar2.field_md5;
                fileDownloadTaskInfo.qJe = aVar2.field_downloadedSize;
                fileDownloadTaskInfo.oJj = aVar2.field_totalSize;
                fileDownloadTaskInfo.qJf = aVar2.field_autoDownload;
                fileDownloadTaskInfo.dNv = aVar2.field_downloaderType;
                fileDownloadTaskInfo.qJg = aVar2.field_downloadInWifi;
                fileDownloadTaskInfo.qJh = aVar2.field_reserveInWifi;
                linkedList3.add(fileDownloadTaskInfo);
            }
        }
        AppMethodBeat.o(88988);
        return linkedList3;
    }

    static /* synthetic */ PendingIntent a(String str, com.tencent.mm.plugin.downloader.g.a aVar) {
        AppMethodBeat.i(89001);
        Intent intent = new Intent();
        Context context = MMApplicationContext.getContext();
        intent.setClass(context, FileDownloadPendingReceive.class);
        intent.putExtra(FileDownloadService.qJa, 3);
        intent.putExtra(FileDownloadService.qJb, str);
        intent.putExtra(FileDownloadService.qJc, aVar.field_md5);
        intent.putExtra("downloadId", aVar.field_downloadId);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, 0);
        AppMethodBeat.o(89001);
        return broadcast;
    }

    static /* synthetic */ void i(com.tencent.mm.plugin.downloader.g.a aVar) {
        AppMethodBeat.i(89003);
        if (Util.isNullOrNil(aVar.field_filePath)) {
            Log.e("MicroMsg.FileDownloadManager", "installApk, path is null");
            AppMethodBeat.o(89003);
            return;
        }
        Log.i("MicroMsg.FileDownloadManager", "APK File Path: %s", aVar.field_filePath);
        com.tencent.mm.plugin.downloader.i.a.a(aVar.field_downloadId, true, null);
        AppMethodBeat.o(89003);
    }
}
