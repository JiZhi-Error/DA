package com.tencent.mm.rabbiteye.a;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public enum a {
    INSTANCE;
    
    private ComponentCallbacks2C2041a NBa = new ComponentCallbacks2C2041a(this, (byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private boolean f1539b = false;

    /* renamed from: c  reason: collision with root package name */
    String f1540c = BuildConfig.KINDA_DEFAULT;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1541e = false;

    /* renamed from: com.tencent.mm.rabbiteye.a.a$a  reason: collision with other inner class name */
    final class ComponentCallbacks2C2041a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
        private ComponentCallbacks2C2041a() {
            AppMethodBeat.i(186303);
            AppMethodBeat.o(186303);
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
            AppMethodBeat.i(186304);
            a.a(a.this, activity);
            a.this.f1539b = true;
            AppMethodBeat.o(186304);
        }

        public final void onActivityStopped(Activity activity) {
            AppMethodBeat.i(186305);
            if (a.RF() == null) {
                a.this.f1539b = false;
            }
            AppMethodBeat.o(186305);
        }

        public final void onConfigurationChanged(Configuration configuration) {
        }

        public final void onLowMemory() {
        }

        public final void onTrimMemory(int i2) {
            AppMethodBeat.i(186306);
            if (i2 == 20 && a.this.f1539b) {
                a aVar = a.this;
                String unused = aVar.f1540c;
                aVar.f1539b = false;
            }
            AppMethodBeat.o(186306);
        }

        /* synthetic */ ComponentCallbacks2C2041a(a aVar, byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(186314);
        AppMethodBeat.o(186314);
    }

    private a(String str) {
        AppMethodBeat.i(186309);
        AppMethodBeat.o(186309);
    }

    public static String RF() {
        Map map;
        AppMethodBeat.i(186310);
        System.currentTimeMillis();
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            if (Build.VERSION.SDK_INT < 19) {
                map = (HashMap) declaredField.get(invoke);
            } else {
                map = (ArrayMap) declaredField.get(invoke);
            }
            if (map.size() <= 0) {
                System.currentTimeMillis();
                AppMethodBeat.o(186310);
                return null;
            }
            for (Object obj : map.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                    declaredField3.setAccessible(true);
                    String name = ((Activity) declaredField3.get(obj)).getClass().getName();
                    System.currentTimeMillis();
                    AppMethodBeat.o(186310);
                    return name;
                }
            }
            System.currentTimeMillis();
            AppMethodBeat.o(186310);
            return null;
        } catch (Exception e2) {
        } catch (Throwable th) {
            System.currentTimeMillis();
            AppMethodBeat.o(186310);
            throw th;
        }
    }

    public static boolean gus() {
        AppMethodBeat.i(186311);
        boolean a2 = a();
        AppMethodBeat.o(186311);
        return a2;
    }

    public static a valueOf(String str) {
        AppMethodBeat.i(186308);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(186308);
        return aVar;
    }

    private static boolean a() {
        Map map;
        AppMethodBeat.i(186312);
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            if (Build.VERSION.SDK_INT < 19) {
                map = (HashMap) declaredField.get(invoke);
            } else {
                map = (ArrayMap) declaredField.get(invoke);
            }
            if (map.size() <= 0) {
                AppMethodBeat.o(186312);
                return false;
            }
            for (Object obj : map.values()) {
                Field declaredField2 = obj.getClass().getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    AppMethodBeat.o(186312);
                    return true;
                }
            }
            AppMethodBeat.o(186312);
            return false;
        } catch (Exception e2) {
        } catch (Throwable th) {
            AppMethodBeat.o(186312);
            throw th;
        }
    }

    static /* synthetic */ void a(a aVar, Activity activity) {
        AppMethodBeat.i(186313);
        aVar.f1540c = activity.getClass().getName();
        AppMethodBeat.o(186313);
    }
}
