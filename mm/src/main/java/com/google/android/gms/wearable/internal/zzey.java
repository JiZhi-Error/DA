package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;

public final class zzey implements MessageApi.SendMessageResult {
    private final int zzeh;
    private final Status zzp;

    public zzey(Status status, int i2) {
        this.zzp = status;
        this.zzeh = i2;
    }

    @Override // com.google.android.gms.wearable.MessageApi.SendMessageResult
    public final int getRequestId() {
        return this.zzeh;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzp;
    }
}
