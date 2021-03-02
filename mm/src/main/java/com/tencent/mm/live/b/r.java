package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.a.e;
import com.tencent.mm.live.b.a.k;
import com.tencent.mm.live.b.a.m;
import com.tencent.mm.live.b.a.n;
import com.tencent.mm.live.b.a.o;
import com.tencent.mm.live.b.a.q;
import com.tencent.mm.live.b.a.s;
import com.tencent.mm.live.b.a.u;
import com.tencent.mm.live.b.b.a;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.protocal.protobuf.bpo;
import com.tencent.mm.protocal.protobuf.cfd;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.dlz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\bJ\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\fJ\u0010\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\bJ\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\fJ\u0010\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"J\u0014\u0010#\u001a\u00020\f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040%J\u0010\u0010&\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u000e\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\bJ\u0016\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\"J\u000e\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\"J\u000e\u0010.\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020\fJ,\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\"2\b\u00103\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0006\u00106\u001a\u00020\fJ\u000e\u00107\u001a\u00020\f2\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u00020\fJ\u0006\u0010;\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, hxF = {"Lcom/tencent/mm/live/model/LiveRoomOperation;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "getMessageTask", "Ljava/lang/Runnable;", "isAnchor", "", "keepAliveTask", "micKeepAliveTask", "doBanComment", "", "enableComment", "doCheckExitRoomReason", "doCloseLive", "cutLive", "doCloseLiveMic", "micId", "sdkUid", "doGetLiveInfo", "doGetLiveMessage", "delay", "", "doGetLiveOnlineByRoom", "wechatRoomId", "ignoreErr", "doGetLiveStateByRoom", "doGetMicAudienceInfo", "doKeepAlive", "doKickMember", ch.COL_USERNAME, "doLikeLive", "likeCount", "", "doLoadOnlineMembers", "userList", "", "doMicKeepAlive", "doOpenReplay", "enableOpenReplay", "doPostComment", "content", "msgType", "doSetAnchorStatus", "status", "doShareLive", "doVisitorOfflineNotify", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "startLive", "stopMicKeepAlive", "plugin-logic_release"})
public final class r implements i {
    private static final String TAG = TAG;
    private static boolean dMz = true;
    private static final Runnable hId = b.hIi;
    private static final Runnable hIe = a.hIh;
    public static final Runnable hIf = c.hIj;
    public static final r hIg = new r();

    static {
        AppMethodBeat.i(207688);
        AppMethodBeat.o(207688);
    }

    private r() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        public static final b hIi = new b();

        static {
            AppMethodBeat.i(207659);
            AppMethodBeat.o(207659);
        }

        b() {
        }

