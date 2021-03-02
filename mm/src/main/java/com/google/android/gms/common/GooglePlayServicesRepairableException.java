package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int zzbq;

    public GooglePlayServicesRepairableException(int i2, String str, Intent intent) {
        super(str, intent);
        this.zzbq = i2;
    }

    public int getConnectionStatusCode() {
        return this.zzbq;
    }
}
