package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bas;
import com.tencent.mm.protocal.protobuf.bat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0006\u0010\u001b\u001a\u00020\tJ\b\u0010\u001c\u001a\u00020\u000bH\u0016J>\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPreCreate;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "eventName", "eventDesc", "coverUrl", "endTime", "", "scene", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getEventDesc", "()Ljava/lang/String;", "getEventName", "eventTopicId", "preCreateEventRequest", "Lcom/tencent/mm/protocal/protobuf/FinderPreCreateEventRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getEventTopicId", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cc extends ax implements m {
    public static final a twg = new a((byte) 0);
    private i callback;
    private final String coverUrl;
    private final String eventName;
    private d rr;
    public long twd;
    private bas twe;
    private final String twf;
    private final String userName;

    static {
        AppMethodBeat.i(242498);
        AppMethodBeat.o(242498);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ cc(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, long r14, int r16, int r17) {
        /*
            r9 = this;
            r0 = r17 & 2
            if (r0 == 0) goto L_0x003b
            java.lang.String r3 = ""
        L_0x0007:
            r0 = r17 & 4
            if (r0 == 0) goto L_0x0039
            java.lang.String r4 = ""
        L_0x000e:
            r0 = r17 & 8
            if (r0 == 0) goto L_0x0037
            java.lang.String r5 = ""
        L_0x0015:
            r0 = r17 & 16
            if (r0 == 0) goto L_0x0035
            r6 = 0
        L_0x001b:
            r0 = r17 & 32
            if (r0 == 0) goto L_0x0032
            r8 = 0
        L_0x0020:
            r1 = r9
            r2 = r10
            r1.<init>(r2, r3, r4, r5, r6, r8)
            r0 = 260192(0x3f860, float:3.64607E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r0)
            r0 = 260192(0x3f860, float:3.64607E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0)
            return
        L_0x0032:
            r8 = r16
            goto L_0x0020
        L_0x0035:
            r6 = r14
            goto L_0x001b
        L_0x0037:
            r5 = r13
            goto L_0x0015
        L_0x0039:
            r4 = r12
            goto L_0x000e
        L_0x003b:
            r3 = r11
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.cc.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, int, int):void");
    }

    private cc(String str, String str2, String str3, String str4, long j2, int i2) {
        p.h(str, "userName");
        p.h(str2, "eventName");
        p.h(str3, "eventDesc");
        p.h(str4, "coverUrl");
        AppMethodBeat.i(260191);
        this.userName = str;
        this.eventName = str2;
        this.twf = str3;
        this.coverUrl = str4;
        d.a aVar = new d.a();
        aVar.MB("/cgi-bin/micromsg-bin/finderprecreateevent");
        aVar.sG(getType());
        bas bas = new bas();
        bas.username = this.userName;
        bas.LKn = this.eventName;
        bas.LKo = this.twf;
        bas.LKp = this.coverUrl;
        am amVar = am.tuw;
        bas.LCA = am.cXY();
        bas.Vjy = j2;
        bas.scene = i2;
        this.twe = bas;
        aVar.c(this.twe);
        aVar.d(new bat());
        Log.i("Finder.LogPost.NetSceneFinderPost", "post userName:" + this.userName + " eventName:" + this.eventName + " eventDesc:" + this.twf + " scene:" + i2);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        AppMethodBeat.o(260191);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPreCreate$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(242495);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(242495);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 4050;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        AppMethodBeat.i(242496);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.bw.a aYK = this.rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPreCreateEventResponse");
                AppMethodBeat.o(242496);
                throw tVar;
            }
            this.twd = ((bat) aYK).LIT;
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(242496);
    }
}
