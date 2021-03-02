package com.tencent.mm.plugin.updater.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010(\u001a\u00020\nH\u0016J>\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/updater/model/NetSceneManualCheckWxUpdate;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "baseId", "", "patchId", "targets", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/PRCondition;", "source", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;I)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "()I", "tinkerSyncNode", "Lcom/tencent/mm/protocal/protobuf/PRRespNode;", "getTinkerSyncNode", "()Lcom/tencent/mm/protocal/protobuf/PRRespNode;", "setTinkerSyncNode", "(Lcom/tencent/mm/protocal/protobuf/PRRespNode;)V", "tinkerSyncResponse", "Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "getTinkerSyncResponse", "()Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;", "setTinkerSyncResponse", "(Lcom/tencent/mm/plugin/hp/util/TinkerSyncResponse;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-updater_release"})
public final class c extends q implements m {
    public b GwJ;
    private cxz GwK;
    private final String TAG;
    private i callback;
    private final d rr;
    public final int source;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private /* synthetic */ c() {
        /*
            r5 = this;
            r4 = 194764(0x2f8cc, float:2.72922E-40)
            java.lang.String r0 = com.tencent.mm.loader.j.a.aKw()
            if (r0 != 0) goto L_0x000c
            java.lang.String r0 = ""
        L_0x000c:
            java.lang.String r1 = com.tencent.mm.loader.j.a.aKx()
            if (r1 != 0) goto L_0x0015
            java.lang.String r1 = ""
        L_0x0015:
            java.util.LinkedList r2 = com.tencent.mm.plugin.hp.net.e.dZe()
            java.lang.String r3 = "NetSceneCheckTinkerUtil.getConditionList()"
            kotlin.g.b.p.g(r2, r3)
            r3 = 0
            r5.<init>(r0, r1, r2, r3)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.updater.model.c.<init>():void");
    }

    public c(String str, String str2, LinkedList<cxu> linkedList, int i2) {
        p.h(str, "baseId");
        p.h(str2, "patchId");
        p.h(linkedList, "targets");
        AppMethodBeat.i(194763);
        this.source = i2;
        this.TAG = "MicroMsg.Updater.NetSceneManualCheckWxUpdate";
        cxv cxv = new cxv();
        cxv.MCI = str;
        cxv.APx = str2;
        cxv.MCJ = linkedList;
        cxv.MCL = 1;
        d.a aVar = new d.a();
        aVar.c(cxv);
        aVar.d(new cxw());
        aVar.MB("/cgi-bin/micromsg-bin/prconfig");
        aVar.sG(3899);
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        Log.i(this.TAG, "Create NetSceneManualCheckWxUpdate baseId:" + str + " patchId:" + str2);
        AppMethodBeat.o(194763);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3899;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(194761);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(194761);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(194762);
        Log.i(this.TAG, "errType:" + i3 + ", errCode:" + i4 + ", errMsg:" + str);
        if (i3 == 0 && i4 == 0) {
            if (sVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                AppMethodBeat.o(194762);
                throw tVar;
            }
            a aYK = ((d) sVar).aYK();
            if (aYK == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.PRConfigResponse");
                AppMethodBeat.o(194762);
                throw tVar2;
            }
            cxz cxz = ((cxw) aYK).MCM;
            if (cxz != null) {
                this.GwK = cxz;
                this.GwJ = new b(cxz);
            }
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(194762);
            return;
        }
        AppMethodBeat.o(194762);
    }
}
