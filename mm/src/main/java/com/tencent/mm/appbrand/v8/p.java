package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8ArrayBuffer;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;

final class p extends o {
    e doV;

    p(e eVar) {
        this.doV = eVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.appbrand.v8.o
    public final void a(final m mVar, V8Object v8Object) {
        AppMethodBeat.i(144076);
        v8Object.registerJavaMethod(new JavaCallback() {
            /* class com.tencent.mm.appbrand.v8.p.AnonymousClass1 */

            @Override // com.eclipsesource.v8.JavaCallback
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(144073);
                Integer valueOf = Integer.valueOf(p.this.doV.generateId());
                Log.d("V8DirectApiBuffer", "generateId:%d", valueOf);
                AppMethodBeat.o(144073);
                return valueOf;
            }
        }, "getNativeBufferId");
        v8Object.registerJavaMethod(new JavaCallback() {
            /* class com.tencent.mm.appbrand.v8.p.AnonymousClass2 */

            @Override // com.eclipsesource.v8.JavaCallback
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(144074);
                if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
                    Log.w("V8DirectApiBuffer", "getNativeBuffer invalid parameters");
                    AppMethodBeat.o(144074);
                    return null;
                }
                Log.d("V8DirectApiBuffer", "getNativeBuffer, id:%d", Integer.valueOf(v8Array.getInteger(0)));
                ByteBuffer buffer = p.this.doV.getBuffer(v8Array.getInteger(0), false);
                if (buffer == null) {
                    Log.w("V8DirectApiBuffer", "getNativeBuffer bb null");
                    AppMethodBeat.o(144074);
                    return null;
                }
                V8ArrayBuffer newV8ArrayBuffer = mVar.XJ().newV8ArrayBuffer(buffer);
                AppMethodBeat.o(144074);
                return newV8ArrayBuffer;
            }
        }, "getNativeBuffer");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            /* class com.tencent.mm.appbrand.v8.p.AnonymousClass3 */

            @Override // com.eclipsesource.v8.JavaVoidCallback
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(144075);
                if (v8Array.length() >= 2 && v8Array.getType(0) == 1 && v8Array.getType(1) == 10) {
                    Log.d("V8DirectApiBuffer", "setNativeBuffer, id:%d", Integer.valueOf(v8Array.getInteger(0)));
                    V8ArrayBuffer v8ArrayBuffer = (V8ArrayBuffer) v8Array.get(1);
                    if (v8ArrayBuffer != null) {
                        p.this.doV.setBuffer(v8Array.getInteger(0), v8ArrayBuffer.getBackingStore());
                        v8ArrayBuffer.release();
                        AppMethodBeat.o(144075);
                        return;
                    }
                    Log.w("V8DirectApiBuffer", "setNativeBuffer buffer null");
                    AppMethodBeat.o(144075);
                    return;
                }
                Log.w("V8DirectApiBuffer", "setNativeBuffer invalid parameters");
                AppMethodBeat.o(144075);
            }
        }, "setNativeBuffer");
        AppMethodBeat.o(144076);
    }

    @Override // com.tencent.mm.appbrand.v8.o
    public final void cleanup() {
    }
}
