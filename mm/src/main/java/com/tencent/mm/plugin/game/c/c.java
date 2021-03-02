package com.tencent.mm.plugin.game.c;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.b.a.j;
import com.tencent.mm.plugin.game.b.a.k;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/game/download/GameResourceDownloadReporter;", "", "()V", "STAGE_CANCEL_DOWNLOAD", "", "STAGE_FINISH_DOWNLOAD", "STAGE_START_DOWNLOAD", "STATUS_DOWNLOAD_FAIL", "STATUS_DOWNLOAD_SUCCESS", "TAG", "", "finishOneDownload", "", AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "report", "downloadId", "", "plugin-game_release"})
public final class c {
    public static final c xvR = new c();

    static {
        AppMethodBeat.i(204352);
        AppMethodBeat.o(204352);
    }

    private c() {
    }

    public static void report(long j2) {
        int i2;
        int i3;
        AppMethodBeat.i(204350);
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw == null) {
            Log.i("MicroMsg.GameResourceDownloadReporter", "report, info is null");
            AppMethodBeat.o(204350);
        } else if (Cw.field_fileType != 3) {
            AppMethodBeat.o(204350);
        } else {
            switch (Cw.field_status) {
                case 1:
                    i2 = 0;
                    i3 = 3;
                    break;
                case 2:
                default:
                    AppMethodBeat.o(204350);
                    return;
                case 3:
                    String str = Cw.field_packageName;
                    p.g(str, "info.field_packageName");
                    azv(str);
                    i2 = 0;
                    i3 = 4;
                    break;
                case 4:
                    i2 = 1;
                    String str2 = Cw.field_packageName;
                    p.g(str2, "info.field_packageName");
                    azv(str2);
                    i3 = 4;
                    break;
                case 5:
                    String str3 = Cw.field_packageName;
                    p.g(str3, "info.field_packageName");
                    azv(str3);
                    i2 = 0;
                    i3 = 5;
                    break;
            }
            String nullAsNil = Util.nullAsNil(Cw.field_filePath);
            j jVar = new j();
            jVar.xuk = Cw.field_packageName;
            jVar.xus = i3;
            jVar.oTW = i2;
            p.g(nullAsNil, "filePath");
            int g2 = n.g(nullAsNil, FilePathGenerator.ANDROID_DIR_SEP) + 1;
            if (nullAsNil == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(204350);
                throw tVar;
            }
            String substring = nullAsNil.substring(g2);
            p.g(substring, "(this as java.lang.String).substring(startIndex)");
            jVar.xuz = substring;
            jVar.xuB = Cw.field_md5;
            String substring2 = nullAsNil.substring(0, n.g(nullAsNil, FilePathGenerator.ANDROID_DIR_SEP) + 1);
            p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            jVar.xuC = substring2;
            jVar.errorCode = Cw.field_errCode;
            jVar.xup = q.dr(false);
            jVar.xuo = q.aoK();
            jVar.xun = "";
            jVar.xuq = String.valueOf(com.tencent.mm.plugin.game.e.c.aAH(jVar.xuk));
            jVar.xur = com.tencent.mm.plugin.game.e.c.aAI(jVar.xuk);
            jVar.oTJ = Build.MODEL;
            jVar.oUj = Build.MANUFACTURER;
            Log.i("MicroMsg.GameResourceDownloadReporter", "PackageName:" + jVar.xuk + ", Stage:" + jVar.xus + ", Status:" + jVar.oTW + ", FileName:" + jVar.xuz + ", FileMd5:" + jVar.xuB + ", DownloadPath:" + jVar.xuC + ", errorCode:" + jVar.errorCode + ", Imei:" + jVar.xup + ", Oaid:" + jVar.xuo + ", Xid:" + jVar.xun + ", VersionCode:" + jVar.xuq + ", VersionName:" + jVar.xur + ", Model:" + jVar.oTJ + ", Manufacturer:" + jVar.oUj);
            d.a aVar = new d.a();
            aVar.sG(4100);
            aVar.MB("/cgi-bin/mmgame-bin/reportgameresourcedownload");
            aVar.c(jVar);
            aVar.d(new k());
            aVar.sI(0);
            aVar.sJ(0);
            aa.a(aVar.aXF(), a.xvS);
            AppMethodBeat.o(204350);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    public static final class a implements aa.a {
        public static final a xvS = new a();

        static {
            AppMethodBeat.i(204349);
            AppMethodBeat.o(204349);
        }

        a() {
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(204348);
            Log.i("MicroMsg.GameResourceDownloadReporter", "report, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(204348);
            return 0;
        }
    }

    private static void azv(String str) {
        AppMethodBeat.i(204351);
        com.tencent.mm.kernel.c.a af = g.af(f.class);
        p.g(af, "MMKernel.service(IGameStorage::class.java)");
        ((f) af).dSP().azy(str);
        b bVar = b.xvL;
        b.azs(str);
        AppMethodBeat.o(204351);
    }
}
