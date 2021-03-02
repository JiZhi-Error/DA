package com.google.android.gms.common.config;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import android.os.StrictMode;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.stable.zzg;
import com.google.android.gms.internal.stable.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public abstract class GservicesValue<T> {
    private static final Object sLock = new Object();
    private static zza zzmu = null;
    private static int zzmv = 0;
    private static Context zzmw;
    private static String zzmx = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    @GuardedBy("sLock")
    private static HashSet<String> zzmy;
    protected final T mDefaultValue;
    protected final String mKey;
    private T zzmz = null;

    /* access modifiers changed from: package-private */
    public interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Double zza(String str, Double d2);

        Float zza(String str, Float f2);

        Integer zza(String str, Integer num);

        String zzb(String str, String str2);
    }

    /* access modifiers changed from: package-private */
    public static class zzb implements zza {
        private static final Collection<GservicesValue<?>> zzna = new HashSet();

        static {
            AppMethodBeat.i(4542);
            AppMethodBeat.o(4542);
        }

        private zzb() {
        }

        /* synthetic */ zzb(zza zza) {
            this();
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Long getLong(String str, Long l) {
            return l;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final String getString(String str, String str2) {
            return str2;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Boolean zza(String str, Boolean bool) {
            return bool;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Double zza(String str, Double d2) {
            return d2;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Float zza(String str, Float f2) {
            return f2;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Integer zza(String str, Integer num) {
            return num;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final String zzb(String str, String str2) {
            return str2;
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public static class zzc implements zza {
        private final Map<String, ?> values;

        public zzc(Map<String, ?> map) {
            this.values = map;
        }

        private final <T> T zza(String str, T t) {
            AppMethodBeat.i(4550);
            if (this.values.containsKey(str)) {
                T t2 = (T) this.values.get(str);
                AppMethodBeat.o(4550);
                return t2;
            }
            AppMethodBeat.o(4550);
            return t;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Long getLong(String str, Long l) {
            AppMethodBeat.i(4547);
            Long l2 = (Long) zza(str, l);
            AppMethodBeat.o(4547);
            return l2;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final String getString(String str, String str2) {
            AppMethodBeat.i(4548);
            String str3 = (String) zza(str, str2);
            AppMethodBeat.o(4548);
            return str3;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Boolean zza(String str, Boolean bool) {
            AppMethodBeat.i(4543);
            Boolean bool2 = (Boolean) zza(str, (Object) bool);
            AppMethodBeat.o(4543);
            return bool2;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Double zza(String str, Double d2) {
            AppMethodBeat.i(4545);
            Double d3 = (Double) zza(str, (Object) d2);
            AppMethodBeat.o(4545);
            return d3;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Float zza(String str, Float f2) {
            AppMethodBeat.i(4546);
            Float f3 = (Float) zza(str, (Object) f2);
            AppMethodBeat.o(4546);
            return f3;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Integer zza(String str, Integer num) {
            AppMethodBeat.i(4544);
            Integer num2 = (Integer) zza(str, (Object) num);
            AppMethodBeat.o(4544);
            return num2;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final String zzb(String str, String str2) {
            AppMethodBeat.i(4549);
            String str3 = (String) zza(str, str2);
            AppMethodBeat.o(4549);
            return str3;
        }
    }

    /* access modifiers changed from: package-private */
    public static class zzd implements zza {
        private final ContentResolver mContentResolver;

        public zzd(ContentResolver contentResolver) {
            this.mContentResolver = contentResolver;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Long getLong(String str, Long l) {
            AppMethodBeat.i(4555);
            Long valueOf = Long.valueOf(zzi.getLong(this.mContentResolver, str, l.longValue()));
            AppMethodBeat.o(4555);
            return valueOf;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final String getString(String str, String str2) {
            AppMethodBeat.i(4556);
            String zza = zzi.zza(this.mContentResolver, str, str2);
            AppMethodBeat.o(4556);
            return zza;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Boolean zza(String str, Boolean bool) {
            AppMethodBeat.i(4551);
            Boolean valueOf = Boolean.valueOf(zzi.zza(this.mContentResolver, str, bool.booleanValue()));
            AppMethodBeat.o(4551);
            return valueOf;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Double zza(String str, Double d2) {
            AppMethodBeat.i(4553);
            String zza = zzi.zza(this.mContentResolver, str, (String) null);
            if (zza != null) {
                try {
                    d2 = Double.valueOf(Double.parseDouble(zza));
                    AppMethodBeat.o(4553);
                } catch (NumberFormatException e2) {
                }
                return d2;
            }
            AppMethodBeat.o(4553);
            return d2;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Float zza(String str, Float f2) {
            AppMethodBeat.i(4554);
            String zza = zzi.zza(this.mContentResolver, str, (String) null);
            if (zza != null) {
                try {
                    f2 = Float.valueOf(Float.parseFloat(zza));
                    AppMethodBeat.o(4554);
                } catch (NumberFormatException e2) {
                }
                return f2;
            }
            AppMethodBeat.o(4554);
            return f2;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final Integer zza(String str, Integer num) {
            AppMethodBeat.i(4552);
            Integer valueOf = Integer.valueOf(zzi.getInt(this.mContentResolver, str, num.intValue()));
            AppMethodBeat.o(4552);
            return valueOf;
        }

        @Override // com.google.android.gms.common.config.GservicesValue.zza
        public final String zzb(String str, String str2) {
            AppMethodBeat.i(4557);
            String zza = zzg.zza(this.mContentResolver, str, str2);
            AppMethodBeat.o(4557);
            return zza;
        }
    }

    protected GservicesValue(String str, T t) {
        this.mKey = str;
        this.mDefaultValue = t;
    }

    @VisibleForTesting
    @Deprecated
    public static void forceInit(Context context) {
        forceInit(context, new HashSet());
    }

    @VisibleForTesting
    public static void forceInit(Context context, HashSet<String> hashSet) {
        zza(context, new zzd(context.getContentResolver()), hashSet);
    }

    @TargetApi(24)
    public static SharedPreferences getDirectBootCache(Context context) {
        return context.getApplicationContext().createDeviceProtectedStorageContext().getSharedPreferences("gservices-direboot-cache", 0);
    }

    public static int getSharedUserId() {
        return zzmv;
    }

    @Deprecated
    public static void init(Context context) {
        init(context, zzd(context) ? new HashSet() : null);
    }

    public static void init(Context context, HashSet<String> hashSet) {
        synchronized (sLock) {
            if (zzmu == null) {
                zza(context, new zzd(context.getContentResolver()), hashSet);
            }
            if (zzmv == 0) {
                try {
                    zzmv = context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).uid;
                } catch (PackageManager.NameNotFoundException e2) {
                }
            }
        }
    }

    @VisibleForTesting
    @Deprecated
    public static void initForTests() {
        zza(null, new zzb(null), new HashSet());
    }

    @VisibleForTesting
    public static void initForTests(Context context, HashSet<String> hashSet) {
        zza(context, new zzb(null), hashSet);
    }

    @VisibleForTesting
    @Deprecated
    public static void initForTests(String str, Object obj) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(str, obj);
        initForTests(hashMap);
    }

    @VisibleForTesting
    @Deprecated
    public static void initForTests(Map<String, ?> map) {
        synchronized (sLock) {
            zzmu = new zzc(map);
        }
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (sLock) {
            z = zzmu != null;
        }
        return z;
    }

    public static GservicesValue<String> partnerSetting(String str, String str2) {
        return new zzg(str, str2);
    }

    @VisibleForTesting
    public static void resetAllOverrides() {
        synchronized (sLock) {
            if (zzcg()) {
                for (GservicesValue gservicesValue : zzb.zzna) {
                    gservicesValue.resetOverride();
                }
                zzb.zzna.clear();
            }
        }
    }

    public static GservicesValue<Double> value(String str, Double d2) {
        return new zzd(str, d2);
    }

    public static GservicesValue<Float> value(String str, Float f2) {
        return new zze(str, f2);
    }

    public static GservicesValue<Integer> value(String str, Integer num) {
        return new zzc(str, num);
    }

    public static GservicesValue<Long> value(String str, Long l) {
        return new zzb(str, l);
    }

    public static GservicesValue<String> value(String str, String str2) {
        return new zzf(str, str2);
    }

    public static GservicesValue<Boolean> value(String str, boolean z) {
        return new zza(str, Boolean.valueOf(z));
    }

    @TargetApi(24)
    private static void zza(Context context, zza zza2, HashSet<String> hashSet) {
        synchronized (sLock) {
            zzmu = zza2;
            zzmy = null;
            zzmw = null;
            if (context != null && zzd(context)) {
                zzmy = hashSet;
                zzmw = context.getApplicationContext().createDeviceProtectedStorageContext();
            }
        }
    }

    private static boolean zzcg() {
        boolean z;
        synchronized (sLock) {
            z = (zzmu instanceof zzb) || (zzmu instanceof zzc);
        }
        return z;
    }

    @TargetApi(24)
    private static boolean zzd(Context context) {
        if (!PlatformVersion.isAtLeastN()) {
            return false;
        }
        UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
        if (userManager.isUserUnlocked()) {
            return false;
        }
        return !userManager.isUserRunning(Process.myUserHandle());
    }

    public final T get() {
        boolean z;
        HashSet<String> hashSet;
        Context context;
        long clearCallingIdentity;
        if (this.zzmz != null) {
            return this.zzmz;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        synchronized (sLock) {
            z = zzmw != null && zzd(zzmw);
            hashSet = zzmy;
            context = zzmw;
        }
        if (z) {
            if (Log.isLoggable("GservicesValue", 3)) {
                String valueOf = String.valueOf(this.mKey);
                if (valueOf.length() != 0) {
                    "Gservice value accessed during directboot: ".concat(valueOf);
                } else {
                    new String("Gservice value accessed during directboot: ");
                }
            }
            if (hashSet == null || hashSet.contains(this.mKey)) {
                return retrieveFromDirectBootCache(context, this.mKey, this.mDefaultValue);
            }
            String valueOf2 = String.valueOf(this.mKey);
            if (valueOf2.length() != 0) {
                "Gservices key not whitelisted for directboot access: ".concat(valueOf2);
            } else {
                new String("Gservices key not whitelisted for directboot access: ");
            }
            return this.mDefaultValue;
        }
        synchronized (sLock) {
            zzmy = null;
            zzmw = null;
        }
        try {
            T retrieve = retrieve(this.mKey);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return retrieve;
        } catch (SecurityException e2) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            T retrieve2 = retrieve(this.mKey);
            Binder.restoreCallingIdentity(clearCallingIdentity);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return retrieve2;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    public String getKey() {
        return this.mKey;
    }

    @VisibleForTesting
    public void override(T t) {
        this.zzmz = t;
        synchronized (sLock) {
            if (zzcg()) {
                zzb.zzna.add(this);
            }
        }
    }

    @VisibleForTesting
    public void resetOverride() {
        this.zzmz = null;
    }

    /* access modifiers changed from: protected */
    public abstract T retrieve(String str);

    /* access modifiers changed from: protected */
    @TargetApi(24)
    public T retrieveFromDirectBootCache(Context context, String str, T t) {
        throw new UnsupportedOperationException("The Gservices classes used does not support direct-boot");
    }
}
