package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResolvableApiException extends ApiException {
    public ResolvableApiException(Status status) {
        super(status);
    }

    public PendingIntent getResolution() {
        AppMethodBeat.i(4468);
        PendingIntent resolution = this.mStatus.getResolution();
        AppMethodBeat.o(4468);
        return resolution;
    }

    public void startResolutionForResult(Activity activity, int i2) {
        AppMethodBeat.i(4467);
        this.mStatus.startResolutionForResult(activity, i2);
        AppMethodBeat.o(4467);
    }
}
