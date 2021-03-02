package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.components.c;
import com.google.firebase.components.k;
import com.google.firebase.components.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

public class a {
    private static final List<String> bKj = Arrays.asList("com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId");
    private static final List<String> bKk = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> bKl = Arrays.asList("com.google.android.gms.measurement.AppMeasurement");
    private static final List<String> bKm = Arrays.asList(new String[0]);
    private static final Set<String> bKn = Collections.emptySet();
    @GuardedBy("sLock")
    static final Map<String, a> bKo = new android.support.v4.e.a();
    private static final Object sLock = new Object();
    private final Context bKp;
    private final b bKq;
    private final n bKr;
    private final AtomicBoolean bKs = new AtomicBoolean(false);
    private final AtomicBoolean bKt = new AtomicBoolean();
    private final List<Object> bKu = new CopyOnWriteArrayList();
    private final List<Object> bKv = new CopyOnWriteArrayList();
    private AbstractC0120a bKw;
    private final String mName;
    private final List<Object> zzm = new CopyOnWriteArrayList();

    @KeepForSdk
    /* renamed from: com.google.firebase.a$a  reason: collision with other inner class name */
    public interface AbstractC0120a {
    }

    static {
        AppMethodBeat.i(4062);
        AppMethodBeat.o(4062);
    }

