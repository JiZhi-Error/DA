package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn extends GooglePlayServicesUpdatedReceiver.Callback {
    private final /* synthetic */ Dialog zzex;
    private final /* synthetic */ zzm zzey;

    zzn(zzm zzm, Dialog dialog) {
        this.zzey = zzm;
        this.zzex = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver.Callback
    public final void zzv() {
        AppMethodBeat.i(11433);
        this.zzey.zzew.zzt();
        if (this.zzex.isShowing()) {
            this.zzex.dismiss();
        }
        AppMethodBeat.o(11433);
    }
}
