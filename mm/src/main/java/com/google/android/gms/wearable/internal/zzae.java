package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityClient;
import com.google.android.gms.wearable.CapabilityInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzae implements CapabilityClient.OnCapabilityChangedListener {
    private final String zzbc;
    private final CapabilityClient.OnCapabilityChangedListener zzby;

    zzae(CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, String str) {
        this.zzby = onCapabilityChangedListener;
        this.zzbc = str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(100968);
        if (this == obj) {
            AppMethodBeat.o(100968);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(100968);
            return false;
        } else {
            zzae zzae = (zzae) obj;
            if (!this.zzby.equals(zzae.zzby)) {
                AppMethodBeat.o(100968);
                return false;
            }
            boolean equals = this.zzbc.equals(zzae.zzbc);
            AppMethodBeat.o(100968);
            return equals;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(100969);
        int hashCode = (this.zzby.hashCode() * 31) + this.zzbc.hashCode();
        AppMethodBeat.o(100969);
        return hashCode;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi.CapabilityListener, com.google.android.gms.wearable.CapabilityClient.OnCapabilityChangedListener
    public final void onCapabilityChanged(CapabilityInfo capabilityInfo) {
        AppMethodBeat.i(100967);
        this.zzby.onCapabilityChanged(capabilityInfo);
        AppMethodBeat.o(100967);
    }
}
