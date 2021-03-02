package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzv implements CapabilityApi.CapabilityListener {
    private final String zzbc;
    private final CapabilityApi.CapabilityListener zzbs;

    zzv(CapabilityApi.CapabilityListener capabilityListener, String str) {
        this.zzbs = capabilityListener;
        this.zzbc = str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(101457);
        if (this == obj) {
            AppMethodBeat.o(101457);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(101457);
            return false;
        } else {
            zzv zzv = (zzv) obj;
            if (!this.zzbs.equals(zzv.zzbs)) {
                AppMethodBeat.o(101457);
                return false;
            }
            boolean equals = this.zzbc.equals(zzv.zzbc);
            AppMethodBeat.o(101457);
            return equals;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(101458);
        int hashCode = (this.zzbs.hashCode() * 31) + this.zzbc.hashCode();
        AppMethodBeat.o(101458);
        return hashCode;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi.CapabilityListener
    public final void onCapabilityChanged(CapabilityInfo capabilityInfo) {
        AppMethodBeat.i(101456);
        this.zzbs.onCapabilityChanged(capabilityInfo);
        AppMethodBeat.o(101456);
    }
}
