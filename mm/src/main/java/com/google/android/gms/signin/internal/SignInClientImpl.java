package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.ISignInService;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SignInClientImpl extends GmsClient<ISignInService> implements SignInClient {
    public static final String ACTION_START_SERVICE = "com.google.android.gms.signin.service.START";
    public static final String INTERNAL_ACTION_START_SERVICE = "com.google.android.gms.signin.service.INTERNAL_START";
    public static final String KEY_AUTH_API_SIGN_IN_MODULE_VERSION = "com.google.android.gms.signin.internal.authApiSignInModuleVersion";
    public static final String KEY_CLIENT_REQUESTED_ACCOUNT = "com.google.android.gms.signin.internal.clientRequestedAccount";
    public static final String KEY_FORCE_CODE_FOR_REFRESH_TOKEN = "com.google.android.gms.signin.internal.forceCodeForRefreshToken";
    public static final String KEY_HOSTED_DOMAIN = "com.google.android.gms.signin.internal.hostedDomain";
    public static final String KEY_ID_TOKEN_REQUESTED = "com.google.android.gms.signin.internal.idTokenRequested";
    @Deprecated
    public static final String KEY_OFFLINE_ACCESS_CALLBACKS = "com.google.android.gms.signin.internal.signInCallbacks";
    public static final String KEY_OFFLINE_ACCESS_REQUESTED = "com.google.android.gms.signin.internal.offlineAccessRequested";
    public static final String KEY_REAL_CLIENT_LIBRARY_VERSION = "com.google.android.gms.signin.internal.realClientLibraryVersion";
    public static final String KEY_REAL_CLIENT_PACKAGE_NAME = "com.google.android.gms.signin.internal.realClientPackageName";
    public static final String KEY_SERVER_CLIENT_ID = "com.google.android.gms.signin.internal.serverClientId";
    public static final String KEY_USE_PROMPT_MODE_FOR_AUTH_CODE = "com.google.android.gms.signin.internal.usePromptModeForAuthCode";
    public static final String KEY_WAIT_FOR_ACCESS_TOKEN_REFRESH = "com.google.android.gms.signin.internal.waitForAccessTokenRefresh";
    private final Bundle zzada;
    private final boolean zzads;
    private final ClientSettings zzgf;
    private Integer zzsc;

    public SignInClientImpl(Context context, Looper looper, boolean z, ClientSettings clientSettings, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.i(12179);
        this.zzads = z;
        this.zzgf = clientSettings;
        this.zzada = bundle;
        this.zzsc = clientSettings.getClientSessionId();
        AppMethodBeat.o(12179);
    }

    public SignInClientImpl(Context context, Looper looper, boolean z, ClientSettings clientSettings, SignInOptions signInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, z, clientSettings, createBundleFromClientSettings(clientSettings), connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.i(12180);
        AppMethodBeat.o(12180);
    }

    public static Bundle createBundleFromClientSettings(ClientSettings clientSettings) {
        AppMethodBeat.i(12187);
        SignInOptions signInOptions = clientSettings.getSignInOptions();
        Integer clientSessionId = clientSettings.getClientSessionId();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_CLIENT_REQUESTED_ACCOUNT, clientSettings.getAccount());
        if (clientSessionId != null) {
            bundle.putInt(ClientSettings.KEY_CLIENT_SESSION_ID, clientSessionId.intValue());
        }
        if (signInOptions != null) {
            bundle.putBoolean(KEY_OFFLINE_ACCESS_REQUESTED, signInOptions.isOfflineAccessRequested());
            bundle.putBoolean(KEY_ID_TOKEN_REQUESTED, signInOptions.isIdTokenRequested());
            bundle.putString(KEY_SERVER_CLIENT_ID, signInOptions.getServerClientId());
            bundle.putBoolean(KEY_USE_PROMPT_MODE_FOR_AUTH_CODE, true);
            bundle.putBoolean(KEY_FORCE_CODE_FOR_REFRESH_TOKEN, signInOptions.isForceCodeForRefreshToken());
            bundle.putString(KEY_HOSTED_DOMAIN, signInOptions.getHostedDomain());
            bundle.putBoolean(KEY_WAIT_FOR_ACCESS_TOKEN_REFRESH, signInOptions.waitForAccessTokenRefresh());
            if (signInOptions.getAuthApiSignInModuleVersion() != null) {
                bundle.putLong(KEY_AUTH_API_SIGN_IN_MODULE_VERSION, signInOptions.getAuthApiSignInModuleVersion().longValue());
            }
            if (signInOptions.getRealClientLibraryVersion() != null) {
                bundle.putLong(KEY_REAL_CLIENT_LIBRARY_VERSION, signInOptions.getRealClientLibraryVersion().longValue());
            }
        }
        AppMethodBeat.o(12187);
        return bundle;
    }

    @Override // com.google.android.gms.signin.SignInClient
    public void clearAccountFromSessionStore() {
        AppMethodBeat.i(12182);
        try {
            ((ISignInService) getService()).clearAccountFromSessionStore(this.zzsc.intValue());
            AppMethodBeat.o(12182);
        } catch (RemoteException e2) {
            AppMethodBeat.o(12182);
        }
    }

    @Override // com.google.android.gms.signin.SignInClient
    public void connect() {
        AppMethodBeat.i(12186);
        connect(new BaseGmsClient.LegacyClientCallbackAdapter());
        AppMethodBeat.o(12186);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public ISignInService createServiceInterface(IBinder iBinder) {
        AppMethodBeat.i(12184);
        ISignInService asInterface = ISignInService.Stub.asInterface(iBinder);
        AppMethodBeat.o(12184);
        return asInterface;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public Bundle getGetServiceRequestExtraArgs() {
        AppMethodBeat.i(12185);
        if (!getContext().getPackageName().equals(this.zzgf.getRealClientPackageName())) {
            this.zzada.putString(KEY_REAL_CLIENT_PACKAGE_NAME, this.zzgf.getRealClientPackageName());
        }
        Bundle bundle = this.zzada;
        AppMethodBeat.o(12185);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.GmsClient
    public int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public String getStartServiceAction() {
        return ACTION_START_SERVICE;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public boolean requiresSignIn() {
        return this.zzads;
    }

    @Override // com.google.android.gms.signin.SignInClient
    public void saveDefaultAccount(IAccountAccessor iAccountAccessor, boolean z) {
        AppMethodBeat.i(12181);
        try {
            ((ISignInService) getService()).saveDefaultAccountToSharedPref(iAccountAccessor, this.zzsc.intValue(), z);
            AppMethodBeat.o(12181);
        } catch (RemoteException e2) {
            AppMethodBeat.o(12181);
        }
    }

    @Override // com.google.android.gms.signin.SignInClient
    public void signIn(ISignInCallbacks iSignInCallbacks) {
        AppMethodBeat.i(12183);
        Preconditions.checkNotNull(iSignInCallbacks, "Expecting a valid ISignInCallbacks");
        try {
            Account accountOrDefault = this.zzgf.getAccountOrDefault();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(accountOrDefault.name)) {
                googleSignInAccount = Storage.getInstance(getContext()).getSavedDefaultGoogleSignInAccount();
            }
            ((ISignInService) getService()).signIn(new SignInRequest(new ResolveAccountRequest(accountOrDefault, this.zzsc.intValue(), googleSignInAccount)), iSignInCallbacks);
            AppMethodBeat.o(12183);
        } catch (RemoteException e2) {
            try {
                iSignInCallbacks.onSignInComplete(new SignInResponse(8));
                AppMethodBeat.o(12183);
            } catch (RemoteException e3) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
                AppMethodBeat.o(12183);
            }
        }
    }
}
