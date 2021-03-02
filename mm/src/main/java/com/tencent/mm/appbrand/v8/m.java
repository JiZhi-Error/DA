package com.tencent.mm.appbrand.v8;

import android.text.TextUtils;
import com.eclipsesource.v8.ExecuteDetails;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public final class m {
    public final e doV;
    public final IJSRuntime dpQ;
    public final d dpR;
    final LinkedList<o> dpS = new LinkedList<>();
    private final FutureTask<V8Context> dpT;
    V8Object dpU = null;
    private final HashMap<String, V8Object> dpV = new HashMap<>();

    public interface a {
        V8Context Xy();
    }

    public interface b {
        void a(String str, c cVar);
    }

    m(IJSRuntime iJSRuntime, e eVar, final a aVar) {
        AppMethodBeat.i(144056);
        this.dpQ = iJSRuntime;
        this.dpT = new FutureTask<>(new Callable<V8Context>() {
            /* class com.tencent.mm.appbrand.v8.m.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ V8Context call() {
                AppMethodBeat.i(144042);
                V8Context Xy = aVar.Xy();
                AppMethodBeat.o(144042);
                return Xy;
            }
        });
        iJSRuntime.r(this.dpT);
        this.doV = eVar == null ? new u() : eVar;
        this.dpR = new j(this);
        this.dpQ.s(new Runnable() {
            /* class com.tencent.mm.appbrand.v8.m.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(144048);
                if (m.this.XJ() != null) {
                    try {
                        V8Object globalObject = m.this.XJ().getGlobalObject();
                        m.this.dpU = globalObject.getObject("console");
                    } catch (Throwable th) {
                        Log.e("MicroMsg.J2V8.V8ContextEngine", "get OriginConsole ex: %s", th.getMessage());
                    }
                }
                m.this.dpS.add(new q().a(m.this));
                m.this.dpS.add(new t().a(m.this));
                m.this.dpS.add(new s().a(m.this));
                Log.d("MicroMsg.J2V8.V8ContextEngine", "hy: config is %s", m.this.dpQ.Xr());
                if (m.this.doV.supportBufferStoreBindTo()) {
                    Log.i("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use NativeBufferJNI");
                    m.this.doV.bufferStoreBindTo(m.this.dpQ.getIsolatePtr(), m.this.XK());
                } else {
                    Log.i("MicroMsg.J2V8.V8ContextEngine", "[v8] [dl: ] [nativebuffer] use V8DirectApi");
                    m.this.dpS.add(new p(m.this.doV).a(m.this));
                }
                m.this.dpS.add(new r(m.this.dpR).a(m.this));
                AppMethodBeat.o(144048);
            }
        });
        AppMethodBeat.o(144056);
    }

    public final V8Context XJ() {
        V8Context v8Context;
        AppMethodBeat.i(144058);
        try {
            v8Context = this.dpT.get(10, TimeUnit.SECONDS);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.J2V8.V8ContextEngine", e2, "getV8Context failed", new Object[0]);
            v8Context = null;
        }
        AppMethodBeat.o(144058);
        return v8Context;
    }

    public final V8Object getGlobalObject() {
        AppMethodBeat.i(216890);
        V8Object globalObject = XJ().getGlobalObject();
        AppMethodBeat.o(216890);
        return globalObject;
    }

    public final V8Array newV8Array() {
        AppMethodBeat.i(216891);
        V8Array newV8Array = XJ().newV8Array();
        AppMethodBeat.o(216891);
        return newV8Array;
    }

    public final long XK() {
        AppMethodBeat.i(144059);
        long ptr = XJ().getPtr();
        AppMethodBeat.o(144059);
        return ptr;
    }

    public final void a(final String str, final b bVar) {
        AppMethodBeat.i(144061);
        this.dpQ.r(new Runnable() {
            /* class com.tencent.mm.appbrand.v8.m.AnonymousClass10 */

            public final void run() {
                String str = null;
                AppMethodBeat.i(144050);
                if (bVar != null) {
                    c cVar = new c();
                    c.b(cVar);
                    Object executeScript = m.this.XJ().executeScript(str, cVar);
                    c.c(cVar);
                    b bVar = bVar;
                    if (executeScript != null) {
                        str = executeScript.toString();
                    }
                    bVar.a(str, cVar);
                    AppMethodBeat.o(144050);
                    return;
                }
                m.this.XJ().executeVoidScript(str, null);
                AppMethodBeat.o(144050);
            }
        });
        AppMethodBeat.o(144061);
    }

    public final void a(final String str, final String str2, final b bVar) {
        AppMethodBeat.i(144062);
        this.dpQ.r(new Runnable() {
            /* class com.tencent.mm.appbrand.v8.m.AnonymousClass11 */

            public final void run() {
                String str = null;
                AppMethodBeat.i(144051);
                Log.d("MicroMsg.J2V8.V8ContextEngine", "eval with script(%s)", str);
                if (bVar != null) {
                    c cVar = new c();
                    c.b(cVar);
                    Object executeScript = m.this.XJ().executeScript(str2, str, 0, cVar);
                    c.c(cVar);
                    b bVar = bVar;
                    if (executeScript != null) {
                        str = executeScript.toString();
                    }
                    bVar.a(str, cVar);
                    AppMethodBeat.o(144051);
                    return;
                }
                m.this.XJ().executeVoidScript(str2, str, 0, null);
                AppMethodBeat.o(144051);
            }
        });
        AppMethodBeat.o(144062);
    }

    public final void a(final String str, final String str2, final b bVar, final String str3, final String str4, final int i2) {
        AppMethodBeat.i(144063);
        this.dpQ.r(new Runnable() {
            /* class com.tencent.mm.appbrand.v8.m.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(144052);
                Log.d("MicroMsg.J2V8.V8ContextEngine", "eval script(%s) with code cache", str);
                if (bVar != null) {
                    c cVar = new c();
                    cVar.dqm = i2;
                    c.b(cVar);
                    Object executeScript = m.this.XJ().executeScript(str2, str, 0, str3, str4, i2, cVar);
                    c.c(cVar);
                    bVar.a(executeScript == null ? null : executeScript.toString(), cVar);
                    AppMethodBeat.o(144052);
                    return;
                }
                m.this.XJ().executeVoidScript(str2, str, 0, str3, str4, i2, null);
                AppMethodBeat.o(144052);
            }
        });
        AppMethodBeat.o(144063);
    }

    public final void a(final Object obj, final String str, final Class<? extends Annotation> cls) {
        AppMethodBeat.i(144065);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(144065);
            return;
        }
        this.dpQ.r(new Runnable() {
            /* class com.tencent.mm.appbrand.v8.m.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(144044);
                m mVar = m.this;
                Object obj = obj;
                String str = str;
                Class<? extends Annotation> cls = cls;
                ArrayList<Method> arrayList = new ArrayList();
                for (Class<?> cls2 = obj.getClass(); cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                    for (Method method : new ArrayList(Arrays.asList(cls2.getDeclaredMethods()))) {
                        if (cls == null || method.isAnnotationPresent(cls)) {
                            arrayList.add(method);
                        }
                    }
                }
                V8Object newV8Object = mVar.XJ().newV8Object();
                for (Method method2 : arrayList) {
                    newV8Object.registerJavaMethod(obj, method2.getName(), method2.getName(), method2.getParameterTypes());
                }
                mVar.XJ().add(str, newV8Object);
                newV8Object.release();
                AppMethodBeat.o(144044);
            }
        });
        AppMethodBeat.o(144065);
    }

    public final void a(int i2, h hVar) {
        AppMethodBeat.i(144066);
        this.dpQ.a(i2, hVar);
        AppMethodBeat.o(144066);
    }

    public final void destroy() {
        AppMethodBeat.i(144067);
        this.dpQ.t(new Runnable() {
            /* class com.tencent.mm.appbrand.v8.m.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(144045);
                Log.i("MicroMsg.J2V8.V8ContextEngine", "destroy");
                Iterator<o> it = m.this.dpS.iterator();
                while (it.hasNext()) {
                    it.next().cleanup();
                }
                m.this.dpS.clear();
                V8Context XJ = m.this.XJ();
                if (XJ != null) {
                    try {
                        XJ.release();
                        AppMethodBeat.o(144045);
                        return;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.J2V8.V8ContextEngine", "destroy :%s", e2);
                    }
                }
                AppMethodBeat.o(144045);
            }
        });
        AppMethodBeat.o(144067);
    }

    public static class c extends ExecuteDetails {
        public long dqk;
        public long dql;
        public int dqm;

        static /* synthetic */ void b(c cVar) {
            AppMethodBeat.i(144054);
            cVar.dqk = System.currentTimeMillis();
            AppMethodBeat.o(144054);
        }

        static /* synthetic */ void c(c cVar) {
            AppMethodBeat.i(144055);
            cVar.dql = System.currentTimeMillis();
            AppMethodBeat.o(144055);
        }
    }
}
