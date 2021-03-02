package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzb extends DialogRedirect {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ Intent zzsh;

    zzb(Intent intent, Activity activity, int i2) {
        this.zzsh = intent;
        this.val$activity = activity;
        this.val$requestCode = i2;
    }

    @Override // com.google.android.gms.common.internal.DialogRedirect
    public final void redirect() {
        AppMethodBeat.i(11893);
        if (this.zzsh != null) {
            this.val$activity.startActivityForResult(this.zzsh, this.val$requestCode);
        }
        AppMethodBeat.o(11893);
    }
}
