package com.tencent.matrix.a.c;

import android.os.IBinder;
import android.os.IInterface;
import com.tencent.matrix.g.c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public final class g {
    private final String cUn;
    private final b cUo;
    private IBinder cUp;
    private IBinder cUq;
    private final String mServiceName;

    public interface b {
        void b(Method method, Object[] objArr);
    }

    public g(String str, String str2, b bVar) {
        this.mServiceName = str;
        this.cUn = str2;
        this.cUo = bVar;
    }

    public final boolean doHook() {
        c.i("Matrix.battery.SystemServiceBinderHooker", "doHook: serviceName:%s, serviceClsName:%s", this.mServiceName, this.cUn);
        try {
            a aVar = new a(this.mServiceName, this.cUn, this.cUo);
            Class<?> cls = Class.forName("android.os.ServiceManager");
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null) {
                throw new IllegalStateException("Can not get ClassLoader of " + cls.getName());
            }
            IBinder iBinder = (IBinder) Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class}, aVar);
            Field declaredField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put(this.mServiceName, iBinder);
            this.cUq = iBinder;
            this.cUp = aVar.cUr;
            return true;
        } catch (Throwable th) {
            c.e("Matrix.battery.SystemServiceBinderHooker", "#doHook exp: " + th.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }

    public final boolean doUnHook() {
        if (this.cUp == null) {
            c.w("Matrix.battery.SystemServiceBinderHooker", "#doUnHook mOriginServiceBinder null", new Object[0]);
            return false;
        } else if (this.cUq == null) {
            c.w("Matrix.battery.SystemServiceBinderHooker", "#doUnHook mDelegateServiceBinder null", new Object[0]);
            return false;
        } else {
            try {
                if (this.cUq != a.ew(this.mServiceName)) {
                    c.w("Matrix.battery.SystemServiceBinderHooker", "#doUnHook mDelegateServiceBinder != currentBinder", new Object[0]);
                    return false;
                }
                Field declaredField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
                declaredField.setAccessible(true);
                ((Map) declaredField.get(null)).put(this.mServiceName, this.cUp);
                return true;
            } catch (Throwable th) {
                c.e("Matrix.battery.SystemServiceBinderHooker", "#doUnHook exp: " + th.getLocalizedMessage(), new Object[0]);
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a implements InvocationHandler {
        final IBinder cUr;
        private final Object cUs;

        a(String str, String str2, final b bVar) {
            this.cUr = ew(str);
            IBinder iBinder = this.cUr;
            Class<?> cls = Class.forName(str2);
            Class<?> cls2 = Class.forName(str2 + "$Stub");
            ClassLoader classLoader = cls2.getClassLoader();
            if (classLoader == null) {
                throw new IllegalStateException("get service manager ClassLoader fail!");
            }
            final Object invoke = cls2.getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
            this.cUs = Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class, IInterface.class, cls}, new InvocationHandler() {
                /* class com.tencent.matrix.a.c.g.a.AnonymousClass1 */

                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    if (bVar != null) {
                        bVar.b(method, objArr);
                    }
                    return method.invoke(invoke, objArr);
                }
            });
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            if ("queryLocalInterface".equals(method.getName())) {
                return this.cUs;
            }
            return method.invoke(this.cUr, objArr);
        }

        static IBinder ew(String str) {
            return (IBinder) Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, str);
        }
    }
}
