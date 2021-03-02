package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi;

public final class zzch implements DataApi.DeleteDataItemsResult {
    private final int zzdh;
    private final Status zzp;

    public zzch(Status status, int i2) {
        this.zzp = status;
        this.zzdh = i2;
    }

    @Override // com.google.android.gms.wearable.DataApi.DeleteDataItemsResult
    public final int getNumDeleted() {
        return this.zzdh;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzp;
    }
}
