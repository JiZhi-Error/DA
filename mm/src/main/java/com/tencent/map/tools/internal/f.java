package com.tencent.map.tools.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class f implements d {

    /* renamed from: a  reason: collision with root package name */
    private b f1329a;

    public f(b bVar) {
        this.f1329a = bVar;
    }

    @Override // com.tencent.map.tools.internal.d
    public final Class findSheet(String str) {
        AppMethodBeat.i(180782);
        try {
            DexClassLoader a2 = this.f1329a.f1320a.a();
            if (a2 == null) {
                NullPointerException nullPointerException = new NullPointerException("load class failed");
                AppMethodBeat.o(180782);
                throw nullPointerException;
            }
            Class loadClass = a2.loadClass(str);
            AppMethodBeat.o(180782);
            return loadClass;
        } catch (Exception e2) {
            AppMethodBeat.o(180782);
            return null;
        }
    }

    @Override // com.tencent.map.tools.internal.d
    public final <T> Class<? extends T> findSheet(String str, Class<T> cls) {
        AppMethodBeat.i(180783);
        Class<? extends T> findSheet = findSheet(str);
        if (cls.isAssignableFrom(findSheet)) {
            AppMethodBeat.o(180783);
            return findSheet;
        }
        AppMethodBeat.o(180783);
        return null;
    }

    @Override // com.tencent.map.tools.internal.d
    public final Object newSheetIns(String str) {
        AppMethodBeat.i(180784);
        try {
            Object newSheetIns = newSheetIns(findSheet(str), new Object[0]);
            AppMethodBeat.o(180784);
            return newSheetIns;
        } catch (Exception e2) {
            AppMethodBeat.o(180784);
            return null;
        }
    }

    @Override // com.tencent.map.tools.internal.d
    public final <T> T newSheetIns(Class<T> cls, Object... objArr) {
        Constructor<?> constructor;
        AppMethodBeat.i(180785);
        if (cls != null) {
            Class[] clsArr = new Class[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                clsArr[i2] = objArr[i2].getClass();
            }
            try {
                constructor = b.a(cls, clsArr);
            } catch (Exception e2) {
                constructor = null;
            }
            if (constructor != null) {
                try {
                    T t = (T) b.a(constructor, new Object[0]);
                    AppMethodBeat.o(180785);
                    return t;
                } catch (Exception e3) {
                    if (e3 instanceof InvocationTargetException) {
                        RuntimeException runtimeException = new RuntimeException(((InvocationTargetException) e3).getTargetException());
                        AppMethodBeat.o(180785);
                        throw runtimeException;
                    }
                    RuntimeException runtimeException2 = new RuntimeException(e3);
                    AppMethodBeat.o(180785);
                    throw runtimeException2;
                }
            }
        }
        AppMethodBeat.o(180785);
        return null;
    }

    @Override // com.tencent.map.tools.internal.d
    public final ClassLoader getSheetLoader() {
        AppMethodBeat.i(180786);
        DexClassLoader a2 = this.f1329a.f1320a.a();
        AppMethodBeat.o(180786);
        return a2;
    }

    @Override // com.tencent.map.tools.internal.d
    public final Object callSheetMth(Object obj, String str, Object... objArr) {
        Method method;
        AppMethodBeat.i(180787);
        Class[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            clsArr[i2] = objArr[i2].getClass();
        }
        try {
            method = b.a(obj.getClass(), str, clsArr);
        } catch (Exception e2) {
            method = null;
        }
        if (method != null) {
            try {
                method.setAccessible(true);
                Object a2 = b.a(obj, method, objArr);
                AppMethodBeat.o(180787);
                return a2;
            } catch (Exception e3) {
                if (e3 instanceof InvocationTargetException) {
                    RuntimeException runtimeException = new RuntimeException(((InvocationTargetException) e3).getTargetException());
                    AppMethodBeat.o(180787);
                    throw runtimeException;
                }
                RuntimeException runtimeException2 = new RuntimeException(e3);
                AppMethodBeat.o(180787);
                throw runtimeException2;
            }
        } else {
            AppMethodBeat.o(180787);
            return null;
        }
    }

    @Override // com.tencent.map.tools.internal.d
    public final Object callSheetMth(Object obj, String str, Class[] clsArr, Object[] objArr) {
        Method method;
        Object obj2 = null;
        AppMethodBeat.i(180788);
        try {
            method = b.a(obj.getClass(), str, clsArr);
        } catch (Exception e2) {
            method = null;
        }
        if (method != null) {
            try {
                method.setAccessible(true);
                obj2 = b.a(obj, method, objArr);
                AppMethodBeat.o(180788);
            } catch (Exception e3) {
                if (e3 instanceof InvocationTargetException) {
                    RuntimeException runtimeException = new RuntimeException(((InvocationTargetException) e3).getTargetException());
                    AppMethodBeat.o(180788);
                    throw runtimeException;
                }
                RuntimeException runtimeException2 = new RuntimeException(e3);
                AppMethodBeat.o(180788);
                throw runtimeException2;
            }
        } else {
            AppMethodBeat.o(180788);
        }
        return obj2;
    }

    @Override // com.tencent.map.tools.internal.d
    public final Object callSheetStaMth(Class cls, String str, Class[] clsArr, Object[] objArr) {
        AppMethodBeat.i(193527);
        Method method = null;
        try {
            method = b.a(cls, str, clsArr);
        } catch (Exception e2) {
        }
        try {
            Object a2 = b.a(cls, method, objArr);
            AppMethodBeat.o(193527);
            return a2;
        } catch (Exception e3) {
            if (e3 instanceof InvocationTargetException) {
                RuntimeException runtimeException = new RuntimeException(((InvocationTargetException) e3).getTargetException());
                AppMethodBeat.o(193527);
                throw runtimeException;
            }
            RuntimeException runtimeException2 = new RuntimeException(e3);
            AppMethodBeat.o(193527);
            throw runtimeException2;
        }
    }

    @Override // com.tencent.map.tools.internal.d
    public final int loadSheetGroups() {
        AppMethodBeat.i(180789);
        int a2 = this.f1329a.f1320a.a(a.f1315g);
        AppMethodBeat.o(180789);
        return a2;
    }
}
