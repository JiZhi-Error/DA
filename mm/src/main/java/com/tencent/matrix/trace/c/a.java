package com.tencent.matrix.trace.c;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class a {
    private static long dbA = 0;
    private static long dbB = 0;
    public static AppMethodBeat.a dbC = new AppMethodBeat.a();
    public static AppMethodBeat.a dbD = new AppMethodBeat.a();
    public static int dbE = Integer.MIN_VALUE;
    private static boolean dbF = false;
    private static final HashSet<b> listeners = new HashSet<>();

    public interface b {
        void TC();
    }

    public static void a(b bVar) {
        synchronized (listeners) {
            listeners.add(bVar);
        }
    }

    public static void Tx() {
        try {
            dbA = SystemClock.uptimeMillis();
            dbD = AppMethodBeat.getInstance().maskIndex("ApplicationCreateBeginMethodIndex");
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Field declaredField = cls.getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            Field declaredField2 = cls.getDeclaredField("mH");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Class<? super Object> superclass = obj2.getClass().getSuperclass();
            if (superclass != null) {
                Field declaredField3 = superclass.getDeclaredField("mCallback");
                declaredField3.setAccessible(true);
                declaredField3.set(obj2, new C0234a((Handler.Callback) declaredField3.get(obj2)));
            }
            c.i("Matrix.ActivityThreadHacker", "hook system handler completed. start:%s SDK_INT:%s", Long.valueOf(dbA), Integer.valueOf(Build.VERSION.SDK_INT));
        } catch (Exception e2) {
            c.e("Matrix.ActivityThreadHacker", "hook system handler err! %s", e2.getCause().toString());
        }
    }

    public static long Ty() {
        return dbB - dbA;
    }

    public static long Tz() {
        return dbA;
    }

    public static boolean TA() {
        return dbF;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.matrix.trace.c.a$a  reason: collision with other inner class name */
    public static final class C0234a implements Handler.Callback {
        private static boolean dbG = false;
        private static int dbH = Integer.MAX_VALUE;
        private final Handler.Callback dbI;
        private Method method = null;

        C0234a(Handler.Callback callback) {
            this.dbI = callback;
        }

        public final boolean handleMessage(Message message) {
            if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 25 && (message.what == 115 || message.what == 116 || message.what == 103 || message.what == 104 || message.what == 137)) {
                c.i("Matrix.ActivityThreadHacker", "[Matrix.fix.sp.apply] start to fix msg.waht=" + message.what, new Object[0]);
                try {
                    Field declaredField = Class.forName("android.app.QueuedWork").getDeclaredField("sPendingWorkFinishers");
                    if (declaredField != null) {
                        declaredField.setAccessible(true);
                        ((ConcurrentLinkedQueue) declaredField.get(null)).clear();
                        c.i("Matrix.ActivityThreadHacker", "[Matrix.fix.sp.apply] sPendingWorkFinishers.clear successful", new Object[0]);
                    }
                } catch (ClassNotFoundException e2) {
                    c.e("Matrix.ActivityThreadHacker", "[Matrix.fix.sp.apply] ClassNotFoundException = " + e2.getMessage(), new Object[0]);
                } catch (IllegalAccessException e3) {
                    c.e("Matrix.ActivityThreadHacker", "[Matrix.fix.sp.apply] IllegalAccessException =" + e3.getMessage(), new Object[0]);
                } catch (NoSuchFieldException e4) {
                    c.e("Matrix.ActivityThreadHacker", "[Matrix.fix.sp.apply] NoSuchFieldException = " + e4.getMessage(), new Object[0]);
                } catch (Exception e5) {
                    c.e("Matrix.ActivityThreadHacker", "[Matrix.fix.sp.apply] Exception = " + e5.getMessage(), new Object[0]);
                }
            }
            if (!AppMethodBeat.isRealTrace()) {
                return this.dbI != null && this.dbI.handleMessage(message);
            }
            boolean g2 = g(message);
            if (dbH > 0) {
                c.i("Matrix.ActivityThreadHacker", "[handleMessage] msg.what:%s begin:%s isLaunchActivity:%s SDK_INT=%s", Integer.valueOf(message.what), Long.valueOf(SystemClock.uptimeMillis()), Boolean.valueOf(g2), Integer.valueOf(Build.VERSION.SDK_INT));
                dbH--;
            }
            if (!dbG && (g2 || message.what == 114 || message.what == 113)) {
                long unused = a.dbB = SystemClock.uptimeMillis();
                a.dbE = message.what;
                dbG = true;
                boolean unused2 = a.dbF = g2;
                c.i("Matrix.ActivityThreadHacker", "application create end, sApplicationCreateScene:%d, isLaunchActivity:%s", Integer.valueOf(message.what), Boolean.valueOf(g2));
                synchronized (a.listeners) {
                    Iterator it = a.listeners.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).TC();
                    }
                }
            }
            return this.dbI != null && this.dbI.handleMessage(message);
        }

        private boolean g(Message message) {
            if (Build.VERSION.SDK_INT <= 27) {
                return message.what == 100 || message.what == 126;
            }
            if (message.what == 159 && message.obj != null) {
                try {
                    if (this.method == null) {
                        this.method = Class.forName("android.app.servertransaction.ClientTransaction").getDeclaredMethod("getCallbacks", new Class[0]);
                        this.method.setAccessible(true);
                    }
                    List list = (List) this.method.invoke(message.obj, new Object[0]);
                    if (!list.isEmpty()) {
                        return list.get(0).getClass().getName().endsWith(".LaunchActivityItem");
                    }
                } catch (Exception e2) {
                    c.e("Matrix.ActivityThreadHacker", "[isLaunchActivity] %s", e2);
                }
            }
            return message.what == 100;
        }
    }
}
