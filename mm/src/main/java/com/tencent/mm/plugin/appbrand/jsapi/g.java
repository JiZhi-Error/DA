package com.tencent.mm.plugin.appbrand.jsapi;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.luggage.a.b;
import com.tencent.luggage.a.e;
import com.tencent.luggage.bridge.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.d;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.n;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public abstract class g implements f {
    @TargetApi(21)
    private final ConcurrentLinkedDeque<m> kAA = new ConcurrentLinkedDeque<>();
    private final LinkedHashSet<n> kAE = new LinkedHashSet<>();
    public boolean kAU;
    private q kAz = new j();
    private final Object lxl = new byte[0];
    private i lxm;
    private o lxn = new o(this);
    private Handler lxo;
    protected final Map<String, p> lxp = new ConcurrentHashMap();
    private final AtomicBoolean lxq = new AtomicBoolean(false);
    protected volatile f.b lxr;
    final d lxs = new d();
    private SparseArray<o> lxt = new SparseArray<>(5);
    private boolean lxu = false;

    /* access modifiers changed from: protected */
    public String btc() {
        return "";
    }

    public g() {
        AnonymousClass1 r0 = new a.AbstractC0164a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.g.AnonymousClass1 */

            @Override // com.tencent.luggage.bridge.a.a.c
            public final <T extends b> void a(Class<T> cls, T t) {
                AppMethodBeat.i(140620);
                if (t == null) {
                    Log.w("MicroMsg.AppBrandComponentImpl", "registerCustomize failed, clazz(%s) or customize(%s) is null.", cls, t);
                    AppMethodBeat.o(140620);
                    return;
                }
                g.this.lxs.b(cls, t);
                AppMethodBeat.o(140620);
            }

            @Override // com.tencent.luggage.bridge.a.a.c
            public final <T extends com.tencent.luggage.a.d> void a(Class<T> cls, T t) {
            }
        };
        if (a.csR != null) {
            a.csR.a((a.AbstractC0164a) r0);
        }
        this.kAU = false;
    }

    /* access modifiers changed from: protected */
    public void On() {
    }

    public final void bEb() {
        synchronized (this.lxn) {
            if (this.lxm == null) {
                this.lxm = Oo();
                this.lxm.addJavascriptInterface(this.lxn, "WeixinJSCore");
                if (!TextUtils.isEmpty("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);")) {
                    this.lxm.evaluateJavascript("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);", null);
                }
                On();
            }
        }
    }

    public final void bEc() {
        if (!this.lxq.getAndSet(true)) {
            Map<String, p> Op = Op();
            if (Op == null) {
                Log.e("MicroMsg.AppBrandComponentImpl", "!! get NULL jsApiPool when createJsApiPool() called, make sure your logic !!");
            } else {
                this.lxp.putAll(Op);
            }
        }
    }

    public void init() {
        bEb();
        bEc();
    }

    private void bEd() {
        HandlerThread hC = com.tencent.f.c.d.hC("AppBrandAsyncJSThread", 5);
        hC.start();
        this.lxo = new Handler(hC.getLooper());
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public boolean bsV() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void co(String str, String str2) {
        c(str, str2, 0);
    }

    public void c(String str, String str2, int i2) {
        a(str, str2, i2, getJsRuntime());
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final void a(bc bcVar) {
        a(bcVar, getJsRuntime());
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public void a(final bc bcVar, final o oVar) {
        f.b bVar = this.lxr;
        if (bVar == null) {
            a(bcVar.getName(), bcVar.getData(), bcVar.lzy, oVar);
        } else {
            bVar.a(bcVar, new aj() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.g.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.aj, com.tencent.mm.plugin.appbrand.jsapi.f.a
                public final void proceed() {
                    AppMethodBeat.i(140621);
                    g.this.a(bcVar.getName(), bcVar.getData(), bcVar.lzy, oVar);
                    AppMethodBeat.o(140621);
                }
            });
        }
    }

    public void a(String str, String str2, int i2, o oVar) {
        if (bsV() || isRunning()) {
            if (oVar == null) {
                oVar = getJsRuntime();
            }
            cx.a(oVar, str, str2, i2);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public void a(bc bcVar, int[] iArr) {
        b(bcVar.getName(), bcVar.getData(), iArr);
    }

    public final String y(String str, String str2, int i2) {
        return a(str, str2, i2, false);
    }

    public final String a(String str, String str2, int i2, boolean z) {
        return a(str, str2, i2, z, (o) null);
    }

    public final String a(String str, final String str2, final int i2, boolean z, o oVar) {
        String a2;
        int length;
        final p pVar = this.lxp.get(str);
        if (pVar == null) {
            i(i2, as(str, "fail:not supported"));
            Log.e("MicroMsg.AppBrandComponentImpl", "invokeHandler, api: %s not support", str);
            return "fail:not supported";
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = pVar instanceof d;
        final o jsRuntime = oVar == null ? getJsRuntime() : oVar;
        if (z2) {
            if (oVar != null) {
                this.lxt.put(i2, oVar);
            }
            if (((d) pVar).bEa()) {
                if (z) {
                    Log.e("MicroMsg.AppBrandComponentImpl", "hy: should be called in js thread but called in async thread");
                    return "";
                }
                a(pVar, str2, i2, jsRuntime, (Looper) null);
                a2 = "";
            } else if (!z || !bEe()) {
                bEf().post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.g.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(140622);
                        g.this.a((g) pVar, (p) str2, (String) i2, (int) jsRuntime, (o) g.this.bEf().getLooper());
                        AppMethodBeat.o(140622);
                    }
                });
                a2 = "";
            } else {
                a(pVar, str2, i2, jsRuntime, bEf().getLooper());
                a2 = "";
            }
        } else if (z) {
            Log.e("MicroMsg.AppBrandComponentImpl", "hy: is sync but called in async thread");
            return "";
        } else {
            a2 = a(pVar, str2, i2, jsRuntime, (Looper) null);
        }
        Object[] objArr = new Object[4];
        objArr[0] = btc();
        objArr[1] = str;
        if (str2 == null) {
            length = 0;
        } else {
            length = str2.length();
        }
        objArr[2] = Integer.valueOf(length);
        objArr[3] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        Log.i("MicroMsg.AppBrandComponentImpl", "invokeHandler, tag: %s, api: %s, data size: %d, time: %d", objArr);
        return a2;
    }

    private boolean bEe() {
        if (this.lxu) {
            return true;
        }
        try {
            ThreadLocal threadLocal = (ThreadLocal) org.a.a.bF(Looper.class).get("sThreadLocal");
            if (threadLocal.get() == null) {
                threadLocal.set(getAsyncHandler().getLooper());
            }
            this.lxu = true;
            if (this.lxu) {
                Log.i("MicroMsg.AppBrandComponentImpl", "[+] hookLooper succeed");
            }
            return true;
        } catch (Throwable th) {
            if (this.lxu) {
                Log.i("MicroMsg.AppBrandComponentImpl", "[+] hookLooper succeed");
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String a(final p pVar, final String str, final int i2, final o oVar, final Looper looper) {
        if (bsV() || isRunning()) {
            AnonymousClass4 r0 = new ak() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.g.AnonymousClass4 */

                private String bEg() {
                    String a2;
                    AppMethodBeat.i(140623);
                    try {
                        JSONObject Zc = g.Zc(str);
                        if (Zc == null) {
                            a2 = pVar.h("fail:invalid data", null);
                        } else {
                            a2 = g.this.a(pVar, Zc, i2, oVar);
                        }
                        g gVar = g.this;
                        p pVar = pVar;
                        String str = str;
                        int i2 = i2;
                        f.b bVar = gVar.lxr;
                        if (bVar != null) {
                            bVar.a(pVar, str, i2, a2);
                        }
                        AppMethodBeat.o(140623);
                        return a2;
                    } catch (OutOfMemoryError e2) {
                        Log.e("MicroMsg.AppBrandComponentImpl", "invokeImpl() parseDataStr oom, api[%s], data_length[%d]", pVar.getName(), Integer.valueOf(Util.nullAsNil(str).length()));
                        AppMethodBeat.o(140623);
                        throw e2;
                    }
                }

                private void Zd(String str) {
                    AppMethodBeat.i(140624);
                    this.lyg = str;
                    g.this.i(i2, str);
                    AppMethodBeat.o(140624);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.ak, com.tencent.mm.plugin.appbrand.jsapi.f.a
                public final void proceed() {
                    String h2;
                    AppMethodBeat.i(140625);
                    if (!TextUtils.isEmpty(this.lyg)) {
                        AppMethodBeat.o(140625);
                    } else if (looper == null || looper == Looper.myLooper()) {
                        boolean z = g.this.bsV() || g.this.isRunning();
                        if (!z) {
                            Log.e("MicroMsg.AppBrandComponentImpl", "invoke handler.proceed() log[%s] api[%s], callbackId[%d], component not running", g.this.btc(), pVar, Integer.valueOf(i2));
                        }
                        if (z) {
                            h2 = bEg();
                        } else {
                            h2 = pVar.h("fail:interrupted", null);
                        }
                        if (!TextUtils.isEmpty(h2)) {
                            Zd(h2);
                        }
                        AppMethodBeat.o(140625);
                    } else {
                        new Handler(looper).post(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.g.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(221219);
                                this.proceed();
                                AppMethodBeat.o(221219);
                            }
                        });
                        AppMethodBeat.o(140625);
                    }
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.ak, com.tencent.mm.plugin.appbrand.jsapi.f.a
                public final void Zb(String str) {
                    AppMethodBeat.i(140626);
                    if (!TextUtils.isEmpty(this.lyg)) {
                        AppMethodBeat.o(140626);
                        return;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        Zd(str);
                    }
                    AppMethodBeat.o(140626);
                }
            };
            f.b bVar = this.lxr;
            if (!(bVar != null && bVar.a(pVar, str, i2, r0))) {
                r0.proceed();
            }
            if (!TextUtils.isEmpty(r0.lyg)) {
                return r0.lyg;
            }
            return "";
        }
        Log.e("MicroMsg.AppBrandComponentImpl", "invoke log[%s] api[%s], callbackId[%d], component not running", btc(), pVar.getName(), Integer.valueOf(i2));
        return as(pVar.getName(), "fail:interrupted");
    }

    /* access modifiers changed from: package-private */
    public final String a(p pVar, JSONObject jSONObject, int i2, o oVar) {
        String str;
        String str2 = "";
        try {
            if (!(pVar instanceof ab)) {
                if (pVar instanceof d) {
                    if (x.a(getJsRuntime(), pVar, jSONObject, (x.a) av(x.a.class)) == x.b.FAIL_SIZE_EXCEED_LIMIT) {
                        str = pVar.h("fail:convert native buffer parameter fail. native buffer exceed size limit.", null);
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        if (pVar.bEi()) {
                            ((d) pVar).a(this, jSONObject, i2, oVar);
                            return str;
                        }
                        ((d) pVar).a(this, jSONObject, i2);
                    }
                    str2 = str;
                }
                return str2;
            } else if (pVar.bEi()) {
                return ((ab) pVar).a(this, jSONObject, oVar);
            } else {
                return ((ab) pVar).a(this, jSONObject);
            }
        } catch (ClassCastException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandComponentImpl", e2, e2.getMessage(), new Object[0]);
            return pVar.h("fail:internal error invalid js component", null);
        } catch (Throwable th) {
            Log.e("MicroMsg.AppBrandComponentImpl", "invokeTheJsApi with name[%s], get exception %s", pVar, th);
            throw th;
        }
    }

    static JSONObject Zc(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrandComponentImpl", e2.getMessage());
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public void i(int i2, String str) {
        a(i2, str, (o) null);
    }

    public final void a(int i2, String str, o oVar) {
        n nVar = null;
        if (bsV() || isRunning()) {
            if (Util.isNullOrNil(str)) {
                str = "{}";
            }
            Log.d("MicroMsg.AppBrandComponentImpl", "callbackId: %d, data size: %d", Integer.valueOf(i2), Integer.valueOf(str.length()));
            o oVar2 = this.lxt.get(i2);
            synchronized (this.lxl) {
                if (oVar != null) {
                    if (oVar == this.lxm) {
                        nVar = (n) this.lxm.R(n.class);
                    }
                } else if (oVar2 == null) {
                    oVar = this.lxm;
                    if (oVar != null) {
                        nVar = (n) this.lxm.R(n.class);
                    }
                } else {
                    this.lxt.remove(i2);
                    oVar = oVar2;
                }
            }
            if (oVar == null) {
                Log.e("MicroMsg.AppBrandComponentImpl", "callback but get NULL JsRuntime, callbackId:%d", Integer.valueOf(i2));
                return;
            }
            if (nVar != null) {
                nVar.invokeCallbackHandler(i2, str);
            } else {
                a(oVar, i2, str);
            }
            V(i2, str);
            return;
        }
        Log.e("MicroMsg.AppBrandComponentImpl", "callback but destroyed, callbackId %d", Integer.valueOf(i2));
    }

    private static void a(o oVar, int i2, String str) {
        oVar.evaluateJavascript(String.format(Locale.US, "typeof %s !== 'undefined' && %s.invokeCallbackHandler(%d, %s)", "WeixinJSCoreAndroid", "WeixinJSCoreAndroid", Integer.valueOf(i2), str), null);
    }

    private void V(int i2, String str) {
        f.b bVar = this.lxr;
        if (bVar != null) {
            bVar.V(i2, str);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public int getComponentId() {
        return hashCode();
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final i getJsRuntime() {
        i iVar;
        synchronized (this.lxl) {
            iVar = this.lxm;
        }
        return iVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final Handler getAsyncHandler() {
        return bEf();
    }

    /* access modifiers changed from: package-private */
    public final Handler bEf() {
        if (this.lxo == null) {
            bEd();
        }
        return this.lxo;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public q getFileSystem() {
        Log.e("MicroMsg.AppBrandComponentImpl", "getFileSystem return dummy impl");
        return this.kAz;
    }

    public final String[] getAsyncableJsApis() {
        ArrayList arrayList = new ArrayList(500);
        for (Map.Entry<String, p> entry : this.lxp.entrySet()) {
            if ((entry.getValue() instanceof d) && !((d) entry.getValue()).bEa()) {
                arrayList.add(entry.getKey());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void cleanup() {
        i iVar;
        if (this.lxo != null) {
            this.lxo.removeCallbacksAndMessages(null);
            this.lxo.getLooper().quit();
        }
        this.lxn.lxN = null;
        this.lxp.clear();
        this.lxn = null;
        this.lxr = null;
        synchronized (this.lxl) {
            iVar = this.lxm;
            this.lxm = null;
        }
        if (iVar != null) {
            iVar.destroy();
        }
    }

    public static String as(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", str + ":" + str2);
        return new JSONObject(hashMap).toString();
    }

    public final void f(Collection<m> collection) {
        this.kAA.addAll(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Object, com.tencent.mm.plugin.appbrand.jsapi.m] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public <T extends m> T av(Class<T> cls) {
        T t;
        T t2 = null;
        Iterator<m> descendingIterator = this.kAA.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                break;
            }
            m next = descendingIterator.next();
            if (cls.isInstance(next)) {
                t2 = next;
                break;
            }
        }
        if (t2 != null) {
            return t2;
        }
        try {
            t = (T) ((m) org.a.a.bF(cls).hPX().object);
            if (t == null) {
                return t;
            }
            try {
                this.kAA.add(t);
                return t;
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
            t = t2;
            Log.e("MicroMsg.AppBrandComponentImpl", "Make sure %s has default constructor", cls.getName());
            return t;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public <T extends n> T aw(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        synchronized (this.kAE) {
            Iterator<n> it = this.kAE.iterator();
            while (it.hasNext()) {
                T t = (T) it.next();
                if (cls.isInstance(t)) {
                    return t;
                }
            }
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public boolean a(n nVar) {
        if (nVar == null) {
            return false;
        }
        synchronized (this.kAE) {
            this.kAE.add(nVar);
        }
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public m getDialogContainer() {
        Log.e("MicroMsg.AppBrandComponentImpl", "getDialogContainer return dummy impl");
        return m.JjX;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public <T extends b> T M(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        T t = (T) ((b) this.lxs.ap(cls));
        if (t == null && (t = (T) e.M(cls)) != null && !cls.isAssignableFrom(t.getClass())) {
            t = null;
        }
        return t;
    }

    public final <T extends b> void a(Class<T> cls, T t) {
        this.lxs.b(cls, t);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public void P(Runnable runnable) {
        if (runnable != null) {
            MMHandlerThread.postToMainThread(runnable);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public void i(Runnable runnable, long j2) {
        if (runnable != null) {
            if (j2 < 0) {
                j2 = 0;
            }
            MMHandlerThread.postToMainThreadDelayed(runnable, j2);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public void b(String str, String str2, int[] iArr) {
        c(str, str2, 0);
    }
}
