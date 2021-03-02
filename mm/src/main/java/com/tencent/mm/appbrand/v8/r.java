package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.SharedV8ArrayBuffer;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class r extends o {
    final d dpR;

    public r(d dVar) {
        super("WeixinArrayBuffer");
        this.dpR = dVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.appbrand.v8.o
    public final void a(m mVar, V8Object v8Object) {
        AppMethodBeat.i(144085);
        v8Object.registerJavaMethod(new JavaCallback() {
            /* class com.tencent.mm.appbrand.v8.r.AnonymousClass1 */

            @Override // com.eclipsesource.v8.JavaCallback
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(144084);
                if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
                    Log.w("MicroMsg.V8DirectApiSharedBuffer", "get invalid parameters");
                    AppMethodBeat.o(144084);
                    return null;
                }
                int integer = v8Array.getInteger(0);
                Log.i("MicroMsg.V8DirectApiSharedBuffer", "get, id:%d", Integer.valueOf(integer));
                SharedV8ArrayBuffer iR = r.this.dpR.iR(integer);
                AppMethodBeat.o(144084);
                return iR;
            }
        }, "get");
        AppMethodBeat.o(144085);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.appbrand.v8.o
    public final void cleanup() {
    }
}
