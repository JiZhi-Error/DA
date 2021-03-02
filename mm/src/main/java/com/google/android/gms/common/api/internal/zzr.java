package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.e.a;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* access modifiers changed from: package-private */
public final class zzr implements zzbp {
    private final Context mContext;
    private final Looper zzcn;
    private final zzav zzfq;
    private final zzbd zzfr;
    private final zzbd zzfs;
    private final Map<Api.AnyClientKey<?>, zzbd> zzft;
    private final Set<SignInConnectionListener> zzfu = Collections.newSetFromMap(new WeakHashMap());
    private final Api.Client zzfv;
    private Bundle zzfw;
    private ConnectionResult zzfx = null;
    private ConnectionResult zzfy = null;
    private boolean zzfz = false;
    private final Lock zzga;
    @GuardedBy("mLock")
    private int zzgb = 0;

    private zzr(Context context, zzav zzav, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, Api.Client client, ArrayList<zzp> arrayList, ArrayList<zzp> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        AppMethodBeat.i(11439);
        this.mContext = context;
        this.zzfq = zzav;
        this.zzga = lock;
        this.zzcn = looper;
        this.zzfv = client;
        this.zzfr = new zzbd(context, this.zzfq, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, new zzt(this, null));
        this.zzfs = new zzbd(context, this.zzfq, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, arrayList, new zzu(this, null));
        a aVar = new a();
        for (Api.AnyClientKey<?> anyClientKey : map2.keySet()) {
            aVar.put(anyClientKey, this.zzfr);
        }
        for (Api.AnyClientKey<?> anyClientKey2 : map.keySet()) {
            aVar.put(anyClientKey2, this.zzfs);
        }
        this.zzft = Collections.unmodifiableMap(aVar);
        AppMethodBeat.o(11439);
    }

