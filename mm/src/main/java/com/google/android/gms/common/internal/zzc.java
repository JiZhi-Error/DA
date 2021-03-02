package com.google.android.gms.common.internal;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzc extends DialogRedirect {
    private final /* synthetic */ Fragment val$fragment;
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ Intent zzsh;

    zzc(Intent intent, Fragment fragment, int i2) {
        this.zzsh = intent;
        this.val$fragment = fragment;
        this.val$requestCode = i2;
    }

    @Override // com.google.android.gms.common.internal.DialogRedirect
    public final void redirect() {
        AppMethodBeat.i(11894);
        if (this.zzsh != null) {
            this.val$fragment.startActivityForResult(this.zzsh, this.val$requestCode);
        }
        AppMethodBeat.o(11894);
    }
}
