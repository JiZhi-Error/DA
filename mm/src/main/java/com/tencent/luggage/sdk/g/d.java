package com.tencent.luggage.sdk.g;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bJ\u0018\u0010\u000b\u001a\u00020\u00072\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bJ\u0018\u0010\f\u001a\u00020\u00072\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bJ\u001c\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bJ\"\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bH\u0002R(\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\b0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController$OnRunningStateChangedListener;", "()V", "mEventInvokeMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "Lkotlin/Function0;", "", "Lcom/tencent/luggage/sdk/wxa_ktx/LifecycleEventInvoke;", "onBackground", "callback", "onDestroy", "onForeground", "onRunningStateChanged", "appId", "", "state", "onSuspend", "registerCallback", "luggage-wxa-app_release"})
public final class d implements c.a {
    private final ArrayMap<b, a<x>> cCK = new ArrayMap<>();

    public d() {
        AppMethodBeat.i(147859);
        AppMethodBeat.o(147859);
    }

    @Override // com.tencent.mm.plugin.appbrand.a.c.a
    public final void a(String str, b bVar) {
        AppMethodBeat.i(147856);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(147856);
        } else if (bVar == null) {
            AppMethodBeat.o(147856);
        } else {
            a<x> aVar = this.cCK.get(bVar);
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(147856);
                return;
            }
            AppMethodBeat.o(147856);
        }
    }

    public final void a(b bVar, a<x> aVar) {
        AppMethodBeat.i(147857);
        this.cCK.put(bVar, aVar);
        AppMethodBeat.o(147857);
    }

    public final void a(a<x> aVar) {
        AppMethodBeat.i(219642);
        p.h(aVar, "callback");
        a(b.kQH, aVar);
        AppMethodBeat.o(219642);
    }

    public final void b(a<x> aVar) {
        AppMethodBeat.i(219643);
        p.h(aVar, "callback");
        a(b.BACKGROUND, aVar);
        AppMethodBeat.o(219643);
    }

    public final void c(a<x> aVar) {
        AppMethodBeat.i(147858);
        p.h(aVar, "callback");
        a(b.DESTROYED, aVar);
        AppMethodBeat.o(147858);
    }
}
