package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.ArrayMap;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum AppForegroundDelegate {
    INSTANCE;
    
    public static final String djS = WeChatPermissions.PERMISSION_MM_MESSAGE();
    private static String djV = null;
    public static boolean djW = false;
    private static final b dka = new b((byte) 0);
    private static ConcurrentHashMap<String, d> dkb = new ConcurrentHashMap<>();
    private Handler aDv = new Handler(Looper.getMainLooper());
    public volatile boolean cPB = false;
    private Handler djT;
    private Runnable djU;
    public final Set<p> djX = new HashSet();
    private c djY = new c(this, (byte) 0);
    private boolean djZ = false;
    private volatile boolean isInit = false;
    private final Set<o> listeners = new HashSet();

    private AppForegroundDelegate(String str) {
        AppMethodBeat.i(131761);
        AppMethodBeat.o(131761);
    }

    public static AppForegroundDelegate valueOf(String str) {
        AppMethodBeat.i(131760);
        AppForegroundDelegate appForegroundDelegate = (AppForegroundDelegate) Enum.valueOf(AppForegroundDelegate.class, str);
        AppMethodBeat.o(131760);
        return appForegroundDelegate;
    }

    static {
        AppMethodBeat.i(131766);
        AppMethodBeat.o(131766);
    }

    /* access modifiers changed from: package-private */
    public enum a {
        CREATED("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_CREATED"),
        STARTED("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STARTED"),
        RESUMED("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_RESUMED"),
        PAUSED("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_PAUSED"),
        STOPPED("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STOPPED"),
        DESTROY("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_DESTROY");
        
        private String value;

        public static a valueOf(String str) {
            AppMethodBeat.i(131739);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(131739);
            return aVar;
        }

        static {
            AppMethodBeat.i(131741);
            AppMethodBeat.o(131741);
        }

        private a(String str) {
            this.value = str;
        }

        public static a fY(String str) {
            AppMethodBeat.i(131740);
            if (str.equals(STARTED.value)) {
                a aVar = STARTED;
                AppMethodBeat.o(131740);
                return aVar;
            } else if (str.equals(RESUMED.value)) {
                a aVar2 = RESUMED;
                AppMethodBeat.o(131740);
                return aVar2;
            } else if (str.equals(PAUSED.value)) {
                a aVar3 = PAUSED;
                AppMethodBeat.o(131740);
                return aVar3;
            } else if (str.equals(STOPPED.value)) {
                a aVar4 = STOPPED;
                AppMethodBeat.o(131740);
                return aVar4;
            } else {
                AppMethodBeat.o(131740);
                return null;
            }
        }
    }

    public final void d(Application application) {
        AppMethodBeat.i(196963);
        if (this.isInit) {
            Log.e("MicroMsg.AppForegroundDelegate", "has init!");
            AppMethodBeat.o(196963);
            return;
        }
        this.isInit = true;
        HandlerThread handlerThread = new HandlerThread("AppForegroundDelegate");
        handlerThread.start();
        this.djT = new Handler(handlerThread.getLooper());
        if (MMApplicationContext.isMainProcess()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(a.STARTED.value);
            intentFilter.addAction(a.RESUMED.value);
            intentFilter.addAction(a.PAUSED.value);
            intentFilter.addAction(a.STOPPED.value);
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            application.registerReceiver(this.djY.dkn, intentFilter, djS, null);
        } else if (MMApplicationContext.getProcessName().endsWith(":dexopt")) {
            AppMethodBeat.o(196963);
            return;
        } else {
            Uri parse = Uri.parse("content://" + Provider.AUTHORITY + FilePathGenerator.ANDROID_DIR_SEP);
            Bundle bundle = new Bundle();
            try {
                if (MMApplicationContext.isMMProcessExist()) {
                    bundle = application.getContentResolver().call(parse, "isAppForeground", (String) null, (Bundle) null);
                    this.cPB = bundle.getBoolean("isAppForeground");
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppForegroundDelegate", e2, "isMMProcessExist:%s", Boolean.valueOf(MMApplicationContext.isMMProcessExist()));
                if (MMApplicationContext.isPushProcess()) {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1118, 0, 1, true);
                } else {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1118, 1, 1, true);
                }
            }
            final String string = bundle == null ? "" : bundle.getString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME");
            Log.i("MicroMsg.AppForegroundDelegate", "[init] process:%s isAppForeground:%s", MMApplicationContext.getProcessName(), Boolean.valueOf(this.cPB));
            if (this.cPB) {
                this.aDv.post(new Runnable() {
                    /* class com.tencent.mm.app.AppForegroundDelegate.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(131735);
                        Intent intent = new Intent();
                        intent.setAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
                        intent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", string);
                        AppForegroundDelegate.this.djY.dkl.onReceive(MMApplicationContext.getContext(), intent);
                        AppMethodBeat.o(131735);
                    }
                });
            }
        }
        application.registerActivityLifecycleCallbacks(this.djY.dkn);
        application.registerComponentCallbacks(this.djY.dkn);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE");
        intentFilter2.addAction("com.tencent.mm.AppForegroundDelegate.ACTION_DEAD");
        application.registerReceiver(this.djY.dkl, intentFilter2, djS, null);
        AppMethodBeat.o(196963);
    }

    public static String Wb() {
        AppMethodBeat.i(196964);
        if (Util.isNullOrNil(djV)) {
            djV = RF();
        }
        String str = djV;
        AppMethodBeat.o(196964);
        return str;
    }

    public final boolean Wc() {
        return this.cPB;
    }

    public final void a(o oVar) {
        AppMethodBeat.i(131762);
        if (this.cPB) {
            oVar.onAppForeground(this.djY.dkl.activity);
        }
        synchronized (this.listeners) {
            try {
                this.listeners.add(oVar);
            } finally {
                AppMethodBeat.o(131762);
            }
        }
    }

    public final void b(o oVar) {
        AppMethodBeat.i(131763);
        synchronized (this.listeners) {
            try {
                this.listeners.remove(oVar);
            } finally {
                AppMethodBeat.o(131763);
            }
        }
    }

    public static class Provider extends ContentProvider {
        public static final String AUTHORITY = WeChatAuthorities.AUTHORITIES_APPFOREGROUNDDELEGATE_PROVIDER();

        static {
            AppMethodBeat.i(196962);
            AppMethodBeat.o(196962);
        }

        public boolean onCreate() {
            return true;
        }

        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            return null;
        }

        public String getType(Uri uri) {
            return null;
        }

        public Uri insert(Uri uri, ContentValues contentValues) {
            return null;
        }

        public int delete(Uri uri, String str, String[] strArr) {
            return 0;
        }

        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            return 0;
        }

        public Bundle call(String str, String str2, Bundle bundle) {
            AppMethodBeat.i(131758);
            if (str.equals("isAppForeground")) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", AppForegroundDelegate.INSTANCE.djY.dkl.activity);
                bundle2.putBoolean("isAppForeground", AppForegroundDelegate.INSTANCE.cPB);
                AppMethodBeat.o(131758);
                return bundle2;
            }
            Bundle call = super.call(str, str2, bundle);
            AppMethodBeat.o(131758);
            return call;
        }
    }

    /* access modifiers changed from: package-private */
    public class e extends BroadcastReceiver {
        public String activity;

        private e() {
        }

        /* synthetic */ e(AppForegroundDelegate appForegroundDelegate, byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(131756);
            if (intent == null) {
                AppMethodBeat.o(131756);
                return;
            }
            String action = intent.getAction();
            this.activity = intent.getStringExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME");
            long longExtra = intent.getLongExtra("com.tencent.mm.AppForegroundDelegate.DISPATCH_TIME", 0);
            boolean equalsIgnoreCase = "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE".equalsIgnoreCase(action);
            long uptimeMillis = SystemClock.uptimeMillis() - longExtra;
            if (equalsIgnoreCase) {
                AppForegroundDelegate.a(AppForegroundDelegate.this, this.activity, uptimeMillis);
                AppMethodBeat.o(131756);
                return;
            }
            AppForegroundDelegate.b(AppForegroundDelegate.this, this.activity, uptimeMillis);
            AppMethodBeat.o(131756);
        }

        public static void c(boolean z, String str) {
            AppMethodBeat.i(131757);
            Intent intent = new Intent();
            intent.setAction(z ? "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE" : "com.tencent.mm.AppForegroundDelegate.ACTION_DEAD");
            intent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", str);
            intent.putExtra("com.tencent.mm.AppForegroundDelegate.DISPATCH_TIME", SystemClock.uptimeMillis());
            MMApplicationContext.getContext().sendBroadcast(intent, AppForegroundDelegate.djS);
            AppMethodBeat.o(131757);
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements Runnable {
        Handler aDv;
        public boolean daZ;
        e dkl;
        int dkm;

        private b() {
            this.dkm = 0;
            this.daZ = true;
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(196958);
            Log.i("MicroMsg.AppForegroundDelegate", "CheckExceptionRunnable... isValid=%s checkErrorCount=%s isAppForeground=%s", Boolean.valueOf(this.daZ), Integer.valueOf(this.dkm), Boolean.valueOf(AppForegroundDelegate.INSTANCE.cPB));
            if (!this.daZ) {
                AppMethodBeat.o(196958);
                return;
            }
            if (AppForegroundDelegate.INSTANCE.cPB && this.dkm >= 2) {
                Log.e("MicroMsg.AppForegroundDelegate", "check error! isScreenOff is true but isAppForeground is true");
                com.tencent.mm.plugin.report.e.INSTANCE.a(20459, Boolean.valueOf(AppForegroundDelegate.djW), 2);
                if (AppForegroundDelegate.djW) {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1439, 11, 1, false);
                } else {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1439, 12, 1, false);
                }
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1439, 13, 1, false);
                AppForegroundDelegate.dkb.clear();
                if (this.dkl != null) {
                    e.c(false, "fallback");
                    AppMethodBeat.o(196958);
                    return;
                }
            } else if (AppForegroundDelegate.INSTANCE.cPB && this.dkm < 2) {
                this.dkm++;
                this.aDv.postDelayed(this, 5000);
            }
            AppMethodBeat.o(196958);
        }
    }

    /* access modifiers changed from: package-private */
    public final class c {
        e dkl;
        a dkn;

        private c() {
            AppMethodBeat.i(131755);
            this.dkn = new a(this, (byte) 0);
            this.dkl = new e(AppForegroundDelegate.this, (byte) 0);
            AppMethodBeat.o(131755);
        }

        /* synthetic */ c(AppForegroundDelegate appForegroundDelegate, byte b2) {
            this();
        }

        class a extends BroadcastReceiver implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
            private HashSet<String> dko;

            private a() {
                AppMethodBeat.i(131745);
                this.dko = new HashSet<>();
                AppMethodBeat.o(131745);
            }

            /* synthetic */ a(c cVar, byte b2) {
                this();
            }

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(131746);
                if (intent == null) {
                    AppMethodBeat.o(131746);
                    return;
                }
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action) || "android.intent.action.SCREEN_ON".equals(action)) {
                    Log.i("MicroMsg.AppForegroundDelegate", "ACTION_SCREEN:%s isAppForeground:%s", action, Boolean.valueOf(AppForegroundDelegate.this.cPB));
                    if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        AppForegroundDelegate.this.djZ = true;
                        b bVar = AppForegroundDelegate.dka;
                        e eVar = c.this.dkl;
                        Handler handler = AppForegroundDelegate.this.aDv;
                        bVar.dkl = eVar;
                        bVar.aDv = handler;
                        bVar.dkm = 0;
                        bVar.daZ = true;
                        AppForegroundDelegate.this.aDv.postDelayed(AppForegroundDelegate.dka, 5000);
                    } else {
                        AppForegroundDelegate.this.aDv.removeCallbacks(AppForegroundDelegate.dka);
                        AppForegroundDelegate.this.djZ = false;
                    }
                    h.RTc.b(new Runnable() {
                        /* class com.tencent.mm.app.AppForegroundDelegate.c.a.AnonymousClass1 */

                        public final void run() {
                            LinkedList<p> linkedList;
                            AppMethodBeat.i(131742);
                            synchronized (AppForegroundDelegate.this.djX) {
                                try {
                                    linkedList = new LinkedList(AppForegroundDelegate.this.djX);
                                } finally {
                                    AppMethodBeat.o(131742);
                                }
                            }
                            for (p pVar : linkedList) {
                                pVar.cM(AppForegroundDelegate.this.djZ);
                            }
                        }
                    }, "MicroMsg.AppForegroundDelegate");
                    AppMethodBeat.o(131746);
                    return;
                }
                a fY = a.fY(action);
                if (fY == a.STARTED || fY == a.RESUMED) {
                    AppForegroundDelegate.dka.daZ = false;
                    AppForegroundDelegate.this.aDv.removeCallbacks(AppForegroundDelegate.dka);
                }
                if (fY != null) {
                    a(intent.getStringExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME"), intent.getStringExtra(MMApplicationContext.INTENT_PROCESS_NAME), fY);
                }
                AppMethodBeat.o(131746);
            }

            private static void a(a aVar, String str) {
                AppMethodBeat.i(131747);
                Intent intent = new Intent();
                intent.setAction(aVar.value);
                intent.putExtra(MMApplicationContext.INTENT_PROCESS_NAME, Wf());
                intent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", str);
                MMApplicationContext.getContext().sendBroadcast(intent, AppForegroundDelegate.djS);
                AppMethodBeat.o(131747);
            }

            private void a(final String str, String str2, a aVar) {
                AppMethodBeat.i(131748);
                Log.i("MicroMsg.AppForegroundDelegate", "[checkAlive] activityName:%s process:%s action:%s", str, str2, aVar.name());
                AppForegroundDelegate.a(str2, aVar, str);
                if (aVar == a.STARTED) {
                    if (!AppForegroundDelegate.this.cPB) {
                        e.c(true, str);
                    }
                    this.dko.remove(str);
                }
                if ((aVar == a.CREATED || aVar == a.STARTED || aVar == a.RESUMED || aVar == a.PAUSED) && AppForegroundDelegate.this.djU != null) {
                    AppForegroundDelegate.this.aDv.removeCallbacks(AppForegroundDelegate.this.djU);
                    AppForegroundDelegate.this.djU = null;
                }
                if (aVar == a.RESUMED) {
                    AppForegroundDelegate.this.aDv.postDelayed(AppForegroundDelegate.this.djU = new Runnable() {
                        /* class com.tencent.mm.app.AppForegroundDelegate.c.a.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(131743);
                            if (!AppForegroundDelegate.this.cPB) {
                                e.c(true, str);
                            }
                            AppMethodBeat.o(131743);
                        }
                    }, 600);
                    AppMethodBeat.o(131748);
                } else if (aVar == a.PAUSED) {
                    AppForegroundDelegate.this.aDv.postDelayed(AppForegroundDelegate.this.djU = new Runnable() {
                        /* class com.tencent.mm.app.AppForegroundDelegate.c.a.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(131744);
                            if (!AppForegroundDelegate.this.cPB || !a.this.dko.remove(str)) {
                                AppForegroundDelegate.this.djU = null;
                                Log.w("MicroMsg.AppForegroundDelegate", "[PAUSED] delay to check background in stop!");
                                AppMethodBeat.o(131744);
                                return;
                            }
                            e.c(false, str);
                            AppMethodBeat.o(131744);
                        }
                    }, 600);
                    AppMethodBeat.o(131748);
                } else {
                    if (aVar == a.STOPPED || aVar == a.DESTROY) {
                        if (aVar == a.STOPPED) {
                            this.dko.add(str);
                        }
                        if (AppForegroundDelegate.this.djU == null) {
                            AppForegroundDelegate.this.aDv.postDelayed(AppForegroundDelegate.this.djU = new Runnable() {
                                /* class com.tencent.mm.app.AppForegroundDelegate.c.a.AnonymousClass4 */

                                public final void run() {
                                    AppMethodBeat.i(182866);
                                    if (AppForegroundDelegate.this.cPB) {
                                        e.c(false, str);
                                    }
                                    AppMethodBeat.o(182866);
                                }
                            }, 600);
                        }
                    }
                    AppMethodBeat.o(131748);
                }
            }

            private static String Wf() {
                AppMethodBeat.i(196959);
                String str = MMApplicationContext.getProcessName() + "@" + Process.myPid();
                AppMethodBeat.o(196959);
                return str;
            }

            public final void onActivityCreated(Activity activity, Bundle bundle) {
                AppMethodBeat.i(131749);
                String str = activity.getClass().getName() + "@" + activity.hashCode();
                String unused = AppForegroundDelegate.djV = str;
                if (MMApplicationContext.isMainProcess()) {
                    a(str, Wf(), a.CREATED);
                    AppMethodBeat.o(131749);
                    return;
                }
                a(a.CREATED, str);
                AppMethodBeat.o(131749);
            }

            public final void onActivityStarted(Activity activity) {
                AppMethodBeat.i(131750);
                String str = activity.getClass().getName() + "@" + activity.hashCode();
                if (MMApplicationContext.isMainProcess()) {
                    a(str, Wf(), a.STARTED);
                    AppMethodBeat.o(131750);
                    return;
                }
                a(a.STARTED, str);
                AppMethodBeat.o(131750);
            }

            public final void onActivityResumed(Activity activity) {
                AppMethodBeat.i(131751);
                String str = activity.getClass().getName() + "@" + activity.hashCode();
                if (MMApplicationContext.isMainProcess()) {
                    a(str, Wf(), a.RESUMED);
                    AppMethodBeat.o(131751);
                    return;
                }
                a(a.RESUMED, str);
                AppMethodBeat.o(131751);
            }

            public final void onActivityPaused(Activity activity) {
                AppMethodBeat.i(131752);
                String str = activity.getClass().getName() + "@" + activity.hashCode();
                if (MMApplicationContext.isMainProcess()) {
                    a(str, Wf(), a.PAUSED);
                    AppMethodBeat.o(131752);
                    return;
                }
                a(a.PAUSED, str);
                AppMethodBeat.o(131752);
            }

            public final void onActivityStopped(Activity activity) {
                AppMethodBeat.i(131753);
                String str = activity.getClass().getName() + "@" + activity.hashCode();
                if (MMApplicationContext.isMainProcess()) {
                    a(str, Wf(), a.STOPPED);
                    AppMethodBeat.o(131753);
                    return;
                }
                a(a.STOPPED, str);
                AppMethodBeat.o(131753);
            }

            public final void onActivityDestroyed(Activity activity) {
                AppMethodBeat.i(131754);
                String str = activity.getClass().getName() + "@" + activity.hashCode();
                if (MMApplicationContext.isMainProcess()) {
                    a(str, Wf(), a.DESTROY);
                    AppMethodBeat.o(131754);
                    return;
                }
                a(a.DESTROY, str);
                AppMethodBeat.o(131754);
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onConfigurationChanged(Configuration configuration) {
            }

            public final void onLowMemory() {
            }

            public final void onTrimMemory(int i2) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class d {
        LinkedList<String> dkr = new LinkedList<>();

        public d(String str, a aVar) {
            AppMethodBeat.i(196960);
            a(str, aVar);
            AppMethodBeat.o(196960);
        }

        public final boolean a(String str, a aVar) {
            AppMethodBeat.i(196961);
            String str2 = str + "#" + aVar;
            if (!this.dkr.contains(str2)) {
                if (aVar == a.RESUMED) {
                    this.dkr.add(str2);
                } else if (aVar == a.PAUSED) {
                    this.dkr.remove(str + "#" + a.RESUMED);
                }
                AppMethodBeat.o(196961);
                return true;
            }
            AppMethodBeat.o(196961);
            return false;
        }
    }

    private static String RF() {
        AppMethodBeat.i(196965);
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(invoke);
            if (arrayMap.size() <= 0) {
                AppMethodBeat.o(196965);
                return null;
            }
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                    declaredField3.setAccessible(true);
                    String canonicalName = ((Activity) declaredField3.get(obj)).getClass().getCanonicalName();
                    AppMethodBeat.o(196965);
                    return canonicalName;
                }
            }
            AppMethodBeat.o(196965);
            return null;
        } catch (Exception e2) {
        }
    }

    static /* synthetic */ void a(AppForegroundDelegate appForegroundDelegate, final String str, long j2) {
        AppMethodBeat.i(196966);
        if (appForegroundDelegate.cPB || !appForegroundDelegate.isInit) {
            AppMethodBeat.o(196966);
            return;
        }
        Log.i("MicroMsg.AppForeground", "onAppForeground... activity[%s] expired[%sms]", str, Long.valueOf(j2));
        appForegroundDelegate.cPB = true;
        appForegroundDelegate.djT.post(new Runnable() {
            /* class com.tencent.mm.app.AppForegroundDelegate.AnonymousClass2 */

            public final void run() {
                LinkedList<o> linkedList;
                AppMethodBeat.i(131736);
                com.tencent.mm.kernel.a.c.aAu().g(true, str);
                synchronized (AppForegroundDelegate.this.listeners) {
                    try {
                        linkedList = new LinkedList(AppForegroundDelegate.this.listeners);
                    } finally {
                        AppMethodBeat.o(131736);
                    }
                }
                for (o oVar : linkedList) {
                    oVar.onAppForeground(str);
                }
            }
        });
        AppMethodBeat.o(196966);
    }

    static /* synthetic */ void b(AppForegroundDelegate appForegroundDelegate, final String str, long j2) {
        boolean z;
        AppMethodBeat.i(196967);
        if (appForegroundDelegate.cPB && appForegroundDelegate.isInit) {
            if (!djW) {
                z = true;
            } else {
                LinkedList linkedList = new LinkedList();
                List<String> aliveProcess = MMApplicationContext.getAliveProcess();
                z = true;
                for (Map.Entry<String, d> entry : dkb.entrySet()) {
                    if (!aliveProcess.contains(entry.getKey())) {
                        linkedList.add(entry.getKey());
                    } else if (entry.getValue().dkr.size() > 0) {
                        Log.i("MicroMsg.AppForegroundDelegate", "[isFallbackBackgroundValid] printRecord=%s", entry.getValue().dkr.toString());
                        z = false;
                    }
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    dkb.remove((String) it.next());
                }
            }
            if (z) {
                appForegroundDelegate.cPB = false;
                Log.i("MicroMsg.AppForeground", "onAppBackground... activity[%s] expired[%sms]", str, Long.valueOf(j2));
                appForegroundDelegate.djT.post(new Runnable() {
                    /* class com.tencent.mm.app.AppForegroundDelegate.AnonymousClass3 */

                    public final void run() {
                        LinkedList<o> linkedList;
                        AppMethodBeat.i(131737);
                        com.tencent.mm.kernel.a.c.aAu().g(false, str);
                        synchronized (AppForegroundDelegate.this.listeners) {
                            try {
                                linkedList = new LinkedList(AppForegroundDelegate.this.listeners);
                            } finally {
                                AppMethodBeat.o(131737);
                            }
                        }
                        for (o oVar : linkedList) {
                            oVar.onAppBackground(str);
                        }
                    }
                });
                AppMethodBeat.o(196967);
                return;
            }
        }
        AppMethodBeat.o(196967);
    }

    static /* synthetic */ void a(String str, a aVar, String str2) {
        AppMethodBeat.i(196968);
        if (aVar == a.RESUMED) {
            d dVar = dkb.get(str);
            if (dVar == null) {
                dkb.put(str, new d(str2, aVar));
                AppMethodBeat.o(196968);
                return;
            }
            if (!dVar.a(str2, aVar)) {
                Log.e("MicroMsg.AppForegroundDelegate", "[countState] activityName=%s duplicate resume", str2);
            }
            AppMethodBeat.o(196968);
            return;
        }
        if (aVar == a.PAUSED) {
            d dVar2 = dkb.get(str);
            if (dVar2 == null) {
                dkb.put(str, new d(str2, aVar));
                AppMethodBeat.o(196968);
                return;
            } else if (!dVar2.a(str2, aVar)) {
                Log.e("MicroMsg.AppForegroundDelegate", "[countState] activityName=%s duplicate pause", str2);
            }
        }
        AppMethodBeat.o(196968);
    }
}
