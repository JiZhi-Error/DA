package com.tencent.mm.live.b.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.b.x;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J>\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, hxF = {"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class d extends q implements m {
    private static final String TAG = TAG;
    public static final a hJI = new a((byte) 0);
    private i callback;
    private final String hFW;
    private bpt hJG;
    private bpu hJH;
    private com.tencent.mm.ak.d hJu;
    private final long liveId;

    public d(long j2, String str) {
        p.h(str, "wechatRoomId");
        AppMethodBeat.i(207752);
        this.liveId = j2;
        this.hFW = str;
        d.a aVar = new d.a();
        aVar.c(new bpt());
        aVar.d(new bpu());
        aVar.sG(3700);
        aVar.MB("/cgi-bin/micromsg-bin/getliveonlinestatebyroom");
        aVar.sI(0);
        aVar.sJ(0);
        com.tencent.mm.ak.d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.hJu = aXF;
        com.tencent.mm.bw.a aYJ = this.hJu.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomRequest");
            AppMethodBeat.o(207752);
            throw tVar;
        }
        this.hJG = (bpt) aYJ;
        bpt bpt = this.hJG;
        if (bpt != null) {
            bpt.hyH = this.liveId;
        }
        bpt bpt2 = this.hJG;
        if (bpt2 != null) {
            bpt2.KDQ = this.hFW;
            AppMethodBeat.o(207752);
            return;
        }
        AppMethodBeat.o(207752);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(207753);
        AppMethodBeat.o(207753);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3700;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(207750);
        Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(207750);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        A a2;
        AppMethodBeat.i(207751);
        Log.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        if (sVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
            AppMethodBeat.o(207751);
            throw tVar;
        }
        com.tencent.mm.bw.a aYK = ((com.tencent.mm.ak.d) sVar).aYK();
        if (aYK == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomResponse");
            AppMethodBeat.o(207751);
            throw tVar2;
        }
        this.hJH = (bpu) aYK;
        if (i3 == 0 && i4 == 0) {
            bpu bpu = this.hJH;
            if (bpu != null) {
                x xVar = x.hJf;
                if (x.aGo().get(this.hFW) == null) {
                    x xVar2 = x.hJf;
                    x.aGo().put(this.hFW, new o<>(new ArrayList(), 0));
                }
                x xVar3 = x.hJf;
                o<ArrayList<String>, Integer> oVar = x.aGo().get(this.hFW);
                if (oVar != null) {
                    a2 = oVar.first;
                } else {
                    a2 = null;
                }
                if (a2 != null) {
                    a2.clear();
                }
                ArrayList arrayList = new ArrayList();
                LinkedList<cje> linkedList = bpu.LXM;
                p.g(linkedList, "it.user_online_state_list");
                Iterator<T> it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().MnR);
                }
                if (a2 != null) {
                    a2.addAll(arrayList);
                }
                Log.i(TAG, "idList:".concat(String.valueOf(arrayList)));
                x xVar4 = x.hJf;
                x.aGr().LIa = arrayList.size();
            }
        } else {
            Log.e(TAG, "onGYNetEnd error");
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(207751);
            return;
        }
        AppMethodBeat.o(207751);
    }
}
