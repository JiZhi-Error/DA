package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@ParametersAreNonnullByDefault
public class AdvertisingIdClient {
    @GuardedBy("this")
    private final Context mContext;
    @GuardedBy("this")
    private BlockingServiceConnection zze;
    @GuardedBy("this")
    private zze zzf;
    @GuardedBy("this")
    private boolean zzg;
    private final Object zzh;
    @GuardedBy("mAutoDisconnectTaskLock")
    private zza zzi;
    private final boolean zzj;
    private final long zzk;

    @KeepForSdkWithMembers
    public static final class Info {
        private final String zzq;
        private final boolean zzr;

        public Info(String str, boolean z) {
            this.zzq = str;
            this.zzr = z;
        }

        public final String getId() {
            return this.zzq;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzr;
        }

        public final String toString() {
            AppMethodBeat.i(53012);
            String str = this.zzq;
            String sb = new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.zzr).toString();
            AppMethodBeat.o(53012);
            return sb;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzm;
        private long zzn;
        CountDownLatch zzo = new CountDownLatch(1);
        boolean zzp = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j2) {
            AppMethodBeat.i(53013);
            this.zzm = new WeakReference<>(advertisingIdClient);
            this.zzn = j2;
            start();
            AppMethodBeat.o(53013);
        }

        private final void disconnect() {
            AppMethodBeat.i(53014);
            AdvertisingIdClient advertisingIdClient = this.zzm.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzp = true;
            }
            AppMethodBeat.o(53014);
        }

        public final void run() {
            AppMethodBeat.i(53015);
            try {
                if (!this.zzo.await(this.zzn, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
                AppMethodBeat.o(53015);
            } catch (InterruptedException e2) {
                disconnect();
                AppMethodBeat.o(53015);
            }
        }
    }

    @KeepForSdk
    public AdvertisingIdClient(Context context) {
        this(context, 30000, false, false);
    }

    @VisibleForTesting
    private AdvertisingIdClient(Context context, long j2, boolean z, boolean z2) {
        AppMethodBeat.i(53016);
        this.zzh = new Object();
        Preconditions.checkNotNull(context);
        if (z) {
            Context applicationContext = context.getApplicationContext();
            this.mContext = applicationContext != null ? applicationContext : context;
        } else {
            this.mContext = context;
        }
        this.zzg = false;
        this.zzk = j2;
        this.zzj = z2;
        AppMethodBeat.o(53016);
    }

    @KeepForSdk
    public static Info getAdvertisingIdInfo(Context context) {
        AppMethodBeat.i(53025);
        zzb zzb = new zzb(context);
        boolean z = zzb.getBoolean("gads:ad_id_app_context:enabled", false);
        float f2 = zzb.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
        String string = zzb.getString("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, z, zzb.getBoolean("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.zza(false);
            Info info = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info, z, f2, SystemClock.elapsedRealtime() - elapsedRealtime, string, null);
            advertisingIdClient.finish();
            AppMethodBeat.o(53025);
            return info;
        } catch (Throwable th) {
            advertisingIdClient.finish();
            AppMethodBeat.o(53025);
            throw th;
        }
    }

    @KeepForSdk
    public static boolean getIsAdIdFakeForDebugLogging(Context context) {
        AppMethodBeat.i(53026);
        zzb zzb = new zzb(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, zzb.getBoolean("gads:ad_id_app_context:enabled", false), zzb.getBoolean("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            advertisingIdClient.zza(false);
            return advertisingIdClient.zzb();
        } finally {
            advertisingIdClient.finish();
            AppMethodBeat.o(53026);
        }
    }

    @KeepForSdk
    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private static BlockingServiceConnection zza(Context context, boolean z) {
        AppMethodBeat.i(53024);
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12451000)) {
                case 0:
                case 2:
                    String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                    BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
                    Intent intent = new Intent(str);
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (ConnectionTracker.getInstance().bindService(context, intent, blockingServiceConnection, 1)) {
                            AppMethodBeat.o(53024);
                            return blockingServiceConnection;
                        }
                        IOException iOException = new IOException("Connection failure");
                        AppMethodBeat.o(53024);
                        throw iOException;
                    } catch (Throwable th) {
                        IOException iOException2 = new IOException(th);
                        AppMethodBeat.o(53024);
                        throw iOException2;
                    }
                case 1:
                default:
                    IOException iOException3 = new IOException("Google Play services not available");
                    AppMethodBeat.o(53024);
                    throw iOException3;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException = new GooglePlayServicesNotAvailableException(9);
            AppMethodBeat.o(53024);
            throw googlePlayServicesNotAvailableException;
        }
    }

    @VisibleForTesting
    private static zze zza(Context context, BlockingServiceConnection blockingServiceConnection) {
        AppMethodBeat.i(53028);
        try {
            zze zza2 = zzf.zza(blockingServiceConnection.getServiceWithTimeout(10000, TimeUnit.MILLISECONDS));
            AppMethodBeat.o(53028);
            return zza2;
        } catch (InterruptedException e2) {
            IOException iOException = new IOException("Interrupted exception");
            AppMethodBeat.o(53028);
            throw iOException;
        } catch (Throwable th) {
            IOException iOException2 = new IOException(th);
            AppMethodBeat.o(53028);
            throw iOException2;
        }
    }

    private final void zza() {
        AppMethodBeat.i(53019);
        synchronized (this.zzh) {
            try {
                if (this.zzi != null) {
                    this.zzi.zzo.countDown();
                    try {
                        this.zzi.join();
                    } catch (InterruptedException e2) {
                    }
                }
                if (this.zzk > 0) {
                    this.zzi = new zza(this, this.zzk);
                }
            } finally {
                AppMethodBeat.o(53019);
            }
        }
    }

    @VisibleForTesting
    private final void zza(boolean z) {
        AppMethodBeat.i(53018);
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.zzg) {
                    finish();
                }
                this.zze = zza(this.mContext, this.zzj);
                this.zzf = zza(this.mContext, this.zze);
                this.zzg = true;
                if (z) {
                    zza();
                }
            } finally {
                AppMethodBeat.o(53018);
            }
        }
    }

    @VisibleForTesting
    private final boolean zza(Info info, boolean z, float f2, long j2, String str, Throwable th) {
        AppMethodBeat.i(53027);
        if (Math.random() > ((double) f2)) {
            AppMethodBeat.o(53027);
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_context", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (info != null) {
            hashMap.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (!(info == null || info.getId() == null)) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j2));
        new zza(this, hashMap).start();
        AppMethodBeat.o(53027);
        return true;
    }

    private final boolean zzb() {
        boolean zzc;
        AppMethodBeat.i(53021);
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.zzg) {
                    synchronized (this.zzh) {
                        try {
                            if (this.zzi == null || !this.zzi.zzp) {
                                IOException iOException = new IOException("AdvertisingIdClient is not connected.");
                                AppMethodBeat.o(53021);
                                throw iOException;
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(53021);
                            throw th;
                        }
                    }
                    try {
                        zza(false);
                        if (!this.zzg) {
                            IOException iOException2 = new IOException("AdvertisingIdClient cannot reconnect.");
                            AppMethodBeat.o(53021);
                            throw iOException2;
                        }
                    } catch (Exception e2) {
                        IOException iOException3 = new IOException("AdvertisingIdClient cannot reconnect.", e2);
                        AppMethodBeat.o(53021);
                        throw iOException3;
                    }
                }
                Preconditions.checkNotNull(this.zze);
                Preconditions.checkNotNull(this.zzf);
                try {
                    zzc = this.zzf.zzc();
                } catch (RemoteException e3) {
                    IOException iOException4 = new IOException("Remote exception");
                    AppMethodBeat.o(53021);
                    throw iOException4;
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(53021);
                throw th2;
            }
        }
        zza();
        AppMethodBeat.o(53021);
        return zzc;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(53023);
        finish();
        super.finalize();
        AppMethodBeat.o(53023);
    }

    public final void finish() {
        AppMethodBeat.i(53022);
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.mContext != null && this.zze != null) {
                    try {
                        if (this.zzg) {
                            ConnectionTracker.getInstance().unbindService(this.mContext, this.zze);
                        }
                    } catch (Throwable th) {
                    }
                    this.zzg = false;
                    this.zzf = null;
                    this.zze = null;
                    AppMethodBeat.o(53022);
                }
            } finally {
                AppMethodBeat.o(53022);
            }
        }
    }

    @KeepForSdk
    public Info getInfo() {
        Info info;
        AppMethodBeat.i(53020);
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.zzg) {
                    synchronized (this.zzh) {
                        try {
                            if (this.zzi == null || !this.zzi.zzp) {
                                IOException iOException = new IOException("AdvertisingIdClient is not connected.");
                                AppMethodBeat.o(53020);
                                throw iOException;
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(53020);
                            throw th;
                        }
                    }
                    try {
                        zza(false);
                        if (!this.zzg) {
                            IOException iOException2 = new IOException("AdvertisingIdClient cannot reconnect.");
                            AppMethodBeat.o(53020);
                            throw iOException2;
                        }
                    } catch (Exception e2) {
                        IOException iOException3 = new IOException("AdvertisingIdClient cannot reconnect.", e2);
                        AppMethodBeat.o(53020);
                        throw iOException3;
                    }
                }
                Preconditions.checkNotNull(this.zze);
                Preconditions.checkNotNull(this.zzf);
                try {
                    info = new Info(this.zzf.getId(), this.zzf.zzb(true));
                } catch (RemoteException e3) {
                    IOException iOException4 = new IOException("Remote exception");
                    AppMethodBeat.o(53020);
                    throw iOException4;
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(53020);
                throw th2;
            }
        }
        zza();
        AppMethodBeat.o(53020);
        return info;
    }

    @KeepForSdk
    public void start() {
        AppMethodBeat.i(53017);
        zza(true);
        AppMethodBeat.o(53017);
    }
}
