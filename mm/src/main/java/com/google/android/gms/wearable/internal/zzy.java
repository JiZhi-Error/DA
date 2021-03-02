package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;

public final class zzy implements CapabilityApi.GetCapabilityResult {
    private final CapabilityInfo zzbv;
    private final Status zzp;

    public zzy(Status status, CapabilityInfo capabilityInfo) {
        this.zzp = status;
        this.zzbv = capabilityInfo;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult
    public final CapabilityInfo getCapability() {
        return this.zzbv;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzp;
    }
}
