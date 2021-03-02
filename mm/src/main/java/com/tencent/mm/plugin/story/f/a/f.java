package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.protocal.protobuf.edw;
import com.tencent.mm.protocal.protobuf.edx;
import com.tencent.mm.protocal.protobuf.edy;
import com.tencent.mm.protocal.protobuf.eeb;
import com.tencent.mm.protocal.protobuf.eec;
import com.tencent.mm.protocal.protobuf.eed;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\bJ\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0018\u001a\u00020\u0007H\u0016J>\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opList", "", "Lcom/tencent/mm/plugin/story/model/cgi/BaseStoryOpItem;", "localIdList", "", "(Ljava/util/List;Ljava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getLocalIdList", "()Ljava/util/List;", "getOpList", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getOp", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class f extends q implements m {
    public static final a FnI = new a((byte) 0);
    private static final String TAG = TAG;
    private final List<a> FnG;
    public final List<Integer> FnH;
    public i callback;
    private final d rr;

    public /* synthetic */ f(List list) {
        this(list, new ArrayList());
        AppMethodBeat.i(118817);
        AppMethodBeat.o(118817);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.List<? extends com.tencent.mm.plugin.story.f.a.a> */
    /* JADX WARN: Multi-variable type inference failed */
    public f(List<? extends a> list, List<Integer> list2) {
        p.h(list, "opList");
        p.h(list2, "localIdList");
        AppMethodBeat.i(118816);
        this.FnG = list;
        this.FnH = list2;
        d.a aVar = new d.a();
        aVar.c(new eec());
        aVar.d(new eed());
        aVar.MB("/cgi-bin/micromsg-bin/mmstoryobjectop");
        aVar.sG(764);
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpRequest");
            AppMethodBeat.o(118816);
            throw tVar;
        }
        eec eec = (eec) aYJ;
        eec.MZB = this.FnG.size();
        for (a aVar2 : this.FnG) {
            eeb eeb = new eeb();
            eeb.Nds = aVar2.edx;
            eeb.him = aVar2.type;
            Log.i(TAG, "op.id:" + aVar2.edx + " op.type:" + aVar2.type);
            if (aVar2 instanceof l) {
                edx edx = new edx();
                edx.Nds = aVar2.edx;
                eeb.Neu = new SKBuiltinBuffer_t().setBuffer(edx.toByteArray());
            } else if (aVar2 instanceof j) {
                edv edv = new edv();
                edv.MYT = ((j) aVar2).FnS;
                eeb.Neu = new SKBuiltinBuffer_t().setBuffer(edv.toByteArray());
            } else if (aVar2 instanceof m) {
                edy edy = new edy();
                edy.Nek = ((m) aVar2).FnU;
                edy.Nds = aVar2.edx;
                eeb.Neu = new SKBuiltinBuffer_t().setBuffer(edy.toByteArray());
            } else if (aVar2 instanceof k) {
                edw edw = new edw();
                edw.Nej = ((k) aVar2).FnT;
                edw.Nds = aVar2.edx;
                eeb.Neu = new SKBuiltinBuffer_t().setBuffer(edw.toByteArray());
            }
            eec.MZC.add(eeb);
        }
        AppMethodBeat.o(118816);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(118818);
        AppMethodBeat.o(118818);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(118813);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(118813);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 764;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(118814);
        Log.i(TAG, "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpResponse");
            AppMethodBeat.o(118814);
            throw tVar;
        }
        Log.i(TAG, "respCount=".concat(String.valueOf(((eed) aYK).Nev)));
        i iVar = this.callback;
        if (iVar == null) {
            p.btv("callback");
        }
        iVar.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(118814);
    }

    public final a foQ() {
        boolean z;
        AppMethodBeat.i(118815);
        if (this.FnG != null) {
            if (!this.FnG.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                a aVar = this.FnG.get(0);
                AppMethodBeat.o(118815);
                return aVar;
            }
        }
        AppMethodBeat.o(118815);
        return null;
    }
}
