package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.aqh;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0006\u0010\u001a\u001a\u00020\u0006J\b\u0010\u001b\u001a\u00020\u0017H\u0016J>\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneDeleteFinderObject;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", ch.COL_USERNAME, "", "objectId", "", "objectNonceId", "isMegaVideo", "", "(Ljava/lang/String;JLjava/lang/String;Z)V", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/MegaVideo;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getDelId", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class av extends ax implements m {
    private String TAG;
    private i callback;
    public long hFK;
    private d rr;
    private FinderObject tuO;
    private cng tuP;

    private /* synthetic */ av(String str, long j2, String str2) {
        this(str, j2, str2, false);
        AppMethodBeat.i(165207);
        AppMethodBeat.o(165207);
    }

    public av(String str, long j2, String str2, boolean z) {
        int i2;
        p.h(str, ch.COL_USERNAME);
        p.h(str2, "objectNonceId");
        AppMethodBeat.i(242351);
        this.TAG = "Finder.NetSceneDeleteFinderObject";
        d.a aVar = new d.a();
        aVar.MB("/cgi-bin/micromsg-bin/finderdelfeed");
        aVar.sG(getType());
        aqh aqh = new aqh();
        aqh.id = j2;
        aqh.objectNonceId = str2;
        aqh.LCo = str;
        am amVar = am.tuw;
        aqh.uli = am.cXY();
        aov aov = aqh.uli;
        if (aov == null) {
            p.hyc();
        }
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        aov.scene = i2;
        aVar.c(aqh);
        aVar.d(new aqi());
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        this.hFK = j2;
        AppMethodBeat.o(242351);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public av(java.lang.String r5, com.tencent.mm.protocal.protobuf.FinderObject r6) {
        /*
            r4 = this;
            r1 = 242352(0x3b2b0, float:3.39607E-40)
            java.lang.String r0 = "username"
            kotlin.g.b.p.h(r5, r0)
            java.lang.String r0 = "finderObject"
            kotlin.g.b.p.h(r6, r0)
            long r2 = r6.id
            java.lang.String r0 = r6.objectNonceId
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = ""
        L_0x0018:
            r4.<init>(r5, r2, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            r4.tuO = r6
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.av.<init>(java.lang.String, com.tencent.mm.protocal.protobuf.FinderObject):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public av(java.lang.String r8, com.tencent.mm.protocal.protobuf.cng r9) {
        /*
            r7 = this;
            r6 = 242353(0x3b2b1, float:3.39609E-40)
            java.lang.String r0 = "username"
            kotlin.g.b.p.h(r8, r0)
            java.lang.String r0 = "megaVideo"
            kotlin.g.b.p.h(r9, r0)
            com.tencent.mm.protocal.protobuf.cns r0 = r9.MtI
            if (r0 == 0) goto L_0x002f
            long r2 = r0.hFK
        L_0x0015:
            com.tencent.mm.protocal.protobuf.cns r0 = r9.MtI
            if (r0 == 0) goto L_0x001d
            java.lang.String r4 = r0.objectNonceId
            if (r4 != 0) goto L_0x0020
        L_0x001d:
            java.lang.String r4 = ""
        L_0x0020:
            r5 = 1
            r0 = r7
            r1 = r8
            r0.<init>(r1, r2, r4, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            r7.tuP = r9
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x002f:
            r2 = 0
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.av.<init>(java.lang.String, com.tencent.mm.protocal.protobuf.cng):void");
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3627;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165205);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(165205);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        long j2;
        long j3;
        long j4;
        LinkedList<aop> linkedList;
        aop aop;
        bei bei;
        cng cng;
        AppMethodBeat.i(242350);
        Log.i(this.TAG, "errType " + i3 + " errCode " + i4 + " errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            FinderObject finderObject = this.tuO;
            if (finderObject != null) {
                c.a aVar = c.vGN;
                c.a.FT(this.hFK);
                long j5 = this.hFK;
                aoq aoq = finderObject.attachmentList;
                long j6 = (aoq == null || (linkedList = aoq.LAM) == null || (aop = (aop) j.kt(linkedList)) == null || (bei = aop.LAL) == null || (cng = bei.LIA) == null) ? 0 : cng.id;
                if (j6 != 0) {
                    c.a aVar2 = c.vGN;
                    c.a.FU(j6);
                }
                j2 = j5;
            } else {
                j2 = 0;
            }
            cng cng2 = this.tuP;
            if (cng2 != null) {
                c.a aVar3 = c.vGN;
                c.a.FU(cng2.id);
                cns cns = cng2.MtI;
                if (cns != null) {
                    j4 = cns.hFK;
                } else {
                    j4 = 0;
                }
                if (j4 != 0) {
                    c.a aVar4 = c.vGN;
                    c.a.FT(j4);
                }
                j3 = j4;
            } else {
                j3 = j2;
            }
            if (j3 != 0) {
                hg hgVar = new hg();
                hgVar.dLJ.id = j3;
                EventCenter.instance.publish(hgVar);
            }
            if (this.tuO == null && this.tuP == null) {
                c.a aVar5 = c.vGN;
                if (c.a.FT(this.hFK)) {
                    hg hgVar2 = new hg();
                    hgVar2.dLJ.id = this.hFK;
                    EventCenter.instance.publish(hgVar2);
                }
            }
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242350);
            return;
        }
        AppMethodBeat.o(242350);
    }
}
