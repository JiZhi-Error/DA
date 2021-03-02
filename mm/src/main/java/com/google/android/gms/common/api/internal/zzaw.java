package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzaw implements GmsClientEventManager.GmsClientEventState {
    private final /* synthetic */ zzav zzit;

    zzaw(zzav zzav) {
        this.zzit = zzav;
    }

    @Override // com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState
    public final Bundle getConnectionHint() {
        return null;
    }

    @Override // com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState
    public final boolean isConnected() {
        AppMethodBeat.i(11301);
        boolean isConnected = this.zzit.isConnected();
        AppMethodBeat.o(11301);
        return isConnected;
    }
}
