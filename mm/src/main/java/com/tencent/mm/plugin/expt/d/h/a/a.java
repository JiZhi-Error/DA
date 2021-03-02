package com.tencent.mm.plugin.expt.d.h.a;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.b.g;

public final class a implements b {
    private V8 syy;

    public a() {
        AppMethodBeat.i(220358);
        try {
            this.syy = V8.createV8Runtime();
            com.tencent.mm.plugin.expt.d.f.a.lV(true);
            AppMethodBeat.o(220358);
        } catch (Throwable th) {
            com.tencent.mm.plugin.expt.d.f.a.lV(false);
            Log.e("EdgeComputingJSScriptEngine", "[EdgeComputingJSScriptEngine] init V8 fail for : %s", th.getMessage());
            AppMethodBeat.o(220358);
        }
    }

    @Override // com.tencent.mm.plugin.expt.d.h.a.b
    public final boolean a(com.tencent.mm.plugin.expt.d.h.b.a aVar) {
        AppMethodBeat.i(220359);
        if (this.syy == null || this.syy.isReleased() || aVar == null) {
            AppMethodBeat.o(220359);
            return false;
        }
        try {
            this.syy.registerJavaMethod(aVar, aVar.cNb());
            AppMethodBeat.o(220359);
            return true;
        } catch (Throwable th) {
            Log.e("EdgeComputingJSScriptEngine", "[EdgeComputingJSScriptEngine] registerJsApi fail, jsApi : %s, msg : %s", aVar.cNb(), th.getMessage());
            AppMethodBeat.o(220359);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.expt.d.h.a.b
    public final boolean aor(String str) {
        AppMethodBeat.i(220360);
        if (g.eP(str) || this.syy == null || this.syy.isReleased()) {
            AppMethodBeat.o(220360);
            return false;
        }
        try {
            this.syy.executeVoidScript(str);
            AppMethodBeat.o(220360);
            return true;
        } catch (Throwable th) {
            Log.e("EdgeComputingJSScriptEngine", "[EdgeComputingJSScriptEngine] loadScript throw Throwable e : %s", th.getMessage());
            AppMethodBeat.o(220360);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.expt.d.h.a.b
    public final List<String> ab(String str, String str2, String str3) {
        V8Array v8Array;
        V8Array v8Array2;
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(220361);
        if (g.eP(str) || g.eP(str2) || this.syy == null || this.syy.isReleased() || g.eP(str3)) {
            AppMethodBeat.o(220361);
            return null;
        }
        try {
            v8Array = new V8Array(this.syy).push(str2).push(str3);
            try {
                v8Array2 = this.syy.executeArrayFunction(str, v8Array);
            } catch (Throwable th3) {
                th = th3;
                v8Array2 = null;
                if (v8Array != null && !v8Array.isReleased()) {
                    v8Array.release();
                }
                if (v8Array2 != null && !v8Array2.isReleased()) {
                    v8Array2.release();
                }
                AppMethodBeat.o(220361);
                throw th;
            }
            try {
                ArrayList arrayList = new ArrayList();
                if (v8Array2 != null && v8Array2.length() > 0) {
                    for (int i2 = 0; i2 < v8Array2.length(); i2++) {
                        String string = v8Array2.getString(i2);
                        if (!g.eP(string)) {
                            arrayList.add(string);
                        }
                    }
                }
                v8Array.release();
                v8Array2.release();
                if (v8Array != null && !v8Array.isReleased()) {
                    v8Array.release();
                }
                if (v8Array2 != null && !v8Array2.isReleased()) {
                    v8Array2.release();
                }
                AppMethodBeat.o(220361);
                return arrayList;
            } catch (Throwable th4) {
                th2 = th4;
                Log.e("EdgeComputingJSScriptEngine", "[EdgeComputingJSScriptEngine] executeArrayFunction funcName : %s, throw Throwable e : %s", str, th2.getMessage());
                if (v8Array != null && !v8Array.isReleased()) {
                    v8Array.release();
                }
                if (v8Array2 != null && !v8Array2.isReleased()) {
                    v8Array2.release();
                }
                AppMethodBeat.o(220361);
                return null;
            }
        } catch (Throwable th5) {
            th = th5;
            v8Array2 = null;
            v8Array = null;
            v8Array.release();
            v8Array2.release();
            AppMethodBeat.o(220361);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.expt.d.h.a.b
    public final void release() {
        AppMethodBeat.i(220362);
        if (this.syy != null && !this.syy.isReleased()) {
            try {
                this.syy.release(true);
            } catch (Throwable th) {
                Log.e("EdgeComputingJSScriptEngine", "[EdgeComputingJSScriptEngine] release throw Throwable : " + th.getMessage());
            }
        }
        this.syy = null;
        AppMethodBeat.o(220362);
    }
}
