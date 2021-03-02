package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.f;
import com.tencent.mm.plugin.story.h.e;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.protocal.protobuf.edh;
import com.tencent.mm.protocal.protobuf.edi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0016H\u0016J>\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", ClientInfoTable.Columns.CLIENTID, "", "commentDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "sessionId", "currentCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getCurrentCommentItem", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getCurCommentItem", "getResp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class c extends q implements m {
    public static final a FnC = new a((byte) 0);
    private static final String TAG = TAG;
    private edf FnA;
    public final com.tencent.mm.plugin.story.f.b.a FnB;
    public i callback;
    public final d rr;

    public c(String str, edf edf, String str2, com.tencent.mm.plugin.story.f.b.a aVar) {
        p.h(str, ClientInfoTable.Columns.CLIENTID);
        p.h(edf, "commentDetail");
        AppMethodBeat.i(118802);
        this.FnA = edf;
        this.FnB = aVar;
        d.a aVar2 = new d.a();
        aVar2.c(new edh());
        aVar2.d(new edi());
        aVar2.MB("/cgi-bin/micromsg-bin/mmstorycomment");
        aVar2.sG(f.CTRL_INDEX);
        aVar2.sI(0);
        aVar2.sJ(0);
        d aXF = aVar2.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentRequest");
            AppMethodBeat.o(118802);
            throw tVar;
        }
        edh edh = (edh) aYJ;
        edh.izX = str;
        edh.NdH = this.FnA;
        h hVar = h.FuH;
        edh.NdJ = (int) h.fqi().ahw();
        h hVar2 = h.FuH;
        edh.NdK = (int) h.fqi().ahx();
        edh.SessionId = str2;
        Log.i(TAG, "ClientId " + edh.izX + " PreviewEnterScene " + edh.NdJ + " sessionID: " + edh.SessionId + ' ');
        AppMethodBeat.o(118802);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(118800);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(118800);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return f.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(118801);
        Log.i(TAG, "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (i3 == 0 && i4 == 0) {
            String str2 = this.FnA.iAc;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                e eVar = e.Fuh;
                e.fpZ();
            } else {
                e eVar2 = e.Fuh;
                e.fqa();
            }
        } else {
            String str3 = this.FnA.iAc;
            if (str3 == null || str3.length() == 0) {
                z2 = true;
            }
            if (z2) {
                e eVar3 = e.Fuh;
                e.fqb();
                if (i3 == 4) {
                    e eVar4 = e.Fuh;
                    e.fqd();
                }
            } else {
                e eVar5 = e.Fuh;
                e.fqc();
                if (i3 == 4) {
                    e eVar6 = e.Fuh;
                    e.fqe();
                }
            }
        }
        i iVar = this.callback;
        if (iVar == null) {
            p.btv("callback");
        }
        iVar.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(118801);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryComment$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(118803);
        AppMethodBeat.o(118803);
    }
}
