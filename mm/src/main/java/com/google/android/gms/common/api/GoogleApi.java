package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zzad;
import com.google.android.gms.common.api.internal.zzbo;
import com.google.android.gms.common.api.internal.zzby;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import java.util.Collections;

@KeepForSdk
public class GoogleApi<O extends Api.ApiOptions> {
    private final Api<O> mApi;
    private final Context mContext;
    private final int mId;
    private final O zzcl;
    private final zzh<O> zzcm;
    private final Looper zzcn;
    private final GoogleApiClient zzco;
    private final StatusExceptionMapper zzcp;
    protected final GoogleApiManager zzcq;

    @KeepForSdk
    public static class Settings {
        @KeepForSdk
        public static final Settings DEFAULT_SETTINGS = new Builder().build();
        public final StatusExceptionMapper zzcr;
        public final Looper zzcs;

        @KeepForSdk
        public static class Builder {
            private Looper zzcn;
            private StatusExceptionMapper zzcp;

            @KeepForSdk
            public Settings build() {
                AppMethodBeat.i(10997);
                if (this.zzcp == null) {
                    this.zzcp = new ApiExceptionMapper();
                }
                if (this.zzcn == null) {
                    this.zzcn = Looper.getMainLooper();
                }
                Settings settings = new Settings(this.zzcp, this.zzcn);
                AppMethodBeat.o(10997);
                return settings;
            }

            @KeepForSdk
            public Builder setLooper(Looper looper) {
                AppMethodBeat.i(10996);
                Preconditions.checkNotNull(looper, "Looper must not be null.");
                this.zzcn = looper;
                AppMethodBeat.o(10996);
                return this;
            }

            @KeepForSdk
            public Builder setMapper(StatusExceptionMapper statusExceptionMapper) {
                AppMethodBeat.i(10995);
                Preconditions.checkNotNull(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.zzcp = statusExceptionMapper;
                AppMethodBeat.o(10995);
                return this;
            }
        }

        static {
            AppMethodBeat.i(10998);
            AppMethodBeat.o(10998);
        }

        @KeepForSdk
        private Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.zzcr = statusExceptionMapper;
            this.zzcs = looper;
        }
    }

