package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzm implements Runnable {
    private final zzl zzev;
    final /* synthetic */ zzk zzew;

    zzm(zzk zzk, zzl zzl) {
        this.zzew = zzk;
        this.zzev = zzl;
    }

    public final void run() {
        AppMethodBeat.i(11432);
        if (!this.zzew.mStarted) {
            AppMethodBeat.o(11432);
            return;
        }
        ConnectionResult connectionResult = this.zzev.getConnectionResult();
        if (connectionResult.hasResolution()) {
            this.zzew.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zza(this.zzew.getActivity(), connectionResult.getResolution(), this.zzev.zzu(), false), 1);
            AppMethodBeat.o(11432);
        } else if (this.zzew.zzdg.isUserResolvableError(connectionResult.getErrorCode())) {
            this.zzew.zzdg.showErrorDialogFragment(this.zzew.getActivity(), this.zzew.mLifecycleFragment, connectionResult.getErrorCode(), 2, this.zzew);
            AppMethodBeat.o(11432);
        } else if (connectionResult.getErrorCode() == 18) {
            this.zzew.zzdg.registerCallbackOnUpdate(this.zzew.getActivity().getApplicationContext(), new zzn(this, this.zzew.zzdg.showUpdatingDialog(this.zzew.getActivity(), this.zzew)));
            AppMethodBeat.o(11432);
        } else {
            this.zzew.zza(connectionResult, this.zzev.zzu());
            AppMethodBeat.o(11432);
        }
    }
}