        public final void run() {
            AppMethodBeat.i(207658);
            com.tencent.mm.kernel.b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            t azz = aAg.azz();
            x xVar = x.hJf;
            long j2 = x.aGr().hyH;
            x xVar2 = x.hJf;
            String aGm = x.aGm();
            x xVar3 = x.hJf;
            azz.b(new o(j2, aGm, x.aGq()));
            AppMethodBeat.o(207658);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        public static final a hIh = new a();

        static {
            AppMethodBeat.i(207657);
            AppMethodBeat.o(207657);
        }

        a() {
        }

        public final void run() {
            AppMethodBeat.i(207656);
            com.tencent.mm.kernel.b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            t azz = aAg.azz();
            x xVar = x.hJf;
            long j2 = x.aGr().hyH;
            x xVar2 = x.hJf;
            azz.b(new m(j2, x.aGm()));
            AppMethodBeat.o(207656);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        public static final c hIj = new c();

        static {
            AppMethodBeat.i(207661);
            AppMethodBeat.o(207661);
        }

        c() {
        }

        public final void run() {
            String str;
            AppMethodBeat.i(207660);
            com.tencent.mm.kernel.b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            t azz = aAg.azz();
            x xVar = x.hJf;
            long j2 = x.aGr().hyH;
            x xVar2 = x.hJf;
            String aGm = x.aGm();
            x xVar3 = x.hJf;
            a.C0371a aVar = x.aHa().hKU;
            if (aVar == null || (str = aVar.hFz) == null) {
                str = "";
            }
            azz.b(new com.tencent.mm.live.b.a.t(j2, aGm, str));
            AppMethodBeat.o(207660);
        }
    }

    public static /* synthetic */ void aFY() {
        AppMethodBeat.i(207663);
        zy(0);
        AppMethodBeat.o(207663);
    }

    private static void zy(long j2) {
        AppMethodBeat.i(207662);
        d.C(hIe);
        d.a(j2, hIe);
        AppMethodBeat.o(207662);
    }

    public static void aFZ() {
        AppMethodBeat.i(207664);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar = x.hJf;
        long j2 = x.aGr().hyH;
        x xVar2 = x.hJf;
        azz.b(new m(j2, x.aGm(), true));
        AppMethodBeat.o(207664);
    }

    public static void aa(String str, int i2) {
        AppMethodBeat.i(207665);
        p.h(str, "content");
        String aTY = z.aTY();
        p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        com.tencent.mm.live.view.a.a aVar = new com.tencent.mm.live.view.a.a(aTY, "", str, i2, cl.aWB());
        x xVar = x.hJf;
        x.aGp().add(aVar);
        m mVar = m.hGg;
        m.aFe();
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar2 = x.hJf;
        long j2 = x.aGr().hyH;
        x xVar3 = x.hJf;
        byte[] aGq = x.aGq();
        if (aGq == null) {
            aGq = new byte[0];
        }
        x xVar4 = x.hJf;
        azz.b(new s(str, i2, j2, aGq, x.aGm()));
        AppMethodBeat.o(207665);
    }

    public static void qR(int i2) {
        AppMethodBeat.i(207666);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar = x.hJf;
        long j2 = x.aGr().hyH;
        x xVar2 = x.hJf;
        azz.b(new q(j2, x.aGm(), i2));
        AppMethodBeat.o(207666);
    }

    public static /* synthetic */ void aGa() {
        AppMethodBeat.i(207668);
        eE(false);
        AppMethodBeat.o(207668);
    }

    public static void eE(boolean z) {
        AppMethodBeat.i(207667);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar = x.hJf;
        long j2 = x.aGr().hyH;
        x xVar2 = x.hJf;
        azz.b(new com.tencent.mm.live.b.a.a(j2, x.aGm(), z));
        AppMethodBeat.o(207667);
    }

    public static /* synthetic */ void a(r rVar) {
        AppMethodBeat.i(207670);
        rVar.zz(0);
        AppMethodBeat.o(207670);
    }

    public final void zz(long j2) {
        AppMethodBeat.i(207669);
        Log.i(TAG, "doKeepAlive delay:".concat(String.valueOf(j2)));
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3797, this);
        d.C(hId);
        d.a(j2, hId);
        AppMethodBeat.o(207669);
    }

    public static /* synthetic */ void GM(String str) {
        AppMethodBeat.i(207672);
        z(str, false);
        AppMethodBeat.o(207672);
    }

    public static void z(String str, boolean z) {
        AppMethodBeat.i(207671);
        p.h(str, "wechatRoomId");
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar = x.hJf;
        azz.b(new com.tencent.mm.live.b.a.c(x.aGr().hyH, str, z));
        AppMethodBeat.o(207671);
    }

    public static void GN(String str) {
        AppMethodBeat.i(207673);
        p.h(str, "wechatRoomId");
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar = x.hJf;
        azz.b(new com.tencent.mm.live.b.a.d(x.aGr().hyH, str));
        AppMethodBeat.o(207673);
    }

    public static void aGb() {
        AppMethodBeat.i(207674);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar = x.hJf;
        long j2 = x.aGr().hyH;
        x xVar2 = x.hJf;
        azz.b(new com.tencent.mm.live.b.a.b(j2, x.aGm()));
        AppMethodBeat.o(207674);
    }

    public static void eF(boolean z) {
        AppMethodBeat.i(207675);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar = x.hJf;
        long j2 = x.aGr().hyH;
        x xVar2 = x.hJf;
        azz.b(new com.tencent.mm.live.b.a.i(j2, x.aGm(), z));
        AppMethodBeat.o(207675);
    }

    public static void GO(String str) {
        AppMethodBeat.i(207676);
        p.h(str, "wechatRoomId");
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar = x.hJf;
        azz.b(new u(x.aGr().hyH, str));
        AppMethodBeat.o(207676);
    }

    public static void eG(boolean z) {
        AppMethodBeat.i(207677);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar = x.hJf;
        long j2 = x.aGr().hyH;
        x xVar2 = x.hJf;
        azz.b(new com.tencent.mm.live.b.a.r(j2, x.aGm(), z));
        AppMethodBeat.o(207677);
    }

