package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.launching.c.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/debugger/MockScanCodeUrl;", "Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShell$DebuggerAction;", "()V", "handler", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "getHandler", "()Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "handler$delegate", "Lkotlin/Lazy;", "name", "", "onAction", "", "intent", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
public final class h implements DebuggerShell.a {
    private final f lhN = g.ah(a.lhO);

    public h() {
        AppMethodBeat.i(50350);
        AppMethodBeat.o(50350);
    }

    @Override // com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a
    public final String name() {
        return "MockScanCodeUrl";
    }

    @Override // com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a
    public final void A(Intent intent) {
        String stringExtra;
        AppMethodBeat.i(50349);
        if (intent == null || (stringExtra = intent.getStringExtra("url")) == null) {
            AppMethodBeat.o(50349);
            return;
        }
        ((e) this.lhN.getValue()).a(MMApplicationContext.getContext(), stringExtra, 1011, new Bundle(), (Bundle) null);
        AppMethodBeat.o(50349);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/launching/links/DebugCmdLinkOpener;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<e> {
        public static final a lhO = new a();

        static {
            AppMethodBeat.i(50347);
            AppMethodBeat.o(50347);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ e invoke() {
            AppMethodBeat.i(50346);
            e eVar = new e();
            AppMethodBeat.o(50346);
            return eVar;
        }
    }
}
