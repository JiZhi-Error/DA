package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.radar.ui.g;
import com.tencent.mm.protocal.protobuf.djb;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J>\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u000b2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opCode", "", "latitude", "", "longitude", "precision", "gpsSource", "macAddr", "", "cellId", "(IFFIILjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpCode", "()I", "radarSearchMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMembers", "()Ljava/util/LinkedList;", "radarSearchMembersCount", "getRadarSearchMembersCount", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-radar_release"})
public final class b extends q implements m {
    public static final a Bye = new a((byte) 0);
    private static final String TAG = TAG;
    private i callback;
    final int dJY;
    private final float dTj;
    private final int dTk;
    private final int dTl;
    private final String dTm;
    private final String dTn;
    private final float latitude;
    d rr;

    public /* synthetic */ b() {
        this(2, 0.0f, 0.0f, 0, 0, "", "");
        AppMethodBeat.i(138511);
        AppMethodBeat.o(138511);
    }

    public b(int i2, float f2, float f3, int i3, int i4, String str, String str2) {
        p.h(str, "macAddr");
        p.h(str2, "cellId");
        AppMethodBeat.i(138510);
        this.dJY = i2;
        this.latitude = f2;
        this.dTj = f3;
        this.dTk = i3;
        this.dTl = i4;
        this.dTm = str;
        this.dTn = str2;
        if (this.dJY == 0) {
            Log.e(TAG, "opcode is wrong!");
        }
        AppMethodBeat.o(138510);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        LinkedList<djb> linkedList;
        AppMethodBeat.i(138508);
        Log.d(TAG, "onGYNetEnd errtype:" + i3 + " errcode:" + i4 + " errMsg:" + str);
        if (this.dJY == 1 && i3 == 0) {
            ArrayList arrayList = new ArrayList();
            d dVar = this.rr;
            com.tencent.mm.bw.a aYK = dVar != null ? dVar.aYK() : null;
            if (!(aYK instanceof djd)) {
                aYK = null;
            }
            djd djd = (djd) aYK;
            if (!(djd == null || (linkedList = djd.KGQ) == null)) {
                for (T t : linkedList) {
                    com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
                    g gVar = g.BAY;
                    p.g(t, "member");
                    iVar.setUsername(g.b(t));
                    iVar.Mw(t.SmallImgUrl);
                    iVar.fv(true);
                    arrayList.add(iVar);
                }
            }
            com.tencent.mm.aj.p.aYB().av(arrayList);
        }
        i iVar2 = this.callback;
        if (iVar2 != null) {
            iVar2.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(138508);
            return;
        }
        AppMethodBeat.o(138508);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 425;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(138509);
        p.h(gVar, "dispatcher");
        p.h(iVar, "callback");
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.c(new djc());
        aVar.d(new djd());
        aVar.MB("/cgi-bin/micromsg-bin/mmradarsearch");
        aVar.sG(425);
        aVar.sI(209);
        aVar.sJ(1000000209);
        this.rr = aVar.aXF();
        d dVar = this.rr;
        if (dVar == null) {
            p.hyc();
        }
        com.tencent.mm.bw.a aYJ = dVar.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
            AppMethodBeat.o(138509);
            throw tVar;
        }
        djc djc = (djc) aYJ;
        djc.OpCode = this.dJY;
        djc.LuV = this.dTn;
        djc.LuW = this.dTl;
        djc.LbD = this.latitude;
        djc.LbC = this.dTj;
        djc.LuU = this.dTm;
        djc.LuT = this.dTk;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(138509);
        return dispatch;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(138512);
        AppMethodBeat.o(138512);
    }
}
