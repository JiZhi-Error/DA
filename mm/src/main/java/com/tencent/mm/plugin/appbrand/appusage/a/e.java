package com.tencent.mm.plugin.appbrand.appusage.a;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¨\u0006\u0004"}, hxF = {"runOnWorkThread", "", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class e {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ kotlin.g.a.a kXn;

        a(kotlin.g.a.a aVar) {
            this.kXn = aVar;
        }

        public final void run() {
            AppMethodBeat.i(50330);
            this.kXn.invoke();
            AppMethodBeat.o(50330);
        }
    }

    public static final void v(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(50331);
        p.h(aVar, NativeProtocol.WEB_DIALOG_ACTION);
        m.bZn().postToWorker(new a(aVar));
        AppMethodBeat.o(50331);
    }
}
