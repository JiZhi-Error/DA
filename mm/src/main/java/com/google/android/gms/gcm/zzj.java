package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzj implements Parcelable.Creator<PendingCallback> {
    zzj() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PendingCallback createFromParcel(Parcel parcel) {
        AppMethodBeat.i(3708);
        PendingCallback pendingCallback = new PendingCallback(parcel);
        AppMethodBeat.o(3708);
        return pendingCallback;
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PendingCallback[] newArray(int i2) {
        return new PendingCallback[i2];
    }
}
