package com.google.android.gms.wearable;

import java.io.IOException;

public class ChannelIOException extends IOException {
    private final int zzg;
    private final int zzh;

    public ChannelIOException(String str, int i2, int i3) {
        super(str);
        this.zzg = i2;
        this.zzh = i3;
    }

    public int getAppSpecificErrorCode() {
        return this.zzh;
    }

    public int getCloseReason() {
        return this.zzg;
    }
}
