package com.tencent.mm.plugin.byp;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.au;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.byp.a;
import com.tencent.mm.plugin.byp.c;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0006\u0018\u0000 \u00192\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/byp/PluginByp;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/byp/api/IPluginByp;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "bypSyncEventListener", "com/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1", "Lcom/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1;", "syncExtension", "Lcom/tencent/mm/plugin/byp/BypSyncCore;", "addBypSyncHandler", "", "bizSyncKeyType", "", "handler", "Lcom/tencent/mm/plugin/byp/api/IBypSyncHandler;", "configure", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "removeBypSyncHandler", "Companion", "plugin-byp_release"})
public final class PluginByp extends f implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.byp.a.c {
    public static final a pPs = new a((byte) 0);
    private final c pPq = new c();
    private final b pPr = new b(this);

    static {
        AppMethodBeat.i(199106);
        AppMethodBeat.o(199106);
    }

    public PluginByp() {
        AppMethodBeat.i(199105);
        AppMethodBeat.o(199105);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/byp/PluginByp$Companion;", "", "()V", "TAG", "", "plugin-byp_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/byp/PluginByp$bypSyncEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BypNotifyEvent;", "callback", "", "event", "plugin-byp_release"})
    public static final class b extends IListener<au> {
        final /* synthetic */ PluginByp pPt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(PluginByp pluginByp) {
            this.pPt = pluginByp;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(au auVar) {
            AppMethodBeat.i(199098);
            au auVar2 = auVar;
            p.h(auVar2, "event");
            c cVar = this.pPt.pPq;
            LinkedList<Integer> linkedList = auVar2.dDQ.dDR.LaF;
            p.g(linkedList, "event.data.data.selector");
            c.a(cVar, linkedList, c.b.NOTIFY, false, 12);
            AppMethodBeat.o(199098);
            return true;
        }
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(199100);
        Log.i("Byp.PluginByp", "[onAccountRelease]");
        this.pPr.dead();
        this.pPq.pOY.dead();
        AppMethodBeat.o(199100);
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(g gVar) {
        AppMethodBeat.i(199101);
        p.h(gVar, Scopes.PROFILE);
        super.configure(gVar);
        if (gVar.aBb()) {
            Log.i("Byp.PluginByp", "[configure]");
            ((com.tencent.mm.plugin.auth.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new c(this));
        }
        AppMethodBeat.o(199101);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J@\u0010\n\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016¨\u0006\u0013"}, hxF = {"com/tencent/mm/plugin/byp/PluginByp$configure$1", "Lcom/tencent/mm/plugin/auth/api/IHandleAuthResponse;", "onAuthResponse", "", "req", "Lcom/tencent/mm/protocal/MMAuth$Req;", "resp", "Lcom/tencent/mm/protocal/MMAuth$Resp;", "autoAuth", "", "onRegResponse", "Lcom/tencent/mm/protocal/MMReg2$Resp;", "alias", "", "bindUin", "", "nick", "mobile", "pluginFlag", "plugin-byp_release"})
    public static final class c implements com.tencent.mm.plugin.auth.a.b {
        final /* synthetic */ PluginByp pPt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(PluginByp pluginByp) {
            this.pPt = pluginByp;
        }

        @Override // com.tencent.mm.plugin.auth.a.b
        public final void a(j.h hVar, j.i iVar, boolean z) {
            AppMethodBeat.i(199099);
            Log.i("Byp.PluginByp", "[onAuthResponse] autoAuth=".concat(String.valueOf(z)));
            c cVar = this.pPt.pPq;
            a.C0898a aVar = a.C0898a.pOV;
            c.a(cVar, a.C0898a.crQ(), c.b.AUTO_AUTH, false, 12);
            AppMethodBeat.o(199099);
        }

        @Override // com.tencent.mm.plugin.auth.a.b
        public final void a(x.b bVar, String str, int i2, String str2, String str3, int i3) {
        }
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(199102);
        Log.i("Byp.PluginByp", "[onAccountInitialized]");
        this.pPr.alive();
        this.pPq.pOY.alive();
        AppMethodBeat.o(199102);
    }

    @Override // com.tencent.mm.plugin.byp.a.c
    public final void removeBypSyncHandler(int i2) {
        AppMethodBeat.i(199103);
        this.pPq.pOX.remove(Integer.valueOf(i2));
        AppMethodBeat.o(199103);
    }

    @Override // com.tencent.mm.plugin.byp.a.c
    public final void addBypSyncHandler(int i2, com.tencent.mm.plugin.byp.a.b bVar) {
        AppMethodBeat.i(199104);
        p.h(bVar, "handler");
        c cVar = this.pPq;
        p.h(bVar, "handler");
        cVar.pOX.putIfAbsent(Integer.valueOf(i2), bVar);
        AppMethodBeat.o(199104);
    }
}
