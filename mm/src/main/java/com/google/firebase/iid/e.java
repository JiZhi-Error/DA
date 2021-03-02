package com.google.firebase.iid;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class e extends c<Bundle> {
    e(int i2, Bundle bundle) {
        super(i2, 1, bundle);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.c
    public final void zzb(Bundle bundle) {
        AppMethodBeat.i(4151);
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        p(bundle2);
        AppMethodBeat.o(4151);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.c
    public final boolean zzw() {
        return false;
    }
}
