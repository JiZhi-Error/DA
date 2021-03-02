package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;

final class q extends o {
    z dqt;
    private final JavaVoidCallback dqu = new JavaVoidCallback() {
        /* class com.tencent.mm.appbrand.v8.q.AnonymousClass1 */

        @Override // com.eclipsesource.v8.JavaVoidCallback
        public final void invoke(V8Object v8Object, V8Array v8Array) {
        }
    };

    public q() {
        super("console");
        AppMethodBeat.i(144082);
        AppMethodBeat.o(144082);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.appbrand.v8.o
    public final void a(m mVar, V8Object v8Object) {
        AppMethodBeat.i(144083);
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            /* class com.tencent.mm.appbrand.v8.q.AnonymousClass2 */

            @Override // com.eclipsesource.v8.JavaVoidCallback
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(144077);
                Log.v("MicroMsg.J2V8_Console", v8Array.toString());
                AppMethodBeat.o(144077);
            }
        }, "log");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            /* class com.tencent.mm.appbrand.v8.q.AnonymousClass3 */

            @Override // com.eclipsesource.v8.JavaVoidCallback
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(144078);
                Log.i("MicroMsg.J2V8_Console", v8Array.toString());
                AppMethodBeat.o(144078);
            }
        }, "info");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            /* class com.tencent.mm.appbrand.v8.q.AnonymousClass4 */

            @Override // com.eclipsesource.v8.JavaVoidCallback
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(144079);
                Log.w("MicroMsg.J2V8_Console", v8Array.toString());
                AppMethodBeat.o(144079);
            }
        }, "warn");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            /* class com.tencent.mm.appbrand.v8.q.AnonymousClass5 */

            @Override // com.eclipsesource.v8.JavaVoidCallback
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(144080);
                String v8Array2 = v8Array.toString();
                Log.e("MicroMsg.J2V8_Console", v8Array2);
                if (q.this.dqt != null) {
                    q.this.dqt.onError(v8Array2);
                }
                AppMethodBeat.o(144080);
            }
        }, "error");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            /* class com.tencent.mm.appbrand.v8.q.AnonymousClass6 */

            @Override // com.eclipsesource.v8.JavaVoidCallback
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(144081);
                Log.d("MicroMsg.J2V8_Console", v8Array.toString());
                AppMethodBeat.o(144081);
            }
        }, "debug");
        v8Object.registerJavaMethod(this.dqu, "assert");
        v8Object.registerJavaMethod(this.dqu, "count");
        v8Object.registerJavaMethod(this.dqu, Scopes.PROFILE);
        v8Object.registerJavaMethod(this.dqu, "profileEnd");
        v8Object.registerJavaMethod(this.dqu, "time");
        v8Object.registerJavaMethod(this.dqu, "timeEnd");
        v8Object.registerJavaMethod(this.dqu, "timeStamp");
        v8Object.registerJavaMethod(this.dqu, "takeHeapSnapshot");
        v8Object.registerJavaMethod(this.dqu, "group");
        v8Object.registerJavaMethod(this.dqu, "groupCollapsed");
        v8Object.registerJavaMethod(this.dqu, "groupEnd");
        v8Object.registerJavaMethod(this.dqu, "clear");
        v8Object.registerJavaMethod(this.dqu, SharePatchInfo.OAT_DIR);
        v8Object.registerJavaMethod(this.dqu, "dirxml");
        v8Object.registerJavaMethod(this.dqu, SharePluginInfo.ISSUE_KEY_TABLE);
        v8Object.registerJavaMethod(this.dqu, "trace");
        AppMethodBeat.o(144083);
    }

    @Override // com.tencent.mm.appbrand.v8.o
    public final void cleanup() {
        this.dqt = null;
    }
}
