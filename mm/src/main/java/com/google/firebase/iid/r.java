package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.pay.s;
import java.io.IOException;

/* access modifiers changed from: package-private */
public final class r implements Runnable {
    private final long bLW;
    private final PowerManager.WakeLock bLX = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
    private final FirebaseInstanceId bLY;
    private final f bLj;

    @VisibleForTesting
    r(FirebaseInstanceId firebaseInstanceId, f fVar, long j2) {
        AppMethodBeat.i(4201);
        this.bLY = firebaseInstanceId;
        this.bLj = fVar;
        this.bLW = j2;
        this.bLX.setReferenceCounted(false);
        AppMethodBeat.o(4201);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (bT(r0) != false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(4204);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return false;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean yu() {
        /*
            r3 = this;
            r2 = 4204(0x106c, float:5.891E-42)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
        L_0x0005:
            com.google.firebase.iid.FirebaseInstanceId r1 = r3.bLY
            monitor-enter(r1)
            com.google.firebase.iid.p r0 = com.google.firebase.iid.FirebaseInstanceId.yf()     // Catch:{ all -> 0x0024 }
            java.lang.String r0 = r0.ys()     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0018
            r0 = 1
            monitor-exit(r1)     // Catch:{ all -> 0x0024 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0017:
            return r0
        L_0x0018:
            monitor-exit(r1)
            boolean r1 = r3.bT(r0)
            if (r1 != 0) goto L_0x002a
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0017
        L_0x0024:
            r0 = move-exception
            monitor-exit(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x002a:
            com.google.firebase.iid.p r1 = com.google.firebase.iid.FirebaseInstanceId.yf()
            r1.zzf(r0)
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.r.yu():boolean");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaj() {
        AppMethodBeat.i(4207);
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            AppMethodBeat.o(4207);
            return false;
        }
        AppMethodBeat.o(4207);
        return true;
    }

    public final void run() {
        boolean z = true;
        AppMethodBeat.i(4202);
        this.bLX.acquire();
        try {
            this.bLY.zza(true);
            if (this.bLj.zzx() == 0) {
                z = false;
            }
            if (!z) {
                this.bLY.zza(false);
            } else if (!zzaj()) {
                s sVar = new s(this);
                FirebaseInstanceId.yg();
                sVar.bLZ.getContext().registerReceiver(sVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.bLX.release();
                AppMethodBeat.o(4202);
            } else {
                if (!yt() || !yu()) {
                    this.bLY.zza(this.bLW);
                } else {
                    this.bLY.zza(false);
                }
                this.bLX.release();
                AppMethodBeat.o(4202);
            }
        } finally {
            this.bLX.release();
            AppMethodBeat.o(4202);
        }
    }

    @VisibleForTesting
    private final boolean yt() {
        AppMethodBeat.i(4203);
        q ye = this.bLY.ye();
        if (ye == null || ye.bS(this.bLj.yn())) {
            try {
                FirebaseInstanceId firebaseInstanceId = this.bLY;
                String b2 = f.b(firebaseInstanceId.bLi);
                String str = "*";
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    IOException iOException = new IOException("MAIN_THREAD");
                    AppMethodBeat.o(4203);
                    throw iOException;
                }
                if (str.isEmpty() || str.equalsIgnoreCase(AppMeasurement.FCM_ORIGIN) || str.equalsIgnoreCase(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) {
                    str = "*";
                }
                q c2 = FirebaseInstanceId.bLg.c("", b2, str);
                String zzp = (c2 == null || c2.bS(firebaseInstanceId.bLj.yn())) ? firebaseInstanceId.bLl.a(b2, str, new aa(firebaseInstanceId, b2, str)).zzp() : c2.bLU;
                if (zzp == null) {
                    AppMethodBeat.o(4203);
                    return false;
                }
                Log.isLoggable("FirebaseInstanceId", 3);
                if (ye == null || (ye != null && !zzp.equals(ye.bLU))) {
                    Context context = getContext();
                    Intent intent = new Intent("com.google.firebase.iid.TOKEN_REFRESH");
                    Intent intent2 = new Intent("com.google.firebase.INSTANCE_ID_EVENT");
                    intent2.setClass(context, FirebaseInstanceIdReceiver.class);
                    intent2.putExtra("wrapped_intent", intent);
                    context.sendBroadcast(intent2);
                }
                AppMethodBeat.o(4203);
                return true;
            } catch (IOException | SecurityException e2) {
                String valueOf = String.valueOf(e2.getMessage());
                if (valueOf.length() != 0) {
                    "Token retrieval failed: ".concat(valueOf);
                } else {
                    new String("Token retrieval failed: ");
                }
                AppMethodBeat.o(4203);
                return false;
            }
        } else {
            AppMethodBeat.o(4203);
            return true;
        }
    }

    private final boolean bT(String str) {
        AppMethodBeat.i(4205);
        String[] split = str.split("!");
        if (split.length == 2) {
            String str2 = split[0];
            String str3 = split[1];
            char c2 = 65535;
            try {
                switch (str2.hashCode()) {
                    case 83:
                        if (str2.equals("S")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case s.CTRL_INDEX /*{ENCODED_INT: 85}*/:
                        if (str2.equals("U")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        FirebaseInstanceId firebaseInstanceId = this.bLY;
                        q ye = firebaseInstanceId.ye();
                        if (ye == null || ye.bS(firebaseInstanceId.bLj.yn())) {
                            IOException iOException = new IOException("token not available");
                            AppMethodBeat.o(4205);
                            throw iOException;
                        }
                        Bundle bundle = new Bundle();
                        String valueOf = String.valueOf("/topics/");
                        String valueOf2 = String.valueOf(str3);
                        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                        String str4 = ye.bLU;
                        String valueOf3 = String.valueOf("/topics/");
                        String valueOf4 = String.valueOf(str3);
                        firebaseInstanceId.b(str4, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle);
                        if (FirebaseInstanceId.yg()) {
                        }
                        break;
                    case 1:
                        FirebaseInstanceId firebaseInstanceId2 = this.bLY;
                        q ye2 = firebaseInstanceId2.ye();
                        if (ye2 != null && !ye2.bS(firebaseInstanceId2.bLj.yn())) {
                            Bundle bundle2 = new Bundle();
                            String valueOf5 = String.valueOf("/topics/");
                            String valueOf6 = String.valueOf(str3);
                            bundle2.putString("gcm.topic", valueOf6.length() != 0 ? valueOf5.concat(valueOf6) : new String(valueOf5));
                            bundle2.putString("delete", "1");
                            String str5 = ye2.bLU;
                            String valueOf7 = String.valueOf("/topics/");
                            String valueOf8 = String.valueOf(str3);
                            firebaseInstanceId2.b(str5, valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7), bundle2);
                            FirebaseInstanceId.yg();
                            break;
                        } else {
                            IOException iOException2 = new IOException("token not available");
                            AppMethodBeat.o(4205);
                            throw iOException2;
                        }
                }
            } catch (IOException e2) {
                String valueOf9 = String.valueOf(e2.getMessage());
                if (valueOf9.length() != 0) {
                    "Topic sync failed: ".concat(valueOf9);
                } else {
                    new String("Topic sync failed: ");
                }
                AppMethodBeat.o(4205);
                return false;
            }
        }
        AppMethodBeat.o(4205);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final Context getContext() {
        AppMethodBeat.i(4206);
        Context applicationContext = this.bLY.bLi.getApplicationContext();
        AppMethodBeat.o(4206);
        return applicationContext;
    }
}
