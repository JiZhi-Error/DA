package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@VisibleForTesting
final class s extends BroadcastReceiver {
    @Nullable
    r bLZ;

    public s(r rVar) {
        this.bLZ = rVar;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(4208);
        if (this.bLZ == null) {
            AppMethodBeat.o(4208);
        } else if (!this.bLZ.zzaj()) {
            AppMethodBeat.o(4208);
        } else {
            FirebaseInstanceId.yg();
            FirebaseInstanceId.b(this.bLZ, 0);
            this.bLZ.getContext().unregisterReceiver(this);
            this.bLZ = null;
            AppMethodBeat.o(4208);
        }
    }
}
