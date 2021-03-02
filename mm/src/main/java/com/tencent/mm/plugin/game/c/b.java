package com.tencent.mm.plugin.game.c;

import android.database.Cursor;
import android.os.Build;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.game.b.a.e;
import com.tencent.mm.plugin.game.b.a.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/game/download/GameResourceDownloadManager;", "", "()V", "TAG", "", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", JsApiCancelDownloadTask.NAME, "", AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "checkResourceDownload", "appInfo", "Lcom/tencent/mm/pluginsdk/model/app/AppInfo;", "downloadStage", "", "response", "Lcom/tencent/mm/plugin/game/autogen/download/GetGameResourceDownloadInfoResponse;", "getValidDir", "dirName", "isDownloadTaskExist", "", "downloadPath", "otherPathList", "", "loopDownload", "performNextDownload", "resetCheckTimer", "tryDownload", "appId", "ControlFlagEnum", "DownloadStageEnum", "plugin-game_release"})
public final class b {
    private static MTimerHandler mEP = new MTimerHandler("GameResourceDownloadManager", (MTimerHandler.CallBack) a.xvM, true);
    public static final b xvL = new b();

    static {
        AppMethodBeat.i(204344);
        AppMethodBeat.o(204344);
    }

    private b() {
    }

    public static final /* synthetic */ void a(b bVar, g gVar, int i2, f fVar) {
        AppMethodBeat.i(204347);
        bVar.a(gVar, i2, fVar);
        AppMethodBeat.o(204347);
    }

