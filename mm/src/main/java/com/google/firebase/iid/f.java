package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Base64;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

public final class f {
    private final Context bLv;
    @GuardedBy("this")
    private int bLw;
    @GuardedBy("this")
    private int bLx = 0;
    @GuardedBy("this")
    private String zzbu;
    @GuardedBy("this")
    private String zzbv;

    public f(Context context) {
        this.bLv = context;
    }

    public static String a(KeyPair keyPair) {
        AppMethodBeat.i(4154);
        try {
            byte[] digest = MessageDigest.getInstance(AndroidUtilsLight.DIGEST_ALGORITHM_SHA1).digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            String encodeToString = Base64.encodeToString(digest, 0, 8, 11);
            AppMethodBeat.o(4154);
            return encodeToString;
        } catch (NoSuchAlgorithmException e2) {
            AppMethodBeat.o(4154);
            return null;
        }
    }

    private final PackageInfo bO(String str) {
        AppMethodBeat.i(4159);
        try {
            PackageInfo packageInfo = this.bLv.getPackageManager().getPackageInfo(str, 0);
            AppMethodBeat.o(4159);
            return packageInfo;
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to find package ").append(valueOf);
            AppMethodBeat.o(4159);
            return null;
        }
    }

    private final synchronized void zzab() {
        AppMethodBeat.i(4158);
        PackageInfo bO = bO(this.bLv.getPackageName());
        if (bO != null) {
            this.zzbu = Integer.toString(bO.versionCode);
            this.zzbv = bO.versionName;
        }
        AppMethodBeat.o(4158);
    }

    public final synchronized String yn() {
        String str;
        AppMethodBeat.i(4155);
        if (this.zzbu == null) {
            zzab();
        }
        str = this.zzbu;
        AppMethodBeat.o(4155);
        return str;
    }

    public final synchronized String yo() {
        String str;
        AppMethodBeat.i(4156);
        if (this.zzbv == null) {
            zzab();
        }
        str = this.zzbv;
        AppMethodBeat.o(4156);
        return str;
    }

    public final synchronized int yp() {
        int i2;
        PackageInfo bO;
        AppMethodBeat.i(4157);
        if (this.bLw == 0 && (bO = bO("com.google.android.gms")) != null) {
            this.bLw = bO.versionCode;
        }
        i2 = this.bLw;
        AppMethodBeat.o(4157);
        return i2;
    }

    public final synchronized int zzx() {
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(4152);
            if (this.bLx != 0) {
                i2 = this.bLx;
                AppMethodBeat.o(4152);
            } else {
                PackageManager packageManager = this.bLv.getPackageManager();
                if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
                    AppMethodBeat.o(4152);
                } else {
                    if (!PlatformVersion.isAtLeastO()) {
                        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                        intent.setPackage("com.google.android.gms");
                        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                        if (queryIntentServices != null && queryIntentServices.size() > 0) {
                            this.bLx = 1;
                            i2 = this.bLx;
                            AppMethodBeat.o(4152);
                        }
                    }
                    Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
                    intent2.setPackage("com.google.android.gms");
                    List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
                    if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
                        if (PlatformVersion.isAtLeastO()) {
                            this.bLx = 2;
                        } else {
                            this.bLx = 1;
                        }
                        i2 = this.bLx;
                        AppMethodBeat.o(4152);
                    } else {
                        this.bLx = 2;
                        i2 = this.bLx;
                        AppMethodBeat.o(4152);
                    }
                }
            }
        }
        return i2;
    }

    public static String b(a aVar) {
        AppMethodBeat.i(4153);
        String str = aVar.xR().bKz;
        if (str != null) {
            AppMethodBeat.o(4153);
            return str;
        }
        String str2 = aVar.xR().zzs;
        if (!str2.startsWith("1:")) {
            AppMethodBeat.o(4153);
            return str2;
        }
        String[] split = str2.split(":");
        if (split.length < 2) {
            AppMethodBeat.o(4153);
            return null;
        }
        String str3 = split[1];
        if (str3.isEmpty()) {
            AppMethodBeat.o(4153);
            return null;
        }
        AppMethodBeat.o(4153);
        return str3;
    }
}
