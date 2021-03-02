package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.e.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzad extends zzk {
    private GoogleApiManager zzcq;
    private final b<zzh<?>> zzhb = new b<>();

    private zzad(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        AppMethodBeat.i(11178);
        this.mLifecycleFragment.addCallback("ConnectionlessLifecycleHelper", this);
        AppMethodBeat.o(11178);
    }

    public static void zza(Activity activity, GoogleApiManager googleApiManager, zzh<?> zzh) {
        AppMethodBeat.i(11177);
        LifecycleFragment fragment = getFragment(activity);
        zzad zzad = (zzad) fragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zzad.class);
        if (zzad == null) {
            zzad = new zzad(fragment);
        }
        zzad.zzcq = googleApiManager;
        Preconditions.checkNotNull(zzh, "ApiKey cannot be null");
        zzad.zzhb.add(zzh);
        googleApiManager.zza(zzad);
        AppMethodBeat.o(11177);
    }

    private final void zzan() {
        AppMethodBeat.i(11184);
        if (!this.zzhb.isEmpty()) {
            this.zzcq.zza(this);
        }
        AppMethodBeat.o(11184);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onResume() {
        AppMethodBeat.i(11180);
        super.onResume();
        zzan();
        AppMethodBeat.o(11180);
    }

    @Override // com.google.android.gms.common.api.internal.zzk, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        AppMethodBeat.i(11179);
        super.onStart();
        zzan();
        AppMethodBeat.o(11179);
    }

    @Override // com.google.android.gms.common.api.internal.zzk, com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        AppMethodBeat.i(11181);
        super.onStop();
        this.zzcq.zzb(this);
        AppMethodBeat.o(11181);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzk
    public final void zza(ConnectionResult connectionResult, int i2) {
        AppMethodBeat.i(11182);
        this.zzcq.zza(connectionResult, i2);
        AppMethodBeat.o(11182);
    }

    /* access modifiers changed from: package-private */
    public final b<zzh<?>> zzam() {
        return this.zzhb;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzk
    public final void zzr() {
        AppMethodBeat.i(11183);
        this.zzcq.zzr();
        AppMethodBeat.o(11183);
    }
}