    public static void GP(String str) {
        AppMethodBeat.i(207678);
        p.h(str, ch.COL_USERNAME);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar = x.hJf;
        long j2 = x.aGr().hyH;
        x xVar2 = x.hJf;
        azz.b(new com.tencent.mm.live.b.a.p(j2, x.aGm(), str));
        AppMethodBeat.o(207678);
    }

    public final void zA(long j2) {
        AppMethodBeat.i(207679);
        Log.i(TAG, "doMicKeepLive delay:".concat(String.valueOf(j2)));
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(760, this);
        d.C(hIf);
        d.a(j2, hIf);
        AppMethodBeat.o(207679);
    }

    public static void qS(int i2) {
        AppMethodBeat.i(207680);
        ciq ciq = new ciq();
        ciq.MnE = (long) i2;
        ciq.MnD = cl.aWz();
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar = x.hJf;
        azz.b(new com.tencent.mm.live.b.a.g(x.aGr().hyH, ciq));
        AppMethodBeat.o(207680);
    }

    public static void ag(List<String> list) {
        AppMethodBeat.i(207681);
        p.h(list, "userList");
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar = x.hJf;
        azz.b(new n(x.aGr().hyH, list));
        AppMethodBeat.o(207681);
    }

    public static void aw(String str, String str2) {
        AppMethodBeat.i(207682);
        p.h(str, "micId");
        p.h(str2, "sdkUid");
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar = x.hJf;
        long j2 = x.aGr().hyH;
        x xVar2 = x.hJf;
        azz.b(new k(j2, x.aGm(), String.valueOf(System.currentTimeMillis()), str, str2));
        AppMethodBeat.o(207682);
    }

    public static void aGc() {
        AppMethodBeat.i(207683);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        t azz = aAg.azz();
        x xVar = x.hJf;
        long j2 = x.aGr().hyH;
        x xVar2 = x.hJf;
        azz.b(new e(j2, x.aGm()));
        AppMethodBeat.o(207683);
    }

    public static void a(LiveConfig liveConfig) {
        AppMethodBeat.i(207684);
        p.h(liveConfig, "config");
        dMz = liveConfig.aBC() == LiveConfig.hvT;
        AppMethodBeat.o(207684);
    }

