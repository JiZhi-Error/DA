package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class b {

    /* renamed from: c  reason: collision with root package name */
    private static b f1319c;

    /* renamed from: a  reason: collision with root package name */
    public m f1320a;

    /* renamed from: b  reason: collision with root package name */
    private String f1321b = b.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private Context f1322d;

    private b(Context context) {
        AppMethodBeat.i(180773);
        this.f1322d = context;
        this.f1320a = new m(this.f1322d);
        AppMethodBeat.o(180773);
    }

    public static b a(Context context) {
        AppMethodBeat.i(180774);
        if (context == null) {
            NullPointerException nullPointerException = new NullPointerException("context is null");
            AppMethodBeat.o(180774);
            throw nullPointerException;
        } else if (context.getApplicationContext() == null) {
            NullPointerException nullPointerException2 = new NullPointerException("application context is null");
            AppMethodBeat.o(180774);
            throw nullPointerException2;
        } else {
            synchronized (b.class) {
                try {
                    if (f1319c == null) {
                        f1319c = new b(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(180774);
                    throw th;
                }
            }
            b bVar = f1319c;
            AppMethodBeat.o(180774);
            return bVar;
        }
    }

    public static Constructor<?> a(Class cls, Class<?>... clsArr) {
        AppMethodBeat.i(180775);
        if (cls == null) {
            NullPointerException nullPointerException = new NullPointerException("class is null");
            AppMethodBeat.o(180775);
            throw nullPointerException;
        }
        Constructor<?> constructor = cls.getConstructor(clsArr);
        AppMethodBeat.o(180775);
        return constructor;
    }

    public static Object a(Constructor<?> constructor, Object... objArr) {
        AppMethodBeat.i(180776);
        if (constructor == null) {
            NullPointerException nullPointerException = new NullPointerException("constructor is null");
            AppMethodBeat.o(180776);
            throw nullPointerException;
        }
        Object newInstance = constructor.newInstance(objArr);
        AppMethodBeat.o(180776);
        return newInstance;
    }

    public static Method a(Class cls, String str, Class<?>... clsArr) {
        AppMethodBeat.i(180777);
        if (cls == null) {
            NullPointerException nullPointerException = new NullPointerException("class is null");
            AppMethodBeat.o(180777);
            throw nullPointerException;
        } else if (clsArr == null) {
            Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            AppMethodBeat.o(180777);
            return declaredMethod;
        } else {
            Method declaredMethod2 = cls.getDeclaredMethod(str, clsArr);
            AppMethodBeat.o(180777);
            return declaredMethod2;
        }
    }

    public static Object a(Object obj, Method method, Object... objArr) {
        AppMethodBeat.i(180778);
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException("Object instance is null");
            AppMethodBeat.o(180778);
            throw nullPointerException;
        } else if (method == null) {
            NullPointerException nullPointerException2 = new NullPointerException("method instance is null");
            AppMethodBeat.o(180778);
            throw nullPointerException2;
        } else if (objArr == null) {
            Object invoke = method.invoke(obj, method);
            AppMethodBeat.o(180778);
            return invoke;
        } else {
            Object invoke2 = method.invoke(obj, objArr);
            AppMethodBeat.o(180778);
            return invoke2;
        }
    }
}
