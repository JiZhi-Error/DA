package com.google.firebase.iid;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends c<Void> {
    public b(int i2, Bundle bundle) {
        super(i2, 2, bundle);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.c
    public final void zzb(Bundle bundle) {
        AppMethodBeat.i(4150);
        if (bundle.getBoolean("ack", false)) {
            p(null);
            AppMethodBeat.o(4150);
            return;
        }
        a(new d(4, "Invalid response to one way request"));
        AppMethodBeat.o(4150);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.c
    public final boolean zzw() {
        return true;
    }
}
