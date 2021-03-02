package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class f {
    private s csr;
    private LinkedList<e> css = new LinkedList<>();
    private boolean cst = false;

    f(s sVar) {
        AppMethodBeat.i(140319);
        this.csr = sVar;
        AppMethodBeat.o(140319);
    }

    public final synchronized void a(e eVar) {
        AppMethodBeat.i(140320);
        if (this.cst) {
            b(eVar);
            AppMethodBeat.o(140320);
        } else {
            this.css.add(eVar);
            AppMethodBeat.o(140320);
        }
    }

    private void b(e eVar) {
        AppMethodBeat.i(140321);
        this.csr.evaluateJavascript(String.format("if(typeof luggageBridge !== 'undefined') luggageBridge._processMessageFromJava(%s);", eVar.toString()), null);
        AppMethodBeat.o(140321);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void KY() {
        AppMethodBeat.i(140322);
        Log.i("Java2JsMessageQueue", "ready");
        this.cst = true;
        Iterator<e> it = this.css.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        this.css.clear();
        AppMethodBeat.o(140322);
    }
}
