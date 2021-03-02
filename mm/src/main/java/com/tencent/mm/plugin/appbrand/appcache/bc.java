package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.ab;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
public final class bc implements InvocationHandler {
    private final Map<String, Method> kNf = new ConcurrentHashMap();
    private final b kNg;

    public static IWxaFileSystemWithModularizing K(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(134684);
        try {
            bc bcVar = new bc(bg.M(appBrandRuntime));
            IWxaFileSystemWithModularizing iWxaFileSystemWithModularizing = (IWxaFileSystemWithModularizing) Proxy.newProxyInstance(IWxaFileSystemWithModularizing.class.getClassLoader(), new Class[]{IWxaFileSystemWithModularizing.class}, bcVar);
            AppMethodBeat.o(134684);
            return iWxaFileSystemWithModularizing;
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "createInstance e=%s", e2);
            a aVar = new a((byte) 0);
            AppMethodBeat.o(134684);
            return aVar;
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Method a2;
        AppMethodBeat.i(134685);
        if (method.getReturnType().equals(Boolean.TYPE)) {
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(134685);
            return bool;
        } else if (Modifier.isStatic(method.getModifiers())) {
            AppMethodBeat.o(134685);
            return null;
        } else if (method.getReturnType().equals(WxaPkg.Info.class)) {
            try {
                q.a UV = this.kNg.kNh.UV((String) objArr[0]);
                if (UV != null) {
                    WxaPkg.Info bvB = UV.bvB();
                    AppMethodBeat.o(134685);
                    return bvB;
                }
                AppMethodBeat.o(134685);
                return null;
            } catch (Throwable th) {
                Log.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), call openReadPartialInfo get exception(%s)", method.toGenericString(), Arrays.toString(objArr), th);
                AppMethodBeat.o(134685);
                return null;
            }
        } else {
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof String)) {
                ab Vm = this.kNg.Vm((String) objArr[0]);
                if (Vm == null) {
                    Log.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), get NULL targetFS", method.toGenericString(), Arrays.toString(objArr));
                    Object a3 = a(method, m.RET_NOT_EXISTS);
                    AppMethodBeat.o(134685);
                    return a3;
                } else if (method.getReturnType().equals(WxaPkg.class)) {
                    WxaPkg wxaPkg = Vm.kMl;
                    AppMethodBeat.o(134685);
                    return wxaPkg;
                } else {
                    Method a4 = a(method);
                    if (a4 != null) {
                        Object invoke = a4.invoke(Vm, objArr);
                        AppMethodBeat.o(134685);
                        return invoke;
                    }
                }
            } else if (method.getReturnType().equals(Void.TYPE)) {
                Collection<ab> bwu = this.kNg.bwu();
                if (!(bwu == null || (a2 = a(method)) == null)) {
                    for (ab abVar : bwu) {
                        a2.invoke(abVar, objArr);
                    }
                }
                AppMethodBeat.o(134685);
                return null;
            }
            Log.e("MicroMsg.AppBrand.WxaPkgFileSystemWithModuleInvokeAdapter", "invoke with method(%s) args(%s), fallback return access denied", method.toGenericString(), Arrays.toString(objArr));
            Object a5 = a(method, m.ERR_PERMISSION_DENIED);
            AppMethodBeat.o(134685);
            return a5;
        }
    }

    private static Object a(Method method, m mVar) {
        AppMethodBeat.i(178542);
        if (method.getReturnType().equals(m.class)) {
            AppMethodBeat.o(178542);
            return mVar;
        }
        AppMethodBeat.o(178542);
        return null;
    }

    private Method a(Method method) {
        AppMethodBeat.i(134687);
        String genericString = method.toGenericString();
        Method method2 = this.kNf.get(genericString);
        if (method2 == null && (method2 = ab.class.getMethod(method.getName(), method.getParameterTypes())) != null) {
            this.kNf.put(genericString, method2);
        }
        AppMethodBeat.o(134687);
        return method2;
    }

    private bc(q qVar) {
        AppMethodBeat.i(178543);
        this.kNg = new b(qVar, (byte) 0);
        AppMethodBeat.o(178543);
    }

    static final class b implements Closeable {
        private final q kNh;
        private final Map<WxaPkg, ab> kNi;

        /* synthetic */ b(q qVar, byte b2) {
            this(qVar);
        }

        private b(q qVar) {
            AppMethodBeat.i(178541);
            this.kNi = new HashMap();
            this.kNh = qVar;
            AppMethodBeat.o(178541);
        }

        /* access modifiers changed from: package-private */
        public final Collection<ab> bwu() {
            Collection<ab> values;
            AppMethodBeat.i(134681);
            synchronized (this.kNi) {
                try {
                    values = this.kNi.values();
                } finally {
                    AppMethodBeat.o(134681);
                }
            }
            return values;
        }

        /* access modifiers changed from: package-private */
        public final ab Vm(String str) {
            ab abVar = null;
            AppMethodBeat.i(134682);
            if (this.kNh == null) {
                AppMethodBeat.o(134682);
            } else {
                WxaPkg UT = this.kNh.UT(str);
                if (UT == null) {
                    AppMethodBeat.o(134682);
                } else {
                    synchronized (this.kNi) {
                        try {
                            abVar = this.kNi.get(UT);
                            if (abVar == null) {
                                Map<WxaPkg, ab> map = this.kNi;
                                abVar = new ab(UT);
                                map.put(UT, abVar);
                            }
                        } finally {
                            AppMethodBeat.o(134682);
                        }
                    }
                }
            }
            return abVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            AppMethodBeat.i(134683);
            synchronized (this.kNi) {
                try {
                    this.kNi.clear();
                } finally {
                    AppMethodBeat.o(134683);
                }
            }
            if (this.kNh != null) {
                this.kNh.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a extends j implements IWxaFileSystemWithModularizing {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
        public final WxaPkg.Info openReadPartialInfo(String str) {
            return null;
        }
    }
}
