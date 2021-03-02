package com.tencent.mm.emoji.loader.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.emoji.loader.c.d;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J5\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122#\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R+\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher;", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcher;", "()V", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cdnCallback", "com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1;", "cdnMediaType", "", "fetcherConfig", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "startRet", "startTime", "", "fetch", "reportResult", "reportStart", "plugin-emojisdk_release"})
public final class b implements d {
    private final String TAG = "MicroMsg.EmojiCdnHttpsFetcher";
    private kotlin.g.a.b<? super Boolean, x> callback;
    private e gVV;
    private int gVY;
    private int gVZ;
    private final a gWa = new a(this);
    private long startTime;

    public b() {
        AppMethodBeat.i(199903);
        AppMethodBeat.o(199903);
    }

    public static final /* synthetic */ void a(b bVar, boolean z) {
        AppMethodBeat.i(199904);
        bVar.dP(z);
        AppMethodBeat.o(199904);
    }

    @Override // com.tencent.mm.emoji.loader.c.d
    public final void a(e eVar, kotlin.g.a.b<? super Boolean, x> bVar) {
        int i2;
        AppMethodBeat.i(199901);
        p.h(eVar, "fetcherConfig");
        this.gVV = eVar;
        this.callback = bVar;
        o heq = new o(eVar.path).heq();
        if (heq != null) {
            heq.mkdirs();
        }
        if (eVar.gWn == 2) {
            i2 = CdnLogic.kMediaTypeEmojiWXAM;
        } else {
            i2 = CdnLogic.kMediaTypeEmojiNormal;
        }
        this.gVY = i2;
        this.startTime = Util.nowMilliSecond();
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        c2CDownloadRequest.queueTimeoutSeconds = 60;
        c2CDownloadRequest.transforTimeoutSeconds = 60;
        c2CDownloadRequest.taskStartTime = this.startTime;
        c2CDownloadRequest.fileType = this.gVY;
        c2CDownloadRequest.fileKey = d.a.auE() + eVar.gWm.getMd5();
        c2CDownloadRequest.url = eVar.url;
        c2CDownloadRequest.setSavePath(eVar.path);
        this.gVZ = CdnLogic.startHttpsDownload(c2CDownloadRequest, this.gWa);
        Log.i(this.TAG, "fetch: start " + eVar.gWm.getMd5() + ' ' + this.gVZ);
        com.tencent.mm.plugin.emoji.d.CK(20);
        e eVar2 = this.gVV;
        if (eVar2 != null) {
            switch (eVar2.gWn) {
                case 0:
                    com.tencent.mm.plugin.emoji.d.CK(1);
                    break;
                case 1:
                    com.tencent.mm.plugin.emoji.d.CK(6);
                    break;
                case 2:
                    com.tencent.mm.plugin.emoji.d.CK(10);
                    break;
            }
        }
        if (this.gVZ != 0) {
            new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(this.gVZ), 2, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gVY))).bfK();
            kotlin.g.a.b<? super Boolean, x> bVar2 = this.callback;
            if (bVar2 != null) {
                bVar2.invoke(Boolean.FALSE);
            }
            dP(false);
        }
        AppMethodBeat.o(199901);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J(\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/emoji/loader/fetcher/EmojiCdnHttpsFetcher$cdnCallback$1", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "onC2CDownloadCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDownloadProgressChanged", "finished", "", "total", "tryshow", "", "plugin-emojisdk_release"})
    public static final class a implements CdnLogic.DownloadCallback {
        final /* synthetic */ b gWb;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(b bVar) {
            this.gWb = bVar;
        }

        @Override // com.tencent.mars.cdn.CdnLogic.DownloadCallback
        public final void onC2CDownloadCompleted(String str, CdnLogic.C2CDownloadResult c2CDownloadResult) {
            AppMethodBeat.i(199899);
            p.h(str, "filekey");
            p.h(c2CDownloadResult, "result");
            Log.i(this.gWb.TAG, "onC2CDownloadCompleted: " + str + ", " + c2CDownloadResult.errorCode);
            String str2 = "";
            String str3 = "";
            if (!Util.isNullOrNil(c2CDownloadResult.transforMsg)) {
                String str4 = c2CDownloadResult.transforMsg;
                p.g(str4, "result.transforMsg");
                int a2 = n.a((CharSequence) str4, "@,", 0, false, 6);
                if (a2 > 0) {
                    String str5 = c2CDownloadResult.transforMsg;
                    p.g(str5, "result.transforMsg");
                    int i2 = a2 + 2;
                    if (str5 == null) {
                        t tVar = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(199899);
                        throw tVar;
                    }
                    str3 = str5.substring(i2);
                    p.g(str3, "(this as java.lang.String).substring(startIndex)");
                    String str6 = c2CDownloadResult.transforMsg;
                    p.g(str6, "result.transforMsg");
                    if (str6 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(199899);
                        throw tVar2;
                    }
                    str2 = str6.substring(0, a2);
                    p.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                } else {
                    str2 = c2CDownloadResult.transforMsg;
                    p.g(str2, "result.transforMsg");
                    str3 = "";
                }
            }
            new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(this.gWb.gVZ), 2, Long.valueOf(this.gWb.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.gWb.gVY), Long.valueOf(c2CDownloadResult.fileSize), str2, "", "", "", "", "", "", "", str3)).bfK();
            if (c2CDownloadResult.errorCode != 0) {
                kotlin.g.a.b bVar = this.gWb.callback;
                if (bVar != null) {
                    bVar.invoke(Boolean.FALSE);
                }
                b.a(this.gWb, false);
                AppMethodBeat.o(199899);
                return;
            }
            kotlin.g.a.b bVar2 = this.gWb.callback;
            if (bVar2 != null) {
                bVar2.invoke(Boolean.TRUE);
            }
            b.a(this.gWb, true);
            AppMethodBeat.o(199899);
        }

        @Override // com.tencent.mars.cdn.CdnLogic.DownloadCallback
        public final void onDownloadProgressChanged(String str, long j2, long j3, boolean z) {
            AppMethodBeat.i(199900);
            p.h(str, "filekey");
            AppMethodBeat.o(199900);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final void dP(boolean z) {
        AppMethodBeat.i(199902);
        e eVar = this.gVV;
        if (eVar == null) {
            AppMethodBeat.o(199902);
        } else if (z) {
            com.tencent.mm.plugin.emoji.d.CK(21);
            com.tencent.mm.plugin.emoji.d.CK(2);
            AppMethodBeat.o(199902);
        } else {
            com.tencent.mm.plugin.emoji.d.CK(22);
            com.tencent.mm.plugin.emoji.d.CK(3);
            switch (eVar.gWn) {
                case 0:
                    com.tencent.mm.plugin.emoji.d.a(eVar.gWm.getMd5(), 4, 1, 1, eVar.gWm.avy(), 1, eVar.gWm.field_designerID);
                    AppMethodBeat.o(199902);
                    return;
                case 1:
                    com.tencent.mm.plugin.emoji.d.a(eVar.gWm.getMd5(), 2, 1, 1, eVar.gWm.avy(), 1, eVar.gWm.field_designerID);
                    AppMethodBeat.o(199902);
                    return;
                case 2:
                    com.tencent.mm.plugin.emoji.d.a(eVar.gWm.getMd5(), 4, 1, 1, eVar.gWm.avy(), 1, eVar.gWm.field_designerID);
                    break;
            }
            AppMethodBeat.o(199902);
        }
    }
}
