package com.tencent.mm.plugin.festival.c;

import com.facebook.share.internal.ShareConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2#\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH\u0002J3\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2#\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/festival/util/FestivalCdnHttpsDownloader;", "", "()V", "TAG", "", "createCdnCallback", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/festival/util/FestivalHttpsDownloadRequest;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "errCode", "", "startHttpsDownload", "plugin-festival_release"})
public final class b {
    public static final b UGa = new b();

    static {
        AppMethodBeat.i(263478);
        AppMethodBeat.o(263478);
    }

    private b() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J*\u0010\u0010\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, hxF = {"com/tencent/mm/plugin/festival/util/FestivalCdnHttpsDownloader$createCdnCallback$1", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "reportFileType", "", "getReportFileType", "()I", "startTime", "", "getStartTime", "()J", "onC2CDownloadCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDownloadProgressChanged", "finished", "total", "tryshow", "", "plugin-festival_release"})
    public static final class a implements CdnLogic.DownloadCallback {
        private final int UGb;
        final /* synthetic */ d UGc;
        final /* synthetic */ kotlin.g.a.b gWe;
        private final long startTime = Util.nowMilliSecond();

        a(d dVar, kotlin.g.a.b bVar) {
            this.UGc = dVar;
            this.gWe = bVar;
            AppMethodBeat.i(263475);
            this.UGb = dVar.UGi.UGh;
            AppMethodBeat.o(263475);
        }

        @Override // com.tencent.mars.cdn.CdnLogic.DownloadCallback
        public final void onC2CDownloadCompleted(String str, CdnLogic.C2CDownloadResult c2CDownloadResult) {
            AppMethodBeat.i(263474);
            p.h(str, "filekey");
            p.h(c2CDownloadResult, "result");
            Log.i("MicroMsg.FestivalCdnHttpsDownloader", "onC2CDownloadCompleted, fileKey:" + str + ", result:" + c2CDownloadResult.errorCode + ", request:" + this.UGc.hSt());
            kotlin.g.a.b bVar = this.gWe;
            if (bVar != null) {
                bVar.invoke(Integer.valueOf(c2CDownloadResult.errorCode));
            }
            String str2 = "";
            String str3 = "";
            try {
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
                            AppMethodBeat.o(263474);
                            throw tVar;
                        }
                        str3 = str5.substring(i2);
                        p.g(str3, "(this as java.lang.String).substring(startIndex)");
                        String str6 = c2CDownloadResult.transforMsg;
                        p.g(str6, "result.transforMsg");
                        if (str6 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                            AppMethodBeat.o(263474);
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
                new y(com.tencent.mm.plugin.report.a.t(0, 2, Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(this.UGb), Long.valueOf(c2CDownloadResult.fileSize), str2, "", "", "", "", "", "", "", str3)).bfK();
                AppMethodBeat.o(263474);
            } catch (Exception e2) {
                AppMethodBeat.o(263474);
            }
        }

        @Override // com.tencent.mars.cdn.CdnLogic.DownloadCallback
        public final void onDownloadProgressChanged(String str, long j2, long j3, boolean z) {
        }
    }

    private static CdnLogic.DownloadCallback b(d dVar, kotlin.g.a.b<? super Integer, x> bVar) {
        AppMethodBeat.i(263477);
        a aVar = new a(dVar, bVar);
        AppMethodBeat.o(263477);
        return aVar;
    }

    public static void a(d dVar, kotlin.g.a.b<? super Integer, x> bVar) {
        boolean z;
        int startHttpsDownload;
        AppMethodBeat.i(263476);
        p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        String str = dVar.url;
        if (str == null || str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            String str2 = dVar.savePath;
            if (!(str2 == null || str2.length() == 0)) {
                long nowMilliSecond = Util.nowMilliSecond();
                int i2 = dVar.UGi.UGh;
                CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
                c2CDownloadRequest.queueTimeoutSeconds = 60;
                c2CDownloadRequest.transforTimeoutSeconds = 60;
                c2CDownloadRequest.taskStartTime = nowMilliSecond;
                c2CDownloadRequest.fileType = 0;
                c2CDownloadRequest.fileKey = "FestivalCdnHttps-" + dVar.UGi + '-' + MD5Util.getMD5String(dVar.url);
                c2CDownloadRequest.url = dVar.url;
                c2CDownloadRequest.setSavePath(dVar.savePath);
                c2CDownloadRequest.marscdnAppType = dVar.UGi.UGh;
                if (dVar.UGi.UGh != 0) {
                    c2CDownloadRequest.marscdnBizType = 3;
                    startHttpsDownload = CdnLogic.startSNSDownload(c2CDownloadRequest, null, b(dVar, bVar), 0);
                } else {
                    startHttpsDownload = CdnLogic.startHttpsDownload(c2CDownloadRequest, b(dVar, bVar));
                }
                if (startHttpsDownload != 0) {
                    Log.e("MicroMsg.FestivalCdnHttpsDownloader", "startHttpsDownload failed with " + dVar.hSt());
                    bVar.invoke(Integer.valueOf(startHttpsDownload));
                    try {
                        new y(com.tencent.mm.plugin.report.a.t(Integer.valueOf(startHttpsDownload), 2, Long.valueOf(nowMilliSecond), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(c.cY(MMApplicationContext.getContext())), Integer.valueOf(i2))).bfK();
                        AppMethodBeat.o(263476);
                        return;
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.o(263476);
                return;
            }
        }
        bVar.invoke(-20003);
        AppMethodBeat.o(263476);
    }
}
