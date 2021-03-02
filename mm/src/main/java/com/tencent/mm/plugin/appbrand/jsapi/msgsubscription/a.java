package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.util.a;
import com.tencent.mm.plugin.appbrand.networking.c;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/CompatNetSceneDispatcherDefaultAdapter;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "()V", "TAG", "", "mapWxaUsername2Appid", "Ljava/util/concurrent/ConcurrentHashMap;", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "setWxaUsername2Appid", "", "wxaUsername", "appid", "luggage-wechat-full-sdk_release"})
public final class a implements a.AbstractC0480a {
    private static final ConcurrentHashMap<String, String> mfv = new ConcurrentHashMap<>();
    public static final a mfw = new a();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "kotlin.jvm.PlatformType", "onTerminate"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.a$a  reason: collision with other inner class name */
    static final class C0682a<T> implements d.b {
        final /* synthetic */ a.c jzj;
        final /* synthetic */ a.b jzk;
        final /* synthetic */ com.tencent.mm.msgsubscription.util.a jzl;

        C0682a(a.c cVar, a.b bVar, com.tencent.mm.msgsubscription.util.a aVar) {
            this.jzj = cVar;
            this.jzk = bVar;
            this.jzl = aVar;
        }

        @Override // com.tencent.mm.vending.g.d.b
        public final /* synthetic */ void bz(Object obj) {
            AppMethodBeat.i(169628);
            dpc dpc = (dpc) obj;
            if (dpc != null) {
                try {
                    this.jzj.bji().parseFrom(dpc.toByteArray());
                    a.b bVar = this.jzk;
                    if (bVar != null) {
                        bVar.k(0, 0, null);
                        AppMethodBeat.o(169628);
                        return;
                    }
                    AppMethodBeat.o(169628);
                } catch (IOException e2) {
                    Log.e("Luggage.WXA.FULL.CompatNetSceneDispatcherDefaultAdapter", "onTerminate uri=" + this.jzj.getUri() + ", parse responseProtoBuf get e=" + e2);
                    a.b bVar2 = this.jzk;
                    if (bVar2 != null) {
                        bVar2.k(5, 0, null);
                        AppMethodBeat.o(169628);
                        return;
                    }
                    AppMethodBeat.o(169628);
                }
            } else {
                Log.e("Luggage.WXA.FULL.CompatNetSceneDispatcherDefaultAdapter", "onTerminate null response, uri=" + this.jzj.getUri());
                a.b bVar3 = this.jzk;
                if (bVar3 != null) {
                    bVar3.k(4, -1, null);
                    AppMethodBeat.o(169628);
                    return;
                }
                AppMethodBeat.o(169628);
            }
        }
    }

    static {
        AppMethodBeat.i(169632);
        AppMethodBeat.o(169632);
    }

    private a() {
    }

    @Override // com.tencent.mm.msgsubscription.util.a.AbstractC0480a
    public final int a(a.c cVar, a.b bVar, com.tencent.mm.msgsubscription.util.a aVar) {
        AppMethodBeat.i(169630);
        p.h(cVar, "rr");
        p.h(aVar, "scene");
        c cVar2 = (c) e.M(c.class);
        if (cVar2 == null) {
            AppMethodBeat.o(169630);
            return -1;
        }
        mfv.get(((com.tencent.mm.msgsubscription.a.b) aVar).username);
        cVar2.a(cVar.getUri(), cVar.bjh(), cVar.bji().getClass()).a(new C0682a(cVar, bVar, aVar)).a(new b(bVar, aVar));
        AppMethodBeat.o(169630);
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "err", "", "kotlin.jvm.PlatformType", "onInterrupt"})
    static final class b<T> implements d.a<Object> {
        final /* synthetic */ a.b jzk;
        final /* synthetic */ com.tencent.mm.msgsubscription.util.a jzl;

        b(a.b bVar, com.tencent.mm.msgsubscription.util.a aVar) {
            this.jzk = bVar;
            this.jzl = aVar;
        }

        @Override // com.tencent.mm.vending.g.d.a
        public final void cn(Object obj) {
            AppMethodBeat.i(169629);
            String obj2 = obj != null ? obj.toString() : null;
            a.b bVar = this.jzk;
            if (bVar != null) {
                bVar.k(1, -1, obj2);
                AppMethodBeat.o(169629);
                return;
            }
            AppMethodBeat.o(169629);
        }
    }

    public static void dB(String str, String str2) {
        AppMethodBeat.i(169631);
        p.h(str, "wxaUsername");
        p.h(str2, "appid");
        mfv.put(str, str2);
        AppMethodBeat.o(169631);
    }
}
