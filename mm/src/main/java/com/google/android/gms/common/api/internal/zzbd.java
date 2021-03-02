package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zzbd implements zzbp, zzq {
    private final Context mContext;
    private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
    final zzav zzfq;
    private final Lock zzga;
    private final ClientSettings zzgf;
    private final Map<Api<?>, Boolean> zzgi;
    private final GoogleApiAvailabilityLight zzgk;
    final Map<Api.AnyClientKey<?>, Api.Client> zzil;
    private final Condition zziz;
    private final zzbf zzja;
    final Map<Api.AnyClientKey<?>, ConnectionResult> zzjb = new HashMap();
    private volatile zzbc zzjc;
    private ConnectionResult zzjd = null;
    int zzje;
    final zzbq zzjf;

    public zzbd(Context context, zzav zzav, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, ArrayList<zzp> arrayList, zzbq zzbq) {
        AppMethodBeat.i(11308);
        this.mContext = context;
        this.zzga = lock;
        this.zzgk = googleApiAvailabilityLight;
        this.zzil = map;
        this.zzgf = clientSettings;
        this.zzgi = map2;
        this.zzdh = abstractClientBuilder;
        this.zzfq = zzav;
        this.zzjf = zzbq;
        ArrayList<zzp> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            zzp zzp = arrayList2.get(i2);
            i2++;
            zzp.zza(this);
        }
        this.zzja = new zzbf(this, looper);
        this.zziz = lock.newCondition();
        this.zzjc = new zzau(this);
        AppMethodBeat.o(11308);
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        AppMethodBeat.i(11312);
        connect();
        while (isConnecting()) {
            try {
                this.zziz.await();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                ConnectionResult connectionResult = new ConnectionResult(15, null);
                AppMethodBeat.o(11312);
                return connectionResult;
            }
        }
        if (isConnected()) {
            ConnectionResult connectionResult2 = ConnectionResult.RESULT_SUCCESS;
            AppMethodBeat.o(11312);
            return connectionResult2;
        } else if (this.zzjd != null) {
            ConnectionResult connectionResult3 = this.zzjd;
            AppMethodBeat.o(11312);
            return connectionResult3;
        } else {
            ConnectionResult connectionResult4 = new ConnectionResult(13, null);
            AppMethodBeat.o(11312);
            return connectionResult4;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(11313);
        connect();
        long nanos = timeUnit.toNanos(j2);
        while (isConnecting()) {
            if (nanos <= 0) {
                try {
                    disconnect();
                    ConnectionResult connectionResult = new ConnectionResult(14, null);
                    AppMethodBeat.o(11313);
                    return connectionResult;
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    ConnectionResult connectionResult2 = new ConnectionResult(15, null);
                    AppMethodBeat.o(11313);
                    return connectionResult2;
                }
            } else {
                nanos = this.zziz.awaitNanos(nanos);
            }
        }
        if (isConnected()) {
            ConnectionResult connectionResult3 = ConnectionResult.RESULT_SUCCESS;
            AppMethodBeat.o(11313);
            return connectionResult3;
        } else if (this.zzjd != null) {
            ConnectionResult connectionResult4 = this.zzjd;
            AppMethodBeat.o(11313);
            return connectionResult4;
        } else {
            ConnectionResult connectionResult5 = new ConnectionResult(13, null);
            AppMethodBeat.o(11313);
            return connectionResult5;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final void connect() {
        AppMethodBeat.i(11311);
        this.zzjc.connect();
        AppMethodBeat.o(11311);
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final void disconnect() {
        AppMethodBeat.i(11314);
        if (this.zzjc.disconnect()) {
            this.zzjb.clear();
        }
        AppMethodBeat.o(11314);
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.i(11325);
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.zzjc);
        for (Api<?> api : this.zzgi.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.getName()).println(":");
            this.zzil.get(api.getClientKey()).dump(concat, fileDescriptor, printWriter, strArr);
        }
        AppMethodBeat.o(11325);
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.i(11309);
        t.zzx();
        T t2 = (T) this.zzjc.enqueue(t);
        AppMethodBeat.o(11309);
        return t2;
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.i(11310);
        t.zzx();
        T t2 = (T) this.zzjc.execute(t);
        AppMethodBeat.o(11310);
        return t2;
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final ConnectionResult getConnectionResult(Api<?> api) {
        AppMethodBeat.i(11315);
        Api.AnyClientKey<?> clientKey = api.getClientKey();
        if (this.zzil.containsKey(clientKey)) {
            if (this.zzil.get(clientKey).isConnected()) {
                ConnectionResult connectionResult = ConnectionResult.RESULT_SUCCESS;
                AppMethodBeat.o(11315);
                return connectionResult;
            } else if (this.zzjb.containsKey(clientKey)) {
                ConnectionResult connectionResult2 = this.zzjb.get(clientKey);
                AppMethodBeat.o(11315);
                return connectionResult2;
            }
        }
        AppMethodBeat.o(11315);
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final boolean isConnected() {
        return this.zzjc instanceof zzag;
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final boolean isConnecting() {
        return this.zzjc instanceof zzaj;
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final void maybeSignOut() {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        AppMethodBeat.i(11321);
        this.zzga.lock();
        try {
            this.zzjc.onConnected(bundle);
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11321);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i2) {
        AppMethodBeat.i(11322);
        this.zzga.lock();
        try {
            this.zzjc.onConnectionSuspended(i2);
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11322);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzq
    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        AppMethodBeat.i(11320);
        this.zzga.lock();
        try {
            this.zzjc.zza(connectionResult, api, z);
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11320);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbe zzbe) {
        AppMethodBeat.i(11323);
        this.zzja.sendMessage(this.zzja.obtainMessage(1, zzbe));
        AppMethodBeat.o(11323);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(RuntimeException runtimeException) {
        AppMethodBeat.i(11324);
        this.zzja.sendMessage(this.zzja.obtainMessage(2, runtimeException));
        AppMethodBeat.o(11324);
    }

    /* access modifiers changed from: package-private */
    public final void zzbc() {
        AppMethodBeat.i(11316);
        this.zzga.lock();
        try {
            this.zzjc = new zzaj(this, this.zzgf, this.zzgi, this.zzgk, this.zzdh, this.zzga, this.mContext);
            this.zzjc.begin();
            this.zziz.signalAll();
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11316);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzbd() {
        AppMethodBeat.i(11317);
        this.zzga.lock();
        try {
            this.zzfq.zzaz();
            this.zzjc = new zzag(this);
            this.zzjc.begin();
            this.zziz.signalAll();
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11317);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(ConnectionResult connectionResult) {
        AppMethodBeat.i(11318);
        this.zzga.lock();
        try {
            this.zzjd = connectionResult;
            this.zzjc = new zzau(this);
            this.zzjc.begin();
            this.zziz.signalAll();
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11318);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final void zzz() {
        AppMethodBeat.i(11319);
        if (isConnected()) {
            ((zzag) this.zzjc).zzap();
        }
        AppMethodBeat.o(11319);
    }
}
