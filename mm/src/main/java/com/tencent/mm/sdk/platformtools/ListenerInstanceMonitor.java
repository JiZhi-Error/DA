package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class ListenerInstanceMonitor {
    private static final String ACTIVITY_CLASSNAME = Activity.class.getName();
    private static final int MONITOR_TRIGGER_INTERVAL_MILLIS = 10000;
    private static final int RECONFIRM_CHECK_COUNT = 3;
    private static final String TAG = "MicroMsg.ListenerInstanceMonitor";
    private static volatile Class sClass_DoNotCheckLeakForActivities = null;
    private static volatile boolean sIsMonitorRunning = false;
    private static final Object sLock = new Object();
    private static Field sMContextField;
    private static final byte[] sMapGuard = new byte[0];
    private static final Map<Object, Set<HeldUIInfo>> sMarkedInstanceToHeldObjMap = new WeakHashMap();
    private static volatile Method sMehtod_value = null;
    private static final Runnable sMonitorTask = new Runnable() {
        /* class com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.AnonymousClass1 */

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
            if (com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.sIsMonitorRunning == false) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
            com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.sMonitorThreadHandler.postDelayed(r5, 10000);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(125239);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
            doMonitorWorks();
            r1 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.sMonitorTask;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
            monitor-enter(r1);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r5 = this;
                r4 = 125239(0x1e937, float:1.75497E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                java.lang.Runnable r1 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.access$000()
                monitor-enter(r1)
                boolean r0 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.access$100()     // Catch:{ all -> 0x0033 }
                if (r0 != 0) goto L_0x0016
                monitor-exit(r1)     // Catch:{ all -> 0x0033 }
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0015:
                return
            L_0x0016:
                monitor-exit(r1)
                r5.doMonitorWorks()
                java.lang.Runnable r1 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.access$000()
                monitor-enter(r1)
                boolean r0 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.access$100()     // Catch:{ all -> 0x0039 }
                if (r0 == 0) goto L_0x002e
                com.tencent.mm.sdk.platformtools.MMHandler r0 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.access$200()     // Catch:{ all -> 0x0039 }
                r2 = 10000(0x2710, double:4.9407E-320)
                r0.postDelayed(r5, r2)     // Catch:{ all -> 0x0039 }
            L_0x002e:
                monitor-exit(r1)     // Catch:{ all -> 0x0039 }
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0015
            L_0x0033:
                r0 = move-exception
                monitor-exit(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                throw r0
            L_0x0039:
                r0 = move-exception
                monitor-exit(r1)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.AnonymousClass1.run():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
            if (android.os.Debug.isDebuggerConnected() == false) goto L_0x003f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            com.tencent.mm.sdk.platformtools.Log.w(com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.TAG, "[tomys] monitor task: found debugger connected, disable monitor works in case of misreport.");
            com.tencent.matrix.trace.core.AppMethodBeat.o(200890);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
            com.tencent.mm.sdk.platformtools.Log.d(com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.TAG, "[tomys] monitor task: triggering gc...");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            java.lang.Runtime.getRuntime().gc();
            java.lang.Thread.sleep(100);
            java.lang.Runtime.getRuntime().runFinalization();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void doMonitorWorks() {
            /*
            // Method dump skipped, instructions count: 300
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.AnonymousClass1.doMonitorWorks():void");
        }

        private boolean isUIActuallyDestroyed(Activity activity) {
            boolean z = false;
            AppMethodBeat.i(200891);
            boolean isDestroyed = activity.isDestroyed();
            if (!isDestroyed) {
                AppMethodBeat.o(200891);
            } else {
                StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                int length = stackTrace.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = isDestroyed;
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if (ListenerInstanceMonitor.ACTIVITY_CLASSNAME.equals(stackTraceElement.getClassName()) && "performDestroy".equals(stackTraceElement.getMethodName())) {
                        break;
                    }
                    i2++;
                }
                AppMethodBeat.o(200891);
            }
            return z;
        }
    };
    private static MMHandler sMonitorThreadHandler = null;

    static {
        AppMethodBeat.i(125253);
        sMContextField = null;
        if (!WeChatEnvironment.hasDebugger() && !WeChatEnvironment.isMonkeyEnv()) {
            Log.w(TAG, "Not debug, assist or monkey env, keep disabled.");
        } else if (MMApplicationContext.isMMProcess()) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                sMContextField = declaredField;
                declaredField.setAccessible(true);
                startMonitor();
            } catch (Throwable th) {
                Log.printErrStackTrace(TAG, th, "init failed, keep disabled.", new Object[0]);
            }
        } else {
            Log.w(TAG, "Not mm process, keep disabled.");
        }
        AppMethodBeat.o(125253);
    }

    /* access modifiers changed from: package-private */
    public static class HeldUIInfo {
        int checkedCount;
        Class<?> heldUIClazz;
        WeakReference<Activity> heldUIRef;
        Field holderField;
        final WeakReference<Object> sentinel = new WeakReference<>(new Object());
        Throwable stacktrace;

        HeldUIInfo(Activity activity, Field field, Throwable th) {
            AppMethodBeat.i(125240);
            this.heldUIRef = new WeakReference<>(activity);
            this.heldUIClazz = activity.getClass();
            this.holderField = field;
            this.stacktrace = th;
            this.checkedCount = 0;
            AppMethodBeat.o(125240);
        }

        public String describe() {
            AppMethodBeat.i(200892);
            if (this.heldUIRef.get() == null) {
                if (this.holderField != null) {
                    String str = "ui of class [" + this.heldUIClazz.getName() + "] held by\n [" + getHolderFieldDesc() + "] is recycled";
                    AppMethodBeat.o(200892);
                    return str;
                }
                String str2 = "ui of class [" + this.heldUIClazz.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is recycled";
                AppMethodBeat.o(200892);
                return str2;
            } else if (this.holderField != null) {
                String str3 = "ui of class [" + this.heldUIClazz.getName() + "] held by\n [" + getHolderFieldDesc() + "] is leaked.\n Perhaps you should remove the holder from any 'Manager' class when the leaked ui was destroyed.";
                AppMethodBeat.o(200892);
                return str3;
            } else {
                String str4 = "ui of class [" + this.heldUIClazz.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is leaked.\n Perhaps you should remove any instance of this class from any 'Manager'";
                AppMethodBeat.o(200892);
                return str4;
            }
        }

        public String toString() {
            AppMethodBeat.i(125241);
            String str = getHolderFieldDesc() + "@" + getStackTraceString().replace('\n', '|');
            AppMethodBeat.o(125241);
            return str;
        }

        private String getStackTraceString() {
            PrintWriter printWriter;
            Throwable th;
            AppMethodBeat.i(125242);
            StringWriter stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
                try {
                    this.stacktrace.printStackTrace(printWriter);
                    Util.qualityClose(printWriter);
                    String stringWriter2 = stringWriter.toString();
                    AppMethodBeat.o(125242);
                    return stringWriter2;
                } catch (Throwable th2) {
                    th = th2;
                    Util.qualityClose(printWriter);
                    AppMethodBeat.o(125242);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                printWriter = null;
                Util.qualityClose(printWriter);
                AppMethodBeat.o(125242);
                throw th;
            }
        }

        private String getHolderFieldDesc() {
            AppMethodBeat.i(125243);
            if (this.holderField == null) {
                AppMethodBeat.o(125243);
                return "#null#";
            }
            Class<?> declaringClass = this.holderField.getDeclaringClass();
            if (!declaringClass.isAnonymousClass()) {
                String str = "field " + this.holderField.getName() + " defined in " + declaringClass.getName();
                AppMethodBeat.o(125243);
                return str;
            }
            Object genericSuperclass = declaringClass.getGenericSuperclass();
            Object obj = declaringClass;
            if (Object.class.equals(genericSuperclass)) {
                obj = declaringClass.getGenericInterfaces()[0];
            } else if (genericSuperclass != null) {
                obj = genericSuperclass;
            }
            String str2 = "field " + this.holderField.getName() + " define in anonymous class of " + obj.toString().replace('<', '#').replace('>', '#');
            AppMethodBeat.o(125243);
            return str2;
        }

        public int hashCode() {
            int i2;
            int i3;
            int i4 = 0;
            AppMethodBeat.i(125244);
            Activity activity = this.heldUIRef.get();
            if (activity != null) {
                i2 = activity.hashCode();
            } else {
                i2 = 0;
            }
            if (this.holderField != null) {
                i3 = this.holderField.hashCode();
            } else {
                i3 = 0;
            }
            if (this.stacktrace != null) {
                i4 = this.stacktrace.hashCode();
            }
            int i5 = i2 + i3 + i4;
            AppMethodBeat.o(125244);
            return i5;
        }

        public boolean equals(Object obj) {
            boolean equals;
            boolean equals2;
            boolean z = true;
            AppMethodBeat.i(125245);
            if (obj == null || !(obj instanceof HeldUIInfo)) {
                AppMethodBeat.o(125245);
                return false;
            }
            HeldUIInfo heldUIInfo = (HeldUIInfo) obj;
            Activity activity = this.heldUIRef.get();
            Activity activity2 = heldUIInfo.heldUIRef.get();
            if (activity == null && activity2 == null) {
                equals = true;
            } else {
                equals = (activity == null || activity2 == null) ? false : activity.equals(activity2);
            }
            if (!equals) {
                AppMethodBeat.o(125245);
                return false;
            }
            Field field = this.holderField;
            Field field2 = heldUIInfo.holderField;
            if (field == null && field2 == null) {
                equals2 = true;
            } else {
                equals2 = (field == null || field2 == null) ? false : field.equals(field2);
            }
            if (!equals2) {
                AppMethodBeat.o(125245);
                return false;
            }
            Throwable th = this.stacktrace;
            Throwable th2 = heldUIInfo.stacktrace;
            if (!(th == null && th2 == null)) {
                z = (th == null || th2 == null) ? false : th.equals(th2);
            }
            AppMethodBeat.o(125245);
            return z;
        }
    }

    public static void startMonitor() {
        AppMethodBeat.i(125247);
        synchronized (sMonitorTask) {
            try {
                if (!sIsMonitorRunning) {
                    MMHandler mMHandler = new MMHandler("ListenerInstanceMonitor");
                    sMonitorThreadHandler = mMHandler;
                    mMHandler.setLogging(false);
                    sMonitorThreadHandler.postDelayed(sMonitorTask, 10000);
                    sIsMonitorRunning = true;
                }
            } finally {
                AppMethodBeat.o(125247);
            }
        }
    }

    public static void stopMonitor() {
        AppMethodBeat.i(200893);
        synchronized (sMonitorTask) {
            try {
                if (sIsMonitorRunning) {
                    sMonitorThreadHandler.removeCallbacks(sMonitorTask);
                    sMonitorThreadHandler.quit();
                    sMonitorThreadHandler = null;
                    sIsMonitorRunning = false;
                }
            } finally {
                AppMethodBeat.o(200893);
            }
        }
    }

    public static void markInstanceRegistered(Object obj) {
        AppMethodBeat.i(125248);
        if (obj == null) {
            AppMethodBeat.o(125248);
            return;
        }
        Throwable th = new Throwable();
        for (Class<?> cls = obj.getClass(); !Object.class.equals(cls); cls = cls.getSuperclass()) {
            if (Activity.class.isAssignableFrom(cls)) {
                processHeldActivity(obj, null, th);
            } else if (View.class.isAssignableFrom(cls)) {
                processHeldView(obj, null, th);
            } else {
                Field[] declaredFields = cls.getDeclaredFields();
                for (Field field : declaredFields) {
                    Class<?> type = field.getType();
                    if (Activity.class.isAssignableFrom(type)) {
                        processHeldActivity(obj, field, th);
                    } else if (View.class.isAssignableFrom(type)) {
                        processHeldView(obj, field, th);
                    }
                }
            }
        }
        AppMethodBeat.o(125248);
    }

    private static void processHeldActivity(Object obj, Field field, Throwable th) {
        Activity activity;
        AppMethodBeat.i(125249);
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                activity = (Activity) field.get(obj);
                if (activity == null) {
                    AppMethodBeat.o(125249);
                    return;
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(125249);
                return;
            }
        } else if (obj instanceof Activity) {
            activity = (Activity) obj;
        } else {
            AppMethodBeat.o(125249);
            return;
        }
        addHeldObjInfo(obj, activity, field, th);
        AppMethodBeat.o(125249);
    }

    private static void processHeldView(Object obj, Field field, Throwable th) {
        View view;
        AppMethodBeat.i(125250);
        if (field == null) {
            if (obj instanceof View) {
                view = (View) obj;
            } else {
                AppMethodBeat.o(125250);
                return;
            }
        } else if (sMContextField == null) {
            AppMethodBeat.o(125250);
            return;
        } else {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                view = (View) field.get(obj);
                if (view == null) {
                    AppMethodBeat.o(125250);
                    return;
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(125250);
                return;
            }
        }
        try {
            Object obj2 = sMContextField.get(view);
            if (obj2 instanceof Activity) {
                addHeldObjInfo(obj, (Activity) obj2, field, th);
            }
            AppMethodBeat.o(125250);
        } catch (Throwable th3) {
            AppMethodBeat.o(125250);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void addHeldObjInfo(java.lang.Object r9, android.app.Activity r10, java.lang.reflect.Field r11, java.lang.Throwable r12) {
        /*
        // Method dump skipped, instructions count: 225
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.addHeldObjInfo(java.lang.Object, android.app.Activity, java.lang.reflect.Field, java.lang.Throwable):void");
    }

    public static void markInstanceUnregistered(Object obj) {
        AppMethodBeat.i(125252);
        if (obj == null) {
            AppMethodBeat.o(125252);
            return;
        }
        synchronized (sMapGuard) {
            try {
                sMarkedInstanceToHeldObjMap.remove(obj);
            } finally {
                AppMethodBeat.o(125252);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ListenerLeakedException extends RuntimeException {
        ListenerLeakedException(String str, Throwable th) {
            super(str + "\n See stacktrace to find where is the holder(listener) being added.");
            AppMethodBeat.i(125246);
            setStackTrace(th.getStackTrace());
            AppMethodBeat.o(125246);
        }

        public final Throwable fillInStackTrace() {
            return this;
        }
    }
}
