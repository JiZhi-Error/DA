package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.e.a;
import android.support.v4.e.b;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public class GoogleApiManager implements Handler.Callback {
    private static final Object lock = new Object();
    public static final Status zzjj = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zzjk = new Status(4, "The user must be signed in to make this API call.");
    @GuardedBy("lock")
    private static GoogleApiManager zzjo;
    private final Handler handler;
    private long zzjl = 5000;
    private long zzjm = 120000;
    private long zzjn = 10000;
    private final Context zzjp;
    private final GoogleApiAvailability zzjq;
    private final GoogleApiAvailabilityCache zzjr;
    private final AtomicInteger zzjs = new AtomicInteger(1);
    private final AtomicInteger zzjt = new AtomicInteger(0);
    private final Map<zzh<?>, zza<?>> zzju = new ConcurrentHashMap(5, 0.75f, 1);
    @GuardedBy("lock")
    private zzad zzjv = null;
    @GuardedBy("lock")
    private final Set<zzh<?>> zzjw = new b();
    private final Set<zzh<?>> zzjx = new b();

    public class zza<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zzq {
        private final zzh<O> zzhc;
        private final Queue<zzb> zzjz = new LinkedList();
        private final Api.Client zzka;
        private final Api.AnyClient zzkb;
        private final zzaa zzkc;
        private final Set<zzj> zzkd = new HashSet();
        private final Map<ListenerHolder.ListenerKey<?>, zzbv> zzke = new HashMap();
        private final int zzkf;
        private final zzby zzkg;
        private boolean zzkh;
        private final List<zzb> zzki = new ArrayList();
        private ConnectionResult zzkj = null;

        public zza(GoogleApi<O> googleApi) {
            AppMethodBeat.i(11062);
            this.zzka = googleApi.zza(GoogleApiManager.this.handler.getLooper(), this);
            if (this.zzka instanceof SimpleClientAdapter) {
                this.zzkb = ((SimpleClientAdapter) this.zzka).getClient();
            } else {
                this.zzkb = this.zzka;
            }
            this.zzhc = googleApi.zzm();
            this.zzkc = new zzaa();
            this.zzkf = googleApi.getInstanceId();
            if (this.zzka.requiresSignIn()) {
                this.zzkg = googleApi.zza(GoogleApiManager.this.zzjp, GoogleApiManager.this.handler);
                AppMethodBeat.o(11062);
                return;
            }
            this.zzkg = null;
            AppMethodBeat.o(11062);
        }

        static /* synthetic */ void zza(zza zza, zzb zzb) {
            AppMethodBeat.i(11094);
            zza.zza(zzb);
            AppMethodBeat.o(11094);
        }

        private final void zza(zzb zzb) {
            AppMethodBeat.i(11091);
            if (!this.zzki.contains(zzb)) {
                AppMethodBeat.o(11091);
                return;
            }
            if (!this.zzkh) {
                if (!this.zzka.isConnected()) {
                    connect();
                    AppMethodBeat.o(11091);
                    return;
                }
                zzbl();
            }
            AppMethodBeat.o(11091);
        }

        static /* synthetic */ boolean zza(zza zza, boolean z) {
            AppMethodBeat.i(11093);
            boolean zzb = zza.zzb(false);
            AppMethodBeat.o(11093);
            return zzb;
        }

        static /* synthetic */ void zzb(zza zza, zzb zzb) {
            AppMethodBeat.i(11095);
            zza.zzb(zzb);
            AppMethodBeat.o(11095);
        }

        private final void zzb(zzb zzb) {
            Feature[] requiredFeatures;
            AppMethodBeat.i(11092);
            if (this.zzki.remove(zzb)) {
                GoogleApiManager.this.handler.removeMessages(15, zzb);
                GoogleApiManager.this.handler.removeMessages(16, zzb);
                Feature feature = zzb.zzdr;
                ArrayList arrayList = new ArrayList(this.zzjz.size());
                for (zzb zzb2 : this.zzjz) {
                    if ((zzb2 instanceof zzf) && (requiredFeatures = ((zzf) zzb2).getRequiredFeatures()) != null && ArrayUtils.contains(requiredFeatures, feature)) {
                        arrayList.add(zzb2);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    zzb zzb3 = (zzb) obj;
                    this.zzjz.remove(zzb3);
                    zzb3.zza(new UnsupportedApiCallException(feature));
                }
            }
            AppMethodBeat.o(11092);
        }

        private final boolean zzb(zzb zzb) {
            AppMethodBeat.i(11076);
            if (!(zzb instanceof zzf)) {
                zzc(zzb);
                AppMethodBeat.o(11076);
                return true;
            }
            zzf zzf = (zzf) zzb;
            Feature[] requiredFeatures = zzf.getRequiredFeatures();
            if (requiredFeatures == null || requiredFeatures.length == 0) {
                zzc(zzb);
                AppMethodBeat.o(11076);
                return true;
            }
            Feature[] availableFeatures = this.zzka.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            a aVar = new a(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                aVar.put(feature.getName(), Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : requiredFeatures) {
                if (!aVar.containsKey(feature2.getName()) || ((Long) aVar.get(feature2.getName())).longValue() < feature2.getVersion()) {
                    if (zzf.shouldAutoResolveMissingFeatures()) {
                        zzb zzb2 = new zzb(this.zzhc, feature2, null);
                        int indexOf = this.zzki.indexOf(zzb2);
                        if (indexOf >= 0) {
                            zzb zzb3 = this.zzki.get(indexOf);
                            GoogleApiManager.this.handler.removeMessages(15, zzb3);
                            GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 15, zzb3), GoogleApiManager.this.zzjl);
                        } else {
                            this.zzki.add(zzb2);
                            GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 15, zzb2), GoogleApiManager.this.zzjl);
                            GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 16, zzb2), GoogleApiManager.this.zzjm);
                            ConnectionResult connectionResult = new ConnectionResult(2, null);
                            if (!zzh(connectionResult)) {
                                GoogleApiManager.this.zzc(connectionResult, this.zzkf);
                            }
                        }
                    } else {
                        zzf.zza(new UnsupportedApiCallException(feature2));
                    }
                    AppMethodBeat.o(11076);
                    return false;
                }
                this.zzki.remove(new zzb(this.zzhc, feature2, null));
            }
            zzc(zzb);
            AppMethodBeat.o(11076);
            return true;
        }

        private final boolean zzb(boolean z) {
            AppMethodBeat.i(11084);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (!this.zzka.isConnected() || this.zzke.size() != 0) {
                AppMethodBeat.o(11084);
                return false;
            } else if (this.zzkc.zzaj()) {
                if (z) {
                    zzbr();
                }
                AppMethodBeat.o(11084);
                return false;
            } else {
                this.zzka.disconnect();
                AppMethodBeat.o(11084);
                return true;
            }
        }

        private final void zzbj() {
            AppMethodBeat.i(11064);
            zzbo();
            zzi(ConnectionResult.RESULT_SUCCESS);
            zzbq();
            for (zzbv zzbv : this.zzke.values()) {
                try {
                    zzbv.zzlt.registerListener(this.zzkb, new TaskCompletionSource<>());
                } catch (DeadObjectException e2) {
                    onConnectionSuspended(1);
                    this.zzka.disconnect();
                } catch (RemoteException e3) {
                }
            }
            zzbl();
            zzbr();
            AppMethodBeat.o(11064);
        }

        private final void zzbk() {
            AppMethodBeat.i(11066);
            zzbo();
            this.zzkh = true;
            this.zzkc.zzal();
            GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 9, this.zzhc), GoogleApiManager.this.zzjl);
            GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 11, this.zzhc), GoogleApiManager.this.zzjm);
            GoogleApiManager.this.zzjr.flush();
            AppMethodBeat.o(11066);
        }

        private final void zzbl() {
            AppMethodBeat.i(11071);
            ArrayList arrayList = new ArrayList(this.zzjz);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                zzb zzb = (zzb) obj;
                if (!this.zzka.isConnected()) {
                    break;
                } else if (zzb(zzb)) {
                    this.zzjz.remove(zzb);
                }
            }
            AppMethodBeat.o(11071);
        }

        private final void zzbq() {
            AppMethodBeat.i(11080);
            if (this.zzkh) {
                GoogleApiManager.this.handler.removeMessages(11, this.zzhc);
                GoogleApiManager.this.handler.removeMessages(9, this.zzhc);
                this.zzkh = false;
            }
            AppMethodBeat.o(11080);
        }

        private final void zzbr() {
            AppMethodBeat.i(11082);
            GoogleApiManager.this.handler.removeMessages(12, this.zzhc);
            GoogleApiManager.this.handler.sendMessageDelayed(GoogleApiManager.this.handler.obtainMessage(12, this.zzhc), GoogleApiManager.this.zzjn);
            AppMethodBeat.o(11082);
        }

        static /* synthetic */ void zzc(zza zza) {
            AppMethodBeat.i(11096);
            zza.zzbj();
            AppMethodBeat.o(11096);
        }

        private final void zzc(zzb zzb) {
            AppMethodBeat.i(11077);
            zzb.zza(this.zzkc, requiresSignIn());
            try {
                zzb.zza((zza<?>) this);
                AppMethodBeat.o(11077);
            } catch (DeadObjectException e2) {
                onConnectionSuspended(1);
                this.zzka.disconnect();
                AppMethodBeat.o(11077);
            }
        }

        static /* synthetic */ void zzd(zza zza) {
            AppMethodBeat.i(11097);
            zza.zzbk();
            AppMethodBeat.o(11097);
        }

        private final boolean zzh(ConnectionResult connectionResult) {
            boolean z;
            AppMethodBeat.i(11068);
            synchronized (GoogleApiManager.lock) {
                try {
                    if (GoogleApiManager.this.zzjv == null || !GoogleApiManager.this.zzjw.contains(this.zzhc)) {
                        z = false;
                        AppMethodBeat.o(11068);
                    } else {
                        GoogleApiManager.this.zzjv.zzb(connectionResult, this.zzkf);
                        z = true;
                    }
                } finally {
                    AppMethodBeat.o(11068);
                }
            }
            return z;
        }

        private final void zzi(ConnectionResult connectionResult) {
            AppMethodBeat.i(11087);
            for (zzj zzj : this.zzkd) {
                String str = null;
                if (Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                    str = this.zzka.getEndpointPackageName();
                }
                zzj.zza(this.zzhc, connectionResult, str);
            }
            this.zzkd.clear();
            AppMethodBeat.o(11087);
        }

        public final void connect() {
            AppMethodBeat.i(11085);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (this.zzka.isConnected() || this.zzka.isConnecting()) {
                AppMethodBeat.o(11085);
                return;
            }
            int clientAvailability = GoogleApiManager.this.zzjr.getClientAvailability(GoogleApiManager.this.zzjp, this.zzka);
            if (clientAvailability != 0) {
                onConnectionFailed(new ConnectionResult(clientAvailability, null));
                AppMethodBeat.o(11085);
                return;
            }
            zzc zzc = new zzc(this.zzka, this.zzhc);
            if (this.zzka.requiresSignIn()) {
                this.zzkg.zza(zzc);
            }
            this.zzka.connect(zzc);
            AppMethodBeat.o(11085);
        }

        public final int getInstanceId() {
            return this.zzkf;
        }

        /* access modifiers changed from: package-private */
        public final boolean isConnected() {
            AppMethodBeat.i(11088);
            boolean isConnected = this.zzka.isConnected();
            AppMethodBeat.o(11088);
            return isConnected;
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public final void onConnected(Bundle bundle) {
            AppMethodBeat.i(11063);
            if (Looper.myLooper() == GoogleApiManager.this.handler.getLooper()) {
                zzbj();
                AppMethodBeat.o(11063);
                return;
            }
            GoogleApiManager.this.handler.post(new zzbi(this));
            AppMethodBeat.o(11063);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public final void onConnectionFailed(ConnectionResult connectionResult) {
            AppMethodBeat.i(11070);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (this.zzkg != null) {
                this.zzkg.zzbz();
            }
            zzbo();
            GoogleApiManager.this.zzjr.flush();
            zzi(connectionResult);
            if (connectionResult.getErrorCode() == 4) {
                zzc(GoogleApiManager.zzjk);
                AppMethodBeat.o(11070);
            } else if (this.zzjz.isEmpty()) {
                this.zzkj = connectionResult;
                AppMethodBeat.o(11070);
            } else if (zzh(connectionResult)) {
                AppMethodBeat.o(11070);
            } else {
                if (!GoogleApiManager.this.zzc(connectionResult, this.zzkf)) {
                    if (connectionResult.getErrorCode() == 18) {
                        this.zzkh = true;
                    }
                    if (this.zzkh) {
                        GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 9, this.zzhc), GoogleApiManager.this.zzjl);
                        AppMethodBeat.o(11070);
                        return;
                    }
                    String zzq = this.zzhc.zzq();
                    zzc(new Status(17, new StringBuilder(String.valueOf(zzq).length() + 38).append("API: ").append(zzq).append(" is not available on this device.").toString()));
                }
                AppMethodBeat.o(11070);
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public final void onConnectionSuspended(int i2) {
            AppMethodBeat.i(11065);
            if (Looper.myLooper() == GoogleApiManager.this.handler.getLooper()) {
                zzbk();
                AppMethodBeat.o(11065);
                return;
            }
            GoogleApiManager.this.handler.post(new zzbj(this));
            AppMethodBeat.o(11065);
        }

        public final boolean requiresSignIn() {
            AppMethodBeat.i(11089);
            boolean requiresSignIn = this.zzka.requiresSignIn();
            AppMethodBeat.o(11089);
            return requiresSignIn;
        }

        public final void resume() {
            AppMethodBeat.i(11079);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (this.zzkh) {
                connect();
            }
            AppMethodBeat.o(11079);
        }

        @Override // com.google.android.gms.common.api.internal.zzq
        public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
            AppMethodBeat.i(11069);
            if (Looper.myLooper() == GoogleApiManager.this.handler.getLooper()) {
                onConnectionFailed(connectionResult);
                AppMethodBeat.o(11069);
                return;
            }
            GoogleApiManager.this.handler.post(new zzbk(this, connectionResult));
            AppMethodBeat.o(11069);
        }

        public final void zza(zzb zzb) {
            AppMethodBeat.i(11072);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (!this.zzka.isConnected()) {
                this.zzjz.add(zzb);
                if (this.zzkj == null || !this.zzkj.hasResolution()) {
                    connect();
                    AppMethodBeat.o(11072);
                    return;
                }
                onConnectionFailed(this.zzkj);
                AppMethodBeat.o(11072);
            } else if (zzb(zzb)) {
                zzbr();
                AppMethodBeat.o(11072);
            } else {
                this.zzjz.add(zzb);
                AppMethodBeat.o(11072);
            }
        }

        public final void zza(zzj zzj) {
            AppMethodBeat.i(11086);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            this.zzkd.add(zzj);
            AppMethodBeat.o(11086);
        }

        public final Api.Client zzae() {
            return this.zzka;
        }

        public final void zzay() {
            AppMethodBeat.i(11081);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (this.zzkh) {
                zzbq();
                zzc(GoogleApiManager.this.zzjq.isGooglePlayServicesAvailable(GoogleApiManager.this.zzjp) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.zzka.disconnect();
            }
            AppMethodBeat.o(11081);
        }

        public final void zzbm() {
            AppMethodBeat.i(11073);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            zzc(GoogleApiManager.zzjj);
            this.zzkc.zzak();
            for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.zzke.keySet().toArray(new ListenerHolder.ListenerKey[this.zzke.size()])) {
                zza(new zzg(listenerKey, new TaskCompletionSource()));
            }
            zzi(new ConnectionResult(4));
            if (this.zzka.isConnected()) {
                this.zzka.onUserSignOut(new zzbl(this));
            }
            AppMethodBeat.o(11073);
        }

        public final Map<ListenerHolder.ListenerKey<?>, zzbv> zzbn() {
            return this.zzke;
        }

        public final void zzbo() {
            AppMethodBeat.i(11074);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            this.zzkj = null;
            AppMethodBeat.o(11074);
        }

        public final ConnectionResult zzbp() {
            AppMethodBeat.i(11075);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            ConnectionResult connectionResult = this.zzkj;
            AppMethodBeat.o(11075);
            return connectionResult;
        }

        public final boolean zzbs() {
            AppMethodBeat.i(11083);
            boolean zzb = zzb(true);
            AppMethodBeat.o(11083);
            return zzb;
        }

        /* access modifiers changed from: package-private */
        public final SignInClient zzbt() {
            AppMethodBeat.i(11090);
            if (this.zzkg == null) {
                AppMethodBeat.o(11090);
                return null;
            }
            SignInClient zzbt = this.zzkg.zzbt();
            AppMethodBeat.o(11090);
            return zzbt;
        }

        public final void zzc(Status status) {
            AppMethodBeat.i(11078);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            for (zzb zzb : this.zzjz) {
                zzb.zza(status);
            }
            this.zzjz.clear();
            AppMethodBeat.o(11078);
        }

        public final void zzg(ConnectionResult connectionResult) {
            AppMethodBeat.i(11067);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            this.zzka.disconnect();
            onConnectionFailed(connectionResult);
            AppMethodBeat.o(11067);
        }
    }

    /* access modifiers changed from: package-private */
    public static class zzb {
        private final Feature zzdr;
        private final zzh<?> zzkn;

        private zzb(zzh<?> zzh, Feature feature) {
            this.zzkn = zzh;
            this.zzdr = feature;
        }

        /* synthetic */ zzb(zzh zzh, Feature feature, zzbh zzbh) {
            this(zzh, feature);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(11098);
            if (obj == null || !(obj instanceof zzb)) {
                AppMethodBeat.o(11098);
                return false;
            }
            zzb zzb = (zzb) obj;
            if (!Objects.equal(this.zzkn, zzb.zzkn) || !Objects.equal(this.zzdr, zzb.zzdr)) {
                AppMethodBeat.o(11098);
                return false;
            }
            AppMethodBeat.o(11098);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.i(11099);
            int hashCode = Objects.hashCode(this.zzkn, this.zzdr);
            AppMethodBeat.o(11099);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(11100);
            String toStringHelper = Objects.toStringHelper(this).add("key", this.zzkn).add("feature", this.zzdr).toString();
            AppMethodBeat.o(11100);
            return toStringHelper;
        }
    }

    /* access modifiers changed from: package-private */
    public class zzc implements zzcb, BaseGmsClient.ConnectionProgressReportCallbacks {
        private final zzh<?> zzhc;
        private final Api.Client zzka;
        private IAccountAccessor zzko = null;
        private Set<Scope> zzkp = null;
        private boolean zzkq = false;

        public zzc(Api.Client client, zzh<?> zzh) {
            this.zzka = client;
            this.zzhc = zzh;
        }

        static /* synthetic */ void zzb(zzc zzc) {
            AppMethodBeat.i(11105);
            zzc.zzbu();
            AppMethodBeat.o(11105);
        }

        private final void zzbu() {
            AppMethodBeat.i(11104);
            if (this.zzkq && this.zzko != null) {
                this.zzka.getRemoteService(this.zzko, this.zzkp);
            }
            AppMethodBeat.o(11104);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void onReportServiceBinding(ConnectionResult connectionResult) {
            AppMethodBeat.i(11101);
            GoogleApiManager.this.handler.post(new zzbn(this, connectionResult));
            AppMethodBeat.o(11101);
        }

        @Override // com.google.android.gms.common.api.internal.zzcb
        public final void zza(IAccountAccessor iAccountAccessor, Set<Scope> set) {
            AppMethodBeat.i(11103);
            if (iAccountAccessor == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                zzg(new ConnectionResult(4));
                AppMethodBeat.o(11103);
                return;
            }
            this.zzko = iAccountAccessor;
            this.zzkp = set;
            zzbu();
            AppMethodBeat.o(11103);
        }

        @Override // com.google.android.gms.common.api.internal.zzcb
        public final void zzg(ConnectionResult connectionResult) {
            AppMethodBeat.i(11102);
            ((zza) GoogleApiManager.this.zzju.get(this.zzhc)).zzg(connectionResult);
            AppMethodBeat.o(11102);
        }
    }

    static {
        AppMethodBeat.i(11127);
        AppMethodBeat.o(11127);
    }

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        AppMethodBeat.i(11109);
        this.zzjp = context;
        this.handler = new Handler(looper, this);
        this.zzjq = googleApiAvailability;
        this.zzjr = new GoogleApiAvailabilityCache(googleApiAvailability);
        this.handler.sendMessage(this.handler.obtainMessage(6));
        AppMethodBeat.o(11109);
    }

    @KeepForSdk
    public static void reportSignOut() {
        AppMethodBeat.i(11108);
        synchronized (lock) {
            try {
                if (zzjo != null) {
                    GoogleApiManager googleApiManager = zzjo;
                    googleApiManager.zzjt.incrementAndGet();
                    googleApiManager.handler.sendMessageAtFrontOfQueue(googleApiManager.handler.obtainMessage(10));
                }
            } finally {
                AppMethodBeat.o(11108);
            }
        }
    }

    public static GoogleApiManager zzb(Context context) {
        GoogleApiManager googleApiManager;
        AppMethodBeat.i(11106);
        synchronized (lock) {
            try {
                if (zzjo == null) {
                    HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                    handlerThread.start();
                    zzjo = new GoogleApiManager(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
                }
                googleApiManager = zzjo;
            } finally {
                AppMethodBeat.o(11106);
            }
        }
        return googleApiManager;
    }

    private final void zzb(GoogleApi<?> googleApi) {
        AppMethodBeat.i(11112);
        zzh<?> zzm = googleApi.zzm();
        zza<?> zza2 = this.zzju.get(zzm);
        if (zza2 == null) {
            zza2 = new zza<>(googleApi);
            this.zzju.put(zzm, zza2);
        }
        if (zza2.requiresSignIn()) {
            this.zzjx.add(zzm);
        }
        zza2.connect();
        AppMethodBeat.o(11112);
    }

    public static GoogleApiManager zzbf() {
        GoogleApiManager googleApiManager;
        AppMethodBeat.i(11107);
        synchronized (lock) {
            try {
                Preconditions.checkNotNull(zzjo, "Must guarantee manager is non-null before using getInstance");
                googleApiManager = zzjo;
            } finally {
                AppMethodBeat.o(11107);
            }
        }
        return googleApiManager;
    }

    public boolean handleMessage(Message message) {
        zza<?> zza2;
        AppMethodBeat.i(11123);
        switch (message.what) {
            case 1:
                this.zzjn = ((Boolean) message.obj).booleanValue() ? 10000 : 300000;
                this.handler.removeMessages(12);
                for (zzh<?> zzh : this.zzju.keySet()) {
                    this.handler.sendMessageDelayed(this.handler.obtainMessage(12, zzh), this.zzjn);
                }
                break;
            case 2:
                zzj zzj = (zzj) message.obj;
                Iterator<zzh<?>> it = zzj.zzs().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        zzh<?> next = it.next();
                        zza<?> zza3 = this.zzju.get(next);
                        if (zza3 == null) {
                            zzj.zza(next, new ConnectionResult(13), null);
                            break;
                        } else if (zza3.isConnected()) {
                            zzj.zza(next, ConnectionResult.RESULT_SUCCESS, zza3.zzae().getEndpointPackageName());
                        } else if (zza3.zzbp() != null) {
                            zzj.zza(next, zza3.zzbp(), null);
                        } else {
                            zza3.zza(zzj);
                        }
                    }
                }
            case 3:
                for (zza<?> zza4 : this.zzju.values()) {
                    zza4.zzbo();
                    zza4.connect();
                }
                break;
            case 4:
            case 8:
            case 13:
                zzbu zzbu = (zzbu) message.obj;
                zza<?> zza5 = this.zzju.get(zzbu.zzlr.zzm());
                if (zza5 == null) {
                    zzb(zzbu.zzlr);
                    zza5 = this.zzju.get(zzbu.zzlr.zzm());
                }
                if (!zza5.requiresSignIn() || this.zzjt.get() == zzbu.zzlq) {
                    zza5.zza(zzbu.zzlp);
                    break;
                } else {
                    zzbu.zzlp.zza(zzjj);
                    zza5.zzbm();
                    break;
                }
                break;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<zza<?>> it2 = this.zzju.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zza2 = it2.next();
                        if (zza2.getInstanceId() == i2) {
                        }
                    } else {
                        zza2 = null;
                    }
                }
                if (zza2 != null) {
                    String errorString = this.zzjq.getErrorString(connectionResult.getErrorCode());
                    String errorMessage = connectionResult.getErrorMessage();
                    zza2.zzc(new Status(17, new StringBuilder(String.valueOf(errorString).length() + 69 + String.valueOf(errorMessage).length()).append("Error resolution was canceled by the user, original error message: ").append(errorString).append(": ").append(errorMessage).toString()));
                    break;
                } else {
                    Log.wtf("GoogleApiManager", new StringBuilder(76).append("Could not find API instance ").append(i2).append(" while trying to fail enqueued calls.").toString(), new Exception());
                    break;
                }
            case 6:
                if (PlatformVersion.isAtLeastIceCreamSandwich() && (this.zzjp.getApplicationContext() instanceof Application)) {
                    BackgroundDetector.initialize((Application) this.zzjp.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zzbh(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zzjn = 300000;
                        break;
                    }
                }
                break;
            case 7:
                zzb((GoogleApi) message.obj);
                break;
            case 9:
                if (this.zzju.containsKey(message.obj)) {
                    this.zzju.get(message.obj).resume();
                    break;
                }
                break;
            case 10:
                for (zzh<?> zzh2 : this.zzjx) {
                    this.zzju.remove(zzh2).zzbm();
                }
                this.zzjx.clear();
                break;
            case 11:
                if (this.zzju.containsKey(message.obj)) {
                    this.zzju.get(message.obj).zzay();
                    break;
                }
                break;
            case 12:
                if (this.zzju.containsKey(message.obj)) {
                    this.zzju.get(message.obj).zzbs();
                    break;
                }
                break;
            case 14:
                zzae zzae = (zzae) message.obj;
                zzh<?> zzm = zzae.zzm();
                if (!this.zzju.containsKey(zzm)) {
                    zzae.zzao().setResult(Boolean.FALSE);
                    break;
                } else {
                    zzae.zzao().setResult(Boolean.valueOf(zza.zza((zza) this.zzju.get(zzm), false)));
                    break;
                }
            case 15:
                zzb zzb2 = (zzb) message.obj;
                if (this.zzju.containsKey(zzb2.zzkn)) {
                    zza.zza(this.zzju.get(zzb2.zzkn), zzb2);
                    break;
                }
                break;
            case 16:
                zzb zzb3 = (zzb) message.obj;
                if (this.zzju.containsKey(zzb3.zzkn)) {
                    zza.zzb(this.zzju.get(zzb3.zzkn), zzb3);
                    break;
                }
                break;
            default:
                new StringBuilder(31).append("Unknown message id: ").append(message.what);
                AppMethodBeat.o(11123);
                return false;
        }
        AppMethodBeat.o(11123);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void maybeSignOut() {
        AppMethodBeat.i(11117);
        this.zzjt.incrementAndGet();
        this.handler.sendMessage(this.handler.obtainMessage(10));
        AppMethodBeat.o(11117);
    }

    /* access modifiers changed from: package-private */
    public final PendingIntent zza(zzh<?> zzh, int i2) {
        AppMethodBeat.i(11124);
        zza<?> zza2 = this.zzju.get(zzh);
        if (zza2 == null) {
            AppMethodBeat.o(11124);
            return null;
        }
        SignInClient zzbt = zza2.zzbt();
        if (zzbt == null) {
            AppMethodBeat.o(11124);
            return null;
        }
        PendingIntent activity = PendingIntent.getActivity(this.zzjp, i2, zzbt.getSignInIntent(), 134217728);
        AppMethodBeat.o(11124);
        return activity;
    }

    public final <O extends Api.ApiOptions> Task<Boolean> zza(GoogleApi<O> googleApi, ListenerHolder.ListenerKey<?> listenerKey) {
        AppMethodBeat.i(11122);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.handler.sendMessage(this.handler.obtainMessage(13, new zzbu(new zzg(listenerKey, taskCompletionSource), this.zzjt.get(), googleApi)));
        Task<Boolean> task = taskCompletionSource.getTask();
        AppMethodBeat.o(11122);
        return task;
    }

    public final <O extends Api.ApiOptions> Task<Void> zza(GoogleApi<O> googleApi, RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod) {
        AppMethodBeat.i(11121);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.handler.sendMessage(this.handler.obtainMessage(8, new zzbu(new zze(new zzbv(registerListenerMethod, unregisterListenerMethod), taskCompletionSource), this.zzjt.get(), googleApi)));
        Task<Void> task = taskCompletionSource.getTask();
        AppMethodBeat.o(11121);
        return task;
    }

    public final Task<Map<zzh<?>, String>> zza(Iterable<? extends GoogleApi<?>> iterable) {
        AppMethodBeat.i(11115);
        zzj zzj = new zzj(iterable);
        this.handler.sendMessage(this.handler.obtainMessage(2, zzj));
        Task<Map<zzh<?>, String>> task = zzj.getTask();
        AppMethodBeat.o(11115);
        return task;
    }

    public final void zza(ConnectionResult connectionResult, int i2) {
        AppMethodBeat.i(11126);
        if (!zzc(connectionResult, i2)) {
            this.handler.sendMessage(this.handler.obtainMessage(5, i2, 0, connectionResult));
        }
        AppMethodBeat.o(11126);
    }

    public final void zza(GoogleApi<?> googleApi) {
        AppMethodBeat.i(11111);
        this.handler.sendMessage(this.handler.obtainMessage(7, googleApi));
        AppMethodBeat.o(11111);
    }

    public final <O extends Api.ApiOptions> void zza(GoogleApi<O> googleApi, int i2, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> apiMethodImpl) {
        AppMethodBeat.i(11119);
        this.handler.sendMessage(this.handler.obtainMessage(4, new zzbu(new zzd(i2, apiMethodImpl), this.zzjt.get(), googleApi)));
        AppMethodBeat.o(11119);
    }

    public final <O extends Api.ApiOptions, ResultT> void zza(GoogleApi<O> googleApi, int i2, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        AppMethodBeat.i(11120);
        this.handler.sendMessage(this.handler.obtainMessage(4, new zzbu(new zzf(i2, taskApiCall, taskCompletionSource, statusExceptionMapper), this.zzjt.get(), googleApi)));
        AppMethodBeat.o(11120);
    }

    public final void zza(zzad zzad) {
        AppMethodBeat.i(11113);
        synchronized (lock) {
            try {
                if (this.zzjv != zzad) {
                    this.zzjv = zzad;
                    this.zzjw.clear();
                }
                this.zzjw.addAll(zzad.zzam());
            } finally {
                AppMethodBeat.o(11113);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzad zzad) {
        AppMethodBeat.i(11114);
        synchronized (lock) {
            try {
                if (this.zzjv == zzad) {
                    this.zzjv = null;
                    this.zzjw.clear();
                }
            } finally {
                AppMethodBeat.o(11114);
            }
        }
    }

    public final int zzbg() {
        AppMethodBeat.i(11110);
        int andIncrement = this.zzjs.getAndIncrement();
        AppMethodBeat.o(11110);
        return andIncrement;
    }

    public final Task<Boolean> zzc(GoogleApi<?> googleApi) {
        AppMethodBeat.i(11118);
        zzae zzae = new zzae(googleApi.zzm());
        this.handler.sendMessage(this.handler.obtainMessage(14, zzae));
        Task<Boolean> task = zzae.zzao().getTask();
        AppMethodBeat.o(11118);
        return task;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(ConnectionResult connectionResult, int i2) {
        AppMethodBeat.i(11125);
        boolean showWrappedErrorNotification = this.zzjq.showWrappedErrorNotification(this.zzjp, connectionResult, i2);
        AppMethodBeat.o(11125);
        return showWrappedErrorNotification;
    }

    public final void zzr() {
        AppMethodBeat.i(11116);
        this.handler.sendMessage(this.handler.obtainMessage(3));
        AppMethodBeat.o(11116);
    }
}