    public static final /* synthetic */ void azu(String str) {
        AppMethodBeat.i(204346);
        cancelDownloadTask(str);
        AppMethodBeat.o(204346);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class a implements MTimerHandler.CallBack {
        public static final a xvM = new a();

        static {
            AppMethodBeat.i(204331);
            AppMethodBeat.o(204331);
        }

        a() {
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(204330);
            b bVar = b.xvL;
            b.dTj();
            AppMethodBeat.o(204330);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.game.c.b$b  reason: collision with other inner class name */
    public static final class RunnableC1394b implements Runnable {
        public static final RunnableC1394b xvN = new RunnableC1394b();

        static {
            AppMethodBeat.i(204333);
            AppMethodBeat.o(204333);
        }

        RunnableC1394b() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x007c, code lost:
            if (r1 == null) goto L_0x007e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 175
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.c.b.RunnableC1394b.run():void");
        }
    }

    public static void dTh() {
        AppMethodBeat.i(204337);
        h.RTc.b(RunnableC1394b.xvN, "GameResourceDownloadRequest_resetCheckTimer");
        AppMethodBeat.o(204337);
    }

    public static void azr(String str) {
        AppMethodBeat.i(204338);
        p.h(str, "appId");
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.GameResourceDownloadManager", "appId is null");
            AppMethodBeat.o(204338);
            return;
        }
        Log.i("MicroMsg.GameResourceDownloadManager", "tryDownload, appId:".concat(String.valueOf(str)));
        h.RTc.b(new c(str), "GameResourceDownloadRequest_tryDownload");
        AppMethodBeat.o(204338);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ String kPQ;

        c(String str) {
            this.kPQ = str;
        }

        public final void run() {
            boolean z;
            AppMethodBeat.i(204336);
            g cX = com.tencent.mm.pluginsdk.model.app.h.cX(this.kPQ, false);
            if (cX != null) {
                String str = cX.field_packageName;
                if (str == null || str.length() == 0) {
                    AppMethodBeat.o(204336);
                    return;
                }
                Log.i("MicroMsg.GameResourceDownloadManager", "tryDownload, packageName:" + cX.field_packageName);
                com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
                p.g(af, "MMKernel.service(IGameStorage::class.java)");
                d dSP = ((com.tencent.mm.plugin.game.api.f) af).dSP();
                String str2 = cX.field_packageName;
                p.g(str2, "field_packageName");
                p.h(str2, AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
                Log.i("MicroMsg.GameResourceDownloadStorage", "allowCleanPkg(" + str2 + ')');
                a azw = dSP.azw(str2);
                if (azw == null || Math.abs(Util.nowSecond() - azw.field_finishDownloadTime) <= ((long) azw.field_expiredSeconds)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    Log.i("MicroMsg.GameResourceDownloadManager", "tryDownload, allowCleanPkg:true");
                    b bVar = b.xvL;
                    String str3 = cX.field_packageName;
                    p.g(str3, "field_packageName");
                    b.azu(str3);
                    AppMethodBeat.o(204336);
                    return;
                }
                z.f fVar = new z.f();
                fVar.SYG = (T) new e();
                fVar.SYG.oTJ = Build.MODEL;
                fVar.SYG.oUj = Build.MANUFACTURER;
                fVar.SYG.xun = "";
                fVar.SYG.xuo = q.aoK();
                fVar.SYG.xup = q.dr(false);
                fVar.SYG.xuk = cX.field_packageName;
                fVar.SYG.jfi = cX.field_appId;
                fVar.SYG.xuq = String.valueOf(com.tencent.mm.plugin.game.e.c.aAH(fVar.SYG.xuk));
                fVar.SYG.xur = com.tencent.mm.plugin.game.e.c.aAI(fVar.SYG.xuk);
                com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
                p.g(af2, "MMKernel.service(IGameStorage::class.java)");
                d dSP2 = ((com.tencent.mm.plugin.game.api.f) af2).dSP();
                String str4 = fVar.SYG.xuk;
                p.g(str4, "request.PackageName");
                fVar.SYG.xus = dSP2.azx(str4);
                Log.i("MicroMsg.GameResourceDownloadManager", "download stage:" + fVar.SYG.xus);
                d.a aVar = new d.a();
                aVar.MB("/cgi-bin/mmgame-bin/getgameresourcedownloadinfo");
                aVar.sG(4218);
                aVar.sI(0);
                aVar.sJ(0);
                aVar.c(fVar.SYG);
                aVar.d(new f());
                aa.a(aVar.aXF(), new a(cX, fVar));
                AppMethodBeat.o(204336);
                return;
            }
            AppMethodBeat.o(204336);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
        static final class a implements aa.a {
            final /* synthetic */ g xvO;
            final /* synthetic */ z.f xvP;

            a(g gVar, z.f fVar) {
                this.xvO = gVar;
                this.xvP = fVar;
            }

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, final d dVar, com.tencent.mm.ak.q qVar) {
                AppMethodBeat.i(204335);
                Log.i("MicroMsg.GameResourceDownloadManager", "tryDownload, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (i2 == 0 && i3 == 0) {
                    h.RTc.b(new Runnable(this) {
                        /* class com.tencent.mm.plugin.game.c.b.c.a.AnonymousClass1 */
                        final /* synthetic */ a xvQ;

                        {
                            this.xvQ = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(204334);
                            b bVar = b.xvL;
                            g gVar = this.xvQ.xvO;
                            int i2 = this.xvQ.xvP.SYG.xus;
                            d dVar = dVar;
                            p.g(dVar, "rr");
                            com.tencent.mm.bw.a aYK = dVar.aYK();
                            if (aYK == null) {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.game.autogen.download.GetGameResourceDownloadInfoResponse");
                                AppMethodBeat.o(204334);
                                throw tVar;
                            }
                            b.a(bVar, gVar, i2, (f) aYK);
                            AppMethodBeat.o(204334);
                        }
                    }, "GameResourceDownloadRequest_callback");
                }
                AppMethodBeat.o(204335);
                return 0;
            }
        }
    }

    private final synchronized void a(g gVar, int i2, f fVar) {
        int i3;
        AppMethodBeat.i(204339);
        if (fVar != null) {
            Log.i("MicroMsg.GameResourceDownloadManager", "response, PackageName:" + fVar.xuk + ", ControlFlag:" + fVar.xuw + ", IntervalSeconds:" + fVar.xux + ", expiredTime:" + fVar.xuy + ", downloadStage:" + i2);
            String str = fVar.xuk;
            if (!(str == null || str.length() == 0)) {
                switch (fVar.xuw) {
                    case 0:
                        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
                        p.g(af, "MMKernel.service(IGameStorage::class.java)");
                        d dSP = ((com.tencent.mm.plugin.game.api.f) af).dSP();
                        String str2 = fVar.xuk;
                        p.g(str2, "PackageName");
                        if (dSP.azw(str2) != null) {
                            LinkedList<com.tencent.mm.plugin.game.b.a.g> linkedList = fVar.xuv;
                            if (!(linkedList == null || linkedList.isEmpty()) || i2 == 2) {
                                com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
                                p.g(af2, "MMKernel.service(IGameStorage::class.java)");
                                d dSP2 = ((com.tencent.mm.plugin.game.api.f) af2).dSP();
                                String str3 = fVar.xuk;
                                p.g(str3, "PackageName");
                                int i4 = fVar.xux;
                                long nowSecond = Util.nowSecond();
                                int i5 = fVar.xuy;
                                p.h(str3, AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
                                Log.i("MicroMsg.GameResourceDownloadStorage", "updateItemTime, packageName:".concat(String.valueOf(str3)));
                                a azw = dSP2.azw(str3);
                                if (azw != null) {
                                    azw.field_checkCgiTime = nowSecond;
                                    azw.field_intervalSeconds = i4;
                                    azw.field_expiredSeconds = i5;
                                    dSP2.update(azw, new String[0]);
                                }
                                dTh();
                                AppMethodBeat.o(204339);
                                break;
                            } else {
                                Log.i("MicroMsg.GameResourceDownloadManager", "packageInfoList is empty");
                                String str4 = fVar.xuk;
                                p.g(str4, "PackageName");
                                cancelDownloadTask(str4);
                                AppMethodBeat.o(204339);
                                break;
                            }
                        } else {
                            String str5 = fVar.xut;
                            if (str5 == null || str5.length() == 0) {
                                Log.i("MicroMsg.GameResourceDownloadManager", "response path is null");
                                AppMethodBeat.o(204339);
                                break;
                            } else {
                                String str6 = fVar.xut;
                                p.g(str6, "this.Path");
                                String azt = azt(str6);
                                LinkedList<String> linkedList2 = fVar.xuu;
                                p.g(linkedList2, "this.OtherPathList");
                                if (w(azt, linkedList2)) {
                                    AppMethodBeat.o(204339);
                                    break;
                                } else {
                                    com.tencent.mm.plugin.game.b.a.d dVar = new com.tencent.mm.plugin.game.b.a.d();
                                    int i6 = 1;
                                    LinkedList<com.tencent.mm.plugin.game.b.a.g> linkedList3 = fVar.xuv;
                                    if (linkedList3 != null) {
                                        for (T t : linkedList3) {
                                            Log.i("MicroMsg.GameResourceDownloadManager", "checkResourceDownload url:" + t.Url + ", type:" + t.oUv);
                                            String str7 = t.Url;
                                            if (!(str7 == null || str7.length() == 0)) {
                                                if (j.listOf((Object[]) new Integer[]{0, 2}).contains(Integer.valueOf(t.oUv))) {
                                                    String string = MMApplicationContext.getResources().getString(R.string.dsa, gVar.field_appName, Integer.valueOf(i6));
                                                    p.g(string, "MMApplicationContext.get…nfo.field_appName, index)");
                                                    com.tencent.mm.plugin.game.b.a.c cVar = new com.tencent.mm.plugin.game.b.a.c();
                                                    cVar.xuc = t.Url;
                                                    cVar.xui = t.xui;
                                                    cVar.xuj = string;
                                                    cVar.Md5 = t.Md5;
                                                    cVar.jfi = gVar.field_appId + "_gameres_" + i6;
                                                    cVar.xuk = fVar.xuk;
                                                    cVar.xul = azt + t.xuz;
                                                    dVar.xum.add(cVar);
                                                    i3 = i6 + 1;
                                                    i6 = i3;
                                                }
                                            }
                                            i3 = i6;
                                            i6 = i3;
                                        }
                                    }
                                    LinkedList<com.tencent.mm.plugin.game.b.a.c> linkedList4 = dVar.xum;
                                    if (linkedList4 == null || linkedList4.isEmpty()) {
                                        Log.i("MicroMsg.GameResourceDownloadManager", "checkResourceDownload, DownloadItemList is empty");
                                        AppMethodBeat.o(204339);
                                        break;
                                    } else {
                                        com.tencent.mm.kernel.c.a af3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
                                        p.g(af3, "MMKernel.service(IGameStorage::class.java)");
                                        ((com.tencent.mm.plugin.game.api.f) af3).dSP();
                                        String str8 = fVar.xuk;
                                        p.g(str8, "PackageName");
                                        String str9 = gVar.field_appId;
                                        p.g(str9, "appInfo.field_appId");
                                        d.a(str8, str9, fVar.xux, fVar.xuy, dVar);
                                        String str10 = fVar.xuk;
                                        p.g(str10, "PackageName");
                                        azs(str10);
                                        AppMethodBeat.o(204339);
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        String str11 = fVar.xuk;
                        p.g(str11, "PackageName");
                        cancelDownloadTask(str11);
                    case 1:
                    default:
                        AppMethodBeat.o(204339);
                        break;
                }
            } else {
                AppMethodBeat.o(204339);
            }
        } else {
            AppMethodBeat.o(204339);
        }
    }

    public static void azs(String str) {
        AppMethodBeat.i(204340);
        p.h(str, AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
        p.g(af, "MMKernel.service(IGameStorage::class.java)");
        a azw = ((com.tencent.mm.plugin.game.api.f) af).dSP().azw(str);
        if (azw != null) {
            com.tencent.mm.plugin.game.b.a.d dVar = new com.tencent.mm.plugin.game.b.a.d();
            try {
                dVar.parseFrom(azw.field_downloadItemList);
                LinkedList<com.tencent.mm.plugin.game.b.a.c> linkedList = dVar.xum;
                if (linkedList != null) {
                    for (T t : linkedList) {
                        if (!t.xuh) {
                            g.a aVar = new g.a();
                            aVar.alj(t.xuc);
                            aVar.setFileSize(t.xui);
                            aVar.alo(t.xuj);
                            aVar.setFileMD5(t.Md5);
                            aVar.setAppId(t.jfi);
                            aVar.gm(t.xuk);
                            aVar.kS(false);
                            aVar.Fl(3);
                            aVar.kV(true);
                            aVar.cBF();
                            aVar.aln(t.xul);
                            com.tencent.mm.plugin.downloader.model.g cBG = aVar.cBG();
                            com.tencent.mm.plugin.downloader.model.d.alc(t.xuc);
                            long b2 = com.tencent.mm.plugin.downloader.model.f.cBv().b(cBG);
                            Log.i("MicroMsg.GameResourceDownloadManager", "add download task[packageName:" + t.xuk + ", downloadUrl:" + t.xuc + ", downloadPath:" + t.xul + "], size:" + t.xui + ", md5:" + t.Md5 + ", downloadId:" + b2);
                            t.xug = b2;
                            t.xuh = true;
                            if (b2 > 0) {
                                break;
                            }
                        }
                    }
                }
                azw.field_downloadItemList = dVar.toByteArray();
                com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
                p.g(af2, "MMKernel.service(IGameStorage::class.java)");
                Log.i("MicroMsg.GameResourceDownloadManager", "performNextDownload, updateRet:".concat(String.valueOf(((com.tencent.mm.plugin.game.api.f) af2).dSP().update(azw, new String[0]))));
                AppMethodBeat.o(204340);
            } catch (Exception e2) {
                Log.i("MicroMsg.GameResourceDownloadManager", "performNextDownload, catch err:" + e2.getMessage());
                AppMethodBeat.o(204340);
            }
        } else {
            AppMethodBeat.o(204340);
        }
    }

    private static String azt(String str) {
        AppMethodBeat.i(204341);
        String str2 = com.tencent.mm.loader.j.b.aKE() + FilePathGenerator.ANDROID_DIR_SEP + str + FilePathGenerator.ANDROID_DIR_SEP;
        AppMethodBeat.o(204341);
        return str2;
    }

    private static void cancelDownloadTask(String str) {
        AppMethodBeat.i(204342);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(204342);
            return;
        }
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
        p.g(af, "MMKernel.service(IGameStorage::class.java)");
        a azw = ((com.tencent.mm.plugin.game.api.f) af).dSP().azw(str);
        if (azw != null) {
            com.tencent.mm.plugin.game.b.a.d dVar = new com.tencent.mm.plugin.game.b.a.d();
            try {
                dVar.parseFrom(azw.field_downloadItemList);
                LinkedList<com.tencent.mm.plugin.game.b.a.c> linkedList = dVar.xum;
                if (linkedList != null) {
                    for (T t : linkedList) {
                        Log.i("MicroMsg.GameResourceDownloadManager", "cancelDownloadTask, downloadId:" + t.xug + " ret:" + com.tencent.mm.plugin.downloader.model.f.cBv().Cn(t.xug));
                    }
                }
            } catch (Exception e2) {
                Log.i("MicroMsg.GameResourceDownloadManager", "cancelDownloadTask, catch err:" + e2.getMessage());
            }
        }
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
        p.g(af2, "MMKernel.service(IGameStorage::class.java)");
        d dSP = ((com.tencent.mm.plugin.game.api.f) af2).dSP();
        p.h(str, AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        String str3 = "delete from GameResourceDownload where packageName=\"" + str + '\"';
        boolean execSQL = dSP.execSQL("GameResourceDownload", str3);
        Log.i("MicroMsg.GameResourceDownloadStorage", "delDownloadInfo, sql:" + str3 + ", ret:" + execSQL);
        dTh();
        Log.i("MicroMsg.GameResourceDownloadManager", "cancelDownloadTask, packageName:" + str + ", delDownloadInfo: " + execSQL);
        AppMethodBeat.o(204342);
    }

    private static boolean w(String str, List<String> list) {
        AppMethodBeat.i(204343);
        Iterable<com.tencent.mm.vfs.e> dC = s.dC(str, false);
        if (dC != null) {
            Iterator<com.tencent.mm.vfs.e> it = dC.iterator();
            if (it.hasNext()) {
                it.next();
                Log.i("MicroMsg.GameResourceDownloadManager", "download task exists in path:".concat(String.valueOf(str)));
                AppMethodBeat.o(204343);
                return true;
            }
        }
        if (list != null) {
            for (T t : list) {
                Iterable<com.tencent.mm.vfs.e> dC2 = s.dC(azt(t), false);
                if (dC2 != null) {
                    Iterator<com.tencent.mm.vfs.e> it2 = dC2.iterator();
                    if (it2.hasNext()) {
                        it2.next();
                        Log.i("MicroMsg.GameResourceDownloadManager", "download task exists in path:".concat(String.valueOf(t)));
                        AppMethodBeat.o(204343);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.o(204343);
        return false;
    }

    public static final /* synthetic */ void dTj() {
        ArrayList<a> arrayList;
        AppMethodBeat.i(204345);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class);
        p.g(af, "MMKernel.service(IGameStorage::class.java)");
        Cursor rawQuery = ((com.tencent.mm.plugin.game.api.f) af).dSP().rawQuery("select * from GameResourceDownload", new String[0]);
        if (rawQuery == null) {
            arrayList = null;
        } else {
            ArrayList<a> arrayList2 = new ArrayList();
            if (rawQuery.moveToFirst()) {
                do {
                    a aVar = new a();
                    aVar.convertFrom(rawQuery);
                    arrayList2.add(aVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            ArrayList arrayList3 = new ArrayList();
            for (a aVar2 : arrayList2) {
                if (Math.abs(Util.nowSecond() - aVar2.field_checkCgiTime) >= ((long) aVar2.field_intervalSeconds)) {
                    arrayList3.add(aVar2);
                }
            }
            Log.i("MicroMsg.GameResourceDownloadStorage", "getNeedCheckItems, allItemsSize:" + arrayList2.size() + ", needCheckItemsSize:" + arrayList3.size());
            arrayList = arrayList3;
        }
        if (arrayList != null) {
            for (a aVar3 : arrayList) {
                Log.i("MicroMsg.GameResourceDownloadManager", "loopDownload, appId:" + aVar3.field_appId);
                String str = aVar3.field_appId;
                p.g(str, "it.field_appId");
                azr(str);
            }
            AppMethodBeat.o(204345);
            return;
        }
        AppMethodBeat.o(204345);
    }
}