    public static zzr zza(Context context, zzav zzav, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, ArrayList<zzp> arrayList) {
        AppMethodBeat.i(11438);
        Api.Client client = null;
        a aVar = new a();
        a aVar2 = new a();
        for (Map.Entry<Api.AnyClientKey<?>, Api.Client> entry : map.entrySet()) {
            Api.Client value = entry.getValue();
            if (value.providesSignIn()) {
                client = value;
            }
            if (value.requiresSignIn()) {
                aVar.put(entry.getKey(), value);
            } else {
                aVar2.put(entry.getKey(), value);
            }
        }
        Preconditions.checkState(!aVar.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        a aVar3 = new a();
        a aVar4 = new a();
        for (Api<?> api : map2.keySet()) {
            Api.AnyClientKey<?> clientKey = api.getClientKey();
            if (aVar.containsKey(clientKey)) {
                aVar3.put(api, map2.get(api));
            } else if (aVar2.containsKey(clientKey)) {
                aVar4.put(api, map2.get(api));
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                AppMethodBeat.o(11438);
                throw illegalStateException;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<zzp> arrayList4 = arrayList;
        int size = arrayList4.size();
        int i2 = 0;
        while (i2 < size) {
            zzp zzp = arrayList4.get(i2);
            i2++;
            zzp zzp2 = zzp;
            if (aVar3.containsKey(zzp2.mApi)) {
                arrayList2.add(zzp2);
            } else if (aVar4.containsKey(zzp2.mApi)) {
                arrayList3.add(zzp2);
            } else {
                IllegalStateException illegalStateException2 = new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                AppMethodBeat.o(11438);
                throw illegalStateException2;
            }
        }
        zzr zzr = new zzr(context, zzav, lock, looper, googleApiAvailabilityLight, aVar, aVar2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, aVar3, aVar4);
        AppMethodBeat.o(11438);
        return zzr;
    }

    @GuardedBy("mLock")
    private final void zza(int i2, boolean z) {
        AppMethodBeat.i(11455);
        this.zzfq.zzb(i2, z);
        this.zzfy = null;
        this.zzfx = null;
        AppMethodBeat.o(11455);
    }

    private final void zza(Bundle bundle) {
        AppMethodBeat.i(11459);
        if (this.zzfw == null) {
            this.zzfw = bundle;
            AppMethodBeat.o(11459);
            return;
        }
        if (bundle != null) {
            this.zzfw.putAll(bundle);
        }
        AppMethodBeat.o(11459);
    }

    @GuardedBy("mLock")
    private final void zza(ConnectionResult connectionResult) {
        AppMethodBeat.i(11453);
        switch (this.zzgb) {
            case 2:
                this.zzfq.zzc(connectionResult);
            case 1:
                zzab();
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        this.zzgb = 0;
        AppMethodBeat.o(11453);
    }

    static /* synthetic */ void zza(zzr zzr, int i2, boolean z) {
        AppMethodBeat.i(11464);
        zzr.zza(i2, z);
        AppMethodBeat.o(11464);
    }

    static /* synthetic */ void zza(zzr zzr, Bundle bundle) {
        AppMethodBeat.i(11463);
        zzr.zza(bundle);
        AppMethodBeat.o(11463);
    }

    private final boolean zza(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        AppMethodBeat.i(11457);
        Api.AnyClientKey<? extends Api.AnyClient> clientKey = apiMethodImpl.getClientKey();
        Preconditions.checkArgument(this.zzft.containsKey(clientKey), "GoogleApiClient is not configured to use the API required for this call.");
        boolean equals = this.zzft.get(clientKey).equals(this.zzfs);
        AppMethodBeat.o(11457);
        return equals;
    }

    @GuardedBy("mLock")
    private final void zzaa() {
        AppMethodBeat.i(11452);
        if (zzb(this.zzfx)) {
            if (zzb(this.zzfy) || zzac()) {
                switch (this.zzgb) {
                    case 2:
                        this.zzfq.zzb(this.zzfw);
                    case 1:
                        zzab();
                        break;
                    default:
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        break;
                }
                this.zzgb = 0;
                AppMethodBeat.o(11452);
                return;
            } else if (this.zzfy != null) {
                if (this.zzgb == 1) {
                    zzab();
                    AppMethodBeat.o(11452);
                    return;
                }
                zza(this.zzfy);
                this.zzfr.disconnect();
                AppMethodBeat.o(11452);
                return;
            }
        } else if (this.zzfx != null && zzb(this.zzfy)) {
            this.zzfs.disconnect();
            zza(this.zzfx);
            AppMethodBeat.o(11452);
            return;
        } else if (!(this.zzfx == null || this.zzfy == null)) {
            ConnectionResult connectionResult = this.zzfx;
            if (this.zzfs.zzje < this.zzfr.zzje) {
                connectionResult = this.zzfy;
            }
            zza(connectionResult);
        }
        AppMethodBeat.o(11452);
    }

    @GuardedBy("mLock")
    private final void zzab() {
        AppMethodBeat.i(11454);
        for (SignInConnectionListener signInConnectionListener : this.zzfu) {
            signInConnectionListener.onComplete();
        }
        this.zzfu.clear();
        AppMethodBeat.o(11454);
    }

    @GuardedBy("mLock")
    private final boolean zzac() {
        AppMethodBeat.i(11456);
        if (this.zzfy == null || this.zzfy.getErrorCode() != 4) {
            AppMethodBeat.o(11456);
            return false;
        }
        AppMethodBeat.o(11456);
        return true;
    }

    private final PendingIntent zzad() {
        AppMethodBeat.i(11458);
        if (this.zzfv == null) {
            AppMethodBeat.o(11458);
            return null;
        }
        PendingIntent activity = PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zzfq), this.zzfv.getSignInIntent(), 134217728);
        AppMethodBeat.o(11458);
        return activity;
    }

    static /* synthetic */ void zzb(zzr zzr) {
        AppMethodBeat.i(11462);
        zzr.zzaa();
        AppMethodBeat.o(11462);
    }

    private static boolean zzb(ConnectionResult connectionResult) {
        AppMethodBeat.i(11460);
        if (connectionResult == null || !connectionResult.isSuccess()) {
            AppMethodBeat.o(11460);
            return false;
        }
        AppMethodBeat.o(11460);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        AppMethodBeat.i(11444);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(11444);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(11445);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(11445);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final void connect() {
        AppMethodBeat.i(11443);
        this.zzgb = 2;
        this.zzfz = false;
        this.zzfy = null;
        this.zzfx = null;
        this.zzfr.connect();
        this.zzfs.connect();
        AppMethodBeat.o(11443);
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final void disconnect() {
        AppMethodBeat.i(11446);
        this.zzfy = null;
        this.zzfx = null;
        this.zzgb = 0;
        this.zzfr.disconnect();
        this.zzfs.disconnect();
        zzab();
        AppMethodBeat.o(11446);
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.i(11461);
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.zzfs.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.zzfr.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        AppMethodBeat.o(11461);
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.i(11440);
        if (!zza(t)) {
            T t2 = (T) this.zzfr.enqueue(t);
            AppMethodBeat.o(11440);
            return t2;
        } else if (zzac()) {
            t.setFailedResult(new Status(4, null, zzad()));
            AppMethodBeat.o(11440);
            return t;
        } else {
            T t3 = (T) this.zzfs.enqueue(t);
            AppMethodBeat.o(11440);
            return t3;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.i(11441);
        if (!zza(t)) {
            T t2 = (T) this.zzfr.execute(t);
            AppMethodBeat.o(11441);
            return t2;
        } else if (zzac()) {
            t.setFailedResult(new Status(4, null, zzad()));
            AppMethodBeat.o(11441);
            return t;
        } else {
            T t3 = (T) this.zzfs.execute(t);
            AppMethodBeat.o(11441);
            return t3;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final ConnectionResult getConnectionResult(Api<?> api) {
        AppMethodBeat.i(11442);
        if (!this.zzft.get(api.getClientKey()).equals(this.zzfs)) {
            ConnectionResult connectionResult = this.zzfr.getConnectionResult(api);
            AppMethodBeat.o(11442);
            return connectionResult;
        } else if (zzac()) {
            ConnectionResult connectionResult2 = new ConnectionResult(4, zzad());
            AppMethodBeat.o(11442);
            return connectionResult2;
        } else {
            ConnectionResult connectionResult3 = this.zzfs.getConnectionResult(api);
            AppMethodBeat.o(11442);
            return connectionResult3;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final boolean isConnected() {
        boolean z = true;
        AppMethodBeat.i(11447);
        this.zzga.lock();
        try {
            if (!this.zzfr.isConnected() || (!this.zzfs.isConnected() && !zzac() && this.zzgb != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11447);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final boolean isConnecting() {
        AppMethodBeat.i(11448);
        this.zzga.lock();
        try {
            return this.zzgb == 2;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11448);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        AppMethodBeat.i(11449);
        this.zzga.lock();
        try {
            if ((isConnecting() || isConnected()) && !this.zzfs.isConnected()) {
                this.zzfu.add(signInConnectionListener);
                if (this.zzgb == 0) {
                    this.zzgb = 1;
                }
                this.zzfy = null;
                this.zzfs.connect();
                return true;
            }
            this.zzga.unlock();
            AppMethodBeat.o(11449);
            return false;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11449);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    public final void maybeSignOut() {
        AppMethodBeat.i(11451);
        this.zzga.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zzfs.disconnect();
            this.zzfy = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzcn).post(new zzs(this));
            } else {
                zzab();
            }
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11451);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbp
    @GuardedBy("mLock")
    public final void zzz() {
        AppMethodBeat.i(11450);
        this.zzfr.zzz();
        this.zzfs.zzz();
        AppMethodBeat.o(11450);
    }
}
