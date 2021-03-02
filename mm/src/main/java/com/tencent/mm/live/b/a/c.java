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
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.protocal.protobuf.bpq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J>\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, hxF = {"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "ignoreErr", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getIgnoreErr", "()Z", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class c extends q implements m {
    private static final String TAG = TAG;
    public static final a hJF = new a((byte) 0);
    private i callback;
    private final String hFW;
    private bpp hJC;
    private bpq hJD;
    public final boolean hJE;
    private d hJu;
    private final long liveId;

    public c(long j2, String str, boolean z) {
        p.h(str, "wechatRoomId");
        AppMethodBeat.i(207748);
        this.liveId = j2;
        this.hFW = str;
        this.hJE = z;
        d.a aVar = new d.a();
        aVar.c(new bpp());
        aVar.d(new bpq());
        aVar.sG(3662);
        aVar.MB("/cgi-bin/micromsg-bin/getliveonlinebyroom");
        aVar.sI(0);
        aVar.sJ(0);
        d aXF = aVar.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.hJu = aXF;
        com.tencent.mm.bw.a aYJ = this.hJu.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomRequest");
            AppMethodBeat.o(207748);
            throw tVar;
        }
        this.hJC = (bpp) aYJ;
        bpp bpp = this.hJC;
        if (bpp != null) {
            bpp.hyH = this.liveId;
        }
        bpp bpp2 = this.hJC;
        if (bpp2 != null) {
            bpp2.KDQ = this.hFW;
            AppMethodBeat.o(207748);
            return;
        }
        AppMethodBeat.o(207748);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineByRoom$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(207749);
        AppMethodBeat.o(207749);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(207746);
        Log.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        if (sVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
            AppMethodBeat.o(207746);
            throw tVar;
        }
        com.tencent.mm.bw.a aYK = ((d) sVar).aYK();
        if (aYK == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineByRoomResponse");
            AppMethodBeat.o(207746);
            throw tVar2;
        }
        this.hJD = (bpq) aYK;
        if (i3 == 0 && i4 == 0) {
            bpq bpq = this.hJD;
            if (bpq != null) {
                x xVar = x.hJf;
                if (x.aGo().get(this.hFW) == null) {
                    x xVar2 = x.hJf;
                    x.aGo().put(this.hFW, new o<>(new ArrayList(), 0));
                }
                x xVar3 = x.hJf;
                o<ArrayList<String>, Integer> oVar = x.aGo().get(this.hFW);
                A a2 = oVar != null ? oVar.first : null;
                if (a2 != null) {
                    a2.clear();
                }
                if (a2 != null) {
                    LinkedList<String> linkedList = bpq.LXK;
                    p.g(linkedList, "it.identity_id_list");
                    ArrayList arrayList = new ArrayList();
                    for (T t : linkedList) {
                        x xVar4 = x.hJf;
                        if (!Util.isEqual(x.aGt(), t)) {
                            arrayList.add(t);
                        }
                    }
                    a2.addAll(arrayList);
                }
                x xVar5 = x.hJf;
                x.aGr().LIa = a2 != null ? a2.size() : 0;
                Log.i(TAG, "it.identity_id_list:" + bpq.LXK);
            }
        } else {
            Log.e("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "onGYNetEnd error");
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(207746);
            return;
        }
        AppMethodBeat.o(207746);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3662;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(207747);
        Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(207747);
        return dispatch;
    }
}
