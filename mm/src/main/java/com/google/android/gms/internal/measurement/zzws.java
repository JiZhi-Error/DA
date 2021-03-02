package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.support.v4.content.f;

public abstract class zzws<T> {
    private static final Object zzbnc = new Object();
    private static boolean zzbnd = false;
    private static volatile Boolean zzbne = null;
    private static volatile Boolean zzbnf = null;
    private static Context zzqx = null;
    private final zzxc zzbng;
    final String zzbnh;
    private final String zzbni;
    private final T zzbnj;
    private T zzbnk;
    private volatile zzwp zzbnl;
    private volatile SharedPreferences zzbnm;

    private zzws(zzxc zzxc, String str, T t) {
        this.zzbnk = null;
        this.zzbnl = null;
        this.zzbnm = null;
        if (zzxc.zzbns == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zzbng = zzxc;
        String valueOf = String.valueOf(zzxc.zzbnt);
        String valueOf2 = String.valueOf(str);
        this.zzbni = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        String valueOf3 = String.valueOf(zzxc.zzbnu);
        String valueOf4 = String.valueOf(str);
        this.zzbnh = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        this.zzbnj = t;
    }

    /* synthetic */ zzws(zzxc zzxc, String str, Object obj, zzww zzww) {
        this(zzxc, str, obj);
    }

    public static void init(Context context) {
        Context applicationContext;
        synchronized (zzbnc) {
            if ((Build.VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) && (applicationContext = context.getApplicationContext()) != null) {
                context = applicationContext;
            }
            if (zzqx != context) {
                zzbne = null;
            }
            zzqx = context;
        }
        zzbnd = false;
    }

    public static zzws<Double> zza(zzxc zzxc, String str, double d2) {
        return new zzwz(zzxc, str, Double.valueOf(d2));
    }

    public static zzws<Integer> zza(zzxc zzxc, String str, int i2) {
        return new zzwx(zzxc, str, Integer.valueOf(i2));
    }

    public static zzws<Long> zza(zzxc zzxc, String str, long j2) {
        return new zzww(zzxc, str, Long.valueOf(j2));
    }

    public static zzws<String> zza(zzxc zzxc, String str, String str2) {
        return new zzxa(zzxc, str, str2);
    }

    public static zzws<Boolean> zza(zzxc zzxc, String str, boolean z) {
        return new zzwy(zzxc, str, Boolean.valueOf(z));
    }

    private static <V> V zza(zzxb<V> zzxb) {
        long clearCallingIdentity;
        try {
            return zzxb.zzsc();
        } catch (SecurityException e2) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zzsc = zzxb.zzsc();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zzsc;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    static boolean zzd(String str, boolean z) {
        try {
            if (zzsa()) {
                return ((Boolean) zza(new zzwv(str, false))).booleanValue();
            }
            return false;
        } catch (SecurityException e2) {
            return false;
        }
    }

    private final T zzry() {
        if (zzd("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            String valueOf = String.valueOf(this.zzbnh);
            if (valueOf.length() != 0) {
                "Bypass reading Phenotype values for flag: ".concat(valueOf);
            } else {
                new String("Bypass reading Phenotype values for flag: ");
            }
        } else if (this.zzbng.zzbns != null) {
            if (this.zzbnl == null) {
                this.zzbnl = zzwp.zza(zzqx.getContentResolver(), this.zzbng.zzbns);
            }
            String str = (String) zza(new zzwt(this, this.zzbnl));
            if (str != null) {
                return zzey(str);
            }
        }
        return null;
    }

    private final T zzrz() {
        if (zzsa()) {
            try {
                String str = (String) zza(new zzwu(this));
                if (str != null) {
                    return zzey(str);
                }
            } catch (SecurityException e2) {
                String valueOf = String.valueOf(this.zzbnh);
                if (valueOf.length() != 0) {
                    "Unable to read GServices for flag: ".concat(valueOf);
                } else {
                    new String("Unable to read GServices for flag: ");
                }
            }
        }
        return null;
    }

    private static boolean zzsa() {
        boolean z = false;
        if (zzbne == null) {
            if (zzqx == null) {
                return false;
            }
            if (f.f(zzqx, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                z = true;
            }
            zzbne = Boolean.valueOf(z);
        }
        return zzbne.booleanValue();
    }

    public final T get() {
        if (zzqx == null) {
            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
        }
        T zzry = zzry();
        if (zzry != null) {
            return zzry;
        }
        T zzrz = zzrz();
        return zzrz == null ? this.zzbnj : zzrz;
    }

    /* access modifiers changed from: protected */
    public abstract T zzey(String str);

    public final /* synthetic */ String zzsb() {
        return zzwn.zza(zzqx.getContentResolver(), this.zzbni, (String) null);
    }
}