    public final void aGd() {
        AppMethodBeat.i(207685);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3767, this);
        com.tencent.mm.kernel.b aAg2 = g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().a(f.CTRL_INDEX, this);
        AppMethodBeat.o(207685);
    }

    public final void release() {
        AppMethodBeat.i(207686);
        d.C(hId);
        d.C(hIe);
        d.C(hIf);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3767, this);
        com.tencent.mm.kernel.b aAg2 = g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().b(3797, this);
        com.tencent.mm.kernel.b aAg3 = g.aAg();
        p.g(aAg3, "MMKernel.network()");
        aAg3.azz().b(760, this);
        com.tencent.mm.kernel.b aAg4 = g.aAg();
        p.g(aAg4, "MMKernel.network()");
        aAg4.azz().b(f.CTRL_INDEX, this);
        AppMethodBeat.o(207686);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        LinkedList<ciy> linkedList;
        ciy ciy;
        TRTCCloudDef.TRTCParams tRTCParams;
        TRTCCloudDef.TRTCParams tRTCParams2;
        long aFJ;
        long j2 = 0;
        cjb cjb = null;
        AppMethodBeat.i(207687);
        if (qVar instanceof m) {
            long j3 = ((m) qVar).duration;
            o.i iVar = o.i.hHg;
            if (j3 > o.i.aFJ()) {
                aFJ = 0;
            } else {
                o.i iVar2 = o.i.hHg;
                aFJ = o.i.aFJ();
            }
            Log.i(TAG, "NetSceneLiveGetLiveMessage duration:" + ((m) qVar).duration + ", delay:" + aFJ);
            zy(aFJ);
            x xVar = x.hJf;
            x xVar2 = x.hJf;
            x.qU(x.aGr().LIa);
            AppMethodBeat.o(207687);
            return;
        }
        if (qVar instanceof com.tencent.mm.live.b.a.o) {
            com.tencent.mm.kernel.b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().b(3797, this);
            if (i2 == 0 && i3 == 0) {
                cfd cfd = ((com.tencent.mm.live.b.a.o) qVar).hKo;
                if (cfd != null) {
                    cjb = cfd.LFH;
                }
                if (cjb != null) {
                    x xVar3 = x.hJf;
                    x.a(cjb);
                    Log.i(TAG, "doKeepAlive updatePrivateMapKey");
                    if (dMz) {
                        b.a aVar = com.tencent.mm.live.core.core.a.b.hyv;
                        MMApplicationContext.getContext();
                        com.tencent.mm.live.core.core.a.b aDo = b.a.aDo();
                        String yO = cjb.Mon.yO();
                        p.g(yO, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
                        aDo.Go(yO);
                    } else {
                        b.a aVar2 = com.tencent.mm.live.core.core.d.b.hCo;
                        MMApplicationContext.getContext();
                        com.tencent.mm.live.core.core.d.b aEf = b.a.aEf();
                        String yO2 = cjb.Mon.yO();
                        p.g(yO2, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
                        aEf.Go(yO2);
                    }
                    x xVar4 = x.hJf;
                    com.tencent.mm.live.core.core.b.f aGv = x.aGv();
                    if (!(aGv == null || (tRTCParams2 = aGv.hzu) == null)) {
                        tRTCParams2.privateMapKey = cjb.Mon.yO();
                    }
                    x xVar5 = x.hJf;
                    cjb aGs = x.aGs();
                    if (aGs != null) {
                        j2 = aGs.Mor;
                    }
                    zz(j.aM((j2 - 60) * 1000, Util.MILLSECONDS_OF_MINUTE));
                    AppMethodBeat.o(207687);
                    return;
                }
            }
        } else if (qVar instanceof com.tencent.mm.live.b.a.t) {
            com.tencent.mm.kernel.b aAg2 = g.aAg();
            p.g(aAg2, "MMKernel.network()");
            aAg2.azz().b(760, this);
            if (i2 == 0 && i3 == 0) {
                dlz dlz = ((com.tencent.mm.live.b.a.t) qVar).hKD;
                if (dlz != null) {
                    cjb = dlz.LFH;
                }
                if (cjb != null) {
                    x xVar6 = x.hJf;
                    x.a(cjb);
                    Log.i(TAG, "doMicKeepAlive updatePrivateMapKey");
                    b.a aVar3 = com.tencent.mm.live.core.core.d.b.hCo;
                    MMApplicationContext.getContext();
                    com.tencent.mm.live.core.core.d.b aEf2 = b.a.aEf();
                    String yO3 = cjb.Mon.yO();
                    p.g(yO3, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
                    aEf2.Go(yO3);
                    x xVar7 = x.hJf;
                    com.tencent.mm.live.core.core.b.f aGv2 = x.aGv();
                    if (!(aGv2 == null || (tRTCParams = aGv2.hzu) == null)) {
                        tRTCParams.privateMapKey = cjb.Mon.yO();
                    }
                    x xVar8 = x.hJf;
                    zA(j.aM((x.aGw() - 60) * 1000, Util.MILLSECONDS_OF_MINUTE));
                    AppMethodBeat.o(207687);
                    return;
                }
            }
        } else if (qVar instanceof e) {
            bpo bpo = ((e) qVar).hJK;
            if (bpo != null) {
                linkedList = bpo.LXJ;
            } else {
                linkedList = null;
            }
            LinkedList<ciy> linkedList2 = linkedList;
            if (linkedList2 != null) {
                if ((!linkedList2.isEmpty()) && (ciy = linkedList2.get(0)) != null) {
                    Log.i(TAG, "update live mic audienceInfo:[" + ciy.MnR + ' ' + ciy.nickname + ']');
                    x xVar9 = x.hJf;
                    com.tencent.mm.live.b.b.a aHa = x.aHa();
                    x xVar10 = x.hJf;
                    long j4 = x.aGr().hyH;
                    String str2 = ciy.KDS;
                    p.g(str2, "it.live_mic_id");
                    String str3 = ciy.MnR;
                    p.g(str3, "it.identity_id");
                    String str4 = ciy.qFV;
                    p.g(str4, "it.head_img_url");
                    String str5 = ciy.nickname;
                    p.g(str5, "it.nickname");
                    String str6 = ciy.MnL;
                    p.g(str6, "it.sdk_user_id");
                    aHa.a(j4, str2, str3, str4, str5, str6);
                    AppMethodBeat.o(207687);
                    return;
                }
            } else {
                AppMethodBeat.o(207687);
                return;
            }
        }
        AppMethodBeat.o(207687);
    }
}
