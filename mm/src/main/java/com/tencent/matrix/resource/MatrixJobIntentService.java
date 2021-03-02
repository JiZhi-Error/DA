package com.tencent.matrix.resource;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class MatrixJobIntentService extends Service {
    static final HashMap<ComponentName, h> GL = new HashMap<>();
    static final Object sLock = new Object();
    boolean GJ = false;
    final ArrayList<d> GK;
    a cWA;
    b cWy;
    h cWz;
    boolean mDestroyed = false;
    boolean mStopped = false;

    /* access modifiers changed from: package-private */
    public interface b {
        e ST();

        IBinder SU();
    }

    /* access modifiers changed from: package-private */
    public interface e {
        void complete();

        Intent getIntent();
    }

    /* access modifiers changed from: protected */
    public abstract void l(Intent intent);

    /* access modifiers changed from: package-private */
    public static abstract class h {
        boolean cWN;
        int cWO;
        final ComponentName mComponentName;

        /* access modifiers changed from: package-private */
        public abstract void m(Intent intent);

        h(ComponentName componentName) {
            this.mComponentName = componentName;
        }

        /* access modifiers changed from: package-private */
        public final void it(int i2) {
            if (!this.cWN) {
                this.cWN = true;
                this.cWO = i2;
            } else if (this.cWO != i2) {
                throw new IllegalArgumentException("Given job ID " + i2 + " is different than previous " + this.cWO);
            }
        }

        public void SV() {
        }

        public void SW() {
        }

        public void SX() {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c extends h {
        private final PowerManager.WakeLock cWC;
        private final PowerManager.WakeLock cWD;
        boolean cWE;
        boolean cWF;
        private final Context mContext;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.mContext = context.getApplicationContext();
            if (this.mContext.checkPermission("android.permission.WAKE_LOCK", Process.myPid(), Process.myUid()) == 0) {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                this.cWC = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
                this.cWC.setReferenceCounted(false);
                this.cWD = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
                this.cWD.setReferenceCounted(false);
                return;
            }
            com.tencent.matrix.g.c.w("Matrix.JobIntentService", "it would be better to grant WAKE_LOCK permission to your app so that tinker can use WakeLock to keep system awake.", new Object[0]);
            this.cWD = null;
            this.cWC = null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.MatrixJobIntentService.h
        public final void m(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.mComponentName);
            try {
                if (this.mContext.startService(intent2) != null) {
                    synchronized (this) {
                        if (!this.cWE) {
                            this.cWE = true;
                            if (!this.cWF && this.cWC != null) {
                                this.cWC.acquire(Util.MILLSECONDS_OF_MINUTE);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                com.tencent.matrix.g.c.printErrStackTrace("Matrix.JobIntentService", th, "Exception occurred.", new Object[0]);
            }
        }

        @Override // com.tencent.matrix.resource.MatrixJobIntentService.h
        public final void SV() {
            synchronized (this) {
                this.cWE = false;
            }
        }

        @Override // com.tencent.matrix.resource.MatrixJobIntentService.h
        public final void SW() {
            synchronized (this) {
                if (!this.cWF) {
                    this.cWF = true;
                    if (this.cWD != null) {
                        this.cWD.acquire(600000);
                    }
                    if (this.cWC != null) {
                        this.cWC.release();
                    }
                }
            }
        }

        @Override // com.tencent.matrix.resource.MatrixJobIntentService.h
        public final void SX() {
            synchronized (this) {
                if (this.cWF) {
                    if (this.cWE && this.cWC != null) {
                        this.cWC.acquire(Util.MILLSECONDS_OF_MINUTE);
                    }
                    this.cWF = false;
                    if (this.cWD != null) {
                        this.cWD.release();
                    }
                }
            }
        }
    }

    static final class f extends JobServiceEngine implements b {
        final MatrixJobIntentService cWH;
        JobParameters cWI;
        final Object mLock = new Object();

        final class a implements e {
            final JobWorkItem cWJ;

            a(JobWorkItem jobWorkItem) {
                this.cWJ = jobWorkItem;
            }

            @Override // com.tencent.matrix.resource.MatrixJobIntentService.e
            public final Intent getIntent() {
                return this.cWJ.getIntent();
            }

            @Override // com.tencent.matrix.resource.MatrixJobIntentService.e
            public final void complete() {
                synchronized (f.this.mLock) {
                    if (f.this.cWI != null) {
                        f.this.cWI.completeWork(this.cWJ);
                    }
                }
            }
        }

        f(MatrixJobIntentService matrixJobIntentService) {
            super(matrixJobIntentService);
            this.cWH = matrixJobIntentService;
        }

        @Override // com.tencent.matrix.resource.MatrixJobIntentService.b
        public final IBinder SU() {
            return getBinder();
        }

        public final boolean onStartJob(JobParameters jobParameters) {
            synchronized (this.mLock) {
                this.cWI = jobParameters;
            }
            this.cWH.cF(false);
            return true;
        }

        public final boolean onStopJob(JobParameters jobParameters) {
            MatrixJobIntentService matrixJobIntentService = this.cWH;
            if (matrixJobIntentService.cWA != null) {
                matrixJobIntentService.cWA.cancel(matrixJobIntentService.GJ);
            }
            matrixJobIntentService.mStopped = true;
            synchronized (this.mLock) {
                this.cWI = null;
            }
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
            if (r1.getIntent() == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
            r1.getIntent().setExtrasClassLoader(r6.cWH.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            return new com.tencent.matrix.resource.MatrixJobIntentService.f.a(r6, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r1 == null) goto L_?;
         */
        @Override // com.tencent.matrix.resource.MatrixJobIntentService.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.matrix.resource.MatrixJobIntentService.e ST() {
            /*
                r6 = this;
                r0 = 0
                java.lang.Object r2 = r6.mLock
                monitor-enter(r2)
                android.app.job.JobParameters r1 = r6.cWI     // Catch:{ all -> 0x003b }
                if (r1 != 0) goto L_0x000a
                monitor-exit(r2)     // Catch:{ all -> 0x003b }
            L_0x0009:
                return r0
            L_0x000a:
                android.app.job.JobParameters r1 = r6.cWI     // Catch:{ Throwable -> 0x002c }
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ Throwable -> 0x002c }
                monitor-exit(r2)
                if (r1 == 0) goto L_0x0009
                android.content.Intent r2 = r1.getIntent()
                if (r2 == 0) goto L_0x0009
                android.content.Intent r0 = r1.getIntent()
                com.tencent.matrix.resource.MatrixJobIntentService r2 = r6.cWH
                java.lang.ClassLoader r2 = r2.getClassLoader()
                r0.setExtrasClassLoader(r2)
                com.tencent.matrix.resource.MatrixJobIntentService$f$a r0 = new com.tencent.matrix.resource.MatrixJobIntentService$f$a
                r0.<init>(r1)
                goto L_0x0009
            L_0x002c:
                r1 = move-exception
                java.lang.String r3 = "JobServiceEngineImpl"
                java.lang.String r4 = "exception occurred."
                r5 = 0
                java.lang.Object[] r5 = new java.lang.Object[r5]
                com.tencent.matrix.g.c.printErrStackTrace(r3, r1, r4, r5)
                monitor-exit(r2)
                goto L_0x0009
            L_0x003b:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.resource.MatrixJobIntentService.f.ST():com.tencent.matrix.resource.MatrixJobIntentService$e");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class g extends h {
        private final JobInfo cWL;
        private final JobScheduler cWM;

        g(Context context, ComponentName componentName, int i2) {
            super(componentName);
            it(i2);
            this.cWL = new JobInfo.Builder(i2, this.mComponentName).setOverrideDeadline(0).build();
            this.cWM = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.matrix.resource.MatrixJobIntentService.h
        public final void m(Intent intent) {
            this.cWM.enqueue(this.cWL, new JobWorkItem(intent));
        }
    }

    /* access modifiers changed from: package-private */
    public final class d implements e {
        final int cWG;
        final Intent mIntent;

        d(Intent intent, int i2) {
            this.mIntent = intent;
            this.cWG = i2;
        }

        @Override // com.tencent.matrix.resource.MatrixJobIntentService.e
        public final Intent getIntent() {
            return this.mIntent;
        }

        @Override // com.tencent.matrix.resource.MatrixJobIntentService.e
        public final void complete() {
            MatrixJobIntentService.this.stopSelf(this.cWG);
        }
    }

    /* access modifiers changed from: package-private */
    public final class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onCancelled(Void r2) {
            MatrixJobIntentService.this.SS();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(Void r2) {
            MatrixJobIntentService.this.SS();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ Void doInBackground(Void[] voidArr) {
            while (true) {
                e ST = MatrixJobIntentService.this.ST();
                if (ST == null) {
                    return null;
                }
                MatrixJobIntentService.this.l(ST.getIntent());
                ST.complete();
            }
        }
    }

    public MatrixJobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.GK = null;
        } else {
            this.GK = new ArrayList<>();
        }
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.cWy = new f(this);
            this.cWz = null;
            return;
        }
        this.cWy = null;
        this.cWz = a((Context) this, new ComponentName(this, getClass()), false, 0);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (this.GK == null) {
            return 2;
        }
        this.cWz.SV();
        synchronized (this.GK) {
            ArrayList<d> arrayList = this.GK;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i3));
            cF(true);
        }
        return 3;
    }

    public IBinder onBind(Intent intent) {
        if (this.cWy != null) {
            return this.cWy.SU();
        }
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.GK != null) {
            synchronized (this.GK) {
                this.mDestroyed = true;
                this.cWz.SX();
            }
        }
    }

    public static void a(Context context, Class cls, int i2, Intent intent) {
        a(context, new ComponentName(context, cls), i2, intent);
    }

    private static void a(Context context, ComponentName componentName, int i2, Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (sLock) {
            h a2 = a(context, componentName, true, i2);
            a2.it(i2);
            a2.m(intent);
        }
    }

    private static h a(Context context, ComponentName componentName, boolean z, int i2) {
        h hVar = GL.get(componentName);
        if (hVar == null) {
            if (Build.VERSION.SDK_INT < 26) {
                hVar = new c(context, componentName);
            } else if (!z) {
                throw new IllegalArgumentException("Can't be here without a job id");
            } else {
                hVar = new g(context, componentName, i2);
            }
            GL.put(componentName, hVar);
        }
        return hVar;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(11)
    public final void cF(boolean z) {
        if (this.cWA == null) {
            this.cWA = new a();
            if (this.cWz != null && z) {
                this.cWz.SW();
            }
            this.cWA.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void SS() {
        if (this.GK != null) {
            synchronized (this.GK) {
                this.cWA = null;
                if (this.GK != null && !this.GK.isEmpty()) {
                    cF(false);
                } else if (!this.mDestroyed) {
                    this.cWz.SX();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final e ST() {
        if (this.cWy != null) {
            return this.cWy.ST();
        }
        if (this.GK == null) {
            return null;
        }
        synchronized (this.GK) {
            if (this.GK == null || this.GK.isEmpty()) {
                return null;
            }
            return this.GK.remove(0);
        }
    }
}
