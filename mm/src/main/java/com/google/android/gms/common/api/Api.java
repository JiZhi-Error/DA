package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions> {
    private final String mName;
    private final AbstractClientBuilder<?, O> zzby;
    private final zza<?, O> zzbz = null;
    private final ClientKey<?> zzca;
    private final zzb<?> zzcb;

    @VisibleForTesting
    @KeepForSdk
    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        @KeepForSdk
        public abstract T buildClient(Context context, Looper looper, ClientSettings clientSettings, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener);
    }

    @KeepForSdk
    public interface AnyClient {
    }

    @KeepForSdk
    public static class AnyClientKey<C extends AnyClient> {
    }

    public interface ApiOptions {

        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            Account getAccount();
        }

        public interface HasGoogleSignInAccountOptions extends HasOptions {
            GoogleSignInAccount getGoogleSignInAccount();
        }

        public interface HasOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public static abstract class BaseClientBuilder<T extends AnyClient, O> {
        @KeepForSdk
        public static final int API_PRIORITY_GAMES = 1;
        @KeepForSdk
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        @KeepForSdk
        public static final int API_PRIORITY_PLUS = 2;

        @KeepForSdk
        public List<Scope> getImpliedScopes(O o) {
            AppMethodBeat.i(10969);
            List<Scope> emptyList = Collections.emptyList();
            AppMethodBeat.o(10969);
            return emptyList;
        }

        @KeepForSdk
        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    @KeepForSdk
    public interface Client extends AnyClient {
        void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        Feature[] getAvailableFeatures();

        String getEndpointPackageName();

        int getMinApkVersion();

        void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set);

        IBinder getServiceBrokerBinder();

        Intent getSignInIntent();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks);

        boolean providesSignIn();

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    @VisibleForTesting
    @KeepForSdk
    public static final class ClientKey<C extends Client> extends AnyClientKey<C> {
    }

    public interface SimpleClient<T extends IInterface> extends AnyClient {
        T createServiceInterface(IBinder iBinder);

        String getServiceDescriptor();

        String getStartServiceAction();

        void setState(int i2, T t);
    }

    @VisibleForTesting
    public static abstract class zza<T extends SimpleClient, O> extends BaseClientBuilder<T, O> {
    }

    @VisibleForTesting
    public static final class zzb<C extends SimpleClient> extends AnyClientKey<C> {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.android.gms.common.api.Api$AbstractClientBuilder<C extends com.google.android.gms.common.api.Api$Client, O extends com.google.android.gms.common.api.Api$ApiOptions> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.android.gms.common.api.Api$ClientKey<C extends com.google.android.gms.common.api.Api$Client> */
    /* JADX WARN: Multi-variable type inference failed */
    public <C extends Client> Api(String str, AbstractClientBuilder<C, O> abstractClientBuilder, ClientKey<C> clientKey) {
        AppMethodBeat.i(10970);
        Preconditions.checkNotNull(abstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
        Preconditions.checkNotNull(clientKey, "Cannot construct an Api with a null ClientKey");
        this.mName = str;
        this.zzby = abstractClientBuilder;
        this.zzca = clientKey;
        this.zzcb = null;
        AppMethodBeat.o(10970);
    }

    public final AnyClientKey<?> getClientKey() {
        AppMethodBeat.i(10972);
        if (this.zzca != null) {
            ClientKey<?> clientKey = this.zzca;
            AppMethodBeat.o(10972);
            return clientKey;
        }
        IllegalStateException illegalStateException = new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
        AppMethodBeat.o(10972);
        throw illegalStateException;
    }

    public final String getName() {
        return this.mName;
    }

    public final BaseClientBuilder<?, O> zzj() {
        return this.zzby;
    }

    public final AbstractClientBuilder<?, O> zzk() {
        AppMethodBeat.i(10971);
        Preconditions.checkState(this.zzby != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        AbstractClientBuilder<?, O> abstractClientBuilder = this.zzby;
        AppMethodBeat.o(10971);
        return abstractClientBuilder;
    }
}
