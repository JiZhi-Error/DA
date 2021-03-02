package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.e.a;
import android.util.Base64;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Deprecated
public class InstanceID {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String ERROR_TIMEOUT = "TIMEOUT";
    private static Map<String, InstanceID> zzbq = new a();
    private static long zzbr = TimeUnit.DAYS.toSeconds(7);
    private static zzak zzbs;
    private static zzaf zzbt;
    private static String zzbu;
    private String zzbv = "";
    private Context zzk;

    static {
        AppMethodBeat.i(2472);
        AppMethodBeat.o(2472);
    }

    private InstanceID(Context context, String str) {
        AppMethodBeat.i(2456);
        this.zzk = context.getApplicationContext();
        this.zzbv = str;
        AppMethodBeat.o(2456);
    }

    @Deprecated
    public static InstanceID getInstance(Context context) {
        AppMethodBeat.i(2459);
        InstanceID instance = getInstance(context, null);
        AppMethodBeat.o(2459);
        return instance;
    }

    @KeepForSdk
    public static synchronized InstanceID getInstance(Context context, Bundle bundle) {
        InstanceID instanceID;
        synchronized (InstanceID.class) {
            AppMethodBeat.i(2460);
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (zzbs == null) {
                String packageName = applicationContext.getPackageName();
                new StringBuilder(String.valueOf(packageName).length() + 73).append("Instance ID SDK is deprecated, ").append(packageName).append(" should update to use Firebase Instance ID");
                zzbs = new zzak(applicationContext);
                zzbt = new zzaf(applicationContext);
            }
            zzbu = Integer.toString(zzg(applicationContext));
            instanceID = zzbq.get(str);
            if (instanceID == null) {
                instanceID = new InstanceID(applicationContext, str);
                zzbq.put(str, instanceID);
            }
            AppMethodBeat.o(2460);
        }
        return instanceID;
    }

    private final KeyPair getKeyPair() {
        AppMethodBeat.i(2461);
        KeyPair keyPair = zzbs.zzj(this.zzbv).getKeyPair();
        AppMethodBeat.o(2461);
        return keyPair;
    }

    static String zzd(KeyPair keyPair) {
        AppMethodBeat.i(2463);
        try {
            byte[] digest = MessageDigest.getInstance(AndroidUtilsLight.DIGEST_ALGORITHM_SHA1).digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            String encodeToString = Base64.encodeToString(digest, 0, 8, 11);
            AppMethodBeat.o(2463);
            return encodeToString;
        } catch (NoSuchAlgorithmException e2) {
            AppMethodBeat.o(2463);
            return null;
        }
    }

    static int zzg(Context context) {
        int i2 = 0;
        AppMethodBeat.i(2457);
        try {
            i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            AppMethodBeat.o(2457);
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf);
            AppMethodBeat.o(2457);
        }
        return i2;
    }

    static String zzh(Context context) {
        AppMethodBeat.i(2458);
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            AppMethodBeat.o(2458);
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf);
            AppMethodBeat.o(2458);
            return null;
        }
    }

    public static zzak zzn() {
        return zzbs;
    }

    @Deprecated
    public void deleteInstanceID() {
        AppMethodBeat.i(2465);
        zzd("*", "*", null);
        zzm();
        AppMethodBeat.o(2465);
    }

    @Deprecated
    public void deleteToken(String str, String str2) {
        AppMethodBeat.i(2467);
        zzd(str, str2, null);
        AppMethodBeat.o(2467);
    }

    @Deprecated
    public long getCreationTime() {
        AppMethodBeat.i(2464);
        long creationTime = zzbs.zzj(this.zzbv).getCreationTime();
        AppMethodBeat.o(2464);
        return creationTime;
    }

    @Deprecated
    public String getId() {
        AppMethodBeat.i(2462);
        String zzd = zzd(getKeyPair());
        AppMethodBeat.o(2462);
        return zzd;
    }

    @KeepForSdk
    public String getSubtype() {
        return this.zzbv;
    }

    @Deprecated
    public String getToken(String str, String str2) {
        AppMethodBeat.i(2469);
        String token = getToken(str, str2, null);
        AppMethodBeat.o(2469);
        return token;
    }

    @Deprecated
    public String getToken(String str, String str2, Bundle bundle) {
        String str3;
        boolean z = true;
        AppMethodBeat.i(2470);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            IOException iOException = new IOException("MAIN_THREAD");
            AppMethodBeat.o(2470);
            throw iOException;
        }
        String str4 = null;
        String str5 = zzbs.get("appVersion");
        if (!(str5 == null || !str5.equals(zzbu) || (str3 = zzbs.get("lastToken")) == null)) {
            if ((System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str3)).longValue() <= zzbr) {
                z = false;
            }
        }
        if (!z) {
            str4 = zzbs.zze(this.zzbv, str, str2);
        }
        if (str4 == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            str4 = zze(str, str2, bundle);
            if (str4 != null) {
                zzbs.zzd(this.zzbv, str, str2, str4, zzbu);
            }
        }
        AppMethodBeat.o(2470);
        return str4;
    }

    public final void zzd(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(2468);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            IOException iOException = new IOException("MAIN_THREAD");
            AppMethodBeat.o(2468);
            throw iOException;
        }
        zzbs.zzf(this.zzbv, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.zzbv) ? str : this.zzbv);
        if (!"".equals(this.zzbv)) {
            str = this.zzbv;
        }
        bundle.putString("X-subtype", str);
        zzaf.zzi(zzbt.zzd(bundle, getKeyPair()));
        AppMethodBeat.o(2468);
    }

    public final String zze(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(2471);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.zzbv) ? str : this.zzbv;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        String zzi = zzaf.zzi(zzbt.zzd(bundle, getKeyPair()));
        if ("RST".equals(zzi) || zzi.startsWith("RST|")) {
            InstanceIDListenerService.zzd(this.zzk, zzbs);
            IOException iOException = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.o(2471);
            throw iOException;
        }
        AppMethodBeat.o(2471);
        return zzi;
    }

    /* access modifiers changed from: package-private */
    public final void zzm() {
        AppMethodBeat.i(2466);
        zzbs.zzk(this.zzbv);
        AppMethodBeat.o(2466);
    }
}
