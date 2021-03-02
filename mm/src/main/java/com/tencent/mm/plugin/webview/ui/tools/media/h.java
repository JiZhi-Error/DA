package com.tencent.mm.plugin.webview.ui.tools.media;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.y;
import com.tencent.mm.ak.d;
import com.tencent.mm.g.b.a.fu;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 72\u00020\u0001:\u0003789B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J\u0006\u00100\u001a\u00020\nJ(\u00101\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\nR\u001c\u0010\u0003\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000e¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "", "()V", "_realPlayTime", "", "get_realPlayTime", "()J", "set_realPlayTime", "(J)V", "endPlayTime", "", "getEndPlayTime", "()I", "setEndPlayTime", "(I)V", "isFans", "", "()Z", "setFans", "(Z)V", "lastOpType", "playErrType", "", "getPlayErrType", "()Ljava/lang/String;", "setPlayErrType", "(Ljava/lang/String;)V", "playStatus", "getPlayStatus", "setPlayStatus", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "scene", "getScene", "setScene", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "subScene", "getSubScene", "setSubScene", "doPlayReport", "", "doStopReport", "getPlayType", "report17149", "videoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "opType", "enterId", "itemShowType", "Companion", "KV17149OpType", "PlayStatus", "plugin-webview_release"})
public class h {
    public static final a JwJ = new a((byte) 0);
    private static final String TAG = TAG;
    private int JwI;
    private long iJF = System.currentTimeMillis();
    public int jpW;
    protected int pHw;
    protected int pLB;
    protected int pLC;
    public String pLD = "";
    protected boolean pLE;
    protected int scene;
    private long vgm;

    public h() {
        AppMethodBeat.i(82684);
        AppMethodBeat.o(82684);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J6\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J>\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport$Companion;", "", "()V", "ACTION_TYPE_FRIEND", "", "ACTION_TYPE_SNS", "REPORT_TYPE_10380", "REPORT_TYPE_10945", "REPORT_TYPE_17537", "SHARE_TYPE_MP_VIDEO", "TAG", "", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "logReportData", "kv", "report10380", "actionType", "sharePageType", "vid", "url", "timeLineSessionId", "enterId", "report17537", "eventType", "scene", "subScene", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        private static void a(fg fgVar) {
            AppMethodBeat.i(82678);
            d.a aVar = new d.a();
            aVar.c(fgVar);
            aVar.d(new fh());
            aVar.MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
            aVar.sG(1870);
            aVar.sI(0);
            aVar.sJ(0);
            IPCRunCgi.a(aVar.aXF(), C1999a.JwK);
            AppMethodBeat.o(82678);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.media.h$a$a  reason: collision with other inner class name */
        public static final class C1999a implements IPCRunCgi.a {
            public static final C1999a JwK = new C1999a();

            static {
                AppMethodBeat.i(82677);
                AppMethodBeat.o(82677);
            }

            C1999a() {
            }

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
                AppMethodBeat.i(82676);
                Log.i(h.TAG, "appmsg_report errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
                AppMethodBeat.o(82676);
            }
        }

        public static void i(int i2, String str, String str2, int i3) {
            AppMethodBeat.i(210563);
            p.h(str, "vid");
            p.h(str2, "url");
            fg fgVar = new fg();
            ff ffVar = new ff();
            ffVar.type = 2;
            LinkedList<fi> linkedList = ffVar.KEQ;
            p.g(linkedList, "reportData.item");
            a("Vid", str, linkedList);
            String formatedNetType = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
            LinkedList<fi> linkedList2 = ffVar.KEQ;
            p.g(linkedList2, "reportData.item");
            a("Network", formatedNetType, linkedList2);
            LinkedList<fi> linkedList3 = ffVar.KEQ;
            p.g(linkedList3, "reportData.item");
            a("SharePageType", "101", linkedList3);
            LinkedList<fi> linkedList4 = ffVar.KEQ;
            p.g(linkedList4, "reportData.item");
            a("ContentUrl", str2, linkedList4);
            LinkedList<fi> linkedList5 = ffVar.KEQ;
            p.g(linkedList5, "reportData.item");
            a("#AppMsgUrl#", str2, linkedList5);
            String valueOf = String.valueOf(i2);
            LinkedList<fi> linkedList6 = ffVar.KEQ;
            p.g(linkedList6, "reportData.item");
            a("ActionType", valueOf, linkedList6);
            LinkedList<fi> linkedList7 = ffVar.KEQ;
            p.g(linkedList7, "reportData.item");
            a("SessionId", AppEventsConstants.EVENT_PARAM_VALUE_NO, linkedList7);
            String valueOf2 = String.valueOf(i3);
            LinkedList<fi> linkedList8 = ffVar.KEQ;
            p.g(linkedList8, "reportData.item");
            a("EnterId", valueOf2, linkedList8);
            fgVar.KIG.add(ffVar);
            a(fgVar);
            LinkedList<fi> linkedList9 = ffVar.KEQ;
            p.g(linkedList9, "reportData.item");
            b(10380, linkedList9);
            AppMethodBeat.o(210563);
        }

        public static void b(int i2, String str, String str2, int i3, int i4) {
            AppMethodBeat.i(82680);
            p.h(str, "vid");
            p.h(str2, "url");
            fg fgVar = new fg();
            ff ffVar = new ff();
            ffVar.type = 3;
            LinkedList<fi> linkedList = ffVar.KEQ;
            p.g(linkedList, "reportData.item");
            a("#AppMsgUrl#", str2, linkedList);
            LinkedList<fi> linkedList2 = ffVar.KEQ;
            p.g(linkedList2, "reportData.item");
            a("VideoId", str, linkedList2);
            LinkedList<fi> linkedList3 = ffVar.KEQ;
            p.g(linkedList3, "reportData.item");
            a("Scene", "141", linkedList3);
            String valueOf = String.valueOf(i3);
            LinkedList<fi> linkedList4 = ffVar.KEQ;
            p.g(linkedList4, "reportData.item");
            a("SubScene", valueOf, linkedList4);
            String valueOf2 = String.valueOf(System.currentTimeMillis());
            LinkedList<fi> linkedList5 = ffVar.KEQ;
            p.g(linkedList5, "reportData.item");
            a("ClientId", valueOf2, linkedList5);
            LinkedList<fi> linkedList6 = ffVar.KEQ;
            p.g(linkedList6, "reportData.item");
            a("SessionId", AppEventsConstants.EVENT_PARAM_VALUE_NO, linkedList6);
            String valueOf3 = String.valueOf(i4);
            LinkedList<fi> linkedList7 = ffVar.KEQ;
            p.g(linkedList7, "reportData.item");
            a("EnterId", valueOf3, linkedList7);
            String valueOf4 = String.valueOf(i2);
            LinkedList<fi> linkedList8 = ffVar.KEQ;
            p.g(linkedList8, "reportData.item");
            a("EventType", valueOf4, linkedList8);
            fgVar.KIG.add(ffVar);
            a(fgVar);
            LinkedList<fi> linkedList9 = ffVar.KEQ;
            p.g(linkedList9, "reportData.item");
            b(17537, linkedList9);
            AppMethodBeat.o(82680);
        }

        private static void b(int i2, LinkedList<fi> linkedList) {
            AppMethodBeat.i(82681);
            if (Log.getLogLevel() <= 0 && !Util.isNullOrNil(linkedList)) {
                StringBuilder sb = new StringBuilder();
                Iterator<fi> it = linkedList.iterator();
                while (it.hasNext()) {
                    fi next = it.next();
                    sb.append(next.key).append(":").append(next.iFF).append("  ");
                }
                Log.v(h.TAG, i2 + ", " + ((Object) sb));
            }
            AppMethodBeat.o(82681);
        }

        private static void a(String str, String str2, LinkedList<fi> linkedList) {
            AppMethodBeat.i(82682);
            fi fiVar = new fi();
            fiVar.key = str;
            fiVar.iFF = str2;
            linkedList.add(fiVar);
            AppMethodBeat.o(82682);
        }
    }

    static {
        AppMethodBeat.i(82685);
        AppMethodBeat.o(82685);
    }

    public final int getPlayType() {
        switch (this.jpW) {
            case 0:
            default:
                return 3;
            case 1:
                return 4;
            case 2:
                return 8;
            case 3:
                return 9;
            case 4:
                return 10;
        }
    }

    public final void a(y yVar, int i2, int i3) {
        AppMethodBeat.i(82683);
        if (yVar == null) {
            AppMethodBeat.o(82683);
        } else if (this.JwI == i2) {
            AppMethodBeat.o(82683);
        } else {
            this.JwI = i2;
            yVar.aSB();
            switch (i2) {
                case 2:
                case 7:
                case 8:
                    long currentTimeMillis = System.currentTimeMillis();
                    this.vgm += currentTimeMillis - this.iJF;
                    this.iJF = currentTimeMillis;
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                    this.iJF = System.currentTimeMillis();
                    break;
            }
            if (i2 == 3) {
                String str = yVar.KOf;
                p.g(str, "videoInfo.videoVid");
                String str2 = yVar.KOe;
                p.g(str2, "videoInfo.mpUrl");
                a.b(0, str, str2, this.pHw, i3);
            } else if (i2 == 4) {
                String str3 = yVar.KOf;
                p.g(str3, "videoInfo.videoVid");
                String str4 = yVar.KOe;
                p.g(str4, "videoInfo.mpUrl");
                a.b(1, str3, str4, this.pHw, i3);
            } else if (i2 == 10) {
                String str5 = yVar.KOf;
                p.g(str5, "videoInfo.videoVid");
                String str6 = yVar.KOe;
                p.g(str6, "videoInfo.mpUrl");
                a.b(2, str5, str6, this.pHw, i3);
            }
            int ape = m.ape();
            if (ape == 100) {
                ape = -1;
            }
            fu agG = new fu().sL(yVar.dHc).pp((long) i2).sM(yVar.KOf).lm(ape).pl(yVar.iAQ).pm((long) yVar.idx).pn((long) i3).po((long) yVar.videoDuration).pu((long) this.scene).pv((long) this.pHw).py((long) yVar.width).px((long) yVar.height).agG();
            if (this.vgm == 0 && this.iJF != 0) {
                this.vgm = System.currentTimeMillis() - this.iJF;
            }
            agG.pr(this.vgm).pt((long) this.pLC).pq(System.currentTimeMillis() / 1000).ps((long) this.pLB).sN(this.pLD).agE().pw(this.pLE ? 1 : 0).agF().bfK();
            Log.d(TAG, "eventType: ".concat(String.valueOf(i2)));
            switch (i2) {
                case 1:
                case 2:
                    this.vgm = 0;
                    this.iJF = System.currentTimeMillis();
                    this.pLC = 0;
                    break;
            }
            AppMethodBeat.o(82683);
        }
    }
}
