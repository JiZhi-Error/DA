package com.tencent.mm.plugin.downloader;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.plugin.downloader.a.e;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.commlib.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginDownloader extends f implements c, e {
    private static o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.downloader.PluginDownloader.AnonymousClass1 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(88821);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!a.azj()) {
                    ((d) g.af(d.class)).kR(true);
                }
            }
            AppMethodBeat.o(88821);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(88822);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!a.azj()) {
                    ((d) g.af(d.class)).kR(false);
                }
            }
            AppMethodBeat.o(88822);
        }
    };
    private static a qFe;

    static /* synthetic */ void access$000(PluginDownloader pluginDownloader) {
        AppMethodBeat.i(88829);
        pluginDownloader.checkMD5CheckingTasks();
        AppMethodBeat.o(88829);
    }

    static /* synthetic */ void access$100(PluginDownloader pluginDownloader) {
        AppMethodBeat.i(88830);
        pluginDownloader.resumeDownloadTaskWhenProcessRestart();
        AppMethodBeat.o(88830);
    }

    static {
        AppMethodBeat.i(88831);
        AppMethodBeat.o(88831);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(192248);
        y.b("CDNDownloadBigFile", "BigFile", 2592000000L, 55);
        AppMethodBeat.o(192248);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(88824);
        Log.d("MicroMsg.PluginDownloader", "execute");
        if (gVar.aBb()) {
            g.b(d.class, new b());
            g.b(com.tencent.mm.plugin.cdndownloader.b.a.class, new com.tencent.mm.plugin.cdndownloader.a());
            a aVar = new a(b.qIb);
            qFe = aVar;
            aVar.startWatching();
        }
        AppMethodBeat.o(88824);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(88825);
        Log.i("MicroMsg.PluginDownloader", "onAccountInitialized");
        com.tencent.mm.plugin.downloader.e.a.cBn();
        appForegroundListener.alive();
        com.tencent.mm.plugin.game.commlib.c.a.dTf().a("md5_check", new a.AbstractC1395a() {
            /* class com.tencent.mm.plugin.downloader.PluginDownloader.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.game.commlib.c.a.AbstractC1395a
            public final void cBm() {
                AppMethodBeat.i(192245);
                com.tencent.mm.plugin.cdndownloader.g.a.cyh().postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.downloader.PluginDownloader.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(192244);
                        PluginDownloader.access$000(PluginDownloader.this);
                        AppMethodBeat.o(192244);
                    }
                }, 0);
                AppMethodBeat.o(192245);
            }
        });
        com.tencent.mm.plugin.game.commlib.c.a.dTf().a("download_resume", new a.AbstractC1395a() {
            /* class com.tencent.mm.plugin.downloader.PluginDownloader.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.game.commlib.c.a.AbstractC1395a
            public final void cBm() {
                AppMethodBeat.i(192247);
                com.tencent.mm.plugin.cdndownloader.g.a.cyh().postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.downloader.PluginDownloader.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(192246);
                        PluginDownloader.access$100(PluginDownloader.this);
                        AppMethodBeat.o(192246);
                    }
                }, 0);
                AppMethodBeat.o(192247);
            }
        });
        com.tencent.mm.plugin.downloader.b.a.cBn();
        AppMethodBeat.o(88825);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(88826);
        Log.i("MicroMsg.PluginDownloader", "onAccountRelease");
        com.tencent.mm.plugin.downloader.e.a.cBo();
        appForegroundListener.dead();
        com.tencent.mm.plugin.downloader.b.a.cBo();
        com.tencent.mm.plugin.downloader.a.c.clearCache();
        AppMethodBeat.o(88826);
    }

    private void checkMD5CheckingTasks() {
        LinkedList linkedList;
        AppMethodBeat.i(88827);
        com.tencent.mm.plugin.downloader.g.b aSU = com.tencent.mm.plugin.downloader.model.d.aSU();
        if (aSU == null) {
            linkedList = null;
        } else {
            Log.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status=6")));
            Cursor rawQuery = aSU.rawQuery("select * from FileDownloadInfo where status=6", new String[0]);
            linkedList = new LinkedList();
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    com.tencent.mm.plugin.downloader.g.a aVar = new com.tencent.mm.plugin.downloader.g.a();
                    aVar.convertFrom(rawQuery);
                    linkedList.add(aVar);
                }
                rawQuery.close();
            }
        }
        if (!Util.isNullOrNil(linkedList)) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                Intent intent = new Intent();
                intent.putExtra(FileDownloadService.qJa, 1);
                intent.setClass(MMApplicationContext.getContext(), FileDownloadService.class);
                intent.putExtra(FileDownloadService.EXTRA_ID, ((com.tencent.mm.plugin.downloader.g.a) it.next()).field_downloadId);
                try {
                    com.tencent.mm.br.c.startService(intent);
                } catch (Exception e2) {
                    Log.e("MicroMsg.PluginDownloader", e2.getMessage());
                }
                h.INSTANCE.idkeyStat(710, 25, 1, false);
            }
        }
        AppMethodBeat.o(88827);
    }

    private void resumeDownloadTaskWhenProcessRestart() {
        LinkedList linkedList;
        AppMethodBeat.i(88828);
        com.tencent.mm.plugin.downloader.g.b aSU = com.tencent.mm.plugin.downloader.model.d.aSU();
        if (aSU == null) {
            linkedList = null;
        } else {
            Log.i("MicroMsg.FileDownloadInfoStorage", "getRunningDownloadInfos: select * from FileDownloadInfo where status=1");
            Cursor rawQuery = aSU.rawQuery("select * from FileDownloadInfo where status=1", new String[0]);
            if (rawQuery == null) {
                Log.i("MicroMsg.FileDownloadInfoStorage", "cursor is null");
                linkedList = null;
            } else {
                linkedList = new LinkedList();
                while (rawQuery.moveToNext()) {
                    com.tencent.mm.plugin.downloader.g.a aVar = new com.tencent.mm.plugin.downloader.g.a();
                    aVar.convertFrom(rawQuery);
                    linkedList.add(aVar);
                }
                rawQuery.close();
            }
        }
        if (!Util.isNullOrNil(linkedList)) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.downloader.g.a aVar2 = (com.tencent.mm.plugin.downloader.g.a) it.next();
                Log.i("MicroMsg.PluginDownloader", "resumeDownloadTaskWhenProcessRestart, downloadid : %d, appid : %s, status : %d", Long.valueOf(aVar2.field_downloadId), aVar2.field_appId, Integer.valueOf(aVar2.field_status));
                if (com.tencent.mm.plugin.downloader.model.d.alf(aVar2.field_downloadUrl)) {
                    Log.i("MicroMsg.PluginDownloader", "hasDuplicatedTask");
                    com.tencent.mm.plugin.downloader.model.d.alc(aVar2.field_downloadUrl);
                    h.INSTANCE.idkeyStat(710, 26, 1, false);
                } else {
                    com.tencent.mm.plugin.downloader.f.b bVar = new com.tencent.mm.plugin.downloader.f.b();
                    bVar.k(aVar2);
                    com.tencent.mm.plugin.downloader.f.a.a(20, bVar);
                    FileDownloadTaskInfo Co = com.tencent.mm.plugin.downloader.model.f.cBv().Co(aVar2.field_downloadId);
                    if (Co.status == 3) {
                        Log.i("MicroMsg.PluginDownloader", "has download finish");
                        aVar2.field_finishTime = System.currentTimeMillis();
                        aVar2.field_downloadedSize = aVar2.field_totalSize;
                        aVar2.field_status = 6;
                        Log.i("MicroMsg.PluginDownloader", "download succeed, downloadedSize = %d, startSize = %d", Long.valueOf(aVar2.field_downloadedSize), Long.valueOf(aVar2.field_startSize));
                        com.tencent.mm.plugin.downloader.model.d.e(aVar2);
                        com.tencent.mm.plugin.downloader.model.f cBv = com.tencent.mm.plugin.downloader.model.f.cBv();
                        long j2 = aVar2.field_downloadId;
                        if (cBv.qIy != null) {
                            cBv.qIy.Cv(j2);
                        }
                        Intent intent = new Intent();
                        intent.putExtra(FileDownloadService.qJa, 1);
                        intent.setClass(MMApplicationContext.getContext(), FileDownloadService.class);
                        intent.putExtra(FileDownloadService.EXTRA_ID, aVar2.field_downloadId);
                        try {
                            com.tencent.mm.br.c.startService(intent);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.PluginDownloader", e2.getMessage());
                        }
                        h.INSTANCE.idkeyStat(710, 12, 1, false);
                    } else if (Co.status != 1) {
                        h.INSTANCE.idkeyStat(710, 14, 1, false);
                        Log.i("MicroMsg.PluginDownloader", "download fail, all process dead, appId: " + aVar2.field_appId);
                        long currentTimeMillis = (System.currentTimeMillis() - aVar2.field_updateTime) / 1000;
                        Log.i("MicroMsg.PluginDownloader", "lastTime = ".concat(String.valueOf(currentTimeMillis)));
                        if (currentTimeMillis <= 1800) {
                            boolean a2 = ((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_download_resume_not_in_wifi, false);
                            Log.i("MicroMsg.PluginDownloader", "in half hour, net: %s, downloadInWifi: %b, expt: %b", NetStatusUtil.getNetTypeString(MMApplicationContext.getContext()), Boolean.valueOf(Co.qJg), Boolean.valueOf(a2));
                            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                                Log.i("MicroMsg.PluginDownloader", "in half hour, in wifi, restart");
                                com.tencent.mm.plugin.downloader.model.f.cBv().Cr(aVar2.field_downloadId);
                                h.INSTANCE.idkeyStat(710, 15, 1, false);
                            } else if (Co.qJg || !a2) {
                                h.INSTANCE.idkeyStat(710, 17, 1, false);
                            } else {
                                Log.i("MicroMsg.PluginDownloader", "download not in wifi");
                                com.tencent.mm.plugin.downloader.model.f.cBv().Cr(aVar2.field_downloadId);
                                h.INSTANCE.idkeyStat(710, 19, 1, false);
                            }
                        } else {
                            h.INSTANCE.idkeyStat(710, 16, 1, false);
                            if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                                h.INSTANCE.idkeyStat(710, 17, 1, false);
                            }
                        }
                        aVar2.field_finishTime = System.currentTimeMillis();
                        aVar2.field_status = 4;
                        aVar2.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFq;
                        com.tencent.mm.plugin.downloader.model.d.e(aVar2);
                        com.tencent.mm.plugin.downloader.model.f cBv2 = com.tencent.mm.plugin.downloader.model.f.cBv();
                        long j3 = aVar2.field_downloadId;
                        int i2 = aVar2.field_errCode;
                        if (cBv2.qIy != null) {
                            cBv2.qIy.c(j3, i2, false);
                        }
                    } else {
                        Log.i("MicroMsg.PluginDownloader", "download process alive, still downloading: " + aVar2.field_appId);
                        h.INSTANCE.idkeyStat(710, 13, 1, false);
                    }
                }
            }
        }
        AppMethodBeat.o(88828);
    }
}
