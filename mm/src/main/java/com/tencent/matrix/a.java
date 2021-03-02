package com.tencent.matrix;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.matrix.b.c;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum a {
    INSTANCE;
    
    public boolean cPB = false;
    public String cPC = BuildConfig.KINDA_DEFAULT;
    ComponentCallbacks2C0201a cPD = new ComponentCallbacks2C0201a(this, (byte) 0);
    public String cPE;
    Handler handler;
    boolean isInit = false;
    private final Set<c> listeners = new HashSet();

    private a(String str) {
    }

    public final void eg(String str) {
        com.tencent.matrix.g.c.i("Matrix.AppActiveDelegate", "[setCurrentFragmentName] fragmentName:%s", str);
        this.cPE = str;
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            str = "?";
        }
        sb.append(str);
        this.cPC = sb.toString();
    }

    public final void a(c cVar) {
        synchronized (this.listeners) {
            this.listeners.add(cVar);
        }
    }

    public final void b(c cVar) {
        synchronized (this.listeners) {
            this.listeners.remove(cVar);
        }
    }

    /* renamed from: com.tencent.matrix.a$a  reason: collision with other inner class name */
    final class ComponentCallbacks2C0201a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
        private ComponentCallbacks2C0201a() {
        }

        /* synthetic */ ComponentCallbacks2C0201a(a aVar, byte b2) {
            this();
        }

        public final void onActivityStarted(Activity activity) {
            a.a(a.this, activity);
            a.a(a.this, a.this.cPC);
        }

        public final void onActivityStopped(Activity activity) {
            if (a.RF() == null) {
                a.b(a.this, a.this.cPC);
            }
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onConfigurationChanged(Configuration configuration) {
        }

        public final void onLowMemory() {
        }

        public final void onTrimMemory(int i2) {
            com.tencent.matrix.g.c.i("Matrix.AppActiveDelegate", "[onTrimMemory] level:%s", Integer.valueOf(i2));
            if (i2 == 20 && a.this.cPB) {
                a.b(a.this, a.this.cPC);
            }
        }
    }

    public static String RF() {
        Map map;
        long currentTimeMillis = System.currentTimeMillis();
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
                com.tencent.matrix.g.c.d("Matrix.AppActiveDelegate", "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
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
                    com.tencent.matrix.g.c.d("Matrix.AppActiveDelegate", "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return name;
                }
            }
            com.tencent.matrix.g.c.d("Matrix.AppActiveDelegate", "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return null;
        } catch (Exception e2) {
            com.tencent.matrix.g.c.d("Matrix.AppActiveDelegate", "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable th) {
            com.tencent.matrix.g.c.d("Matrix.AppActiveDelegate", "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            throw th;
        }
    }

    static /* synthetic */ void a(a aVar, Activity activity) {
        aVar.cPC = activity.getClass().getName();
    }

    static /* synthetic */ void a(a aVar, String str) {
        if (!aVar.cPB && aVar.isInit) {
            com.tencent.matrix.g.c.i("Matrix.AppActiveDelegate", "onForeground... visibleScene[%s]", str);
            aVar.handler.post(new Runnable() {
                /* class com.tencent.matrix.a.AnonymousClass1 */

                public final void run() {
                    a.this.cPB = true;
                    synchronized (a.this.listeners) {
                        for (c cVar : a.this.listeners) {
                            cVar.onForeground(true);
                        }
                    }
                }
            });
        }
    }

    static /* synthetic */ void b(a aVar, String str) {
        if (aVar.cPB && aVar.isInit) {
            com.tencent.matrix.g.c.i("Matrix.AppActiveDelegate", "onBackground... visibleScene[%s]", str);
            aVar.handler.post(new Runnable() {
                /* class com.tencent.matrix.a.AnonymousClass2 */

                public final void run() {
                    a.this.cPB = false;
                    synchronized (a.this.listeners) {
                        for (c cVar : a.this.listeners) {
                            cVar.onForeground(false);
                        }
                    }
                }
            });
        }
    }
}
