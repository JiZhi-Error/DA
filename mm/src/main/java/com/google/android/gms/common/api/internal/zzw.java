package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.e.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zzw implements zzbp {
    private final Looper zzcn;
    private final GoogleApiManager zzcq;
    private final Lock zzga;
    private final ClientSettings zzgf;
    private final Map<Api.AnyClientKey<?>, zzv<?>> zzgg = new HashMap();
    private final Map<Api.AnyClientKey<?>, zzv<?>> zzgh = new HashMap();
    private final Map<Api<?>, Boolean> zzgi;
    private final zzav zzgj;
    private final GoogleApiAvailabilityLight zzgk;
    private final Condition zzgl;
    private final boolean zzgm;
    private final boolean zzgn;
    private final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zzgo = new LinkedList();
    @GuardedBy("mLock")
    private boolean zzgp;
    @GuardedBy("mLock")
    private Map<zzh<?>, ConnectionResult> zzgq;
    @GuardedBy("mLock")
    private Map<zzh<?>, ConnectionResult> zzgr;
    @GuardedBy("mLock")
    private zzz zzgs;
    @GuardedBy("mLock")
    private ConnectionResult zzgt;

    public zzw(Context context, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, ArrayList<zzp> arrayList, zzav zzav, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        AppMethodBeat.i(11475);
        this.zzga = lock;
        this.zzcn = looper;
        this.zzgl = lock.newCondition();
        this.zzgk = googleApiAvailabilityLight;
        this.zzgj = zzav;
        this.zzgi = map2;
        this.zzgf = clientSettings;
        this.zzgm = z;
        HashMap hashMap = new HashMap();
        for (Api<?> api : map2.keySet()) {
            hashMap.put(api.getClientKey(), api);
        }
        HashMap hashMap2 = new HashMap();
        ArrayList<zzp> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            zzp zzp = arrayList2.get(i2);
            i2++;
            zzp zzp2 = zzp;
            hashMap2.put(zzp2.mApi, zzp2);
        }
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = false;
        for (Map.Entry<Api.AnyClientKey<?>, Api.Client> entry : map.entrySet()) {
            Api api2 = (Api) hashMap.get(entry.getKey());
            Api.Client value = entry.getValue();
            if (!value.requiresGooglePlayServices()) {
                z2 = z7;
                z3 = false;
                z4 = z5;
            } else if (!this.zzgi.get(api2).booleanValue()) {
                z2 = true;
                z3 = z6;
                z4 = true;
            } else {
                z2 = true;
                z3 = z6;
                z4 = z5;
            }
            zzv<?> zzv = new zzv<>(context, api2, looper, value, (zzp) hashMap2.get(api2), clientSettings, abstractClientBuilder);
            this.zzgg.put(entry.getKey(), zzv);
            if (value.requiresSignIn()) {
                this.zzgh.put(entry.getKey(), zzv);
            }
            z7 = z2;
            z6 = z3;
            z5 = z4;
        }
        this.zzgn = z7 && !z6 && !z5;
        this.zzcq = GoogleApiManager.zzbf();
        AppMethodBeat.o(11475);
    }

    private final ConnectionResult zza(Api.AnyClientKey<?> anyClientKey) {
        AppMethodBeat.i(11484);
        this.zzga.lock();
        try {
            zzv<?> zzv = this.zzgg.get(anyClientKey);
            if (this.zzgq != null && zzv != null) {
                return this.zzgq.get(zzv.zzm());
            }
            this.zzga.unlock();
            AppMethodBeat.o(11484);
            return null;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11484);
        }
    }

    private final boolean zza(zzv<?> zzv, ConnectionResult connectionResult) {
        AppMethodBeat.i(11492);
        if (connectionResult.isSuccess() || connectionResult.hasResolution() || !this.zzgi.get(zzv.getApi()).booleanValue() || !zzv.zzae().requiresGooglePlayServices() || !this.zzgk.isUserResolvableError(connectionResult.getErrorCode())) {
            AppMethodBeat.o(11492);
            return false;
        }
        AppMethodBeat.o(11492);
        return true;
    }

    static /* synthetic */ boolean zza(zzw zzw, zzv zzv, ConnectionResult connectionResult) {
        AppMethodBeat.i(11494);
        boolean zza = zzw.zza(zzv, connectionResult);
        AppMethodBeat.o(11494);
        return zza;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzaf() {
        /*
            r4 = this;
            r1 = 0
            r3 = 11487(0x2cdf, float:1.6097E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            java.util.concurrent.locks.Lock r0 = r4.zzga
            r0.lock()
            boolean r0 = r4.zzgp     // Catch:{ all -> 0x0053 }
            if (r0 == 0) goto L_0x0013
            boolean r0 = r4.zzgm     // Catch:{ all -> 0x0053 }
            if (r0 != 0) goto L_0x001d
        L_0x0013:
            java.util.concurrent.locks.Lock r0 = r4.zzga
            r0.unlock()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            r0 = r1
        L_0x001c:
            return r0
        L_0x001d:
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.api.internal.zzv<?>> r0 = r4.zzgh
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r2 = r0.iterator()
        L_0x0027:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0049
            java.lang.Object r0 = r2.next()
            com.google.android.gms.common.api.Api$AnyClientKey r0 = (com.google.android.gms.common.api.Api.AnyClientKey) r0
            com.google.android.gms.common.ConnectionResult r0 = r4.zza(r0)
            if (r0 == 0) goto L_0x003f
            boolean r0 = r0.isSuccess()
            if (r0 != 0) goto L_0x0027
        L_0x003f:
            java.util.concurrent.locks.Lock r0 = r4.zzga
            r0.unlock()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            r0 = r1
            goto L_0x001c
        L_0x0049:
            java.util.concurrent.locks.Lock r0 = r4.zzga
            r0.unlock()
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x001c
        L_0x0053:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r4.zzga
            r1.unlock()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzw.zzaf():boolean");
    }

    @GuardedBy("mLock")
    private final void zzag() {
        AppMethodBeat.i(11490);
        if (this.zzgf == null) {
            this.zzgj.zzim = Collections.emptySet();
            AppMethodBeat.o(11490);
            return;
        }
        HashSet hashSet = new HashSet(this.zzgf.getRequiredScopes());
        Map<Api<?>, ClientSettings.OptionalApiSettings> optionalApiSettings = this.zzgf.getOptionalApiSettings();
        for (Api<?> api : optionalApiSettings.keySet()) {
            ConnectionResult connectionResult = getConnectionResult(api);
            if (connectionResult != null && connectionResult.isSuccess()) {
                hashSet.addAll(optionalApiSettings.get(api).mScopes);
            }
        }
        this.zzgj.zzim = hashSet;
        AppMethodBeat.o(11490);
    }

    @GuardedBy("mLock")
    private final void zzah() {
        AppMethodBeat.i(11491);
        while (!this.zzgo.isEmpty()) {
            execute(this.zzgo.remove());
        }
        this.zzgj.zzb((Bundle) null);
        AppMethodBeat.o(11491);
    }

    @GuardedBy("mLock")
    private final ConnectionResult zzai() {
        AppMethodBeat.i(11493);
        int i2 = 0;
        ConnectionResult connectionResult = null;
        int i3 = 0;
        ConnectionResult connectionResult2 = null;
        for (zzv<?> zzv : this.zzgg.values()) {
            Api<?> api = zzv.getApi();
            ConnectionResult connectionResult3 = this.zzgq.get(zzv.zzm());
            if (!connectionResult3.isSuccess() && (!this.zzgi.get(api).booleanValue() || connectionResult3.hasResolution() || this.zzgk.isUserResolvableError(connectionResult3.getErrorCode()))) {
                if (connectionResult3.getErrorCode() != 4 || !this.zzgm) {
                    int priority = api.zzj().getPriority();
                    if (connectionResult2 != null && i3 <= priority) {
                        priority = i3;
                        connectionResult3 = connectionResult2;
                    }
                    i3 = priority;
                    connectionResult2 = connectionResult3;
                } else {
                    int priority2 = api.zzj().getPriority();
                    if (connectionResult == null || i2 > priority2) {
                        i2 = priority2;
                        connectionResult = connectionResult3;
                    }
                }
            }
        }
        if (connectionResult2 == null || connectionResult == null || i3 <= i2) {
            AppMethodBeat.o(11493);
            return connectionResult2;
        }
        AppMethodBeat.o(11493);
        return connectionResult;
    }

    private final <T extends BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>> boolean zzb(T t) {
        AppMethodBeat.i(11478);
        Api.AnyClientKey<?> clientKey = t.getClientKey();
        ConnectionResult zza = zza(clientKey);
        if (zza == null || zza.getErrorCode() != 4) {
            AppMethodBeat.o(11478);
            return false;
        }
        t.setFailedResult(new Status(4, null, this.zzcq.zza(this.zzgg.get(clientKey).zzm(), System.identityHashCode(this.zzgj))));
        AppMethodBeat.o(11478);
        return true;
    }

    static /* synthetic */ ConnectionResult zzf(zzw zzw) {
        AppMethodBeat.i(11495);
        ConnectionResult zzai = zzw.zzai();
        AppMethodBeat.o(11495);
        return zzai;
    }

    static /* synthetic */ void zzi(zzw zzw) {
        AppMethodBeat.i(11496);
        zzw.zzag();
        AppMethodBeat.o(11496);
    }

    static /* synthetic */ void zzj(zzw zzw) {
        AppMethodBeat.i(11497);
        zzw.zzah();
        AppMethodBeat.o(11497);
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        AppMethodBeat.i(11480);
        connect();
        while (isConnecting()) {
            try {
                this.zzgl.await();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                ConnectionResult connectionResult = new ConnectionResult(15, null);
                AppMethodBeat.o(11480);
                return connectionResult;
            }
        }
        if (isConnected()) {
            ConnectionResult connectionResult2 = ConnectionResult.RESULT_SUCCESS;
            AppMethodBeat.o(11480);
            return connectionResult2;
        } else if (this.zzgt != null) {
            ConnectionResult connectionResult3 = this.zzgt;
            AppMethodBeat.o(11480);
            return connectionResult3;
        } else {
            ConnectionResult connectionResult4 = new ConnectionResult(13, null);
            AppMethodBeat.o(11480);
            return connectionResult4;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(11481);
        connect();
        long nanos = timeUnit.toNanos(j2);
        while (isConnecting()) {
            if (nanos <= 0) {
                try {
                    disconnect();
                    ConnectionResult connectionResult = new ConnectionResult(14, null);
                    AppMethodBeat.o(11481);
                    return connectionResult;
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    ConnectionResult connectionResult2 = new ConnectionResult(15, null);
                    AppMethodBeat.o(11481);
                    return connectionResult2;
                }
            } else {
                nanos = this.zzgl.awaitNanos(nanos);
            }
        }
        if (isConnected()) {
            ConnectionResult connectionResult3 = ConnectionResult.RESULT_SUCCESS;
            AppMethodBeat.o(11481);
            return connectionResult3;
        } else if (this.zzgt != null) {
            ConnectionResult connectionResult4 = this.zzgt;
            AppMethodBeat.o(11481);
            return connectionResult4;
        } else {
            ConnectionResult connectionResult5 = new ConnectionResult(13, null);
            AppMethodBeat.o(11481);
            return connectionResult5;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final void connect() {
        AppMethodBeat.i(11479);
        this.zzga.lock();
        try {
            if (!this.zzgp) {
                this.zzgp = true;
                this.zzgq = null;
                this.zzgr = null;
                this.zzgs = null;
                this.zzgt = null;
                this.zzcq.zzr();
                this.zzcq.zza(this.zzgg.values()).addOnCompleteListener(new HandlerExecutor(this.zzcn), new zzy(this));
                this.zzga.unlock();
                AppMethodBeat.o(11479);
            }
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11479);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final void disconnect() {
        AppMethodBeat.i(11482);
        this.zzga.lock();
        try {
            this.zzgp = false;
            this.zzgq = null;
            this.zzgr = null;
            if (this.zzgs != null) {
                this.zzgs.cancel();
                this.zzgs = null;
            }
            this.zzgt = null;
            while (!this.zzgo.isEmpty()) {
                BaseImplementation.ApiMethodImpl<?, ?> remove = this.zzgo.remove();
                remove.zza((zzcn) null);
                remove.cancel();
            }
            this.zzgl.signalAll();
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11482);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.i(11476);
        if (this.zzgm && zzb(t)) {
            AppMethodBeat.o(11476);
            return t;
        } else if (!isConnected()) {
            this.zzgo.add(t);
            AppMethodBeat.o(11476);
            return t;
        } else {
            this.zzgj.zzir.zzb(t);
            T t2 = (T) this.zzgg.get(t.getClientKey()).doRead(t);
            AppMethodBeat.o(11476);
            return t2;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.i(11477);
        Api.AnyClientKey<A> clientKey = t.getClientKey();
        if (!this.zzgm || !zzb(t)) {
            this.zzgj.zzir.zzb(t);
            T t2 = (T) this.zzgg.get(clientKey).doWrite(t);
            AppMethodBeat.o(11477);
            return t2;
        }
        AppMethodBeat.o(11477);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final ConnectionResult getConnectionResult(Api<?> api) {
        AppMethodBeat.i(11483);
        ConnectionResult zza = zza(api.getClientKey());
        AppMethodBeat.o(11483);
        return zza;
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final boolean isConnected() {
        AppMethodBeat.i(11485);
        this.zzga.lock();
        try {
            return this.zzgq != null && this.zzgt == null;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11485);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final boolean isConnecting() {
        AppMethodBeat.i(11486);
        this.zzga.lock();
        try {
            return this.zzgq == null && this.zzgp;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11486);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        AppMethodBeat.i(11488);
        this.zzga.lock();
        try {
            if (!this.zzgp || zzaf()) {
                this.zzga.unlock();
                AppMethodBeat.o(11488);
                return false;
            }
            this.zzcq.zzr();
            this.zzgs = new zzz(this, signInConnectionListener);
            this.zzcq.zza(this.zzgh.values()).addOnCompleteListener(new HandlerExecutor(this.zzcn), this.zzgs);
            this.zzga.unlock();
            AppMethodBeat.o(11488);
            return true;
        } catch (Throwable th) {
            this.zzga.unlock();
            AppMethodBeat.o(11488);
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final void maybeSignOut() {
        AppMethodBeat.i(11489);
        this.zzga.lock();
        try {
            this.zzcq.maybeSignOut();
            if (this.zzgs != null) {
                this.zzgs.cancel();
                this.zzgs = null;
            }
            if (this.zzgr == null) {
                this.zzgr = new a(this.zzgh.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            for (zzv<?> zzv : this.zzgh.values()) {
                this.zzgr.put(zzv.zzm(), connectionResult);
            }
            if (this.zzgq != null) {
                this.zzgq.putAll(this.zzgr);
            }
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11489);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final void zzz() {
    }
}
