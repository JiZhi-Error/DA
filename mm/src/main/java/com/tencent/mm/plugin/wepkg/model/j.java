package com.tencent.mm.plugin.wepkg.model;

import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.protocal.protobuf.fbd;
import com.tencent.mm.protocal.protobuf.fbf;
import com.tencent.mm.protocal.protobuf.fbg;
import com.tencent.mm.protocal.protobuf.fbh;
import com.tencent.mm.protocal.protobuf.fbi;
import com.tencent.mm.protocal.protobuf.fbj;
import com.tencent.mm.protocal.protobuf.fbk;
import com.tencent.mm.protocal.protobuf.fbl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j {
    public static WepkgVersion bcH(String str) {
        AppMethodBeat.i(110737);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.EX = 3001;
        wepkgCrossProcessTask.JNh.hhD = str;
        if (MMApplicationContext.isMMProcess()) {
            wepkgCrossProcessTask.bjj();
        } else {
            AppBrandMainProcessService.b(wepkgCrossProcessTask);
        }
        if (wepkgCrossProcessTask.JNh == null) {
            AppMethodBeat.o(110737);
            return null;
        }
        WepkgVersion wepkgVersion = wepkgCrossProcessTask.JNh;
        AppMethodBeat.o(110737);
        return wepkgVersion;
    }

    public static WepkgVersion bcI(String str) {
        AppMethodBeat.i(110738);
        Log.printInfoStack("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "getWepkgVersionRecordWithAble", new Object[0]);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.EX = 3002;
        wepkgCrossProcessTask.JNh.hhD = str;
        if (MMApplicationContext.isMMProcess()) {
            wepkgCrossProcessTask.bjj();
        } else {
            AppBrandMainProcessService.b(wepkgCrossProcessTask);
        }
        if (wepkgCrossProcessTask.JNh == null) {
            AppMethodBeat.o(110738);
            return null;
        }
        WepkgVersion wepkgVersion = wepkgCrossProcessTask.JNh;
        AppMethodBeat.o(110738);
        return wepkgVersion;
    }

    public static void a(String str, final a aVar) {
        AppMethodBeat.i(110739);
        Log.printInfoStack("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "getWepkgVersionRecordWithAbleAsync", new Object[0]);
        final WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.EX = 3002;
        wepkgCrossProcessTask.JNh.hhD = str;
        if (MMApplicationContext.isMMProcess()) {
            wepkgCrossProcessTask.bjj();
            AppMethodBeat.o(110739);
            return;
        }
        wepkgCrossProcessTask.lyv = new Runnable() {
            /* class com.tencent.mm.plugin.wepkg.model.j.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(110732);
                if (aVar != null) {
                    aVar.a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.bDK();
                AppMethodBeat.o(110732);
            }
        };
        wepkgCrossProcessTask.bDJ();
        AppBrandMainProcessService.a(wepkgCrossProcessTask);
        AppMethodBeat.o(110739);
    }

    public static void a(String str, String str2, boolean z, final a aVar) {
        AppMethodBeat.i(110740);
        final WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.EX = 3005;
        wepkgCrossProcessTask.JNh.hhD = str;
        wepkgCrossProcessTask.JNh.pkgPath = str2;
        wepkgCrossProcessTask.JNh.JNV = z;
        if (MMApplicationContext.isMMProcess()) {
            d.cyh().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.wepkg.model.j.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(110733);
                    wepkgCrossProcessTask.bjj();
                    if (aVar != null) {
                        aVar.a(wepkgCrossProcessTask);
                    }
                    AppMethodBeat.o(110733);
                }
            });
            AppMethodBeat.o(110740);
            return;
        }
        wepkgCrossProcessTask.lyv = new Runnable() {
            /* class com.tencent.mm.plugin.wepkg.model.j.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(110734);
                if (aVar != null) {
                    aVar.a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.bDK();
                AppMethodBeat.o(110734);
            }
        };
        wepkgCrossProcessTask.bDJ();
        AppBrandMainProcessService.a(wepkgCrossProcessTask);
        AppMethodBeat.o(110740);
    }

    public static void a(final int i2, final String str, final String str2, final String str3, final long j2, final String str4, final String str5, final int i3, final a aVar) {
        AppMethodBeat.i(110741);
        final WepkgDownloadProcessTask wepkgDownloadProcessTask = new WepkgDownloadProcessTask();
        wepkgDownloadProcessTask.fileType = i2;
        wepkgDownloadProcessTask.eig = str;
        wepkgDownloadProcessTask.downloadUrl = str3;
        wepkgDownloadProcessTask.JNo = j2;
        wepkgDownloadProcessTask.version = str4;
        wepkgDownloadProcessTask.md5 = str5;
        wepkgDownloadProcessTask.JMZ = i3;
        if (MMApplicationContext.isMMProcess()) {
            d.cyh().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.wepkg.model.j.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(110725);
                    AnonymousClass1 r12 = new WePkgDownloader.IWepkgUpdateCallback() {
                        /* class com.tencent.mm.plugin.wepkg.model.j.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback
                        public final void a(String str, String str2, WePkgDownloader.IWepkgUpdateCallback.RetCode retCode) {
                            AppMethodBeat.i(110724);
                            Log.i("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "onPkgUpdatingCallback errCode:%s", retCode);
                            wepkgDownloadProcessTask.eig = str;
                            wepkgDownloadProcessTask.pkgPath = str2;
                            wepkgDownloadProcessTask.JNp = retCode;
                            if (aVar != null) {
                                aVar.a(wepkgDownloadProcessTask);
                            }
                            AppMethodBeat.o(110724);
                        }
                    };
                    if (i2 == 1) {
                        WePkgDownloader.gkM().a(str, r12);
                        AppMethodBeat.o(110725);
                        return;
                    }
                    WePkgDownloader.gkM().a(i2, Util.nullAsNil(str), "", Util.nullAsNil(str2), Util.nullAsNil(str3), j2, Util.nullAsNil(str4), "", Util.nullAsNil(str5), i3, r12);
                    AppMethodBeat.o(110725);
                }
            });
            AppMethodBeat.o(110741);
            return;
        }
        wepkgDownloadProcessTask.lyv = new Runnable() {
            /* class com.tencent.mm.plugin.wepkg.model.j.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(110726);
                if (aVar != null) {
                    aVar.a(wepkgDownloadProcessTask);
                }
                wepkgDownloadProcessTask.bDK();
                AppMethodBeat.o(110726);
            }
        };
        wepkgDownloadProcessTask.bDJ();
        AppBrandMainProcessService.a(wepkgDownloadProcessTask);
        AppMethodBeat.o(110741);
    }

    public static void a(dbq dbq, int i2) {
        AppMethodBeat.i(110742);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.EX = 2002;
        WepkgVersion wepkgVersion = wepkgCrossProcessTask.JNh;
        if (dbq != null) {
            wepkgVersion.hhD = dbq.xJD;
            fbi fbi = dbq.MGz;
            fbl fbl = dbq.MGA;
            if (fbi != null) {
                wepkgVersion.appId = fbi.jfi;
                fbf fbf = fbi.NxD;
                if (fbf != null) {
                    wepkgVersion.version = fbf.Nxw;
                    wepkgVersion.JNP = fbf.Nxx;
                    wepkgVersion.JNQ = (long) fbf.Nxy;
                    wepkgVersion.JNR = (long) fbf.Nxz;
                }
            }
            if (fbl != null) {
                wepkgVersion.domain = fbl.NxG;
                wepkgVersion.charset = fbl.Nvi;
                fbd fbd = fbl.NxH;
                if (fbd == null || fbd.Nxt == null || Util.isNullOrNil(fbd.Nxt.xuc)) {
                    wepkgVersion.JNV = true;
                } else {
                    wepkgVersion.md5 = fbd.Nxt.Md5;
                    wepkgVersion.downloadUrl = fbd.Nxt.xuc;
                    wepkgVersion.JNT = fbd.Nxt.NxB;
                    wepkgVersion.JMZ = fbd.Nxt.NxA;
                    wepkgVersion.JNV = false;
                }
                fbk fbk = fbl.NxI;
                if (fbk != null) {
                    wepkgVersion.JNX = fbk.NxF;
                }
                if (fbk == null || Util.isNullOrNil(fbk.NxE) || !fbk.NxF) {
                    wepkgVersion.JNW = true;
                } else {
                    wepkgVersion.JNW = false;
                }
                wepkgVersion.JNY = 0;
            }
            wepkgVersion.eij = i2;
        }
        WePkgDiffInfo wePkgDiffInfo = wepkgCrossProcessTask.JNj;
        if (!(dbq == null || dbq.MGA == null || dbq.MGA.NxH == null || dbq.MGA.NxH.Nxt == null || dbq.MGA.NxH.Nxt.NxC == null || Util.isNullOrNil(dbq.MGA.NxH.Nxt.NxC.xuc))) {
            fbj fbj = dbq.MGA.NxH.Nxt.NxC;
            wePkgDiffInfo.version = dbq.MGz.NxD.Nxw;
            wePkgDiffInfo.hhD = dbq.xJD;
            wePkgDiffInfo.downloadUrl = fbj.xuc;
            wePkgDiffInfo.md5 = fbj.Md5;
            wePkgDiffInfo.fileSize = fbj.NxB;
            wePkgDiffInfo.JMZ = fbj.NxA;
        }
        fbk fbk2 = dbq.MGA.NxI;
        if (fbk2 != null && !Util.isNullOrNil(fbk2.NxE)) {
            ArrayList arrayList = new ArrayList();
            Iterator<fbh> it = fbk2.NxE.iterator();
            while (it.hasNext()) {
                fbh next = it.next();
                WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile();
                String str = dbq.xJD;
                String str2 = dbq.MGz.NxD.Nxw;
                if (next != null) {
                    wepkgPreloadFile.key = d.mv(str, next.LzG);
                    wepkgPreloadFile.hhD = str;
                    wepkgPreloadFile.version = str2;
                    wepkgPreloadFile.JNn = next.LzG;
                    wepkgPreloadFile.mimeType = next.LzI;
                    fbg fbg = next.Nxt;
                    if (fbg != null) {
                        wepkgPreloadFile.md5 = fbg.Md5;
                        wepkgPreloadFile.downloadUrl = fbg.xuc;
                        wepkgPreloadFile.size = fbg.NxB;
                        wepkgPreloadFile.JMZ = fbg.NxA;
                    }
                    wepkgPreloadFile.JNA = false;
                }
                arrayList.add(wepkgPreloadFile);
            }
            wepkgCrossProcessTask.JNl = arrayList;
        }
        if (MMApplicationContext.isMMProcess()) {
            wepkgCrossProcessTask.bjj();
            AppMethodBeat.o(110742);
            return;
        }
        AppBrandMainProcessService.b(wepkgCrossProcessTask);
        AppMethodBeat.o(110742);
    }

    public static List<WepkgPreloadFile> bcJ(String str) {
        AppMethodBeat.i(110743);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.EX = 4001;
        wepkgCrossProcessTask.JNh.hhD = str;
        if (MMApplicationContext.isMMProcess()) {
            wepkgCrossProcessTask.bjj();
        } else {
            AppBrandMainProcessService.b(wepkgCrossProcessTask);
        }
        List<WepkgPreloadFile> list = wepkgCrossProcessTask.JNl;
        AppMethodBeat.o(110743);
        return list;
    }

    public static void a(String str, String str2, String str3, final a aVar) {
        AppMethodBeat.i(110744);
        final WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.EX = 4002;
        wepkgCrossProcessTask.JNk.hhD = str;
        wepkgCrossProcessTask.JNk.JNn = str2;
        wepkgCrossProcessTask.JNk.filePath = str3;
        wepkgCrossProcessTask.JNk.JNA = false;
        if (MMApplicationContext.isMMProcess()) {
            d.cyh().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.wepkg.model.j.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(110727);
                    wepkgCrossProcessTask.bjj();
                    if (aVar != null) {
                        aVar.a(wepkgCrossProcessTask);
                    }
                    AppMethodBeat.o(110727);
                }
            });
            AppMethodBeat.o(110744);
            return;
        }
        wepkgCrossProcessTask.lyv = new Runnable() {
            /* class com.tencent.mm.plugin.wepkg.model.j.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(110728);
                if (aVar != null) {
                    aVar.a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.bDK();
                AppMethodBeat.o(110728);
            }
        };
        wepkgCrossProcessTask.bDJ();
        AppBrandMainProcessService.a(wepkgCrossProcessTask);
        AppMethodBeat.o(110744);
    }

    public static void bcK(String str) {
        AppMethodBeat.i(110745);
        final WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.EX = 3003;
        wepkgCrossProcessTask.JNh.hhD = str;
        if (MMApplicationContext.isMMProcess()) {
            d.cyh().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.wepkg.model.j.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(110729);
                    wepkgCrossProcessTask.bjj();
                    AppMethodBeat.o(110729);
                }
            });
            AppMethodBeat.o(110745);
            return;
        }
        AppBrandMainProcessService.a(wepkgCrossProcessTask);
        AppMethodBeat.o(110745);
    }

    public static List<WepkgPreloadFile> bcL(String str) {
        AppMethodBeat.i(110746);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.EX = WearableStatusCodes.DATA_ITEM_TOO_LARGE;
        wepkgCrossProcessTask.JNh.hhD = str;
        if (MMApplicationContext.isMMProcess()) {
            wepkgCrossProcessTask.bjj();
        } else {
            AppBrandMainProcessService.b(wepkgCrossProcessTask);
        }
        List<WepkgPreloadFile> list = wepkgCrossProcessTask.JNl;
        AppMethodBeat.o(110746);
        return list;
    }

    public static void bcM(String str) {
        AppMethodBeat.i(110747);
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.EX = 2006;
        wepkgCrossProcessTask.JNh.hhD = str;
        if (MMApplicationContext.isMMProcess()) {
            wepkgCrossProcessTask.bjj();
            AppMethodBeat.o(110747);
            return;
        }
        AppBrandMainProcessService.b(wepkgCrossProcessTask);
        AppMethodBeat.o(110747);
    }
}
