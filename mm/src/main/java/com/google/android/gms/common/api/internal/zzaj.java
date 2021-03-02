package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.SignInResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zzaj implements zzbc {
    private final Context mContext;
    private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
    private final Lock zzga;
    private final ClientSettings zzgf;
    private final Map<Api<?>, Boolean> zzgi;
    private final GoogleApiAvailabilityLight zzgk;
    private ConnectionResult zzgt;
    private final zzbd zzhf;
    private int zzhi;
    private int zzhj = 0;
    private int zzhk;
    private final Bundle zzhl = new Bundle();
    private final Set<Api.AnyClientKey> zzhm = new HashSet();
    private SignInClient zzhn;
    private boolean zzho;
    private boolean zzhp;
    private boolean zzhq;
    private IAccountAccessor zzhr;
    private boolean zzhs;
    private boolean zzht;
    private ArrayList<Future<?>> zzhu = new ArrayList<>();

    public zzaj(zzbd zzbd, ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        AppMethodBeat.i(11212);
        this.zzhf = zzbd;
        this.zzgf = clientSettings;
        this.zzgi = map;
        this.zzgk = googleApiAvailabilityLight;
        this.zzdh = abstractClientBuilder;
        this.zzga = lock;
        this.mContext = context;
        AppMethodBeat.o(11212);
    }

    static /* synthetic */ void zza(zzaj zzaj, ConnectionResult connectionResult) {
        AppMethodBeat.i(11232);
        zzaj.zze(connectionResult);
        AppMethodBeat.o(11232);
    }

    static /* synthetic */ void zza(zzaj zzaj, ConnectionResult connectionResult, Api api, boolean z) {
        AppMethodBeat.i(11238);
        zzaj.zzb(connectionResult, api, z);
        AppMethodBeat.o(11238);
    }

    static /* synthetic */ void zza(zzaj zzaj, SignInResponse signInResponse) {
        AppMethodBeat.i(11240);
        zzaj.zza(signInResponse);
        AppMethodBeat.o(11240);
    }

    @GuardedBy("mLock")
    private final void zza(SignInResponse signInResponse) {
        AppMethodBeat.i(11215);
        if (!zze(0)) {
            AppMethodBeat.o(11215);
            return;
        }
        ConnectionResult connectionResult = signInResponse.getConnectionResult();
        if (connectionResult.isSuccess()) {
            ResolveAccountResponse resolveAccountResponse = signInResponse.getResolveAccountResponse();
            ConnectionResult connectionResult2 = resolveAccountResponse.getConnectionResult();
            if (!connectionResult2.isSuccess()) {
                String valueOf = String.valueOf(connectionResult2);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                zze(connectionResult2);
                AppMethodBeat.o(11215);
                return;
            }
            this.zzhq = true;
            this.zzhr = resolveAccountResponse.getAccountAccessor();
            this.zzhs = resolveAccountResponse.getSaveDefaultAccount();
            this.zzht = resolveAccountResponse.isFromCrossClientAuth();
            zzas();
            AppMethodBeat.o(11215);
        } else if (zzd(connectionResult)) {
            zzau();
            zzas();
            AppMethodBeat.o(11215);
        } else {
            zze(connectionResult);
            AppMethodBeat.o(11215);
        }
    }

    private final void zza(boolean z) {
        AppMethodBeat.i(11228);
        if (this.zzhn != null) {
            if (this.zzhn.isConnected() && z) {
                this.zzhn.clearAccountFromSessionStore();
            }
            this.zzhn.disconnect();
            this.zzhr = null;
        }
        AppMethodBeat.o(11228);
    }

    static /* synthetic */ boolean zza(zzaj zzaj, int i2) {
        AppMethodBeat.i(11237);
        boolean zze = zzaj.zze(0);
        AppMethodBeat.o(11237);
        return zze;
    }

    @GuardedBy("mLock")
    private final boolean zzar() {
        AppMethodBeat.i(11214);
        this.zzhk--;
        if (this.zzhk > 0) {
            AppMethodBeat.o(11214);
            return false;
        } else if (this.zzhk < 0) {
            this.zzhf.zzfq.zzbb();
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zze(new ConnectionResult(8, null));
            AppMethodBeat.o(11214);
            return false;
        } else if (this.zzgt != null) {
            this.zzhf.zzje = this.zzhi;
            zze(this.zzgt);
            AppMethodBeat.o(11214);
            return false;
        } else {
            AppMethodBeat.o(11214);
            return true;
        }
    }

    @GuardedBy("mLock")
    private final void zzas() {
        AppMethodBeat.i(11216);
        if (this.zzhk != 0) {
            AppMethodBeat.o(11216);
            return;
        }
        if (!this.zzhp || this.zzhq) {
            ArrayList arrayList = new ArrayList();
            this.zzhj = 1;
            this.zzhk = this.zzhf.zzil.size();
            for (Api.AnyClientKey<?> anyClientKey : this.zzhf.zzil.keySet()) {
                if (!this.zzhf.zzjb.containsKey(anyClientKey)) {
                    arrayList.add(this.zzhf.zzil.get(anyClientKey));
                } else if (zzar()) {
                    zzat();
                }
            }
            if (!arrayList.isEmpty()) {
                this.zzhu.add(zzbg.zzbe().submit(new zzap(this, arrayList)));
            }
        }
        AppMethodBeat.o(11216);
    }

    @GuardedBy("mLock")
    private final void zzat() {
        AppMethodBeat.i(11219);
        this.zzhf.zzbd();
        zzbg.zzbe().execute(new zzak(this));
        if (this.zzhn != null) {
            if (this.zzhs) {
                this.zzhn.saveDefaultAccount(this.zzhr, this.zzht);
            }
            zza(false);
        }
        for (Api.AnyClientKey<?> anyClientKey : this.zzhf.zzjb.keySet()) {
            this.zzhf.zzil.get(anyClientKey).disconnect();
        }
        this.zzhf.zzjf.zzb(this.zzhl.isEmpty() ? null : this.zzhl);
        AppMethodBeat.o(11219);
    }

    @GuardedBy("mLock")
    private final void zzau() {
        AppMethodBeat.i(11225);
        this.zzhp = false;
        this.zzhf.zzfq.zzim = Collections.emptySet();
        for (Api.AnyClientKey<?> anyClientKey : this.zzhm) {
            if (!this.zzhf.zzjb.containsKey(anyClientKey)) {
                this.zzhf.zzjb.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
        AppMethodBeat.o(11225);
    }

    private final void zzav() {
        AppMethodBeat.i(11229);
        ArrayList<Future<?>> arrayList = this.zzhu;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Future<?> future = arrayList.get(i2);
            i2++;
            future.cancel(true);
        }
        this.zzhu.clear();
        AppMethodBeat.o(11229);
    }

    private final Set<Scope> zzaw() {
        AppMethodBeat.i(11230);
        if (this.zzgf == null) {
            Set<Scope> emptySet = Collections.emptySet();
            AppMethodBeat.o(11230);
            return emptySet;
        }
        HashSet hashSet = new HashSet(this.zzgf.getRequiredScopes());
        Map<Api<?>, ClientSettings.OptionalApiSettings> optionalApiSettings = this.zzgf.getOptionalApiSettings();
        for (Api<?> api : optionalApiSettings.keySet()) {
            if (!this.zzhf.zzjb.containsKey(api.getClientKey())) {
                hashSet.addAll(optionalApiSettings.get(api).mScopes);
            }
        }
        AppMethodBeat.o(11230);
        return hashSet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        if ((r7.hasResolution() ? true : r6.zzgk.getErrorResolutionIntent(r7.getErrorCode()) != null) != false) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if (r3 >= r6.zzhi) goto L_0x0047;
     */
    @javax.annotation.concurrent.GuardedBy("mLock")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(com.google.android.gms.common.ConnectionResult r7, com.google.android.gms.common.api.Api<?> r8, boolean r9) {
        /*
            r6 = this;
            r5 = 11224(0x2bd8, float:1.5728E-41)
            r1 = 0
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            com.google.android.gms.common.api.Api$BaseClientBuilder r2 = r8.zzj()
            int r3 = r2.getPriority()
            if (r9 == 0) goto L_0x001a
            boolean r2 = r7.hasResolution()
            if (r2 == 0) goto L_0x0037
            r2 = r0
        L_0x0018:
            if (r2 == 0) goto L_0x0047
        L_0x001a:
            com.google.android.gms.common.ConnectionResult r2 = r6.zzgt
            if (r2 == 0) goto L_0x0022
            int r2 = r6.zzhi
            if (r3 >= r2) goto L_0x0047
        L_0x0022:
            if (r0 == 0) goto L_0x0028
            r6.zzgt = r7
            r6.zzhi = r3
        L_0x0028:
            com.google.android.gms.common.api.internal.zzbd r0 = r6.zzhf
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.ConnectionResult> r0 = r0.zzjb
            com.google.android.gms.common.api.Api$AnyClientKey r1 = r8.getClientKey()
            r0.put(r1, r7)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return
        L_0x0037:
            com.google.android.gms.common.GoogleApiAvailabilityLight r2 = r6.zzgk
            int r4 = r7.getErrorCode()
            android.content.Intent r2 = r2.getErrorResolutionIntent(r4)
            if (r2 == 0) goto L_0x0045
            r2 = r0
            goto L_0x0018
        L_0x0045:
            r2 = r1
            goto L_0x0018
        L_0x0047:
            r0 = r1
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzaj.zzb(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, boolean):void");
    }

    static /* synthetic */ boolean zzb(zzaj zzaj, ConnectionResult connectionResult) {
        AppMethodBeat.i(11234);
        boolean zzd = zzaj.zzd(connectionResult);
        AppMethodBeat.o(11234);
        return zzd;
    }

    @GuardedBy("mLock")
    private final boolean zzd(ConnectionResult connectionResult) {
        AppMethodBeat.i(11226);
        if (!this.zzho || connectionResult.hasResolution()) {
            AppMethodBeat.o(11226);
            return false;
        }
        AppMethodBeat.o(11226);
        return true;
    }

    @GuardedBy("mLock")
    private final void zze(ConnectionResult connectionResult) {
        AppMethodBeat.i(11227);
        zzav();
        zza(!connectionResult.hasResolution());
        this.zzhf.zzf(connectionResult);
        this.zzhf.zzjf.zzc(connectionResult);
        AppMethodBeat.o(11227);
    }

    @GuardedBy("mLock")
    private final boolean zze(int i2) {
        AppMethodBeat.i(11231);
        if (this.zzhj != i2) {
            this.zzhf.zzfq.zzbb();
            String valueOf = String.valueOf(this);
            new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf);
            new StringBuilder(33).append("mRemainingConnections=").append(this.zzhk);
            String zzf = zzf(this.zzhj);
            String zzf2 = zzf(i2);
            Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(zzf).length() + 70 + String.valueOf(zzf2).length()).append("GoogleApiClient connecting is in step ").append(zzf).append(" but received callback for step ").append(zzf2).toString(), new Exception());
            zze(new ConnectionResult(8, null));
            AppMethodBeat.o(11231);
            return false;
        }
        AppMethodBeat.o(11231);
        return true;
    }

    private static String zzf(int i2) {
        switch (i2) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    static /* synthetic */ Set zzg(zzaj zzaj) {
        AppMethodBeat.i(11233);
        Set<Scope> zzaw = zzaj.zzaw();
        AppMethodBeat.o(11233);
        return zzaw;
    }

    static /* synthetic */ void zzi(zzaj zzaj) {
        AppMethodBeat.i(11235);
        zzaj.zzau();
        AppMethodBeat.o(11235);
    }

    static /* synthetic */ void zzj(zzaj zzaj) {
        AppMethodBeat.i(11236);
        zzaj.zzas();
        AppMethodBeat.o(11236);
    }

    static /* synthetic */ boolean zzk(zzaj zzaj) {
        AppMethodBeat.i(11239);
        boolean zzar = zzaj.zzar();
        AppMethodBeat.o(11239);
        return zzar;
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final void begin() {
        AppMethodBeat.i(11213);
        this.zzhf.zzjb.clear();
        this.zzhp = false;
        this.zzgt = null;
        this.zzhj = 0;
        this.zzho = true;
        this.zzhq = false;
        this.zzhs = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api<?> api : this.zzgi.keySet()) {
            Api.Client client = this.zzhf.zzil.get(api.getClientKey());
            boolean z2 = (api.zzj().getPriority() == 1) | z;
            boolean booleanValue = this.zzgi.get(api).booleanValue();
            if (client.requiresSignIn()) {
                this.zzhp = true;
                if (booleanValue) {
                    this.zzhm.add(api.getClientKey());
                } else {
                    this.zzho = false;
                }
            }
            hashMap.put(client, new zzal(this, api, booleanValue));
            z = z2;
        }
        if (z) {
            this.zzhp = false;
        }
        if (this.zzhp) {
            this.zzgf.setClientSessionId(Integer.valueOf(System.identityHashCode(this.zzhf.zzfq)));
            zzas zzas = new zzas(this, null);
            this.zzhn = (SignInClient) this.zzdh.buildClient(this.mContext, this.zzhf.zzfq.getLooper(), this.zzgf, this.zzgf.getSignInOptions(), zzas, zzas);
        }
        this.zzhk = this.zzhf.zzil.size();
        this.zzhu.add(zzbg.zzbe().submit(new zzam(this, hashMap)));
        AppMethodBeat.o(11213);
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final void connect() {
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final boolean disconnect() {
        AppMethodBeat.i(11222);
        zzav();
        zza(true);
        this.zzhf.zzf(null);
        AppMethodBeat.o(11222);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.i(11220);
        this.zzhf.zzfq.zzgo.add(t);
        AppMethodBeat.o(11220);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.i(11221);
        IllegalStateException illegalStateException = new IllegalStateException("GoogleApiClient is not connected yet.");
        AppMethodBeat.o(11221);
        throw illegalStateException;
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    @GuardedBy("mLock")
    public final void onConnected(Bundle bundle) {
        AppMethodBeat.i(11217);
        if (!zze(1)) {
            AppMethodBeat.o(11217);
            return;
        }
        if (bundle != null) {
            this.zzhl.putAll(bundle);
        }
        if (zzar()) {
            zzat();
        }
        AppMethodBeat.o(11217);
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    @GuardedBy("mLock")
    public final void onConnectionSuspended(int i2) {
        AppMethodBeat.i(11223);
        zze(new ConnectionResult(8, null));
        AppMethodBeat.o(11223);
    }

    @Override // com.google.android.gms.common.api.internal.zzbc
    @GuardedBy("mLock")
    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        AppMethodBeat.i(11218);
        if (!zze(1)) {
            AppMethodBeat.o(11218);
            return;
        }
        zzb(connectionResult, api, z);
        if (zzar()) {
            zzat();
        }
        AppMethodBeat.o(11218);
    }
}