    @KeepForSdk
    public GoogleApi(Activity activity, Api<O> api, O o, Settings settings) {
        AppMethodBeat.i(11001);
        Preconditions.checkNotNull(activity, "Null activity is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = activity.getApplicationContext();
        this.mApi = api;
        this.zzcl = o;
        this.zzcn = settings.zzcs;
        this.zzcm = zzh.zza(this.mApi, this.zzcl);
        this.zzco = new zzbo(this);
        this.zzcq = GoogleApiManager.zzb(this.mContext);
        this.mId = this.zzcq.zzbg();
        this.zzcp = settings.zzcr;
        zzad.zza(activity, this.zzcq, this.zzcm);
        this.zzcq.zza((GoogleApi<?>) this);
        AppMethodBeat.o(11001);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Activity activity, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        this(activity, (Api) api, (Api.ApiOptions) o, new Settings.Builder().setMapper(statusExceptionMapper).setLooper(activity.getMainLooper()).build());
        AppMethodBeat.i(11003);
        AppMethodBeat.o(11003);
    }

    @KeepForSdk
    protected GoogleApi(Context context, Api<O> api, Looper looper) {
        AppMethodBeat.i(10999);
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(looper, "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.mApi = api;
        this.zzcl = null;
        this.zzcn = looper;
        this.zzcm = zzh.zza(api);
        this.zzco = new zzbo(this);
        this.zzcq = GoogleApiManager.zzb(this.mContext);
        this.mId = this.zzcq.zzbg();
        this.zzcp = new ApiExceptionMapper();
        AppMethodBeat.o(10999);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, Looper looper, StatusExceptionMapper statusExceptionMapper) {
        this(context, api, o, new Settings.Builder().setLooper(looper).setMapper(statusExceptionMapper).build());
        AppMethodBeat.i(11000);
        AppMethodBeat.o(11000);
    }

    @KeepForSdk
    public GoogleApi(Context context, Api<O> api, O o, Settings settings) {
        AppMethodBeat.i(ErrorCode.ERROR_OUTOF_MEMORY);
        Preconditions.checkNotNull(context, "Null context is not permitted.");
        Preconditions.checkNotNull(api, "Api must not be null.");
        Preconditions.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = context.getApplicationContext();
        this.mApi = api;
        this.zzcl = o;
        this.zzcn = settings.zzcs;
        this.zzcm = zzh.zza(this.mApi, this.zzcl);
        this.zzco = new zzbo(this);
        this.zzcq = GoogleApiManager.zzb(this.mContext);
        this.mId = this.zzcq.zzbg();
        this.zzcp = settings.zzcr;
        this.zzcq.zza((GoogleApi<?>) this);
        AppMethodBeat.o(ErrorCode.ERROR_OUTOF_MEMORY);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        this(context, api, o, new Settings.Builder().setMapper(statusExceptionMapper).build());
        AppMethodBeat.i(11004);
        AppMethodBeat.o(11004);
    }

    private final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zza(int i2, T t) {
        AppMethodBeat.i(11005);
        t.zzx();
        this.zzcq.zza(this, i2, t);
        AppMethodBeat.o(11005);
        return t;
    }

    private final <TResult, A extends Api.AnyClient> Task<TResult> zza(int i2, TaskApiCall<A, TResult> taskApiCall) {
        AppMethodBeat.i(11006);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzcq.zza(this, i2, taskApiCall, taskCompletionSource, this.zzcp);
        Task<TResult> task = taskCompletionSource.getTask();
        AppMethodBeat.o(11006);
        return task;
    }

    @KeepForSdk
    public GoogleApiClient asGoogleApiClient() {
        return this.zzco;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public ClientSettings.Builder createClientSettingsBuilder() {
        GoogleSignInAccount googleSignInAccount;
        GoogleSignInAccount googleSignInAccount2;
        AppMethodBeat.i(11018);
        ClientSettings.Builder realClientPackageName = new ClientSettings.Builder().setAccount((!(this.zzcl instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) this.zzcl).getGoogleSignInAccount()) == null) ? this.zzcl instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) this.zzcl).getAccount() : null : googleSignInAccount2.getAccount()).addAllRequiredScopes((!(this.zzcl instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccount = ((Api.ApiOptions.HasGoogleSignInAccountOptions) this.zzcl).getGoogleSignInAccount()) == null) ? Collections.emptySet() : googleSignInAccount.getRequestedScopes()).setRealClientClassName(this.mContext.getClass().getName()).setRealClientPackageName(this.mContext.getPackageName());
        AppMethodBeat.o(11018);
        return realClientPackageName;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public Task<Boolean> disconnectService() {
        AppMethodBeat.i(11016);
        Task<Boolean> zzc = this.zzcq.zzc((GoogleApi<?>) this);
        AppMethodBeat.o(11016);
        return zzc;
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(T t) {
        AppMethodBeat.i(11011);
        T t2 = (T) zza(2, t);
        AppMethodBeat.o(11011);
        return t2;
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> taskApiCall) {
        AppMethodBeat.i(11012);
        Task<TResult> zza = zza(2, taskApiCall);
        AppMethodBeat.o(11012);
        return zza;
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(T t) {
        AppMethodBeat.i(11007);
        T t2 = (T) zza(0, t);
        AppMethodBeat.o(11007);
        return t2;
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> taskApiCall) {
        AppMethodBeat.i(11008);
        Task<TResult> zza = zza(0, taskApiCall);
        AppMethodBeat.o(11008);
        return zza;
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(T t, U u) {
        AppMethodBeat.i(11013);
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(u);
        Preconditions.checkNotNull(t.getListenerKey(), "Listener has already been released.");
        Preconditions.checkNotNull(u.getListenerKey(), "Listener has already been released.");
        Preconditions.checkArgument(t.getListenerKey().equals(u.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        Task<Void> zza = this.zzcq.zza(this, t, u);
        AppMethodBeat.o(11013);
        return zza;
    }

    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey) {
        AppMethodBeat.i(11014);
        Preconditions.checkNotNull(listenerKey, "Listener key cannot be null.");
        Task<Boolean> zza = this.zzcq.zza(this, listenerKey);
        AppMethodBeat.o(11014);
        return zza;
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(T t) {
        AppMethodBeat.i(11009);
        T t2 = (T) zza(1, t);
        AppMethodBeat.o(11009);
        return t2;
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> taskApiCall) {
        AppMethodBeat.i(11010);
        Task<TResult> zza = zza(1, taskApiCall);
        AppMethodBeat.o(11010);
        return zza;
    }

    public final Api<O> getApi() {
        return this.mApi;
    }

    @KeepForSdk
    public O getApiOptions() {
        return this.zzcl;
    }

    @KeepForSdk
    public Context getApplicationContext() {
        return this.mContext;
    }

    public final int getInstanceId() {
        return this.mId;
    }

    @KeepForSdk
    public Looper getLooper() {
        return this.zzcn;
    }

    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(L l, String str) {
        AppMethodBeat.i(11015);
        ListenerHolder<L> createListenerHolder = ListenerHolders.createListenerHolder(l, this.zzcn, str);
        AppMethodBeat.o(11015);
        return createListenerHolder;
    }

    public Api.Client zza(Looper looper, GoogleApiManager.zza<O> zza) {
        AppMethodBeat.i(11017);
        Api.Client buildClient = this.mApi.zzk().buildClient(this.mContext, looper, createClientSettingsBuilder().build(), this.zzcl, zza, zza);
        AppMethodBeat.o(11017);
        return buildClient;
    }

    public zzby zza(Context context, Handler handler) {
        AppMethodBeat.i(11019);
        zzby zzby = new zzby(context, handler, createClientSettingsBuilder().build());
        AppMethodBeat.o(11019);
        return zzby;
    }

    public final zzh<O> zzm() {
        return this.zzcm;
    }
}
