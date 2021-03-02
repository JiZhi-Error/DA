package com.tencent.mm.msgsubscription.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.msgsubscription.util.a;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import g.a.a.b;
import java.io.IOException;
import java.util.WeakHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u000e\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u0014H\u0002J\u0014\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016*\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/msgsubscription/cgi/MMCompatNetworkDispatcher;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "()V", "TAG", "", "mapCompat2MMNetScene", "Ljava/util/WeakHashMap;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "cancel", "", "scene", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "checkIsValid", "", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toMMRepRespWrapper", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "plugin-comm_release"})
public final class a implements a.AbstractC0480a {
    private static final WeakHashMap<com.tencent.mm.msgsubscription.util.a, q> jzh = new WeakHashMap<>();
    public static final a jzi = new a();

    static {
        AppMethodBeat.i(177282);
        AppMethodBeat.o(177282);
    }

    private a() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "mmrr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    /* renamed from: com.tencent.mm.msgsubscription.a.a$a  reason: collision with other inner class name */
    static final class C0461a implements IPCRunCgi.a {
        final /* synthetic */ a.c jzj;
        final /* synthetic */ a.b jzk;
        final /* synthetic */ com.tencent.mm.msgsubscription.util.a jzl;

        C0461a(a.c cVar, a.b bVar, com.tencent.mm.msgsubscription.util.a aVar) {
            this.jzj = cVar;
            this.jzk = bVar;
            this.jzl = aVar;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, d dVar) {
            AppMethodBeat.i(177279);
            a aVar = a.jzi;
            p.g(dVar, "mmrr");
            if (a.f(dVar.aYK())) {
                try {
                    this.jzj.bji().parseFrom(dVar.aYK().toByteArray());
                } catch (IOException e2) {
                    Log.e("MicroMsg.MMCompatNetworkDispatcher", "parseFrom mmrr uri=" + this.jzj.getUri() + ", e=" + e2);
                    a.b bVar = this.jzk;
                    if (bVar != null) {
                        bVar.k(5, i3, str);
                        AppMethodBeat.o(177279);
                        return;
                    }
                    AppMethodBeat.o(177279);
                    return;
                } catch (b e3) {
                    Log.e("MicroMsg.MMCompatNetworkDispatcher", "parseFrom mmrr uri=" + this.jzj.getUri() + ", e=" + e3);
                    a.b bVar2 = this.jzk;
                    if (bVar2 != null) {
                        bVar2.k(i2, i3, str);
                        AppMethodBeat.o(177279);
                        return;
                    }
                    AppMethodBeat.o(177279);
                    return;
                }
            }
            a.b bVar3 = this.jzk;
            if (bVar3 != null) {
                bVar3.k(i2, i3, str);
                AppMethodBeat.o(177279);
                return;
            }
            AppMethodBeat.o(177279);
        }
    }

    public static void a(com.tencent.mm.msgsubscription.util.a aVar) {
        q qVar;
        AppMethodBeat.i(177281);
        if (aVar == null) {
            AppMethodBeat.o(177281);
            return;
        }
        synchronized (jzh) {
            try {
                qVar = jzh.get(aVar);
            } finally {
                AppMethodBeat.o(177281);
            }
        }
        if (qVar != null) {
            aa.a(qVar);
        }
    }

    @Override // com.tencent.mm.msgsubscription.util.a.AbstractC0480a
    public final int a(a.c cVar, a.b bVar, com.tencent.mm.msgsubscription.util.a aVar) {
        AppMethodBeat.i(177280);
        p.h(cVar, "rr");
        p.h(aVar, "scene");
        d.a aVar2 = new d.a();
        aVar2.c(cVar.bjh());
        aVar2.d(cVar.bji());
        aVar2.MB(cVar.getUri());
        aVar2.sG(cVar.getType());
        q a2 = IPCRunCgi.a(aVar2.aXF(), new C0461a(cVar, bVar, aVar));
        if (a2 != null) {
            synchronized (jzh) {
                try {
                    jzh.put(aVar, a2);
                } catch (Throwable th) {
                    AppMethodBeat.o(177280);
                    throw th;
                }
            }
        }
        AppMethodBeat.o(177280);
        return 0;
    }

    public static final /* synthetic */ boolean f(com.tencent.mm.bw.a aVar) {
        AppMethodBeat.i(184246);
        if (aVar == null) {
            AppMethodBeat.o(184246);
            return false;
        } else if (!(aVar instanceof dpc) || ((dpc) aVar).getBaseResponse() != null) {
            AppMethodBeat.o(184246);
            return true;
        } else {
            AppMethodBeat.o(184246);
            return false;
        }
    }
}
