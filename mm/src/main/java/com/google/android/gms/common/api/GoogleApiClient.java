package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.e.a;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zzav;
import com.google.android.gms.common.api.internal.zzch;
import com.google.android.gms.common.api.internal.zzi;
import com.google.android.gms.common.api.internal.zzp;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignIn;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class GoogleApiClient {
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    @GuardedBy("sAllClients")
    private static final Set<GoogleApiClient> zzcu = Collections.newSetFromMap(new WeakHashMap());

    @KeepForSdk
    public static final class Builder {
        private final Context mContext;
        private Looper zzcn;
        private final Set<Scope> zzcv;
        private final Set<Scope> zzcw;
        private int zzcx;
        private View zzcy;
        private String zzcz;
        private String zzda;
        private final Map<Api<?>, ClientSettings.OptionalApiSettings> zzdb;
        private final Map<Api<?>, Api.ApiOptions> zzdc;
        private LifecycleActivity zzdd;
        private int zzde;
        private OnConnectionFailedListener zzdf;
        private GoogleApiAvailability zzdg;
        private Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
        private final ArrayList<ConnectionCallbacks> zzdi;
        private final ArrayList<OnConnectionFailedListener> zzdj;
        private boolean zzdk;
        private Account zzs;

        @KeepForSdk
        public Builder(Context context) {
            AppMethodBeat.i(11026);
            this.zzcv = new HashSet();
            this.zzcw = new HashSet();
            this.zzdb = new a();
            this.zzdc = new a();
            this.zzde = -1;
            this.zzdg = GoogleApiAvailability.getInstance();
            this.zzdh = SignIn.CLIENT_BUILDER;
            this.zzdi = new ArrayList<>();
            this.zzdj = new ArrayList<>();
            this.zzdk = false;
            this.mContext = context;
            this.zzcn = context.getMainLooper();
            this.zzcz = context.getPackageName();
            this.zzda = context.getClass().getName();
            AppMethodBeat.o(11026);
        }

        @KeepForSdk
        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            AppMethodBeat.i(11027);
            Preconditions.checkNotNull(connectionCallbacks, "Must provide a connected listener");
            this.zzdi.add(connectionCallbacks);
            Preconditions.checkNotNull(onConnectionFailedListener, "Must provide a connection failed listener");
            this.zzdj.add(onConnectionFailedListener);
            AppMethodBeat.o(11027);
        }

        private final <O extends Api.ApiOptions> void zza(Api<O> api, O o, Scope... scopeArr) {
            AppMethodBeat.i(11044);
            HashSet hashSet = new HashSet(api.zzj().getImpliedScopes(o));
            for (Scope scope : scopeArr) {
                hashSet.add(scope);
            }
            this.zzdb.put(api, new ClientSettings.OptionalApiSettings(hashSet));
            AppMethodBeat.o(11044);
        }

        public final Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            AppMethodBeat.i(11034);
            Preconditions.checkNotNull(api, "Api must not be null");
            this.zzdc.put(api, null);
            List<Scope> impliedScopes = api.zzj().getImpliedScopes(null);
            this.zzcw.addAll(impliedScopes);
            this.zzcv.addAll(impliedScopes);
            AppMethodBeat.o(11034);
            return this;
        }

        public final <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> api, O o) {
            AppMethodBeat.i(11036);
            Preconditions.checkNotNull(api, "Api must not be null");
            Preconditions.checkNotNull(o, "Null options are not permitted for this Api");
            this.zzdc.put(api, o);
            List<Scope> impliedScopes = api.zzj().getImpliedScopes(o);
            this.zzcw.addAll(impliedScopes);
            this.zzcv.addAll(impliedScopes);
            AppMethodBeat.o(11036);
            return this;
        }

        public final <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(Api<O> api, O o, Scope... scopeArr) {
            AppMethodBeat.i(11037);
            Preconditions.checkNotNull(api, "Api must not be null");
            Preconditions.checkNotNull(o, "Null options are not permitted for this Api");
            this.zzdc.put(api, o);
            zza(api, o, scopeArr);
            AppMethodBeat.o(11037);
            return this;
        }

        public final Builder addApiIfAvailable(Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            AppMethodBeat.i(11035);
            Preconditions.checkNotNull(api, "Api must not be null");
            this.zzdc.put(api, null);
            zza(api, null, scopeArr);
            AppMethodBeat.o(11035);
            return this;
        }

        public final Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            AppMethodBeat.i(11029);
            Preconditions.checkNotNull(connectionCallbacks, "Listener must not be null");
            this.zzdi.add(connectionCallbacks);
            AppMethodBeat.o(11029);
            return this;
        }

        public final Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            AppMethodBeat.i(11030);
            Preconditions.checkNotNull(onConnectionFailedListener, "Listener must not be null");
            this.zzdj.add(onConnectionFailedListener);
            AppMethodBeat.o(11030);
            return this;
        }

        public final Builder addScope(Scope scope) {
            AppMethodBeat.i(11032);
            Preconditions.checkNotNull(scope, "Scope must not be null");
            this.zzcv.add(scope);
            AppMethodBeat.o(11032);
            return this;
        }

        @KeepForSdk
        public final Builder addScopeNames(String[] strArr) {
            AppMethodBeat.i(11033);
            for (String str : strArr) {
                this.zzcv.add(new Scope(str));
            }
            AppMethodBeat.o(11033);
            return this;
        }

        public final GoogleApiClient build() {
            AppMethodBeat.i(11043);
            Preconditions.checkArgument(!this.zzdc.isEmpty(), "must call addApi() to add at least one API");
            ClientSettings buildClientSettings = buildClientSettings();
            Api<?> api = null;
            Map<Api<?>, ClientSettings.OptionalApiSettings> optionalApiSettings = buildClientSettings.getOptionalApiSettings();
            a aVar = new a();
            a aVar2 = new a();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Api<?> api2 : this.zzdc.keySet()) {
                Api.ApiOptions apiOptions = this.zzdc.get(api2);
                boolean z2 = optionalApiSettings.get(api2) != null;
                aVar.put(api2, Boolean.valueOf(z2));
                zzp zzp = new zzp(api2, z2);
                arrayList.add(zzp);
                Api.AbstractClientBuilder<?, ?> zzk = api2.zzk();
                Api.Client buildClient = zzk.buildClient(this.mContext, this.zzcn, buildClientSettings, apiOptions, zzp, zzp);
                aVar2.put(api2.getClientKey(), buildClient);
                boolean z3 = zzk.getPriority() == 1 ? apiOptions != null : z;
                if (!buildClient.providesSignIn()) {
                    api2 = api;
                } else if (api != null) {
                    String name = api2.getName();
                    String name2 = api.getName();
                    IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(name).length() + 21 + String.valueOf(name2).length()).append(name).append(" cannot be used with ").append(name2).toString());
                    AppMethodBeat.o(11043);
                    throw illegalStateException;
                }
                z = z3;
                api = api2;
            }
            if (api != null) {
                if (z) {
                    String name3 = api.getName();
                    IllegalStateException illegalStateException2 = new IllegalStateException(new StringBuilder(String.valueOf(name3).length() + 82).append("With using ").append(name3).append(", GamesOptions can only be specified within GoogleSignInOptions.Builder").toString());
                    AppMethodBeat.o(11043);
                    throw illegalStateException2;
                }
                Preconditions.checkState(this.zzs == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.getName());
                Preconditions.checkState(this.zzcv.equals(this.zzcw), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.getName());
            }
            zzav zzav = new zzav(this.mContext, new ReentrantLock(), this.zzcn, buildClientSettings, this.zzdg, this.zzdh, aVar, this.zzdi, this.zzdj, aVar2, this.zzde, zzav.zza(aVar2.values(), true), arrayList, false);
            synchronized (GoogleApiClient.zzcu) {
                try {
                    GoogleApiClient.zzcu.add(zzav);
                } finally {
                    AppMethodBeat.o(11043);
                }
            }
            if (this.zzde >= 0) {
                zzi.zza(this.zzdd).zza(this.zzde, zzav, this.zzdf);
            }
            return zzav;
        }

        @VisibleForTesting
        @KeepForSdk
        public final ClientSettings buildClientSettings() {
            AppMethodBeat.i(11042);
            SignInOptions signInOptions = SignInOptions.DEFAULT;
            if (this.zzdc.containsKey(SignIn.API)) {
                signInOptions = (SignInOptions) this.zzdc.get(SignIn.API);
            }
            ClientSettings clientSettings = new ClientSettings(this.zzs, this.zzcv, this.zzdb, this.zzcx, this.zzcy, this.zzcz, this.zzda, signInOptions);
            AppMethodBeat.o(11042);
            return clientSettings;
        }

        public final Builder enableAutoManage(FragmentActivity fragmentActivity, int i2, OnConnectionFailedListener onConnectionFailedListener) {
            AppMethodBeat.i(11040);
            LifecycleActivity lifecycleActivity = new LifecycleActivity(fragmentActivity);
            Preconditions.checkArgument(i2 >= 0, "clientId must be non-negative");
            this.zzde = i2;
            this.zzdf = onConnectionFailedListener;
            this.zzdd = lifecycleActivity;
            AppMethodBeat.o(11040);
            return this;
        }

        public final Builder enableAutoManage(FragmentActivity fragmentActivity, OnConnectionFailedListener onConnectionFailedListener) {
            AppMethodBeat.i(11041);
            Builder enableAutoManage = enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
            AppMethodBeat.o(11041);
            return enableAutoManage;
        }

        public final Builder setAccountName(String str) {
            AppMethodBeat.i(11038);
            this.zzs = str == null ? null : new Account(str, "com.google");
            AppMethodBeat.o(11038);
            return this;
        }

        public final Builder setGravityForPopups(int i2) {
            this.zzcx = i2;
            return this;
        }

        public final Builder setHandler(Handler handler) {
            AppMethodBeat.i(11028);
            Preconditions.checkNotNull(handler, "Handler must not be null");
            this.zzcn = handler.getLooper();
            AppMethodBeat.o(11028);
            return this;
        }

        public final Builder setViewForPopups(View view) {
            AppMethodBeat.i(11031);
            Preconditions.checkNotNull(view, "View must not be null");
            this.zzcy = view;
            AppMethodBeat.o(11031);
            return this;
        }

        public final Builder useDefaultAccount() {
            AppMethodBeat.i(11039);
            Builder accountName = setAccountName("<<default account>>");
            AppMethodBeat.o(11039);
            return accountName;
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i2);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (zzcu) {
            String concat = String.valueOf(str).concat("  ");
            int i2 = 0;
            for (GoogleApiClient googleApiClient : zzcu) {
                printWriter.append((CharSequence) str).append("GoogleApiClient#").println(i2);
                googleApiClient.dump(concat, fileDescriptor, printWriter, strArr);
                i2++;
            }
        }
    }

    @KeepForSdk
    public static Set<GoogleApiClient> getAllClients() {
        Set<GoogleApiClient> set;
        synchronized (zzcu) {
            set = zzcu;
        }
        return set;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j2, TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i2) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @KeepForSdk
    public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public <C extends Api.Client> C getClient(Api.AnyClientKey<C> anyClientKey) {
        throw new UnsupportedOperationException();
    }

    public abstract ConnectionResult getConnectionResult(Api<?> api);

    @KeepForSdk
    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public boolean hasApi(Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    @KeepForSdk
    public boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public void maybeSignOut() {
        throw new UnsupportedOperationException();
    }

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(L l) {
        throw new UnsupportedOperationException();
    }

    public abstract void stopAutoManage(FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public void zza(zzch zzch) {
        throw new UnsupportedOperationException();
    }

    public void zzb(zzch zzch) {
        throw new UnsupportedOperationException();
    }
}
