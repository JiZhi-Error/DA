package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzi extends zzk {
    private final SparseArray<zza> zzed = new SparseArray<>();

    /* access modifiers changed from: package-private */
    public class zza implements GoogleApiClient.OnConnectionFailedListener {
        public final int zzee;
        public final GoogleApiClient zzef;
        public final GoogleApiClient.OnConnectionFailedListener zzeg;

        public zza(int i2, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            AppMethodBeat.i(11415);
            this.zzee = i2;
            this.zzef = googleApiClient;
            this.zzeg = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
            AppMethodBeat.o(11415);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public final void onConnectionFailed(ConnectionResult connectionResult) {
            AppMethodBeat.i(11416);
            String valueOf = String.valueOf(connectionResult);
            new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf);
            zzi.this.zzb(connectionResult, this.zzee);
            AppMethodBeat.o(11416);
        }
    }

    private zzi(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        AppMethodBeat.i(11418);
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
        AppMethodBeat.o(11418);
    }

    public static zzi zza(LifecycleActivity lifecycleActivity) {
        AppMethodBeat.i(11417);
        LifecycleFragment fragment = getFragment(lifecycleActivity);
        zzi zzi = (zzi) fragment.getCallbackOrNull("AutoManageHelper", zzi.class);
        if (zzi != null) {
            AppMethodBeat.o(11417);
            return zzi;
        }
        zzi zzi2 = new zzi(fragment);
        AppMethodBeat.o(11417);
        return zzi2;
    }

    private final zza zzd(int i2) {
        AppMethodBeat.i(11426);
        if (this.zzed.size() <= i2) {
            AppMethodBeat.o(11426);
            return null;
        }
        zza zza2 = this.zzed.get(this.zzed.keyAt(i2));
        AppMethodBeat.o(11426);
        return zza2;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.i(11423);
        for (int i2 = 0; i2 < this.zzed.size(); i2++) {
            zza zzd = zzd(i2);
            if (zzd != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(zzd.zzee);
                printWriter.println(":");
                zzd.zzef.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
        AppMethodBeat.o(11423);
    }

    @Override // com.google.android.gms.common.api.internal.zzk, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        AppMethodBeat.i(11421);
        super.onStart();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(this.zzed);
        new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(" ").append(valueOf);
        if (this.zzer.get() == null) {
            for (int i2 = 0; i2 < this.zzed.size(); i2++) {
                zza zzd = zzd(i2);
                if (zzd != null) {
                    zzd.zzef.connect();
                }
            }
        }
        AppMethodBeat.o(11421);
    }

    @Override // com.google.android.gms.common.api.internal.zzk, com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        AppMethodBeat.i(11422);
        super.onStop();
        for (int i2 = 0; i2 < this.zzed.size(); i2++) {
            zza zzd = zzd(i2);
            if (zzd != null) {
                zzd.zzef.disconnect();
            }
        }
        AppMethodBeat.o(11422);
    }

    public final void zza(int i2, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(11419);
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        Preconditions.checkState(this.zzed.indexOfKey(i2) < 0, new StringBuilder(54).append("Already managing a GoogleApiClient with id ").append(i2).toString());
        zzl zzl = (zzl) this.zzer.get();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(zzl);
        new StringBuilder(String.valueOf(valueOf).length() + 49).append("starting AutoManage for client ").append(i2).append(" ").append(z).append(" ").append(valueOf);
        this.zzed.put(i2, new zza(i2, googleApiClient, onConnectionFailedListener));
        if (this.mStarted && zzl == null) {
            String valueOf2 = String.valueOf(googleApiClient);
            new StringBuilder(String.valueOf(valueOf2).length() + 11).append("connecting ").append(valueOf2);
            googleApiClient.connect();
        }
        AppMethodBeat.o(11419);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzk
    public final void zza(ConnectionResult connectionResult, int i2) {
        AppMethodBeat.i(11424);
        if (i2 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            AppMethodBeat.o(11424);
            return;
        }
        zza zza2 = this.zzed.get(i2);
        if (zza2 != null) {
            zzc(i2);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zza2.zzeg;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        AppMethodBeat.o(11424);
    }

    public final void zzc(int i2) {
        AppMethodBeat.i(11420);
        zza zza2 = this.zzed.get(i2);
        this.zzed.remove(i2);
        if (zza2 != null) {
            zza2.zzef.unregisterConnectionFailedListener(zza2);
            zza2.zzef.disconnect();
        }
        AppMethodBeat.o(11420);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzk
    public final void zzr() {
        AppMethodBeat.i(11425);
        for (int i2 = 0; i2 < this.zzed.size(); i2++) {
            zza zzd = zzd(i2);
            if (zzd != null) {
                zzd.zzef.connect();
            }
        }
        AppMethodBeat.o(11425);
    }
}
