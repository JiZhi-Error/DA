package com.tencent.mm.plugin.wepkg.model;

import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaz;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.mm.plugin.wepkg.event.c;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.List;

public class k {
    private static volatile k JNK = null;

    static /* synthetic */ void M(boolean z, String str) {
        AppMethodBeat.i(110757);
        L(z, str);
        AppMethodBeat.o(110757);
    }

    static /* synthetic */ void a(k kVar, String str, List list, boolean z) {
        AppMethodBeat.i(110758);
        kVar.c(str, list, z);
        AppMethodBeat.o(110758);
    }

    public static k gkU() {
        AppMethodBeat.i(110751);
        if (JNK == null) {
            synchronized (k.class) {
                try {
                    if (JNK == null) {
                        JNK = new k();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(110751);
                    throw th;
                }
            }
        }
        k kVar = JNK;
        AppMethodBeat.o(110751);
        return kVar;
    }

    public final void cW(final String str, final boolean z) {
        AppMethodBeat.i(110752);
        if (Util.isNullOrNil(str)) {
            L(z, str);
            AppMethodBeat.o(110752);
            return;
        }
        final AnonymousClass1 r10 = new a() {
            /* class com.tencent.mm.plugin.wepkg.model.k.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wepkg.model.a
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                AppMethodBeat.i(110748);
                if (this.object instanceof String) {
                    String str = (String) this.object;
                    k.n(str, baseWepkgProcessTask.result, !baseWepkgProcessTask.JMQ);
                    k.a(k.this, str, z);
                    AppMethodBeat.o(110748);
                    return;
                }
                k.M(z, str);
                AppMethodBeat.o(110748);
            }
        };
        r10.object = str;
        Log.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", str, Boolean.valueOf(z));
        if (Util.isNullOrNil(str)) {
            L(z, str);
            AppMethodBeat.o(110752);
            return;
        }
        Log.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", str, Boolean.valueOf(z));
        WepkgVersion bcH = j.bcH(str);
        if (bcH == null) {
            L(z, str);
            AppMethodBeat.o(110752);
        } else if (!bcH.JNV) {
            j.a(1, bcH.hhD, "", bcH.downloadUrl, (long) bcH.JNT, bcH.version, bcH.md5, bcH.JMZ, new a() {
                /* class com.tencent.mm.plugin.wepkg.model.k.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.wepkg.model.a
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                    AppMethodBeat.i(110749);
                    if (baseWepkgProcessTask instanceof WepkgDownloadProcessTask) {
                        WepkgDownloadProcessTask wepkgDownloadProcessTask = (WepkgDownloadProcessTask) baseWepkgProcessTask;
                        if (wepkgDownloadProcessTask.JNp != WePkgDownloader.IWepkgUpdateCallback.RetCode.OK || Util.isNullOrNil(wepkgDownloadProcessTask.eig) || Util.isNullOrNil(wepkgDownloadProcessTask.pkgPath)) {
                            if (r10 != null) {
                                WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                                wepkgCrossProcessTask.result = false;
                                r10.a(wepkgCrossProcessTask);
                            }
                            k.M(z, str);
                            AppMethodBeat.o(110749);
                            return;
                        }
                        j.a(wepkgDownloadProcessTask.eig, wepkgDownloadProcessTask.pkgPath, true, r10);
                        AppMethodBeat.o(110749);
                        return;
                    }
                    k.M(z, str);
                    AppMethodBeat.o(110749);
                }
            });
            AppMethodBeat.o(110752);
        } else {
            WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
            wepkgCrossProcessTask.result = true;
            wepkgCrossProcessTask.JMQ = true;
            r10.a(wepkgCrossProcessTask);
            AppMethodBeat.o(110752);
        }
    }

    private void c(final String str, final List<WepkgPreloadFile> list, final boolean z) {
        AppMethodBeat.i(110753);
        try {
            if (Util.isNullOrNil(list)) {
                Log.i("MicroMsg.Wepkg.WepkgUpdater", "loopDownload WepkgPreloadFile is empty");
                if (Util.isNullOrNil(str)) {
                    L(z, str);
                    AppMethodBeat.o(110753);
                    return;
                }
                List<WepkgPreloadFile> bcJ = j.bcJ(str);
                if (Util.isNullOrNil(bcJ)) {
                    WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask.EX = 3006;
                    wepkgCrossProcessTask.JNh.hhD = str;
                    wepkgCrossProcessTask.JNh.JNW = true;
                    if (MMApplicationContext.isMMProcess()) {
                        wepkgCrossProcessTask.bjj();
                    } else {
                        AppBrandMainProcessService.b(wepkgCrossProcessTask);
                    }
                    WepkgVersion bcH = j.bcH(str);
                    if (!(bcH == null || bcH.createTime == 0)) {
                        a.b("downloadCompleteTime", "", bcH.hhD, bcH.version, -1, System.currentTimeMillis() - (bcH.createTime * 1000), null);
                        WepkgCrossProcessTask wepkgCrossProcessTask2 = new WepkgCrossProcessTask();
                        wepkgCrossProcessTask2.EX = TXLiteAVCode.WARNING_RTMP_READ_FAIL;
                        wepkgCrossProcessTask2.JNh.hhD = str;
                        if (MMApplicationContext.isMMProcess()) {
                            wepkgCrossProcessTask2.bjj();
                        } else {
                            AppBrandMainProcessService.b(wepkgCrossProcessTask2);
                        }
                    }
                    L(z, str);
                    Log.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:true");
                    AppMethodBeat.o(110753);
                    return;
                }
                Log.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", Integer.valueOf(bcJ.size()));
                L(z, str);
                AppMethodBeat.o(110753);
                return;
            }
            WepkgPreloadFile remove = list.remove(0);
            if (remove != null) {
                Log.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", remove.hhD, remove.version, remove.JNn);
                AnonymousClass3 r11 = new a() {
                    /* class com.tencent.mm.plugin.wepkg.model.k.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.wepkg.model.a
                    public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                        AppMethodBeat.i(110750);
                        if (!(this.object instanceof WepkgPreloadFile) || !(baseWepkgProcessTask instanceof WepkgDownloadProcessTask)) {
                            Log.i("MicroMsg.Wepkg.WepkgUpdater", "object instanceof  WepkgPreloadFile is false");
                            k.a(k.this, str, list, z);
                            AppMethodBeat.o(110750);
                            return;
                        }
                        WepkgDownloadProcessTask wepkgDownloadProcessTask = (WepkgDownloadProcessTask) baseWepkgProcessTask;
                        WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) this.object;
                        if (wepkgDownloadProcessTask.JNp != WePkgDownloader.IWepkgUpdateCallback.RetCode.OK || Util.isNullOrNil(wepkgDownloadProcessTask.pkgPath)) {
                            Log.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", wepkgDownloadProcessTask.JNp);
                            k.a(k.this, str, list, z);
                            AppMethodBeat.o(110750);
                            return;
                        }
                        String str = wepkgPreloadFile.hhD;
                        String str2 = wepkgPreloadFile.JNn;
                        String str3 = wepkgDownloadProcessTask.pkgPath;
                        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                        wepkgCrossProcessTask.EX = 4002;
                        wepkgCrossProcessTask.JNk.hhD = str;
                        wepkgCrossProcessTask.JNk.JNn = str2;
                        wepkgCrossProcessTask.JNk.filePath = str3;
                        wepkgCrossProcessTask.JNk.JNA = true;
                        if (MMApplicationContext.isMMProcess()) {
                            wepkgCrossProcessTask.bjj();
                        } else {
                            AppBrandMainProcessService.b(wepkgCrossProcessTask);
                        }
                        k.a(k.this, str, list, z);
                        AppMethodBeat.o(110750);
                    }
                };
                r11.object = remove;
                j.a(2, remove.hhD, remove.JNn, remove.downloadUrl, (long) remove.size, remove.version, remove.md5, remove.JMZ, r11);
                AppMethodBeat.o(110753);
                return;
            }
            Log.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
            c(str, list, z);
            AppMethodBeat.o(110753);
        } catch (Exception e2) {
            Log.e("MicroMsg.Wepkg.WepkgUpdater", "loopDownload err:%s", e2.getMessage());
            AppMethodBeat.o(110753);
        }
    }

    private static void L(boolean z, String str) {
        AppMethodBeat.i(110754);
        if (z) {
            aaz aaz = new aaz();
            aaz.eif.dDe = 0;
            EventCenter.instance.publish(aaz);
        }
        j.bcM(str);
        c.gkN().aH(str, 3, 6);
        AppMethodBeat.o(110754);
    }

    static /* synthetic */ void n(String str, boolean z, boolean z2) {
        AppMethodBeat.i(200175);
        Log.i("MicroMsg.Wepkg.WepkgUpdater", "notifyBigPkgDownloadComplete: ".concat(String.valueOf(str)));
        c.a(new DownloadBigPkgCompleteNotify(str, z, z2), null);
        Log.i("MicroMsg.Wepkg.WepkgUpdater", "updateLiteApp, pkgId : %s, success : %b, haveDownloadAction : %b", str, Boolean.valueOf(z), Boolean.valueOf(z2));
        if (!z || !z2) {
            AppMethodBeat.o(200175);
            return;
        }
        WepkgVersion bcI = j.bcI(str);
        if (bcI == null) {
            Log.e("MicroMsg.Wepkg.WepkgUpdater", "updateLiteApp, wepkgVersion is null");
            AppMethodBeat.o(200175);
        } else if (Util.isNullOrNil(bcI.pkgPath)) {
            Log.e("MicroMsg.Wepkg.WepkgUpdater", "pkgPath is null");
            AppMethodBeat.o(200175);
        } else {
            o oVar = new o(bcI.pkgPath);
            if (!oVar.exists()) {
                Log.e("MicroMsg.Wepkg.WepkgUpdater", "file not exists");
                AppMethodBeat.o(200175);
                return;
            }
            g gVar = new g(oVar);
            if (gVar.kKk) {
                Iterator<d> it = gVar.gkS().iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    f.ecC();
                    WxaLiteAppInfo aCT = f.aCT(next.izu);
                    if (aCT != null && aCT.cri.equals(next.cri)) {
                        Log.i("MicroMsg.GameCenterLiteAppManager", "updateLiteAppInfo, patchId is same : ", next.cri);
                    }
                    WxaLiteAppInfo wxaLiteAppInfo = new WxaLiteAppInfo();
                    wxaLiteAppInfo.appId = next.izu;
                    wxaLiteAppInfo.cri = next.cri;
                    wxaLiteAppInfo.path = next.filePath;
                    wxaLiteAppInfo.crh = next.JMW;
                    wxaLiteAppInfo.type = "release";
                    wxaLiteAppInfo.crj = System.currentTimeMillis();
                    f.ecC();
                    f.b(wxaLiteAppInfo);
                }
            }
            AppMethodBeat.o(200175);
        }
    }

    static /* synthetic */ void a(k kVar, String str, boolean z) {
        AppMethodBeat.i(110756);
        if (Util.isNullOrNil(str)) {
            L(z, str);
            AppMethodBeat.o(110756);
            return;
        }
        Log.i("MicroMsg.Wepkg.WepkgUpdater", "update preload files. pkgid:%s, isAutoUpdate:%s", str, Boolean.valueOf(z));
        List<WepkgPreloadFile> bcJ = j.bcJ(str);
        if (!Util.isNullOrNil(bcJ)) {
            Log.i("MicroMsg.Wepkg.WepkgUpdater", "pkgid:%s, %s preload files need to download", str, Integer.valueOf(bcJ.size()));
        }
        kVar.c(str, bcJ, z);
        AppMethodBeat.o(110756);
    }
}
