package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class f {
    private static volatile boolean hre = false;

    /* access modifiers changed from: package-private */
    public interface b {
    }

    static /* synthetic */ Object b(Class cls, int i2) {
        AppMethodBeat.i(158303);
        Object a2 = a(cls, i2);
        AppMethodBeat.o(158303);
        return a2;
    }

    public static boolean bx(Object obj) {
        if (obj instanceof b) {
            return true;
        }
        return false;
    }

    public static <T> T ak(Class<T> cls) {
        AppMethodBeat.i(158301);
        if (!hre) {
            AppMethodBeat.o(158301);
            return null;
        }
        T t = (T) a(cls, 0);
        AppMethodBeat.o(158301);
        return t;
    }

    private static <T> T a(Class<T> cls, int i2) {
        AppMethodBeat.i(158302);
        if (!hre) {
            AppMethodBeat.o(158302);
            return null;
        } else if (i2 > 3) {
            j.e("MMSkeleton.DummyMode", "dummy level > 3, return null.", new Object[0]);
            AppMethodBeat.o(158302);
            return null;
        } else if (!cls.isInterface()) {
            AppMethodBeat.o(158302);
            return null;
        } else {
            try {
                a aVar = new a((byte) 0);
                aVar.level = i2;
                T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls, b.class}, aVar);
                j.i("MMSkeleton.DummyMode", "dummy instance(%s) for class(%s), dummy level %s", t, cls, Integer.valueOf(i2));
                AppMethodBeat.o(158302);
                return t;
            } catch (Throwable th) {
                j.printErrStackTrace("MMSkeleton.DummyMode", th, "", new Object[0]);
                AppMethodBeat.o(158302);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements InvocationHandler {
        public int level;

        private a() {
            this.level = 0;
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.i(158300);
            Class<?> returnType = method.getReturnType();
            if (returnType.equals(Integer.TYPE)) {
                AppMethodBeat.o(158300);
                return 0;
            } else if (returnType.equals(Long.TYPE)) {
                AppMethodBeat.o(158300);
                return 0L;
            } else if (returnType.equals(Double.TYPE)) {
                Double valueOf = Double.valueOf(0.0d);
                AppMethodBeat.o(158300);
                return valueOf;
            } else if (returnType.equals(Float.TYPE)) {
                Float valueOf2 = Float.valueOf(0.0f);
                AppMethodBeat.o(158300);
                return valueOf2;
            } else if (returnType.equals(Short.TYPE)) {
                AppMethodBeat.o(158300);
                return 0;
            } else if (returnType.equals(Byte.TYPE)) {
                AppMethodBeat.o(158300);
                return 0;
            } else if (returnType.equals(Character.TYPE)) {
                AppMethodBeat.o(158300);
                return 0;
            } else if (returnType.equals(Boolean.TYPE)) {
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.o(158300);
                return bool;
            } else if (returnType.equals(Boolean.class)) {
                Boolean bool2 = Boolean.FALSE;
                AppMethodBeat.o(158300);
                return bool2;
            } else if (returnType.isInterface()) {
                Object b2 = f.b(returnType, this.level + 1);
                AppMethodBeat.o(158300);
                return b2;
            } else {
                AppMethodBeat.o(158300);
                return null;
            }
        }
    }
}
