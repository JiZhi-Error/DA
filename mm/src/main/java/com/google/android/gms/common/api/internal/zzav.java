package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zzav extends GoogleApiClient implements zzbq {
    private final Context mContext;
    private final Looper zzcn;
    private final int zzde;
    private final GoogleApiAvailability zzdg;
    private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
    private boolean zzdk;
    private final Lock zzga;
    private final ClientSettings zzgf;
    private final Map<Api<?>, Boolean> zzgi;
    @VisibleForTesting
    final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zzgo = new LinkedList();
    private final GmsClientEventManager zzie;
    private zzbp zzif = null;
    private volatile boolean zzig;
    private long zzih = 120000;
    private long zzii = 5000;
    private final zzba zzij;
    @VisibleForTesting
    private GooglePlayServicesUpdatedReceiver zzik;
    final Map<Api.AnyClientKey<?>, Api.Client> zzil;
    Set<Scope> zzim = new HashSet();
    private final ListenerHolders zzin = new ListenerHolders();
    private final ArrayList<zzp> zzio;
    private Integer zzip = null;
    Set<zzch> zziq = null;
    final zzck zzir;
    private final GmsClientEventManager.GmsClientEventState zzis = new zzaw(this);

    public zzav(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, Map<Api<?>, Boolean> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.AnyClientKey<?>, Api.Client> map2, int i2, int i3, ArrayList<zzp> arrayList, boolean z) {
        AppMethodBeat.i(11257);
        this.mContext = context;
        this.zzga = lock;
        this.zzdk = false;
        this.zzie = new GmsClientEventManager(looper, this.zzis);
        this.zzcn = looper;
        this.zzij = new zzba(this, looper);
        this.zzdg = googleApiAvailability;
        this.zzde = i2;
        if (this.zzde >= 0) {
            this.zzip = Integer.valueOf(i3);
        }
        this.zzgi = map;
        this.zzil = map2;
        this.zzio = arrayList;
        this.zzir = new zzck(this.zzil);
        for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : list) {
            this.zzie.registerConnectionCallbacks(connectionCallbacks);
        }
        for (GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener : list2) {
            this.zzie.registerConnectionFailedListener(onConnectionFailedListener);
        }
        this.zzgf = clientSettings;
        this.zzdh = abstractClientBuilder;
        AppMethodBeat.o(11257);
    }

    private final void resume() {
        AppMethodBeat.i(11278);
        this.zzga.lock();
        try {
            if (this.zzig) {
                zzax();
            }
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11278);
        }
    }

    public static int zza(Iterable<Api.Client> iterable, boolean z) {
        AppMethodBeat.i(11297);
        boolean z2 = false;
        boolean z3 = false;
        for (Api.Client client : iterable) {
            if (client.requiresSignIn()) {
                z3 = true;
            }
            z2 = client.providesSignIn() ? true : z2;
        }
        if (!z3) {
            AppMethodBeat.o(11297);
            return 3;
        } else if (!z2 || !z) {
            AppMethodBeat.o(11297);
            return 1;
        } else {
            AppMethodBeat.o(11297);
            return 2;
        }
    }

    private final void zza(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        AppMethodBeat.i(11272);
        Common.CommonApi.clearDefaultAccount(googleApiClient).setResultCallback(new zzaz(this, statusPendingResult, z, googleApiClient));
        AppMethodBeat.o(11272);
    }

    static /* synthetic */ void zza(zzav zzav) {
        AppMethodBeat.i(11298);
        zzav.resume();
        AppMethodBeat.o(11298);
    }

    static /* synthetic */ void zza(zzav zzav, GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        AppMethodBeat.i(11300);
        zzav.zza(googleApiClient, statusPendingResult, true);
        AppMethodBeat.o(11300);
    }

    @GuardedBy("mLock")
    private final void zzax() {
        AppMethodBeat.i(11277);
        this.zzie.enableCallbacks();
        this.zzif.connect();
        AppMethodBeat.o(11277);
    }

    private final void zzay() {
        AppMethodBeat.i(11279);
        this.zzga.lock();
        try {
            if (zzaz()) {
                zzax();
            }
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11279);
        }
    }

    static /* synthetic */ void zzb(zzav zzav) {
        AppMethodBeat.i(11299);
        zzav.zzay();
        AppMethodBeat.o(11299);
    }

    private final void zzg(int i2) {
        AppMethodBeat.i(11276);
        if (this.zzip == null) {
            this.zzip = Integer.valueOf(i2);
        } else if (this.zzip.intValue() != i2) {
            String zzh = zzh(i2);
            String zzh2 = zzh(this.zzip.intValue());
            IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(zzh).length() + 51 + String.valueOf(zzh2).length()).append("Cannot use sign-in mode: ").append(zzh).append(". Mode was already set to ").append(zzh2).toString());
            AppMethodBeat.o(11276);
            throw illegalStateException;
        }
        if (this.zzif != null) {
            AppMethodBeat.o(11276);
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (Api.Client client : this.zzil.values()) {
            if (client.requiresSignIn()) {
                z2 = true;
            }
            z = client.providesSignIn() ? true : z;
        }
        switch (this.zzip.intValue()) {
            case 1:
                if (!z2) {
                    IllegalStateException illegalStateException2 = new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    AppMethodBeat.o(11276);
                    throw illegalStateException2;
                } else if (z) {
                    IllegalStateException illegalStateException3 = new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    AppMethodBeat.o(11276);
                    throw illegalStateException3;
                }
                break;
            case 2:
                if (z2) {
                    if (this.zzdk) {
                        this.zzif = new zzw(this.mContext, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio, this, true);
                        AppMethodBeat.o(11276);
                        return;
                    }
                    this.zzif = zzr.zza(this.mContext, this, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio);
                    AppMethodBeat.o(11276);
                    return;
                }
                break;
        }
        if (!this.zzdk || z) {
            this.zzif = new zzbd(this.mContext, this, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio, this);
            AppMethodBeat.o(11276);
            return;
        }
        this.zzif = new zzw(this.mContext, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio, this, false);
        AppMethodBeat.o(11276);
    }

    private static String zzh(int i2) {
        switch (i2) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect() {
        boolean z = true;
        AppMethodBeat.i(11267);
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zzga.lock();
        try {
            if (this.zzde >= 0) {
                if (this.zzip == null) {
                    z = false;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzip == null) {
                this.zzip = Integer.valueOf(zza(this.zzil.values(), false));
            } else if (this.zzip.intValue() == 2) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                AppMethodBeat.o(11267);
                throw illegalStateException;
            }
            zzg(this.zzip.intValue());
            this.zzie.enableCallbacks();
            return this.zzif.blockingConnect();
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11267);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect(long j2, TimeUnit timeUnit) {
        boolean z = false;
        AppMethodBeat.i(11268);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        Preconditions.checkState(z, "blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.zzga.lock();
        try {
            if (this.zzip == null) {
                this.zzip = Integer.valueOf(zza(this.zzil.values(), false));
            } else if (this.zzip.intValue() == 2) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                AppMethodBeat.o(11268);
                throw illegalStateException;
            }
            zzg(this.zzip.intValue());
            this.zzie.enableCallbacks();
            return this.zzif.blockingConnect(j2, timeUnit);
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11268);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        AppMethodBeat.i(11271);
        Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
        Preconditions.checkState(this.zzip.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult(this);
        if (this.zzil.containsKey(Common.CLIENT_KEY)) {
            zza(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new GoogleApiClient.Builder(this.mContext).addApi(Common.API).addConnectionCallbacks(new zzax(this, atomicReference, statusPendingResult)).addOnConnectionFailedListener(new zzay(this, statusPendingResult)).setHandler(this.zzij).build();
            atomicReference.set(build);
            build.connect();
        }
        AppMethodBeat.o(11271);
        return statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect() {
        boolean z = false;
        AppMethodBeat.i(11265);
        this.zzga.lock();
        try {
            if (this.zzde >= 0) {
                if (this.zzip != null) {
                    z = true;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzip == null) {
                this.zzip = Integer.valueOf(zza(this.zzil.values(), false));
            } else if (this.zzip.intValue() == 2) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                AppMethodBeat.o(11265);
                throw illegalStateException;
            }
            connect(this.zzip.intValue());
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11265);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect(int i2) {
        boolean z = true;
        AppMethodBeat.i(11266);
        this.zzga.lock();
        if (!(i2 == 3 || i2 == 1 || i2 == 2)) {
            z = false;
        }
        try {
            Preconditions.checkArgument(z, new StringBuilder(33).append("Illegal sign-in mode: ").append(i2).toString());
            zzg(i2);
            zzax();
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11266);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void disconnect() {
        AppMethodBeat.i(11269);
        this.zzga.lock();
        try {
            this.zzir.release();
            if (this.zzif != null) {
                this.zzif.disconnect();
            }
            this.zzin.release();
            for (BaseImplementation.ApiMethodImpl<?, ?> apiMethodImpl : this.zzgo) {
                apiMethodImpl.zza((zzcn) null);
                apiMethodImpl.cancel();
            }
            this.zzgo.clear();
            if (this.zzif != null) {
                zzaz();
                this.zzie.disableCallbacks();
                this.zzga.unlock();
                AppMethodBeat.o(11269);
            }
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11269);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.i(11296);
        printWriter.append((CharSequence) str).append("mContext=").println(this.mContext);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.zzig);
        printWriter.append(" mWorkQueue.size()=").print(this.zzgo.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zzir.zzmo.size());
        if (this.zzif != null) {
            this.zzif.dump(str, fileDescriptor, printWriter, strArr);
        }
        AppMethodBeat.o(11296);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.i(11258);
        Preconditions.checkArgument(t.getClientKey() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.zzil.containsKey(t.getClientKey());
        String name = t.getApi() != null ? t.getApi().getName() : "the API";
        Preconditions.checkArgument(containsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.zzga.lock();
        try {
            if (this.zzif == null) {
                this.zzgo.add(t);
                return t;
            }
            T t2 = (T) this.zzif.enqueue(t);
            this.zzga.unlock();
            AppMethodBeat.o(11258);
            return t2;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11258);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.i(11259);
        Preconditions.checkArgument(t.getClientKey() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.zzil.containsKey(t.getClientKey());
        String name = t.getApi() != null ? t.getApi().getName() : "the API";
        Preconditions.checkArgument(containsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.zzga.lock();
        try {
            if (this.zzif == null) {
                IllegalStateException illegalStateException = new IllegalStateException("GoogleApiClient is not connected yet.");
                AppMethodBeat.o(11259);
                throw illegalStateException;
            } else if (this.zzig) {
                this.zzgo.add(t);
                while (!this.zzgo.isEmpty()) {
                    BaseImplementation.ApiMethodImpl<?, ?> remove = this.zzgo.remove();
                    this.zzir.zzb(remove);
                    remove.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                }
                return t;
            } else {
                T t2 = (T) this.zzif.execute(t);
                this.zzga.unlock();
                AppMethodBeat.o(11259);
                return t2;
            }
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11259);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <C extends Api.Client> C getClient(Api.AnyClientKey<C> anyClientKey) {
        AppMethodBeat.i(11261);
        C c2 = (C) this.zzil.get(anyClientKey);
        Preconditions.checkNotNull(c2, "Appropriate Api was not requested.");
        AppMethodBeat.o(11261);
        return c2;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult getConnectionResult(Api<?> api) {
        AppMethodBeat.i(11264);
        this.zzga.lock();
        try {
            if (!isConnected() && !this.zzig) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
                AppMethodBeat.o(11264);
                throw illegalStateException;
            } else if (this.zzil.containsKey(api.getClientKey())) {
                ConnectionResult connectionResult = this.zzif.getConnectionResult(api);
                if (connectionResult != null) {
                    this.zzga.unlock();
                    AppMethodBeat.o(11264);
                    return connectionResult;
                } else if (this.zzig) {
                    return ConnectionResult.RESULT_SUCCESS;
                } else {
                    zzbb();
                    Log.wtf("GoogleApiClientImpl", String.valueOf(api.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                    ConnectionResult connectionResult2 = new ConnectionResult(8, null);
                    this.zzga.unlock();
                    AppMethodBeat.o(11264);
                    return connectionResult2;
                }
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(api.getName()).concat(" was never registered with GoogleApiClient"));
                AppMethodBeat.o(11264);
                throw illegalArgumentException;
            }
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11264);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context getContext() {
        return this.mContext;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper getLooper() {
        return this.zzcn;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasApi(Api<?> api) {
        AppMethodBeat.i(11262);
        boolean containsKey = this.zzil.containsKey(api.getClientKey());
        AppMethodBeat.o(11262);
        return containsKey;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasConnectedApi(Api<?> api) {
        AppMethodBeat.i(11263);
        if (!isConnected()) {
            AppMethodBeat.o(11263);
            return false;
        }
        Api.Client client = this.zzil.get(api.getClientKey());
        if (client == null || !client.isConnected()) {
            AppMethodBeat.o(11263);
            return false;
        }
        AppMethodBeat.o(11263);
        return true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnected() {
        AppMethodBeat.i(11274);
        if (this.zzif == null || !this.zzif.isConnected()) {
            AppMethodBeat.o(11274);
            return false;
        }
        AppMethodBeat.o(11274);
        return true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnecting() {
        AppMethodBeat.i(11275);
        if (this.zzif == null || !this.zzif.isConnecting()) {
            AppMethodBeat.o(11275);
            return false;
        }
        AppMethodBeat.o(11275);
        return true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.i(11282);
        boolean isConnectionCallbacksRegistered = this.zzie.isConnectionCallbacksRegistered(connectionCallbacks);
        AppMethodBeat.o(11282);
        return isConnectionCallbacksRegistered;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(11285);
        boolean isConnectionFailedListenerRegistered = this.zzie.isConnectionFailedListenerRegistered(onConnectionFailedListener);
        AppMethodBeat.o(11285);
        return isConnectionFailedListenerRegistered;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        AppMethodBeat.i(11290);
        if (this.zzif == null || !this.zzif.maybeSignIn(signInConnectionListener)) {
            AppMethodBeat.o(11290);
            return false;
        }
        AppMethodBeat.o(11290);
        return true;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void maybeSignOut() {
        AppMethodBeat.i(11291);
        if (this.zzif != null) {
            this.zzif.maybeSignOut();
        }
        AppMethodBeat.o(11291);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void reconnect() {
        AppMethodBeat.i(11270);
        disconnect();
        connect();
        AppMethodBeat.o(11270);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.i(11281);
        this.zzie.registerConnectionCallbacks(connectionCallbacks);
        AppMethodBeat.o(11281);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(11284);
        this.zzie.registerConnectionFailedListener(onConnectionFailedListener);
        AppMethodBeat.o(11284);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <L> ListenerHolder<L> registerListener(L l) {
        AppMethodBeat.i(11260);
        this.zzga.lock();
        try {
            return this.zzin.zza(l, this.zzcn, "NO_TYPE");
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11260);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void stopAutoManage(FragmentActivity fragmentActivity) {
        AppMethodBeat.i(11273);
        LifecycleActivity lifecycleActivity = new LifecycleActivity(fragmentActivity);
        if (this.zzde >= 0) {
            zzi.zza(lifecycleActivity).zzc(this.zzde);
            AppMethodBeat.o(11273);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        AppMethodBeat.o(11273);
        throw illegalStateException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.i(11283);
        this.zzie.unregisterConnectionCallbacks(connectionCallbacks);
        AppMethodBeat.o(11283);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(11286);
        this.zzie.unregisterConnectionFailedListener(onConnectionFailedListener);
        AppMethodBeat.o(11286);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zza(zzch zzch) {
        AppMethodBeat.i(11292);
        this.zzga.lock();
        try {
            if (this.zziq == null) {
                this.zziq = new HashSet();
            }
            this.zziq.add(zzch);
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11292);
        }
    }

    /* access modifiers changed from: package-private */
    @GuardedBy("mLock")
    public final boolean zzaz() {
        AppMethodBeat.i(11280);
        if (!this.zzig) {
            AppMethodBeat.o(11280);
            return false;
        }
        this.zzig = false;
        this.zzij.removeMessages(2);
        this.zzij.removeMessages(1);
        if (this.zzik != null) {
            this.zzik.unregister();
            this.zzik = null;
        }
        AppMethodBeat.o(11280);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zzbq
    @GuardedBy("mLock")
    public final void zzb(int i2, boolean z) {
        AppMethodBeat.i(11289);
        if (i2 == 1 && !z && !this.zzig) {
            this.zzig = true;
            if (this.zzik == null) {
                this.zzik = this.zzdg.registerCallbackOnUpdate(this.mContext.getApplicationContext(), new zzbb(this));
            }
            this.zzij.sendMessageDelayed(this.zzij.obtainMessage(1), this.zzih);
            this.zzij.sendMessageDelayed(this.zzij.obtainMessage(2), this.zzii);
        }
        this.zzir.zzce();
        this.zzie.onUnintentionalDisconnection(i2);
        this.zzie.disableCallbacks();
        if (i2 == 2) {
            zzax();
        }
        AppMethodBeat.o(11289);
    }

    @Override // com.google.android.gms.common.api.internal.zzbq
    @GuardedBy("mLock")
    public final void zzb(Bundle bundle) {
        AppMethodBeat.i(11287);
        while (!this.zzgo.isEmpty()) {
            execute(this.zzgo.remove());
        }
        this.zzie.onConnectionSuccess(bundle);
        AppMethodBeat.o(11287);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zzb(zzch zzch) {
        AppMethodBeat.i(11293);
        this.zzga.lock();
        try {
            if (this.zziq == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.zziq.remove(zzch)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!zzba()) {
                this.zzif.zzz();
            }
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11293);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzba() {
        boolean z = false;
        AppMethodBeat.i(11294);
        this.zzga.lock();
        try {
            if (this.zziq != null) {
                if (!this.zziq.isEmpty()) {
                    z = true;
                }
                this.zzga.unlock();
                AppMethodBeat.o(11294);
            }
            return z;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(11294);
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzbb() {
        AppMethodBeat.i(11295);
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(11295);
        return stringWriter2;
    }

    @Override // com.google.android.gms.common.api.internal.zzbq
    @GuardedBy("mLock")
    public final void zzc(ConnectionResult connectionResult) {
        AppMethodBeat.i(11288);
        if (!this.zzdg.isPlayServicesPossiblyUpdating(this.mContext, connectionResult.getErrorCode())) {
            zzaz();
        }
        if (!this.zzig) {
            this.zzie.onConnectionFailure(connectionResult);
            this.zzie.disableCallbacks();
        }
        AppMethodBeat.o(11288);
    }
}
