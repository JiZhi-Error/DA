package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0002J0\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010\u0017\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007J0\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/modelbiz/BizChattingItemReportHelper;", "", "()V", "TAG", "", "reportCache", "Lcom/tencent/mm/algorithm/LRUMap;", "", "doReportBizServiceMsgClick", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "enterTime", "doReportServiceMsgExpose", "talker", "Lcom/tencent/mm/storage/Contact;", "position", "", "msgCount", "fillReportMsgSendType", "reportInfo", "Lcom/tencent/mm/modelbiz/BizChattingItemReportHelper$BizServiceMsgReportInfo;", "fillReportMsgType", "reportBizServiceMsgClick", "reportServiceMsgExpose", "BizServiceMsgReportInfo", "BizServiceMsgSendType", "BizServiceMsgType", "plugin-biz_release"})
public final class b {
    private static final f<Long, Long> iNH = new h(20);
    public static final b iNI = new b();

    static {
        AppMethodBeat.i(212430);
        AppMethodBeat.o(212430);
    }

    private b() {
    }

    public static final void a(as asVar, ca caVar, int i2, int i3, long j2) {
        AppMethodBeat.i(212426);
        p.h(asVar, "talker");
        p.h(caVar, "msg");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (iNH.get(Long.valueOf(caVar.ajL())) != null) {
                Long l = iNH.get(Long.valueOf(caVar.ajL()));
                p.g(l, "reportCache[msg.msgId]");
                if (currentTimeMillis - l.longValue() < 1000) {
                    AppMethodBeat.o(212426);
                    return;
                }
            }
            iNH.put(Long.valueOf(caVar.ajL()), Long.valueOf(currentTimeMillis));
            com.tencent.f.h.RTc.b(new c(asVar, caVar, i2, i3, j2), "BizServicesReportThread");
            AppMethodBeat.o(212426);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BizChattingItemReportHelper", e2, "reportServiceMsgExpose exception", new Object[0]);
            AppMethodBeat.o(212426);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ int gUj;
        final /* synthetic */ ca iNM;
        final /* synthetic */ long iNN;
        final /* synthetic */ as iNO;
        final /* synthetic */ int iNP;

        c(as asVar, ca caVar, int i2, int i3, long j2) {
            this.iNO = asVar;
            this.iNM = caVar;
            this.gUj = i2;
            this.iNP = i3;
            this.iNN = j2;
        }

        public final void run() {
            AppMethodBeat.i(212425);
            b bVar = b.iNI;
            b.b(this.iNO, this.iNM, this.gUj, this.iNP, this.iNN);
            AppMethodBeat.o(212425);
        }
    }

