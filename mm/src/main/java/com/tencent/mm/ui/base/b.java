package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class b {

    public interface a {
        void bXA();

        void bXB();
    }

    /* renamed from: com.tencent.mm.ui.base.b$b  reason: collision with other inner class name */
    public interface AbstractC2081b {
        void ei(boolean z);
    }

    public static String e(ComponentName componentName) {
        AppMethodBeat.i(141605);
        if (componentName.getClassName().startsWith(componentName.getPackageName())) {
            String className = componentName.getClassName();
            AppMethodBeat.o(141605);
            return className;
        }
        String className2 = componentName.getClassName();
        AppMethodBeat.o(141605);
        return className2;
    }

    public static int blZ(String str) {
        AppMethodBeat.i(141606);
        Class<?> bma = bma(str);
        if (bma != null) {
            int bd = bd(bma);
            AppMethodBeat.o(141606);
            return bd;
        }
        AppMethodBeat.o(141606);
        return 0;
    }

    public static int bd(Class<?> cls) {
        AppMethodBeat.i(141607);
        a aVar = (a) cls.getAnnotation(a.class);
        if (aVar != null) {
            int value = aVar.value();
            AppMethodBeat.o(141607);
            return value;
        }
        int be = be(cls);
        AppMethodBeat.o(141607);
        return be;
    }

    private static int be(Class<?> cls) {
        AppMethodBeat.i(141608);
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            int bd = bd(superclass);
            AppMethodBeat.o(141608);
            return bd;
        }
        AppMethodBeat.o(141608);
        return 0;
    }

    private static Class<?> bma(String str) {
        AppMethodBeat.i(141609);
        try {
            Class<?> cls = Class.forName(str);
            AppMethodBeat.o(141609);
            return cls;
        } catch (ClassNotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.ActivityUtil", e2, "", new Object[0]);
            Log.e("MicroMsg.ActivityUtil", "Class %s not found in dex", str);
            AppMethodBeat.o(141609);
            return null;
        }
    }

    public static boolean bf(Class<?> cls) {
        AppMethodBeat.i(141610);
        if ((bd(cls) & 1) == 0) {
            AppMethodBeat.o(141610);
            return true;
        }
        AppMethodBeat.o(141610);
        return false;
    }

    public static boolean bg(Class<?> cls) {
        AppMethodBeat.i(141611);
        if ((bd(cls) & 2) == 0) {
            AppMethodBeat.o(141611);
            return true;
        }
        AppMethodBeat.o(141611);
        return false;
    }

    public static boolean bmb(String str) {
        AppMethodBeat.i(141612);
        if ((blZ(str) & 4) != 0) {
            AppMethodBeat.o(141612);
            return true;
        }
        AppMethodBeat.o(141612);
        return false;
    }

    public static void bp(Activity activity) {
        AppMethodBeat.i(141613);
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
            if (activity instanceof a) {
                ((a) activity).bXB();
            }
            AppMethodBeat.o(141613);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.ActivityUtil", th, "call convertActivityFromTranslucent Fail: %s", th.getMessage());
            AppMethodBeat.o(141613);
        }
    }

    /* access modifiers changed from: package-private */
    public static class c implements InvocationHandler {
        WeakReference<AbstractC2081b> hfj;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            boolean z = false;
            AppMethodBeat.i(141604);
            if (this.hfj == null) {
                Log.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!");
                AppMethodBeat.o(141604);
            } else {
                AbstractC2081b bVar = this.hfj.get();
                if (bVar == null) {
                    Log.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!");
                    AppMethodBeat.o(141604);
                } else {
                    if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                        z = ((Boolean) objArr[0]).booleanValue();
                    }
                    bVar.ei(z);
                    AppMethodBeat.o(141604);
                }
            }
            return null;
        }
    }

    @TargetApi(16)
    public static void a(Activity activity, AbstractC2081b bVar) {
        Object obj;
        AppMethodBeat.i(141614);
        if (d.oE(16)) {
            Log.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", Integer.valueOf(Build.VERSION.SDK_INT));
            AppMethodBeat.o(141614);
            return;
        }
        try {
            Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
            int length = declaredClasses.length;
            int i2 = 0;
            Class<?> cls = null;
            while (i2 < length) {
                Class<?> cls2 = declaredClasses[i2];
                if (!cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls2 = cls;
                }
                i2++;
                cls = cls2;
            }
            if (bVar != null) {
                c cVar = new c((byte) 0);
                cVar.hfj = new WeakReference<>(bVar);
                obj = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, cVar);
            } else {
                obj = null;
            }
            if (d.oE(21)) {
                Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(activity, obj);
            } else {
                Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(activity, obj, null);
            }
            if (activity instanceof a) {
                ((a) activity).bXA();
            }
            AppMethodBeat.o(141614);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.ActivityUtil", th, "call convertActivityToTranslucent Fail: %s", th.getMessage());
            AppMethodBeat.o(141614);
        }
    }

    public static void kb(Context context) {
        AppMethodBeat.i(141615);
        if (context == null || !(context instanceof Activity)) {
            AppMethodBeat.o(141615);
            return;
        }
        ((Activity) context).overridePendingTransition(R.anim.dd, R.anim.s);
        AppMethodBeat.o(141615);
    }

    public static void kc(Context context) {
        AppMethodBeat.i(141616);
        if (context == null || !(context instanceof Activity)) {
            AppMethodBeat.o(141616);
            return;
        }
        ((Activity) context).overridePendingTransition(R.anim.dd, R.anim.di);
        AppMethodBeat.o(141616);
    }

    public static void az(Context context, Intent intent) {
        AppMethodBeat.i(141617);
        if (intent == null || context == null || !(context instanceof Activity)) {
            AppMethodBeat.o(141617);
            return;
        }
        if (intent.getBooleanExtra("animation_pop_in", false)) {
            ((Activity) context).overridePendingTransition(R.anim.dd, R.anim.s);
        }
        if (intent.getBooleanExtra("animation_push_up_in", false)) {
            ((Activity) context).overridePendingTransition(R.anim.dq, R.anim.s);
        }
        AppMethodBeat.o(141617);
    }

    public static void kd(Context context) {
        AppMethodBeat.i(141618);
        if (context == null || !(context instanceof Activity)) {
            AppMethodBeat.o(141618);
            return;
        }
        ((Activity) context).overridePendingTransition(R.anim.s, R.anim.di);
        AppMethodBeat.o(141618);
    }

    public static void ke(Context context) {
        AppMethodBeat.i(141619);
        if (context == null || !(context instanceof Activity)) {
            AppMethodBeat.o(141619);
            return;
        }
        ((Activity) context).overridePendingTransition(R.anim.s, R.anim.s);
        AppMethodBeat.o(141619);
    }
}
