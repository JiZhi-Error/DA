package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.protocal.protobuf.cfd;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJl\u0010\u0016\u001a\u00020\u00152d\b\u0002\u0010\n\u001a^\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000bJ,\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016Rj\u0010\n\u001a^\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/live/model/JoinLiveRoom;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "liveId", "", "wechatRoomId", "", "liveName", "isAnchor", "", "(JLjava/lang/String;Ljava/lang/String;Z)V", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "ret", "errMsg", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "liveRoomInfo", "Lcom/tencent/trtc/TRTCCloudDef$TRTCParams;", "trtcParams", "", "join", "onSceneEnd", "errType", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-logic_release"})
public final class k implements i {
    public static final a hFX = new a((byte) 0);
    private final boolean dMz;
    private r<? super Integer, ? super String, ? super e, ? super TRTCCloudDef.TRTCParams, x> hFV;
    private final String hFW;
    private final String hwb;
    private final long liveId;

    static {
        AppMethodBeat.i(207576);
        AppMethodBeat.o(207576);
    }

    private k(long j2, String str, String str2) {
        p.h(str, "wechatRoomId");
        p.h(str2, "liveName");
        AppMethodBeat.i(207575);
        this.liveId = j2;
        this.hFW = str;
        this.hwb = str2;
        this.dMz = false;
        AppMethodBeat.o(207575);
    }

    public /* synthetic */ k(long j2, String str, String str2, byte b2) {
        this(j2, str, str2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/model/JoinLiveRoom$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(r<? super Integer, ? super String, ? super e, ? super TRTCCloudDef.TRTCParams, x> rVar) {
        AppMethodBeat.i(207573);
        b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3797, this);
        long j2 = this.liveId;
        String str = this.hFW;
        x xVar = x.hJf;
        o oVar = new o(j2, str, x.aGq());
        b aAg2 = g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().b(oVar);
        this.hFV = rVar;
        AppMethodBeat.o(207573);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(207574);
        if (qVar instanceof o) {
            Log.i("MicroMsg.JoinLiveRoom", "JoinLiveRoom on SceneEnd");
            if (i2 == 0 && i3 == 0) {
                cfd cfd = ((o) qVar).hKo;
                x xVar = x.hJf;
                x.a(cfd != null ? cfd.LFH : null);
                x xVar2 = x.hJf;
                cjb aGs = x.aGs();
                if (aGs != null) {
                    TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
                    e eVar = new e(null, 0, 0, null, 0, 0, 0, null, null, 0, 8191);
                    n nVar = n.hGh;
                    x xVar3 = x.hJf;
                    String str2 = x.aGr().LpF;
                    if (str2 == null) {
                        str2 = "";
                    }
                    x xVar4 = x.hJf;
                    n.a(str2, aGs, x.aGr(), tRTCParams, eVar);
                    if (this.dMz) {
                        e.a aVar = e.a.hxc;
                        eVar.hzl = e.a.aCe();
                    }
                    r.hIg.zz(j.aM((aGs.Mor - 60) * 1000, Util.MILLSECONDS_OF_MINUTE));
                    r<? super Integer, ? super String, ? super com.tencent.mm.live.core.core.b.e, ? super TRTCCloudDef.TRTCParams, x> rVar = this.hFV;
                    if (rVar != null) {
                        rVar.invoke(0, "", eVar, tRTCParams);
                    }
                }
            } else {
                Log.i("MicroMsg.JoinLiveRoom", "join live room failed " + i2 + ' ' + i3);
                r<? super Integer, ? super String, ? super com.tencent.mm.live.core.core.b.e, ? super TRTCCloudDef.TRTCParams, x> rVar2 = this.hFV;
                if (rVar2 != null) {
                    Integer valueOf = Integer.valueOf(i3);
                    if (str == null) {
                        str = "";
                    }
                    f.a aVar2 = f.hzy;
                    com.tencent.mm.live.core.core.b.e eVar2 = f.hzx;
                    f.a aVar3 = f.hzy;
                    rVar2.invoke(valueOf, str, eVar2, f.hzw);
                }
            }
            b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().b(3797, this);
        }
        AppMethodBeat.o(207574);
    }
}
