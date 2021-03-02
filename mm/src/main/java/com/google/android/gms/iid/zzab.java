package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzab extends zzz<Bundle> {
    zzab(int i2, int i3, Bundle bundle) {
        super(i2, 1, bundle);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.iid.zzz
    public final void zzh(Bundle bundle) {
        AppMethodBeat.i(2482);
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(bundle2);
            new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length()).append("Finishing ").append(valueOf).append(" with ").append(valueOf2);
        }
        this.zzcl.setResult(bundle2);
        AppMethodBeat.o(2482);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.iid.zzz
    public final boolean zzu() {
        return false;
    }
}
