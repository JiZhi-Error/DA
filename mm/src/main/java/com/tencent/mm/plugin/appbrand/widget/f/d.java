package com.tencent.mm.plugin.appbrand.widget.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AutoDismissRunner;", "Ljava/lang/Runnable;", "toast", "Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "(Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;)V", "ref", "Ljava/lang/ref/WeakReference;", "run", "", "plugin-appbrand-integration_release"})
public final class d implements Runnable {
    private final WeakReference<c> nsR;

    public d(c cVar) {
        p.h(cVar, "toast");
        AppMethodBeat.i(51452);
        this.nsR = new WeakReference<>(cVar);
        AppMethodBeat.o(51452);
    }

    public final void run() {
        AppMethodBeat.i(51451);
        c cVar = this.nsR.get();
        if (cVar != null) {
            cVar.dismiss();
            AppMethodBeat.o(51451);
            return;
        }
        AppMethodBeat.o(51451);
    }
}
