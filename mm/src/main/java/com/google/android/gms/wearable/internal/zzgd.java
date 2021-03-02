package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzgd {
    public static Status zzb(int i2) {
        AppMethodBeat.i(101344);
        Status status = new Status(i2, WearableStatusCodes.getStatusCodeString(i2));
        AppMethodBeat.o(101344);
        return status;
    }
}