    public static final void a(ca caVar, long j2) {
        AppMethodBeat.i(212427);
        if (caVar == null) {
            AppMethodBeat.o(212427);
        } else if (caVar.ajN() == 1) {
            AppMethodBeat.o(212427);
        } else {
            com.tencent.f.h.RTc.aZ(new RunnableC0253b(caVar, j2));
            AppMethodBeat.o(212427);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.al.b$b  reason: collision with other inner class name */
    public static final class RunnableC0253b implements Runnable {
        final /* synthetic */ ca iNM;
        final /* synthetic */ long iNN;

        RunnableC0253b(ca caVar, long j2) {
            this.iNM = caVar;
            this.iNN = j2;
        }

        public final void run() {
            AppMethodBeat.i(212424);
            b bVar = b.iNI;
            b.b(this.iNM, this.iNN);
            AppMethodBeat.o(212424);
        }
    }

    private static void a(ca caVar, a aVar) {
        boolean z;
        AppMethodBeat.i(212428);
        aVar.iEt = caVar.ajV();
        String ajT = caVar.ajT();
        if (ajT == null) {
            ajT = "";
        }
        p.h(ajT, "<set-?>");
        aVar.iEs = ajT;
        if (caVar.isText()) {
            aVar.iNJ = 1;
            aVar.iNL = true;
        } else if (caVar.gAy()) {
            aVar.iNJ = 9;
            aVar.iNL = true;
        } else if (caVar.gAz()) {
            aVar.iNJ = 2;
            aVar.iNL = true;
        } else if (caVar.cWJ()) {
            aVar.iNJ = 5;
            aVar.iNL = true;
        } else if (caVar.getType() == 452984881 || caVar.getType() == 520093745) {
            aVar.iNJ = 6;
            aVar.iNL = false;
        } else if (caVar.gAt()) {
            aVar.iNJ = 3;
            aVar.iNL = false;
            u a2 = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).a(caVar.ajL(), caVar.getContent());
            if (a2 != null && !Util.isNullOrNil(a2.iAd)) {
                String str = ((v) a2.iAd.get(0)).url;
                p.g(str, "reader.items[0].url");
                aVar.setUrl(str);
            }
        } else if (caVar.dOQ() && caVar.getContent() != null) {
            aVar.iNL = false;
            k.b HD = k.b.HD(caVar.getContent());
            if (HD != null) {
                if (HD.type == 33 || HD.type == 36) {
                    aVar.iNJ = 4;
                    String str2 = HD.url;
                    p.g(str2, "content.url");
                    aVar.setUrl(str2);
                    String str3 = HD.izj;
                    p.g(str3, "content.appbrandAppId");
                    p.h(str3, "<set-?>");
                    aVar.extraInfo = str3;
                } else if (HD.type == 5) {
                    aVar.iNJ = 7;
                } else if (HD.type == 3) {
                    aVar.iNJ = 8;
                }
            }
        }
        if (aVar.url.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String bfG = z.bfG(aVar.url);
            p.g(bfG, "WebViewUtil.doUrlEncode(reportInfo.url)");
            aVar.setUrl(bfG);
        }
        AppMethodBeat.o(212428);
    }

    private static void b(ca caVar, a aVar) {
        AppMethodBeat.i(212429);
        if (Util.isNullOrNil(caVar.ajw())) {
            Log.i("MicroMsg.BizChattingItemReportHelper", "fillReportMsgSendType msg source null");
            AppMethodBeat.o(212429);
            return;
        }
        if (caVar.getType() == 318767153) {
            aVar.iNK = 2;
        }
        bp.b Ky = bp.Ky(caVar.ajw());
        if (Ky == null) {
            Log.i("MicroMsg.BizChattingItemReportHelper", "fillReportMsgSendType msg source value null");
            AppMethodBeat.o(212429);
            return;
        }
        if (Ky.iEp == 3) {
            aVar.iNK = 1;
        }
        if (Ky.scene >= 4 && Ky.scene <= 6) {
            aVar.iNK = 5;
        }
        if (h.R(caVar)) {
            aVar.iNK = 4;
        }
        if (!Util.isNullOrNil(caVar.ajT())) {
            aVar.iNK = 3;
        }
        AppMethodBeat.o(212429);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006!"}, hxF = {"Lcom/tencent/mm/modelbiz/BizChattingItemReportHelper$BizServiceMsgReportInfo;", "", "()V", "extraInfo", "", "getExtraInfo", "()Ljava/lang/String;", "setExtraInfo", "(Ljava/lang/String;)V", "kfType", "", "getKfType", "()I", "setKfType", "(I)V", "kfWorker", "getKfWorker", "setKfWorker", "needCheckKF", "", "getNeedCheckKF", "()Z", "setNeedCheckKF", "(Z)V", "reportMsgType", "getReportMsgType", "setReportMsgType", "sendType", "getSendType", "setSendType", "url", "getUrl", "setUrl", "plugin-biz_release"})
    public static final class a {
        String extraInfo = "";
        String iEs = "";
        int iEt;
        int iNJ;
        int iNK;
        boolean iNL = true;
        String url = "";

        public final void setUrl(String str) {
            AppMethodBeat.i(212423);
            p.h(str, "<set-?>");
            this.url = str;
            AppMethodBeat.o(212423);
        }
    }

    public static final /* synthetic */ void b(as asVar, ca caVar, int i2, int i3, long j2) {
        AppMethodBeat.i(212431);
        int i4 = (i3 - i2) - 1;
        a aVar = new a();
        a(caVar, aVar);
        b(caVar, aVar);
        if (aVar.iNJ > 0) {
            Log.d("MicroMsg.BizChattingItemReportHelper", "doReportServiceMsgExpose username: %s, msg raw Type: %d, url: %s, revertPos: %s, createTime: %s, enterTime: %s, reportMsgType: %d, sendType: %s, msgSvrId: %s, extraInfo: %s", asVar.getUsername(), Integer.valueOf(caVar.getType()), aVar.url, Integer.valueOf(i4), Long.valueOf(caVar.getCreateTime()), Long.valueOf(j2), Integer.valueOf(aVar.iNJ), Integer.valueOf(aVar.iNK), Long.valueOf(caVar.ajM()), aVar.extraInfo);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(19202, asVar.getUsername(), Integer.valueOf(aVar.iNJ), aVar.url, 1, Integer.valueOf(i4), Long.valueOf(caVar.getCreateTime()), Long.valueOf(j2), Integer.valueOf(aVar.iNK), Long.valueOf(caVar.ajM()));
        }
        AppMethodBeat.o(212431);
    }

    public static final /* synthetic */ void b(ca caVar, long j2) {
        AppMethodBeat.i(212432);
        if (g.Nb(caVar.ajO())) {
            a aVar = new a();
            b(caVar, aVar);
            a(caVar, aVar);
            if (aVar.iNJ > 0) {
                Log.d("MicroMsg.BizChattingItemReportHelper", "alvinluo doReportBizServiceMsgClick msg raw type: %d, enterTime: %d, kfWorker: %s, kfType: %d, talker: %s, reportMsgType: %d, sendType: %d, msgSvrId: %s, extraInfo: %s", Integer.valueOf(caVar.getType()), Long.valueOf(j2), aVar.iEs, Integer.valueOf(aVar.iEt), caVar.ajO(), Integer.valueOf(aVar.iNJ), Integer.valueOf(aVar.iNK), Long.valueOf(caVar.ajM()), aVar.extraInfo);
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[9];
                String ajO = caVar.ajO();
                if (ajO == null) {
                    ajO = "";
                }
                objArr[0] = ajO;
                objArr[1] = Integer.valueOf(aVar.iNJ);
                objArr[2] = aVar.url;
                objArr[3] = 2;
                objArr[4] = 0;
                objArr[5] = Long.valueOf(caVar.getCreateTime());
                objArr[6] = Long.valueOf(j2);
                objArr[7] = Integer.valueOf(aVar.iNK);
                objArr[8] = Long.valueOf(caVar.ajM());
                hVar.a(19202, objArr);
            }
        }
        AppMethodBeat.o(212432);
    }
}
