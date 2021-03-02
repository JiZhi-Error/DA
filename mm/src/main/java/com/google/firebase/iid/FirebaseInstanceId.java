package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseInstanceId {
    private static final long bLf = TimeUnit.HOURS.toSeconds(8);
    static p bLg;
    @VisibleForTesting
    @GuardedBy("FirebaseInstanceId.class")
    private static ScheduledThreadPoolExecutor bLh;
    final a bLi;
    final f bLj;
    final ae bLk;
    final i bLl;
    @GuardedBy("this")
    private boolean bLm;
    @GuardedBy("this")
    private boolean bLn;

    static {
        AppMethodBeat.i(4142);
        AppMethodBeat.o(4142);
    }

    FirebaseInstanceId(a aVar) {
        this(aVar, new f(aVar.getApplicationContext()));
        AppMethodBeat.i(4126);
        AppMethodBeat.o(4126);
    }

    private FirebaseInstanceId(a aVar, f fVar) {
        AppMethodBeat.i(4127);
        this.bLl = new i();
        this.bLm = false;
        if (f.b(aVar) == null) {
            IllegalStateException illegalStateException = new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
            AppMethodBeat.o(4127);
            throw illegalStateException;
        }
        synchronized (FirebaseInstanceId.class) {
            try {
                if (bLg == null) {
                    bLg = new p(aVar.getApplicationContext());
                }
            } finally {
                AppMethodBeat.o(4127);
            }
        }
        this.bLi = aVar;
        this.bLj = fVar;
        this.bLk = new ab(aVar, this, fVar);
        this.bLn = yi();
        if (yk()) {
            yd();
        }
    }

    static <T> T a(Task<T> task) {
        AppMethodBeat.i(4135);
        try {
            T t = (T) Tasks.await(task);
            AppMethodBeat.o(4135);
            return t;
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                IOException iOException = (IOException) cause;
                AppMethodBeat.o(4135);
                throw iOException;
            } else if (cause instanceof RuntimeException) {
                IOException iOException2 = new IOException(cause);
                AppMethodBeat.o(4135);
                throw iOException2;
            } else {
                IOException iOException3 = new IOException(e2);
                AppMethodBeat.o(4135);
                throw iOException3;
            }
        } catch (InterruptedException e3) {
            IOException iOException4 = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.o(4135);
            throw iOException4;
        }
    }

    static void b(Runnable runnable, long j2) {
        AppMethodBeat.i(TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITH_CORE);
        synchronized (FirebaseInstanceId.class) {
            try {
                if (bLh == null) {
                    bLh = new ScheduledThreadPoolExecutor(1);
                }
                bLh.schedule(runnable, j2, TimeUnit.SECONDS);
            } finally {
                AppMethodBeat.o(TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITH_CORE);
            }
        }
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(a aVar) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            AppMethodBeat.i(4125);
            firebaseInstanceId = (FirebaseInstanceId) aVar.y(FirebaseInstanceId.class);
            AppMethodBeat.o(4125);
        }
        return firebaseInstanceId;
    }

    public static FirebaseInstanceId yc() {
        AppMethodBeat.i(4124);
        FirebaseInstanceId instance = getInstance(a.xS());
        AppMethodBeat.o(4124);
        return instance;
    }

    static p yf() {
        return bLg;
    }

    static boolean yg() {
        AppMethodBeat.i(4137);
        if (Log.isLoggable("FirebaseInstanceId", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3))) {
            AppMethodBeat.o(4137);
            return true;
        }
        AppMethodBeat.o(4137);
        return false;
    }

    private final boolean yi() {
        ApplicationInfo applicationInfo;
        AppMethodBeat.i(4139);
        Context applicationContext = this.bLi.getApplicationContext();
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
        if (sharedPreferences.contains("auto_init")) {
            boolean z = sharedPreferences.getBoolean("auto_init", true);
            AppMethodBeat.o(4139);
            return z;
        }
        try {
            PackageManager packageManager = applicationContext.getPackageManager();
            if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled"))) {
                boolean z2 = applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled");
                AppMethodBeat.o(4139);
                return z2;
            }
        } catch (PackageManager.NameNotFoundException e2) {
        }
        boolean yj = yj();
        AppMethodBeat.o(4139);
        return yj;
    }

    private final boolean yj() {
        AppMethodBeat.i(4140);
        try {
            Class.forName("com.google.firebase.messaging.a");
            AppMethodBeat.o(4140);
            return true;
        } catch (ClassNotFoundException e2) {
            Context applicationContext = this.bLi.getApplicationContext();
            Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
            intent.setPackage(applicationContext.getPackageName());
            ResolveInfo resolveService = applicationContext.getPackageManager().resolveService(intent, 0);
            if (resolveService == null || resolveService.serviceInfo == null) {
                AppMethodBeat.o(4140);
                return false;
            }
            AppMethodBeat.o(4140);
            return true;
        }
    }

    @VisibleForTesting
    private synchronized boolean yk() {
        return this.bLn;
    }

    public final String getToken() {
        AppMethodBeat.i(4133);
        q ye = ye();
        if (ye == null || ye.bS(this.bLj.yn())) {
            startSync();
        }
        if (ye != null) {
            String str = ye.bLU;
            AppMethodBeat.o(4133);
            return str;
        }
        AppMethodBeat.o(4133);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void startSync() {
        AppMethodBeat.i(4129);
        if (!this.bLm) {
            zza(0);
        }
        AppMethodBeat.o(4129);
    }

    public final void yd() {
        AppMethodBeat.i(4128);
        q ye = ye();
        if (ye == null || ye.bS(this.bLj.yn()) || bLg.ys() != null) {
            startSync();
        }
        AppMethodBeat.o(4128);
    }

    /* access modifiers changed from: package-private */
    public final q ye() {
        AppMethodBeat.i(4134);
        q c2 = bLg.c("", f.b(this.bLi), "*");
        AppMethodBeat.o(4134);
        return c2;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void yh() {
        AppMethodBeat.i(4138);
        bLg.zzag();
        if (yk()) {
            startSync();
        }
        AppMethodBeat.o(4138);
    }

    @VisibleForTesting
    public final synchronized void yl() {
        AppMethodBeat.i(4141);
        SharedPreferences.Editor edit = this.bLi.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
        edit.putBoolean("auto_init", true);
        edit.apply();
        if (!this.bLn) {
            yd();
        }
        this.bLn = true;
        AppMethodBeat.o(4141);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(long j2) {
        AppMethodBeat.i(4130);
        b(new r(this, this.bLj, Math.min(Math.max(30L, j2 << 1), bLf)), j2);
        this.bLm = true;
        AppMethodBeat.o(4130);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(boolean z) {
        this.bLm = z;
    }

    public static String zzf() {
        AppMethodBeat.i(TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE);
        String a2 = f.a(bLg.bP("").bMC);
        AppMethodBeat.o(TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final String b(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(4136);
        ab abVar = (ab) this.bLk;
        abVar.c(str, str2, bundle);
        String j2 = abVar.j(abVar.bMx.h(bundle));
        AppMethodBeat.o(4136);
        return j2;
    }
}
