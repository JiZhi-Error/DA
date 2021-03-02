package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.ab;
import com.tencent.mm.sdk.platformtools.Log;

public class y extends a {
    private MultiContextV8 doQ;

    y(IJSRuntime.Config config) {
        super(config);
    }

    static y f(IJSRuntime.Config config) {
        AppMethodBeat.i(144126);
        y yVar = new y(config);
        AppMethodBeat.o(144126);
        return yVar;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.appbrand.v8.a
    public final MultiContextV8 Xs() {
        AppMethodBeat.i(144127);
        this.doQ = MultiContextV8.createMultiContextV8(this.doZ, this.doX, this.doY);
        this.doY = null;
        MultiContextV8 multiContextV8 = this.doQ;
        AppMethodBeat.o(144127);
        return multiContextV8;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.appbrand.v8.a
    public c Xt() {
        AppMethodBeat.i(144128);
        ab a2 = ab.a(new ab.a() {
            /* class com.tencent.mm.appbrand.v8.y.AnonymousClass1 */

            @Override // com.tencent.mm.appbrand.v8.ab.a
            public final void XP() {
                AppMethodBeat.i(216925);
                y.this.doQ.getV8().pumpMessageLoopDirect();
                AppMethodBeat.o(216925);
            }
        }, this.dpf.dpp);
        AppMethodBeat.o(144128);
        return a2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.appbrand.v8.a
    public final void Xu() {
        AppMethodBeat.i(144129);
        try {
            this.doQ.release();
            AppMethodBeat.o(144129);
        } catch (Exception e2) {
            Log.e("MicroMsg.V8JSRuntime", "commonCleanUp exp = %s", e2);
            AppMethodBeat.o(144129);
        }
    }
}
