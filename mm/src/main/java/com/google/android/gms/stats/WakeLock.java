package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class WakeLock {
    private static ScheduledExecutorService zzaeg;
    private static Configuration zzaeh = new zza();
    private final PowerManager.WakeLock zzadv;
    private WorkSource zzadw;
    private String zzadx;
    private final int zzady;
    private final String zzadz;
    private final String zzaea;
    private final String zzaeb;
    private boolean zzaec;
    private final Map<String, Integer[]> zzaed;
    private int zzaee;
    private AtomicInteger zzaef;
    private final Context zzjp;

    public interface Configuration {
        long getMaximumTimeout(String str, String str2);

        boolean isWorkChainsEnabled();
    }

    public class HeldLock {
        private boolean zzaek;
        private Future zzael;
        private final String zzaem;

        private HeldLock(String str) {
            this.zzaek = true;
            this.zzaem = str;
        }

        /* synthetic */ HeldLock(WakeLock wakeLock, String str, zza zza) {
            this(str);
        }

        public void finalize() {
            AppMethodBeat.i(73446);
            if (this.zzaek) {
                String valueOf = String.valueOf(this.zzaem);
                if (valueOf.length() != 0) {
                    "HeldLock finalized while still holding the WakeLock! Reason: ".concat(valueOf);
                } else {
                    new String("HeldLock finalized while still holding the WakeLock! Reason: ");
                }
                release(0);
            }
            AppMethodBeat.o(73446);
        }

        public void release() {
            AppMethodBeat.i(73444);
            release(0);
            AppMethodBeat.o(73444);
        }

        public synchronized void release(int i2) {
            AppMethodBeat.i(73445);
            if (!this.zzaek) {
                AppMethodBeat.o(73445);
            } else {
                this.zzaek = false;
                if (this.zzael != null) {
                    this.zzael.cancel(false);
                    this.zzael = null;
                }
                WakeLock.zza(WakeLock.this, this.zzaem, i2);
                AppMethodBeat.o(73445);
            }
        }
    }

    static {
        AppMethodBeat.i(73473);
        AppMethodBeat.o(73473);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WakeLock(Context context, int i2, @Nonnull String str) {
        this(context, i2, str, null, context == null ? null : context.getPackageName());
        AppMethodBeat.i(73447);
        AppMethodBeat.o(73447);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WakeLock(Context context, int i2, @Nonnull String str, @Nullable String str2) {
        this(context, i2, str, str2, context == null ? null : context.getPackageName());
        AppMethodBeat.i(73448);
        AppMethodBeat.o(73448);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public WakeLock(Context context, int i2, @Nonnull String str, @Nullable String str2, @Nonnull String str3) {
        this(context, i2, str, str2, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public WakeLock(Context context, int i2, @Nonnull String str, @Nullable String str2, @Nonnull String str3, @Nullable String str4) {
        AppMethodBeat.i(73449);
        this.zzaec = true;
        this.zzaed = new HashMap();
        this.zzaef = new AtomicInteger(0);
        Preconditions.checkNotEmpty(str, "Wake lock name can NOT be empty");
        this.zzady = i2;
        this.zzaea = str2;
        this.zzaeb = str4;
        this.zzjp = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf("*gcore*:");
            String valueOf2 = String.valueOf(str);
            this.zzadz = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            this.zzadz = str;
        }
        this.zzadv = ((PowerManager) context.getSystemService("power")).newWakeLock(i2, str);
        if (WorkSourceUtil.hasWorkSourcePermission(context)) {
            str3 = Strings.isEmptyOrWhitespace(str3) ? context.getPackageName() : str3;
            if (!zzaeh.isWorkChainsEnabled() || str3 == null || str4 == null) {
                this.zzadw = WorkSourceUtil.fromPackage(context, str3);
            } else {
                new StringBuilder(String.valueOf(str3).length() + 42 + String.valueOf(str4).length()).append("Using experimental Pi WorkSource chains: ").append(str3).append(",").append(str4);
                this.zzadx = str3;
                this.zzadw = WorkSourceUtil.fromPackageAndModuleExperimentalPi(context, str3, str4);
            }
            addWorkSource(this.zzadw);
        }
        if (zzaeg == null) {
            zzaeg = PooledExecutorsProvider.getInstance().newSingleThreadScheduledExecutor();
        }
        AppMethodBeat.o(73449);
    }

    public static void setConfiguration(Configuration configuration) {
        zzaeh = configuration;
    }

    private final void zza(WorkSource workSource) {
        AppMethodBeat.i(73468);
        try {
            this.zzadv.setWorkSource(workSource);
            AppMethodBeat.o(73468);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
            Log.wtf("WakeLock", e2.toString());
            AppMethodBeat.o(73468);
        }
    }

    static /* synthetic */ void zza(WakeLock wakeLock, int i2) {
        AppMethodBeat.i(73471);
        wakeLock.zzn(0);
        AppMethodBeat.o(73471);
    }

    static /* synthetic */ void zza(WakeLock wakeLock, String str, int i2) {
        AppMethodBeat.i(73472);
        wakeLock.zzc(str, i2);
        AppMethodBeat.o(73472);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        if (r0 == false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
        if (r12.zzaee == 0) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        com.google.android.gms.common.stats.WakeLockTracker.getInstance().registerEvent(r12.zzjp, com.google.android.gms.common.stats.StatsUtils.getEventKey(r12.zzadv, r6), 7, r12.zzadz, r6, r12.zzaeb, r12.zzady, zzdo(), r14);
        r12.zzaee++;
     */
    @android.annotation.SuppressLint({"WakelockTimeout"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.lang.String r13, long r14) {
        /*
        // Method dump skipped, instructions count: 212
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.zza(java.lang.String, long):void");
    }

    private final void zzb(String str, int i2) {
        AppMethodBeat.i(73461);
        this.zzaef.decrementAndGet();
        zzc(str, i2);
        AppMethodBeat.o(73461);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (r10.zzaee == 1) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        com.google.android.gms.common.stats.WakeLockTracker.getInstance().registerEvent(r10.zzjp, com.google.android.gms.common.stats.StatsUtils.getEventKey(r10.zzadv, r5), 8, r10.zzadz, r5, r10.zzaeb, r10.zzady, zzdo());
        r10.zzaee--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r0 == false) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(java.lang.String r11, int r12) {
        /*
        // Method dump skipped, instructions count: 119
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.zzc(java.lang.String, int):void");
    }

    private final List<String> zzdo() {
        AppMethodBeat.i(73450);
        List<String> names = WorkSourceUtil.getNames(this.zzadw);
        if (this.zzadx == null) {
            AppMethodBeat.o(73450);
            return names;
        }
        ArrayList arrayList = new ArrayList(names);
        arrayList.add(this.zzadx);
        AppMethodBeat.o(73450);
        return arrayList;
    }

    private final String zzn(String str) {
        AppMethodBeat.i(73464);
        if (!this.zzaec) {
            String str2 = this.zzaea;
            AppMethodBeat.o(73464);
            return str2;
        } else if (!TextUtils.isEmpty(str)) {
            AppMethodBeat.o(73464);
            return str;
        } else {
            String str3 = this.zzaea;
            AppMethodBeat.o(73464);
            return str3;
        }
    }

    private final void zzn(int i2) {
        AppMethodBeat.i(73463);
        if (this.zzadv.isHeld()) {
            try {
                if (Build.VERSION.SDK_INT < 21 || i2 <= 0) {
                    this.zzadv.release();
                    AppMethodBeat.o(73463);
                    return;
                }
                this.zzadv.release(i2);
                AppMethodBeat.o(73463);
            } catch (RuntimeException e2) {
                if (e2.getClass().equals(RuntimeException.class)) {
                    String.valueOf(this.zzadz).concat(" was already released!");
                    AppMethodBeat.o(73463);
                    return;
                }
                AppMethodBeat.o(73463);
                throw e2;
            }
        } else {
            AppMethodBeat.o(73463);
        }
    }

    public void acquire() {
        AppMethodBeat.i(73451);
        this.zzaef.incrementAndGet();
        zza((String) null, 0);
        AppMethodBeat.o(73451);
    }

    public void acquire(long j2) {
        AppMethodBeat.i(73452);
        this.zzaef.incrementAndGet();
        zza((String) null, j2);
        AppMethodBeat.o(73452);
    }

    public void acquire(String str) {
        AppMethodBeat.i(73453);
        this.zzaef.incrementAndGet();
        zza(str, 0);
        AppMethodBeat.o(73453);
    }

    public void acquire(String str, long j2) {
        AppMethodBeat.i(73454);
        this.zzaef.incrementAndGet();
        zza(str, j2);
        AppMethodBeat.o(73454);
    }

    public HeldLock acquireLock(long j2, String str) {
        AppMethodBeat.i(73456);
        long min = Math.min(j2, zzaeh.getMaximumTimeout(this.zzadz, str));
        HeldLock heldLock = new HeldLock(this, str, null);
        zza(str, 0);
        heldLock.zzael = zzaeg.schedule(new zzc(new WeakReference(heldLock)), min, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(73456);
        return heldLock;
    }

    public void addWorkSource(WorkSource workSource) {
        AppMethodBeat.i(73467);
        if (workSource != null && WorkSourceUtil.hasWorkSourcePermission(this.zzjp)) {
            if (this.zzadw != null) {
                this.zzadw.add(workSource);
            } else {
                this.zzadw = workSource;
            }
            zza(this.zzadw);
        }
        AppMethodBeat.o(73467);
    }

    public PowerManager.WakeLock getWakeLock() {
        return this.zzadv;
    }

    public boolean isHeld() {
        AppMethodBeat.i(73466);
        boolean isHeld = this.zzadv.isHeld();
        AppMethodBeat.o(73466);
        return isHeld;
    }

    public void release() {
        AppMethodBeat.i(73457);
        zzb(null, 0);
        AppMethodBeat.o(73457);
    }

    public void release(int i2) {
        AppMethodBeat.i(73458);
        zzb(null, i2);
        AppMethodBeat.o(73458);
    }

    public void release(String str) {
        AppMethodBeat.i(73459);
        zzb(str, 0);
        AppMethodBeat.o(73459);
    }

    public void release(String str, int i2) {
        AppMethodBeat.i(73460);
        zzb(str, i2);
        AppMethodBeat.o(73460);
    }

    public void removeWorkSource(WorkSource workSource) {
        AppMethodBeat.i(73469);
        if (workSource != null && WorkSourceUtil.hasWorkSourcePermission(this.zzjp)) {
            try {
                if (this.zzadw != null) {
                    this.zzadw.remove(workSource);
                }
                zza(this.zzadw);
                AppMethodBeat.o(73469);
                return;
            } catch (ArrayIndexOutOfBoundsException e2) {
            }
        }
        AppMethodBeat.o(73469);
    }

    public void setReferenceCounted(boolean z) {
        AppMethodBeat.i(73465);
        this.zzadv.setReferenceCounted(z);
        this.zzaec = z;
        AppMethodBeat.o(73465);
    }

    public void setWorkSource(WorkSource workSource) {
        AppMethodBeat.i(73470);
        if (WorkSourceUtil.hasWorkSourcePermission(this.zzjp)) {
            zza(workSource);
            this.zzadw = workSource;
            this.zzadx = null;
        }
        AppMethodBeat.o(73470);
    }
}