    private static a a(Context context, b bVar, String str) {
        a aVar;
        AppMethodBeat.i(4052);
        com.google.firebase.b.b.yx();
        if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
            BackgroundDetector.initialize((Application) context.getApplicationContext());
            BackgroundDetector.getInstance().addListener(new c());
        }
        String trim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (sLock) {
            try {
                Preconditions.checkState(!bKo.containsKey(trim), new StringBuilder(String.valueOf(trim).length() + 33).append("FirebaseApp name ").append(trim).append(" already exists!").toString());
                Preconditions.checkNotNull(context, "Application context cannot be null.");
                aVar = new a(context, trim, bVar);
                bKo.put(trim, aVar);
            } catch (Throwable th) {
                AppMethodBeat.o(4052);
                throw th;
            }
        }
        com.google.firebase.b.b.yy();
        aVar.zzc();
        AppMethodBeat.o(4052);
        return aVar;
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(4061);
        aVar.zzc();
        AppMethodBeat.o(4061);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(Class<T> cls, T t, Iterable<String> iterable, boolean z) {
        AppMethodBeat.i(4060);
        for (String str : iterable) {
            if (z) {
                try {
                    if (!bKm.contains(str)) {
                    }
                } catch (ClassNotFoundException e2) {
                    if (bKn.contains(str)) {
                        IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(str).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                        AppMethodBeat.o(4060);
                        throw illegalStateException;
                    }
                    String.valueOf(str).concat(" is not linked. Skipping initialization.");
                } catch (NoSuchMethodException e3) {
                    IllegalStateException illegalStateException2 = new IllegalStateException(String.valueOf(str).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                    AppMethodBeat.o(4060);
                    throw illegalStateException2;
                } catch (InvocationTargetException e4) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e4);
                } catch (IllegalAccessException e5) {
                    String valueOf = String.valueOf(str);
                    Log.wtf("FirebaseApp", valueOf.length() != 0 ? "Failed to initialize ".concat(valueOf) : new String("Failed to initialize "), e5);
                }
            }
            Method method = Class.forName(str).getMethod("getInstance", cls);
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, t);
            }
        }
        AppMethodBeat.o(4060);
    }

    private String getName() {
        AppMethodBeat.i(4045);
        zza();
        String str = this.mName;
        AppMethodBeat.o(4045);
        return str;
    }

    public static a xS() {
        a aVar;
        AppMethodBeat.i(4050);
        synchronized (sLock) {
            try {
                aVar = bKo.get("[DEFAULT]");
                if (aVar == null) {
                    String myProcessName = ProcessUtils.getMyProcessName();
                    IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(myProcessName).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(myProcessName).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
                    AppMethodBeat.o(4050);
                    throw illegalStateException;
                }
            } finally {
                AppMethodBeat.o(4050);
            }
        }
        return aVar;
    }

    @KeepForSdk
    public static void xT() {
        AppMethodBeat.i(4053);
        synchronized (sLock) {
            try {
                ArrayList arrayList = new ArrayList(bKo.values());
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    a aVar = (a) obj;
                    if (aVar.bKs.get()) {
                        aVar.xV();
                    }
                }
            } finally {
                AppMethodBeat.o(4053);
            }
        }
    }

    @VisibleForTesting
    @KeepForSdk
    private boolean xU() {
        AppMethodBeat.i(4057);
        boolean equals = "[DEFAULT]".equals(getName());
        AppMethodBeat.o(4057);
        return equals;
    }

    private final void xV() {
        AppMethodBeat.i(4058);
        Iterator<Object> it = this.zzm.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(4058);
    }

    private final void zza() {
        AppMethodBeat.i(4056);
        Preconditions.checkState(!this.bKt.get(), "FirebaseApp was deleted");
        AppMethodBeat.o(4056);
    }

    private final void zzc() {
        AppMethodBeat.i(4059);
        boolean V = android.support.v4.content.b.V(this.bKp);
        if (V) {
            b.am(this.bKp);
        } else {
            this.bKr.bd(xU());
        }
        a(a.class, this, bKj, V);
        if (xU()) {
            a(a.class, this, bKk, V);
            a(Context.class, this.bKp, bKl, V);
        }
        AppMethodBeat.o(4059);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(4047);
        if (!(obj instanceof a)) {
            AppMethodBeat.o(4047);
            return false;
        }
        boolean equals = this.mName.equals(((a) obj).getName());
        AppMethodBeat.o(4047);
        return equals;
    }

    public final Context getApplicationContext() {
        AppMethodBeat.i(4044);
        zza();
        Context context = this.bKp;
        AppMethodBeat.o(4044);
        return context;
    }

    public int hashCode() {
        AppMethodBeat.i(4048);
        int hashCode = this.mName.hashCode();
        AppMethodBeat.o(4048);
        return hashCode;
    }

    public String toString() {
        AppMethodBeat.i(4049);
        String toStringHelper = Objects.toStringHelper(this).add("name", this.mName).add("options", this.bKq).toString();
        AppMethodBeat.o(4049);
        return toStringHelper;
    }

    public final b xR() {
        AppMethodBeat.i(4046);
        zza();
        b bVar = this.bKq;
        AppMethodBeat.o(4046);
        return bVar;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(24)
    public static class b extends BroadcastReceiver {
        private static AtomicReference<b> bKx = new AtomicReference<>();
        private final Context bKp;

        static {
            AppMethodBeat.i(4043);
            AppMethodBeat.o(4043);
        }

        private b(Context context) {
            this.bKp = context;
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(4041);
            synchronized (a.sLock) {
                try {
                    for (a aVar : a.bKo.values()) {
                        a.a(aVar);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(4041);
                    throw th;
                }
            }
            this.bKp.unregisterReceiver(this);
            AppMethodBeat.o(4041);
        }

        static /* synthetic */ void am(Context context) {
            AppMethodBeat.i(4042);
            if (bKx.get() == null) {
                b bVar = new b(context);
                if (bKx.compareAndSet(null, bVar)) {
                    context.registerReceiver(bVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
            AppMethodBeat.o(4042);
        }
    }

    public static a al(Context context) {
        a a2;
        AppMethodBeat.i(4051);
        synchronized (sLock) {
            try {
                if (bKo.containsKey("[DEFAULT]")) {
                    a2 = xS();
                } else {
                    b an = b.an(context);
                    if (an == null) {
                        a2 = null;
                        AppMethodBeat.o(4051);
                    } else {
                        a2 = a(context, an, "[DEFAULT]");
                        AppMethodBeat.o(4051);
                    }
                }
            } finally {
                AppMethodBeat.o(4051);
            }
        }
        return a2;
    }

    @KeepForSdk
    public final <T> T y(Class<T> cls) {
        AppMethodBeat.i(4054);
        zza();
        T t = (T) c.a(this.bKr, cls);
        AppMethodBeat.o(4054);
        return t;
    }

    private a(Context context, String str, b bVar) {
        AppMethodBeat.i(4055);
        this.bKp = (Context) Preconditions.checkNotNull(context);
        this.mName = Preconditions.checkNotEmpty(str);
        this.bKq = (b) Preconditions.checkNotNull(bVar);
        this.bKw = new com.google.firebase.b.a();
        k kVar = new k(this.bKp);
        this.bKr = new n(k.z(kVar.bKR.ap(kVar.mContext)), com.google.firebase.components.a.a(Context.class, this.bKp), com.google.firebase.components.a.a(a.class, this), com.google.firebase.components.a.a(b.class, this.bKq));
        AppMethodBeat.o(4055);
    }
}
